package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

/* compiled from: GoCoderSDK */
public class AMFObjChunk {
    public static final String TAG = "AMFObjChunk";
    public byte[] buffer = null;
    public int len = 0;
    public int offset = 0;

    public AMFObjChunk(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.offset = i;
        this.len = i2;
    }
}
