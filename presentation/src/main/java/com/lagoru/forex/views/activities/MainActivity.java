package com.lagoru.forex.views.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.lagoru.forex.R;
import com.lagoru.forex.domain.exception.DefaultErrorBundle;
import com.lagoru.forex.domain.interactor.DefaultSubscriber;
import com.lagoru.forex.domain.interactor.GetMainScreens;
import com.lagoru.forex.views.FragmentMapper;
import com.lagoru.forex.views.activities.base.BaseActivity;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Inject
    GetMainScreens getMainScreens;

    @Inject
    FragmentMapper fragmentMapper;

    MainTabsAdapter mainTabsAdapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainTabsAdapter = new MainTabsAdapter(this, viewPager, tabLayout);

        viewPager.setAdapter(mainTabsAdapter);
        setSupportActionBar(toolbar);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getMainScreens.execute(new GetMainScreensSubscriber());
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @RxLogSubscriber
    private final class GetMainScreensSubscriber extends DefaultSubscriber<Set<String>> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onNext(Set<String> classesNames) {
            List<Class> fragmentList = fragmentMapper.transform(classesNames);
            try {
                for (Class clazz : fragmentList) {
                    mainTabsAdapter.addTab(clazz);
                }
            } catch (Exception e) {
                showErrorMessage(new DefaultErrorBundle(e));
            }
            mainTabsAdapter.notifyDataSetChanged();
        }
    }
}
