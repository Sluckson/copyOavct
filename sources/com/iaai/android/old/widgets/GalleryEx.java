package com.iaai.android.old.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Gallery;

public class GalleryEx extends Gallery {
    private float initialX;
    private float initialY;
    private final int slop;

    public GalleryEx(Context context) {
        super(context);
        this.slop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public GalleryEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.slop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public GalleryEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.slop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private boolean isScrollingLeft(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent2.getX() > motionEvent.getX();
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        onKeyDown(isScrollingLeft(motionEvent, motionEvent2) ? 21 : 22, (KeyEvent) null);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            onTouchEvent(motionEvent);
            this.initialX = motionEvent.getX();
            this.initialY = motionEvent.getY();
            return false;
        } else if (action != 2) {
            return false;
        } else {
            float abs = Math.abs(motionEvent.getX() - this.initialX);
            float abs2 = Math.abs(motionEvent.getY() - this.initialY);
            if ((abs2 <= abs || abs2 <= ((float) this.slop)) && abs > ((float) this.slop)) {
                return true;
            }
            return false;
        }
    }
}
