package com.salesforce.marketingcloud.messages;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.location.LatLon;

@MCKeep
public abstract class MessageResponse {
    @NonNull
    public abstract LatLon refreshCenter();

    public abstract int refreshRadius();
}
