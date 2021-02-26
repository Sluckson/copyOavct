package com.google.inject.binder;

import com.google.inject.Scope;
import java.lang.annotation.Annotation;

public interface ScopedBindingBuilder {
    void asEagerSingleton();

    /* renamed from: in */
    void mo36521in(Scope scope);

    /* renamed from: in */
    void mo36522in(Class<? extends Annotation> cls);
}
