package com.salesforce.marketingcloud.p027e;

/* renamed from: com.salesforce.marketingcloud.e.c */
public class C4024c {

    /* renamed from: a */
    private static Boolean f2921a;

    /* renamed from: b */
    private static Boolean f2922b;

    private C4024c() {
    }

    /* renamed from: a */
    public static boolean m2753a() {
        if (f2922b == null) {
            try {
                Class.forName("org.altbeacon.beacon.BeaconManager");
                f2922b = true;
            } catch (ClassNotFoundException unused) {
                f2922b = false;
            }
        }
        return f2922b.booleanValue();
    }

    /* renamed from: b */
    public static boolean m2754b() {
        if (f2921a == null) {
            try {
                Class.forName("com.google.android.gms.location.LocationServices");
                f2921a = true;
            } catch (ClassNotFoundException unused) {
                f2921a = false;
            }
        }
        return f2921a.booleanValue();
    }
}
