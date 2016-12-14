package com.lagoru.forex.di.modules;

import com.lagoru.forex.data.data.SharedPreferenceManager;
import com.lagoru.forex.data.executor.PostExecutionThread;
import com.lagoru.forex.data.executor.ThreadExecutor;
import com.lagoru.forex.domain.interactor.GetMainScreens;
import com.lagoru.forex.domain.interactor.SetMainScreens;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

/**
 * Created by lagoru on 07.12.16.
 */
@Module
public class UseCasesModule {

    //-- use cases dependecies
    @Provides
    @Reusable
    public static GetMainScreens provideGetMainScreenUseCase(SharedPreferenceManager sharedPreferenceManager, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetMainScreens(sharedPreferenceManager, threadExecutor, postExecutionThread);
    }

    @Provides
    @Reusable
    public static SetMainScreens provideSetMainScreensUseCase(SharedPreferenceManager sharedPreferenceManager, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new SetMainScreens(sharedPreferenceManager, threadExecutor, postExecutionThread);
    }
}
