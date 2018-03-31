package io.meisterwerk.coinsocean.db;

import java.util.List;

import io.meisterwerk.coinsocean.model.CryptoCoin;

public interface Repository {

    void closeRepo();

    List<CryptoCoin> getCoinsByName(String name);

    void addAllCoins(CryptoCoin coinListResponse);

    void addChainConverter();


}
