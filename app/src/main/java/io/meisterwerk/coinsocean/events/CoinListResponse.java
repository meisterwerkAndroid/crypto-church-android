package io.meisterwerk.coinsocean.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by xdev on 04.02.18.
 */

public class CoinListResponse {
    @SerializedName("Response")
    @Expose
    private String response;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("BaseImageUrl")
    @Expose
    private String baseImageUrl;
    @SerializedName("BaseLinkUrl")
    @Expose
    private String baseLinkUrl;
    @SerializedName("DefaultWatchlist")
    @Expose
    private DefaultWatchlist defaultWatchlist;
    @SerializedName("Data")
    @Expose
    private Map<String, Coin> data;

    @SerializedName("Type")
    @Expose
    private Integer type;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBaseImageUrl() {
        return baseImageUrl;
    }

    public void setBaseImageUrl(String baseImageUrl) {
        this.baseImageUrl = baseImageUrl;
    }

    public String getBaseLinkUrl() {
        return baseLinkUrl;
    }

    public void setBaseLinkUrl(String baseLinkUrl) {
        this.baseLinkUrl = baseLinkUrl;
    }

    public DefaultWatchlist getDefaultWatchlist() {
        return defaultWatchlist;
    }

    public void setDefaultWatchlist(DefaultWatchlist defaultWatchlist) {
        this.defaultWatchlist = defaultWatchlist;
    }

    public Map<String, Coin> getData() {
        return data;
    }

    public void setData(Map<String, Coin> data) {
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
