package com.medallia.digital.mobilesdk;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3792y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.medallia.digital.mobilesdk.x0 */
class C3782x0 extends SQLiteOpenHelper implements C3713r5 {

    /* renamed from: b */
    private static final String f2016b = "MedalliaDigitalDB";

    /* renamed from: c */
    private static final int f2017c = C3784b.V9.ordinal();

    /* renamed from: d */
    private static C3782x0 f2018d = null;
    @VisibleForTesting

    /* renamed from: e */
    private static final double f2019e = 10.0d;

    /* renamed from: a */
    private HashMap<String, C3794y0> f2020a = new HashMap<>();

    /* renamed from: com.medallia.digital.mobilesdk.x0$a */
    static /* synthetic */ class C3783a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2021a = new int[C3792y.C3793a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.medallia.digital.mobilesdk.y$a[] r0 = com.medallia.digital.mobilesdk.C3792y.C3793a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2021a = r0
                int[] r0 = f2021a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.y$a r1 = com.medallia.digital.mobilesdk.C3792y.C3793a.UserJourneyData     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2021a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.y$a r1 = com.medallia.digital.mobilesdk.C3792y.C3793a.FormData     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2021a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.y$a r1 = com.medallia.digital.mobilesdk.C3792y.C3793a.Resource     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f2021a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.medallia.digital.mobilesdk.y$a r1 = com.medallia.digital.mobilesdk.C3792y.C3793a.Template     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f2021a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.medallia.digital.mobilesdk.y$a r1 = com.medallia.digital.mobilesdk.C3792y.C3793a.Feedback     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f2021a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.medallia.digital.mobilesdk.y$a r1 = com.medallia.digital.mobilesdk.C3792y.C3793a.AnalyticsData     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3782x0.C3783a.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.x0$b */
    private enum C3784b {
        V0,
        V1,
        V2,
        V3,
        V4,
        V5,
        V6,
        V7,
        V8,
        V9
    }

    protected C3782x0() {
        super(C3595k3.m1060d().mo55513b(), f2016b, (SQLiteDatabase.CursorFactory) null, f2017c);
        this.f2020a.put(C3776w5.class.getSimpleName(), new C3776w5());
        this.f2020a.put(C3445b2.class.getSimpleName(), new C3445b2());
        this.f2020a.put(C3637m4.class.getSimpleName(), new C3637m4());
        this.f2020a.put(C3544g5.class.getSimpleName(), new C3544g5());
        this.f2020a.put(C3748u1.class.getSimpleName(), new C3748u1());
        this.f2020a.put(C3440b.class.getSimpleName(), new C3440b());
    }

    /* renamed from: a */
    private void m1868a(SQLiteDatabase sQLiteDatabase, Class cls) {
        C3794y0 y0Var = this.f2020a.get(cls.getSimpleName());
        if (y0Var != null) {
            m1869a(sQLiteDatabase, y0Var.mo55222d());
            m1870a(sQLiteDatabase, y0Var.mo55222d(), y0Var.mo55219c());
        }
    }

    /* renamed from: a */
    private void m1869a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    /* renamed from: a */
    private void m1870a(SQLiteDatabase sQLiteDatabase, String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder("CREATE TABLE " + str + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT");
        for (Map.Entry next : hashMap.entrySet()) {
            sb.append(", ");
            sb.append((String) next.getKey());
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append((String) next.getValue());
        }
        sb.append(" )");
        sQLiteDatabase.execSQL(sb.toString());
    }

    /* renamed from: c */
    private C3794y0<C3792y> m1871c(C3792y.C3793a aVar) {
        HashMap<String, C3794y0> hashMap;
        Class cls;
        switch (C3783a.f2021a[aVar.ordinal()]) {
            case 1:
                hashMap = this.f2020a;
                cls = C3776w5.class;
                break;
            case 2:
                hashMap = this.f2020a;
                cls = C3445b2.class;
                break;
            case 3:
                hashMap = this.f2020a;
                cls = C3637m4.class;
                break;
            case 4:
                hashMap = this.f2020a;
                cls = C3544g5.class;
                break;
            case 5:
                hashMap = this.f2020a;
                cls = C3748u1.class;
                break;
            case 6:
                hashMap = this.f2020a;
                cls = C3440b.class;
                break;
            default:
                return null;
        }
        return hashMap.get(cls.getSimpleName());
    }

    /* renamed from: d */
    public static C3782x0 m1872d() {
        if (f2018d == null && C3595k3.m1060d().mo55513b() != null) {
            f2018d = new C3782x0();
        }
        return f2018d;
    }

    @VisibleForTesting
    /* renamed from: a */
    public double mo55905a() {
        return 1.048576E7d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55906a(C3792y.C3793a aVar) {
        return (aVar == null || m1871c(aVar) == null || !m1871c(aVar).mo55929a()) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55907a(C3792y.C3793a aVar, Object... objArr) {
        return (aVar == null || m1871c(aVar) == null || !m1871c(aVar).mo55213a(objArr)) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55908a(C3792y yVar) {
        return (yVar == null || yVar.getDataTableObjectType() == null || m1871c(yVar.getDataTableObjectType()) == null || !m1871c(yVar.getDataTableObjectType()).mo55232a(yVar)) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public double mo55909b() {
        return C3488e1.m652a(C3595k3.m1060d().mo55513b().getDatabasePath(f2016b).length());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo55910b(C3792y.C3793a aVar) {
        if (aVar == null || m1871c(aVar) == null) {
            return 0;
        }
        return m1871c(aVar).mo55214b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3792y mo55911b(C3792y.C3793a aVar, Object... objArr) {
        if (aVar == null || m1871c(aVar) == null) {
            return null;
        }
        return m1871c(aVar).mo55216b(objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo55912b(C3792y yVar) {
        return (yVar == null || yVar.getDataTableObjectType() == null || m1871c(yVar.getDataTableObjectType()) == null || !m1871c(yVar.getDataTableObjectType()).mo55221c(yVar)) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ArrayList<? extends C3792y> mo55913c(C3792y.C3793a aVar, Object... objArr) {
        if (aVar == null || m1871c(aVar) == null) {
            return null;
        }
        return m1871c(aVar).mo55218c(objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55914c() {
        return ((double) C3595k3.m1060d().mo55513b().getDatabasePath(f2016b).length()) > mo55905a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55915c(C3792y yVar) {
        return (yVar == null || yVar.getDataTableObjectType() == null || m1871c(yVar.getDataTableObjectType()) == null || !m1871c(yVar.getDataTableObjectType()).mo55223d(yVar)) ? false : true;
    }

    public void clearAndDisconnect() {
        C3490e3.m659a("Database");
        C3595k3.m1060d().mo55513b().deleteDatabase(f2016b);
        f2018d = null;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (C3794y0 next : this.f2020a.values()) {
            m1870a(sQLiteDatabase, next.mo55222d(), next.mo55219c());
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < C3784b.V2.ordinal()) {
            m1868a(sQLiteDatabase, C3776w5.class);
        }
        if (i < C3784b.V3.ordinal()) {
            m1868a(sQLiteDatabase, C3544g5.class);
        }
        if (i < C3784b.V4.ordinal() || i < C3784b.V7.ordinal() || i < C3784b.V8.ordinal() || i < C3784b.V9.ordinal()) {
            m1868a(sQLiteDatabase, C3445b2.class);
        }
        if (i < C3784b.V5.ordinal()) {
            m1868a(sQLiteDatabase, C3637m4.class);
        }
        if (i < C3784b.V6.ordinal()) {
            m1868a(sQLiteDatabase, C3748u1.class);
        }
        if (i < C3784b.V9.ordinal()) {
            m1868a(sQLiteDatabase, C3440b.class);
        }
    }
}
