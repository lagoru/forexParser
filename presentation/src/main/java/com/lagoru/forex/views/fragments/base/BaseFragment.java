package com.lagoru.forex.views.fragments.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.lagoru.forex.di.components.FragmentComponent;
import com.lagoru.forex.presenter.base.Presenter;

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
        FragmentComponent.Initializer.init(this);
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
        getPresenter().pause();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        getPresenter().destroy();
        super.onDestroy();
    }
}
