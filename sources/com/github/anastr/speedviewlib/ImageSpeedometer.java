package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0007J\b\u0010\u001c\u001a\u00020\fH\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/ImageSpeedometer;", "Lcom/github/anastr/speedviewlib/Speedometer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageSpeedometer", "Landroid/graphics/drawable/Drawable;", "defaultGaugeValues", "", "defaultSpeedometerValues", "getImageSpeedometer", "initAttributeSet", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldW", "oldH", "setImageSpeedometer", "bitmapImage", "Landroid/graphics/Bitmap;", "imageResource", "updateBackgroundBitmap", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: ImageSpeedometer.kt */
public class ImageSpeedometer extends Speedometer {
    private Drawable imageSpeedometer;

    @JvmOverloads
    public ImageSpeedometer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageSpeedometer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public void defaultSpeedometerValues() {
        setBackgroundCircleColor(0);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.ImageSpeedometer, 0, 0);
            this.imageSpeedometer = obtainStyledAttributes.getDrawable(C1083R.styleable.ImageSpeedometer_sv_image);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateBackgroundBitmap();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        drawSpeedUnitText(canvas);
        drawIndicator(canvas);
        drawNotes(canvas);
    }

    /* access modifiers changed from: protected */
    public void updateBackgroundBitmap() {
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        Drawable drawable = this.imageSpeedometer;
        if (drawable != null) {
            if (drawable == null) {
                Intrinsics.throwNpe();
            }
            drawable.setBounds(((int) getViewLeft()) + getPadding(), ((int) getViewTop()) + getPadding(), ((int) getViewRight()) - getPadding(), ((int) getViewBottom()) - getPadding());
            Drawable drawable2 = this.imageSpeedometer;
            if (drawable2 == null) {
                Intrinsics.throwNpe();
            }
            drawable2.draw(createBackgroundBitmapCanvas);
        }
        drawMarks(createBackgroundBitmapCanvas);
        drawTicks(createBackgroundBitmapCanvas);
    }

    @Nullable
    public final Drawable getImageSpeedometer() {
        return this.imageSpeedometer;
    }

    public final void setImageSpeedometer(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            setImageSpeedometer(getContext().getDrawable(i));
            return;
        }
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setImageSpeedometer(context.getResources().getDrawable(i));
    }

    public final void setImageSpeedometer(@Nullable Drawable drawable) {
        this.imageSpeedometer = drawable;
        updateBackgroundBitmap();
    }

    public final void setImageSpeedometer(@NotNull Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmapImage");
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setImageSpeedometer((Drawable) new BitmapDrawable(context.getResources(), bitmap));
    }
}
