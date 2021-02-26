package com.salesforce.marketingcloud.location;

/* renamed from: com.salesforce.marketingcloud.location.a */
final class C4044a extends C4047d {

    /* renamed from: d */
    private final String f2962d;

    /* renamed from: e */
    private final float f2963e;

    /* renamed from: f */
    private final double f2964f;

    /* renamed from: g */
    private final double f2965g;

    /* renamed from: h */
    private final int f2966h;

    C4044a(String str, float f, double d, double d2, int i) {
        if (str != null) {
            this.f2962d = str;
            this.f2963e = f;
            this.f2964f = d;
            this.f2965g = d2;
            this.f2966h = i;
            return;
        }
        throw new NullPointerException("Null id");
    }

    /* renamed from: a */
    public String mo56563a() {
        return this.f2962d;
    }

    /* renamed from: b */
    public float mo56564b() {
        return this.f2963e;
    }

    /* renamed from: c */
    public double mo56565c() {
        return this.f2964f;
    }

    /* renamed from: d */
    public double mo56566d() {
        return this.f2965g;
    }

    /* renamed from: e */
    public int mo56567e() {
        return this.f2966h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4047d)) {
            return false;
        }
        C4047d dVar = (C4047d) obj;
        return this.f2962d.equals(dVar.mo56563a()) && Float.floatToIntBits(this.f2963e) == Float.floatToIntBits(dVar.mo56564b()) && Double.doubleToLongBits(this.f2964f) == Double.doubleToLongBits(dVar.mo56565c()) && Double.doubleToLongBits(this.f2965g) == Double.doubleToLongBits(dVar.mo56566d()) && this.f2966h == dVar.mo56567e();
    }

    public int hashCode() {
        return ((((((((this.f2962d.hashCode() ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.f2963e)) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2964f) >>> 32) ^ Double.doubleToLongBits(this.f2964f)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2965g) >>> 32) ^ Double.doubleToLongBits(this.f2965g)))) * 1000003) ^ this.f2966h;
    }

    public String toString() {
        return "GeofenceRegion{id=" + this.f2962d + ", radius=" + this.f2963e + ", latitude=" + this.f2964f + ", longitude=" + this.f2965g + ", transitionTypes=" + this.f2966h + "}";
    }
}
