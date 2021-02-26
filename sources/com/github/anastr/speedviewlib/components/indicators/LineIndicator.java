package com.github.anastr.speedviewlib.components.indicators;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.anastr.speedviewlib.Speedometer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/LineIndicator;", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "context", "Landroid/content/Context;", "mode", "", "(Landroid/content/Context;F)V", "indicatorPath", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "degree", "getBottom", "setWithEffects", "withEffects", "", "updateIndicator", "Companion", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: LineIndicator.kt */
public final class LineIndicator extends Indicator<LineIndicator> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float HALF_LINE = 0.5f;
    public static final float LINE = 1.0f;
    public static final float QUARTER_LINE = 0.25f;
    private final Path indicatorPath = new Path();
    private final float mode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LineIndicator(@NotNull Context context, float f) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mode = f;
        setWidth(dpTOpx(8.0f));
    }

    public float getBottom() {
        return getCenterY() * this.mode;
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
        Speedometer speedometer = getSpeedometer();
        if (speedometer == null) {
            Intrinsics.throwNpe();
        }
        path.moveTo(centerX, (float) speedometer.getPadding());
        this.indicatorPath.lineTo(getCenterX(), getCenterY() * this.mode);
        getIndicatorPaint().setStyle(Paint.Style.STROKE);
        getIndicatorPaint().setStrokeWidth(getWidth());
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/LineIndicator$Companion;", "", "()V", "HALF_LINE", "", "LINE", "QUARTER_LINE", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: LineIndicator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
