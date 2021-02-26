package com.googlecode.android.widgets.DateSlider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.googlecode.android.widgets.DateSlider.labeler.Labeler;
import com.googlecode.android.widgets.DateSlider.timeview.TimeView;
import com.iaai.android.C2723R;

public class ScrollLayout extends LinearLayout {
    private static String TAG = "SCROLLLAYOUT";
    private int childrenWidth;
    private long currentTime = System.currentTimeMillis();
    private Drawable leftShadow;
    private OnScrollListener listener;
    private TimeView mCenterView;
    private boolean mDragMode;
    private int mInitialOffset;
    private Labeler mLabeler;
    private int mLastScroll;
    private int mLastX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScrollX;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;
    private long maxTime = -1;
    private long minTime = -1;
    private int minuteInterval = 1;
    private int objHeight;
    private int objWidth;
    private Drawable rightShadow;

    public interface OnScrollListener {
        void onScroll(long j);
    }

    public ScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.rightShadow = getContext().getResources().getDrawable(C2723R.C2725drawable.right_shadow);
        this.leftShadow = getContext().getResources().getDrawable(C2723R.C2725drawable.left_shadow);
        this.mScroller = new Scroller(getContext());
        setGravity(16);
        setOrientation(0);
        this.mMinimumVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = (int) (getContext().getResources().getDisplayMetrics().density * 2000.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2723R.styleable.ScrollLayout, 0, 0);
        String nonResourceString = obtainStyledAttributes.getNonResourceString(2);
        if (nonResourceString != null) {
            String string = obtainStyledAttributes.getString(3);
            if (string != null) {
                try {
                    this.mLabeler = (Labeler) Class.forName(nonResourceString).getConstructor(new Class[]{String.class}).newInstance(new Object[]{string});
                    this.objWidth = obtainStyledAttributes.getDimensionPixelSize(1, this.mLabeler.getPreferredViewWidth(context));
                    this.objHeight = obtainStyledAttributes.getDimensionPixelSize(0, this.mLabeler.getPreferredViewHeight(context));
                    obtainStyledAttributes.recycle();
                } catch (Exception e) {
                    throw new RuntimeException("Failed to construct labeler at " + obtainStyledAttributes.getPositionDescription(), e);
                }
            } else {
                throw new RuntimeException("Must specify labelerFormat at " + obtainStyledAttributes.getPositionDescription());
            }
        } else {
            throw new RuntimeException("Must specify labeler class at " + obtainStyledAttributes.getPositionDescription());
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int width = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        int i = this.objWidth;
        int i2 = width / i;
        if (width % i != 0) {
            i2++;
        }
        if (i2 % 2 == 0) {
            i2++;
        }
        int i3 = i2 / 2;
        removeAllViews();
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= i2) {
                break;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.objWidth, this.objHeight);
            Labeler labeler = this.mLabeler;
            Context context = getContext();
            if (i4 != i3) {
                z = false;
            }
            addView((View) labeler.createView(context, z), layoutParams);
            i4++;
        }
        this.mCenterView = (TimeView) getChildAt(i3);
        this.mCenterView.setVals(this.mLabeler.getElem(this.currentTime));
        Log.v(TAG, "mCenter: " + this.mCenterView.getTimeText() + " minInterval " + this.minuteInterval);
        for (int i5 = i3 + 1; i5 < i2; i5++) {
            ((TimeView) getChildAt(i5)).setVals(this.mLabeler.add(((TimeView) getChildAt(i5 - 1)).getEndTime(), 1));
        }
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            ((TimeView) getChildAt(i6)).setVals(this.mLabeler.add(((TimeView) getChildAt(i6 + 1)).getEndTime(), -1));
        }
        this.childrenWidth = i2 * this.objWidth;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mInitialOffset = (this.childrenWidth - i) / 2;
        super.scrollTo(this.mInitialOffset, 0);
        int i5 = this.mInitialOffset;
        this.mScrollX = i5;
        this.mLastScroll = i5;
        setTime(this.currentTime, 0);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.rightShadow.setBounds((getScrollX() + getWidth()) - 50, 0, getWidth() + getScrollX() + 1, getHeight());
        this.rightShadow.draw(canvas);
        this.leftShadow.setBounds(getScrollX(), 0, getScrollX() + 50, getHeight());
        this.leftShadow.draw(canvas);
    }

    public void setMinTime(long j) {
        this.minTime = j;
    }

    public void setMaxTime(long j) {
        this.maxTime = j;
    }

    public void setTime(long j) {
        setTime(j, 0);
    }

    public void setMinuteInterval(int i) {
        this.minuteInterval = i;
        this.mLabeler.setMinuteInterval(i);
        if (i > 1) {
            int childCount = getChildCount() / 2;
            for (int i2 = childCount + 1; i2 < getChildCount(); i2++) {
                ((TimeView) getChildAt(i2)).setVals(this.mLabeler.add(((TimeView) getChildAt(i2 - 1)).getEndTime(), 1));
            }
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                ((TimeView) getChildAt(i3)).setVals(this.mLabeler.add(((TimeView) getChildAt(i3 + 1)).getEndTime(), -1));
            }
        }
    }

    private void setTime(long j, int i) {
        this.currentTime = j;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        TimeView timeView = (TimeView) getChildAt(getChildCount() / 2);
        if (i <= 2 && (timeView.getStartTime() > j || timeView.getEndTime() < j)) {
            double endTime = (double) (timeView.getEndTime() - timeView.getStartTime());
            moveElements(-((int) Math.round((((double) j) - (((double) timeView.getStartTime()) + (endTime / 2.0d))) / endTime)));
            setTime(j, i + 1);
        } else if (i > 2) {
            Log.d(TAG, String.format("time: %d, start: %d, end: %d", new Object[]{Long.valueOf(j), Long.valueOf(timeView.getStartTime()), Long.valueOf(timeView.getEndTime())}));
        } else {
            this.mScrollX -= (int) Math.round(((((((double) getWidth()) / 2.0d) - ((double) (((getChildCount() / 2) * this.objWidth) - getScrollX()))) / ((double) this.objWidth)) - (((double) (j - timeView.getStartTime())) / ((double) (timeView.getEndTime() - timeView.getStartTime())))) * ((double) this.objWidth));
            reScrollTo(this.mScrollX, 0, false);
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.mScrollX = this.mScroller.getCurrX();
            reScrollTo(this.mScrollX, 0, true);
            postInvalidate();
        }
    }

    public void scrollTo(int i, int i2) {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        reScrollTo(i, i2, true);
    }

    /* access modifiers changed from: protected */
    public void reScrollTo(int i, int i2, boolean z) {
        int i3 = i;
        if (z) {
            Log.d(TAG, String.format("scroll to " + i3, new Object[0]));
        }
        int scrollX = getScrollX();
        int i4 = i3 - this.mLastScroll;
        if (this.minTime != -1 && z && i4 < 0) {
            int i5 = this.objWidth;
            long startTime = (long) (((double) this.mCenterView.getStartTime()) + (((((((double) getWidth()) / 2.0d) - ((double) (((getChildCount() / 2) * i5) - scrollX))) / ((double) i5)) - (((double) (-i4)) / ((double) this.objWidth))) * ((double) (this.mCenterView.getEndTime() - this.mCenterView.getStartTime()))));
            long j = this.minTime;
            if (startTime < j) {
                long j2 = this.currentTime;
                int round = i4 - ((int) Math.round((((double) (j2 - j)) / ((double) (j2 - startTime))) * ((double) i4)));
                this.mScrollX -= round;
                i3 -= round;
                i4 -= round;
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
            }
        } else if (this.maxTime != -1 && z && i4 > 0) {
            int i6 = this.objWidth;
            long startTime2 = (long) (((double) this.mCenterView.getStartTime()) + (((((((double) getWidth()) / 2.0d) - ((double) (((getChildCount() / 2) * i6) - scrollX))) / ((double) i6)) - (((double) (-i4)) / ((double) this.objWidth))) * ((double) (this.mCenterView.getEndTime() - this.mCenterView.getStartTime()))));
            long j3 = this.maxTime;
            if (startTime2 > j3) {
                long j4 = this.currentTime;
                int round2 = i4 - ((int) Math.round((((double) (j4 - j3)) / ((double) (j4 - startTime2))) * ((double) i4)));
                this.mScrollX -= round2;
                i3 -= round2;
                i4 -= round2;
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
            }
        }
        if (getChildCount() > 0) {
            scrollX += i4;
            int i7 = this.mInitialOffset;
            int i8 = scrollX - i7;
            int i9 = this.objWidth;
            if (i8 > i9 / 2) {
                int i10 = scrollX - i7;
                moveElements(-(((i9 / 2) + i10) / i9));
                int i11 = this.objWidth;
                scrollX = (((i10 - (i11 / 2)) % i11) + this.mInitialOffset) - (i11 / 2);
            } else if (i7 - scrollX > i9 / 2) {
                moveElements(((i7 - scrollX) + (i9 / 2)) / i9);
                int i12 = this.mInitialOffset;
                int i13 = this.objWidth;
                scrollX = ((i13 / 2) + i12) - (((i12 + (i13 / 2)) - scrollX) % i13);
            }
        }
        int i14 = scrollX;
        super.scrollTo(i14, i2);
        if (this.listener != null && z) {
            int i15 = this.objWidth;
            this.currentTime = (long) (((double) this.mCenterView.getStartTime()) + (((double) (this.mCenterView.getEndTime() - this.mCenterView.getStartTime())) * (((((double) getWidth()) / 2.0d) - ((double) (((getChildCount() / 2) * i15) - i14))) / ((double) i15))));
            if (z) {
                Log.d(TAG, String.format("real time " + this.currentTime, new Object[0]));
            }
            if (z) {
                Log.d(TAG, String.format("", new Object[0]));
            }
            this.listener.onScroll(this.currentTime);
        }
        this.mLastScroll = i3;
    }

    /* access modifiers changed from: protected */
    public void moveElements(int i) {
        int i2;
        int i3;
        if (i != 0) {
            int i4 = -1;
            if (i < 0) {
                i4 = getChildCount();
                i3 = 0;
                i2 = 1;
            } else {
                i3 = getChildCount() - 1;
                i2 = -1;
            }
            while (i3 != i4) {
                TimeView timeView = (TimeView) getChildAt(i3);
                int i5 = i3 - i;
                if (i5 < 0 || i5 >= getChildCount()) {
                    timeView.setVals(this.mLabeler.add(timeView.getEndTime(), -i));
                } else {
                    timeView.setVals((TimeView) getChildAt(i5));
                }
                if (this.minTime == -1 || timeView.getEndTime() >= this.minTime) {
                    if (this.maxTime == -1 || timeView.getStartTime() <= this.maxTime) {
                        if (timeView.isOutOfBounds()) {
                            timeView.setOutOfBounds(false);
                        }
                    } else if (!timeView.isOutOfBounds()) {
                        timeView.setOutOfBounds(true);
                    }
                } else if (!timeView.isOutOfBounds()) {
                    timeView.setOutOfBounds(true);
                }
                i3 += i2;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (action == 0) {
            this.mDragMode = true;
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
        }
        if (!this.mDragMode) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (action != 0) {
            if (action == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000);
                int min = (int) Math.min(velocityTracker.getXVelocity(), (float) this.mMaximumVelocity);
                if (getChildCount() > 0 && Math.abs(min) > this.mMinimumVelocity) {
                    fling(-min);
                }
            } else if (action == 2) {
                this.mScrollX += this.mLastX - x;
                reScrollTo(this.mScrollX, 0, true);
            }
            this.mDragMode = false;
        }
        this.mLastX = x;
        return true;
    }

    private void fling(int i) {
        if (getChildCount() > 0) {
            this.mScroller.fling(this.mScrollX, 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            invalidate();
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.listener = onScrollListener;
    }
}
