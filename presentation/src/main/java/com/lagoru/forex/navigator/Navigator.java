package com.lagoru.forex.navigator;

import android.content.Context;
import android.content.Intent;

import com.lagoru.forex.views.activities.MainActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lagoru on 06.12.16.
 */
@Singleton
public class Navigator {
    @Inject
    public Navigator() {
    }

    public void navigateToMainMenu(Context context) {
        if (context != null) {
            Intent intentToLaunch = new Intent(context, MainActivity.class);
            context.startActivity(intentToLaunch);
        }
    }
}
