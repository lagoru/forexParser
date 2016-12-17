package com.lagoru.forex.di.components;

import com.lagoru.forex.di.modules.MainModule;
import com.lagoru.forex.di.modules.UseCasesModule;
import com.lagoru.forex.views.fragments.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lagoru on 17.12.16.
 */
@Singleton
@Component(modules = {MainModule.class, UseCasesModule.class})
public interface FragmentComponent {
    void inject(BaseFragment baseFragment);

    final class Initializer {
        private Initializer() {

        }

        public static FragmentComponent init(BaseFragment baseFragment) {
            return DaggerFragmentComponent.builder()
                    .build();
        }
    }
}
