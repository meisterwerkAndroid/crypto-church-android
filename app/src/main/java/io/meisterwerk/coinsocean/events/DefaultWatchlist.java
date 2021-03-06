package io.meisterwerk.coinsocean.events;

/**
 * Created by xdev on 04.02.18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultWatchlist {

    @SerializedName("CoinIs")
    @Expose
    private String coinIs;
    @SerializedName("Sponsored")
    @Expose
    private String sponsored;

    public String getCoinIs() {
        return coinIs;
    }

    public void setCoinIs(String coinIs) {
        this.coinIs = coinIs;
    }

    public String getSponsored() {
        return sponsored;
    }

    public void setSponsored(String sponsored) {
        this.sponsored = sponsored;
    }
}
