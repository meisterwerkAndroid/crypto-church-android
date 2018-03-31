package io.meisterwerk.coinsocean.events;

import java.util.Map;

/**
 * Created by xdev on 04.02.18.
 */
public class CoinData {

    private Map<String, Coin> data;
    public Map<String, Coin> getData() {
        return data;
    }

    public void setData(Map<String, Coin> data) {
        this.data = data;
    }
}
