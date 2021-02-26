package com.paypal.android.sdk.onetouch.core.metadata;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.HashMap;
import lib.android.paypal.com.magnessdk.MagnesSDK;
import lib.android.paypal.com.magnessdk.MagnesSettings;
import lib.android.paypal.com.magnessdk.MagnesSource;

public class MetadataIdProviderImpl implements MetadataIdProvider {
    public String getClientMetadataId(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull HashMap<String, String> hashMap) {
        MagnesSDK instance = MagnesSDK.getInstance();
        instance.setUp(new MagnesSettings.Builder(context).setMagnesSource(MagnesSource.BRAINTREE).setAppGuid(str).build());
        return instance.collectAndSubmit(context, str2, hashMap).getPaypalClientMetaDataId();
    }
}
