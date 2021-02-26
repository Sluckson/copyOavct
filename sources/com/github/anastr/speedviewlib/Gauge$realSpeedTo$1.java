package com.github.anastr.speedviewlib;

import android.animation.ValueAnimator;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo66934k = 3, mo66935mv = {1, 1, 16})
/* compiled from: Gauge.kt */
final class Gauge$realSpeedTo$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ float $finalSpeed;
    final /* synthetic */ Gauge this$0;

    Gauge$realSpeedTo$1(Gauge gauge, float f) {
        this.this$0 = gauge;
        this.$finalSpeed = f;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.this$0.isSpeedIncrease()) {
            float percentSpeed = 100.005f - this.this$0.getPercentSpeed();
            Gauge gauge = this.this$0;
            gauge.currentSpeed = gauge.getCurrentSpeed() + (this.this$0.getAccelerate() * 10.0f * percentSpeed * 0.01f);
            float currentSpeed = this.this$0.getCurrentSpeed();
            float f = this.$finalSpeed;
            if (currentSpeed > f) {
                this.this$0.currentSpeed = f;
            }
        } else {
            Gauge gauge2 = this.this$0;
            gauge2.currentSpeed = gauge2.getCurrentSpeed() - ((((this.this$0.getDecelerate() * 10.0f) * (this.this$0.getPercentSpeed() + 0.005f)) * 0.01f) + 0.1f);
            float currentSpeed2 = this.this$0.getCurrentSpeed();
            float f2 = this.$finalSpeed;
            if (currentSpeed2 < f2) {
                this.this$0.currentSpeed = f2;
            }
        }
        this.this$0.postInvalidate();
        if (this.$finalSpeed == this.this$0.getCurrentSpeed()) {
            this.this$0.stop();
        }
    }
}
