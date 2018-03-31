package io.meisterwerk.coinsocean.db;


import java.util.List;

import io.meisterwerk.coinsocean.model.CryptoCoin;

public class DataHandler implements Repository {

    private static final String TAG = "DataHandler";
    private DataSource dataSource;
//    private List<CryptoCoin> coins;
    private static Repository sInstance;

    private DataHandler() {
        dataSource = new RealmSource();
//        coins = new ArrayList<>();
    }

    public static Repository getInstance() {
        if (sInstance == null) sInstance = new DataHandler();
        return sInstance;
    }

    @Override
    public void closeRepo() {
        sInstance = null;
        dataSource = null;
    }

    @Override
    public List<CryptoCoin> getCoinsByName(String name) {
        dataSource.getCoinsByName(name);
        return null;
    }

    @Override
    public void addAllCoins(CryptoCoin coinListResponse) {
        if (coinListResponse == null) return;
        dataSource.addAllCoins(coinListResponse);
    }

    @Override
    public void addChainConverter() {

    }
}
