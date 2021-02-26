package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.lowagie.text.pdf.PdfBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomParameter implements Comparable {

    /* renamed from: d */
    private static final int f837d = 89;

    /* renamed from: a */
    private String f838a;

    /* renamed from: b */
    private Object f839b;

    /* renamed from: c */
    private CustomParameterType f840c;

    public enum CustomParameterType {
        TypeString,
        TypeInteger,
        TypeLong,
        TypeDouble,
        TypeFloat,
        TypeBoolean;

        protected static CustomParameterType fromString(String str) {
            if (TypeString.name().equals(str)) {
                return TypeString;
            }
            if (TypeInteger.name().equals(str)) {
                return TypeInteger;
            }
            if (TypeLong.name().equals(str)) {
                return TypeLong;
            }
            if (TypeDouble.name().equals(str)) {
                return TypeDouble;
            }
            if (TypeFloat.name().equals(str)) {
                return TypeFloat;
            }
            if (TypeBoolean.name().equals(str)) {
                return TypeBoolean;
            }
            return null;
        }

        protected static CustomParameterType parseType(Object obj) {
            if (obj instanceof String) {
                return TypeString;
            }
            if (obj instanceof Integer) {
                return TypeInteger;
            }
            if (obj instanceof Long) {
                return TypeLong;
            }
            if (obj instanceof Double) {
                return TypeDouble;
            }
            if (obj instanceof Float) {
                return TypeFloat;
            }
            if (obj instanceof Boolean) {
                return TypeBoolean;
            }
            return null;
        }

        public Object validateValueFromType(Object obj) {
            if (this == TypeString) {
                return obj.toString();
            }
            if (this == TypeInteger) {
                return Integer.valueOf((int) Double.valueOf(String.valueOf(obj)).longValue());
            }
            if (this == TypeLong) {
                return Long.valueOf(Double.valueOf(String.valueOf(obj)).longValue());
            }
            if (this == TypeDouble) {
                return Double.valueOf(String.valueOf(obj));
            }
            if (this == TypeFloat) {
                return Float.valueOf(String.valueOf(obj));
            }
            if (this != TypeBoolean) {
                return null;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.toLowerCase().equals("true") || valueOf.toLowerCase().equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                return true;
            }
            return (valueOf.toLowerCase().equals(PdfBoolean.FALSE) || valueOf.toLowerCase().equals("0")) ? false : null;
        }
    }

    public CustomParameter() {
    }

    public CustomParameter(JSONObject jSONObject) {
        try {
            if (jSONObject.has("name") && !jSONObject.isNull("name")) {
                this.f838a = jSONObject.getString("name");
            }
            if (jSONObject.has("customParameterType") && !jSONObject.isNull("customParameterType")) {
                this.f840c = CustomParameterType.fromString(jSONObject.getString("customParameterType"));
            }
            if (jSONObject.has("value") && !jSONObject.isNull("value")) {
                this.f839b = jSONObject.get("value");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomParameterType mo54990a() {
        return this.f840c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo54991a(Object obj) {
        CustomParameterType parseType;
        if (obj == null || (parseType = CustomParameterType.parseType(obj)) == null) {
            return false;
        }
        this.f840c = parseType;
        this.f839b = obj;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo54992a(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return false;
        }
        this.f838a = str;
        return true;
    }

    /* renamed from: b */
    public String mo54993b() {
        return this.f838a;
    }

    /* renamed from: c */
    public Object mo54994c() {
        return this.f839b;
    }

    public int compareTo(@NonNull Object obj) {
        if (!(obj instanceof CustomParameter)) {
            return 1;
        }
        CustomParameter customParameter = (CustomParameter) obj;
        String str = this.f838a;
        if (str == null) {
            return -1;
        }
        String str2 = customParameter.f838a;
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public JSONObject mo54996d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", C3770w2.m1827a((Object) this.f838a));
            jSONObject.put("customParameterType", C3770w2.m1827a((Object) this.f840c));
            jSONObject.put("value", C3770w2.m1827a(this.f839b));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo54997e() {
        return "Name: " + this.f838a + " Value: " + this.f839b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = r5.f838a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.medallia.digital.mobilesdk.CustomParameter
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.medallia.digital.mobilesdk.CustomParameter r5 = (com.medallia.digital.mobilesdk.CustomParameter) r5
            java.lang.String r0 = r4.f838a
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.String r2 = r5.f838a
            if (r2 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.lang.Object r3 = r4.f839b
            if (r3 != 0) goto L_0x0017
            return r1
        L_0x0017:
            java.lang.Object r3 = r5.f839b
            if (r3 == 0) goto L_0x002c
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r4.f839b
            java.lang.Object r5 = r5.f839b
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x002c
            r1 = 1
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.CustomParameter.equals(java.lang.Object):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public CustomParameter mo54999f() {
        this.f839b = this.f840c.validateValueFromType(this.f839b);
        return this;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 89;
        String str = this.f838a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 89;
        Object obj = this.f839b;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Name: " + this.f838a + " Value: " + this.f839b;
    }
}
