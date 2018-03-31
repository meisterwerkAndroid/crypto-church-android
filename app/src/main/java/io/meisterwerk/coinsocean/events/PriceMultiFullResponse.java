package io.meisterwerk.coinsocean.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;


public class PriceMultiFullResponse {
    @SerializedName("RAW")
    @Expose
    private Map<String, Map<String, CoinInfo>> listCoinPriceRaw;

    @SerializedName("DISPLAY")
    @Expose
    private Displayed displayed;

    public Map<String, Map<String, CoinInfo>> getListCoinPriceRaw() {
        return listCoinPriceRaw;
    }

    public void setListCoinPriceRaw(Map<String, Map<String, CoinInfo>> listCoinPriceRaw) {
        this.listCoinPriceRaw = listCoinPriceRaw;
    }

    public Displayed getDisplayed() {
        return displayed;
    }

    public void setDisplayed(Displayed displayed) {
        this.displayed = displayed;
    }
}
