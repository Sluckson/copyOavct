package org.codehaus.jackson.map.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.text.Typography;

public class StdDateFormat extends DateFormat {
    static final String[] ALL_FORMATS = {DATE_FORMAT_STR_ISO8601, DATE_FORMAT_STR_ISO8601_Z, "EEE, dd MMM yyyy HH:mm:ss zzz", DATE_FORMAT_STR_PLAIN};
    static final SimpleDateFormat DATE_FORMAT_ISO8601 = new SimpleDateFormat(DATE_FORMAT_STR_ISO8601);
    static final SimpleDateFormat DATE_FORMAT_ISO8601_Z = new SimpleDateFormat(DATE_FORMAT_STR_ISO8601_Z);
    static final SimpleDateFormat DATE_FORMAT_PLAIN = new SimpleDateFormat(DATE_FORMAT_STR_PLAIN);
    static final SimpleDateFormat DATE_FORMAT_RFC1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
    static final String DATE_FORMAT_STR_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    static final String DATE_FORMAT_STR_ISO8601_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    static final String DATE_FORMAT_STR_PLAIN = "yyyy-MM-dd";
    static final String DATE_FORMAT_STR_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final StdDateFormat instance = new StdDateFormat();
    transient SimpleDateFormat _formatISO8601;
    transient SimpleDateFormat _formatISO8601_z;
    transient SimpleDateFormat _formatPlain;
    transient SimpleDateFormat _formatRFC1123;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        DATE_FORMAT_RFC1123.setTimeZone(timeZone);
        DATE_FORMAT_ISO8601.setTimeZone(timeZone);
        DATE_FORMAT_ISO8601_Z.setTimeZone(timeZone);
        DATE_FORMAT_PLAIN.setTimeZone(timeZone);
    }

    public StdDateFormat clone() {
        return new StdDateFormat();
    }

    public static DateFormat getBlueprintISO8601Format() {
        return DATE_FORMAT_ISO8601;
    }

    public static DateFormat getISO8601Format(TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DATE_FORMAT_ISO8601.clone();
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat;
    }

    public static DateFormat getBlueprintRFC1123Format() {
        return DATE_FORMAT_RFC1123;
    }

    public static DateFormat getRFC1123Format(TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DATE_FORMAT_RFC1123.clone();
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat;
    }

    public Date parse(String str) throws ParseException {
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(trim, parsePosition);
        if (parse != null) {
            return parse;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : ALL_FORMATS) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append(Typography.quote);
            }
            sb.append(str2);
        }
        sb.append(Typography.quote);
        throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{trim, sb.toString()}), parsePosition.getErrorIndex());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date parse(java.lang.String r4, java.text.ParsePosition r5) {
        /*
            r3 = this;
            boolean r0 = r3.looksLikeISO8601(r4)
            if (r0 == 0) goto L_0x000b
            java.util.Date r4 = r3.parseAsISO8601(r4, r5)
            return r4
        L_0x000b:
            int r0 = r4.length()
        L_0x000f:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x001f
            char r1 = r4.charAt(r0)
            r2 = 48
            if (r1 < r2) goto L_0x001f
            r2 = 57
            if (r1 <= r2) goto L_0x000f
        L_0x001f:
            if (r0 >= 0) goto L_0x0032
            r0 = 0
            boolean r0 = org.codehaus.jackson.p063io.NumberInput.inLongRange(r4, r0)
            if (r0 == 0) goto L_0x0032
            java.util.Date r5 = new java.util.Date
            long r0 = java.lang.Long.parseLong(r4)
            r5.<init>(r0)
            return r5
        L_0x0032:
            java.util.Date r4 = r3.parseAsRFC1123(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.util.StdDateFormat.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (this._formatISO8601 == null) {
            this._formatISO8601 = (SimpleDateFormat) DATE_FORMAT_ISO8601.clone();
        }
        return this._formatISO8601.format(date, stringBuffer, fieldPosition);
    }

    /* access modifiers changed from: protected */
    public boolean looksLikeISO8601(String str) {
        return str.length() >= 5 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-';
    }

    /* access modifiers changed from: protected */
    public Date parseAsISO8601(String str, ParsePosition parsePosition) {
        SimpleDateFormat simpleDateFormat;
        int length = str.length();
        int i = length - 1;
        char charAt = str.charAt(i);
        if (length <= 10 && Character.isDigit(charAt)) {
            simpleDateFormat = this._formatPlain;
            if (simpleDateFormat == null) {
                simpleDateFormat = (SimpleDateFormat) DATE_FORMAT_PLAIN.clone();
                this._formatPlain = simpleDateFormat;
            }
        } else if (charAt == 'Z') {
            SimpleDateFormat simpleDateFormat2 = this._formatISO8601_z;
            if (simpleDateFormat2 == null) {
                simpleDateFormat2 = (SimpleDateFormat) DATE_FORMAT_ISO8601_Z.clone();
                this._formatISO8601_z = simpleDateFormat2;
            }
            if (str.charAt(length - 4) == ':') {
                StringBuilder sb = new StringBuilder(str);
                sb.insert(i, ".000");
                str = sb.toString();
            }
            simpleDateFormat = simpleDateFormat2;
        } else if (hasTimeZone(str)) {
            int i2 = length - 3;
            char charAt2 = str.charAt(i2);
            if (charAt2 == ':') {
                StringBuilder sb2 = new StringBuilder(str);
                sb2.delete(i2, length - 2);
                str = sb2.toString();
            } else if (charAt2 == '+' || charAt2 == '-') {
                str = str + "00";
            }
            int length2 = str.length();
            if (Character.isDigit(str.charAt(length2 - 9))) {
                StringBuilder sb3 = new StringBuilder(str);
                sb3.insert(length2 - 5, ".000");
                str = sb3.toString();
            }
            simpleDateFormat = this._formatISO8601;
            if (simpleDateFormat == null) {
                simpleDateFormat = (SimpleDateFormat) DATE_FORMAT_ISO8601.clone();
                this._formatISO8601 = simpleDateFormat;
            }
        } else {
            StringBuilder sb4 = new StringBuilder(str);
            if ((length - str.lastIndexOf(84)) - 1 <= 8) {
                sb4.append(".000");
            }
            sb4.append('Z');
            str = sb4.toString();
            simpleDateFormat = this._formatISO8601_z;
            if (simpleDateFormat == null) {
                simpleDateFormat = (SimpleDateFormat) DATE_FORMAT_ISO8601_Z.clone();
                this._formatISO8601_z = simpleDateFormat;
            }
        }
        return simpleDateFormat.parse(str, parsePosition);
    }

    /* access modifiers changed from: protected */
    public Date parseAsRFC1123(String str, ParsePosition parsePosition) {
        if (this._formatRFC1123 == null) {
            this._formatRFC1123 = (SimpleDateFormat) DATE_FORMAT_RFC1123.clone();
        }
        return this._formatRFC1123.parse(str, parsePosition);
    }

    private static final boolean hasTimeZone(String str) {
        char charAt;
        char charAt2;
        int length = str.length();
        if (length < 6) {
            return false;
        }
        char charAt3 = str.charAt(length - 6);
        if (charAt3 == '+' || charAt3 == '-' || (charAt = str.charAt(length - 5)) == '+' || charAt == '-' || (charAt2 = str.charAt(length - 3)) == '+' || charAt2 == '-') {
            return true;
        }
        return false;
    }
}
