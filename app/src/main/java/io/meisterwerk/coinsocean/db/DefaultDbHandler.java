package io.meisterwerk.coinsocean.db;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by xdev on 02.02.18.
 */

public class DefaultDbHandler {

    protected Realm mRealmInstance;
    protected boolean isOpen;

    public interface OnLoadCompleteListener<T> {
        void onLoad(T t);
    }

    protected RealmResults<? extends RealmObject> findInDb(Realm realm, Class<? extends RealmObject> clazz) {
        return realm.where(clazz).findAll();
    }

    protected RealmResults<? extends RealmObject> findInDb(Realm realm, Class<? extends RealmObject> clazz, String key, String value) {
      return realm.where(clazz).equalTo(key, value).findAll();
    }

    protected RealmObject findInDbBy(Realm realm, Class<? extends RealmObject> clazz, String keyEqualsTo, String valueEqualsTo) {
        return realm.where(clazz).equalTo(keyEqualsTo, valueEqualsTo).findFirst();
    }

    public static <T extends RealmObject> T copyFromRealm(T t) {
        Realm realm = Realm.getDefaultInstance();
        T result = null;
        try {
            result = realm.copyFromRealm(t);
        } finally {
            realm.close();
        }
        return result;
    }

    protected void removeFromDb(Realm realm, final Class<? extends RealmObject> clazz, final String keyEqualsTo, final String valueEqualsTo) {
        RealmObject realmResults = findInDbBy(realm, clazz, keyEqualsTo, valueEqualsTo);
        realmResults.deleteFromRealm();
    }

    protected void deleteAllFromRealm(final Class<? extends RealmObject> clazz) {
        mRealmInstance.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                findInDb(realm, clazz).deleteAllFromRealm();
            }
        });
    }

    public void close() {
        checkState();
        mRealmInstance.close();
        changeState(false);
    }

    protected void checkState() {
        if (mRealmInstance.isClosed()) {
            mRealmInstance = Realm.getDefaultInstance();
        }
    }

    protected void changeState(boolean open) {
        this.isOpen = open;
    }

    protected void putData(final RealmObject realmObject) {
        checkState();
        mRealmInstance.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(realmObject);
            }
        });
    }



}
