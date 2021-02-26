package com.iaai.android.bdt.feature.findVehiclePage.filter;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class MakeModelFilterActivity_MembersInjector implements MembersInjector<MakeModelFilterActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public MakeModelFilterActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<MakeModelFilterActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new MakeModelFilterActivity_MembersInjector(provider);
    }

    public void injectMembers(MakeModelFilterActivity makeModelFilterActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(makeModelFilterActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
