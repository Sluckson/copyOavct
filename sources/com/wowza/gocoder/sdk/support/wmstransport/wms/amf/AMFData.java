package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: GoCoderSDK */
public abstract class AMFData {
    public static final byte AMF_LEVEL0 = 0;
    public static final byte AMF_LEVEL3 = 3;
    public static final byte DATA_TYPE_AMF3 = 17;
    public static final byte DATA_TYPE_AMF3_ARRAY = 9;
    public static final byte DATA_TYPE_AMF3_BOOLEAN_FALSE = 2;
    public static final byte DATA_TYPE_AMF3_BOOLEAN_TRUE = 3;
    public static final byte DATA_TYPE_AMF3_BYTEARRAY = 12;
    public static final byte DATA_TYPE_AMF3_DATE = 8;
    public static final byte DATA_TYPE_AMF3_INTEGER = 4;
    public static final byte DATA_TYPE_AMF3_NULL = 1;
    public static final byte DATA_TYPE_AMF3_NUMBER = 5;
    public static final byte DATA_TYPE_AMF3_OBJECT = 10;
    public static final byte DATA_TYPE_AMF3_STRING = 6;
    public static final byte DATA_TYPE_AMF3_UNDEFINED = 0;
    public static final byte DATA_TYPE_AMF3_XML_LEGACY = 7;
    public static final byte DATA_TYPE_AMF3_XML_TOP = 11;
    public static final byte DATA_TYPE_ARRAY = 10;
    public static final byte DATA_TYPE_AS_OBJECT = 13;
    public static final byte DATA_TYPE_BOOLEAN = 1;
    public static final byte DATA_TYPE_BYTEARRAY = 33;
    public static final byte DATA_TYPE_CUSTOM_CLASS = 16;
    public static final byte DATA_TYPE_DATE = 11;
    public static final byte DATA_TYPE_INTEGER = 32;
    public static final byte DATA_TYPE_LONG_STRING = 12;
    public static final byte DATA_TYPE_MIXED_ARRAY = 8;
    public static final byte DATA_TYPE_MOVIE_CLIP = 4;
    public static final byte DATA_TYPE_NULL = 5;
    public static final byte DATA_TYPE_NUMBER = 0;
    public static final byte DATA_TYPE_OBJECT = 3;
    public static final byte DATA_TYPE_OBJECT_END = 9;
    public static final byte DATA_TYPE_RECORDSET = 14;
    public static final byte DATA_TYPE_REFERENCE_OBJECT = 7;
    public static final byte DATA_TYPE_STRING = 2;
    public static final byte DATA_TYPE_UNDEFINED = 6;
    public static final byte DATA_TYPE_UNKNOWN = -1;
    public static final byte DATA_TYPE_XML = 15;
    public static final byte DATA_TYPE_XML_TOP = 34;
    public static final int MILLS_PER_HOUR = 60000;
    public static final String TAG = "AMFData";
    protected int type = 5;

    public abstract void deserialize(ByteBuffer byteBuffer);

    public abstract void deserialize(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize);

    public abstract Object getValue();

    public abstract void serialize(DataOutputStream dataOutputStream);

    public abstract void serialize(DataOutputStream dataOutputStream, int i);

    public abstract void serialize(DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize);

    public abstract byte[] serialize();

    public abstract byte[] serialize(int i);

    public abstract byte[] serialize(AMFDataContextSerialize aMFDataContextSerialize);

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public static boolean testNextByte(ByteBuffer byteBuffer, int i) {
        try {
            if (!byteBuffer.hasRemaining()) {
                return false;
            }
            if (byteBuffer.get() == i) {
                return true;
            }
            byteBuffer.position(byteBuffer.position() - 1);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int peekByte(ByteBuffer byteBuffer) {
        try {
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            byte b = byteBuffer.get();
            byteBuffer.position(byteBuffer.position() - 1);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int skipByte(ByteBuffer byteBuffer) {
        try {
            if (byteBuffer.hasRemaining()) {
                return byteBuffer.get();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isObjStart(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        return testNextByte(byteBuffer, aMFDataContextDeserialize.isAMF3() ? 10 : 3);
    }

    public static boolean isAMF3Start(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        if (aMFDataContextDeserialize.isAMF3()) {
            return false;
        }
        return testNextByte(byteBuffer, 17);
    }

    public static boolean isArrayStart(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        if (aMFDataContextDeserialize.isAMF3()) {
            return false;
        }
        return testNextByte(byteBuffer, 10);
    }

    public static boolean isMixedArrayStart(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        return testNextByte(byteBuffer, aMFDataContextDeserialize.isAMF3() ? 9 : 8);
    }

    public static boolean isObjEnd(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        if (aMFDataContextDeserialize.isAMF3()) {
            return false;
        }
        return testNextByte(byteBuffer, 9);
    }

    public static boolean isByteArrayStart(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        if (aMFDataContextDeserialize.isAMF0()) {
            return false;
        }
        return testNextByte(byteBuffer, 12);
    }

    public static AMFData getReference(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        AMFData aMFData;
        try {
            if (aMFDataContextDeserialize.isAMF0()) {
                aMFData = (AMFData) aMFDataContextDeserialize.getObject(C4307c.m4264a(byteBuffer));
            } else {
                int deserializeInt = AMF3Utils.deserializeInt(byteBuffer);
                if ((deserializeInt & 1) == 0) {
                    aMFData = (AMFData) aMFDataContextDeserialize.getObject(deserializeInt >> 1);
                } else {
                    aMFDataContextDeserialize.setIntData(deserializeInt);
                    return null;
                }
            }
            return aMFData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AMFData deserializeInnerObject(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) throws IOException {
        int peekByte;
        AMFData aMFData;
        while (true) {
            peekByte = peekByte(byteBuffer);
            if (peekByte != 17) {
                break;
            }
            skipByte(byteBuffer);
            aMFDataContextDeserialize.setObjectEncoding(3);
        }
        AMFData aMFData2 = null;
        if (aMFDataContextDeserialize.isAMF0()) {
            if (peekByte == 3) {
                skipByte(byteBuffer);
                aMFData = new AMFDataObj(byteBuffer, aMFDataContextDeserialize);
            } else if (peekByte == 10) {
                skipByte(byteBuffer);
                aMFData = new AMFDataArray(byteBuffer, aMFDataContextDeserialize);
            } else if (peekByte == 16) {
                skipByte(byteBuffer);
                byte[] bArr = new byte[C4307c.m4264a(byteBuffer)];
                byteBuffer.get(bArr);
                String str = new String(bArr, "UTF-8");
                aMFData = new AMFDataObj(byteBuffer, aMFDataContextDeserialize);
                ((AMFDataObj) aMFData).setClassName(str);
            } else if (peekByte == 7) {
                skipByte(byteBuffer);
                aMFData = getReference(byteBuffer, aMFDataContextDeserialize);
            } else if (peekByte == 8) {
                skipByte(byteBuffer);
                aMFData = new AMFDataMixedArray(byteBuffer, aMFDataContextDeserialize);
            }
            aMFData2 = aMFData;
        } else if (peekByte == 9) {
            skipByte(byteBuffer);
            aMFData2 = getReference(byteBuffer, aMFDataContextDeserialize);
            if (aMFData2 == null) {
                aMFData2 = new AMFDataMixedArray(byteBuffer, aMFDataContextDeserialize);
            }
        } else if (peekByte == 10) {
            skipByte(byteBuffer);
            aMFData2 = getReference(byteBuffer, aMFDataContextDeserialize);
            if (aMFData2 == null) {
                aMFData2 = new AMFDataObj(byteBuffer, aMFDataContextDeserialize);
            }
        } else if (peekByte == 12) {
            skipByte(byteBuffer);
            aMFData2 = getReference(byteBuffer, aMFDataContextDeserialize);
            if (aMFData2 == null) {
                aMFData2 = new AMFDataByteArray(byteBuffer, aMFDataContextDeserialize);
            }
        }
        return aMFData2 == null ? new AMFDataItem(byteBuffer, aMFDataContextDeserialize) : aMFData2;
    }

    public static AMFDataContextSerialize createContextSerialize() {
        return new AMFDataContextSerialize(0);
    }

    public static AMFDataContextSerialize createContextSerialize(int i) {
        return new AMFDataContextSerialize(i);
    }

    public static AMFDataContextDeserialize createContextDeserialize() {
        return new AMFDataContextDeserialize(0);
    }

    public static AMFDataContextDeserialize createContextDeserialize(int i) {
        return new AMFDataContextDeserialize(i);
    }

    public static boolean triggerAMF3Switch(AMFData aMFData) {
        if (!(aMFData instanceof AMFDataObj) && !(aMFData instanceof AMFDataMixedArray) && !(aMFData instanceof AMFDataByteArray) && !(aMFData instanceof AMFDataArray)) {
            return false;
        }
        return true;
    }
}
