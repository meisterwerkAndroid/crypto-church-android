package io.meisterwerk.coinsocean.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xdev on 11.02.18.
 */

public class AppPref {

    private static final String DATABASE_NAME = "updater";
    private static final String FIRST_RUN = "first_run";

    private static AppPref sInstance = null;
    private SharedPreferences mPreferences = null;

    public static AppPref getInstance() {
        return sInstance;
    }

    public AppPref() {
    }

    public static void init(Context context) {
        if (sInstance == null) {
            sInstance = new AppPref();
            sInstance.mPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
            if (sInstance.isFirstRun()) {
                sInstance.saveFirstRun(false);
            }
        }
    }

    private boolean isFirstRun() {
        return mPreferences.getBoolean(FIRST_RUN, true);
    }

    private void saveFirstRun(boolean value) {
        mPreferences.edit().putBoolean(FIRST_RUN, value).apply();
    }

}
