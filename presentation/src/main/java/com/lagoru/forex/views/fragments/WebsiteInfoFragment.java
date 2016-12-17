package com.lagoru.forex.views.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lagoru.forex.R;
import com.lagoru.forex.data.model.Information;
import com.lagoru.forex.presenter.WebsiteInfoPresenter;
import com.lagoru.forex.presenter.base.Presenter;
import com.lagoru.forex.views.components.SingleWebsiteInfoView;
import com.lagoru.forex.views.fragments.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import lombok.Data;
import lombok.Setter;

/**
 * Created by lagoru on 16.08.16.
 */
public class WebsiteInfoFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.webpageName)
    TextView webpageName;

    @Inject
    WebsiteInfoPresenter websiteInfoPresenter;

    WebsiteInfosAdapter websiteInfosAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    public String getTitle() {
        return getString(R.string.website_informations);
    }

    @Override
    protected Presenter getPresenter() {
        return websiteInfoPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_website_info, container);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        linearLayoutManager = new LinearLayoutManager(getContext());
        websiteInfosAdapter = new WebsiteInfosAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(websiteInfosAdapter);
    }

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
            return new SingleInformationViewHolder(new SingleWebsiteInfoView(parent.getContext()));
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
