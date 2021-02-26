package repack.org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.ocsp.CertID;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;

public class CertificateID {
    public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);

    /* renamed from: id */
    private final CertID f5900id;

    public CertificateID(CertID certID) {
        if (certID != null) {
            this.f5900id = certID;
            return;
        }
        throw new IllegalArgumentException("'id' cannot be null");
    }

    public CertificateID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, BigInteger bigInteger) throws OCSPException {
        this.f5900id = createCertID(digestCalculator, x509CertificateHolder, new DERInteger(bigInteger));
    }

    public ASN1ObjectIdentifier getHashAlgOID() {
        return this.f5900id.getHashAlgorithm().getAlgorithm();
    }

    public byte[] getIssuerNameHash() {
        return this.f5900id.getIssuerNameHash().getOctets();
    }

    public byte[] getIssuerKeyHash() {
        return this.f5900id.getIssuerKeyHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.f5900id.getSerialNumber().getValue();
    }

    public boolean matchesIssuer(X509CertificateHolder x509CertificateHolder, DigestCalculatorProvider digestCalculatorProvider) throws OCSPException {
        try {
            return createCertID(digestCalculatorProvider.get(this.f5900id.getHashAlgorithm()), x509CertificateHolder, this.f5900id.getSerialNumber()).equals(this.f5900id);
        } catch (OperatorCreationException e) {
            throw new OCSPException("unable to create digest calculator: " + e.getMessage(), e);
        }
    }

    public CertID toASN1Object() {
        return this.f5900id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificateID)) {
            return false;
        }
        return this.f5900id.getDERObject().equals(((CertificateID) obj).f5900id.getDERObject());
    }

    public int hashCode() {
        return this.f5900id.getDERObject().hashCode();
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new CertID(certificateID.f5900id.getHashAlgorithm(), certificateID.f5900id.getIssuerNameHash(), certificateID.f5900id.getIssuerKeyHash(), new DERInteger(bigInteger)));
    }

    private static CertID createCertID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, DERInteger dERInteger) throws OCSPException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(x509CertificateHolder.toASN1Structure().getSubject().getDEREncoded());
            outputStream.close();
            DEROctetString dEROctetString = new DEROctetString(digestCalculator.getDigest());
            SubjectPublicKeyInfo subjectPublicKeyInfo = x509CertificateHolder.getSubjectPublicKeyInfo();
            OutputStream outputStream2 = digestCalculator.getOutputStream();
            outputStream2.write(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            outputStream2.close();
            return new CertID(digestCalculator.getAlgorithmIdentifier(), dEROctetString, new DEROctetString(digestCalculator.getDigest()), dERInteger);
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }
}
