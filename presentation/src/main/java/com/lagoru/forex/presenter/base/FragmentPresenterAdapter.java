package com.lagoru.forex.presenter.base;

import android.support.annotation.NonNull;

import com.lagoru.forex.views.fragments.base.BaseFragment;

/**
 * Created by lagoru on 15.12.16.
 */

public class FragmentPresenterAdapter<T extends BaseFragment> implements FragmentPresenter<T> {
    @Override
    public void setFragment(@NonNull T baseFragment) {

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}
