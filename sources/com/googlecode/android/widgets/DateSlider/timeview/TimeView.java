package com.googlecode.android.widgets.DateSlider.timeview;

import com.googlecode.android.widgets.DateSlider.TimeObject;

public interface TimeView {
    long getEndTime();

    long getStartTime();

    String getTimeText();

    boolean isOutOfBounds();

    void setOutOfBounds(boolean z);

    void setVals(TimeObject timeObject);

    void setVals(TimeView timeView);
}
