package repack.org.bouncycastle.jce.provider;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import repack.org.bouncycastle.crypto.params.DESParameters;
import repack.org.bouncycastle.util.Strings;

public class JCEDHKeyAgreement extends KeyAgreementSpi {
    private static final Hashtable algorithms = new Hashtable();

    /* renamed from: g */
    private BigInteger f6223g;

    /* renamed from: p */
    private BigInteger f6224p;
    private BigInteger result;

    /* renamed from: x */
    private BigInteger f6225x;

    static {
        Integer num = new Integer(64);
        Integer num2 = new Integer(PsExtractor.AUDIO_STREAM);
        Integer num3 = new Integer(128);
        Integer num4 = new Integer(256);
        algorithms.put("DES", num);
        algorithms.put("DESEDE", num2);
        algorithms.put("BLOWFISH", num3);
        algorithms.put("AES", num4);
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        byte[] bArr = new byte[(byteArray.length - 1)];
        System.arraycopy(byteArray, 1, bArr, 0, bArr.length);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.f6225x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.f6223g) || !dHPublicKey.getParams().getP().equals(this.f6224p)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            } else if (z) {
                this.result = dHPublicKey.getY().modPow(this.f6225x, this.f6224p);
                return null;
            } else {
                this.result = dHPublicKey.getY().modPow(this.f6225x, this.f6224p);
                return new JCEDHPublicKey(this.result, dHPublicKey.getParams());
            }
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.f6225x != null) {
            return bigIntToBytes(this.result);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        if (this.f6225x != null) {
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            if (bArr.length - i >= bigIntToBytes.length) {
                System.arraycopy(bigIntToBytes, 0, bArr, i, bigIntToBytes.length);
                return bigIntToBytes.length;
            }
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    public SecretKey engineGenerateSecret(String str) {
        if (this.f6225x != null) {
            String upperCase = Strings.toUpperCase(str);
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            if (!algorithms.containsKey(upperCase)) {
                return new SecretKeySpec(bigIntToBytes, str);
            }
            byte[] bArr = new byte[(((Integer) algorithms.get(upperCase)).intValue() / 8)];
            System.arraycopy(bigIntToBytes, 0, bArr, 0, bArr.length);
            if (upperCase.startsWith("DES")) {
                DESParameters.setOddParity(bArr);
            }
            return new SecretKeySpec(bArr, str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.f6224p = dHPrivateKey.getParams().getP();
                this.f6223g = dHPrivateKey.getParams().getG();
            } else if (algorithmParameterSpec instanceof DHParameterSpec) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.f6224p = dHParameterSpec.getP();
                this.f6223g = dHParameterSpec.getG();
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.f6225x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.f6224p = dHPrivateKey.getParams().getP();
            this.f6223g = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.f6225x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
