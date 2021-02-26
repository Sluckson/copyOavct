package repack.org.bouncycastle.crypto.generators;

import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DESParameters;

public class DESKeyGenerator extends CipherKeyGenerator {
    public void init(KeyGenerationParameters keyGenerationParameters) {
        super.init(keyGenerationParameters);
        if (this.strength == 0 || this.strength == 7) {
            this.strength = 8;
        } else if (this.strength != 8) {
            throw new IllegalArgumentException("DES key must be 64 bits long.");
        }
    }

    public byte[] generateKey() {
        byte[] bArr = new byte[8];
        do {
            this.random.nextBytes(bArr);
            DESParameters.setOddParity(bArr);
        } while (DESParameters.isWeakKey(bArr, 0));
        return bArr;
    }
}
