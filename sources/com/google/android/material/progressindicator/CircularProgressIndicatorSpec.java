package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.C0049Px;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.C1308R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;
    @C0049Px
    public int indicatorInset;
    @C0049Px
    public int indicatorSize;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C1308R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C1308R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C1308R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C1308R.styleable.CircularProgressIndicator, i, i2, new int[0]);
        this.indicatorSize = MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, C1308R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, C1308R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.indicatorDirection = obtainStyledAttributes.getInt(C1308R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        obtainStyledAttributes.recycle();
        validateSpec();
    }

    /* access modifiers changed from: package-private */
    public void validateSpec() {
        if (this.indicatorSize < this.trackThickness * 2) {
            throw new IllegalArgumentException("The indicatorSize (" + this.indicatorSize + " px) cannot be less than twice of the trackThickness (" + this.trackThickness + " px).");
        }
    }
}
