package roboguice.config;

import android.content.Context;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.matcher.Matchers;
import roboguice.event.EventManager;
import roboguice.event.ObservesTypeListener;

public class EventManagerModule extends AbstractModule {
    protected Provider<Context> contextProvider;
    protected EventManager eventManager;

    public EventManagerModule(EventManager eventManager2, Provider<Context> provider) {
        this.eventManager = eventManager2;
        this.contextProvider = provider;
    }

    /* access modifiers changed from: protected */
    public void configure() {
        bind(EventManager.class).toInstance(this.eventManager);
        bindListener(Matchers.any(), new ObservesTypeListener(this.contextProvider, this.eventManager));
        requestInjection(this.eventManager);
    }
}
