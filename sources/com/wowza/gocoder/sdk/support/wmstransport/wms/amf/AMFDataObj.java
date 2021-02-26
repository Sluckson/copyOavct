package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GoCoderSDK */
public class AMFDataObj extends AMFData implements IAMFDataObj {
    public static final int DECODE_OBJ_REF = 1;
    public static final int DECODE_TRAITS = 4;
    public static final int DECODE_TRAITS_EXT = 3;
    public static final int DECODE_TRAITS_REF = 2;
    public static final int DECODE_UNDEFINED = 0;
    public static final String TAG = "AMFDataObj";
    protected Map<String, AMFData> members = new HashMap();
    protected List<String> order = new ArrayList();
    protected IAMFExternalizable serializer = null;
    protected AMFDataTrait trait = null;

    public AMFDataObj() {
        this.type = 3;
    }

    public AMFDataObj(byte[] bArr) {
        this.type = 3;
        deserialize(ByteBuffer.wrap(bArr));
    }

    public AMFDataObj(byte[] bArr, int i, int i2) {
        this.type = 3;
        deserialize(ByteBuffer.wrap(bArr, i, i2));
    }

    public AMFDataObj(ByteBuffer byteBuffer) {
        this.type = 3;
        deserialize(byteBuffer);
    }

    public AMFDataObj(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) {
        this.type = 3;
        deserialize(byteBuffer, aMFDataContextDeserialize);
    }

    public int size() {
        return this.members.size();
    }

    public boolean containsKey(String str) {
        return this.members.containsKey(str);
    }

    public void put(String str, AMFData aMFData) {
        try {
            this.members.put(str, aMFData);
            this.order.remove(str);
            this.order.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String str, String str2) {
        try {
            this.members.put(str, new AMFDataItem(str2));
            this.order.remove(str);
            this.order.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String str, double d) {
        try {
            this.members.put(str, new AMFDataItem(d));
            this.order.remove(str);
            this.order.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String str, int i) {
        try {
            this.members.put(str, new AMFDataItem(i));
            this.order.remove(str);
            this.order.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String str, long j) {
        try {
            this.members.put(str, new AMFDataItem(j));
            this.order.remove(str);
            this.order.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String str, Date date) {
        try {
            this.members.put(str, new AMFDataItem(date));
            this.order.remove(str);
            this.order.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String str, boolean z) {
        try {
            this.members.put(str, new AMFDataItem(z));
            this.order.remove(str);
            this.order.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List getKeys() {
        return new ArrayList(this.order);
    }

    public String getKey(int i) {
        try {
            return this.order.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AMFData get(String str) {
        try {
            return this.members.get(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AMFData get(int i) {
        try {
            String str = this.order.get(i);
            if (str != null) {
                return this.members.get(str);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AMFData remove(String str) {
        try {
            this.order.remove(str);
            return this.members.remove(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AMFData remove(int i) {
        try {
            String remove = this.order.remove(i);
            if (remove != null) {
                return this.members.remove(remove);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getString(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        if (aMFDataItem != null) {
            return aMFDataItem.toString();
        }
        return null;
    }

    public int getInt(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        if (aMFDataItem != null) {
            return aMFDataItem.intValue();
        }
        return 0;
    }

    public long getLong(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        if (aMFDataItem != null) {
            return aMFDataItem.longValue();
        }
        return 0;
    }

    public short getShort(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        if (aMFDataItem != null) {
            return aMFDataItem.shortValue();
        }
        return 0;
    }

    public double getDouble(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        return aMFDataItem != null ? aMFDataItem.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public float getFloat(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        if (aMFDataItem != null) {
            return aMFDataItem.floatValue();
        }
        return 0.0f;
    }

    public byte getByte(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        if (aMFDataItem != null) {
            return aMFDataItem.byteValue();
        }
        return 0;
    }

    public boolean getBoolean(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        if (aMFDataItem != null) {
            return aMFDataItem.booleanValue();
        }
        return false;
    }

    public Date getDate(String str) {
        AMFDataItem aMFDataItem = (AMFDataItem) get(str);
        Object obj = null;
        if (aMFDataItem != null && aMFDataItem.getType() == 11) {
            obj = aMFDataItem.getValue();
        }
        return (Date) obj;
    }

    public AMFDataObj getObject(String str) {
        return (AMFDataObj) get(str);
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
        deserialize(byteBuffer, AMFData.createContextDeserialize());
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ Exception -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00af A[Catch:{ Exception -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b2 A[Catch:{ Exception -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deserialize(java.nio.ByteBuffer r10, com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataContextDeserialize r11) {
        /*
            r9 = this;
            boolean r0 = r11.isAMF0()     // Catch:{ Exception -> 0x0148 }
            r1 = 3
            if (r0 != 0) goto L_0x0108
            boolean r0 = r11.isIntData()     // Catch:{ Exception -> 0x0148 }
            if (r0 == 0) goto L_0x0012
            int r0 = r11.clearIntData()     // Catch:{ Exception -> 0x0148 }
            goto L_0x0016
        L_0x0012:
            int r0 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMF3Utils.deserializeInt(r10)     // Catch:{ Exception -> 0x0148 }
        L_0x0016:
            r2 = r0 & 1
            r3 = 4
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 != 0) goto L_0x0024
            int r0 = r0 >> r6
            r2 = r0
            r0 = 1
        L_0x0021:
            r7 = 0
            r8 = 0
            goto L_0x0042
        L_0x0024:
            int r0 = r0 >> r6
            r2 = r0 & 1
            if (r2 != 0) goto L_0x002d
            int r0 = r0 >> r6
            r2 = r0
            r0 = 2
            goto L_0x0021
        L_0x002d:
            int r0 = r0 >> r6
            r2 = r0 & 1
            if (r2 != r6) goto L_0x0035
            r0 = 3
            r2 = 0
            goto L_0x0021
        L_0x0035:
            int r0 = r0 >> r6
            r2 = r0 & 1
            if (r2 != r6) goto L_0x003c
            r2 = 1
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            int r0 = r0 >> r6
            r8 = r0
            r7 = r2
            r0 = 4
            r2 = 0
        L_0x0042:
            if (r0 == r6) goto L_0x00af
            if (r0 == r4) goto L_0x00a8
            if (r0 == r1) goto L_0x0074
            if (r0 == r3) goto L_0x004b
            goto L_0x00b0
        L_0x004b:
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = new com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait     // Catch:{ Exception -> 0x0148 }
            r0.<init>()     // Catch:{ Exception -> 0x0148 }
            r9.trait = r0     // Catch:{ Exception -> 0x0148 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = r9.trait     // Catch:{ Exception -> 0x0148 }
            r11.addTrait(r0)     // Catch:{ Exception -> 0x0148 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = r9.trait     // Catch:{ Exception -> 0x0148 }
            r0.setDynamic(r7)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r0 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMF3Utils.deserializeString((java.nio.ByteBuffer) r10, (com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataContextDeserialize) r11)     // Catch:{ Exception -> 0x0148 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r1 = r9.trait     // Catch:{ Exception -> 0x0148 }
            r1.setClassName(r0)     // Catch:{ Exception -> 0x0148 }
            r0 = 0
        L_0x0066:
            if (r0 >= r8) goto L_0x00b0
            java.lang.String r1 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMF3Utils.deserializeString((java.nio.ByteBuffer) r10, (com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataContextDeserialize) r11)     // Catch:{ Exception -> 0x0148 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r2 = r9.trait     // Catch:{ Exception -> 0x0148 }
            r2.addMember(r1)     // Catch:{ Exception -> 0x0148 }
            int r0 = r0 + 1
            goto L_0x0066
        L_0x0074:
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = new com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait     // Catch:{ Exception -> 0x0148 }
            r0.<init>()     // Catch:{ Exception -> 0x0148 }
            r9.trait = r0     // Catch:{ Exception -> 0x0148 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = r9.trait     // Catch:{ Exception -> 0x0148 }
            r11.addTrait(r0)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r0 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMF3Utils.deserializeString((java.nio.ByteBuffer) r10, (com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataContextDeserialize) r11)     // Catch:{ Exception -> 0x0148 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r1 = r9.trait     // Catch:{ Exception -> 0x0148 }
            r1.setClassName(r0)     // Catch:{ Exception -> 0x0148 }
            java.lang.Class r1 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00b0 }
            if (r1 != 0) goto L_0x0090
            goto L_0x00b0
        L_0x0090:
            java.lang.Object r1 = r1.newInstance()     // Catch:{ Exception -> 0x00b0 }
            boolean r2 = r1 instanceof com.wowza.gocoder.sdk.support.wmstransport.wms.amf.IAMFExternalizable     // Catch:{ Exception -> 0x00b0 }
            if (r2 != 0) goto L_0x0099
            goto L_0x00b0
        L_0x0099:
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.IAMFExternalizable r1 = (com.wowza.gocoder.sdk.support.wmstransport.wms.amf.IAMFExternalizable) r1     // Catch:{ Exception -> 0x00b0 }
            r9.serializer = r1     // Catch:{ Exception -> 0x00b0 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.IAMFExternalizable r1 = r9.serializer     // Catch:{ Exception -> 0x00b0 }
            r1.setClassName(r0)     // Catch:{ Exception -> 0x00b0 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.IAMFExternalizable r0 = r9.serializer     // Catch:{ Exception -> 0x00b0 }
            r0.deserialize(r9, r10, r11)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00b0
        L_0x00a8:
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = r11.getTrait(r2)     // Catch:{ Exception -> 0x0148 }
            r9.trait = r0     // Catch:{ Exception -> 0x0148 }
            goto L_0x00b0
        L_0x00af:
            r6 = 0
        L_0x00b0:
            if (r6 == 0) goto L_0x014c
            r11.addObject(r9)     // Catch:{ Exception -> 0x0148 }
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = r9.trait     // Catch:{ Exception -> 0x0148 }
            if (r0 == 0) goto L_0x014c
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = r9.trait     // Catch:{ Exception -> 0x0148 }
            int r0 = r0.getMemberCount()     // Catch:{ Exception -> 0x0148 }
        L_0x00bf:
            if (r5 >= r0) goto L_0x00df
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData r1 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData.deserializeInnerObject(r10, r11)     // Catch:{ Exception -> 0x0148 }
            if (r1 == 0) goto L_0x00dc
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r2 = r9.trait     // Catch:{ Exception -> 0x0148 }
            java.lang.String r2 = r2.getMember(r5)     // Catch:{ Exception -> 0x0148 }
            java.util.Map<java.lang.String, com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData> r3 = r9.members     // Catch:{ Exception -> 0x0148 }
            r3.put(r2, r1)     // Catch:{ Exception -> 0x0148 }
            java.util.List<java.lang.String> r1 = r9.order     // Catch:{ Exception -> 0x0148 }
            r1.remove(r2)     // Catch:{ Exception -> 0x0148 }
            java.util.List<java.lang.String> r1 = r9.order     // Catch:{ Exception -> 0x0148 }
            r1.add(r2)     // Catch:{ Exception -> 0x0148 }
        L_0x00dc:
            int r5 = r5 + 1
            goto L_0x00bf
        L_0x00df:
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataTrait r0 = r9.trait     // Catch:{ Exception -> 0x0148 }
            boolean r0 = r0.isDynamic()     // Catch:{ Exception -> 0x0148 }
            if (r0 == 0) goto L_0x014c
        L_0x00e7:
            java.lang.String r0 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMF3Utils.deserializeString((java.nio.ByteBuffer) r10, (com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataContextDeserialize) r11)     // Catch:{ Exception -> 0x0148 }
            int r1 = r0.length()     // Catch:{ Exception -> 0x0148 }
            if (r1 != 0) goto L_0x00f2
            goto L_0x014c
        L_0x00f2:
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData r1 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData.deserializeInnerObject(r10, r11)     // Catch:{ Exception -> 0x0148 }
            if (r1 == 0) goto L_0x00e7
            java.util.Map<java.lang.String, com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData> r2 = r9.members     // Catch:{ Exception -> 0x0148 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x0148 }
            java.util.List<java.lang.String> r1 = r9.order     // Catch:{ Exception -> 0x0148 }
            r1.remove(r0)     // Catch:{ Exception -> 0x0148 }
            java.util.List<java.lang.String> r1 = r9.order     // Catch:{ Exception -> 0x0148 }
            r1.add(r0)     // Catch:{ Exception -> 0x0148 }
            goto L_0x00e7
        L_0x0108:
            r11.addObject(r9)     // Catch:{ Exception -> 0x0148 }
        L_0x010b:
            int r0 = r10.remaining()     // Catch:{ Exception -> 0x0148 }
            if (r0 < r1) goto L_0x014c
            int r0 = com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c.m4264a((java.nio.ByteBuffer) r10)     // Catch:{ Exception -> 0x0148 }
            if (r0 != 0) goto L_0x011e
            boolean r2 = isObjEnd(r10, r11)     // Catch:{ Exception -> 0x0148 }
            if (r2 == 0) goto L_0x011e
            goto L_0x014c
        L_0x011e:
            if (r0 <= 0) goto L_0x012d
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0148 }
            r10.get(r0)     // Catch:{ Exception -> 0x0148 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0148 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r0, r3)     // Catch:{ Exception -> 0x0148 }
            goto L_0x0132
        L_0x012d:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0148 }
            r2.<init>()     // Catch:{ Exception -> 0x0148 }
        L_0x0132:
            com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData r0 = com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData.deserializeInnerObject(r10, r11)     // Catch:{ Exception -> 0x0148 }
            if (r0 == 0) goto L_0x010b
            java.util.Map<java.lang.String, com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData> r3 = r9.members     // Catch:{ Exception -> 0x0148 }
            r3.put(r2, r0)     // Catch:{ Exception -> 0x0148 }
            java.util.List<java.lang.String> r0 = r9.order     // Catch:{ Exception -> 0x0148 }
            r0.remove(r2)     // Catch:{ Exception -> 0x0148 }
            java.util.List<java.lang.String> r0 = r9.order     // Catch:{ Exception -> 0x0148 }
            r0.add(r2)     // Catch:{ Exception -> 0x0148 }
            goto L_0x010b
        L_0x0148:
            r10 = move-exception
            r10.printStackTrace()
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataObj.deserialize(java.nio.ByteBuffer, com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFDataContextDeserialize):void");
    }

    public void serialize(DataOutputStream dataOutputStream) {
        serialize(dataOutputStream, AMFData.createContextSerialize(0));
    }

    public void serialize(DataOutputStream dataOutputStream, int i) {
        serialize(dataOutputStream, AMFData.createContextSerialize(i));
    }

    public void serialize(DataOutputStream dataOutputStream, AMFDataContextSerialize aMFDataContextSerialize) {
        boolean z;
        int i;
        try {
            if (!aMFDataContextSerialize.isAMF0()) {
                dataOutputStream.write(10);
                int objectReference = aMFDataContextSerialize.getObjectReference(this);
                if (objectReference >= 0) {
                    AMF3Utils.serializeInt(dataOutputStream, objectReference << 1);
                } else if (this.serializer != null) {
                    AMF3Utils.serializeInt(dataOutputStream, 7);
                    aMFDataContextSerialize.writeString(dataOutputStream, this.serializer.getClassName());
                    this.serializer.serialize(this, dataOutputStream, aMFDataContextSerialize);
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(this.order);
                    int i2 = -1;
                    if (this.trait != null) {
                        boolean isDynamic = this.trait.isDynamic();
                        i = this.trait.getMemberCount();
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList.remove(this.trait.getMember(i3));
                        }
                        if (arrayList.size() > 0) {
                            isDynamic = true;
                        }
                        if (this.trait.isDynamic() != isDynamic) {
                            this.trait = this.trait.clone();
                            this.trait.setDynamic(isDynamic);
                        }
                        z = isDynamic;
                        i2 = aMFDataContextSerialize.getTraitReference(this.trait);
                    } else {
                        i = 0;
                        z = true;
                    }
                    if (i2 >= 0) {
                        AMF3Utils.serializeInt(dataOutputStream, (i2 << 2) + 1);
                    } else {
                        int i4 = 3 | (i << 4);
                        if (z) {
                            i4 |= 8;
                        }
                        AMF3Utils.serializeInt(dataOutputStream, i4);
                        aMFDataContextSerialize.writeString(dataOutputStream, getClassName());
                        for (int i5 = 0; i5 < i; i5++) {
                            aMFDataContextSerialize.writeString(dataOutputStream, this.trait.getMember(i5));
                        }
                    }
                    for (int i6 = 0; i6 < i; i6++) {
                        AMFData aMFData = this.members.get(this.trait.getMember(i6));
                        if (aMFData != null) {
                            aMFData.serialize(dataOutputStream, aMFDataContextSerialize);
                        } else {
                            dataOutputStream.write(6);
                        }
                    }
                    if (z) {
                        for (String str : arrayList) {
                            aMFDataContextSerialize.writeString(dataOutputStream, str);
                            this.members.get(str).serialize(dataOutputStream, aMFDataContextSerialize);
                        }
                        AMF3Utils.serializeZeroLengthString(dataOutputStream);
                    }
                }
            } else {
                dataOutputStream.write(3);
                for (String next : this.order) {
                    dataOutputStream.writeUTF(next);
                    this.members.get(next).serialize(dataOutputStream, aMFDataContextSerialize);
                }
                dataOutputStream.writeShort(0);
                dataOutputStream.write(9);
            }
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

    public Object getValue() {
        return this.members;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{Obj[" + getClassName() + "]: ");
        int i = 0;
        for (String next : this.order) {
            AMFData aMFData = this.members.get(next);
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

    public String getClassName() {
        AMFDataTrait aMFDataTrait = this.trait;
        return aMFDataTrait == null ? "" : aMFDataTrait.getClassName();
    }

    public void setClassName(String str) {
        if (this.trait == null) {
            this.trait = new AMFDataTrait();
        }
        this.trait.setClassName(str);
    }

    public AMFDataTrait getTrait() {
        return this.trait;
    }

    public IAMFExternalizable getSerializer() {
        return this.serializer;
    }

    public void setSerializer(IAMFExternalizable iAMFExternalizable) {
        this.serializer = iAMFExternalizable;
    }
}
