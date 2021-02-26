package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import com.github.anastr.speedviewlib.components.Section;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J(\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\b\u0010!\u001a\u00020\u0014H\u0014R$\u0010\t\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/TubeSpeedometer;", "Lcom/github/anastr/speedviewlib/Speedometer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "speedometerBackColor", "getSpeedometerBackColor", "()I", "setSpeedometerBackColor", "(I)V", "speedometerRect", "Landroid/graphics/RectF;", "tubeBacPaint", "Landroid/graphics/Paint;", "tubePaint", "defaultGaugeValues", "", "defaultSpeedometerValues", "init", "initAttributeSet", "initDraw", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldW", "oldH", "updateBackgroundBitmap", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: TubeSpeedometer.kt */
public class TubeSpeedometer extends Speedometer {
    private final RectF speedometerRect;
    private final Paint tubeBacPaint;
    private final Paint tubePaint;

    @JvmOverloads
    public TubeSpeedometer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public TubeSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TubeSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.tubePaint = new Paint(1);
        this.tubeBacPaint = new Paint(1);
        this.speedometerRect = new RectF();
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TubeSpeedometer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getSpeedometerBackColor() {
        return this.tubeBacPaint.getColor();
    }

    public final void setSpeedometerBackColor(int i) {
        this.tubeBacPaint.setColor(i);
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
        super.setSpeedometerWidth(dpTOpx(40.0f));
        getSections().get(0).setColor((int) 4278238420L);
        getSections().get(1).setColor((int) 4294951175L);
        getSections().get(2).setColor((int) 4294198070L);
    }

    /* access modifiers changed from: protected */
    public void defaultSpeedometerValues() {
        super.setBackgroundCircleColor(0);
    }

    private final void init() {
        this.tubePaint.setStyle(Paint.Style.STROKE);
        this.tubeBacPaint.setStyle(Paint.Style.STROKE);
        this.tubeBacPaint.setColor((int) 4285887861L);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.TubeSpeedometer, 0, 0);
            this.tubeBacPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.TubeSpeedometer_sv_speedometerBackColor, this.tubeBacPaint.getColor()));
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateBackgroundBitmap();
    }

    private final void initDraw() {
        this.tubePaint.setStrokeWidth(getSpeedometerWidth());
        if (getCurrentSection() != null) {
            Paint paint = this.tubePaint;
            Section currentSection = getCurrentSection();
            if (currentSection == null) {
                Intrinsics.throwNpe();
            }
            paint.setColor(currentSection.getColor());
            return;
        }
        this.tubePaint.setColor(0);
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        initDraw();
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.speedometerRect, (float) getStartDegree(), ((float) (getEndDegree() - getStartDegree())) * getOffsetSpeed(), false, this.tubePaint);
        drawSpeedUnitText(canvas);
        drawIndicator(canvas);
        drawNotes(canvas);
    }

    /* access modifiers changed from: protected */
    public void updateBackgroundBitmap() {
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        this.tubeBacPaint.setStrokeWidth(getSpeedometerWidth());
        float speedometerWidth = (getSpeedometerWidth() * 0.5f) + ((float) getPadding());
        this.speedometerRect.set(speedometerWidth, speedometerWidth, ((float) getSize()) - speedometerWidth, ((float) getSize()) - speedometerWidth);
        createBackgroundBitmapCanvas.drawArc(this.speedometerRect, (float) getStartDegree(), (float) (getEndDegree() - getStartDegree()), false, this.tubeBacPaint);
        drawMarks(createBackgroundBitmapCanvas);
        if (getTickNumber() > 0) {
            drawTicks(createBackgroundBitmapCanvas);
        } else {
            drawDefMinMaxSpeedPosition(createBackgroundBitmapCanvas);
        }
    }
}
