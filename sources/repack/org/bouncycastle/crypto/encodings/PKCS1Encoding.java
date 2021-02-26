package repack.org.bouncycastle.crypto.encodings;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;

public class PKCS1Encoding implements AsymmetricBlockCipher {
    private static final int HEADER_LENGTH = 10;
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.strict";
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private boolean forPrivateKey;
    private SecureRandom random;
    private boolean useStrictLength = useStrict();

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.engine = asymmetricBlockCipher;
    }

    private boolean useStrict() {
        String str = (String) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return System.getProperty(PKCS1Encoding.STRICT_LENGTH_ENABLED_PROPERTY);
            }
        });
        return str == null || str.equals("true");
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            this.random = new SecureRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        this.engine.init(z, cipherParameters);
        this.forPrivateKey = asymmetricKeyParameter.isPrivate();
        this.forEncryption = z;
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? inputBlockSize - 10 : inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : outputBlockSize - 10;
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encodeBlock(bArr, i, i2);
        }
        return decodeBlock(bArr, i, i2);
    }

    private byte[] encodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (i2 <= getInputBlockSize()) {
            byte[] bArr2 = new byte[this.engine.getInputBlockSize()];
            if (this.forPrivateKey) {
                bArr2[0] = 1;
                for (int i3 = 1; i3 != (bArr2.length - i2) - 1; i3++) {
                    bArr2[i3] = -1;
                }
            } else {
                this.random.nextBytes(bArr2);
                bArr2[0] = 2;
                for (int i4 = 1; i4 != (bArr2.length - i2) - 1; i4++) {
                    while (bArr2[i4] == 0) {
                        bArr2[i4] = (byte) this.random.nextInt();
                    }
                }
            }
            bArr2[(bArr2.length - i2) - 1] = 0;
            System.arraycopy(bArr, i, bArr2, bArr2.length - i2, i2);
            return this.engine.processBlock(bArr2, 0, bArr2.length);
        }
        throw new IllegalArgumentException("input data too large");
    }

    private byte[] decodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte b;
        byte[] processBlock = this.engine.processBlock(bArr, i, i2);
        if (processBlock.length >= getOutputBlockSize()) {
            byte b2 = processBlock[0];
            if (b2 != 1 && b2 != 2) {
                throw new InvalidCipherTextException("unknown block type");
            } else if (!this.useStrictLength || processBlock.length == this.engine.getOutputBlockSize()) {
                int i3 = 1;
                while (i3 != processBlock.length && (b = processBlock[i3]) != 0) {
                    if (b2 != 1 || b == -1) {
                        i3++;
                    } else {
                        throw new InvalidCipherTextException("block padding incorrect");
                    }
                }
                int i4 = i3 + 1;
                if (i4 > processBlock.length || i4 < 10) {
                    throw new InvalidCipherTextException("no data in block");
                }
                byte[] bArr2 = new byte[(processBlock.length - i4)];
                System.arraycopy(processBlock, i4, bArr2, 0, bArr2.length);
                return bArr2;
            } else {
                throw new InvalidCipherTextException("block incorrect size");
            }
        } else {
            throw new InvalidCipherTextException("block truncated");
        }
    }
}
