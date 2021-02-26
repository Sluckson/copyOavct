package com.braintreepayments.api.internal;

import android.app.Activity;

public class IntegrationType {
    public static String get(Activity activity) {
        try {
            if (Class.forName("com.braintreepayments.api.BraintreePaymentActivity").isInstance(activity)) {
                return "dropin";
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            return Class.forName("com.braintreepayments.api.dropin.DropInActivity").isInstance(activity) ? "dropin2" : "custom";
        } catch (ClassNotFoundException unused2) {
            return "custom";
        }
    }
}
