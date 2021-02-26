package com.medallia.digital.mobilesdk;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.w5 */
class C3776w5 extends C3794y0<C3803z> {

    /* renamed from: d */
    private static final String f1993d = "userJourney";

    /* renamed from: com.medallia.digital.mobilesdk.w5$a */
    class C3777a extends HashMap<String, String> {
        C3777a() {
            put("sessionId", "TEXT");
            put("name", "TEXT");
            put("value", "TEXT");
            put("valueType", "TEXT");
            put("lifetime", "TEXT");
            put("timestamp", "INTEGER");
            put("groupType", "TEXT");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.w5$b */
    static /* synthetic */ class C3778b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1995a = new int[C3780d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.medallia.digital.mobilesdk.w5$d[] r0 = com.medallia.digital.mobilesdk.C3776w5.C3780d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1995a = r0
                int[] r0 = f1995a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.w5$d r1 = com.medallia.digital.mobilesdk.C3776w5.C3780d.ALL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1995a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.w5$d r1 = com.medallia.digital.mobilesdk.C3776w5.C3780d.SESSION     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1995a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.w5$d r1 = com.medallia.digital.mobilesdk.C3776w5.C3780d.EVENTS_SESSION     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1995a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.medallia.digital.mobilesdk.w5$d r1 = com.medallia.digital.mobilesdk.C3776w5.C3780d.DISTINCT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f1995a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.medallia.digital.mobilesdk.w5$d r1 = com.medallia.digital.mobilesdk.C3776w5.C3780d.DISTINCT_SESSION_COLLECTORS     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f1995a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.medallia.digital.mobilesdk.w5$d r1 = com.medallia.digital.mobilesdk.C3776w5.C3780d.CUSTOM_PARAMS     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f1995a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.medallia.digital.mobilesdk.w5$d r1 = com.medallia.digital.mobilesdk.C3776w5.C3780d.CUSTOM_PARAMS_SESSION     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3776w5.C3778b.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.w5$c */
    private static class C3779c {

        /* renamed from: a */
        private static final String f1996a = "sessionId";

        /* renamed from: b */
        private static final String f1997b = "name";

        /* renamed from: c */
        private static final String f1998c = "value";

        /* renamed from: d */
        private static final String f1999d = "valueType";

        /* renamed from: e */
        private static final String f2000e = "lifetime";

        /* renamed from: f */
        private static final String f2001f = "timestamp";

        /* renamed from: g */
        private static final String f2002g = "groupType";

        private C3779c() {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.w5$d */
    enum C3780d {
        ALL,
        SESSION,
        EVENTS_SESSION,
        DISTINCT,
        DISTINCT_SESSION_COLLECTORS,
        CUSTOM_PARAMS,
        CUSTOM_PARAMS_SESSION
    }

    C3776w5() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ContentValues mo55215b(C3803z zVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sessionId", zVar.mo55941g());
        contentValues.put("name", zVar.getName());
        String str = null;
        contentValues.put("value", zVar.mo55944i() == null ? null : zVar.mo55944i().toString());
        contentValues.put("valueType", zVar.mo55945j() == null ? null : zVar.mo55945j().name());
        contentValues.put("timestamp", Long.valueOf(zVar.mo55943h()));
        contentValues.put("lifetime", zVar.mo55940f() == null ? null : zVar.mo55940f().name());
        if (zVar.mo55939e() != null) {
            str = zVar.mo55939e().name();
        }
        contentValues.put("groupType", str);
        return contentValues;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55213a(Object... objArr) {
        boolean z = false;
        if (!(objArr == null || objArr.length == 0)) {
            Object obj = objArr[0];
            Lifetime lifetime = Lifetime.Session;
            if (obj instanceof Lifetime) {
                lifetime = objArr[0];
            }
            String str = "lifetime='" + lifetime.name() + "'";
            if (objArr.length > 1 && (objArr[1] instanceof GroupType)) {
                str = str + " AND groupType!='" + objArr[1].name() + "'";
            }
            if (lifetime == Lifetime.Application) {
                str = str + " OR lifetime='" + Lifetime.Session.name() + "'";
            }
            if (lifetime == Lifetime.Forever) {
                str = null;
            }
            if (C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), str, (String[]) null) > 0) {
                z = true;
            }
            if (z) {
                C3490e3.m665e("Delete records by criterion " + lifetime.name());
            }
            mo55928a(!z, "delete by " + lifetime.name() + " criterion");
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo55214b() {
        try {
            return DatabaseUtils.queryNumEntries(C3782x0.m1872d().getWritableDatabase(), f1993d);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3803z m1851b(Object... objArr) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo55221c(C3803z zVar) {
        if (!TextUtils.isEmpty(zVar.mo55941g()) && zVar.mo55943h() > 0) {
            return super.mo55221c(zVar);
        }
        mo55928a(true, "insert (invalid data from event) - " + zVar.toString());
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f9, code lost:
        r3.append(r0);
        r3.append("'");
        r0 = r8.query(r9, (java.lang.String[]) null, r3.toString(), (java.lang.String[]) null, (java.lang.String) null, (java.lang.String) null, "timestamp ASC");
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.medallia.digital.mobilesdk.C3803z> mo55218c(java.lang.Object... r19) {
        /*
            r18 = this;
            r0 = r19
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "groupType"
            if (r0 == 0) goto L_0x0110
            int r3 = r0.length
            if (r3 <= 0) goto L_0x0110
            r3 = 0
            r4 = r0[r3]
            boolean r4 = r4 instanceof com.medallia.digital.mobilesdk.C3776w5.C3780d
            if (r4 == 0) goto L_0x010e
            r3 = r0[r3]
            com.medallia.digital.mobilesdk.w5$d r3 = (com.medallia.digital.mobilesdk.C3776w5.C3780d) r3
            int[] r4 = com.medallia.digital.mobilesdk.C3776w5.C3778b.f1995a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            java.lang.String r4 = "' AND "
            java.lang.String r5 = "'"
            java.lang.String r6 = "sessionId='"
            r7 = 1
            switch(r3) {
                case 1: goto L_0x0110;
                case 2: goto L_0x00e3;
                case 3: goto L_0x00ae;
                case 4: goto L_0x0092;
                case 5: goto L_0x005b;
                case 6: goto L_0x0047;
                case 7: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x010e
        L_0x002d:
            com.medallia.digital.mobilesdk.x0 r3 = com.medallia.digital.mobilesdk.C3782x0.m1872d()
            android.database.sqlite.SQLiteDatabase r8 = r3.getReadableDatabase()
            java.lang.String r9 = r18.mo55222d()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "name='CustomParameters' AND sessionId='"
            r3.append(r4)
            r0 = r0[r7]
            goto L_0x00f9
        L_0x0047:
            com.medallia.digital.mobilesdk.x0 r0 = com.medallia.digital.mobilesdk.C3782x0.m1872d()
            android.database.sqlite.SQLiteDatabase r3 = r0.getReadableDatabase()
            java.lang.String r4 = r18.mo55222d()
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r6 = "name='CustomParameters'"
            goto L_0x0121
        L_0x005b:
            com.medallia.digital.mobilesdk.x0 r3 = com.medallia.digital.mobilesdk.C3782x0.m1872d()
            android.database.sqlite.SQLiteDatabase r8 = r3.getReadableDatabase()
            java.lang.String r10 = r18.mo55222d()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r0 = r0[r7]
            r3.append(r0)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r0 = " == collector"
            r3.append(r0)
            java.lang.String r12 = r3.toString()
            r9 = 1
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            java.lang.String r16 = "timestamp ASC"
            android.database.Cursor r0 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0127
        L_0x0092:
            com.medallia.digital.mobilesdk.x0 r0 = com.medallia.digital.mobilesdk.C3782x0.m1872d()
            android.database.sqlite.SQLiteDatabase r3 = r0.getReadableDatabase()
            java.lang.String r5 = r18.mo55222d()
            r4 = 1
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            java.lang.String r9 = "name"
            java.lang.String r11 = "timestamp ASC"
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x0127
        L_0x00ae:
            com.medallia.digital.mobilesdk.x0 r3 = com.medallia.digital.mobilesdk.C3782x0.m1872d()
            android.database.sqlite.SQLiteDatabase r8 = r3.getReadableDatabase()
            java.lang.String r9 = r18.mo55222d()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r0 = r0[r7]
            r3.append(r0)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r0 = " != collector"
            r3.append(r0)
            java.lang.String r11 = r3.toString()
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            java.lang.String r15 = "timestamp ASC"
            android.database.Cursor r0 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0127
        L_0x00e3:
            com.medallia.digital.mobilesdk.x0 r3 = com.medallia.digital.mobilesdk.C3782x0.m1872d()
            android.database.sqlite.SQLiteDatabase r8 = r3.getReadableDatabase()
            java.lang.String r9 = r18.mo55222d()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r0 = r0[r7]
        L_0x00f9:
            r3.append(r0)
            r3.append(r5)
            java.lang.String r11 = r3.toString()
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.lang.String r15 = "timestamp ASC"
            android.database.Cursor r0 = r8.query(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0127
        L_0x010e:
            r0 = 0
            goto L_0x0127
        L_0x0110:
            com.medallia.digital.mobilesdk.x0 r0 = com.medallia.digital.mobilesdk.C3782x0.m1872d()
            android.database.sqlite.SQLiteDatabase r3 = r0.getReadableDatabase()
            java.lang.String r4 = r18.mo55222d()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0121:
            java.lang.String r10 = "timestamp ASC"
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10)
        L_0x0127:
            if (r0 == 0) goto L_0x0191
            boolean r3 = r0.moveToFirst()
            if (r3 == 0) goto L_0x0191
        L_0x012f:
            com.medallia.digital.mobilesdk.z r3 = new com.medallia.digital.mobilesdk.z
            java.lang.String r4 = "value"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r5 = r0.getString(r4)
            int r4 = r0.getColumnIndex(r2)
            java.lang.String r4 = r0.getString(r4)
            com.medallia.digital.mobilesdk.GroupType r6 = com.medallia.digital.mobilesdk.GroupType.valueOf(r4)
            java.lang.String r4 = "lifetime"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r4 = r0.getString(r4)
            com.medallia.digital.mobilesdk.Lifetime r7 = com.medallia.digital.mobilesdk.Lifetime.valueOf(r4)
            java.lang.String r4 = "valueType"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r4 = r0.getString(r4)
            com.medallia.digital.mobilesdk.ValueType r8 = com.medallia.digital.mobilesdk.ValueType.fromString(r4)
            java.lang.String r4 = "name"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r9 = r0.getString(r4)
            java.lang.String r4 = "timestamp"
            int r4 = r0.getColumnIndex(r4)
            long r10 = r0.getLong(r4)
            java.lang.String r4 = "sessionId"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r12 = r0.getString(r4)
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r12)
            r1.add(r3)
            boolean r3 = r0.moveToNext()
            if (r3 != 0) goto L_0x012f
            r0.close()
        L_0x0191:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3776w5.mo55218c(java.lang.Object[]):java.util.ArrayList");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public HashMap<String, String> mo55219c() {
        return new C3777a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55223d(C3803z zVar) {
        SQLiteDatabase writableDatabase = C3782x0.m1872d().getWritableDatabase();
        String d = mo55222d();
        ContentValues a = mo55215b(zVar);
        StringBuilder sb = new StringBuilder();
        sb.append("name='");
        sb.append(zVar.getName());
        sb.append("'");
        return writableDatabase.update(d, a, sb.toString(), (String[]) null) > 0 || super.mo55221c(zVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55222d() {
        return f1993d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo55224e() {
        return "timestamp";
    }
}
