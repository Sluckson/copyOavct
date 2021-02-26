package repack.org.bouncycastle.jce.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.jce.X509LDAPCertStoreParameters;

public class X509LDAPCertStoreSpi extends CertStoreSpi {
    private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String REFERRALS_IGNORE = "ignore";
    private static final String SEARCH_SECURITY_LEVEL = "none";
    private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
    private X509LDAPCertStoreParameters params;

    private Set search(String str, String str2, String[] strArr) throws CertStoreException {
        return null;
    }

    public X509LDAPCertStoreSpi(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof X509LDAPCertStoreParameters) {
            this.params = (X509LDAPCertStoreParameters) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException(String.valueOf(X509LDAPCertStoreSpi.class.getName()) + ": parameter must be a " + X509LDAPCertStoreParameters.class.getName() + " object\n" + certStoreParameters.toString());
    }

    private String parseDN(String str, String str2) {
        int i;
        String substring = str.substring(str.toLowerCase().indexOf(str2.toLowerCase()) + str2.length());
        int indexOf = substring.indexOf(44);
        if (indexOf == -1) {
            indexOf = substring.length();
        }
        while (substring.charAt(i - 1) == '\\') {
            i = substring.indexOf(44, i + 1);
            if (i == -1) {
                i = substring.length();
            }
        }
        String substring2 = substring.substring(0, i);
        String substring3 = substring2.substring(substring2.indexOf(61) + 1);
        if (substring3.charAt(0) == ' ') {
            substring3 = substring3.substring(1);
        }
        if (substring3.startsWith("\"")) {
            substring3 = substring3.substring(1);
        }
        return substring3.endsWith("\"") ? substring3.substring(0, substring3.length() - 1) : substring3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|(1:17)|18|(1:20)|21|22|(6:27|28|29|(2:31|45)(1:44)|42|23)|43|26|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0076 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[Catch:{ Exception -> 0x009a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection engineGetCertificates(java.security.cert.CertSelector r7) throws java.security.cert.CertStoreException {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.security.cert.X509CertSelector
            if (r0 == 0) goto L_0x00af
            java.security.cert.X509CertSelector r7 = (java.security.cert.X509CertSelector) r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Set r1 = r6.getEndCertificates(r7)
            java.util.Set r2 = r6.getCACertificates(r7)
            r1.addAll(r2)
            java.util.Set r2 = r6.getCrossCertificates(r7)
            r1.addAll(r2)
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r2 = "X.509"
            java.lang.String r3 = repack.org.bouncycastle.jce.provider.BouncyCastleProvider.PROVIDER_NAME     // Catch:{ Exception -> 0x009a }
            java.security.cert.CertificateFactory r2 = java.security.cert.CertificateFactory.getInstance(r2, r3)     // Catch:{ Exception -> 0x009a }
        L_0x0029:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x009a }
            if (r3 != 0) goto L_0x0030
            return r0
        L_0x0030:
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x009a }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x009a }
            if (r3 == 0) goto L_0x0029
            int r4 = r3.length     // Catch:{ Exception -> 0x009a }
            if (r4 != 0) goto L_0x003c
            goto L_0x0029
        L_0x003c:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x009a }
            r4.<init>()     // Catch:{ Exception -> 0x009a }
            r4.add(r3)     // Catch:{ Exception -> 0x009a }
            repack.org.bouncycastle.asn1.ASN1InputStream r5 = new repack.org.bouncycastle.asn1.ASN1InputStream     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            r5.<init>((byte[]) r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            repack.org.bouncycastle.asn1.DERObject r3 = r5.readObject()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            repack.org.bouncycastle.asn1.x509.CertificatePair r3 = repack.org.bouncycastle.asn1.x509.CertificatePair.getInstance(r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            r4.clear()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            repack.org.bouncycastle.asn1.x509.X509CertificateStructure r5 = r3.getForward()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            if (r5 == 0) goto L_0x0065
            repack.org.bouncycastle.asn1.x509.X509CertificateStructure r5 = r3.getForward()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            byte[] r5 = r5.getEncoded()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            r4.add(r5)     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
        L_0x0065:
            repack.org.bouncycastle.asn1.x509.X509CertificateStructure r5 = r3.getReverse()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            if (r5 == 0) goto L_0x0076
            repack.org.bouncycastle.asn1.x509.X509CertificateStructure r3 = r3.getReverse()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            byte[] r3 = r3.getEncoded()     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
            r4.add(r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0076 }
        L_0x0076:
            java.util.Iterator r3 = r4.iterator()     // Catch:{ Exception -> 0x009a }
        L_0x007a:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x009a }
            if (r4 != 0) goto L_0x0081
            goto L_0x0029
        L_0x0081:
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x009a }
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x009a }
            byte[] r5 = (byte[]) r5     // Catch:{ Exception -> 0x009a }
            r4.<init>(r5)     // Catch:{ Exception -> 0x009a }
            java.security.cert.Certificate r4 = r2.generateCertificate(r4)     // Catch:{ Exception -> 0x007a }
            boolean r5 = r7.match(r4)     // Catch:{ Exception -> 0x007a }
            if (r5 == 0) goto L_0x007a
            r0.add(r4)     // Catch:{ Exception -> 0x007a }
            goto L_0x007a
        L_0x009a:
            r7 = move-exception
            java.security.cert.CertStoreException r0 = new java.security.cert.CertStoreException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "certificate cannot be constructed from LDAP result: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x00af:
            java.security.cert.CertStoreException r7 = new java.security.cert.CertStoreException
            java.lang.String r0 = "selector is not a X509CertSelector"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.X509LDAPCertStoreSpi.engineGetCertificates(java.security.cert.CertSelector):java.util.Collection");
    }

    private Set certSubjectSerialSearch(X509CertSelector x509CertSelector, String[] strArr, String str, String str2) throws CertStoreException {
        String str3;
        HashSet hashSet = new HashSet();
        try {
            if (x509CertSelector.getSubjectAsBytes() == null) {
                if (x509CertSelector.getSubjectAsString() == null) {
                    if (x509CertSelector.getCertificate() == null) {
                        hashSet.addAll(search(str, "*", strArr));
                        return hashSet;
                    }
                }
            }
            String str4 = null;
            if (x509CertSelector.getCertificate() != null) {
                String name = x509CertSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
                str4 = x509CertSelector.getCertificate().getSerialNumber().toString();
                str3 = name;
            } else if (x509CertSelector.getSubjectAsBytes() != null) {
                str3 = new X500Principal(x509CertSelector.getSubjectAsBytes()).getName("RFC1779");
            } else {
                str3 = x509CertSelector.getSubjectAsString();
            }
            String parseDN = parseDN(str3, str2);
            hashSet.addAll(search(str, "*" + parseDN + "*", strArr));
            if (!(str4 == null || this.params.getSearchForSerialNumberIn() == null)) {
                String searchForSerialNumberIn = this.params.getSearchForSerialNumberIn();
                hashSet.addAll(search(searchForSerialNumberIn, "*" + str4 + "*", strArr));
            }
            return hashSet;
        } catch (IOException e) {
            throw new CertStoreException("exception processing selector: " + e);
        }
    }

    private Set getEndCertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        return certSubjectSerialSearch(x509CertSelector, new String[]{this.params.getUserCertificateAttribute()}, this.params.getLdapUserCertificateAttributeName(), this.params.getUserCertificateSubjectAttributeName());
    }

    private Set getCACertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.params.getCACertificateAttribute()};
        Set certSubjectSerialSearch = certSubjectSerialSearch(x509CertSelector, strArr, this.params.getLdapCACertificateAttributeName(), this.params.getCACertificateSubjectAttributeName());
        if (certSubjectSerialSearch.isEmpty()) {
            certSubjectSerialSearch.addAll(search((String) null, "*", strArr));
        }
        return certSubjectSerialSearch;
    }

    private Set getCrossCertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.params.getCrossCertificateAttribute()};
        Set certSubjectSerialSearch = certSubjectSerialSearch(x509CertSelector, strArr, this.params.getLdapCrossCertificateAttributeName(), this.params.getCrossCertificateSubjectAttributeName());
        if (certSubjectSerialSearch.isEmpty()) {
            certSubjectSerialSearch.addAll(search((String) null, "*", strArr));
        }
        return certSubjectSerialSearch;
    }

    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        String str;
        String[] strArr = {this.params.getCertificateRevocationListAttribute()};
        if (cRLSelector instanceof X509CRLSelector) {
            X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
            HashSet hashSet = new HashSet();
            String ldapCertificateRevocationListAttributeName = this.params.getLdapCertificateRevocationListAttributeName();
            HashSet<byte[]> hashSet2 = new HashSet<>();
            if (x509CRLSelector.getIssuerNames() != null) {
                for (Object next : x509CRLSelector.getIssuerNames()) {
                    if (next instanceof String) {
                        str = parseDN((String) next, this.params.getCertificateRevocationListIssuerAttributeName());
                    } else {
                        str = parseDN(new X500Principal((byte[]) next).getName("RFC1779"), this.params.getCertificateRevocationListIssuerAttributeName());
                    }
                    hashSet2.addAll(search(ldapCertificateRevocationListAttributeName, "*" + str + "*", strArr));
                }
            } else {
                hashSet2.addAll(search(ldapCertificateRevocationListAttributeName, "*", strArr));
            }
            hashSet2.addAll(search((String) null, "*", strArr));
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
                for (byte[] byteArrayInputStream : hashSet2) {
                    CRL generateCRL = instance.generateCRL(new ByteArrayInputStream(byteArrayInputStream));
                    if (x509CRLSelector.match(generateCRL)) {
                        hashSet.add(generateCRL);
                    }
                }
                return hashSet;
            } catch (Exception e) {
                throw new CertStoreException("CRL cannot be constructed from LDAP result " + e);
            }
        } else {
            throw new CertStoreException("selector is not a X509CRLSelector");
        }
    }
}
