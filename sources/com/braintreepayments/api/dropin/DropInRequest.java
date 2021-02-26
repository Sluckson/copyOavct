package com.braintreepayments.api.dropin;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.models.GooglePaymentRequest;
import com.braintreepayments.api.models.PayPalRequest;

public class DropInRequest implements Parcelable {
    public static final Parcelable.Creator<DropInRequest> CREATOR = new Parcelable.Creator<DropInRequest>() {
        public DropInRequest createFromParcel(Parcel parcel) {
            return new DropInRequest(parcel);
        }

        public DropInRequest[] newArray(int i) {
            return new DropInRequest[i];
        }
    };
    public static final String EXTRA_CHECKOUT_REQUEST = "com.braintreepayments.api.EXTRA_CHECKOUT_REQUEST";
    private String mAmount;
    private String mAuthorization;
    private boolean mCardEnabled = true;
    private int mCardholderNameStatus = 0;
    private boolean mCollectDeviceData;
    private boolean mDefaultVaultValue = true;
    private boolean mGooglePaymentEnabled = true;
    private GooglePaymentRequest mGooglePaymentRequest;
    private boolean mMaskCardNumber = false;
    private boolean mMaskSecurityCode = false;
    private boolean mPayPalEnabled = true;
    private PayPalRequest mPayPalRequest;
    private boolean mRequestThreeDSecureVerification;
    private boolean mShowCheckBoxToAllowVaultOverride = false;
    private boolean mVaultManagerEnabled = false;
    private boolean mVenmoEnabled = true;

    public int describeContents() {
        return 0;
    }

    public DropInRequest() {
    }

    public DropInRequest clientToken(String str) {
        this.mAuthorization = str;
        return this;
    }

    public DropInRequest tokenizationKey(String str) {
        this.mAuthorization = str;
        return this;
    }

    public DropInRequest amount(String str) {
        this.mAmount = str;
        return this;
    }

    public DropInRequest collectDeviceData(boolean z) {
        this.mCollectDeviceData = z;
        return this;
    }

    public DropInRequest googlePaymentRequest(GooglePaymentRequest googlePaymentRequest) {
        this.mGooglePaymentRequest = googlePaymentRequest;
        return this;
    }

    public DropInRequest paypalRequest(PayPalRequest payPalRequest) {
        this.mPayPalRequest = payPalRequest;
        return this;
    }

    public DropInRequest disableGooglePayment() {
        this.mGooglePaymentEnabled = false;
        return this;
    }

    public DropInRequest disablePayPal() {
        this.mPayPalEnabled = false;
        return this;
    }

    public DropInRequest disableVenmo() {
        this.mVenmoEnabled = false;
        return this;
    }

    public DropInRequest disableCard() {
        this.mCardEnabled = false;
        return this;
    }

    public DropInRequest requestThreeDSecureVerification(boolean z) {
        this.mRequestThreeDSecureVerification = z;
        return this;
    }

    public DropInRequest maskCardNumber(boolean z) {
        this.mMaskCardNumber = z;
        return this;
    }

    public DropInRequest maskSecurityCode(boolean z) {
        this.mMaskSecurityCode = z;
        return this;
    }

    public DropInRequest vaultManager(boolean z) {
        this.mVaultManagerEnabled = z;
        return this;
    }

    public DropInRequest vaultCard(boolean z) {
        this.mDefaultVaultValue = z;
        return this;
    }

    public DropInRequest allowVaultCardOverride(boolean z) {
        this.mShowCheckBoxToAllowVaultOverride = z;
        return this;
    }

    public DropInRequest cardholderNameStatus(int i) {
        this.mCardholderNameStatus = i;
        return this;
    }

    public Intent getIntent(Context context) {
        return new Intent(context, DropInActivity.class).putExtra(EXTRA_CHECKOUT_REQUEST, this);
    }

    public String getAuthorization() {
        return this.mAuthorization;
    }

    /* access modifiers changed from: package-private */
    public String getAmount() {
        return this.mAmount;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldCollectDeviceData() {
        return this.mCollectDeviceData;
    }

    public boolean isPayPalEnabled() {
        return this.mPayPalEnabled;
    }

    public PayPalRequest getPayPalRequest() {
        return this.mPayPalRequest;
    }

    public boolean isVenmoEnabled() {
        return this.mVenmoEnabled;
    }

    public boolean isCardEnabled() {
        return this.mCardEnabled;
    }

    public GooglePaymentRequest getGooglePaymentRequest() {
        return this.mGooglePaymentRequest;
    }

    public boolean isGooglePaymentEnabled() {
        return this.mGooglePaymentEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRequestThreeDSecureVerification() {
        return this.mRequestThreeDSecureVerification;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMaskCardNumber() {
        return this.mMaskCardNumber;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMaskSecurityCode() {
        return this.mMaskSecurityCode;
    }

    /* access modifiers changed from: package-private */
    public boolean isVaultManagerEnabled() {
        return this.mVaultManagerEnabled;
    }

    public int getCardholderNameStatus() {
        return this.mCardholderNameStatus;
    }

    public boolean getDefaultVaultSetting() {
        return this.mDefaultVaultValue;
    }

    public boolean isSaveCardCheckBoxShown() {
        return this.mShowCheckBoxToAllowVaultOverride;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAuthorization);
        parcel.writeString(this.mAmount);
        parcel.writeByte(this.mCollectDeviceData ? (byte) 1 : 0);
        parcel.writeParcelable(this.mGooglePaymentRequest, 0);
        parcel.writeByte(this.mGooglePaymentEnabled ? (byte) 1 : 0);
        parcel.writeParcelable(this.mPayPalRequest, 0);
        parcel.writeByte(this.mPayPalEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.mVenmoEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.mCardEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.mRequestThreeDSecureVerification ? (byte) 1 : 0);
        parcel.writeByte(this.mMaskCardNumber ? (byte) 1 : 0);
        parcel.writeByte(this.mMaskSecurityCode ? (byte) 1 : 0);
        parcel.writeByte(this.mVaultManagerEnabled ? (byte) 1 : 0);
        parcel.writeInt(this.mCardholderNameStatus);
        parcel.writeByte(this.mDefaultVaultValue ? (byte) 1 : 0);
        parcel.writeByte(this.mShowCheckBoxToAllowVaultOverride ? (byte) 1 : 0);
    }

    protected DropInRequest(Parcel parcel) {
        boolean z = true;
        this.mAuthorization = parcel.readString();
        this.mAmount = parcel.readString();
        this.mCollectDeviceData = parcel.readByte() != 0;
        this.mGooglePaymentRequest = (GooglePaymentRequest) parcel.readParcelable(GooglePaymentRequest.class.getClassLoader());
        this.mGooglePaymentEnabled = parcel.readByte() != 0;
        this.mPayPalRequest = (PayPalRequest) parcel.readParcelable(PayPalRequest.class.getClassLoader());
        this.mPayPalEnabled = parcel.readByte() != 0;
        this.mVenmoEnabled = parcel.readByte() != 0;
        this.mCardEnabled = parcel.readByte() != 0;
        this.mRequestThreeDSecureVerification = parcel.readByte() != 0;
        this.mMaskCardNumber = parcel.readByte() != 0;
        this.mMaskSecurityCode = parcel.readByte() != 0;
        this.mVaultManagerEnabled = parcel.readByte() != 0;
        this.mCardholderNameStatus = parcel.readInt();
        this.mDefaultVaultValue = parcel.readByte() != 0;
        this.mShowCheckBoxToAllowVaultOverride = parcel.readByte() == 0 ? false : z;
    }
}
