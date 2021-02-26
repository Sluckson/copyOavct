package com.wowza.gocoder.sdk.api.devices;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI;
import com.wowza.gocoder.sdk.api.status.WOWZState;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.p037d.C4280a;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: GoCoderSDK */
public class WOWZAudioDevice implements WOWZBroadcastAPI.AudioBroadcaster {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f3604a = "WOWZAudioDevice";

    /* renamed from: b */
    private static final int f3605b = 1024;

    /* renamed from: c */
    private static final int f3606c = 8;

    /* renamed from: d */
    private static final int f3607d = 4;

    /* renamed from: e */
    private static final int[] f3608e = {WOWZMediaConfig.DEFAULT_AUDIO_SAMPLE_RATE, 48000, 22050, 11025, 8000};

    /* renamed from: f */
    private static final short[] f3609f = {2, 3};

    /* renamed from: g */
    private static final long f3610g = 90000;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public WOWZStatus f3611A = new WOWZStatus(0);
    /* access modifiers changed from: private */

    /* renamed from: B */
    public WOWZBroadcastConfig f3612B = new WOWZBroadcastConfig();
    /* access modifiers changed from: private */

    /* renamed from: C */
    public ArrayList<AudioSampleListener> f3613C = new ArrayList<>();

    /* renamed from: D */
    private WOWZStatus f3614D = new WOWZStatus(0);

    /* renamed from: E */
    private WOWZBroadcastConfig f3615E = new WOWZBroadcastConfig();

    /* renamed from: F */
    private WOWZSinkAPI.AudioSink[] f3616F;

    /* renamed from: G */
    private boolean f3617G = true;

    /* renamed from: H */
    private C4280a f3618H = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Object f3619h = new Object();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f3620i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile AudioEncoderHandler f3621j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Object f3622k = new Object();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f3623l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile AudioRecorderHandler f3624m = null;

    /* renamed from: n */
    private int f3625n = 5;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public AudioRecord f3626o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public WOWZStatus f3627p = new WOWZStatus(0);

    /* renamed from: q */
    private int f3628q;

    /* renamed from: r */
    private int f3629r;

    /* renamed from: s */
    private int f3630s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public byte[] f3631t;

    /* renamed from: u */
    private long f3632u;

    /* renamed from: v */
    private long f3633v;

    /* renamed from: w */
    private MediaCodec f3634w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public WOWZStatus f3635x = new WOWZStatus(0);

    /* renamed from: y */
    private boolean f3636y;

    /* renamed from: z */
    private MediaCodec.BufferInfo f3637z;

    /* compiled from: GoCoderSDK */
    public interface AudioSampleListener {
        boolean isWZAudioSampleListenerEnabled();

        void onWZAudioPaused(boolean z);

        void onWZAudioSampleListenerRelease();

        void onWZAudioSampleListenerSetup(WOWZMediaConfig wOWZMediaConfig);

        void onWZAudioSampleRecorded(byte[] bArr, int i, long j);
    }

    /* renamed from: a */
    private int m3519a(int i) {
        return i > 1 ? 12 : 16;
    }

    /* renamed from: b */
    private int m3530b(int i) {
        return i == 12 ? 2 : 1;
    }

    public WOWZAudioDevice() {
        m3532b();
    }

    /* renamed from: b */
    private void m3532b() {
        this.f3626o = null;
        this.f3634w = null;
        this.f3637z = null;
        this.f3636y = false;
        this.f3628q = 0;
        this.f3629r = 0;
        this.f3630s = f3608e[0];
        this.f3631t = null;
        this.f3632u = 0;
        this.f3633v = 0;
        this.f3616F = null;
    }

    public int getAudioSource() {
        return this.f3625n;
    }

    public void setAudioSource(int i) {
        this.f3625n = i;
    }

    public WOWZBroadcastConfig getSamplingConfig() {
        return this.f3612B;
    }

    public void setSamplingConfig(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f3612B.set(wOWZBroadcastConfig);
    }

    public boolean isMuted() {
        return isAudioPaused();
    }

    public void setMuted(boolean z) {
        setAudioPaused(z);
    }

    public void registerAudioSampleListener(AudioSampleListener audioSampleListener) {
        if (!this.f3613C.contains(audioSampleListener)) {
            this.f3613C.add(audioSampleListener);
        }
    }

    public void unregisterAudioSampleListener(AudioSampleListener audioSampleListener) {
        if (this.f3613C.contains(audioSampleListener)) {
            this.f3613C.remove(audioSampleListener);
        }
    }

    public boolean isSamplingAudio() {
        return this.f3611A.isRunning();
    }

    public void startAudioSampler(WOWZBroadcastConfig wOWZBroadcastConfig) {
        if (this.f3614D.isIdle() && this.f3611A.isIdle() && this.f3613C.size() != 0) {
            this.f3612B.set(wOWZBroadcastConfig);
            startAudioSampler();
        }
    }

    public void startAudioSampler() {
        if (this.f3614D.isIdle() && this.f3611A.isIdle() && this.f3613C.size() != 0) {
            m3532b();
            m3540d();
            if (m3524a(this.f3612B).isReady()) {
                this.f3624m.post(new Runnable() {
                    public void run() {
                        byte[] unused = WOWZAudioDevice.this.f3631t = new byte[(WOWZAudioDevice.this.f3612B.getAudioChannels() * 4 * 1024 * 8)];
                        WOWZAudioDevice.this.f3626o.startRecording();
                        WOWZAudioDevice.this.f3627p.setState(3);
                        Iterator it = WOWZAudioDevice.this.f3613C.iterator();
                        while (it.hasNext()) {
                            ((AudioSampleListener) it.next()).onWZAudioSampleListenerSetup(WOWZAudioDevice.this.f3612B);
                        }
                        WOWZAudioDevice.this.f3611A.setState(3);
                        while (WOWZAudioDevice.this.f3627p.isRunning()) {
                            WOWZAudioDevice.this.m3538c();
                        }
                        WOWZAudioDevice.this.f3611A.setState(4);
                        Iterator it2 = WOWZAudioDevice.this.f3613C.iterator();
                        while (it2.hasNext()) {
                            ((AudioSampleListener) it2.next()).onWZAudioSampleListenerRelease();
                        }
                        try {
                            WOWZAudioDevice.this.f3626o.stop();
                        } catch (Exception e) {
                            WOWZLog.error(WOWZAudioDevice.f3604a, "An exception occurred stopping the audio recorder.", (Throwable) e);
                        }
                        try {
                            WOWZAudioDevice.this.f3626o.release();
                        } catch (Exception e2) {
                            WOWZLog.error(WOWZAudioDevice.f3604a, "An exception occurred releasing the audio recorder.", (Throwable) e2);
                        } catch (Throwable th) {
                            AudioRecord unused2 = WOWZAudioDevice.this.f3626o = null;
                            Looper.myLooper().quitSafely();
                            throw th;
                        }
                        AudioRecord unused3 = WOWZAudioDevice.this.f3626o = null;
                        Looper.myLooper().quitSafely();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m3538c() {
        try {
            int read = this.f3626o.read(this.f3631t, 0, this.f3631t.length);
            if (read != -3) {
                if (read != -2) {
                    long nanoTime = System.nanoTime();
                    if (this.f3633v == 0) {
                        this.f3633v = nanoTime;
                    }
                    long j = nanoTime - this.f3633v;
                    Iterator<AudioSampleListener> it = this.f3613C.iterator();
                    while (it.hasNext()) {
                        AudioSampleListener next = it.next();
                        if (next.isWZAudioSampleListenerEnabled()) {
                            next.onWZAudioSampleRecorded(this.f3631t, this.f3631t.length, j);
                        }
                    }
                    return;
                }
            }
            String str = f3604a;
            StringBuilder sb = new StringBuilder();
            sb.append(read == -3 ? "Invalid operation" : "Bad value");
            sb.append(" result returned while reading input from the audio recorder.");
            WOWZLog.error(str, sb.toString());
        } catch (Exception e) {
            WOWZLog.error(f3604a, "An exception occurred sampling the audio input.", (Throwable) e);
        }
    }

    public void stopAudioSampler() {
        if (this.f3611A.isRunning()) {
            this.f3627p.setAndWaitForState(4, 0);
            this.f3611A.setState(0);
        }
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        return this.f3615E;
    }

    public WOWZStatus getBroadcasterStatus() {
        return this.f3614D;
    }

    public WOWZStatus getStatus() {
        return getBroadcasterStatus();
    }

    public boolean isAudioEnabled() {
        return this.f3617G;
    }

    public void setAudioEnabled(boolean z) {
        this.f3617G = z;
    }

    public boolean isAudioPaused() {
        return !this.f3614D.isRunning();
    }

    public void setAudioPaused(boolean z) {
        if (this.f3614D.isRunning() || this.f3614D.isPaused()) {
            WOWZStatus wOWZStatus = this.f3614D;
            wOWZStatus.setState(wOWZStatus.isRunning() ? 5 : 3);
            Iterator<AudioSampleListener> it = this.f3613C.iterator();
            while (it.hasNext()) {
                it.next().onWZAudioPaused(this.f3614D.isPaused());
            }
        }
    }

    public WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        if (isSamplingAudio()) {
            stopAudioSampler();
        }
        m3532b();
        this.f3614D.setState(1);
        this.f3616F = wOWZBroadcastConfig.getAudioSinks();
        m3540d();
        WOWZStatus a = m3524a(wOWZBroadcastConfig);
        if (a.isReady()) {
            m3549h();
            a = m3536c(wOWZBroadcastConfig);
        }
        this.f3614D.set(a);
        return this.f3614D;
    }

    public WOWZStatus startBroadcasting() {
        this.f3633v = 0;
        WOWZStatus i = m3550i();
        if (i.isRunning()) {
            i = m3542e();
        }
        this.f3614D.set(i);
        return this.f3614D;
    }

    public WOWZStatus stopBroadcasting() {
        this.f3614D.setState(4);
        m3546g();
        this.f3635x.waitForState(0);
        this.f3614D.setState(0);
        return this.f3614D;
    }

    /* renamed from: d */
    private void m3540d() {
        synchronized (this.f3622k) {
            if (this.f3623l) {
                WOWZLog.warn(f3604a, "The audio recorder thread is already running.");
                return;
            }
            C42282 r2 = new Runnable() {
                public void run() {
                    Looper.prepare();
                    synchronized (WOWZAudioDevice.this.f3622k) {
                        AudioRecorderHandler unused = WOWZAudioDevice.this.f3624m = new AudioRecorderHandler(WOWZAudioDevice.this);
                        boolean unused2 = WOWZAudioDevice.this.f3623l = true;
                        WOWZAudioDevice.this.f3622k.notify();
                    }
                    Looper.loop();
                    synchronized (WOWZAudioDevice.this.f3622k) {
                        boolean unused3 = WOWZAudioDevice.this.f3623l = false;
                        AudioRecorderHandler unused4 = WOWZAudioDevice.this.f3624m = null;
                        WOWZAudioDevice.this.f3622k.notify();
                    }
                    WOWZAudioDevice.this.f3627p.setState(0);
                }
            };
            new Thread(r2, f3604a + "(PCMRecorder)").start();
            while (!this.f3623l) {
                try {
                    this.f3622k.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private WOWZStatus m3524a(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f3627p.clearLastError();
        if (!this.f3627p.isIdle()) {
            WOWZStatus wOWZStatus = this.f3627p;
            wOWZStatus.setError(new WOWZError("The audio recorder was in the " + WOWZState.toLabel(this.f3627p.getState()) + " state at recorder prep (expected IDLE)."));
            WOWZLog.error(f3604a, this.f3627p.getLastError());
            this.f3627p.setState(0);
            return this.f3627p;
        }
        this.f3627p.setState(1);
        this.f3624m.m3561a((WOWZMediaConfig) wOWZBroadcastConfig);
        this.f3627p.waitForState(2);
        return this.f3627p;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012a A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3533b(com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r22) {
        /*
            r21 = this;
            r1 = r21
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$BroadcastErrorCallback r2 = r22.getErrorCallback()
            com.wowza.gocoder.sdk.support.d.a r0 = r22.getStreamingMonitor()
            r1.f3618H = r0
            int r0 = r22.getAudioChannels()
            int r0 = r0 * 4
            int r0 = r0 * 1024
            int r9 = r0 * 8
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            int r0 = r22.getAudioChannels()
            r11 = 2
            if (r0 != r11) goto L_0x002b
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.add(r0)
        L_0x002b:
            r0 = 16
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.add(r0)
            int r0 = r22.getAudioSampleRate()
            java.util.ArrayList r3 = new java.util.ArrayList
            int[] r4 = f3608e
            int r4 = r4.length
            r3.<init>(r4)
            int[] r4 = f3608e
            int r5 = r4.length
            r12 = 0
            r6 = 0
        L_0x0045:
            if (r6 >= r5) goto L_0x0055
            r7 = r4[r6]
            if (r7 != r0) goto L_0x0052
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.add(r7)
        L_0x0052:
            int r6 = r6 + 1
            goto L_0x0045
        L_0x0055:
            int[] r4 = f3608e
            int r5 = r4.length
            r6 = 0
        L_0x0059:
            if (r6 >= r5) goto L_0x0069
            r7 = r4[r6]
            if (r7 == r0) goto L_0x0066
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.add(r7)
        L_0x0066:
            int r6 = r6 + 1
            goto L_0x0059
        L_0x0069:
            r0 = 0
            r1.f3626o = r0
            java.util.Iterator r13 = r3.iterator()
        L_0x0070:
            boolean r0 = r13.hasNext()
            r14 = 71
            if (r0 == 0) goto L_0x013e
            java.lang.Object r0 = r13.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r15 = r0.intValue()
            short[] r8 = f3609f
            int r7 = r8.length
            r6 = 0
        L_0x0086:
            if (r6 >= r7) goto L_0x0070
            short r5 = r8[r6]
            java.util.Iterator r16 = r10.iterator()
        L_0x008e:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x0134
            java.lang.Object r0 = r16.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r3 = android.media.AudioRecord.getMinBufferSize(r15, r0, r5)     // Catch:{ Exception -> 0x0101 }
            r1.f3629r = r3     // Catch:{ Exception -> 0x0101 }
            int r3 = r1.f3629r     // Catch:{ Exception -> 0x0101 }
            r4 = -2
            if (r3 == r4) goto L_0x00f8
            android.media.AudioRecord r4 = new android.media.AudioRecord     // Catch:{ Exception -> 0x0101 }
            int r3 = r1.f3625n     // Catch:{ Exception -> 0x0101 }
            r17 = r3
            r3 = r4
            r22 = r4
            r4 = r17
            r17 = r5
            r5 = r15
            r18 = r6
            r6 = r0
            r19 = r7
            r7 = r17
            r20 = r8
            r8 = r9
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00f6 }
            int r0 = r22.getState()     // Catch:{ Exception -> 0x00f6 }
            r3 = 1
            if (r0 != r3) goto L_0x00d5
            r0 = r22
            r1.f3626o = r0     // Catch:{ Exception -> 0x00f6 }
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3627p     // Catch:{ Exception -> 0x00f6 }
            r0.setState(r11)     // Catch:{ Exception -> 0x00f6 }
            return
        L_0x00d5:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3627p     // Catch:{ Exception -> 0x00f6 }
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r3 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError     // Catch:{ Exception -> 0x00f6 }
            r3.<init>(r14)     // Catch:{ Exception -> 0x00f6 }
            r0.set(r12, r3)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r0 = f3604a     // Catch:{ Exception -> 0x00f6 }
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3627p     // Catch:{ Exception -> 0x00f6 }
            com.wowza.gocoder.sdk.api.errors.WOWZError r3 = r3.getLastError()     // Catch:{ Exception -> 0x00f6 }
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r3)     // Catch:{ Exception -> 0x00f6 }
            if (r2 == 0) goto L_0x012a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3627p     // Catch:{ Exception -> 0x00f6 }
            com.wowza.gocoder.sdk.api.errors.WOWZError r0 = r0.getLastError()     // Catch:{ Exception -> 0x00f6 }
            r2.onBroadcastError(r0)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x012a
        L_0x00f6:
            r0 = move-exception
            goto L_0x010a
        L_0x00f8:
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            goto L_0x012a
        L_0x0101:
            r0 = move-exception
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
        L_0x010a:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3627p
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r4 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError
            r4.<init>((int) r14, (java.lang.Exception) r0)
            r3.set(r12, r4)
            java.lang.String r0 = f3604a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3627p
            com.wowza.gocoder.sdk.api.errors.WOWZError r3 = r3.getLastError()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r3)
            if (r2 == 0) goto L_0x012a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3627p
            com.wowza.gocoder.sdk.api.errors.WOWZError r0 = r0.getLastError()
            r2.onBroadcastError(r0)
        L_0x012a:
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            goto L_0x008e
        L_0x0134:
            r18 = r6
            r19 = r7
            r20 = r8
            int r6 = r18 + 1
            goto L_0x0086
        L_0x013e:
            android.media.AudioRecord r0 = r1.f3626o
            if (r0 != 0) goto L_0x0162
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3627p
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r3 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError
            r3.<init>(r14)
            r0.set(r12, r3)
            java.lang.String r0 = f3604a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3627p
            com.wowza.gocoder.sdk.api.errors.WOWZError r3 = r3.getLastError()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r3)
            if (r2 == 0) goto L_0x0162
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3627p
            com.wowza.gocoder.sdk.api.errors.WOWZError r0 = r0.getLastError()
            r2.onBroadcastError(r0)
        L_0x0162:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.devices.WOWZAudioDevice.m3533b(com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig):void");
    }

    /* renamed from: e */
    private WOWZStatus m3542e() {
        if (!this.f3627p.isReady()) {
            WOWZStatus wOWZStatus = this.f3627p;
            wOWZStatus.setError(new WOWZError("The audio recorder was in the " + WOWZState.toLabel(this.f3627p.getState()) + " state at recorder start (expected READY)."));
            WOWZLog.error(f3604a, this.f3627p.getLastError());
            this.f3627p.setState(0);
            return this.f3627p;
        }
        this.f3624m.m3560a();
        this.f3627p.waitForState(3);
        return this.f3627p;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m3544f() {
        this.f3626o.startRecording();
        this.f3627p.setState(3);
        Iterator<AudioSampleListener> it = this.f3613C.iterator();
        while (it.hasNext()) {
            it.next().onWZAudioSampleListenerSetup(this.f3615E);
        }
        while (this.f3627p.isRunning()) {
            m3527a(false);
        }
        m3527a(true);
        Iterator<AudioSampleListener> it2 = this.f3613C.iterator();
        while (it2.hasNext()) {
            it2.next().onWZAudioSampleListenerRelease();
        }
        try {
            this.f3626o.stop();
        } catch (Exception e) {
            WOWZLog.error(f3604a, "An exception occurred stopping the audio recorder.", (Throwable) e);
        }
        try {
            this.f3626o.release();
        } catch (Exception e2) {
            WOWZLog.error(f3604a, "An exception occurred releasing the audio recorder.", (Throwable) e2);
        } catch (Throwable th) {
            this.f3626o = null;
            Looper.myLooper().quitSafely();
            throw th;
        }
        this.f3626o = null;
        Looper.myLooper().quitSafely();
    }

    /* renamed from: a */
    private void m3527a(boolean z) {
        WOWZBroadcastAPI.BroadcastErrorCallback errorCallback = this.f3615E.getErrorCallback();
        try {
            ByteBuffer[] inputBuffers = this.f3634w.getInputBuffers();
            int dequeueInputBuffer = this.f3634w.dequeueInputBuffer(f3610g);
            if (dequeueInputBuffer >= 0) {
                byte[] bArr = new byte[this.f3628q];
                int read = this.f3626o.read(bArr, 0, bArr.length);
                if (read != -3) {
                    if (read != -2) {
                        if (this.f3614D.isPaused()) {
                            Arrays.fill(bArr, (byte) 0);
                        }
                        ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                        byteBuffer.clear();
                        byteBuffer.put(bArr);
                        long nanoTime = System.nanoTime();
                        if (this.f3633v == 0) {
                            this.f3633v = nanoTime;
                        }
                        long j = nanoTime - this.f3633v;
                        long j2 = j / 1000;
                        Iterator<AudioSampleListener> it = this.f3613C.iterator();
                        while (it.hasNext()) {
                            AudioSampleListener next = it.next();
                            if (next.isWZAudioSampleListenerEnabled()) {
                                next.onWZAudioSampleRecorded(bArr, bArr.length, j);
                            }
                        }
                        if (z) {
                            this.f3634w.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j2, 4);
                            return;
                        } else {
                            this.f3634w.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j2, 0);
                            return;
                        }
                    }
                }
                String str = f3604a;
                StringBuilder sb = new StringBuilder();
                sb.append(read == -3 ? "Invalid operation" : "Bad value");
                sb.append(" error returned from the audio recorder.");
                WOWZLog.error(str, sb.toString());
            }
        } catch (Exception e) {
            WOWZPlatformError wOWZPlatformError = new WOWZPlatformError(69, e);
            WOWZLog.error(f3604a, (WOWZError) wOWZPlatformError);
            if (errorCallback != null) {
                errorCallback.onBroadcastError(wOWZPlatformError);
            }
            this.f3635x.set(4, wOWZPlatformError);
            this.f3627p.set(4, wOWZPlatformError);
        }
    }

    /* renamed from: g */
    private WOWZStatus m3546g() {
        if (!this.f3627p.isRunning()) {
            String str = f3604a;
            WOWZLog.warn(str, "The audio recorder was in the " + WOWZState.toLabel(this.f3627p.getState()) + " state at recorder stop (expected RUNNING).");
        }
        this.f3627p.setAndWaitForState(4, 0);
        return this.f3627p;
    }

    /* renamed from: h */
    private void m3549h() {
        synchronized (this.f3619h) {
            if (this.f3620i) {
                WOWZLog.warn(f3604a, "The audio encoder thread is already running.");
                return;
            }
            C42293 r2 = new Runnable() {
                public void run() {
                    Looper.prepare();
                    synchronized (WOWZAudioDevice.this.f3619h) {
                        AudioEncoderHandler unused = WOWZAudioDevice.this.f3621j = new AudioEncoderHandler(WOWZAudioDevice.this);
                        boolean unused2 = WOWZAudioDevice.this.f3620i = true;
                        WOWZAudioDevice.this.f3619h.notify();
                    }
                    Looper.loop();
                    synchronized (WOWZAudioDevice.this.f3619h) {
                        boolean unused3 = WOWZAudioDevice.this.f3620i = false;
                        AudioEncoderHandler unused4 = WOWZAudioDevice.this.f3621j = null;
                        WOWZAudioDevice.this.f3619h.notify();
                    }
                    WOWZAudioDevice.this.f3635x.setState(0);
                }
            };
            new Thread(r2, f3604a + "(AACEncoder)").start();
            while (!this.f3620i) {
                try {
                    this.f3619h.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: c */
    private WOWZStatus m3536c(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f3635x.clearLastError();
        if (!this.f3635x.isIdle()) {
            WOWZStatus wOWZStatus = this.f3635x;
            wOWZStatus.setError(new WOWZError("The " + f3604a + " was in the " + WOWZState.toLabel(this.f3635x.getState()) + " state at encoder prep (expected IDLE)."));
            WOWZLog.error(f3604a, this.f3635x.getLastError());
            this.f3635x.setState(0);
            return this.f3635x;
        }
        this.f3635x.setState(1);
        this.f3621j.m3557a((WOWZMediaConfig) wOWZBroadcastConfig);
        this.f3635x.waitForState(2);
        return this.f3635x;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:32|33|34|35|36|(2:39|65)(1:66)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x012d */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3541d(com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r14) {
        /*
            r13 = this;
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI$BroadcastErrorCallback r0 = r14.getErrorCallback()
            android.media.AudioRecord r1 = r13.f3626o
            int r1 = r1.getChannelConfiguration()
            int r1 = r13.m3530b((int) r1)
            int r2 = r13.m3519a((int) r1)
            java.lang.String r3 = "audio/mp4a-latm"
            android.media.MediaCodecInfo[] r4 = com.wowza.gocoder.sdk.api.codec.WOWZCodecUtils.getEncodersForType(r3)
            int r5 = r4.length
            r6 = 62
            r7 = 0
            if (r5 != 0) goto L_0x003f
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r1 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError
            r1.<init>(r6)
            r14.set(r7, r1)
            java.lang.String r14 = f3604a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r1 = r1.getLastError()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r14, (com.wowza.gocoder.sdk.api.errors.WOWZError) r1)
            if (r0 == 0) goto L_0x003e
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r14 = r14.getLastError()
            r0.onBroadcastError(r14)
        L_0x003e:
            return
        L_0x003f:
            int r5 = r1 * 4
            int r5 = r5 * 1024
            int r8 = r5 * 8
            r13.f3628q = r8
            int r8 = r14.getAudioSampleRate()
            r13.f3630s = r8
            int r8 = r13.f3630s
            android.media.AudioRecord r9 = r13.f3626o
            int r9 = r9.getAudioFormat()
            int r8 = android.media.AudioRecord.getMinBufferSize(r8, r2, r9)
            if (r8 >= 0) goto L_0x009d
            java.lang.String r9 = f3604a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Sample rate "
            r10.append(r11)
            int r11 = r13.f3630s
            r10.append(r11)
            java.lang.String r11 = " not supported for audio format: "
            r10.append(r11)
            int r11 = r14.getAudioSampleRate()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.warn((java.lang.String) r9, (java.lang.String) r10)
            int[] r9 = f3608e
            int r10 = r9.length
            r11 = r8
            r8 = 0
        L_0x0084:
            if (r8 >= r10) goto L_0x009c
            r11 = r9[r8]
            android.media.AudioRecord r12 = r13.f3626o
            int r12 = r12.getAudioFormat()
            int r12 = android.media.AudioRecord.getMinBufferSize(r11, r2, r12)
            if (r12 <= 0) goto L_0x0098
            r13.f3630s = r11
            r8 = r12
            goto L_0x009d
        L_0x0098:
            int r8 = r8 + 1
            r11 = r12
            goto L_0x0084
        L_0x009c:
            r8 = r11
        L_0x009d:
            if (r8 >= 0) goto L_0x00c0
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r1 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError
            r1.<init>(r6)
            r14.set(r7, r1)
            java.lang.String r14 = f3604a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r1 = r1.getLastError()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r14, (com.wowza.gocoder.sdk.api.errors.WOWZError) r1)
            if (r0 == 0) goto L_0x00bf
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r14 = r14.getLastError()
            r0.onBroadcastError(r14)
        L_0x00bf:
            return
        L_0x00c0:
            int r2 = r13.f3628q
            if (r2 >= r8) goto L_0x00d0
            int r2 = r8 / r5
            int r9 = r2 * r5
            if (r9 >= r8) goto L_0x00cc
            int r2 = r2 + 1
        L_0x00cc:
            int r2 = r2 * r5
            r13.f3628q = r2
        L_0x00d0:
            android.media.MediaFormat r2 = new android.media.MediaFormat
            r2.<init>()
            java.lang.String r5 = "mime"
            r2.setString(r5, r3)
            r3 = 2
            java.lang.String r5 = "aac-profile"
            r2.setInteger(r5, r3)
            int r5 = r13.f3630s
            java.lang.String r8 = "sample-rate"
            r2.setInteger(r8, r5)
            java.lang.String r5 = "channel-count"
            r2.setInteger(r5, r1)
            int r14 = r14.getAudioBitRate()
            java.lang.String r1 = "bitrate"
            r2.setInteger(r1, r14)
            int r14 = r13.f3628q
            java.lang.String r1 = "max-input-size"
            r2.setInteger(r1, r14)
            int r14 = r4.length
            r1 = 0
        L_0x00fe:
            if (r1 >= r14) goto L_0x0185
            r5 = r4[r1]
            android.media.MediaCodec r8 = r13.f3634w
            if (r8 == 0) goto L_0x0108
            goto L_0x0185
        L_0x0108:
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0158 }
            android.media.MediaCodec r5 = android.media.MediaCodec.createByCodecName(r5)     // Catch:{ Exception -> 0x0158 }
            r13.f3634w = r5     // Catch:{ Exception -> 0x0158 }
            android.media.MediaCodec r5 = r13.f3634w     // Catch:{ Exception -> 0x0158 }
            r8 = 0
            r9 = 1
            r5.configure(r2, r8, r8, r9)     // Catch:{ Exception -> 0x0158 }
            android.media.MediaCodec r5 = r13.f3634w
            if (r5 == 0) goto L_0x0155
            r5.start()     // Catch:{ Exception -> 0x012d }
            android.media.MediaCodec$BufferInfo r5 = new android.media.MediaCodec$BufferInfo     // Catch:{ Exception -> 0x012d }
            r5.<init>()     // Catch:{ Exception -> 0x012d }
            r13.f3637z = r5     // Catch:{ Exception -> 0x012d }
            com.wowza.gocoder.sdk.api.status.WOWZStatus r5 = r13.f3635x     // Catch:{ Exception -> 0x012d }
            r5.setState(r3)     // Catch:{ Exception -> 0x012d }
            goto L_0x0155
        L_0x012d:
            android.media.MediaCodec r14 = r13.f3634w     // Catch:{ Exception -> 0x0132 }
            r14.release()     // Catch:{ Exception -> 0x0132 }
        L_0x0132:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r1 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError
            r2 = 66
            r1.<init>(r2)
            r14.set(r7, r1)
            java.lang.String r14 = f3604a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r1 = r1.getLastError()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r14, (com.wowza.gocoder.sdk.api.errors.WOWZError) r1)
            if (r0 == 0) goto L_0x0154
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r14 = r14.getLastError()
            r0.onBroadcastError(r14)
        L_0x0154:
            return
        L_0x0155:
            int r1 = r1 + 1
            goto L_0x00fe
        L_0x0158:
            android.media.MediaCodec r14 = r13.f3634w
            if (r14 == 0) goto L_0x0162
            r14.release()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0162
        L_0x0161:
        L_0x0162:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r1 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError
            r2 = 64
            r1.<init>(r2)
            r14.set(r7, r1)
            java.lang.String r14 = f3604a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r1 = r1.getLastError()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r14, (com.wowza.gocoder.sdk.api.errors.WOWZError) r1)
            if (r0 == 0) goto L_0x0184
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r14 = r14.getLastError()
            r0.onBroadcastError(r14)
        L_0x0184:
            return
        L_0x0185:
            android.media.MediaCodec r14 = r13.f3634w
            if (r14 != 0) goto L_0x01a9
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZPlatformError r1 = new com.wowza.gocoder.sdk.api.errors.WOWZPlatformError
            r1.<init>(r6)
            r14.set(r7, r1)
            java.lang.String r14 = f3604a
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r1 = r1.getLastError()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r14, (com.wowza.gocoder.sdk.api.errors.WOWZError) r1)
            if (r0 == 0) goto L_0x01a9
            com.wowza.gocoder.sdk.api.status.WOWZStatus r14 = r13.f3635x
            com.wowza.gocoder.sdk.api.errors.WOWZError r14 = r14.getLastError()
            r0.onBroadcastError(r14)
        L_0x01a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.devices.WOWZAudioDevice.m3541d(com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig):void");
    }

    /* renamed from: i */
    private WOWZStatus m3550i() {
        if (!this.f3635x.isReady()) {
            WOWZStatus wOWZStatus = this.f3635x;
            wOWZStatus.setError(new WOWZError("The audio encoder was in the " + WOWZState.toLabel(this.f3635x.getState()) + " state at encoder start (expected READY)."));
            WOWZLog.error(f3604a, this.f3635x.getLastError());
            this.f3635x.setState(0);
            return this.f3635x;
        }
        this.f3621j.m3556a();
        this.f3635x.waitForState(3);
        return this.f3635x;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m3552j() {
        this.f3635x.setState(3);
        while (this.f3635x.isRunning()) {
            m3554k();
        }
        try {
            this.f3634w.stop();
        } catch (Exception e) {
            WOWZLog.error(f3604a, "An exception occurred stopping the audio encoder.", (Throwable) e);
        }
        try {
            this.f3634w.release();
        } catch (Exception e2) {
            WOWZLog.error(f3604a, "An exception occurred releasing the audio encoder.", (Throwable) e2);
        } catch (Throwable th) {
            this.f3634w = null;
            Looper.myLooper().quitSafely();
            throw th;
        }
        this.f3634w = null;
        Looper.myLooper().quitSafely();
    }

    /* renamed from: k */
    private void m3554k() {
        ByteBuffer[] byteBufferArr;
        int i;
        ByteBuffer[] byteBufferArr2;
        ByteBuffer[] outputBuffers = this.f3634w.getOutputBuffers();
        while (true) {
            ByteBuffer[] byteBufferArr3 = outputBuffers;
            while (true) {
                int dequeueOutputBuffer = this.f3634w.dequeueOutputBuffer(this.f3637z, f3610g);
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer == -3) {
                        break;
                    }
                    if (dequeueOutputBuffer == -2) {
                        if (this.f3636y) {
                            WOWZLog.warn(f3604a, "Audio encoder output format changed more than once.");
                        }
                        this.f3636y = true;
                    } else if (dequeueOutputBuffer < 0) {
                        WOWZLog.warn(f3604a, "Unexpected result from audio encoder dequeueOutputBuffer(): " + dequeueOutputBuffer);
                    } else if (dequeueOutputBuffer >= 0) {
                        ByteBuffer byteBuffer = byteBufferArr3[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            WOWZLog.warn(f3604a, "Audio encoder encoderOutputBuffer() " + dequeueOutputBuffer + " returned null.");
                            return;
                        }
                        if ((this.f3637z.flags & 2) != 0) {
                            for (WOWZSinkAPI.AudioSink audioSink : this.f3616F) {
                                if (audioSink instanceof WOWZSinkAPI.MediaCodecAudioSink) {
                                    ((WOWZSinkAPI.MediaCodecAudioSink) audioSink).onAudioFormat(this.f3634w.getOutputFormat());
                                }
                            }
                            this.f3637z.size = 0;
                        }
                        if (this.f3637z.size > 0) {
                            byteBuffer.position(this.f3637z.offset);
                            byteBuffer.limit(this.f3637z.offset + this.f3637z.size);
                            byte[] bArr = new byte[this.f3637z.size];
                            byteBuffer.get(bArr, 0, bArr.length);
                            long j = (this.f3632u * 1000) / ((long) this.f3630s);
                            if (this.f3618H.mo59089c()) {
                                this.f3618H.mo59081a(1, bArr.length);
                            }
                            WOWZSinkAPI.AudioSink[] audioSinkArr = this.f3616F;
                            int length = audioSinkArr.length;
                            int i2 = 0;
                            while (i2 < length) {
                                WOWZSinkAPI.AudioSink audioSink2 = audioSinkArr[i2];
                                if (audioSink2 instanceof WOWZSinkAPI.StreamingAudioSink) {
                                    final WOWZSinkAPI.StreamingAudioSink streamingAudioSink = (WOWZSinkAPI.StreamingAudioSink) audioSink2;
                                    Handler audioSinkHandler = streamingAudioSink.getAudioSinkHandler();
                                    if (audioSinkHandler != null) {
                                        Handler handler = audioSinkHandler;
                                        byteBufferArr2 = byteBufferArr3;
                                        C42304 r7 = r0;
                                        final long j2 = j;
                                        i = i2;
                                        final byte[] bArr2 = bArr;
                                        C42304 r0 = new Runnable() {
                                            public void run() {
                                                WOWZSinkAPI.StreamingAudioSink streamingAudioSink = streamingAudioSink;
                                                long j = j2;
                                                byte[] bArr = bArr2;
                                                streamingAudioSink.onAudioFrame(j, bArr, bArr.length);
                                            }
                                        };
                                        handler.post(r7);
                                    } else {
                                        i = i2;
                                        byteBufferArr2 = byteBufferArr3;
                                    }
                                } else {
                                    i = i2;
                                    byteBufferArr2 = byteBufferArr3;
                                    if (audioSink2 instanceof WOWZSinkAPI.MediaCodecAudioSink) {
                                        ((WOWZSinkAPI.MediaCodecAudioSink) audioSink2).onAudioSample(j, byteBuffer, this.f3637z);
                                    }
                                }
                                i2 = i + 1;
                                byteBufferArr3 = byteBufferArr2;
                            }
                            byteBufferArr = byteBufferArr3;
                            this.f3632u += PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        } else {
                            byteBufferArr = byteBufferArr3;
                        }
                        this.f3634w.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f3637z.flags & 4) != 0) {
                            this.f3635x.setState(4);
                            return;
                        }
                        byteBufferArr3 = byteBufferArr;
                    }
                    byteBufferArr = byteBufferArr3;
                    byteBufferArr3 = byteBufferArr;
                } else {
                    return;
                }
            }
            WOWZLog.warn(f3604a, "Audio encoder output buffers changed.");
            outputBuffers = this.f3634w.getOutputBuffers();
        }
    }

    /* compiled from: GoCoderSDK */
    protected static class AudioEncoderHandler extends Handler {

        /* renamed from: a */
        private static final String f3645a = "AudioEncoderHandler";

        /* renamed from: b */
        private static final int f3646b = 1;

        /* renamed from: c */
        private static final int f3647c = 2;

        /* renamed from: d */
        private WeakReference<WOWZAudioDevice> f3648d;

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3557a(WOWZMediaConfig wOWZMediaConfig) {
            sendMessage(obtainMessage(1, wOWZMediaConfig));
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3556a() {
            sendMessage(obtainMessage(2));
        }

        AudioEncoderHandler(WOWZAudioDevice wOWZAudioDevice) {
            this.f3648d = new WeakReference<>(wOWZAudioDevice);
        }

        public void handleMessage(Message message) {
            WOWZAudioDevice wOWZAudioDevice = (WOWZAudioDevice) this.f3648d.get();
            if (wOWZAudioDevice == null) {
                WOWZLog.error(f3645a, "The reference to the H264Encoder instance is null.");
                return;
            }
            int i = message.what;
            if (i == 1) {
                wOWZAudioDevice.m3541d((WOWZBroadcastConfig) message.obj);
            } else if (i == 2) {
                wOWZAudioDevice.m3552j();
            }
        }
    }

    /* compiled from: GoCoderSDK */
    protected static class AudioRecorderHandler extends Handler {

        /* renamed from: a */
        private static final String f3649a = "AudioRecorderHandler";

        /* renamed from: b */
        private static final int f3650b = 1;

        /* renamed from: c */
        private static final int f3651c = 2;

        /* renamed from: d */
        private WeakReference<WOWZAudioDevice> f3652d;

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3561a(WOWZMediaConfig wOWZMediaConfig) {
            sendMessage(obtainMessage(1, wOWZMediaConfig));
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3560a() {
            sendMessage(obtainMessage(2));
        }

        AudioRecorderHandler(WOWZAudioDevice wOWZAudioDevice) {
            this.f3652d = new WeakReference<>(wOWZAudioDevice);
        }

        public void handleMessage(Message message) {
            WOWZAudioDevice wOWZAudioDevice = (WOWZAudioDevice) this.f3652d.get();
            if (wOWZAudioDevice == null) {
                WOWZLog.error(f3649a, "The reference to the H264Encoder instance is null.");
                return;
            }
            int i = message.what;
            if (i == 1) {
                wOWZAudioDevice.m3533b((WOWZBroadcastConfig) message.obj);
            } else if (i == 2) {
                wOWZAudioDevice.m3544f();
            }
        }
    }
}
