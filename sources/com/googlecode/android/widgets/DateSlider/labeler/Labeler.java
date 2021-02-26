package com.googlecode.android.widgets.DateSlider.labeler;

import android.content.Context;
import com.googlecode.android.widgets.DateSlider.TimeObject;
import com.googlecode.android.widgets.DateSlider.timeview.TimeTextView;
import com.googlecode.android.widgets.DateSlider.timeview.TimeView;
import java.util.Calendar;

public abstract class Labeler {
    protected int minuteInterval = 1;
    private final int viewHeightDP;
    private final int viewWidthDP;

    public abstract TimeObject add(long j, int i);

    /* access modifiers changed from: protected */
    public abstract TimeObject timeObjectfromCalendar(Calendar calendar);

    public Labeler(int i, int i2) {
        this.viewWidthDP = i;
        this.viewHeightDP = i2;
    }

    public TimeObject getElem(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return timeObjectfromCalendar(instance);
    }

    public TimeView createView(Context context, boolean z) {
        return new TimeTextView(context, z, 25);
    }

    public int getPreferredViewWidth(Context context) {
        return (int) (((float) this.viewWidthDP) * context.getResources().getDisplayMetrics().density);
    }

    public int getPreferredViewHeight(Context context) {
        return (int) (((float) this.viewHeightDP) * context.getResources().getDisplayMetrics().density);
    }

    public void setMinuteInterval(int i) {
        this.minuteInterval = i;
    }
}
