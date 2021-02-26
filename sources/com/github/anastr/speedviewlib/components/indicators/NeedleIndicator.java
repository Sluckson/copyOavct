package com.github.anastr.speedviewlib.components.indicators;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.anastr.speedviewlib.Speedometer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/NeedleIndicator;", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomY", "", "circlePaint", "Landroid/graphics/Paint;", "circlePath", "Landroid/graphics/Path;", "indicatorPath", "draw", "", "canvas", "Landroid/graphics/Canvas;", "degree", "getBottom", "setWithEffects", "withEffects", "", "updateIndicator", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: NeedleIndicator.kt */
public final class NeedleIndicator extends Indicator<NeedleIndicator> {
    private float bottomY;
    private final Paint circlePaint = new Paint(1);
    private final Path circlePath = new Path();
    private final Path indicatorPath = new Path();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NeedleIndicator(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setWidth(dpTOpx(12.0f));
        this.circlePaint.setStyle(Paint.Style.STROKE);
    }

    public float getBottom() {
        return this.bottomY;
    }

    public void draw(@NotNull Canvas canvas, float f) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        canvas.save();
        canvas.rotate(f + 90.0f, getCenterX(), getCenterY());
        canvas.drawPath(this.indicatorPath, getIndicatorPaint());
        canvas.drawPath(this.circlePath, this.circlePaint);
        canvas.restore();
    }

    public void updateIndicator() {
        this.indicatorPath.reset();
        this.circlePath.reset();
        Path path = this.indicatorPath;
        float centerX = getCenterX();
        Speedometer speedometer = getSpeedometer();
        if (speedometer == null) {
            Intrinsics.throwNpe();
        }
        path.moveTo(centerX, (float) speedometer.getPadding());
        float width = ((float) (((double) getWidth()) * Math.sin(Math.toRadians(260.0d)))) + (getViewSize() * 0.5f);
        Speedometer speedometer2 = getSpeedometer();
        if (speedometer2 == null) {
            Intrinsics.throwNpe();
        }
        this.bottomY = width + ((float) speedometer2.getPadding());
        float width2 = ((float) (((double) getWidth()) * Math.cos(Math.toRadians(260.0d)))) + (getViewSize() * 0.5f);
        Speedometer speedometer3 = getSpeedometer();
        if (speedometer3 == null) {
            Intrinsics.throwNpe();
        }
        this.indicatorPath.lineTo(width2 + ((float) speedometer3.getPadding()), this.bottomY);
        this.indicatorPath.arcTo(new RectF(getCenterX() - getWidth(), getCenterY() - getWidth(), getCenterX() + getWidth(), getCenterY() + getWidth()), 260.0f, 20.0f);
        float width3 = getWidth() * 0.25f;
        this.circlePath.addCircle(getCenterX(), getCenterY(), (getWidth() - (0.5f * width3)) + 0.6f, Path.Direction.CW);
        getIndicatorPaint().setColor(getColor());
        this.circlePaint.setColor(getColor());
        this.circlePaint.setStrokeWidth(width3);
    }

    /* access modifiers changed from: protected */
    public void setWithEffects(boolean z) {
        if (z) {
            Speedometer speedometer = getSpeedometer();
            if (speedometer == null) {
                Intrinsics.throwNpe();
            }
            if (!speedometer.isInEditMode()) {
                getIndicatorPaint().setMaskFilter(new BlurMaskFilter(15.0f, BlurMaskFilter.Blur.SOLID));
                return;
            }
        }
        getIndicatorPaint().setMaskFilter((MaskFilter) null);
    }
}
