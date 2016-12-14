package com.lagoru.forex.domain.interactor;

import com.lagoru.forex.data.data.SharedPreferenceManager;
import com.lagoru.forex.data.executor.PostExecutionThread;
import com.lagoru.forex.data.executor.ThreadExecutor;

import java.util.Set;

import javax.inject.Inject;

import lombok.Setter;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import static com.lagoru.forex.domain.interactor.GetMainScreens.FRAGMENTS_CLASSES_MAIN_SCREEN;

/**
 * Created by lagoru on 14.12.16.
 */

public class SetMainScreens extends UseCase {
    SharedPreferenceManager sharedPreferenceManager;

    @Setter
    Set<String> arguments;

    @Inject
    public SetMainScreens(SharedPreferenceManager sharedPreferenceManager, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.sharedPreferenceManager = sharedPreferenceManager;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return rx.Observable.create(subscriber -> {
            Scheduler.Worker inner = Schedulers.io().createWorker();
            subscriber.add(inner);
            inner.schedule(() -> {
                try {
                    sharedPreferenceManager.setStringSet(FRAGMENTS_CLASSES_MAIN_SCREEN, arguments);
                    subscriber.onNext(arguments);
                } catch (Exception e) {
                    subscriber.onError(e);
                } finally {
                    subscriber.onCompleted();
                }
            });
        });
    }
}
