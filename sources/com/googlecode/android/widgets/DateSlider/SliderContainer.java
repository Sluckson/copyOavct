package com.googlecode.android.widgets.DateSlider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.googlecode.android.widgets.DateSlider.ScrollLayout;
import java.util.Calendar;

public class SliderContainer extends LinearLayout {
    private OnTimeChangeListener mOnTimeChangeListener;
    /* access modifiers changed from: private */
    public Calendar mTime = null;
    private int minuteInterval;

    public interface OnTimeChangeListener {
        void onTimeChange(Calendar calendar);
    }

    public SliderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ScrollLayout) {
                final ScrollLayout scrollLayout = (ScrollLayout) childAt;
                scrollLayout.setOnScrollListener(new ScrollLayout.OnScrollListener() {
                    public void onScroll(long j) {
                        SliderContainer.this.mTime.setTimeInMillis(j);
                        SliderContainer.this.arrangeScrollers(scrollLayout);
                    }
                });
            }
        }
    }

    public void setTime(Calendar calendar) {
        this.mTime = Calendar.getInstance(calendar.getTimeZone());
        this.mTime.setTimeInMillis(calendar.getTimeInMillis());
        arrangeScrollers((ScrollLayout) null);
    }

    public Calendar getTime() {
        return this.mTime;
    }

    public void setMinTime(Calendar calendar) {
        if (this.mTime != null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ScrollLayout) {
                    ((ScrollLayout) childAt).setMinTime(calendar.getTimeInMillis());
                }
            }
            return;
        }
        throw new RuntimeException("You have to call setTime before setting a MinimumTime!");
    }

    public void setMaxTime(Calendar calendar) {
        if (this.mTime != null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ScrollLayout) {
                    ((ScrollLayout) childAt).setMaxTime(calendar.getTimeInMillis());
                }
            }
            return;
        }
        throw new RuntimeException("You have to call setTime before setting a MinimumTime!");
    }

    public void setMinuteInterval(int i) {
        this.minuteInterval = i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ScrollLayout) {
                ((ScrollLayout) childAt).setMinuteInterval(i);
            }
        }
    }

    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener) {
        this.mOnTimeChangeListener = onTimeChangeListener;
    }

    /* access modifiers changed from: private */
    public void arrangeScrollers(ScrollLayout scrollLayout) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != scrollLayout && (childAt instanceof ScrollLayout)) {
                ((ScrollLayout) childAt).setTime(this.mTime.getTimeInMillis());
            }
        }
        if (this.mOnTimeChangeListener != null) {
            if (this.minuteInterval > 1) {
                int i2 = this.mTime.get(12);
                int i3 = this.minuteInterval;
                this.mTime.set(12, (i2 / i3) * i3);
            }
            this.mOnTimeChangeListener.onTimeChange(this.mTime);
        }
    }
}
