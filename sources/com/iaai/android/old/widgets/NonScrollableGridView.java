package com.iaai.android.old.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class NonScrollableGridView extends GridView {
    public NonScrollableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }
}
