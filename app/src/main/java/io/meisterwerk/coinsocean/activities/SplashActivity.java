package io.meisterwerk.coinsocean.activities;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.meisterwerk.coinsocean.R;
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
import io.meisterwerk.coinsocean.service.ApiService;

public class SplashActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private boolean mServiceBound = false;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mServiceBound = true;
            EventBus.getDefault().post(new CoinListEvent());
            showDialog("please wait", "established secure connection");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mServiceBound = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initProgress();

        Intent intent = new Intent(this, ApiService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onDestroy() {
        if (mServiceBound) {
            unbindService(mConnection);
            mServiceBound = false;
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

    private void initProgress() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setTitle("please wait");
        mProgressDialog.setMessage("established secure connection");
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getCoinListResponse(CoinListResponse response) {
        Map<String, Coin> data = response.getData();
        List<Coin> listCoins = new ArrayList<>();
        for (String s : data.keySet()) {
            listCoins.add(data.get(s));
        }
        if (listCoins.size() > 0) {
            startMainScreen();
//            PriceMultiFullEvent priceEvent = new PriceMultiFullEvent();
//            priceEvent.setListCoin(listCoins);
//            EventBus.getDefault().post(priceEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getPriceMultiFullResponse(PriceMultiResponse response) {
        PriceMultiFullResponse fullEvents = response.getFullEvents();
        Map<String, Map<String, CoinInfo>> listCoinPriceRaw = fullEvents.getListCoinPriceRaw();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorEvent(ErrorEvent errorEvent) {
    }

    private void showDialog(@NonNull String title, @NonNull String message) {
        if (mProgressDialog != null) {
            mProgressDialog.setTitle(title);
            mProgressDialog.setMessage(message);

            if (!mProgressDialog.isShowing())
                mProgressDialog.show();
        } else {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
        }
    }

    private void hideDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    private void startMainScreen() {
        hideDialog();
        Intent startMain = new Intent(this, MainActivity.class);
        startActivity(startMain);
        finish();
    }

}
