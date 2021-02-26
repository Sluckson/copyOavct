package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import java.io.DataOutputStream;
import java.nio.ByteBuffer;

/* compiled from: GoCoderSDK */
public interface IAMFExternalizable {
    void deserialize(AMFDataObj aMFDataObj, ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize);

    String getClassName();

    void serialize(AMFDataObj aMFDataObj, DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize);

    void setClassName(String str);
}
