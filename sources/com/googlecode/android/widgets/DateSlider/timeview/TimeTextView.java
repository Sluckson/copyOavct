package com.googlecode.android.widgets.DateSlider.timeview;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.googlecode.android.widgets.DateSlider.TimeObject;

public class TimeTextView extends TextView implements TimeView {
    protected long endTime;
    protected boolean isOutOfBounds = false;
    protected long startTime;

    public TimeTextView(Context context, boolean z, int i) {
        super(context);
        setupView(z, i);
    }

    /* access modifiers changed from: protected */
    public void setupView(boolean z, int i) {
        setGravity(17);
        setTextSize(1, (float) i);
        if (z) {
            setTypeface(Typeface.DEFAULT_BOLD);
            setTextColor(-13421773);
            return;
        }
        setTextColor(-10066330);
    }

    public void setVals(TimeObject timeObject) {
        setText(timeObject.text);
        this.startTime = timeObject.startTime;
        this.endTime = timeObject.endTime;
    }

    public void setVals(TimeView timeView) {
        setText(timeView.getTimeText());
        this.startTime = timeView.getStartTime();
        this.endTime = timeView.getEndTime();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getTimeText() {
        return getText().toString();
    }

    public boolean isOutOfBounds() {
        return this.isOutOfBounds;
    }

    public void setOutOfBounds(boolean z) {
        if (z && !this.isOutOfBounds) {
            setTextColor(1147561574);
        } else if (!z && this.isOutOfBounds) {
            setTextColor(-10066330);
        }
        this.isOutOfBounds = z;
    }
}
