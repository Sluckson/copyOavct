package com.googlecode.android.widgets.DateSlider;

public class TimeObject {
    public final long endTime;
    public final long startTime;
    public final CharSequence text;

    public TimeObject(CharSequence charSequence, long j, long j2) {
        this.text = charSequence;
        this.startTime = j;
        this.endTime = j2;
    }
}
