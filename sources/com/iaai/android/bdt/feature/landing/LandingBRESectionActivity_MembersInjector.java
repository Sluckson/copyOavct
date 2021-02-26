package com.iaai.android.bdt.feature.landing;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class LandingBRESectionActivity_MembersInjector implements MembersInjector<LandingBRESectionActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    public LandingBRESectionActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.dispatchingAndroidInjectorProvider = provider;
    }

    public static MembersInjector<LandingBRESectionActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new LandingBRESectionActivity_MembersInjector(provider);
    }

    public void injectMembers(LandingBRESectionActivity landingBRESectionActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(landingBRESectionActivity, this.dispatchingAndroidInjectorProvider.get());
    }
}
