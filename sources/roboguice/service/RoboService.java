package roboguice.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import com.google.inject.Injector;
import roboguice.application.RoboApplication;
import roboguice.event.EventManager;
import roboguice.inject.ContextScope;
import roboguice.inject.InjectorProvider;
import roboguice.service.event.OnConfigurationChangedEvent;
import roboguice.service.event.OnCreateEvent;
import roboguice.service.event.OnDestroyEvent;
import roboguice.service.event.OnStartEvent;

public abstract class RoboService extends Service implements InjectorProvider {
    protected EventManager eventManager;
    protected ContextScope scope;

    public void onCreate() {
        Injector injector = getInjector();
        this.eventManager = (EventManager) injector.getInstance(EventManager.class);
        this.scope = (ContextScope) injector.getInstance(ContextScope.class);
        this.scope.enter(this);
        injector.injectMembers(this);
        super.onCreate();
        this.eventManager.fire(new OnCreateEvent());
    }

    public void onStart(Intent intent, int i) {
        this.scope.enter(this);
        super.onStart(intent, i);
        this.eventManager.fire(new OnStartEvent());
    }

    public void onDestroy() {
        this.scope.enter(this);
        try {
            this.eventManager.fire(new OnDestroyEvent());
        } finally {
            this.eventManager.clear(this);
            this.scope.exit(this);
            this.scope.dispose(this);
            super.onDestroy();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = getResources().getConfiguration();
        super.onConfigurationChanged(configuration);
        this.eventManager.fire(new OnConfigurationChangedEvent(configuration2, configuration));
    }

    public Injector getInjector() {
        return ((RoboApplication) getApplication()).getInjector();
    }
}
