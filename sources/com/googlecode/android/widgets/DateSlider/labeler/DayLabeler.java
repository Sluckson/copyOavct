package com.googlecode.android.widgets.DateSlider.labeler;

import com.googlecode.android.widgets.DateSlider.TimeObject;
import java.util.Calendar;

public class DayLabeler extends Labeler {
    private final String mFormatString;

    public DayLabeler(String str) {
        super(150, 60);
        this.mFormatString = str;
    }

    public TimeObject add(long j, int i) {
        return timeObjectfromCalendar(Util.addDays(j, i));
    }

    /* access modifiers changed from: protected */
    public TimeObject timeObjectfromCalendar(Calendar calendar) {
        return Util.getDay(calendar, this.mFormatString);
    }
}
