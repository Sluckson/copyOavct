package com.medallia.digital.mobilesdk;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* renamed from: com.medallia.digital.mobilesdk.x */
abstract class C3781x extends RelativeLayout {

    /* renamed from: a */
    final C3766w f2011a;

    /* renamed from: b */
    View f2012b;

    /* renamed from: c */
    RelativeLayout f2013c;

    /* renamed from: d */
    RelativeLayout f2014d;

    /* renamed from: e */
    public boolean f2015e;

    C3781x(C3766w wVar, Context context) {
        super(context);
        this.f2011a = wVar;
        mo55904a(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo55838a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55904a(Context context) {
        this.f2012b = RelativeLayout.inflate(context, C3417R.C3421layout.view_base_banner, this);
        this.f2014d = (RelativeLayout) this.f2012b.findViewById(C3417R.C3420id.medallia_banner_base_view);
        this.f2013c = (RelativeLayout) this.f2012b.findViewById(C3417R.C3420id.medallia_shadow_view);
        this.f2013c.addView(mo55839b(context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract RelativeLayout mo55839b(Context context);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo55840b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract boolean mo55841c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract boolean mo55842d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract View mo55843e();

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract View mo55844f();
}
