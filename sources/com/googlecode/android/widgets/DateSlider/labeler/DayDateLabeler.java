package com.googlecode.android.widgets.DateSlider.labeler;

import android.content.Context;
import com.googlecode.android.widgets.DateSlider.timeview.DayTimeLayoutView;
import com.googlecode.android.widgets.DateSlider.timeview.TimeView;

public class DayDateLabeler extends DayLabeler {
    public DayDateLabeler(String str) {
        super(str);
    }

    public TimeView createView(Context context, boolean z) {
        return new DayTimeLayoutView(context, z, 30, 8, 0.8f);
    }
}
