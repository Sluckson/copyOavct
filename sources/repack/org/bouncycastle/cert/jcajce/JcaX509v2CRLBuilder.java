package repack.org.bouncycastle.cert.jcajce;

import java.util.Date;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.cert.X509v2CRLBuilder;

public class JcaX509v2CRLBuilder extends X509v2CRLBuilder {
    public JcaX509v2CRLBuilder(X500Principal x500Principal, Date date) {
        super(X500Name.getInstance(x500Principal.getEncoded()), date);
    }
}
