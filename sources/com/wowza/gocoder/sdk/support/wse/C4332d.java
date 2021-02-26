package com.wowza.gocoder.sdk.support.wse;

import com.google.common.base.Ascii;
import com.lowagie.text.html.HtmlTags;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataEvent;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.data.WOWZDataScope;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZStreamingError;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI;
import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.wowza.gocoder.sdk.support.wse.d */
/* compiled from: GoCoderSDK */
public final class C4332d implements WMSTransport.FunctionListener {

    /* renamed from: a */
    protected static final int f4691a = 1;

    /* renamed from: b */
    protected static final int f4692b = 2;

    /* renamed from: c */
    protected static final int f4693c = 3;

    /* renamed from: d */
    protected static final int f4694d = 0;

    /* renamed from: e */
    protected static final int f4695e = 1;

    /* renamed from: f */
    protected static final int f4696f = 2;

    /* renamed from: g */
    protected static final int f4697g = 0;

    /* renamed from: h */
    protected static final int f4698h = 1;

    /* renamed from: i */
    private static final String f4699i = "d";

    /* renamed from: j */
    private static final int f4700j = 8000;

    /* renamed from: k */
    private static final int f4701k = 10240000;

    /* renamed from: l */
    private static final int f4702l = 2;

    /* renamed from: m */
    private static final int f4703m = 512;

    /* renamed from: n */
    private static final int f4704n = 1024;

    /* renamed from: o */
    private static final String f4705o = "Wowza GoCoder SDK/1.0";

    /* renamed from: p */
    private static final String f4706p = "Playback Wowza GoCoder SDK/1.0";

    /* renamed from: A */
    private String f4707A = null;

    /* renamed from: B */
    private String f4708B = null;

    /* renamed from: C */
    private String f4709C = null;

    /* renamed from: D */
    private long f4710D;

    /* renamed from: E */
    private long f4711E;

    /* renamed from: F */
    private long f4712F;

    /* renamed from: G */
    private long f4713G;

    /* renamed from: H */
    private long f4714H;

    /* renamed from: I */
    private int f4715I;

    /* renamed from: J */
    private int f4716J = 4;

    /* renamed from: K */
    private HashMap<String, ArrayList<WOWZDataEvent.EventListener>> f4717K = new HashMap<>();

    /* renamed from: L */
    private HashMap<Integer, WOWZDataEvent.ResultCallback> f4718L = new HashMap<>();

    /* renamed from: M */
    private boolean f4719M = true;

    /* renamed from: N */
    private boolean f4720N = true;

    /* renamed from: q */
    private Socket f4721q;

    /* renamed from: r */
    private int f4722r;

    /* renamed from: s */
    private final AtomicBoolean f4723s = new AtomicBoolean(false);

    /* renamed from: t */
    private WMSTransport f4724t = new WMSTransport(this);

    /* renamed from: u */
    private WOWZBroadcastConfig f4725u = new WOWZBroadcastConfig();

    /* renamed from: v */
    private final AtomicBoolean f4726v = new AtomicBoolean(false);

    /* renamed from: w */
    private WOWZError f4727w = null;

    /* renamed from: x */
    private int f4728x;

    /* renamed from: y */
    private long f4729y;

    /* renamed from: z */
    private int f4730z;

    protected C4332d() {
        m4539z();
    }

    /* renamed from: z */
    private void m4539z() {
        this.f4721q = null;
        this.f4722r = 8000;
        this.f4728x = -1;
        this.f4729y = 0;
        this.f4730z = -1;
        this.f4710D = 0;
        this.f4711E = 0;
        this.f4712F = 0;
        this.f4713G = 0;
        this.f4714H = 0;
        this.f4723s.set(false);
        this.f4726v.set(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59636a(int i) {
        this.f4716J = i;
        int i2 = 4;
        if (i == 1) {
            i2 = 1;
        } else if (i == 2) {
            i2 = 2;
        } else if (i == 3) {
            i2 = 3;
        } else if (i != 5) {
            this.f4716J = 4;
        } else {
            i2 = 5;
        }
        if (this.f4726v.get()) {
            this.f4724t.setLogLevel(i2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59628a() {
        return this.f4716J;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public WMSTransport mo59645b() {
        return this.f4724t;
    }

    /* renamed from: a */
    public void mo59637a(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f4725u.set(wOWZBroadcastConfig);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public WOWZError mo59648c() {
        return mo59635a(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WOWZError mo59635a(boolean z) {
        WOWZError wOWZError = this.f4727w;
        if (wOWZError == null) {
            return null;
        }
        return z ? mo59652d() : new WOWZError(wOWZError);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public WOWZError mo59652d() {
        WOWZError wOWZError = this.f4727w;
        WOWZError wOWZError2 = wOWZError != null ? new WOWZError(wOWZError) : null;
        this.f4727w = null;
        return wOWZError2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0206, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0207, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0209, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0227, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0228, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x022a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0248, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0249, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x024b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00f1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f2, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0112, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0113, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0115, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0133, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0134, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0136, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0157, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0158, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x017b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x017c, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x019d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x019e, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c1, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c3, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e4, code lost:
        r8.f4721q = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e6, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:105:0x01ff] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:115:0x0220] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:125:0x0241] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:20:0x00eb] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:31:0x010c] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:42:0x012d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:53:0x0150] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:64:0x0174] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:75:0x0196] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:85:0x01b9] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x00c3, B:95:0x01dc] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x01e7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x020a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:120:0x022b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x01a1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x01c4 */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:6:0x00c3] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:80:0x01a1=Splitter:B:80:0x01a1, B:90:0x01c4=Splitter:B:90:0x01c4, B:100:0x01e7=Splitter:B:100:0x01e7, B:110:0x020a=Splitter:B:110:0x020a, B:120:0x022b=Splitter:B:120:0x022b} */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo59653e() {
        /*
            r8 = this;
            java.lang.String r0 = "**************************************"
            r8.mo59652d()
            r1 = 0
            r8.f4710D = r1
            r8.f4711E = r1
            r8.f4712F = r1
            r1 = 0
            r8.f4721q = r1
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.f4723s
            r3 = 0
            r2.set(r3)
            r2 = 48
            r3 = 1
            r4 = 52
            javax.net.SocketFactory r5 = javax.net.SocketFactory.getDefault()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.net.Socket r5 = r5.createSocket()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r8.f4721q = r5     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r5 = f4699i     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r5, r0)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r5 = f4699i     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r6.<init>()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r7 = "Host: "
            r6.append(r7)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r7 = r8.f4725u     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r7 = r7.getHostAddress()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r6.append(r7)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r6 = r6.toString()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r5, r6)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r5 = f4699i     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r6.<init>()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r7 = "Application: "
            r6.append(r7)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r7 = r8.f4725u     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r7 = r7.getApplicationName()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r6.append(r7)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r6 = r6.toString()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r5, r6)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r5 = f4699i     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r6.<init>()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r7 = "Stream: "
            r6.append(r7)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r7 = r8.f4725u     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r7 = r7.getStreamName()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r6.append(r7)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r6 = r6.toString()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r5, r6)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r5 = f4699i     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r5, r0)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.net.Socket r0 = r8.f4721q     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r6 = r8.f4725u     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.lang.String r6 = r6.getHostAddress()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r7 = r8.f4725u     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            int r7 = r7.getPortNumber()     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r5.<init>(r6, r7)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r6 = 8000(0x1f40, float:1.121E-41)
            r0.connect(r5, r6)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r0.set(r3)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.net.Socket r0 = r8.f4721q     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r0.setSoTimeout(r6)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r8.f4722r = r6     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.net.Socket r0 = r8.f4721q     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r0.setTcpNoDelay(r3)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.net.Socket r0 = r8.f4721q     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            r5 = 10240000(0x9c4000, float:1.4349296E-38)
            r0.setSendBufferSize(r5)     // Catch:{ NoRouteToHostException -> 0x022b, UnknownHostException -> 0x020a, PortUnreachableException -> 0x01e7, ConnectException -> 0x01c4, SocketTimeoutException -> 0x01a1, SocketException -> 0x017f, IOException -> 0x015b, SecurityException -> 0x0137, IllegalArgumentException -> 0x0116, IllegalBlockingModeException -> 0x00f5, Exception -> 0x00d4 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x00cd:
            r8.f4721q = r1
            goto L_0x024c
        L_0x00d1:
            r0 = move-exception
            goto L_0x0254
        L_0x00d4:
            r0 = move-exception
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r2 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r2     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x00f1 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x00f1 }
            goto L_0x00cd
        L_0x00f1:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x00f5:
            r0 = move-exception
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r2 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r2     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x0112 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x0112 }
            goto L_0x00cd
        L_0x0112:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x0116:
            r0 = move-exception
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r2 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r2     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x0133 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x0133 }
            goto L_0x00cd
        L_0x0133:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x0137:
            r0 = move-exception
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r2 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r4 = 50
            r2.<init>(r4, r0)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r2     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x0157 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x0157 }
            goto L_0x00cd
        L_0x0157:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x015b:
            r0 = move-exception
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r2 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r4 = 51
            r2.<init>(r4, r0)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r2     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x017b }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x017b }
            goto L_0x00cd
        L_0x017b:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x017f:
            r0 = move-exception
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r2 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r2     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x019d }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x019d }
            goto L_0x00cd
        L_0x019d:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x01a1:
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r0 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r2 = 49
            r0.<init>(r2)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r0     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x01c0 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x01c0 }
            goto L_0x00cd
        L_0x01c0:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x01c4:
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r0 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r2 = 60
            r0.<init>(r2)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r0     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x01e3 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x01e3 }
            goto L_0x00cd
        L_0x01e3:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x01e7:
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r0 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r2 = 9
            r0.<init>(r2)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r0     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x0206 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x0206 }
            goto L_0x00cd
        L_0x0206:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x020a:
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r0 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r0.<init>(r2)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r0     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x0227 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x0227 }
            goto L_0x00cd
        L_0x0227:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x022b:
            com.wowza.gocoder.sdk.api.errors.WOWZStreamingError r0 = new com.wowza.gocoder.sdk.api.errors.WOWZStreamingError     // Catch:{ all -> 0x00d1 }
            r0.<init>(r2)     // Catch:{ all -> 0x00d1 }
            r8.f4727w = r0     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x024c
            java.lang.String r0 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r2 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r0, (com.wowza.gocoder.sdk.api.errors.WOWZError) r2)
            java.net.Socket r0 = r8.f4721q     // Catch:{ Exception -> 0x00cd, all -> 0x0248 }
            r0.close()     // Catch:{ Exception -> 0x00cd, all -> 0x0248 }
            goto L_0x00cd
        L_0x0248:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x024c:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f4723s
            boolean r0 = r0.get()
            r0 = r0 ^ r3
            return r0
        L_0x0254:
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.f4723s
            boolean r2 = r2.get()
            if (r2 != 0) goto L_0x026f
            java.lang.String r2 = f4699i
            com.wowza.gocoder.sdk.api.errors.WOWZError r3 = r8.f4727w
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r2, (com.wowza.gocoder.sdk.api.errors.WOWZError) r3)
            java.net.Socket r2 = r8.f4721q     // Catch:{ Exception -> 0x026d, all -> 0x0269 }
            r2.close()     // Catch:{ Exception -> 0x026d, all -> 0x0269 }
            goto L_0x026d
        L_0x0269:
            r0 = move-exception
            r8.f4721q = r1
            throw r0
        L_0x026d:
            r8.f4721q = r1
        L_0x026f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wse.C4332d.mo59653e():int");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo59656f() {
        return this.f4723s.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo59657g() {
        try {
            if (this.f4723s.get()) {
                this.f4721q.close();
                this.f4723s.set(false);
            }
        } catch (Exception e) {
            WOWZLog.error(f4699i, "An exception occurred closing the broadcast connection socket", (Throwable) e);
        } catch (Throwable th) {
            m4539z();
            throw th;
        }
        m4539z();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo59658h() {
        return this.f4726v.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo59642b(int i) {
        return this.f4724t.closeStream(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public int mo59659i() {
        int i;
        if (!this.f4726v.get() || (i = this.f4728x) == -1) {
            return 1;
        }
        return mo59642b(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo59649c(int i) {
        if (this.f4726v.get()) {
            this.f4724t.closeSession(i);
            this.f4724t.destroySession();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo59660j() {
        mo59649c(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo59661k() {
        mo59659i();
        mo59660j();
        mo59657g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public int mo59662l() {
        if (this.f4726v.get()) {
            return this.f4724t.getSessionState();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo59651d(int i) {
        if (this.f4726v.get()) {
            return this.f4724t.streamGetState(i);
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public int mo59663m() {
        int i = this.f4728x;
        if (i != -1) {
            return mo59651d(i);
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public WOWZDataMap mo59664n() {
        if (!this.f4726v.get()) {
            return null;
        }
        if (this.f4730z == 0) {
            return this.f4725u.getStreamMetadata();
        }
        return this.f4724t.getStreamMetadata();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public long mo59665o() {
        if (this.f4726v.get()) {
            return this.f4724t.getTotalBytesRead();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public long mo59668p() {
        if (this.f4726v.get()) {
            return this.f4724t.getTotalBytesWritten();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public long mo59669q() {
        if (this.f4726v.get()) {
            return this.f4724t.getTotalBytesPending();
        }
        return 0;
    }

    /* renamed from: r */
    public long mo59670r() {
        return this.f4710D;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public long mo59671s() {
        if (this.f4726v.get()) {
            return System.currentTimeMillis() - this.f4729y;
        }
        return 0;
    }

    /* renamed from: t */
    public long mo59672t() {
        return this.f4712F;
    }

    /* renamed from: u */
    public long mo59673u() {
        return this.f4711E;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59629a(int i, long j) {
        mo59652d();
        this.f4726v.set(false);
        this.f4728x = -1;
        this.f4729y = 0;
        this.f4713G = 0;
        this.f4715I = -1;
        if (this.f4724t.newSession()) {
            this.f4726v.set(true);
            mo59636a(this.f4716J);
            this.f4724t.setConnectionFlashVersion(i == 0 ? f4705o : f4706p);
            this.f4724t.setDirection(i);
            this.f4729y = System.currentTimeMillis();
            this.f4724t.setConnectionURL(this.f4725u.getConnectionURL());
            if (this.f4725u.getUsername() != null) {
                this.f4724t.setAuthUserName(this.f4725u.getUsername());
            }
            if (this.f4725u.getPassword() != null) {
                this.f4724t.setAuthPassword(this.f4725u.getPassword());
            }
            String str = this.f4709C;
            if (str != null) {
                this.f4724t.setAuthSalt(str);
                this.f4709C = null;
            }
            String str2 = this.f4707A;
            if (str2 != null) {
                this.f4724t.setAuthChallenge(str2);
                this.f4707A = null;
            }
            String str3 = this.f4708B;
            if (str3 != null) {
                this.f4724t.setAuthOpaque(str3);
                this.f4708B = null;
            }
            this.f4728x = this.f4724t.addStream();
            int i2 = this.f4728x;
            if (i2 >= 0) {
                this.f4724t.streamSetStreamName(i2, this.f4725u.getStreamName());
                if (j != 0 && this.f4730z == 1) {
                    this.f4724t.streamSetPlayStart(this.f4728x, j);
                }
            }
        }
        if (this.f4728x >= 0) {
            return 0;
        }
        this.f4727w = m4538g(3);
        WOWZLog.error(f4699i, this.f4727w);
        return 1;
    }

    /* renamed from: b */
    public void mo59647b(boolean z) {
        WOWZLog.debug("****** IS VIDEO ENABLED: " + z);
        this.f4719M = z;
    }

    /* renamed from: c */
    public void mo59650c(boolean z) {
        WOWZLog.debug("****** IS Audio ENABLED: " + z);
        this.f4720N = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int mo59674v() {
        WOWZLog.debug("******[FPS] WOWZClient: " + this.f4725u.getVideoFramerate());
        if (this.f4719M) {
            m4530A();
        }
        if (this.f4720N) {
            m4531B();
        }
        WOWZDataMap streamMetadata = this.f4725u.getStreamMetadata();
        if (streamMetadata != null && streamMetadata.size() > 0 && this.f4730z == 0) {
            this.f4724t.streamSetOnMetaDataExtra(this.f4728x, streamMetadata);
        }
        if (this.f4724t.prepareSession() == 0) {
            return 0;
        }
        this.f4727w = m4538g(2);
        WOWZLog.error(f4699i, this.f4727w);
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59631a(int i, WOWZPlayerAPI.WZVideoStreamReceiver wZVideoStreamReceiver, WOWZPlayerAPI.WZAudioStreamReceiver wZAudioStreamReceiver) {
        return mo59630a(i, 0, wZVideoStreamReceiver, wZAudioStreamReceiver);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo59630a(int r16, long r17, com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI.WZVideoStreamReceiver r19, com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI.WZAudioStreamReceiver r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r0.f4730z = r1
            if (r1 != 0) goto L_0x000a
            r2 = 200(0xc8, float:2.8E-43)
            goto L_0x000c
        L_0x000a:
            r2 = 400(0x190, float:5.6E-43)
        L_0x000c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "******[FPS] WOWZClient2: "
            r3.append(r4)
            com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig r4 = r0.f4725u
            int r4 = r4.getVideoFramerate()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r3)
            r15.mo59652d()
            r3 = 0
            r4 = -1
            r4 = 0
            r5 = -1
        L_0x002d:
            int r6 = r15.mo59653e()
            r7 = 2
            if (r6 != 0) goto L_0x008c
            int r6 = r15.mo59629a((int) r16, (long) r17)
            if (r6 != 0) goto L_0x007f
            int r6 = r15.mo59674v()
            if (r6 != 0) goto L_0x007f
            int r5 = r15.mo59663m()
            long r8 = java.lang.System.currentTimeMillis()
        L_0x0048:
            r10 = 100
            if (r5 != r10) goto L_0x007f
            if (r6 != 0) goto L_0x007f
            long r10 = java.lang.System.currentTimeMillis()
            long r10 = r10 - r8
            r12 = 30000(0x7530, double:1.4822E-319)
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x005c
            int r4 = r4 + 1
            goto L_0x007f
        L_0x005c:
            r6 = 3
            int r6 = r15.mo59655f(r6)
            if (r6 != 0) goto L_0x0076
            r10 = r19
            r11 = r20
            int r6 = r15.mo59633a((com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI.WZVideoStreamReceiver) r10, (com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI.WZAudioStreamReceiver) r11)
            if (r6 != 0) goto L_0x007a
            int r6 = r15.mo59676x()
            if (r6 != r7) goto L_0x007a
            int r4 = r4 + 1
            goto L_0x0083
        L_0x0076:
            r10 = r19
            r11 = r20
        L_0x007a:
            int r5 = r15.mo59663m()
            goto L_0x0048
        L_0x007f:
            r10 = r19
            r11 = r20
        L_0x0083:
            if (r6 == 0) goto L_0x0090
            r15.mo59660j()
            r15.mo59657g()
            goto L_0x0090
        L_0x008c:
            r10 = r19
            r11 = r20
        L_0x0090:
            r8 = 1
            if (r4 >= r7) goto L_0x0097
            if (r5 == r2) goto L_0x0097
            if (r6 != r8) goto L_0x002d
        L_0x0097:
            if (r4 < r7) goto L_0x00a1
            r1 = 4
            com.wowza.gocoder.sdk.api.errors.WOWZError r1 = r15.m4538g(r1)
            r0.f4727w = r1
            return r8
        L_0x00a1:
            if (r5 != r2) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r3 = 1
        L_0x00a5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wse.C4332d.mo59630a(int, long, com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI$WZVideoStreamReceiver, com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI$WZAudioStreamReceiver):int");
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo59654e(int i) {
        return mo59631a(i, (WOWZPlayerAPI.WZVideoStreamReceiver) null, (WOWZPlayerAPI.WZAudioStreamReceiver) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59641a(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            this.f4724t.streamSetVideoNALSPS(this.f4728x, bArr, bArr.length);
        }
        if (bArr2.length > 0) {
            this.f4724t.streamSetVideoNALPPS(this.f4728x, bArr2, bArr2.length);
        }
    }

    /* renamed from: A */
    private void m4530A() {
        this.f4724t.streamSetVideoCodecId(this.f4728x, 7);
        WOWZSize wOWZSize = new WOWZSize(this.f4725u.getVideoFrameSize());
        this.f4724t.streamSetVideoFrameSize(this.f4728x, wOWZSize.width, wOWZSize.height);
        this.f4724t.streamSetVideoDisplaySize(this.f4728x, wOWZSize.width, wOWZSize.height);
        this.f4724t.streamSetVideoFrameRate(this.f4728x, (double) this.f4725u.getVideoFramerate());
        this.f4724t.streamSetVideoDataRate(this.f4728x, this.f4725u.getVideoBitRate() * 1000);
    }

    /* renamed from: B */
    private void m4531B() {
        this.f4724t.streamSetAudioCodecId(this.f4728x, 10);
        this.f4724t.streamSetAudioAACObjectType(this.f4728x, 2);
        this.f4724t.streamSetAudioChannels(this.f4728x, this.f4725u.getAudioChannels());
        this.f4724t.streamSetAudioSampleRate(this.f4728x, this.f4725u.getAudioSampleRate());
        this.f4724t.streamSetAudioDataRate(this.f4728x, this.f4725u.getAudioBitRate());
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo59655f(int i) {
        mo59652d();
        try {
            OutputStream outputStream = this.f4721q.getOutputStream();
            int messagesToWriteLen = this.f4724t.getMessagesToWriteLen();
            while (messagesToWriteLen > 0) {
                byte[] messagesToWrite = this.f4724t.getMessagesToWrite();
                if (messagesToWrite != null) {
                    outputStream.write(messagesToWrite, 0, messagesToWriteLen);
                    this.f4710D += (long) messagesToWriteLen;
                    if (this.f4725u.getStreamingMonitor() != null && this.f4725u.getStreamingMonitor().mo59089c()) {
                        this.f4725u.getStreamingMonitor().mo59086b(i, messagesToWriteLen);
                    }
                    if (this.f4724t.incrementMessageBytesWritten(messagesToWriteLen) != 0) {
                        this.f4727w = m4537b("An error occurred incrementing the message bytes written");
                        WOWZLog.error(f4699i, this.f4727w);
                        return 1;
                    }
                    messagesToWriteLen = this.f4724t.getMessagesToWriteLen();
                } else {
                    WOWZLog.warn(f4699i, "The length of the session messages to write was " + messagesToWriteLen + " but the message buffer returned had a length of 0");
                }
            }
            return 0;
        } catch (Exception e) {
            this.f4727w = m4534a(53, e);
            WOWZLog.error(f4699i, this.f4727w);
            return 1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public int mo59675w() {
        return mo59633a((WOWZPlayerAPI.WZVideoStreamReceiver) null, (WOWZPlayerAPI.WZAudioStreamReceiver) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59633a(WOWZPlayerAPI.WZVideoStreamReceiver wZVideoStreamReceiver, WOWZPlayerAPI.WZAudioStreamReceiver wZAudioStreamReceiver) {
        mo59652d();
        try {
            InputStream inputStream = this.f4721q.getInputStream();
            while (inputStream.available() > 0) {
                int inputBufferSize = this.f4724t.getInputBufferSize();
                if (inputBufferSize > 0) {
                    byte[] bArr = new byte[inputBufferSize];
                    int read = inputStream.read(bArr, 0, inputBufferSize);
                    if (read > 0) {
                        this.f4724t.setInputBuffer(bArr, read);
                        if (this.f4724t.parseBytes(read, wZVideoStreamReceiver, wZAudioStreamReceiver) != 0) {
                            this.f4727w = m4537b("An error occurred parsing the session message received");
                            WOWZLog.error(f4699i, this.f4727w);
                            return 1;
                        }
                    } else if (read < 0) {
                        this.f4727w = m4537b("The parsed session message byte size was < 0");
                        WOWZLog.error(f4699i, this.f4727w);
                        return 1;
                    }
                    if (mo59669q() > 0) {
                        mo59655f(3);
                        continue;
                    }
                    if (read <= 0) {
                        return 0;
                    }
                } else {
                    this.f4727w = m4537b("The session input buffer size was <= 0");
                    WOWZLog.error(f4699i, this.f4727w);
                    return 1;
                }
            }
            return 0;
        } catch (Exception e) {
            WOWZLog.info("Exception in read function : " + e.getMessage());
            this.f4727w = m4534a(54, e);
            WOWZLog.error(f4699i, this.f4727w);
            return 1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public int mo59676x() {
        int l = mo59662l();
        int sessionError = this.f4724t.getSessionError();
        String sessionErrorDescription = sessionError != 0 ? this.f4724t.getSessionErrorDescription() : null;
        int m = mo59663m();
        if (m != this.f4715I) {
            if (m == 100) {
                this.f4713G = System.currentTimeMillis();
            }
            this.f4715I = m;
        }
        this.f4724t.clearError();
        if (l == 201) {
            this.f4709C = this.f4724t.getAuthSalt(512);
            this.f4707A = this.f4724t.getAuthChallenge(512);
            this.f4708B = this.f4724t.getAuthOpaque(512);
            WOWZLog.info(f4699i, "Session authentication is required, reconnecting");
            return 2;
        } else if (l == 203) {
            this.f4727w = new WOWZStreamingError(57);
            WOWZLog.error(f4699i, this.f4727w);
            return 1;
        } else if (l == 210) {
            StringBuffer stringBuffer = new StringBuffer();
            this.f4724t.getRedirectURL(stringBuffer, 1024);
            if (m4536a(stringBuffer.toString()).booleanValue()) {
                String str = f4699i;
                WOWZLog.info(str, "Session redirect URI returned, reconnecting to " + stringBuffer.toString());
                return 2;
            }
            this.f4727w = new WOWZStreamingError(58);
            WOWZLog.error(f4699i, this.f4727w);
            return 1;
        } else if (sessionError != 0) {
            this.f4727w = mo59634a(sessionError, sessionErrorDescription);
            WOWZLog.error(f4699i, this.f4727w);
            return 1;
        } else if (m == 100 || m == 200) {
            return 0;
        } else {
            if (m == 230) {
                this.f4727w = m4538g(67);
                WOWZLog.error(f4699i, this.f4727w);
                return 1;
            } else if (m != 300) {
                if (m == 400 || m != 401) {
                    return 0;
                }
                this.f4727w = m4538g(66);
                WOWZLog.error(f4699i, this.f4727w);
                return 1;
            } else if (this.f4730z != 1) {
                return 0;
            } else {
                this.f4727w = m4538g(68);
                WOWZLog.error(f4699i, this.f4727w);
                return 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo59632a(long j, byte[] bArr, int i, int i2) {
        if (j > this.f4714H) {
            this.f4714H = j;
        }
        if (this.f4724t.streamAddVideoFrame(this.f4728x, j, j, m4533a(bArr), bArr, i) != 0) {
            this.f4727w = new WOWZStreamingError(14);
            return 1;
        }
        int a = m4532a(0, i2);
        if (a == 0) {
            this.f4711E++;
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo59643b(long j, byte[] bArr, int i, int i2) {
        if (j > this.f4714H) {
            this.f4714H = j;
        }
        if (this.f4724t.streamAddAudioFrame(this.f4728x, j, bArr, i) != 0) {
            this.f4727w = new WOWZStreamingError(15);
            return 1;
        }
        int a = m4532a(1, i2);
        if (a == 0) {
            this.f4712F++;
        }
        return a;
    }

    /* renamed from: a */
    private int m4532a(int i, int i2) {
        if (this.f4722r != i2) {
            try {
                this.f4721q.setSoTimeout(i2);
                this.f4722r = i2;
            } catch (SocketException e) {
                this.f4727w = new WOWZStreamingError(52, e);
                return 1;
            }
        }
        if (mo59655f(i) == 0 && mo59675w() == 0 && mo59676x() == 0) {
            return 0;
        }
        return 1;
    }

    /* renamed from: b */
    public int mo59644b(WOWZPlayerAPI.WZVideoStreamReceiver wZVideoStreamReceiver, WOWZPlayerAPI.WZAudioStreamReceiver wZAudioStreamReceiver) {
        if (mo59633a(wZVideoStreamReceiver, wZAudioStreamReceiver) == 0) {
            return mo59676x();
        }
        return 1;
    }

    /* renamed from: a */
    private int m4533a(byte[] bArr) {
        byte b = bArr[4] & Ascii.f275US;
        return (b == 1 || b != 5) ? 2 : 1;
    }

    public synchronized void onFunctionCallRequestReceived(String str, WOWZDataMap wOWZDataMap, int i, int i2, int i3) {
        String str2;
        String str3 = f4699i;
        StringBuilder sb = new StringBuilder();
        sb.append("Function call request received: ");
        sb.append(str);
        sb.append("() (streamId: ");
        sb.append(i);
        sb.append(", srcFunctionId: ");
        sb.append(i2);
        sb.append(", srcId: ");
        sb.append(i3);
        sb.append(")");
        if (wOWZDataMap != null) {
            str2 = "\nFunction call parameters:\n" + wOWZDataMap.toString(true);
        } else {
            str2 = "";
        }
        sb.append(str2);
        WOWZLog.debug(str3, sb.toString());
        if (this.f4717K.containsKey(str)) {
            Iterator it = this.f4717K.get(str).iterator();
            while (it.hasNext()) {
                WOWZDataMap onWZDataEvent = ((WOWZDataEvent.EventListener) it.next()).onWZDataEvent(str, wOWZDataMap);
                if (i2 > 0 && onWZDataEvent != null) {
                    this.f4724t.sendModuleFunctionResult(i, 0, (long) i2, onWZDataEvent, onWZDataEvent.keys().length == 2 && onWZDataEvent.containsKey(HtmlTags.CODE) && onWZDataEvent.containsKey("description"));
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo59640a(String str, WOWZDataEvent.EventListener eventListener) {
        if (!this.f4717K.containsKey(str)) {
            this.f4717K.put(str, new ArrayList());
        }
        if (!this.f4717K.get(str).contains(eventListener)) {
            this.f4717K.get(str).add(eventListener);
        }
    }

    /* renamed from: b */
    public synchronized void mo59646b(String str, WOWZDataEvent.EventListener eventListener) {
        if (this.f4717K.containsKey(str) && this.f4717K.get(str).contains(eventListener)) {
            this.f4717K.get(str).remove(eventListener);
            if (this.f4717K.get(str).size() == 0) {
                this.f4717K.remove(str);
            }
        }
    }

    /* renamed from: com.wowza.gocoder.sdk.support.wse.d$1 */
    /* compiled from: GoCoderSDK */
    static /* synthetic */ class C43331 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4731a = new int[WOWZDataScope.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.wowza.gocoder.sdk.api.data.WOWZDataScope[] r0 = com.wowza.gocoder.sdk.api.data.WOWZDataScope.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4731a = r0
                int[] r0 = f4731a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.wowza.gocoder.sdk.api.data.WOWZDataScope r1 = com.wowza.gocoder.sdk.api.data.WOWZDataScope.STREAM     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f4731a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.wowza.gocoder.sdk.api.data.WOWZDataScope r1 = com.wowza.gocoder.sdk.api.data.WOWZDataScope.MODULE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wse.C4332d.C43331.<clinit>():void");
        }
    }

    /* renamed from: a */
    public void mo59639a(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap, WOWZDataEvent.ResultCallback resultCallback) {
        int i = C43331.f4731a[wOWZDataScope.ordinal()];
        if (i == 1) {
            this.f4724t.sendStreamDataEvent(this.f4728x, this.f4714H, str, wOWZDataMap);
        } else if (i == 2) {
            int sendModuleFunctionCall = this.f4724t.sendModuleFunctionCall(this.f4728x, this.f4714H, str, wOWZDataMap, resultCallback);
            if (resultCallback != null && sendModuleFunctionCall > 0 && !this.f4718L.containsKey(Integer.valueOf(sendModuleFunctionCall))) {
                this.f4718L.put(Integer.valueOf(sendModuleFunctionCall), resultCallback);
            }
        }
    }

    public synchronized void onFunctionCallResultReceived(int i, WOWZDataMap wOWZDataMap, boolean z, int i2, int i3) {
        String str;
        String str2;
        if (z) {
            String str3 = f4699i;
            StringBuilder sb = new StringBuilder();
            sb.append("Function call FAILURE result received (functionId: ");
            sb.append(i);
            sb.append(", streamId: ");
            sb.append(i2);
            sb.append(", srcId: ");
            sb.append(i3);
            sb.append(")");
            if (wOWZDataMap != null) {
                str2 = "\nFunction call result properties:\n" + wOWZDataMap.toString(true);
            } else {
                str2 = "";
            }
            sb.append(str2);
            WOWZLog.warn(str3, sb.toString());
        } else {
            String str4 = f4699i;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Function call SUCCESS result received (functionId: ");
            sb2.append(i);
            sb2.append(", streamId: ");
            sb2.append(i2);
            sb2.append(", srcId: ");
            sb2.append(i3);
            sb2.append(")");
            if (wOWZDataMap != null) {
                str = "\nFunction call result properties:\n" + wOWZDataMap.toString(true);
            } else {
                str = "";
            }
            sb2.append(str);
            WOWZLog.debug(str4, sb2.toString());
        }
        if (this.f4718L.containsKey(Integer.valueOf(i))) {
            this.f4718L.remove(Integer.valueOf(i)).onWZDataEventResult(wOWZDataMap, z);
        }
    }

    /* renamed from: y */
    public synchronized void mo59677y() {
        this.f4717K.clear();
        this.f4718L.clear();
    }

    /* renamed from: a */
    public void mo59638a(WOWZDataEvent.ResultCallback resultCallback) {
        int sendPingRequest = this.f4724t.sendPingRequest(resultCallback);
        if (resultCallback != null && sendPingRequest > 0 && !this.f4718L.containsKey(Integer.valueOf(sendPingRequest))) {
            this.f4718L.put(Integer.valueOf(sendPingRequest), resultCallback);
        }
    }

    /* renamed from: a */
    private Boolean m4536a(String str) {
        try {
            URL url = new URL(str);
            this.f4725u.setHostAddress(url.getHost());
            this.f4725u.setPortNumber(url.getPort() == -1 ? 1935 : url.getPort());
            return 1;
        } catch (MalformedURLException e) {
            String str2 = f4699i;
            WOWZLog.error(str2, "A malformed connection URI was specified (" + str + ")", (Throwable) e);
            return false;
        } catch (Exception e2) {
            String str3 = f4699i;
            WOWZLog.error(str3, "An exception occurred parsing a connection URI (" + str + ")", (Throwable) e2);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WOWZError mo59634a(int i, String str) {
        int i2;
        if (i == 0) {
            return null;
        }
        switch (i) {
            case 8:
                WOWZStreamingError wOWZStreamingError = new WOWZStreamingError(7);
                if (str != null && str.trim().length() > 0) {
                    wOWZStreamingError.setErrorDescription(str);
                }
                return wOWZStreamingError;
            case 9:
            case 11:
                i2 = 5;
                break;
            case 10:
                i2 = 6;
                break;
            case 12:
                WOWZStreamingError wOWZStreamingError2 = new WOWZStreamingError(55);
                if (str != null && str.trim().length() > 0) {
                    wOWZStreamingError2.setErrorDescription(str);
                }
                return wOWZStreamingError2;
            case 13:
                WOWZStreamingError wOWZStreamingError3 = new WOWZStreamingError(56);
                if (str != null && str.trim().length() > 0) {
                    wOWZStreamingError3.setErrorDescription(str);
                }
                return wOWZStreamingError3;
            default:
                if (str == null || str.trim().length() <= 0) {
                    i2 = 59;
                    break;
                } else {
                    return new WOWZError(str);
                }
                break;
        }
        return m4538g(i2);
    }

    /* renamed from: a */
    private WOWZError m4534a(int i, Exception exc) {
        return m4535a(new WOWZStreamingError(i).getErrorDescription(), exc);
    }

    /* renamed from: g */
    private WOWZError m4538g(int i) {
        return m4534a(i, (Exception) null);
    }

    /* renamed from: a */
    private WOWZError m4535a(String str, Exception exc) {
        String sessionErrorDescription;
        int sessionError = this.f4724t.getSessionError();
        if (!(sessionError == 0 || (sessionErrorDescription = this.f4724t.getSessionErrorDescription()) == null)) {
            str = str + ": " + sessionErrorDescription + " (" + sessionError + ")";
        }
        return exc != null ? new WOWZError(str, exc) : new WOWZError(str);
    }

    /* renamed from: b */
    private WOWZError m4537b(String str) {
        return m4535a(str, (Exception) null);
    }
}
