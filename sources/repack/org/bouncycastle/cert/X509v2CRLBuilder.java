package repack.org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.TBSCertList;
import repack.org.bouncycastle.asn1.x509.Time;
import repack.org.bouncycastle.asn1.x509.V2TBSCertListGenerator;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import repack.org.bouncycastle.operator.ContentSigner;

public class X509v2CRLBuilder {
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();
    private V2TBSCertListGenerator tbsGen = new V2TBSCertListGenerator();

    public X509v2CRLBuilder(X500Name x500Name, Date date) {
        this.tbsGen.setIssuer(x500Name);
        this.tbsGen.setThisUpdate(new Time(date));
    }

    public X509v2CRLBuilder setNextUpdate(Date date) {
        this.tbsGen.setNextUpdate(new Time(date));
        return this;
    }

    public X509v2CRLBuilder addCRLEntry(BigInteger bigInteger, Date date, int i) {
        this.tbsGen.addCRLEntry(new DERInteger(bigInteger), new Time(date), i);
        return this;
    }

    public X509v2CRLBuilder addCRLEntry(BigInteger bigInteger, Date date, int i, Date date2) {
        this.tbsGen.addCRLEntry(new DERInteger(bigInteger), new Time(date), i, new DERGeneralizedTime(date2));
        return this;
    }

    public X509v2CRLBuilder addCRLEntry(BigInteger bigInteger, Date date, X509Extensions x509Extensions) {
        this.tbsGen.addCRLEntry(new DERInteger(bigInteger), new Time(date), x509Extensions);
        return this;
    }

    public X509v2CRLBuilder addCRL(X509CRLHolder x509CRLHolder) {
        TBSCertList tBSCertList = x509CRLHolder.toASN1Structure().getTBSCertList();
        if (tBSCertList != null) {
            Enumeration revokedCertificateEnumeration = tBSCertList.getRevokedCertificateEnumeration();
            while (revokedCertificateEnumeration.hasMoreElements()) {
                this.tbsGen.addCRLEntry(ASN1Sequence.getInstance(((ASN1Encodable) revokedCertificateEnumeration.nextElement()).getDERObject()));
            }
        }
        return this;
    }

    public X509v2CRLBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.extGenerator.addExtension((DERObjectIdentifier) aSN1ObjectIdentifier, z, (DEREncodable) aSN1Encodable);
        return this;
    }

    public X509CRLHolder build(ContentSigner contentSigner) {
        this.tbsGen.setSignature(contentSigner.getAlgorithmIdentifier());
        if (!this.extGenerator.isEmpty()) {
            this.tbsGen.setExtensions(this.extGenerator.generate());
        }
        return CertUtils.generateFullCRL(contentSigner, this.tbsGen.generateTBSCertList());
    }
}
