package com.lagoru.forex.presenter;

import android.support.annotation.NonNull;

import com.lagoru.forex.presenter.base.FragmentPresenterAdapter;
import com.lagoru.forex.views.fragments.WebsiteInfoFragment;

import javax.inject.Inject;

/**
 * Created by lagoru on 17.12.16.
 */

public class WebsiteInfoPresenter extends FragmentPresenterAdapter<WebsiteInfoFragment> {
    WebsiteInfoFragment websiteInfoFragment;

    @Inject
    public WebsiteInfoPresenter() {

    }

    @Override
    public void setFragment(@NonNull WebsiteInfoFragment websiteInfoFragment) {
        this.websiteInfoFragment = websiteInfoFragment;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    /* void downloadData() {
        try {
            InvestingComDataProvider investingComDataProvider = new InvestingComDataProvider();
            List<Information> informationList = investingComDataProvider.parseWebsite();
            websiteInfosAdapter.setInformationList(informationList);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
