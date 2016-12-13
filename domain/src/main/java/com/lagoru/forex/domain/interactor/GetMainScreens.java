package com.lagoru.forex.domain.interactor;

import com.lagoru.forex.data.data.SharedPreferenceManager;
import com.lagoru.forex.data.executor.PostExecutionThread;
import com.lagoru.forex.data.executor.ThreadExecutor;

import java.util.Set;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by lagoru on 07.12.16.
 */

public class GetMainScreens extends UseCase {
    SharedPreferenceManager sharedPreferenceManager;

    public final static String FRAGMENTS_CLASSES_MAIN_SCREEN = "FRAGMENTS_CLASSES_MAIN_SCREEN";

    @Inject
    public GetMainScreens(SharedPreferenceManager sharedPreferenceManager, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.sharedPreferenceManager = sharedPreferenceManager;
    }

    @Override
    protected Observable<Set<String>> buildUseCaseObservable() {
        return rx.Observable.create(subscriber -> {
            Scheduler.Worker inner = Schedulers.io().createWorker();
            subscriber.add(inner);
            inner.schedule(() -> {
                try {
                    Set<String> informationList = sharedPreferenceManager.getStringSet(FRAGMENTS_CLASSES_MAIN_SCREEN);
                    subscriber.onNext(informationList);
                } catch (Exception e) {
                    subscriber.onError(e);
                } finally {
                    subscriber.onCompleted();
                }
            });
        });
    }
}
