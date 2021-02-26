package com.iaai.android.old.analytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AnalyticsBootReceiver extends BroadcastReceiver {
    private AnalyticsAlarmReceiver alarm = new AnalyticsAlarmReceiver();

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            this.alarm.setAlarm(context);
        }
    }
}
