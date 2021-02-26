package p052cz.msebera.android.httpclient.conn.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.text.Typography;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

@Immutable
/* renamed from: cz.msebera.android.httpclient.conn.ssl.AbstractVerifier */
public abstract class AbstractVerifier implements X509HostnameVerifier {
    private static final String[] BAD_COUNTRY_2LDS = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }

    public final void verify(String str, SSLSocket sSLSocket) throws IOException {
        if (str != null) {
            SSLSession session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.getInputStream().available();
                session = sSLSocket.getSession();
                if (session == null) {
                    sSLSocket.startHandshake();
                    session = sSLSocket.getSession();
                }
            }
            verify(str, (X509Certificate) session.getPeerCertificates()[0]);
            return;
        }
        throw new NullPointerException("host to verify is null");
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException unused) {
            return false;
        }
    }

    public final void verify(String str, X509Certificate x509Certificate) throws SSLException {
        verify(str, getCNs(x509Certificate), getSubjectAlts(x509Certificate, str));
    }

    public final void verify(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        boolean z2;
        LinkedList linkedList = new LinkedList();
        if (!(strArr == null || strArr.length <= 0 || strArr[0] == null)) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (str2 != null) {
                    linkedList.add(str2);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String normaliseIPv6Address = normaliseIPv6Address(str.trim().toLowerCase(Locale.ENGLISH));
            Iterator it = linkedList.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                String lowerCase = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                sb.append(" <");
                sb.append(lowerCase);
                sb.append(Typography.greater);
                if (it.hasNext()) {
                    sb.append(" OR");
                }
                String[] split = lowerCase.split("\\.");
                if (split.length >= 3 && split[0].endsWith("*") && validCountryWildcard(lowerCase) && !isIPAddress(str)) {
                    String str3 = split[0];
                    if (str3.length() > 1) {
                        String substring = str3.substring(0, str3.length() - 1);
                        z2 = normaliseIPv6Address.startsWith(substring) && normaliseIPv6Address.substring(substring.length()).endsWith(lowerCase.substring(str3.length()));
                    } else {
                        z2 = normaliseIPv6Address.endsWith(lowerCase.substring(1));
                    }
                    if (z2 && z) {
                        z2 = countDots(normaliseIPv6Address) == countDots(lowerCase);
                    }
                    z3 = z2;
                    continue;
                } else {
                    z3 = normaliseIPv6Address.equals(normaliseIPv6Address(lowerCase));
                    continue;
                }
                if (z3) {
                    break;
                }
            }
            if (!z3) {
                throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + sb);
            }
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    @Deprecated
    public static boolean acceptableCountryWildcard(String str) {
        String[] split = str.split("\\.");
        if (split.length == 3 && split[2].length() == 2 && Arrays.binarySearch(BAD_COUNTRY_2LDS, split[1]) >= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean validCountryWildcard(String str) {
        String[] split = str.split("\\.");
        if (split.length == 3 && split[2].length() == 2 && Arrays.binarySearch(BAD_COUNTRY_2LDS, split[1]) >= 0) {
            return false;
        }
        return true;
    }

    public static String[] getCNs(X509Certificate x509Certificate) {
        try {
            return extractCNs(x509Certificate.getSubjectX500Principal().toString());
        } catch (SSLException unused) {
            return null;
        }
    }

    static String[] extractCNs(String str) throws SSLException {
        if (str == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("CN=");
            if (indexOf >= 0) {
                linkedList.add(nextToken.substring(indexOf + 3));
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static String[] getSubjectAlts(X509Certificate x509Certificate, String str) {
        Collection<List<?>> collection;
        int i = isIPAddress(str) ? 7 : 2;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException unused) {
            collection = null;
        }
        if (collection != null) {
            for (List next : collection) {
                if (((Integer) next.get(0)).intValue() == i) {
                    linkedList.add((String) next.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) {
        return getSubjectAlts(x509Certificate, (String) null);
    }

    public static int countDots(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    private static boolean isIPAddress(String str) {
        return str != null && (InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str));
    }

    private String normaliseIPv6Address(String str) {
        if (str != null && InetAddressUtils.isIPv6Address(str)) {
            try {
                return InetAddress.getByName(str).getHostAddress();
            } catch (UnknownHostException e) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.error("Unexpected error converting " + str, e);
            }
        }
        return str;
    }
}
