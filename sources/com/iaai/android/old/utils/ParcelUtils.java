package com.iaai.android.old.utils;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.math.BigDecimal;
import java.util.Date;

public class ParcelUtils {
    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() == 1;
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static Date readDate(Parcel parcel) {
        return (Date) parcel.readValue(Date.class.getClassLoader());
    }

    public static void writeDate(Parcel parcel, Date date) {
        parcel.writeValue(date);
    }

    public static BigDecimal readBigDecimal(Parcel parcel) {
        return (BigDecimal) readValue(parcel, BigDecimal.class);
    }

    public static void writeBigDecimal(Parcel parcel, BigDecimal bigDecimal) {
        writeValue(parcel, bigDecimal);
    }

    public static <T> T readValue(Parcel parcel, Class<T> cls) {
        return parcel.readValue(cls.getClassLoader());
    }

    public static <T> void writeValue(Parcel parcel, T t) {
        parcel.writeValue(t);
    }

    public static boolean isTrue(String str) {
        return "true".equalsIgnoreCase(str) || IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(str);
    }

    public static int toInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String toString(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        return bigDecimal.toString();
    }

    public static BigDecimal toBigDecimal(String str) {
        if (TextUtils.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(str);
    }
}
