package com.wowza.gocoder.sdk.api.data;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

/* compiled from: GoCoderSDK */
public class WOWZDataItem extends WOWZData implements Serializable {

    /* renamed from: a */
    private Object f3596a = null;

    public WOWZDataItem() {
        this.mDataType = WOWZDataType.NULL;
        this.f3596a = null;
    }

    public WOWZDataItem(WOWZDataItem wOWZDataItem) {
        set(wOWZDataItem);
    }

    public void set(WOWZDataItem wOWZDataItem) {
        this.mDataType = wOWZDataItem.mDataType;
        switch (wOWZDataItem.mDataType) {
            case NULL:
                this.f3596a = null;
                return;
            case BOOLEAN:
                setValue(wOWZDataItem.booleanValue());
                return;
            case DATE:
                setValue(wOWZDataItem.dateValue());
                return;
            case DOUBLE:
                setValue(wOWZDataItem.doubleValue());
                return;
            case FLOAT:
                setValue(wOWZDataItem.floatValue());
                return;
            case INTEGER:
                setValue(wOWZDataItem.intValue());
                return;
            case LONG:
                setValue(wOWZDataItem.longValue());
                return;
            case SHORT:
                setValue(wOWZDataItem.shortValue());
                return;
            case STRING:
                setValue(wOWZDataItem.stringValue());
                return;
            default:
                return;
        }
    }

    public WOWZDataItem(int i) {
        this.mDataType = WOWZDataType.INTEGER;
        setValue(i);
    }

    public WOWZDataItem(short s) {
        this.mDataType = WOWZDataType.SHORT;
        setValue(s);
    }

    public WOWZDataItem(long j) {
        this.mDataType = WOWZDataType.LONG;
        setValue(j);
    }

    public WOWZDataItem(float f) {
        this.mDataType = WOWZDataType.FLOAT;
        setValue(f);
    }

    public WOWZDataItem(double d) {
        this.mDataType = WOWZDataType.DOUBLE;
        setValue(d);
    }

    public WOWZDataItem(String str) {
        this.mDataType = WOWZDataType.STRING;
        setValue(str);
    }

    public WOWZDataItem(boolean z) {
        this.mDataType = WOWZDataType.BOOLEAN;
        setValue(z);
    }

    public WOWZDataItem(Date date) {
        this.mDataType = WOWZDataType.DATE;
        setValue(date);
    }

    public void setValue(int i) {
        if (this.mDataType == WOWZDataType.INTEGER) {
            this.f3596a = Double.valueOf((double) i);
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public void setValue(short s) {
        if (this.mDataType == WOWZDataType.SHORT) {
            this.f3596a = Double.valueOf((double) s);
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public void setValue(long j) {
        if (this.mDataType == WOWZDataType.LONG) {
            this.f3596a = Double.valueOf((double) j);
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public void setValue(float f) {
        if (this.mDataType == WOWZDataType.FLOAT) {
            this.f3596a = Double.valueOf((double) f);
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public void setValue(double d) {
        if (this.mDataType == WOWZDataType.DOUBLE) {
            this.f3596a = Double.valueOf(d);
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public void setValue(String str) {
        if (this.mDataType == WOWZDataType.STRING) {
            this.f3596a = str;
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public void setValue(boolean z) {
        if (this.mDataType == WOWZDataType.BOOLEAN) {
            this.f3596a = Boolean.valueOf(z);
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public void setValue(Date date) {
        if (this.mDataType == WOWZDataType.DATE) {
            this.f3596a = date;
            return;
        }
        throw new RuntimeException("Attempt to set a WOWZ data item value with an invalid data type.");
    }

    public int intValue() {
        if (this.mDataType == WOWZDataType.INTEGER) {
            return ((Double) this.f3596a).intValue();
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public long longValue() {
        if (this.mDataType == WOWZDataType.LONG) {
            return ((Double) this.f3596a).longValue();
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public short shortValue() {
        if (this.mDataType == WOWZDataType.SHORT) {
            return ((Double) this.f3596a).shortValue();
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public float floatValue() {
        if (this.mDataType == WOWZDataType.FLOAT) {
            return ((Double) this.f3596a).floatValue();
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public double doubleValue() {
        if (this.mDataType == WOWZDataType.DOUBLE) {
            return ((Double) this.f3596a).doubleValue();
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public String stringValue() {
        if (this.mDataType == WOWZDataType.STRING) {
            return (String) this.f3596a;
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public Date dateValue() {
        if (this.mDataType == WOWZDataType.DATE) {
            return (Date) this.f3596a;
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public boolean booleanValue() {
        if (this.mDataType == WOWZDataType.BOOLEAN) {
            return ((Boolean) this.f3596a).booleanValue();
        }
        throw new RuntimeException("Attempt to access a WOWZ data item value with an invalid data type.");
    }

    public String toString() {
        switch (getDataType()) {
            case NULL:
                return "";
            case BOOLEAN:
                return Boolean.toString(booleanValue());
            case DATE:
                return dateValue().toString();
            case DOUBLE:
                return new DecimalFormat("#.#").format(doubleValue());
            case FLOAT:
                return Float.toString(floatValue());
            case INTEGER:
                return Integer.toString(intValue());
            case LONG:
                return Long.toString(longValue());
            case SHORT:
                return Short.toString(shortValue());
            case STRING:
                return stringValue();
            default:
                return super.toString();
        }
    }

    public boolean isNull() {
        return this.f3596a == null;
    }
}
