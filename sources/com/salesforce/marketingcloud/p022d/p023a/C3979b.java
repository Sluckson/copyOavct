package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.salesforce.marketingcloud.p027e.C4022a;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.a.b */
public abstract class C3979b {

    /* renamed from: e */
    protected static final String f2729e = "%s = ?";

    /* renamed from: f */
    protected final SQLiteDatabase f2730f;

    public C3979b(SQLiteDatabase sQLiteDatabase) {
        this.f2730f = sQLiteDatabase;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo56453a(ContentValues contentValues, String str, String[] strArr) {
        return this.f2730f.update(mo56450e(), contentValues, str, strArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo56454a(String str, String[] strArr) {
        return this.f2730f.delete(mo56450e(), str, strArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo56455a(ContentValues contentValues) {
        return mo56456a((String) null, contentValues);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final long mo56456a(String str, ContentValues contentValues) {
        return this.f2730f.insert(mo56450e(), str, contentValues);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Cursor mo56457a(boolean z, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.f2730f.query(z, mo56450e(), strArr, str, strArr2, str2, str3, str4, str5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Cursor mo56458a(String[] strArr, String str) {
        return mo56461a(strArr, str, (String[]) null, (String) null, (String) null, (String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Cursor mo56459a(String[] strArr, String str, String[] strArr2) {
        return mo56461a(strArr, str, strArr2, (String) null, (String) null, (String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Cursor mo56460a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return mo56457a(false, strArr, str, strArr2, str2, str3, str4, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Cursor mo56461a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return mo56457a(false, strArr, str, strArr2, str2, str3, str4, str5);
    }

    /* renamed from: a */
    public abstract void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo56462c(String str) {
        return mo56454a(str, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract String mo56450e();
}
