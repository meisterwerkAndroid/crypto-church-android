package io.meisterwerk.coinsocean.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import io.meisterwerk.coinsocean.CoinsOcean;
import io.meisterwerk.coinsocean.R;
import io.meisterwerk.coinsocean.api.ApiInterface;
import io.meisterwerk.coinsocean.db.DataHandler;
import io.meisterwerk.coinsocean.db.Repository;
import io.meisterwerk.coinsocean.events.Coin;
import io.meisterwerk.coinsocean.events.CoinInfo;
import io.meisterwerk.coinsocean.events.CoinListEvent;
import io.meisterwerk.coinsocean.events.CoinListResponse;
import io.meisterwerk.coinsocean.events.ErrorEvent;
import io.meisterwerk.coinsocean.events.PriceMultiFullEvent;
import io.meisterwerk.coinsocean.events.PriceMultiFullResponse;
import io.meisterwerk.coinsocean.events.PriceMultiResponse;
import io.meisterwerk.coinsocean.model.CryptoCoin;
import io.meisterwerk.coinsocean.utils.Constants;
import io.meisterwerk.coinsocean.utils.HttpStatus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xdev on 04.02.18.
 */

public class ApiService extends Service {
    private ApiInterface apiInterface;
    private IBinder mBinder = new ServiceBinder();
    int step;

    public ApiService() {
    }

    public class ServiceBinder extends Binder {
        ApiService getService() {
            return ApiService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        EventBus.getDefault().register(this);
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        apiInterface = CoinsOcean.getInstance().getRetrofitApiClient().create(ApiInterface.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getCoinListEvent(CoinListEvent event) {
        getCoinList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getPriceMultiplyFullEvent(PriceMultiFullEvent event) {
        getPriceMultiplyFull(event.getListNameCoin());
    }

    private void getCoinList() {
        Call<CoinListResponse> call = apiInterface.getCoinList();
        call.enqueue(new Callback<CoinListResponse>() {
            @Override
            public void onResponse(@NonNull Call<CoinListResponse> call, Response<CoinListResponse> response) {
                if (response.body() != null && response.body().getResponse().equals(Constants.RESPONSE_SUCCESS)) {
                    EventBus.getDefault().post(response.body());
                } else if (response.code() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                    Toast.makeText(ApiService.this, getString(R.string.error_server_not_responding), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CoinListResponse> call, @NonNull Throwable t) {
                Log.e("onFailure: ", t.getMessage());
                handleError(t);
            }
        });
    }

    private void getPriceMultiplyFull(final List<Coin> listCoinList) {
        final List<String> nameCoinList = new ArrayList<>();
        for (Coin coin : listCoinList) {
            nameCoinList.add(coin.getName().trim());
        }
        step = 50;
        for (int i = 0; i < nameCoinList.size(); i += step) {
            if (i != 0 && (i / step) == (nameCoinList.size() / step))
                step = nameCoinList.size() % step;
            final StringBuilder sb = formationListParams(nameCoinList, step, i);
            new Request().execute(sb.toString());
            if (step < 50) {

            }

        }
    }

    @NonNull
    private StringBuilder formationListParams(List<String> nameCoinList, int step, int j) {
        String[] stringArray = nameCoinList.subList(j, j + step).toArray(new String[0]);
        final StringBuilder sb = new StringBuilder(" ");
        for (String name : stringArray) {
            sb.append(name).append(",");
        }
        return sb;
    }

    private void handleError(Throwable t) {
        if (t instanceof UnknownHostException || t instanceof SSLException) {
            EventBus.getDefault().post(new ErrorEvent(getString(R.string.error_connection_error)));
        } else if (t instanceof SocketTimeoutException) {
            EventBus.getDefault().post(new ErrorEvent(getString(R.string.error_server_not_responding)));
        } else {
            EventBus.getDefault().post(new ErrorEvent(getString(R.string.error_other_error)));
        }
    }

    private class Request extends AsyncTask<String, PriceMultiFullResponse, CoinInfo> {

        @Override
        protected CoinInfo doInBackground(String... strings) {
            ArrayList<String> convertToList = new ArrayList<>();
            convertToList.add("USD");
            Call<PriceMultiFullResponse> call = apiInterface.getPriceFull(strings[0], convertToList);
            try {
                PriceMultiFullResponse body = call.execute().body();
                Map<String, Map<String, CoinInfo>> listCoinPriceRaw = body.getListCoinPriceRaw();
                for (String name : listCoinPriceRaw.keySet()) {
                    Map<String, CoinInfo> stringCoinInfoMap = listCoinPriceRaw.get(name);
                    for (String coinName : stringCoinInfoMap.keySet()) {
                        CoinInfo coinInfo = stringCoinInfoMap.get(coinName);
                        CryptoCoin cryptoCoin = new CryptoCoin();
                        Repository repository = DataHandler.getInstance();
                        cryptoCoin.setName(coinInfo.getTosymbol());
                        cryptoCoin.setVolume24h(coinInfo.getVolume24Hour());
                        cryptoCoin.setSupply(coinInfo.getSupply());
                        cryptoCoin.setPrc24h(coinInfo.getChangepct24Hour());
                        cryptoCoin.setMtCap(coinInfo.getMktcap());
                        cryptoCoin.setImageCurrency("");
                        cryptoCoin.setMarket(coinInfo.getMarket());
                        cryptoCoin.setCurrencyId(coinInfo.getLastTradeId());
                        cryptoCoin.setSymbol(coinInfo.getFromsymbvol());
                        repository.addAllCoins(cryptoCoin);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(PriceMultiFullResponse... values) {
            super.onProgressUpdate(values);
            PriceMultiResponse responseEvent = new PriceMultiResponse();
            responseEvent.setFullEvents(values[0]);
            EventBus.getDefault().post(responseEvent);
        }
    }
}
