package dagger.android.support;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;

public abstract class DaggerApplication extends dagger.android.DaggerApplication implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    /* access modifiers changed from: protected */
    public abstract AndroidInjector<? extends DaggerApplication> applicationInjector();

    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return this.supportFragmentInjector;
    }
}
