package com.synnapps.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

public class CarouselViewPager extends ViewPager {
    private ImageClickListener imageClickListener;
    private CarouselViewPagerScroller mScroller = null;
    private float newX = 0.0f;
    private float oldX = 0.0f;
    private float sens = 5.0f;

    public void setImageClickListener(ImageClickListener imageClickListener2) {
        this.imageClickListener = imageClickListener2;
    }

    public CarouselViewPager(Context context) {
        super(context);
        postInitViewPager();
    }

    public CarouselViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        postInitViewPager();
    }

    private void postInitViewPager() {
        Class<ViewPager> cls = ViewPager.class;
        try {
            Field declaredField = cls.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            this.mScroller = new CarouselViewPagerScroller(getContext(), (Interpolator) declaredField2.get((Object) null));
            declaredField.set(this, this.mScroller);
        } catch (Exception unused) {
        }
    }

    public void setTransitionVelocity(int i) {
        this.mScroller.setmScrollDuration(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldX = motionEvent.getX();
        } else if (action == 1) {
            this.newX = motionEvent.getX();
            if (Math.abs(this.oldX - this.newX) < this.sens) {
                ImageClickListener imageClickListener2 = this.imageClickListener;
                if (imageClickListener2 != null) {
                    imageClickListener2.onClick(getCurrentItem());
                }
                return true;
            }
            this.oldX = 0.0f;
            this.newX = 0.0f;
        }
        return super.onTouchEvent(motionEvent);
    }
}
