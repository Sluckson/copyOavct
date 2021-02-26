package com.medallia.digital.mobilesdk;

import android.content.ContentValues;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.y0 */
abstract class C3794y0<T> {

    /* renamed from: b */
    private static final int f2051b = 50;

    /* renamed from: c */
    private static final int f2052c = 100;

    /* renamed from: a */
    private int f2053a = 0;

    C3794y0() {
    }

    /* renamed from: a */
    private void m1919a(int i) {
        this.f2053a = i;
    }

    /* renamed from: f */
    private void m1920f() {
        if (this.f2053a >= 50) {
            this.f2053a = 0;
            if (C3782x0.m1872d().mo55914c()) {
                C3782x0.m1872d().getWritableDatabase().execSQL("DELETE FROM " + mo55222d() + " WHERE _id IN (SELECT _id FROM " + mo55222d() + " ORDER BY " + mo55224e() + " ASC LIMIT " + 100 + ")");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55928a(boolean z, String str) {
        if (z) {
            C3490e3.m663c(mo55222d() + " : Failed to " + str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55929a() {
        boolean z = C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, (String[]) null) > 0;
        m1919a(0);
        mo55928a(!z, "delete all");
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55232a(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo55213a(Object... objArr);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract long mo55214b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract ContentValues mo55215b(T t);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract T mo55216b(Object... objArr);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract ArrayList<T> mo55218c(Object... objArr);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract HashMap<String, String> mo55219c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55221c(T t) {
        int i = 0;
        boolean z = C3782x0.m1872d().getWritableDatabase().insert(mo55222d(), (String) null, mo55215b(t)) != -1;
        try {
            mo55928a(!z, "insert - " + t.getClass().getSimpleName());
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        if (z) {
            i = this.f2053a + 1;
        }
        m1919a(i);
        m1920f();
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract String mo55222d();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo55223d(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo55224e() {
        return null;
    }
}
