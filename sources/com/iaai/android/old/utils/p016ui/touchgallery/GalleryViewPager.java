package com.iaai.android.old.utils.p016ui.touchgallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* renamed from: com.iaai.android.old.utils.ui.touchgallery.GalleryViewPager */
public class GalleryViewPager extends ViewPager {
    private static final int CLICK_ACTION_THRESHHOLD = 5;
    PointF last;
    public TouchImageView mCurrentView;
    protected OnItemClickListener mOnItemClickListener;
    private float startX;
    private float startY;

    /* renamed from: com.iaai.android.old.utils.ui.touchgallery.GalleryViewPager$OnItemClickListener */
    public interface OnItemClickListener {
        void onItemClicked(View view, int i);
    }

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(5)
    private float[] handleMotionEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.last = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return null;
        } else if (action != 1 && action != 2) {
            return null;
        } else {
            PointF pointF = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return new float[]{pointF.x - this.last.x, pointF.y - this.last.y};
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 1) {
            if (isAClick(this.startX, motionEvent.getX(), this.startY, motionEvent.getY())) {
                OnItemClickListener onItemClickListener = this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClicked(this.mCurrentView, getCurrentItem());
                }
            } else {
                super.onTouchEvent(motionEvent);
            }
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
        }
        float[] handleMotionEvent = handleMotionEvent(motionEvent);
        if (this.mCurrentView.pagerCanScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (handleMotionEvent != null && this.mCurrentView.onRightSide && handleMotionEvent[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (handleMotionEvent != null && this.mCurrentView.onLeftSide && handleMotionEvent[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (handleMotionEvent != null || (!this.mCurrentView.onLeftSide && !this.mCurrentView.onRightSide)) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 1) {
            if (isAClick(this.startX, motionEvent.getX(), this.startY, motionEvent.getY())) {
                OnItemClickListener onItemClickListener = this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClicked(this.mCurrentView, getCurrentItem());
                }
            } else {
                super.onInterceptTouchEvent(motionEvent);
            }
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
        }
        float[] handleMotionEvent = handleMotionEvent(motionEvent);
        if (this.mCurrentView.pagerCanScroll()) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            if (handleMotionEvent != null && this.mCurrentView.onRightSide && handleMotionEvent[0] < 0.0f) {
                try {
                    return super.onInterceptTouchEvent(motionEvent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (handleMotionEvent != null && this.mCurrentView.onLeftSide && handleMotionEvent[0] > 0.0f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (handleMotionEvent != null || (!this.mCurrentView.onLeftSide && !this.mCurrentView.onRightSide)) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    private boolean isAClick(float f, float f2, float f3, float f4) {
        return Math.abs(f - f2) <= 5.0f && Math.abs(f3 - f4) <= 5.0f;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
