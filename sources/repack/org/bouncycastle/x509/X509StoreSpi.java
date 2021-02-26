package repack.org.bouncycastle.x509;

import java.util.Collection;
import repack.org.bouncycastle.util.Selector;

public abstract class X509StoreSpi {
    public abstract Collection engineGetMatches(Selector selector);

    public abstract void engineInit(X509StoreParameters x509StoreParameters);
}
