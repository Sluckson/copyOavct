package com.iaai.android.old.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.iaai.android.old.analytics.receiver.AnalyticsBootReceiver;
import com.iaai.android.old.utils.IAASharedPreference;

public class SuggestionAlarmReceiver extends WakefulBroadcastReceiver {
    private PendingIntent alarmIntent;
    private AlarmManager alarmMgr;

    public void onReceive(Context context, Intent intent) {
        Log.e("Suggestion Alarm---->", "called");
        IAASharedPreference.saveDayComplete(context, true);
    }

    public void setAlarm(Context context) {
        this.alarmMgr = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.alarmIntent = PendingIntent.getBroadcast(context, 0, new Intent(context, SuggestionAlarmReceiver.class), 0);
        if (!IAASharedPreference.isAlarmSetForRecentAuction(context)) {
            this.alarmMgr.setInexactRepeating(2, 86400000, 86400000, this.alarmIntent);
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, AnalyticsBootReceiver.class), 1, 1);
            Log.e("setAlarmForRecentAuction-->", "true");
            IAASharedPreference.setAlarmForRecentAuction(context, true);
        }
    }

    public void cancelAlarm(Context context) {
        AlarmManager alarmManager = this.alarmMgr;
        if (alarmManager != null) {
            alarmManager.cancel(this.alarmIntent);
        }
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, AnalyticsBootReceiver.class), 2, 1);
    }
}
