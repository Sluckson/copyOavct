package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import com.github.anastr.speedviewlib.components.Section;
import com.github.anastr.speedviewlib.components.indicators.Indicator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020)H\u0014J\u0006\u0010+\u001a\u00020\u0007J\b\u0010,\u001a\u00020)H\u0002J\u001a\u0010-\u001a\u00020)2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0014J(\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J\u000e\u00106\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020)H\u0014J\b\u0010;\u001a\u00020)H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u000e\u0010'\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/RaySpeedometer;", "Lcom/github/anastr/speedviewlib/Speedometer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeMarkPaint", "Landroid/graphics/Paint;", "degreeBetweenMark", "withEffects", "", "isWithEffects", "()Z", "setWithEffects", "(Z)V", "markPath", "Landroid/graphics/Path;", "ray1Path", "ray2Path", "rayColor", "getRayColor", "()I", "setRayColor", "(I)V", "rayMarkPaint", "markRayWidth", "", "rayMarkWidth", "getRayMarkWidth", "()F", "setRayMarkWidth", "(F)V", "rayPaint", "speedBackgroundColor", "getSpeedBackgroundColor", "setSpeedBackgroundColor", "speedBackgroundPaint", "defaultGaugeValues", "", "defaultSpeedometerValues", "getDegreeBetweenMark", "init", "initAttributeSet", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldW", "oldH", "setDegreeBetweenMark", "setIndicator", "indicator", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator$Indicators;", "updateBackgroundBitmap", "updateMarkPath", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: RaySpeedometer.kt */
public class RaySpeedometer extends Speedometer {
    private final Paint activeMarkPaint;
    private int degreeBetweenMark;
    private final Path markPath;
    private final Path ray1Path;
    private final Path ray2Path;
    private final Paint rayMarkPaint;
    private final Paint rayPaint;
    private final Paint speedBackgroundPaint;
    private boolean withEffects;

    @JvmOverloads
    public RaySpeedometer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public RaySpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RaySpeedometer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.markPath = new Path();
        this.ray1Path = new Path();
        this.ray2Path = new Path();
        this.rayMarkPaint = new Paint(1);
        this.activeMarkPaint = new Paint(1);
        this.speedBackgroundPaint = new Paint(1);
        this.rayPaint = new Paint(1);
        this.withEffects = true;
        this.degreeBetweenMark = 5;
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RaySpeedometer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final boolean isWithEffects() {
        return this.withEffects;
    }

    public final void setWithEffects(boolean z) {
        this.withEffects = z;
        if (!isInEditMode()) {
            getIndicator().withEffects(z);
            if (z) {
                this.rayPaint.setMaskFilter(new BlurMaskFilter(3.0f, BlurMaskFilter.Blur.SOLID));
                this.activeMarkPaint.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
                this.speedBackgroundPaint.setMaskFilter(new BlurMaskFilter(8.0f, BlurMaskFilter.Blur.SOLID));
            } else {
                MaskFilter maskFilter = null;
                this.rayPaint.setMaskFilter(maskFilter);
                this.activeMarkPaint.setMaskFilter(maskFilter);
                this.speedBackgroundPaint.setMaskFilter(maskFilter);
            }
            invalidateGauge();
        }
    }

    public final int getSpeedBackgroundColor() {
        return this.speedBackgroundPaint.getColor();
    }

    public final void setSpeedBackgroundColor(int i) {
        this.speedBackgroundPaint.setColor(i);
        invalidateGauge();
    }

    public final float getRayMarkWidth() {
        return this.rayMarkPaint.getStrokeWidth();
    }

    public final void setRayMarkWidth(float f) {
        this.rayMarkPaint.setStrokeWidth(f);
        this.activeMarkPaint.setStrokeWidth(f);
        if (isAttachedToWindow()) {
            invalidate();
        }
    }

    public final int getRayColor() {
        return this.rayPaint.getColor();
    }

    public final void setRayColor(int i) {
        this.rayPaint.setColor(i);
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
        super.setTextColor((int) 4294967295L);
    }

    /* access modifiers changed from: protected */
    public void defaultSpeedometerValues() {
        super.setBackgroundCircleColor((int) 4280361249L);
        super.setMarkColor((int) 4278190080L);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.RaySpeedometer, 0, 0);
            this.rayPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.RaySpeedometer_sv_rayColor, this.rayPaint.getColor()));
            int i = obtainStyledAttributes.getInt(C1083R.styleable.RaySpeedometer_sv_degreeBetweenMark, this.degreeBetweenMark);
            float dimension = obtainStyledAttributes.getDimension(C1083R.styleable.RaySpeedometer_sv_rayMarkWidth, this.rayMarkPaint.getStrokeWidth());
            this.rayMarkPaint.setStrokeWidth(dimension);
            this.activeMarkPaint.setStrokeWidth(dimension);
            this.speedBackgroundPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.RaySpeedometer_sv_speedBackgroundColor, this.speedBackgroundPaint.getColor()));
            this.withEffects = obtainStyledAttributes.getBoolean(C1083R.styleable.RaySpeedometer_sv_withEffects, this.withEffects);
            obtainStyledAttributes.recycle();
            setWithEffects(this.withEffects);
            if (1 <= i && 20 >= i) {
                this.degreeBetweenMark = i;
            }
        }
    }

    private final void init() {
        this.rayMarkPaint.setStyle(Paint.Style.STROKE);
        this.rayMarkPaint.setStrokeWidth(dpTOpx(3.0f));
        this.activeMarkPaint.setStyle(Paint.Style.STROKE);
        this.activeMarkPaint.setStrokeWidth(dpTOpx(3.0f));
        this.rayPaint.setStyle(Paint.Style.STROKE);
        this.rayPaint.setStrokeWidth(dpTOpx(1.8f));
        int i = (int) 4294967295L;
        this.rayPaint.setColor(i);
        this.speedBackgroundPaint.setColor(i);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
        setWithEffects(this.withEffects);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateMarkPath();
        updateBackgroundBitmap();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        int i;
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(((float) getStartDegree()) + 90.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        int startDegree = getStartDegree();
        while (startDegree < getEndDegree()) {
            if (getDegree() <= ((float) startDegree)) {
                this.rayMarkPaint.setColor(getMarkColor());
                canvas.drawPath(this.markPath, this.rayMarkPaint);
                canvas.rotate((float) this.degreeBetweenMark, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
                i = this.degreeBetweenMark;
            } else {
                if (getCurrentSection() != null) {
                    Paint paint = this.activeMarkPaint;
                    Section currentSection = getCurrentSection();
                    if (currentSection == null) {
                        Intrinsics.throwNpe();
                    }
                    paint.setColor(currentSection.getColor());
                } else {
                    this.activeMarkPaint.setColor(0);
                }
                canvas.drawPath(this.markPath, this.activeMarkPaint);
                canvas.rotate((float) this.degreeBetweenMark, ((float) getSize()) * 0.5f, ((float) getSize()) / 2.0f);
                i = this.degreeBetweenMark;
            }
            startDegree += i;
        }
        canvas.restore();
        RectF speedUnitTextBounds = getSpeedUnitTextBounds();
        speedUnitTextBounds.left -= 2.0f;
        speedUnitTextBounds.right += 2.0f;
        speedUnitTextBounds.bottom += 2.0f;
        canvas.drawRect(speedUnitTextBounds, this.speedBackgroundPaint);
        drawSpeedUnitText(canvas);
        drawIndicator(canvas);
        drawNotes(canvas);
    }

    /* access modifiers changed from: protected */
    public void updateBackgroundBitmap() {
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        updateMarkPath();
        this.ray1Path.reset();
        this.ray1Path.moveTo(((float) getSize()) / 2.0f, ((float) getSize()) / 2.0f);
        this.ray1Path.lineTo(((float) getSize()) / 2.0f, (((float) getSizePa()) / 3.2f) + ((float) getPadding()));
        this.ray1Path.moveTo(((float) getSize()) / 2.0f, (((float) getSizePa()) / 3.2f) + ((float) getPadding()));
        this.ray1Path.lineTo(((float) getSize()) / 2.2f, (((float) getSizePa()) / 3.0f) + ((float) getPadding()));
        this.ray1Path.moveTo(((float) getSize()) / 2.2f, (((float) getSizePa()) / 3.0f) + ((float) getPadding()));
        this.ray1Path.lineTo(((float) getSize()) / 2.1f, (((float) getSizePa()) / 4.5f) + ((float) getPadding()));
        this.ray2Path.reset();
        this.ray2Path.moveTo(((float) getSize()) / 2.0f, ((float) getSize()) / 2.0f);
        this.ray2Path.lineTo(((float) getSize()) / 2.0f, (((float) getSizePa()) / 3.2f) + ((float) getPadding()));
        this.ray2Path.moveTo(((float) getSize()) / 2.0f, (((float) getSizePa()) / 3.2f) + ((float) getPadding()));
        this.ray2Path.lineTo(((float) getSize()) / 2.2f, (((float) getSizePa()) / 3.8f) + ((float) getPadding()));
        this.ray2Path.moveTo(((float) getSize()) / 2.0f, (((float) getSizePa()) / 3.2f) + ((float) getPadding()));
        this.ray2Path.lineTo(((float) getSize()) / 1.8f, (((float) getSizePa()) / 3.8f) + ((float) getPadding()));
        createBackgroundBitmapCanvas.save();
        for (int i = 0; i <= 5; i++) {
            createBackgroundBitmapCanvas.rotate(58.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
            if (i % 2 == 0) {
                createBackgroundBitmapCanvas.drawPath(this.ray1Path, this.rayPaint);
            } else {
                createBackgroundBitmapCanvas.drawPath(this.ray2Path, this.rayPaint);
            }
        }
        createBackgroundBitmapCanvas.restore();
        drawMarks(createBackgroundBitmapCanvas);
        if (getTickNumber() > 0) {
            drawTicks(createBackgroundBitmapCanvas);
        } else {
            drawDefMinMaxSpeedPosition(createBackgroundBitmapCanvas);
        }
    }

    private final void updateMarkPath() {
        this.markPath.reset();
        this.markPath.moveTo(((float) getSize()) * 0.5f, (float) getPadding());
        this.markPath.lineTo(((float) getSize()) * 0.5f, getSpeedometerWidth() + ((float) getPadding()));
    }

    public void setIndicator(@NotNull Indicator.Indicators indicators) {
        Intrinsics.checkParameterIsNotNull(indicators, "indicator");
        super.setIndicator(indicators);
        getIndicator().withEffects(this.withEffects);
    }

    public final int getDegreeBetweenMark() {
        return this.degreeBetweenMark;
    }

    public final void setDegreeBetweenMark(int i) {
        if (i > 0 && i <= 20) {
            this.degreeBetweenMark = i;
            if (isAttachedToWindow()) {
                invalidate();
            }
        }
    }
}
