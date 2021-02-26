package com.iaai.android.old.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.apps.analytics.easytracking.EasyTracker;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import roboguice.activity.RoboListActivity;

public abstract class AbstractListActivity extends RoboListActivity {
    /* access modifiers changed from: protected */
    public int[] getMenuIds() {
        return ActivityHelper.DEFAULT_MENU_IDS;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return ActivityHelper.createOptionMenu(menu, getMenuIds());
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (ActivityHelper.isCorrectMenu(menu, getMenuIds())) {
            return true;
        }
        menu.clear();
        ActivityHelper.createOptionMenu(menu, getMenuIds());
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return ActivityHelper.onMenuItemSelected(this, menuItem);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EasyTracker.getTracker().setContext(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        EasyTracker.getTracker().trackActivityStart(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public Object onRetainNonConfigurationInstance() {
        Object onRetainNonConfigurationInstance = super.onRetainNonConfigurationInstance();
        EasyTracker.getTracker().trackActivityRetainNonConfigurationInstance();
        return onRetainNonConfigurationInstance;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        EasyTracker.getTracker().trackActivityStop(this);
    }
}
