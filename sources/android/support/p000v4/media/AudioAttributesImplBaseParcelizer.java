package android.support.p000v4.media;

import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: android.support.v4.media.AudioAttributesImplBaseParcelizer */
public final class AudioAttributesImplBaseParcelizer extends androidx.media.AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        return androidx.media.AudioAttributesImplBaseParcelizer.read(versionedParcel);
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        androidx.media.AudioAttributesImplBaseParcelizer.write(audioAttributesImplBase, versionedParcel);
    }
}
