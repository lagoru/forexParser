package com.lagoru.forex.views.activities;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.lagoru.forex.domain.exception.DefaultErrorBundle;
import com.lagoru.forex.domain.interactor.DefaultSubscriber;
import com.lagoru.forex.domain.interactor.GetMainScreens;
import com.lagoru.forex.domain.interactor.SetMainScreens;
import com.lagoru.forex.views.FragmentMapper;
import com.lagoru.forex.views.activities.base.BaseActivity;

import java.util.Set;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by lagoru on 09.08.16.
 */
public class SplashScreen extends BaseActivity {

    @Inject
    GetMainScreens getMainScreens;

    @Inject
    Lazy<SetMainScreens> setMainScreensLazy;

    @Inject
    Lazy<FragmentMapper> fragmentMapperLazy;

    @Override
    public void onResume() {
        super.onResume();
        //check if any fragment for main screen exists
        getMainScreens.execute(new GetMainScreensSubscriber());
    }

    @RxLogSubscriber
    private final class GetMainScreensSubscriber extends DefaultSubscriber<Set<String>> {

        @Override
        public void onError(Throwable e) {
            showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onNext(Set<String> classesNames) {
            if (classesNames == null || classesNames.isEmpty()) {
                SetMainScreens setMainScreens = setMainScreensLazy.get();
                setMainScreens.setArguments(fragmentMapperLazy.get().getDefaultScreenNames());
                setMainScreens.execute(new SetMainScreensSubscriber());
            } else {
                navigator.navigateToMainMenu(SplashScreen.this);
            }
        }
    }

    @RxLogSubscriber
    private final class SetMainScreensSubscriber extends DefaultSubscriber<Set<String>> {

        @Override
        public void onCompleted() {
            navigator.navigateToMainMenu(SplashScreen.this);
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(new DefaultErrorBundle((Exception) e));
        }
    }
}
