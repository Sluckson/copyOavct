package com.iaai.android.old.managers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.inject.Inject;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Date;
import roboguice.activity.event.OnCreateEvent;
import roboguice.activity.event.OnDestroyEvent;
import roboguice.event.EventManager;
import roboguice.event.Observes;
import roboguice.util.C5058Ln;

public class AuctionDateChangeEventListener {
    private final BroadcastReceiver broadcastReceiver;
    @Inject
    Context context;
    @Inject
    EventManager eventManager;
    private final IntentFilter intentFilter = new IntentFilter();

    AuctionDateChangeEventListener() {
        this.intentFilter.addAction(Constants.INTENT_AUCTION_DATES_CHANGE);
        this.broadcastReceiver = new AuctionDateBroadcastReceiver();
    }

    /* access modifiers changed from: package-private */
    public void registerReceiver(@Observes OnCreateEvent onCreateEvent) {
        C5058Ln.m4829d("AuctionDateChangeEventListener.registerReceiver context[%s]", this.context.getClass().getSimpleName());
        this.context.registerReceiver(this.broadcastReceiver, this.intentFilter);
    }

    /* access modifiers changed from: package-private */
    public void unregisterReceiver(@Observes OnDestroyEvent onDestroyEvent) {
        C5058Ln.m4829d("AuctionDateChangeEventListener.unregisterReceiver context[%s]", this.context.getClass().getSimpleName());
        this.context.unregisterReceiver(this.broadcastReceiver);
    }

    private class AuctionDateBroadcastReceiver extends BroadcastReceiver {
        private AuctionDateBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int i;
            Date[] dateArr;
            long[] longArrayExtra = intent.getLongArrayExtra(Constants.EXTRA_DATE);
            if (longArrayExtra == null) {
                i = 0;
            } else {
                i = longArrayExtra.length;
            }
            if (i > 0) {
                dateArr = new Date[i];
                for (int i2 = 0; i2 < i; i2++) {
                    dateArr[i2] = new Date(longArrayExtra[i2]);
                }
            } else {
                dateArr = null;
            }
            Intent intent2 = new Intent(Constants.INTENT_AUCTION_DATES_CHANGE_NEW);
            intent2.putExtra(Constants.EXTRA_DATE_NEW, longArrayExtra);
            context.sendBroadcast(intent2);
            AuctionDateChangeEventListener.this.eventManager.fire(context, new OnAuctionDateChangeEvent(dateArr, intent));
        }
    }
}
