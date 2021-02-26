package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Principal;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import repack.org.bouncycastle.util.Selector;
import repack.org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import repack.org.bouncycastle.x509.X509AttributeCertStoreSelector;
import repack.org.bouncycastle.x509.X509AttributeCertificate;
import repack.org.bouncycastle.x509.X509CertStoreSelector;

public class PKIXAttrCertPathBuilderSpi extends CertPathBuilderSpi {
    private Exception certPathException;

    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters;
        Exception exc;
        if ((certPathParameters instanceof PKIXBuilderParameters) || (certPathParameters instanceof ExtendedPKIXBuilderParameters)) {
            if (certPathParameters instanceof ExtendedPKIXBuilderParameters) {
                extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
            } else {
                extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) ExtendedPKIXBuilderParameters.getInstance((PKIXBuilderParameters) certPathParameters);
            }
            ArrayList arrayList = new ArrayList();
            Selector targetConstraints = extendedPKIXBuilderParameters.getTargetConstraints();
            if (targetConstraints instanceof X509AttributeCertStoreSelector) {
                try {
                    Collection findCertificates = CertPathValidatorUtilities.findCertificates((X509AttributeCertStoreSelector) targetConstraints, extendedPKIXBuilderParameters.getStores());
                    if (!findCertificates.isEmpty()) {
                        CertPathBuilderResult certPathBuilderResult = null;
                        Iterator it = findCertificates.iterator();
                        while (it.hasNext() && certPathBuilderResult == null) {
                            X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) it.next();
                            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
                            Principal[] principals = x509AttributeCertificate.getIssuer().getPrincipals();
                            HashSet hashSet = new HashSet();
                            int i = 0;
                            while (i < principals.length) {
                                try {
                                    if (principals[i] instanceof X500Principal) {
                                        x509CertStoreSelector.setSubject(((X500Principal) principals[i]).getEncoded());
                                    }
                                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXBuilderParameters.getStores()));
                                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXBuilderParameters.getCertStores()));
                                    i++;
                                } catch (AnnotatedException e) {
                                    throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", e);
                                } catch (IOException e2) {
                                    throw new ExtCertPathBuilderException("cannot encode X500Principal.", e2);
                                }
                            }
                            if (!hashSet.isEmpty()) {
                                Iterator it2 = hashSet.iterator();
                                while (it2.hasNext() && certPathBuilderResult == null) {
                                    certPathBuilderResult = build(x509AttributeCertificate, (X509Certificate) it2.next(), extendedPKIXBuilderParameters, arrayList);
                                }
                            } else {
                                throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
                            }
                        }
                        if (certPathBuilderResult == null && (exc = this.certPathException) != null) {
                            throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", exc);
                        } else if (certPathBuilderResult != null || this.certPathException != null) {
                            return certPathBuilderResult;
                        } else {
                            throw new CertPathBuilderException("Unable to find certificate chain.");
                        }
                    } else {
                        throw new CertPathBuilderException("No attribute certificate found matching targetContraints.");
                    }
                } catch (AnnotatedException e3) {
                    throw new ExtCertPathBuilderException("Error finding target attribute certificate.", e3);
                }
            } else {
                throw new CertPathBuilderException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + getClass().getName() + " class.");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + ExtendedPKIXBuilderParameters.class.getName() + ".");
        }
    }

    private CertPathBuilderResult build(X509AttributeCertificate x509AttributeCertificate, X509Certificate x509Certificate, ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters, List list) {
        CertPathBuilderResult certPathBuilderResult = null;
        if (list.contains(x509Certificate) || extendedPKIXBuilderParameters.getExcludedCerts().contains(x509Certificate)) {
            return null;
        }
        if (extendedPKIXBuilderParameters.getMaxPathLength() != -1 && list.size() - 1 > extendedPKIXBuilderParameters.getMaxPathLength()) {
            return null;
        }
        list.add(x509Certificate);
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
            CertPathValidator instance2 = CertPathValidator.getInstance("RFC3281", BouncyCastleProvider.PROVIDER_NAME);
            try {
                if (CertPathValidatorUtilities.findTrustAnchor(x509Certificate, extendedPKIXBuilderParameters.getTrustAnchors(), extendedPKIXBuilderParameters.getSigProvider()) != null) {
                    CertPath generateCertPath = instance.generateCertPath(list);
                    PKIXCertPathValidatorResult pKIXCertPathValidatorResult = (PKIXCertPathValidatorResult) instance2.validate(generateCertPath, extendedPKIXBuilderParameters);
                    return new PKIXCertPathBuilderResult(generateCertPath, pKIXCertPathValidatorResult.getTrustAnchor(), pKIXCertPathValidatorResult.getPolicyTree(), pKIXCertPathValidatorResult.getPublicKey());
                }
                CertPathValidatorUtilities.addAdditionalStoresFromAltNames(x509Certificate, extendedPKIXBuilderParameters);
                HashSet hashSet = new HashSet();
                hashSet.addAll(CertPathValidatorUtilities.findIssuerCerts(x509Certificate, extendedPKIXBuilderParameters));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (certPathBuilderResult != null) {
                            break;
                        } else {
                            X509Certificate x509Certificate2 = (X509Certificate) it.next();
                            if (!x509Certificate2.getIssuerX500Principal().equals(x509Certificate2.getSubjectX500Principal())) {
                                certPathBuilderResult = build(x509AttributeCertificate, x509Certificate2, extendedPKIXBuilderParameters, list);
                            }
                        }
                    }
                    if (certPathBuilderResult == null) {
                        list.remove(x509Certificate);
                    }
                    return certPathBuilderResult;
                }
                throw new AnnotatedException("No issuer certificate for certificate in certification path found.");
            } catch (CertificateParsingException e) {
                throw new AnnotatedException("No additional X.509 stores can be added from certificate locations.", e);
            } catch (AnnotatedException e2) {
                throw new AnnotatedException("Cannot find issuer certificate for certificate in certification path.", e2);
            } catch (Exception e3) {
                throw new AnnotatedException("Certification path could not be constructed from certificate list.", e3);
            } catch (Exception e4) {
                throw new AnnotatedException("Certification path could not be validated.", e4);
            } catch (AnnotatedException e5) {
                this.certPathException = new AnnotatedException("No valid certification path could be build.", e5);
            }
        } catch (Exception unused) {
            throw new RuntimeException("Exception creating support classes.");
        }
    }
}
