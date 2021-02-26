package com.iaai.android.old.analytics;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.iaai.android.C2723R;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.iaai.android.old.analytics.classes.AnalyticInfo;
import com.iaai.android.old.analytics.classes.ReferenceInfo;
import com.iaai.android.old.analytics.task.LogAnalyticAsyncTask;
import com.iaai.android.old.analytics.task.SyncAnalyticsAsyncTask;
import com.iaai.android.old.utils.http.RestClient;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class AnalyticUtils {
    public static boolean isAnalyticCompleteForToday(Context context, int i, int i2) {
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(getYesterdayTimeInSeconds());
            return context.getContentResolver().query(AnalyticsContract.Analytics.CONTENT_URI, (String[]) null, "AnalyticsTypeID =? AND UTCDateTime >?", new String[]{sb.toString(), sb2.toString()}, (String) null).getCount() >= i;
        }
        throw new IllegalArgumentException("analytic_type_id should be greater than zero");
    }

    public static boolean isBeconDataExist(Context context, int i, int i2, int i3) {
        if (i <= 0) {
            throw new IllegalArgumentException("major should be greater than zero");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("minor should be greater than zero");
        } else if (i3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(i);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(i2);
            return context.getContentResolver().query(AnalyticsContract.Analytics.CONTENT_URI, (String[]) null, "AnalyticsTypeID =? AND BranchNumber =? AND StockNumber =?", new String[]{sb.toString(), sb2.toString(), sb3.toString()}, (String) null).getCount() > 0;
        } else {
            throw new IllegalArgumentException("analytic_type_id should be greater than zero");
        }
    }

    private static long getYesterdayTimeInSeconds() {
        return (System.currentTimeMillis() - 86400000) / 1000;
    }

    public static boolean isAnalyticTypeIDActive(Context context, int i) {
        if (i > 0) {
            boolean z = false;
            Cursor query = context.getContentResolver().query(AnalyticsContract.Reference.CONTENT_URI, (String[]) null, "AnalyticsTypeID =?", new String[]{"" + i}, (String) null);
            if (query.getCount() > 0) {
                while (query.moveToNext()) {
                    z = new ReferenceInfo(query).getIsActive();
                }
            }
            query.close();
            return z;
        }
        throw new IllegalArgumentException("analytic_type_id should be greater than zero");
    }

    public static boolean isAnalyticTypeIDAvailable(Context context, int i) {
        if (i > 0) {
            boolean z = true;
            Cursor query = context.getContentResolver().query(AnalyticsContract.Reference.CONTENT_URI, (String[]) null, "AnalyticsTypeID =?", new String[]{"" + i}, (String) null);
            if (query.getCount() <= 0) {
                z = false;
            }
            query.close();
            return z;
        }
        throw new IllegalArgumentException("analytic_type_id should be greater than zero");
    }

    public static void updateInsertReferenceTabel(Context context, ReferenceInfo referenceInfo) {
        if (referenceInfo == null) {
            throw new IllegalArgumentException("ReferenceInfo object should not be null");
        } else if (isAnalyticTypeIDAvailable(context, referenceInfo.getAnalyticsTypeID())) {
            context.getContentResolver().update(AnalyticsContract.Reference.CONTENT_URI, referenceInfo.getContentValues(), "AnalyticsTypeID =?", new String[]{"" + referenceInfo.getAnalyticsTypeID()});
            Log.d("Updated-TypeID->", "" + referenceInfo.getAnalyticsTypeID());
        } else {
            context.getContentResolver().insert(AnalyticsContract.Reference.CONTENT_URI, referenceInfo.getContentValues());
            Log.d("Added-TypeID->", "" + referenceInfo.getAnalyticsTypeID());
        }
    }

    public static String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return capitalize(str2);
        }
        return capitalize(str) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "";
        boolean z = true;
        for (char c : str.toCharArray()) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                str2 = str2 + c;
            } else {
                str2 = str2 + Character.toUpperCase(c);
                z = false;
            }
        }
        return str2;
    }

    public static boolean isLocalDataAvailableInReferenceTable(Context context) {
        Cursor query = context.getContentResolver().query(AnalyticsContract.Reference.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        boolean z = query.getCount() > 0;
        query.close();
        return z;
    }

    public static int deleteAnalyticTableData(Context context) {
        int delete = context.getContentResolver().delete(AnalyticsContract.Analytics.CONTENT_URI, (String) null, (String[]) null);
        Log.d("Analytic row deleted", "->" + delete);
        return delete;
    }

    public static void downloadReferenceTableData(Context context, RestClient restClient) {
        List<ReferenceInfo> list;
        try {
            list = restClient.executeAnalytics(context.getString(C2723R.string.analytic_reference_url), (Parcelable) null, (Class) null, false, new TypeReference<List<ReferenceInfo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        if (list != null) {
            for (ReferenceInfo updateInsertReferenceTabel : list) {
                updateInsertReferenceTabel(context, updateInsertReferenceTabel);
            }
        }
    }

    public static void testDataForReferenceTable(Context context) {
        new SyncAnalyticsAsyncTask();
        updateInsertReferenceTabel(context, new ReferenceInfo(10, "auction list", true));
        updateInsertReferenceTabel(context, new ReferenceInfo(12, "Join Ibid", true));
    }

    public static void logAnalytics(Context context, AnalyticInfo analyticInfo) {
        new LogAnalyticAsyncTask().execute(new Object[]{context, analyticInfo});
    }
}
