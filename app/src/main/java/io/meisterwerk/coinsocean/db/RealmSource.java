package io.meisterwerk.coinsocean.db;

import android.support.annotation.NonNull;

import java.util.List;

import io.meisterwerk.coinsocean.model.CryptoCoin;
import io.realm.Realm;

public class RealmSource implements DataSource{
    @Override
    public List<CryptoCoin> getCoinsByName(String name) {
        return null;
    }

    @Override
    public void addAllCoins(final CryptoCoin coinListResponse) {
        try (Realm db = Realm.getDefaultInstance()){
            db.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(@NonNull Realm realm) {
                    realm.insertOrUpdate(coinListResponse);
                }
            });
        }
    }

    @Override
    public void addChainConverter() {

    }
}
