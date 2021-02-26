package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BDTPaymentActivity_MembersInjector implements MembersInjector<BDTPaymentActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public BDTPaymentActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<BDTPaymentActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new BDTPaymentActivity_MembersInjector(provider);
    }

    public void injectMembers(BDTPaymentActivity bDTPaymentActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTPaymentActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
