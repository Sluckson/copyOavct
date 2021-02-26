package com.github.anastr.speedviewlib.components.indicators;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.anastr.speedviewlib.Speedometer;
import com.github.anastr.speedviewlib.components.indicators.Indicator;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 4*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u000245B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000eH&J\b\u0010(\u001a\u00020\u000eH\u0016J\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eJ\u0006\u0010+\u001a\u00020\u000eJ\b\u0010,\u001a\u00020\u000eH\u0016J\u0006\u0010-\u001a\u00020\u000eJ\u0013\u0010.\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H$J\b\u00103\u001a\u00020$H&J\u000e\u00101\u001a\u00020$2\u0006\u00101\u001a\u000202R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00066"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "I", "Ljava/util/Observable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "indicatorColor", "", "color", "getColor", "()I", "setColor", "(I)V", "density", "", "indicatorPaint", "Landroid/graphics/Paint;", "getIndicatorPaint", "()Landroid/graphics/Paint;", "setIndicatorPaint", "(Landroid/graphics/Paint;)V", "speedometer", "Lcom/github/anastr/speedviewlib/Speedometer;", "getSpeedometer", "()Lcom/github/anastr/speedviewlib/Speedometer;", "setSpeedometer", "(Lcom/github/anastr/speedviewlib/Speedometer;)V", "indicatorWidth", "width", "getWidth", "()F", "setWidth", "(F)V", "dpTOpx", "dp", "draw", "", "canvas", "Landroid/graphics/Canvas;", "degree", "getBottom", "getCenterX", "getCenterY", "getLightBottom", "getTop", "getViewSize", "setTargetSpeedometer", "(Lcom/github/anastr/speedviewlib/Speedometer;)Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "setWithEffects", "withEffects", "", "updateIndicator", "Companion", "Indicators", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: Indicator.kt */
public abstract class Indicator<I extends Indicator<? extends I>> extends Observable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int color;
    private final float density;
    @NotNull
    private Paint indicatorPaint = new Paint(1);
    @Nullable
    private Speedometer speedometer;
    private float width;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/Indicator$Indicators;", "", "(Ljava/lang/String;I)V", "NoIndicator", "NormalIndicator", "NormalSmallIndicator", "TriangleIndicator", "SpindleIndicator", "LineIndicator", "HalfLineIndicator", "QuarterLineIndicator", "KiteIndicator", "NeedleIndicator", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Indicator.kt */
    public enum Indicators {
        NoIndicator,
        NormalIndicator,
        NormalSmallIndicator,
        TriangleIndicator,
        SpindleIndicator,
        LineIndicator,
        HalfLineIndicator,
        QuarterLineIndicator,
        KiteIndicator,
        NeedleIndicator
    }

    public abstract void draw(@NotNull Canvas canvas, float f);

    /* access modifiers changed from: protected */
    public abstract void setWithEffects(boolean z);

    public abstract void updateIndicator();

    public Indicator(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        this.density = resources.getDisplayMetrics().density;
        this.color = (int) 4280391411L;
        this.indicatorPaint.setColor(this.color);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Paint getIndicatorPaint() {
        return this.indicatorPaint;
    }

    /* access modifiers changed from: protected */
    public final void setIndicatorPaint(@NotNull Paint paint) {
        Intrinsics.checkParameterIsNotNull(paint, "<set-?>");
        this.indicatorPaint = paint;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Speedometer getSpeedometer() {
        return this.speedometer;
    }

    /* access modifiers changed from: protected */
    public final void setSpeedometer(@Nullable Speedometer speedometer2) {
        this.speedometer = speedometer2;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setWidth(float f) {
        this.width = f;
        if (this.speedometer != null) {
            updateIndicator();
        }
        setChanged();
        notifyObservers((Object) null);
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i) {
        this.color = i;
        if (this.speedometer != null) {
            updateIndicator();
        }
        setChanged();
        notifyObservers((Object) null);
    }

    public float getTop() {
        Speedometer speedometer2 = this.speedometer;
        if (speedometer2 == null) {
            return 0.0f;
        }
        if (speedometer2 == null) {
            Intrinsics.throwNpe();
        }
        return (float) speedometer2.getPadding();
    }

    public float getBottom() {
        return getCenterY();
    }

    public final float getLightBottom() {
        return getCenterY() > getBottom() ? getBottom() : getCenterY();
    }

    public final float getCenterX() {
        Speedometer speedometer2 = this.speedometer;
        if (speedometer2 == null) {
            return 0.0f;
        }
        if (speedometer2 == null) {
            Intrinsics.throwNpe();
        }
        return ((float) speedometer2.getSize()) / 2.0f;
    }

    public final float getCenterY() {
        Speedometer speedometer2 = this.speedometer;
        if (speedometer2 == null) {
            return 0.0f;
        }
        if (speedometer2 == null) {
            Intrinsics.throwNpe();
        }
        return ((float) speedometer2.getSize()) / 2.0f;
    }

    @NotNull
    public final I setTargetSpeedometer(@NotNull Speedometer speedometer2) {
        Intrinsics.checkParameterIsNotNull(speedometer2, "speedometer");
        deleteObservers();
        addObserver(speedometer2);
        this.speedometer = speedometer2;
        updateIndicator();
        return this;
    }

    public final float dpTOpx(float f) {
        return f * this.density;
    }

    public final float getViewSize() {
        Speedometer speedometer2 = this.speedometer;
        if (speedometer2 != null) {
            return ((float) speedometer2.getSize()) - (((float) speedometer2.getPadding()) * 2.0f);
        }
        return 0.0f;
    }

    public final void withEffects(boolean z) {
        setWithEffects(z);
        if (this.speedometer != null) {
            updateIndicator();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/Indicator$Companion;", "", "()V", "createIndicator", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "context", "Landroid/content/Context;", "speedometer", "Lcom/github/anastr/speedviewlib/Speedometer;", "indicator", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator$Indicators;", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Indicator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Indicator<?> createIndicator(@NotNull Context context, @NotNull Speedometer speedometer, @NotNull Indicators indicators) {
            Indicator indicator;
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(speedometer, "speedometer");
            Intrinsics.checkParameterIsNotNull(indicators, "indicator");
            switch (indicators) {
                case NoIndicator:
                    indicator = new NoIndicator(context);
                    break;
                case NormalIndicator:
                    indicator = new NormalIndicator(context);
                    break;
                case NormalSmallIndicator:
                    indicator = new NormalSmallIndicator(context);
                    break;
                case TriangleIndicator:
                    indicator = new TriangleIndicator(context);
                    break;
                case SpindleIndicator:
                    indicator = new SpindleIndicator(context);
                    break;
                case LineIndicator:
                    indicator = new LineIndicator(context, 1.0f);
                    break;
                case HalfLineIndicator:
                    indicator = new LineIndicator(context, 0.5f);
                    break;
                case QuarterLineIndicator:
                    indicator = new LineIndicator(context, 0.25f);
                    break;
                case KiteIndicator:
                    indicator = new KiteIndicator(context);
                    break;
                case NeedleIndicator:
                    indicator = new NeedleIndicator(context);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return indicator.setTargetSpeedometer(speedometer);
        }
    }
}
