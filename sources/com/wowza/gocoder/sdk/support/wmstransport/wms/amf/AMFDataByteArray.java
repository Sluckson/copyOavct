package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.iaai.android.bdt.utils.Constants_MVVM;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* compiled from: GoCoderSDK */
public class AMFDataByteArray extends AMFData {
    public static final String TAG = "AMFDataByteArray";
    byte[] data = null;

    public AMFDataByteArray() {
        this.type = 33;
    }

    public AMFDataByteArray(byte[] bArr) {
        this.type = 33;
        deserialize(ByteBuffer.wrap(bArr));
    }

    public AMFDataByteArray(byte[] bArr, int i, int i2) {
        this.type = 33;
        deserialize(ByteBuffer.wrap(bArr, i, i2));
    }

    public AMFDataByteArray(ByteBuffer byteBuffer) {
        this.type = 33;
        deserialize(byteBuffer);
    }

    public AMFDataByteArray(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        this.type = 33;
        deserialize(byteBuffer, aMFDataContextDeserialize);
    }

    public int size() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public byte[] toArray() {
        return this.data;
    }

    public ByteBuffer toByteBuffer() {
        byte[] bArr = this.data;
        if (bArr != null) {
            return ByteBuffer.wrap(bArr);
        }
        return null;
    }

    public static AMFDataByteArray wrap(byte[] bArr) {
        AMFDataByteArray aMFDataByteArray = new AMFDataByteArray();
        aMFDataByteArray.data = bArr;
        return aMFDataByteArray;
    }

    public static AMFDataByteArray wrap(ByteBuffer byteBuffer) {
        AMFDataByteArray aMFDataByteArray = new AMFDataByteArray();
        try {
            aMFDataByteArray.data = byteBuffer.array();
        } catch (Exception unused) {
        }
        if (aMFDataByteArray.data == null) {
            aMFDataByteArray.data = new byte[byteBuffer.limit()];
            int position = byteBuffer.position();
            byteBuffer.position(0);
            byteBuffer.get(aMFDataByteArray.data);
            byteBuffer.position(position);
        }
        return aMFDataByteArray;
    }

    public Object getValue() {
        return this.data;
    }

    public void deserialize(ByteBuffer byteBuffer) {
        deserialize(byteBuffer, AMFData.createContextDeserialize());
    }

    public void deserialize(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        try {
            if (!aMFDataContextDeserialize.isAMF0()) {
                this.data = new byte[((aMFDataContextDeserialize.isIntData() ? aMFDataContextDeserialize.clearIntData() : AMF3Utils.deserializeInt(byteBuffer)) >> 1)];
                byteBuffer.get(this.data);
                aMFDataContextDeserialize.addObject(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serialize(DataOutputStream dataOutputStream) {
        serialize(dataOutputStream, AMFData.createContextSerialize(0));
    }

    public void serialize(DataOutputStream dataOutputStream, int i) {
        serialize(dataOutputStream, AMFData.createContextSerialize(i));
    }

    public void serialize(DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize) {
        try {
            if (!aMFDataContextSerialize.isAMF0()) {
                dataOutputStream.write(12);
                int objectReference = aMFDataContextSerialize.getObjectReference(this);
                if (objectReference >= 0) {
                    AMF3Utils.serializeInt(dataOutputStream, objectReference << 1);
                    return;
                }
                AMF3Utils.serializeInt(dataOutputStream, (size() << 1) | 1);
                if (size() > 0) {
                    dataOutputStream.write(this.data);
                    return;
                }
                return;
            }
            int size = size();
            AMFDataObj aMFDataObj = new AMFDataObj();
            aMFDataObj.put("endian", (AMFData) new AMFDataItem("bigEndian"));
            aMFDataObj.put("length", (AMFData) new AMFDataItem(size));
            aMFDataObj.put(Constants_MVVM.EXTRA_ITEM_POSITION, (AMFData) new AMFDataItem(size));
            aMFDataObj.put("objectEncoding", (AMFData) new AMFDataItem(3));
            aMFDataObj.serialize(dataOutputStream, aMFDataContextSerialize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] serialize() {
        return serialize(AMFData.createContextSerialize(0));
    }

    public byte[] serialize(int i) {
        return serialize(AMFData.createContextSerialize(i));
    }

    public byte[] serialize(AMFDataContextSerialize aMFDataContextSerialize) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(new DataOutputStream(byteArrayOutputStream), aMFDataContextSerialize);
        return byteArrayOutputStream.toByteArray();
    }

    public int compress() {
        int size = size();
        if (size > 0) {
            Deflater deflater = new Deflater();
            deflater.setLevel(9);
            deflater.setInput(this.data);
            deflater.finish();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.data = byteArrayOutputStream.toByteArray();
        }
        return size();
    }

    public int decompress() {
        int size = size();
        if (size > 0) {
            Inflater inflater = new Inflater();
            inflater.setInput(this.data);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
            byte[] bArr = new byte[1024];
            while (!inflater.finished()) {
                try {
                    byteArrayOutputStream.write(bArr, 0, inflater.inflate(bArr));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.data = byteArrayOutputStream.toByteArray();
        }
        return size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int size = size();
        stringBuffer.append("{Array: size: " + size);
        if (size < 1024) {
            stringBuffer.append(", data: {");
            for (int i = 0; i < size; i++) {
                String hexString = Integer.toHexString(this.data[i]);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                } else if (hexString.length() > 2) {
                    hexString = hexString.substring(hexString.length() - 2);
                }
                if (i > 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append("0x" + hexString);
            }
            stringBuffer.append("}");
        } else {
            stringBuffer.append(", data: [largeblock]");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
