package com.googlecode.android.widgets.DateSlider.timeview;

import android.content.Context;
import com.googlecode.android.widgets.DateSlider.TimeObject;
import java.util.Calendar;

public class DayTimeLayoutView extends TimeLayoutView {
    protected boolean isSunday = false;

    public DayTimeLayoutView(Context context, boolean z, int i, int i2, float f) {
        super(context, z, i, i2, f);
    }

    public void setVals(TimeObject timeObject) {
        super.setVals(timeObject);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(timeObject.endTime);
        if (instance.get(7) == 1 && !this.isSunday) {
            this.isSunday = true;
            colorMeSunday();
        } else if (this.isSunday && instance.get(7) != 1) {
            this.isSunday = false;
            colorMeWorkday();
        }
    }

    /* access modifiers changed from: protected */
    public void colorMeSunday() {
        if (!this.isOutOfBounds) {
            if (this.isCenter) {
                this.bottomView.setTextColor(-8965325);
                this.topView.setTextColor(-11193549);
                return;
            }
            this.bottomView.setTextColor(-12312030);
            this.topView.setTextColor(-11193549);
        }
    }

    /* access modifiers changed from: protected */
    public void colorMeWorkday() {
        if (!this.isOutOfBounds) {
            if (this.isCenter) {
                this.topView.setTextColor(-13421773);
                this.bottomView.setTextColor(-12303292);
                return;
            }
            this.topView.setTextColor(-10066330);
            this.bottomView.setTextColor(-10066330);
        }
    }

    public void setVals(TimeView timeView) {
        super.setVals(timeView);
        DayTimeLayoutView dayTimeLayoutView = (DayTimeLayoutView) timeView;
        if (dayTimeLayoutView.isSunday && !this.isSunday) {
            this.isSunday = true;
            colorMeSunday();
        } else if (this.isSunday && !dayTimeLayoutView.isSunday) {
            this.isSunday = false;
            colorMeWorkday();
        }
    }
}
