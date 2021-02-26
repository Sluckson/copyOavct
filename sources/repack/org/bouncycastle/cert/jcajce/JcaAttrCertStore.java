package repack.org.bouncycastle.cert.jcajce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import repack.org.bouncycastle.util.CollectionStore;
import repack.org.bouncycastle.x509.X509AttributeCertificate;

public class JcaAttrCertStore extends CollectionStore {
    public JcaAttrCertStore(Collection collection) throws IOException {
        super(convertCerts(collection));
    }

    public JcaAttrCertStore(X509AttributeCertificate x509AttributeCertificate) throws IOException {
        this((Collection) Collections.singletonList(x509AttributeCertificate));
    }

    private static Collection convertCerts(Collection collection) throws IOException {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next instanceof X509AttributeCertificate) {
                arrayList.add(new JcaX509AttributeCertificateHolder((X509AttributeCertificate) next));
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
