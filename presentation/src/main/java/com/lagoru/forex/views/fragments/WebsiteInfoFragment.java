package com.lagoru.forex.views.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lagoru.forex.R;
import com.lagoru.forex.data.model.Information;
import com.lagoru.forex.presenter.base.Presenter;
import com.lagoru.forex.views.fragments.base.BaseFragment;

import java.util.List;

import lombok.Data;
import lombok.Setter;

/**
 * Created by lagoru on 16.08.16.
 */
//@EFragment(R.layout.fragment_website_info)
public class WebsiteInfoFragment extends BaseFragment {

    //@ViewById
    RecyclerView recyclerView;

    //@ViewById
    TextView webpageName;

    WebsiteInfosAdapter websiteInfosAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    public String getTitle() {
        return getString(R.string.website_informations);
    }

    @Override
    protected Presenter getPresenter() {
        return null;
    }

    void init() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        websiteInfosAdapter = new WebsiteInfosAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(websiteInfosAdapter);
        //downloadData();
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

    @Data
    class SingleInformationViewHolder extends RecyclerView.ViewHolder {
        SingleWebsiteInfoView singleWebsiteInfoView;

        public SingleInformationViewHolder(SingleWebsiteInfoView itemView) {
            super(itemView);
            singleWebsiteInfoView = itemView;
        }
    }

    class WebsiteInfosAdapter extends RecyclerView.Adapter<SingleInformationViewHolder> {
        @Setter
        List<Information> informationList;

        @Override
        public SingleInformationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;//new SingleInformationViewHolder(SingleWebsiteInfoView_.build(parent.getContext()));
        }

        @Override
        public void onBindViewHolder(SingleInformationViewHolder holder, int position) {
            holder.getSingleWebsiteInfoView().setupView(informationList.get(position));
        }

        @Override
        public int getItemCount() {
            return informationList != null ? informationList.size() : 0;
        }
    }
}
