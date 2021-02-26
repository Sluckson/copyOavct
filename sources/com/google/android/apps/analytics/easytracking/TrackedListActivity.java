package com.google.android.apps.analytics.easytracking;

import android.app.ListActivity;
import android.os.Bundle;

public class TrackedListActivity extends ListActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EasyTracker.getTracker().setContext(this);
    }

    public Object onRetainNonConfigurationInstance() {
        Object onRetainNonConfigurationInstance = super.onRetainNonConfigurationInstance();
        EasyTracker.getTracker().trackActivityRetainNonConfigurationInstance();
        return onRetainNonConfigurationInstance;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        EasyTracker.getTracker().trackActivityStart(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        EasyTracker.getTracker().trackActivityStop(this);
    }
}
