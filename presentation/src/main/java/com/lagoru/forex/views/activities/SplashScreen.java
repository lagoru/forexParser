package com.lagoru.forex.views.activities;

import com.lagoru.forex.views.activities.base.BaseActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by lagoru on 09.08.16.
 */
@EActivity
public class SplashScreen extends BaseActivity {

    @AfterInject
    void init() {
        MainActivity_.intent(this).start();
    }
}
