package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.anastr.speedviewlib.components.Section;
import com.github.anastr.speedviewlib.components.Style;
import com.github.anastr.speedviewlib.components.indicators.Indicator;
import com.github.anastr.speedviewlib.components.indicators.NormalIndicator;
import com.github.anastr.speedviewlib.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0014J(\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\b\u0010&\u001a\u00020\u001aH\u0014R$\u0010\t\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/SpeedView;", "Lcom/github/anastr/speedviewlib/Speedometer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerCircleColor", "getCenterCircleColor", "()I", "setCenterCircleColor", "(I)V", "centerCircleRadius", "", "getCenterCircleRadius", "()F", "setCenterCircleRadius", "(F)V", "circlePaint", "Landroid/graphics/Paint;", "speedometerPaint", "speedometerRect", "Landroid/graphics/RectF;", "defaultGaugeValues", "", "defaultSpeedometerValues", "init", "initAttributeSet", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldW", "oldH", "updateBackgroundBitmap", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: SpeedView.kt */
public class SpeedView extends Speedometer {
    private float centerCircleRadius;
    private final Paint circlePaint;
    private final Paint speedometerPaint;
    private final RectF speedometerRect;

    @JvmOverloads
    public SpeedView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public SpeedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void defaultGaugeValues() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpeedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.circlePaint = new Paint(1);
        this.speedometerPaint = new Paint(1);
        this.speedometerRect = new RectF();
        this.centerCircleRadius = dpTOpx(20.0f);
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeedView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* access modifiers changed from: protected */
    public void defaultSpeedometerValues() {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setIndicator((Indicator<?>) new NormalIndicator(context));
        super.setBackgroundCircleColor(0);
        super.setMarksNumber(8);
    }

    private final void init() {
        this.speedometerPaint.setStyle(Paint.Style.STROKE);
        this.circlePaint.setColor((int) 4282664004L);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.SpeedView, 0, 0);
            this.circlePaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.SpeedView_sv_centerCircleColor, this.circlePaint.getColor()));
            setCenterCircleRadius(obtainStyledAttributes.getDimension(C1083R.styleable.SpeedView_sv_centerCircleRadius, this.centerCircleRadius));
            int i = obtainStyledAttributes.getInt(C1083R.styleable.SpeedView_sv_sectionStyle, -1);
            if (i != -1) {
                for (Section style : getSections()) {
                    style.setStyle(Style.values()[i]);
                }
            }
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
        canvas.drawCircle(((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f, this.centerCircleRadius, this.circlePaint);
        drawNotes(canvas);
    }

    /* access modifiers changed from: protected */
    public void updateBackgroundBitmap() {
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        for (Section section : getSections()) {
            float width = (section.getWidth() * 0.5f) + ((float) getPadding()) + section.getPadding();
            this.speedometerRect.set(width, width, ((float) getSize()) - width, ((float) getSize()) - width);
            this.speedometerPaint.setStrokeWidth(section.getWidth());
            this.speedometerPaint.setColor(section.getColor());
            float startDegree = ((float) getStartDegree()) + (((float) (getEndDegree() - getStartDegree())) * section.getStartOffset());
            float endDegree = (((float) (getEndDegree() - getStartDegree())) * section.getEndOffset()) - (startDegree - ((float) getStartDegree()));
            if (section.getStyle() == Style.ROUND) {
                float roundAngle = UtilsKt.getRoundAngle(section.getWidth(), this.speedometerRect.width());
                this.speedometerPaint.setStrokeCap(Paint.Cap.ROUND);
                createBackgroundBitmapCanvas.drawArc(this.speedometerRect, startDegree + roundAngle, endDegree - (roundAngle * 2.0f), false, this.speedometerPaint);
            } else {
                this.speedometerPaint.setStrokeCap(Paint.Cap.BUTT);
                createBackgroundBitmapCanvas.drawArc(this.speedometerRect, startDegree, endDegree, false, this.speedometerPaint);
            }
        }
        drawMarks(createBackgroundBitmapCanvas);
        if (getTickNumber() > 0) {
            drawTicks(createBackgroundBitmapCanvas);
        } else {
            drawDefMinMaxSpeedPosition(createBackgroundBitmapCanvas);
        }
    }
}
