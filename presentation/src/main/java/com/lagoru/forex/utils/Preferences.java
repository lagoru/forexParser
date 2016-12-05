package com.lagoru.forex.utils;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by lagoru on 25.09.16.
 */
@SharedPref
public interface Preferences {
    @DefaultBoolean(false)
    boolean allowCyclicInfoCheck();

    @DefaultInt(5)
//in minutes
    int cyclicInfoCheckPeriod();

    String dataProviderMapString();
}
