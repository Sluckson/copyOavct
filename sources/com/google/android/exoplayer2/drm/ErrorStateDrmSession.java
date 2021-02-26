package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public final class ErrorStateDrmSession<T extends ExoMediaCrypto> implements DrmSession<T> {
    private final DrmSession.DrmSessionException error;

    @Nullable
    public T getMediaCrypto() {
        return null;
    }

    @Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    public int getState() {
        return 1;
    }

    @Nullable
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(drmSessionException);
    }

    @Nullable
    public DrmSession.DrmSessionException getError() {
        return this.error;
    }
}
