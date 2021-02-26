package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.medallia.digital.mobilesdk.C3429a1;

/* renamed from: com.medallia.digital.mobilesdk.v */
class C3758v extends C3781x {

    /* renamed from: j */
    private static final float f1940j = 1.0f;

    /* renamed from: k */
    private static final float f1941k = 4.0f;

    /* renamed from: l */
    private static final int f1942l = 15;

    /* renamed from: m */
    private static final int f1943m = 10;

    /* renamed from: n */
    private static final int f1944n = 600;

    /* renamed from: o */
    private static final double f1945o = 0.2d;

    /* renamed from: p */
    private static final float f1946p = 0.7f;

    /* renamed from: f */
    private TextView f1947f;

    /* renamed from: g */
    private ImageView f1948g;

    /* renamed from: h */
    private C3679q3 f1949h;

    /* renamed from: i */
    private View f1950i;

    /* renamed from: com.medallia.digital.mobilesdk.v$a */
    class C3759a implements View.OnTouchListener {
        C3759a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            C3758v vVar = C3758v.this;
            C3766w wVar = vVar.f2011a;
            if (wVar != null && wVar.f1961f) {
                vVar.f2015e = motionEvent.getAction() == 0;
            }
            return false;
        }
    }

    C3758v(C3766w wVar, Context context) {
        super(wVar, context);
    }

    /* renamed from: a */
    private int m1764a(int i) {
        return (i * getResources().getDisplayMetrics().densityDpi) / 160;
    }

    /* renamed from: a */
    private GradientDrawable m1765a(int i, int i2) {
        return m1767a(Integer.valueOf(i), (float[]) null, i2);
    }

    /* renamed from: a */
    private GradientDrawable m1766a(int i, String str) {
        float f = (float) i;
        return m1768a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f}, Color.parseColor(str));
    }

    /* renamed from: a */
    private GradientDrawable m1767a(Integer num, float[] fArr, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        if (fArr != null) {
            gradientDrawable.setCornerRadii(fArr);
        }
        if (num != null) {
            gradientDrawable.setCornerRadius((float) num.intValue());
        }
        return gradientDrawable;
    }

    /* renamed from: a */
    private GradientDrawable m1768a(float[] fArr, int i) {
        return m1767a((Integer) null, fArr, i);
    }

    /* renamed from: a */
    private void m1769a(TextView textView, String str, int i) {
        if (str != null && textView != null) {
            try {
                textView.setTypeface(Typeface.create(str, i));
            } catch (Exception unused) {
                C3490e3.m663c("Failed on setting font: " + str);
            }
        }
    }

    /* renamed from: g */
    private void m1770g() {
        View view = this.f1950i;
        if (view != null) {
            view.setOnTouchListener(new C3759a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55838a() {
        float f = getResources().getDisplayMetrics().density;
        this.f1949h.mo55716b(true);
        this.f1949h.mo55715b(1.0f * f);
        this.f1949h.mo55712a(f * f1941k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public RelativeLayout mo55839b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(C3417R.C3421layout.view_banner_v2, (ViewGroup) this.f2012b, false);
        this.f1949h = new C3679q3(getContext(), (AttributeSet) null, 0, C3417R.C3422style.MedalliaDefaultShadowStyle);
        this.f1949h.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f2014d.removeAllViews();
        this.f2014d.addView(this.f1949h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        if (this.f2011a.f1960e == C3429a1.C3432c.TOP) {
            layoutParams.setMargins(0, 0, 0, m1764a(10));
        } else {
            layoutParams.setMargins(0, m1764a(10), 0, 0);
        }
        this.f2013c.setLayoutParams(layoutParams);
        this.f1949h.addView(this.f2013c);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(C3417R.C3420id.medallia_banner_root_view);
        this.f1950i = inflate.findViewById(C3417R.C3420id.text_container);
        m1770g();
        TextView textView = (TextView) inflate.findViewById(C3417R.C3420id.medallia_banner_title_text_view);
        TextView textView2 = (TextView) inflate.findViewById(C3417R.C3420id.medallia_banner_message_text_view);
        this.f1947f = (TextView) inflate.findViewById(C3417R.C3420id.medallia_positive_view);
        this.f1948g = (ImageView) inflate.findViewById(C3417R.C3420id.medallia_negative_view);
        String str = this.f2011a.f1956a;
        if (str != null) {
            textView2.setText(str);
            textView2.setAlpha(f1946p);
            m1769a(textView2, this.f2011a.f1968m, 0);
        }
        String str2 = this.f2011a.f1957b;
        if (str2 != null) {
            textView.setText(str2);
            m1769a(textView, this.f2011a.f1968m, 1);
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
        if (this.f2011a.f1961f) {
            this.f1947f.setVisibility(0);
            try {
                m1769a(this.f1947f, this.f2011a.f1968m, 1);
                if (!TextUtils.isEmpty(this.f2011a.f1964i)) {
                    this.f1947f.setBackgroundColor(Color.parseColor(this.f2011a.f1964i));
                }
                if (!TextUtils.isEmpty(this.f2011a.f1963h)) {
                    this.f1947f.setTextColor(Color.parseColor(this.f2011a.f1963h));
                }
                if (!TextUtils.isEmpty(this.f2011a.f1962g)) {
                    this.f1947f.setText(this.f2011a.f1962g);
                }
            } catch (Exception unused3) {
                C3490e3.m666f("Error on set banner action button");
            }
            this.f1948g.setVisibility(0);
            try {
                Drawable drawable = getResources().getDrawable(C3417R.C3419drawable.md_close_banner);
                if (drawable != null && !TextUtils.isEmpty(this.f2011a.f1965j)) {
                    drawable.setColorFilter(Color.parseColor(this.f2011a.f1965j), PorterDuff.Mode.MULTIPLY);
                    this.f1948g.setImageDrawable(drawable);
                }
            } catch (Exception unused4) {
                C3490e3.m663c("Error on set banner close button color");
            }
        } else {
            this.f1947f.setVisibility(8);
            this.f1948g.setVisibility(8);
        }
        if (this.f2011a.f1967l) {
            if (getResources().getConfiguration().smallestScreenWidthDp < 600 || C3595k3.m1060d().mo55513b().getResources().getConfiguration().orientation != 2) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f2013c.getLayoutParams();
                layoutParams2.setMargins(m1764a(10), m1764a(10), m1764a(10), m1764a(10));
                this.f2013c.setLayoutParams(layoutParams2);
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int i = (int) (((double) displayMetrics.widthPixels) * f1945o);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f2013c.getLayoutParams();
                layoutParams3.setMargins(i, m1764a(10), i, m1764a(10));
                this.f2013c.setLayoutParams(layoutParams3);
            }
        }
        mo55838a();
        return relativeLayout;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo55840b() {
        return this.f2011a.f1961f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo55841c() {
        return this.f2011a.f1966k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo55842d() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public View mo55843e() {
        return this.f1948g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public View mo55844f() {
        return this.f1947f;
    }
}
