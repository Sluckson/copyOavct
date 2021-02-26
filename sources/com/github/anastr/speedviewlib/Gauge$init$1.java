package com.github.anastr.speedviewlib;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo66933d2 = {"com/github/anastr/speedviewlib/Gauge$init$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: Gauge.kt */
public final class Gauge$init$1 implements Animator.AnimatorListener {
    final /* synthetic */ Gauge this$0;

    public void onAnimationCancel(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
    }

    public void onAnimationRepeat(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
    }

    public void onAnimationStart(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
    }

    Gauge$init$1(Gauge gauge) {
        this.this$0 = gauge;
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        if (!this.this$0.canceled) {
            this.this$0.tremble();
        }
    }
}
