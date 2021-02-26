package repack.org.bouncycastle.tsp;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.Attribute;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.ess.ESSCertID;
import repack.org.bouncycastle.asn1.ess.SigningCertificate;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.tsp.Accuracy;
import repack.org.bouncycastle.asn1.tsp.MessageImprint;
import repack.org.bouncycastle.asn1.tsp.TSTInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.cert.jcajce.JcaX509CRLHolder;
import repack.org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerationException;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.cms.CMSProcessableByteArray;
import repack.org.bouncycastle.cms.CMSSignedDataGenerator;
import repack.org.bouncycastle.cms.CMSSignedGenerator;
import repack.org.bouncycastle.cms.CMSTypedData;
import repack.org.bouncycastle.cms.DefaultSignedAttributeTableGenerator;
import repack.org.bouncycastle.cms.SignerInfoGenerator;
import repack.org.bouncycastle.cms.SimpleAttributeTableGenerator;
import repack.org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import repack.org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import repack.org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import repack.org.bouncycastle.util.CollectionStore;
import repack.org.bouncycastle.util.Selector;
import repack.org.bouncycastle.util.Store;

public class TimeStampTokenGenerator {
    int accuracyMicros;
    int accuracyMillis;
    int accuracySeconds;
    private List attrCerts;
    X509Certificate cert;
    private List certs;
    CertStore certsAndCrls;
    private List crls;
    String digestOID;
    PrivateKey key;
    boolean ordering;
    AttributeTable signedAttr;
    private SignerInfoGenerator signerInfoGen;
    GeneralName tsa;
    private String tsaPolicyOID;
    AttributeTable unsignedAttr;

    public TimeStampTokenGenerator(final SignerInfoGenerator signerInfoGenerator, ASN1ObjectIdentifier aSN1ObjectIdentifier) throws IllegalArgumentException, TSPException {
        this.accuracySeconds = -1;
        this.accuracyMillis = -1;
        this.accuracyMicros = -1;
        this.ordering = false;
        this.tsa = null;
        this.certs = new ArrayList();
        this.crls = new ArrayList();
        this.attrCerts = new ArrayList();
        this.signerInfoGen = signerInfoGenerator;
        this.tsaPolicyOID = aSN1ObjectIdentifier.getId();
        if (signerInfoGenerator.hasAssociatedCertificate()) {
            TSPUtil.validateCertificate(signerInfoGenerator.getAssociatedCertificate());
            try {
                final ESSCertID eSSCertID = new ESSCertID(MessageDigest.getInstance("SHA-1").digest(signerInfoGenerator.getAssociatedCertificate().getEncoded()));
                this.signerInfoGen = new SignerInfoGenerator(signerInfoGenerator, (CMSAttributeTableGenerator) new CMSAttributeTableGenerator() {
                    public AttributeTable getAttributes(Map map) throws CMSAttributeTableGenerationException {
                        return signerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(map).add(PKCSObjectIdentifiers.id_aa_signingCertificate, new SigningCertificate(eSSCertID));
                    }
                }, signerInfoGenerator.getUnsignedAttributeTableGenerator());
            } catch (NoSuchAlgorithmException e) {
                throw new TSPException("Can't find a SHA-1 implementation.", e);
            } catch (IOException e2) {
                throw new TSPException("Exception processing certificate.", e2);
            }
        } else {
            throw new IllegalArgumentException("SignerInfoGenerator must have an associated certificate");
        }
    }

    public TimeStampTokenGenerator(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2) throws IllegalArgumentException, TSPException {
        this(privateKey, x509Certificate, str, str2, (AttributeTable) null, (AttributeTable) null);
    }

    public TimeStampTokenGenerator(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException, TSPException {
        Hashtable hashtable;
        this.accuracySeconds = -1;
        this.accuracyMillis = -1;
        this.accuracyMicros = -1;
        this.ordering = false;
        this.tsa = null;
        this.certs = new ArrayList();
        this.crls = new ArrayList();
        this.attrCerts = new ArrayList();
        this.key = privateKey;
        this.cert = x509Certificate;
        this.digestOID = str;
        this.tsaPolicyOID = str2;
        this.unsignedAttr = attributeTable2;
        if (attributeTable != null) {
            hashtable = attributeTable.toHashtable();
        } else {
            hashtable = new Hashtable();
        }
        TSPUtil.validateCertificate(x509Certificate);
        try {
            hashtable.put(PKCSObjectIdentifiers.id_aa_signingCertificate, new Attribute(PKCSObjectIdentifiers.id_aa_signingCertificate, new DERSet((DEREncodable) new SigningCertificate(new ESSCertID(MessageDigest.getInstance("SHA-1").digest(x509Certificate.getEncoded()))))));
            this.signedAttr = new AttributeTable(hashtable);
        } catch (NoSuchAlgorithmException e) {
            throw new TSPException("Can't find a SHA-1 implementation.", e);
        } catch (CertificateEncodingException e2) {
            throw new TSPException("Exception processing certificate.", e2);
        }
    }

    public void setCertificatesAndCRLs(CertStore certStore) throws CertStoreException, TSPException {
        Iterator<? extends Certificate> it = certStore.getCertificates((CertSelector) null).iterator();
        while (it.hasNext()) {
            try {
                this.certs.add(new JcaX509CertificateHolder((X509Certificate) it.next()));
            } catch (CertificateEncodingException e) {
                throw new TSPException("cannot encode certificate: " + e.getMessage(), e);
            }
        }
        Iterator<? extends CRL> it2 = certStore.getCRLs((CRLSelector) null).iterator();
        while (it2.hasNext()) {
            try {
                this.crls.add(new JcaX509CRLHolder((X509CRL) it2.next()));
            } catch (CRLException e2) {
                throw new TSPException("cannot encode CRL: " + e2.getMessage(), e2);
            }
        }
    }

    public void addCertificates(Store store) {
        this.certs.addAll(store.getMatches((Selector) null));
    }

    public void addCRLs(Store store) {
        this.crls.addAll(store.getMatches((Selector) null));
    }

    public void addAttributeCertificates(Store store) {
        this.attrCerts.addAll(store.getMatches((Selector) null));
    }

    public void setAccuracySeconds(int i) {
        this.accuracySeconds = i;
    }

    public void setAccuracyMillis(int i) {
        this.accuracyMillis = i;
    }

    public void setAccuracyMicros(int i) {
        this.accuracyMicros = i;
    }

    public void setOrdering(boolean z) {
        this.ordering = z;
    }

    public void setTSA(GeneralName generalName) {
        this.tsa = generalName;
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date, String str) throws NoSuchAlgorithmException, NoSuchProviderException, TSPException {
        if (this.signerInfoGen == null) {
            try {
                JcaSignerInfoGeneratorBuilder jcaSignerInfoGeneratorBuilder = new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider(str).build());
                jcaSignerInfoGeneratorBuilder.setSignedAttributeGenerator(new DefaultSignedAttributeTableGenerator(this.signedAttr));
                if (this.unsignedAttr != null) {
                    jcaSignerInfoGeneratorBuilder.setUnsignedAttributeGenerator(new SimpleAttributeTableGenerator(this.unsignedAttr));
                }
                this.signerInfoGen = jcaSignerInfoGeneratorBuilder.build(new JcaContentSignerBuilder(getSigAlgorithm(this.key, this.digestOID)).setProvider(str).build(this.key), this.cert);
            } catch (OperatorCreationException e) {
                throw new TSPException("Error generating signing operator", e);
            } catch (CertificateEncodingException e2) {
                throw new TSPException("Error encoding certificate", e2);
            }
        }
        return generate(timeStampRequest, bigInteger, date);
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date) throws TSPException {
        Accuracy accuracy;
        if (this.signerInfoGen != null) {
            MessageImprint messageImprint = new MessageImprint(new AlgorithmIdentifier(new ASN1ObjectIdentifier(timeStampRequest.getMessageImprintAlgOID()), new DERNull()), timeStampRequest.getMessageImprintDigest());
            if (this.accuracySeconds > 0 || this.accuracyMillis > 0 || this.accuracyMicros > 0) {
                int i = this.accuracySeconds;
                DERInteger dERInteger = i > 0 ? new DERInteger(i) : null;
                int i2 = this.accuracyMillis;
                DERInteger dERInteger2 = i2 > 0 ? new DERInteger(i2) : null;
                int i3 = this.accuracyMicros;
                accuracy = new Accuracy(dERInteger, dERInteger2, i3 > 0 ? new DERInteger(i3) : null);
            } else {
                accuracy = null;
            }
            boolean z = this.ordering;
            DERBoolean dERBoolean = z ? new DERBoolean(z) : null;
            DERInteger dERInteger3 = timeStampRequest.getNonce() != null ? new DERInteger(timeStampRequest.getNonce()) : null;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(this.tsaPolicyOID);
            if (timeStampRequest.getReqPolicy() != null) {
                aSN1ObjectIdentifier = new ASN1ObjectIdentifier(timeStampRequest.getReqPolicy());
            }
            TSTInfo tSTInfo = new TSTInfo(aSN1ObjectIdentifier, messageImprint, new DERInteger(bigInteger), new DERGeneralizedTime(date), accuracy, dERBoolean, dERInteger3, this.tsa, timeStampRequest.getExtensions());
            try {
                CMSSignedDataGenerator cMSSignedDataGenerator = new CMSSignedDataGenerator();
                if (timeStampRequest.getCertReq()) {
                    cMSSignedDataGenerator.addCertificates(new CollectionStore(this.certs));
                    cMSSignedDataGenerator.addCRLs(new CollectionStore(this.crls));
                    cMSSignedDataGenerator.addAttributeCertificates((Store) new CollectionStore(this.attrCerts));
                } else {
                    cMSSignedDataGenerator.addCRLs(new CollectionStore(this.crls));
                }
                cMSSignedDataGenerator.addSignerInfoGenerator(this.signerInfoGen);
                return new TimeStampToken(cMSSignedDataGenerator.generate((CMSTypedData) new CMSProcessableByteArray(PKCSObjectIdentifiers.id_ct_TSTInfo, tSTInfo.getEncoded(ASN1Encodable.DER)), true));
            } catch (CMSException e) {
                throw new TSPException("Error generating time-stamp token", e);
            } catch (IOException e2) {
                throw new TSPException("Exception encoding info", e2);
            }
        } else {
            throw new IllegalStateException("can only use this method with SignerInfoGenerator constructor");
        }
    }

    private String getSigAlgorithm(PrivateKey privateKey, String str) {
        String str2 = "GOST3410";
        if ((privateKey instanceof RSAPrivateKey) || "RSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "RSA";
        } else if ((privateKey instanceof DSAPrivateKey) || "DSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "DSA";
        } else if ("ECDSA".equalsIgnoreCase(privateKey.getAlgorithm()) || "EC".equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "ECDSA";
        } else if (!(privateKey instanceof GOST3410PrivateKey) && !str2.equalsIgnoreCase(privateKey.getAlgorithm())) {
            str2 = "ECGOST3410".equalsIgnoreCase(privateKey.getAlgorithm()) ? CMSSignedGenerator.ENCRYPTION_ECGOST3410 : null;
        }
        return String.valueOf(TSPUtil.getDigestAlgName(str)) + "with" + str2;
    }
}
