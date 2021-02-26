package com.wowza.gocoder.sdk.support.p035b;

import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.p037d.C4280a;
import java.util.ArrayList;
import java.util.Iterator;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

/* renamed from: com.wowza.gocoder.sdk.support.b.a */
/* compiled from: GoCoderSDK */
public class C4272a implements WOWZBroadcastAPI.VideoBroadcaster, C4280a.C4282a {

    /* renamed from: A */
    private static final int f4015A = 3;

    /* renamed from: B */
    private static final int f4016B = 6;

    /* renamed from: C */
    private static final int f4017C = -1;

    /* renamed from: D */
    private static final int f4018D = 0;

    /* renamed from: E */
    private static final int f4019E = 1;

    /* renamed from: b */
    private static final String f4020b = "ABRVideoBroadcaster";

    /* renamed from: c */
    private static final float f4021c = 1.0f;

    /* renamed from: d */
    private static final float f4022d = 2.0f;

    /* renamed from: e */
    private static final float f4023e = 4.0f;

    /* renamed from: f */
    private static final float f4024f = 0.64f;

    /* renamed from: g */
    private static final int f4025g = 0;

    /* renamed from: h */
    private static final int f4026h = 1;

    /* renamed from: i */
    private static final int f4027i = 2;

    /* renamed from: j */
    private static final int f4028j = 3;

    /* renamed from: k */
    private static final int f4029k = 4;

    /* renamed from: l */
    private static final int f4030l = 6;

    /* renamed from: m */
    private static final int f4031m = 2;

    /* renamed from: n */
    private static final int f4032n = 3;

    /* renamed from: o */
    private static final int f4033o = 8;

    /* renamed from: p */
    private static final int f4034p = 4;

    /* renamed from: q */
    private static final int f4035q = 0;

    /* renamed from: r */
    private static final int f4036r = 1;

    /* renamed from: s */
    private static final int f4037s = 0;

    /* renamed from: t */
    private static final int f4038t = 1;

    /* renamed from: u */
    private static final int f4039u = 2;

    /* renamed from: v */
    private static final int f4040v = 3;

    /* renamed from: w */
    private static final int f4041w = 4;

    /* renamed from: x */
    private static final int f4042x = 0;

    /* renamed from: y */
    private static final int f4043y = 1;

    /* renamed from: z */
    private static final int f4044z = 2;

    /* renamed from: F */
    private WOWZBroadcastConfig f4045F;

    /* renamed from: G */
    private boolean f4046G;

    /* renamed from: H */
    private float f4047H;

    /* renamed from: I */
    private int f4048I;

    /* renamed from: J */
    private int f4049J;

    /* renamed from: K */
    private int f4050K;

    /* renamed from: L */
    private boolean f4051L;

    /* renamed from: M */
    private boolean f4052M;

    /* renamed from: N */
    private int f4053N;

    /* renamed from: O */
    private int[] f4054O;

    /* renamed from: P */
    private int[] f4055P;

    /* renamed from: Q */
    private ArrayList<Integer> f4056Q;

    /* renamed from: R */
    private ArrayList<Long> f4057R;

    /* renamed from: S */
    private ArrayList<WOWZBroadcastAPI.AdaptiveChangeListener> f4058S;

    /* renamed from: T */
    private ArrayList<WOWZBroadcastAPI.AdaptiveChangeListener> f4059T;

    /* renamed from: U */
    private long[] f4060U;

    /* renamed from: V */
    private int f4061V;

    /* renamed from: W */
    private final Object f4062W;

    /* renamed from: a */
    WOWZBroadcastAPI.VideoBroadcaster f4063a;

    /* renamed from: a */
    public static boolean m3758a(WOWZBroadcastConfig wOWZBroadcastConfig) {
        return wOWZBroadcastConfig.isABREnabled() && wOWZBroadcastConfig.isVideoEnabled() && wOWZBroadcastConfig.getVideoBroadcaster() != null && (wOWZBroadcastConfig.getVideoBroadcaster() instanceof WOWZBroadcastAPI.AdaptiveBroadcaster);
    }

    public C4272a() {
        this.f4047H = 0.25f;
        this.f4048I = CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA;
        this.f4049J = 1;
        this.f4050K = 1;
        this.f4051L = false;
        this.f4052M = false;
        this.f4062W = new Object();
        this.f4063a = null;
        this.f4045F = null;
        this.f4046G = true;
        this.f4060U = new long[4];
        this.f4054O = new int[5];
        this.f4055P = new int[4];
        this.f4056Q = new ArrayList<>();
        this.f4057R = new ArrayList<>();
        this.f4061V = 0;
        this.f4058S = new ArrayList<>();
        this.f4059T = new ArrayList<>();
    }

    public C4272a(WOWZBroadcastAPI.VideoBroadcaster videoBroadcaster) {
        this();
        mo59033a(videoBroadcaster);
    }

    /* renamed from: a */
    public void mo59033a(WOWZBroadcastAPI.VideoBroadcaster videoBroadcaster) {
        if (this.f4045F == null) {
            if (!(videoBroadcaster instanceof C4272a)) {
                this.f4063a = videoBroadcaster;
                return;
            }
            throw new IllegalArgumentException("Cannot use another ABRVideoBroadcast instance");
        }
    }

    /* renamed from: a */
    public WOWZBroadcastAPI.VideoBroadcaster mo59031a() {
        return this.f4063a;
    }

    /* renamed from: b */
    public boolean mo59037b() {
        return this.f4046G;
    }

    /* renamed from: a */
    public void mo59035a(boolean z) {
        if (z != this.f4046G) {
            this.f4046G = z;
            WOWZBroadcastConfig wOWZBroadcastConfig = this.f4045F;
            if (wOWZBroadcastConfig == null) {
                return;
            }
            if (this.f4046G) {
                wOWZBroadcastConfig.getStreamingMonitor().mo59083a((C4280a.C4282a) this);
                return;
            }
            wOWZBroadcastConfig.getStreamingMonitor().mo59087b((C4280a.C4282a) this);
            WOWZBroadcastAPI.AdaptiveBroadcaster adaptiveBroadcaster = (WOWZBroadcastAPI.AdaptiveBroadcaster) this.f4063a;
            adaptiveBroadcaster.changeAdaptiveBitrate(this.f4045F.getVideoBitRate());
            adaptiveBroadcaster.changeAdaptiveFramerate(this.f4045F.getVideoFramerate());
        }
    }

    /* renamed from: c */
    public int mo59038c() {
        WOWZBroadcastConfig wOWZBroadcastConfig = this.f4045F;
        if (wOWZBroadcastConfig == null) {
            return 0;
        }
        return wOWZBroadcastConfig.getVideoBitRate();
    }

    /* renamed from: d */
    public int mo59040d() {
        WOWZBroadcastConfig wOWZBroadcastConfig = this.f4045F;
        if (wOWZBroadcastConfig == null) {
            return 0;
        }
        return wOWZBroadcastConfig.getVideoFramerate();
    }

    /* renamed from: e */
    public int mo59042e() {
        if (this.f4045F != null) {
            return 0;
        }
        return ((WOWZBroadcastAPI.AdaptiveBroadcaster) this.f4063a).getAdaptiveBitrate();
    }

    /* renamed from: f */
    public int mo59043f() {
        if (this.f4045F != null) {
            return 0;
        }
        return ((WOWZBroadcastAPI.AdaptiveBroadcaster) this.f4063a).getAdaptiveFramerate();
    }

    /* renamed from: a */
    public void mo59032a(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f4059T.add(adaptiveChangeListener);
    }

    /* renamed from: b */
    public void mo59036b(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f4058S.add(adaptiveChangeListener);
    }

    /* renamed from: c */
    public void mo59039c(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f4059T.remove(adaptiveChangeListener);
    }

    /* renamed from: d */
    public void mo59041d(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f4058S.remove(adaptiveChangeListener);
    }

    public WOWZMediaConfig getVideoSourceConfig() {
        return this.f4063a.getVideoSourceConfig();
    }

    public boolean isVideoEnabled() {
        return this.f4063a.isVideoEnabled();
    }

    public void setVideoEnabled(boolean z) {
        this.f4063a.isVideoEnabled();
    }

    public boolean isVideoPaused() {
        return this.f4063a.isVideoPaused();
    }

    public void setVideoPaused(boolean z) {
        this.f4063a.setVideoPaused(z);
    }

    public WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f4045F = new WOWZBroadcastConfig(wOWZBroadcastConfig);
        if (this.f4046G) {
            this.f4045F.getStreamingMonitor().mo59083a((C4280a.C4282a) this);
        }
        return this.f4063a.prepareForBroadcast(wOWZBroadcastConfig);
    }

    public WOWZStatus startBroadcasting() {
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        while (true) {
            long[] jArr = this.f4060U;
            if (i < jArr.length) {
                jArr[i] = currentTimeMillis;
                i++;
            } else {
                this.f4053N = 0;
                this.f4054O[0] = this.f4045F.getVideoFramerate();
                int[] iArr = this.f4054O;
                iArr[1] = this.f4049J;
                iArr[2] = this.f4045F.getVideoFramerate();
                this.f4054O[3] = this.f4045F.getVideoFramerate();
                this.f4054O[4] = this.f4045F.getVideoFramerate();
                this.f4055P[0] = this.f4045F.getVideoBitRate() * 1000;
                int[] iArr2 = this.f4055P;
                iArr2[1] = this.f4048I * 1000;
                iArr2[2] = this.f4045F.getVideoBitRate() * 1000;
                this.f4055P[3] = this.f4045F.getVideoBitRate() * 1000;
                this.f4057R.clear();
                this.f4056Q.clear();
                this.f4061V = 0;
                return this.f4063a.startBroadcasting();
            }
        }
    }

    public WOWZStatus stopBroadcasting() {
        this.f4045F.getStreamingMonitor().mo59087b((C4280a.C4282a) this);
        this.f4045F = null;
        return this.f4063a.stopBroadcasting();
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        return this.f4045F;
    }

    public WOWZStatus getBroadcasterStatus() {
        return this.f4063a.getBroadcasterStatus();
    }

    public WOWZStatus getStatus() {
        return getBroadcasterStatus();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo59034a(com.wowza.gocoder.sdk.api.monitor.WOWZStreamingStat r12) {
        /*
            r11 = this;
            boolean r0 = r11.f4046G
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$VideoBroadcaster r0 = r11.f4063a
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveBroadcaster r0 = (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI.AdaptiveBroadcaster) r0
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r1 = r11.f4045F
            int r1 = r1.getVideoBitRate()
            int r2 = r0.getAdaptiveBitrate()
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r3 = r11.f4045F
            int r3 = r3.getVideoFramerate()
            int r4 = r0.getAdaptiveFramerate()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "active bitrate = "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r6 = ", original = "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r6, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "active framerate = "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r6 = ", original = "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r6, r5)
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r5 = r11.f4045F
            float r5 = r5.getLowBandwidthScalingFactor()
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r6 = r11.f4045F
            int r6 = r6.getFrameBufferSizeMultiplier()
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r7 = r11.f4045F
            int r7 = r7.getVideoFramerate()
            int r6 = r6 * r7
            int r7 = r12.videoFramesBuffered
            int r8 = r6 / 2
            r9 = 0
            if (r7 <= r8) goto L_0x00dc
            if (r2 != r1) goto L_0x00dc
            float r1 = (float) r1
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Decreasing bitrate to "
            r2.append(r5)
            r2.append(r1)
            java.lang.String r5 = " because the no. of pending frames reached "
            r2.append(r5)
            int r5 = r12.videoFramesBuffered
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r5, r2)
            java.lang.Object r5 = r11.f4062W
            monitor-enter(r5)
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r2 = r11.f4058S     // Catch:{ all -> 0x00d9 }
            int r2 = r2.size()     // Catch:{ all -> 0x00d9 }
            if (r2 <= 0) goto L_0x00c7
            r2 = r1
            r1 = 0
        L_0x00aa:
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r7 = r11.f4058S     // Catch:{ all -> 0x00d9 }
            int r7 = r7.size()     // Catch:{ all -> 0x00d9 }
            if (r1 >= r7) goto L_0x00c6
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r7 = r11.f4058S     // Catch:{ all -> 0x00d9 }
            java.lang.Object r7 = r7.get(r1)     // Catch:{ all -> 0x00d9 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener r7 = (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI.AdaptiveChangeListener) r7     // Catch:{ all -> 0x00d9 }
            int r7 = r7.adaptiveBitRateChange(r12, r2)     // Catch:{ all -> 0x00d9 }
            if (r7 <= 0) goto L_0x00c3
            if (r7 == r2) goto L_0x00c3
            r2 = r7
        L_0x00c3:
            int r1 = r1 + 1
            goto L_0x00aa
        L_0x00c6:
            r1 = r2
        L_0x00c7:
            monitor-exit(r5)     // Catch:{ all -> 0x00d9 }
            r0.changeAdaptiveBitrate(r1)     // Catch:{ Exception -> 0x00cd }
            goto L_0x0177
        L_0x00cd:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            java.lang.String r2 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r2, (java.lang.String) r1)
            goto L_0x0177
        L_0x00d9:
            r12 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00d9 }
            throw r12
        L_0x00dc:
            int r5 = r12.videoFramesBuffered
            if (r5 != 0) goto L_0x0141
            if (r2 == r1) goto L_0x0141
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Increasing bitrate to "
            r5.append(r7)
            r5.append(r1)
            java.lang.String r7 = " because the no. of pending frames lowered to "
            r5.append(r7)
            int r7 = r12.videoFramesBuffered
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r7, r5)
            java.lang.Object r5 = r11.f4062W
            monitor-enter(r5)
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r7 = r11.f4058S     // Catch:{ all -> 0x013e }
            int r7 = r7.size()     // Catch:{ all -> 0x013e }
            if (r7 <= 0) goto L_0x012c
            r7 = r1
            r1 = 0
        L_0x010f:
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r10 = r11.f4058S     // Catch:{ all -> 0x013e }
            int r10 = r10.size()     // Catch:{ all -> 0x013e }
            if (r1 >= r10) goto L_0x012b
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r10 = r11.f4058S     // Catch:{ all -> 0x013e }
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x013e }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener r10 = (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI.AdaptiveChangeListener) r10     // Catch:{ all -> 0x013e }
            int r10 = r10.adaptiveBitRateChange(r12, r7)     // Catch:{ all -> 0x013e }
            if (r10 <= 0) goto L_0x0128
            if (r10 == r7) goto L_0x0128
            r7 = r10
        L_0x0128:
            int r1 = r1 + 1
            goto L_0x010f
        L_0x012b:
            r1 = r7
        L_0x012c:
            monitor-exit(r5)     // Catch:{ all -> 0x013e }
            if (r1 == r2) goto L_0x0177
            r0.changeAdaptiveBitrate(r1)     // Catch:{ Exception -> 0x0133 }
            goto L_0x0177
        L_0x0133:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            java.lang.String r2 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r2, (java.lang.String) r1)
            goto L_0x0177
        L_0x013e:
            r12 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x013e }
            throw r12
        L_0x0141:
            java.lang.Object r1 = r11.f4062W
            monitor-enter(r1)
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r5 = r11.f4058S     // Catch:{ all -> 0x0297 }
            int r5 = r5.size()     // Catch:{ all -> 0x0297 }
            if (r5 <= 0) goto L_0x0165
            r7 = r2
            r5 = 0
        L_0x014e:
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r10 = r11.f4058S     // Catch:{ all -> 0x0297 }
            int r10 = r10.size()     // Catch:{ all -> 0x0297 }
            if (r5 >= r10) goto L_0x0166
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r7 = r11.f4058S     // Catch:{ all -> 0x0297 }
            java.lang.Object r7 = r7.get(r5)     // Catch:{ all -> 0x0297 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener r7 = (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI.AdaptiveChangeListener) r7     // Catch:{ all -> 0x0297 }
            int r7 = r7.adaptiveBitRateChange(r12, r2)     // Catch:{ all -> 0x0297 }
            int r5 = r5 + 1
            goto L_0x014e
        L_0x0165:
            r7 = r2
        L_0x0166:
            monitor-exit(r1)     // Catch:{ all -> 0x0297 }
            if (r7 == r2) goto L_0x0177
            r0.changeAdaptiveBitrate(r7)     // Catch:{ Exception -> 0x016d }
            goto L_0x0177
        L_0x016d:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            java.lang.String r2 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r2, (java.lang.String) r1)
        L_0x0177:
            int r1 = r12.videoFramesBuffered
            if (r1 <= r6) goto L_0x01fd
            if (r4 != r3) goto L_0x01fd
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r1 = r11.f4045F
            int r1 = r1.getFrameRateLowBandwidthSkipCount()
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r2 = r11.f4045F
            int r2 = r2.getVideoKeyFrameInterval()
            r5 = 1
            int r2 = r2 - r5
            int r1 = java.lang.Math.min(r1, r2)
            if (r1 <= r5) goto L_0x019f
            float r2 = (float) r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r1 = (float) r1
            float r5 = r5 / r1
            float r2 = r2 * r5
            double r1 = (double) r2
            double r1 = java.lang.Math.floor(r1)
            int r1 = (int) r1
            int r3 = r3 - r1
        L_0x019f:
            if (r3 == r4) goto L_0x0293
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Decreasing framerate to "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " because the no. of pending frames reached "
            r1.append(r2)
            int r2 = r12.videoFramesBuffered
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r2, r1)
            java.lang.Object r1 = r11.f4062W
            monitor-enter(r1)
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r2 = r11.f4059T     // Catch:{ all -> 0x01fa }
            int r2 = r2.size()     // Catch:{ all -> 0x01fa }
            if (r2 <= 0) goto L_0x01e8
        L_0x01cc:
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r2 = r11.f4059T     // Catch:{ all -> 0x01fa }
            int r2 = r2.size()     // Catch:{ all -> 0x01fa }
            if (r9 >= r2) goto L_0x01e8
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r2 = r11.f4059T     // Catch:{ all -> 0x01fa }
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x01fa }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener r2 = (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI.AdaptiveChangeListener) r2     // Catch:{ all -> 0x01fa }
            int r2 = r2.adaptiveFrameRateChange(r12, r3)     // Catch:{ all -> 0x01fa }
            if (r2 <= 0) goto L_0x01e5
            if (r2 == r3) goto L_0x01e5
            r3 = r2
        L_0x01e5:
            int r9 = r9 + 1
            goto L_0x01cc
        L_0x01e8:
            monitor-exit(r1)     // Catch:{ all -> 0x01fa }
            r0.changeAdaptiveFramerate(r3)     // Catch:{ Exception -> 0x01ee }
            goto L_0x0293
        L_0x01ee:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            java.lang.String r0 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (java.lang.String) r12)
            goto L_0x0293
        L_0x01fa:
            r12 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x01fa }
            throw r12
        L_0x01fd:
            int r1 = r12.videoFramesBuffered
            if (r1 >= r8) goto L_0x025f
            if (r4 >= r3) goto L_0x025f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Increasing framerate to "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " because the no. of pending frames lowered to "
            r1.append(r2)
            int r2 = r12.videoFramesBuffered
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r2, r1)
            java.lang.Object r1 = r11.f4062W
            monitor-enter(r1)
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r2 = r11.f4059T     // Catch:{ all -> 0x025c }
            int r2 = r2.size()     // Catch:{ all -> 0x025c }
            if (r2 <= 0) goto L_0x024a
        L_0x022e:
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r2 = r11.f4059T     // Catch:{ all -> 0x025c }
            int r2 = r2.size()     // Catch:{ all -> 0x025c }
            if (r9 >= r2) goto L_0x024a
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r2 = r11.f4059T     // Catch:{ all -> 0x025c }
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x025c }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener r2 = (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI.AdaptiveChangeListener) r2     // Catch:{ all -> 0x025c }
            int r2 = r2.adaptiveFrameRateChange(r12, r3)     // Catch:{ all -> 0x025c }
            if (r2 <= 0) goto L_0x0247
            if (r2 == r3) goto L_0x0247
            r3 = r2
        L_0x0247:
            int r9 = r9 + 1
            goto L_0x022e
        L_0x024a:
            monitor-exit(r1)     // Catch:{ all -> 0x025c }
            if (r4 >= r3) goto L_0x0293
            r0.changeAdaptiveFramerate(r3)     // Catch:{ Exception -> 0x0251 }
            goto L_0x0293
        L_0x0251:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            java.lang.String r0 = "ABRVideoBroadcaster"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (java.lang.String) r12)
            goto L_0x0293
        L_0x025c:
            r12 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x025c }
            throw r12
        L_0x025f:
            java.lang.Object r2 = r11.f4062W
            monitor-enter(r2)
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r1 = r11.f4059T     // Catch:{ all -> 0x0294 }
            int r1 = r1.size()     // Catch:{ all -> 0x0294 }
            if (r1 <= 0) goto L_0x0292
            r1 = r4
        L_0x026b:
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r3 = r11.f4059T     // Catch:{ all -> 0x0294 }
            int r3 = r3.size()     // Catch:{ all -> 0x0294 }
            if (r9 >= r3) goto L_0x0282
            java.util.ArrayList<com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener> r1 = r11.f4059T     // Catch:{ all -> 0x0294 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x0294 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$AdaptiveChangeListener r1 = (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI.AdaptiveChangeListener) r1     // Catch:{ all -> 0x0294 }
            int r1 = r1.adaptiveFrameRateChange(r12, r4)     // Catch:{ all -> 0x0294 }
            int r9 = r9 + 1
            goto L_0x026b
        L_0x0282:
            if (r1 == r4) goto L_0x0292
            r0.changeAdaptiveFramerate(r1)     // Catch:{ Exception -> 0x0288 }
            goto L_0x0292
        L_0x0288:
            r12 = move-exception
            java.lang.String r0 = "ABRVideoBroadcaster"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0294 }
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (java.lang.String) r12)     // Catch:{ all -> 0x0294 }
        L_0x0292:
            monitor-exit(r2)     // Catch:{ all -> 0x0294 }
        L_0x0293:
            return
        L_0x0294:
            r12 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0294 }
            throw r12
        L_0x0297:
            r12 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0297 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p035b.C4272a.mo59034a(com.wowza.gocoder.sdk.api.monitor.WOWZStreamingStat):void");
    }

    /* renamed from: g */
    private int m3761g() {
        Iterator<Long> it = this.f4057R.iterator();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = -1;
            if (!it.hasNext()) {
                break;
            }
            long longValue = it.next().longValue();
            int i3 = (longValue > j ? 1 : (longValue == j ? 0 : -1));
            if (i3 > 0) {
                i2 = 1;
            } else if (i3 >= 0) {
                i2 = 0;
            }
            i += i2;
            j = longValue;
        }
        if (i < 0) {
            return 1;
        }
        return i > 0 ? -1 : 0;
    }

    /* renamed from: h */
    private int m3762h() {
        int i = 0;
        if (this.f4056Q.size() == 0) {
            return 0;
        }
        Iterator<Integer> it = this.f4056Q.iterator();
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return Math.round(((float) i) / ((float) this.f4056Q.size()));
    }

    /* renamed from: a */
    private int[] m3759a(WOWZSize wOWZSize, int i) {
        float f = (float) i;
        return new int[]{Math.round(((float) wOWZSize.width) * ((float) wOWZSize.height) * f * 1.0f * 0.07f), Math.round(((float) wOWZSize.width) * ((float) wOWZSize.height) * f * f4023e * 0.07f)};
    }

    /* renamed from: b */
    private int[] m3760b(WOWZSize wOWZSize, int i) {
        int[] a = m3759a(wOWZSize, i);
        a[0] = a[0] * Math.round(((float) a[0]) * 1.5625f);
        a[1] = a[1] * Math.round(((float) a[1]) * 1.5625f);
        return a;
    }

    /* renamed from: a */
    private float m3756a(WOWZSize wOWZSize, int i, int i2) {
        int[] b = m3760b(wOWZSize, i);
        int i3 = b[1] - b[0];
        int i4 = i2 - b[0];
        float f = i4 <= 0 ? 0.0f : i4 >= i3 ? 1.0f : ((float) i4) / ((float) i3);
        WOWZLog.debug(f4020b, "QofS calculated for frameSize = " + wOWZSize.toString() + ", framerate = " + i + ", bps = " + i2 + " = " + f);
        return f;
    }

    /* renamed from: a */
    private void m3757a(WOWZBroadcastAPI.AdaptiveBroadcaster adaptiveBroadcaster, WOWZSize wOWZSize, float f, int i, int i2, int i3, int i4, int i5) {
        int i6;
        WOWZSize wOWZSize2 = wOWZSize;
        int i7 = i2;
        int i8 = i4;
        WOWZLog.debug(f4020b, "ENTER optimize. getAdaptiveFramerate = " + adaptiveBroadcaster.getAdaptiveFramerate() + ", getAdaptiveBitrate   = " + adaptiveBroadcaster.getAdaptiveBitrate());
        int round = Math.round(((float) i) * f4024f);
        int i9 = i3;
        int[] iArr = null;
        float f2 = 0.0f;
        while (i9 >= i7) {
            f2 = m3756a(wOWZSize2, i9, round);
            if (f2 >= f) {
                iArr = m3759a(wOWZSize2, i9);
                if (iArr[1] >= i8) {
                    break;
                }
            } else {
                iArr = null;
            }
            i9--;
        }
        int min = Math.min(Math.max(i9, i7), i3);
        WOWZLog.debug(f4020b, "Calculated framerateTarget = " + min);
        if (f2 == 0.0f || iArr == null) {
            WOWZLog.debug(f4020b, "PUNTING optimize");
            iArr = m3759a(wOWZSize2, min);
            i6 = iArr[0];
        } else {
            i6 = iArr[0] + Math.round(((float) (iArr[1] - iArr[0])) * f2);
        }
        WOWZLog.debug(f4020b, "Calculated bitrateRange = " + Math.round(((float) iArr[0]) / 1000.0f) + " to " + Math.round(((float) iArr[1]) / 1000.0f));
        int min2 = Math.min(Math.max(i6, i8), i5);
        StringBuilder sb = new StringBuilder();
        sb.append("Calculated bitrateTarget = ");
        sb.append(Math.round(((float) min2) / 1000.0f));
        WOWZLog.debug(f4020b, sb.toString());
        WOWZLog.debug(f4020b, "EXIT optimize. getAdaptiveFramerate = " + adaptiveBroadcaster.getAdaptiveFramerate() + ", getAdaptiveBitrate   = " + adaptiveBroadcaster.getAdaptiveBitrate());
    }
}
