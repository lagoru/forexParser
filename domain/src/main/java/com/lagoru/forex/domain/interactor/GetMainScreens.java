package com.lagoru.forex.domain.interactor;

import com.lagoru.forex.domain.executor.PostExecutionThread;
import com.lagoru.forex.domain.executor.ThreadExecutor;

import rx.Observable;

/**
 * Created by lagoru on 07.12.16.
 */

public class GetMainScreens extends UseCase {
    public GetMainScreens(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    public Observable buildUseCaseObservable() {
        return null;
    }
}
