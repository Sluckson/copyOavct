package com.googlecode.android.widgets.DateSlider.labeler;

import com.googlecode.android.widgets.DateSlider.TimeObject;
import java.util.Calendar;

public class MonthLabeler extends Labeler {
    private final String mFormatString;

    public MonthLabeler(String str) {
        super(180, 60);
        this.mFormatString = str;
    }

    public TimeObject add(long j, int i) {
        return timeObjectfromCalendar(Util.addMonths(j, i));
    }

    /* access modifiers changed from: protected */
    public TimeObject timeObjectfromCalendar(Calendar calendar) {
        return Util.getMonth(calendar, this.mFormatString);
    }
}
