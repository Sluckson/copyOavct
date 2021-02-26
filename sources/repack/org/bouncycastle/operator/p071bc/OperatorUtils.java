package repack.org.bouncycastle.operator.p071bc;

import java.security.Key;
import repack.org.bouncycastle.operator.GenericKey;

/* renamed from: repack.org.bouncycastle.operator.bc.OperatorUtils */
class OperatorUtils {
    OperatorUtils() {
    }

    static byte[] getKeyBytes(GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return ((Key) genericKey.getRepresentation()).getEncoded();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return (byte[]) genericKey.getRepresentation();
        }
        throw new IllegalArgumentException("unknown generic key type");
    }
}
