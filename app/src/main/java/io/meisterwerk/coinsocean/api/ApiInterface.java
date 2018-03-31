package io.meisterwerk.coinsocean.api;

import java.util.List;

import io.meisterwerk.coinsocean.events.CoinListResponse;
import io.meisterwerk.coinsocean.events.PriceMultiFullResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xdev on 02.02.18.
 */

public interface ApiInterface {

    @GET("all/coinlist")
    Call<CoinListResponse> getCoinList();

    @GET("pricemultifull")
    Call<PriceMultiFullResponse> getPriceFull(@Query("fsyms") String fromExch, @Query("tsyms") List<String> toExch);

}
