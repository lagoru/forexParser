package com.lagoru.forex.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lagoru.forex.R;
import com.lagoru.forex.presenter.Presenter;
import com.lagoru.forex.views.fragments.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by lagoru on 01.09.16.
 */
public class InformationEditorFragment extends BaseFragment {
    @Override
    public String getTitle() {
        return getString(R.string.information_editor);
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_information_editor, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.userDetailsPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadUserDetails();
        }
    }
}
