package com.google.firebase.inappmessaging.internal;

import com.google.firebase.installations.InstallationTokenResult;

final class AutoValue_InstallationIdResult extends InstallationIdResult {
    private final String installationId;
    private final InstallationTokenResult installationTokenResult;

    AutoValue_InstallationIdResult(String str, InstallationTokenResult installationTokenResult2) {
        if (str != null) {
            this.installationId = str;
            if (installationTokenResult2 != null) {
                this.installationTokenResult = installationTokenResult2;
                return;
            }
            throw new NullPointerException("Null installationTokenResult");
        }
        throw new NullPointerException("Null installationId");
    }

    /* access modifiers changed from: package-private */
    public String installationId() {
        return this.installationId;
    }

    /* access modifiers changed from: package-private */
    public InstallationTokenResult installationTokenResult() {
        return this.installationTokenResult;
    }

    public String toString() {
        return "InstallationIdResult{installationId=" + this.installationId + ", installationTokenResult=" + this.installationTokenResult + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationIdResult)) {
            return false;
        }
        InstallationIdResult installationIdResult = (InstallationIdResult) obj;
        if (!this.installationId.equals(installationIdResult.installationId()) || !this.installationTokenResult.equals(installationIdResult.installationTokenResult())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.installationId.hashCode() ^ 1000003) * 1000003) ^ this.installationTokenResult.hashCode();
    }
}
