package p052cz.msebera.android.httpclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.ParseException;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.protocol.HTTP;

/* renamed from: cz.msebera.android.httpclient.util.EntityUtils */
public final class EntityUtils {
    private EntityUtils() {
    }

    public static void consumeQuietly(HttpEntity httpEntity) {
        try {
            consume(httpEntity);
        } catch (IOException unused) {
        }
    }

    public static void consume(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity != null && httpEntity.isStreaming() && (content = httpEntity.getContent()) != null) {
            content.close();
        }
    }

    public static void updateEntity(HttpResponse httpResponse, HttpEntity httpEntity) throws IOException {
        Args.notNull(httpResponse, "Response");
        consume(httpResponse.getEntity());
        httpResponse.setEntity(httpEntity);
    }

    public static byte[] toByteArray(HttpEntity httpEntity) throws IOException {
        Args.notNull(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return null;
        }
        try {
            Args.check(httpEntity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength < 0) {
                contentLength = 4096;
            }
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(contentLength);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return byteArrayBuffer.toByteArray();
                }
                byteArrayBuffer.append(bArr, 0, read);
            }
        } finally {
            content.close();
        }
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity httpEntity) throws ParseException {
        NameValuePair parameterByName;
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() != null) {
            HeaderElement[] elements = httpEntity.getContentType().getElements();
            if (elements.length > 0 && (parameterByName = elements[0].getParameterByName("charset")) != null) {
                return parameterByName.getValue();
            }
        }
        return null;
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity httpEntity) throws ParseException {
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() != null) {
            HeaderElement[] elements = httpEntity.getContentType().getElements();
            if (elements.length > 0) {
                return elements[0].getName();
            }
        }
        return null;
    }

    public static String toString(HttpEntity httpEntity, Charset charset) throws IOException, ParseException {
        Args.notNull(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return null;
        }
        try {
            Args.check(httpEntity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength < 0) {
                contentLength = 4096;
            }
            ContentType contentType = ContentType.get(httpEntity);
            Charset charset2 = contentType != null ? contentType.getCharset() : null;
            if (charset2 == null) {
                charset2 = charset;
            }
            if (charset2 == null) {
                charset2 = HTTP.DEF_CONTENT_CHARSET;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(content, charset2);
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength);
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    charArrayBuffer.append(cArr, 0, read);
                } else {
                    String charArrayBuffer2 = charArrayBuffer.toString();
                    content.close();
                    return charArrayBuffer2;
                }
            }
        } catch (UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(e.getMessage());
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    public static String toString(HttpEntity httpEntity, String str) throws IOException, ParseException {
        return toString(httpEntity, str != null ? Charset.forName(str) : null);
    }

    public static String toString(HttpEntity httpEntity) throws IOException, ParseException {
        return toString(httpEntity, (Charset) null);
    }
}
