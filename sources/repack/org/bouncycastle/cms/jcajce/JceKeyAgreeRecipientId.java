package repack.org.bouncycastle.cms.jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.cms.KeyAgreeRecipientId;

public class JceKeyAgreeRecipientId extends KeyAgreeRecipientId {
    public JceKeyAgreeRecipientId(X509Certificate x509Certificate) {
        this(x509Certificate.getIssuerX500Principal(), x509Certificate.getSerialNumber());
    }

    public JceKeyAgreeRecipientId(X500Principal x500Principal, BigInteger bigInteger) {
        super(X500Name.getInstance(x500Principal.getEncoded()), bigInteger);
    }
}
