package com.iaai.android.old.analytics.sync;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.iaai.android.C2723R;
import com.iaai.android.old.analytics.AnalyticUtils;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.iaai.android.old.analytics.classes.AnalyticInfo;
import com.iaai.android.old.analytics.classes.AnalyticInfoParcelable;
import com.iaai.android.old.analytics.classes.AnalyticsDataList;
import com.iaai.android.old.analytics.classes.AnalyticsSyncResponseInfo;
import com.iaai.android.old.utils.http.RestClient;
import java.util.ArrayList;

public class SyncAnalytics {
    public void SyncAnalyticsData(final Context context, final RestClient restClient) {
        new Thread() {
            public void run() {
                SyncAnalytics.this.downloadReferenceData(context, restClient);
                SyncAnalytics.this.uploadAnalyticData(context, restClient);
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void downloadReferenceData(Context context, RestClient restClient) {
        AnalyticUtils.downloadReferenceTableData(context, restClient);
    }

    /* access modifiers changed from: private */
    public void uploadAnalyticData(Context context, RestClient restClient) {
        AnalyticsSyncResponseInfo analyticsSyncResponseInfo;
        AnalyticsDataList createUploadAnalyticModel = createUploadAnalyticModel(context);
        if (createUploadAnalyticModel.AnalyticsDataList != null && createUploadAnalyticModel.AnalyticsDataList.size() > 0) {
            try {
                analyticsSyncResponseInfo = (AnalyticsSyncResponseInfo) restClient.execute(context.getString(C2723R.string.analytic_save_url), createUploadAnalyticModel, AnalyticsSyncResponseInfo.class, false);
            } catch (Exception e) {
                Log.d("Excep in Ana uploaded", "->" + e.getMessage());
                e.printStackTrace();
                analyticsSyncResponseInfo = null;
            }
            if (analyticsSyncResponseInfo != null) {
                Log.d("AnalyticData uploaded", "->" + analyticsSyncResponseInfo.IsSuccessful);
                if (analyticsSyncResponseInfo.IsSuccessful) {
                    AnalyticUtils.deleteAnalyticTableData(context);
                }
            }
        }
    }

    private AnalyticsDataList createUploadAnalyticModel(Context context) {
        AnalyticsDataList analyticsDataList = new AnalyticsDataList();
        analyticsDataList.AnalyticsDataList = new ArrayList<>();
        Cursor query = context.getContentResolver().query(AnalyticsContract.Analytics.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query.getCount() > 0) {
            while (query.moveToNext()) {
                AnalyticInfo analyticInfo = new AnalyticInfo(query);
                if (AnalyticUtils.isAnalyticTypeIDActive(context, analyticInfo.getAnalyticsTypeID())) {
                    AnalyticInfoParcelable analyticInfoParcelable = new AnalyticInfoParcelable();
                    analyticInfoParcelable.mAnalyticsID = analyticInfo.mAnalyticsID;
                    analyticInfoParcelable.AnalyticsTypeID = analyticInfo.AnalyticsTypeID;
                    analyticInfoParcelable.BranchNumber = analyticInfo.BranchNumber;
                    analyticInfoParcelable.StockNumber = analyticInfo.StockNumber;
                    analyticInfoParcelable.LaneNumber = analyticInfo.LaneNumber;
                    analyticInfoParcelable.UserID = analyticInfo.UserID;
                    analyticInfoParcelable.DeviceVersion = analyticInfo.DeviceVersion;
                    analyticInfoParcelable.DeviceType = analyticInfo.DeviceType;
                    analyticInfoParcelable.beaconMajor = analyticInfo.beaconMajor;
                    analyticInfoParcelable.beaconMinor = analyticInfo.beaconMinor;
                    analyticInfoParcelable.unixtimestamp = analyticInfo.unixtimestamp;
                    analyticsDataList.AnalyticsDataList.add(analyticInfoParcelable);
                }
            }
        }
        return analyticsDataList;
    }
}
