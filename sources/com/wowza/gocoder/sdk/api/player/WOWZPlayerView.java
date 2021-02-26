package com.wowza.gocoder.sdk.api.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZStreamConfig;
import com.wowza.gocoder.sdk.api.data.WOWZData;
import com.wowza.gocoder.sdk.api.data.WOWZDataEvent;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.data.WOWZDataScope;
import com.wowza.gocoder.sdk.api.data.WOWZDataType;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.geometry.WOWZPoint;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.gles.EglCore;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.api.status.WOWZStatusCallback;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;
import com.wowza.gocoder.sdk.support.p038e.C4289c;
import com.wowza.gocoder.sdk.support.p038e.C4296e;
import com.wowza.gocoder.sdk.support.p040g.C4300a;
import com.wowza.gocoder.sdk.support.p040g.C4301b;
import com.wowza.gocoder.sdk.support.wse.C4330b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: GoCoderSDK */
public class WOWZPlayerView extends FrameLayout implements SurfaceHolder.Callback, WOWZPlayerAPI.WZAudioStreamReceiver, WOWZPlayerAPI.WZVideoStreamReceiver {
    public static final int STATE_ERROR = 10;
    public static final int STATE_PLAYBACK_COMPLETE = 7;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREBUFFERING_ENDED = 13;
    public static final int STATE_PREBUFFERING_STARTED = 12;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_READY_TO_PLAY = 0;
    public static final int STATE_STOPPING = 4;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f3843c = "WOWZPlayerView";

    /* renamed from: d */
    private static final int f3844d = 3;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public Object f3845A = new Object();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f3846B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public WOWZSize f3847C;

    /* renamed from: D */
    private Surface f3848D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f3849E = false;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f3850F = 0;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f3851G = 0;

    /* renamed from: H */
    private HashMap<String, ArrayList<WOWZDataEvent.EventListener>> f3852H = new HashMap<>();

    /* renamed from: a */
    boolean f3853a = false;

    /* renamed from: b */
    MediaExtractor f3854b = new MediaExtractor();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WOWZPlayerConfig f3855e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WOWZStreamConfig f3856f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WOWZStatus f3857g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WOWZStatusCallback f3858h;

    /* renamed from: i */
    private WOWZStatusCallback f3859i;

    /* renamed from: j */
    private AudioManager f3860j;

    /* renamed from: k */
    private boolean f3861k;

    /* renamed from: l */
    private boolean f3862l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f3863m;

    /* renamed from: n */
    private AtomicBoolean f3864n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public AtomicBoolean f3865o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public AtomicBoolean f3866p;

    /* renamed from: q */
    private AtomicBoolean f3867q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C4296e f3868r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C4289c f3869s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public MediaPlayer f3870t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public C4330b f3871u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public SurfaceView f3872v;

    /* renamed from: w */
    private int f3873w;

    /* renamed from: x */
    private int f3874x;

    /* renamed from: y */
    private int f3875y;

    /* renamed from: z */
    private WOWZDataMap f3876z;

    /* compiled from: GoCoderSDK */
    public interface PacketThresholdChangeListener {
        void packetsAboveMinimumThreshold(int i);

        void packetsBelowMinimumThreshold(int i);
    }

    public WOWZPlayerView(Context context) {
        super(context);
        m3658a(context);
    }

    public WOWZPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3658a(context);
    }

    /* renamed from: a */
    private void m3658a(Context context) {
        this.f3855e = new WOWZPlayerConfig();
        this.f3857g = new WOWZStatus(0);
        this.f3859i = new WOWZStatusCallback() {
            public void onWZStatus(WOWZStatus wOWZStatus) {
                GlobalPlayerStateManager.CONNECTION_STATE = wOWZStatus.getState();
            }

            public void onWZError(WOWZStatus wOWZStatus) {
                WOWZLog.error(WOWZPlayerView.f3843c, wOWZStatus.getLastError());
            }
        };
        this.f3858h = this.f3859i;
        this.f3856f = null;
        this.f3862l = false;
        this.f3861k = false;
        this.f3863m = false;
        this.f3864n = new AtomicBoolean(false);
        this.f3876z = new WOWZDataMap();
        this.f3865o = new AtomicBoolean(false);
        this.f3866p = new AtomicBoolean(false);
        this.f3867q = new AtomicBoolean(false);
        this.f3868r = new C4296e();
        this.f3869s = new C4289c();
        this.f3868r.mo59142a((WOWZStatusCallback) new WOWZStatusCallback() {
            public void onWZError(WOWZStatus wOWZStatus) {
            }

            public void onWZStatus(WOWZStatus wOWZStatus) {
                String a = WOWZPlayerView.f3843c;
                WOWZLog.debug(a, "DECODER STATUS --> video New Status: " + wOWZStatus.toString());
                int state = wOWZStatus.getState();
                if (state == 10) {
                    WOWZLog.debug("WZPLAYERVIEW", "ERROR STATUS FROM DECODER");
                    if (WOWZPlayerView.this.f3869s.f4193h || WOWZPlayerView.this.f3868r.f4193h) {
                        synchronized (WOWZPlayerView.this.f3845A) {
                            WOWZLog.debug("WZPLAYERVIEW", "Running stop procedure. State: " + WOWZPlayerView.this.f3857g.getState());
                            if (WOWZPlayerView.this.f3868r != null && WOWZPlayerView.this.f3868r.mo59151f().isRunning()) {
                                WOWZPlayerView.this.f3868r.mo59145ab();
                            }
                            if (WOWZPlayerView.this.f3869s != null && WOWZPlayerView.this.f3869s.mo59151f().isRunning()) {
                                WOWZPlayerView.this.f3869s.mo59145ab();
                            }
                            WOWZPlayerView.this.f3857g.setError(new WOWZError("Unable to initiate codec. Please try again."));
                            WOWZPlayerView.this.stop();
                            WOWZPlayerView.this.f3871u.mo59626g();
                        }
                    }
                } else if (state == 12) {
                    WOWZLog.debug("WZPLAYERVIEW", "PREFBUFFERING STARTED");
                    WOWZPlayerView.this.f3865o.set(true);
                    if (!WOWZPlayerView.this.f3866p.get()) {
                        WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(12));
                    }
                } else if (state != 13) {
                    GlobalPlayerStateManager.DECODER_VIDEO_STATE = wOWZStatus.getState();
                    WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(wOWZStatus.getState()));
                    GlobalPlayerStateManager.isReady();
                } else {
                    WOWZLog.debug("WZPLAYERVIEW", "PREFBUFFERING ENDED");
                    WOWZPlayerView.this.f3865o.set(false);
                    if (!WOWZPlayerView.this.f3866p.get()) {
                        WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(13));
                    }
                }
            }
        });
        this.f3869s.mo59142a((WOWZStatusCallback) new WOWZStatusCallback() {
            public void onWZError(WOWZStatus wOWZStatus) {
            }

            public void onWZStatus(WOWZStatus wOWZStatus) {
                String a = WOWZPlayerView.f3843c;
                WOWZLog.debug(a, "DECODER STATUS --> audio New Status: " + wOWZStatus.toString());
                int state = wOWZStatus.getState();
                if (state == 12) {
                    WOWZPlayerView.this.f3866p.set(true);
                    if (!WOWZPlayerView.this.f3865o.get()) {
                        WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(12));
                    }
                } else if (state != 13) {
                    GlobalPlayerStateManager.DECODER_AUDIO_STATE = wOWZStatus.getState();
                    WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(wOWZStatus.getState()));
                    GlobalPlayerStateManager.isReady();
                } else {
                    WOWZPlayerView.this.f3866p.set(false);
                    if (!WOWZPlayerView.this.f3865o.get()) {
                        WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(13));
                    }
                }
            }
        });
        try {
            this.f3860j = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        } catch (Exception e) {
            WOWZLog.error(f3843c, "An exception occurred initializing the AudioManager.", (Throwable) e);
            this.f3860j = null;
        }
        this.f3871u = new C4330b();
        if (this.f3872v == null) {
            this.f3872v = new SurfaceView(context);
        }
        this.f3846B = 1;
        this.f3847C = new WOWZSize(0, 0);
        this.f3872v.getHolder().addCallback(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.f3872v, layoutParams);
        m3655a(0);
    }

    private Surface getSurface() {
        return this.f3848D;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        String str = f3843c;
        WOWZLog.debug(str, "surfaceCreated: " + surfaceHolder.getSurfaceFrame().toString());
        this.f3848D = surfaceHolder.getSurface();
        if (this.f3853a) {
            this.f3853a = false;
            WOWZLog.debug(f3843c, "surfaceCreated: calling play");
            m3657a(0);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = f3843c;
        WOWZLog.debug(str, "surfaceChanged: " + i2 + "x" + i3);
        this.f3848D = surfaceHolder.getSurface();
        if (this.f3853a) {
            this.f3853a = false;
            WOWZLog.debug(f3843c, "surfaceChanged: calling play");
            m3657a(0);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WOWZLog.debug(f3843c, "surfaceDestroyed");
        this.f3848D = null;
    }

    public void pauseNetworkStack() {
        this.f3868r.mo59201am();
    }

    public void unpauseNetworkStack() {
        this.f3868r.mo59202an();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WOWZSize wOWZSize = new WOWZSize(getWidth(), getHeight());
        WOWZSize wOWZSize2 = this.f3847C;
        int i5 = this.f3846B;
        if (wOWZSize2.isZero()) {
            wOWZSize2.set(wOWZSize);
        }
        WOWZSize a = m3651a(this.f3872v, wOWZSize, wOWZSize2, i5);
        WOWZPoint wOWZPoint = new WOWZPoint(0, 0);
        wOWZPoint.f3734x = Math.round(((float) (wOWZSize.width - a.width)) / 2.0f);
        wOWZPoint.f3735y = Math.round(((float) (wOWZSize.height - a.height)) / 2.0f);
        this.f3872v.layout(wOWZPoint.f3734x, wOWZPoint.f3735y, wOWZPoint.f3734x + a.width, wOWZPoint.f3735y + a.height);
    }

    /* renamed from: a */
    private WOWZSize m3651a(View view, WOWZSize wOWZSize, WOWZSize wOWZSize2, int i) {
        if (wOWZSize.isZero() || wOWZSize2 == null || wOWZSize2.isZero()) {
            return wOWZSize;
        }
        WOWZSize wOWZSize3 = new WOWZSize(wOWZSize);
        double aspectRatio = (double) wOWZSize.aspectRatio();
        double aspectRatio2 = (double) wOWZSize2.aspectRatio();
        if (aspectRatio2 != aspectRatio) {
            double d = (aspectRatio2 / aspectRatio) - 1.0d;
            if (i == 1) {
                if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    wOWZSize3.height = (int) (((double) wOWZSize.width) / aspectRatio2);
                } else {
                    wOWZSize3.width = (int) (((double) wOWZSize.height) * aspectRatio2);
                }
            } else if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                wOWZSize3.height = (int) (((double) wOWZSize.width) / aspectRatio2);
            } else {
                wOWZSize3.width = (int) (((double) wOWZSize.height) * aspectRatio2);
            }
        }
        return wOWZSize3;
    }

    public void onStateChanged(WOWZStatusCallback wOWZStatusCallback) {
        if (wOWZStatusCallback == null) {
            wOWZStatusCallback = this.f3859i;
        }
        this.f3858h = wOWZStatusCallback;
    }

    public int getCurrentState() {
        return this.f3857g.getState();
    }

    public WOWZStatus getCurrentStatus() {
        return this.f3857g;
    }

    /* renamed from: a */
    private synchronized void m3656a(int i, WOWZError wOWZError) {
        this.f3857g.setState(i);
        this.f3857g.setError(wOWZError);
        this.f3858h.onWZStatus(this.f3857g);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m3666b(int i, WOWZError wOWZError) {
        this.f3857g.setState(i);
        if (wOWZError != null) {
            this.f3857g.setState(10);
            this.f3857g.setError(wOWZError);
            this.f3858h.onWZError(this.f3857g);
        }
        this.f3858h.onWZStatus(this.f3857g);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3655a(int i) {
        m3666b(i, (WOWZError) null);
    }

    public int getVolume() {
        return m3670c();
    }

    public void setVolume(int i) {
        if (i < 0 || i > 100) {
            WOWZLog.error(f3843c, "Invalid volume specified.");
        } else if (isPlaying()) {
            setVolumeLevel(i);
        }
    }

    public void mute(boolean z) {
        if (isPlaying() && this.f3860j != null) {
            this.f3868r.mo59143a((C4301b.C4302a) z ? null : this.f3869s);
            this.f3860j.setStreamMute(3, z);
        }
        this.f3861k = z;
    }

    public boolean isMuted() {
        return m3668b();
    }

    /* renamed from: b */
    private boolean m3668b() {
        AudioManager audioManager = this.f3860j;
        if (audioManager != null) {
            int ringerMode = audioManager.getRingerMode();
            if (ringerMode == 0) {
                return true;
            }
            if (ringerMode == 1 || ringerMode == 2) {
                return false;
            }
        }
        return this.f3861k;
    }

    /* renamed from: c */
    private int m3670c() {
        AudioManager audioManager = this.f3860j;
        if (audioManager == null) {
            return -1;
        }
        float streamMaxVolume = (float) audioManager.getStreamMaxVolume(3);
        if (streamMaxVolume != 0.0f) {
            return Math.round((((float) this.f3860j.getStreamVolume(3)) / streamMaxVolume) * 100.0f);
        }
        return -1;
    }

    private void setVolumeLevel(int i) {
        int round;
        AudioManager audioManager = this.f3860j;
        if (audioManager != null) {
            float streamMaxVolume = (float) audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume != 0.0f && this.f3860j.getStreamVolume(3) != (round = Math.round(streamMaxVolume * (((float) i) / 100.0f)))) {
                this.f3860j.setStreamVolume(3, round, 0);
            }
        }
    }

    /* renamed from: a */
    private void m3662a(boolean z) {
        this.f3862l = z;
    }

    /* renamed from: d */
    private boolean m3675d() {
        return this.f3862l;
    }

    public int getScaleMode() {
        return this.f3846B;
    }

    public void setScaleMode(final int i) {
        if (!WOWZMediaConfig.isValidScaleMode(i)) {
            WOWZLog.warn(f3843c, "Invalid scale mode specified.");
        } else if (isPlaying()) {
            new Handler(getContext().getMainLooper()).post(new Runnable() {
                public void run() {
                    int unused = WOWZPlayerView.this.f3846B = i;
                    WOWZPlayerView.this.requestLayout();
                }
            });
        } else {
            this.f3846B = i;
        }
    }

    public void clear() {
        EglCore eglCore = new EglCore();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        eglCore.release();
    }

    public int getLogLevel() {
        return this.f3871u.mo59610b();
    }

    public void setLogLevel(int i) {
        this.f3871u.mo59605a(i);
    }

    public boolean isReadyToPlay() {
        return this.f3857g.isIdle();
    }

    /* renamed from: e */
    private void m3678e() {
        this.f3857g.clearLastError();
        this.f3857g.setState(0);
        this.f3856f = new WOWZStreamConfig();
        this.f3864n.set(false);
        this.f3865o.set(false);
        this.f3866p.set(false);
        this.f3867q.set(false);
        this.f3861k = m3668b();
        this.f3873w = 0;
        this.f3874x = 0;
        this.f3875y = 500;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m3680f() {
        this.f3853a = false;
        C4296e eVar = this.f3868r;
        if (eVar != null && eVar.mo59151f().isRunning()) {
            this.f3868r.mo59145ab();
        }
        C4289c cVar = this.f3869s;
        if (cVar != null && cVar.mo59151f().isRunning()) {
            this.f3869s.mo59145ab();
        }
        this.f3856f = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3665b(int i) {
        if (i == -1010) {
            WOWZLog.debug(f3843c, "MEDIA_ERROR_UNSUPPORTED");
        } else if (i == -1007) {
            WOWZLog.debug(f3843c, "MEDIA_ERROR_MALFORMED");
        } else if (i == -1004) {
            WOWZLog.debug(f3843c, "MEDIA_ERROR_IO");
        } else if (i == -110) {
            WOWZLog.debug(f3843c, "MEDIA_ERROR_TIMED_OUT");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m3682g() {
        int width = this.f3872v.getWidth();
        int height = this.f3872v.getHeight();
        float videoWidth = (float) this.f3870t.getVideoWidth();
        float videoHeight = (float) this.f3870t.getVideoHeight();
        float f = (float) width;
        float f2 = f / videoWidth;
        float f3 = (float) height;
        float f4 = f3 / videoHeight;
        float f5 = videoWidth / videoHeight;
        ViewGroup.LayoutParams layoutParams = this.f3872v.getLayoutParams();
        if (f2 > f4) {
            layoutParams.width = (int) (f3 * f5);
            layoutParams.height = height;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) (f / f5);
        }
        this.f3872v.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m3684h() {
        if (!LicenseManager.getInstance().canDoPlayback()) {
            this.f3863m = false;
            m3661a("Unable to initiate playback with this license.");
            return;
        }
        if (this.f3870t == null) {
            this.f3870t = new MediaPlayer();
        }
        WOWZLog.debug("**** USING HLS *****");
        this.f3870t.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String a = WOWZPlayerView.f3843c;
                WOWZLog.debug(a, "MP_ERROR4: onError in MediaPlayer: (" + i + ") with extra (" + i2 + ")");
                WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(13));
                if (i == 1) {
                    WOWZLog.debug(WOWZPlayerView.f3843c, "MEDIA_ERROR_UNKNOWN");
                    boolean unused = WOWZPlayerView.this.f3863m = false;
                    WOWZPlayerView.this.m3661a("Unable to process playback.");
                    WOWZPlayerView.this.m3665b(i2);
                } else if (i != 100) {
                    boolean unused2 = WOWZPlayerView.this.f3863m = false;
                    String a2 = WOWZPlayerView.f3843c;
                    WOWZLog.debug(a2, "onError in player: (" + i + ") with extra (" + i2 + ")");
                    WOWZPlayerView.this.m3661a("Unable to process playback.");
                } else {
                    WOWZLog.debug(WOWZPlayerView.f3843c, "MEDIA_ERROR_SERVER_DIED");
                    boolean unused3 = WOWZPlayerView.this.f3863m = false;
                    WOWZPlayerView.this.m3661a("Unable to process playback.");
                    WOWZPlayerView.this.m3665b(i2);
                }
                mediaPlayer.reset();
                GlobalPlayerStateManager.setAll(0);
                WOWZPlayerView.this.m3655a(10);
                return false;
            }
        });
        this.f3870t.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public boolean onInfo(final MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 701) {
                    WOWZLog.debug(WOWZPlayerView.f3843c, "MEDIA_INFO_BUFFERING_START");
                    WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(12));
                    boolean unused = WOWZPlayerView.this.f3849E = true;
                    WOWZLog.debug("***** BUFFERING TOO LONG, CHECKING!");
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (WOWZPlayerView.this.f3849E) {
                                WOWZLog.debug("***** BUFFERING TOO LONG, SHUTTING DOWN!");
                                WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(13));
                                mediaPlayer.reset();
                                GlobalPlayerStateManager.setAll(0);
                                WOWZPlayerView.this.m3655a(10);
                                return;
                            }
                            WOWZLog.debug("***** BUFFERING TOO LONG,OK! " + WOWZPlayerView.this.f3857g.toString() + " :: " + WOWZPlayerView.this.f3870t.isPlaying());
                        }
                    }, 7000);
                } else if (i != 702) {
                    String a = WOWZPlayerView.f3843c;
                    WOWZLog.debug(a, "onInfo :: " + i + " : " + i2);
                } else {
                    boolean unused2 = WOWZPlayerView.this.f3849E = false;
                    WOWZLog.debug(WOWZPlayerView.f3843c, "MEDIA_INFO_BUFFERING_END");
                    WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(13));
                }
                return true;
            }
        });
        this.f3870t.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                String a = WOWZPlayerView.f3843c;
                WOWZLog.debug(a, "onBufferingUpdate " + i);
            }
        });
        this.f3870t.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                WOWZLog.debug(WOWZPlayerView.f3843c, "onCompletion");
            }
        });
        this.f3870t.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                WOWZPlayerView.this.m3655a(3);
                WOWZPlayerView.this.f3871u.mo59613d().setState(3);
                WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(13));
                WOWZPlayerView.this.m3682g();
                WOWZPlayerView.this.f3855e.setPreRollBufferDuration(0.0f);
                mediaPlayer.start();
            }
        });
        new Thread(new Runnable() {
            public void run() {
                WOWZPlayerView.this.m3655a(1);
                try {
                    WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(12));
                    WOWZPlayerView.this.f3847C.set(WOWZPlayerView.this.f3871u.mo59614e().getVideoFrameWidth(), WOWZPlayerView.this.f3871u.mo59614e().getVideoFrameHeight());
                    WOWZPlayerView.this.f3870t.setDisplay(WOWZPlayerView.this.f3872v.getHolder());
                    String hLSBackupURL = WOWZPlayerView.this.f3855e.getHLSBackupURL();
                    if (hLSBackupURL != null) {
                        String a = WOWZPlayerView.f3843c;
                        WOWZLog.debug(a, "Preparing " + hLSBackupURL + " ...");
                        WOWZPlayerView.this.f3870t.setDataSource(hLSBackupURL);
                        WOWZPlayerView.this.f3870t.setOnVideoSizeChangedListener(new HLSVideoSizedChanged());
                        WOWZPlayerView.this.f3870t.prepare();
                        return;
                    }
                    boolean unused = WOWZPlayerView.this.f3863m = false;
                    WOWZPlayerView.this.m3661a("Playback cannot continue.");
                } catch (IllegalArgumentException e) {
                    boolean unused2 = WOWZPlayerView.this.f3863m = false;
                    String a2 = WOWZPlayerView.f3843c;
                    WOWZLog.debug(a2, "ERROR[IllegalArgumentException]: " + e.getMessage());
                    WOWZPlayerView.this.m3661a("Unable to continue playback.");
                    WOWZPlayerView.this.f3870t.reset();
                } catch (IllegalStateException e2) {
                    boolean unused3 = WOWZPlayerView.this.f3863m = false;
                    String a3 = WOWZPlayerView.f3843c;
                    WOWZLog.debug(a3, "ERROR[IllegalStateException]: " + e2.getMessage());
                    WOWZPlayerView.this.m3661a("Unable to continue playback.");
                    WOWZPlayerView.this.f3870t.reset();
                } catch (IOException e3) {
                    boolean unused4 = WOWZPlayerView.this.f3863m = false;
                    String a4 = WOWZPlayerView.f3843c;
                    WOWZLog.debug(a4, "ERROR[IOException]: " + e3.getMessage());
                    WOWZPlayerView.this.m3661a("Unable to continue playback.");
                    WOWZPlayerView.this.f3870t.reset();
                }
            }
        }, "GoCoderSDKPlayer").start();
    }

    /* compiled from: GoCoderSDK */
    class HLSVideoSizedChanged implements MediaPlayer.OnVideoSizeChangedListener {
        HLSVideoSizedChanged() {
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            int unused = WOWZPlayerView.this.f3850F = i;
            int unused2 = WOWZPlayerView.this.f3851G = i2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3661a(String str) {
        this.f3857g.set(2, new WOWZError(str));
        this.f3858h.onWZError(this.f3857g);
        this.f3858h.onWZStatus(new WOWZStatus(13));
        m3655a(0);
    }

    /* renamed from: i */
    private void m3685i() {
        this.f3856f.setHostAddress(this.f3855e.getHostAddress());
        this.f3856f.setApplicationName(this.f3855e.getApplicationName());
        this.f3856f.setPortNumber(this.f3855e.getPortNumber());
        this.f3856f.setStreamName(this.f3855e.getStreamName());
        this.f3856f.setUsername(this.f3855e.getUsername());
        this.f3856f.setPassword(this.f3855e.getPassword());
        this.f3856f.setConnectionParameters(this.f3855e.getConnectionParameters());
        this.f3856f.setStreamMetadata(this.f3855e.getStreamMetadata());
    }

    /* renamed from: a */
    private void m3657a(long j) {
        if (!isReadyToPlay()) {
            WOWZLog.error(f3843c, "play !isReadyToPlay Sorry ...");
            stop();
            return;
        }
        clear();
        m3678e();
        m3685i();
        if (this.f3855e.isHLSEnabled() || this.f3863m) {
            WOWZLog.debug(f3843c, "Starting HLS playback.");
            m3684h();
            return;
        }
        WOWZLog.debug("**** USING WOWZ *****");
        m3655a(1);
        C4289c cVar = null;
        final WOWZPlayerView wOWZPlayerView = this.f3855e.isVideoEnabled() ? this : null;
        final WOWZPlayerView wOWZPlayerView2 = this.f3855e.isAudioEnabled() ? this : null;
        this.f3868r.mo59141a(this.f3855e.getPreRollBufferDurationMillis());
        this.f3869s.mo59141a(this.f3855e.getPreRollBufferDurationMillis());
        if (this.f3855e.isVideoEnabled()) {
            this.f3868r.mo59178a(getSurface());
            C4296e eVar = this.f3868r;
            if (this.f3855e.isAudioEnabled()) {
                cVar = this.f3869s;
            }
            eVar.mo59143a((C4301b.C4302a) cVar);
        }
        new Thread(new Runnable() {
            public void run() {
                WOWZLog.debug("**** Decoder SHOW BUFFER *****");
                WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(12));
                if (!(WOWZPlayerView.this.f3868r.mo59151f().getState() == 4)) {
                    WOWZStatus a = WOWZPlayerView.this.f3871u.mo59624a((WOWZStreamConfig) WOWZPlayerView.this.f3855e, 0, wOWZPlayerView, wOWZPlayerView2);
                    if (a.isReady()) {
                        WOWZPlayerView.this.m3655a(3);
                        WOWZStatus a2 = WOWZPlayerView.this.f3871u.mo59625a(wOWZPlayerView, wOWZPlayerView2);
                        if (a2.getLastError() == null) {
                            WOWZPlayerView.this.m3655a(7);
                        } else {
                            WOWZPlayerView.this.m3666b(10, a2.getLastError());
                        }
                    } else if (a.getLastError() != null) {
                        WOWZLog.debug(WOWZPlayerView.f3843c, a.getLastError().toString());
                        WOWZPlayerView.this.m3655a(0);
                        boolean unused = WOWZPlayerView.this.f3863m = true;
                        WOWZPlayerView.this.f3858h.onWZStatus(new WOWZStatus(13));
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                WOWZPlayerView.this.m3684h();
                            }
                        });
                    }
                    WOWZPlayerView.this.m3680f();
                    WOWZPlayerView.this.m3655a(0);
                }
            }
        }, "GoCoderSDKPlayer").start();
    }

    public void play(WOWZPlayerConfig wOWZPlayerConfig, WOWZStatusCallback wOWZStatusCallback) {
        this.f3855e.set(wOWZPlayerConfig);
        onStateChanged(wOWZStatusCallback);
        if (this.f3848D != null) {
            WOWZLog.debug(f3843c, "play ready to go");
            m3657a(0);
            return;
        }
        WOWZLog.debug(f3843c, "play surface is not ready yet");
        this.f3853a = true;
    }

    public void stop() {
        this.f3853a = false;
        this.f3863m = false;
        m3655a(4);
        final Handler handler = new Handler(getContext().getMainLooper());
        new Thread() {
            public void run() {
                int i = 0;
                while (!GlobalPlayerStateManager.isReady() && i <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception unused) {
                    }
                    i++;
                }
                GlobalPlayerStateManager.setAll(0);
                handler.post(new Runnable() {
                    public void run() {
                        WOWZPlayerView.this.m3655a(0);
                    }
                });
            }
        }.start();
        new Thread(new Runnable() {
            public void run() {
                if (WOWZPlayerView.this.f3870t != null) {
                    try {
                        WOWZLog.debug(WOWZPlayerView.f3843c, "Stopping HLS playback.");
                        WOWZPlayerView.this.f3870t.stop();
                        WOWZPlayerView.this.f3870t.reset();
                    } catch (IllegalStateException e) {
                        WOWZLog.debug(WOWZPlayerView.f3843c, e.getMessage());
                    }
                    WOWZPlayerView.this.m3655a(0);
                    GlobalPlayerStateManager.setAll(0);
                }
                if (!WOWZPlayerView.this.f3871u.mo59613d().isIdle()) {
                    WOWZPlayerView.this.f3871u.mo59626g();
                }
                WOWZPlayerView.this.m3655a(0);
            }
        }).start();
    }

    public void stop(WOWZStatusCallback wOWZStatusCallback) {
        this.f3853a = false;
        if (isPlaying()) {
            this.f3858h = wOWZStatusCallback;
            stop();
        }
    }

    public synchronized void onEnhancedSeekStart() {
        this.f3867q.set(true);
    }

    public synchronized void onEnhancedSeekEnd() {
        this.f3867q.set(false);
    }

    public void onVideoFrameReceived(int i, long j, byte[] bArr, long j2) {
        if (!this.f3857g.isStopping() && !this.f3857g.isIdle()) {
            if (i == 4) {
                WOWZMediaConfig b = this.f3868r.mo59146b(bArr);
                if (this.f3868r.mo59151f().isRunning()) {
                    if (b != null) {
                        this.f3856f.setVideoFrameSize(b.getVideoFrameSize());
                    }
                    new Handler(getContext().getMainLooper()).post(new Runnable() {
                        public void run() {
                            WOWZPlayerView wOWZPlayerView = WOWZPlayerView.this;
                            WOWZSize unused = wOWZPlayerView.f3847C = wOWZPlayerView.f3856f.getVideoFrameSize();
                            WOWZPlayerView.this.requestLayout();
                        }
                    });
                    return;
                }
                this.f3857g.setError(this.f3868r.mo59151f().getLastError());
                stop();
                return;
            }
            if (!this.f3867q.get() && !this.f3864n.get() && i == 1) {
                WOWZLog.debug(f3843c, "The first video keyframe received after the enhanced seek stop had the timecode: " + C4300a.m4214a(j));
                WOWZLog.debug(f3843c, this.f3873w + " frames and " + this.f3874x + " audio samples were skipped during the enhanced seek.");
                this.f3864n.set(true);
                if (!m3688j()) {
                    this.f3868r.mo59183ad();
                } else {
                    this.f3868r.mo59184ae();
                }
            }
            if (!this.f3864n.get()) {
                this.f3873w++;
            } else if (!this.f3862l) {
                this.f3868r.mo59139a(i, j, bArr, j2);
            }
        }
    }

    public void onAudioSampleReceived(int i, long j, byte[] bArr) {
        int i2;
        if (!this.f3857g.isStopping() && !this.f3857g.isIdle()) {
            if (i == 6) {
                WOWZMediaConfig b = this.f3869s.mo59146b(bArr);
                if (!this.f3869s.mo59151f().isRunning()) {
                    this.f3857g.setError(this.f3869s.mo59151f().getLastError());
                    stop();
                } else if (b != null) {
                    this.f3856f.setAudioChannels(b.getAudioChannels());
                    this.f3856f.setAudioSampleRate(b.getAudioSampleRate());
                }
            } else if (!this.f3855e.isVideoEnabled() || this.f3864n.get() || (i2 = this.f3874x) >= this.f3875y) {
                this.f3869s.mo59139a(i, j, bArr, 0);
            } else {
                this.f3874x = i2 + 1;
            }
        }
    }

    public boolean isPlaying() {
        return this.f3857g.isRunning();
    }

    public boolean isBuffering() {
        return isPlaying() && ((this.f3855e.isVideoEnabled() && this.f3868r.mo59155j()) || (this.f3855e.isAudioEnabled() && this.f3869s.mo59155j()));
    }

    public long getCurrentTime() {
        if (this.f3855e.isHLSEnabled() || this.f3863m) {
            return (long) this.f3870t.getCurrentPosition();
        }
        C4296e eVar = this.f3868r;
        if (eVar != null) {
            return eVar.mo59107A();
        }
        C4289c cVar = this.f3869s;
        if (cVar != null) {
            return cVar.mo59107A();
        }
        return 0;
    }

    public WOWZStreamConfig getStreamConfig() {
        return this.f3856f;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0 = java.lang.Long.parseLong(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0060 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getDuration() {
        /*
            r9 = this;
            boolean r0 = r9.isPlaying()
            r1 = 0
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            com.wowza.gocoder.sdk.api.player.WOWZPlayerConfig r0 = r9.f3855e
            boolean r0 = r0.isHLSEnabled()
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r0 != 0) goto L_0x00a4
            boolean r0 = r9.f3863m
            if (r0 == 0) goto L_0x0019
            goto L_0x00a4
        L_0x0019:
            com.wowza.gocoder.sdk.api.data.WOWZDataMap r0 = r9.getMetadata()
            if (r0 == 0) goto L_0x00a3
            java.lang.String r5 = "duration"
            boolean r6 = r0.containsKey(r5)
            if (r6 == 0) goto L_0x00a3
            com.wowza.gocoder.sdk.api.data.WOWZData r6 = r0.get(r5)
            com.wowza.gocoder.sdk.api.data.WOWZDataType r6 = r6.getDataType()
            int[] r7 = com.wowza.gocoder.sdk.api.player.WOWZPlayerView.C424815.f3888a
            int r6 = r6.ordinal()
            r6 = r7[r6]
            r7 = 1
            r8 = 1148846080(0x447a0000, float:1000.0)
            if (r6 == r7) goto L_0x0090
            r7 = 2
            if (r6 == r7) goto L_0x0080
            r7 = 3
            if (r6 == r7) goto L_0x0072
            r7 = 4
            if (r6 == r7) goto L_0x0065
            r7 = 5
            if (r6 == r7) goto L_0x0049
            goto L_0x00a3
        L_0x0049:
            com.wowza.gocoder.sdk.api.data.WOWZData r0 = r0.get(r5)
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            java.lang.String r0 = r0.stringValue()
            float r5 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0060 }
            float r5 = r5 * r8
            int r0 = java.lang.Math.round(r5)     // Catch:{ NumberFormatException -> 0x0060 }
            goto L_0x00a2
        L_0x0060:
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x00a3 }
            goto L_0x008d
        L_0x0065:
            com.wowza.gocoder.sdk.api.data.WOWZData r0 = r0.get(r5)
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            short r0 = r0.shortValue()
            goto L_0x008c
        L_0x0072:
            com.wowza.gocoder.sdk.api.data.WOWZData r0 = r0.get(r5)
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            double r0 = r0.doubleValue()
            long r0 = (long) r0
            goto L_0x008d
        L_0x0080:
            com.wowza.gocoder.sdk.api.data.WOWZData r0 = r0.get(r5)
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            int r0 = r0.intValue()
        L_0x008c:
            long r0 = (long) r0
        L_0x008d:
            long r1 = r0 * r3
            goto L_0x00a3
        L_0x0090:
            com.wowza.gocoder.sdk.api.data.WOWZData r0 = r0.get(r5)
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            com.wowza.gocoder.sdk.api.data.WOWZDataItem r0 = (com.wowza.gocoder.sdk.api.data.WOWZDataItem) r0
            float r0 = r0.floatValue()
            float r0 = r0 * r8
            int r0 = java.lang.Math.round(r0)
        L_0x00a2:
            long r1 = (long) r0
        L_0x00a3:
            return r1
        L_0x00a4:
            android.media.MediaPlayer r0 = r9.f3870t
            int r0 = r0.getDuration()
            long r0 = (long) r0
            long r0 = r0 * r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.player.WOWZPlayerView.getDuration():long");
    }

    /* renamed from: com.wowza.gocoder.sdk.api.player.WOWZPlayerView$15 */
    /* compiled from: GoCoderSDK */
    static /* synthetic */ class C424815 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3888a = new int[WOWZDataType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.wowza.gocoder.sdk.api.data.WOWZDataType[] r0 = com.wowza.gocoder.sdk.api.data.WOWZDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3888a = r0
                int[] r0 = f3888a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.wowza.gocoder.sdk.api.data.WOWZDataType r1 = com.wowza.gocoder.sdk.api.data.WOWZDataType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3888a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.wowza.gocoder.sdk.api.data.WOWZDataType r1 = com.wowza.gocoder.sdk.api.data.WOWZDataType.INTEGER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3888a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.wowza.gocoder.sdk.api.data.WOWZDataType r1 = com.wowza.gocoder.sdk.api.data.WOWZDataType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3888a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.wowza.gocoder.sdk.api.data.WOWZDataType r1 = com.wowza.gocoder.sdk.api.data.WOWZDataType.SHORT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f3888a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.wowza.gocoder.sdk.api.data.WOWZDataType r1 = com.wowza.gocoder.sdk.api.data.WOWZDataType.STRING     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.player.WOWZPlayerView.C424815.<clinit>():void");
        }
    }

    public WOWZDataMap getMetadata() {
        if (!this.f3855e.isHLSEnabled() && !this.f3863m) {
            return this.f3871u.mo59627h();
        }
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        wOWZDataMap.put("Height", this.f3870t.getVideoHeight());
        wOWZDataMap.put("Width", this.f3870t.getVideoWidth());
        return wOWZDataMap;
    }

    /* renamed from: j */
    private boolean m3688j() {
        return isPlaying() && getMetadata() != null && !getMetadata().containsKey("duration");
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap, WOWZDataEvent.ResultCallback resultCallback) {
        this.f3871u.mo59607a(wOWZDataScope, str, wOWZDataMap, resultCallback);
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str, WOWZDataEvent.ResultCallback resultCallback) {
        sendDataEvent(wOWZDataScope, str, (WOWZDataMap) null, resultCallback);
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap) {
        sendDataEvent(wOWZDataScope, str, wOWZDataMap, (WOWZDataEvent.ResultCallback) null);
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str) {
        sendDataEvent(wOWZDataScope, str, (WOWZDataMap) null, (WOWZDataEvent.ResultCallback) null);
    }

    public void registerDataEventListener(String str, WOWZDataEvent.EventListener eventListener) {
        if (!this.f3852H.containsKey(str)) {
            this.f3852H.put(str, new ArrayList());
        }
        if (!this.f3852H.get(str).contains(eventListener)) {
            this.f3852H.get(str).add(eventListener);
        }
        this.f3871u.mo59608a(str, eventListener);
    }

    public void setShowAllNotificationsWhenBelowThreshold(boolean z) {
        this.f3868r.mo59181a(z);
    }

    public void setMinimumPacketThreshold(int i) {
        this.f3868r.mo59188b(i);
    }

    public void registerPacketThresholdListener(PacketThresholdChangeListener packetThresholdChangeListener) {
        this.f3868r.mo59179a(packetThresholdChangeListener);
    }

    public void unregisterDataEventListener(String str, WOWZDataEvent.EventListener eventListener) {
        if (this.f3852H.containsKey(str) && this.f3852H.get(str).contains(eventListener)) {
            this.f3852H.get(str).remove(eventListener);
            if (this.f3852H.get(str).size() == 0) {
                this.f3852H.remove(str);
            }
        }
        if (isPlaying()) {
            this.f3871u.mo59611b(str, eventListener);
        }
    }

    /* renamed from: k */
    private void m3689k() {
        for (String next : this.f3852H.keySet()) {
            Iterator it = this.f3852H.get(next).iterator();
            while (it.hasNext()) {
                this.f3871u.mo59608a(next, (WOWZDataEvent.EventListener) it.next());
            }
        }
    }

    /* renamed from: l */
    private void m3692l() {
        this.f3871u.mo59615f();
    }

    public WOWZDataMap getStreamStats() {
        long j;
        int i;
        WOWZDataMap wOWZDataMap;
        WOWZDataMap wOWZDataMap2;
        WOWZDataMap wOWZDataMap3;
        if (!isPlaying()) {
            return null;
        }
        if (this.f3855e.isHLSEnabled() || this.f3863m) {
            WOWZDataMap wOWZDataMap4 = new WOWZDataMap();
            wOWZDataMap4.put("Duration", this.f3870t.getDuration() == -1 ? "Live" : String.valueOf(this.f3870t.getDuration()));
            wOWZDataMap4.put("Position", this.f3870t.getCurrentPosition());
            return wOWZDataMap4;
        }
        int i2 = 0;
        if (!this.f3855e.isVideoEnabled() || !this.f3868r.mo59151f().isRunning()) {
            j = 0;
            i = 0;
        } else {
            long j2 = (long) 0;
            i = (int) (this.f3868r.mo59165s() + j2);
            i2 = (int) (j2 + this.f3868r.mo59167u());
            j = this.f3868r.mo59158m();
        }
        if (this.f3855e.isAudioEnabled() && this.f3869s.mo59151f().isRunning()) {
            i = (int) (((long) i) + this.f3869s.mo59165s());
            i2 = (int) (((long) i2) + this.f3869s.mo59167u());
            if (j == 0) {
                j = this.f3869s.mo59158m();
            }
        }
        this.f3876z.put("elapsedTimeMs", j);
        if (!this.f3876z.containsKey("networkStatistics")) {
            wOWZDataMap = new WOWZDataMap();
            this.f3876z.put("networkStatistics", (WOWZData) wOWZDataMap);
        } else {
            wOWZDataMap = (WOWZDataMap) this.f3876z.get("networkStatistics");
        }
        wOWZDataMap.put("bytesReceived", i);
        wOWZDataMap.put("bytesBuffered", i2);
        if (this.f3855e.isVideoEnabled() && this.f3868r.mo59151f().isRunning()) {
            if (!this.f3876z.containsKey("videoStatistics")) {
                wOWZDataMap3 = new WOWZDataMap();
                this.f3876z.put("videoStatistics", (WOWZData) wOWZDataMap3);
            } else {
                wOWZDataMap3 = (WOWZDataMap) this.f3876z.get("videoStatistics");
            }
            wOWZDataMap3.put("framesReceived", this.f3868r.mo59163r());
            wOWZDataMap3.put("framesRendered", this.f3868r.mo59109C());
            wOWZDataMap3.put("framesDropped", this.f3868r.mo59112F());
            wOWZDataMap3.put("framesBuffered", this.f3868r.mo59166t());
            wOWZDataMap3.put("frameRateActual", this.f3868r.mo59111E());
            wOWZDataMap3.put("bytesReceived", this.f3868r.mo59165s());
            wOWZDataMap3.put("bytesRendered", this.f3868r.mo59110D());
            wOWZDataMap3.put("bytesDropped", this.f3868r.mo59113G());
            wOWZDataMap3.put("bytesBuffered", this.f3868r.mo59167u());
            if (this.f3855e.isVideoEnabled() && this.f3855e.isAudioEnabled() && this.f3869s.mo59151f().isRunning()) {
                long U = this.f3868r.mo59127U();
                long U2 = this.f3869s.mo59127U();
                long j3 = U - U2;
                wOWZDataMap3.put("videoDriftMs", j3);
                WOWZLog.debug(f3843c, "Elapsed time = " + C4300a.m4214a(j));
                WOWZLog.debug(f3843c, "Video current timecode = " + C4300a.m4214a(U));
                WOWZLog.debug(f3843c, "Audio current timecode = " + C4300a.m4214a(U2));
                WOWZLog.debug(f3843c, "Video drift = " + C4300a.m4214a(j3));
            }
        } else if (this.f3876z.containsKey("videoStatistics")) {
            this.f3876z.remove("videoStatistics");
        }
        if (this.f3855e.isAudioEnabled() && this.f3869s.mo59151f().isRunning()) {
            if (!this.f3876z.containsKey(MimeTypes.BASE_TYPE_AUDIO)) {
                wOWZDataMap2 = new WOWZDataMap();
                this.f3876z.put("audioStatistics", (WOWZData) wOWZDataMap2);
            } else {
                wOWZDataMap2 = (WOWZDataMap) this.f3876z.get("audioStatistics");
            }
            wOWZDataMap2.put("samplesReceived", this.f3869s.mo59163r());
            wOWZDataMap2.put("samplesBuffered", this.f3869s.mo59166t());
            wOWZDataMap2.put("bytesReceived", this.f3869s.mo59165s());
            wOWZDataMap2.put("bytesBuffered", this.f3869s.mo59167u());
        } else if (this.f3876z.containsKey("audioStatistics")) {
            this.f3876z.remove("audioStatistics");
        }
        return this.f3876z;
    }

    public void sendPingRequest(WOWZDataEvent.ResultCallback resultCallback) {
        if (this.f3857g.isRunning()) {
            this.f3871u.mo59606a(resultCallback);
        }
    }

    public void setMaxSecondsOfAudioLatency(int i) {
        if (i < 1) {
            i = 1;
        }
        C4289c cVar = this.f3869s;
        if (i > 3) {
            i = 3;
        }
        this.f3869s.mo59189c(i);
    }
}
