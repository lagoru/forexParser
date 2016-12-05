package com.lagoru.forex.data.dataprovider;

import com.lagoru.forex.data.model.Information;

import java.io.IOException;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by lagoru on 27.11.16.
 */

public abstract class DataProviderInterface {

    public abstract String getUrl();

    protected abstract List<Information> parseWebsite() throws IOException;

    public Observable<List<Information>> getInformationObservable() {
        return rx.Observable.create(subscriber -> {
            Scheduler.Worker inner = Schedulers.io().createWorker();
            subscriber.add(inner);
            inner.schedule(() -> {
                try {
                    List<Information> informationList = parseWebsite();
                    subscriber.onNext(informationList);
                } catch (Exception e) {
                    subscriber.onError(e);
                } finally {
                    subscriber.onCompleted();
                }
            });
        });
    }

    /*public Observable<List<Information>> getInformationObservable() {
        return rx.Observable.create(new rx.Observable.OnSubscribe<List<Information>>() {

            @Override
            public void call(final Subscriber<? super List<Information>> subscriber) {
                Scheduler.Worker inner = Schedulers.io().createWorker();
                subscriber.add(inner);

                inner.schedule(new Action0() {

                    @Override
                    public void call() {
                        try {
                            List<Information> informationList = parseWebsite();
                            subscriber.onNext(informationList);
                        } catch (Exception e) {
                            subscriber.onError(e);
                        } finally {
                            subscriber.onCompleted();
                        }
                    }

                });
            }
        });
    }*/
}
