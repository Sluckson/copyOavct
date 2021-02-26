package com.googlecode.android.widgets.DateSlider.timeview;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.googlecode.android.widgets.DateSlider.TimeObject;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class TimeLayoutView extends LinearLayout implements TimeView {
    protected TextView bottomView;
    protected long endTime;
    protected boolean isCenter = false;
    protected boolean isOutOfBounds = false;
    protected long startTime;
    protected String text;
    protected TextView topView;

    public TimeLayoutView(Context context, boolean z, int i, int i2, float f) {
        super(context);
        setupView(context, z, i, i2, f);
    }

    /* access modifiers changed from: protected */
    public void setupView(Context context, boolean z, int i, int i2, float f) {
        setOrientation(1);
        this.topView = new TextView(context);
        this.topView.setGravity(81);
        this.topView.setTextSize(1, (float) i);
        this.bottomView = new TextView(context);
        this.bottomView.setGravity(49);
        this.bottomView.setTextSize(1, (float) i2);
        this.topView.setLineSpacing(0.0f, f);
        if (z) {
            this.isCenter = true;
            this.topView.setTypeface(Typeface.DEFAULT_BOLD);
            this.topView.setTextColor(-13421773);
            this.bottomView.setTypeface(Typeface.DEFAULT_BOLD);
            this.bottomView.setTextColor(-12303292);
            this.topView.setPadding(0, 5 - ((int) (((double) i) / 15.0d)), 0, 0);
        } else {
            this.topView.setPadding(0, 5, 0, 0);
            this.topView.setTextColor(-10066330);
            this.bottomView.setTextColor(-10066330);
        }
        addView(this.topView);
        addView(this.bottomView);
    }

    public void setVals(TimeObject timeObject) {
        this.text = timeObject.text.toString();
        setText();
        this.startTime = timeObject.startTime;
        this.endTime = timeObject.endTime;
    }

    public void setVals(TimeView timeView) {
        this.text = timeView.getTimeText().toString();
        setText();
        this.startTime = timeView.getStartTime();
        this.endTime = timeView.getEndTime();
    }

    /* access modifiers changed from: protected */
    public void setText() {
        String[] split = this.text.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        this.topView.setText(split[0]);
        this.bottomView.setText(split[1]);
    }

    public String getTimeText() {
        return this.text;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public boolean isOutOfBounds() {
        return this.isOutOfBounds;
    }

    public void setOutOfBounds(boolean z) {
        if (z && !this.isOutOfBounds) {
            this.topView.setTextColor(1147561574);
            this.bottomView.setTextColor(1147561574);
        } else if (!z && this.isOutOfBounds) {
            this.topView.setTextColor(-10066330);
            this.bottomView.setTextColor(-10066330);
        }
        this.isOutOfBounds = z;
    }
}
