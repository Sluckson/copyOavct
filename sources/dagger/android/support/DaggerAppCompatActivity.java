package dagger.android.support;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import javax.inject.Inject;

public abstract class DaggerAppCompatActivity extends AppCompatActivity implements HasFragmentInjector, HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> frameworkFragmentInjector;
    @Inject
    DispatchingAndroidInjector<androidx.fragment.app.Fragment> supportFragmentInjector;

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
    }

    public AndroidInjector<androidx.fragment.app.Fragment> supportFragmentInjector() {
        return this.supportFragmentInjector;
    }

    public AndroidInjector<Fragment> fragmentInjector() {
        return this.frameworkFragmentInjector;
    }
}
