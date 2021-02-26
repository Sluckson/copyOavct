package p052cz.msebera.android.httpclient.protocol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p052cz.msebera.android.httpclient.annotation.GuardedBy;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.protocol.HttpDateGenerator */
public class HttpDateGenerator {
    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    @GuardedBy("this")
    private long dateAsLong = 0;
    @GuardedBy("this")
    private String dateAsText = null;
    @GuardedBy("this")
    private final DateFormat dateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);

    public HttpDateGenerator() {
        this.dateformat.setTimeZone(GMT);
    }

    public synchronized String getCurrentDate() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dateAsLong > 1000) {
            this.dateAsText = this.dateformat.format(new Date(currentTimeMillis));
            this.dateAsLong = currentTimeMillis;
        }
        return this.dateAsText;
    }
}
