package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SearchByACVActivity_MembersInjector implements MembersInjector<SearchByACVActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public SearchByACVActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<SearchByACVActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new SearchByACVActivity_MembersInjector(provider);
    }

    public void injectMembers(SearchByACVActivity searchByACVActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchByACVActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
