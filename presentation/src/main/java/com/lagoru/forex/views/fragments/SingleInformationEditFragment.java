package com.lagoru.forex.views.fragments;

import com.lagoru.forex.R;
import com.lagoru.forex.presenter.Presenter;
import com.lagoru.forex.views.fragments.base.BaseFragment;


/**
 * Created by lagoru on 22.09.16.
 */
//@EFragment(R.layout.fragment_single_information_edit)
public class SingleInformationEditFragment extends BaseFragment {
    @Override
    public String getTitle() {
        return getString(R.string.single_information_page);
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }
}
