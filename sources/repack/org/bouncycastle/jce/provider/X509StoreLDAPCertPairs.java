package repack.org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import repack.org.bouncycastle.jce.X509LDAPCertStoreParameters;
import repack.org.bouncycastle.util.Selector;
import repack.org.bouncycastle.util.StoreException;
import repack.org.bouncycastle.x509.X509CertPairStoreSelector;
import repack.org.bouncycastle.x509.X509StoreParameters;
import repack.org.bouncycastle.x509.X509StoreSpi;
import repack.org.bouncycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCertPairs extends X509StoreSpi {
    private LDAPStoreHelper helper;

    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509LDAPCertStoreParameters) {
            this.helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + ".");
    }

    public Collection engineGetMatches(Selector selector) throws StoreException {
        if (!(selector instanceof X509CertPairStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.helper.getCrossCertificatePairs((X509CertPairStoreSelector) selector));
        return hashSet;
    }
}
