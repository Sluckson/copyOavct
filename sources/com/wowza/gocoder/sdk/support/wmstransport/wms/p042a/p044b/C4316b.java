package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b;

import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.b.b */
/* compiled from: GoCoderSDK */
public class C4316b {

    /* renamed from: a */
    public byte[] f4502a = null;

    /* renamed from: b */
    public List<byte[]> f4503b = null;

    /* renamed from: c */
    public byte[] f4504c = null;

    /* renamed from: a */
    public void mo59314a(byte[] bArr) {
        if (this.f4503b == null) {
            this.f4503b = new ArrayList();
        }
        this.f4503b.add(bArr);
    }

    /* renamed from: a */
    public String mo59313a() {
        byte[] bArr = this.f4504c;
        return bArr != null ? C4307c.m4268a(bArr) : "";
    }

    /* renamed from: b */
    public String mo59315b() {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = this.f4502a;
        if (bArr != null) {
            stringBuffer.append(C4303a.m4223a(bArr, 8));
        }
        List<byte[]> list = this.f4503b;
        if (list != null) {
            for (byte[] next : list) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(C4303a.m4223a(next, 8));
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return mo59315b();
    }
}
