package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.wallet.ShippingAddressRequirements;
import com.google.android.gms.wallet.TransactionInfo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class GooglePaymentRequest implements Parcelable {
    public static final Parcelable.Creator<GooglePaymentRequest> CREATOR = new Parcelable.Creator<GooglePaymentRequest>() {
        public GooglePaymentRequest createFromParcel(Parcel parcel) {
            return new GooglePaymentRequest(parcel);
        }

        public GooglePaymentRequest[] newArray(int i) {
            return new GooglePaymentRequest[i];
        }
    };
    private Boolean mAllowPrepaidCards;
    private HashMap<String, JSONArray> mAllowedAuthMethods;
    private HashMap<String, JSONArray> mAllowedCardNetworks;
    private HashMap<String, JSONObject> mAllowedPaymentMethods;
    private Integer mBillingAddressFormat;
    private Boolean mBillingAddressRequired;
    private Boolean mEmailRequired;
    private String mEnvironment;
    private String mGoogleMerchantId;
    private String mGoogleMerchantName;
    private boolean mPayPalEnabled;
    private Boolean mPhoneNumberRequired;
    private Boolean mShippingAddressRequired;
    private ShippingAddressRequirements mShippingAddressRequirements;
    private HashMap<String, JSONObject> mTokenizationSpecifications;
    private TransactionInfo mTransactionInfo;

    public int describeContents() {
        return 0;
    }

    public GooglePaymentRequest() {
        this.mEmailRequired = null;
        this.mPhoneNumberRequired = null;
        this.mBillingAddressRequired = null;
        this.mShippingAddressRequired = null;
        this.mAllowPrepaidCards = null;
        this.mPayPalEnabled = true;
        this.mAllowedPaymentMethods = new HashMap<>();
        this.mTokenizationSpecifications = new HashMap<>();
        this.mAllowedAuthMethods = new HashMap<>();
        this.mAllowedCardNetworks = new HashMap<>();
    }

    public GooglePaymentRequest transactionInfo(TransactionInfo transactionInfo) {
        this.mTransactionInfo = transactionInfo;
        return this;
    }

    public GooglePaymentRequest emailRequired(boolean z) {
        this.mEmailRequired = Boolean.valueOf(z);
        return this;
    }

    public GooglePaymentRequest phoneNumberRequired(boolean z) {
        this.mPhoneNumberRequired = Boolean.valueOf(z);
        return this;
    }

    public GooglePaymentRequest billingAddressRequired(boolean z) {
        this.mBillingAddressRequired = Boolean.valueOf(z);
        return this;
    }

    public GooglePaymentRequest billingAddressFormat(int i) {
        this.mBillingAddressFormat = Integer.valueOf(i);
        return this;
    }

    public GooglePaymentRequest shippingAddressRequired(boolean z) {
        this.mShippingAddressRequired = Boolean.valueOf(z);
        return this;
    }

    public GooglePaymentRequest shippingAddressRequirements(ShippingAddressRequirements shippingAddressRequirements) {
        this.mShippingAddressRequirements = shippingAddressRequirements;
        return this;
    }

    public GooglePaymentRequest allowPrepaidCards(boolean z) {
        this.mAllowPrepaidCards = Boolean.valueOf(z);
        return this;
    }

    public GooglePaymentRequest paypalEnabled(boolean z) {
        this.mPayPalEnabled = z;
        return this;
    }

    public GooglePaymentRequest setAllowedPaymentMethod(String str, JSONObject jSONObject) {
        this.mAllowedPaymentMethods.put(str, jSONObject);
        return this;
    }

    public GooglePaymentRequest setTokenizationSpecificationForType(String str, JSONObject jSONObject) {
        this.mTokenizationSpecifications.put(str, jSONObject);
        return this;
    }

    public GooglePaymentRequest setAllowedAuthMethods(String str, JSONArray jSONArray) {
        this.mAllowedAuthMethods.put(str, jSONArray);
        return this;
    }

    public GooglePaymentRequest setAllowedCardNetworks(String str, JSONArray jSONArray) {
        this.mAllowedCardNetworks.put(str, jSONArray);
        return this;
    }

    public GooglePaymentRequest googleMerchantId(String str) {
        this.mGoogleMerchantId = str;
        return this;
    }

    public GooglePaymentRequest googleMerchantName(String str) {
        this.mGoogleMerchantName = str;
        return this;
    }

    public GooglePaymentRequest environment(String str) {
        String str2 = "PRODUCTION";
        if (!str2.equals(str.toUpperCase())) {
            str2 = "TEST";
        }
        this.mEnvironment = str2;
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:2|(3:4|(2:7|5)|48))|8|(3:10|11|12)|13|14|15|(8:20|21|22|(5:24|25|26|27|(1:29))|30|51|49|17)|50|31|(5:32|33|(1:35)|36|(1:38))|39|(3:41|42|(1:44))|45|47) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:24|25|26|27|(1:29)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ec A[Catch:{ JSONException -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a A[Catch:{ JSONException -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012d A[Catch:{ JSONException -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0180 A[Catch:{ JSONException -> 0x0185 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toJson() {
        /*
            r12 = this;
            java.lang.String r0 = "billingAddressParameters"
            java.lang.String r1 = "parameters"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            com.google.android.gms.wallet.TransactionInfo r3 = r12.getTransactionInfo()
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.google.android.gms.wallet.ShippingAddressRequirements r8 = r12.mShippingAddressRequirements
            if (r8 == 0) goto L_0x0046
            java.util.ArrayList r8 = r8.getAllowedCountryCodes()
            r7.addAll(r8)
            int r8 = r7.size()
            if (r8 <= 0) goto L_0x0046
            java.util.Iterator r7 = r7.iterator()
        L_0x0036:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0046
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            r6.put(r8)
            goto L_0x0036
        L_0x0046:
            java.lang.Boolean r7 = r12.isShippingAddressRequired()
            boolean r7 = r7.booleanValue()
            java.lang.String r8 = "phoneNumberRequired"
            if (r7 == 0) goto L_0x005f
            java.lang.String r7 = "allowedCountryCodes"
            org.json.JSONObject r6 = r5.put(r7, r6)     // Catch:{ JSONException -> 0x005f }
            java.lang.Boolean r7 = r12.isPhoneNumberRequired()     // Catch:{ JSONException -> 0x005f }
            r6.put(r8, r7)     // Catch:{ JSONException -> 0x005f }
        L_0x005f:
            java.lang.String r6 = r12.totalPriceStatusToString()     // Catch:{ JSONException -> 0x007c }
            java.lang.String r7 = "totalPriceStatus"
            org.json.JSONObject r6 = r2.put(r7, r6)     // Catch:{ JSONException -> 0x007c }
            java.lang.String r7 = "totalPrice"
            java.lang.String r9 = r3.getTotalPrice()     // Catch:{ JSONException -> 0x007c }
            org.json.JSONObject r6 = r6.put(r7, r9)     // Catch:{ JSONException -> 0x007c }
            java.lang.String r7 = "currencyCode"
            java.lang.String r3 = r3.getCurrencyCode()     // Catch:{ JSONException -> 0x007c }
            r6.put(r7, r3)     // Catch:{ JSONException -> 0x007c }
        L_0x007c:
            java.util.HashMap<java.lang.String, org.json.JSONObject> r3 = r12.mAllowedPaymentMethods
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0086:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x010b
            java.lang.Object r6 = r3.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0086 }
            r7.<init>()     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r9 = "type"
            java.lang.Object r10 = r6.getKey()     // Catch:{ JSONException -> 0x0086 }
            org.json.JSONObject r7 = r7.put(r9, r10)     // Catch:{ JSONException -> 0x0086 }
            java.lang.Object r9 = r6.getValue()     // Catch:{ JSONException -> 0x0086 }
            org.json.JSONObject r7 = r7.put(r1, r9)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r9 = "tokenizationSpecification"
            java.util.HashMap<java.lang.String, org.json.JSONObject> r10 = r12.mTokenizationSpecifications     // Catch:{ JSONException -> 0x0086 }
            java.lang.Object r11 = r6.getKey()     // Catch:{ JSONException -> 0x0086 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ JSONException -> 0x0086 }
            org.json.JSONObject r7 = r7.put(r9, r10)     // Catch:{ JSONException -> 0x0086 }
            java.lang.Object r9 = r6.getKey()     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r10 = "CARD"
            if (r9 != r10) goto L_0x0106
            java.lang.Object r6 = r6.getValue()     // Catch:{ JSONException -> 0x00cb }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x00cb }
            r6.get(r0)     // Catch:{ JSONException -> 0x00cb }
            goto L_0x0106
        L_0x00cb:
            org.json.JSONObject r6 = r7.getJSONObject(r1)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r9 = "billingAddressRequired"
            java.lang.Boolean r10 = r12.isBillingAddressRequired()     // Catch:{ JSONException -> 0x0086 }
            org.json.JSONObject r9 = r6.put(r9, r10)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r10 = "allowPrepaidCards"
            java.lang.Boolean r11 = r12.getAllowPrepaidCards()     // Catch:{ JSONException -> 0x0086 }
            r9.put(r10, r11)     // Catch:{ JSONException -> 0x0086 }
            java.lang.Boolean r9 = r12.isBillingAddressRequired()     // Catch:{ JSONException -> 0x0086 }
            boolean r9 = r9.booleanValue()     // Catch:{ JSONException -> 0x0086 }
            if (r9 == 0) goto L_0x0106
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0086 }
            r9.<init>()     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r10 = "format"
            java.lang.String r11 = r12.billingAddressFormatToString()     // Catch:{ JSONException -> 0x0086 }
            org.json.JSONObject r9 = r9.put(r10, r11)     // Catch:{ JSONException -> 0x0086 }
            java.lang.Boolean r10 = r12.isPhoneNumberRequired()     // Catch:{ JSONException -> 0x0086 }
            org.json.JSONObject r9 = r9.put(r8, r10)     // Catch:{ JSONException -> 0x0086 }
            r6.put(r0, r9)     // Catch:{ JSONException -> 0x0086 }
        L_0x0106:
            r4.put(r7)     // Catch:{ JSONException -> 0x0086 }
            goto L_0x0086
        L_0x010b:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r12.getGoogleMerchantId()     // Catch:{ JSONException -> 0x0136 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0136 }
            if (r1 != 0) goto L_0x0123
            java.lang.String r1 = "merchantId"
            java.lang.String r3 = r12.getGoogleMerchantId()     // Catch:{ JSONException -> 0x0136 }
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0136 }
        L_0x0123:
            java.lang.String r1 = r12.getGoogleMerchantName()     // Catch:{ JSONException -> 0x0136 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0136 }
            if (r1 != 0) goto L_0x0136
            java.lang.String r1 = "merchantName"
            java.lang.String r3 = r12.getGoogleMerchantName()     // Catch:{ JSONException -> 0x0136 }
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0136 }
        L_0x0136:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r3 = "apiVersion"
            r6 = 2
            org.json.JSONObject r3 = r1.put(r3, r6)     // Catch:{ JSONException -> 0x0185 }
            java.lang.String r6 = "apiVersionMinor"
            r7 = 0
            org.json.JSONObject r3 = r3.put(r6, r7)     // Catch:{ JSONException -> 0x0185 }
            java.lang.String r6 = "allowedPaymentMethods"
            org.json.JSONObject r3 = r3.put(r6, r4)     // Catch:{ JSONException -> 0x0185 }
            java.lang.String r4 = "emailRequired"
            java.lang.Boolean r6 = r12.isEmailRequired()     // Catch:{ JSONException -> 0x0185 }
            org.json.JSONObject r3 = r3.put(r4, r6)     // Catch:{ JSONException -> 0x0185 }
            java.lang.String r4 = "shippingAddressRequired"
            java.lang.Boolean r6 = r12.isShippingAddressRequired()     // Catch:{ JSONException -> 0x0185 }
            org.json.JSONObject r3 = r3.put(r4, r6)     // Catch:{ JSONException -> 0x0185 }
            java.lang.String r4 = "environment"
            java.lang.String r6 = r12.mEnvironment     // Catch:{ JSONException -> 0x0185 }
            org.json.JSONObject r3 = r3.put(r4, r6)     // Catch:{ JSONException -> 0x0185 }
            java.lang.String r4 = "merchantInfo"
            org.json.JSONObject r0 = r3.put(r4, r0)     // Catch:{ JSONException -> 0x0185 }
            java.lang.String r3 = "transactionInfo"
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x0185 }
            java.lang.Boolean r0 = r12.isShippingAddressRequired()     // Catch:{ JSONException -> 0x0185 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0185 }
            if (r0 == 0) goto L_0x0185
            java.lang.String r0 = "shippingAddressParameters"
            r1.put(r0, r5)     // Catch:{ JSONException -> 0x0185 }
        L_0x0185:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.models.GooglePaymentRequest.toJson():java.lang.String");
    }

    private String totalPriceStatusToString() {
        int totalPriceStatus = getTransactionInfo().getTotalPriceStatus();
        if (totalPriceStatus != 1) {
            return totalPriceStatus != 2 ? "FINAL" : "ESTIMATED";
        }
        return "NOT_CURRENTLY_KNOWN";
    }

    public String billingAddressFormatToString() {
        Integer num = this.mBillingAddressFormat;
        return (num == null || num.intValue() != 1) ? "MIN" : "FULL";
    }

    public TransactionInfo getTransactionInfo() {
        return this.mTransactionInfo;
    }

    @Nullable
    public Boolean isEmailRequired() {
        return this.mEmailRequired;
    }

    @Nullable
    public Boolean isPhoneNumberRequired() {
        return this.mPhoneNumberRequired;
    }

    @Nullable
    public Boolean isBillingAddressRequired() {
        return this.mBillingAddressRequired;
    }

    @Nullable
    public Integer getBillingAddressFormat() {
        return this.mBillingAddressFormat;
    }

    @Nullable
    public Boolean isShippingAddressRequired() {
        return this.mShippingAddressRequired;
    }

    @Nullable
    public ShippingAddressRequirements getShippingAddressRequirements() {
        return this.mShippingAddressRequirements;
    }

    @Nullable
    public Boolean getAllowPrepaidCards() {
        return this.mAllowPrepaidCards;
    }

    public Boolean isPayPalEnabled() {
        return Boolean.valueOf(this.mPayPalEnabled);
    }

    public JSONObject getAllowedPaymentMethod(String str) {
        return this.mAllowedPaymentMethods.get(str);
    }

    public JSONObject getTokenizationSpecificationForType(String str) {
        return this.mTokenizationSpecifications.get(str);
    }

    public JSONArray getAllowedAuthMethodsForType(String str) {
        return this.mAllowedAuthMethods.get(str);
    }

    public JSONArray getAllowedCardNetworksForType(String str) {
        return this.mAllowedCardNetworks.get(str);
    }

    public String getEnvironment() {
        return this.mEnvironment;
    }

    public String getGoogleMerchantId() {
        return this.mGoogleMerchantId;
    }

    public String getGoogleMerchantName() {
        return this.mGoogleMerchantName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mTransactionInfo, i);
        Boolean bool = this.mEmailRequired;
        int i2 = 2;
        parcel.writeByte((byte) (bool == null ? 0 : bool.booleanValue() ? 1 : 2));
        Boolean bool2 = this.mPhoneNumberRequired;
        parcel.writeByte((byte) (bool2 == null ? 0 : bool2.booleanValue() ? 1 : 2));
        Boolean bool3 = this.mBillingAddressRequired;
        parcel.writeByte((byte) (bool3 == null ? 0 : bool3.booleanValue() ? 1 : 2));
        if (this.mBillingAddressFormat == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.mBillingAddressFormat.intValue());
        }
        Boolean bool4 = this.mShippingAddressRequired;
        parcel.writeByte((byte) (bool4 == null ? 0 : bool4.booleanValue() ? 1 : 2));
        parcel.writeParcelable(this.mShippingAddressRequirements, i);
        Boolean bool5 = this.mAllowPrepaidCards;
        if (bool5 == null) {
            i2 = 0;
        } else if (bool5.booleanValue()) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.mEnvironment);
        parcel.writeString(this.mGoogleMerchantId);
        parcel.writeString(this.mGoogleMerchantName);
    }

    protected GooglePaymentRequest(Parcel parcel) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5 = null;
        this.mEmailRequired = null;
        this.mPhoneNumberRequired = null;
        this.mBillingAddressRequired = null;
        this.mShippingAddressRequired = null;
        this.mAllowPrepaidCards = null;
        boolean z = true;
        this.mPayPalEnabled = true;
        this.mAllowedPaymentMethods = new HashMap<>();
        this.mTokenizationSpecifications = new HashMap<>();
        this.mAllowedAuthMethods = new HashMap<>();
        this.mAllowedCardNetworks = new HashMap<>();
        this.mTransactionInfo = parcel.readParcelable(TransactionInfo.class.getClassLoader());
        byte readByte = parcel.readByte();
        if (readByte == 0) {
            bool = null;
        } else {
            bool = Boolean.valueOf(readByte == 1);
        }
        this.mEmailRequired = bool;
        byte readByte2 = parcel.readByte();
        if (readByte2 == 0) {
            bool2 = null;
        } else {
            bool2 = Boolean.valueOf(readByte2 == 1);
        }
        this.mPhoneNumberRequired = bool2;
        byte readByte3 = parcel.readByte();
        if (readByte3 == 0) {
            bool3 = null;
        } else {
            bool3 = Boolean.valueOf(readByte3 == 1);
        }
        this.mBillingAddressRequired = bool3;
        if (parcel.readByte() == 0) {
            this.mBillingAddressFormat = null;
        } else {
            this.mBillingAddressFormat = Integer.valueOf(parcel.readInt());
        }
        byte readByte4 = parcel.readByte();
        if (readByte4 == 0) {
            bool4 = null;
        } else {
            bool4 = Boolean.valueOf(readByte4 == 1);
        }
        this.mShippingAddressRequired = bool4;
        this.mShippingAddressRequirements = parcel.readParcelable(ShippingAddressRequirements.class.getClassLoader());
        byte readByte5 = parcel.readByte();
        if (readByte5 != 0) {
            bool5 = Boolean.valueOf(readByte5 != 1 ? false : z);
        }
        this.mAllowPrepaidCards = bool5;
        this.mEnvironment = parcel.readString();
        this.mGoogleMerchantId = parcel.readString();
        this.mGoogleMerchantName = parcel.readString();
    }
}
