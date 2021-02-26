package com.medallia.digital.mobilesdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.z4 */
class C3815z4<T> implements C3713r5 {

    /* renamed from: a */
    private static final String f2098a = "com.medallia.digital.sharedpreference.SHARED_PREFS_KEY";

    /* renamed from: b */
    private static C3815z4 f2099b;

    /* renamed from: c */
    private static SharedPreferences f2100c;

    /* renamed from: com.medallia.digital.mobilesdk.z4$a */
    protected enum C3816a {
        API_TOKEN,
        ACCESS_TOKEN,
        SESSION_ID,
        PROPERTY_ID,
        SESSION_COUNTER,
        PREVIOUS_SESSION_ID,
        DEVICE_ID,
        CUSTOM_PARAMETERS,
        TARGET_ENGINE,
        UUID,
        LOCAL_CONFIGURATION_TIMESTAMP,
        UUID_URL,
        LENNY,
        NALA,
        LAST_SDK_VERSION,
        LAST_OS_VERSION,
        SDK_KILL_TIMESTAMP,
        SDK_RECOVER_TIMESTAMP,
        IS_SDK_KILLED,
        SHOULD_CHECK_OS,
        SDK_STOPPED,
        MISSING_EVENTS,
        MISSING_EVENTS_V2,
        PREVIOUS_ANALYTICS_V2,
        PREVIOUS_SEND_USER_JOURNEY,
        IS_BLACKBOX_ENABLED
    }

    private C3815z4() {
        if (C3595k3.m1060d().mo55513b() != null) {
            f2100c = C3595k3.m1060d().mo55513b().getSharedPreferences(f2098a, 0);
        }
    }

    /* renamed from: a */
    private boolean m2009a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (jSONObject2 != null) {
            try {
                return !jSONObject.isNull(str) && jSONObject.getString(str).equals(jSONObject2.getString(str));
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return false;
    }

    /* renamed from: d */
    protected static C3815z4 m2010d() {
        if (f2099b == null || f2100c == null) {
            f2099b = new C3815z4();
        }
        return f2099b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo55973a(C3816a aVar, int i) {
        return mo55986c() ? f2100c.getInt(aVar.toString(), i) : i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo55974a(C3816a aVar, long j) {
        return mo55986c() ? f2100c.getLong(aVar.toString(), j) : j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55975a(C3816a aVar, String str) {
        return mo55986c() ? f2100c.getString(aVar.toString(), str) : str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55976a() {
        if (mo55986c()) {
            f2100c.edit().clear().commit();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55977a(C3816a aVar) {
        if (!mo55986c()) {
            return false;
        }
        f2100c.edit().remove(aVar.toString()).commit();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55978a(C3816a aVar, JSONArray jSONArray) {
        SharedPreferences.Editor putString;
        boolean z;
        if (!mo55986c() || jSONArray == null || jSONArray.length() == 0) {
            return false;
        }
        if (TextUtils.isEmpty(f2100c.getString(aVar.toString(), (String) null))) {
            putString = f2100c.edit().putString(aVar.toString(), jSONArray.toString());
        } else {
            JSONArray b = mo55981b(aVar);
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= b.length()) {
                                z = true;
                                break;
                            }
                            JSONObject jSONObject2 = b.getJSONObject(i2);
                            if (m2009a(jSONObject, jSONObject2, "name") && m2009a(jSONObject, jSONObject2, "customParameterType")) {
                                b.put(i2, jSONObject);
                                z = false;
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            b.put(jSONObject);
                        }
                    }
                    i++;
                } catch (Exception e) {
                    C3490e3.m663c(e.getMessage());
                }
            }
            putString = f2100c.edit().putString(aVar.toString(), b.toString());
        }
        putString.commit();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55979a(C3816a aVar, boolean z) {
        return mo55986c() ? f2100c.getBoolean(aVar.toString(), z) : z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public SharedPreferences mo55980b() {
        return f2100c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONArray mo55981b(C3816a aVar) {
        if (mo55986c() && !TextUtils.isEmpty(f2100c.getString(aVar.toString(), (String) null))) {
            try {
                return new JSONArray(f2100c.getString(aVar.toString(), (String) null));
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55982b(C3816a aVar, int i) {
        if (mo55986c()) {
            f2100c.edit().putInt(aVar.toString(), i).commit();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55983b(C3816a aVar, long j) {
        if (mo55986c()) {
            f2100c.edit().putLong(aVar.toString(), j).commit();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55984b(C3816a aVar, String str) {
        if (mo55986c()) {
            f2100c.edit().putString(aVar.toString(), str).commit();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55985b(C3816a aVar, boolean z) {
        if (mo55986c()) {
            f2100c.edit().putBoolean(aVar.toString(), z).commit();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55986c() {
        return f2100c != null;
    }

    public void clearAndDisconnect() {
        C3490e3.m659a(C3815z4.class.getSimpleName());
        mo55976a();
        f2100c = null;
        f2099b = null;
    }
}
