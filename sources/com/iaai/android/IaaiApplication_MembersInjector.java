package com.iaai.android;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.injection.module.CustomInterceptor;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class IaaiApplication_MembersInjector implements MembersInjector<IaaiApplication> {
    private final Provider<CustomInterceptor> customInterceptorProvider;
    private final Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingFragmentInjectorProvider;

    public IaaiApplication_MembersInjector(Provider<DispatchingAndroidInjector<Activity>> provider, Provider<DispatchingAndroidInjector<Fragment>> provider2, Provider<CustomInterceptor> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.dispatchingFragmentInjectorProvider = provider2;
        this.customInterceptorProvider = provider3;
    }

    public static MembersInjector<IaaiApplication> create(Provider<DispatchingAndroidInjector<Activity>> provider, Provider<DispatchingAndroidInjector<Fragment>> provider2, Provider<CustomInterceptor> provider3) {
        return new IaaiApplication_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(IaaiApplication iaaiApplication) {
        injectDispatchingAndroidInjector(iaaiApplication, this.dispatchingAndroidInjectorProvider.get());
        injectDispatchingFragmentInjector(iaaiApplication, this.dispatchingFragmentInjectorProvider.get());
        injectCustomInterceptor(iaaiApplication, this.customInterceptorProvider.get());
    }

    public static void injectDispatchingAndroidInjector(IaaiApplication iaaiApplication, DispatchingAndroidInjector<Activity> dispatchingAndroidInjector) {
        iaaiApplication.dispatchingAndroidInjector = dispatchingAndroidInjector;
    }

    public static void injectDispatchingFragmentInjector(IaaiApplication iaaiApplication, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        iaaiApplication.dispatchingFragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectCustomInterceptor(IaaiApplication iaaiApplication, CustomInterceptor customInterceptor) {
        iaaiApplication.customInterceptor = customInterceptor;
    }
}
