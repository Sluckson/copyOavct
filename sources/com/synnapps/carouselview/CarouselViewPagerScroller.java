package com.synnapps.carouselview;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.logging.type.LogSeverity;

public class CarouselViewPagerScroller extends Scroller {
    private int mScrollDuration = LogSeverity.CRITICAL_VALUE;

    public CarouselViewPagerScroller(Context context) {
        super(context);
    }

    public CarouselViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public int getmScrollDuration() {
        return this.mScrollDuration;
    }

    public void setmScrollDuration(int i) {
        this.mScrollDuration = i;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.mScrollDuration);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.mScrollDuration);
    }
}
