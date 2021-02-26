package com.wowza.gocoder.sdk.api.data;

/* compiled from: GoCoderSDK */
public enum WOWZDataType {
    NULL(0),
    STRING(1),
    BOOLEAN(2),
    DATE(3),
    INTEGER(33),
    SHORT(49),
    LONG(50),
    FLOAT(51),
    DOUBLE(52),
    DATA_MAP(65),
    DATA_LIST(66);
    

    /* renamed from: a */
    private int f3603a;

    public int getValue() {
        return this.f3603a;
    }

    private WOWZDataType(int i) {
        this.f3603a = i;
    }
}
