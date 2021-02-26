package roboguice.activity;

import android.accounts.AccountAuthenticatorActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.inject.Injector;
import roboguice.activity.event.OnActivityResultEvent;
import roboguice.activity.event.OnConfigurationChangedEvent;
import roboguice.activity.event.OnContentChangedEvent;
import roboguice.activity.event.OnContentViewAvailableEvent;
import roboguice.activity.event.OnCreateEvent;
import roboguice.activity.event.OnDestroyEvent;
import roboguice.activity.event.OnNewIntentEvent;
import roboguice.activity.event.OnPauseEvent;
import roboguice.activity.event.OnRestartEvent;
import roboguice.activity.event.OnResumeEvent;
import roboguice.activity.event.OnStartEvent;
import roboguice.activity.event.OnStopEvent;
import roboguice.application.RoboApplication;
import roboguice.event.EventManager;
import roboguice.inject.ContextScope;
import roboguice.inject.InjectorProvider;

public class RoboAccountAuthenticatorActivity extends AccountAuthenticatorActivity implements InjectorProvider {
    protected EventManager eventManager;
    protected ContextScope scope;

    public Object onRetainNonConfigurationInstance() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Injector injector = getInjector();
        this.eventManager = (EventManager) injector.getInstance(EventManager.class);
        this.scope = (ContextScope) injector.getInstance(ContextScope.class);
        this.scope.enter(this);
        injector.injectMembers(this);
        super.onCreate(bundle);
        this.eventManager.fire(new OnCreateEvent(bundle));
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.scope.injectViews();
        this.eventManager.fire(new OnContentViewAvailableEvent());
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.scope.injectViews();
        this.eventManager.fire(new OnContentViewAvailableEvent());
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.scope.injectViews();
        this.eventManager.fire(new OnContentViewAvailableEvent());
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        this.scope.enter(this);
        super.onRestart();
        this.eventManager.fire(new OnRestartEvent());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.scope.enter(this);
        super.onStart();
        this.eventManager.fire(new OnStartEvent());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.scope.enter(this);
        super.onResume();
        this.eventManager.fire(new OnResumeEvent());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.eventManager.fire(new OnPauseEvent());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.scope.enter(this);
        this.eventManager.fire(new OnNewIntentEvent());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.scope.enter(this);
        try {
            this.eventManager.fire(new OnStopEvent());
        } finally {
            this.scope.exit(this);
            super.onStop();
        }
    }

    /* access modifiers changed from: protected */
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

    public void onContentChanged() {
        super.onContentChanged();
        this.eventManager.fire(new OnContentChangedEvent());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.scope.enter(this);
        try {
            this.eventManager.fire(new OnActivityResultEvent(i, i2, intent));
        } finally {
            this.scope.exit(this);
        }
    }

    public Injector getInjector() {
        return ((RoboApplication) getApplication()).getInjector();
    }
}
