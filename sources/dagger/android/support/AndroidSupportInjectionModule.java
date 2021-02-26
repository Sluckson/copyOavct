package dagger.android.support;

import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;
import java.util.Map;

@Module(includes = {AndroidInjectionModule.class})
public abstract class AndroidSupportInjectionModule {
    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<Class<? extends Fragment>, AndroidInjector.Factory<? extends Fragment>> supportFragmentInjectorFactories();

    private AndroidSupportInjectionModule() {
    }
}
