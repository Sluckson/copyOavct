package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SearchByDistanceActivity_MembersInjector implements MembersInjector<SearchByDistanceActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public SearchByDistanceActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<SearchByDistanceActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new SearchByDistanceActivity_MembersInjector(provider);
    }

    public void injectMembers(SearchByDistanceActivity searchByDistanceActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchByDistanceActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
