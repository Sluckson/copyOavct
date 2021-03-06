package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs;
    private final Context context;
    @Nullable
    private DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private boolean enableDecoderFallback;
    private int extensionRendererMode;
    private MediaCodecSelector mediaCodecSelector;
    private boolean playClearSamplesWithoutKeys;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public DefaultRenderersFactory(Context context2) {
        this.context = context2;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2) {
        this(context2, drmSessionManager2, 0);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i) {
        this(context2, i, (long) DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i) {
        this(context2, drmSessionManager2, i, DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i, long j) {
        this(context2, (DrmSessionManager<FrameworkMediaCrypto>) null, i, j);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i, long j) {
        this.context = context2;
        this.extensionRendererMode = i;
        this.allowedVideoJoiningTimeMs = j;
        this.drmSessionManager = drmSessionManager2;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.extensionRendererMode = i;
        return this;
    }

    public DefaultRenderersFactory setPlayClearSamplesWithoutKeys(boolean z) {
        this.playClearSamplesWithoutKeys = z;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.enableDecoderFallback = z;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector2) {
        this.mediaCodecSelector = mediaCodecSelector2;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.allowedVideoJoiningTimeMs = j;
        return this;
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2) {
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager3 = drmSessionManager2 == null ? this.drmSessionManager : drmSessionManager2;
        ArrayList arrayList = new ArrayList();
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager4 = drmSessionManager3;
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, drmSessionManager4, this.playClearSamplesWithoutKeys, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, drmSessionManager4, this.playClearSamplesWithoutKeys, this.enableDecoderFallback, buildAudioProcessors(), handler, audioRendererEventListener, arrayList);
        ArrayList arrayList2 = arrayList;
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    public void buildVideoRenderers(Context context2, int i, MediaCodecSelector mediaCodecSelector2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, boolean z, boolean z2, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        int i2 = i;
        ArrayList<Renderer> arrayList2 = arrayList;
        arrayList2.add(new MediaCodecVideoRenderer(context2, mediaCodecSelector2, j, drmSessionManager2, z, z2, handler, videoRendererEventListener, 50));
        if (i2 != 0) {
            int size = arrayList.size();
            if (i2 == 2) {
                size--;
            }
            try {
                arrayList2.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE}).newInstance(new Object[]{Long.valueOf(j), handler, videoRendererEventListener, 50}));
                Log.m52i(TAG, "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused) {
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating VP9 extension", e);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0067, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0067 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:19:0x0073] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r15, int r16, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r17, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> r18, boolean r19, boolean r20, com.google.android.exoplayer2.audio.AudioProcessor[] r21, android.os.Handler r22, com.google.android.exoplayer2.audio.AudioRendererEventListener r23, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r24) {
        /*
            r14 = this;
            r0 = r16
            r1 = r21
            r11 = r24
            java.lang.String r12 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer r13 = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer
            com.google.android.exoplayer2.audio.DefaultAudioSink r10 = new com.google.android.exoplayer2.audio.DefaultAudioSink
            com.google.android.exoplayer2.audio.AudioCapabilities r2 = com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(r15)
            r10.<init>(r2, r1)
            r2 = r13
            r3 = r15
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r22
            r9 = r23
            r2.<init>((android.content.Context) r3, (com.google.android.exoplayer2.mediacodec.MediaCodecSelector) r4, (com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto>) r5, (boolean) r6, (boolean) r7, (android.os.Handler) r8, (com.google.android.exoplayer2.audio.AudioRendererEventListener) r9, (com.google.android.exoplayer2.audio.AudioSink) r10)
            r11.add(r13)
            if (r0 != 0) goto L_0x002a
            return
        L_0x002a:
            int r2 = r24.size()
            r3 = 2
            if (r0 != r3) goto L_0x0033
            int r2 = r2 + -1
        L_0x0033:
            r0 = 0
            r4 = 3
            r5 = 1
            java.lang.String r6 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r8 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioProcessor[]> r8 = com.google.android.exoplayer2.audio.AudioProcessor[].class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            r7[r0] = r22     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            r7[r5] = r23     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            r7[r3] = r1     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            com.google.android.exoplayer2.Renderer r6 = (com.google.android.exoplayer2.Renderer) r6     // Catch:{ ClassNotFoundException -> 0x0070, Exception -> 0x0067 }
            int r7 = r2 + 1
            r11.add(r2, r6)     // Catch:{ ClassNotFoundException -> 0x0071, Exception -> 0x0067 }
            java.lang.String r2 = "Loaded LibopusAudioRenderer."
            com.google.android.exoplayer2.util.Log.m52i(r12, r2)     // Catch:{ ClassNotFoundException -> 0x0071, Exception -> 0x0067 }
            goto L_0x0071
        L_0x0067:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0070:
            r7 = r2
        L_0x0071:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r6[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r8 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioProcessor[]> r8 = com.google.android.exoplayer2.audio.AudioProcessor[].class
            r6[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            r6[r0] = r22     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            r6[r5] = r23     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            r6[r3] = r1     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            com.google.android.exoplayer2.Renderer r2 = (com.google.android.exoplayer2.Renderer) r2     // Catch:{ ClassNotFoundException -> 0x00ab, Exception -> 0x00a2 }
            int r6 = r7 + 1
            r11.add(r7, r2)     // Catch:{ ClassNotFoundException -> 0x00ac, Exception -> 0x00a2 }
            java.lang.String r2 = "Loaded LibflacAudioRenderer."
            com.google.android.exoplayer2.util.Log.m52i(r12, r2)     // Catch:{ ClassNotFoundException -> 0x00ac, Exception -> 0x00a2 }
            goto L_0x00ac
        L_0x00a2:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00ab:
            r6 = r7
        L_0x00ac:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r8 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioProcessor[]> r8 = com.google.android.exoplayer2.audio.AudioProcessor[].class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            r4[r0] = r22     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            r4[r5] = r23     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            r4[r3] = r1     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            r11.add(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.google.android.exoplayer2.util.Log.m52i(r12, r0)     // Catch:{ ClassNotFoundException -> 0x00e4, Exception -> 0x00db }
            goto L_0x00e4
        L_0x00db:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager, boolean, boolean, com.google.android.exoplayer2.audio.AudioProcessor[], android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildCameraMotionRenderers(Context context2, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }
}
