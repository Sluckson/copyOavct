package com.medallia.digital.mobilesdk;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/* renamed from: com.medallia.digital.mobilesdk.z0 */
final class C3804z0 {

    /* renamed from: a */
    private final long f2075a = 400;

    /* renamed from: b */
    private Animation f2076b;

    /* renamed from: c */
    private Animation f2077c;

    /* renamed from: d */
    private int f2078d;

    /* renamed from: e */
    private int f2079e;

    C3804z0() {
    }

    /* renamed from: a */
    private void m1968a(int i) {
        this.f2078d = i;
    }

    /* renamed from: a */
    private boolean m1969a(int i, View view) {
        return i == view.getMeasuredHeight();
    }

    /* renamed from: b */
    private void m1970b(int i) {
        this.f2079e = i;
    }

    /* renamed from: g */
    private boolean m1971g(View view) {
        return m1969a(this.f2078d, view);
    }

    /* renamed from: h */
    private boolean m1972h(View view) {
        return m1969a(this.f2079e, view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Animation mo55948a(View view) {
        if (!m1971g(view) || this.f2076b == null) {
            this.f2076b = new TranslateAnimation(0.0f, 0.0f, (float) (-view.getMeasuredHeight()), 0.0f);
            this.f2076b.setDuration(400);
            m1968a(view.getMeasuredHeight());
        }
        return this.f2076b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Animation mo55949b(View view) {
        if (!m1971g(view) || this.f2076b == null) {
            this.f2076b = new TranslateAnimation(0.0f, 0.0f, (float) view.getMeasuredHeight(), 0.0f);
            this.f2076b.setDuration(400);
            m1968a(view.getMeasuredHeight());
        }
        return this.f2076b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Animation mo55950c(View view) {
        if (!m1972h(view) || this.f2077c == null) {
            this.f2077c = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) view.getMeasuredWidth());
            this.f2077c.setDuration(400);
            m1970b(view.getMeasuredHeight());
        }
        return this.f2077c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Animation mo55951d(View view) {
        if (!m1972h(view) || this.f2077c == null) {
            this.f2077c = new TranslateAnimation(0.0f, (float) (-view.getMeasuredWidth()), 0.0f, 0.0f);
            this.f2077c.setDuration(400);
            m1970b(view.getMeasuredHeight());
        }
        return this.f2077c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Animation mo55952e(View view) {
        if (!m1972h(view) || this.f2077c == null) {
            this.f2077c = new TranslateAnimation(0.0f, (float) view.getMeasuredWidth(), 0.0f, 0.0f);
            this.f2077c.setDuration(400);
            m1970b(view.getMeasuredHeight());
        }
        return this.f2077c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Animation mo55953f(View view) {
        if (!m1972h(view) || this.f2077c == null) {
            this.f2077c = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-view.getMeasuredWidth()));
            this.f2077c.setDuration(400);
            m1970b(view.getMeasuredHeight());
        }
        return this.f2077c;
    }
}
