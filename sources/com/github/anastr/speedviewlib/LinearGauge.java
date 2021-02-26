package com.github.anastr.speedviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.lowagie.text.ElementTags;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0001\"B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0004J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0014J(\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\b\u0010 \u001a\u00020\u0018H\u0014J\b\u0010!\u001a\u00020\u0018H$R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/LinearGauge;", "Lcom/github/anastr/speedviewlib/Gauge;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "foregroundBitmap", "Landroid/graphics/Bitmap;", "orientation", "Lcom/github/anastr/speedviewlib/LinearGauge$Orientation;", "getOrientation", "()Lcom/github/anastr/speedviewlib/LinearGauge$Orientation;", "setOrientation", "(Lcom/github/anastr/speedviewlib/LinearGauge$Orientation;)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/Rect;", "createForegroundBitmapCanvas", "Landroid/graphics/Canvas;", "initAttributeSet", "", "onDraw", "canvas", "onSizeChanged", "w", "h", "oldW", "oldH", "updateBackgroundBitmap", "updateFrontAndBackBitmaps", "Orientation", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: LinearGauge.kt */
public abstract class LinearGauge extends Gauge {
    private Bitmap foregroundBitmap;
    @NotNull
    private Orientation orientation;
    private final Paint paint;
    private final Rect rect;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/LinearGauge$Orientation;", "", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: LinearGauge.kt */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    @JvmOverloads
    public LinearGauge(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public LinearGauge(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public abstract void updateFrontAndBackBitmaps();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LinearGauge(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.paint = new Paint(1);
        this.rect = new Rect();
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.foregroundBitmap = createBitmap;
        this.orientation = Orientation.HORIZONTAL;
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinearGauge(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(@NotNull Orientation orientation2) {
        Intrinsics.checkParameterIsNotNull(orientation2, ElementTags.ORIENTATION);
        this.orientation = orientation2;
        if (isAttachedToWindow()) {
            requestLayout();
            invalidateGauge();
        }
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.LinearGauge, 0, 0);
            int i = obtainStyledAttributes.getInt(C1083R.styleable.LinearGauge_sv_orientation, -1);
            if (i != -1) {
                setOrientation(Orientation.values()[i]);
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
    public void updateBackgroundBitmap() {
        updateFrontAndBackBitmaps();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Canvas createForegroundBitmapCanvas() {
        if (getWidthPa() == 0 || getHeightPa() == 0) {
            return new Canvas();
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidthPa(), getHeightPa(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.foregroundBitmap = createBitmap;
        return new Canvas(this.foregroundBitmap);
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        if (this.orientation == Orientation.HORIZONTAL) {
            this.rect.set(0, 0, (int) (((float) getWidthPa()) * getOffsetSpeed()), getHeightPa());
        } else {
            this.rect.set(0, getHeightPa() - ((int) (((float) getHeightPa()) * getOffsetSpeed())), getWidthPa(), getHeightPa());
        }
        canvas.translate((float) getPadding(), (float) getPadding());
        Bitmap bitmap = this.foregroundBitmap;
        Rect rect2 = this.rect;
        canvas.drawBitmap(bitmap, rect2, rect2, this.paint);
        canvas.translate((float) (-getPadding()), (float) (-getPadding()));
        drawSpeedUnitText(canvas);
    }
}
