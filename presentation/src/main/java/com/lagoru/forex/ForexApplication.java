package com.lagoru.forex;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import lombok.Getter;

/**
 * Created by lagoru on 23.08.16.
 */
public class ForexApplication extends Application {
    @Getter
    private static ForexApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initializeLeakDetection();
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
