package com.iaai.android.bdt.feature.findVehiclePage.filter;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SubFilterActivity_MembersInjector implements MembersInjector<SubFilterActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public SubFilterActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<SubFilterActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new SubFilterActivity_MembersInjector(provider);
    }

    public void injectMembers(SubFilterActivity subFilterActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(subFilterActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
