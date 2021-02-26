package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import p011io.reactivex.Scheduler;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.schedulers.Schedulers;

@Module
public class SchedulerModule {
    @Singleton
    @Provides
    @Named("io")
    public Scheduler providesIOScheduler() {
        return Schedulers.m4611io();
    }

    @Singleton
    @Provides
    @Named("compute")
    public Scheduler providesComputeScheduler() {
        return Schedulers.computation();
    }

    @Singleton
    @Provides
    @Named("main")
    public Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
