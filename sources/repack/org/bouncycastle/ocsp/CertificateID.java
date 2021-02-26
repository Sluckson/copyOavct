package repack.org.bouncycastle.ocsp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.ocsp.CertID;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.jce.PrincipalUtil;

public class CertificateID {
    public static final String HASH_SHA1 = "1.3.14.3.2.26";

    /* renamed from: id */
    private final CertID f6294id;

    public CertificateID(CertID certID) {
        if (certID != null) {
            this.f6294id = certID;
            return;
        }
        throw new IllegalArgumentException("'id' cannot be null");
    }

    public CertificateID(String str, X509Certificate x509Certificate, BigInteger bigInteger, String str2) throws OCSPException {
        this.f6294id = createCertID(new AlgorithmIdentifier(new DERObjectIdentifier(str), DERNull.INSTANCE), x509Certificate, new DERInteger(bigInteger), str2);
    }

    public CertificateID(String str, X509Certificate x509Certificate, BigInteger bigInteger) throws OCSPException {
        this(str, x509Certificate, bigInteger, "BC");
    }

    public String getHashAlgOID() {
        return this.f6294id.getHashAlgorithm().getObjectId().getId();
    }

    public byte[] getIssuerNameHash() {
        return this.f6294id.getIssuerNameHash().getOctets();
    }

    public byte[] getIssuerKeyHash() {
        return this.f6294id.getIssuerKeyHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.f6294id.getSerialNumber().getValue();
    }

    public boolean matchesIssuer(X509Certificate x509Certificate, String str) throws OCSPException {
        return createCertID(this.f6294id.getHashAlgorithm(), x509Certificate, this.f6294id.getSerialNumber(), str).equals(this.f6294id);
    }

    public CertID toASN1Object() {
        return this.f6294id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificateID)) {
            return false;
        }
        return this.f6294id.getDERObject().equals(((CertificateID) obj).f6294id.getDERObject());
    }

    public int hashCode() {
        return this.f6294id.getDERObject().hashCode();
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new CertID(certificateID.f6294id.getHashAlgorithm(), certificateID.f6294id.getIssuerNameHash(), certificateID.f6294id.getIssuerKeyHash(), new DERInteger(bigInteger)));
    }

    private static CertID createCertID(AlgorithmIdentifier algorithmIdentifier, X509Certificate x509Certificate, DERInteger dERInteger, String str) throws OCSPException {
        try {
            MessageDigest createDigestInstance = OCSPUtil.createDigestInstance(algorithmIdentifier.getAlgorithm().getId(), str);
            createDigestInstance.update(PrincipalUtil.getSubjectX509Principal(x509Certificate).getEncoded());
            DEROctetString dEROctetString = new DEROctetString(createDigestInstance.digest());
            createDigestInstance.update(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(x509Certificate.getPublicKey().getEncoded()).readObject()).getPublicKeyData().getBytes());
            return new CertID(algorithmIdentifier, dEROctetString, new DEROctetString(createDigestInstance.digest()), dERInteger);
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }
}
