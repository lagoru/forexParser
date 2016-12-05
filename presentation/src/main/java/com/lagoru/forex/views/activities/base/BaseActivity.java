package com.lagoru.forex.views.activities.base;

import android.app.Activity;
import android.os.Bundle;

import com.lagoru.forex.ForexApplication;

/**
 * Created by lagoru on 09.08.16.
 */
public class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ForexApplication.getComponent().inject(this);
    }
}
