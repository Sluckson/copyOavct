package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.x509.DistributionPoint;
import repack.org.bouncycastle.asn1.x509.TargetInformation;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import repack.org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import repack.org.bouncycastle.x509.ExtendedPKIXParameters;
import repack.org.bouncycastle.x509.PKIXAttrCertChecker;
import repack.org.bouncycastle.x509.X509AttributeCertificate;
import repack.org.bouncycastle.x509.X509CertStoreSelector;

class RFC3281CertPathUtilities {
    private static final String AUTHORITY_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();
    private static final String CRL_DISTRIBUTION_POINTS = X509Extensions.CRLDistributionPoints.getId();
    private static final String NO_REV_AVAIL = X509Extensions.NoRevAvail.getId();
    private static final String TARGET_INFORMATION = X509Extensions.TargetInformation.getId();

    RFC3281CertPathUtilities() {
    }

    protected static void processAttrCert7(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, ExtendedPKIXParameters extendedPKIXParameters) throws CertPathValidatorException {
        Set criticalExtensionOIDs = x509AttributeCertificate.getCriticalExtensionOIDs();
        if (criticalExtensionOIDs.contains(TARGET_INFORMATION)) {
            try {
                TargetInformation.getInstance(CertPathValidatorUtilities.getExtensionValue(x509AttributeCertificate, TARGET_INFORMATION));
            } catch (AnnotatedException e) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e);
            } catch (IllegalArgumentException e2) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e2);
            }
        }
        criticalExtensionOIDs.remove(TARGET_INFORMATION);
        for (PKIXAttrCertChecker check : extendedPKIXParameters.getAttrCertCheckers()) {
            check.check(x509AttributeCertificate, certPath, certPath2, criticalExtensionOIDs);
        }
        if (!criticalExtensionOIDs.isEmpty()) {
            throw new CertPathValidatorException("Attribute certificate contains unsupported critical extensions: " + criticalExtensionOIDs);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void checkCRLs(repack.org.bouncycastle.x509.X509AttributeCertificate r18, repack.org.bouncycastle.x509.ExtendedPKIXParameters r19, java.security.cert.X509Certificate r20, java.util.Date r21, java.util.List r22) throws java.security.cert.CertPathValidatorException {
        /*
            r9 = r18
            boolean r0 = r19.isRevocationEnabled()
            if (r0 == 0) goto L_0x0181
            java.lang.String r0 = NO_REV_AVAIL
            byte[] r0 = r9.getExtensionValue(r0)
            if (r0 != 0) goto L_0x0168
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS     // Catch:{ AnnotatedException -> 0x015f }
            repack.org.bouncycastle.asn1.DERObject r0 = repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r9, r0)     // Catch:{ AnnotatedException -> 0x015f }
            repack.org.bouncycastle.asn1.x509.CRLDistPoint r0 = repack.org.bouncycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ AnnotatedException -> 0x015f }
            r10 = r19
            repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.addAdditionalStoresFromCRLDistributionPoint(r0, r10)     // Catch:{ AnnotatedException -> 0x0155 }
            repack.org.bouncycastle.jce.provider.CertStatus r11 = new repack.org.bouncycastle.jce.provider.CertStatus
            r11.<init>()
            repack.org.bouncycastle.jce.provider.ReasonsMask r12 = new repack.org.bouncycastle.jce.provider.ReasonsMask
            r12.<init>()
            java.lang.String r13 = "No valid CRL for distribution point found."
            r8 = 11
            r7 = 0
            if (r0 == 0) goto L_0x0086
            repack.org.bouncycastle.asn1.x509.DistributionPoint[] r0 = r0.getDistributionPoints()     // Catch:{ Exception -> 0x007c }
            r6 = 0
            r16 = 0
        L_0x0037:
            int r1 = r0.length     // Catch:{ AnnotatedException -> 0x0071 }
            if (r6 >= r1) goto L_0x006c
            int r1 = r11.getCertStatus()     // Catch:{ AnnotatedException -> 0x0071 }
            if (r1 != r8) goto L_0x006c
            boolean r1 = r12.isAllReasons()     // Catch:{ AnnotatedException -> 0x0071 }
            if (r1 == 0) goto L_0x0047
            goto L_0x006c
        L_0x0047:
            java.lang.Object r1 = r19.clone()     // Catch:{ AnnotatedException -> 0x0071 }
            r3 = r1
            repack.org.bouncycastle.x509.ExtendedPKIXParameters r3 = (repack.org.bouncycastle.x509.ExtendedPKIXParameters) r3     // Catch:{ AnnotatedException -> 0x0071 }
            r1 = r0[r6]     // Catch:{ AnnotatedException -> 0x0071 }
            r2 = r18
            r4 = r21
            r5 = r20
            r17 = r6
            r6 = r11
            r14 = 0
            r7 = r12
            r15 = 11
            r8 = r22
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ AnnotatedException -> 0x006a }
            int r6 = r17 + 1
            r7 = 0
            r8 = 11
            r16 = 1
            goto L_0x0037
        L_0x006a:
            r0 = move-exception
            goto L_0x0075
        L_0x006c:
            r14 = 0
            r15 = 11
            r0 = 0
            goto L_0x008c
        L_0x0071:
            r0 = move-exception
            r14 = 0
            r15 = 11
        L_0x0075:
            repack.org.bouncycastle.jce.provider.AnnotatedException r1 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            r1.<init>(r13, r0)
            r0 = r1
            goto L_0x008c
        L_0x007c:
            r0 = move-exception
            r1 = r0
            repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "Distribution points could not be read."
            r0.<init>(r2, r1)
            throw r0
        L_0x0086:
            r14 = 0
            r15 = 11
            r0 = 0
            r16 = 0
        L_0x008c:
            int r1 = r11.getCertStatus()
            if (r1 != r15) goto L_0x00f0
            boolean r1 = r12.isAllReasons()
            if (r1 != 0) goto L_0x00f0
            repack.org.bouncycastle.asn1.ASN1InputStream r1 = new repack.org.bouncycastle.asn1.ASN1InputStream     // Catch:{ Exception -> 0x00e1 }
            repack.org.bouncycastle.x509.AttributeCertificateIssuer r2 = r18.getIssuer()     // Catch:{ Exception -> 0x00e1 }
            java.security.Principal[] r2 = r2.getPrincipals()     // Catch:{ Exception -> 0x00e1 }
            r2 = r2[r14]     // Catch:{ Exception -> 0x00e1 }
            javax.security.auth.x500.X500Principal r2 = (javax.security.auth.x500.X500Principal) r2     // Catch:{ Exception -> 0x00e1 }
            byte[] r2 = r2.getEncoded()     // Catch:{ Exception -> 0x00e1 }
            r1.<init>((byte[]) r2)     // Catch:{ Exception -> 0x00e1 }
            repack.org.bouncycastle.asn1.DERObject r1 = r1.readObject()     // Catch:{ Exception -> 0x00e1 }
            repack.org.bouncycastle.asn1.x509.DistributionPoint r2 = new repack.org.bouncycastle.asn1.x509.DistributionPoint     // Catch:{ AnnotatedException -> 0x00df }
            repack.org.bouncycastle.asn1.x509.DistributionPointName r3 = new repack.org.bouncycastle.asn1.x509.DistributionPointName     // Catch:{ AnnotatedException -> 0x00df }
            repack.org.bouncycastle.asn1.x509.GeneralNames r4 = new repack.org.bouncycastle.asn1.x509.GeneralNames     // Catch:{ AnnotatedException -> 0x00df }
            repack.org.bouncycastle.asn1.x509.GeneralName r5 = new repack.org.bouncycastle.asn1.x509.GeneralName     // Catch:{ AnnotatedException -> 0x00df }
            r6 = 4
            r5.<init>((int) r6, (repack.org.bouncycastle.asn1.ASN1Encodable) r1)     // Catch:{ AnnotatedException -> 0x00df }
            r4.<init>((repack.org.bouncycastle.asn1.x509.GeneralName) r5)     // Catch:{ AnnotatedException -> 0x00df }
            r3.<init>((int) r14, (repack.org.bouncycastle.asn1.ASN1Encodable) r4)     // Catch:{ AnnotatedException -> 0x00df }
            r1 = 0
            r2.<init>(r3, r1, r1)     // Catch:{ AnnotatedException -> 0x00df }
            java.lang.Object r1 = r19.clone()     // Catch:{ AnnotatedException -> 0x00df }
            r3 = r1
            repack.org.bouncycastle.x509.ExtendedPKIXParameters r3 = (repack.org.bouncycastle.x509.ExtendedPKIXParameters) r3     // Catch:{ AnnotatedException -> 0x00df }
            r1 = r2
            r2 = r18
            r4 = r21
            r5 = r20
            r6 = r11
            r7 = r12
            r8 = r22
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ AnnotatedException -> 0x00df }
            r16 = 1
            goto L_0x00f0
        L_0x00df:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e1:
            r0 = move-exception
            repack.org.bouncycastle.jce.provider.AnnotatedException r1 = new repack.org.bouncycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00df }
            java.lang.String r2 = "Issuer from certificate for CRL could not be reencoded."
            r1.<init>(r2, r0)     // Catch:{ AnnotatedException -> 0x00df }
            throw r1     // Catch:{ AnnotatedException -> 0x00df }
        L_0x00ea:
            repack.org.bouncycastle.jce.provider.AnnotatedException r1 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            r1.<init>(r13, r0)
            r0 = r1
        L_0x00f0:
            if (r16 == 0) goto L_0x014d
            int r0 = r11.getCertStatus()
            if (r0 != r15) goto L_0x0118
            boolean r0 = r12.isAllReasons()
            r1 = 12
            if (r0 != 0) goto L_0x0109
            int r0 = r11.getCertStatus()
            if (r0 != r15) goto L_0x0109
            r11.setCertStatus(r1)
        L_0x0109:
            int r0 = r11.getCertStatus()
            if (r0 == r1) goto L_0x0110
            goto L_0x0181
        L_0x0110:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate status could not be determined."
            r0.<init>(r1)
            throw r0
        L_0x0118:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Attribute certificate revocation after "
            r0.<init>(r1)
            java.util.Date r1 = r11.getRevocationDate()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r0)
            java.lang.String r0 = ", reason: "
            r1.append(r0)
            java.lang.String[] r0 = repack.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.crlReasons
            int r2 = r11.getCertStatus()
            r0 = r0[r2]
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            r1.<init>(r0)
            throw r1
        L_0x014d:
            repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException r1 = new repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "No valid CRL found."
            r1.<init>(r2, r0)
            throw r1
        L_0x0155:
            r0 = move-exception
            r1 = r0
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "No additional CRL locations could be decoded from CRL distribution point extension."
            r0.<init>(r2, r1)
            throw r0
        L_0x015f:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "CRL distribution point extension could not be read."
            r1.<init>(r2, r0)
            throw r1
        L_0x0168:
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS
            byte[] r0 = r9.getExtensionValue(r0)
            if (r0 != 0) goto L_0x0179
            java.lang.String r0 = AUTHORITY_INFO_ACCESS
            byte[] r0 = r9.getExtensionValue(r0)
            if (r0 != 0) goto L_0x0179
            goto L_0x0181
        L_0x0179:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "No rev avail extension is set, but also an AC revocation pointer."
            r0.<init>(r1)
            throw r0
        L_0x0181:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.RFC3281CertPathUtilities.checkCRLs(repack.org.bouncycastle.x509.X509AttributeCertificate, repack.org.bouncycastle.x509.ExtendedPKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.util.List):void");
    }

    protected static void additionalChecks(X509AttributeCertificate x509AttributeCertificate, ExtendedPKIXParameters extendedPKIXParameters) throws CertPathValidatorException {
        for (String str : extendedPKIXParameters.getProhibitedACAttributes()) {
            if (x509AttributeCertificate.getAttributes(str) != null) {
                throw new CertPathValidatorException("Attribute certificate contains prohibited attribute: " + str + ".");
            }
        }
        for (String str2 : extendedPKIXParameters.getNecessaryACAttributes()) {
            if (x509AttributeCertificate.getAttributes(str2) == null) {
                throw new CertPathValidatorException("Attribute certificate does not contain necessary attribute: " + str2 + ".");
            }
        }
    }

    protected static void processAttrCert5(X509AttributeCertificate x509AttributeCertificate, ExtendedPKIXParameters extendedPKIXParameters) throws CertPathValidatorException {
        try {
            x509AttributeCertificate.checkValidity(CertPathValidatorUtilities.getValidDate(extendedPKIXParameters));
        } catch (CertificateExpiredException e) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e);
        } catch (CertificateNotYetValidException e2) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e2);
        }
    }

    protected static void processAttrCert4(X509Certificate x509Certificate, ExtendedPKIXParameters extendedPKIXParameters) throws CertPathValidatorException {
        boolean z = false;
        for (TrustAnchor trustAnchor : extendedPKIXParameters.getTrustedACIssuers()) {
            if (x509Certificate.getSubjectX500Principal().getName("RFC2253").equals(trustAnchor.getCAName()) || x509Certificate.equals(trustAnchor.getTrustedCert())) {
                z = true;
            }
        }
        if (!z) {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        }
    }

    protected static void processAttrCert3(X509Certificate x509Certificate, ExtendedPKIXParameters extendedPKIXParameters) throws CertPathValidatorException {
        if (x509Certificate.getKeyUsage() != null && !x509Certificate.getKeyUsage()[0] && !x509Certificate.getKeyUsage()[1]) {
            throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
        } else if (x509Certificate.getBasicConstraints() != -1) {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        }
    }

    protected static CertPathValidatorResult processAttrCert2(CertPath certPath, ExtendedPKIXParameters extendedPKIXParameters) throws CertPathValidatorException {
        try {
            try {
                return CertPathValidator.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).validate(certPath, extendedPKIXParameters);
            } catch (CertPathValidatorException e) {
                throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", e);
            } catch (InvalidAlgorithmParameterException e2) {
                throw new RuntimeException(e2.getMessage());
            }
        } catch (NoSuchProviderException e3) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e4);
        }
    }

    protected static CertPath processAttrCert1(X509AttributeCertificate x509AttributeCertificate, ExtendedPKIXParameters extendedPKIXParameters) throws CertPathValidatorException {
        HashSet<X509Certificate> hashSet = new HashSet<>();
        int i = 0;
        if (x509AttributeCertificate.getHolder().getIssuer() != null) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            x509CertStoreSelector.setSerialNumber(x509AttributeCertificate.getHolder().getSerialNumber());
            Principal[] issuer = x509AttributeCertificate.getHolder().getIssuer();
            int i2 = 0;
            while (i2 < issuer.length) {
                try {
                    if (issuer[i2] instanceof X500Principal) {
                        x509CertStoreSelector.setIssuer(((X500Principal) issuer[i2]).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getStores()));
                    i2++;
                } catch (AnnotatedException e) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e);
                } catch (IOException e2) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e2);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (x509AttributeCertificate.getHolder().getEntityNames() != null) {
            X509CertStoreSelector x509CertStoreSelector2 = new X509CertStoreSelector();
            Principal[] entityNames = x509AttributeCertificate.getHolder().getEntityNames();
            while (i < entityNames.length) {
                try {
                    if (entityNames[i] instanceof X500Principal) {
                        x509CertStoreSelector2.setIssuer(((X500Principal) entityNames[i]).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector2, extendedPKIXParameters.getStores()));
                    i++;
                } catch (AnnotatedException e3) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e3);
                } catch (IOException e4) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e4);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) ExtendedPKIXBuilderParameters.getInstance(extendedPKIXParameters);
        ExtCertPathValidatorException extCertPathValidatorException = null;
        CertPathBuilderResult certPathBuilderResult = null;
        for (X509Certificate certificate : hashSet) {
            X509CertStoreSelector x509CertStoreSelector3 = new X509CertStoreSelector();
            x509CertStoreSelector3.setCertificate(certificate);
            extendedPKIXBuilderParameters.setTargetConstraints(x509CertStoreSelector3);
            try {
                try {
                    certPathBuilderResult = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).build(ExtendedPKIXBuilderParameters.getInstance(extendedPKIXBuilderParameters));
                } catch (CertPathBuilderException e5) {
                    extCertPathValidatorException = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", e5);
                } catch (InvalidAlgorithmParameterException e6) {
                    throw new RuntimeException(e6.getMessage());
                }
            } catch (NoSuchProviderException e7) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e7);
            } catch (NoSuchAlgorithmException e8) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e8);
            }
        }
        if (extCertPathValidatorException == null) {
            return certPathBuilderResult.getCertPath();
        }
        throw extCertPathValidatorException;
    }

    private static void checkCRL(DistributionPoint distributionPoint, X509AttributeCertificate x509AttributeCertificate, ExtendedPKIXParameters extendedPKIXParameters, Date date, X509Certificate x509Certificate, CertStatus certStatus, ReasonsMask reasonsMask, List list) throws AnnotatedException {
        Iterator it;
        X509CRL x509crl;
        DistributionPoint distributionPoint2 = distributionPoint;
        X509AttributeCertificate x509AttributeCertificate2 = x509AttributeCertificate;
        ExtendedPKIXParameters extendedPKIXParameters2 = extendedPKIXParameters;
        Date date2 = date;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        if (x509AttributeCertificate2.getExtensionValue(X509Extensions.NoRevAvail.getId()) == null) {
            Date date3 = new Date(System.currentTimeMillis());
            if (date.getTime() <= date3.getTime()) {
                Iterator it2 = CertPathValidatorUtilities.getCompleteCRLs(distributionPoint2, x509AttributeCertificate2, date3, extendedPKIXParameters2).iterator();
                e = null;
                boolean z = false;
                while (it2.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
                    try {
                        X509CRL x509crl2 = (X509CRL) it2.next();
                        ReasonsMask processCRLD = RFC3280CertPathUtilities.processCRLD(x509crl2, distributionPoint2);
                        if (!processCRLD.hasNewReasons(reasonsMask2)) {
                            continue;
                        } else {
                            ReasonsMask reasonsMask3 = processCRLD;
                            X509CRL x509crl3 = x509crl2;
                            it = it2;
                            try {
                                PublicKey processCRLG = RFC3280CertPathUtilities.processCRLG(x509crl3, RFC3280CertPathUtilities.processCRLF(x509crl2, x509AttributeCertificate, (X509Certificate) null, (PublicKey) null, extendedPKIXParameters, list));
                                if (extendedPKIXParameters.isUseDeltasEnabled()) {
                                    x509crl = RFC3280CertPathUtilities.processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date3, extendedPKIXParameters2, x509crl3), processCRLG);
                                } else {
                                    x509crl = null;
                                }
                                if (extendedPKIXParameters.getValidityModel() != 1) {
                                    try {
                                        if (x509AttributeCertificate.getNotAfter().getTime() < x509crl3.getThisUpdate().getTime()) {
                                            throw new AnnotatedException("No valid CRL for current time found.");
                                        }
                                    } catch (AnnotatedException e) {
                                        e = e;
                                        it2 = it;
                                    }
                                }
                                RFC3280CertPathUtilities.processCRLB1(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.processCRLB2(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.processCRLC(x509crl, x509crl3, extendedPKIXParameters2);
                                RFC3280CertPathUtilities.processCRLI(date2, x509crl, x509AttributeCertificate2, certStatus2, extendedPKIXParameters2);
                                RFC3280CertPathUtilities.processCRLJ(date2, x509crl3, x509AttributeCertificate2, certStatus2);
                                if (certStatus.getCertStatus() == 8) {
                                    certStatus2.setCertStatus(11);
                                }
                                reasonsMask2.addReasons(reasonsMask3);
                                it2 = it;
                                z = true;
                            } catch (AnnotatedException e2) {
                                e = e2;
                                it2 = it;
                            }
                        }
                    } catch (AnnotatedException e3) {
                        e = e3;
                        it = it2;
                        it2 = it;
                    }
                }
                if (!z) {
                    throw e;
                }
                return;
            }
            throw new AnnotatedException("Validation time is in future.");
        }
    }
}
