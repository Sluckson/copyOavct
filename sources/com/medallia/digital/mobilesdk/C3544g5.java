package com.medallia.digital.mobilesdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.g5 */
class C3544g5 extends C3794y0<C3525f5> {

    /* renamed from: d */
    private static final String f1221d = "templateData";

    /* renamed from: com.medallia.digital.mobilesdk.g5$a */
    class C3545a extends HashMap<String, String> {
        C3545a() {
            put("templatePath", "TEXT");
            put("templateUrl", "TEXT");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.g5$b */
    private static class C3546b {

        /* renamed from: a */
        private static final String f1223a = "templateUrl";

        /* renamed from: b */
        private static final String f1224b = "templatePath";

        private C3546b() {
        }
    }

    C3544g5() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55232a(C3525f5 f5Var) {
        StringBuilder sb;
        String str;
        boolean z = false;
        boolean z2 = true;
        if (f5Var == null || TextUtils.isEmpty(f5Var.mo55380b())) {
            sb = new StringBuilder();
            sb.append("delete (invalid data) - ");
            str = f5Var == null ? "record is null" : "templateUrl is not valid";
        } else {
            if (C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), "templateUrl='" + f5Var.mo55380b() + "'", (String[]) null) > 0) {
                z = true;
            }
            z2 = !z;
            sb = new StringBuilder();
            sb.append("delete - ");
            str = f5Var.toString();
        }
        sb.append(str);
        mo55928a(z2, sb.toString());
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55213a(Object... objArr) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo55214b() {
        try {
            return DatabaseUtils.queryNumEntries(C3782x0.m1872d().getWritableDatabase(), f1221d);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ContentValues mo55215b(C3525f5 f5Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("templatePath", f5Var.mo55378a());
        contentValues.put("templateUrl", f5Var.mo55380b());
        return contentValues;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3525f5 m870b(Object... objArr) {
        C3525f5 f5Var = null;
        if (objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String)) {
            SQLiteDatabase readableDatabase = C3782x0.m1872d().getReadableDatabase();
            String d = mo55222d();
            Cursor query = readableDatabase.query(d, (String[]) null, "templateUrl='" + objArr[0] + "'", (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    f5Var = new C3525f5(query.getString(query.getColumnIndex("templatePath")), query.getString(query.getColumnIndex("templateUrl")));
                }
                query.close();
            }
        }
        return f5Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ArrayList<C3525f5> mo55218c(Object... objArr) {
        ArrayList<C3525f5> arrayList = new ArrayList<>();
        Cursor query = C3782x0.m1872d().getReadableDatabase().query(mo55222d(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null && query.moveToFirst()) {
            do {
                arrayList.add(new C3525f5(query.getString(query.getColumnIndex("templatePath")), query.getString(query.getColumnIndex("templateUrl"))));
            } while (query.moveToNext());
            query.close();
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public HashMap<String, String> mo55219c() {
        return new C3545a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55222d() {
        return f1221d;
    }
}
