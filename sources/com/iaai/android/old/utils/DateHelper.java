package com.iaai.android.old.utils;

import android.text.TextUtils;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.HtmlTags;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import roboguice.util.C5058Ln;

public class DateHelper {
    public static final long DAY_MILLIS = 86400000;
    public static final long HOUR_MILLIS = 3600000;
    public static final long MINUTE_MILLIS = 60000;
    public static final long SECOND_MILLIS = 1000;
    public static int SERVER_RECYCLE_HOUR = 2;
    public static int SERVER_RECYCLE_MINUTE = 5;
    private static long serverRecycleMillis = -1;

    public static TimeDiff calculateTimeDiff(Date date, Date date2) {
        if (date == null || date2 == null) {
            return null;
        }
        long abs = Math.abs(date.getTime() - date2.getTime());
        return new TimeDiff(abs / 3600000, (abs % 3600000) / 60000, (abs % 60000) / 1000);
    }

    public static TimeDiff calculateDateTimeDiff(Date date, Date date2) {
        if (date == null || date2 == null) {
            return null;
        }
        long abs = Math.abs(date.getTime() - date2.getTime());
        long j = abs % 86400000;
        return new TimeDiff(abs / 86400000, j / 3600000, (j % 3600000) / 60000, (abs % 60000) / 1000);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == date2) {
            return true;
        }
        if (date == null || date2 == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(date.getTime());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(date2.getTime());
        return isSameDay(instance, instance2);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == calendar2) {
            return true;
        }
        if (calendar != null && calendar2 != null && calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return true;
        }
        return false;
    }

    public static boolean isSameDayInServerTimezone(long j, long j2) {
        return isSameDay(toCalendarInTimeZone(j, Constants.TIMEZONE_SERVER), toCalendarInTimeZone(j2, Constants.TIMEZONE_SERVER));
    }

    private static Calendar toCalendarInTimeZone(long j, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.set(1, instance.get(1));
        instance2.set(2, instance.get(2));
        instance2.set(5, instance.get(5));
        instance2.set(11, instance.get(11));
        instance2.set(12, instance.get(12));
        instance2.set(13, instance.get(13));
        instance2.set(14, instance.get(14));
        return instance2;
    }

    public static Date getDate(String str) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String format(Date date, String str) {
        if (date == null) {
            return "";
        }
        if (IaaiApplication.getInstance().getResources().getConfiguration().locale.getLanguage().equalsIgnoreCase("ar")) {
            return new SimpleDateFormat(str, Locale.ENGLISH).format(date);
        }
        return getDateFormatByPattern(str).format(date);
    }

    public static String format(long j, String str) {
        return getDateFormatByPattern(str).format(Long.valueOf(j));
    }

    public static String formatAuctionDate(Date date) {
        return format(date, (date == null || date.getMinutes() != 0) ? Constants.DATE_NEW_PATTERN_AUCTION_DATE_SHORT : Constants.DATE_NEW_PATTERN_AUCTION_DATE_SHORT_HOUR_ONLY);
    }

    public static String formatAuctionShortDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return String.format("%tA, %tB %te, %tY", new Object[]{instance, instance, instance, instance});
    }

    public static Date parse(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2, Locale.US).parse(str);
        } catch (ParseException e) {
            C5058Ln.m4834e(e, "Unable to parse date[%s] pattern[%s]", str, str2);
            return null;
        }
    }

    public static Date parseDateInServerTimezone(String str) {
        Date parse = parse(str, Constants.DATE_PATTERN_DATE_TIME);
        if (parse == null) {
            return null;
        }
        return toDateInTimeZone(parse, Constants.TIMEZONE_SERVER);
    }

    public static String convertFormat(String str, String str2, String str3) {
        if (str != null && !TextUtils.isEmpty(str)) {
            DateFormat dateFormatByPattern = getDateFormatByPattern(str2);
            try {
                return getDateFormatByPattern(str3).format(dateFormatByPattern.parse(str));
            } catch (ParseException e) {
                C5058Ln.m4843w(e, "Fail to convert date[%s] string from format[%s] to format[%s]", str, str2, str3);
            }
        }
        return "";
    }

    public static String convertFormatETOB(String str, String str2, String str3) {
        if (str != null && !TextUtils.isEmpty(str)) {
            DateFormat dateFormatByPattern = getDateFormatByPattern(str2);
            DateFormat dateFormatByPattern2 = getDateFormatByPattern(str3);
            dateFormatByPattern.setTimeZone(Constants.TIMEZONE_SERVER);
            dateFormatByPattern2.setTimeZone(Constants.TIMEZONE_SERVER);
            try {
                return dateFormatByPattern2.format(dateFormatByPattern.parse(str));
            } catch (ParseException e) {
                C5058Ln.m4843w(e, "Fail to convert date[%s] string from format[%s] to format[%s]", str, str2, str3);
            }
        }
        return "";
    }

    public static Calendar convertToDateOnlyCalendar(Date date) {
        if (date == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(date.getYear() + 1900, date.getMonth(), date.getDate());
        return instance;
    }

    public static Date addDay(Date date, int i) {
        return new Date(date.getTime() + (((long) i) * 86400000));
    }

    private static DateFormat getDateFormatByPattern(String str) {
        DateFormatThreadLocal dateFormatThreadLocal;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (concurrentHashMap.containsKey(str)) {
            dateFormatThreadLocal = (DateFormatThreadLocal) concurrentHashMap.get(str);
        } else {
            DateFormatThreadLocal dateFormatThreadLocal2 = new DateFormatThreadLocal(str);
            concurrentHashMap.putIfAbsent(str, dateFormatThreadLocal2);
            dateFormatThreadLocal = dateFormatThreadLocal2;
        }
        return (DateFormat) dateFormatThreadLocal.get();
    }

    public static boolean isPast(Date date) {
        return date == null || System.currentTimeMillis() > date.getTime();
    }

    public static boolean isTomorrow(Calendar calendar) {
        if (calendar == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, -1);
        if (calendar2.get(1) == instance.get(1) && calendar2.get(2) == instance.get(2) && calendar2.get(5) == instance.get(5)) {
            return true;
        }
        return false;
    }

    public static Date toDateInTimeZone(Date date, TimeZone timeZone) {
        return toCalendarInTimeZone(date.getTime(), timeZone).getTime();
    }

    public static void changeServerRecycleTime(int i, int i2) {
        serverRecycleMillis = -1;
        SERVER_RECYCLE_HOUR = i;
        SERVER_RECYCLE_MINUTE = i2;
    }

    public static long getServerRecycleMillis() {
        if (serverRecycleMillis <= 0 || System.currentTimeMillis() - serverRecycleMillis >= 86400000) {
            Calendar instance = Calendar.getInstance(Constants.TIMEZONE_SERVER);
            instance.setTimeInMillis(System.currentTimeMillis());
            instance.set(11, SERVER_RECYCLE_HOUR);
            instance.set(12, SERVER_RECYCLE_MINUTE);
            instance.set(13, 0);
            instance.set(14, 0);
            serverRecycleMillis = instance.getTimeInMillis();
        }
        return serverRecycleMillis;
    }

    public static class TimeDiff {
        public final int days;
        public final int hours;
        public final int minutes;
        public final int seconds;

        public TimeDiff(int i, int i2, int i3) {
            this.days = 0;
            this.hours = i;
            this.minutes = i2;
            this.seconds = i3;
        }

        public TimeDiff(long j, long j2, long j3) {
            this((int) j, (int) j2, (int) j3);
        }

        public TimeDiff(int i, int i2, int i3, int i4) {
            this.days = i;
            this.hours = i2;
            this.minutes = i3;
            this.seconds = i4;
        }

        public TimeDiff(long j, long j2, long j3, long j4) {
            this((int) j, (int) j2, (int) j3, (int) j4);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int i = this.days;
            if (i > 0) {
                sb.append(i);
                sb.append("d ");
            }
            if (this.days > 0 || this.hours > 0) {
                sb.append(this.hours);
                sb.append("h ");
            }
            sb.append(this.minutes);
            sb.append("m ");
            if (this.days <= 0 && this.hours <= 0) {
                sb.append(this.seconds);
                sb.append(HtmlTags.f607S);
            }
            return sb.toString();
        }

        public String getPreBidTimeString() {
            int i;
            StringBuilder sb = new StringBuilder();
            int i2 = this.days;
            if (i2 > 0) {
                sb.append(i2);
                sb.append("d ");
                i = 1;
            } else {
                i = 0;
            }
            if (this.days > 0 || this.hours > 0) {
                sb.append(this.hours);
                sb.append("h ");
                i++;
            }
            if (i == 2) {
                return sb.toString();
            }
            sb.append(this.minutes);
            sb.append("m ");
            if (i + 1 == 2) {
                return sb.toString();
            }
            if (this.days <= 0 && this.hours <= 0) {
                sb.append(this.seconds);
                sb.append(HtmlTags.f607S);
            }
            return sb.toString();
        }
    }

    public static String convertByteToString(byte[] bArr) {
        return bArr.toString();
    }

    public static Date getDateFromString(String str) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.ENGLISH).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getETOBDateFormat(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_ETBO, Locale.US);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        try {
            date = simpleDateFormat2.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        if (date == null) {
            return str;
        }
        try {
            return simpleDateFormat.format(date);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static TimeDiff calculateDateTimeDiffWithoutAbs(Date date, Date date2) {
        if (date == null || date2 == null) {
            return null;
        }
        long time = date2.getTime() - date.getTime();
        if (time <= 0) {
            return new TimeDiff(0, 0, 0, 0);
        }
        long j = time % 86400000;
        return new TimeDiff(time / 86400000, j / 3600000, (j % 3600000) / 60000, (time % 60000) / 1000);
    }
}
