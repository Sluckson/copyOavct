package com.paypal.android.sdk.onetouch.core.metadata;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.HashMap;

public interface MetadataIdProvider {
    String getClientMetadataId(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull HashMap<String, String> hashMap);
}
