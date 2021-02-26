package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.SignerIdentifier;
import repack.org.bouncycastle.asn1.cms.SignerInfo;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.ContentSigner;
import repack.org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import repack.org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.util.p072io.TeeOutputStream;

public class SignerInfoGenerator {
    private static final Set RSA_PKCS1d5 = new HashSet();
    private byte[] calculatedDigest;
    private X509CertificateHolder certHolder;
    private final DigestAlgorithmIdentifierFinder digAlgFinder;
    private final DigestCalculator digester;
    private final CMSAttributeTableGenerator sAttrGen;
    private final ContentSigner signer;
    private final SignerIdentifier signerIdentifier;
    private final CMSAttributeTableGenerator unsAttrGen;

    static {
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.md2WithRSAEncryption);
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.md4WithRSAEncryption);
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.md5WithRSAEncryption);
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.sha1WithRSAEncryption);
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.sha224WithRSAEncryption);
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.sha256WithRSAEncryption);
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.sha384WithRSAEncryption);
        RSA_PKCS1d5.add(PKCSObjectIdentifiers.sha512WithRSAEncryption);
        RSA_PKCS1d5.add(OIWObjectIdentifiers.md4WithRSAEncryption);
        RSA_PKCS1d5.add(OIWObjectIdentifiers.md4WithRSA);
        RSA_PKCS1d5.add(OIWObjectIdentifiers.md5WithRSA);
        RSA_PKCS1d5.add(OIWObjectIdentifiers.sha1WithRSA);
        RSA_PKCS1d5.add(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
        RSA_PKCS1d5.add(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
        RSA_PKCS1d5.add(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
    }

    public SignerInfoGenerator(SignerIdentifier signerIdentifier2, ContentSigner contentSigner, DigestCalculatorProvider digestCalculatorProvider) throws OperatorCreationException {
        this(signerIdentifier2, contentSigner, digestCalculatorProvider, false);
    }

    public SignerInfoGenerator(SignerIdentifier signerIdentifier2, ContentSigner contentSigner, DigestCalculatorProvider digestCalculatorProvider, boolean z) throws OperatorCreationException {
        this.digAlgFinder = new DefaultDigestAlgorithmIdentifierFinder();
        this.calculatedDigest = null;
        this.signerIdentifier = signerIdentifier2;
        this.signer = contentSigner;
        if (digestCalculatorProvider != null) {
            this.digester = digestCalculatorProvider.get(this.digAlgFinder.find(contentSigner.getAlgorithmIdentifier()));
        } else {
            this.digester = null;
        }
        if (z) {
            this.sAttrGen = null;
            this.unsAttrGen = null;
            return;
        }
        this.sAttrGen = new DefaultSignedAttributeTableGenerator();
        this.unsAttrGen = null;
    }

    public SignerInfoGenerator(SignerInfoGenerator signerInfoGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) {
        this.digAlgFinder = new DefaultDigestAlgorithmIdentifierFinder();
        this.calculatedDigest = null;
        this.signerIdentifier = signerInfoGenerator.signerIdentifier;
        this.signer = signerInfoGenerator.signer;
        this.digester = signerInfoGenerator.digester;
        this.sAttrGen = cMSAttributeTableGenerator;
        this.unsAttrGen = cMSAttributeTableGenerator2;
    }

    public SignerInfoGenerator(SignerIdentifier signerIdentifier2, ContentSigner contentSigner, DigestCalculatorProvider digestCalculatorProvider, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) throws OperatorCreationException {
        this.digAlgFinder = new DefaultDigestAlgorithmIdentifierFinder();
        this.calculatedDigest = null;
        this.signerIdentifier = signerIdentifier2;
        this.signer = contentSigner;
        if (digestCalculatorProvider != null) {
            this.digester = digestCalculatorProvider.get(this.digAlgFinder.find(contentSigner.getAlgorithmIdentifier()));
        } else {
            this.digester = null;
        }
        this.sAttrGen = cMSAttributeTableGenerator;
        this.unsAttrGen = cMSAttributeTableGenerator2;
    }

    public boolean hasAssociatedCertificate() {
        return this.certHolder != null;
    }

    public X509CertificateHolder getAssociatedCertificate() {
        return this.certHolder;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        DigestCalculator digestCalculator = this.digester;
        if (digestCalculator != null) {
            return digestCalculator.getAlgorithmIdentifier();
        }
        return this.digAlgFinder.find(this.signer.getAlgorithmIdentifier());
    }

    public OutputStream getCalculatingOutputStream() {
        DigestCalculator digestCalculator = this.digester;
        if (digestCalculator == null) {
            return this.signer.getOutputStream();
        }
        if (this.sAttrGen == null) {
            return new TeeOutputStream(digestCalculator.getOutputStream(), this.signer.getOutputStream());
        }
        return digestCalculator.getOutputStream();
    }

    public SignerInfo generate(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        ASN1Set aSN1Set;
        AlgorithmIdentifier algorithmIdentifier;
        AlgorithmIdentifier algorithmIdentifier2;
        try {
            ASN1Set aSN1Set2 = null;
            if (this.sAttrGen != null) {
                AlgorithmIdentifier algorithmIdentifier3 = this.digester.getAlgorithmIdentifier();
                this.calculatedDigest = this.digester.getDigest();
                ASN1Set attributeSet = getAttributeSet(this.sAttrGen.getAttributes(Collections.unmodifiableMap(getBaseParameters(aSN1ObjectIdentifier, this.digester.getAlgorithmIdentifier(), this.calculatedDigest))));
                OutputStream outputStream = this.signer.getOutputStream();
                outputStream.write(attributeSet.getEncoded(ASN1Encodable.DER));
                outputStream.close();
                algorithmIdentifier = algorithmIdentifier3;
                aSN1Set = attributeSet;
            } else {
                if (this.digester != null) {
                    algorithmIdentifier2 = this.digester.getAlgorithmIdentifier();
                    this.calculatedDigest = this.digester.getDigest();
                } else {
                    algorithmIdentifier2 = this.digAlgFinder.find(this.signer.getAlgorithmIdentifier());
                    this.calculatedDigest = null;
                }
                algorithmIdentifier = algorithmIdentifier2;
                aSN1Set = null;
            }
            byte[] signature = this.signer.getSignature();
            if (this.unsAttrGen != null) {
                Map baseParameters = getBaseParameters(aSN1ObjectIdentifier, algorithmIdentifier, this.calculatedDigest);
                baseParameters.put(CMSAttributeTableGenerator.SIGNATURE, signature.clone());
                aSN1Set2 = getAttributeSet(this.unsAttrGen.getAttributes(Collections.unmodifiableMap(baseParameters)));
            }
            return new SignerInfo(this.signerIdentifier, algorithmIdentifier, aSN1Set, getSignatureAlgorithm(this.signer.getAlgorithmIdentifier()), new DEROctetString(signature), aSN1Set2);
        } catch (IOException e) {
            throw new CMSException("encoding error.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAssociatedCertificate(X509CertificateHolder x509CertificateHolder) {
        this.certHolder = x509CertificateHolder;
    }

    private ASN1Set getAttributeSet(AttributeTable attributeTable) {
        if (attributeTable != null) {
            return new DERSet(attributeTable.toASN1EncodableVector());
        }
        return null;
    }

    private Map getBaseParameters(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        HashMap hashMap = new HashMap();
        if (dERObjectIdentifier != null) {
            hashMap.put(CMSAttributeTableGenerator.CONTENT_TYPE, dERObjectIdentifier);
        }
        hashMap.put(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER, algorithmIdentifier);
        hashMap.put(CMSAttributeTableGenerator.DIGEST, bArr.clone());
        return hashMap;
    }

    private AlgorithmIdentifier getSignatureAlgorithm(AlgorithmIdentifier algorithmIdentifier) throws IOException {
        return RSA_PKCS1d5.contains(algorithmIdentifier.getAlgorithm()) ? new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE) : algorithmIdentifier;
    }

    public byte[] getCalculatedDigest() {
        byte[] bArr = this.calculatedDigest;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public CMSAttributeTableGenerator getSignedAttributeTableGenerator() {
        return this.sAttrGen;
    }

    public CMSAttributeTableGenerator getUnsignedAttributeTableGenerator() {
        return this.unsAttrGen;
    }
}
