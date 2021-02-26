package com.github.anastr.speedviewlib;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo66934k = 3, mo66935mv = {1, 1, 16})
/* compiled from: Gauge.kt */
final class Gauge$speedTo$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ Gauge this$0;

    Gauge$speedTo$1(Gauge gauge) {
        this.this$0 = gauge;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Gauge gauge = this.this$0;
        Object animatedValue = Gauge.access$getSpeedAnimator$p(gauge).getAnimatedValue();
        if (animatedValue != null) {
            gauge.currentSpeed = ((Float) animatedValue).floatValue();
            this.this$0.postInvalidate();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
