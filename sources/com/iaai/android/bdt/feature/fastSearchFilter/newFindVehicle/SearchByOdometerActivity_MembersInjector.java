package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SearchByOdometerActivity_MembersInjector implements MembersInjector<SearchByOdometerActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public SearchByOdometerActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<SearchByOdometerActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new SearchByOdometerActivity_MembersInjector(provider);
    }

    public void injectMembers(SearchByOdometerActivity searchByOdometerActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchByOdometerActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
