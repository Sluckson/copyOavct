package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: GoCoderSDK */
public class AMFDataList extends AMFData {
    public static final String TAG = "AMFDataList";
    private List children = new ArrayList();

    public AMFDataList() {
        this.type = 10;
    }

    public AMFDataList(byte[] bArr) {
        this.type = 10;
        deserialize(ByteBuffer.wrap(bArr));
    }

    public AMFDataList(byte[] bArr, int i, int i2) {
        this.type = 10;
        deserialize(ByteBuffer.wrap(bArr, i, i2));
    }

    public AMFDataList(ByteBuffer byteBuffer) {
        this.type = 10;
        deserialize(byteBuffer);
    }

    public AMFDataList(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        this.type = 10;
        deserialize(byteBuffer, aMFDataContextDeserialize);
    }

    public AMFData remove(int i) {
        if (i < this.children.size()) {
            return (AMFData) this.children.remove(i);
        }
        return null;
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

    public int getType(int i) {
        try {
            if (i < this.children.size()) {
                AMFData aMFData = (AMFData) this.children.get(i);
                if (aMFData == null) {
                    return -1;
                }
                return aMFData.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public AMFData get(int i) {
        try {
            if (i < this.children.size()) {
                return (AMFData) this.children.get(i);
            }
            return null;
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

    public void deserialize(ByteBuffer byteBuffer) {
        deserialize(byteBuffer, createContextDeserialize());
    }

    public void deserialize(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        while (byteBuffer.hasRemaining()) {
            try {
                AMFData deserializeInnerObject = deserializeInnerObject(byteBuffer, aMFDataContextDeserialize);
                if (deserializeInnerObject != null) {
                    this.children.add(deserializeInnerObject);
                }
                aMFDataContextDeserialize.setObjectEncoding(0);
            } catch (Exception unused) {
                return;
            }
        }
    }

    public void serialize(DataOutputStream dataOutputStream) {
        serialize(dataOutputStream, createContextSerialize(0), (byte[]) null);
    }

    public void serialize(DataOutputStream dataOutputStream, int i) {
        serialize(dataOutputStream, createContextSerialize(i), (byte[]) null);
    }

    public void serialize(DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize) {
        serialize(dataOutputStream, aMFDataContextSerialize, (byte[]) null);
    }

    public void serialize(DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize, byte[] bArr) {
        if (bArr != null) {
            try {
                dataOutputStream.write(bArr);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int targetEncoding = aMFDataContextSerialize.getTargetEncoding();
        for (AMFData aMFData : this.children) {
            if (aMFDataContextSerialize.getObjectEncoding() < targetEncoding && triggerAMF3Switch(aMFData)) {
                dataOutputStream.write(17);
                aMFDataContextSerialize.setObjectEncoding(targetEncoding);
            }
            aMFData.serialize(dataOutputStream, aMFDataContextSerialize);
            aMFDataContextSerialize.setObjectEncoding(0);
        }
    }

    public byte[] serialize() {
        return serialize(createContextSerialize(0));
    }

    public byte[] serialize(int i) {
        return serialize(createContextSerialize(i));
    }

    public byte[] serialize(AMFDataContextSerialize aMFDataContextSerialize) {
        return serialize(aMFDataContextSerialize, (byte[]) null);
    }

    public byte[] serialize(AMFDataContextSerialize aMFDataContextSerialize, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(new DataOutputStream(byteArrayOutputStream), aMFDataContextSerialize, bArr);
        return byteArrayOutputStream.toByteArray();
    }

    public Object getValue() {
        return this.children;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AMFDataList:\n");
        int i = 0;
        for (AMFData aMFData : this.children) {
            if (aMFData.getType() == 3) {
                stringBuffer.append("[" + i + "] object\n" + aMFData.toString() + "\n");
            } else {
                stringBuffer.append("[" + i + "] " + aMFData.toString() + "\n");
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
