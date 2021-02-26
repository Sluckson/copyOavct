package com.wowza.gocoder.sdk.support.p038e;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerView;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.api.status.WOWZStatusCallback;
import com.wowza.gocoder.sdk.support.p038e.C4290d;
import com.wowza.gocoder.sdk.support.p040g.C4301b;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4315a;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4316b;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c;
import java.nio.ByteBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.e.e */
/* compiled from: GoCoderSDK */
public class C4296e extends C4290d {

    /* renamed from: V */
    private static final long f4307V = 30;

    /* renamed from: W */
    private static final long f4308W = 500;

    /* renamed from: i */
    public static long f4309i = 30;

    /* renamed from: j */
    private static final String f4310j = "e";

    /* renamed from: X */
    private boolean f4311X;

    /* renamed from: Y */
    private long f4312Y;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo59147b() {
        return "video/avc";
    }

    /* renamed from: A */
    public /* bridge */ /* synthetic */ long mo59107A() {
        return super.mo59107A();
    }

    /* renamed from: B */
    public /* bridge */ /* synthetic */ long mo59108B() {
        return super.mo59108B();
    }

    /* renamed from: C */
    public /* bridge */ /* synthetic */ int mo59109C() {
        return super.mo59109C();
    }

    /* renamed from: D */
    public /* bridge */ /* synthetic */ int mo59110D() {
        return super.mo59110D();
    }

    /* renamed from: E */
    public /* bridge */ /* synthetic */ int mo59111E() {
        return super.mo59111E();
    }

    /* renamed from: F */
    public /* bridge */ /* synthetic */ int mo59112F() {
        return super.mo59112F();
    }

    /* renamed from: G */
    public /* bridge */ /* synthetic */ int mo59113G() {
        return super.mo59113G();
    }

    /* renamed from: H */
    public /* bridge */ /* synthetic */ int mo59114H() {
        return super.mo59114H();
    }

    /* renamed from: I */
    public /* bridge */ /* synthetic */ long mo59115I() {
        return super.mo59115I();
    }

    /* renamed from: J */
    public /* bridge */ /* synthetic */ long mo59116J() {
        return super.mo59116J();
    }

    /* renamed from: K */
    public /* bridge */ /* synthetic */ long mo59117K() {
        return super.mo59117K();
    }

    /* renamed from: L */
    public /* bridge */ /* synthetic */ long mo59118L() {
        return super.mo59118L();
    }

    /* renamed from: M */
    public /* bridge */ /* synthetic */ float mo59119M() {
        return super.mo59119M();
    }

    /* renamed from: N */
    public /* bridge */ /* synthetic */ boolean mo59120N() {
        return super.mo59120N();
    }

    /* renamed from: O */
    public /* bridge */ /* synthetic */ int mo59121O() {
        return super.mo59121O();
    }

    /* renamed from: P */
    public /* bridge */ /* synthetic */ int mo59122P() {
        return super.mo59122P();
    }

    /* renamed from: Q */
    public /* bridge */ /* synthetic */ long mo59123Q() {
        return super.mo59123Q();
    }

    /* renamed from: R */
    public /* bridge */ /* synthetic */ long mo59124R() {
        return super.mo59124R();
    }

    /* renamed from: S */
    public /* bridge */ /* synthetic */ long mo59125S() {
        return super.mo59125S();
    }

    /* renamed from: T */
    public /* bridge */ /* synthetic */ long mo59126T() {
        return super.mo59126T();
    }

    /* renamed from: V */
    public /* bridge */ /* synthetic */ void mo59128V() {
        super.mo59128V();
    }

    /* renamed from: W */
    public /* bridge */ /* synthetic */ void mo59129W() {
        super.mo59129W();
    }

    /* renamed from: X */
    public /* bridge */ /* synthetic */ boolean mo59130X() {
        return super.mo59130X();
    }

    /* renamed from: Y */
    public /* bridge */ /* synthetic */ void mo59131Y() {
        super.mo59131Y();
    }

    /* renamed from: Z */
    public /* bridge */ /* synthetic */ void mo59132Z() {
        super.mo59132Z();
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59139a(int i, long j, byte[] bArr, long j2) {
        super.mo59139a(i, j, bArr, j2);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59141a(long j) {
        super.mo59141a(j);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59178a(Surface surface) {
        super.mo59178a(surface);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59179a(WOWZPlayerView.PacketThresholdChangeListener packetThresholdChangeListener) {
        super.mo59179a(packetThresholdChangeListener);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59142a(WOWZStatusCallback wOWZStatusCallback) {
        super.mo59142a(wOWZStatusCallback);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59143a(C4301b.C4302a aVar) {
        super.mo59143a(aVar);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59180a(String str) {
        super.mo59180a(str);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59181a(boolean z) {
        super.mo59181a(z);
    }

    /* renamed from: aa */
    public /* bridge */ /* synthetic */ void mo59144aa() {
        super.mo59144aa();
    }

    /* renamed from: ab */
    public /* bridge */ /* synthetic */ void mo59145ab() {
        super.mo59145ab();
    }

    /* renamed from: ad */
    public /* bridge */ /* synthetic */ void mo59183ad() {
        super.mo59183ad();
    }

    /* renamed from: ae */
    public /* bridge */ /* synthetic */ void mo59184ae() {
        super.mo59184ae();
    }

    /* renamed from: af */
    public /* bridge */ /* synthetic */ Surface mo59185af() {
        return super.mo59185af();
    }

    /* renamed from: ag */
    public /* bridge */ /* synthetic */ int mo59186ag() {
        return super.mo59186ag();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ WOWZMediaConfig mo59146b(byte[] bArr) {
        return super.mo59146b(bArr);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo59188b(int i) {
        super.mo59188b(i);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo59189c(int i) {
        super.mo59189c(i);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ String mo59149d() {
        return super.mo59149d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ WOWZStatusCallback mo59150e() {
        return super.mo59150e();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ WOWZStatus mo59151f() {
        return super.mo59151f();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ WOWZMediaConfig mo59152g() {
        return super.mo59152g();
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ C4301b.C4302a mo59153h() {
        return super.mo59153h();
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ long mo59154i() {
        return super.mo59154i();
    }

    /* renamed from: j */
    public /* bridge */ /* synthetic */ boolean mo59155j() {
        return super.mo59155j();
    }

    /* renamed from: k */
    public /* bridge */ /* synthetic */ long mo59156k() {
        return super.mo59156k();
    }

    /* renamed from: l */
    public /* bridge */ /* synthetic */ long mo59157l() {
        return super.mo59157l();
    }

    /* renamed from: m */
    public /* bridge */ /* synthetic */ long mo59158m() {
        return super.mo59158m();
    }

    /* renamed from: n */
    public /* bridge */ /* synthetic */ long mo59159n() {
        return super.mo59159n();
    }

    /* renamed from: o */
    public /* bridge */ /* synthetic */ long mo59160o() {
        return super.mo59160o();
    }

    /* renamed from: p */
    public /* bridge */ /* synthetic */ long mo59161p() {
        return super.mo59161p();
    }

    /* renamed from: q */
    public /* bridge */ /* synthetic */ long mo59162q() {
        return super.mo59162q();
    }

    /* renamed from: r */
    public /* bridge */ /* synthetic */ long mo59163r() {
        return super.mo59163r();
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    /* renamed from: s */
    public /* bridge */ /* synthetic */ long mo59165s() {
        return super.mo59165s();
    }

    /* renamed from: t */
    public /* bridge */ /* synthetic */ long mo59166t() {
        return super.mo59166t();
    }

    /* renamed from: u */
    public /* bridge */ /* synthetic */ long mo59167u() {
        return super.mo59167u();
    }

    /* renamed from: v */
    public /* bridge */ /* synthetic */ int mo59168v() {
        return super.mo59168v();
    }

    /* renamed from: w */
    public /* bridge */ /* synthetic */ long mo59169w() {
        return super.mo59169w();
    }

    /* renamed from: x */
    public /* bridge */ /* synthetic */ long mo59170x() {
        return super.mo59170x();
    }

    /* renamed from: y */
    public /* bridge */ /* synthetic */ long mo59171y() {
        return super.mo59171y();
    }

    /* renamed from: z */
    public /* bridge */ /* synthetic */ long mo59172z() {
        return super.mo59172z();
    }

    public C4296e() {
    }

    public C4296e(Surface surface) {
        this.f4280m = surface;
    }

    /* renamed from: U */
    public long mo59127U() {
        return this.f4312Y;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo59137a() {
        return f4310j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WOWZMediaConfig mo59135a(byte[] bArr) {
        C4315a a;
        if (C4317c.m4404d(bArr, 0, bArr.length) == null || (a = C4317c.m4386a(bArr)) == null) {
            return null;
        }
        String str = f4310j;
        WOWZLog.debug(str, "H.264 codecConfigInfo=" + a.toString());
        double g = a.mo59310g();
        mo59180a("frameRate: " + g);
        if (g > 100.0d) {
            g /= 100.0d;
        }
        double d = 1000.0d / g;
        if (d > 10.0d) {
            f4309i = (long) d;
        }
        mo59180a("codecConfigInfo.getFrameRate(): " + a.mo59310g() + " (" + f4309i + ")");
        WOWZMediaConfig wOWZMediaConfig = new WOWZMediaConfig();
        wOWZMediaConfig.setVideoFrameSize(a.mo59306c(), a.mo59307d());
        return wOWZMediaConfig;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public MediaFormat mo59187b(WOWZMediaConfig wOWZMediaConfig, byte[] bArr) {
        this.f4281n.clearLastError();
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", wOWZMediaConfig.getVideoFrameWidth(), wOWZMediaConfig.getVideoFrameHeight());
            C4316b d = C4317c.m4404d(bArr, 0, bArr.length);
            if (d != null && d.f4502a.length > 0) {
                byte[] bArr2 = {0, 0, 0, 1};
                byte[] bArr3 = new byte[(d.f4502a.length + bArr2.length)];
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                System.arraycopy(d.f4502a, 0, bArr3, 4, d.f4502a.length);
                createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr3));
                int size = d.f4503b.size();
                if (size > 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        i += d.f4503b.get(i2).length;
                    }
                    if (i > 0) {
                        byte[] bArr4 = new byte[(i + (bArr2.length * size))];
                        int i3 = 0;
                        for (int i4 = 0; i4 < size; i4++) {
                            System.arraycopy(bArr2, 0, bArr4, i3, bArr2.length);
                            System.arraycopy(d.f4503b.get(i4), 0, bArr4, bArr2.length + i3, d.f4503b.get(i4).length);
                            i3 += bArr2.length + d.f4503b.get(i4).length;
                        }
                        createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr4));
                    }
                }
            }
            int videoFrameWidth = wOWZMediaConfig.getVideoFrameWidth();
            int videoFrameHeight = wOWZMediaConfig.getVideoFrameHeight();
            createVideoFormat.setInteger("max-width", videoFrameWidth);
            createVideoFormat.setInteger("max-height", videoFrameHeight);
            createVideoFormat.setInteger("max-input-size", ((((m4078a(wOWZMediaConfig.getVideoFrameWidth(), 16) * m4078a(wOWZMediaConfig.getVideoFrameHeight(), 16)) * 16) * 16) * 3) / 4);
            return createVideoFormat;
        } catch (Exception e) {
            this.f4281n.setError(new WOWZPlatformError(85, e));
            WOWZLog.error(mo59137a(), this.f4281n.getLastError(), (Throwable) this.f4281n.getLastError().getException());
            return null;
        }
    }

    /* renamed from: a */
    private static int m4078a(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WOWZStatus mo59136a(WOWZMediaConfig wOWZMediaConfig, byte[] bArr) {
        this.f4311X = false;
        this.f4312Y = 0;
        return super.mo59136a(wOWZMediaConfig, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59176a(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, int i2, long j5) {
        if (!f4239L) {
            return 2;
        }
        float f = 30.0f;
        float M = mo59119M();
        this.f4281n.clearLastError();
        long j6 = j2 - 29;
        if (this.f4311X) {
            if (j2 >= f4307V) {
                if (M > 0.0f) {
                    f = M * 100.0f;
                }
                try {
                    long j7 = j - f4235H;
                    long j8 = ((C4290d.C4292a) f4242O.peek()).f4294c;
                    if (j > j8) {
                        String a = mo59137a();
                        WOWZLog.debug(a, "Video packets not coming in order.  bufferTimecodeMs:" + j + ", nextVideoTimestamp: " + j8 + " .... yikes.  Skip?");
                    } else if (f4235H > 0 && j7 > f4308W) {
                        String a2 = mo59137a();
                        WOWZLog.debug(a2, "Video is way ahead of audio with  diff: " + j7 + ", bufferTimecodeMs: " + j + ",  lastAudioTimestamp: " + f4235H + ", vs. waitTime: " + j6);
                    } else if (j7 < -500) {
                        String a3 = mo59137a();
                        WOWZLog.debug(a3, "Skipping video frame for catchup: " + j6 + ",   Frame Rate: " + f + ", diff: " + j + " - " + f4235H + "=" + j7);
                        Thread.sleep(10);
                    } else if (j6 > 0) {
                        Thread.sleep(j6);
                    }
                } catch (InterruptedException e) {
                    String a4 = mo59137a();
                    WOWZLog.warn(a4, "MediaCodecVideoDecoder Exception: " + e.getMessage());
                }
            } else {
                try {
                    f4236I = j;
                    mediaCodec.releaseOutputBuffer(i, true);
                    if (!this.f4311X) {
                        this.f4311X = true;
                    }
                    this.f4312Y = j;
                } catch (Exception e2) {
                    this.f4281n.setError(new WOWZError("An exception occurred releasing the video decoder output buffer", e2));
                    WOWZLog.error(mo59137a(), this.f4281n.getLastError(), (Throwable) this.f4281n.getLastError().getException());
                    return -1;
                }
            }
        }
        return 1;
    }

    /* renamed from: am */
    public void mo59201am() {
        f4231B = true;
    }

    /* renamed from: an */
    public void mo59202an() {
        f4231B = false;
    }
}
