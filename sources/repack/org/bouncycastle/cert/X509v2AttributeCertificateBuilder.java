package repack.org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.x509.AttCertIssuer;
import repack.org.bouncycastle.asn1.x509.Attribute;
import repack.org.bouncycastle.asn1.x509.V2AttributeCertificateInfoGenerator;
import repack.org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import repack.org.bouncycastle.operator.ContentSigner;

public class X509v2AttributeCertificateBuilder {
    private V2AttributeCertificateInfoGenerator acInfoGen = new V2AttributeCertificateInfoGenerator();
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();

    public X509v2AttributeCertificateBuilder(AttributeCertificateHolder attributeCertificateHolder, AttributeCertificateIssuer attributeCertificateIssuer, BigInteger bigInteger, Date date, Date date2) {
        this.acInfoGen.setHolder(attributeCertificateHolder.holder);
        this.acInfoGen.setIssuer(AttCertIssuer.getInstance(attributeCertificateIssuer.form));
        this.acInfoGen.setSerialNumber(new DERInteger(bigInteger));
        this.acInfoGen.setStartDate(new DERGeneralizedTime(date));
        this.acInfoGen.setEndDate(new DERGeneralizedTime(date2));
    }

    public X509v2AttributeCertificateBuilder addAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.acInfoGen.addAttribute(new Attribute(aSN1ObjectIdentifier, new DERSet((DEREncodable) aSN1Encodable)));
        return this;
    }

    public X509v2AttributeCertificateBuilder addAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable[] aSN1EncodableArr) {
        this.acInfoGen.addAttribute(new Attribute(aSN1ObjectIdentifier, new DERSet(aSN1EncodableArr)));
        return this;
    }

    public void setIssuerUniqueId(boolean[] zArr) {
        this.acInfoGen.setIssuerUniqueID(CertUtils.booleanToBitString(zArr));
    }

    public X509v2AttributeCertificateBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.extGenerator.addExtension((DERObjectIdentifier) aSN1ObjectIdentifier, z, (DEREncodable) aSN1Encodable);
        return this;
    }

    public X509AttributeCertificateHolder build(ContentSigner contentSigner) {
        this.acInfoGen.setSignature(contentSigner.getAlgorithmIdentifier());
        if (!this.extGenerator.isEmpty()) {
            this.acInfoGen.setExtensions(this.extGenerator.generate());
        }
        return CertUtils.generateFullAttrCert(contentSigner, this.acInfoGen.generateAttributeCertificateInfo());
    }
}
