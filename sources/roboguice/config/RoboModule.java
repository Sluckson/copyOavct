package roboguice.config;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.matcher.Matchers;
import java.lang.annotation.Annotation;
import roboguice.inject.ActivityProvider;
import roboguice.inject.AssetManagerProvider;
import roboguice.inject.ContentResolverProvider;
import roboguice.inject.ContextScope;
import roboguice.inject.ContextScoped;
import roboguice.inject.ExtrasListener;
import roboguice.inject.PreferenceListener;
import roboguice.inject.ResourceListener;
import roboguice.inject.ResourcesProvider;
import roboguice.inject.SharedPreferencesProvider;
import roboguice.inject.SystemServiceProvider;
import roboguice.inject.ViewListener;
import roboguice.util.C5058Ln;
import roboguice.util.RoboAsyncTask;
import roboguice.util.RoboThread;

public class RoboModule extends AbstractModule {
    protected Application application;
    protected Provider<Context> contextProvider;
    protected ContextScope contextScope;
    protected ExtrasListener extrasListener;
    protected PreferenceListener preferenceListener;
    protected ResourceListener resourceListener;
    protected Provider<Context> throwingContextProvider;
    protected ViewListener viewListener;

    public RoboModule(ContextScope contextScope2, Provider<Context> provider, Provider<Context> provider2, ResourceListener resourceListener2, ViewListener viewListener2, ExtrasListener extrasListener2, PreferenceListener preferenceListener2, Application application2) {
        this.contextScope = contextScope2;
        this.throwingContextProvider = provider;
        this.contextProvider = provider2;
        this.resourceListener = resourceListener2;
        this.viewListener = viewListener2;
        this.extrasListener = extrasListener2;
        this.preferenceListener = preferenceListener2;
        this.application = application2;
    }

    /* access modifiers changed from: protected */
    public void configure() {
        bindScope(ContextScoped.class, this.contextScope);
        bind(ContextScope.class).toInstance(this.contextScope);
        bind(Context.class).toProvider(this.throwingContextProvider).mo36522in((Class<? extends Annotation>) ContextScoped.class);
        bind(Activity.class).toProvider(ActivityProvider.class);
        bind(AssetManager.class).toProvider(AssetManagerProvider.class);
        bind(SharedPreferences.class).toProvider(SharedPreferencesProvider.class);
        bind(Resources.class).toProvider(ResourcesProvider.class);
        bind(ContentResolver.class).toProvider(ContentResolverProvider.class);
        Class cls = this.application.getClass();
        while (cls != null && Application.class.isAssignableFrom(cls)) {
            bind(cls).toInstance(this.application);
            cls = cls.getSuperclass();
        }
        bind(LocationManager.class).toProvider(new SystemServiceProvider("location"));
        bind(WindowManager.class).toProvider(new SystemServiceProvider("window"));
        bind(LayoutInflater.class).toProvider(new SystemServiceProvider("layout_inflater"));
        bind(ActivityManager.class).toProvider(new SystemServiceProvider("activity"));
        bind(PowerManager.class).toProvider(new SystemServiceProvider("power"));
        bind(AlarmManager.class).toProvider(new SystemServiceProvider(NotificationCompat.CATEGORY_ALARM));
        bind(NotificationManager.class).toProvider(new SystemServiceProvider("notification"));
        bind(KeyguardManager.class).toProvider(new SystemServiceProvider("keyguard"));
        bind(SearchManager.class).toProvider(new SystemServiceProvider(FirebaseAnalytics.Event.SEARCH));
        bind(Vibrator.class).toProvider(new SystemServiceProvider("vibrator"));
        bind(ConnectivityManager.class).toProvider(new SystemServiceProvider("connectivity"));
        bind(WifiManager.class).toProvider(new SystemServiceProvider("wifi"));
        bind(InputMethodManager.class).toProvider(new SystemServiceProvider("input_method"));
        bind(SensorManager.class).toProvider(new SystemServiceProvider("sensor"));
        bindListener(Matchers.any(), this.resourceListener);
        bindListener(Matchers.any(), this.extrasListener);
        bindListener(Matchers.any(), this.viewListener);
        if (this.preferenceListener != null) {
            bindListener(Matchers.any(), this.preferenceListener);
        }
        requestStaticInjection(C5058Ln.class);
        requestStaticInjection(RoboThread.class);
        requestStaticInjection(RoboAsyncTask.class);
    }
}
