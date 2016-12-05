package com.lagoru.forex.views.fragments;

import com.lagoru.forex.R;
import com.lagoru.forex.views.fragments.base.BaseFragment;

import org.androidannotations.annotations.EFragment;

/**
 * Created by lagoru on 01.09.16.
 */
@EFragment(R.layout.fragment_information_editor)
public class InformationEditorFragment extends BaseFragment {
    @Override
    public String getTitle() {
        return getString(R.string.information_editor);
    }


}
