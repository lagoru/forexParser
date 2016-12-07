package com.lagoru.forex.views.activities.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lagoru.forex.ForexApplication;
import com.lagoru.forex.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by lagoru on 09.08.16.
 */
public class BaseActivity extends AppCompatActivity {

    @Inject
    protected Navigator navigator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ForexApplication.getComponent().inject(this);
    }
}
