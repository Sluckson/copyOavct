package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.InternalContext;
import com.google.inject.spi.InjectionPoint;

interface SingleMemberInjector {
    InjectionPoint getInjectionPoint();

    void inject(Errors errors, InternalContext internalContext, Object obj);
}
