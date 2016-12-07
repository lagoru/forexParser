package com.lagoru.forex.views.activities;

import com.lagoru.forex.views.activities.base.BaseActivity;

/**
 * Created by lagoru on 09.08.16.
 */
public class SplashScreen extends BaseActivity {

    @Override
    public void onResume() {
        super.onResume();
        navigator.navigateToMainMenu(this);
    }
}
