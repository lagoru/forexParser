package com.lagoru.forex.di.modules;

import android.content.Context;

import com.lagoru.forex.ForexApplication;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lagoru on 05.12.16.
 */

@Module
public class MainModule {
    @Provides
    @Named("applicationContext")
    public static Context getApplicationContext() {
        return ForexApplication.getInstance().getApplicationContext();
    }
}