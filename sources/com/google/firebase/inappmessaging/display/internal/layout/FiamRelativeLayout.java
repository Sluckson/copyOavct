package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.google.firebase.inappmessaging.display.internal.layout.util.BackButtonHandler;

public class FiamRelativeLayout extends RelativeLayout implements BackButtonLayout {
    private BackButtonHandler mBackHandler;

    public FiamRelativeLayout(Context context) {
        super(context);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(21)
    public FiamRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setDismissListener(View.OnClickListener onClickListener) {
        this.mBackHandler = new BackButtonHandler(this, onClickListener);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean dispatchKeyEvent = this.mBackHandler.dispatchKeyEvent(keyEvent);
        if (dispatchKeyEvent != null) {
            return dispatchKeyEvent.booleanValue();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
