package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public class ThreeDSecureInfo implements Parcelable {
    public static final Parcelable.Creator<ThreeDSecureInfo> CREATOR = new Parcelable.Creator<ThreeDSecureInfo>() {
        public ThreeDSecureInfo createFromParcel(Parcel parcel) {
            return new ThreeDSecureInfo(parcel);
        }

        public ThreeDSecureInfo[] newArray(int i) {
            return new ThreeDSecureInfo[i];
        }
    };
    private static final String LIABILITY_SHIFTED_KEY = "liabilityShifted";
    private static final String LIABILITY_SHIFT_POSSIBLE_KEY = "liabilityShiftPossible";
    private boolean mLiabilityShiftPossible;
    private boolean mLiabilityShifted;
    private boolean mWasVerified;

    public int describeContents() {
        return 0;
    }

    protected static ThreeDSecureInfo fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ThreeDSecureInfo threeDSecureInfo = new ThreeDSecureInfo();
        threeDSecureInfo.mLiabilityShifted = jSONObject.optBoolean(LIABILITY_SHIFTED_KEY);
        threeDSecureInfo.mLiabilityShiftPossible = jSONObject.optBoolean(LIABILITY_SHIFT_POSSIBLE_KEY);
        threeDSecureInfo.mWasVerified = jSONObject.has(LIABILITY_SHIFTED_KEY) && jSONObject.has(LIABILITY_SHIFT_POSSIBLE_KEY);
        return threeDSecureInfo;
    }

    public boolean isLiabilityShifted() {
        return this.mLiabilityShifted;
    }

    public boolean isLiabilityShiftPossible() {
        return this.mLiabilityShiftPossible;
    }

    public boolean wasVerified() {
        return this.mWasVerified;
    }

    public ThreeDSecureInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mLiabilityShifted ? (byte) 1 : 0);
        parcel.writeByte(this.mLiabilityShiftPossible ? (byte) 1 : 0);
        parcel.writeByte(this.mWasVerified ? (byte) 1 : 0);
    }

    private ThreeDSecureInfo(Parcel parcel) {
        boolean z = true;
        this.mLiabilityShifted = parcel.readByte() != 0;
        this.mLiabilityShiftPossible = parcel.readByte() != 0;
        this.mWasVerified = parcel.readByte() == 0 ? false : z;
    }
}
