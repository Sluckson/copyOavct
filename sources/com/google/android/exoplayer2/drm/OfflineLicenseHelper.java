package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.UUID;

public final class OfflineLicenseHelper<T extends ExoMediaCrypto> {
    private static final DrmInitData DUMMY_DRM_INIT_DATA = new DrmInitData(new DrmInitData.SchemeData[0]);
    /* access modifiers changed from: private */
    public final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager<T> drmSessionManager;
    private final HandlerThread handlerThread = new HandlerThread("OfflineLicenseHelper");

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        return newWidevineInstance(str, false, factory, (HashMap<String, String>) null);
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        return newWidevineInstance(str, z, factory, (HashMap<String, String>) null);
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory, @Nullable HashMap<String, String> hashMap) throws UnsupportedDrmException {
        return new OfflineLicenseHelper<>(C1119C.WIDEVINE_UUID, FrameworkMediaDrm.newInstance(C1119C.WIDEVINE_UUID), new HttpMediaDrmCallback(str, z, factory), hashMap);
    }

    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap) {
        this.handlerThread.start();
        this.conditionVariable = new ConditionVariable();
        C11521 r0 = new DefaultDrmSessionEventListener() {
            public /* synthetic */ void onDrmSessionAcquired() {
                DefaultDrmSessionEventListener.CC.$default$onDrmSessionAcquired(this);
            }

            public /* synthetic */ void onDrmSessionReleased() {
                DefaultDrmSessionEventListener.CC.$default$onDrmSessionReleased(this);
            }

            public void onDrmKeysLoaded() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmSessionManagerError(Exception exc) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRestored() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRemoved() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }
        };
        this.drmSessionManager = new DefaultDrmSessionManager<>(uuid, exoMediaDrm, mediaDrmCallback, hashMap);
        this.drmSessionManager.addListener(new Handler(this.handlerThread.getLooper()), r0);
    }

    public synchronized byte[] getPropertyByteArray(String str) {
        return this.drmSessionManager.getPropertyByteArray(str);
    }

    public synchronized void setPropertyByteArray(String str, byte[] bArr) {
        this.drmSessionManager.setPropertyByteArray(str, bArr);
    }

    public synchronized String getPropertyString(String str) {
        return this.drmSessionManager.getPropertyString(str);
    }

    public synchronized void setPropertyString(String str, String str2) {
        this.drmSessionManager.setPropertyString(str, str2);
    }

    public synchronized byte[] downloadLicense(DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        Assertions.checkArgument(drmInitData != null);
        return blockingKeyRequest(2, (byte[]) null, drmInitData);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return blockingKeyRequest(2, bArr, DUMMY_DRM_INIT_DATA);
    }

    public synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        blockingKeyRequest(3, bArr, DUMMY_DRM_INIT_DATA);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(1, bArr, DUMMY_DRM_INIT_DATA);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(openBlockingKeyRequest);
        this.drmSessionManager.releaseSession(openBlockingKeyRequest);
        if (error == null) {
            return (Pair) Assertions.checkNotNull(licenseDurationRemainingSec);
        } else if (error.getCause() instanceof KeysExpiredException) {
            return Pair.create(0L, 0L);
        } else {
            throw error;
        }
    }

    public void release() {
        this.handlerThread.quit();
    }

    private byte[] blockingKeyRequest(int i, @Nullable byte[] bArr, DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(i, bArr, drmInitData);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        byte[] offlineLicenseKeySetId = openBlockingKeyRequest.getOfflineLicenseKeySetId();
        this.drmSessionManager.releaseSession(openBlockingKeyRequest);
        if (error == null) {
            return (byte[]) Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        throw error;
    }

    private DrmSession<T> openBlockingKeyRequest(int i, @Nullable byte[] bArr, DrmInitData drmInitData) {
        this.drmSessionManager.setMode(i, bArr);
        this.conditionVariable.close();
        DrmSession<T> acquireSession = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), drmInitData);
        this.conditionVariable.block();
        return acquireSession;
    }
}
