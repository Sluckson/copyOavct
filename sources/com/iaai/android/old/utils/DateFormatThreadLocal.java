package com.iaai.android.old.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateFormatThreadLocal extends ThreadLocal<DateFormat> {
    private final String datePattern;

    public DateFormatThreadLocal(String str) {
        this.datePattern = str;
    }

    /* access modifiers changed from: protected */
    public DateFormat initialValue() {
        return new SimpleDateFormat(this.datePattern);
    }
}
