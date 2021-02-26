package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.BasicConstraints;
import repack.org.bouncycastle.asn1.x509.CRLDistPoint;
import repack.org.bouncycastle.asn1.x509.DistributionPoint;
import repack.org.bouncycastle.asn1.x509.DistributionPointName;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.GeneralNames;
import repack.org.bouncycastle.asn1.x509.GeneralSubtree;
import repack.org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import repack.org.bouncycastle.asn1.x509.NameConstraints;
import repack.org.bouncycastle.asn1.x509.PolicyInformation;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.asn1.x509.X509Name;
import repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import repack.org.bouncycastle.util.Arrays;
import repack.org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import repack.org.bouncycastle.x509.ExtendedPKIXParameters;
import repack.org.bouncycastle.x509.X509CRLStoreSelector;
import repack.org.bouncycastle.x509.X509CertStoreSelector;

public class RFC3280CertPathUtilities {
    protected static final String ANY_POLICY = "2.5.29.32.0";
    protected static final String AUTHORITY_KEY_IDENTIFIER = X509Extensions.AuthorityKeyIdentifier.getId();
    protected static final String BASIC_CONSTRAINTS = X509Extensions.BasicConstraints.getId();
    protected static final String CERTIFICATE_POLICIES = X509Extensions.CertificatePolicies.getId();
    protected static final String CRL_DISTRIBUTION_POINTS = X509Extensions.CRLDistributionPoints.getId();
    protected static final String CRL_NUMBER = X509Extensions.CRLNumber.getId();
    protected static final int CRL_SIGN = 6;
    private static final PKIXCRLUtil CRL_UTIL = new PKIXCRLUtil();
    protected static final String DELTA_CRL_INDICATOR = X509Extensions.DeltaCRLIndicator.getId();
    protected static final String FRESHEST_CRL = X509Extensions.FreshestCRL.getId();
    protected static final String INHIBIT_ANY_POLICY = X509Extensions.InhibitAnyPolicy.getId();
    protected static final String ISSUING_DISTRIBUTION_POINT = X509Extensions.IssuingDistributionPoint.getId();
    protected static final int KEY_CERT_SIGN = 5;
    protected static final String KEY_USAGE = X509Extensions.KeyUsage.getId();
    protected static final String NAME_CONSTRAINTS = X509Extensions.NameConstraints.getId();
    protected static final String POLICY_CONSTRAINTS = X509Extensions.PolicyConstraints.getId();
    protected static final String POLICY_MAPPINGS = X509Extensions.PolicyMappings.getId();
    protected static final String SUBJECT_ALTERNATIVE_NAME = X509Extensions.SubjectAlternativeName.getId();
    protected static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    protected static void processCRLB2(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        GeneralName[] generalNameArr;
        try {
            IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (instance != null) {
                if (instance.getDistributionPoint() != null) {
                    DistributionPointName distributionPoint2 = IssuingDistributionPoint.getInstance(instance).getDistributionPoint();
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    if (distributionPoint2.getType() == 0) {
                        GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                        for (GeneralName add : names) {
                            arrayList.add(add);
                        }
                    }
                    if (distributionPoint2.getType() == 1) {
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        try {
                            Enumeration objects = ASN1Sequence.getInstance(ASN1Sequence.fromByteArray(CertPathValidatorUtilities.getIssuerPrincipal(x509crl).getEncoded())).getObjects();
                            while (objects.hasMoreElements()) {
                                aSN1EncodableVector.add((DEREncodable) objects.nextElement());
                            }
                            aSN1EncodableVector.add(distributionPoint2.getName());
                            arrayList.add(new GeneralName(X509Name.getInstance(new DERSequence(aSN1EncodableVector))));
                        } catch (IOException e) {
                            throw new AnnotatedException("Could not read CRL issuer.", e);
                        }
                    }
                    if (distributionPoint.getDistributionPoint() != null) {
                        DistributionPointName distributionPoint3 = distributionPoint.getDistributionPoint();
                        GeneralName[] generalNameArr2 = null;
                        if (distributionPoint3.getType() == 0) {
                            generalNameArr2 = GeneralNames.getInstance(distributionPoint3.getName()).getNames();
                        }
                        if (distributionPoint3.getType() == 1) {
                            if (distributionPoint.getCRLIssuer() != null) {
                                generalNameArr = distributionPoint.getCRLIssuer().getNames();
                            } else {
                                generalNameArr = new GeneralName[1];
                                try {
                                    generalNameArr[0] = new GeneralName(new X509Name((ASN1Sequence) ASN1Sequence.fromByteArray(CertPathValidatorUtilities.getEncodedIssuerPrincipal(obj).getEncoded())));
                                } catch (IOException e2) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e2);
                                }
                            }
                            generalNameArr2 = generalNameArr;
                            for (int i = 0; i < generalNameArr2.length; i++) {
                                Enumeration objects2 = ASN1Sequence.getInstance(generalNameArr2[i].getName().getDERObject()).getObjects();
                                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                                while (objects2.hasMoreElements()) {
                                    aSN1EncodableVector2.add((DEREncodable) objects2.nextElement());
                                }
                                aSN1EncodableVector2.add(distributionPoint3.getName());
                                generalNameArr2[i] = new GeneralName(new X509Name((ASN1Sequence) new DERSequence(aSN1EncodableVector2)));
                            }
                        }
                        if (generalNameArr2 != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= generalNameArr2.length) {
                                    break;
                                } else if (arrayList.contains(generalNameArr2[i2])) {
                                    z = true;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else if (distributionPoint.getCRLIssuer() != null) {
                        GeneralName[] names2 = distributionPoint.getCRLIssuer().getNames();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= names2.length) {
                                break;
                            } else if (arrayList.contains(names2[i3])) {
                                z = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else {
                        throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                    }
                }
                try {
                    BasicConstraints instance2 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension) obj, BASIC_CONSTRAINTS));
                    if (obj instanceof X509Certificate) {
                        if (instance.onlyContainsUserCerts() && instance2 != null && instance2.isCA()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                        } else if (instance.onlyContainsCACerts() && (instance2 == null || !instance2.isCA())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.");
                        }
                    }
                    if (instance.onlyContainsAttributeCerts()) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (Exception e3) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e3);
                }
            }
        } catch (Exception e4) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e4);
        }
    }

    protected static void processCRLB1(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        boolean z;
        DERObject extensionValue = CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT);
        boolean z2 = extensionValue != null && IssuingDistributionPoint.getInstance(extensionValue).isIndirectCRL();
        byte[] encoded = CertPathValidatorUtilities.getIssuerPrincipal(x509crl).getEncoded();
        if (distributionPoint.getCRLIssuer() != null) {
            GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
            z = false;
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    try {
                        if (Arrays.areEqual(names[i].getName().getDERObject().getEncoded(), encoded)) {
                            z = true;
                        }
                    } catch (IOException e) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                    }
                }
            }
            if (z && !z2) {
                throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
            } else if (!z) {
                throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
            }
        } else {
            z = CertPathValidatorUtilities.getIssuerPrincipal(x509crl).equals(CertPathValidatorUtilities.getEncodedIssuerPrincipal(obj));
        }
        if (!z) {
            throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
        }
    }

    protected static ReasonsMask processCRLD(X509CRL x509crl, DistributionPoint distributionPoint) throws AnnotatedException {
        ReasonsMask reasonsMask;
        ReasonsMask reasonsMask2;
        try {
            IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (instance != null && instance.getOnlySomeReasons() != null && distributionPoint.getReasons() != null) {
                return new ReasonsMask(distributionPoint.getReasons().intValue()).intersect(new ReasonsMask(instance.getOnlySomeReasons().intValue()));
            }
            if ((instance == null || instance.getOnlySomeReasons() == null) && distributionPoint.getReasons() == null) {
                return ReasonsMask.allReasons;
            }
            if (distributionPoint.getReasons() == null) {
                reasonsMask = ReasonsMask.allReasons;
            } else {
                reasonsMask = new ReasonsMask(distributionPoint.getReasons().intValue());
            }
            if (instance == null) {
                reasonsMask2 = ReasonsMask.allReasons;
            } else {
                reasonsMask2 = new ReasonsMask(instance.getOnlySomeReasons().intValue());
            }
            return reasonsMask.intersect(reasonsMask2);
        } catch (Exception e) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e);
        }
    }

    protected static Set processCRLF(X509CRL x509crl, Object obj, X509Certificate x509Certificate, PublicKey publicKey, ExtendedPKIXParameters extendedPKIXParameters, List list) throws AnnotatedException {
        int i;
        X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
        try {
            x509CertStoreSelector.setSubject(CertPathValidatorUtilities.getIssuerPrincipal(x509crl).getEncoded());
            try {
                Collection findCertificates = CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getStores());
                findCertificates.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getAdditionalStores()));
                findCertificates.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getCertStores()));
                findCertificates.add(x509Certificate);
                Iterator it = findCertificates.iterator();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        arrayList.add(x509Certificate2);
                        arrayList2.add(publicKey);
                    } else {
                        try {
                            CertPathBuilder instance = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME);
                            X509CertStoreSelector x509CertStoreSelector2 = new X509CertStoreSelector();
                            x509CertStoreSelector2.setCertificate(x509Certificate2);
                            ExtendedPKIXParameters extendedPKIXParameters2 = (ExtendedPKIXParameters) extendedPKIXParameters.clone();
                            extendedPKIXParameters2.setTargetCertConstraints(x509CertStoreSelector2);
                            ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) ExtendedPKIXBuilderParameters.getInstance(extendedPKIXParameters2);
                            if (list.contains(x509Certificate2)) {
                                extendedPKIXBuilderParameters.setRevocationEnabled(false);
                            } else {
                                extendedPKIXBuilderParameters.setRevocationEnabled(true);
                            }
                            List<? extends Certificate> certificates = instance.build(extendedPKIXBuilderParameters).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(CertPathValidatorUtilities.getNextWorkingKey(certificates, 0));
                        } catch (CertPathBuilderException e) {
                            throw new AnnotatedException("Internal error.", e);
                        } catch (CertPathValidatorException e2) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e2);
                        } catch (Exception e3) {
                            throw new RuntimeException(e3.getMessage());
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                AnnotatedException annotatedException = null;
                for (i = 0; i < arrayList.size(); i++) {
                    boolean[] keyUsage = ((X509Certificate) arrayList.get(i)).getKeyUsage();
                    if (keyUsage == null || (keyUsage.length >= 7 && keyUsage[6])) {
                        hashSet.add(arrayList2.get(i));
                    } else {
                        annotatedException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                }
                if (hashSet.isEmpty() && annotatedException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.");
                } else if (!hashSet.isEmpty() || annotatedException == null) {
                    return hashSet;
                } else {
                    throw annotatedException;
                }
            } catch (AnnotatedException e4) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e4);
            }
        } catch (IOException e5) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e5);
        }
    }

    protected static PublicKey processCRLG(X509CRL x509crl, Set set) throws AnnotatedException {
        Iterator it = set.iterator();
        Exception e = null;
        while (it.hasNext()) {
            PublicKey publicKey = (PublicKey) it.next();
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e2) {
                e = e2;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", e);
    }

    protected static X509CRL processCRLH(Set set, PublicKey publicKey) throws AnnotatedException {
        Iterator it = set.iterator();
        Exception e = null;
        while (it.hasNext()) {
            X509CRL x509crl = (X509CRL) it.next();
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", e);
    }

    protected static Set processCRLA1i(Date date, ExtendedPKIXParameters extendedPKIXParameters, X509Certificate x509Certificate, X509CRL x509crl) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        if (extendedPKIXParameters.isUseDeltasEnabled()) {
            try {
                CRLDistPoint instance = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, FRESHEST_CRL));
                if (instance == null) {
                    try {
                        instance = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, FRESHEST_CRL));
                    } catch (AnnotatedException e) {
                        throw new AnnotatedException("Freshest CRL extension could not be decoded from CRL.", e);
                    }
                }
                if (instance != null) {
                    try {
                        CertPathValidatorUtilities.addAdditionalStoresFromCRLDistributionPoint(instance, extendedPKIXParameters);
                        try {
                            hashSet.addAll(CertPathValidatorUtilities.getDeltaCRLs(date, extendedPKIXParameters, x509crl));
                        } catch (AnnotatedException e2) {
                            throw new AnnotatedException("Exception obtaining delta CRLs.", e2);
                        }
                    } catch (AnnotatedException e3) {
                        throw new AnnotatedException("No new delta CRL locations could be added from Freshest CRL extension.", e3);
                    }
                }
            } catch (AnnotatedException e4) {
                throw new AnnotatedException("Freshest CRL extension could not be decoded from certificate.", e4);
            }
        }
        return hashSet;
    }

    protected static Set[] processCRLA1ii(Date date, ExtendedPKIXParameters extendedPKIXParameters, X509Certificate x509Certificate, X509CRL x509crl) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        x509CRLStoreSelector.setCertificateChecking(x509Certificate);
        try {
            x509CRLStoreSelector.addIssuerName(x509crl.getIssuerX500Principal().getEncoded());
            x509CRLStoreSelector.setCompleteCRLEnabled(true);
            Set findCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, extendedPKIXParameters, date);
            if (extendedPKIXParameters.isUseDeltasEnabled()) {
                try {
                    hashSet.addAll(CertPathValidatorUtilities.getDeltaCRLs(date, extendedPKIXParameters, x509crl));
                } catch (AnnotatedException e) {
                    throw new AnnotatedException("Exception obtaining delta CRLs.", e);
                }
            }
            return new Set[]{findCRLs, hashSet};
        } catch (IOException e2) {
            throw new AnnotatedException("Cannot extract issuer from CRL." + e2, e2);
        }
    }

    protected static void processCRLC(X509CRL x509crl, X509CRL x509crl2, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        if (x509crl != null) {
            try {
                IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl2, ISSUING_DISTRIBUTION_POINT));
                if (!extendedPKIXParameters.isUseDeltasEnabled()) {
                    return;
                }
                if (x509crl.getIssuerX500Principal().equals(x509crl2.getIssuerX500Principal())) {
                    try {
                        IssuingDistributionPoint instance2 = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
                        boolean z = true;
                        if (instance != null ? !instance.equals(instance2) : instance2 != null) {
                            z = false;
                        }
                        if (z) {
                            try {
                                DERObject extensionValue = CertPathValidatorUtilities.getExtensionValue(x509crl2, AUTHORITY_KEY_IDENTIFIER);
                                try {
                                    DERObject extensionValue2 = CertPathValidatorUtilities.getExtensionValue(x509crl, AUTHORITY_KEY_IDENTIFIER);
                                    if (extensionValue == null) {
                                        throw new AnnotatedException("CRL authority key identifier is null.");
                                    } else if (extensionValue2 == null) {
                                        throw new AnnotatedException("Delta CRL authority key identifier is null.");
                                    } else if (!extensionValue.equals(extensionValue2)) {
                                        throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                                    }
                                } catch (AnnotatedException e) {
                                    throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e);
                                }
                            } catch (AnnotatedException e2) {
                                throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e2);
                            }
                        } else {
                            throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                        }
                    } catch (Exception e3) {
                        throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e3);
                    }
                } else {
                    throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
                }
            } catch (Exception e4) {
                throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e4);
            }
        }
    }

    protected static void processCRLI(Date date, X509CRL x509crl, Object obj, CertStatus certStatus, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        if (extendedPKIXParameters.isUseDeltasEnabled() && x509crl != null) {
            CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
        }
    }

    protected static void processCRLJ(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        if (certStatus.getCertStatus() == 11) {
            CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
        }
    }

    protected static PKIXPolicyNode prepareCertB(CertPath certPath, int i, List[] listArr, PKIXPolicyNode pKIXPolicyNode, int i2) throws CertPathValidatorException {
        boolean z;
        CertPath certPath2 = certPath;
        int i3 = i;
        List[] listArr2 = listArr;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i3);
        int size = certificates.size() - i3;
        try {
            ASN1Sequence instance = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, POLICY_MAPPINGS));
            if (instance == null) {
                return pKIXPolicyNode;
            }
            HashMap hashMap = new HashMap();
            HashSet<String> hashSet = new HashSet<>();
            for (int i4 = 0; i4 < instance.size(); i4++) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) instance.getObjectAt(i4);
                String id = ((DERObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId();
                String id2 = ((DERObjectIdentifier) aSN1Sequence.getObjectAt(1)).getId();
                if (!hashMap.containsKey(id)) {
                    HashSet hashSet2 = new HashSet();
                    hashSet2.add(id2);
                    hashMap.put(id, hashSet2);
                    hashSet.add(id);
                } else {
                    ((Set) hashMap.get(id)).add(id2);
                }
            }
            PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
            for (String str : hashSet) {
                if (i2 > 0) {
                    Iterator it = listArr2[size].iterator();
                    while (true) {
                        if (it.hasNext()) {
                            PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) it.next();
                            if (pKIXPolicyNode3.getValidPolicy().equals(str)) {
                                pKIXPolicyNode3.expectedPolicies = (Set) hashMap.get(str);
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        Iterator it2 = listArr2[size].iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) it2.next();
                            if (ANY_POLICY.equals(pKIXPolicyNode4.getValidPolicy())) {
                                Set set = null;
                                try {
                                    Enumeration objects = ((ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CERTIFICATE_POLICIES)).getObjects();
                                    while (true) {
                                        if (!objects.hasMoreElements()) {
                                            break;
                                        }
                                        try {
                                            PolicyInformation instance2 = PolicyInformation.getInstance(objects.nextElement());
                                            if (ANY_POLICY.equals(instance2.getPolicyIdentifier().getId())) {
                                                try {
                                                    set = CertPathValidatorUtilities.getQualifierSet(instance2.getPolicyQualifiers());
                                                    break;
                                                } catch (CertPathValidatorException e) {
                                                    throw new ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", e, certPath2, i3);
                                                }
                                            }
                                        } catch (Exception e2) {
                                            throw new CertPathValidatorException("Policy information could not be decoded.", e2, certPath2, i3);
                                        }
                                    }
                                    Set set2 = set;
                                    boolean contains = x509Certificate.getCriticalExtensionOIDs() != null ? x509Certificate.getCriticalExtensionOIDs().contains(CERTIFICATE_POLICIES) : false;
                                    PKIXPolicyNode pKIXPolicyNode5 = (PKIXPolicyNode) pKIXPolicyNode4.getParent();
                                    if (ANY_POLICY.equals(pKIXPolicyNode5.getValidPolicy())) {
                                        PKIXPolicyNode pKIXPolicyNode6 = r5;
                                        PKIXPolicyNode pKIXPolicyNode7 = new PKIXPolicyNode(new ArrayList(), size, (Set) hashMap.get(str), pKIXPolicyNode5, set2, str, contains);
                                        pKIXPolicyNode5.addChild(pKIXPolicyNode6);
                                        listArr2[size].add(pKIXPolicyNode6);
                                    }
                                } catch (AnnotatedException e3) {
                                    throw new ExtCertPathValidatorException("Certificate policies extension could not be decoded.", e3, certPath2, i3);
                                }
                            }
                        }
                    }
                } else if (i2 <= 0) {
                    Iterator it3 = listArr2[size].iterator();
                    while (it3.hasNext()) {
                        PKIXPolicyNode pKIXPolicyNode8 = (PKIXPolicyNode) it3.next();
                        if (pKIXPolicyNode8.getValidPolicy().equals(str)) {
                            ((PKIXPolicyNode) pKIXPolicyNode8.getParent()).removeChild(pKIXPolicyNode8);
                            it3.remove();
                            for (int i5 = size - 1; i5 >= 0; i5--) {
                                List list = listArr2[i5];
                                PKIXPolicyNode pKIXPolicyNode9 = pKIXPolicyNode2;
                                for (int i6 = 0; i6 < list.size(); i6++) {
                                    PKIXPolicyNode pKIXPolicyNode10 = (PKIXPolicyNode) list.get(i6);
                                    if (!pKIXPolicyNode10.hasChildren() && (pKIXPolicyNode9 = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode9, listArr2, pKIXPolicyNode10)) == null) {
                                        break;
                                    }
                                }
                                pKIXPolicyNode2 = pKIXPolicyNode9;
                            }
                        }
                    }
                }
            }
            return pKIXPolicyNode2;
        } catch (AnnotatedException e4) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e4, certPath2, i3);
        }
    }

    protected static void prepareNextCertA(CertPath certPath, int i) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_MAPPINGS));
            if (instance != null) {
                int i2 = 0;
                while (i2 < instance.size()) {
                    try {
                        ASN1Sequence instance2 = DERSequence.getInstance(instance.getObjectAt(i2));
                        DERObjectIdentifier instance3 = DERObjectIdentifier.getInstance(instance2.getObjectAt(0));
                        DERObjectIdentifier instance4 = DERObjectIdentifier.getInstance(instance2.getObjectAt(1));
                        if (ANY_POLICY.equals(instance3.getId())) {
                            throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", (Throwable) null, certPath, i);
                        } else if (!ANY_POLICY.equals(instance4.getId())) {
                            i2++;
                        } else {
                            throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy,", (Throwable) null, certPath, i);
                        }
                    } catch (Exception e) {
                        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e, certPath, i);
                    }
                }
            }
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e2, certPath, i);
        }
    }

    protected static void processCertF(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode, int i2) throws CertPathValidatorException {
        if (i2 <= 0 && pKIXPolicyNode == null) {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", (Throwable) null, certPath, i);
        }
    }

    protected static PKIXPolicyNode processCertE(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode) throws CertPathValidatorException {
        try {
            if (DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), CERTIFICATE_POLICIES)) == null) {
                return null;
            }
            return pKIXPolicyNode;
        } catch (AnnotatedException e) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e, certPath, i);
        }
    }

    protected static void processCertBC(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator) throws CertPathValidatorException {
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i);
        int size = certificates.size();
        int i2 = size - i;
        if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate) || i2 >= size) {
            try {
                ASN1Sequence instance = DERSequence.getInstance(new ASN1InputStream(CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate).getEncoded()).readObject());
                try {
                    pKIXNameConstraintValidator.checkPermittedDN(instance);
                    pKIXNameConstraintValidator.checkExcludedDN(instance);
                    try {
                        GeneralNames instance2 = GeneralNames.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME));
                        Enumeration elements = new X509Name(instance).getValues(X509Name.EmailAddress).elements();
                        while (elements.hasMoreElements()) {
                            GeneralName generalName = new GeneralName(1, (String) elements.nextElement());
                            try {
                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                pKIXNameConstraintValidator.checkExcluded(generalName);
                            } catch (PKIXNameConstraintValidatorException e) {
                                throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", e, certPath, i);
                            }
                        }
                        if (instance2 != null) {
                            try {
                                GeneralName[] names = instance2.getNames();
                                int i3 = 0;
                                while (i3 < names.length) {
                                    try {
                                        pKIXNameConstraintValidator.checkPermitted(names[i3]);
                                        pKIXNameConstraintValidator.checkExcluded(names[i3]);
                                        i3++;
                                    } catch (PKIXNameConstraintValidatorException e2) {
                                        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", e2, certPath, i);
                                    }
                                }
                            } catch (Exception e3) {
                                throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", e3, certPath, i);
                            }
                        }
                    } catch (Exception e4) {
                        throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", e4, certPath, i);
                    }
                } catch (PKIXNameConstraintValidatorException e5) {
                    throw new CertPathValidatorException("Subtree check for certificate subject failed.", e5, certPath, i);
                }
            } catch (Exception e6) {
                throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", e6, certPath, i);
            }
        }
    }

    protected static PKIXPolicyNode processCertD(CertPath certPath, int i, Set set, PKIXPolicyNode pKIXPolicyNode, List[] listArr, int i2) throws CertPathValidatorException {
        String id;
        CertPath certPath2 = certPath;
        int i3 = i;
        Set set2 = set;
        List[] listArr2 = listArr;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i3);
        int size = certificates.size();
        int i4 = size - i3;
        try {
            ASN1Sequence instance = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CERTIFICATE_POLICIES));
            if (instance == null || pKIXPolicyNode == null) {
                return null;
            }
            Enumeration objects = instance.getObjects();
            HashSet hashSet = new HashSet();
            while (objects.hasMoreElements()) {
                PolicyInformation instance2 = PolicyInformation.getInstance(objects.nextElement());
                DERObjectIdentifier policyIdentifier = instance2.getPolicyIdentifier();
                hashSet.add(policyIdentifier.getId());
                if (!ANY_POLICY.equals(policyIdentifier.getId())) {
                    try {
                        Set qualifierSet = CertPathValidatorUtilities.getQualifierSet(instance2.getPolicyQualifiers());
                        if (!CertPathValidatorUtilities.processCertD1i(i4, listArr2, policyIdentifier, qualifierSet)) {
                            CertPathValidatorUtilities.processCertD1ii(i4, listArr2, policyIdentifier, qualifierSet);
                        }
                    } catch (CertPathValidatorException e) {
                        throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", e, certPath2, i3);
                    }
                }
            }
            if (set.isEmpty() || set2.contains(ANY_POLICY)) {
                set.clear();
                set2.addAll(hashSet);
            } else {
                HashSet hashSet2 = new HashSet();
                for (Object next : set) {
                    if (hashSet.contains(next)) {
                        hashSet2.add(next);
                    }
                }
                set.clear();
                set2.addAll(hashSet2);
            }
            if (i2 > 0 || (i4 < size && CertPathValidatorUtilities.isSelfIssued(x509Certificate))) {
                Enumeration objects2 = instance.getObjects();
                while (true) {
                    if (!objects2.hasMoreElements()) {
                        break;
                    }
                    PolicyInformation instance3 = PolicyInformation.getInstance(objects2.nextElement());
                    if (ANY_POLICY.equals(instance3.getPolicyIdentifier().getId())) {
                        Set qualifierSet2 = CertPathValidatorUtilities.getQualifierSet(instance3.getPolicyQualifiers());
                        List list = listArr2[i4 - 1];
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(i5);
                            for (Object next2 : pKIXPolicyNode2.getExpectedPolicies()) {
                                if (next2 instanceof String) {
                                    id = (String) next2;
                                } else if (next2 instanceof DERObjectIdentifier) {
                                    id = ((DERObjectIdentifier) next2).getId();
                                }
                                String str = id;
                                Iterator children = pKIXPolicyNode2.getChildren();
                                boolean z = false;
                                while (children.hasNext()) {
                                    if (str.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    HashSet hashSet3 = new HashSet();
                                    hashSet3.add(str);
                                    PKIXPolicyNode pKIXPolicyNode3 = r6;
                                    PKIXPolicyNode pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), i4, hashSet3, pKIXPolicyNode2, qualifierSet2, str, false);
                                    pKIXPolicyNode2.addChild(pKIXPolicyNode3);
                                    listArr2[i4].add(pKIXPolicyNode3);
                                }
                            }
                        }
                    }
                }
            }
            PKIXPolicyNode pKIXPolicyNode5 = pKIXPolicyNode;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                List list2 = listArr2[i6];
                PKIXPolicyNode pKIXPolicyNode6 = pKIXPolicyNode5;
                for (int i7 = 0; i7 < list2.size(); i7++) {
                    PKIXPolicyNode pKIXPolicyNode7 = (PKIXPolicyNode) list2.get(i7);
                    if (!pKIXPolicyNode7.hasChildren() && (pKIXPolicyNode6 = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode6, listArr2, pKIXPolicyNode7)) == null) {
                        break;
                    }
                }
                pKIXPolicyNode5 = pKIXPolicyNode6;
            }
            Set criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null) {
                boolean contains = criticalExtensionOIDs.contains(CERTIFICATE_POLICIES);
                List list3 = listArr2[i4];
                for (int i8 = 0; i8 < list3.size(); i8++) {
                    ((PKIXPolicyNode) list3.get(i8)).setCritical(contains);
                }
            }
            return pKIXPolicyNode5;
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e2, certPath2, i3);
        }
    }

    protected static void processCertA(CertPath certPath, ExtendedPKIXParameters extendedPKIXParameters, int i, PublicKey publicKey, boolean z, X500Principal x500Principal, X509Certificate x509Certificate) throws ExtCertPathValidatorException {
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate2 = (X509Certificate) certificates.get(i);
        if (!z) {
            try {
                CertPathValidatorUtilities.verifyX509Certificate(x509Certificate2, publicKey, extendedPKIXParameters.getSigProvider());
            } catch (GeneralSecurityException e) {
                throw new ExtCertPathValidatorException("Could not validate certificate signature.", e, certPath, i);
            }
        }
        try {
            x509Certificate2.checkValidity(CertPathValidatorUtilities.getValidCertDateFromValidityModel(extendedPKIXParameters, certPath, i));
            if (extendedPKIXParameters.isRevocationEnabled()) {
                try {
                    checkCRLs(extendedPKIXParameters, x509Certificate2, CertPathValidatorUtilities.getValidCertDateFromValidityModel(extendedPKIXParameters, certPath, i), x509Certificate, publicKey, certificates);
                } catch (AnnotatedException e2) {
                    throw new ExtCertPathValidatorException(e2.getMessage(), e2.getCause() != null ? e2.getCause() : e2, certPath, i);
                }
            }
            if (!CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate2).equals(x500Principal)) {
                throw new ExtCertPathValidatorException("IssuerName(" + CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate2) + ") does not match SubjectName(" + x500Principal + ") of signing certificate.", (Throwable) null, certPath, i);
            }
        } catch (CertificateExpiredException e3) {
            throw new ExtCertPathValidatorException("Could not validate certificate: " + e3.getMessage(), e3, certPath, i);
        } catch (CertificateNotYetValidException e4) {
            throw new ExtCertPathValidatorException("Could not validate certificate: " + e4.getMessage(), e4, certPath, i);
        } catch (AnnotatedException e5) {
            throw new ExtCertPathValidatorException("Could not validate time of certificate.", e5, certPath, i);
        }
    }

    protected static int prepareNextCertI1(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_CONSTRAINTS));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (instance2.getTagNo() == 0) {
                            int intValue = DERInteger.getInstance(instance2, false).getValue().intValue();
                            if (intValue < i2) {
                                return intValue;
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e, certPath, i);
                    }
                }
            }
            return i2;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e2, certPath, i);
        }
    }

    protected static int prepareNextCertI2(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_CONSTRAINTS));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (instance2.getTagNo() == 1) {
                            int intValue = DERInteger.getInstance(instance2, false).getValue().intValue();
                            if (intValue < i2) {
                                return intValue;
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e, certPath, i);
                    }
                }
            }
            return i2;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e2, certPath, i);
        }
    }

    protected static void prepareNextCertG(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), NAME_CONSTRAINTS));
            NameConstraints nameConstraints = instance != null ? new NameConstraints(instance) : null;
            if (nameConstraints != null) {
                ASN1Sequence permittedSubtrees = nameConstraints.getPermittedSubtrees();
                if (permittedSubtrees != null) {
                    try {
                        pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                    } catch (Exception e) {
                        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", e, certPath, i);
                    }
                }
                ASN1Sequence excludedSubtrees = nameConstraints.getExcludedSubtrees();
                if (excludedSubtrees != null) {
                    Enumeration objects = excludedSubtrees.getObjects();
                    while (objects.hasMoreElements()) {
                        try {
                            pKIXNameConstraintValidator.addExcludedSubtree(GeneralSubtree.getInstance(objects.nextElement()));
                        } catch (Exception e2) {
                            throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", e2, certPath, i);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e3, certPath, i);
        }
    }

    private static void checkCRL(DistributionPoint distributionPoint, ExtendedPKIXParameters extendedPKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, CertStatus certStatus, ReasonsMask reasonsMask, List list) throws AnnotatedException {
        Iterator it;
        X509CRL x509crl;
        Set criticalExtensionOIDs;
        DistributionPoint distributionPoint2 = distributionPoint;
        ExtendedPKIXParameters extendedPKIXParameters2 = extendedPKIXParameters;
        X509Certificate x509Certificate3 = x509Certificate;
        Date date2 = date;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        Date date3 = new Date(System.currentTimeMillis());
        if (date.getTime() <= date3.getTime()) {
            Iterator it2 = CertPathValidatorUtilities.getCompleteCRLs(distributionPoint2, x509Certificate3, date3, extendedPKIXParameters2).iterator();
            e = null;
            boolean z = false;
            while (it2.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
                try {
                    X509CRL x509crl2 = (X509CRL) it2.next();
                    ReasonsMask processCRLD = processCRLD(x509crl2, distributionPoint2);
                    if (!processCRLD.hasNewReasons(reasonsMask2)) {
                        continue;
                    } else {
                        ReasonsMask reasonsMask3 = processCRLD;
                        X509CRL x509crl3 = x509crl2;
                        it = it2;
                        try {
                            PublicKey processCRLG = processCRLG(x509crl3, processCRLF(x509crl2, x509Certificate, x509Certificate2, publicKey, extendedPKIXParameters, list));
                            if (extendedPKIXParameters.isUseDeltasEnabled()) {
                                x509crl = processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date3, extendedPKIXParameters2, x509crl3), processCRLG);
                            } else {
                                x509crl = null;
                            }
                            if (extendedPKIXParameters.getValidityModel() != 1) {
                                try {
                                    if (x509Certificate.getNotAfter().getTime() < x509crl3.getThisUpdate().getTime()) {
                                        throw new AnnotatedException("No valid CRL for current time found.");
                                    }
                                } catch (AnnotatedException e) {
                                    e = e;
                                    it2 = it;
                                }
                            }
                            processCRLB1(distributionPoint2, x509Certificate3, x509crl3);
                            processCRLB2(distributionPoint2, x509Certificate3, x509crl3);
                            processCRLC(x509crl, x509crl3, extendedPKIXParameters2);
                            processCRLI(date2, x509crl, x509Certificate3, certStatus2, extendedPKIXParameters2);
                            processCRLJ(date2, x509crl3, x509Certificate3, certStatus2);
                            if (certStatus.getCertStatus() == 8) {
                                certStatus2.setCertStatus(11);
                            }
                            reasonsMask2.addReasons(reasonsMask3);
                            Set criticalExtensionOIDs2 = x509crl3.getCriticalExtensionOIDs();
                            if (criticalExtensionOIDs2 != null) {
                                HashSet hashSet = new HashSet(criticalExtensionOIDs2);
                                hashSet.remove(X509Extensions.IssuingDistributionPoint.getId());
                                hashSet.remove(X509Extensions.DeltaCRLIndicator.getId());
                                if (!hashSet.isEmpty()) {
                                    throw new AnnotatedException("CRL contains unsupported critical extensions.");
                                }
                            }
                            if (!(x509crl == null || (criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs()) == null)) {
                                HashSet hashSet2 = new HashSet(criticalExtensionOIDs);
                                hashSet2.remove(X509Extensions.IssuingDistributionPoint.getId());
                                hashSet2.remove(X509Extensions.DeltaCRLIndicator.getId());
                                if (!hashSet2.isEmpty()) {
                                    throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
                                }
                            }
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

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void checkCRLs(repack.org.bouncycastle.x509.ExtendedPKIXParameters r19, java.security.cert.X509Certificate r20, java.util.Date r21, java.security.cert.X509Certificate r22, java.security.PublicKey r23, java.util.List r24) throws repack.org.bouncycastle.jce.provider.AnnotatedException {
        /*
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS     // Catch:{ Exception -> 0x014c }
            r10 = r20
            repack.org.bouncycastle.asn1.DERObject r0 = repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r10, r0)     // Catch:{ Exception -> 0x014c }
            repack.org.bouncycastle.asn1.x509.CRLDistPoint r0 = repack.org.bouncycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ Exception -> 0x014c }
            r11 = r19
            repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.addAdditionalStoresFromCRLDistributionPoint(r0, r11)     // Catch:{ AnnotatedException -> 0x0142 }
            repack.org.bouncycastle.jce.provider.CertStatus r12 = new repack.org.bouncycastle.jce.provider.CertStatus
            r12.<init>()
            repack.org.bouncycastle.jce.provider.ReasonsMask r13 = new repack.org.bouncycastle.jce.provider.ReasonsMask
            r13.<init>()
            r15 = 0
            r9 = 0
            r8 = 11
            if (r0 == 0) goto L_0x007a
            repack.org.bouncycastle.asn1.x509.DistributionPoint[] r7 = r0.getDistributionPoints()     // Catch:{ Exception -> 0x0070 }
            if (r7 == 0) goto L_0x007a
            r0 = r9
            r6 = 0
            r16 = 0
        L_0x002b:
            int r1 = r7.length
            if (r6 >= r1) goto L_0x006d
            int r1 = r12.getCertStatus()
            if (r1 != r8) goto L_0x006d
            boolean r1 = r13.isAllReasons()
            if (r1 == 0) goto L_0x003b
            goto L_0x006d
        L_0x003b:
            java.lang.Object r1 = r19.clone()
            r2 = r1
            repack.org.bouncycastle.x509.ExtendedPKIXParameters r2 = (repack.org.bouncycastle.x509.ExtendedPKIXParameters) r2
            r1 = r7[r6]     // Catch:{ AnnotatedException -> 0x005e }
            r3 = r20
            r4 = r21
            r5 = r22
            r17 = r6
            r6 = r23
            r18 = r7
            r7 = r12
            r14 = 11
            r8 = r13
            r9 = r24
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ AnnotatedException -> 0x005c }
            r16 = 1
            goto L_0x0065
        L_0x005c:
            r0 = move-exception
            goto L_0x0065
        L_0x005e:
            r0 = move-exception
            r17 = r6
            r18 = r7
            r14 = 11
        L_0x0065:
            int r6 = r17 + 1
            r7 = r18
            r8 = 11
            r9 = 0
            goto L_0x002b
        L_0x006d:
            r14 = 11
            goto L_0x007f
        L_0x0070:
            r0 = move-exception
            r1 = r0
            repack.org.bouncycastle.jce.provider.AnnotatedException r0 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "Distribution points could not be read."
            r0.<init>(r2, r1)
            throw r0
        L_0x007a:
            r14 = 11
            r0 = 0
            r16 = 0
        L_0x007f:
            int r1 = r12.getCertStatus()
            if (r1 != r14) goto L_0x00d8
            boolean r1 = r13.isAllReasons()
            if (r1 != 0) goto L_0x00d8
            repack.org.bouncycastle.asn1.ASN1InputStream r1 = new repack.org.bouncycastle.asn1.ASN1InputStream     // Catch:{ Exception -> 0x00cf }
            javax.security.auth.x500.X500Principal r2 = repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getEncodedIssuerPrincipal(r20)     // Catch:{ Exception -> 0x00cf }
            byte[] r2 = r2.getEncoded()     // Catch:{ Exception -> 0x00cf }
            r1.<init>((byte[]) r2)     // Catch:{ Exception -> 0x00cf }
            repack.org.bouncycastle.asn1.DERObject r1 = r1.readObject()     // Catch:{ Exception -> 0x00cf }
            repack.org.bouncycastle.asn1.x509.DistributionPoint r2 = new repack.org.bouncycastle.asn1.x509.DistributionPoint     // Catch:{ AnnotatedException -> 0x00cd }
            repack.org.bouncycastle.asn1.x509.DistributionPointName r3 = new repack.org.bouncycastle.asn1.x509.DistributionPointName     // Catch:{ AnnotatedException -> 0x00cd }
            repack.org.bouncycastle.asn1.x509.GeneralNames r4 = new repack.org.bouncycastle.asn1.x509.GeneralNames     // Catch:{ AnnotatedException -> 0x00cd }
            repack.org.bouncycastle.asn1.x509.GeneralName r5 = new repack.org.bouncycastle.asn1.x509.GeneralName     // Catch:{ AnnotatedException -> 0x00cd }
            r6 = 4
            r5.<init>((int) r6, (repack.org.bouncycastle.asn1.ASN1Encodable) r1)     // Catch:{ AnnotatedException -> 0x00cd }
            r4.<init>((repack.org.bouncycastle.asn1.x509.GeneralName) r5)     // Catch:{ AnnotatedException -> 0x00cd }
            r3.<init>((int) r15, (repack.org.bouncycastle.asn1.ASN1Encodable) r4)     // Catch:{ AnnotatedException -> 0x00cd }
            r1 = 0
            r2.<init>(r3, r1, r1)     // Catch:{ AnnotatedException -> 0x00cd }
            java.lang.Object r1 = r19.clone()     // Catch:{ AnnotatedException -> 0x00cd }
            r3 = r1
            repack.org.bouncycastle.x509.ExtendedPKIXParameters r3 = (repack.org.bouncycastle.x509.ExtendedPKIXParameters) r3     // Catch:{ AnnotatedException -> 0x00cd }
            r1 = r2
            r2 = r3
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r12
            r8 = r13
            r9 = r24
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ AnnotatedException -> 0x00cd }
            r16 = 1
            goto L_0x00d8
        L_0x00cd:
            r0 = move-exception
            goto L_0x00d8
        L_0x00cf:
            r0 = move-exception
            repack.org.bouncycastle.jce.provider.AnnotatedException r1 = new repack.org.bouncycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00cd }
            java.lang.String r2 = "Issuer from certificate for CRL could not be reencoded."
            r1.<init>(r2, r0)     // Catch:{ AnnotatedException -> 0x00cd }
            throw r1     // Catch:{ AnnotatedException -> 0x00cd }
        L_0x00d8:
            if (r16 != 0) goto L_0x00e7
            boolean r1 = r0 instanceof repack.org.bouncycastle.jce.provider.AnnotatedException
            if (r1 == 0) goto L_0x00df
            throw r0
        L_0x00df:
            repack.org.bouncycastle.jce.provider.AnnotatedException r1 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "No valid CRL found."
            r1.<init>(r2, r0)
            throw r1
        L_0x00e7:
            int r0 = r12.getCertStatus()
            if (r0 != r14) goto L_0x010d
            boolean r0 = r13.isAllReasons()
            r1 = 12
            if (r0 != 0) goto L_0x00fe
            int r0 = r12.getCertStatus()
            if (r0 != r14) goto L_0x00fe
            r12.setCertStatus(r1)
        L_0x00fe:
            int r0 = r12.getCertStatus()
            if (r0 == r1) goto L_0x0105
            return
        L_0x0105:
            repack.org.bouncycastle.jce.provider.AnnotatedException r0 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r1 = "Certificate status could not be determined."
            r0.<init>(r1)
            throw r0
        L_0x010d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Certificate revocation after "
            r0.<init>(r1)
            java.util.Date r1 = r12.getRevocationDate()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r0)
            java.lang.String r0 = ", reason: "
            r1.append(r0)
            java.lang.String[] r0 = crlReasons
            int r2 = r12.getCertStatus()
            r0 = r0[r2]
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            repack.org.bouncycastle.jce.provider.AnnotatedException r1 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            r1.<init>(r0)
            throw r1
        L_0x0142:
            r0 = move-exception
            r1 = r0
            repack.org.bouncycastle.jce.provider.AnnotatedException r0 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "No additional CRL locations could be decoded from CRL distribution point extension."
            r0.<init>(r2, r1)
            throw r0
        L_0x014c:
            r0 = move-exception
            repack.org.bouncycastle.jce.provider.AnnotatedException r1 = new repack.org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "CRL distribution point extension could not be read."
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.checkCRLs(repack.org.bouncycastle.x509.ExtendedPKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r2 = r2.getValue().intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int prepareNextCertJ(java.security.cert.CertPath r2, int r3, int r4) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r2.getCertificates()
            java.lang.Object r0 = r0.get(r3)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = INHIBIT_ANY_POLICY     // Catch:{ Exception -> 0x0022 }
            repack.org.bouncycastle.asn1.DERObject r0 = repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r0, r1)     // Catch:{ Exception -> 0x0022 }
            repack.org.bouncycastle.asn1.DERInteger r2 = repack.org.bouncycastle.asn1.DERInteger.getInstance(r0)     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0021
            java.math.BigInteger r2 = r2.getValue()
            int r2 = r2.intValue()
            if (r2 >= r4) goto L_0x0021
            return r2
        L_0x0021:
            return r4
        L_0x0022:
            r4 = move-exception
            repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Inhibit any-policy extension cannot be decoded."
            r0.<init>(r1, r4, r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertJ(java.security.cert.CertPath, int, int):int");
    }

    protected static void prepareNextCertK(CertPath certPath, int i) throws CertPathValidatorException {
        try {
            BasicConstraints instance = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), BASIC_CONSTRAINTS));
            if (instance == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints");
            } else if (!instance.isCA()) {
                throw new CertPathValidatorException("Not a CA certificate");
            }
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, certPath, i);
        }
    }

    protected static int prepareNextCertL(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i))) {
            return i2;
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", (Throwable) null, certPath, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r2 = (r2 = r2.getPathLenConstraint()).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int prepareNextCertM(java.security.cert.CertPath r2, int r3, int r4) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r2.getCertificates()
            java.lang.Object r0 = r0.get(r3)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = BASIC_CONSTRAINTS     // Catch:{ Exception -> 0x0024 }
            repack.org.bouncycastle.asn1.DERObject r0 = repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r0, r1)     // Catch:{ Exception -> 0x0024 }
            repack.org.bouncycastle.asn1.x509.BasicConstraints r2 = repack.org.bouncycastle.asn1.x509.BasicConstraints.getInstance(r0)     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x0023
            java.math.BigInteger r2 = r2.getPathLenConstraint()
            if (r2 == 0) goto L_0x0023
            int r2 = r2.intValue()
            if (r2 >= r4) goto L_0x0023
            return r2
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new repack.org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Basic constraints extension cannot be decoded."
            r0.<init>(r1, r4, r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertM(java.security.cert.CertPath, int, int):int");
    }

    protected static void prepareNextCertN(CertPath certPath, int i) throws CertPathValidatorException {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i)).getKeyUsage();
        if (keyUsage != null && !keyUsage[5]) {
            throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", (Throwable) null, certPath, i);
        }
    }

    protected static void prepareNextCertO(CertPath certPath, int i, Set set, List list) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e) {
                throw new CertPathValidatorException(e.getMessage(), e.getCause(), certPath, i);
            }
        }
        if (!set.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension.", (Throwable) null, certPath, i);
        }
    }

    protected static int prepareNextCertH1(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    protected static int prepareNextCertH2(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    protected static int prepareNextCertH3(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    protected static int wrapupCertA(int i, X509Certificate x509Certificate) {
        return (CertPathValidatorUtilities.isSelfIssued(x509Certificate) || i == 0) ? i : i - 1;
    }

    protected static int wrapupCertB(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_CONSTRAINTS));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (objects.hasMoreElements()) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
                    if (aSN1TaggedObject.getTagNo() == 0) {
                        try {
                            if (DERInteger.getInstance(aSN1TaggedObject, false).getValue().intValue() == 0) {
                                return 0;
                            }
                        } catch (Exception e) {
                            throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", e, certPath, i);
                        }
                    }
                }
            }
            return i2;
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", e2, certPath, i);
        }
    }

    protected static void wrapupCertF(CertPath certPath, int i, List list, Set set) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e) {
                throw new ExtCertPathValidatorException("Additional certificate path checker failed.", e, certPath, i);
            }
        }
        if (!set.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension", (Throwable) null, certPath, i);
        }
    }

    protected static PKIXPolicyNode wrapupCertG(CertPath certPath, ExtendedPKIXParameters extendedPKIXParameters, Set set, int i, List[] listArr, PKIXPolicyNode pKIXPolicyNode, Set set2) throws CertPathValidatorException {
        int size = certPath.getCertificates().size();
        if (pKIXPolicyNode != null) {
            if (!CertPathValidatorUtilities.isAnyPolicy(set)) {
                HashSet<PKIXPolicyNode> hashSet = new HashSet<>();
                for (List list : listArr) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(i2);
                        if (ANY_POLICY.equals(pKIXPolicyNode2.getValidPolicy())) {
                            Iterator children = pKIXPolicyNode2.getChildren();
                            while (children.hasNext()) {
                                PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) children.next();
                                if (!ANY_POLICY.equals(pKIXPolicyNode3.getValidPolicy())) {
                                    hashSet.add(pKIXPolicyNode3);
                                }
                            }
                        }
                    }
                }
                for (PKIXPolicyNode pKIXPolicyNode4 : hashSet) {
                    if (!set.contains(pKIXPolicyNode4.getValidPolicy())) {
                        pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode4);
                    }
                }
                if (pKIXPolicyNode != null) {
                    for (int i3 = size - 1; i3 >= 0; i3--) {
                        List list2 = listArr[i3];
                        for (int i4 = 0; i4 < list2.size(); i4++) {
                            PKIXPolicyNode pKIXPolicyNode5 = (PKIXPolicyNode) list2.get(i4);
                            if (!pKIXPolicyNode5.hasChildren()) {
                                pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode5);
                            }
                        }
                    }
                }
            } else if (extendedPKIXParameters.isExplicitPolicyRequired()) {
                if (!set2.isEmpty()) {
                    HashSet<PKIXPolicyNode> hashSet2 = new HashSet<>();
                    for (List list3 : listArr) {
                        for (int i5 = 0; i5 < list3.size(); i5++) {
                            PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) list3.get(i5);
                            if (ANY_POLICY.equals(pKIXPolicyNode6.getValidPolicy())) {
                                Iterator children2 = pKIXPolicyNode6.getChildren();
                                while (children2.hasNext()) {
                                    hashSet2.add(children2.next());
                                }
                            }
                        }
                    }
                    for (PKIXPolicyNode validPolicy : hashSet2) {
                        set2.contains(validPolicy.getValidPolicy());
                    }
                    if (pKIXPolicyNode != null) {
                        for (int i6 = size - 1; i6 >= 0; i6--) {
                            List list4 = listArr[i6];
                            for (int i7 = 0; i7 < list4.size(); i7++) {
                                PKIXPolicyNode pKIXPolicyNode7 = (PKIXPolicyNode) list4.get(i7);
                                if (!pKIXPolicyNode7.hasChildren()) {
                                    pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode7);
                                }
                            }
                        }
                    }
                } else {
                    throw new ExtCertPathValidatorException("Explicit policy requested but none available.", (Throwable) null, certPath, i);
                }
            }
            return pKIXPolicyNode;
        } else if (!extendedPKIXParameters.isExplicitPolicyRequired()) {
            return null;
        } else {
            throw new ExtCertPathValidatorException("Explicit policy requested but none available.", (Throwable) null, certPath, i);
        }
    }
}
