package com.lagoru.forex.di.modules;

import com.lagoru.forex.domain.executor.PostExecutionThread;
import com.lagoru.forex.domain.executor.ThreadExecutor;
import com.lagoru.forex.domain.interactor.GetMainScreens;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lagoru on 07.12.16.
 */
@Module
public class ActivityModule {

    //-- use cases dependecies
    @Provides
    public static GetMainScreens provideGetMainScreenUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetMainScreens(threadExecutor, postExecutionThread);
    }
}
