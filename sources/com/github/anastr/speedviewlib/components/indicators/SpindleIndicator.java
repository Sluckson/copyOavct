package com.github.anastr.speedviewlib.components.indicators;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Path;
import com.github.anastr.speedviewlib.Speedometer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/SpindleIndicator;", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "indicatorPath", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "degree", "", "getTop", "setWithEffects", "withEffects", "", "updateIndicator", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: SpindleIndicator.kt */
public final class SpindleIndicator extends Indicator<SpindleIndicator> {
    private final Path indicatorPath = new Path();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpindleIndicator(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setWidth(dpTOpx(16.0f));
    }

    public float getTop() {
        float viewSize = getViewSize() * 0.18f;
        Speedometer speedometer = getSpeedometer();
        if (speedometer == null) {
            Intrinsics.throwNpe();
        }
        return viewSize + ((float) speedometer.getPadding());
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
        this.indicatorPath.moveTo(getCenterX(), getCenterY());
        Path path = this.indicatorPath;
        float centerX = getCenterX() - getWidth();
        float viewSize = getViewSize() * 0.34f;
        Speedometer speedometer = getSpeedometer();
        if (speedometer == null) {
            Intrinsics.throwNpe();
        }
        float padding = viewSize + ((float) speedometer.getPadding());
        float centerX2 = getCenterX();
        float viewSize2 = getViewSize() * 0.18f;
        Speedometer speedometer2 = getSpeedometer();
        if (speedometer2 == null) {
            Intrinsics.throwNpe();
        }
        path.quadTo(centerX, padding, centerX2, viewSize2 + ((float) speedometer2.getPadding()));
        Path path2 = this.indicatorPath;
        float centerX3 = getCenterX() + getWidth();
        float viewSize3 = getViewSize() * 0.34f;
        Speedometer speedometer3 = getSpeedometer();
        if (speedometer3 == null) {
            Intrinsics.throwNpe();
        }
        path2.quadTo(centerX3, viewSize3 + ((float) speedometer3.getPadding()), getCenterX(), getCenterY());
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
