package com.braintreepayments.api.models;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.C0904R;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.braintreepayments.api.internal.GraphQLQueryHelper;
import com.lowagie.text.ElementTags;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class CardBuilder extends BaseCardBuilder<CardBuilder> implements Parcelable {
    public static final Parcelable.Creator<CardBuilder> CREATOR = new Parcelable.Creator<CardBuilder>() {
        public CardBuilder createFromParcel(Parcel parcel) {
            return new CardBuilder(parcel);
        }

        public CardBuilder[] newArray(int i) {
            return new CardBuilder[i];
        }
    };

    /* access modifiers changed from: protected */
    public void buildGraphQL(Context context, JSONObject jSONObject, JSONObject jSONObject2) throws BraintreeException, JSONException {
        try {
            jSONObject.put("query", GraphQLQueryHelper.getQuery(context, C0904R.raw.tokenize_credit_card_mutation));
            jSONObject.put(GraphQLConstants.Keys.OPERATION_NAME, "TokenizeCreditCard");
            JSONObject put = new JSONObject().put(ElementTags.NUMBER, this.mCardnumber).put("expirationMonth", this.mExpirationMonth).put("expirationYear", this.mExpirationYear).put("cvv", this.mCvv).put("cardholderName", this.mCardholderName);
            JSONObject put2 = new JSONObject().put("firstName", this.mFirstName).put("lastName", this.mLastName).put("company", this.mCompany).put("countryCode", this.mCountryCode).put(PostalAddressParser.USER_ADDRESS_LOCALITY_KEY, this.mLocality).put("postalCode", this.mPostalCode).put(TtmlNode.TAG_REGION, this.mRegion).put("streetAddress", this.mStreetAddress).put("extendedAddress", this.mExtendedAddress);
            if (put2.length() > 0) {
                put.put("billingAddress", put2);
            }
            jSONObject2.put("creditCard", put);
        } catch (Resources.NotFoundException | IOException e) {
            throw new BraintreeException("Unable to read GraphQL query", e);
        }
    }

    public CardBuilder() {
    }

    protected CardBuilder(Parcel parcel) {
        super(parcel);
    }
}
