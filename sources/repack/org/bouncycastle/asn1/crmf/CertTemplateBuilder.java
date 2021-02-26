package repack.org.bouncycastle.asn1.crmf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class CertTemplateBuilder {
    private X509Extensions extensions;
    private X500Name issuer;
    private DERBitString issuerUID;
    private SubjectPublicKeyInfo publicKey;
    private DERInteger serialNumber;
    private AlgorithmIdentifier signingAlg;
    private X500Name subject;
    private DERBitString subjectUID;
    private OptionalValidity validity;
    private DERInteger version;

    public CertTemplateBuilder setVersion(int i) {
        this.version = new DERInteger(i);
        return this;
    }

    public CertTemplateBuilder setSerialNumber(DERInteger dERInteger) {
        this.serialNumber = dERInteger;
        return this;
    }

    public CertTemplateBuilder setSigningAlg(AlgorithmIdentifier algorithmIdentifier) {
        this.signingAlg = algorithmIdentifier;
        return this;
    }

    public CertTemplateBuilder setIssuer(X500Name x500Name) {
        this.issuer = x500Name;
        return this;
    }

    public CertTemplateBuilder setValidity(OptionalValidity optionalValidity) {
        this.validity = optionalValidity;
        return this;
    }

    public CertTemplateBuilder setSubject(X500Name x500Name) {
        this.subject = x500Name;
        return this;
    }

    public CertTemplateBuilder setPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.publicKey = subjectPublicKeyInfo;
        return this;
    }

    public CertTemplateBuilder setIssuerUID(DERBitString dERBitString) {
        this.issuerUID = dERBitString;
        return this;
    }

    public CertTemplateBuilder setSubjectUID(DERBitString dERBitString) {
        this.subjectUID = dERBitString;
        return this;
    }

    public CertTemplateBuilder setExtensions(X509Extensions x509Extensions) {
        this.extensions = x509Extensions;
        return this;
    }

    public CertTemplate build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        addOptional(aSN1EncodableVector, 0, false, this.version);
        addOptional(aSN1EncodableVector, 1, false, this.serialNumber);
        addOptional(aSN1EncodableVector, 2, false, this.signingAlg);
        addOptional(aSN1EncodableVector, 3, true, this.issuer);
        addOptional(aSN1EncodableVector, 4, false, this.validity);
        addOptional(aSN1EncodableVector, 5, true, this.subject);
        addOptional(aSN1EncodableVector, 6, false, this.publicKey);
        addOptional(aSN1EncodableVector, 7, false, this.issuerUID);
        addOptional(aSN1EncodableVector, 8, false, this.subjectUID);
        addOptional(aSN1EncodableVector, 9, false, this.extensions);
        return CertTemplate.getInstance(new DERSequence(aSN1EncodableVector));
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, boolean z, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(new DERTaggedObject(z, i, aSN1Encodable));
        }
    }
}