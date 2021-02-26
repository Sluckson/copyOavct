package repack.org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import repack.org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        ExtendedPKIXParameters extendedPKIXParameters;
        int i;
        PublicKey publicKey;
        X500Principal x500Principal;
        HashSet hashSet;
        Set set;
        boolean z;
        ArrayList[] arrayListArr;
        HashSet hashSet2;
        CertPath certPath2 = certPath;
        CertPathParameters certPathParameters2 = certPathParameters;
        if (certPathParameters2 instanceof PKIXParameters) {
            if (certPathParameters2 instanceof ExtendedPKIXParameters) {
                extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters2;
            } else {
                extendedPKIXParameters = ExtendedPKIXParameters.getInstance((PKIXParameters) certPathParameters2);
            }
            if (extendedPKIXParameters.getTrustAnchors() != null) {
                List<? extends Certificate> certificates = certPath.getCertificates();
                int size = certificates.size();
                int i2 = 0;
                if (!certificates.isEmpty()) {
                    Set initialPolicies = extendedPKIXParameters.getInitialPolicies();
                    try {
                        TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), extendedPKIXParameters.getTrustAnchors(), extendedPKIXParameters.getSigProvider());
                        if (findTrustAnchor != null) {
                            int i3 = size + 1;
                            ArrayList[] arrayListArr2 = new ArrayList[i3];
                            int i4 = 0;
                            while (i4 < arrayListArr2.length) {
                                List<? extends Certificate> list = certificates;
                                Set set2 = initialPolicies;
                                TrustAnchor trustAnchor = findTrustAnchor;
                                arrayListArr2[i4] = new ArrayList();
                                i4++;
                                extendedPKIXParameters = extendedPKIXParameters;
                                i2 = 0;
                            }
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add("2.5.29.32.0");
                            PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, (PolicyNode) null, new HashSet(), "2.5.29.32.0", false);
                            arrayListArr2[i2].add(pKIXPolicyNode);
                            PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                            HashSet hashSet4 = new HashSet();
                            int i5 = extendedPKIXParameters.isExplicitPolicyRequired() ? 0 : i3;
                            int i6 = extendedPKIXParameters.isAnyPolicyInhibited() ? 0 : i3;
                            if (extendedPKIXParameters.isPolicyMappingInhibited()) {
                                i3 = 0;
                            }
                            X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                            if (trustedCert != null) {
                                try {
                                    X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(trustedCert);
                                    publicKey = trustedCert.getPublicKey();
                                    x500Principal = subjectPrincipal;
                                } catch (IllegalArgumentException e) {
                                    throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e, certPath2, -1);
                                }
                            } else {
                                x500Principal = new X500Principal(findTrustAnchor.getCAName());
                                publicKey = findTrustAnchor.getCAPublicKey();
                            }
                            try {
                                AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                                algorithmIdentifier.getObjectId();
                                algorithmIdentifier.getParameters();
                                if (extendedPKIXParameters.getTargetConstraints() == null || extendedPKIXParameters.getTargetConstraints().match((X509Certificate) certificates.get(i2))) {
                                    List<PKIXCertPathChecker> certPathCheckers = extendedPKIXParameters.getCertPathCheckers();
                                    for (PKIXCertPathChecker init : certPathCheckers) {
                                        List<? extends Certificate> list2 = certificates;
                                        Set set3 = initialPolicies;
                                        TrustAnchor trustAnchor2 = findTrustAnchor;
                                        init.init(false);
                                        arrayListArr2 = arrayListArr2;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator;
                                        extendedPKIXParameters = extendedPKIXParameters;
                                    }
                                    int size2 = certificates.size() - 1;
                                    PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                    X509Certificate x509Certificate = trustedCert;
                                    X509Certificate x509Certificate2 = null;
                                    X500Principal x500Principal2 = x500Principal;
                                    int i7 = size;
                                    int i8 = i6;
                                    int i9 = i5;
                                    int i10 = i8;
                                    while (size2 >= 0) {
                                        int i11 = size - size2;
                                        X509Certificate x509Certificate3 = (X509Certificate) certificates.get(size2);
                                        if (size2 == certificates.size() - 1) {
                                            set = initialPolicies;
                                            z = true;
                                        } else {
                                            set = initialPolicies;
                                            z = false;
                                        }
                                        int i12 = i7;
                                        CertPath certPath3 = certPath;
                                        TrustAnchor trustAnchor3 = findTrustAnchor;
                                        int i13 = i;
                                        int i14 = i10;
                                        ExtendedPKIXParameters extendedPKIXParameters2 = extendedPKIXParameters;
                                        int i15 = i11;
                                        List<? extends Certificate> list3 = certificates;
                                        int i16 = i9;
                                        boolean z2 = z;
                                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                                        ArrayList[] arrayListArr3 = arrayListArr2;
                                        RFC3280CertPathUtilities.processCertA(certPath3, extendedPKIXParameters, size2, publicKey, z2, x500Principal2, x509Certificate);
                                        RFC3280CertPathUtilities.processCertBC(certPath2, size2, pKIXNameConstraintValidator2);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath2, size2, RFC3280CertPathUtilities.processCertD(certPath3, size2, hashSet4, pKIXPolicyNode2, arrayListArr3, i14));
                                        RFC3280CertPathUtilities.processCertF(certPath2, size2, processCertE, i16);
                                        if (i15 == size) {
                                            arrayListArr = arrayListArr3;
                                            pKIXPolicyNode2 = processCertE;
                                            i10 = i14;
                                            i9 = i16;
                                            i7 = i12;
                                            i = i13;
                                        } else if (x509Certificate3 == null || x509Certificate3.getVersion() != 1) {
                                            RFC3280CertPathUtilities.prepareNextCertA(certPath2, size2);
                                            arrayListArr = arrayListArr3;
                                            PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, size2, arrayListArr, processCertE, i13);
                                            RFC3280CertPathUtilities.prepareNextCertG(certPath2, size2, pKIXNameConstraintValidator2);
                                            int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, size2, i16);
                                            int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, size2, i13);
                                            int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, size2, i14);
                                            int prepareNextCertI1 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, size2, prepareNextCertH1);
                                            int prepareNextCertI2 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, size2, prepareNextCertH2);
                                            int prepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, size2, prepareNextCertH3);
                                            RFC3280CertPathUtilities.prepareNextCertK(certPath2, size2);
                                            int prepareNextCertM = RFC3280CertPathUtilities.prepareNextCertM(certPath2, size2, RFC3280CertPathUtilities.prepareNextCertL(certPath2, size2, i12));
                                            RFC3280CertPathUtilities.prepareNextCertN(certPath2, size2);
                                            Set criticalExtensionOIDs = x509Certificate3.getCriticalExtensionOIDs();
                                            if (criticalExtensionOIDs != null) {
                                                hashSet2 = new HashSet(criticalExtensionOIDs);
                                                hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                            } else {
                                                hashSet2 = new HashSet();
                                            }
                                            RFC3280CertPathUtilities.prepareNextCertO(certPath2, size2, hashSet2, certPathCheckers);
                                            x500Principal2 = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate3);
                                            try {
                                                publicKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), size2);
                                                AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                                                algorithmIdentifier2.getObjectId();
                                                algorithmIdentifier2.getParameters();
                                                pKIXPolicyNode2 = prepareCertB;
                                                i7 = prepareNextCertM;
                                                x509Certificate = x509Certificate3;
                                                i9 = prepareNextCertI1;
                                                i = prepareNextCertI2;
                                                i10 = prepareNextCertJ;
                                            } catch (CertPathValidatorException e2) {
                                                throw new CertPathValidatorException("Next working key could not be retrieved.", e2, certPath2, size2);
                                            }
                                        } else {
                                            throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", (Throwable) null, certPath2, size2);
                                        }
                                        size2--;
                                        arrayListArr2 = arrayListArr;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                        x509Certificate2 = x509Certificate3;
                                        initialPolicies = set;
                                        findTrustAnchor = trustAnchor3;
                                        extendedPKIXParameters = extendedPKIXParameters2;
                                        certificates = list3;
                                    }
                                    int wrapupCertA = RFC3280CertPathUtilities.wrapupCertA(i9, x509Certificate2);
                                    int i17 = size2 + 1;
                                    int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i17, wrapupCertA);
                                    Set criticalExtensionOIDs2 = x509Certificate2.getCriticalExtensionOIDs();
                                    if (criticalExtensionOIDs2 != null) {
                                        hashSet = new HashSet(criticalExtensionOIDs2);
                                        hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                        hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                        hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                        hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                        hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                        hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    RFC3280CertPathUtilities.wrapupCertF(certPath2, i17, certPathCheckers, hashSet);
                                    X509Certificate x509Certificate4 = x509Certificate2;
                                    PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, extendedPKIXParameters, initialPolicies, i17, arrayListArr2, pKIXPolicyNode2, hashSet4);
                                    if (wrapupCertB > 0 || wrapupCertG != null) {
                                        return new PKIXCertPathValidatorResult(findTrustAnchor, wrapupCertG, x509Certificate4.getPublicKey());
                                    }
                                    throw new CertPathValidatorException("Path processing failed on policy.", (Throwable) null, certPath2, size2);
                                }
                                throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", (Throwable) null, certPath2, i2);
                            } catch (CertPathValidatorException e3) {
                                throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e3, certPath2, -1);
                            }
                        } else {
                            throw new CertPathValidatorException("Trust anchor for certification path not found.", (Throwable) null, certPath2, -1);
                        }
                    } catch (AnnotatedException e4) {
                        throw new CertPathValidatorException(e4.getMessage(), e4, certPath2, certificates.size() - 1);
                    }
                } else {
                    throw new CertPathValidatorException("Certification path is empty.", (Throwable) null, certPath2, 0);
                }
            } else {
                throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
    }
}
