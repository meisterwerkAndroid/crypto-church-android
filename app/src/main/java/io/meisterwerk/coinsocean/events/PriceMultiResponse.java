package io.meisterwerk.coinsocean.events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdev on 11.02.18.
 */

public class PriceMultiResponse {
    private PriceMultiFullResponse fullEvents;
    private List<String> coinListName = new ArrayList<>();

    public List<String> getCoinListName() {
        return coinListName;
    }

    public void setCoinListName(List<String> coinListName) {
        this.coinListName = coinListName;
    }

    public PriceMultiFullResponse getFullEvents() {
        return fullEvents;
    }

    public void setFullEvents(PriceMultiFullResponse fullEvents) {
        this.fullEvents = fullEvents;
    }
}
