package com.salesforce.marketingcloud.location;

import com.salesforce.marketingcloud.MCKeep;

/* renamed from: com.salesforce.marketingcloud.location.$AutoValue_LatLon  reason: invalid class name */
abstract class C$AutoValue_LatLon extends LatLon {

    /* renamed from: a */
    private final double f2956a;

    /* renamed from: b */
    private final double f2957b;

    C$AutoValue_LatLon(double d, double d2) {
        this.f2956a = d;
        this.f2957b = d2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LatLon)) {
            return false;
        }
        LatLon latLon = (LatLon) obj;
        return Double.doubleToLongBits(this.f2956a) == Double.doubleToLongBits(latLon.latitude()) && Double.doubleToLongBits(this.f2957b) == Double.doubleToLongBits(latLon.longitude());
    }

    public int hashCode() {
        return ((int) ((Double.doubleToLongBits(this.f2957b) >>> 32) ^ Double.doubleToLongBits(this.f2957b))) ^ ((((int) ((Double.doubleToLongBits(this.f2956a) >>> 32) ^ Double.doubleToLongBits(this.f2956a))) ^ 1000003) * 1000003);
    }

    @MCKeep
    public double latitude() {
        return this.f2956a;
    }

    @MCKeep
    public double longitude() {
        return this.f2957b;
    }

    public String toString() {
        return "LatLon{latitude=" + this.f2956a + ", longitude=" + this.f2957b + "}";
    }
}
