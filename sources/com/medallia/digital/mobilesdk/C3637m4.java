package com.medallia.digital.mobilesdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.m4 */
public class C3637m4 extends C3794y0<ResourceContract> {

    /* renamed from: d */
    private static final String f1494d = "ResourceData";

    /* renamed from: com.medallia.digital.mobilesdk.m4$a */
    class C3638a extends HashMap<String, String> {
        C3638a() {
            put("formId", "TEXT");
            put("remoteUrl", "TEXT");
            put("localUrl", "TEXT");
            put("checksum", "TEXT");
            put("isGlobal", "INTEGER");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m4$b */
    private static class C3639b {

        /* renamed from: a */
        private static final String f1496a = "formId";

        /* renamed from: b */
        private static final String f1497b = "remoteUrl";

        /* renamed from: c */
        private static final String f1498c = "localUrl";

        /* renamed from: d */
        private static final String f1499d = "checksum";

        /* renamed from: e */
        private static final String f1500e = "isGlobal";

        private C3639b() {
        }
    }

    /* renamed from: a */
    private ResourceContract m1251a(Cursor cursor, boolean z) {
        return new ResourceContract(cursor.getString(cursor.getColumnIndex("formId")), C3770w2.m1829a(cursor.getString(cursor.getColumnIndex("remoteUrl")), z), C3770w2.m1829a(cursor.getString(cursor.getColumnIndex("localUrl")), z), cursor.getString(cursor.getColumnIndex("checksum")), cursor.getInt(cursor.getColumnIndex("isGlobal")) == 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ArrayList<ResourceContract> mo55593a(String str) {
        ArrayList<ResourceContract> arrayList = new ArrayList<>();
        if (str != null) {
            SQLiteDatabase readableDatabase = C3782x0.m1872d().getReadableDatabase();
            String d = mo55222d();
            Cursor query = readableDatabase.query(d, (String[]) null, "formId='" + str + "'", (String[]) null, (String) null, (String) null, (String) null);
            if (query != null && query.moveToFirst()) {
                do {
                    arrayList.add(m1251a(query, false));
                } while (query.moveToNext());
                query.close();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55232a(ResourceContract resourceContract) {
        StringBuilder sb;
        String str;
        boolean z = false;
        boolean z2 = true;
        if (resourceContract == null || TextUtils.isEmpty(resourceContract.getFormId())) {
            sb = new StringBuilder();
            sb.append("delete (invalid data) - ");
            str = resourceContract == null ? "record is null" : "formId is not valid";
        } else {
            if (C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), "formId='" + resourceContract.getFormId() + "' AND " + "remoteUrl" + "='" + C3770w2.m1829a(resourceContract.getRemoteUrl(), true) + "'", (String[]) null) > 0) {
                z = true;
            }
            z2 = !z;
            sb = new StringBuilder();
            sb.append("delete - ");
            str = resourceContract.toString();
        }
        sb.append(str);
        mo55928a(z2, sb.toString());
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55213a(Object... objArr) {
        if (objArr == null || objArr.length <= 0 || objArr[0] == null || !(objArr[0] instanceof Boolean)) {
            return false;
        }
        boolean booleanValue = objArr[0].booleanValue();
        StringBuilder sb = new StringBuilder();
        sb.append("isGlobal='");
        sb.append(booleanValue ? 1 : 0);
        sb.append("'");
        return C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), sb.toString(), (String[]) null) > 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo55214b() {
        try {
            return DatabaseUtils.queryNumEntries(C3782x0.m1872d().getWritableDatabase(), f1494d);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ContentValues mo55215b(ResourceContract resourceContract) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("formId", resourceContract.getFormId());
        contentValues.put("remoteUrl", C3770w2.m1829a(resourceContract.getRemoteUrl(), true));
        contentValues.put("localUrl", C3770w2.m1829a(resourceContract.getLocalUrl(), true));
        contentValues.put("checksum", resourceContract.getChecksum());
        contentValues.put("isGlobal", Integer.valueOf(resourceContract.isGlobal().booleanValue() ? 1 : 0));
        return contentValues;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ResourceContract m1260b(Object... objArr) {
        ResourceContract resourceContract = null;
        if (objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String)) {
            SQLiteDatabase readableDatabase = C3782x0.m1872d().getReadableDatabase();
            String d = mo55222d();
            Cursor query = readableDatabase.query(d, (String[]) null, "remoteUrl='" + C3770w2.m1829a(objArr[0], true) + "'", (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    resourceContract = m1251a(query, false);
                }
                query.close();
            }
        }
        return resourceContract;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ArrayList<ResourceContract> mo55218c(Object... objArr) {
        Cursor cursor;
        if (objArr == null || objArr.length <= 0) {
            cursor = C3782x0.m1872d().getReadableDatabase().query(mo55222d(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        } else if (objArr[0] == null || !(objArr[0] instanceof Boolean)) {
            return null;
        } else {
            boolean booleanValue = objArr[0].booleanValue();
            SQLiteDatabase readableDatabase = C3782x0.m1872d().getReadableDatabase();
            cursor = readableDatabase.rawQuery("select * from '" + mo55222d() + "' where " + "isGlobal" + "='" + (booleanValue ? 1 : 0) + "'", (String[]) null);
        }
        ArrayList<ResourceContract> arrayList = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                arrayList.add(m1251a(cursor, false));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public HashMap<String, String> mo55219c() {
        return new C3638a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55221c(ResourceContract resourceContract) {
        if (!TextUtils.isEmpty(resourceContract.getFormId()) && !TextUtils.isEmpty(resourceContract.getRemoteUrl()) && !TextUtils.isEmpty(resourceContract.getLocalUrl())) {
            return super.mo55221c(resourceContract);
        }
        mo55928a(true, "insert (invalid data from collector) - " + resourceContract.toString());
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55222d() {
        return f1494d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo55223d(ResourceContract resourceContract) {
        SQLiteDatabase writableDatabase = C3782x0.m1872d().getWritableDatabase();
        String d = mo55222d();
        ContentValues b = mo55215b(resourceContract);
        StringBuilder sb = new StringBuilder();
        sb.append("remoteUrl='");
        sb.append(C3770w2.m1829a(resourceContract.getRemoteUrl(), true));
        sb.append("' AND ");
        sb.append("localUrl");
        sb.append("='");
        sb.append(C3770w2.m1829a(resourceContract.getLocalUrl(), true));
        String str = "'";
        if (!TextUtils.isEmpty(resourceContract.getFormId())) {
            str = "' AND formId='" + resourceContract.getFormId() + str;
        }
        sb.append(str);
        return writableDatabase.update(d, b, sb.toString(), (String[]) null) > 0 || super.mo55221c(resourceContract);
    }
}
