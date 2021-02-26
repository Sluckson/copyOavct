package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.medallia.digital.mobilesdk.C3429a1;

/* renamed from: com.medallia.digital.mobilesdk.t */
class C3725t implements View.OnTouchListener {

    /* renamed from: n */
    private static final int f1855n = 100;

    /* renamed from: o */
    private static final int f1856o = 10;

    /* renamed from: p */
    private static final float f1857p = 2.0f;

    /* renamed from: a */
    private final C3429a1.C3432c f1858a;

    /* renamed from: b */
    private GestureDetector f1859b;

    /* renamed from: c */
    private int f1860c;

    /* renamed from: d */
    private C3728c f1861d;

    /* renamed from: e */
    private float f1862e;

    /* renamed from: f */
    private float f1863f;

    /* renamed from: g */
    private float f1864g;

    /* renamed from: h */
    private float f1865h;

    /* renamed from: i */
    private long f1866i;

    /* renamed from: j */
    private long f1867j;

    /* renamed from: k */
    private boolean f1868k;

    /* renamed from: l */
    private boolean f1869l;

    /* renamed from: m */
    private int f1870m = 0;

    /* renamed from: com.medallia.digital.mobilesdk.t$b */
    private class C3727b extends GestureDetector.SimpleOnGestureListener {
        private C3727b() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.t$c */
    private enum C3728c {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    C3725t(C3429a1.C3432c cVar, boolean z) {
        int i = 0;
        this.f1858a = cVar;
        this.f1869l = z;
        this.f1859b = new GestureDetector(C3595k3.m1060d().mo55513b(), new C3727b());
        try {
            Activity activity = (Activity) C3595k3.m1060d().mo55514c().getBaseContext();
            Window window = activity.getWindow();
            boolean z2 = true;
            boolean z3 = (window.getAttributes().flags & 1024) != 0;
            if (Build.VERSION.SDK_INT < 19 || (window.getAttributes().flags & 67108864) == 0) {
                z2 = false;
            }
            if (z3 || z2) {
                int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
                this.f1870m = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : i;
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        WindowManager windowManager = (WindowManager) C3595k3.m1060d().mo55511a().getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            if (Build.VERSION.SDK_INT >= 19) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            this.f1860c = point.y;
        }
    }

    /* renamed from: g */
    private void m1634g() {
        this.f1864g = 0.0f;
        this.f1862e = 0.0f;
        this.f1863f = 0.0f;
        this.f1865h = 0.0f;
        this.f1867j = 0;
        this.f1866i = 0;
        this.f1868k = false;
        this.f1861d = null;
    }

    /* renamed from: h */
    private boolean m1635h() {
        if (this.f1867j - this.f1866i <= 10) {
            return false;
        }
        this.f1866i = 0;
        this.f1867j = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55758a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55759b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo55760c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo55761d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo55762e() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo55763f() {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        C3781x xVar;
        C3728c cVar;
        if (!this.f1859b.onTouchEvent(motionEvent)) {
            int rawY = (int) motionEvent.getRawY();
            int rawX = (int) motionEvent.getRawX();
            if (motionEvent.getAction() == 0) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C3417R.C3420id.medallia_shadow_view);
                if (relativeLayout != null) {
                    if (relativeLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        int i2 = ((FrameLayout.LayoutParams) relativeLayout.getLayoutParams()).bottomMargin;
                    } else {
                        int i3 = ((RelativeLayout.LayoutParams) relativeLayout.getLayoutParams()).bottomMargin;
                    }
                }
                this.f1866i = motionEvent.getEventTime();
                this.f1862e = motionEvent.getRawY();
                this.f1864g = motionEvent.getRawX();
            }
            if (motionEvent.getAction() == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                C3728c cVar2 = this.f1861d;
                if (cVar2 == C3728c.TOP) {
                    if (((float) Math.abs(layoutParams.topMargin)) < ((float) view.getHeight()) / 2.0f) {
                        layoutParams.topMargin = this.f1870m;
                    } else {
                        mo55763f();
                        m1634g();
                    }
                } else if (cVar2 != C3728c.BOTTOM) {
                    if (cVar2 != C3728c.LEFT) {
                        if (cVar2 == C3728c.RIGHT) {
                            if (((float) Math.abs(layoutParams.leftMargin)) >= ((float) view.getWidth()) / 2.0f) {
                                mo55762e();
                            }
                        }
                        m1634g();
                    } else if (((float) Math.abs(layoutParams.rightMargin)) >= ((float) view.getWidth()) / 2.0f) {
                        mo55761d();
                        m1634g();
                    }
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                } else if (((float) Math.abs(layoutParams.bottomMargin)) < ((float) view.getHeight()) / 2.0f) {
                    layoutParams.bottomMargin = 0;
                } else {
                    mo55760c();
                    m1634g();
                }
                view.setLayoutParams(layoutParams);
                m1634g();
            }
            if (motionEvent.getAction() == 2) {
                this.f1863f = motionEvent.getRawY();
                this.f1865h = motionEvent.getRawX();
                this.f1867j = motionEvent.getEventTime();
                if (!this.f1868k) {
                    if (Math.abs(this.f1862e - this.f1863f) > 100.0f) {
                        C3429a1.C3432c cVar3 = this.f1858a;
                        if (cVar3 == C3429a1.C3432c.TOP) {
                            cVar = C3728c.TOP;
                        } else {
                            if (cVar3 == C3429a1.C3432c.BOTTOM) {
                                cVar = C3728c.BOTTOM;
                            }
                            this.f1868k = true;
                        }
                    } else {
                        float f = this.f1864g - this.f1865h;
                        if (f <= 0.0f || Math.abs(f) <= 100.0f) {
                            float f2 = this.f1864g - this.f1865h;
                            if (f2 < 0.0f && Math.abs(f2) > 100.0f) {
                                cVar = C3728c.RIGHT;
                            }
                        } else {
                            cVar = C3728c.LEFT;
                        }
                    }
                    this.f1861d = cVar;
                    this.f1868k = true;
                }
                if (m1635h()) {
                    if (this.f1869l || ((xVar = (C3781x) view) != null && xVar.f2015e)) {
                        mo55759b();
                    }
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
                    if (this.f1861d == C3728c.TOP && rawY >= 0 && rawY <= view.getHeight() + this.f1870m) {
                        layoutParams2.topMargin = -(view.getHeight() - rawY);
                    } else if (this.f1861d != C3728c.BOTTOM || rawY >= (i = this.f1860c) || rawY < i - view.getHeight()) {
                        C3728c cVar4 = this.f1861d;
                        if (cVar4 == C3728c.LEFT) {
                            int width = view.getWidth() - rawX;
                            layoutParams2.leftMargin = -width;
                            layoutParams2.rightMargin = width;
                        } else if (cVar4 == C3728c.RIGHT) {
                            int width2 = view.getWidth() - (view.getWidth() - rawX);
                            layoutParams2.rightMargin = -width2;
                            layoutParams2.leftMargin = width2;
                        }
                    } else {
                        layoutParams2.bottomMargin = -(view.getHeight() - (this.f1860c - rawY));
                    }
                    view.setLayoutParams(layoutParams2);
                }
            }
        } else if (this.f1869l) {
            mo55758a();
        }
        return true;
    }
}
