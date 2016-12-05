package com.lagoru.forex;

import android.app.Application;

import com.lagoru.forex.views.activities.base.BaseActivity;
import com.lagoru.forex.views.fragments.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import lombok.Getter;

/**
 * Created by lagoru on 23.08.16.
 */
public class ForexApplication extends Application {

    @Getter
    private static ForexApplicationComponent component;

    @Getter
    private static ForexApplication instance;

    public interface ForexBeanComponent{

    }

    @Singleton
    @Component(modules = BusModule.class)
    @Module
    public interface ForexApplicationComponent {
        void inject(BaseActivity baseActivity);

        void inject(BaseFragment baseFragment);

        void inject(ForexBeanComponent forexBeanComponent);

        final class Initializer {

            private Initializer() {

            }

            public static ForexApplicationComponent init(ForexApplication app) {
                return DaggerForexApplication_ForexApplicationComponent.builder()
                        .build();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = ForexApplicationComponent.Initializer.init(this);
        instance = this;
    }
}
