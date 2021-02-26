package com.braintreepayments.api.dropin.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ViewAnimator;
import com.braintreepayments.api.dropin.C0944R;

public class AnimatedButtonView extends RelativeLayout implements View.OnClickListener {
    private Button mButton;
    private View.OnClickListener mOnClickListener;
    private ViewAnimator mViewAnimator;

    public AnimatedButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public AnimatedButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    @TargetApi(21)
    public AnimatedButtonView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (!isInEditMode()) {
            LayoutInflater.from(getContext()).inflate(C0944R.C0949layout.bt_animated_button_view, this);
            this.mViewAnimator = (ViewAnimator) findViewById(C0944R.C0947id.bt_view_animator);
            this.mButton = (Button) findViewById(C0944R.C0947id.bt_button);
            this.mButton.setOnClickListener(this);
            this.mViewAnimator.setInAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
            this.mViewAnimator.setOutAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0944R.styleable.bt_AnimatedButtonAttributes);
            this.mButton.setText(obtainStyledAttributes.getString(C0944R.styleable.bt_AnimatedButtonAttributes_bt_buttonText));
            obtainStyledAttributes.recycle();
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    public void onClick(View view) {
        showLoading();
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void showButton() {
        if (this.mViewAnimator.getDisplayedChild() == 1) {
            this.mViewAnimator.showPrevious();
        }
    }

    public void showLoading() {
        if (this.mViewAnimator.getDisplayedChild() == 0) {
            this.mViewAnimator.showNext();
        }
    }

    public void requestButtonFocus() {
        requestFocus();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
