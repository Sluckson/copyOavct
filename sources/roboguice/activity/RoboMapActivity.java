package roboguice.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.maps.MapActivity;
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

public abstract class RoboMapActivity extends MapActivity implements InjectorProvider {
    protected EventManager eventManager;
    protected ContextScope scope;

    public Object onRetainNonConfigurationInstance() {
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, java.lang.Object, com.google.android.maps.MapActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Injector injector = getInjector();
        this.eventManager = (EventManager) injector.getInstance(EventManager.class);
        this.scope = (ContextScope) injector.getInstance(ContextScope.class);
        this.scope.enter(this);
        injector.injectMembers(this);
        RoboMapActivity.super.onCreate(bundle);
        this.eventManager.fire(new OnCreateEvent(bundle));
    }

    public void setContentView(int i) {
        RoboMapActivity.super.setContentView(i);
        this.scope.injectViews();
        this.eventManager.fire(new OnContentViewAvailableEvent());
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        RoboMapActivity.super.setContentView(view, layoutParams);
        this.scope.injectViews();
        this.eventManager.fire(new OnContentViewAvailableEvent());
    }

    public void setContentView(View view) {
        RoboMapActivity.super.setContentView(view);
        this.scope.injectViews();
        this.eventManager.fire(new OnContentViewAvailableEvent());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, com.google.android.maps.MapActivity] */
    /* access modifiers changed from: protected */
    public void onRestart() {
        this.scope.enter(this);
        RoboMapActivity.super.onRestart();
        this.eventManager.fire(new OnRestartEvent());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, com.google.android.maps.MapActivity] */
    /* access modifiers changed from: protected */
    public void onStart() {
        this.scope.enter(this);
        RoboMapActivity.super.onStart();
        this.eventManager.fire(new OnStartEvent());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, com.google.android.maps.MapActivity] */
    /* access modifiers changed from: protected */
    public void onResume() {
        this.scope.enter(this);
        RoboMapActivity.super.onResume();
        this.eventManager.fire(new OnResumeEvent());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        RoboMapActivity.super.onPause();
        this.eventManager.fire(new OnPauseEvent());
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, com.google.android.maps.MapActivity] */
    public void onNewIntent(Intent intent) {
        RoboMapActivity.super.onNewIntent(intent);
        this.scope.enter(this);
        this.eventManager.fire(new OnNewIntentEvent());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, com.google.android.maps.MapActivity] */
    /* access modifiers changed from: protected */
    public void onStop() {
        this.scope.enter(this);
        try {
            this.eventManager.fire(new OnStopEvent());
        } finally {
            this.scope.exit(this);
            RoboMapActivity.super.onStop();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, com.google.android.maps.MapActivity] */
    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.scope.enter(this);
        try {
            this.eventManager.fire(new OnDestroyEvent());
        } finally {
            this.eventManager.clear(this);
            this.scope.exit(this);
            this.scope.dispose(this);
            RoboMapActivity.super.onDestroy();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = getResources().getConfiguration();
        RoboMapActivity.super.onConfigurationChanged(configuration);
        this.eventManager.fire(new OnConfigurationChangedEvent(configuration2, configuration));
    }

    public void onContentChanged() {
        RoboMapActivity.super.onContentChanged();
        this.eventManager.fire(new OnContentChangedEvent());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, roboguice.activity.RoboMapActivity, com.google.android.maps.MapActivity] */
    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        RoboMapActivity.super.onActivityResult(i, i2, intent);
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
