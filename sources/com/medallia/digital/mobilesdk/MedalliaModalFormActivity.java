package com.medallia.digital.mobilesdk;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MedalliaModalFormActivity extends C3424a0 {

    /* renamed from: i */
    private ImageView f849i;

    /* renamed from: j */
    private TextView f850j;

    /* renamed from: com.medallia.digital.mobilesdk.MedalliaModalFormActivity$a */
    class C3416a implements View.OnClickListener {
        C3416a() {
        }

        public void onClick(View view) {
            MedalliaModalFormActivity.this.mo55176e();
        }
    }

    /* renamed from: g */
    private void m409g() {
        this.f849i.setOnClickListener(new C3416a());
    }

    /* renamed from: h */
    private void m410h() {
        this.f850j.setText(this.f857a.getTitle());
        if (!TextUtils.isEmpty(this.f857a.getTitleTextColor())) {
            try {
                this.f850j.setTextColor(Color.parseColor(this.f857a.getTitleTextColor()));
                this.f849i.setColorFilter(Color.parseColor(this.f857a.getTitleTextColor()), PorterDuff.Mode.SRC_IN);
            } catch (Exception unused) {
                C3490e3.m666f("Error on set title text color");
            }
        }
        if (!TextUtils.isEmpty(this.f857a.getTitleBackgroundColor())) {
            try {
                this.f850j.setBackgroundColor(Color.parseColor(this.f857a.getTitleBackgroundColor()));
            } catch (Exception unused2) {
                C3490e3.m666f("Error on set title background color");
            }
        }
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo55094a() {
        super.mo55094a();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo55095b() {
        super.mo55095b();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo55096c() {
        super.mo55096c();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo55097d() {
        super.mo55097d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo55098f() {
        setContentView(C3417R.C3421layout.medallia_activity_modal_form);
        this.f849i = (ImageView) findViewById(C3417R.C3420id.medallia_modal_close_button);
        this.f850j = (TextView) findViewById(C3417R.C3420id.medallia_modal_form_title);
        m410h();
        m409g();
    }

    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }
}
