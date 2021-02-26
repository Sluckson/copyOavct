package com.salesforce.marketingcloud.p022d;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.C3962a;
import com.salesforce.marketingcloud.p022d.p023a.C3996f;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4027f;
import com.salesforce.marketingcloud.p027e.C4028g;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import lib.android.paypal.com.magnessdk.p058a.C4820b;

/* renamed from: com.salesforce.marketingcloud.d.d */
abstract class C4010d {

    /* renamed from: a */
    private static final String f2886a = "DEFAULT_SHARED_PREFERENCES";

    /* renamed from: b */
    private static final String f2887b = C4039h.m2810a((Class<?>) C4010d.class);

    /* renamed from: c */
    private static final String f2888c = "et_207_preference_migration_complete";

    /* renamed from: d */
    private static AtomicBoolean f2889d = new AtomicBoolean(false);

    /* renamed from: e */
    protected static final int f2890e = -1;

    /* renamed from: f */
    private final String f2891f;

    /* renamed from: g */
    private final String f2892g;

    C4010d(@NonNull String str, @NonNull String str2) {
        this.f2891f = (String) C4028g.m2761a((CharSequence) C4028g.m2762a(str, "Application ID is null."), "Application ID is empty.");
        this.f2892g = (String) C4028g.m2761a((CharSequence) C4028g.m2762a(str2, "Access Token is null."), "Access Token is empty.");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0036 */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m2663a(@androidx.annotation.NonNull com.salesforce.marketingcloud.p027e.C4022a r7, java.lang.String r8, java.lang.reflect.Type r9) {
        /*
            r6 = this;
            android.content.Context r0 = r6.mo56528b()
            r1 = 0
            java.lang.String r2 = "ETPush"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r1)
            r2 = 0
            java.lang.String r3 = "%s_enc"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ ClassCastException -> 0x0042 }
            r5[r1] = r8     // Catch:{ ClassCastException -> 0x0042 }
            java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ ClassCastException -> 0x0042 }
            java.lang.String r3 = r0.getString(r3, r2)     // Catch:{ ClassCastException -> 0x0042 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r3 = r0.getString(r8, r2)     // Catch:{ ClassCastException -> 0x0042 }
        L_0x0021:
            if (r3 == 0) goto L_0x0041
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ UnsupportedEncodingException | GeneralSecurityException -> 0x0036 }
            java.lang.String r3 = r7.mo56545b(r0)     // Catch:{ UnsupportedEncodingException | GeneralSecurityException -> 0x0036 }
            java.lang.String r7 = f2887b     // Catch:{ UnsupportedEncodingException | GeneralSecurityException -> 0x0036 }
            java.lang.String r0 = "Found encrypted value for %s"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ UnsupportedEncodingException | GeneralSecurityException -> 0x0036 }
            r5[r1] = r8     // Catch:{ UnsupportedEncodingException | GeneralSecurityException -> 0x0036 }
            com.salesforce.marketingcloud.C4039h.m2823c(r7, r0, r5)     // Catch:{ UnsupportedEncodingException | GeneralSecurityException -> 0x0036 }
            goto L_0x0041
        L_0x0036:
            java.lang.String r7 = f2887b     // Catch:{ ClassCastException -> 0x0042 }
            java.lang.String r0 = "Found unencrypted value for %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassCastException -> 0x0042 }
            r4[r1] = r8     // Catch:{ ClassCastException -> 0x0042 }
            com.salesforce.marketingcloud.C4039h.m2823c(r7, r0, r4)     // Catch:{ ClassCastException -> 0x0042 }
        L_0x0041:
            r2 = r3
        L_0x0042:
            if (r2 == 0) goto L_0x0045
            goto L_0x0049
        L_0x0045:
            java.lang.Object r2 = r6.m2664a((java.lang.String) r8, (java.lang.reflect.Type) r9)
        L_0x0049:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p022d.C4010d.m2663a(com.salesforce.marketingcloud.e.a, java.lang.String, java.lang.reflect.Type):java.lang.Object");
    }

    @Nullable
    /* renamed from: a */
    private Object m2664a(String str, Type type) {
        for (String str2 : new String[]{"ETPush", "et_registration_cache", "~!Registration", "~!ETPush", "~!ETLocationManager", "etpushSDK@ETPush", "etpushsdk@ETLocationManager", f2886a}) {
            SharedPreferences defaultSharedPreferences = f2886a.equals(str2) ? PreferenceManager.getDefaultSharedPreferences(mo56528b()) : mo56528b().getSharedPreferences(str2, 0);
            if (defaultSharedPreferences.contains(str)) {
                if (type == Integer.class) {
                    try {
                        return Integer.valueOf(defaultSharedPreferences.getInt(str, 0));
                    } catch (ClassCastException unused) {
                    }
                } else if (type == Boolean.class) {
                    return Boolean.valueOf(defaultSharedPreferences.getBoolean(str, false));
                } else {
                    if (type == Long.class) {
                        return Long.valueOf(defaultSharedPreferences.getLong(str, 0));
                    }
                    if (type == String.class) {
                        return defaultSharedPreferences.getString(str, (String) null);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m2665a(Context context, String str, String str2) {
        boolean z;
        try {
            boolean andSet = f2889d.getAndSet(true);
            boolean z2 = mo56532e().getBoolean(f2888c, false);
            if (!andSet) {
                if (!z2) {
                    C4027f fVar = new C4027f(context, str, str2, mo56534f());
                    try {
                        fVar.mo56545b(context.getSharedPreferences("ETPush", 0).getString("et_device_id_cache_enc", (String) null));
                        z = true;
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (!z) {
                        C4039h.m2820b(f2887b, "Unable to verify old encryption.  Moving on without migrating data.", new Object[0]);
                    } else if (mo56527a(context, (C4022a) fVar)) {
                        mo56526a((C4022a) fVar);
                        C4039h.m2823c(f2887b, "Old data migrations completed without exception.", new Object[0]);
                    }
                    mo56532e().edit().putBoolean(f2888c, true).apply();
                    f2889d.set(false);
                    return;
                }
            }
            mo56532e().edit().putBoolean(f2888c, true).apply();
            f2889d.set(false);
        } catch (Exception e) {
            C4039h.m2830e(f2887b, e, "Data migration failed", new Object[0]);
        } catch (Throwable th) {
            mo56532e().edit().putBoolean(f2888c, true).apply();
            f2889d.set(false);
            throw th;
        }
    }

    /* renamed from: a */
    private void m2666a(String str) {
        C4039h.m2823c(f2887b, "Unknown Type for %s. Preference will not be migrated.", str);
    }

    /* renamed from: b */
    private void m2667b(@NonNull C4022a aVar) {
        Map<String, String> c;
        for (String str : new String[]{C4007c.f2876c, C4007c.f2875b, C4007c.f2877d, C4007c.f2878e, C4007c.f2880g, C4007c.f2879f, "et_last_location_latitude", "et_last_location_longitude"}) {
            try {
                C4039h.m2823c(f2887b, "Migrating %s ...", str);
                Object a = m2663a(aVar, str, (Type) String.class);
                if (C4007c.f2875b.equals(str) && (c = C4029h.m2778c((String) a)) != null) {
                    c.remove("_ETSDKVersion");
                    a = C4029h.m2767a(c);
                }
                if (a == null || "null".equals(a)) {
                    C4039h.m2823c(f2887b, "Value was \"null\" and will not be migrated.", new Object[0]);
                } else {
                    C4039h.m2823c(f2887b, "Writing %s to encrypted preferences ...", str);
                    mo56531d().mo56522a(str, String.valueOf(a));
                }
                C4039h.m2823c(f2887b, "Done with %s.", str);
            } catch (Exception e) {
                C4039h.m2830e(f2887b, e, "Unable to migrate %s", str);
            }
        }
    }

    /* renamed from: c */
    private void m2668c(@NonNull C4022a aVar) {
        long longValue;
        int intValue;
        boolean booleanValue;
        SharedPreferences.Editor edit = mo56532e().edit();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("et_device_id_cache", String.class);
        arrayMap.put("et_manufacturer_cache", String.class);
        arrayMap.put("et_model_cache", String.class);
        arrayMap.put("et_platform_cache", String.class);
        arrayMap.put("et_platform_version_cache", String.class);
        arrayMap.put("previousRegistrationHash", String.class);
        arrayMap.put("et_android_version", String.class);
        arrayMap.put("et_customer_manifest_requires_verification", Boolean.class);
        arrayMap.put("et_geo_enabled_key", Boolean.class);
        arrayMap.put("et_proximity_enabled_key", Boolean.class);
        arrayMap.put("et_proximity_invalidated_key", Boolean.class);
        arrayMap.put("et_push_enabled", Boolean.class);
        arrayMap.put("time_went_in_background", Long.class);
        arrayMap.put("pause_time_key", Long.class);
        arrayMap.put("et_background_time_cache", Long.class);
        arrayMap.put("et_registration_alarm_created_date", Long.class);
        arrayMap.put("et_registration_next_alarm_interval", Long.class);
        arrayMap.put("et_register_for_remote_notifications_alarm_created_date", Long.class);
        arrayMap.put("et_register_for_remote_notifications_next_alarm_interval", Long.class);
        arrayMap.put("et_wama_alarm_created_date", Long.class);
        arrayMap.put("et_wama_next_alarm_interval", Long.class);
        arrayMap.put("et_etanalytic_alarm_created_date", Long.class);
        arrayMap.put("et_etanalytic_next_alarm_interval", Long.class);
        arrayMap.put("et_fetch_beacon_messages_alarm_created_date", Long.class);
        arrayMap.put("et_fetch_beacon_messages_next_alarm_interval", Long.class);
        arrayMap.put("et_fetch_background_beacon_messages_alarm_created_date", Long.class);
        arrayMap.put("et_fetch_background_beacon_messages_next_alarm_interval", Long.class);
        arrayMap.put("et_fetch_fence_messages_alarm_created_date", Long.class);
        arrayMap.put("et_fetch_fence_messages_next_alarm_interval", Long.class);
        arrayMap.put("et_fetch_background_fence_messages_alarm_created_date", Long.class);
        arrayMap.put("et_fetch_background_fence_messages_next_alarm_interval", Long.class);
        arrayMap.put("et_fetch_cloud_messages_alarm_created_date", Long.class);
        arrayMap.put("et_fetch_cloud_messages_next_alarm_interval", Long.class);
        arrayMap.put("et_force_registration_alarm_created_date", Long.class);
        arrayMap.put("et_force_registration_next_alarm_interval", Long.class);
        arrayMap.put("et_cp_route_retry_after_time_in_millis", Long.class);
        arrayMap.put("et_geofence_route_retry_after_time_in_millis", Long.class);
        arrayMap.put("et_proximity_route_retry_after_time_in_millis", Long.class);
        arrayMap.put("gcm_app_version_key", Integer.class);
        arrayMap.put("et_notification_id_key", Integer.class);
        arrayMap.put("et_notification_request_code_key", Integer.class);
        for (Map.Entry entry : arrayMap.entrySet()) {
            String str = (String) entry.getKey();
            Type type = (Type) entry.getValue();
            C4039h.m2823c(f2887b, "Migrating %s ...", str);
            try {
                Object a = m2663a(aVar, str, type);
                if (a != null) {
                    if (type == Boolean.class) {
                        if (a instanceof Boolean) {
                            booleanValue = ((Boolean) a).booleanValue();
                        } else if (a instanceof String) {
                            booleanValue = Boolean.valueOf((String) a).booleanValue();
                        }
                        edit.putBoolean(str, booleanValue);
                    } else if (type == Integer.class) {
                        if (a instanceof Integer) {
                            intValue = ((Integer) a).intValue();
                        } else if (a instanceof String) {
                            intValue = Integer.valueOf((String) a).intValue();
                        }
                        edit.putInt(str, intValue);
                    } else if (type == Long.class) {
                        if (a instanceof Long) {
                            longValue = ((Long) a).longValue();
                        } else if (a instanceof String) {
                            longValue = Long.valueOf((String) a).longValue();
                        }
                        edit.putLong(str, longValue);
                    } else if (type != String.class) {
                        C4039h.m2823c(f2887b, "Key '%s' with value of '%s' was not written to preferences.", str, a);
                    } else if (a instanceof String) {
                        if (!"null".equals(a)) {
                            edit.putString(str, (String) a);
                        } else {
                            C4039h.m2823c(f2887b, "Value was \"null\" and will not be migrated.", new Object[0]);
                        }
                    }
                    m2666a(str);
                }
                C4039h.m2823c(f2887b, "Done with %s.", str);
            } catch (Exception e) {
                C4039h.m2830e(f2887b, e, "Unable to migrate %s", str);
            }
        }
        edit.apply();
    }

    @NonNull
    /* renamed from: f */
    private String mo56534f() {
        return C4029h.m2775b(Settings.Secure.getString(mo56528b().getContentResolver(), C4820b.f5526f) + "-" + mo56528b().getPackageName());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public abstract C4022a mo56524a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo56525a(Context context, int i, int i2) {
        String[] databaseList;
        if (i == -1 && (databaseList = context.databaseList()) != null) {
            for (String equals : databaseList) {
                if (C3964a.f2605a.equals(equals)) {
                    m2665a(context, this.f2891f, this.f2892g);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo56526a(@NonNull C4022a aVar) {
        C4039h.m2823c(f2887b, "Migrating SharedPreferences ...", new Object[0]);
        m2667b(aVar);
        m2668c(aVar);
        C4039h.m2823c(f2887b, "Finished migrating SharedPreferences.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo56527a(Context context, C4022a aVar) {
        SQLiteDatabase readableDatabase = new C3964a(context, aVar).getReadableDatabase();
        SQLiteDatabase writableDatabase = mo56530c().getWritableDatabase();
        writableDatabase.beginTransaction();
        boolean z = false;
        try {
            new C3962a(writableDatabase).mo56449a(aVar, mo56524a(), readableDatabase);
            new C3996f(writableDatabase).mo56449a(aVar, mo56524a(), readableDatabase);
            writableDatabase.setTransactionSuccessful();
            z = true;
        } catch (Exception e) {
            C4039h.m2830e(f2887b, e, "Failed to migrate old database", new Object[0]);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
        writableDatabase.endTransaction();
        readableDatabase.close();
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Context mo56528b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo56529b(Context context, int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract SQLiteOpenHelper mo56530c();

    /* renamed from: d */
    public abstract C4007c mo56531d();

    /* renamed from: e */
    public abstract SharedPreferences mo56532e();
}
