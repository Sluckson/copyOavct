package com.medallia.digital.mobilesdk;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.medallia.digital.mobilesdk.C3429a1;

/* renamed from: com.medallia.digital.mobilesdk.u */
class C3745u extends C3781x {
    C3745u(C3766w wVar, Context context) {
        super(wVar, context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55838a() {
        int i;
        RelativeLayout relativeLayout;
        C3429a1.C3432c cVar = this.f2011a.f1960e;
        if (cVar != null) {
            if (cVar == C3429a1.C3432c.BOTTOM) {
                relativeLayout = this.f2013c;
                i = C3417R.C3419drawable.medallia_bottom_shadow;
            } else {
                relativeLayout = this.f2013c;
                i = C3417R.C3419drawable.medallia_top_shadow;
            }
            relativeLayout.setBackgroundResource(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public RelativeLayout mo55839b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(C3417R.C3421layout.view_banner_v1, (ViewGroup) this.f2012b, false);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(C3417R.C3420id.medallia_banner_root_view);
        TextView textView = (TextView) inflate.findViewById(C3417R.C3420id.medallia_banner_title_text_view);
        TextView textView2 = (TextView) inflate.findViewById(C3417R.C3420id.medallia_banner_message_text_view);
        String str = this.f2011a.f1956a;
        if (str != null) {
            textView2.setText(str);
        }
        String str2 = this.f2011a.f1957b;
        if (str2 != null) {
            textView.setText(str2);
        }
        if (!TextUtils.isEmpty(this.f2011a.f1958c)) {
            try {
                relativeLayout.setBackgroundColor(Color.parseColor(this.f2011a.f1958c));
            } catch (Exception unused) {
                C3490e3.m666f("Error on set banner background color");
            }
        }
        if (!TextUtils.isEmpty(this.f2011a.f1959d)) {
            try {
                textView.setTextColor(Color.parseColor(this.f2011a.f1959d));
                textView2.setTextColor(Color.parseColor(this.f2011a.f1959d));
            } catch (Exception unused2) {
                C3490e3.m666f("Error on set banner background color");
            }
        }
        mo55838a();
        return relativeLayout;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo55840b() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo55841c() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo55842d() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public View mo55843e() {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public View mo55844f() {
        return null;
    }
}
