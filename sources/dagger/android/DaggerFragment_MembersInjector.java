package dagger.android;

import android.app.Fragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerFragment_MembersInjector implements MembersInjector<DaggerFragment> {
    private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

    public DaggerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.childFragmentInjectorProvider = provider;
    }

    public static MembersInjector<DaggerFragment> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new DaggerFragment_MembersInjector(provider);
    }

    public void injectMembers(DaggerFragment daggerFragment) {
        injectChildFragmentInjector(daggerFragment, this.childFragmentInjectorProvider.get());
    }

    public static void injectChildFragmentInjector(DaggerFragment daggerFragment, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        daggerFragment.childFragmentInjector = dispatchingAndroidInjector;
    }
}
