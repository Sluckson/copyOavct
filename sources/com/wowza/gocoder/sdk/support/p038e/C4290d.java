package com.wowza.gocoder.sdk.support.p038e;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.lowagie.text.Annotation;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerView;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.wowza.gocoder.sdk.support.e.d */
/* compiled from: GoCoderSDK */
abstract class C4290d extends C4285b {

    /* renamed from: A */
    public static boolean f4230A = false;

    /* renamed from: B */
    protected static boolean f4231B = false;

    /* renamed from: E */
    public static final int f4232E = 1;

    /* renamed from: F */
    public static int f4233F = 25;

    /* renamed from: G */
    public static long f4234G = 0;

    /* renamed from: H */
    public static long f4235H = 0;

    /* renamed from: I */
    public static long f4236I = 0;

    /* renamed from: J */
    public static long f4237J = 0;

    /* renamed from: K */
    public static long f4238K = 0;

    /* renamed from: L */
    public static boolean f4239L = false;

    /* renamed from: M */
    public static boolean f4240M = false;

    /* renamed from: N */
    public static Object f4241N = new Object();

    /* renamed from: O */
    public static ConcurrentLinkedQueue<C4292a> f4242O = new ConcurrentLinkedQueue<>();

    /* renamed from: P */
    public static ConcurrentLinkedQueue<C4292a> f4243P = new ConcurrentLinkedQueue<>();

    /* renamed from: Q */
    public static ArrayList<C4292a> f4244Q = new ArrayList<>();

    /* renamed from: V */
    private static int f4245V = 20;

    /* renamed from: W */
    private static boolean f4246W = false;

    /* renamed from: X */
    private static boolean f4247X = false;

    /* renamed from: Y */
    private static boolean f4248Y = false;

    /* renamed from: Z */
    private static ArrayList<WOWZPlayerView.PacketThresholdChangeListener> f4249Z = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public static int f4250ae = 0;

    /* renamed from: al */
    private static long f4251al = 0;

    /* renamed from: am */
    private static long f4252am = 0;

    /* renamed from: an */
    private static boolean f4253an = false;

    /* renamed from: ao */
    private static boolean f4254ao = false;

    /* renamed from: i */
    private static final long f4255i = 5000;

    /* renamed from: o */
    public static final int f4256o = 3;

    /* renamed from: u */
    public static Object f4257u = new Object();

    /* renamed from: v */
    public static boolean f4258v = false;

    /* renamed from: C */
    protected boolean f4259C = false;

    /* renamed from: D */
    protected boolean f4260D = true;

    /* renamed from: R */
    protected ConcurrentLinkedQueue<C4294c> f4261R = new ConcurrentLinkedQueue<>();

    /* renamed from: S */
    protected HashMap<Long, C4294c> f4262S = new HashMap<>();

    /* renamed from: T */
    public boolean f4263T = false;

    /* renamed from: U */
    public boolean f4264U = false;

    /* renamed from: aa */
    private int f4265aa = 3;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public C4292a f4266ab = null;

    /* renamed from: ac */
    private long f4267ac = 0;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public Long f4268ad = 0L;

    /* renamed from: af */
    private Future<?> f4269af = null;

    /* renamed from: ag */
    private Future<?> f4270ag = null;

    /* renamed from: ah */
    private Object f4271ah = new Object();
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public final CountDownLatch f4272ai = new CountDownLatch(1);

    /* renamed from: aj */
    private ScheduledThreadPoolExecutor f4273aj = null;

    /* renamed from: ak */
    private ScheduledThreadPoolExecutor f4274ak = null;

    /* renamed from: ap */
    private boolean f4275ap = false;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public int f4276aq = 0;

    /* renamed from: j */
    private MediaCodec.BufferInfo f4277j = null;

    /* renamed from: k */
    MediaCodec f4278k = null;

    /* renamed from: l */
    protected boolean f4279l = false;

    /* renamed from: m */
    Surface f4280m = null;

    /* renamed from: n */
    WOWZStatus f4281n = new WOWZStatus(0);

    /* renamed from: p */
    boolean f4282p = false;

    /* renamed from: q */
    int f4283q = 0;

    /* renamed from: r */
    int f4284r = 0;

    /* renamed from: s */
    public int f4285s = 0;

    /* renamed from: t */
    public long f4286t = 0;

    /* renamed from: w */
    protected long f4287w = 0;

    /* renamed from: x */
    protected long f4288x = 0;

    /* renamed from: y */
    byte[] f4289y;

    /* renamed from: z */
    MediaFormat f4290z;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo59176a(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, int i2, long j5);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59177a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59192a(MediaCodec mediaCodec, ByteBuffer[] byteBufferArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract MediaFormat mo59187b(WOWZMediaConfig wOWZMediaConfig, byte[] bArr);

    /* renamed from: ak */
    static /* synthetic */ int m4035ak() {
        int i = f4250ae;
        f4250ae = i + 1;
        return i;
    }

    /* renamed from: b */
    static /* synthetic */ int m4042b(C4290d dVar) {
        int i = dVar.f4276aq;
        dVar.f4276aq = i + 1;
        return i;
    }

    /* renamed from: ag */
    public int mo59186ag() {
        return this.f4265aa;
    }

    /* renamed from: c */
    public void mo59189c(int i) {
        this.f4265aa = i;
    }

    C4290d() {
    }

    /* renamed from: a */
    public void mo59181a(boolean z) {
        f4248Y = z;
    }

    /* renamed from: b */
    public void mo59188b(int i) {
        if (i >= 0) {
            f4245V = i;
        }
    }

    /* renamed from: a */
    public void mo59179a(WOWZPlayerView.PacketThresholdChangeListener packetThresholdChangeListener) {
        f4249Z.add(packetThresholdChangeListener);
    }

    /* renamed from: af */
    public Surface mo59185af() {
        Surface surface;
        synchronized (this) {
            surface = this.f4280m;
        }
        return surface;
    }

    /* renamed from: a */
    public void mo59178a(Surface surface) {
        if (this.f4281n.isIdle()) {
            synchronized (this) {
                this.f4280m = surface;
            }
            return;
        }
        WOWZLog.warn(mo59137a(), "The output surface cannot be set while the decoder is running");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59191a(int i, long j, byte[] bArr, int i2, ByteBuffer byteBuffer, long j2) {
        int i3 = i;
        byte[] bArr2 = bArr;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (this.f4281n.isIdle()) {
            WOWZLog.debug(mo59137a(), "onInputStream mMediaCodecStatus.isIdle");
            return 3;
        } else if (i3 == -1 || !(bArr2 == null || bArr2.length == 0 || !this.f4281n.isRunning())) {
            this.f4281n.clearLastError();
            int i4 = (i3 == 4 || i3 == 6) ? 2 : 0;
            if (i2 < 0) {
                try {
                    WOWZLog.debug(mo59137a(), "onInputStream inputBufferIndex < 0");
                    return 3;
                } catch (Exception e) {
                    WOWZLog.warn(mo59137a(), "onInputBufferAvailable Exception");
                    this.f4281n.setError(new WOWZError("An exception occurred feeding the decoder input buffer", e));
                    this.f4191f.setError(this.f4281n.getLastError());
                    f4240M = true;
                    WOWZLog.error(mo59137a(), this.f4281n.getLastError(), (Throwable) this.f4281n.getLastError().getException());
                    return -1;
                }
            } else if (i3 == -1) {
                this.f4278k.queueInputBuffer(i2, 0, 0, 0, 4);
                WOWZLog.debug(mo59137a(), "Queued end-of-stream");
                return 4;
            } else if (bArr2 == null) {
                WOWZLog.debug(mo59137a(), "onInputStream no sample buffer");
                return 3;
            } else if (byteBuffer2 != null) {
                byteBuffer.clear();
                byteBuffer2.put(bArr2);
                byteBuffer.flip();
                try {
                    if (this.f4278k == null) {
                        WOWZLog.debug(mo59137a(), "onInputBufferAvailable  mMediaCodec is null");
                    } else if (byteBuffer2 == null) {
                        WOWZLog.debug(mo59137a(), "onInputBufferAvailable  inputBuffer is null");
                    } else {
                        this.f4278k.queueInputBuffer(i2, 0, byteBuffer.limit(), j, i4);
                    }
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    String a = mo59137a();
                    WOWZLog.debug(a, "onInputBufferAvailable  IllegalStateException: " + e2.getMessage());
                } catch (MediaCodec.CryptoException e3) {
                    String a2 = mo59137a();
                    WOWZLog.debug(a2, "onInputBufferAvailable  CryptoException: " + e3.getMessage());
                } catch (Exception e4) {
                    String a3 = mo59137a();
                    WOWZLog.debug(a3, "onInputBufferAvailable  exception: " + e4.getMessage());
                }
                return 4;
            } else {
                WOWZLog.warn(mo59137a(), "onInputBufferAvailable The input buffer dequeued from the decoder was NULL");
                return 3;
            }
        } else {
            WOWZLog.debug(mo59137a(), "onInputStream decoder is shutting down?");
            return 3;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WOWZStatus mo59136a(WOWZMediaConfig wOWZMediaConfig, byte[] bArr) {
        WOWZLog.debug(mo59137a(), "onStartDecoder: START MediaCodecDecoder");
        f4234G = 0;
        f4235H = 0;
        f4237J = 0;
        f4238K = 0;
        f4236I = 0;
        this.f4275ap = false;
        f4239L = false;
        f4240M = false;
        this.f4261R.clear();
        if (this.f4278k != null) {
            try {
                String a = mo59137a();
                WOWZLog.debug(a, "AVQueue: Stopping mediacodec .. in state:" + this.f4281n.getState());
                this.f4278k.stop();
            } catch (Exception e) {
                WOWZLog.error(mo59137a(), "An exception occurred attempting to flush the decoder", (Throwable) e);
            }
            if (!this.f4259C) {
                try {
                    String a2 = mo59137a();
                    WOWZLog.debug(a2, "AVQueue: releasing mediacodec .. in state:" + this.f4281n.getState());
                    this.f4278k.release();
                } catch (Exception e2) {
                    WOWZLog.error(mo59137a(), "An exception occurred attempting to flush the decoder", (Throwable) e2);
                }
            }
        } else {
            this.f4281n.setState(0);
        }
        this.f4277j = null;
        this.f4281n.clearLastError();
        this.f4281n.setState(1);
        if (wOWZMediaConfig != null) {
            this.f4290z = mo59187b(wOWZMediaConfig, bArr);
        }
        if (this.f4290z != null) {
            try {
                this.f4278k = MediaCodec.createDecoderByType(mo59147b());
                String a3 = mo59137a();
                WOWZLog.debug(a3, "MediaCodec decoder (" + this.f4278k.getName() + ") input format = " + this.f4290z.toString());
                if (this.f4290z.getString(Annotation.MIMETYPE).indexOf(MimeTypes.BASE_TYPE_VIDEO) >= 0) {
                    this.f4259C = true;
                    this.f4278k.setCallback(new MediaCodec.Callback() {
                        public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
                            C4292a aVar;
                            if (C4290d.f4231B) {
                                aVar = C4290d.f4242O.peek();
                            } else if (C4290d.f4242O.size() <= 0) {
                                WOWZLog.info("Video waiting for next frame. Queue Size: " + C4290d.f4242O.size());
                                aVar = C4290d.this.f4266ab;
                            } else {
                                aVar = C4290d.f4242O.poll();
                                C4292a unused = C4290d.this.f4266ab = aVar;
                            }
                            if (aVar != null) {
                                if (!C4290d.this.f4282p) {
                                    if (aVar.f4292a != 1) {
                                        C4290d.this.mo59180a("First video frame IS **NOT** a keyframe :(");
                                    } else {
                                        C4290d dVar = C4290d.this;
                                        dVar.f4282p = true;
                                        dVar.mo59180a("Found First video keyframe :)");
                                    }
                                }
                                if (aVar != null) {
                                    try {
                                        ByteBuffer inputBuffer = C4290d.this.f4278k.getInputBuffer(i);
                                        new String(aVar.f4293b);
                                        C4290d.this.f4283q++;
                                        C4290d.this.mo59191a(aVar.f4292a, aVar.f4294c, aVar.f4293b, i, inputBuffer, aVar.f4297f);
                                    } catch (Exception e) {
                                        WOWZLog.debug(C4290d.this.mo59137a(), "[video] onInputBufferAvailable  -> exception: " + e.getMessage() + ":" + aVar.f4292a);
                                    }
                                } else {
                                    try {
                                        WOWZLog.debug(C4290d.this.mo59137a(), "[video] onInputBufferAvailable -> no items in queue to process, send blackframe.");
                                        mediaCodec.queueInputBuffer(i, 0, 0, 0, 0);
                                    } catch (Exception unused2) {
                                        WOWZLog.debug(C4290d.this.mo59137a(), "[video] onInputBufferAvailable ->fake queue input died");
                                    }
                                }
                            } else {
                                WOWZLog.info(C4290d.this.mo59137a(), "[video] onInputBufferAvailable packet was null");
                            }
                        }

                        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
                            C4294c cVar = new C4294c();
                            cVar.f4300a = i;
                            cVar.f4303d = bufferInfo;
                            cVar.f4301b = 0;
                            cVar.f4304e = false;
                            if (C4290d.this.f4286t == bufferInfo.presentationTimeUs) {
                                cVar.f4304e = true;
                                C4290d.m4042b(C4290d.this);
                            }
                            C4290d.this.f4286t = bufferInfo.presentationTimeUs;
                            C4290d dVar = C4290d.this;
                            dVar.f4285s = i;
                            dVar.f4261R.add(cVar);
                            C4290d.this.f4284r++;
                        }

                        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                            String a = C4290d.this.mo59137a();
                            WOWZLog.debug(a, "onError : " + codecException.getMessage());
                        }

                        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                            String a = C4290d.this.mo59137a();
                            WOWZLog.debug(a, "onOutputFormatChanged : " + mediaFormat.getString(Annotation.MIMETYPE));
                            C4290d.this.f4290z = mediaFormat;
                        }
                    });
                }
                if (this.f4259C) {
                    this.f4278k.configure(this.f4290z, this.f4280m, (MediaCrypto) null, 0);
                } else {
                    this.f4278k.configure(this.f4290z, (Surface) null, (MediaCrypto) null, 0);
                }
                this.f4277j = new MediaCodec.BufferInfo();
                this.f4281n.setState(3);
                boolean contains = this.f4290z.getString(Annotation.MIMETYPE).contains(MimeTypes.BASE_TYPE_AUDIO);
                this.f4290z = this.f4290z;
                if (!this.f4259C) {
                    this.f4278k.start();
                    WOWZLog.debug("STARTING VIDEO THREAD mMediaCodec.start!");
                }
                if (!this.f4259C) {
                    mo59201am();
                    WOWZLog.debug("STARTING AUDIO THREAD!");
                } else {
                    WOWZLog.debug("STARTING VIDEO THREAD!");
                    mo59202an();
                }
            } catch (Exception e3) {
                mo59182ac();
                this.f4281n.setError(new WOWZPlatformError(91, e3));
                this.f4191f.setError(this.f4281n.getLastError());
                mo59145ab();
                WOWZLog.error(mo59137a(), this.f4281n.getLastError());
                this.f4281n.setState(0);
            }
        } else {
            mo59182ac();
            this.f4281n.setState(0);
            this.f4191f.setError(this.f4281n.getLastError());
        }
        return this.f4281n;
    }

    /* renamed from: com.wowza.gocoder.sdk.support.e.d$c */
    /* compiled from: GoCoderSDK */
    class C4294c {

        /* renamed from: a */
        public int f4300a;

        /* renamed from: b */
        public long f4301b;

        /* renamed from: c */
        public ByteBuffer f4302c;

        /* renamed from: d */
        public MediaCodec.BufferInfo f4303d;

        /* renamed from: e */
        boolean f4304e;

        C4294c() {
        }
    }

    /* renamed from: a */
    public void mo59180a(String str) {
        if (f4258v) {
            WOWZLog.debug(mo59137a(), str);
        }
    }

    /* renamed from: com.wowza.gocoder.sdk.support.e.d$d */
    /* compiled from: GoCoderSDK */
    class C4295d implements Runnable {
        C4295d() {
        }

        /* renamed from: a */
        private boolean m4075a() {
            if (!Thread.currentThread().isInterrupted() && C4290d.this.f4281n.isRunning()) {
                return false;
            }
            C4290d.this.mo59180a("AVQueue [video] stream has interrupted ...");
            C4290d.this.f4272ai.countDown();
            return true;
        }

        /* renamed from: b */
        private C4294c m4076b() {
            return C4290d.this.f4261R.poll();
        }

        /* renamed from: c */
        private void m4077c() {
            C4290d.f4231B = false;
            Long unused = C4290d.this.f4268ad = 0L;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:63|64|65|66|67|68) */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0381, code lost:
            r0 = false;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0169 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x01a0 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r18 = this;
                r1 = r18
                r18.m4077c()
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                r0.mo59128V()
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r0 = r0.mo59137a()
                java.lang.String r2 = "**** Decoder Starting VideoOutputThread .. "
                com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r0, r2)
            L_0x0015:
                r2 = 5
                java.lang.Thread.sleep(r2)     // Catch:{ Exception -> 0x001a }
            L_0x001a:
                boolean r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4239L
                if (r0 == 0) goto L_0x0015
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r0 = r0.mo59137a()
                java.lang.String r2 = "**** Decoder Stop buffer .. "
                com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r0, r2)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                r0.mo59129W()
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                android.media.MediaCodec r0 = r0.f4278k
                r0.start()
                r2 = 0
                r0 = 0
            L_0x0037:
                r3 = 1
                r5 = 1
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x004a }
                boolean r6 = r18.m4075a()     // Catch:{ Exception -> 0x004a }
                if (r6 != 0) goto L_0x0054
                r6 = 1000(0x3e8, float:1.401E-42)
                if (r0 < r6) goto L_0x0048
                goto L_0x0054
            L_0x0048:
                int r0 = r0 + 1
            L_0x004a:
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r6 = r6.f4261R
                int r6 = r6.size()
                if (r6 < r5) goto L_0x0037
            L_0x0054:
                com.wowza.gocoder.sdk.support.p038e.C4290d.f4230A = r5
            L_0x0056:
                boolean r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4239L
                if (r0 == 0) goto L_0x03e5
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r0.f4281n
                boolean r0 = r0.isRunning()
                if (r0 == 0) goto L_0x03e5
                boolean r0 = r18.m4075a()
                if (r0 == 0) goto L_0x006c
                goto L_0x03e5
            L_0x006c:
                com.wowza.gocoder.sdk.support.e.d$c r0 = r18.m4076b()
                java.lang.String r8 = ", "
                if (r0 == 0) goto L_0x030b
                int unused = com.wowza.gocoder.sdk.support.p038e.C4290d.f4250ae = r2
                android.media.MediaCodec$BufferInfo r9 = r0.f4303d
                int r10 = r0.f4300a
                int r11 = r9.flags
                r11 = r11 & 2
                if (r11 == 0) goto L_0x008e
                java.lang.String r0 = "outputbuffer: BUFFER_FLAG_CODEC_CONFIG"
                com.wowza.gocoder.sdk.api.logging.WOWZLog.info(r0)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                android.media.MediaCodec r0 = r0.f4278k
                r0.releaseOutputBuffer(r10, r2)
                goto L_0x0056
            L_0x008e:
                com.wowza.gocoder.sdk.support.e.d r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                int r11 = r11.f4276aq
                r12 = 10
                com.wowza.gocoder.sdk.support.e.d r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.Long r11 = r11.f4268ad
                long r11 = r11.longValue()
                r13 = 0
                int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r15 == 0) goto L_0x00c5
                com.wowza.gocoder.sdk.support.e.d r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.Long r11 = r11.f4268ad
                long r11 = r11.longValue()
                android.media.MediaCodec$BufferInfo r15 = r0.f4303d
                long r6 = r15.presentationTimeUs
                int r15 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r15 <= 0) goto L_0x00c5
                java.lang.String r0 = "outputbuffer: discarding packet due to seek .... "
                com.wowza.gocoder.sdk.api.logging.WOWZLog.info(r0)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                android.media.MediaCodec r0 = r0.f4278k
                r0.releaseOutputBuffer(r10, r2)
                goto L_0x0056
            L_0x00c5:
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.Long r7 = java.lang.Long.valueOf(r13)
                java.lang.Long unused = r6.f4268ad = r7
                if (r10 < 0) goto L_0x0300
                boolean r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4231B
                if (r6 != 0) goto L_0x02b5
                boolean r6 = r0.f4304e
                if (r6 == 0) goto L_0x00e0
                long r6 = r9.presentationTimeUs
                int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
                if (r11 == 0) goto L_0x00e0
                goto L_0x02b5
            L_0x00e0:
                long r6 = r9.presentationTimeUs
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H
                long r6 = r6 - r11
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4243P
                int r0 = r0.size()
                if (r0 > 0) goto L_0x010c
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.m4039ao()
                java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x00f4 }
            L_0x00f4:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                android.media.MediaCodec r0 = r0.f4278k
                r0.releaseOutputBuffer(r10, r5)
                long r6 = r9.presentationTimeUs
                long r10 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I
                int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
                if (r0 <= 0) goto L_0x0106
                long r6 = r9.presentationTimeUs
                goto L_0x0108
            L_0x0106:
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I
            L_0x0108:
                com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I = r6
                goto L_0x0056
            L_0x010c:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                long r11 = r0.f4288x
                long r11 = r11 + r6
                r0.f4288x = r11
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                long r6 = r0.f4287w
                long r6 = r6 + r3
                r0.f4287w = r6
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x0282 }
                long r11 = r9.presentationTimeUs     // Catch:{ Exception -> 0x0282 }
                int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r0 <= 0) goto L_0x012a
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x0282 }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x0282 }
            L_0x0126:
                long r6 = r6 - r11
                r11 = 500(0x1f4, double:2.47E-321)
                goto L_0x0133
            L_0x012a:
                long r6 = r9.presentationTimeUs     // Catch:{ Exception -> 0x0282 }
                com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I = r6     // Catch:{ Exception -> 0x0282 }
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x0282 }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x0282 }
                goto L_0x0126
            L_0x0133:
                int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r0 < 0) goto L_0x0172
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0282 }
                r0.<init>()     // Catch:{ Exception -> 0x0282 }
                java.lang.String r9 = "+Bad: Video Timestamp[3]: ("
                r0.append(r9)     // Catch:{ Exception -> 0x0282 }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x0282 }
                r0.append(r11)     // Catch:{ Exception -> 0x0282 }
                java.lang.String r9 = " vs "
                r0.append(r9)     // Catch:{ Exception -> 0x0282 }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x0282 }
                r0.append(r11)     // Catch:{ Exception -> 0x0282 }
                java.lang.String r9 = ") Wait time:: ("
                r0.append(r9)     // Catch:{ Exception -> 0x0282 }
                r0.append(r6)     // Catch:{ Exception -> 0x0282 }
                java.lang.String r6 = ")."
                r0.append(r6)     // Catch:{ Exception -> 0x0282 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0282 }
                com.wowza.gocoder.sdk.api.logging.WOWZLog.info(r0)     // Catch:{ Exception -> 0x0282 }
                r6 = 50
                java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x0169 }
            L_0x0169:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x0282 }
                android.media.MediaCodec r0 = r0.f4278k     // Catch:{ Exception -> 0x0282 }
                r0.releaseOutputBuffer(r10, r2)     // Catch:{ Exception -> 0x0282 }
                goto L_0x030b
            L_0x0172:
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x0282 }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x0282 }
                long r16 = com.wowza.gocoder.sdk.support.p038e.C4289c.f4220j     // Catch:{ Exception -> 0x0282 }
                long r11 = r11 - r16
                long r6 = r6 - r11
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025a }
                r0.<init>()     // Catch:{ Exception -> 0x025a }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x025a }
                r0.append(r11)     // Catch:{ Exception -> 0x025a }
                java.lang.String r9 = " vs. "
                r0.append(r9)     // Catch:{ Exception -> 0x025a }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x025a }
                r0.append(r11)     // Catch:{ Exception -> 0x025a }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x025a }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x025a }
                long r16 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x025a }
                long r11 = r11 - r16
                int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r9 <= 0) goto L_0x01d4
            L_0x019d:
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x01a0 }
            L_0x01a0:
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x025a }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x025a }
                long r6 = r6 - r11
                int r9 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
                if (r9 > 0) goto L_0x019d
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4289c.f4219i     // Catch:{ Exception -> 0x025a }
                java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x025a }
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x025a }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025a }
                r7.<init>()     // Catch:{ Exception -> 0x025a }
                java.lang.String r9 = "Timestamp > 0, sleeping for gap time. outputbuffer: "
                r7.append(r9)     // Catch:{ Exception -> 0x025a }
                com.wowza.gocoder.sdk.support.e.d r9 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x025a }
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r9 = r9.f4261R     // Catch:{ Exception -> 0x025a }
                int r9 = r9.size()     // Catch:{ Exception -> 0x025a }
                r7.append(r9)     // Catch:{ Exception -> 0x025a }
                r7.append(r8)     // Catch:{ Exception -> 0x025a }
                r7.append(r0)     // Catch:{ Exception -> 0x025a }
                java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x025a }
                r6.mo59180a((java.lang.String) r0)     // Catch:{ Exception -> 0x025a }
                goto L_0x0279
            L_0x01d4:
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4236I     // Catch:{ Exception -> 0x025a }
                long r16 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4235H     // Catch:{ Exception -> 0x025a }
                long r11 = r11 - r16
                r16 = -50
                java.lang.String r9 = " outputbuffer: "
                int r15 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
                if (r15 > 0) goto L_0x0228
                r11 = 0
                int r12 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
                if (r12 > 0) goto L_0x01f2
                r11 = 1117126656(0x42960000, float:75.0)
                if (r12 >= 0) goto L_0x01ef
                r16 = -1
                long r6 = r6 * r16
            L_0x01ef:
                float r6 = (float) r6
                float r11 = r6 / r11
            L_0x01f2:
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4289c.f4219i     // Catch:{ Exception -> 0x025a }
                long r11 = (long) r11     // Catch:{ Exception -> 0x025a }
                long r6 = r6 - r11
                int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
                if (r11 <= 0) goto L_0x0279
                com.wowza.gocoder.sdk.support.e.d r11 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x025a }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025a }
                r12.<init>()     // Catch:{ Exception -> 0x025a }
                java.lang.String r13 = "Timestamp <=-50, wait : "
                r12.append(r13)     // Catch:{ Exception -> 0x025a }
                r12.append(r6)     // Catch:{ Exception -> 0x025a }
                r12.append(r9)     // Catch:{ Exception -> 0x025a }
                com.wowza.gocoder.sdk.support.e.d r9 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x025a }
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r9 = r9.f4261R     // Catch:{ Exception -> 0x025a }
                int r9 = r9.size()     // Catch:{ Exception -> 0x025a }
                r12.append(r9)     // Catch:{ Exception -> 0x025a }
                r12.append(r8)     // Catch:{ Exception -> 0x025a }
                r12.append(r0)     // Catch:{ Exception -> 0x025a }
                java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x025a }
                r11.mo59180a((java.lang.String) r0)     // Catch:{ Exception -> 0x025a }
                java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x025a }
                goto L_0x0279
            L_0x0228:
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x025a }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025a }
                r7.<init>()     // Catch:{ Exception -> 0x025a }
                java.lang.String r11 = "Timestamp >-50 and <=0, wait : "
                r7.append(r11)     // Catch:{ Exception -> 0x025a }
                long r11 = com.wowza.gocoder.sdk.support.p038e.C4289c.f4219i     // Catch:{ Exception -> 0x025a }
                r7.append(r11)     // Catch:{ Exception -> 0x025a }
                r7.append(r9)     // Catch:{ Exception -> 0x025a }
                com.wowza.gocoder.sdk.support.e.d r9 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x025a }
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r9 = r9.f4261R     // Catch:{ Exception -> 0x025a }
                int r9 = r9.size()     // Catch:{ Exception -> 0x025a }
                r7.append(r9)     // Catch:{ Exception -> 0x025a }
                r7.append(r8)     // Catch:{ Exception -> 0x025a }
                r7.append(r0)     // Catch:{ Exception -> 0x025a }
                java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x025a }
                r6.mo59180a((java.lang.String) r0)     // Catch:{ Exception -> 0x025a }
                long r6 = com.wowza.gocoder.sdk.support.p038e.C4289c.f4219i     // Catch:{ Exception -> 0x025a }
                java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x025a }
                goto L_0x0279
            L_0x025a:
                r0 = move-exception
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x0282 }
                java.lang.String r6 = r6.mo59137a()     // Catch:{ Exception -> 0x0282 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0282 }
                r7.<init>()     // Catch:{ Exception -> 0x0282 }
                java.lang.String r9 = "[Video] Exception: "
                r7.append(r9)     // Catch:{ Exception -> 0x0282 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0282 }
                r7.append(r0)     // Catch:{ Exception -> 0x0282 }
                java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0282 }
                com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r6, r0)     // Catch:{ Exception -> 0x0282 }
            L_0x0279:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x0282 }
                android.media.MediaCodec r0 = r0.f4278k     // Catch:{ Exception -> 0x0282 }
                r0.releaseOutputBuffer(r10, r5)     // Catch:{ Exception -> 0x0282 }
                goto L_0x030b
            L_0x0282:
                r0 = move-exception
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r6 = r6.mo59137a()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r9 = "[Video] OutputBuffer Exception: "
                r7.append(r9)
                java.lang.String r0 = r0.getMessage()
                r7.append(r0)
                java.lang.String r0 = r7.toString()
                com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r6, r0)
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4242O
                r0.clear()
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                android.media.MediaCodec r0 = r0.f4278k
                r0.flush()
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                android.media.MediaCodec r0 = r0.f4278k
                r0.start()
                goto L_0x030b
            L_0x02b5:
                boolean r0 = r0.f4304e
                if (r0 == 0) goto L_0x02f7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r6 = "isDuplicate: true, video queue: "
                r0.append(r6)
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4242O
                int r6 = r6.size()
                r0.append(r6)
                java.lang.String r6 = " :: "
                r0.append(r6)
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4242O
                int r6 = r6.size()
                r0.append(r6)
                r0.append(r8)
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r6 = r6.f4261R
                int r6 = r6.size()
                r0.append(r6)
                r0.append(r8)
                long r6 = r9.presentationTimeUs
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r0)
            L_0x02f7:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                android.media.MediaCodec r0 = r0.f4278k
                r0.releaseOutputBuffer(r10, r2)
                goto L_0x0056
            L_0x0300:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r0 = r0.mo59137a()
                java.lang.String r6 = "Video output buffer index is null"
                com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r0, r6)
            L_0x030b:
                long r6 = java.lang.System.currentTimeMillis()
            L_0x030f:
                long r9 = java.lang.System.currentTimeMillis()
                long r9 = r9 - r6
                boolean r0 = r18.m4075a()
                if (r0 == 0) goto L_0x031b
                goto L_0x0381
            L_0x031b:
                r11 = 500(0x1f4, double:2.47E-321)
                int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r0 < 0) goto L_0x0374
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "[Video] Could not find item after "
                r6.append(r7)
                r6.append(r9)
                java.lang.String r7 = " ms.  Break and try again ... "
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                r0.mo59180a((java.lang.String) r6)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r0 = r0.mo59137a()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Video could not find item after "
                r6.append(r7)
                r6.append(r9)
                java.lang.String r7 = " ms.  Break and try again  mOutputBuffer.size(): "
                r6.append(r7)
                com.wowza.gocoder.sdk.support.e.d r7 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r7 = r7.f4261R
                int r7 = r7.size()
                r6.append(r7)
                java.lang.String r7 = ", numFramesOutputByBuffer: "
                r6.append(r7)
                com.wowza.gocoder.sdk.support.e.d r7 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                int r7 = r7.f4284r
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.wowza.gocoder.sdk.api.logging.WOWZLog.info(r0, r6)
                r0 = 1
                goto L_0x0382
            L_0x0374:
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x0377 }
            L_0x0377:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r0 = r0.f4261R
                int r0 = r0.size()
                if (r0 < r5) goto L_0x030f
            L_0x0381:
                r0 = 0
            L_0x0382:
                if (r0 == 0) goto L_0x0056
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4242O
                int r6 = r6.size()
                r0.append(r6)
                r0.append(r8)
                com.wowza.gocoder.sdk.support.e.d r6 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$c> r6 = r6.f4261R
                int r6 = r6.size()
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                java.lang.String r6 = "TIMESTAMP"
                com.wowza.gocoder.sdk.api.logging.WOWZLog.info(r6, r0)
                com.wowza.gocoder.sdk.support.p038e.C4290d.m4035ak()
                int r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4250ae
                r7 = 3
                if (r0 < r7) goto L_0x0056
                java.lang.String r0 = "Flushing MC .... "
                com.wowza.gocoder.sdk.api.logging.WOWZLog.info(r6, r0)     // Catch:{ Exception -> 0x03c7 }
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x03c7 }
                android.media.MediaCodec r0 = r0.f4278k     // Catch:{ Exception -> 0x03c7 }
                r0.flush()     // Catch:{ Exception -> 0x03c7 }
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x03c7 }
                android.media.MediaCodec r0 = r0.f4278k     // Catch:{ Exception -> 0x03c7 }
                r0.start()     // Catch:{ Exception -> 0x03c7 }
                goto L_0x03e0
            L_0x03c7:
                r0 = move-exception
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Exception with MC reset: "
                r6.append(r7)
                java.lang.String r0 = r0.getMessage()
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0)
            L_0x03e0:
                int unused = com.wowza.gocoder.sdk.support.p038e.C4290d.f4250ae = r2
                goto L_0x0056
            L_0x03e5:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r0 = r0.mo59137a()
                java.lang.String r2 = "**** Decoder Stop MediaCodec .. "
                com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r0, r2)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                r0.mo59129W()
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                r0.m4041aq()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p038e.C4290d.C4295d.run():void");
        }
    }

    /* renamed from: b */
    private void m4045b(String str) {
        mo59180a("[" + str + "] could not resolve back to audio packet, buffer again.");
        f4243P.clear();
        f4242O.clear();
    }

    /* renamed from: am */
    private void mo59201am() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f4273aj;
        if (scheduledThreadPoolExecutor == null) {
            this.f4273aj = new ScheduledThreadPoolExecutor(1);
            this.f4270ag = this.f4273aj.submit(new C4293b());
        } else if (scheduledThreadPoolExecutor.getActiveCount() < 1) {
            this.f4273aj = new ScheduledThreadPoolExecutor(1);
            this.f4270ag = this.f4273aj.submit(new C4293b());
        }
    }

    /* renamed from: an */
    private void mo59202an() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f4274ak;
        if (scheduledThreadPoolExecutor == null) {
            mo59180a("AVQueue: startVideoRunner ");
            this.f4274ak = new ScheduledThreadPoolExecutor(1);
            this.f4274ak.setRemoveOnCancelPolicy(true);
            this.f4269af = this.f4274ak.submit(new C4295d());
        } else if (scheduledThreadPoolExecutor.getActiveCount() < 1) {
            mo59180a("AVQueue: startVideoRunner ");
            this.f4274ak = new ScheduledThreadPoolExecutor(1);
            this.f4274ak.setRemoveOnCancelPolicy(true);
            this.f4269af = this.f4274ak.submit(new C4295d());
        } else {
            mo59180a("AVQueue: startVideoRunner already started ....");
        }
    }

    /* renamed from: U */
    public long mo59127U() {
        if (mo59151f().isIdle()) {
            return 0;
        }
        return System.currentTimeMillis() - mo59169w();
    }

    /* renamed from: com.wowza.gocoder.sdk.support.e.d$b */
    /* compiled from: GoCoderSDK */
    class C4293b implements Runnable {
        C4293b() {
        }

        /* renamed from: a */
        private boolean m4074a() {
            if (!Thread.currentThread().isInterrupted() && C4290d.this.f4281n.isRunning()) {
                return false;
            }
            C4290d.this.mo59180a("AVQueue [audio] stream has interrupted ...");
            C4290d.this.f4272ai.countDown();
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
            if (m4074a() != false) goto L_0x0024;
         */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0122  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01c5  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0112 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0049 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r20 = this;
                r1 = r20
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r2 = "AVQueue [audio] stream has started ..."
                r0.mo59180a((java.lang.String) r2)
            L_0x0009:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x001c }
                java.lang.String r2 = "AVQueue [audio] waiting for started video or stream starting ..."
                r0.mo59180a((java.lang.String) r2)     // Catch:{ Exception -> 0x001c }
                r2 = 10
                java.lang.Thread.sleep(r2)     // Catch:{ Exception -> 0x001c }
                boolean r0 = r20.m4074a()     // Catch:{ Exception -> 0x001c }
                if (r0 == 0) goto L_0x001c
                goto L_0x0024
            L_0x001c:
                boolean r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4239L
                if (r0 == 0) goto L_0x0009
                boolean r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4230A
                if (r0 == 0) goto L_0x0009
            L_0x0024:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x002c }
                android.media.MediaCodec r0 = r0.f4278k     // Catch:{ Exception -> 0x002c }
                r0.flush()     // Catch:{ Exception -> 0x002c }
                goto L_0x0034
            L_0x002c:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0)
            L_0x0034:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r0 = r0.mo59137a()
                java.lang.String r2 = "AVQueue Starting audio thread ... "
                com.wowza.gocoder.sdk.api.logging.WOWZLog.info(r0, r2)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                r2 = 6
                r3 = 0
                byte[] r5 = r0.f4289y
                r0.mo59190a((int) r2, (long) r3, (byte[]) r5)
            L_0x0049:
                boolean r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4239L
                r2 = 0
                if (r0 == 0) goto L_0x01a7
                boolean r0 = r20.m4074a()
                if (r0 == 0) goto L_0x0056
                goto L_0x01a7
            L_0x0056:
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4243P
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x0049
                boolean r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4231B
                if (r0 == 0) goto L_0x006b
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4243P
                java.lang.Object r0 = r0.peek()
                com.wowza.gocoder.sdk.support.e.d$a r0 = (com.wowza.gocoder.sdk.support.p038e.C4290d.C4292a) r0
                goto L_0x0073
            L_0x006b:
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4243P
                java.lang.Object r0 = r0.poll()
                com.wowza.gocoder.sdk.support.e.d$a r0 = (com.wowza.gocoder.sdk.support.p038e.C4290d.C4292a) r0
            L_0x0073:
                int r3 = r0.f4292a
                long r4 = r0.f4294c
                byte[] r6 = r0.f4293b
                long r14 = r0.f4295d
                long r12 = r0.f4296e
                com.wowza.gocoder.sdk.support.e.d r7 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r7 = r7.f4281n
                boolean r7 = r7.isRunning()
                if (r7 == 0) goto L_0x0180
                com.wowza.gocoder.sdk.support.e.d r7 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r7 = r7.f4281n
                r7.clearLastError()
                r10 = 10
                com.wowza.gocoder.sdk.support.e.d r7 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x015b }
                int r3 = r7.mo59190a((int) r3, (long) r4, (byte[]) r6)     // Catch:{ Exception -> 0x015b }
                r4 = -1
                if (r3 != r4) goto L_0x00a1
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x015b }
                java.lang.String r3 = "AVQueue Audio BUFFER_ACTION_ERROR"
                r0.mo59180a((java.lang.String) r3)     // Catch:{ Exception -> 0x015b }
                goto L_0x0049
            L_0x00a1:
                if (r3 != r4) goto L_0x00ab
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x015b }
                java.lang.String r3 = "AVQueue Audio MediaCodec.INFO_TRY_AGAIN_LATER"
                r0.mo59180a((java.lang.String) r3)     // Catch:{ Exception -> 0x015b }
                goto L_0x0049
            L_0x00ab:
                r5 = 4
                if (r3 == r5) goto L_0x00b6
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x015b }
                java.lang.String r3 = "AVQueue Audio != MediaCodec.BUFFER_ACTION_PENDING"
                r0.mo59180a((java.lang.String) r3)     // Catch:{ Exception -> 0x015b }
                goto L_0x0049
            L_0x00b6:
                if (r3 != r5) goto L_0x0152
                r3 = 4
            L_0x00b9:
                r6 = 1
                boolean r7 = r20.m4074a()     // Catch:{ Exception -> 0x00f2 }
                if (r7 == 0) goto L_0x00c3
                r7 = 10
                goto L_0x010f
            L_0x00c3:
                java.util.concurrent.ConcurrentLinkedQueue<com.wowza.gocoder.sdk.support.e.d$a> r7 = com.wowza.gocoder.sdk.support.p038e.C4290d.f4243P     // Catch:{ Exception -> 0x00f2 }
                int r7 = r7.size()     // Catch:{ Exception -> 0x00f2 }
                if (r7 <= r6) goto L_0x00e4
                com.wowza.gocoder.sdk.support.e.d r7 = com.wowza.gocoder.sdk.support.p038e.C4290d.this     // Catch:{ Exception -> 0x00f2 }
                long r8 = r0.f4297f     // Catch:{ Exception -> 0x00f2 }
                r16 = r8
                r8 = r14
                r3 = 10
                r10 = r12
                r18 = r12
                r12 = r16
                int r7 = r7.m4029a((long) r8, (long) r10, (long) r12)     // Catch:{ Exception -> 0x00f2 }
                if (r7 != r4) goto L_0x00e2
                r7 = 10
                goto L_0x0110
            L_0x00e2:
                r3 = r7
                goto L_0x00e6
            L_0x00e4:
                r18 = r12
            L_0x00e6:
                r7 = 10
                if (r3 == r5) goto L_0x00ed
                if (r3 == r6) goto L_0x00ed
                goto L_0x010f
            L_0x00ed:
                r12 = r18
                r10 = 10
                goto L_0x00b9
            L_0x00f2:
                r0 = move-exception
                r7 = 10
                com.wowza.gocoder.sdk.support.e.d r3 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "AVQueue [audio] Error in obtaining drain output buffer: "
                r4.append(r5)
                java.lang.String r0 = r0.getMessage()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3.mo59180a((java.lang.String) r0)
            L_0x010f:
                r6 = 0
            L_0x0110:
                if (r6 == 0) goto L_0x0122
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r3 = "AVQueue [audio] There was a problem with the mediacodec, maybe next packet will be ok?"
                r0.mo59180a((java.lang.String) r3)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r0.f4281n
                r0.setState(r7)
                goto L_0x01a7
            L_0x0122:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r0.f4281n
                com.wowza.gocoder.sdk.api.errors.WOWZError r0 = r0.getLastError()
                if (r0 == 0) goto L_0x0049
                com.wowza.gocoder.sdk.support.p038e.C4290d.f4239L = r2
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "AVQueue [audio] Error mMediaCodecStatus.getLastError() != null: "
                r2.append(r3)
                com.wowza.gocoder.sdk.support.e.d r3 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r3.f4281n
                com.wowza.gocoder.sdk.api.errors.WOWZError r3 = r3.getLastError()
                java.lang.String r3 = r3.toString()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.mo59180a((java.lang.String) r2)
                goto L_0x0049
            L_0x0152:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r2 = "AVQueue inputqueue overwhelmed"
                r0.mo59180a((java.lang.String) r2)
                goto L_0x0049
            L_0x015b:
                r0 = move-exception
                r7 = 10
                com.wowza.gocoder.sdk.support.e.d r3 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "AVQueue Error in obtaining drain input buffer: "
                r4.append(r5)
                java.lang.String r0 = r0.getMessage()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3.mo59180a((java.lang.String) r0)
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r0.f4281n
                r0.setState(r7)
                goto L_0x01a7
            L_0x0180:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r0.f4281n
                boolean r0 = r0.isStopping()
                if (r0 != 0) goto L_0x019e
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r0.f4281n
                boolean r0 = r0.isStopped()
                if (r0 != 0) goto L_0x019e
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r0.f4281n
                boolean r0 = r0.isShutdown()
                if (r0 == 0) goto L_0x0049
            L_0x019e:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r3 = "AVQueue [audio] sees the mediacodec not running ..."
                r0.mo59180a((java.lang.String) r3)
                com.wowza.gocoder.sdk.support.p038e.C4290d.f4239L = r2
            L_0x01a7:
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.lang.String r3 = "AVQueue [audio] stream has exited ..."
                r0.mo59180a((java.lang.String) r3)
                com.wowza.gocoder.sdk.support.p038e.C4290d.f4239L = r2
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                r0.m4041aq()
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.util.concurrent.CountDownLatch r0 = r0.f4272ai
                long r2 = r0.getCount()
                r4 = 1
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 < 0) goto L_0x01ce
                com.wowza.gocoder.sdk.support.e.d r0 = com.wowza.gocoder.sdk.support.p038e.C4290d.this
                java.util.concurrent.CountDownLatch r0 = r0.f4272ai
                r0.countDown()
            L_0x01ce:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p038e.C4290d.C4293b.run():void");
        }
    }

    /* renamed from: com.wowza.gocoder.sdk.support.e.d$a */
    /* compiled from: GoCoderSDK */
    class C4292a {

        /* renamed from: a */
        int f4292a;

        /* renamed from: b */
        byte[] f4293b;

        /* renamed from: c */
        long f4294c;

        /* renamed from: d */
        long f4295d;

        /* renamed from: e */
        long f4296e;

        /* renamed from: f */
        long f4297f;

        C4292a() {
        }
    }

    /* renamed from: b */
    private ConcurrentLinkedQueue<C4292a> m4043b(boolean z) {
        if (z) {
            return f4242O;
        }
        return f4243P;
    }

    /* access modifiers changed from: private */
    /* renamed from: ao */
    public static long m4039ao() {
        return f4251al;
    }

    /* renamed from: b */
    private static void m4044b(long j) {
        long j2 = f4252am;
        if (j > j2) {
            f4251al = j - j2;
            f4252am = j;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59133a(int i, byte[] bArr, long j, long j2, long j3, long j4) {
        C4292a aVar = new C4292a();
        aVar.f4292a = i;
        aVar.f4293b = bArr;
        aVar.f4294c = j;
        aVar.f4295d = j2;
        aVar.f4296e = j3;
        aVar.f4297f = j4;
        boolean z = false;
        boolean z2 = (i == 5 || i == 6) ? false : true;
        if (z2) {
            mo59180a("onProcessBuffer-video::" + j);
            f4253an = true;
        } else {
            mo59180a("onProcessBuffer-audio::" + j);
            f4254ao = true;
            int i2 = 100;
            if (mo59186ag() * 48 <= 100) {
                i2 = mo59186ag() * 48;
            }
            if (f4242O.size() <= 0 && f4243P.size() >= i2 && !f4230A) {
                mo59180a("We have audio packets but no video packets.  Lets play audio only stream.");
                f4230A = true;
                f4239L = true;
            }
        }
        m4044b(j);
        if (f4242O.size() > f4245V) {
            f4239L = true;
        }
        if (!z2) {
            f4234G = j;
        }
        if (z2 && this.f4260D) {
            if (((double) f4242O.size()) > ((double) mo59154i()) * 0.067d) {
                WOWZLog.debug("RESTART: Draining video queue for catchup ... " + f4242O.size());
                new ArrayList();
                Iterator<C4292a> it = f4242O.iterator();
                int i3 = 0;
                int i4 = 0;
                while (it.hasNext()) {
                    if (it.next().f4292a == 1 && f4242O.size() - i4 > 10) {
                        i3++;
                    }
                    i4++;
                }
                if (i3 > 0) {
                    while (true) {
                        C4292a peek = f4242O.peek();
                        int i5 = peek.f4292a;
                        if (peek.f4292a == 1 && i3 - 1 <= 0) {
                            WOWZLog.debug("Draining video found keyframe ... " + f4242O.size());
                            break;
                        } else if (f4242O.size() <= 1) {
                            WOWZLog.debug("Had to break, draining pool too low ... " + f4242O.size());
                            break;
                        } else {
                            WOWZLog.debug("Draining video missing keyframe ... " + f4242O.size());
                            f4242O.remove();
                        }
                    }
                    if (f4243P.size() > 0) {
                        long j5 = aVar.f4294c;
                        while (!z) {
                            C4292a poll = f4243P.poll();
                            WOWZLog.debug("Draining audio [" + poll.f4294c + " vs. " + j5 + "] queue for catchup ... " + f4243P.size());
                            if (j5 - poll.f4294c <= 50 || f4243P.size() <= 0) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        if (f4243P.size() > 1 && f4242O.size() == 0 && f4243P.size() > mo59186ag() * 48) {
            f4243P.clear();
        }
        m4043b(z2).add(aVar);
        if (z2) {
            m4040ap();
        }
        return 1;
    }

    /* renamed from: ap */
    private void m4040ap() {
        if (f4249Z.size() > 0) {
            int size = f4242O.size() + f4243P.size();
            if (f4246W) {
                int i = 0;
                if (f4247X) {
                    boolean z = f4248Y;
                    if (size > f4245V) {
                        f4247X = false;
                        z = true;
                    }
                    if (z) {
                        while (i < f4249Z.size()) {
                            if (!f4247X) {
                                f4249Z.get(i).packetsAboveMinimumThreshold(size);
                            } else {
                                f4249Z.get(i).packetsBelowMinimumThreshold(size);
                            }
                            i++;
                        }
                    }
                } else if (size <= f4245V) {
                    while (i < f4249Z.size()) {
                        f4249Z.get(i).packetsBelowMinimumThreshold(size);
                        i++;
                    }
                    WOWZLog.debug("RESTART: Total Packets Below Threshold: v: " + f4242O.size() + "+ a:" + f4243P.size() + " = " + size);
                    f4247X = true;
                }
            } else if (size > f4245V) {
                f4246W = true;
            }
        }
    }

    /* renamed from: ae */
    public void mo59184ae() {
        WOWZLog.debug("**** Enabling catchup functionality!");
        this.f4260D = true;
    }

    /* renamed from: ad */
    public void mo59183ad() {
        WOWZLog.debug("**** Disabling catchup functionality!");
        this.f4260D = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59190a(int i, long j, byte[] bArr) {
        int i2 = i;
        byte[] bArr2 = bArr;
        if (this.f4281n.isIdle()) {
            WOWZLog.info("AVQueue: mMediaCodecStatus is idle.");
            return 3;
        } else if (i2 == -1 || !(bArr2 == null || bArr2.length == 0 || !this.f4281n.isRunning())) {
            this.f4281n.clearLastError();
            int i3 = (i2 == 4 || i2 == 6) ? 2 : 0;
            try {
                int dequeueInputBuffer = this.f4278k.dequeueInputBuffer(5000);
                if (dequeueInputBuffer < 0) {
                    return -1;
                }
                if (i2 == -1) {
                    mo59180a("AVQueue: feedInputBuffer::Queueing end-of-stream");
                    this.f4278k.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                    mo59180a("AVQueue: feedInputBuffer::Queued end-of-stream");
                    return 4;
                }
                ByteBuffer inputBuffer = this.f4278k.getInputBuffer(dequeueInputBuffer);
                if (inputBuffer != null) {
                    inputBuffer.clear();
                    inputBuffer.put(bArr2);
                    inputBuffer.flip();
                    this.f4278k.queueInputBuffer(dequeueInputBuffer, 0, inputBuffer.limit(), j, i3);
                    return 4;
                }
                WOWZLog.warn(mo59137a(), "AVQueue: The input buffer dequeued from the decoder was NULL");
                return 3;
            } catch (Exception e) {
                this.f4281n.setError(new WOWZError("An exception occurred feeding the decoder input buffer", e));
                this.f4191f.setError(this.f4281n.getLastError());
                f4240M = true;
                mo59180a("AVQueue: ERROR IN Input buffer: " + e.getMessage());
                WOWZLog.error(mo59137a(), this.f4281n.getLastError(), (Throwable) this.f4281n.getLastError().getException());
                return -1;
            }
        } else {
            mo59180a("AVQueue: bufferType returned: " + i2 + " or sampleBuffer == null or length  ==0 or codec status is not running.");
            return 3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m4029a(long j, long j2, long j3) {
        C4290d dVar;
        int i;
        long j4 = j;
        if (this.f4281n.isIdle() || !this.f4281n.isRunning()) {
            return 3;
        }
        this.f4281n.clearLastError();
        try {
            int dequeueOutputBuffer = this.f4278k.dequeueOutputBuffer(this.f4277j, 5000);
            if (dequeueOutputBuffer < 0) {
                dVar = this;
                if (dequeueOutputBuffer == -2) {
                    WOWZLog.debug(mo59137a(), "dequeueOutputBuffer: INFO_OUTPUT_FORMAT_CHANGED");
                    dVar.mo59177a(dVar.f4278k, dVar.f4278k.getOutputFormat());
                    return 4;
                } else if (dequeueOutputBuffer == -3) {
                    dVar.mo59192a(dVar.f4278k, dVar.f4278k.getOutputBuffers());
                    return 4;
                } else {
                    i = -1;
                    if (dequeueOutputBuffer == -1) {
                        return 3;
                    }
                    try {
                        String a = mo59137a();
                        WOWZLog.warn(a, "Unexpected return result (" + dequeueOutputBuffer + ") from dequeueOutputBuffer()");
                        return 3;
                    } catch (Exception e) {
                        e = e;
                        dVar.f4281n.setError(new WOWZError("An exception occurred releasing the video decoder output buffer", e));
                        dVar.f4191f.setError(dVar.f4281n.getLastError());
                        f4240M = true;
                        WOWZLog.error(mo59137a(), dVar.f4281n.getLastError(), (Throwable) dVar.f4281n.getLastError().getException());
                        return i;
                    }
                }
            } else if ((this.f4277j.flags & 4) != 0) {
                mo59180a("Dequeued end-of-stream");
                this.f4278k.releaseOutputBuffer(dequeueOutputBuffer, false);
                mo59180a("Release end-of-stream output buffer");
                return 3;
            } else {
                if (this.f4281n.isRunning()) {
                    if (j4 != -1) {
                        ByteBuffer outputBuffer = this.f4278k.getOutputBuffer(dequeueOutputBuffer);
                        if (outputBuffer != null) {
                            try {
                                outputBuffer.position(this.f4277j.offset);
                                outputBuffer.limit(this.f4277j.offset + this.f4277j.size);
                                long round = (long) Math.round((float) (this.f4277j.presentationTimeUs / 1000));
                                int i2 = this.f4277j.size;
                                return mo59176a(this.f4278k, dequeueOutputBuffer, this.f4277j, outputBuffer, round, mo59134a(round, j4), j, j2, i2, j3);
                            } catch (Exception e2) {
                                e = e2;
                                i = -1;
                                dVar = this;
                                dVar.f4281n.setError(new WOWZError("An exception occurred releasing the video decoder output buffer", e));
                                dVar.f4191f.setError(dVar.f4281n.getLastError());
                                f4240M = true;
                                WOWZLog.error(mo59137a(), dVar.f4281n.getLastError(), (Throwable) dVar.f4281n.getLastError().getException());
                                return i;
                            }
                        } else {
                            try {
                                WOWZLog.warn(mo59137a(), "The output buffer dequeued from the decoder was NULL");
                                dVar = this;
                                try {
                                    dVar.f4278k.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    return 3;
                                } catch (Exception e3) {
                                    e = e3;
                                    i = -1;
                                    dVar.f4281n.setError(new WOWZError("An exception occurred releasing the video decoder output buffer", e));
                                    dVar.f4191f.setError(dVar.f4281n.getLastError());
                                    f4240M = true;
                                    WOWZLog.error(mo59137a(), dVar.f4281n.getLastError(), (Throwable) dVar.f4281n.getLastError().getException());
                                    return i;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                dVar = this;
                                i = -1;
                                dVar.f4281n.setError(new WOWZError("An exception occurred releasing the video decoder output buffer", e));
                                dVar.f4191f.setError(dVar.f4281n.getLastError());
                                f4240M = true;
                                WOWZLog.error(mo59137a(), dVar.f4281n.getLastError(), (Throwable) dVar.f4281n.getLastError().getException());
                                return i;
                            }
                        }
                    }
                }
                dVar = this;
                try {
                    dVar.f4278k.releaseOutputBuffer(dequeueOutputBuffer, false);
                } catch (Exception e5) {
                    dVar.mo59180a("AVQueue: releasing output buffer error: " + e5.getMessage());
                }
                return 4;
            }
        } catch (Exception e6) {
            e = e6;
            dVar = this;
            i = -1;
            dVar.f4281n.setError(new WOWZError("An exception occurred releasing the video decoder output buffer", e));
            dVar.f4191f.setError(dVar.f4281n.getLastError());
            f4240M = true;
            WOWZLog.error(mo59137a(), dVar.f4281n.getLastError(), (Throwable) dVar.f4281n.getLastError().getException());
            return i;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public void mo59193ah() {
        Future<?> future = this.f4270ag;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Exception unused) {
            }
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f4273aj;
        if (scheduledThreadPoolExecutor != null) {
            try {
                scheduledThreadPoolExecutor.shutdown();
                this.f4273aj.awaitTermination(3, TimeUnit.SECONDS);
                this.f4273aj.shutdownNow();
            } catch (Exception unused2) {
            }
            this.f4273aj = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ai */
    public void mo59194ai() {
        Future<?> future = this.f4269af;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Exception unused) {
            }
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f4274ak;
        if (scheduledThreadPoolExecutor != null) {
            try {
                scheduledThreadPoolExecutor.shutdown();
                this.f4274ak.awaitTermination(3, TimeUnit.SECONDS);
                this.f4274ak.shutdownNow();
            } catch (Exception unused2) {
            }
            this.f4274ak = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo59148c() {
        WOWZLog.debug(mo59137a(), "onStopDecoder: Stop MediaCodecDecoder.");
        try {
            if (!this.f4259C) {
                WOWZLog.debug(mo59137a(), "onStopDecoder: Stop shutdownAudioThread.");
                mo59193ah();
            } else {
                WOWZLog.debug(mo59137a(), "onStopDecoder: Stop shutdownVideoThread.");
                mo59194ai();
            }
        } catch (Exception unused) {
        }
        if (this.f4281n.isRunning()) {
            WOWZLog.debug(mo59137a(), "onStopDecoder:mMediaCodecStatus  STOPPING.");
            this.f4281n.setState(4);
            try {
                if (!this.f4259C) {
                    this.f4272ai.await();
                }
            } catch (Exception unused2) {
                WOWZLog.debug(mo59137a(), "AVQueue: Issue signaling end of stream.");
            }
            this.f4281n.getLastError();
            this.f4281n.setState(0);
            mo59182ac();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:2|3|(1:5)|6|7|(1:9)|10|11|(1:13)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[Catch:{ Exception -> 0x0024 }] */
    /* renamed from: aq */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4041aq() {
        /*
            r1 = this;
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f4281n
            com.wowza.gocoder.sdk.api.errors.WOWZError r0 = r0.getLastError()
            if (r0 != 0) goto L_0x0032
            android.media.MediaCodec r0 = r1.f4278k     // Catch:{ Exception -> 0x0016 }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "[video] flush MediaCodec"
            r1.mo59180a((java.lang.String) r0)     // Catch:{ Exception -> 0x0016 }
            android.media.MediaCodec r0 = r1.f4278k     // Catch:{ Exception -> 0x0016 }
            r0.reset()     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            android.media.MediaCodec r0 = r1.f4278k     // Catch:{ Exception -> 0x0024 }
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = "[video] stop MediaCodec"
            r1.mo59180a((java.lang.String) r0)     // Catch:{ Exception -> 0x0024 }
            android.media.MediaCodec r0 = r1.f4278k     // Catch:{ Exception -> 0x0024 }
            r0.stop()     // Catch:{ Exception -> 0x0024 }
        L_0x0024:
            android.media.MediaCodec r0 = r1.f4278k     // Catch:{ Exception -> 0x0032 }
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = "[video] signalEndOfInputStream MediaCodec"
            r1.mo59180a((java.lang.String) r0)     // Catch:{ Exception -> 0x0032 }
            android.media.MediaCodec r0 = r1.f4278k     // Catch:{ Exception -> 0x0032 }
            r0.signalEndOfInputStream()     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            java.lang.String r0 = "[video] stop player"
            r1.mo59180a((java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p038e.C4290d.m4041aq():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ac */
    public void mo59182ac() {
        f4251al = 0;
        this.f4286t = 0;
        f4252am = 0;
        this.f4269af = null;
        f4246W = false;
        this.f4270ag = null;
        if (this.f4278k != null && !this.f4275ap && this.f4281n.isRunning()) {
            try {
                String str = this.f4259C ? MimeTypes.BASE_TYPE_VIDEO : MimeTypes.BASE_TYPE_AUDIO;
                WOWZLog.debug("[video-stop-" + str + "] stop codec");
                this.f4275ap = true;
                try {
                    String a = mo59137a();
                    WOWZLog.debug(a, "[video-stop-" + str + "]: Stopping mediacodec ..");
                    if (!this.f4259C) {
                        if (!this.f4264U && this.f4278k != null) {
                            this.f4264U = true;
                            String a2 = mo59137a();
                            WOWZLog.debug(a2, "[video-stop-" + str + "]: Stopped ..");
                        }
                    }
                    if (this.f4259C) {
                        this.f4278k.stop();
                        String a3 = mo59137a();
                        WOWZLog.debug(a3, "[video-stop-" + str + "]: Stopped ..");
                    }
                } catch (Exception e) {
                    String a4 = mo59137a();
                    WOWZLog.error(a4, "[video-stop-" + str + "] An exception occurred attempting to flush the decoder", (Throwable) e);
                }
            } catch (Exception unused) {
                WOWZLog.debug("[video-stop] codec died");
            }
        }
        try {
            this.f4264U = false;
            this.f4263T = false;
            this.f4261R.clear();
            this.f4262S.clear();
            f4242O.clear();
            f4243P.clear();
            f4239L = false;
        } catch (Exception unused2) {
        }
        this.f4277j = null;
        f4230A = false;
    }
}
