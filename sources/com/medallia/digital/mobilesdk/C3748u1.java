package com.medallia.digital.mobilesdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.u1 */
public class C3748u1 extends C3794y0<C3731t1> {

    /* renamed from: d */
    private static final int f1915d = 10;

    /* renamed from: e */
    private static final String f1916e = "feedbacks";

    /* renamed from: com.medallia.digital.mobilesdk.u1$a */
    class C3749a extends HashMap<String, String> {
        C3749a() {
            put("feedbackData", "TEXT");
            put("feedbackUUID", "TEXT");
            put("formId", "TEXT");
            put("submittedTimestamp", "INTEGER");
            put("formTriggerType", "TEXT");
            put("numberOfRetries", "INTEGER");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.u1$b */
    private static class C3750b {

        /* renamed from: a */
        private static final String f1918a = "feedbackData";

        /* renamed from: b */
        private static final String f1919b = "feedbackUUID";

        /* renamed from: c */
        private static final String f1920c = "formId";

        /* renamed from: d */
        private static final String f1921d = "submittedTimestamp";

        /* renamed from: e */
        private static final String f1922e = "formTriggerType";

        /* renamed from: f */
        private static final String f1923f = "numberOfRetries";

        private C3750b() {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55232a(C3731t1 t1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append("feedbackUUID='");
        sb.append(t1Var.mo55817b());
        sb.append("'");
        return C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), sb.toString(), (String[]) null) > 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55213a(Object... objArr) {
        if (objArr == null || objArr.length <= 0 || objArr[0] == null || !(objArr[0] instanceof Long)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("submittedTimestamp<=");
        sb.append(objArr[0]);
        return C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), sb.toString(), (String[]) null) > 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo55214b() {
        try {
            return DatabaseUtils.queryNumEntries(C3782x0.m1872d().getWritableDatabase(), f1916e);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ContentValues mo55215b(C3731t1 t1Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("feedbackData", C3659o3.m1391f().mo55690b(t1Var.mo55815a()));
        contentValues.put("feedbackUUID", t1Var.mo55817b());
        contentValues.put("formId", t1Var.getFormId());
        contentValues.put("submittedTimestamp", Long.valueOf(t1Var.mo55820e()));
        contentValues.put("formTriggerType", t1Var.mo55818c() != null ? t1Var.mo55818c().toString() : null);
        contentValues.put("numberOfRetries", Integer.valueOf(t1Var.mo55819d()));
        return contentValues;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3731t1 m1727b(Object... objArr) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ArrayList<C3731t1> mo55218c(Object... objArr) {
        ArrayList<C3731t1> arrayList = new ArrayList<>();
        Cursor query = C3782x0.m1872d().getReadableDatabase().query(mo55222d(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "submittedTimestamp DESC");
        if (query != null && query.moveToFirst()) {
            do {
                arrayList.add(new C3731t1(C3659o3.m1391f().mo55688a(query.getString(query.getColumnIndex("feedbackData"))), query.getString(query.getColumnIndex("feedbackUUID")), query.getString(query.getColumnIndex("formId")), FormTriggerType.valueOf(query.getString(query.getColumnIndex("formTriggerType"))), query.getLong(query.getColumnIndex("submittedTimestamp")), query.getInt(query.getColumnIndex("numberOfRetries"))));
            } while (query.moveToNext());
            query.close();
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public HashMap<String, String> mo55219c() {
        return new C3749a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55221c(C3731t1 t1Var) {
        int size = mo55218c(new Object[0]).size();
        if (size >= 10) {
            Cursor query = C3782x0.m1872d().getReadableDatabase().query(mo55222d(), new String[]{"feedbackUUID"}, (String) null, (String[]) null, (String) null, (String) null, "submittedTimestamp ASC LIMIT " + ((size - 10) + 1));
            ArrayList arrayList = new ArrayList();
            if (query != null && query.moveToFirst()) {
                do {
                    arrayList.add(query.getString(0));
                } while (query.moveToNext());
                query.close();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                SQLiteDatabase writableDatabase = C3782x0.m1872d().getWritableDatabase();
                String d = mo55222d();
                writableDatabase.delete(d, "feedbackUUID='" + ((String) arrayList.get(i)) + "'", (String[]) null);
            }
        }
        return super.mo55221c(t1Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55222d() {
        return f1916e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo55223d(C3731t1 t1Var) {
        SQLiteDatabase writableDatabase = C3782x0.m1872d().getWritableDatabase();
        String d = mo55222d();
        ContentValues b = mo55215b(t1Var);
        StringBuilder sb = new StringBuilder();
        sb.append("feedbackUUID='");
        sb.append(t1Var.mo55817b());
        sb.append("'");
        return writableDatabase.update(d, b, sb.toString(), (String[]) null) > 0 || super.mo55221c(t1Var);
    }
}
