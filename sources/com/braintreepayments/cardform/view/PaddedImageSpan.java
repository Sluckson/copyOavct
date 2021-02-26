package com.braintreepayments.cardform.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.braintreepayments.cardform.utils.ViewUtils;

public class PaddedImageSpan extends ImageSpan {
    private boolean mDisabled;
    private int mPadding;
    private int mResourceId;

    public PaddedImageSpan(Context context, int i) {
        super(context, i);
        this.mResourceId = i;
        this.mPadding = ViewUtils.dp2px(context, 8.0f);
    }

    public void setDisabled(boolean z) {
        this.mDisabled = z;
    }

    /* access modifiers changed from: package-private */
    public int getResourceId() {
        return this.mResourceId;
    }

    /* access modifiers changed from: package-private */
    public boolean isDisabled() {
        return this.mDisabled;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt) + (this.mPadding * 2);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        super.draw(canvas, charSequence, i, i2, f + ((float) this.mPadding), i3, i4, i5, paint);
    }

    public Drawable getDrawable() {
        Drawable drawable = super.getDrawable();
        if (this.mDisabled) {
            drawable.mutate().setAlpha(80);
        }
        return drawable;
    }
}
