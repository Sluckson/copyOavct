package com.google.firebase.inappmessaging.internal;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import p011io.reactivex.Scheduler;

@Singleton
public class Schedulers {
    private final Scheduler computeScheduler;
    private final Scheduler ioScheduler;
    private final Scheduler mainThreadScheduler;

    @Inject
    Schedulers(@Named("io") Scheduler scheduler, @Named("compute") Scheduler scheduler2, @Named("main") Scheduler scheduler3) {
        this.ioScheduler = scheduler;
        this.computeScheduler = scheduler2;
        this.mainThreadScheduler = scheduler3;
    }

    /* renamed from: io */
    public Scheduler mo34832io() {
        return this.ioScheduler;
    }

    public Scheduler mainThread() {
        return this.mainThreadScheduler;
    }

    public Scheduler computation() {
        return this.computeScheduler;
    }
}
