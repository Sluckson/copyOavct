package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: GoCoderSDK */
public class AMFDataMixedArray extends AMFDataObj {
    public static final String TAG = "AMFDataMixedArray";

    public AMFDataMixedArray() {
        this.type = 8;
    }

    public AMFDataMixedArray(byte[] bArr) {
        this.type = 8;
        deserialize(ByteBuffer.wrap(bArr));
    }

    public AMFDataMixedArray(byte[] bArr, int i, int i2) {
        this.type = 8;
        deserialize(ByteBuffer.wrap(bArr, i, i2));
    }

    public AMFDataMixedArray(ByteBuffer byteBuffer) {
        this.type = 8;
        deserialize(byteBuffer);
    }

    public AMFDataMixedArray(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        this.type = 8;
        deserialize(byteBuffer, aMFDataContextDeserialize);
    }

    public void deserialize(ByteBuffer byteBuffer) {
        deserialize(byteBuffer, createContextDeserialize());
    }

    public void deserialize(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        String str;
        try {
            if (!aMFDataContextDeserialize.isAMF0()) {
                int clearIntData = (aMFDataContextDeserialize.isIntData() ? aMFDataContextDeserialize.clearIntData() : AMF3Utils.deserializeInt(byteBuffer)) >> 1;
                aMFDataContextDeserialize.addObject(this);
                while (true) {
                    String deserializeString = AMF3Utils.deserializeString(byteBuffer, aMFDataContextDeserialize);
                    if (deserializeString.length() == 0) {
                        break;
                    }
                    AMFData deserializeInnerObject = deserializeInnerObject(byteBuffer, aMFDataContextDeserialize);
                    if (deserializeInnerObject != null) {
                        this.members.put(deserializeString, deserializeInnerObject);
                        this.order.remove(deserializeString);
                        this.order.add(deserializeString);
                    }
                }
                for (int i = 0; i < clearIntData; i++) {
                    AMFData deserializeInnerObject2 = deserializeInnerObject(byteBuffer, aMFDataContextDeserialize);
                    if (deserializeInnerObject2 != null) {
                        String str2 = new String(i + "");
                        this.members.put(str2, deserializeInnerObject2);
                        this.order.remove(str2);
                        this.order.add(i, str2);
                    }
                }
                return;
            }
            aMFDataContextDeserialize.addObject(this);
            byteBuffer.getInt();
            while (byteBuffer.remaining() >= 3) {
                int a = C4307c.m4264a(byteBuffer);
                if (a != 0 || !isObjEnd(byteBuffer, aMFDataContextDeserialize)) {
                    if (a > 0) {
                        byte[] bArr = new byte[a];
                        byteBuffer.get(bArr);
                        str = new String(bArr, "UTF-8");
                    } else {
                        str = new String();
                    }
                    AMFData deserializeInnerObject3 = deserializeInnerObject(byteBuffer, aMFDataContextDeserialize);
                    if (deserializeInnerObject3 != null) {
                        this.members.put(str, deserializeInnerObject3);
                        this.order.add(str);
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serialize(DataOutputStream dataOutputStream) {
        serialize(dataOutputStream, createContextSerialize(0));
    }

    public void serialize(DataOutputStream dataOutputStream, int i) {
        serialize(dataOutputStream, createContextSerialize(i));
    }

    public void serialize(DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize) {
        try {
            if (!aMFDataContextSerialize.isAMF0()) {
                dataOutputStream.write(9);
                int objectReference = aMFDataContextSerialize.getObjectReference(this);
                if (objectReference >= 0) {
                    AMF3Utils.serializeInt(dataOutputStream, objectReference << 1);
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.order);
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    String str = "" + i2;
                    if (!arrayList.contains(str)) {
                        break;
                    }
                    arrayList.remove(str);
                    i++;
                }
                AMF3Utils.serializeInt(dataOutputStream, (i << 1) | 1);
                for (String str2 : arrayList) {
                    aMFDataContextSerialize.writeString(dataOutputStream, str2);
                    ((AMFData) this.members.get(str2)).serialize(dataOutputStream, aMFDataContextSerialize);
                }
                AMF3Utils.serializeZeroLengthString(dataOutputStream);
                for (int i3 = 0; i3 < i; i3++) {
                    ((AMFData) this.members.get("" + i3)).serialize(dataOutputStream, aMFDataContextSerialize);
                }
                return;
            }
            dataOutputStream.write(8);
            boolean z = false;
            int i4 = 0;
            for (String parseInt : this.order) {
                try {
                    int parseInt2 = Integer.parseInt(parseInt);
                    if (parseInt2 <= i4) {
                        parseInt2 = i4;
                    }
                    i4 = parseInt2;
                    z = true;
                } catch (Exception unused) {
                }
            }
            if (z) {
                i4++;
            }
            dataOutputStream.writeInt(i4);
            for (String str3 : this.order) {
                dataOutputStream.writeUTF(str3);
                ((AMFData) this.members.get(str3)).serialize(dataOutputStream, aMFDataContextSerialize);
            }
            dataOutputStream.writeShort(0);
            dataOutputStream.write(9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{MixedArray: ");
        int i = 0;
        for (Object next : this.order) {
            AMFData aMFData = (AMFData) this.members.get(next);
            if (i > 0) {
                stringBuffer.append(", ");
            }
            int type = aMFData.getType();
            if (type == 2 || type == 11 || type == 15 || type == 34) {
                stringBuffer.append(next + ": \"" + aMFData.toString() + "\"");
            } else {
                stringBuffer.append(next + ": " + aMFData.toString());
            }
            i++;
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
