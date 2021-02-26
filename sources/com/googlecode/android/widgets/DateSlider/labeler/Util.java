package com.googlecode.android.widgets.DateSlider.labeler;

import com.googlecode.android.widgets.DateSlider.TimeObject;
import java.util.Calendar;

class Util {
    Util() {
    }

    public static Calendar addYears(long j, int i) {
        return add(j, i, 1);
    }

    public static Calendar addMonths(long j, int i) {
        return add(j, i, 2);
    }

    public static Calendar addWeeks(long j, int i) {
        return add(j, i, 3);
    }

    public static Calendar addDays(long j, int i) {
        return add(j, i, 5);
    }

    public static Calendar addHours(long j, int i) {
        return add(j, i, 11);
    }

    public static Calendar addMinutes(long j, int i) {
        return add(j, i, 12);
    }

    public static Calendar addMinutes(long j, int i, int i2) {
        return add(j, i * i2, 12);
    }

    public static TimeObject getYear(Calendar calendar, String str) {
        Calendar calendar2 = calendar;
        int i = calendar.get(1);
        calendar2.set(i, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar2.set(i, 11, 31, 23, 59, 59);
        calendar.set(14, 999);
        return new TimeObject(String.format(str, new Object[]{calendar, calendar}), timeInMillis, calendar.getTimeInMillis());
    }

    public static TimeObject getMonth(Calendar calendar, String str) {
        Calendar calendar2 = calendar;
        int i = calendar2.get(1);
        int i2 = calendar2.get(2);
        calendar.set(i, i2, 1, 0, 0, 0);
        calendar2.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(i, i2, calendar2.getActualMaximum(5), 23, 59, 59);
        calendar2.set(14, 999);
        return new TimeObject(String.format(str, new Object[]{calendar2, calendar2}), timeInMillis, calendar.getTimeInMillis());
    }

    public static TimeObject getDay(Calendar calendar, String str) {
        Calendar calendar2 = calendar;
        int i = calendar2.get(1);
        Calendar calendar3 = calendar;
        int i2 = i;
        int i3 = calendar2.get(2);
        int i4 = calendar2.get(5);
        calendar3.set(i2, i3, i4, 0, 0, 0);
        calendar2.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar3.set(i2, i3, i4, 23, 59, 59);
        calendar2.set(14, 999);
        return new TimeObject(String.format(str, new Object[]{calendar2, calendar2}), timeInMillis, calendar.getTimeInMillis());
    }

    public static TimeObject getHour(Calendar calendar, String str) {
        Calendar calendar2 = calendar;
        int i = calendar2.get(1);
        int i2 = calendar2.get(2);
        Calendar calendar3 = calendar;
        int i3 = i;
        int i4 = i2;
        int i5 = calendar2.get(5);
        int i6 = calendar2.get(11);
        calendar3.set(i3, i4, i5, i6, 0, 0);
        calendar2.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar3.set(i3, i4, i5, i6, 59, 59);
        calendar2.set(14, 999);
        return new TimeObject(String.format(str, new Object[]{calendar2, calendar2}), timeInMillis, calendar.getTimeInMillis());
    }

    public static TimeObject getMinute(Calendar calendar, String str) {
        return getMinute(calendar, str, 1);
    }

    public static TimeObject getMinute(Calendar calendar, String str, int i) {
        Calendar calendar2 = calendar;
        int i2 = calendar2.get(1);
        int i3 = calendar2.get(2);
        int i4 = calendar2.get(5);
        int i5 = calendar2.get(11);
        int i6 = calendar2.get(12);
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        calendar.set(i7, i8, i9, i10, Math.min(59, (i6 + i) - 1), 59);
        calendar2.set(14, 999);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(i7, i8, i9, i10, i6, 0);
        calendar2.set(14, 0);
        return new TimeObject(String.format(str, new Object[]{calendar2, calendar2}), calendar.getTimeInMillis(), timeInMillis);
    }

    public static TimeObject getTime(Calendar calendar, String str, int i) {
        Calendar calendar2 = calendar;
        int i2 = calendar2.get(1);
        int i3 = calendar2.get(2);
        int i4 = calendar2.get(5);
        int i5 = calendar2.get(11);
        int i6 = (calendar2.get(12) / i) * i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        calendar.set(i7, i8, i9, i10, (i6 + i) - 1, 59);
        calendar2.set(14, 999);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(i7, i8, i9, i10, i6, 0);
        calendar2.set(14, 0);
        return new TimeObject(String.format(str, new Object[]{calendar2, calendar2}), calendar.getTimeInMillis(), timeInMillis);
    }

    private static Calendar add(long j, int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.add(i2, i);
        return instance;
    }
}
