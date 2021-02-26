package roboguice.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

public class Strings {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    public static <T> String joinAnd(String str, String str2, Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        Iterator<T> it = collection.iterator();
        StringBuffer stringBuffer = new StringBuffer(toString((Object) it.next()));
        int i = 1;
        while (it.hasNext()) {
            T next = it.next();
            if (notEmpty(next)) {
                i++;
                stringBuffer.append(i == collection.size() ? str2 : str);
                stringBuffer.append(toString((Object) next));
            }
        }
        return stringBuffer.toString();
    }

    public static <T> String joinAnd(String str, String str2, T... tArr) {
        return joinAnd(str, str2, Arrays.asList(tArr));
    }

    public static <T> String join(String str, Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        Iterator<T> it = collection.iterator();
        StringBuffer stringBuffer = new StringBuffer(toString((Object) it.next()));
        while (it.hasNext()) {
            T next = it.next();
            if (notEmpty(next)) {
                stringBuffer.append(str);
                stringBuffer.append(toString((Object) next));
            }
        }
        return stringBuffer.toString();
    }

    public static <T> String join(String str, T... tArr) {
        return join(str, Arrays.asList(tArr));
    }

    public static String toString(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        copy(new InputStreamReader(inputStream), stringWriter);
        return stringWriter.toString();
    }

    public static String toString(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        copy(reader, stringWriter);
        return stringWriter.toString();
    }

    public static int copy(Reader reader, Writer writer) {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(Reader reader, Writer writer) throws RuntimeException {
        try {
            char[] cArr = new char[4096];
            long j = 0;
            while (true) {
                int read = reader.read(cArr);
                if (-1 == read) {
                    return j;
                }
                writer.write(cArr, 0, read);
                j += (long) read;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Object obj) {
        return toString(obj, "");
    }

    public static String toString(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof InputStream) {
            return toString((InputStream) obj);
        }
        if (obj instanceof Reader) {
            return toString((Reader) obj);
        }
        if (obj instanceof Object[]) {
            return join(", ", (T[]) (Object[]) obj);
        }
        return obj instanceof Collection ? join(", ", (Collection) obj) : obj.toString();
    }

    public static boolean isEmpty(Object obj) {
        return toString(obj).trim().length() == 0;
    }

    public static boolean notEmpty(Object obj) {
        return toString(obj).trim().length() != 0;
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & 255));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String capitalize(String str) {
        String strings = toString((Object) str);
        if (strings.length() < 2) {
            return strings.length() >= 1 ? strings.toUpperCase() : strings;
        }
        return strings.substring(0, 1).toUpperCase() + strings.substring(1);
    }

    public static boolean equals(Object obj, Object obj2) {
        return toString(obj).equals(toString(obj2));
    }

    public static boolean equalsIgnoreCase(Object obj, Object obj2) {
        return toString(obj).toLowerCase().equals(toString(obj2).toLowerCase());
    }

    public static String[] chunk(String str, int i) {
        if (isEmpty(str) || i == 0) {
            return new String[0];
        }
        int length = str.length();
        int i2 = ((length - 1) / i) + 1;
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            int i5 = i4 + i;
            if (i5 >= length) {
                i5 = length;
            }
            strArr[i3] = str.substring(i4, i5);
        }
        return strArr;
    }

    public static String namedFormat(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            str = str.replace(Typography.dollar + next, map.get(next));
        }
        return str;
    }

    public static String namedFormat(String str, Object... objArr) {
        if (objArr.length % 2 == 0) {
            HashMap hashMap = new HashMap(objArr.length / 2);
            for (int i = 0; i < objArr.length; i += 2) {
                hashMap.put(toString(objArr[i]), toString(objArr[i + 1]));
            }
            return namedFormat(str, (Map<String, String>) hashMap);
        }
        throw new InvalidParameterException("You must include one value for each parameter");
    }
}
