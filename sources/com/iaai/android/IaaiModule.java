package com.iaai.android;

import com.google.inject.AbstractModule;
import com.iaai.android.old.managers.AlertManager;
import java.lang.annotation.Annotation;
import roboguice.inject.SharedPreferencesName;

public class IaaiModule extends AbstractModule {
    /* access modifiers changed from: protected */
    public void configure() {
        bindConstant().annotatedWith((Class<? extends Annotation>) SharedPreferencesName.class).mo36510to("com.iaai.android_preferences");
        bind(AlertManager.class).asEagerSingleton();
    }
}
