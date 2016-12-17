package com.lagoru.forex.presenter.base;

import com.lagoru.forex.views.fragments.base.BaseFragment;

/**
 * Created by lagoru on 15.12.16.
 */

public interface FragmentPresenter<T extends BaseFragment> extends Presenter {
    void setFragment(T baseFragment);
}
