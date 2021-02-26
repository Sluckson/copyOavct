package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SearchResultActivity_MembersInjector implements MembersInjector<SearchResultActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public SearchResultActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<SearchResultActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new SearchResultActivity_MembersInjector(provider);
    }

    public void injectMembers(SearchResultActivity searchResultActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(searchResultActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
