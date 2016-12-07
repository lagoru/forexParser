package com.lagoru.forex.presenter;

/**
 * Created by lagoru on 06.12.16.
 */

public interface Presenter {

    void start();

    void resume();

    void pause();

    void stop();

    void destroy();
}
