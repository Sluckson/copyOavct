package com.iaai.android.old.analytics.task;

import android.content.Context;
import android.os.AsyncTask;
import com.iaai.android.old.analytics.AnalyticUtils;
import com.iaai.android.old.utils.http.RestClient;

public class DownloadReferenceAsyncTask extends AsyncTask<Object, Void, Void> {
    /* access modifiers changed from: protected */
    public Void doInBackground(Object... objArr) {
        Context context = objArr[0];
        RestClient restClient = objArr[1];
        if (AnalyticUtils.isLocalDataAvailableInReferenceTable(context)) {
            return null;
        }
        AnalyticUtils.downloadReferenceTableData(context, restClient);
        return null;
    }
}
