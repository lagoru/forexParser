package com.lagoru.forex.di.components;

import com.lagoru.forex.di.modules.MainModule;
import com.lagoru.forex.di.modules.UseCasesModule;
import com.lagoru.forex.views.activities.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lagoru on 07.12.16.
 */
@Singleton
@Component(modules = {MainModule.class, UseCasesModule.class})
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);

    final class Initializer {
        private Initializer() {

        }

        public static ActivityComponent init(BaseActivity baseActivity) {
            return DaggerActivityComponent.builder()
                    .build();
        }
    }
}
