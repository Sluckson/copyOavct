package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.anastr.speedviewlib.components.Style;
import com.github.anastr.speedviewlib.components.indicators.Indicator;
import com.github.anastr.speedviewlib.components.indicators.SpindleIndicator;
import com.github.anastr.speedviewlib.util.UtilsKt;
import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020$H\u0014J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\b\u0010(\u001a\u00020$H\u0002J\u001a\u0010)\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0014J(\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u000e\u00104\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u00105\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u0007J\b\u00106\u001a\u00020$H\u0014J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u000209H\u0002R$\u0010\t\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/PointerSpeedometer;", "Lcom/github/anastr/speedviewlib/Speedometer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerCircleColor", "getCenterCircleColor", "()I", "setCenterCircleColor", "(I)V", "centerCircleRadius", "", "getCenterCircleRadius", "()F", "setCenterCircleRadius", "(F)V", "circlePaint", "Landroid/graphics/Paint;", "withPointer", "", "isWithPointer", "()Z", "setWithPointer", "(Z)V", "pointerBackPaint", "pointerColor", "pointerPaint", "speedometerColor", "speedometerPaint", "speedometerRect", "Landroid/graphics/RectF;", "defaultGaugeValues", "", "defaultSpeedometerValues", "getPointerColor", "getSpeedometerColor", "init", "initAttributeSet", "initAttributeValue", "initDraw", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldW", "oldH", "setPointerColor", "setSpeedometerColor", "updateBackgroundBitmap", "updateRadial", "updateSweep", "Landroid/graphics/SweepGradient;", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: PointerSpeedometer.kt */
public class PointerSpeedometer extends Speedometer {
    private float centerCircleRadius;
    private final Paint circlePaint;
    private final Paint pointerBackPaint;
    private int pointerColor;
    private final Paint pointerPaint;
    private int speedometerColor;
    private final Paint speedometerPaint;
    private final RectF speedometerRect;
    private boolean withPointer;

    @JvmOverloads
    public PointerSpeedometer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PointerSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PointerSpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.speedometerPaint = new Paint(1);
        this.pointerPaint = new Paint(1);
        this.pointerBackPaint = new Paint(1);
        this.circlePaint = new Paint(1);
        this.speedometerRect = new RectF();
        this.speedometerColor = (int) 4293848814L;
        this.pointerColor = (int) 4294967295L;
        this.withPointer = true;
        this.centerCircleRadius = dpTOpx(12.0f);
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PointerSpeedometer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getCenterCircleColor() {
        return this.circlePaint.getColor();
    }

    public final void setCenterCircleColor(int i) {
        this.circlePaint.setColor(i);
        if (isAttachedToWindow()) {
            invalidate();
        }
    }

    public final float getCenterCircleRadius() {
        return this.centerCircleRadius;
    }

    public final void setCenterCircleRadius(float f) {
        this.centerCircleRadius = f;
        if (isAttachedToWindow()) {
            invalidate();
        }
    }

    public final boolean isWithPointer() {
        return this.withPointer;
    }

    public final void setWithPointer(boolean z) {
        this.withPointer = z;
        if (isAttachedToWindow()) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
        super.setSpeedometerWidth(dpTOpx(10.0f));
        int i = (int) 4294967295L;
        super.setTextColor(i);
        super.setSpeedTextColor(i);
        super.setUnitTextColor(i);
        super.setSpeedTextSize(dpTOpx(24.0f));
        super.setUnitTextSize(dpTOpx(11.0f));
        super.setSpeedTextTypeface(Typeface.create(Typeface.DEFAULT, 1));
    }

    /* access modifiers changed from: protected */
    public void defaultSpeedometerValues() {
        super.setMarksNumber(8);
        super.setMarksPadding(getSpeedometerWidth() + dpTOpx(12.0f));
        super.setMarkStyle(Style.ROUND);
        super.setMarkHeight(dpTOpx(5.0f));
        super.setMarkWidth(dpTOpx(2.0f));
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setIndicator((Indicator<?>) new SpindleIndicator(context));
        Indicator<?> indicator = getIndicator();
        indicator.setWidth(indicator.dpTOpx(16.0f));
        indicator.setColor((int) 4294967295L);
        super.setBackgroundCircleColor((int) 4282961129L);
    }

    private final void init() {
        this.speedometerPaint.setStyle(Paint.Style.STROKE);
        this.speedometerPaint.setStrokeCap(Paint.Cap.ROUND);
        this.circlePaint.setColor((int) 4294967295L);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            initAttributeValue();
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.PointerSpeedometer, 0, 0);
        this.speedometerColor = obtainStyledAttributes.getColor(C1083R.styleable.PointerSpeedometer_sv_speedometerColor, this.speedometerColor);
        this.pointerColor = obtainStyledAttributes.getColor(C1083R.styleable.PointerSpeedometer_sv_pointerColor, this.pointerColor);
        this.circlePaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.PointerSpeedometer_sv_centerCircleColor, this.circlePaint.getColor()));
        setCenterCircleRadius(obtainStyledAttributes.getDimension(C1083R.styleable.SpeedView_sv_centerCircleRadius, this.centerCircleRadius));
        this.withPointer = obtainStyledAttributes.getBoolean(C1083R.styleable.PointerSpeedometer_sv_withPointer, this.withPointer);
        obtainStyledAttributes.recycle();
        initAttributeValue();
    }

    private final void initAttributeValue() {
        this.pointerPaint.setColor(this.pointerColor);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float speedometerWidth = (getSpeedometerWidth() * 0.5f) + dpTOpx(8.0f) + ((float) getPadding());
        this.speedometerRect.set(speedometerWidth, speedometerWidth, ((float) getSize()) - speedometerWidth, ((float) getSize()) - speedometerWidth);
        updateRadial();
        updateBackgroundBitmap();
    }

    private final void initDraw() {
        this.speedometerPaint.setStrokeWidth(getSpeedometerWidth());
        this.speedometerPaint.setShader(updateSweep());
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        initDraw();
        float roundAngle = UtilsKt.getRoundAngle(getSpeedometerWidth(), this.speedometerRect.width());
        canvas.drawArc(this.speedometerRect, ((float) getStartDegree()) + roundAngle, ((float) (getEndDegree() - getStartDegree())) - (roundAngle * 2.0f), false, this.speedometerPaint);
        if (this.withPointer) {
            canvas.save();
            canvas.rotate(((float) 90) + getDegree(), ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
            canvas.drawCircle(((float) getSize()) * 0.5f, (getSpeedometerWidth() * 0.5f) + dpTOpx(8.0f) + ((float) getPadding()), (getSpeedometerWidth() * 0.5f) + dpTOpx(8.0f), this.pointerBackPaint);
            canvas.drawCircle(((float) getSize()) * 0.5f, (getSpeedometerWidth() * 0.5f) + dpTOpx(8.0f) + ((float) getPadding()), (getSpeedometerWidth() * 0.5f) + dpTOpx(1.0f), this.pointerPaint);
            canvas.restore();
        }
        drawSpeedUnitText(canvas);
        drawIndicator(canvas);
        int centerCircleColor = getCenterCircleColor();
        this.circlePaint.setColor(Color.argb((int) (((float) Color.alpha(centerCircleColor)) * 0.5f), Color.red(centerCircleColor), Color.green(centerCircleColor), Color.blue(centerCircleColor)));
        canvas.drawCircle(((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f, this.centerCircleRadius + dpTOpx(6.0f), this.circlePaint);
        this.circlePaint.setColor(centerCircleColor);
        canvas.drawCircle(((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f, this.centerCircleRadius, this.circlePaint);
        drawNotes(canvas);
    }

    /* access modifiers changed from: protected */
    public void updateBackgroundBitmap() {
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        initDraw();
        drawMarks(createBackgroundBitmapCanvas);
        if (getTickNumber() > 0) {
            drawTicks(createBackgroundBitmapCanvas);
        } else {
            drawDefMinMaxSpeedPosition(createBackgroundBitmapCanvas);
        }
    }

    private final SweepGradient updateSweep() {
        int argb = Color.argb(150, Color.red(this.speedometerColor), Color.green(this.speedometerColor), Color.blue(this.speedometerColor));
        int argb2 = Color.argb(WMSTransport.SESSIONSTATE_CONNECT_REJECTED, Color.red(this.speedometerColor), Color.green(this.speedometerColor), Color.blue(this.speedometerColor));
        int argb3 = Color.argb(70, Color.red(this.speedometerColor), Color.green(this.speedometerColor), Color.blue(this.speedometerColor));
        int argb4 = Color.argb(15, Color.red(this.speedometerColor), Color.green(this.speedometerColor), Color.blue(this.speedometerColor));
        float offsetSpeed = (getOffsetSpeed() * ((float) (getEndDegree() - getStartDegree()))) / 360.0f;
        SweepGradient sweepGradient = new SweepGradient(((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f, new int[]{argb, argb2, this.speedometerColor, argb3, argb4, argb}, new float[]{0.0f, offsetSpeed * 0.5f, offsetSpeed, offsetSpeed, 0.99f, 1.0f});
        Matrix matrix = new Matrix();
        matrix.postRotate((float) getStartDegree(), ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        sweepGradient.setLocalMatrix(matrix);
        return sweepGradient;
    }

    private final void updateRadial() {
        int argb = Color.argb(160, Color.red(this.pointerColor), Color.green(this.pointerColor), Color.blue(this.pointerColor));
        int argb2 = Color.argb(10, Color.red(this.pointerColor), Color.green(this.pointerColor), Color.blue(this.pointerColor));
        float size = ((float) getSize()) * 0.5f;
        this.pointerBackPaint.setShader(new RadialGradient(size, ((float) getPadding()) + (getSpeedometerWidth() * 0.5f) + dpTOpx(8.0f), (getSpeedometerWidth() * 0.5f) + dpTOpx(8.0f), new int[]{argb, argb2}, new float[]{0.4f, 1.0f}, Shader.TileMode.CLAMP));
    }

    public final int getSpeedometerColor() {
        return this.speedometerColor;
    }

    public final void setSpeedometerColor(int i) {
        this.speedometerColor = i;
        if (isAttachedToWindow()) {
            invalidate();
        }
    }

    public final int getPointerColor() {
        return this.pointerColor;
    }

    public final void setPointerColor(int i) {
        this.pointerColor = i;
        this.pointerPaint.setColor(i);
        updateRadial();
        if (isAttachedToWindow()) {
            invalidate();
        }
    }
}
