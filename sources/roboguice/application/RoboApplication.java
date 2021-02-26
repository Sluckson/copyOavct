package roboguice.application;

import android.app.Application;
import android.content.Context;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Stage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.config.AbstractAndroidModule;
import roboguice.config.EventManagerModule;
import roboguice.config.RoboModule;
import roboguice.event.EventManager;
import roboguice.inject.ContextScope;
import roboguice.inject.ExtrasListener;
import roboguice.inject.InjectorProvider;
import roboguice.inject.PreferenceListener;
import roboguice.inject.ResourceListener;
import roboguice.inject.StaticTypeListener;
import roboguice.inject.ViewListener;

public class RoboApplication extends Application implements InjectorProvider {
    protected Provider<Context> contextProvider;
    protected ContextScope contextScope;
    protected EventManager eventManager;
    protected ExtrasListener extrasListener;
    protected Injector guiceInjector;
    protected PreferenceListener preferenceListener;
    protected ResourceListener resourceListener;
    protected List<StaticTypeListener> staticTypeListeners;
    protected Provider<Context> throwingContextProvider;
    protected ViewListener viewListener;

    /* access modifiers changed from: protected */
    public void addApplicationModules(List<Module> list) {
    }

    /* access modifiers changed from: protected */
    public boolean allowContextObservers() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean allowPreferenceInjection() {
        return true;
    }

    public Injector getInjector() {
        if (this.guiceInjector == null) {
            synchronized (this) {
                if (this.guiceInjector == null) {
                    initInstanceMembers();
                    this.guiceInjector = createInjector();
                }
            }
        }
        return this.guiceInjector;
    }

    /* access modifiers changed from: protected */
    public void initInstanceMembers() {
        this.contextScope = new ContextScope(this);
        this.throwingContextProvider = new Provider<Context>() {
            public Context get() {
                return RoboApplication.this;
            }
        };
        this.contextProvider = this.contextScope.scope(Key.get(Context.class), this.throwingContextProvider);
        this.resourceListener = new ResourceListener(this);
        this.viewListener = new ViewListener(this.contextProvider, this, this.contextScope);
        this.extrasListener = new ExtrasListener(this.contextProvider);
        this.eventManager = allowContextObservers() ? new EventManager() : new EventManager.NullEventManager();
        if (allowPreferenceInjection()) {
            this.preferenceListener = new PreferenceListener(this.contextProvider, this, this.contextScope);
        }
        this.staticTypeListeners = new ArrayList();
        this.staticTypeListeners.add(this.resourceListener);
    }

    /* access modifiers changed from: protected */
    public Injector createInjector() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RoboModule(this.contextScope, this.throwingContextProvider, this.contextProvider, this.resourceListener, this.viewListener, this.extrasListener, this.preferenceListener, this));
        arrayList.add(new EventManagerModule(this.eventManager, this.contextProvider));
        addApplicationModules(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Module module = (Module) it.next();
            if (module instanceof AbstractAndroidModule) {
                ((AbstractAndroidModule) module).setStaticTypeListeners(this.staticTypeListeners);
            }
        }
        return Guice.createInjector(Stage.PRODUCTION, (Iterable<? extends Module>) arrayList);
    }

    public List<StaticTypeListener> getStaticTypeListeners() {
        return this.staticTypeListeners;
    }
}
