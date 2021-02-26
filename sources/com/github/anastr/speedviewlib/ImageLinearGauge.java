package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.github.anastr.speedviewlib.Gauge;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0014J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0014R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/ImageLinearGauge;", "Lcom/github/anastr/speedviewlib/LinearGauge;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backColor", "image", "Landroid/graphics/drawable/Drawable;", "defaultGaugeValues", "", "initAttributeSet", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateFrontAndBackBitmaps", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: ImageLinearGauge.kt */
public class ImageLinearGauge extends LinearGauge {
    private int backColor;
    private Drawable image;

    @JvmOverloads
    public ImageLinearGauge(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageLinearGauge(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageLinearGauge(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.backColor = (int) 4292270039L;
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageLinearGauge(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
        super.setSpeedTextPosition(Gauge.Position.CENTER);
        super.setUnitUnderSpeedText(true);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.ImageLinearGauge, 0, 0);
            this.backColor = obtainStyledAttributes.getColor(C1083R.styleable.ImageLinearGauge_sv_speedometerBackColor, this.backColor);
            this.image = obtainStyledAttributes.getDrawable(C1083R.styleable.ImageLinearGauge_sv_image);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Drawable drawable = this.image;
        if (drawable != null && measuredWidth != 0 && measuredHeight != 0) {
            if (drawable == null) {
                Intrinsics.throwNpe();
            }
            if (drawable.getIntrinsicWidth() > 0) {
                Drawable drawable2 = this.image;
                if (drawable2 == null) {
                    Intrinsics.throwNpe();
                }
                if (drawable2.getIntrinsicHeight() > 0) {
                    Drawable drawable3 = this.image;
                    if (drawable3 == null) {
                        Intrinsics.throwNpe();
                    }
                    float intrinsicWidth = (float) drawable3.getIntrinsicWidth();
                    Drawable drawable4 = this.image;
                    if (drawable4 == null) {
                        Intrinsics.throwNpe();
                    }
                    float intrinsicHeight = (float) drawable4.getIntrinsicHeight();
                    if (intrinsicWidth / intrinsicHeight > ((float) (measuredWidth / measuredHeight))) {
                        setMeasuredDimension(measuredWidth, (int) ((((float) measuredWidth) * intrinsicHeight) / intrinsicWidth));
                    } else {
                        setMeasuredDimension((int) ((((float) measuredHeight) * intrinsicWidth) / intrinsicHeight), measuredHeight);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateFrontAndBackBitmaps() {
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        Canvas createForegroundBitmapCanvas = createForegroundBitmapCanvas();
        Drawable drawable = this.image;
        if (drawable != null) {
            if (drawable == null) {
                Intrinsics.throwNpe();
            }
            drawable.setBounds(getPadding(), getPadding(), getWidth() - getPadding(), getHeight() - getPadding());
            Drawable drawable2 = this.image;
            if (drawable2 == null) {
                Intrinsics.throwNpe();
            }
            drawable2.setColorFilter(this.backColor, PorterDuff.Mode.SRC_IN);
            Drawable drawable3 = this.image;
            if (drawable3 == null) {
                Intrinsics.throwNpe();
            }
            drawable3.draw(createBackgroundBitmapCanvas);
            Drawable drawable4 = this.image;
            if (drawable4 == null) {
                Intrinsics.throwNpe();
            }
            drawable4.setColorFilter((ColorFilter) null);
            Drawable drawable5 = this.image;
            if (drawable5 == null) {
                Intrinsics.throwNpe();
            }
            drawable5.draw(createForegroundBitmapCanvas);
        }
    }
}
