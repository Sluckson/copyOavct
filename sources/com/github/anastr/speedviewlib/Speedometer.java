package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.github.anastr.speedviewlib.components.Style;
import com.github.anastr.speedviewlib.components.indicators.Indicator;
import com.github.anastr.speedviewlib.components.indicators.NoIndicator;
import com.github.anastr.speedviewlib.components.note.Note;
import com.lowagie.text.pdf.codec.TIFFConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p052cz.msebera.android.httpclient.HttpStatus;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002¥\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010|\u001a\u00020}2\n\u0010~\u001a\u0006\u0012\u0002\b\u00030J2\t\b\u0002\u0010\u001a\u00030\u0001J\t\u0010\u0001\u001a\u00020}H\u0002J\t\u0010\u0001\u001a\u00020}H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0014J\t\u0010\u0001\u001a\u00020}H$J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0012\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012H\u0004J\t\u0010\u0001\u001a\u00020\u0007H\u0004J\u0011\u0010\u0001\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0004J\t\u0010\u0001\u001a\u00020\u0007H\u0004J\t\u0010\u0001\u001a\u00020}H\u0002J\u001b\u0010\u0001\u001a\u00020}2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\t\u0010\u0001\u001a\u00020}H\u0002J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u001b\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0014J-\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0014J\u0007\u0010\u0001\u001a\u00020}J\u000f\u0010 \u0001\u001a\u00020}2\u0006\u0010\u0016\u001a\u00020\u0007J\u0011\u0010\u001b\u001a\u00020}2\u0007\u0010\u0017\u001a\u00030¡\u0001H\u0016J\u000f\u0010¢\u0001\u001a\u00020}2\u0006\u0010d\u001a\u00020\u0007J\u0017\u0010£\u0001\u001a\u00020}2\u0006\u0010d\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\t\u0010¤\u0001\u001a\u00020}H\u0002R$\u0010\t\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R,\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u000e\u0010 \u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010$R$\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8F@FX\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u000e\u0010-\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\rR$\u00101\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010$R\u0014\u00104\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R$\u00109\u001a\u00020:2\u0006\u00109\u001a\u00020:8F@FX\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010$R$\u0010B\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000b\"\u0004\bD\u0010\rR$\u0010E\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010$R\u0018\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030J0IX\u0004¢\u0006\u0002\n\u0000R\u0001\u0010K\u001a<\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(P\u0012\u0006\u0012\u0004\u0018\u00010Q\u0018\u00010Lj\u0004\u0018\u0001`R2@\u0010K\u001a<\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(P\u0012\u0006\u0012\u0004\u0018\u00010Q\u0018\u00010Lj\u0004\u0018\u0001`R@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0011\u0010W\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bX\u0010\u000bR\u0011\u0010Y\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bZ\u0010\u000bR$\u0010[\u001a\u00020\\2\u0006\u0010[\u001a\u00020\\@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010a\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u00128V@VX\u000e¢\u0006\f\u001a\u0004\bb\u0010\u0015\"\u0004\bc\u0010$R\u000e\u0010d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010e\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010\rR$\u0010h\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\rR\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R0\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00120I2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00120I@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\bq\u0010\u0015R\u0014\u0010r\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\bs\u0010\u0015R\u0014\u0010t\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\bu\u0010\u0015R\u0014\u0010v\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\bw\u0010\u0015R\u0014\u0010x\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\by\u0010\u0015R\u0014\u0010z\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b{\u0010\u0015¨\u0006¦\u0001"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/Speedometer;", "Lcom/github/anastr/speedviewlib/Gauge;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundCircleColor", "getBackgroundCircleColor", "()I", "setBackgroundCircleColor", "(I)V", "circleBackPaint", "Landroid/graphics/Paint;", "cutPadding", "<set-?>", "", "degree", "getDegree", "()F", "endDegree", "indicator", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "getIndicator", "()Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "setIndicator", "(Lcom/github/anastr/speedviewlib/components/indicators/Indicator;)V", "indicatorLightColor", "getIndicatorLightColor", "setIndicatorLightColor", "indicatorLightPaint", "initTickPadding", "getInitTickPadding", "setInitTickPadding", "(F)V", "tickRotation", "", "isTickRotation", "()Z", "setTickRotation", "(Z)V", "isWithIndicatorLight", "setWithIndicatorLight", "lastPercentSpeed", "markColor", "getMarkColor", "setMarkColor", "markHeight", "getMarkHeight", "setMarkHeight", "markPaint", "getMarkPaint", "()Landroid/graphics/Paint;", "markPath", "Landroid/graphics/Path;", "markStyle", "Lcom/github/anastr/speedviewlib/components/Style;", "getMarkStyle", "()Lcom/github/anastr/speedviewlib/components/Style;", "setMarkStyle", "(Lcom/github/anastr/speedviewlib/components/Style;)V", "markWidth", "getMarkWidth", "setMarkWidth", "marksNumber", "getMarksNumber", "setMarksNumber", "marksPadding", "getMarksPadding", "setMarksPadding", "notes", "Ljava/util/ArrayList;", "Lcom/github/anastr/speedviewlib/components/note/Note;", "onPrintTickLabel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tickPosition", "tick", "", "Lcom/github/anastr/speedviewlib/util/OnPrintTickLabelListener;", "getOnPrintTickLabel", "()Lkotlin/jvm/functions/Function2;", "setOnPrintTickLabel", "(Lkotlin/jvm/functions/Function2;)V", "size", "getSize", "sizePa", "getSizePa", "speedometerMode", "Lcom/github/anastr/speedviewlib/Speedometer$Mode;", "getSpeedometerMode", "()Lcom/github/anastr/speedviewlib/Speedometer$Mode;", "setSpeedometerMode", "(Lcom/github/anastr/speedviewlib/Speedometer$Mode;)V", "speedometerWidth", "getSpeedometerWidth", "setSpeedometerWidth", "startDegree", "tickNumber", "getTickNumber", "setTickNumber", "tickPadding", "getTickPadding", "setTickPadding", "ticks", "getTicks", "()Ljava/util/ArrayList;", "setTicks", "(Ljava/util/ArrayList;)V", "viewBottom", "getViewBottom", "viewCenterX", "getViewCenterX", "viewCenterY", "getViewCenterY", "viewLeft", "getViewLeft", "viewRight", "getViewRight", "viewTop", "getViewTop", "addNote", "", "note", "showTimeMillisecond", "", "checkStartAndEndDegree", "checkTicks", "createBackgroundBitmapCanvas", "Landroid/graphics/Canvas;", "defaultSpeedometerValues", "drawDefMinMaxSpeedPosition", "c", "drawIndicator", "canvas", "drawIndicatorLight", "drawMarks", "drawNotes", "drawTicks", "getDegreeAtSpeed", "speed", "getEndDegree", "getSpeedAtDegree", "getStartDegree", "init", "initAttributeSet", "initAttributeValue", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldW", "oldH", "removeAllNotes", "setEndDegree", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator$Indicators;", "setStartDegree", "setStartEndDegree", "updateTranslated", "Mode", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: Speedometer.kt */
public abstract class Speedometer extends Gauge {
    private int backgroundCircleColor;
    private final Paint circleBackPaint;
    private int cutPadding;
    private float degree;
    private int endDegree;
    @NotNull
    private Indicator<?> indicator;
    private int indicatorLightColor;
    private final Paint indicatorLightPaint;
    private float initTickPadding;
    private boolean isWithIndicatorLight;
    private float lastPercentSpeed;
    private float markHeight;
    @NotNull
    private final Paint markPaint;
    private final Path markPath;
    private int marksNumber;
    private float marksPadding;
    /* access modifiers changed from: private */
    public final ArrayList<Note<?>> notes;
    @Nullable
    private Function2<? super Integer, ? super Float, ? extends CharSequence> onPrintTickLabel;
    @NotNull
    private Mode speedometerMode;
    private int startDegree;
    private int tickPadding;
    private boolean tickRotation;
    @NotNull
    private ArrayList<Float> ticks;

    @JvmOverloads
    public Speedometer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public Speedometer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public abstract void defaultSpeedometerValues();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Speedometer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.indicator = new NoIndicator(context);
        this.indicatorLightColor = (int) 3154073378L;
        this.circleBackPaint = new Paint(1);
        this.indicatorLightPaint = new Paint(1);
        this.markPaint = new Paint(1);
        this.markPath = new Path();
        this.markHeight = dpTOpx(9.0f);
        this.backgroundCircleColor = (int) 4294967295L;
        this.startDegree = 135;
        this.endDegree = HttpStatus.SC_METHOD_NOT_ALLOWED;
        this.degree = (float) this.startDegree;
        this.notes = new ArrayList<>();
        this.speedometerMode = Mode.NORMAL;
        this.ticks = new ArrayList<>();
        this.tickRotation = true;
        this.tickPadding = (int) (getSpeedometerWidth() + dpTOpx(3.0f));
        init();
        initAttributeSet(context, attributeSet);
        initAttributeValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Speedometer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @NotNull
    public final Indicator<?> getIndicator() {
        return this.indicator;
    }

    public final void setIndicator(@NotNull Indicator<?> indicator2) {
        Intrinsics.checkParameterIsNotNull(indicator2, "indicator");
        this.indicator.deleteObservers();
        indicator2.setTargetSpeedometer(this);
        this.indicator = indicator2;
        if (isAttachedToWindow()) {
            this.indicator.setTargetSpeedometer(this);
            invalidate();
        }
    }

    public final boolean isWithIndicatorLight() {
        return this.isWithIndicatorLight;
    }

    public final void setWithIndicatorLight(boolean z) {
        this.isWithIndicatorLight = z;
    }

    public final int getIndicatorLightColor() {
        return this.indicatorLightColor;
    }

    public final void setIndicatorLightColor(int i) {
        this.indicatorLightColor = i;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Paint getMarkPaint() {
        return this.markPaint;
    }

    public float getSpeedometerWidth() {
        return super.getSpeedometerWidth();
    }

    public void setSpeedometerWidth(float f) {
        super.setSpeedometerWidth(f);
        if (isAttachedToWindow()) {
            this.indicator.updateIndicator();
        }
    }

    public final int getMarksNumber() {
        return this.marksNumber;
    }

    public final void setMarksNumber(int i) {
        this.marksNumber = i;
        invalidateGauge();
    }

    public final int getMarkColor() {
        return this.markPaint.getColor();
    }

    public final void setMarkColor(int i) {
        this.markPaint.setColor(i);
    }

    public final float getMarksPadding() {
        return this.marksPadding;
    }

    public final void setMarksPadding(float f) {
        this.marksPadding = f;
        invalidateGauge();
    }

    public final float getMarkHeight() {
        return this.markHeight;
    }

    public final void setMarkHeight(float f) {
        this.markHeight = f;
        invalidateGauge();
    }

    public final float getMarkWidth() {
        return this.markPaint.getStrokeWidth();
    }

    public final void setMarkWidth(float f) {
        this.markPaint.setStrokeWidth(f);
        invalidateGauge();
    }

    @NotNull
    public final Style getMarkStyle() {
        return this.markPaint.getStrokeCap() == Paint.Cap.ROUND ? Style.ROUND : Style.BUTT;
    }

    public final void setMarkStyle(@NotNull Style style) {
        Intrinsics.checkParameterIsNotNull(style, "markStyle");
        if (style == Style.ROUND) {
            this.markPaint.setStrokeCap(Paint.Cap.ROUND);
        } else {
            this.markPaint.setStrokeCap(Paint.Cap.BUTT);
        }
        invalidateGauge();
    }

    public final int getBackgroundCircleColor() {
        return this.backgroundCircleColor;
    }

    public final void setBackgroundCircleColor(int i) {
        this.backgroundCircleColor = i;
        this.circleBackPaint.setColor(i);
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    public final float getDegree() {
        return this.degree;
    }

    @NotNull
    public final Mode getSpeedometerMode() {
        return this.speedometerMode;
    }

    public final void setSpeedometerMode(@NotNull Mode mode) {
        Intrinsics.checkParameterIsNotNull(mode, "speedometerMode");
        this.speedometerMode = mode;
        if (mode != Mode.NORMAL) {
            this.startDegree = mode.getMinDegree$speedviewlib_release();
            this.endDegree = mode.getMaxDegree$speedviewlib_release();
        }
        updateTranslated();
        cancelSpeedAnimator();
        this.degree = getDegreeAtSpeed(getSpeed());
        this.indicator.updateIndicator();
        if (isAttachedToWindow()) {
            requestLayout();
            invalidateGauge();
            tremble();
        }
    }

    @NotNull
    public final ArrayList<Float> getTicks() {
        return this.ticks;
    }

    public final void setTicks(@NotNull ArrayList<Float> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "ticks");
        this.ticks.clear();
        this.ticks.addAll(arrayList);
        checkTicks();
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    public final float getInitTickPadding() {
        return this.initTickPadding;
    }

    /* access modifiers changed from: protected */
    public final void setInitTickPadding(float f) {
        this.initTickPadding = f;
    }

    public final int getTickPadding() {
        return this.tickPadding;
    }

    public final void setTickPadding(int i) {
        this.tickPadding = i;
        invalidateGauge();
    }

    @Nullable
    public final Function2<Integer, Float, CharSequence> getOnPrintTickLabel() {
        return this.onPrintTickLabel;
    }

    public final void setOnPrintTickLabel(@Nullable Function2<? super Integer, ? super Float, ? extends CharSequence> function2) {
        this.onPrintTickLabel = function2;
        invalidateGauge();
    }

    public final int getSize() {
        if (this.speedometerMode == Mode.NORMAL) {
            return getWidth();
        }
        return this.speedometerMode.isHalf() ? Math.max(getWidth(), getHeight()) : (Math.max(getWidth(), getHeight()) * 2) - (this.cutPadding * 2);
    }

    public final int getSizePa() {
        return getSize() - (getPadding() * 2);
    }

    public final int getTickNumber() {
        return this.ticks.size();
    }

    public final void setTickNumber(int i) {
        if (i >= 0) {
            ArrayList arrayList = new ArrayList();
            float f = i == 1 ? 0.0f : 1.0f / ((float) (i - 1));
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(Float.valueOf(((float) i2) * f));
            }
            setTicks(arrayList);
            return;
        }
        throw new IllegalArgumentException("tickNumber mustn't be negative".toString());
    }

    public final boolean isTickRotation() {
        return this.tickRotation;
    }

    public final void setTickRotation(boolean z) {
        this.tickRotation = z;
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    public final float getViewCenterX() {
        switch (this.speedometerMode) {
            case LEFT:
            case TOP_LEFT:
            case BOTTOM_LEFT:
                return (((float) getSize()) * 0.5f) - (((float) getWidth()) * 0.5f);
            case RIGHT:
            case TOP_RIGHT:
            case BOTTOM_RIGHT:
                return (((float) getSize()) * 0.5f) + (((float) getWidth()) * 0.5f);
            default:
                return ((float) getSize()) * 0.5f;
        }
    }

    /* access modifiers changed from: protected */
    public final float getViewCenterY() {
        switch (this.speedometerMode) {
            case TOP:
            case TOP_LEFT:
            case TOP_RIGHT:
                return (((float) getSize()) * 0.5f) - (((float) getHeight()) * 0.5f);
            case BOTTOM:
            case BOTTOM_LEFT:
            case BOTTOM_RIGHT:
                return (((float) getSize()) * 0.5f) + (((float) getHeight()) * 0.5f);
            default:
                return ((float) getSize()) * 0.5f;
        }
    }

    /* access modifiers changed from: protected */
    public final float getViewLeft() {
        return getViewCenterX() - (((float) getWidth()) * 0.5f);
    }

    /* access modifiers changed from: protected */
    public final float getViewTop() {
        return getViewCenterY() - (((float) getHeight()) * 0.5f);
    }

    /* access modifiers changed from: protected */
    public final float getViewRight() {
        return getViewCenterX() + (((float) getWidth()) * 0.5f);
    }

    /* access modifiers changed from: protected */
    public final float getViewBottom() {
        return getViewCenterY() + (((float) getHeight()) * 0.5f);
    }

    private final void init() {
        this.indicatorLightPaint.setStyle(Paint.Style.STROKE);
        this.markPaint.setStyle(Paint.Style.STROKE);
        setMarkColor((int) 4294967295L);
        setMarkWidth(dpTOpx(3.0f));
        setMarkStyle(Style.BUTT);
        defaultSpeedometerValues();
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.Speedometer, 0, 0);
            int i = obtainStyledAttributes.getInt(C1083R.styleable.Speedometer_sv_speedometerMode, -1);
            if (!(i == -1 || i == 0)) {
                setSpeedometerMode(Mode.values()[i]);
            }
            int i2 = obtainStyledAttributes.getInt(C1083R.styleable.Speedometer_sv_indicator, -1);
            if (i2 != -1) {
                setIndicator(Indicator.Indicators.values()[i2]);
            }
            setMarksNumber(obtainStyledAttributes.getInt(C1083R.styleable.Speedometer_sv_marksNumber, this.marksNumber));
            setMarksPadding(obtainStyledAttributes.getDimension(C1083R.styleable.Speedometer_sv_marksPadding, this.marksPadding));
            setMarkHeight(obtainStyledAttributes.getDimension(C1083R.styleable.Speedometer_sv_markHeight, this.markHeight));
            setMarkWidth(obtainStyledAttributes.getDimension(C1083R.styleable.Speedometer_sv_markWidth, getMarkWidth()));
            setMarkColor(obtainStyledAttributes.getColor(C1083R.styleable.Speedometer_sv_markColor, getMarkColor()));
            int i3 = obtainStyledAttributes.getInt(C1083R.styleable.Speedometer_sv_markStyle, -1);
            if (i3 != -1) {
                setMarkStyle(Style.values()[i3]);
            }
            setBackgroundCircleColor(obtainStyledAttributes.getColor(C1083R.styleable.Speedometer_sv_backgroundCircleColor, this.backgroundCircleColor));
            this.startDegree = obtainStyledAttributes.getInt(C1083R.styleable.Speedometer_sv_startDegree, this.startDegree);
            this.endDegree = obtainStyledAttributes.getInt(C1083R.styleable.Speedometer_sv_endDegree, this.endDegree);
            this.indicator.setWidth(obtainStyledAttributes.getDimension(C1083R.styleable.Speedometer_sv_indicatorWidth, this.indicator.getWidth()));
            this.cutPadding = (int) obtainStyledAttributes.getDimension(C1083R.styleable.Speedometer_sv_cutPadding, (float) this.cutPadding);
            setTickNumber(obtainStyledAttributes.getInteger(C1083R.styleable.Speedometer_sv_tickNumber, this.ticks.size()));
            this.tickRotation = obtainStyledAttributes.getBoolean(C1083R.styleable.Speedometer_sv_tickRotation, this.tickRotation);
            setTickPadding((int) obtainStyledAttributes.getDimension(C1083R.styleable.Speedometer_sv_tickPadding, (float) this.tickPadding));
            this.indicator.setColor(obtainStyledAttributes.getColor(C1083R.styleable.Speedometer_sv_indicatorColor, this.indicator.getColor()));
            this.isWithIndicatorLight = obtainStyledAttributes.getBoolean(C1083R.styleable.Speedometer_sv_withIndicatorLight, this.isWithIndicatorLight);
            this.indicatorLightColor = obtainStyledAttributes.getColor(C1083R.styleable.Speedometer_sv_indicatorLightColor, this.indicatorLightColor);
            int i4 = obtainStyledAttributes.getInt(C1083R.styleable.Speedometer_sv_tickTextFormat, -1);
            if (i4 == 0) {
                setOnPrintTickLabel(new Speedometer$initAttributeSet$1(this));
            } else if (i4 == 1) {
                setOnPrintTickLabel(new Speedometer$initAttributeSet$2(this));
            }
            this.degree = (float) this.startDegree;
            obtainStyledAttributes.recycle();
            checkStartAndEndDegree();
        }
    }

    private final void initAttributeValue() {
        this.circleBackPaint.setColor(this.backgroundCircleColor);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int dpTOpx = (int) dpTOpx(250.0f);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            size = Math.min(size, size2);
        } else if (mode != 1073741824) {
            size = mode2 == 1073741824 ? size2 : ((mode == 0 && mode2 == 0) || (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE)) ? Math.min(dpTOpx, Math.min(size, size2)) : mode == Integer.MIN_VALUE ? Math.min(dpTOpx, size) : Math.min(dpTOpx, size2);
        }
        int max = Math.max(size, Math.max(getSuggestedMinimumWidth(), getSuggestedMinimumHeight()));
        int divWidth$speedviewlib_release = max / this.speedometerMode.getDivWidth$speedviewlib_release();
        int divHeight$speedviewlib_release = max / this.speedometerMode.getDivHeight$speedviewlib_release();
        if (this.speedometerMode.isHalf()) {
            if (this.speedometerMode.getDivWidth$speedviewlib_release() == 2) {
                divWidth$speedviewlib_release += this.cutPadding;
            } else {
                divHeight$speedviewlib_release += this.cutPadding;
            }
        }
        setMeasuredDimension(divWidth$speedviewlib_release, divHeight$speedviewlib_release);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.indicator.updateIndicator();
        updateTranslated();
    }

    private final void checkStartAndEndDegree() {
        boolean z = true;
        if (this.startDegree >= 0) {
            if (this.endDegree >= 0) {
                if (this.startDegree < this.endDegree) {
                    if (this.endDegree - this.startDegree <= 360) {
                        if (this.startDegree >= this.speedometerMode.getMinDegree$speedviewlib_release()) {
                            if (this.endDegree > this.speedometerMode.getMaxDegree$speedviewlib_release()) {
                                z = false;
                            }
                            if (!z) {
                                throw new IllegalArgumentException(("EndDegree must be smaller than " + this.speedometerMode.getMaxDegree$speedviewlib_release() + " in " + this.speedometerMode + " Mode !").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException(("StartDegree must be bigger than " + this.speedometerMode.getMinDegree$speedviewlib_release() + " in " + this.speedometerMode + " Mode !").toString());
                    }
                    throw new IllegalArgumentException("(EndDegree - StartDegree) must be smaller than 360 !".toString());
                }
                throw new IllegalArgumentException("EndDegree must be bigger than StartDegree !".toString());
            }
            throw new IllegalArgumentException("EndDegree can't be Negative".toString());
        }
        throw new IllegalArgumentException("StartDegree can't be Negative".toString());
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        this.degree = getDegreeAtSpeed(getCurrentSpeed());
    }

    /* access modifiers changed from: protected */
    public final void drawMarks(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        this.markPath.reset();
        this.markPath.moveTo(((float) getSize()) * 0.5f, this.marksPadding + ((float) getPadding()));
        this.markPath.lineTo(((float) getSize()) * 0.5f, this.marksPadding + this.markHeight + ((float) getPadding()));
        canvas.save();
        canvas.rotate(((float) getStartDegree()) + 90.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        int i = this.marksNumber;
        float endDegree2 = ((float) (getEndDegree() - getStartDegree())) / (((float) i) + 1.0f);
        int i2 = 1;
        if (1 <= i) {
            while (true) {
                canvas.rotate(endDegree2, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
                canvas.drawPath(this.markPath, this.markPaint);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public final void drawIndicator(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        if (this.isWithIndicatorLight) {
            drawIndicatorLight(canvas);
        }
        this.indicator.draw(canvas, this.degree);
    }

    /* access modifiers changed from: protected */
    public final void drawIndicatorLight(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        float abs = Math.abs(getPercentSpeed() - this.lastPercentSpeed) * 30.0f;
        this.lastPercentSpeed = getPercentSpeed();
        float f = abs > 30.0f ? 30.0f : abs;
        this.indicatorLightPaint.setShader(new SweepGradient(((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f, new int[]{this.indicatorLightColor, 16777215}, new float[]{0.0f, f / 360.0f}));
        this.indicatorLightPaint.setStrokeWidth(this.indicator.getLightBottom() - this.indicator.getTop());
        float top = this.indicator.getTop() + (this.indicatorLightPaint.getStrokeWidth() * 0.5f);
        RectF rectF = new RectF(top, top, ((float) getSize()) - top, ((float) getSize()) - top);
        canvas.save();
        canvas.rotate(this.degree, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        if (isSpeedIncrease()) {
            canvas.scale(1.0f, -1.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        }
        canvas.drawArc(rectF, 0.0f, f, false, this.indicatorLightPaint);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public final void drawNotes(@NotNull Canvas canvas) {
        float f;
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Iterator<Note<?>> it = this.notes.iterator();
        while (it.hasNext()) {
            Note next = it.next();
            if (next.getPosition() == Note.Position.CenterSpeedometer) {
                next.draw(canvas, ((float) getWidth()) * 0.5f, ((float) getHeight()) * 0.5f);
            } else {
                switch (next.getPosition()) {
                    case TopIndicator:
                        f = this.indicator.getTop();
                        break;
                    case CenterIndicator:
                        f = (this.indicator.getTop() + this.indicator.getBottom()) * 0.5f;
                        break;
                    case BottomIndicator:
                        f = this.indicator.getBottom();
                        break;
                    case TopSpeedometer:
                        f = (float) getPadding();
                        break;
                    case QuarterSpeedometer:
                        f = (((float) getHeightPa()) * 0.25f) + ((float) getPadding());
                        break;
                    case CenterSpeedometer:
                        f = getViewCenterY();
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                canvas.save();
                canvas.rotate(this.degree + 90.0f, ((float) getWidth()) * 0.5f, ((float) getHeight()) * 0.5f);
                canvas.rotate(-(this.degree + 90.0f), ((float) getWidth()) * 0.5f, f);
                next.draw(canvas, ((float) getWidth()) * 0.5f, f);
                canvas.restore();
            }
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Canvas createBackgroundBitmapCanvas() {
        if (getSize() == 0) {
            return new Canvas();
        }
        Bitmap createBitmap = Bitmap.createBitmap(getSize(), getSize(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(size… Bitmap.Config.ARGB_8888)");
        setBackgroundBitmap(createBitmap);
        Canvas canvas = new Canvas(getBackgroundBitmap());
        canvas.drawCircle(((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f, (((float) getSize()) * 0.5f) - ((float) getPadding()), this.circleBackPaint);
        canvas.clipRect(0, 0, getSize(), getSize());
        return canvas;
    }

    /* access modifiers changed from: protected */
    public final float getDegreeAtSpeed(float f) {
        return (((f - getMinSpeed()) * ((float) (this.endDegree - this.startDegree))) / (getMaxSpeed() - getMinSpeed())) + ((float) this.startDegree);
    }

    /* access modifiers changed from: protected */
    public final float getSpeedAtDegree(float f) {
        return (((f - ((float) this.startDegree)) * (getMaxSpeed() - getMinSpeed())) / ((float) (this.endDegree - this.startDegree))) + getMinSpeed();
    }

    /* access modifiers changed from: protected */
    public final int getStartDegree() {
        return this.startDegree;
    }

    public final void setStartDegree(int i) {
        setStartEndDegree(i, this.endDegree);
    }

    /* access modifiers changed from: protected */
    public final int getEndDegree() {
        return this.endDegree;
    }

    public final void setEndDegree(int i) {
        setStartEndDegree(this.startDegree, i);
    }

    public final void setStartEndDegree(int i, int i2) {
        this.startDegree = i;
        this.endDegree = i2;
        checkStartAndEndDegree();
        cancelSpeedAnimator();
        this.degree = getDegreeAtSpeed(getSpeed());
        if (isAttachedToWindow()) {
            invalidateGauge();
            tremble();
        }
    }

    public static /* synthetic */ void addNote$default(Speedometer speedometer, Note note, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                j = 3000;
            }
            speedometer.addNote(note, j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNote");
    }

    public final void addNote(@NotNull Note<?> note, long j) {
        Intrinsics.checkParameterIsNotNull(note, "note");
        note.build(getWidth());
        this.notes.add(note);
        if (j != ((long) -1)) {
            postDelayed(new Speedometer$addNote$1(this, note), j);
            invalidate();
        }
    }

    public final void removeAllNotes() {
        this.notes.clear();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public final void drawDefMinMaxSpeedPosition(@NotNull Canvas canvas) {
        Paint.Align align;
        CharSequence charSequence;
        Paint.Align align2;
        Canvas canvas2 = canvas;
        Intrinsics.checkParameterIsNotNull(canvas2, "c");
        TextPaint textPaint = getTextPaint();
        int i = this.startDegree;
        if (i % 360 <= 90) {
            align = Paint.Align.RIGHT;
        } else if (i % 360 <= 180) {
            align = Paint.Align.LEFT;
        } else if (i % 360 <= 270) {
            align = Paint.Align.CENTER;
        } else {
            align = Paint.Align.RIGHT;
        }
        textPaint.setTextAlign(align);
        CharSequence charSequence2 = null;
        Function2<? super Integer, ? super Float, ? extends CharSequence> function2 = this.onPrintTickLabel;
        if (function2 != null) {
            if (function2 == null) {
                Intrinsics.throwNpe();
            }
            charSequence = (CharSequence) function2.invoke(0, Float.valueOf(getMinSpeed()));
        } else {
            charSequence = charSequence2;
        }
        if (charSequence == null) {
            Locale locale = getLocale();
            Object[] objArr = {Float.valueOf(getMinSpeed())};
            String format = String.format(locale, "%.0f", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, this, *args)");
            charSequence = format;
        }
        canvas.save();
        canvas2.rotate(((float) this.startDegree) + 90.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        canvas2.rotate(-(((float) this.startDegree) + 90.0f), ((((float) getSizePa()) * 0.5f) - getTextPaint().getTextSize()) + ((float) getPadding()), getTextPaint().getTextSize() + ((float) getPadding()));
        canvas2.drawText(charSequence.toString(), ((((float) getSizePa()) * 0.5f) - getTextPaint().getTextSize()) + ((float) getPadding()), getTextPaint().getTextSize() + ((float) getPadding()), getTextPaint());
        canvas.restore();
        TextPaint textPaint2 = getTextPaint();
        int i2 = this.endDegree;
        if (i2 % 360 <= 90) {
            align2 = Paint.Align.RIGHT;
        } else if (i2 % 360 <= 180) {
            align2 = Paint.Align.LEFT;
        } else if (i2 % 360 <= 270) {
            align2 = Paint.Align.CENTER;
        } else {
            align2 = Paint.Align.RIGHT;
        }
        textPaint2.setTextAlign(align2);
        Function2<? super Integer, ? super Float, ? extends CharSequence> function22 = this.onPrintTickLabel;
        if (function22 != null) {
            if (function22 == null) {
                Intrinsics.throwNpe();
            }
            charSequence2 = (CharSequence) function22.invoke(1, Float.valueOf(getMaxSpeed()));
        }
        if (charSequence2 == null) {
            Locale locale2 = getLocale();
            Object[] objArr2 = {Float.valueOf(getMaxSpeed())};
            String format2 = String.format(locale2, "%.0f", Arrays.copyOf(objArr2, objArr2.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(locale, this, *args)");
            charSequence2 = format2;
        }
        canvas.save();
        canvas2.rotate(((float) this.endDegree) + 90.0f, ((float) getSize()) * 0.5f, ((float) getSize()) * 0.5f);
        canvas2.rotate(-(((float) this.endDegree) + 90.0f), (((float) getSizePa()) * 0.5f) + getTextPaint().getTextSize() + ((float) getPadding()), getTextPaint().getTextSize() + ((float) getPadding()));
        canvas2.drawText(charSequence2.toString(), (((float) getSizePa()) * 0.5f) + getTextPaint().getTextSize() + ((float) getPadding()), getTextPaint().getTextSize() + ((float) getPadding()), getTextPaint());
        canvas.restore();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: java.lang.CharSequence} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void drawTicks(@org.jetbrains.annotations.NotNull android.graphics.Canvas r15) {
        /*
            r14 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            java.util.ArrayList<java.lang.Float> r0 = r14.ticks
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            android.text.TextPaint r0 = r14.getTextPaint()
            android.graphics.Paint$Align r1 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r1)
            int r0 = r14.endDegree
            int r1 = r14.startDegree
            int r0 = r0 - r1
            java.util.ArrayList<java.lang.Float> r1 = r14.ticks
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
        L_0x0026:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00f4
            java.lang.Object r4 = r1.next()
            int r5 = r3 + 1
            if (r3 >= 0) goto L_0x0037
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0037:
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r6 = r14.startDegree
            float r6 = (float) r6
            float r7 = (float) r0
            float r7 = r7 * r4
            float r6 = r6 + r7
            r15.save()
            r4 = 1119092736(0x42b40000, float:90.0)
            float r4 = r4 + r6
            int r7 = r14.getSize()
            float r7 = (float) r7
            r8 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 * r8
            int r9 = r14.getSize()
            float r9 = (float) r9
            float r9 = r9 * r8
            r15.rotate(r4, r7, r9)
            boolean r7 = r14.tickRotation
            if (r7 != 0) goto L_0x0081
            float r4 = -r4
            int r7 = r14.getSize()
            float r7 = (float) r7
            float r7 = r7 * r8
            float r8 = r14.initTickPadding
            android.text.TextPaint r9 = r14.getTextPaint()
            float r9 = r9.getTextSize()
            float r8 = r8 + r9
            int r9 = r14.getPadding()
            float r9 = (float) r9
            float r8 = r8 + r9
            int r9 = r14.tickPadding
            float r9 = (float) r9
            float r8 = r8 + r9
            r15.rotate(r4, r7, r8)
        L_0x0081:
            r4 = 0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Float, ? extends java.lang.CharSequence> r7 = r14.onPrintTickLabel
            if (r7 == 0) goto L_0x00a0
            if (r7 != 0) goto L_0x008d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x008d:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            float r4 = r14.getSpeedAtDegree(r6)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r3 = r7.invoke(r3, r4)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        L_0x00a0:
            if (r4 != 0) goto L_0x00c6
            java.util.Locale r3 = r14.getLocale()
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            float r6 = r14.getSpeedAtDegree(r6)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r4[r2] = r6
            int r6 = r4.length
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r6)
            java.lang.String r6 = "%.0f"
            java.lang.String r3 = java.lang.String.format(r3, r6, r4)
            java.lang.String r4 = "java.lang.String.format(locale, this, *args)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        L_0x00c6:
            r7 = r4
            r3 = 0
            float r4 = r14.initTickPadding
            int r6 = r14.getPadding()
            float r6 = (float) r6
            float r4 = r4 + r6
            int r6 = r14.tickPadding
            float r6 = (float) r6
            float r4 = r4 + r6
            r15.translate(r3, r4)
            android.text.StaticLayout r3 = new android.text.StaticLayout
            android.text.TextPaint r8 = r14.getTextPaint()
            int r9 = r14.getSize()
            android.text.Layout$Alignment r10 = android.text.Layout.Alignment.ALIGN_CENTER
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r13 = 0
            r6 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r3.draw(r15)
            r15.restore()
            r3 = r5
            goto L_0x0026
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.anastr.speedviewlib.Speedometer.drawTicks(android.graphics.Canvas):void");
    }

    public void setIndicator(@NotNull Indicator.Indicators indicators) {
        Intrinsics.checkParameterIsNotNull(indicators, "indicator");
        Indicator.Companion companion = Indicator.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setIndicator(companion.createIndicator(context, this, indicators));
    }

    private final void checkTicks() {
        boolean z;
        Iterator<Float> it = this.ticks.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < 0.0f || next.floatValue() > 1.0f) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (!z) {
                throw new IllegalArgumentException("ticks must be between [0f, 1f] !!".toString());
            }
        }
    }

    private final void updateTranslated() {
        float f = 0.0f;
        setTranslatedDx(this.speedometerMode.isRight() ? (((float) (-getSize())) * 0.5f) + ((float) this.cutPadding) : 0.0f);
        if (this.speedometerMode.isBottom()) {
            f = (((float) (-getSize())) * 0.5f) + ((float) this.cutPadding);
        }
        setTranslatedDy(f);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bj\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/Speedometer$Mode;", "", "minDegree", "", "maxDegree", "isHalf", "", "divWidth", "divHeight", "(Ljava/lang/String;IIIZII)V", "getDivHeight$speedviewlib_release", "()I", "getDivWidth$speedviewlib_release", "isBottom", "()Z", "isLeft", "isQuarter", "isRight", "isTop", "getMaxDegree$speedviewlib_release", "getMinDegree$speedviewlib_release", "NORMAL", "LEFT", "TOP", "RIGHT", "BOTTOM", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Speedometer.kt */
    public enum Mode {
        NORMAL(0, 720, false, 1, 1),
        LEFT(90, TIFFConstants.TIFFTAG_IMAGEDESCRIPTION, true, 2, 1),
        TOP(180, 360, true, 1, 2),
        RIGHT(TIFFConstants.TIFFTAG_IMAGEDESCRIPTION, 450, true, 2, 1),
        BOTTOM(0, 180, true, 1, 2),
        TOP_LEFT(180, TIFFConstants.TIFFTAG_IMAGEDESCRIPTION, false, 1, 1),
        TOP_RIGHT(TIFFConstants.TIFFTAG_IMAGEDESCRIPTION, 360, false, 1, 1),
        BOTTOM_RIGHT(0, 90, false, 1, 1),
        BOTTOM_LEFT(90, 180, false, 1, 1);
        
        private final int divHeight;
        private final int divWidth;
        private final boolean isHalf;
        private final int maxDegree;
        private final int minDegree;

        private Mode(int i, int i2, boolean z, int i3, int i4) {
            this.minDegree = i;
            this.maxDegree = i2;
            this.isHalf = z;
            this.divWidth = i3;
            this.divHeight = i4;
        }

        public final int getDivHeight$speedviewlib_release() {
            return this.divHeight;
        }

        public final int getDivWidth$speedviewlib_release() {
            return this.divWidth;
        }

        public final int getMaxDegree$speedviewlib_release() {
            return this.maxDegree;
        }

        public final int getMinDegree$speedviewlib_release() {
            return this.minDegree;
        }

        public final boolean isHalf() {
            return this.isHalf;
        }

        public final boolean isLeft() {
            Mode mode = this;
            return mode == LEFT || mode == TOP_LEFT || mode == BOTTOM_LEFT;
        }

        public final boolean isTop() {
            Mode mode = this;
            return mode == TOP || mode == TOP_LEFT || mode == TOP_RIGHT;
        }

        public final boolean isRight() {
            Mode mode = this;
            return mode == RIGHT || mode == TOP_RIGHT || mode == BOTTOM_RIGHT;
        }

        public final boolean isBottom() {
            Mode mode = this;
            return mode == BOTTOM || mode == BOTTOM_LEFT || mode == BOTTOM_RIGHT;
        }

        public final boolean isQuarter() {
            return !this.isHalf && this != NORMAL;
        }
    }
}
