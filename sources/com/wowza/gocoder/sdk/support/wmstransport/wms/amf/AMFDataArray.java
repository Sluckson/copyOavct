package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: GoCoderSDK */
public class AMFDataArray extends AMFData {
    public static final String TAG = "AMFDataArray";
    private List children = new ArrayList();

    public AMFDataArray() {
        this.type = 10;
    }

    public AMFDataArray(byte[] bArr) {
        this.type = 10;
        deserialize(ByteBuffer.wrap(bArr));
    }

    public AMFDataArray(byte[] bArr, int i, int i2) {
        this.type = 10;
        deserialize(ByteBuffer.wrap(bArr, i, i2));
    }

    public AMFDataArray(ByteBuffer byteBuffer) {
        this.type = 10;
        deserialize(byteBuffer);
    }

    public AMFDataArray(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        this.type = 10;
        deserialize(byteBuffer, aMFDataContextDeserialize);
    }

    public AMFData remove(int i) {
        try {
            return (AMFData) this.children.remove(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int size() {
        return this.children.size();
    }

    public void add(AMFData aMFData) {
        this.children.add(aMFData);
    }

    public void add(String str) {
        this.children.add(new AMFDataItem(str));
    }

    public void add(double d) {
        this.children.add(new AMFDataItem(d));
    }

    public void add(int i) {
        this.children.add(new AMFDataItem(i));
    }

    public void add(long j) {
        this.children.add(new AMFDataItem(j));
    }

    public void add(Date date) {
        this.children.add(new AMFDataItem(date));
    }

    public void add(boolean z) {
        this.children.add(new AMFDataItem(z));
    }

    public void add(int i, AMFData aMFData) {
        this.children.add(i, aMFData);
    }

    public void add(int i, String str) {
        this.children.add(i, new AMFDataItem(str));
    }

    public void add(int i, double d) {
        this.children.add(i, new AMFDataItem(d));
    }

    public void add(int i, int i2) {
        this.children.add(i, new AMFDataItem(i2));
    }

    public void add(int i, long j) {
        this.children.add(i, new AMFDataItem(j));
    }

    public void add(int i, Date date) {
        this.children.add(i, new AMFDataItem(date));
    }

    public void add(int i, boolean z) {
        this.children.add(i, new AMFDataItem(z));
    }

    public void set(int i, AMFData aMFData) {
        this.children.set(i, aMFData);
    }

    public void set(int i, String str) {
        this.children.set(i, new AMFDataItem(str));
    }

    public void set(int i, double d) {
        this.children.set(i, new AMFDataItem(d));
    }

    public void set(int i, int i2) {
        this.children.set(i, new AMFDataItem(i2));
    }

    public void set(int i, long j) {
        this.children.set(i, new AMFDataItem(j));
    }

    public void set(int i, Date date) {
        this.children.set(i, new AMFDataItem(date));
    }

    public void set(int i, boolean z) {
        this.children.set(i, new AMFDataItem(z));
    }

    public AMFData get(int i) {
        try {
            return (AMFData) this.children.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getString(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        if (aMFDataItem != null) {
            return aMFDataItem.toString();
        }
        return null;
    }

    public int getInt(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        if (aMFDataItem != null) {
            return aMFDataItem.intValue();
        }
        return 0;
    }

    public long getLong(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        if (aMFDataItem != null) {
            return aMFDataItem.longValue();
        }
        return 0;
    }

    public short getShort(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        if (aMFDataItem != null) {
            return aMFDataItem.shortValue();
        }
        return 0;
    }

    public byte getByte(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        if (aMFDataItem != null) {
            return aMFDataItem.byteValue();
        }
        return 0;
    }

    public boolean getBoolean(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        if (aMFDataItem != null) {
            return aMFDataItem.booleanValue();
        }
        return false;
    }

    public Date getDate(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        Object obj = null;
        if (aMFDataItem != null && aMFDataItem.getType() == 11) {
            obj = aMFDataItem.getValue();
        }
        return (Date) obj;
    }

    public AMFDataObj getObject(int i) {
        return (AMFDataObj) get(i);
    }

    public double getDouble(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        return aMFDataItem != null ? aMFDataItem.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public float getFloat(int i) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(i);
        if (aMFDataItem != null) {
            return aMFDataItem.floatValue();
        }
        return 0.0f;
    }

    public void deserialize(ByteBuffer byteBuffer) {
        deserialize(byteBuffer, createContextDeserialize());
    }

    public void deserialize(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        AMFData deserializeInnerObject;
        try {
            aMFDataContextDeserialize.addObject(this);
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                if (byteBuffer.hasRemaining() && (deserializeInnerObject = deserializeInnerObject(byteBuffer, aMFDataContextDeserialize)) != null) {
                    this.children.add(deserializeInnerObject);
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
                AMF3Utils.serializeInt(dataOutputStream, (this.children.size() << 1) | 1);
                AMF3Utils.serializeZeroLengthString(dataOutputStream);
                for (AMFData serialize : this.children) {
                    serialize.serialize(dataOutputStream, aMFDataContextSerialize);
                }
                return;
            }
            dataOutputStream.write(10);
            dataOutputStream.writeInt(this.children.size());
            for (AMFData serialize2 : this.children) {
                serialize2.serialize(dataOutputStream, aMFDataContextSerialize);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] serialize() {
        return serialize(createContextSerialize(0));
    }

    public byte[] serialize(int i) {
        return serialize(createContextSerialize(i));
    }

    public byte[] serialize(AMFDataContextSerialize aMFDataContextSerialize) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(new DataOutputStream(byteArrayOutputStream), aMFDataContextSerialize);
        return byteArrayOutputStream.toByteArray();
    }

    public Object getValue() {
        return this.children;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{Array: ");
        int i = 0;
        for (AMFData aMFData : this.children) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            int type = aMFData.getType();
            if (type == 2 || type == 11 || type == 15 || type == 34) {
                stringBuffer.append(i + ": \"" + aMFData.toString() + "\"");
            } else {
                stringBuffer.append(i + ": " + aMFData.toString());
            }
            i++;
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
