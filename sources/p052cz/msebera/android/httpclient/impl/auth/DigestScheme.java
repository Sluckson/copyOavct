package p052cz.msebera.android.httpclient.impl.auth;

import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import p052cz.msebera.android.httpclient.Consts;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.ChallengeState;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import p052cz.msebera.android.httpclient.message.BasicNameValuePair;
import p052cz.msebera.android.httpclient.message.BufferedHeader;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;
import p052cz.msebera.android.httpclient.util.EncodingUtils;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.auth.DigestScheme */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;

    /* renamed from: a1 */
    private String f4880a1;

    /* renamed from: a2 */
    private String f4881a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public String getSchemeName() {
        return CMSAttributeTableGenerator.DIGEST;
    }

    public boolean isConnectionBased() {
        return false;
    }

    public DigestScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    @Deprecated
    public DigestScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public DigestScheme() {
        this(Consts.ASCII);
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
    }

    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        if (getParameter("realm") == null) {
            throw new AuthenticationException("missing realm in challenge");
        } else if (getParameter("nonce") != null) {
            getParameters().put("methodname", httpRequest.getRequestLine().getMethod());
            getParameters().put("uri", httpRequest.getRequestLine().getUri());
            if (getParameter("charset") == null) {
                getParameters().put("charset", getCredentialsCharset(httpRequest));
            }
            return createDigestHeader(credentials, httpRequest);
        } else {
            throw new AuthenticationException("missing nonce in challenge");
        }
    }

    private static MessageDigest createMessageDigest(String str) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    private Header createDigestHeader(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String str;
        char c;
        String str2;
        String str3;
        String str4;
        String str5;
        HttpRequest httpRequest2 = httpRequest;
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        String str6 = "MD5";
        String parameter7 = getParameter("qop");
        String str7 = "opaque";
        String str8 = parameter4;
        String str9 = "algorithm";
        if (parameter7 != null) {
            str = "qop";
            for (StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ENGLISH));
            }
            c = (!(httpRequest2 instanceof HttpEntityEnclosingRequest) || !hashSet.contains("auth-int")) ? hashSet.contains("auth") ? (char) 2 : 65535 : 1;
        } else {
            str = "qop";
            c = 0;
        }
        if (c != 65535) {
            String parameter8 = getParameter("charset");
            if (parameter8 == null) {
                parameter8 = "ISO-8859-1";
            }
            String str10 = parameter6.equalsIgnoreCase("MD5-sess") ? str6 : parameter6;
            try {
                MessageDigest createMessageDigest = createMessageDigest(str10);
                String str11 = "auth-int";
                String name = credentials.getUserPrincipal().getName();
                String str12 = "uri";
                String password = credentials.getPassword();
                String str13 = "nonce";
                String str14 = "realm";
                if (parameter3.equals(this.lastNonce)) {
                    str2 = parameter2;
                    this.nounceCount++;
                } else {
                    str2 = parameter2;
                    this.nounceCount = 1;
                    this.cnonce = null;
                    this.lastNonce = parameter3;
                }
                StringBuilder sb = new StringBuilder(256);
                String str15 = "auth";
                Formatter formatter = new Formatter(sb, Locale.US);
                HashSet hashSet2 = hashSet;
                String str16 = parameter5;
                formatter.format("%08x", new Object[]{Long.valueOf(this.nounceCount)});
                formatter.close();
                String sb2 = sb.toString();
                if (this.cnonce == null) {
                    this.cnonce = createCnonce();
                }
                this.f4880a1 = null;
                this.f4881a2 = null;
                if (parameter6.equalsIgnoreCase("MD5-sess")) {
                    sb.setLength(0);
                    sb.append(name);
                    sb.append(':');
                    sb.append(str2);
                    sb.append(':');
                    sb.append(password);
                    String encode = encode(createMessageDigest.digest(EncodingUtils.getBytes(sb.toString(), parameter8)));
                    sb.setLength(0);
                    sb.append(encode);
                    sb.append(':');
                    sb.append(parameter3);
                    sb.append(':');
                    sb.append(this.cnonce);
                    this.f4880a1 = sb.toString();
                } else {
                    sb.setLength(0);
                    sb.append(name);
                    sb.append(':');
                    sb.append(str2);
                    sb.append(':');
                    sb.append(password);
                    this.f4880a1 = sb.toString();
                }
                String encode2 = encode(createMessageDigest.digest(EncodingUtils.getBytes(this.f4880a1, parameter8)));
                if (c == 2) {
                    this.f4881a2 = str16 + ':' + parameter;
                    str3 = str15;
                } else {
                    String str17 = str16;
                    if (c == 1) {
                        HttpEntity entity = httpRequest2 instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest) httpRequest2).getEntity() : null;
                        if (entity == null || entity.isRepeatable()) {
                            str3 = str15;
                            HttpEntityDigester httpEntityDigester = new HttpEntityDigester(createMessageDigest);
                            if (entity != null) {
                                try {
                                    entity.writeTo(httpEntityDigester);
                                } catch (IOException e) {
                                    throw new AuthenticationException("I/O error reading entity content", e);
                                }
                            }
                            httpEntityDigester.close();
                            this.f4881a2 = str17 + ':' + parameter + ':' + encode(httpEntityDigester.getDigest());
                        } else {
                            str3 = str15;
                            if (hashSet2.contains(str3)) {
                                this.f4881a2 = str17 + ':' + parameter;
                                c = 2;
                            } else {
                                throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                            }
                        }
                    } else {
                        str3 = str15;
                        this.f4881a2 = str17 + ':' + parameter;
                    }
                }
                String encode3 = encode(createMessageDigest.digest(EncodingUtils.getBytes(this.f4881a2, parameter8)));
                if (c == 0) {
                    sb.setLength(0);
                    sb.append(encode2);
                    sb.append(':');
                    sb.append(parameter3);
                    sb.append(':');
                    sb.append(encode3);
                    str4 = sb.toString();
                } else {
                    sb.setLength(0);
                    sb.append(encode2);
                    sb.append(':');
                    sb.append(parameter3);
                    sb.append(':');
                    sb.append(sb2);
                    sb.append(':');
                    sb.append(this.cnonce);
                    sb.append(':');
                    sb.append(c == 1 ? str11 : str3);
                    sb.append(':');
                    sb.append(encode3);
                    str4 = sb.toString();
                }
                String encode4 = encode(createMessageDigest.digest(EncodingUtils.getAsciiBytes(str4)));
                CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
                if (isProxy()) {
                    charArrayBuffer.append("Proxy-Authorization");
                } else {
                    charArrayBuffer.append("Authorization");
                }
                charArrayBuffer.append(": Digest ");
                ArrayList arrayList = new ArrayList(20);
                arrayList.add(new BasicNameValuePair("username", name));
                arrayList.add(new BasicNameValuePair(str14, str2));
                arrayList.add(new BasicNameValuePair(str13, parameter3));
                arrayList.add(new BasicNameValuePair(str12, parameter));
                arrayList.add(new BasicNameValuePair("response", encode4));
                if (c != 0) {
                    if (c == 1) {
                        str3 = str11;
                    }
                    str5 = str;
                    arrayList.add(new BasicNameValuePair(str5, str3));
                    arrayList.add(new BasicNameValuePair("nc", sb2));
                    arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
                } else {
                    str5 = str;
                }
                String str18 = str9;
                arrayList.add(new BasicNameValuePair(str18, parameter6));
                if (str8 != null) {
                    arrayList.add(new BasicNameValuePair(str7, str8));
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i);
                    if (i > 0) {
                        charArrayBuffer.append(", ");
                    }
                    String name2 = basicNameValuePair.getName();
                    BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, (NameValuePair) basicNameValuePair, !("nc".equals(name2) || str5.equals(name2) || str18.equals(name2)));
                }
                return new BufferedHeader(charArrayBuffer);
            } catch (UnsupportedDigestAlgorithmException unused) {
                throw new AuthenticationException("Unsuppported digest algorithm: " + str10);
            }
        } else {
            throw new AuthenticationException("None of the qop methods is supported: " + parameter7);
        }
    }

    /* access modifiers changed from: package-private */
    public String getCnonce() {
        return this.cnonce;
    }

    /* access modifiers changed from: package-private */
    public String getA1() {
        return this.f4880a1;
    }

    /* access modifiers changed from: package-private */
    public String getA2() {
        return this.f4881a2;
    }

    static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i2] = cArr2[(bArr[i] & 240) >> 4];
            cArr[i2 + 1] = cArr2[bArr[i] & 15];
        }
        return new String(cArr);
    }

    public static String createCnonce() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encode(bArr);
    }

    public String toString() {
        return "DIGEST [complete=" + this.complete + ", nonce=" + this.lastNonce + ", nc=" + this.nounceCount + "]";
    }
}
