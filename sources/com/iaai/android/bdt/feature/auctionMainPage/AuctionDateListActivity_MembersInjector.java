package com.iaai.android.bdt.feature.auctionMainPage;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class AuctionDateListActivity_MembersInjector implements MembersInjector<AuctionDateListActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public AuctionDateListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<AuctionDateListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new AuctionDateListActivity_MembersInjector(provider);
    }

    public void injectMembers(AuctionDateListActivity auctionDateListActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(auctionDateListActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
