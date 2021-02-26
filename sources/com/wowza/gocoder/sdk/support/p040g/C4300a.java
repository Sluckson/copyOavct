package com.wowza.gocoder.sdk.support.p040g;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.wowza.gocoder.sdk.support.g.a */
/* compiled from: GoCoderSDK */
public class C4300a {
    /* renamed from: a */
    public static String m4213a(int i, long j) {
        if (j > 0) {
            return m4212a((int) Math.floor((double) (((float) (i * 8)) / (((float) j) / 1000.0f))));
        }
        return m4212a(0);
    }

    /* renamed from: a */
    public static String m4212a(int i) {
        if (i > 1000000) {
            return String.format(Locale.US, "%.1f mbps", new Object[]{Float.valueOf(((float) i) / 1000000.0f)});
        } else if (i > 1000) {
            return String.format(Locale.US, "%d kbps", new Object[]{Integer.valueOf(Math.round(((float) i) / 1000.0f))});
        } else {
            return String.format(Locale.US, "%d bps ", new Object[]{Integer.valueOf(i)});
        }
    }

    /* renamed from: a */
    public static String m4214a(long j) {
        long hours = TimeUnit.MILLISECONDS.toHours(j);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1);
        long j2 = j % 1000;
        if (hours > 0) {
            return String.format(Locale.US, "%02dh %02dm %02ds %03dms", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(j2)});
        } else if (minutes > 0) {
            return String.format(Locale.US, "%02dm %02ds %03dms", new Object[]{Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(j2)});
        } else if (seconds > 0) {
            return String.format(Locale.US, "%02ds %03dms", new Object[]{Long.valueOf(seconds), Long.valueOf(j2)});
        } else {
            return String.format(Locale.US, "%03dms", new Object[]{Long.valueOf(j2)});
        }
    }

    /* renamed from: b */
    public static String m4217b(long j) {
        return new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss:SSS", Locale.US).format(new Date(j));
    }

    /* renamed from: a */
    public static String m4216a(String str, float[] fArr) {
        if (fArr.length != 16) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append("\n");
        }
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < 4) {
                sb.append(String.format(Locale.US, "%5.2f", new Object[]{Float.valueOf(fArr[i3])}));
                if (i4 < 3) {
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                i4++;
                i3++;
            }
            sb.append("\n");
            i++;
            i2 = i3;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m4215a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return null;
        }
        char[] cArr = new char[str.length()];
        Arrays.fill(cArr, '*');
        return String.valueOf(cArr);
    }
}
