package com.wowza.gocoder.sdk.api.geometry;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: GoCoderSDK */
public class WOWZCropDimensions {

    /* renamed from: a */
    private WOWZSize f3726a;

    /* renamed from: b */
    private WOWZSize f3727b;

    /* renamed from: c */
    private int f3728c;

    /* renamed from: d */
    private WOWZSize f3729d;

    /* renamed from: e */
    private float f3730e;

    /* renamed from: f */
    private float f3731f;

    /* renamed from: g */
    private WOWZPoint f3732g;

    /* renamed from: h */
    private WOWZPoint f3733h;

    public WOWZCropDimensions(WOWZSize wOWZSize, WOWZSize wOWZSize2, int i) {
        this.f3727b = new WOWZSize(wOWZSize);
        this.f3726a = new WOWZSize(wOWZSize2);
        this.f3728c = i;
        this.f3732g = new WOWZPoint();
        this.f3729d = new WOWZSize();
        m3614a();
    }

    public WOWZCropDimensions(WOWZCropDimensions wOWZCropDimensions) {
        this();
        set(wOWZCropDimensions);
    }

    public WOWZCropDimensions() {
        this(new WOWZSize(0, 0), new WOWZSize(0, 0), 2);
    }

    public WOWZCropDimensions(WOWZSize wOWZSize, WOWZSize wOWZSize2) {
        this(wOWZSize, wOWZSize2, 2);
    }

    public void set(WOWZCropDimensions wOWZCropDimensions) {
        this.f3728c = wOWZCropDimensions.f3728c;
        this.f3726a.set(wOWZCropDimensions.f3726a);
        this.f3727b.set(wOWZCropDimensions.f3727b);
        m3614a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WOWZCropDimensions)) {
            return false;
        }
        WOWZCropDimensions wOWZCropDimensions = (WOWZCropDimensions) obj;
        if (this.f3728c != wOWZCropDimensions.f3728c || !this.f3727b.equals(wOWZCropDimensions.f3727b) || !this.f3726a.equals(wOWZCropDimensions.f3726a)) {
            return false;
        }
        return true;
    }

    public void setSrcSize(WOWZSize wOWZSize) {
        this.f3727b.set(wOWZSize);
        m3614a();
    }

    public WOWZSize getSrcSize() {
        return this.f3727b;
    }

    public void setDestSize(WOWZSize wOWZSize) {
        this.f3726a.set(wOWZSize);
        m3614a();
    }

    public WOWZSize getDestSize() {
        return this.f3726a;
    }

    public void setScaleMode(int i) {
        this.f3728c = i;
        m3614a();
    }

    public int getScaleMode() {
        return this.f3728c;
    }

    public WOWZPoint getOffset() {
        return this.f3732g;
    }

    public WOWZSize getScaledSize() {
        return this.f3729d;
    }

    public float getScaleX() {
        return this.f3730e;
    }

    public float getScaleY() {
        return this.f3731f;
    }

    public WOWZPoint getCenterPoint() {
        return this.f3733h;
    }

    /* renamed from: a */
    private void m3614a() {
        this.f3733h = this.f3726a.center();
        if (this.f3727b.area() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.f3726a.area() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.f3730e = 1.0f;
            this.f3731f = 1.0f;
            this.f3732g.set(0, 0);
            this.f3729d.set(this.f3727b);
            return;
        }
        int i = this.f3728c;
        if (i == 1) {
            m3615b();
        } else if (i == 2) {
            m3616c();
        }
        this.f3730e = ((float) this.f3729d.width) / ((float) this.f3727b.width);
        this.f3731f = ((float) this.f3729d.height) / ((float) this.f3727b.height);
        WOWZSize offsetFrom = this.f3729d.offsetFrom(this.f3726a);
        this.f3732g.set(offsetFrom.width, offsetFrom.height);
    }

    /* renamed from: b */
    private void m3615b() {
        this.f3729d.set(this.f3726a);
        if (this.f3727b.aspectRatio() < this.f3726a.aspectRatio()) {
            WOWZSize wOWZSize = this.f3729d;
            wOWZSize.width = Math.round(((float) wOWZSize.height) * this.f3727b.aspectRatio());
        } else if (this.f3727b.aspectRatio() > this.f3726a.aspectRatio()) {
            WOWZSize wOWZSize2 = this.f3729d;
            wOWZSize2.height = Math.round(((float) wOWZSize2.width) * (1.0f / this.f3727b.aspectRatio()));
        }
    }

    /* renamed from: c */
    private void m3616c() {
        this.f3729d.set(this.f3726a);
        if (this.f3727b.aspectRatio() > this.f3726a.aspectRatio()) {
            WOWZSize wOWZSize = this.f3729d;
            wOWZSize.width = Math.round(((float) wOWZSize.height) * this.f3727b.aspectRatio());
        } else if (this.f3727b.aspectRatio() < this.f3726a.aspectRatio()) {
            WOWZSize wOWZSize2 = this.f3729d;
            wOWZSize2.height = Math.round(((float) wOWZSize2.width) * (1.0f / this.f3727b.aspectRatio()));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("scaleMode       : ");
        sb.append(this.f3728c == 1 ? "RESIZE_TO_ASPECT" : "FILL_VIEW");
        sb.append("\ndestSize        : ");
        sb.append(this.f3726a.toString());
        sb.append(" (");
        sb.append(this.f3726a.aspectRatioLabel());
        sb.append(")\nsrcSize         : ");
        sb.append(this.f3727b.toString());
        sb.append(" (");
        sb.append(this.f3727b.aspectRatioLabel());
        sb.append(")\nscaledSrcSize   : ");
        sb.append(this.f3729d.toString());
        sb.append(" (");
        sb.append(this.f3729d.aspectRatioLabel());
        sb.append(")\nscaleAxis       : (x:");
        sb.append(this.f3730e);
        sb.append(", y:");
        sb.append(this.f3731f);
        sb.append(")\noffset          : ");
        sb.append(this.f3732g.toString());
        sb.append("\ncenterPoint     : ");
        sb.append(this.f3733h.toString());
        return sb.toString();
    }
}
