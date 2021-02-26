package com.iaai.android.old.utils.p016ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

/* renamed from: com.iaai.android.old.utils.ui.RpViewFlipper */
public class RpViewFlipper extends ViewFlipper {
    public RpViewFlipper(Context context) {
        super(context);
    }

    public RpViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException unused) {
            stopFlipping();
        }
    }
}
