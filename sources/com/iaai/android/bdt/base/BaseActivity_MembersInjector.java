package com.iaai.android.bdt.base;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public BaseActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<BaseActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new BaseActivity_MembersInjector(provider);
    }

    public void injectMembers(BaseActivity baseActivity) {
        injectDispatchingAndroidInjector(baseActivity, this.dispatchingAndroidInjectorProvider.get());
    }

    public static void injectDispatchingAndroidInjector(BaseActivity baseActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        baseActivity.dispatchingAndroidInjector = dispatchingAndroidInjector;
    }
}
