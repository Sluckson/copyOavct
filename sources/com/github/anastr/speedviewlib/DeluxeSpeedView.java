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
import com.github.anastr.speedviewlib.components.Style;
import com.github.anastr.speedviewlib.components.indicators.Indicator;
import com.github.anastr.speedviewlib.components.indicators.NormalSmallIndicator;
import com.github.anastr.speedviewlib.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020'H\u0014J\b\u0010)\u001a\u00020'H\u0002J\u001a\u0010*\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010+\u001a\u00020'H\u0002J\b\u0010,\u001a\u00020'H\u0002J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/H\u0014J(\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020'H\u0014R$\u0010\t\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\u000e\u0010\"\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/DeluxeSpeedView;", "Lcom/github/anastr/speedviewlib/Speedometer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerCircleColor", "getCenterCircleColor", "()I", "setCenterCircleColor", "(I)V", "centerCircleRadius", "", "getCenterCircleRadius", "()F", "setCenterCircleRadius", "(F)V", "circlePaint", "Landroid/graphics/Paint;", "withEffects", "", "isWithEffects", "()Z", "setWithEffects", "(Z)V", "smallMarkPaint", "smallMarkPath", "Landroid/graphics/Path;", "speedBackgroundColor", "getSpeedBackgroundColor", "setSpeedBackgroundColor", "speedBackgroundPaint", "speedometerPaint", "speedometerRect", "Landroid/graphics/RectF;", "defaultGaugeValues", "", "defaultSpeedometerValues", "init", "initAttributeSet", "initAttributeValue", "initDraw", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldW", "oldH", "setIndicator", "indicator", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator$Indicators;", "updateBackgroundBitmap", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: DeluxeSpeedView.kt */
public class DeluxeSpeedView extends Speedometer {
    private float centerCircleRadius;
    private final Paint circlePaint;
    private final Paint smallMarkPaint;
    private final Path smallMarkPath;
    private final Paint speedBackgroundPaint;
    private final Paint speedometerPaint;
    private final RectF speedometerRect;
    private boolean withEffects;

    @JvmOverloads
    public DeluxeSpeedView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public DeluxeSpeedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    private final void initAttributeValue() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DeluxeSpeedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.smallMarkPath = new Path();
        this.circlePaint = new Paint(1);
        this.speedometerPaint = new Paint(1);
        this.smallMarkPaint = new Paint(1);
        this.speedBackgroundPaint = new Paint(1);
        this.speedometerRect = new RectF();
        this.withEffects = true;
        this.centerCircleRadius = dpTOpx(20.0f);
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeluxeSpeedView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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
                getMarkPaint().setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
                this.speedBackgroundPaint.setMaskFilter(new BlurMaskFilter(8.0f, BlurMaskFilter.Blur.SOLID));
                this.circlePaint.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.SOLID));
            } else {
                MaskFilter maskFilter = null;
                getMarkPaint().setMaskFilter(maskFilter);
                this.speedBackgroundPaint.setMaskFilter(maskFilter);
                this.circlePaint.setMaskFilter(maskFilter);
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
    public void defaultGaugeValues() {
        super.setTextColor((int) 4294967295L);
        getSections().get(0).setColor((int) 4281829167L);
        getSections().get(1).setColor((int) 4288905780L);
        getSections().get(2).setColor((int) 4288356384L);
    }

    /* access modifiers changed from: protected */
    public void defaultSpeedometerValues() {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setIndicator((Indicator<?>) new NormalSmallIndicator(context));
        getIndicator().setColor((int) 4278255596L);
        super.setBackgroundCircleColor((int) 4280361249L);
        super.setMarksNumber(8);
    }

    private final void init() {
        this.speedometerPaint.setStyle(Paint.Style.STROKE);
        this.smallMarkPaint.setStyle(Paint.Style.STROKE);
        this.speedBackgroundPaint.setColor((int) 4294967295L);
        this.circlePaint.setColor((int) 4292927712L);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
        setWithEffects(this.withEffects);
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            initAttributeValue();
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.DeluxeSpeedView, 0, 0);
        this.speedBackgroundPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.DeluxeSpeedView_sv_speedBackgroundColor, this.speedBackgroundPaint.getColor()));
        this.withEffects = obtainStyledAttributes.getBoolean(C1083R.styleable.DeluxeSpeedView_sv_withEffects, this.withEffects);
        this.circlePaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.DeluxeSpeedView_sv_centerCircleColor, this.circlePaint.getColor()));
        setCenterCircleRadius(obtainStyledAttributes.getDimension(C1083R.styleable.DeluxeSpeedView_sv_centerCircleRadius, this.centerCircleRadius));
        int i = obtainStyledAttributes.getInt(C1083R.styleable.DeluxeSpeedView_sv_sectionStyle, -1);
        if (i != -1) {
            for (Section style : getSections()) {
                style.setStyle(Style.values()[i]);
            }
        }
        obtainStyledAttributes.recycle();
        setWithEffects(this.withEffects);
        initAttributeValue();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateBackgroundBitmap();
    }

    private final void initDraw() {
        this.speedometerPaint.setStrokeWidth(getSpeedometerWidth());
        this.smallMarkPaint.setColor(getMarkColor());
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        RectF speedUnitTextBounds = getSpeedUnitTextBounds();
        speedUnitTextBounds.left -= 2.0f;
        speedUnitTextBounds.right += 2.0f;
        speedUnitTextBounds.bottom += 2.0f;
        canvas.drawRect(speedUnitTextBounds, this.speedBackgroundPaint);
        drawSpeedUnitText(canvas);
        drawIndicator(canvas);
        canvas.drawCircle(((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f, this.centerCircleRadius, this.circlePaint);
        drawNotes(canvas);
    }

    /* access modifiers changed from: protected */
    public void updateBackgroundBitmap() {
        Canvas createBackgroundBitmapCanvas = createBackgroundBitmapCanvas();
        initDraw();
        this.smallMarkPath.reset();
        this.smallMarkPath.moveTo(((float) getSize()) * 0.5f, getSpeedometerWidth() + ((float) getPadding()));
        this.smallMarkPath.lineTo(((float) getSize()) * 0.5f, getSpeedometerWidth() + ((float) getPadding()) + (((float) getViewSizePa()) / 20.0f));
        this.smallMarkPaint.setStrokeWidth(3.0f);
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
        createBackgroundBitmapCanvas.save();
        createBackgroundBitmapCanvas.rotate(((float) getStartDegree()) + 90.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        for (float startDegree2 = (float) getStartDegree(); startDegree2 < ((float) getEndDegree()) - 10.0f; startDegree2 += 10.0f) {
            createBackgroundBitmapCanvas.rotate(10.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
            createBackgroundBitmapCanvas.drawPath(this.smallMarkPath, this.smallMarkPaint);
        }
        createBackgroundBitmapCanvas.restore();
        drawMarks(createBackgroundBitmapCanvas);
        if (getTickNumber() > 0) {
            drawTicks(createBackgroundBitmapCanvas);
        } else {
            drawDefMinMaxSpeedPosition(createBackgroundBitmapCanvas);
        }
    }

    public void setIndicator(@NotNull Indicator.Indicators indicators) {
        Intrinsics.checkParameterIsNotNull(indicators, "indicator");
        super.setIndicator(indicators);
        getIndicator().withEffects(this.withEffects);
    }
}
