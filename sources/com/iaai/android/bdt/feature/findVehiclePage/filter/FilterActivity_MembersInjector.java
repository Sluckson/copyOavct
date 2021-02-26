package com.iaai.android.bdt.feature.findVehiclePage.filter;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class FilterActivity_MembersInjector implements MembersInjector<FilterActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public FilterActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<FilterActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new FilterActivity_MembersInjector(provider);
    }

    public void injectMembers(FilterActivity filterActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(filterActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
