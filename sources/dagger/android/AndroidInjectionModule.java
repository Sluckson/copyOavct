package dagger.android;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;
import java.util.Map;

@Module
public abstract class AndroidInjectionModule {
    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<Class<? extends Activity>, AndroidInjector.Factory<? extends Activity>> activityInjectorFactories();

    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<Class<? extends BroadcastReceiver>, AndroidInjector.Factory<? extends BroadcastReceiver>> broadcastReceiverInjectorFactories();

    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<Class<? extends ContentProvider>, AndroidInjector.Factory<? extends ContentProvider>> contentProviderInjectorFactories();

    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<Class<? extends Fragment>, AndroidInjector.Factory<? extends Fragment>> fragmentInjectorFactories();

    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<Class<? extends Service>, AndroidInjector.Factory<? extends Service>> serviceInjectorFactories();

    private AndroidInjectionModule() {
    }
}
