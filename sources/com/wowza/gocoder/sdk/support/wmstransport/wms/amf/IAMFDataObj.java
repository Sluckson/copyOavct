package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import java.util.Date;
import java.util.List;

/* compiled from: GoCoderSDK */
public interface IAMFDataObj {
    public static final String TAG = "IAMFDataObj";

    boolean containsKey(String str);

    AMFData get(int i);

    AMFData get(String str);

    boolean getBoolean(int i);

    boolean getBoolean(String str);

    byte getByte(int i);

    byte getByte(String str);

    Date getDate(int i);

    Date getDate(String str);

    double getDouble(int i);

    double getDouble(String str);

    float getFloat(int i);

    float getFloat(String str);

    int getInt(int i);

    int getInt(String str);

    String getKey(int i);

    List getKeys();

    long getLong(int i);

    long getLong(String str);

    AMFDataObj getObject(int i);

    AMFDataObj getObject(String str);

    short getShort(int i);

    short getShort(String str);

    String getString(int i);

    String getString(String str);

    void put(String str, double d);

    void put(String str, int i);

    void put(String str, long j);

    void put(String str, AMFData aMFData);

    void put(String str, String str2);

    void put(String str, Date date);

    void put(String str, boolean z);

    AMFData remove(int i);

    AMFData remove(String str);
}
