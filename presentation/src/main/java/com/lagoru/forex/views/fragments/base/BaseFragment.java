package com.lagoru.forex.views.fragments.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.lagoru.forex.presenter.Presenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lagoru on 16.08.16.
 */
public abstract class BaseFragment extends Fragment {
    public abstract String getTitle();

    protected abstract Presenter getPresenter();

    Unbinder unbinder;

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //ForexApplication.getComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        getPresenter().destroy();
        super.onDestroy();
    }
}
