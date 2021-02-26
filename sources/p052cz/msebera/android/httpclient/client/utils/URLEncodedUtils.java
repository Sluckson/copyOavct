package p052cz.msebera.android.httpclient.client.utils;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import p052cz.msebera.android.httpclient.Consts;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import p052cz.msebera.android.httpclient.message.BasicNameValuePair;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;
import p052cz.msebera.android.httpclient.util.EntityUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.utils.URLEncodedUtils */
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final BitSet PATHSAFE = new BitSet(256);
    private static final BitSet PUNCT = new BitSet(256);
    private static final char[] QP_SEPS = {'&', QP_SEP_S};
    private static final char QP_SEP_A = '&';
    private static final String QP_SEP_PATTERN = ("[" + new String(QP_SEPS) + "]");
    private static final char QP_SEP_S = ';';
    private static final int RADIX = 16;
    private static final BitSet RESERVED = new BitSet(256);
    private static final BitSet UNRESERVED = new BitSet(256);
    private static final BitSet URIC = new BitSet(256);
    private static final BitSet URLENCODER = new BitSet(256);
    private static final BitSet USERINFO = new BitSet(256);

    public static List<NameValuePair> parse(URI uri, String str) {
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null || rawQuery.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        parse(arrayList, new Scanner(rawQuery), QP_SEP_PATTERN, str);
        return arrayList;
    }

    public static List<NameValuePair> parse(HttpEntity httpEntity) throws IOException {
        String entityUtils;
        ContentType contentType = ContentType.get(httpEntity);
        if (contentType == null || !contentType.getMimeType().equalsIgnoreCase(CONTENT_TYPE) || (entityUtils = EntityUtils.toString(httpEntity, Consts.ASCII)) == null || entityUtils.length() <= 0) {
            return Collections.emptyList();
        }
        Charset charset = contentType.getCharset();
        if (charset == null) {
            charset = HTTP.DEF_CONTENT_CHARSET;
        }
        return parse(entityUtils, charset, QP_SEPS);
    }

    public static boolean isEncoded(HttpEntity httpEntity) {
        Header contentType = httpEntity.getContentType();
        if (contentType != null) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return elements[0].getName().equalsIgnoreCase(CONTENT_TYPE);
            }
        }
        return false;
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String str) {
        parse(list, scanner, QP_SEP_PATTERN, str);
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String str, String str2) {
        String str3;
        String str4;
        scanner.useDelimiter(str);
        while (scanner.hasNext()) {
            String next = scanner.next();
            int indexOf = next.indexOf(NAME_VALUE_SEPARATOR);
            if (indexOf != -1) {
                str3 = decodeFormFields(next.substring(0, indexOf).trim(), str2);
                str4 = decodeFormFields(next.substring(indexOf + 1).trim(), str2);
            } else {
                String decodeFormFields = decodeFormFields(next.trim(), str2);
                str4 = null;
                str3 = decodeFormFields;
            }
            list.add(new BasicNameValuePair(str3, str4));
        }
    }

    static {
        for (int i = 97; i <= 122; i++) {
            UNRESERVED.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            UNRESERVED.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            UNRESERVED.set(i3);
        }
        UNRESERVED.set(95);
        UNRESERVED.set(45);
        UNRESERVED.set(46);
        UNRESERVED.set(42);
        URLENCODER.or(UNRESERVED);
        UNRESERVED.set(33);
        UNRESERVED.set(126);
        UNRESERVED.set(39);
        UNRESERVED.set(40);
        UNRESERVED.set(41);
        PUNCT.set(44);
        PUNCT.set(59);
        PUNCT.set(58);
        PUNCT.set(36);
        PUNCT.set(38);
        PUNCT.set(43);
        PUNCT.set(61);
        USERINFO.or(UNRESERVED);
        USERINFO.or(PUNCT);
        PATHSAFE.or(UNRESERVED);
        PATHSAFE.set(47);
        PATHSAFE.set(59);
        PATHSAFE.set(58);
        PATHSAFE.set(64);
        PATHSAFE.set(38);
        PATHSAFE.set(61);
        PATHSAFE.set(43);
        PATHSAFE.set(36);
        PATHSAFE.set(44);
        RESERVED.set(59);
        RESERVED.set(47);
        RESERVED.set(63);
        RESERVED.set(58);
        RESERVED.set(64);
        RESERVED.set(38);
        RESERVED.set(61);
        RESERVED.set(43);
        RESERVED.set(36);
        RESERVED.set(44);
        RESERVED.set(91);
        RESERVED.set(93);
        URIC.or(RESERVED);
        URIC.or(UNRESERVED);
    }

    public static List<NameValuePair> parse(String str, Charset charset) {
        return parse(str, charset, QP_SEPS);
    }

    public static List<NameValuePair> parse(String str, Charset charset, char... cArr) {
        if (str == null) {
            return Collections.emptyList();
        }
        BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.INSTANCE;
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            NameValuePair parseNameValuePair = basicHeaderValueParser.parseNameValuePair(charArrayBuffer, parserCursor, cArr);
            if (parseNameValuePair.getName().length() > 0) {
                arrayList.add(new BasicNameValuePair(decodeFormFields(parseNameValuePair.getName(), charset), decodeFormFields(parseNameValuePair.getValue(), charset)));
            }
        }
        return arrayList;
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        return format(list, '&', str);
    }

    public static String format(List<? extends NameValuePair> list, char c, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String encodeFormFields = encodeFormFields(nameValuePair.getName(), str);
            String encodeFormFields2 = encodeFormFields(nameValuePair.getValue(), str);
            if (sb.length() > 0) {
                sb.append(c);
            }
            sb.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                sb.append(NAME_VALUE_SEPARATOR);
                sb.append(encodeFormFields2);
            }
        }
        return sb.toString();
    }

    public static String format(Iterable<? extends NameValuePair> iterable, Charset charset) {
        return format(iterable, '&', charset);
    }

    public static String format(Iterable<? extends NameValuePair> iterable, char c, Charset charset) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : iterable) {
            String encodeFormFields = encodeFormFields(nameValuePair.getName(), charset);
            String encodeFormFields2 = encodeFormFields(nameValuePair.getValue(), charset);
            if (sb.length() > 0) {
                sb.append(c);
            }
            sb.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                sb.append(NAME_VALUE_SEPARATOR);
                sb.append(encodeFormFields2);
            }
        }
        return sb.toString();
    }

    private static String urlEncode(String str, Charset charset, BitSet bitSet, boolean z) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b = encode.get() & 255;
            if (bitSet.get(b)) {
                sb.append((char) b);
            } else if (!z || b != 32) {
                sb.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((b >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b & 15, 16));
                sb.append(upperCase);
                sb.append(upperCase2);
            } else {
                sb.append('+');
            }
        }
        return sb.toString();
    }

    private static String urlDecode(String str, Charset charset, boolean z) {
        if (str == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.length());
        CharBuffer wrap = CharBuffer.wrap(str);
        while (wrap.hasRemaining()) {
            char c = wrap.get();
            if (c == '%' && wrap.remaining() >= 2) {
                char c2 = wrap.get();
                char c3 = wrap.get();
                int digit = Character.digit(c2, 16);
                int digit2 = Character.digit(c3, 16);
                if (digit == -1 || digit2 == -1) {
                    allocate.put((byte) 37);
                    allocate.put((byte) c2);
                    allocate.put((byte) c3);
                } else {
                    allocate.put((byte) ((digit << 4) + digit2));
                }
            } else if (!z || c != '+') {
                allocate.put((byte) c);
            } else {
                allocate.put((byte) 32);
            }
        }
        allocate.flip();
        return charset.decode(allocate).toString();
    }

    private static String decodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlDecode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, true);
    }

    private static String decodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlDecode(str, charset, true);
    }

    private static String encodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlEncode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, URLENCODER, true);
    }

    private static String encodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlEncode(str, charset, URLENCODER, true);
    }

    static String encUserInfo(String str, Charset charset) {
        return urlEncode(str, charset, USERINFO, false);
    }

    static String encUric(String str, Charset charset) {
        return urlEncode(str, charset, URIC, false);
    }

    static String encPath(String str, Charset charset) {
        return urlEncode(str, charset, PATHSAFE, false);
    }
}
