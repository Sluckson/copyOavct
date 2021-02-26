package com.wowza.gocoder.sdk.support.p038e;

import android.media.AudioTrack;
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
import com.wowza.gocoder.sdk.support.p040g.C4301b;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p043a.C4313a;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p043a.C4314b;
import java.nio.ByteBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.e.c */
/* compiled from: GoCoderSDK */
public class C4289c extends C4290d {

    /* renamed from: V */
    private static final String f4215V = "c";

    /* renamed from: W */
    private static final int f4216W = 10;

    /* renamed from: X */
    private static final int f4217X = 30000;

    /* renamed from: ah */
    private static int f4218ah = 1;

    /* renamed from: i */
    public static long f4219i;

    /* renamed from: j */
    public static long f4220j;

    /* renamed from: Y */
    private final long[] f4221Y = new long[10];

    /* renamed from: Z */
    private int f4222Z = 0;

    /* renamed from: aa */
    private int f4223aa = 0;

    /* renamed from: ab */
    private long f4224ab = 0;

    /* renamed from: ac */
    private long f4225ac = 0;

    /* renamed from: ad */
    private long f4226ad = 0;

    /* renamed from: ae */
    private long f4227ae = 0;

    /* renamed from: af */
    private int f4228af;

    /* renamed from: ag */
    private AudioTrack f4229ag = null;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo59147b() {
        return "audio/mp4a-latm";
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo59137a() {
        return f4215V;
    }

    /* renamed from: U */
    public long mo59127U() {
        if (mo59151f().isIdle()) {
            return 0;
        }
        return m3949ap();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public MediaFormat mo59187b(WOWZMediaConfig wOWZMediaConfig, byte[] bArr) {
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", wOWZMediaConfig.getAudioSampleRate(), wOWZMediaConfig.getAudioChannels());
            createAudioFormat.setInteger("is-adts", 1);
            return createAudioFormat;
        } catch (Exception e) {
            this.f4281n.setError(new WOWZPlatformError(86, e));
            WOWZLog.error(mo59137a(), this.f4281n.getLastError());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WOWZMediaConfig mo59135a(byte[] bArr) {
        C4313a a = C4314b.m4365a(bArr, 0);
        if (a == null) {
            return null;
        }
        f4220j = 0;
        String str = f4215V;
        WOWZLog.debug(str, "AAC configFrame: " + a.toString() + ", timestampDelay: " + f4220j);
        f4219i = Math.round(((double) (a.mo59295e() * 1000)) / ((double) a.mo59285a()));
        String str2 = f4215V;
        WOWZLog.debug(str2, "AAC configFrame test: Math.round((double)(" + a.mo59295e() + "*1000)/(double)" + a.mo59285a() + ") :: " + f4219i);
        WOWZMediaConfig wOWZMediaConfig = new WOWZMediaConfig();
        wOWZMediaConfig.setAudioChannels(a.mo59291c());
        wOWZMediaConfig.setAudioSampleRate(a.mo59285a());
        return wOWZMediaConfig;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WOWZStatus mo59136a(WOWZMediaConfig wOWZMediaConfig, byte[] bArr) {
        this.f4289y = bArr;
        this.f4222Z = 0;
        this.f4223aa = 0;
        this.f4224ab = 0;
        this.f4225ac = 0;
        this.f4228af = 0;
        this.f4226ad = 0;
        this.f4227ae = 0;
        super.mo59136a(wOWZMediaConfig, bArr);
        if (this.f4281n.isRunning()) {
            mo59190a(6, 0, bArr);
        }
        return this.f4281n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59177a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        String str = f4215V;
        WOWZLog.debug(str, "Audio decoder output format changed: " + mediaFormat.toString());
        this.f4281n.clearLastError();
        if (this.f4229ag == null) {
            try {
                int integer = mediaFormat.getInteger("sample-rate");
                int integer2 = mediaFormat.getInteger("channel-count");
                int i2 = integer2 > 1 ? 12 : 4;
                String str2 = f4215V;
                WOWZLog.debug(str2, "nChannels: " + integer2);
                int minBufferSize = AudioTrack.getMinBufferSize(integer, 2, 2);
                if (minBufferSize == -1 || minBufferSize == -2) {
                    int i3 = integer2 > 1 ? integer2 * integer * 2 : integer2 * integer;
                    String str3 = f4215V;
                    WOWZLog.debug(str3, "mBufferSize: " + i3 + ", sampleRate: " + integer);
                    i = i3;
                } else {
                    String str4 = f4215V;
                    WOWZLog.debug(str4, "mBufferSize[2]: " + minBufferSize + ", sampleRate: " + integer);
                    i = minBufferSize;
                }
                this.f4229ag = new AudioTrack(3, integer, i2, 2, i, 1);
                this.f4229ag.play();
            } catch (Exception e) {
                WOWZError wOWZError = new WOWZError("An exception occurred creating the audio decoder output track", e);
                WOWZLog.error(f4215V, wOWZError);
                this.f4281n.setError(wOWZError);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59176a(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, int i2, long j5) {
        this.f4281n.clearLastError();
        if (this.f4229ag != null) {
            if (!f4239L) {
                return 2;
            }
            try {
                if (C4290d.f4231B) {
                    this.f4278k.releaseOutputBuffer(i, false);
                    return 1;
                }
                f4235H = bufferInfo.presentationTimeUs;
                byte[] bArr = new byte[bufferInfo.size];
                byteBuffer.get(bArr);
                byteBuffer.clear();
                if (bArr.length > 0) {
                    this.f4229ag.write(bArr, 0, bArr.length);
                }
                this.f4228af += bArr.length;
                try {
                    this.f4278k.releaseOutputBuffer(i, false);
                    return 1;
                } catch (Exception e) {
                    WOWZError wOWZError = new WOWZError("An exception occurred releasing the audio decoder output buffer", e);
                    WOWZLog.error(f4215V, wOWZError);
                    this.f4281n.setError(wOWZError);
                    return -1;
                }
            } catch (Exception e2) {
                WOWZError wOWZError2 = new WOWZError("An exception occurred writing to the audio decoder track", e2);
                WOWZLog.error(f4215V, wOWZError2);
                this.f4281n.setError(wOWZError2);
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ac */
    public void mo59182ac() {
        AudioTrack audioTrack = this.f4229ag;
        if (audioTrack != null) {
            try {
                this.f4264U = true;
                audioTrack.stop();
            } catch (Exception e) {
                String str = f4215V;
                WOWZLog.warn(str, "A " + e.getClass().getSimpleName() + " exception occurred attempting to stop the audio track");
            }
            try {
                this.f4263T = true;
                this.f4229ag.release();
                WOWZLog.debug(mo59137a(), "Released AudioTrack");
            } catch (Exception e2) {
                String str2 = f4215V;
                WOWZLog.warn(str2, "A " + e2.getClass().getSimpleName() + " exception occurred attempting to release the audio track");
            }
            this.f4229ag = null;
        }
        super.mo59182ac();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f4229ag;
     */
    /* renamed from: am */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3946am() {
        /*
            r2 = this;
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r2.f4281n
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x0015
            android.media.AudioTrack r0 = r2.f4229ag
            if (r0 == 0) goto L_0x0015
            int r0 = r0.getPlayState()
            r1 = 3
            if (r0 != r1) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p038e.C4289c.m3946am():boolean");
    }

    /* renamed from: an */
    private long m3947an() {
        if (!m3946am()) {
            return 0;
        }
        long ar = m3951ar();
        if (ar == 0) {
            return 0;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.f4225ac >= 30000) {
            long[] jArr = this.f4221Y;
            int i = this.f4222Z;
            jArr[i] = ar - nanoTime;
            this.f4222Z = (i + 1) % 10;
            int i2 = this.f4223aa;
            if (i2 < 10) {
                this.f4223aa = i2 + 1;
            }
            this.f4225ac = nanoTime;
            this.f4224ab = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f4223aa;
                if (i3 >= i4) {
                    break;
                }
                this.f4224ab += this.f4221Y[i3] / ((long) i4);
                i3++;
            }
        }
        return this.f4224ab;
    }

    /* renamed from: ao */
    private long m3948ao() {
        if (!m3946am()) {
            return 0;
        }
        m3947an();
        long nanoTime = System.nanoTime() / 1000;
        if (this.f4223aa == 0) {
            return m3951ar();
        }
        return nanoTime + this.f4224ab;
    }

    /* renamed from: ap */
    private long m3949ap() {
        return m3948ao() / 1000;
    }

    /* renamed from: aq */
    private long m3950aq() {
        if (!m3946am()) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.f4229ag.getPlaybackHeadPosition());
        if (this.f4226ad > playbackHeadPosition) {
            this.f4227ae++;
        }
        this.f4226ad = playbackHeadPosition;
        return playbackHeadPosition + (this.f4227ae << 32);
    }

    /* renamed from: ar */
    private long m3951ar() {
        if (mo59152g() == null || mo59152g().getAudioSampleRate() == 0) {
            return 0;
        }
        return (m3950aq() * 1000000) / ((long) mo59152g().getAudioSampleRate());
    }

    /* renamed from: as */
    private long m3952as() {
        return ((long) Math.floor((double) (((float) this.f4228af) / ((float) (mo59152g().getAudioChannels() * 2))))) - m3950aq();
    }

    /* renamed from: at */
    private long m3953at() {
        return m3954au() / 1000;
    }

    /* renamed from: au */
    private long m3954au() {
        return (m3952as() * 1000000) / ((long) mo59152g().getAudioSampleRate());
    }
}
