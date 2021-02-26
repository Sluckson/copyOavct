package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3496e5;
import com.medallia.digital.mobilesdk.C3776w5;
import com.medallia.digital.mobilesdk.C3792y;
import com.medallia.digital.mobilesdk.C3815z4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.u5 */
class C3754u5 implements Observer, C3713r5 {

    /* renamed from: c */
    private static C3754u5 f1929c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f1930a = C3815z4.m2010d().mo55979a(C3815z4.C3816a.SDK_STOPPED, false);

    /* renamed from: b */
    private boolean f1931b;

    /* renamed from: com.medallia.digital.mobilesdk.u5$a */
    class C3755a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ Object f1932a;

        C3755a(Object obj) {
            this.f1932a = obj;
        }

        /* renamed from: a */
        public void mo55177a() {
            if (!C3754u5.this.f1930a) {
                Object obj = this.f1932a;
                if (obj instanceof C3803z) {
                    C3803z zVar = (C3803z) obj;
                    if (zVar.mo55940f() == Lifetime.Forever) {
                        C3782x0.m1872d().mo55915c((C3792y) zVar);
                    } else if (zVar.mo55940f() == Lifetime.Application || zVar.mo55940f() == Lifetime.Session) {
                        C3782x0.m1872d().mo55912b((C3792y) zVar);
                    }
                    if (C3612m0.CustomParameters.getName().equals(zVar.getName())) {
                        C3496e5.m699h().mo55346a(C3496e5.C3505e.customParameters);
                    }
                } else if ((obj instanceof C3485e) && C3646n3.m1337m().mo55672c().mo55366d()) {
                    C3485e eVar = (C3485e) this.f1932a;
                    if (eVar.mo55323c() == Lifetime.Forever) {
                        C3782x0.m1872d().mo55915c((C3792y) eVar);
                    } else if (eVar.mo55323c() == Lifetime.Application || eVar.mo55323c() == Lifetime.Session) {
                        C3782x0.m1872d().mo55912b((C3792y) eVar);
                    }
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.u5$b */
    static /* synthetic */ class C3756b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1934a = new int[C3757c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.medallia.digital.mobilesdk.u5$c[] r0 = com.medallia.digital.mobilesdk.C3754u5.C3757c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1934a = r0
                int[] r0 = f1934a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.u5$c r1 = com.medallia.digital.mobilesdk.C3754u5.C3757c.OsName     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1934a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.u5$c r1 = com.medallia.digital.mobilesdk.C3754u5.C3757c.DeviceId     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1934a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.u5$c r1 = com.medallia.digital.mobilesdk.C3754u5.C3757c.SessionId     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1934a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.medallia.digital.mobilesdk.u5$c r1 = com.medallia.digital.mobilesdk.C3754u5.C3757c.PropertyId     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3754u5.C3756b.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.u5$c */
    private enum C3757c {
        PropertyId,
        OsName,
        SessionId,
        DeviceId;

        /* renamed from: a */
        static C3757c m1763a(String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(PropertyId.toString())) {
                return PropertyId;
            }
            if (str.equals(OsName.toString())) {
                return OsName;
            }
            if (str.equals(SessionId.toString())) {
                return SessionId;
            }
            if (str.equals(DeviceId.toString())) {
                return DeviceId;
            }
            return null;
        }
    }

    private C3754u5() {
        C3490e3.m665e("UserJourney was initiated");
        CollectorsInfrastructure.getInstance().addObserverToCollectors(this);
        AnalyticsBridge.getInstance().addObserverToAnalyticsItems(this);
    }

    /* renamed from: a */
    private JSONArray m1741a(ArrayList<C3757c> arrayList, JSONArray jSONArray, String str) {
        String a;
        JSONArray jSONArray2 = jSONArray;
        if (str == null) {
            return jSONArray2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            long a2 = C3815z4.m2010d().mo55974a(C3815z4.C3816a.PROPERTY_ID, 0);
            if (a2 != 0) {
                jSONArray2.put(new C3803z(Long.valueOf(a2), GroupType.collector, Lifetime.Application, ValueType.TypeLong, "PropertyId", System.currentTimeMillis(), str).mo55938d());
            }
            String a3 = C3815z4.m2010d().mo55975a(C3815z4.C3816a.DEVICE_ID, (String) null);
            if (a3 != null) {
                jSONArray2.put(new C3803z(a3, GroupType.collector, Lifetime.Session, ValueType.TypeString, "DeviceId", System.currentTimeMillis(), str).mo55938d());
            }
            String str2 = str;
            jSONArray2.put(new C3803z("Android", GroupType.collector, Lifetime.Session, ValueType.TypeString, "OsName", System.currentTimeMillis(), str2).mo55938d());
            jSONArray2.put(new C3803z(str, GroupType.collector, Lifetime.Application, ValueType.TypeString, "SessionId", System.currentTimeMillis(), str2).mo55938d());
            return jSONArray2;
        }
        Iterator<C3757c> it = arrayList.iterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (it.hasNext()) {
            int i = C3756b.f1934a[it.next().ordinal()];
            if (i == 1) {
                z3 = true;
            } else if (i != 2) {
                if (i == 3) {
                    z4 = true;
                } else if (i != 4) {
                }
                z = true;
            } else {
                z2 = true;
            }
        }
        if (!z) {
            long a4 = C3815z4.m2010d().mo55974a(C3815z4.C3816a.PROPERTY_ID, 0);
            if (a4 != 0) {
                jSONArray2.put(new C3803z(Long.valueOf(a4), GroupType.collector, Lifetime.Application, ValueType.TypeLong, "PropertyId").mo55938d());
            }
        }
        if (!z2 && (a = C3815z4.m2010d().mo55975a(C3815z4.C3816a.DEVICE_ID, (String) null)) != null) {
            jSONArray2.put(new C3803z(a, GroupType.collector, Lifetime.Session, ValueType.TypeString, "DeviceId").mo55938d());
        }
        if (!z3) {
            jSONArray2.put(new C3803z("Android", GroupType.collector, Lifetime.Session, ValueType.TypeString, "OsName").mo55938d());
        }
        if (!z4) {
            jSONArray2.put(new C3803z(str, GroupType.collector, Lifetime.Application, ValueType.TypeString, "SessionId").mo55938d());
        }
        return jSONArray2;
    }

    /* renamed from: f */
    protected static C3754u5 m1743f() {
        if (f1929c == null) {
            f1929c = new C3754u5();
        }
        return f1929c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ArrayList<C3485e> mo55852a(long j, Long l, int i) {
        C3490e3.m665e("getAllAnalyticsV2RecordsForSession was called");
        return C3782x0.m1872d().mo55913c(C3792y.C3793a.AnalyticsData, Long.valueOf(j), l, Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ArrayList<C3803z> mo55853a(String str) {
        C3490e3.m665e("getAllRecordsForSession was called");
        return C3782x0.m1872d().mo55913c(C3792y.C3793a.UserJourneyData, C3776w5.C3780d.SESSION, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONArray mo55854a(ArrayList<C3485e> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null) {
                Iterator<C3485e> it = arrayList.iterator();
                while (it.hasNext()) {
                    C3485e next = it.next();
                    if (next.mo55324d() != null) {
                        jSONArray.put(next.mo55324d());
                    }
                }
            }
            return jSONArray;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return new JSONArray();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo55855a(boolean z) {
        C3490e3.m661b("exportCurrentUJSessionToJson was called");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userJourney", mo55863b(z));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55856a(ConfigurationContract configurationContract) {
        if (configurationContract != null && configurationContract.getSdkConfiguration() != null && configurationContract.getSdkConfiguration().getMedalliaDigitalBrain() != null) {
            this.f1931b = configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().isDistinct();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55857a(C3803z zVar) {
        C3782x0.m1872d().mo55915c((C3792y) zVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55858a(boolean z, Long l, long j) {
        String str;
        String str2;
        if (z) {
            if (mo55861a(l, j)) {
                str2 = String.format(Locale.US, "Analytics v2: events from %d to %d was cleared", new Object[]{l, Long.valueOf(j)});
            } else {
                str = String.format(Locale.US, "Analytics v2: failed to clear events from %l to %l was cleared", new Object[]{l, Long.valueOf(j)});
                C3490e3.m666f(str);
                return;
            }
        } else if (mo55860a(Lifetime.Application)) {
            str2 = "User Journey: lifetime type application was cleared";
        } else {
            str = "User Journey: failed to clear lifetime type application";
            C3490e3.m666f(str);
            return;
        }
        C3490e3.m661b(str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55859a() {
        return C3782x0.m1872d().mo55907a(C3792y.C3793a.UserJourneyData, Lifetime.Session, GroupType.collector);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55860a(Lifetime lifetime) {
        return C3782x0.m1872d().mo55907a(C3792y.C3793a.UserJourneyData, lifetime);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55861a(Long l, long j) {
        return C3782x0.m1872d().mo55907a(C3792y.C3793a.AnalyticsData, Long.valueOf(j), l);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo55862b() {
        try {
            return mo55869e().toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONArray mo55863b(boolean z) {
        try {
            String a = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, (String) null);
            ArrayList<C3803z> a2 = mo55853a(a);
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray();
            Iterator<C3803z> it = a2.iterator();
            while (it.hasNext()) {
                C3803z next = it.next();
                if (next.mo55938d() != null) {
                    if (!z || next.mo55939e() == null || next.mo55939e() != GroupType.collector || (next.getName() != null && next.getName().equals(C3612m0.CustomParameters.getName()))) {
                        jSONArray.put(next.mo55938d());
                    } else {
                        hashMap.put(next.getName(), next);
                    }
                }
                C3757c a3 = C3757c.m1763a(next.getName());
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
            if (z) {
                for (Map.Entry value : hashMap.entrySet()) {
                    C3803z zVar = (C3803z) value.getValue();
                    if (zVar != null) {
                        jSONArray.put(zVar.mo55938d());
                    }
                }
            }
            return m1741a((ArrayList<C3757c>) arrayList, jSONArray, a);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return new JSONArray();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONObject mo55864b(ArrayList<C3485e> arrayList) {
        C3490e3.m661b("exportAnalyticsToJsonObject was called");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("events", mo55854a(arrayList));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55865b(boolean z, Long l, long j) {
        String str;
        String str2;
        if (z) {
            if (mo55861a(l, j)) {
                str2 = String.format(Locale.US, "Analytics v2: events from %d to %d was cleared", new Object[]{l, Long.valueOf(j)});
            } else {
                str = String.format(Locale.US, "Analytics v2: failed to clear events from %l to %l was cleared", new Object[]{l, Long.valueOf(j)});
                C3490e3.m666f(str);
                return;
            }
        } else if (mo55860a(Lifetime.Session)) {
            str2 = "User Journey: lifetime type session was cleared";
        } else {
            str = "User Journey: failed to clear lifetime type session";
            C3490e3.m666f(str);
            return;
        }
        C3490e3.m661b(str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo55866c(boolean z) {
        this.f1930a = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String[] mo55867c() {
        ArrayList<C3803z> a = mo55853a(C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, (String) null));
        String[] strArr = {"", ""};
        if (a == null || a.isEmpty()) {
            C3490e3.m666f("User Journey failed to export : no data");
            return strArr;
        }
        Iterator<C3803z> it = a.iterator();
        while (it.hasNext()) {
            C3803z next = it.next();
            if (next.mo55939e() == GroupType.collector) {
                strArr[0] = strArr[0] + next.mo55936b();
            } else {
                strArr[1] = strArr[1] + next.mo55936b();
            }
        }
        C3490e3.m665e("User Journey was exported");
        return strArr;
    }

    public void clearAndDisconnect() {
        C3490e3.m659a(C3754u5.class.getSimpleName());
        f1929c = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo55868d() {
        return C3782x0.m1872d().mo55910b(C3792y.C3793a.UserJourneyData);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public JSONArray mo55869e() {
        String str;
        JSONArray jSONArray = new JSONArray();
        ArrayList<? extends C3792y> c = C3782x0.m1872d().mo55913c(C3792y.C3793a.UserJourneyData, C3776w5.C3780d.ALL);
        if (this.f1931b) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Iterator<? extends C3792y> it = c.iterator();
            while (it.hasNext()) {
                C3803z zVar = (C3803z) it.next();
                if (zVar.mo55939e() != GroupType.collector) {
                    hashMap2.put(zVar.getName(), zVar.mo55938d());
                } else {
                    if (zVar.getName().equals("CustomParameters")) {
                        str = zVar.getName() + UUID.randomUUID().toString();
                    } else {
                        str = zVar.getName();
                    }
                    hashMap.put(str, zVar.mo55938d());
                }
            }
            for (Map.Entry value : hashMap.entrySet()) {
                jSONArray.put(value.getValue());
            }
            for (Map.Entry value2 : hashMap2.entrySet()) {
                jSONArray.put(value2.getValue());
            }
        } else {
            Iterator<? extends C3792y> it2 = c.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((C3803z) it2.next()).mo55938d());
            }
        }
        return jSONArray;
    }

    public void update(Observable observable, Object obj) {
        C3561h5.m954c().mo55465a().execute(new C3755a(obj));
    }
}
