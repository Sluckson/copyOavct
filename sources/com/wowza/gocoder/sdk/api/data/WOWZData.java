package com.wowza.gocoder.sdk.api.data;

import java.io.Serializable;

/* compiled from: GoCoderSDK */
public abstract class WOWZData implements Serializable {
    protected WOWZDataType mDataType = WOWZDataType.NULL;

    public WOWZDataType getDataType() {
        return this.mDataType;
    }

    public boolean isPrimitive() {
        return this instanceof WOWZDataItem;
    }

    public String toString(boolean z, int i) {
        return toString();
    }
}
