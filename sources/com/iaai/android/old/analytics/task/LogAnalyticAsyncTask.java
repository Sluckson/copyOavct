package com.iaai.android.old.analytics.task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.analytics.AnalyticUtils;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.iaai.android.old.analytics.classes.AnalyticInfo;
import com.iaai.android.old.utils.DateHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogAnalyticAsyncTask extends AsyncTask<Object, Void, Void> {
    /* access modifiers changed from: protected */
    public Void doInBackground(Object... objArr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        IaaiApplication.getInstance().analyticsStartDateTime = simpleDateFormat.format(new Date());
        Log.e("[LogAnalyticAsyncTask]", "[START TIME] " + IaaiApplication.getInstance().analyticsStartDateTime);
        Context context = objArr[0];
        AnalyticInfo analyticInfo = objArr[1];
        if (!AnalyticUtils.isAnalyticTypeIDActive(context, analyticInfo.getAnalyticsTypeID()) || AnalyticUtils.isAnalyticCompleteForToday(context, 50, analyticInfo.getAnalyticsTypeID()) || context.getContentResolver().insert(AnalyticsContract.Analytics.CONTENT_URI, analyticInfo.getContentValues()) == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
        IaaiApplication.getInstance().analyticsEndDateTime = simpleDateFormat2.format(new Date());
        Log.e("[LogAnalyticAsyncTask]", "[END TIME] " + IaaiApplication.getInstance().analyticsEndDateTime);
        try {
            DateHelper.TimeDiff calculateTimeDiff = DateHelper.calculateTimeDiff(simpleDateFormat2.parse(IaaiApplication.getInstance().analyticsStartDateTime), simpleDateFormat2.parse(IaaiApplication.getInstance().analyticsEndDateTime));
            Log.e("[LogAnalyticAsyncTask]", "[TIME DIFFERENCE] " + calculateTimeDiff.toString());
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
