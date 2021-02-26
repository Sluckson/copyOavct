package com.iaai.android.bdt.injection.module;

import com.iaai.android.bdt.injection.module.CustomInterceptor;
import dagger.MembersInjector;

public final class CustomInterceptor_Companion_MembersInjector implements MembersInjector<CustomInterceptor.Companion> {
    public static MembersInjector<CustomInterceptor.Companion> create() {
        return new CustomInterceptor_Companion_MembersInjector();
    }

    public void injectMembers(CustomInterceptor.Companion companion) {
        injectGet(companion);
    }

    public static CustomInterceptor injectGet(CustomInterceptor.Companion companion) {
        return companion.get();
    }
}
