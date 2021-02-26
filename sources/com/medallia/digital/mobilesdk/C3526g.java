package com.medallia.digital.mobilesdk;

import androidx.annotation.NonNull;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.C3815z4;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.g */
class C3526g {

    /* renamed from: b */
    private static final String f1143b = "md_";

    /* renamed from: c */
    private static final String f1144c = "md_android_";

    /* renamed from: a */
    private C3473d f1145a;

    C3526g() {
    }

    @NonNull
    /* renamed from: a */
    private String m788a(JSONObject jSONObject, String str) {
        try {
            return (!str.contains(f1143b) || jSONObject == null || !jSONObject.has("addOsType") || jSONObject.get("addOsType") == null || !(jSONObject.get("addOsType") instanceof Boolean) || !jSONObject.getBoolean("addOsType")) ? str : str.replace(f1143b, f1144c);
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
            return str;
        }
    }

    /* renamed from: a */
    private JSONObject m789a(JSONObject jSONObject, C3613m1 m1Var, GroupType groupType) {
        Object a;
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject(this.f1145a.mo55292a().toString());
            JSONObject jSONObject4 = new JSONObject(this.f1145a.mo55294c().toString());
            long currentTimeMillis = System.currentTimeMillis();
            while (jSONObject3.keys().hasNext()) {
                String next = jSONObject3.keys().next();
                String string = jSONObject3.getString(next);
                jSONObject3.remove(next);
                String a2 = m788a(jSONObject4, next);
                char c = 65535;
                switch (string.hashCode()) {
                    case -1482972583:
                        if (string.equals("groupType")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -765692853:
                        if (string.equals("valueType")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3373707:
                        if (string.equals("name")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 31228997:
                        if (string.equals("eventName")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 55126294:
                        if (string.equals("timestamp")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 111972721:
                        if (string.equals("value")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 130957936:
                        if (string.equals("globalEnvironment")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 607796817:
                        if (string.equals("sessionId")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 607796829:
                        if (string.equals("sessionIp")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1109191185:
                        if (string.equals(Constants.DEVICEID_HEADER)) {
                            c = 6;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        a = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, "");
                        break;
                    case 1:
                        a = m1Var.mo55557a();
                        break;
                    case 2:
                        jSONObject2.put(a2, jSONObject);
                        if (jSONObject != null) {
                            JSONObject a3 = m790a(jSONObject4, jSONObject);
                            if (a3 != null) {
                                while (a3.keys().hasNext()) {
                                    String next2 = a3.keys().next();
                                    jSONObject2.put(next2, a3.get(next2));
                                    a3.remove(next2);
                                }
                                break;
                            } else {
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 3:
                        a = ValueType.TypeString;
                        break;
                    case 4:
                        jSONObject2.put(a2, currentTimeMillis);
                        continue;
                    case 5:
                        jSONObject2.put(a2, groupType);
                        continue;
                    case 6:
                        a = C3815z4.m2010d().mo55975a(C3815z4.C3816a.DEVICE_ID, (String) null);
                        break;
                    case 7:
                    case 8:
                    case 9:
                        if (jSONObject4.getString(string) != null) {
                            a = jSONObject4.getString(string);
                            break;
                        } else {
                            C3490e3.m666f("Analytics V2 parsing error externalDataJson key is null");
                            jSONObject2.put(a2, "");
                            continue;
                        }
                }
                jSONObject2.put(a2, a);
            }
            if (m1Var.mo55558b() != null && !m1Var.mo55558b().isEmpty()) {
                Iterator<String> it = m1Var.mo55558b().iterator();
                while (it.hasNext()) {
                    String next3 = it.next();
                    if (this.f1145a.mo55295d().has(next3) && this.f1145a.mo55295d().get(next3) != null) {
                        JSONObject jSONObject5 = new JSONObject(this.f1145a.mo55295d().getJSONObject(next3).toString());
                        while (jSONObject5.keys().hasNext()) {
                            String next4 = jSONObject5.keys().next();
                            jSONObject2.put(m788a(jSONObject4, jSONObject5.getString(next4)), CollectorsInfrastructure.getInstance().getByName(next4));
                            jSONObject5.remove(next4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        return jSONObject2;
    }

    /* renamed from: a */
    private JSONObject m790a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        StringBuilder sb;
        if (jSONObject2 == null) {
            return null;
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.contains(f1143b)) {
                str = m788a(jSONObject, next);
            } else {
                if (jSONObject != null) {
                    try {
                        if (jSONObject.has("addOsType") && jSONObject.get("addOsType") != null && (jSONObject.get("addOsType") instanceof Boolean) && jSONObject.getBoolean("addOsType")) {
                            sb = new StringBuilder();
                            sb.append(f1144c);
                            sb.append(next);
                            str = sb.toString();
                        }
                    } catch (JSONException e) {
                        C3490e3.m663c(e.getMessage());
                        str = "";
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f1143b);
                sb2.append(next);
                sb = sb2;
                str = sb.toString();
            }
            try {
                jSONObject3.put(str, jSONObject2.get(next));
            } catch (JSONException e2) {
                C3490e3.m663c(e2.getMessage());
            }
        }
        return jSONObject3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public C3485e mo55384A(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55615E() == null || !this.f1145a.mo55293b().mo55615E().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55615E().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55615E(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public C3485e mo55385B(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55616F() == null || !this.f1145a.mo55293b().mo55616F().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55616F().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55616F(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public C3485e mo55386C(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55617G() == null || !this.f1145a.mo55293b().mo55617G().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55617G().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55617G(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public C3485e mo55387D(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55618H() == null || !this.f1145a.mo55293b().mo55618H().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55618H().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55618H(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public C3485e mo55388E(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55619I() == null || !this.f1145a.mo55293b().mo55619I().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55619I().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55619I(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public C3485e mo55389F(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55620J() == null || !this.f1145a.mo55293b().mo55620J().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55620J().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55620J(), GroupType.callback), GroupType.callback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public C3485e mo55390G(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55622L() == null || !this.f1145a.mo55293b().mo55622L().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55622L().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55622L(), GroupType.callback), GroupType.callback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public C3485e mo55391H(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55623M() == null || !this.f1145a.mo55293b().mo55623M().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55623M().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55623M(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public C3485e mo55392I(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55624N() == null || !this.f1145a.mo55293b().mo55624N().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55624N().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55624N(), GroupType.callback), GroupType.callback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public C3485e mo55393J(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55628R() == null || !this.f1145a.mo55293b().mo55628R().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55628R().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55628R(), GroupType.callback), GroupType.callback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public C3485e mo55394K(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55627Q() == null || !this.f1145a.mo55293b().mo55627Q().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55627Q().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55627Q(), GroupType.api), GroupType.api, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public C3485e mo55395L(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55629S() == null || !this.f1145a.mo55293b().mo55629S().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55629S().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55629S(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public C3485e mo55396M(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55630T() == null || !this.f1145a.mo55293b().mo55630T().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55630T().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55630T(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: N */
    public C3485e mo55397N(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55631U() == null || !this.f1145a.mo55293b().mo55631U().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55631U().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55631U(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3485e mo55398a() {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55634b() == null || !this.f1145a.mo55293b().mo55634b().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55634b().mo55557a(), m789a((JSONObject) null, this.f1145a.mo55293b().mo55634b(), GroupType.feedback), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3485e mo55399a(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55633a() == null || !this.f1145a.mo55293b().mo55633a().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55633a().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55633a(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3485e mo55400a(JSONObject jSONObject, String str, long j) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55654v() == null || !this.f1145a.mo55293b().mo55654v().mo55559c()) {
            return null;
        }
        return new C3485e(m789a(jSONObject, this.f1145a.mo55293b().mo55654v(), GroupType.error), GroupType.error, Lifetime.Session, this.f1145a.mo55293b().mo55654v().mo55557a(), str, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55401a(C3473d dVar) {
        this.f1145a = dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3485e mo55402b() {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55635c() == null || !this.f1145a.mo55293b().mo55635c().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55635c().mo55557a(), m789a((JSONObject) null, this.f1145a.mo55293b().mo55635c(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3485e mo55403b(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55636d() == null || !this.f1145a.mo55293b().mo55636d().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55636d().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55636d(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C3485e mo55404c() {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55644l() == null || !this.f1145a.mo55293b().mo55644l().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55644l().mo55557a(), m789a((JSONObject) null, this.f1145a.mo55293b().mo55644l(), GroupType.api), GroupType.api, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C3485e mo55405c(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55637e() == null || !this.f1145a.mo55293b().mo55637e().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55637e().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55637e(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C3485e mo55406d() {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55621K() == null || !this.f1145a.mo55293b().mo55621K().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55621K().mo55557a(), m789a((JSONObject) null, this.f1145a.mo55293b().mo55621K(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C3485e mo55407d(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55638f() == null || !this.f1145a.mo55293b().mo55638f().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55638f().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55638f(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C3485e mo55408e() {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55625O() == null || !this.f1145a.mo55293b().mo55625O().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55625O().mo55557a(), m789a((JSONObject) null, this.f1145a.mo55293b().mo55625O(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C3485e mo55409e(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55639g() == null || !this.f1145a.mo55293b().mo55639g().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55639g().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55639g(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C3485e mo55410f() {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55626P() == null || !this.f1145a.mo55293b().mo55626P().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55626P().mo55557a(), m789a((JSONObject) null, this.f1145a.mo55293b().mo55626P(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C3485e mo55411f(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55640h() == null || !this.f1145a.mo55293b().mo55640h().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55640h().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55640h(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C3485e mo55412g(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55641i() == null || !this.f1145a.mo55293b().mo55641i().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55641i().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55641i(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C3485e mo55413h(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55642j() == null || !this.f1145a.mo55293b().mo55642j().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55642j().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55642j(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C3485e mo55414i(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55643k() == null || !this.f1145a.mo55293b().mo55643k().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55643k().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55643k(), GroupType.api), GroupType.api, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C3485e mo55415j(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55645m() == null || !this.f1145a.mo55293b().mo55645m().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55645m().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55645m(), GroupType.callback), GroupType.callback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public C3485e mo55416k(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55646n() == null || !this.f1145a.mo55293b().mo55646n().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55646n().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55646n(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public C3485e mo55417l(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55647o() == null || !this.f1145a.mo55293b().mo55647o().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55647o().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55647o(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public C3485e mo55418m(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55648p() == null || !this.f1145a.mo55293b().mo55648p().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55648p().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55648p(), GroupType.error), GroupType.error, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public C3485e mo55419n(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55649q() == null || !this.f1145a.mo55293b().mo55649q().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55649q().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55649q(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public C3485e mo55420o(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55650r() == null || !this.f1145a.mo55293b().mo55650r().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55650r().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55650r(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public C3485e mo55421p(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55651s() == null || !this.f1145a.mo55293b().mo55651s().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55651s().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55651s(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public C3485e mo55422q(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55652t() == null || !this.f1145a.mo55293b().mo55652t().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55652t().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55652t(), GroupType.feedback), GroupType.feedback, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public C3485e mo55423r(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55653u() == null || !this.f1145a.mo55293b().mo55653u().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55653u().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55653u(), GroupType.api), GroupType.api, Lifetime.Application);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public C3485e mo55424s(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55655w() == null || !this.f1145a.mo55293b().mo55655w().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55655w().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55655w(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public C3485e mo55425t(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55656x() == null || !this.f1145a.mo55293b().mo55656x().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55656x().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55656x(), GroupType.appRating), GroupType.appRating, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public C3485e mo55426u(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55657y() == null || !this.f1145a.mo55293b().mo55657y().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55657y().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55657y(), GroupType.appRating), GroupType.appRating, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public C3485e mo55427v(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55658z() == null || !this.f1145a.mo55293b().mo55658z().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55658z().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55658z(), GroupType.appRating), GroupType.appRating, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public C3485e mo55428w(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55611A() == null || !this.f1145a.mo55293b().mo55611A().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55611A().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55611A(), GroupType.appRating), GroupType.appRating, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public C3485e mo55429x(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55612B() == null || !this.f1145a.mo55293b().mo55612B().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55612B().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55612B(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public C3485e mo55430y(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55613C() == null || !this.f1145a.mo55293b().mo55613C().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55613C().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55613C(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public C3485e mo55431z(JSONObject jSONObject) {
        C3473d dVar = this.f1145a;
        if (dVar == null || dVar.mo55293b() == null || this.f1145a.mo55293b().mo55614D() == null || !this.f1145a.mo55293b().mo55614D().mo55559c()) {
            return null;
        }
        return new C3485e(this.f1145a.mo55293b().mo55614D().mo55557a(), m789a(jSONObject, this.f1145a.mo55293b().mo55614D(), GroupType.internalSdk), GroupType.internalSdk, Lifetime.Session);
    }
}
