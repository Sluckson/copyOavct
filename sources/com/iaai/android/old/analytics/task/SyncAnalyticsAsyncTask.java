package com.iaai.android.old.analytics.task;

import android.os.AsyncTask;
import com.iaai.android.old.analytics.AnalyticUtils;

public class SyncAnalyticsAsyncTask extends AsyncTask<Object, Void, Void> {
    /* access modifiers changed from: protected */
    public Void doInBackground(Object... objArr) {
        AnalyticUtils.updateInsertReferenceTabel(objArr[0], objArr[1]);
        return null;
    }
}
