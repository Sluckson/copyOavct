package repack.org.bouncycastle.jce.provider;

import java.util.Collection;
import repack.org.bouncycastle.util.CollectionStore;
import repack.org.bouncycastle.util.Selector;
import repack.org.bouncycastle.x509.X509CollectionStoreParameters;
import repack.org.bouncycastle.x509.X509StoreParameters;
import repack.org.bouncycastle.x509.X509StoreSpi;

public class X509StoreAttrCertCollection extends X509StoreSpi {
    private CollectionStore _store;

    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509CollectionStoreParameters) {
            this._store = new CollectionStore(((X509CollectionStoreParameters) x509StoreParameters).getCollection());
            return;
        }
        throw new IllegalArgumentException(x509StoreParameters.toString());
    }

    public Collection engineGetMatches(Selector selector) {
        return this._store.getMatches(selector);
    }
}
