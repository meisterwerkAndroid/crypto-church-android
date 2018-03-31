package io.meisterwerk.coinsocean.events;

import java.util.List;

/**
 * Created by xdev on 05.02.18.
 */

public class PriceMultiFullEvent {
    private List<Coin> listNameCoin;

    public List<Coin> getListNameCoin() {
        return listNameCoin;
    }

    public void setListCoin(List<Coin> listNameCoin) {
        this.listNameCoin = listNameCoin;
    }
}
