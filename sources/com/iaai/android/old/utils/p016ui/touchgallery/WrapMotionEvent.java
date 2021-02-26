package com.iaai.android.old.utils.p016ui.touchgallery;

import android.view.MotionEvent;

/* renamed from: com.iaai.android.old.utils.ui.touchgallery.WrapMotionEvent */
public class WrapMotionEvent {
    protected MotionEvent event;

    public int getPointerCount() {
        return 1;
    }

    protected WrapMotionEvent(MotionEvent motionEvent) {
        this.event = motionEvent;
    }

    public static WrapMotionEvent wrap(MotionEvent motionEvent) {
        try {
            return new EclairMotionEvent(motionEvent);
        } catch (VerifyError unused) {
            return new WrapMotionEvent(motionEvent);
        }
    }

    public int getAction() {
        return this.event.getAction();
    }

    public float getX() {
        return this.event.getX();
    }

    public float getX(int i) {
        verifyPointerIndex(i);
        return getX();
    }

    public float getY() {
        return this.event.getY();
    }

    public float getY(int i) {
        verifyPointerIndex(i);
        return getY();
    }

    public int getPointerId(int i) {
        verifyPointerIndex(i);
        return 0;
    }

    private void verifyPointerIndex(int i) {
        if (i > 0) {
            throw new IllegalArgumentException("Invalid pointer index for Donut/Cupcake");
        }
    }
}
