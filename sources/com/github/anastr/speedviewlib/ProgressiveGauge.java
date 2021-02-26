package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.anastr.speedviewlib.Gauge;
import com.github.anastr.speedviewlib.LinearGauge;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u001a\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0004J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0004R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006!"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/ProgressiveGauge;", "Lcom/github/anastr/speedviewlib/LinearGauge;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backPaint", "Landroid/graphics/Paint;", "frontPaint", "path", "Landroid/graphics/Path;", "speedometerBackColor", "getSpeedometerBackColor", "()I", "setSpeedometerBackColor", "(I)V", "speedometerColor", "getSpeedometerColor", "setSpeedometerColor", "defaultGaugeValues", "", "init", "initAttributeSet", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateFrontAndBackBitmaps", "updateHorizontalPath", "updateOrientation", "updateVerticalPath", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: ProgressiveGauge.kt */
public class ProgressiveGauge extends LinearGauge {
    private final Paint backPaint;
    private final Paint frontPaint;
    private final Path path;

    @JvmOverloads
    public ProgressiveGauge(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ProgressiveGauge(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProgressiveGauge(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.path = new Path();
        this.frontPaint = new Paint(1);
        this.backPaint = new Paint(1);
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressiveGauge(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getSpeedometerColor() {
        return this.frontPaint.getColor();
    }

    public final void setSpeedometerColor(int i) {
        this.frontPaint.setColor(i);
        invalidateGauge();
    }

    public final int getSpeedometerBackColor() {
        return this.backPaint.getColor();
    }

    public final void setSpeedometerBackColor(int i) {
        this.backPaint.setColor(i);
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
        super.setSpeedTextPosition(Gauge.Position.CENTER);
        super.setUnitUnderSpeedText(true);
    }

    private final void init() {
        this.frontPaint.setColor((int) 4278255615L);
        this.backPaint.setColor((int) 4292270039L);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.LinearGauge, 0, 0);
            this.frontPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.LinearGauge_sv_speedometerColor, this.frontPaint.getColor()));
            this.backPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.LinearGauge_sv_speedometerBackColor, this.backPaint.getColor()));
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getOrientation() == LinearGauge.Orientation.HORIZONTAL) {
            int i3 = measuredWidth / 2;
            if (measuredHeight > i3) {
                setMeasuredDimension(measuredWidth, i3);
            } else {
                setMeasuredDimension(measuredHeight * 2, measuredHeight);
            }
        } else {
            int i4 = measuredHeight / 2;
            if (measuredWidth > i4) {
                setMeasuredDimension(i4, measuredHeight);
            } else {
                setMeasuredDimension(measuredWidth, measuredWidth * 2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateFrontAndBackBitmaps() {
        updateOrientation();
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        Canvas createForegroundBitmapCanvas = createForegroundBitmapCanvas();
        createBackgroundBitmapCanvas.translate((float) getPadding(), (float) getPadding());
        createBackgroundBitmapCanvas.drawPath(this.path, this.backPaint);
        createForegroundBitmapCanvas.drawPath(this.path, this.frontPaint);
    }

    private final void updateOrientation() {
        if (getOrientation() == LinearGauge.Orientation.HORIZONTAL) {
            updateHorizontalPath();
        } else {
            updateVerticalPath();
        }
    }

    /* access modifiers changed from: protected */
    public final void updateHorizontalPath() {
        this.path.reset();
        this.path.moveTo(0.0f, (float) getHeightPa());
        this.path.lineTo(0.0f, ((float) getHeightPa()) - (((float) getHeightPa()) * 0.1f));
        this.path.quadTo(((float) getWidthPa()) * 0.75f, ((float) getHeightPa()) * 0.75f, (float) getWidthPa(), 0.0f);
        this.path.lineTo((float) getWidthPa(), (float) getHeightPa());
        this.path.lineTo(0.0f, (float) getHeightPa());
    }

    /* access modifiers changed from: protected */
    public final void updateVerticalPath() {
        this.path.reset();
        this.path.moveTo(0.0f, (float) getHeightPa());
        this.path.lineTo(((float) getWidthPa()) * 0.1f, (float) getHeightPa());
        this.path.quadTo(((float) getWidthPa()) * 0.25f, ((float) getHeightPa()) * 0.25f, (float) getWidthPa(), 0.0f);
        this.path.lineTo(0.0f, 0.0f);
        this.path.lineTo(0.0f, (float) getHeightPa());
    }
}
