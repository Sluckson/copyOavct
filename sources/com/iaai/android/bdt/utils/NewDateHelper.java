package com.iaai.android.bdt.utils;

import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.utils.DateFormatThreadLocal;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.HtmlTags;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roboguice.util.C5058Ln;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001lB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eJ\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018J!\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J \u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010'2\u0006\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020'J\u0010\u0010.\u001a\u0004\u0018\u00010\u00182\u0006\u0010+\u001a\u00020'J\u0012\u0010/\u001a\u0004\u0018\u0001002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0018\u00101\u001a\u00020'2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u00102\u001a\u00020'J\u0016\u00101\u001a\u00020'2\u0006\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020'J\u0010\u00104\u001a\u00020'2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u00105\u001a\u00020'2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u00106\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u000eJ\u000e\u00109\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010:\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010;\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010<\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010=\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010>\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010?\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010@\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010A\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020'J\u0006\u0010B\u001a\u00020'J\u0010\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020'J\u0010\u0010D\u001a\u00020E2\u0006\u00102\u001a\u00020'H\u0002J\u0010\u0010F\u001a\u0004\u0018\u00010\u00182\u0006\u0010G\u001a\u00020'J\u001a\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u00182\b\u0010K\u001a\u0004\u0018\u00010\u0018J\u000e\u0010L\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u0010\u0010M\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020'J\u0010\u0010N\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010O\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020'J\u0006\u0010P\u001a\u00020'J\u000e\u0010Q\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010R\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010S\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020\u0004J\u0006\u0010V\u001a\u00020\u0004J\b\u0010W\u001a\u0004\u0018\u00010'J\u0010\u0010X\u001a\u00020I2\b\u0010Y\u001a\u0004\u0018\u00010\u0018J\u001a\u0010Z\u001a\u00020I2\b\u0010[\u001a\u0004\u0018\u0001002\b\u0010\\\u001a\u0004\u0018\u000100J\u001a\u0010Z\u001a\u00020I2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018J\u0016\u0010]\u001a\u00020I2\u0006\u0010^\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0004J\u0010\u0010`\u001a\u00020I2\b\u0010a\u001a\u0004\u0018\u000100J\u000e\u0010b\u001a\u00020'2\u0006\u0010c\u001a\u00020\u000eJ\u0018\u0010d\u001a\u0004\u0018\u00010\u00182\u0006\u0010+\u001a\u00020'2\u0006\u00102\u001a\u00020'J\u0010\u0010e\u001a\u0004\u0018\u00010\u00182\u0006\u0010+\u001a\u00020'J\u0018\u0010f\u001a\u0002002\u0006\u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020iH\u0002J\u0016\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u00182\u0006\u0010h\u001a\u00020iR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/NewDateHelper;", "", "()V", "DAY_MILLIS", "", "getDAY_MILLIS", "()J", "HOUR_MILLIS", "getHOUR_MILLIS", "MINUTE_MILLIS", "getMINUTE_MILLIS", "SECOND_MILLIS", "getSECOND_MILLIS", "SERVER_RECYCLE_HOUR", "", "getSERVER_RECYCLE_HOUR", "()I", "setSERVER_RECYCLE_HOUR", "(I)V", "SERVER_RECYCLE_MINUTE", "getSERVER_RECYCLE_MINUTE", "setSERVER_RECYCLE_MINUTE", "serverRecycleMillis", "addDay", "Ljava/util/Date;", "date", "amount", "calculateDateTimeDiff", "Lcom/iaai/android/bdt/utils/NewDateHelper$TimeDiff;", "date1", "date2", "calculateTimeDiff", "calculateTimeDiffInMillis", "(Ljava/util/Date;Ljava/util/Date;)Ljava/lang/Long;", "changeServerRecycleTime", "", "hour", "minutes", "convertByteToString", "", "content", "", "convertFormat", "dateString", "fromPattern", "toPattern", "convertStringToDate", "convertToDateOnlyCalendar", "Ljava/util/Calendar;", "format", "pattern", "dateMillis", "formatAuctionDate", "formatAuctionDateNew", "formatAuctionShortDate", "formattedVehicleCount", "vehicleCount", "getAuctionCompleteTime", "getAuctionDate", "getAuctionDay", "getAuctionTime", "getAuctionTimeLiveCalender", "getBNOfferExpireDate", "getBidHistoryDate", "getBuyNowExpireDate", "getBuyNowOfferExpireDate", "getCurrentYear", "getDate", "getDateFormatByPattern", "Ljava/text/DateFormat;", "getDateFromString", "dateFromServer", "getDateInRange", "", "startDate", "endDate", "getETOBDateFormat", "getFormattedDate", "getFormattedSearchDate", "getManageOfferExpireDate", "getMinYear", "getOfferExpireDate", "getPaidDate", "getPaymentDueDate", "getRemainingTimeString", "diffInMillis", "getServerRecycleMillis", "getSortCurrentDateAndTime", "isPast", "value", "isSameDay", "cal1", "cal2", "isSameDayInServerTimezone", "millis1", "millis2", "isTomorrow", "calendar", "ordinal", "num", "parse", "parseDateInServerTimezone", "toCalendarInTimeZone", "millis", "timeZone", "Ljava/util/TimeZone;", "toDateInTimeZone", "dateInOtherTimeZone", "TimeDiff", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: NewDateHelper.kt */
public final class NewDateHelper {
    private static final long DAY_MILLIS = (HOUR_MILLIS * ((long) 24));
    private static final long HOUR_MILLIS;
    public static final NewDateHelper INSTANCE = new NewDateHelper();
    private static final long MINUTE_MILLIS;
    private static final long SECOND_MILLIS = 1000;
    private static int SERVER_RECYCLE_HOUR = 2;
    private static int SERVER_RECYCLE_MINUTE = 5;
    private static long serverRecycleMillis = -1;

    static {
        long j = (long) 60;
        MINUTE_MILLIS = SECOND_MILLIS * j;
        HOUR_MILLIS = MINUTE_MILLIS * j;
    }

    private NewDateHelper() {
    }

    public final long getSECOND_MILLIS() {
        return SECOND_MILLIS;
    }

    public final long getMINUTE_MILLIS() {
        return MINUTE_MILLIS;
    }

    public final long getHOUR_MILLIS() {
        return HOUR_MILLIS;
    }

    public final long getDAY_MILLIS() {
        return DAY_MILLIS;
    }

    public final int getSERVER_RECYCLE_HOUR() {
        return SERVER_RECYCLE_HOUR;
    }

    public final void setSERVER_RECYCLE_HOUR(int i) {
        SERVER_RECYCLE_HOUR = i;
    }

    public final int getSERVER_RECYCLE_MINUTE() {
        return SERVER_RECYCLE_MINUTE;
    }

    public final void setSERVER_RECYCLE_MINUTE(int i) {
        SERVER_RECYCLE_MINUTE = i;
    }

    @Nullable
    public final TimeDiff calculateTimeDiff(@Nullable Date date, @Nullable Date date2) {
        if (date == null || date2 == null) {
            return null;
        }
        long abs = Math.abs(date.getTime() - date2.getTime());
        long j = HOUR_MILLIS;
        long j2 = abs / j;
        long j3 = MINUTE_MILLIS;
        return new TimeDiff(j2, (abs % j) / j3, (abs % j3) / SECOND_MILLIS);
    }

    @Nullable
    public final TimeDiff calculateDateTimeDiff(@Nullable Date date, @Nullable Date date2) {
        if (date == null || date2 == null) {
            return null;
        }
        long abs = Math.abs(date.getTime() - date2.getTime());
        long j = DAY_MILLIS;
        long j2 = abs / j;
        long j3 = abs % j;
        long j4 = HOUR_MILLIS;
        long j5 = j3 / j4;
        long j6 = j3 % j4;
        long j7 = MINUTE_MILLIS;
        return new TimeDiff(j2, j5, j6 / j7, (abs % j7) / SECOND_MILLIS);
    }

    @NotNull
    public final String getRemainingTimeString(long j) {
        long j2 = DAY_MILLIS;
        long j3 = j / j2;
        long j4 = j % j2;
        long j5 = HOUR_MILLIS;
        long j6 = j4 / j5;
        long j7 = j4 % j5;
        long j8 = MINUTE_MILLIS;
        return new TimeDiff(j3, j6, j7 / j8, (j % j8) / SECOND_MILLIS).getManageOfferTimeString();
    }

    @Nullable
    public final Long calculateTimeDiffInMillis(@Nullable Date date, @Nullable Date date2) {
        if (date == null || date2 == null) {
            return null;
        }
        return Long.valueOf(Math.abs(date.getTime() - date2.getTime()));
    }

    public final boolean isSameDay(@Nullable Date date, @Nullable Date date2) {
        if (date == date2) {
            return true;
        }
        if (date == null || date2 == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "cal1");
        instance.setTimeInMillis(date.getTime());
        Calendar instance2 = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "cal2");
        instance2.setTimeInMillis(date2.getTime());
        return isSameDay(instance, instance2);
    }

    public final boolean isSameDay(@Nullable Calendar calendar, @Nullable Calendar calendar2) {
        if (calendar == calendar2) {
            return true;
        }
        if (calendar != null && calendar2 != null && calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return true;
        }
        return false;
    }

    public final boolean isSameDayInServerTimezone(long j, long j2) {
        TimeZone timeZone = Constants.TIMEZONE_SERVER;
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "Constants.TIMEZONE_SERVER");
        Calendar calendarInTimeZone = toCalendarInTimeZone(j, timeZone);
        TimeZone timeZone2 = Constants.TIMEZONE_SERVER;
        Intrinsics.checkExpressionValueIsNotNull(timeZone2, "Constants.TIMEZONE_SERVER");
        return isSameDay(calendarInTimeZone, toCalendarInTimeZone(j2, timeZone2));
    }

    private final Calendar toCalendarInTimeZone(long j, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "fromCal");
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.set(1, instance.get(1));
        instance2.set(2, instance.get(2));
        instance2.set(5, instance.get(5));
        instance2.set(11, instance.get(11));
        instance2.set(12, instance.get(12));
        instance2.set(13, instance.get(13));
        instance2.set(14, instance.get(14));
        Intrinsics.checkExpressionValueIsNotNull(instance2, "toCal");
        return instance2;
    }

    @Nullable
    public final Date getDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        Date date = null;
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.US).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    @NotNull
    public final String format(@Nullable Date date, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "pattern");
        if (date == null) {
            return "";
        }
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        Resources resources = instance.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "IaaiApplication.getInstance().resources");
        Locale locale = resources.getConfiguration().locale;
        Intrinsics.checkExpressionValueIsNotNull(locale, "locale");
        if (StringsKt.equals(locale.getLanguage(), "ar", true)) {
            String format = new SimpleDateFormat(str, Locale.ENGLISH).format(date);
            Intrinsics.checkExpressionValueIsNotNull(format, "SimpleDateFormat(pattern…ale.ENGLISH).format(date)");
            return format;
        }
        String format2 = getDateFormatByPattern(str).format(date);
        Intrinsics.checkExpressionValueIsNotNull(format2, "getDateFormatByPattern(pattern).format(date)");
        return format2;
    }

    @NotNull
    public final String format(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "pattern");
        String format = getDateFormatByPattern(str).format(Long.valueOf(j));
        Intrinsics.checkExpressionValueIsNotNull(format, "getDateFormatByPattern(pattern).format(dateMillis)");
        return format;
    }

    @NotNull
    public final String formatAuctionDate(@Nullable Date date) {
        return format(date, (date == null || date.getMinutes() != 0) ? Constants.DATE_NEW_PATTERN_AUCTION_DATE_SHORT : Constants.DATE_NEW_PATTERN_AUCTION_DATE_SHORT_HOUR_ONLY);
    }

    @NotNull
    public final String formatAuctionShortDate(@NotNull Date date) {
        Intrinsics.checkParameterIsNotNull(date, Constants.EXTRA_DATE);
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {instance, instance, instance, instance};
        String format = String.format("%tA, %tB %te, %tY", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @Nullable
    public final Date parse(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "pattern");
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

    @Nullable
    public final Date parseDateInServerTimezone(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Date parse = parse(str, Constants.DATE_PATTERN_DATE_TIME);
        if (parse == null) {
            return null;
        }
        TimeZone timeZone = Constants.TIMEZONE_SERVER;
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "Constants.TIMEZONE_SERVER");
        return toDateInTimeZone(parse, timeZone);
    }

    @NotNull
    public final String convertFormat(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str2, "fromPattern");
        Intrinsics.checkParameterIsNotNull(str3, "toPattern");
        if (str != null && !TextUtils.isEmpty(str)) {
            DateFormat dateFormatByPattern = getDateFormatByPattern(str2);
            DateFormat dateFormatByPattern2 = getDateFormatByPattern(str3);
            dateFormatByPattern.setTimeZone(Constants.TIMEZONE_SERVER);
            dateFormatByPattern2.setTimeZone(Constants.TIMEZONE_SERVER);
            try {
                String format = dateFormatByPattern2.format(dateFormatByPattern.parse(str));
                Intrinsics.checkExpressionValueIsNotNull(format, "toDateFormat.format(\n   …Format.parse(dateString))");
                return format;
            } catch (ParseException e) {
                C5058Ln.m4843w(e, "Fail to convert date[%s] string from format[%s] to format[%s]", str, str2, str3);
            }
        }
        return "";
    }

    @Nullable
    public final Calendar convertToDateOnlyCalendar(@Nullable Date date) {
        if (date == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(date.getYear() + 1900, date.getMonth(), date.getDate());
        return instance;
    }

    @NotNull
    public final Date addDay(@NotNull Date date, int i) {
        Intrinsics.checkParameterIsNotNull(date, Constants.EXTRA_DATE);
        return new Date(date.getTime() + (((long) i) * DAY_MILLIS));
    }

    private final DateFormat getDateFormatByPattern(String str) {
        DateFormatThreadLocal dateFormatThreadLocal;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (concurrentHashMap.containsKey(str)) {
            dateFormatThreadLocal = (DateFormatThreadLocal) concurrentHashMap.get(str);
        } else {
            DateFormatThreadLocal dateFormatThreadLocal2 = new DateFormatThreadLocal(str);
            concurrentHashMap.putIfAbsent(str, dateFormatThreadLocal2);
            dateFormatThreadLocal = dateFormatThreadLocal2;
        }
        if (dateFormatThreadLocal == null) {
            Intrinsics.throwNpe();
        }
        Object obj = dateFormatThreadLocal.get();
        Intrinsics.checkExpressionValueIsNotNull(obj, "dateFormatThreadLocal!!.get()");
        return (DateFormat) obj;
    }

    public final boolean isPast(@Nullable Date date) {
        return date == null || System.currentTimeMillis() > date.getTime();
    }

    public final boolean isTomorrow(@Nullable Calendar calendar) {
        if (calendar == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "today");
        instance.setTimeInMillis(System.currentTimeMillis());
        Object clone = calendar.clone();
        if (clone != null) {
            Calendar calendar2 = (Calendar) clone;
            calendar2.add(5, -1);
            if (calendar2.get(1) == instance.get(1) && calendar2.get(2) == instance.get(2) && calendar2.get(5) == instance.get(5)) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
    }

    @NotNull
    public final Date toDateInTimeZone(@NotNull Date date, @NotNull TimeZone timeZone) {
        Intrinsics.checkParameterIsNotNull(date, "dateInOtherTimeZone");
        Intrinsics.checkParameterIsNotNull(timeZone, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Date time = toCalendarInTimeZone(date.getTime(), timeZone).getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "toCalendarInTimeZone(dat…Zone.time, timeZone).time");
        return time;
    }

    public final void changeServerRecycleTime(int i, int i2) {
        serverRecycleMillis = -1;
        SERVER_RECYCLE_HOUR = i;
        SERVER_RECYCLE_MINUTE = i2;
    }

    public final long getServerRecycleMillis() {
        if (serverRecycleMillis <= 0 || System.currentTimeMillis() - serverRecycleMillis >= DAY_MILLIS) {
            Calendar instance = Calendar.getInstance(Constants.TIMEZONE_SERVER);
            Intrinsics.checkExpressionValueIsNotNull(instance, "serverCalendar");
            instance.setTimeInMillis(System.currentTimeMillis());
            instance.set(11, SERVER_RECYCLE_HOUR);
            instance.set(12, SERVER_RECYCLE_MINUTE);
            instance.set(13, 0);
            instance.set(14, 0);
            serverRecycleMillis = instance.getTimeInMillis();
        }
        return serverRecycleMillis;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\nB'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\rH\u0016R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/NewDateHelper$TimeDiff;", "", "hours", "", "minutes", "seconds", "(III)V", "", "(JJJ)V", "days", "(IIII)V", "(JJJJ)V", "auctionMainPageTimeString", "", "getAuctionMainPageTimeString", "()Ljava/lang/String;", "auctionNotToday", "", "getAuctionNotToday", "()Z", "getDays", "()I", "getHours", "manageOfferTimeString", "getManageOfferTimeString", "getMinutes", "preBidTimeString", "getPreBidTimeString", "getSeconds", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: NewDateHelper.kt */
    public static final class TimeDiff {
        private final int days;
        private final int hours;
        private final int minutes;
        private final int seconds;

        public final int getDays() {
            return this.days;
        }

        public final int getHours() {
            return this.hours;
        }

        public final int getMinutes() {
            return this.minutes;
        }

        public final int getSeconds() {
            return this.seconds;
        }

        @NotNull
        public final String getPreBidTimeString() {
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
                String sb2 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
                return sb2;
            }
            sb.append(this.minutes);
            sb.append("m ");
            if (i + 1 == 2) {
                String sb3 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb3, "sb.toString()");
                return sb3;
            }
            if (this.days <= 0 && this.hours <= 0) {
                sb.append(this.seconds);
                sb.append(HtmlTags.f607S);
            }
            String sb4 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb4, "sb.toString()");
            return sb4;
        }

        @NotNull
        public final String getManageOfferTimeString() {
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
                String sb2 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
                return sb2;
            }
            sb.append(this.minutes);
            sb.append("m ");
            if (i + 1 == 2) {
                String sb3 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb3, "sb.toString()");
                return sb3;
            }
            String sb4 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb4, "sb.toString()");
            return sb4;
        }

        @NotNull
        public final String getAuctionMainPageTimeString() {
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
                String sb2 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
                return sb2;
            }
            sb.append(this.minutes);
            sb.append("m ");
            if (i + 1 == 2) {
                String sb3 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb3, "sb.toString()");
                return sb3;
            }
            String sb4 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb4, "sb.toString()");
            return sb4;
        }

        public final boolean getAuctionNotToday() {
            return this.days > 0;
        }

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

        @NotNull
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
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            return sb2;
        }
    }

    @NotNull
    public final String convertByteToString(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "content");
        return bArr.toString();
    }

    @Nullable
    public final Date getDateFromString(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "dateFromServer");
        Date date = null;
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.ENGLISH).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    @NotNull
    public final String formattedVehicleCount(int i) {
        String format = new DecimalFormat("#,###").format(Double.parseDouble(String.valueOf(i)));
        Intrinsics.checkExpressionValueIsNotNull(format, "formatter.format(amount)");
        return format;
    }

    @NotNull
    public final String getCurrentYear() {
        return String.valueOf(Calendar.getInstance().get(1));
    }

    @NotNull
    public final String getMinYear() {
        Calendar instance = Calendar.getInstance();
        instance.add(1, -10);
        return String.valueOf(instance.get(1));
    }

    @Nullable
    public final String getSortCurrentDateAndTime() {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT >= 26) {
            str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM. dd"));
            Intrinsics.checkExpressionValueIsNotNull(str, "current.format(formatter)");
        } else {
            str = new SimpleDateFormat(Constants.DATE_PATTERN_TOBE_PAID).format(new Date());
            Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(date)");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
            Intrinsics.checkExpressionValueIsNotNull(format, "current.format(formatter)");
            str2 = format;
        } else {
            str2 = new SimpleDateFormat("hh:mm a").format(new Date());
            Intrinsics.checkExpressionValueIsNotNull(str2, "formatter.format(date)");
        }
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        String displayName = timeZone.getDisplayName();
        return "Last Updated: " + str + " @ " + str2 + ' ' + displayName;
    }

    @NotNull
    public final String formatAuctionDateNew(@Nullable Date date) {
        String format = new SimpleDateFormat("h:mm a", Locale.US).format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "sdf.format(date)");
        return format;
    }

    @NotNull
    public final String getAuctionDay(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        String format = new SimpleDateFormat("EEE", Locale.US).format(new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US).parse(str));
        Intrinsics.checkExpressionValueIsNotNull(format, "sdf.format(result)");
        return format;
    }

    @NotNull
    public final String getAuctionTime(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, h:mma (z)", Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
        Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
        return format;
    }

    @NotNull
    public final String getAuctionTimeLiveCalender(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_ETBO, Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
        Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
        return format;
    }

    @NotNull
    public final String getOfferExpireDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mma z", Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        try {
            String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
            Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @NotNull
    public final String getBNOfferExpireDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mma z", Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        try {
            String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
            Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @NotNull
    public final String getBuyNowExpireDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMMM d, h:mma z", Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        try {
            String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
            Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @NotNull
    public final Date getManageOfferExpireDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE, Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "inputsdf.parse(date)");
        return parse;
    }

    @NotNull
    public final Date getBuyNowOfferExpireDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "inputsdf.parse(date)");
        return parse;
    }

    @NotNull
    public final String getETOBDateFormat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_ETBO, Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
        Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
        return format;
    }

    @NotNull
    public final String getAuctionDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        String format = new SimpleDateFormat("dd", Locale.US).format(new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US).parse(str));
        Intrinsics.checkExpressionValueIsNotNull(format, "outsdf.format(result)");
        return format;
    }

    @NotNull
    public final String getAuctionCompleteTime(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMMM d, h:mma z", Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
        Intrinsics.checkExpressionValueIsNotNull(format, "outputSdf.format(result)");
        return format;
    }

    @Nullable
    public final Date getFormattedSearchDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        Date parse = parse(str, Constants.DATE_PATTERN_CONFIRMATION_PAGE);
        if (parse == null) {
            return null;
        }
        TimeZone timeZone = Constants.TIMEZONE_SERVER;
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "Constants.TIMEZONE_SERVER");
        return toDateInTimeZone(parse, timeZone);
    }

    @Nullable
    public final Date getFormattedDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        return simpleDateFormat.parse(str);
    }

    public final boolean getDateInRange(@Nullable Date date, @Nullable Date date2) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.getDefault());
        Intrinsics.checkExpressionValueIsNotNull(instance, "c");
        Date parse = simpleDateFormat.parse(simpleDateFormat.format(instance.getTime()));
        return parse.before(date2) && parse.after(date);
    }

    @NotNull
    public final String getBidHistoryDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        try {
            String format = new SimpleDateFormat("hh:mma", Locale.US).format(new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE, Locale.US).parse(str));
            Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @NotNull
    public final String getPaymentDueDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_TOBE_PAID, Locale.US);
        simpleDateFormat.setTimeZone(Constants.TIMEZONE_SERVER);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE, Locale.US);
        simpleDateFormat2.setTimeZone(Constants.TIMEZONE_SERVER);
        try {
            String format = simpleDateFormat.format(simpleDateFormat2.parse(str));
            Intrinsics.checkExpressionValueIsNotNull(format, "outputsdf.format(result)");
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @NotNull
    public final String ordinal(int i) {
        String[] strArr = {HtmlTags.HEADERCELL, "st", "nd", "rd", HtmlTags.HEADERCELL, HtmlTags.HEADERCELL, HtmlTags.HEADERCELL, HtmlTags.HEADERCELL, HtmlTags.HEADERCELL, HtmlTags.HEADERCELL};
        int i2 = i % 100;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(i));
        sb.append(strArr[(4 <= i2 && 20 >= i2) ? 0 : i2 % 10]);
        return sb.toString();
    }

    @NotNull
    public final String getPaidDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_DATE);
        if (str.equals("")) {
            return "";
        }
        String format = new SimpleDateFormat("E MMM dd", Locale.US).format(new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.US).parse(str));
        Intrinsics.checkExpressionValueIsNotNull(format, "outsdf.format(result)");
        return format;
    }

    @Nullable
    public final Date convertStringToDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Date date = null;
        if (TextUtils.isEmpty(str)) {
            return date;
        }
        try {
            IaaiApplication instance = IaaiApplication.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
            Resources resources = instance.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "IaaiApplication.getInstance().resources");
            Locale locale = resources.getConfiguration().locale;
            Intrinsics.checkExpressionValueIsNotNull(locale, "locale");
            String language = locale.getLanguage();
            Intrinsics.checkExpressionValueIsNotNull(language, "locale.language");
            if (!StringsKt.startsWith$default(language, "ar", false, 2, (Object) null)) {
                String language2 = locale.getLanguage();
                Intrinsics.checkExpressionValueIsNotNull(language2, "locale.language");
                if (!StringsKt.startsWith$default(language2, "ko", false, 2, (Object) null)) {
                    String language3 = locale.getLanguage();
                    Intrinsics.checkExpressionValueIsNotNull(language3, "locale.language");
                    if (!StringsKt.startsWith$default(language3, Constants_MVVM.EXTRA_SPANISH_CODE, false, 2, (Object) null)) {
                        String language4 = locale.getLanguage();
                        Intrinsics.checkExpressionValueIsNotNull(language4, "locale.language");
                        if (!StringsKt.startsWith$default(language4, "ch", false, 2, (Object) null)) {
                            return ((DateFormat) new DateFormatThreadLocal(Constants.DATE_PATTERN_DATE_TIME).get()).parse(str);
                        }
                    }
                }
            }
            return new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.ENGLISH).parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return date;
        }
    }
}
