package com.github.anastr.speedviewlib.components.indicators;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.anastr.speedviewlib.Speedometer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/NormalSmallIndicator;", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomY", "", "indicatorPath", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "degree", "getBottom", "getTop", "setWithEffects", "withEffects", "", "updateIndicator", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: NormalSmallIndicator.kt */
public final class NormalSmallIndicator extends Indicator<NormalSmallIndicator> {
    private float bottomY;
    private final Path indicatorPath = new Path();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalSmallIndicator(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setWidth(dpTOpx(12.0f));
    }

    public float getTop() {
        float viewSize = getViewSize() / 5.0f;
        Speedometer speedometer = getSpeedometer();
        if (speedometer == null) {
            Intrinsics.throwNpe();
        }
        return viewSize + ((float) speedometer.getPadding());
    }

    public float getBottom() {
        return this.bottomY;
    }

    public void draw(@NotNull Canvas canvas, float f) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        canvas.save();
        canvas.rotate(f + 90.0f, getCenterX(), getCenterY());
        canvas.drawPath(this.indicatorPath, getIndicatorPaint());
        canvas.restore();
    }

    public void updateIndicator() {
        this.indicatorPath.reset();
        Path path = this.indicatorPath;
        float centerX = getCenterX();
        float viewSize = getViewSize() / 5.0f;
        Speedometer speedometer = getSpeedometer();
        if (speedometer == null) {
            Intrinsics.throwNpe();
        }
        path.moveTo(centerX, viewSize + ((float) speedometer.getPadding()));
        float viewSize2 = (getViewSize() * 3.0f) / 5.0f;
        Speedometer speedometer2 = getSpeedometer();
        if (speedometer2 == null) {
            Intrinsics.throwNpe();
        }
        this.bottomY = viewSize2 + ((float) speedometer2.getPadding());
        this.indicatorPath.lineTo(getCenterX() - getWidth(), this.bottomY);
        this.indicatorPath.lineTo(getCenterX() + getWidth(), this.bottomY);
        this.indicatorPath.addArc(new RectF(getCenterX() - getWidth(), this.bottomY - getWidth(), getCenterX() + getWidth(), this.bottomY + getWidth()), 0.0f, 180.0f);
        getIndicatorPaint().setColor(getColor());
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
