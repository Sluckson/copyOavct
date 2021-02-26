package p052cz.msebera.android.httpclient.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import p052cz.msebera.android.httpclient.Consts;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.ParseException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import p052cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import p052cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;
import p052cz.msebera.android.httpclient.util.TextUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.entity.ContentType */
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
    public static final ContentType APPLICATION_FORM_URLENCODED = create(URLEncodedUtils.CONTENT_TYPE, Consts.ISO_8859_1);
    public static final ContentType APPLICATION_JSON = create("application/json", Consts.UTF_8);
    public static final ContentType APPLICATION_OCTET_STREAM;
    public static final ContentType APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
    public static final ContentType APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
    public static final ContentType APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
    public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    public static final ContentType DEFAULT_TEXT = TEXT_PLAIN;
    public static final ContentType MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
    public static final ContentType TEXT_HTML = create("text/html", Consts.ISO_8859_1);
    public static final ContentType TEXT_PLAIN = create(HTTP.PLAIN_TEXT_TYPE, Consts.ISO_8859_1);
    public static final ContentType TEXT_XML = create("text/xml", Consts.ISO_8859_1);
    public static final ContentType WILDCARD;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;

    static {
        Charset charset2 = null;
        APPLICATION_OCTET_STREAM = create("application/octet-stream", charset2);
        WILDCARD = create("*/*", charset2);
    }

    ContentType(String str, Charset charset2) {
        this.mimeType = str;
        this.charset = charset2;
        this.params = null;
    }

    ContentType(String str, NameValuePair[] nameValuePairArr) throws UnsupportedCharsetException {
        this.mimeType = str;
        this.params = nameValuePairArr;
        String parameter = getParameter("charset");
        this.charset = !TextUtils.isBlank(parameter) ? Charset.forName(parameter) : null;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getParameter(String str) {
        Args.notEmpty(str, "Parameter name");
        NameValuePair[] nameValuePairArr = this.params;
        if (nameValuePairArr == null) {
            return null;
        }
        for (NameValuePair nameValuePair : nameValuePairArr) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair.getValue();
            }
        }
        return null;
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.mimeType);
        if (this.params != null) {
            charArrayBuffer.append("; ");
            BasicHeaderValueFormatter.INSTANCE.formatParameters(charArrayBuffer, this.params, false);
        } else if (this.charset != null) {
            charArrayBuffer.append(HTTP.CHARSET_PARAM);
            charArrayBuffer.append(this.charset.name());
        }
        return charArrayBuffer.toString();
    }

    private static boolean valid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == ',' || charAt == ';') {
                return false;
            }
        }
        return true;
    }

    public static ContentType create(String str, Charset charset2) {
        String lowerCase = ((String) Args.notBlank(str, "MIME type")).toLowerCase(Locale.ENGLISH);
        Args.check(valid(lowerCase), "MIME type may not contain reserved characters");
        return new ContentType(lowerCase, charset2);
    }

    public static ContentType create(String str) {
        return new ContentType(str, (Charset) null);
    }

    public static ContentType create(String str, String str2) throws UnsupportedCharsetException {
        return create(str, !TextUtils.isBlank(str2) ? Charset.forName(str2) : null);
    }

    private static ContentType create(HeaderElement headerElement) {
        String name = headerElement.getName();
        NameValuePair[] parameters = headerElement.getParameters();
        if (parameters == null || parameters.length <= 0) {
            parameters = null;
        }
        return new ContentType(name, parameters);
    }

    public static ContentType parse(String str) throws ParseException, UnsupportedCharsetException {
        Args.notNull(str, "Content type");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        HeaderElement[] parseElements = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, new ParserCursor(0, str.length()));
        if (parseElements.length > 0) {
            return create(parseElements[0]);
        }
        throw new ParseException("Invalid content type: " + str);
    }

    public static ContentType get(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        Header contentType;
        if (!(httpEntity == null || (contentType = httpEntity.getContentType()) == null)) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return create(elements[0]);
            }
        }
        return null;
    }

    public static ContentType getOrDefault(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = get(httpEntity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public ContentType withCharset(Charset charset2) {
        return create(getMimeType(), charset2);
    }

    public ContentType withCharset(String str) {
        return create(getMimeType(), str);
    }
}
