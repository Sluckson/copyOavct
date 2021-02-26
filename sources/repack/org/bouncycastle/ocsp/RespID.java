package repack.org.bouncycastle.ocsp;

import java.security.MessageDigest;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.ocsp.ResponderID;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class RespID {

    /* renamed from: id */
    ResponderID f6296id;

    public RespID(ResponderID responderID) {
        this.f6296id = responderID;
    }

    public RespID(X500Principal x500Principal) {
        this.f6296id = new ResponderID(X500Name.getInstance(x500Principal.getEncoded()));
    }

    public RespID(PublicKey publicKey) throws OCSPException {
        try {
            MessageDigest createDigestInstance = OCSPUtil.createDigestInstance("SHA1", (String) null);
            createDigestInstance.update(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()).getPublicKeyData().getBytes());
            this.f6296id = new ResponderID((ASN1OctetString) new DEROctetString(createDigestInstance.digest()));
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }

    public ResponderID toASN1Object() {
        return this.f6296id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RespID)) {
            return false;
        }
        return this.f6296id.equals(((RespID) obj).f6296id);
    }

    public int hashCode() {
        return this.f6296id.hashCode();
    }
}
