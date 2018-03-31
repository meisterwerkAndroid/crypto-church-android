package io.meisterwerk.coinsocean.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CryptoCoin extends RealmObject{

    @PrimaryKey
    private String currencyId;
    private String imageCurrency;
    private String market;
    private String mtCap;
    private String name;
    private String open24H;
    private String prc24h;
    private String price;
    private String sortOrder;
    private String supply;
    private String symbol;
    private String volume24h;

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getImageCurrency() {
        return imageCurrency;
    }

    public void setImageCurrency(String imageCurrency) {
        this.imageCurrency = imageCurrency;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMtCap() {
        return mtCap;
    }

    public void setMtCap(String mtCap) {
        this.mtCap = mtCap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen24H() {
        return open24H;
    }

    public void setOpen24H(String open24H) {
        this.open24H = open24H;
    }

    public String getPrc24h() {
        return prc24h;
    }

    public void setPrc24h(String prc24h) {
        this.prc24h = prc24h;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(String volume24h) {
        this.volume24h = volume24h;
    }
}
