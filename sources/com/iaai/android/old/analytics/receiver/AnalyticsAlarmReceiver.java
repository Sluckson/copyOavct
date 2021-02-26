package com.iaai.android.old.analytics.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.inject.Inject;
import com.iaai.android.old.analytics.sync.SyncAnalytics;
import com.iaai.android.old.utils.http.RestClient;
import java.util.Date;
import roboguice.application.RoboApplication;

public class AnalyticsAlarmReceiver extends WakefulBroadcastReceiver {
    private PendingIntent alarmIntent;
    private AlarmManager alarmMgr;
    @Inject
    RestClient restClient;

    public void onReceive(Context context, Intent intent) {
        Log.e("AnalyticsAlarmReceiver received", "time " + new Date());
        new SyncAnalytics().SyncAnalyticsData(context, (RestClient) ((RoboApplication) context.getApplicationContext()).getInjector().getInstance(RestClient.class));
    }

    public void setAlarm(Context context) {
        this.alarmMgr = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.alarmIntent = PendingIntent.getBroadcast(context, 0, new Intent(context, AnalyticsAlarmReceiver.class), 0);
        this.alarmMgr.setInexactRepeating(2, 1800000, 1800000, this.alarmIntent);
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, AnalyticsBootReceiver.class), 1, 1);
    }

    public void cancelAlarm(Context context) {
        AlarmManager alarmManager = this.alarmMgr;
        if (alarmManager != null) {
            alarmManager.cancel(this.alarmIntent);
        }
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, AnalyticsBootReceiver.class), 2, 1);
    }
}
