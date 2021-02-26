package repack.org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;

public interface BlockCipherPadding {
    int addPadding(byte[] bArr, int i);

    String getPaddingName();

    void init(SecureRandom secureRandom) throws IllegalArgumentException;

    int padCount(byte[] bArr) throws InvalidCipherTextException;
}
