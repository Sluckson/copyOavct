package com.iaai.android.bdt.utils;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SharedPrefsHelper_Factory implements Factory<SharedPrefsHelper> {
    private final Provider<SharedPreferences> mSharedPreferencesProvider;

    public SharedPrefsHelper_Factory(Provider<SharedPreferences> provider) {
        this.mSharedPreferencesProvider = provider;
    }

    public SharedPrefsHelper get() {
        return provideInstance(this.mSharedPreferencesProvider);
    }

    public static SharedPrefsHelper provideInstance(Provider<SharedPreferences> provider) {
        return new SharedPrefsHelper(provider.get());
    }

    public static SharedPrefsHelper_Factory create(Provider<SharedPreferences> provider) {
        return new SharedPrefsHelper_Factory(provider);
    }

    public static SharedPrefsHelper newSharedPrefsHelper(SharedPreferences sharedPreferences) {
        return new SharedPrefsHelper(sharedPreferences);
    }
}
