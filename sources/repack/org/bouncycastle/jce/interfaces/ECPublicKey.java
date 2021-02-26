package repack.org.bouncycastle.jce.interfaces;

import java.security.PublicKey;
import repack.org.bouncycastle.math.p070ec.ECPoint;

public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}
