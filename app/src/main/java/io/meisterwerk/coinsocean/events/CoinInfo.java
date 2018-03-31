package io.meisterwerk.coinsocean.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by xdev on 04.02.18.
 */

public class CoinInfo {

    @SerializedName("TYPE")
    @Expose
    private String type;
    @SerializedName("MARKET")
    @Expose
    private String market;
    @SerializedName("FROMSYMBOL")
    @Expose
    private String fromsymbvol;
    @SerializedName("TOSYMBOL")
    @Expose
    private String tosymbol;
    @SerializedName("FLAGS")
    @Expose
    private String flags;
    @SerializedName("PRICE")
    @Expose
    private String price;
    @SerializedName("LASTUPDATE")
    @Expose
    private String lastUpdate;
    @SerializedName("LASTVOLUME")
    @Expose
    private String lastVolume;
    @SerializedName("LASTVOLUMETO")
    @Expose
    private String lastVolumeTo;
    @SerializedName("LASTTRADEID")
    @Expose
    private String lastTradeId;
    @SerializedName("VOLUMEDAY")
    @Expose
    private String volumeDay;
    @SerializedName("VOLUMEDAYTO")
    @Expose
    private String volumeDayTo;
    @SerializedName("VOLUME24HOUR")
    @Expose
    private String volume24Hour;
    @SerializedName("VOLUME24HOURTO")
    @Expose
    private String volume24HourTo;
    @SerializedName("OPENDAY")
    @Expose
    private String openDay;
    @SerializedName("HIGHDAY")
    @Expose
    private String highDay;
    @SerializedName("LOWDAY")
    @Expose
    private String lowDay;
    @SerializedName("OPEN24HOUR")
    @Expose
    private String open24Hour;
    @SerializedName("HIGH24HOUR")
    @Expose
    private String high24Hour;
    @SerializedName("LOW24HOUR")
    @Expose
    private String low24Hour;
    @SerializedName("LASTMARKET")
    @Expose
    private String lastMarket;
    @SerializedName("CHANGE24HOUR")
    @Expose
    private String change24Hour;
    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    private String changepct24Hour;
    @SerializedName("CHANGEDAY")
    @Expose
    private String changeDay;
    @SerializedName("CHANGEPCTDAY")
    @Expose
    private String changePctDay;
    @SerializedName("SUPPLY")
    @Expose
    private String supply;
    @SerializedName("MKTCAP")
    @Expose
    private String mktcap;
    @SerializedName("TOTALVOLUME24H")
    @Expose
    private String totalVolume24H;
    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    private String totalVolume24Hto;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getFromsymbvol() {
        return fromsymbvol;
    }

    public String getChangepct24Hour() {
        return changepct24Hour;
    }

    public String getMktcap() {
        return mktcap;
    }

    public void setMktcap(String mktcap) {
        this.mktcap = mktcap;
    }

    public void setChangepct24Hour(String changepct24Hour) {
        this.changepct24Hour = changepct24Hour;
    }

    public void setFromsymbvol(String fromsymbvol) {
        this.fromsymbvol = fromsymbvol;
    }

    public String getTosymbol() {
        return tosymbol;
    }

    public void setTosymbol(String tosymbol) {
        this.tosymbol = tosymbol;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(String lastVolume) {
        this.lastVolume = lastVolume;
    }

    public String getLastVolumeTo() {
        return lastVolumeTo;
    }

    public void setLastVolumeTo(String lastVolumeTo) {
        this.lastVolumeTo = lastVolumeTo;
    }

    public String getLastTradeId() {
        return lastTradeId;
    }

    public void setLastTradeId(String lastTradeId) {
        this.lastTradeId = lastTradeId;
    }

    public String getVolumeDay() {
        return volumeDay;
    }

    public void setVolumeDay(String volumeDay) {
        this.volumeDay = volumeDay;
    }

    public String getVolumeDayTo() {
        return volumeDayTo;
    }

    public void setVolumeDayTo(String volumeDayTo) {
        this.volumeDayTo = volumeDayTo;
    }

    public String getVolume24Hour() {
        return volume24Hour;
    }

    public void setVolume24Hour(String volume24Hour) {
        this.volume24Hour = volume24Hour;
    }

    public String getVolume24HourTo() {
        return volume24HourTo;
    }

    public void setVolume24HourTo(String volume24HourTo) {
        this.volume24HourTo = volume24HourTo;
    }

    public String getOpenDay() {
        return openDay;
    }

    public void setOpenDay(String openDay) {
        this.openDay = openDay;
    }

    public String getHighDay() {
        return highDay;
    }

    public void setHighDay(String highDay) {
        this.highDay = highDay;
    }

    public String getLowDay() {
        return lowDay;
    }

    public void setLowDay(String lowDay) {
        this.lowDay = lowDay;
    }

    public String getOpen24Hour() {
        return open24Hour;
    }

    public void setOpen24Hour(String open24Hour) {
        this.open24Hour = open24Hour;
    }

    public String getHigh24Hour() {
        return high24Hour;
    }

    public void setHigh24Hour(String high24Hour) {
        this.high24Hour = high24Hour;
    }

    public String getLow24Hour() {
        return low24Hour;
    }

    public void setLow24Hour(String low24Hour) {
        this.low24Hour = low24Hour;
    }

    public String getLastMarket() {
        return lastMarket;
    }

    public void setLastMarket(String lastMarket) {
        this.lastMarket = lastMarket;
    }

    public String getChange24Hour() {
        return change24Hour;
    }

    public void setChange24Hour(String change24Hour) {
        this.change24Hour = change24Hour;
    }

    public String getChangeDay() {
        return changeDay;
    }

    public void setChangeDay(String changeDay) {
        this.changeDay = changeDay;
    }

    public String getChangePctDay() {
        return changePctDay;
    }

    public void setChangePctDay(String changePctDay) {
        this.changePctDay = changePctDay;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getTotalVolume24H() {
        return totalVolume24H;
    }

    public void setTotalVolume24H(String totalVolume24H) {
        this.totalVolume24H = totalVolume24H;
    }

    public String getTotalVolume24Hto() {
        return totalVolume24Hto;
    }

    public void setTotalVolume24Hto(String totalVolume24Hto) {
        this.totalVolume24Hto = totalVolume24Hto;
    }
}
