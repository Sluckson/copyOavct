package com.braintreepayments.api.models;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentMethodNonceFactory {
    public static JSONObject extractPaymentMethodToken(String str) throws JSONException {
        return new JSONObject(new JSONObject(str).getJSONObject("paymentMethodData").getJSONObject("tokenizationData").getString("token"));
    }

    public static PaymentMethodNonce fromString(String str) throws JSONException {
        Iterator<String> keys = extractPaymentMethodToken(str).keys();
        while (keys.hasNext()) {
            String next = keys.next();
            char c = 65535;
            int hashCode = next.hashCode();
            if (hashCode != -1730290695) {
                if (hashCode == -1313789142 && next.equals("androidPayCards")) {
                    c = 0;
                }
            } else if (next.equals("paypalAccounts")) {
                c = 1;
            }
            if (c == 0) {
                return GooglePaymentCardNonce.fromJson(str);
            }
            if (c == 1) {
                return PayPalAccountNonce.fromJson(str);
            }
        }
        throw new JSONException("Could not parse JSON for a payment method nonce");
    }
}
