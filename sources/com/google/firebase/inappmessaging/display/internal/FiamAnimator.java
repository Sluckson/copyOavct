package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.graphics.Point;
import android.view.View;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import javax.inject.Inject;

@FirebaseAppScope
public class FiamAnimator {

    public interface AnimationCompleteListener {
        void onComplete();
    }

    @Inject
    FiamAnimator() {
    }

    public void slideIntoView(final Application application, final View view, Position position) {
        view.setAlpha(0.0f);
        Point access$000 = Position.getPoint(position, view);
        view.animate().translationX((float) access$000.x).translationY((float) access$000.y).setDuration(1).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration((long) application.getResources().getInteger(17694722)).setListener((Animator.AnimatorListener) null);
            }
        });
    }

    public void slideOutOfView(Application application, View view, Position position, final AnimationCompleteListener animationCompleteListener) {
        Point access$000 = Position.getPoint(position, view);
        view.animate().translationX((float) access$000.x).translationY((float) access$000.y).setDuration((long) application.getResources().getInteger(17694722)).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animationCompleteListener.onComplete();
            }
        });
    }

    public enum Position {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM;

        /* access modifiers changed from: private */
        public static Point getPoint(Position position, View view) {
            view.measure(-2, -2);
            int i = C23233.f364x1fbc48f9[position.ordinal()];
            if (i == 1) {
                return new Point(view.getMeasuredWidth() * -1, 0);
            }
            if (i == 2) {
                return new Point(view.getMeasuredWidth() * 1, 0);
            }
            if (i == 3) {
                return new Point(0, view.getMeasuredHeight() * -1);
            }
            if (i != 4) {
                return new Point(0, view.getMeasuredHeight() * -1);
            }
            return new Point(0, view.getMeasuredHeight() * 1);
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.display.internal.FiamAnimator$3 */
    static /* synthetic */ class C23233 {

        /* renamed from: $SwitchMap$com$google$firebase$inappmessaging$display$internal$FiamAnimator$Position */
        static final /* synthetic */ int[] f364x1fbc48f9 = new int[Position.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.firebase.inappmessaging.display.internal.FiamAnimator$Position[] r0 = com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f364x1fbc48f9 = r0
                int[] r0 = f364x1fbc48f9     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.inappmessaging.display.internal.FiamAnimator$Position r1 = com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position.LEFT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f364x1fbc48f9     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.inappmessaging.display.internal.FiamAnimator$Position r1 = com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position.RIGHT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f364x1fbc48f9     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.inappmessaging.display.internal.FiamAnimator$Position r1 = com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position.TOP     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f364x1fbc48f9     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.inappmessaging.display.internal.FiamAnimator$Position r1 = com.google.firebase.inappmessaging.display.internal.FiamAnimator.Position.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.display.internal.FiamAnimator.C23233.<clinit>():void");
        }
    }
}
