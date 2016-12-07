package com.lagoru.forex.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lagoru on 25.09.16.
 */
@Singleton
public class Preferences {

    private static final String SHARED_PREF_NAME = "com.lagoru.forex.sharedpref";
    SharedPreferences sharedPreferences;

    @Inject
    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
    }

    public boolean isAllowCyclicInfoCheck() {
        return sharedPreferences.getBoolean("AllowCyclicInfoCheck", false);
    }

    public void setAllowCyclicInfoCheck(boolean value) {
        sharedPreferences.edit().putBoolean("AllowCyclicInfoCheck", value);
    }

    public int getCyclicInfoCheckPeriod() {
        return sharedPreferences.getInt("CyclicInfoCheckPeriod", 5);
    }

    public void setCyclicInfoCheckPeriod(int value) {
        sharedPreferences.edit().putInt("CyclicInfoCheckPeriod", value);
    }
}
