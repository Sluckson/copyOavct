package dagger.android.support;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;

public abstract class DaggerAppCompatDialogFragment extends AppCompatDialogFragment implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    public AndroidInjector<Fragment> supportFragmentInjector() {
        return this.childFragmentInjector;
    }
}
