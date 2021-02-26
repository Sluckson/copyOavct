package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EventDispatcher;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class DefaultDrmSessionManager<T extends ExoMediaCrypto> implements DrmSessionManager<T>, DefaultDrmSession.ProvisioningManager<T> {
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    private static final String TAG = "DefaultDrmSessionMgr";
    private final MediaDrmCallback callback;
    private final EventDispatcher<DefaultDrmSessionEventListener> eventDispatcher;
    private final int initialDrmRequestRetryCount;
    private final ExoMediaDrm<T> mediaDrm;
    @Nullable
    volatile DefaultDrmSessionManager<T>.MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    @Nullable
    private byte[] offlineLicenseKeySetId;
    @Nullable
    private final HashMap<String, String> optionalKeyRequestParameters;
    @Nullable
    private Looper playbackLooper;
    private final List<DefaultDrmSession<T>> provisioningSessions;
    /* access modifiers changed from: private */
    public final List<DefaultDrmSession<T>> sessions;
    private final UUID uuid;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap) throws UnsupportedDrmException {
        return newFrameworkInstance(C1119C.WIDEVINE_UUID, mediaDrmCallback, hashMap);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback mediaDrmCallback, @Nullable String str) throws UnsupportedDrmException {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str)) {
            hashMap = new HashMap();
            hashMap.put(PLAYREADY_CUSTOM_DATA_KEY, str);
        } else {
            hashMap = null;
        }
        return newFrameworkInstance(C1119C.PLAYREADY_UUID, mediaDrmCallback, hashMap);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID uuid2, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap) throws UnsupportedDrmException {
        return new DefaultDrmSessionManager(uuid2, FrameworkMediaDrm.newInstance(uuid2), mediaDrmCallback, hashMap, false, 3);
    }

    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap) {
        this(uuid2, exoMediaDrm, mediaDrmCallback, hashMap, false, 3);
    }

    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap, boolean z) {
        this(uuid2, exoMediaDrm, mediaDrmCallback, hashMap, z, 3);
    }

    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap, boolean z, int i) {
        Assertions.checkNotNull(uuid2);
        Assertions.checkNotNull(exoMediaDrm);
        Assertions.checkArgument(!C1119C.COMMON_PSSH_UUID.equals(uuid2), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid2;
        this.mediaDrm = exoMediaDrm;
        this.callback = mediaDrmCallback;
        this.optionalKeyRequestParameters = hashMap;
        this.eventDispatcher = new EventDispatcher<>();
        this.multiSession = z;
        this.initialDrmRequestRetryCount = i;
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
        if (z && C1119C.WIDEVINE_UUID.equals(uuid2) && Util.SDK_INT >= 19) {
            exoMediaDrm.setPropertyString("sessionSharing", "enable");
        }
        exoMediaDrm.setOnEventListener(new MediaDrmEventListener());
    }

    public final void addListener(Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this.eventDispatcher.addListener(handler, defaultDrmSessionEventListener);
    }

    public final void removeListener(DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this.eventDispatcher.removeListener(defaultDrmSessionEventListener);
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public void setMode(int i, @Nullable byte[] bArr) {
        Assertions.checkState(this.sessions.isEmpty());
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.mode = i;
        this.offlineLicenseKeySetId = bArr;
    }

    public boolean canAcquireSession(DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeDatas(drmInitData, this.uuid, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C1119C.COMMON_PSSH_UUID)) {
                return false;
            }
            Log.m54w(TAG, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        String str = drmInitData.schemeType;
        if (str == null || C1119C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        if ((C1119C.CENC_TYPE_cbc1.equals(str) || C1119C.CENC_TYPE_cbcs.equals(str) || C1119C.CENC_TYPE_cens.equals(str)) && Util.SDK_INT < 25) {
            return false;
        }
        return true;
    }

    public DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData) {
        List<DrmInitData.SchemeData> list;
        DefaultDrmSession defaultDrmSession;
        Looper looper2 = this.playbackLooper;
        Assertions.checkState(looper2 == null || looper2 == looper);
        if (this.sessions.isEmpty()) {
            this.playbackLooper = looper;
            if (this.mediaDrmHandler == null) {
                this.mediaDrmHandler = new MediaDrmHandler(looper);
            }
        }
        DefaultDrmSession defaultDrmSession2 = null;
        if (this.offlineLicenseKeySetId == null) {
            List<DrmInitData.SchemeData> schemeDatas = getSchemeDatas(drmInitData, this.uuid, false);
            if (schemeDatas.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.uuid);
                this.eventDispatcher.dispatch(new EventDispatcher.Event() {
                    public final void sendTo(Object obj) {
                        ((DefaultDrmSessionEventListener) obj).onDrmSessionManagerError(DefaultDrmSessionManager.MissingSchemeDataException.this);
                    }
                });
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
            list = schemeDatas;
        } else {
            list = null;
        }
        if (this.multiSession) {
            Iterator<DefaultDrmSession<T>> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (Util.areEqual(next.schemeDatas, list)) {
                    defaultDrmSession2 = next;
                    break;
                }
            }
        } else if (!this.sessions.isEmpty()) {
            defaultDrmSession2 = this.sessions.get(0);
        }
        if (defaultDrmSession2 == null) {
            defaultDrmSession = new DefaultDrmSession(this.uuid, this.mediaDrm, this, list, this.mode, this.offlineLicenseKeySetId, this.optionalKeyRequestParameters, this.callback, looper, this.eventDispatcher, this.initialDrmRequestRetryCount);
            this.sessions.add(defaultDrmSession);
        } else {
            defaultDrmSession = defaultDrmSession2;
        }
        defaultDrmSession.acquire();
        return defaultDrmSession;
    }

    public void releaseSession(DrmSession<T> drmSession) {
        if (!(drmSession instanceof ErrorStateDrmSession)) {
            DefaultDrmSession<T> defaultDrmSession = (DefaultDrmSession) drmSession;
            if (defaultDrmSession.release()) {
                this.sessions.remove(defaultDrmSession);
                if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession) {
                    this.provisioningSessions.get(1).provision();
                }
                this.provisioningSessions.remove(defaultDrmSession);
            }
        }
    }

    public void provisionRequired(DefaultDrmSession<T> defaultDrmSession) {
        if (!this.provisioningSessions.contains(defaultDrmSession)) {
            this.provisioningSessions.add(defaultDrmSession);
            if (this.provisioningSessions.size() == 1) {
                defaultDrmSession.provision();
            }
        }
    }

    public void onProvisionCompleted() {
        for (DefaultDrmSession<T> onProvisionCompleted : this.provisioningSessions) {
            onProvisionCompleted.onProvisionCompleted();
        }
        this.provisioningSessions.clear();
    }

    public void onProvisionError(Exception exc) {
        for (DefaultDrmSession<T> onProvisionError : this.provisioningSessions) {
            onProvisionError.onProvisionError(exc);
        }
        this.provisioningSessions.clear();
    }

    private static List<DrmInitData.SchemeData> getSchemeDatas(DrmInitData drmInitData, UUID uuid2, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid2) || (C1119C.CLEARKEY_UUID.equals(uuid2) && schemeData.matches(C1119C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @SuppressLint({"HandlerLeak"})
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.sessions) {
                    if (defaultDrmSession.hasSessionId(bArr)) {
                        defaultDrmSession.onMediaDrmEvent(message.what);
                        return;
                    }
                }
            }
        }
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener<T> {
        private MediaDrmEventListener() {
        }

        public void onEvent(ExoMediaDrm<? extends T> exoMediaDrm, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2) {
            ((MediaDrmHandler) Assertions.checkNotNull(DefaultDrmSessionManager.this.mediaDrmHandler)).obtainMessage(i, bArr).sendToTarget();
        }
    }
}
