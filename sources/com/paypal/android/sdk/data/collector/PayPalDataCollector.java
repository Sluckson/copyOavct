package com.paypal.android.sdk.data.collector;

import android.content.Context;
import androidx.annotation.MainThread;
import lib.android.paypal.com.magnessdk.Environment;
import lib.android.paypal.com.magnessdk.MagnesSDK;
import lib.android.paypal.com.magnessdk.MagnesSettings;
import lib.android.paypal.com.magnessdk.MagnesSource;

public class PayPalDataCollector {
    @MainThread
    public static String getClientMetadataId(Context context) {
        return getClientMetadataId(context, new PayPalDataCollectorRequest().setApplicationGuid(InstallationIdentifier.getInstallationGUID(context)));
    }

    @MainThread
    public static String getClientMetadataId(Context context, String str) {
        return getClientMetadataId(context, new PayPalDataCollectorRequest().setApplicationGuid(InstallationIdentifier.getInstallationGUID(context)).setClientMetadataId(str));
    }

    @MainThread
    public static String getClientMetadataId(Context context, PayPalDataCollectorRequest payPalDataCollectorRequest) {
        if (context == null) {
            return "";
        }
        MagnesSDK instance = MagnesSDK.getInstance();
        instance.setUp(new MagnesSettings.Builder(context).setMagnesSource(MagnesSource.BRAINTREE).disableBeacon(payPalDataCollectorRequest.isDisableBeacon()).setMagnesEnvironment(Environment.LIVE).setAppGuid(payPalDataCollectorRequest.getApplicationGuid()).build());
        return instance.collectAndSubmit(context, payPalDataCollectorRequest.getClientMetadataId(), payPalDataCollectorRequest.getAdditionalData()).getPaypalClientMetaDataId();
    }
}
