package com.googlecode.android.widgets.DateSlider.labeler;

import android.content.Context;
import com.googlecode.android.widgets.DateSlider.timeview.TimeLayoutView;
import com.googlecode.android.widgets.DateSlider.timeview.TimeView;

public class MonthYearLabeler extends MonthLabeler {
    public MonthYearLabeler(String str) {
        super(str);
    }

    public TimeView createView(Context context, boolean z) {
        return new TimeLayoutView(context, z, 25, 8, 0.95f);
    }
}
