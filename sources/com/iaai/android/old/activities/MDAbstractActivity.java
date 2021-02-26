package com.iaai.android.old.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.apps.analytics.easytracking.EasyTracker;

public class MDAbstractActivity extends AppCompatActivity {
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
    public void onStop() {
        super.onStop();
        EasyTracker.getTracker().trackActivityStop(this);
    }
}
