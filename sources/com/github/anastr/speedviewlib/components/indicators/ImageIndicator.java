package com.github.anastr.speedviewlib.components.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/ImageIndicator;", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "context", "Landroid/content/Context;", "bitmapIndicator", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "degree", "", "setWithEffects", "withEffects", "", "updateIndicator", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: ImageIndicator.kt */
public final class ImageIndicator extends Indicator<ImageIndicator> {
    private final Drawable bitmapIndicator;

    /* access modifiers changed from: protected */
    public void setWithEffects(boolean z) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageIndicator(@NotNull Context context, @NotNull Drawable drawable) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(drawable, "bitmapIndicator");
        this.bitmapIndicator = drawable;
    }

    public void draw(@NotNull Canvas canvas, float f) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        canvas.save();
        canvas.rotate(f + 90.0f, getCenterX(), getCenterY());
        this.bitmapIndicator.draw(canvas);
        canvas.restore();
    }

    public void updateIndicator() {
        this.bitmapIndicator.setBounds(0, 0, (int) getViewSize(), (int) getViewSize());
    }
}
