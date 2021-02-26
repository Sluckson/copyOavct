package com.iaai.android.old.managers;

import android.content.Intent;
import java.util.Date;

public class OnAuctionDateChangeEvent {
    public final Date[] dates;
    public final Intent intent;

    public OnAuctionDateChangeEvent(Date[] dateArr, Intent intent2) {
        this.dates = dateArr;
        this.intent = intent2;
    }
}
