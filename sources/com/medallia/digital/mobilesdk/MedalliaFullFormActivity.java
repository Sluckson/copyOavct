package com.medallia.digital.mobilesdk;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class MedalliaFullFormActivity extends C3424a0 {

    /* renamed from: i */
    private Toolbar f847i;

    /* renamed from: j */
    private TextView f848j;

    /* renamed from: g */
    private void m403g() {
        C3433a2 a2Var = this.f857a;
        if (a2Var != null) {
            String title = a2Var.getTitle();
            String titleTextColor = this.f857a.getTitleTextColor();
            String titleBackgroundColor = this.f857a.getTitleBackgroundColor();
            if (!TextUtils.isEmpty(title)) {
                this.f848j.setText(title);
            }
            if (!TextUtils.isEmpty(titleBackgroundColor)) {
                try {
                    this.f847i.setBackgroundColor(Color.parseColor(titleBackgroundColor));
                } catch (Exception unused) {
                    C3490e3.m666f("Error on set title background color");
                }
            }
            if (!TextUtils.isEmpty(titleTextColor)) {
                try {
                    this.f848j.setTextColor(Color.parseColor(titleTextColor));
                    Drawable navigationIcon = this.f847i.getNavigationIcon();
                    if (navigationIcon != null) {
                        navigationIcon.setColorFilter(Color.parseColor(titleTextColor), PorterDuff.Mode.MULTIPLY);
                    }
                } catch (Exception unused2) {
                    C3490e3.m666f("Error on set title text color");
                }
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
        setContentView(C3417R.C3421layout.medallia_activity_full_form);
        this.f847i = (Toolbar) findViewById(C3417R.C3420id.medallia_toolbar);
        setSupportActionBar(this.f847i);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeActionContentDescription((CharSequence) getString(C3417R.string.back));
        }
        this.f848j = (TextView) findViewById(C3417R.C3420id.medallia_title_text_view);
        m403g();
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

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        mo55176e();
        return true;
    }
}
