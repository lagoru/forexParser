package com.lagoru.forex.data.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lagoru on 13.12.16.
 */

public class SharedPreferenceManager {

    SharedPreferences sharedPreferences;

    public SharedPreferenceManager(Context context, String sharedPrefName) {
        sharedPreferences = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
    }

    public Set<String> getStringSet(String name) {
        return sharedPreferences.getStringSet(name, new HashSet<String>());
    }

    public void setStringSet(String name, Set<String> set) {
        sharedPreferences.edit().putStringSet(name, set).apply();
    }
}
