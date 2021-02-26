package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

public class SwipeDismissTouchListener implements View.OnTouchListener {
    private long mAnimationTime;
    /* access modifiers changed from: private */
    public DismissCallbacks mDismissCallbacks;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    /* access modifiers changed from: private */
    public Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    /* access modifiers changed from: private */
    public View mView;
    private int mViewWidth = 1;

    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = (long) view.getContext().getResources().getInteger(17694720);
        this.mView = view;
        this.mToken = obj;
        this.mDismissCallbacks = dismissCallbacks;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013f, code lost:
        if (r9.mVelocityTracker.getXVelocity() > 0.0f) goto L_0x0144;
     */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            float r10 = r9.mTranslationX
            r0 = 0
            r11.offsetLocation(r10, r0)
            int r10 = r9.mViewWidth
            r1 = 2
            if (r10 >= r1) goto L_0x0013
            android.view.View r10 = r9.mView
            int r10 = r10.getWidth()
            r9.mViewWidth = r10
        L_0x0013:
            int r10 = r11.getActionMasked()
            r2 = 0
            if (r10 == 0) goto L_0x0163
            r3 = 0
            r4 = 1
            if (r10 == r4) goto L_0x00c5
            r5 = 3
            if (r10 == r1) goto L_0x003f
            if (r10 == r5) goto L_0x0025
            goto L_0x0162
        L_0x0025:
            android.view.VelocityTracker r10 = r9.mVelocityTracker
            if (r10 != 0) goto L_0x002b
            goto L_0x0162
        L_0x002b:
            r9.startCancelAnimation()
            android.view.VelocityTracker r10 = r9.mVelocityTracker
            r10.recycle()
            r9.mVelocityTracker = r3
            r9.mTranslationX = r0
            r9.mDownX = r0
            r9.mDownY = r0
            r9.mSwiping = r2
            goto L_0x0162
        L_0x003f:
            android.view.VelocityTracker r10 = r9.mVelocityTracker
            if (r10 != 0) goto L_0x0045
            goto L_0x0162
        L_0x0045:
            r10.addMovement(r11)
            float r10 = r11.getRawX()
            float r1 = r9.mDownX
            float r10 = r10 - r1
            float r1 = r11.getRawY()
            float r3 = r9.mDownY
            float r1 = r1 - r3
            float r3 = java.lang.Math.abs(r10)
            int r6 = r9.mSlop
            float r6 = (float) r6
            r7 = 1073741824(0x40000000, float:2.0)
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x009d
            float r1 = java.lang.Math.abs(r1)
            float r3 = java.lang.Math.abs(r10)
            float r3 = r3 / r7
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x009d
            r9.mSwiping = r4
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0079
            int r1 = r9.mSlop
            goto L_0x007c
        L_0x0079:
            int r1 = r9.mSlop
            int r1 = -r1
        L_0x007c:
            r9.mSwipingSlop = r1
            android.view.View r1 = r9.mView
            android.view.ViewParent r1 = r1.getParent()
            r1.requestDisallowInterceptTouchEvent(r4)
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r11)
            int r11 = r11.getActionIndex()
            int r11 = r11 << 8
            r11 = r11 | r5
            r1.setAction(r11)
            android.view.View r11 = r9.mView
            r11.onTouchEvent(r1)
            r1.recycle()
        L_0x009d:
            boolean r11 = r9.mSwiping
            if (r11 == 0) goto L_0x0162
            r9.mTranslationX = r10
            int r11 = r9.mSwipingSlop
            float r11 = (float) r11
            float r11 = r10 - r11
            r9.setTranslationX(r11)
            float r10 = java.lang.Math.abs(r10)
            float r10 = r10 * r7
            int r11 = r9.mViewWidth
            float r11 = (float) r11
            float r10 = r10 / r11
            r11 = 1065353216(0x3f800000, float:1.0)
            float r10 = r11 - r10
            float r10 = java.lang.Math.min(r11, r10)
            float r10 = java.lang.Math.max(r0, r10)
            r9.setAlpha(r10)
            return r4
        L_0x00c5:
            android.view.VelocityTracker r10 = r9.mVelocityTracker
            if (r10 != 0) goto L_0x00cb
            goto L_0x0162
        L_0x00cb:
            float r10 = r11.getRawX()
            float r5 = r9.mDownX
            float r10 = r10 - r5
            android.view.VelocityTracker r5 = r9.mVelocityTracker
            r5.addMovement(r11)
            android.view.VelocityTracker r11 = r9.mVelocityTracker
            r5 = 1000(0x3e8, float:1.401E-42)
            r11.computeCurrentVelocity(r5)
            android.view.VelocityTracker r11 = r9.mVelocityTracker
            float r11 = r11.getXVelocity()
            float r5 = java.lang.Math.abs(r11)
            android.view.VelocityTracker r6 = r9.mVelocityTracker
            float r6 = r6.getYVelocity()
            float r6 = java.lang.Math.abs(r6)
            float r7 = java.lang.Math.abs(r10)
            int r8 = r9.mViewWidth
            int r8 = r8 / r1
            float r1 = (float) r8
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x010c
            boolean r1 = r9.mSwiping
            if (r1 == 0) goto L_0x010c
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 <= 0) goto L_0x0108
            r10 = 1
            goto L_0x0109
        L_0x0108:
            r10 = 0
        L_0x0109:
            r4 = r10
            r10 = 1
            goto L_0x0144
        L_0x010c:
            int r1 = r9.mMinFlingVelocity
            float r1 = (float) r1
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x0142
            int r1 = r9.mMaxFlingVelocity
            float r1 = (float) r1
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0142
            int r1 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x0142
            if (r1 >= 0) goto L_0x0142
            boolean r1 = r9.mSwiping
            if (r1 == 0) goto L_0x0142
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 >= 0) goto L_0x012a
            r11 = 1
            goto L_0x012b
        L_0x012a:
            r11 = 0
        L_0x012b:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 >= 0) goto L_0x0131
            r10 = 1
            goto L_0x0132
        L_0x0131:
            r10 = 0
        L_0x0132:
            if (r11 != r10) goto L_0x0136
            r10 = 1
            goto L_0x0137
        L_0x0136:
            r10 = 0
        L_0x0137:
            android.view.VelocityTracker r11 = r9.mVelocityTracker
            float r11 = r11.getXVelocity()
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 <= 0) goto L_0x0143
            goto L_0x0144
        L_0x0142:
            r10 = 0
        L_0x0143:
            r4 = 0
        L_0x0144:
            if (r10 == 0) goto L_0x014a
            r9.startDismissAnimation(r4)
            goto L_0x0151
        L_0x014a:
            boolean r10 = r9.mSwiping
            if (r10 == 0) goto L_0x0151
            r9.startCancelAnimation()
        L_0x0151:
            android.view.VelocityTracker r10 = r9.mVelocityTracker
            if (r10 == 0) goto L_0x0158
            r10.recycle()
        L_0x0158:
            r9.mVelocityTracker = r3
            r9.mTranslationX = r0
            r9.mDownX = r0
            r9.mDownY = r0
            r9.mSwiping = r2
        L_0x0162:
            return r2
        L_0x0163:
            float r10 = r11.getRawX()
            r9.mDownX = r10
            float r10 = r11.getRawY()
            r9.mDownY = r10
            com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener$DismissCallbacks r10 = r9.mDismissCallbacks
            java.lang.Object r0 = r9.mToken
            boolean r10 = r10.canDismiss(r0)
            if (r10 == 0) goto L_0x0184
            android.view.VelocityTracker r10 = android.view.VelocityTracker.obtain()
            r9.mVelocityTracker = r10
            android.view.VelocityTracker r10 = r9.mVelocityTracker
            r10.addMovement(r11)
        L_0x0184:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void setTranslationX(float f) {
        this.mView.setTranslationX(f);
    }

    /* access modifiers changed from: protected */
    public float getTranslationX() {
        return this.mView.getTranslationX();
    }

    /* access modifiers changed from: protected */
    public void setAlpha(float f) {
        this.mView.setAlpha(f);
    }

    /* access modifiers changed from: protected */
    public void startDismissAnimation(boolean z) {
        animateTo((float) (z ? this.mViewWidth : -this.mViewWidth), 0.0f, new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.performDismiss();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void startCancelAnimation() {
        animateTo(0.0f, 1.0f, (AnimatorListenerAdapter) null);
    }

    private void animateTo(float f, float f2, @Nullable AnimatorListenerAdapter animatorListenerAdapter) {
        final float translationX = getTranslationX();
        final float f3 = f - translationX;
        final float alpha = this.mView.getAlpha();
        final float f4 = f2 - alpha;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(this.mAnimationTime);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = translationX + (valueAnimator.getAnimatedFraction() * f3);
                float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f4);
                SwipeDismissTouchListener.this.setTranslationX(animatedFraction);
                SwipeDismissTouchListener.this.setAlpha(animatedFraction2);
            }
        });
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public void performDismiss() {
        final ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        final int height = this.mView.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{height, 1}).setDuration(this.mAnimationTime);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.mDismissCallbacks.onDismiss(SwipeDismissTouchListener.this.mView, SwipeDismissTouchListener.this.mToken);
                SwipeDismissTouchListener.this.mView.setAlpha(1.0f);
                SwipeDismissTouchListener.this.mView.setTranslationX(0.0f);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
