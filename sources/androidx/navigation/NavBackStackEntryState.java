package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new Parcelable.Creator<NavBackStackEntryState>() {
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        public NavBackStackEntryState[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }
    };
    private final Bundle mArgs;
    private final int mDestinationId;
    private final Bundle mSavedState;
    private final UUID mUUID;

    public int describeContents() {
        return 0;
    }

    NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.mUUID = navBackStackEntry.mId;
        this.mDestinationId = navBackStackEntry.getDestination().getId();
        this.mArgs = navBackStackEntry.getArguments();
        this.mSavedState = new Bundle();
        navBackStackEntry.saveState(this.mSavedState);
    }

    NavBackStackEntryState(Parcel parcel) {
        this.mUUID = UUID.fromString(parcel.readString());
        this.mDestinationId = parcel.readInt();
        this.mArgs = parcel.readBundle(getClass().getClassLoader());
        this.mSavedState = parcel.readBundle(getClass().getClassLoader());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public UUID getUUID() {
        return this.mUUID;
    }

    /* access modifiers changed from: package-private */
    public int getDestinationId() {
        return this.mDestinationId;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Bundle getArgs() {
        return this.mArgs;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Bundle getSavedState() {
        return this.mSavedState;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mUUID.toString());
        parcel.writeInt(this.mDestinationId);
        parcel.writeBundle(this.mArgs);
        parcel.writeBundle(this.mSavedState);
    }
}
