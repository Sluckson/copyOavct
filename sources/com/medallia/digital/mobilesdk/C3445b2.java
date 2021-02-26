package com.medallia.digital.mobilesdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.medallia.digital.mobilesdk.C3433a2;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.b2 */
class C3445b2 extends C3794y0<C3433a2> {

    /* renamed from: d */
    private static final String f913d = "formData";

    /* renamed from: com.medallia.digital.mobilesdk.b2$a */
    class C3446a extends HashMap<String, String> {
        C3446a() {
            put("formId", "TEXT");
            put("fromJson", "TEXT");
            put("templatePath", "TEXT");
            put("templateId", "TEXT");
            put("title", "TEXT");
            put("titleTextColor", "TEXT");
            put("titleBackgroundColor", "TEXT");
            put("formType", "TEXT");
            put("formStatus", "INTEGER");
            put("transitionType", "TEXT");
            put("inviteData", "TEXT");
            put("viewType", "TEXT");
            put("isPreloaded", "INTEGER");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.b2$b */
    private static class C3447b {

        /* renamed from: a */
        private static final String f915a = "formId";

        /* renamed from: b */
        private static final String f916b = "fromJson";

        /* renamed from: c */
        private static final String f917c = "templatePath";

        /* renamed from: d */
        private static final String f918d = "templateId";

        /* renamed from: e */
        private static final String f919e = "title";

        /* renamed from: f */
        private static final String f920f = "titleTextColor";

        /* renamed from: g */
        private static final String f921g = "titleBackgroundColor";

        /* renamed from: h */
        private static final String f922h = "formType";

        /* renamed from: i */
        private static final String f923i = "formStatus";

        /* renamed from: j */
        private static final String f924j = "transitionType";

        /* renamed from: k */
        private static final String f925k = "inviteData";

        /* renamed from: l */
        private static final String f926l = "viewType";

        /* renamed from: m */
        private static final String f927m = "isPreloaded";

        private C3447b() {
        }
    }

    C3445b2() {
    }

    /* renamed from: a */
    private InviteData m496a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("inviteData"));
        try {
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new InviteData(new JSONObject(string));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55232a(C3433a2 a2Var) {
        StringBuilder sb;
        String str;
        boolean z = false;
        boolean z2 = true;
        if (a2Var == null || TextUtils.isEmpty(a2Var.getFormId())) {
            sb = new StringBuilder();
            sb.append("delete (invalid data) - ");
            str = a2Var == null ? "record is null" : "formId is not valid";
        } else {
            if (C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), "formId='" + a2Var.getFormId() + "'", (String[]) null) > 0) {
                z = true;
            }
            z2 = !z;
            sb = new StringBuilder();
            sb.append("delete - ");
            str = a2Var.toString();
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
            return DatabaseUtils.queryNumEntries(C3782x0.m1872d().getWritableDatabase(), f913d);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ContentValues mo55215b(C3433a2 a2Var) {
        ContentValues contentValues = new ContentValues();
        if (a2Var != null) {
            contentValues.put("formId", a2Var.getFormId());
            contentValues.put("fromJson", a2Var.getFormJson());
            contentValues.put("templatePath", a2Var.mo55189c());
            contentValues.put("templateId", a2Var.mo55190d());
            contentValues.put("title", a2Var.getTitle());
            contentValues.put("titleTextColor", a2Var.getTitleTextColor());
            contentValues.put("titleBackgroundColor", a2Var.getTitleBackgroundColor());
            String str = null;
            contentValues.put("formType", a2Var.getFormType() != null ? a2Var.getFormType().toString() : null);
            contentValues.put("formStatus", a2Var.mo55182a() != null ? Integer.valueOf(a2Var.mo55182a().mo55203a()) : null);
            contentValues.put("transitionType", a2Var.mo55191e() != null ? a2Var.mo55191e().mo55598a() : null);
            contentValues.put("inviteData", a2Var.getInviteData() != null ? a2Var.getInviteData().toJsonString() : null);
            if (a2Var.getFormViewType() != null) {
                str = a2Var.getFormViewType().toString();
            }
            contentValues.put("viewType", str);
            contentValues.put("isPreloaded", Integer.valueOf(a2Var.mo55193f() ? 1 : 0));
        }
        return contentValues;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3433a2 m504b(Object... objArr) {
        Object[] objArr2 = objArr;
        C3433a2 a2Var = null;
        if (objArr2 != null && objArr2.length > 0) {
            if (objArr2[0] == null || !(objArr2[0] instanceof String)) {
                return null;
            }
            SQLiteDatabase readableDatabase = C3782x0.m1872d().getReadableDatabase();
            String d = mo55222d();
            Cursor query = readableDatabase.query(d, (String[]) null, "formId='" + ((String) objArr2[0]) + "'", (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    a2Var = new C3433a2(query.getString(query.getColumnIndex("formId")), query.getString(query.getColumnIndex("fromJson")), query.getString(query.getColumnIndex("templatePath")), query.getString(query.getColumnIndex("templateId")), new C3637m4().mo55593a(query.getString(query.getColumnIndex("formId"))), query.getString(query.getColumnIndex("title")), query.getString(query.getColumnIndex("titleTextColor")), query.getString(query.getColumnIndex("titleBackgroundColor")), FormTriggerType.fromString(query.getString(query.getColumnIndex("formType"))), C3433a2.C3434a.m457a(query.getInt(query.getColumnIndex("formStatus"))), C3640m5.m1268a(query.getString(query.getColumnIndex("transitionType"))), m496a(query), FormViewType.fromString(query.getString(query.getColumnIndex("viewType"))), query.getInt(query.getColumnIndex("isPreloaded")) == 1);
                }
                query.close();
                return a2Var;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ArrayList<C3433a2> mo55218c(Object... objArr) {
        ArrayList<C3433a2> arrayList = new ArrayList<>();
        Cursor query = C3782x0.m1872d().getReadableDatabase().query(mo55222d(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null && query.moveToFirst()) {
            do {
                arrayList.add(new C3433a2(query.getString(query.getColumnIndex("formId")), query.getString(query.getColumnIndex("fromJson")), query.getString(query.getColumnIndex("templatePath")), query.getString(query.getColumnIndex("templateId")), new C3637m4().mo55593a(query.getString(query.getColumnIndex("formId"))), query.getString(query.getColumnIndex("title")), query.getString(query.getColumnIndex("titleTextColor")), query.getString(query.getColumnIndex("titleBackgroundColor")), FormTriggerType.fromString(query.getString(query.getColumnIndex("formType"))), C3433a2.C3434a.m457a(query.getInt(query.getColumnIndex("formStatus"))), C3640m5.m1268a(query.getString(query.getColumnIndex("transitionType"))), m496a(query), FormViewType.fromString(query.getString(query.getColumnIndex("viewType"))), query.getInt(query.getColumnIndex("isPreloaded")) == 1));
            } while (query.moveToNext());
            query.close();
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public HashMap<String, String> mo55219c() {
        return new C3446a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55223d(C3433a2 a2Var) {
        SQLiteDatabase writableDatabase = C3782x0.m1872d().getWritableDatabase();
        String d = mo55222d();
        ContentValues b = mo55215b(a2Var);
        StringBuilder sb = new StringBuilder();
        sb.append("formId='");
        sb.append(a2Var.getFormId());
        sb.append("'");
        return writableDatabase.update(d, b, sb.toString(), (String[]) null) > 0 || super.mo55221c(a2Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55222d() {
        return f913d;
    }
}
