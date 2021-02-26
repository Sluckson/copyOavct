package com.medallia.digital.mobilesdk;

import java.util.Observable;

/* renamed from: com.medallia.digital.mobilesdk.l0 */
abstract class C3602l0<T> extends Observable {

    /* renamed from: a */
    private boolean f1400a;

    /* renamed from: b */
    private C3612m0 f1401b;

    /* renamed from: c */
    private String f1402c;

    /* renamed from: d */
    private Lifetime f1403d;

    /* renamed from: e */
    private T f1404e;

    protected C3602l0(C3612m0 m0Var) {
        this.f1401b = m0Var;
        if (m0Var != null) {
            this.f1402c = m0Var.getName();
            this.f1403d = m0Var.getLifetime();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3612m0 mo55523a() {
        if (this.f1401b == null) {
            this.f1401b = C3612m0.Unknown;
        }
        return this.f1401b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55524a(Lifetime lifetime) {
        this.f1403d = lifetime;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55525a(T t) {
        if (t != null) {
            this.f1404e = t;
            setChanged();
            notifyObservers(mo55531i());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55338a(boolean z) {
        this.f1400a = z;
    }

    /* renamed from: b */
    public String mo55526b() {
        return getClass().getSimpleName().replace("Collector", "");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract CollectorContract mo55204c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Lifetime mo55527d() {
        return this.f1403d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo55528e() {
        return this.f1402c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public T mo55504f() {
        return this.f1404e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public ValueType mo55529g() {
        T t = this.f1404e;
        return t == null ? ValueType.TypeString : t instanceof Integer ? ValueType.TypeInteger : t instanceof Double ? ValueType.TypeDouble : t instanceof Long ? ValueType.TypeLong : t instanceof Boolean ? ValueType.TypeBoolean : ValueType.TypeString;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo55530h() {
        return this.f1400a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C3803z mo55531i() {
        T t = this.f1404e;
        return new C3803z(t == null ? null : t.toString(), GroupType.collector, mo55527d(), mo55529g(), mo55528e());
    }
}
