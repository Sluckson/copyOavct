package com.makeramen.segmented;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.iaai.android.C2723R;

public class CenteredRadioImageButton extends RadioButton {
    Drawable image;

    public CenteredRadioImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.image = context.obtainStyledAttributes(attributeSet, C2723R.styleable.CompoundButton, 0, 0).getDrawable(1);
        setButtonDrawable(16908292);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        Drawable drawable = this.image;
        if (drawable != null) {
            drawable.setState(getDrawableState());
            int intrinsicHeight = this.image.getIntrinsicHeight();
            int intrinsicWidth = this.image.getIntrinsicWidth();
            int width = getWidth();
            int height = getHeight();
            if (intrinsicWidth > width || intrinsicHeight > height) {
                f = Math.min(((float) width) / ((float) intrinsicWidth), ((float) height) / ((float) intrinsicHeight));
            } else {
                f = 1.0f;
            }
            float f2 = ((float) intrinsicWidth) * f;
            int i = (int) (((((float) width) - f2) * 0.5f) + 0.5f);
            int i2 = (int) (((((float) height) - (((float) intrinsicHeight) * f)) * 0.5f) + 0.5f);
            this.image.setBounds(i, i2, (int) (((float) i) + f2), (int) (((float) i2) + f2));
            this.image.draw(canvas);
        }
    }
}
