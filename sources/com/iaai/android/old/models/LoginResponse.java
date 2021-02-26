package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

public class LoginResponse implements Parcelable {
    public static final Parcelable.Creator<LoginResponse> CREATOR = new Parcelable.Creator<LoginResponse>() {
        public LoginResponse createFromParcel(Parcel parcel) {
            return new LoginResponse(parcel);
        }

        public LoginResponse[] newArray(int i) {
            return new LoginResponse[i];
        }
    };
    @JsonProperty("IsLicensedBusinessAccount")
    public boolean IsLicensedBusinessAccount;
    @JsonProperty("IsPublic")
    public boolean IsPublic;
    public String addtional_bidder_owner;
    @JsonProperty("buyerEmployeeId")
    public String buyerEmployeeId;
    @JsonProperty("buyerId")
    public String buyerId;
    public String fName;
    @JsonProperty("isAFC")
    public boolean isAFC;
    @JsonIgnore
    public boolean isAcceptTermsAndCondition;
    @JsonIgnore
    public boolean isOwner;
    @JsonProperty("IsTermsAndConditionsUpdated")
    public Boolean isTermsAndConditionsUpdated = false;
    public String lName;
    @JsonProperty("lbsParentIndicator")
    public boolean lbsParentIndicator;
    public String message;
    @JsonProperty("StatusCode")
    public String statusCode;
    @JsonProperty("userID")
    public String userId;
    public String zipCode;

    public int describeContents() {
        return 0;
    }

    public LoginResponse() {
    }

    public LoginResponse(Parcel parcel) {
        this.isOwner = ParcelUtils.readBoolean(parcel);
        this.message = parcel.readString();
        this.userId = parcel.readString();
        this.zipCode = parcel.readString();
        this.addtional_bidder_owner = parcel.readString();
        this.isAFC = ParcelUtils.readBoolean(parcel);
        this.IsLicensedBusinessAccount = ParcelUtils.readBoolean(parcel);
        this.IsPublic = ParcelUtils.readBoolean(parcel);
        this.lbsParentIndicator = ParcelUtils.readBoolean(parcel);
        this.buyerId = parcel.readString();
        this.fName = parcel.readString();
        this.lName = parcel.readString();
        this.isAcceptTermsAndCondition = ParcelUtils.readBoolean(parcel);
        this.statusCode = parcel.readString();
        this.isTermsAndConditionsUpdated = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
    }

    @JsonSetter("owner")
    public void setOwner(String str) {
        this.addtional_bidder_owner = str;
        this.isOwner = ParcelUtils.isTrue(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.isOwner);
        parcel.writeString(this.message);
        parcel.writeString(this.userId);
        parcel.writeString(this.zipCode);
        parcel.writeString(this.addtional_bidder_owner);
        ParcelUtils.writeBoolean(parcel, this.isAFC);
        ParcelUtils.writeBoolean(parcel, this.IsLicensedBusinessAccount);
        ParcelUtils.writeBoolean(parcel, this.IsPublic);
        ParcelUtils.writeBoolean(parcel, this.lbsParentIndicator);
        parcel.writeString(this.buyerId);
        parcel.writeString(this.fName);
        parcel.writeString(this.lName);
        ParcelUtils.writeBoolean(parcel, this.isAcceptTermsAndCondition);
        parcel.writeString(this.statusCode);
        ParcelUtils.writeBoolean(parcel, this.isTermsAndConditionsUpdated.booleanValue());
    }
}
