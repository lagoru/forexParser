package com.lagoru.forex;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lagoru on 25.08.16.
 */
@Module
public class BusModule {
    @Provides
    @Singleton
    @Named("mainBus")
    static EventBus provideMainThreadBus() {
        return EventBus.getDefault();
    }
}
