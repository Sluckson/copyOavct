package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;

public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new Parcelable.Creator<TrackSelectionParameters>() {
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        public TrackSelectionParameters[] newArray(int i) {
            return new TrackSelectionParameters[i];
        }
    };
    public static final TrackSelectionParameters DEFAULT = new TrackSelectionParameters();
    public final int disabledTextTrackSelectionFlags;
    @Nullable
    public final String preferredAudioLanguage;
    @Nullable
    public final String preferredTextLanguage;
    public final boolean selectUndeterminedTextLanguage;

    public int describeContents() {
        return 0;
    }

    public static class Builder {
        int disabledTextTrackSelectionFlags;
        @Nullable
        String preferredAudioLanguage;
        @Nullable
        String preferredTextLanguage;
        boolean selectUndeterminedTextLanguage;

        public Builder() {
            this(TrackSelectionParameters.DEFAULT);
        }

        Builder(TrackSelectionParameters trackSelectionParameters) {
            this.preferredAudioLanguage = trackSelectionParameters.preferredAudioLanguage;
            this.preferredTextLanguage = trackSelectionParameters.preferredTextLanguage;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = trackSelectionParameters.disabledTextTrackSelectionFlags;
        }

        public Builder setPreferredAudioLanguage(@Nullable String str) {
            this.preferredAudioLanguage = str;
            return this;
        }

        public Builder setPreferredTextLanguage(@Nullable String str) {
            this.preferredTextLanguage = str;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.selectUndeterminedTextLanguage = z;
            return this;
        }

        public Builder setDisabledTextTrackSelectionFlags(int i) {
            this.disabledTextTrackSelectionFlags = i;
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags);
        }
    }

    TrackSelectionParameters() {
        this((String) null, (String) null, false, 0);
    }

    TrackSelectionParameters(@Nullable String str, @Nullable String str2, boolean z, int i) {
        this.preferredAudioLanguage = Util.normalizeLanguageCode(str);
        this.preferredTextLanguage = Util.normalizeLanguageCode(str2);
        this.selectUndeterminedTextLanguage = z;
        this.disabledTextTrackSelectionFlags = i;
    }

    TrackSelectionParameters(Parcel parcel) {
        this.preferredAudioLanguage = parcel.readString();
        this.preferredTextLanguage = parcel.readString();
        this.selectUndeterminedTextLanguage = Util.readBoolean(parcel);
        this.disabledTextTrackSelectionFlags = parcel.readInt();
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (!TextUtils.equals(this.preferredAudioLanguage, trackSelectionParameters.preferredAudioLanguage) || !TextUtils.equals(this.preferredTextLanguage, trackSelectionParameters.preferredTextLanguage) || this.selectUndeterminedTextLanguage != trackSelectionParameters.selectUndeterminedTextLanguage || this.disabledTextTrackSelectionFlags != trackSelectionParameters.disabledTextTrackSelectionFlags) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.preferredAudioLanguage;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.preferredTextLanguage;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode + i) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.preferredAudioLanguage);
        parcel.writeString(this.preferredTextLanguage);
        Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
        parcel.writeInt(this.disabledTextTrackSelectionFlags);
    }
}
