package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: GoCoderSDK */
public class AMFDataItem extends AMFData {
    public static final String DATEFORMAT = "EEE, dd MMM yyyy HH:mm:ss";
    public static final String TAG = "AMFDataItem";
    public static final TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
    protected SimpleDateFormat fastDateFormat = new SimpleDateFormat(DATEFORMAT, Locale.US);
    private Object value = null;

    public AMFDataItem() {
        this.type = 5;
        this.value = null;
        synchronized (this.fastDateFormat) {
            this.fastDateFormat.setTimeZone(gmtTimeZone);
        }
    }

    public AMFDataItem(String str) {
        if (str == null) {
            this.type = 5;
            this.value = null;
            return;
        }
        this.value = str;
        this.type = 2;
    }

    public AMFDataItem(int i) {
        this.value = new Double((double) i);
        this.type = 0;
    }

    public AMFDataItem(long j) {
        this.value = new Double((double) j);
        this.type = 0;
    }

    public AMFDataItem(double d) {
        this.value = new Double(d);
        this.type = 0;
    }

    public AMFDataItem(boolean z) {
        this.value = new Boolean(z);
        this.type = 1;
    }

    public AMFDataItem(Date date) {
        if (date == null) {
            this.type = 5;
            this.value = null;
            return;
        }
        this.value = date;
        this.type = 11;
    }

    public AMFDataItem(byte[] bArr) {
        deserialize(ByteBuffer.wrap(bArr));
    }

    public AMFDataItem(byte[] bArr, int i, int i2) {
        deserialize(ByteBuffer.wrap(bArr, i, i2));
    }

    public AMFDataItem(ByteBuffer byteBuffer) {
        deserialize(byteBuffer);
    }

    public AMFDataItem(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        deserialize(byteBuffer, aMFDataContextDeserialize);
    }

    public long longValue() {
        if (this.value == null) {
            return 0;
        }
        if (this.type == 0) {
            return ((Double) this.value).longValue();
        }
        if (this.type == 32) {
            return ((Integer) this.value).longValue();
        }
        if (this.type == 2) {
            return Long.parseLong((String) this.value);
        }
        return 0;
    }

    public int intValue() {
        if (this.value == null) {
            return 0;
        }
        if (this.type == 0) {
            return ((Double) this.value).intValue();
        }
        if (this.type == 32) {
            return ((Integer) this.value).intValue();
        }
        if (this.type == 2) {
            return Integer.parseInt((String) this.value);
        }
        return 0;
    }

    public double doubleValue() {
        if (this.value == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (this.type == 0) {
            return ((Double) this.value).doubleValue();
        }
        if (this.type == 32) {
            return ((Integer) this.value).doubleValue();
        }
        return this.type == 2 ? Double.parseDouble((String) this.value) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public float floatValue() {
        if (this.value == null) {
            return 0.0f;
        }
        if (this.type == 0) {
            return ((Double) this.value).floatValue();
        }
        if (this.type == 32) {
            return ((Integer) this.value).floatValue();
        }
        if (this.type == 2) {
            return Float.parseFloat((String) this.value);
        }
        return 0.0f;
    }

    public short shortValue() {
        if (this.value == null) {
            return 0;
        }
        if (this.type == 0) {
            return ((Double) this.value).shortValue();
        }
        if (this.type == 32) {
            return ((Integer) this.value).shortValue();
        }
        if (this.type == 2) {
            return Short.parseShort((String) this.value);
        }
        return 0;
    }

    public byte byteValue() {
        if (this.value == null) {
            return 0;
        }
        if (this.type == 0) {
            return ((Double) this.value).byteValue();
        }
        if (this.type == 32) {
            return ((Integer) this.value).byteValue();
        }
        if (this.type == 2) {
            return Byte.parseByte((String) this.value);
        }
        return 0;
    }

    public Date dateValue() {
        if (this.value == null || this.type != 11) {
            return null;
        }
        return (Date) this.value;
    }

    public boolean booleanValue() {
        if (this.value == null) {
            return false;
        }
        if (this.type == 1) {
            return ((Boolean) this.value).booleanValue();
        }
        if (this.type == 2) {
            return Boolean.parseBoolean((String) this.value);
        }
        return false;
    }

    public void deserialize(ByteBuffer byteBuffer) {
        deserialize(byteBuffer, createContextDeserialize());
    }

    public void deserialize(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        try {
            this.type = byteBuffer.get();
            boolean z = false;
            if (!aMFDataContextDeserialize.isAMF0()) {
                int i = this.type;
                if (i != 11) {
                    switch (i) {
                        case 1:
                            this.type = 5;
                            this.value = null;
                            return;
                        case 2:
                            this.type = 1;
                            this.value = new Boolean(false);
                            return;
                        case 3:
                            this.type = 1;
                            this.value = new Boolean(true);
                            return;
                        case 4:
                            this.type = 32;
                            this.value = new Integer(AMF3Utils.deserializeInt(byteBuffer));
                            return;
                        case 5:
                            this.type = 0;
                            this.value = new Double(byteBuffer.getDouble());
                            return;
                        case 6:
                            this.type = 2;
                            this.value = AMF3Utils.deserializeString(byteBuffer, aMFDataContextDeserialize);
                            return;
                        case 7:
                            this.type = 15;
                            int deserializeInt = AMF3Utils.deserializeInt(byteBuffer);
                            if ((deserializeInt & 1) == 0) {
                                this.value = aMFDataContextDeserialize.getObject(deserializeInt >> 1);
                                return;
                            }
                            int i2 = deserializeInt >> 1;
                            if (i2 > 0) {
                                this.value = AMF3Utils.deserializeString(byteBuffer, i2);
                            } else {
                                this.value = "";
                            }
                            aMFDataContextDeserialize.addObject(this.value);
                            return;
                        case 8:
                            this.type = 11;
                            int deserializeInt2 = AMF3Utils.deserializeInt(byteBuffer);
                            if ((deserializeInt2 & 1) == 0) {
                                this.value = aMFDataContextDeserialize.getObject(deserializeInt2 >> 1);
                                return;
                            }
                            this.value = AMF3Utils.deserializeDate(byteBuffer);
                            aMFDataContextDeserialize.addObject(this.value);
                            return;
                        default:
                            this.type = 6;
                            this.value = null;
                            return;
                    }
                }
                this.type = 34;
                int deserializeInt3 = AMF3Utils.deserializeInt(byteBuffer);
                if ((deserializeInt3 & 1) == 0) {
                    this.value = aMFDataContextDeserialize.getObject(deserializeInt3 >> 1);
                    return;
                }
                int i3 = deserializeInt3 >> 1;
                if (i3 > 0) {
                    this.value = AMF3Utils.deserializeString(byteBuffer, i3);
                } else {
                    this.value = "";
                }
                aMFDataContextDeserialize.addObject(this.value);
                return;
            }
            int i4 = this.type;
            if (i4 != -1) {
                if (i4 == 0) {
                    this.value = new Double(byteBuffer.getDouble());
                    return;
                } else if (i4 == 1) {
                    if (byteBuffer.get() != 0) {
                        z = true;
                    }
                    this.value = new Boolean(z);
                    return;
                } else if (i4 == 2) {
                    byte[] bArr = new byte[C4307c.m4264a(byteBuffer)];
                    byteBuffer.get(bArr);
                    this.value = new String(bArr, "UTF-8");
                    return;
                } else if (i4 != 5) {
                    if (i4 == 15) {
                        byte[] bArr2 = new byte[byteBuffer.getInt()];
                        byteBuffer.get(bArr2);
                        this.value = new String(bArr2, "UTF-8");
                        aMFDataContextDeserialize.addObject(this);
                        return;
                    } else if (i4 == 11) {
                        TimeZone timeZone = TimeZone.getDefault();
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.setTime(new Date((((long) byteBuffer.getDouble()) - ((long) timeZone.getRawOffset())) + ((long) (byteBuffer.getShort() * 60000 * -1))));
                        if (gregorianCalendar.getTimeZone().inDaylightTime(gregorianCalendar.getTime())) {
                            gregorianCalendar.setTime(new Date(gregorianCalendar.getTime().getTime() - 3600000));
                        }
                        this.value = gregorianCalendar.getTime();
                        aMFDataContextDeserialize.addObject(this);
                        return;
                    } else if (i4 != 12) {
                        this.type = 6;
                        this.value = null;
                        return;
                    } else {
                        this.type = 2;
                        byte[] bArr3 = new byte[byteBuffer.getInt()];
                        byteBuffer.get(bArr3);
                        this.value = new String(bArr3, "UTF-8");
                        return;
                    }
                }
            }
            this.type = 5;
            this.value = null;
        } catch (Exception unused) {
        }
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        String str;
        int i = this.type;
        if (i != -1) {
            if (i == 0) {
                return ((Double) this.value).toString();
            }
            if (i == 1) {
                return ((Boolean) this.value).toString();
            }
            if (i == 2) {
                return ((String) this.value).toString();
            }
            if (i != 5) {
                if (i == 11) {
                    synchronized (this.fastDateFormat) {
                        str = this.fastDateFormat.format((Date) this.value) + " GMT";
                    }
                    return str;
                } else if (i == 15) {
                    return ((String) this.value).toString();
                } else {
                    if (i == 32) {
                        return ((Integer) this.value).toString();
                    }
                    if (i != 34) {
                        return "undefined";
                    }
                    return ((String) this.value).toString();
                }
            }
        }
        return "null";
    }

    public void serialize(DataOutputStream dataOutputStream) {
        serialize(dataOutputStream, createContextSerialize(0));
    }

    public void serialize(DataOutputStream dataOutputStream, int i) {
        serialize(dataOutputStream, createContextSerialize(i));
    }

    public void serialize(DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize) {
        try {
            int i = 2;
            int i2 = 0;
            if (!aMFDataContextSerialize.isAMF0()) {
                int i3 = this.type;
                if (i3 == -1) {
                    dataOutputStream.writeByte(0);
                } else if (i3 == 0) {
                    dataOutputStream.writeByte(5);
                    dataOutputStream.writeDouble(((Double) this.value).doubleValue());
                } else if (i3 == 1) {
                    if (((Boolean) this.value).booleanValue()) {
                        i = 3;
                    }
                    dataOutputStream.writeByte(i);
                } else if (i3 == 2) {
                    dataOutputStream.write(6);
                    aMFDataContextSerialize.writeString(dataOutputStream, (String) this.value);
                } else if (i3 == 5) {
                    dataOutputStream.writeByte(1);
                } else if (i3 == 11) {
                    dataOutputStream.write(8);
                    int objectReference = aMFDataContextSerialize.getObjectReference(this.value);
                    if (objectReference >= 0) {
                        AMF3Utils.serializeInt(dataOutputStream, objectReference << 1);
                    } else {
                        AMF3Utils.serializeDate(dataOutputStream, (Date) this.value);
                    }
                } else if (i3 == 15) {
                    dataOutputStream.write(7);
                    int objectReference2 = aMFDataContextSerialize.getObjectReference(this.value);
                    if (objectReference2 >= 0) {
                        AMF3Utils.serializeInt(dataOutputStream, objectReference2 << 1);
                        return;
                    }
                    String str = (String) this.value;
                    if (str.length() > 0) {
                        AMF3Utils.serializeString(dataOutputStream, str);
                    } else {
                        AMF3Utils.serializeZeroLengthString(dataOutputStream);
                    }
                } else if (i3 == 32) {
                    int intValue = ((Integer) this.value).intValue();
                    if (intValue < -268435456 || intValue > 268435455) {
                        dataOutputStream.writeByte(5);
                        dataOutputStream.writeDouble(((Integer) this.value).doubleValue());
                        return;
                    }
                    dataOutputStream.writeByte(4);
                    AMF3Utils.serializeInt(dataOutputStream, intValue);
                } else if (i3 != 34) {
                    dataOutputStream.writeByte(0);
                } else {
                    dataOutputStream.write(11);
                    int objectReference3 = aMFDataContextSerialize.getObjectReference(this.value);
                    if (objectReference3 >= 0) {
                        AMF3Utils.serializeInt(dataOutputStream, objectReference3 << 1);
                        return;
                    }
                    String str2 = (String) this.value;
                    if (str2.length() > 0) {
                        AMF3Utils.serializeString(dataOutputStream, str2);
                    } else {
                        AMF3Utils.serializeZeroLengthString(dataOutputStream);
                    }
                }
            } else {
                int i4 = this.type;
                if (i4 == 0) {
                    dataOutputStream.writeByte(0);
                    dataOutputStream.writeDouble(((Double) this.value).doubleValue());
                } else if (i4 == 1) {
                    dataOutputStream.writeByte(1);
                    dataOutputStream.writeBoolean(((Boolean) this.value).booleanValue());
                } else if (i4 != 2) {
                    if (i4 == 11) {
                        dataOutputStream.writeByte(11);
                        dataOutputStream.writeDouble((double) ((Date) this.value).getTime());
                        TimeZone timeZone = TimeZone.getDefault();
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.setTime((Date) this.value);
                        boolean inDaylightTime = timeZone.inDaylightTime(gregorianCalendar.getTime());
                        int i5 = -TimeZone.getDefault().getRawOffset();
                        if (inDaylightTime) {
                            i2 = 3600000;
                        }
                        dataOutputStream.writeShort((i5 - i2) / 60000);
                    } else if (i4 == 15) {
                        dataOutputStream.writeByte(15);
                        dataOutputStream.writeInt(((String) this.value).length());
                        AMF3Utils.serializeStringNoLength(dataOutputStream, (String) this.value);
                    } else if (i4 != 32) {
                        dataOutputStream.writeByte(5);
                    } else {
                        dataOutputStream.writeByte(0);
                        dataOutputStream.writeDouble(((Integer) this.value).doubleValue());
                    }
                } else if (((String) this.value).length() > 32767) {
                    dataOutputStream.writeByte(12);
                    dataOutputStream.writeInt(((String) this.value).length());
                    AMF3Utils.serializeStringNoLength(dataOutputStream, (String) this.value);
                } else {
                    dataOutputStream.writeByte(2);
                    dataOutputStream.writeUTF(this.value.toString());
                }
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
}
