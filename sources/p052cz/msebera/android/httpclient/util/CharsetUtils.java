package p052cz.msebera.android.httpclient.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* renamed from: cz.msebera.android.httpclient.util.CharsetUtils */
public class CharsetUtils {
    public static Charset lookup(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException unused) {
            return null;
        }
    }

    public static Charset get(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException unused) {
            throw new UnsupportedEncodingException(str);
        }
    }
}
