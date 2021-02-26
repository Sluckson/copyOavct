package repack.org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.ocsp.ResponderID;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.operator.DigestCalculator;

public class RespID {
    public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);

    /* renamed from: id */
    ResponderID f5901id;

    public RespID(ResponderID responderID) {
        this.f5901id = responderID;
    }

    public RespID(X500Name x500Name) {
        this.f5901id = new ResponderID(x500Name);
    }

    public RespID(SubjectPublicKeyInfo subjectPublicKeyInfo, DigestCalculator digestCalculator) throws OCSPException {
        try {
            if (digestCalculator.getAlgorithmIdentifier().equals(HASH_SHA1)) {
                OutputStream outputStream = digestCalculator.getOutputStream();
                outputStream.write(subjectPublicKeyInfo.getPublicKeyData().getBytes());
                outputStream.close();
                this.f5901id = new ResponderID((ASN1OctetString) new DEROctetString(digestCalculator.getDigest()));
                return;
            }
            throw new IllegalArgumentException("only SHA-1 can be used with RespID");
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }

    public ResponderID toASN1Object() {
        return this.f5901id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RespID)) {
            return false;
        }
        return this.f5901id.equals(((RespID) obj).f5901id);
    }

    public int hashCode() {
        return this.f5901id.hashCode();
    }
}
