package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.C0049Px;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.C1308R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = C1308R.C1314style.Widget_MaterialComponents_CircularProgressIndicator;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C1308R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i, DEF_STYLE_RES);
        initializeDrawables();
    }

    /* access modifiers changed from: package-private */
    public CircularProgressIndicatorSpec createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
    }

    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }

    @C0049Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    public void setIndicatorInset(@C0049Px int i) {
        if (((CircularProgressIndicatorSpec) this.spec).indicatorInset != i) {
            ((CircularProgressIndicatorSpec) this.spec).indicatorInset = i;
            invalidate();
        }
    }

    @C0049Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public void setIndicatorSize(@C0049Px int i) {
        if (((CircularProgressIndicatorSpec) this.spec).indicatorSize != i) {
            ((CircularProgressIndicatorSpec) this.spec).indicatorSize = i;
            ((CircularProgressIndicatorSpec) this.spec).validateSpec();
            invalidate();
        }
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    public void setIndicatorDirection(int i) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = i;
        invalidate();
    }
}
