package com.salesforce.marketingcloud.proximity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.C4038g;
import com.salesforce.marketingcloud.C4039h;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.proximity.g */
public abstract class C4124g extends C4038g {

    /* renamed from: a */
    public static final String f3353a = "com.salesforce.marketingcloud.proximity.BEACON_REGION_ENTERED";

    /* renamed from: b */
    public static final String f3354b = "com.salesforce.marketingcloud.proximity.BEACON_REGION_EXITED";

    /* renamed from: c */
    public static final String f3355c = "beaconRegion";

    /* renamed from: d */
    protected static final String f3356d = C4039h.m2810a((Class<?>) C4124g.class);

    /* renamed from: e */
    private static final String f3357e = "ProximityManager";

    /* renamed from: com.salesforce.marketingcloud.proximity.g$a */
    public interface C4125a {
        /* renamed from: a */
        void mo56812a(@NonNull C4122e eVar);

        /* renamed from: b */
        void mo56813b(@NonNull C4122e eVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.salesforce.marketingcloud.proximity.C4124g m3350a(android.content.Context r8, com.salesforce.marketingcloud.MarketingCloudConfig r9) {
        /*
            boolean r0 = r9.proximityEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0058
            boolean r0 = m3354e()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0056
            boolean r2 = m3353a((android.content.Context) r8)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r3 = r2.booleanValue()
            if (r3 == 0) goto L_0x0054
            boolean r3 = com.salesforce.marketingcloud.p027e.C4024c.m2753a()
            r4 = 0
            if (r3 == 0) goto L_0x0044
            com.salesforce.marketingcloud.proximity.c r3 = new com.salesforce.marketingcloud.proximity.c     // Catch:{ IllegalStateException -> 0x0030 }
            r3.<init>(r8)     // Catch:{ IllegalStateException -> 0x0030 }
            return r3
        L_0x0030:
            r8 = move-exception
            java.lang.String r3 = r8.getMessage()
            java.lang.String r5 = f3356d
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = "ProximityManager"
            r6[r4] = r7
            java.lang.String r4 = "Unable to create real instance of %s"
            com.salesforce.marketingcloud.C4039h.m2830e(r5, r8, r4, r6)
            goto L_0x005b
        L_0x0044:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            java.lang.String r3 = f3356d
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "If you wish to use proximity messenger then you need to add the AltBeacon dependency."
            com.salesforce.marketingcloud.C4039h.m2826d(r3, r5, r4)
            r3 = r1
            r1 = r8
            goto L_0x005b
        L_0x0054:
            r3 = r1
            goto L_0x005b
        L_0x0056:
            r2 = r1
            goto L_0x005a
        L_0x0058:
            r0 = r1
            r2 = r0
        L_0x005a:
            r3 = r2
        L_0x005b:
            com.salesforce.marketingcloud.proximity.f r8 = new com.salesforce.marketingcloud.proximity.f
            boolean r4 = r9.proximityEnabled()
            boolean r9 = r9.proximityEnabled()
            org.json.JSONObject r9 = m3352a(r9, r2, r0, r1, r3)
            r8.<init>(r4, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.proximity.C4124g.m3350a(android.content.Context, com.salesforce.marketingcloud.MarketingCloudConfig):com.salesforce.marketingcloud.proximity.g");
    }

    /* renamed from: a */
    private static JSONObject m3351a(JSONObject jSONObject, boolean z) {
        jSONObject.put("proximityEnabled", z);
        return jSONObject;
    }

    /* renamed from: a */
    protected static JSONObject m3352a(boolean z, Boolean bool, Boolean bool2, Boolean bool3, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = m3351a(jSONObject, z);
            jSONObject.put("correctAndroidVersion", bool2);
            jSONObject.put("hardwareAvailable", bool);
            jSONObject.put("libraryDeclared", bool3);
            if (str != null) {
                jSONObject.put("serviceMissing", str);
            }
        } catch (JSONException e) {
            C4039h.m2830e(f3356d, e, "Error creating fake ProximityManager state.", new Object[0]);
        }
        return jSONObject;
    }

    @TargetApi(18)
    /* renamed from: a */
    protected static boolean m3353a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    /* renamed from: e */
    protected static boolean m3354e() {
        return Build.VERSION.SDK_INT >= 18;
    }

    /* renamed from: f */
    protected static JSONObject m3355f() {
        JSONObject jSONObject = new JSONObject();
        m3351a(jSONObject, true);
        return jSONObject;
    }

    /* renamed from: a */
    public abstract void mo56919a(@NonNull C4125a aVar);

    /* renamed from: a */
    public abstract void mo56920a(List<C4122e> list);

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return f3357e;
    }

    /* renamed from: b */
    public abstract void mo56922b(@NonNull C4125a aVar);

    /* renamed from: b */
    public abstract void mo56923b(List<C4122e> list);

    /* renamed from: c */
    public boolean mo56924c() {
        return false;
    }

    /* renamed from: d */
    public abstract void mo56925d();
}
