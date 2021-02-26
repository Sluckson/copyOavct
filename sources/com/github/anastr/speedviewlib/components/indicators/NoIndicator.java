package com.github.anastr.speedviewlib.components.indicators;

import android.content.Context;
import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/indicators/NoIndicator;", "Lcom/github/anastr/speedviewlib/components/indicators/Indicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "degree", "", "setWithEffects", "withEffects", "", "updateIndicator", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: NoIndicator.kt */
public final class NoIndicator extends Indicator<NoIndicator> {
    public void draw(@NotNull Canvas canvas, float f) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
    }

    /* access modifiers changed from: protected */
    public void setWithEffects(boolean z) {
    }

    public void updateIndicator() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoIndicator(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }
}
