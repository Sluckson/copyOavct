package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.anastr.speedviewlib.Gauge;
import com.github.anastr.speedviewlib.components.indicators.Indicator;
import com.github.anastr.speedviewlib.components.indicators.TriangleIndicator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0004J\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020\u001fH\u0002J\u001a\u0010&\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020#H\u0014J(\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J\u000e\u0010/\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u00100\u001a\u00020\u001fH\u0014J\b\u00101\u001a\u00020\u001fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u00062"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/AwesomeSpeedometer;", "Lcom/github/anastr/speedviewlib/Speedometer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customMarkPaint", "Landroid/graphics/Paint;", "markPath", "Landroid/graphics/Path;", "ringPaint", "speedometerColor", "speedometerRect", "Landroid/graphics/RectF;", "speedometerWidth", "", "getSpeedometerWidth", "()F", "setSpeedometerWidth", "(F)V", "trianglesColor", "getTrianglesColor", "()I", "setTrianglesColor", "(I)V", "trianglesPaint", "trianglesPath", "defaultGaugeValues", "", "defaultSpeedometerValues", "drawCustomMarks", "c", "Landroid/graphics/Canvas;", "getSpeedometerColor", "init", "initAttributeSet", "initDraw", "onDraw", "canvas", "onSizeChanged", "w", "h", "oldW", "oldH", "setSpeedometerColor", "updateBackgroundBitmap", "updateGradient", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: AwesomeSpeedometer.kt */
public class AwesomeSpeedometer extends Speedometer {
    private final Paint customMarkPaint;
    private final Path markPath;
    private final Paint ringPaint;
    private int speedometerColor;
    private final RectF speedometerRect;
    private final Paint trianglesPaint;
    private final Path trianglesPath;

    @JvmOverloads
    public AwesomeSpeedometer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public AwesomeSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AwesomeSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.markPath = new Path();
        this.trianglesPath = new Path();
        this.customMarkPaint = new Paint(1);
        this.ringPaint = new Paint(1);
        this.trianglesPaint = new Paint(1);
        this.speedometerRect = new RectF();
        this.speedometerColor = (int) 4278249190L;
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AwesomeSpeedometer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getTrianglesColor() {
        return this.trianglesPaint.getColor();
    }

    public final void setTrianglesColor(int i) {
        this.trianglesPaint.setColor(i);
        invalidateGauge();
    }

    public float getSpeedometerWidth() {
        return super.getSpeedometerWidth();
    }

    public void setSpeedometerWidth(float f) {
        super.setSpeedometerWidth(f);
        RectF rectF = this.speedometerRect;
        if (rectF != null) {
            float f2 = f * 0.5f;
            rectF.set(f2, f2, ((float) getSize()) - f2, ((float) getSize()) - f2);
            updateGradient();
            invalidateGauge();
        }
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
        super.setSpeedometerWidth(dpTOpx(60.0f));
        super.setTextColor((int) 4294951520L);
        int i = (int) 4294967295L;
        super.setSpeedTextColor(i);
        super.setUnitTextColor(i);
        super.setTextTypeface(Typeface.create(Typeface.DEFAULT, 1));
        super.setSpeedTextPosition(Gauge.Position.CENTER);
        super.setUnitUnderSpeedText(true);
    }

    /* access modifiers changed from: protected */
    public void defaultSpeedometerValues() {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setIndicator((Indicator<?>) new TriangleIndicator(context));
        Indicator<?> indicator = getIndicator();
        indicator.setWidth(indicator.dpTOpx(25.0f));
        indicator.setColor((int) 4278249190L);
        super.setStartEndDegree(135, 455);
        super.setBackgroundCircleColor((int) 4280361249L);
        super.setTickNumber(9);
        super.setTickPadding(0);
    }

    private final void init() {
        this.customMarkPaint.setStyle(Paint.Style.STROKE);
        getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.ringPaint.setStyle(Paint.Style.STROKE);
        this.trianglesPaint.setColor((int) 4281944491L);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.AwesomeSpeedometer, 0, 0);
            this.speedometerColor = obtainStyledAttributes.getColor(C1083R.styleable.AwesomeSpeedometer_sv_speedometerColor, this.speedometerColor);
            this.trianglesPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.AwesomeSpeedometer_sv_trianglesColor, this.trianglesPaint.getColor()));
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateGradient();
        updateBackgroundBitmap();
    }

    private final void updateGradient() {
        float sizePa = ((((float) getSizePa()) * 0.5f) - getSpeedometerWidth()) / (((float) getSizePa()) * 0.5f);
        float f = 1.0f - sizePa;
        int i = this.speedometerColor;
        int[] iArr = {getBackgroundCircleColor(), this.speedometerColor, getBackgroundCircleColor(), getBackgroundCircleColor(), i, i};
        float size = ((float) getSize()) * 0.5f;
        this.ringPaint.setShader(new RadialGradient(size, ((float) getSize()) * 0.5f, 0.5f * ((float) getSizePa()), iArr, new float[]{sizePa, (0.1f * f) + sizePa, (0.36f * f) + sizePa, (0.64f * f) + sizePa, (f * 0.9f) + sizePa, 1.0f}, Shader.TileMode.CLAMP));
    }

    private final void initDraw() {
        this.ringPaint.setStrokeWidth(getSpeedometerWidth());
        this.customMarkPaint.setColor(getMarkColor());
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
        initDraw();
        float viewSizePa = ((float) getViewSizePa()) / 22.0f;
        this.markPath.reset();
        this.markPath.moveTo(((float) getSize()) * 0.5f, (float) getPadding());
        this.markPath.lineTo(((float) getSize()) * 0.5f, ((float) getPadding()) + viewSizePa);
        this.customMarkPaint.setStrokeWidth(viewSizePa / 5.0f);
        setInitTickPadding(((float) getViewSizePa()) / 20.0f);
        this.trianglesPath.reset();
        this.trianglesPath.moveTo(((float) getSize()) * 0.5f, ((float) getPadding()) + (((float) getViewSizePa()) / 20.0f));
        float viewSize = (((float) getViewSize()) / 20.0f) / 2.0f;
        this.trianglesPath.lineTo((((float) getSize()) * 0.5f) - viewSize, (float) getPadding());
        this.trianglesPath.lineTo((((float) getSize()) * 0.5f) + viewSize, (float) getPadding());
        float speedometerWidth = (getSpeedometerWidth() * 0.5f) + ((float) getPadding());
        this.speedometerRect.set(speedometerWidth, speedometerWidth, ((float) getSize()) - speedometerWidth, ((float) getSize()) - speedometerWidth);
        createBackgroundBitmapCanvas.drawArc(this.speedometerRect, 0.0f, 360.0f, false, this.ringPaint);
        drawCustomMarks(createBackgroundBitmapCanvas);
        drawMarks(createBackgroundBitmapCanvas);
        drawTicks(createBackgroundBitmapCanvas);
    }

    /* access modifiers changed from: protected */
    public final void drawCustomMarks(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "c");
        int endDegree = getEndDegree() - getStartDegree();
        int i = 0;
        for (Object next : getTicks()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            float f = (float) endDegree;
            float startDegree = ((float) getStartDegree()) + (((Number) next).floatValue() * f);
            canvas.save();
            canvas.rotate(90.0f + startDegree, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
            canvas.drawPath(this.trianglesPath, this.trianglesPaint);
            if (i2 != getTickNumber()) {
                canvas.save();
                Float f2 = getTicks().get(i2);
                Intrinsics.checkExpressionValueIsNotNull(f2, "ticks[index + 1]");
                float startDegree2 = (((float) getStartDegree()) + (f * f2.floatValue())) - startDegree;
                for (int i3 = 1; i3 <= 9; i3++) {
                    canvas.rotate(0.1f * startDegree2, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
                    if (i3 == 5) {
                        this.customMarkPaint.setStrokeWidth((((float) getSize()) / 22.0f) / 5.0f);
                    } else {
                        this.customMarkPaint.setStrokeWidth((((float) getSize()) / 22.0f) / 9.0f);
                    }
                    canvas.drawPath(this.markPath, this.customMarkPaint);
                }
                canvas.restore();
            }
            canvas.restore();
            i = i2;
        }
    }

    public final int getSpeedometerColor() {
        return this.speedometerColor;
    }

    public final void setSpeedometerColor(int i) {
        this.speedometerColor = i;
        updateGradient();
        invalidateGauge();
    }
}
