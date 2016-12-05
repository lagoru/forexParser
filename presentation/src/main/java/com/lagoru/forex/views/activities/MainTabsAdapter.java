package com.lagoru.forex.views.activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.lagoru.forex.views.fragments.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by lagoru on 10.08.16.
 */
public class MainTabsAdapter extends FragmentStatePagerAdapter {

    private final Context context;
    private final ActionBar actionBar;
    private final TabLayout tabLayout;

    private List<Class> tabs = new ArrayList<>();

    public MainTabsAdapter(AppCompatActivity activity, ViewPager pager, TabLayout tabLayout) {
        super(activity.getSupportFragmentManager());
        context = activity;
        actionBar = activity.getSupportActionBar();
        this.tabLayout = tabLayout;
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));
    }

    public void addTab(Class clss) throws Exception {
        if(clss.isAssignableFrom(BaseFragment.class)) {
            tabs.add(clss);
        }else{
            throw new Exception("Bad type of class: should inherit from BaseFragment");
        }
        //tabLayout.addTab(tabLayout.newTab()/*.setIcon(resource)*/.setText(title));
        //notifyDataSetChanged();
    }

    public void replaceCurrentTab(Class<BaseFragment> clss) {
        //TODO
    }

    WeakHashMap<Integer, BaseFragment> instantiatedItems = new WeakHashMap<>();

    @Override
    public BaseFragment getItem(int position) {
        BaseFragment fragment = (BaseFragment) Fragment.instantiate(context, tabs.get(position).getName(), null);
        instantiatedItems.put(position, fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return instantiatedItems.containsKey(position) ? instantiatedItems.get(position).getTitle() : ""; //poki co
    }
}
