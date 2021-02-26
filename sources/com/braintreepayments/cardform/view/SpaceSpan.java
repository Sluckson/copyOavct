package com.braintreepayments.cardform.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class SpaceSpan extends ReplacementSpan {
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) (paint.measureText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, 0, 1) + paint.measureText(charSequence, i, i2));
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.drawText(charSequence.subSequence(i, i2) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, f, (float) i4, paint);
    }
}
