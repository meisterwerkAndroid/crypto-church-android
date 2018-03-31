package io.meisterwerk.coinsocean;

import android.app.Application;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import java.util.concurrent.TimeUnit;

import io.fabric.sdk.android.Fabric;
import io.meisterwerk.coinsocean.db.DbMigration;
import io.meisterwerk.coinsocean.utils.AppPref;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinsOcean extends Application {

    private static volatile CoinsOcean mInstance;
    private Retrofit mRetrofitClient;
    private RealmConfiguration realmConfiguration;


    @Override
    public void onCreate() {
        super.onCreate();
        AppPref.init(getApplicationContext());
        Fabric.with(this, new Crashlytics());
        mInstance = this;
        Realm.init(this);
        configurateRealm("some.realm");

    }

    public static CoinsOcean getInstance() {
        CoinsOcean localInstance = mInstance;
        if (localInstance == null) {
            synchronized (CoinsOcean.class) {
                localInstance = mInstance;
                if (localInstance == null) {
                    mInstance = new CoinsOcean();
                }
            }
        }
        return localInstance;
    }

    public Retrofit getRetrofitApiClient() {
        if (mRetrofitClient == null) {

//            logger.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
//            httpBuilder.addInterceptor(logger);
            httpBuilder.connectTimeout(1, TimeUnit.MINUTES);
            httpBuilder.readTimeout(1, TimeUnit.MINUTES);
            httpBuilder.writeTimeout(1, TimeUnit.MINUTES);
            mRetrofitClient = new Retrofit.Builder().baseUrl(BuildConfig.API_URI)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpBuilder.build())
                    .build();
        }

        return mRetrofitClient;
    }

    public void configurateRealm(String uuid) {
//        UUID.randomUUID().toString();
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration.Builder()
                    .schemaVersion(1)
                    .migration(new DbMigration())
                    .name(uuid)
                    .build();
            Realm.setDefaultConfiguration(realmConfiguration);
        }
    }
}
