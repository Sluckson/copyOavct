package com.iaai.android.old.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.iaai.android.old.utils.IAASharedPreference;

public class SuggestionBootReceiver extends BroadcastReceiver {
    private SuggestionAlarmReceiver alarm = new SuggestionAlarmReceiver();

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            IAASharedPreference.setAlarmForRecentAuction(context, false);
            this.alarm.setAlarm(context);
        }
    }
}
