package com.lagoru.forex.views.fragments.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lagoru.forex.ForexApplication;

import org.androidannotations.annotations.EFragment;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by lagoru on 16.08.16.
 */
@EFragment
public abstract class BaseFragment extends Fragment {
    public abstract String getTitle();

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ForexApplication.getComponent().inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
