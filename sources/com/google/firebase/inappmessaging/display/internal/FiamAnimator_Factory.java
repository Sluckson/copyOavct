package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

public final class FiamAnimator_Factory implements Factory<FiamAnimator> {
    private static final FiamAnimator_Factory INSTANCE = new FiamAnimator_Factory();

    public FiamAnimator get() {
        return new FiamAnimator();
    }

    public static FiamAnimator_Factory create() {
        return INSTANCE;
    }

    public static FiamAnimator newInstance() {
        return new FiamAnimator();
    }
}
