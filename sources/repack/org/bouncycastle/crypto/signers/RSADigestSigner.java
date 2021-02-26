package repack.org.bouncycastle.crypto.signers;

import java.util.Hashtable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DigestInfo;
import repack.org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.encodings.PKCS1Encoding;
import repack.org.bouncycastle.crypto.engines.RSABlindedEngine;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;

public class RSADigestSigner implements Signer {
    private static final Hashtable oidMap = new Hashtable();
    private final AlgorithmIdentifier algId;
    private final Digest digest;
    private boolean forSigning;
    private final AsymmetricBlockCipher rsaEngine = new PKCS1Encoding(new RSABlindedEngine());

    static {
        oidMap.put("RIPEMD128", TeleTrusTObjectIdentifiers.ripemd128);
        oidMap.put("RIPEMD160", TeleTrusTObjectIdentifiers.ripemd160);
        oidMap.put("RIPEMD256", TeleTrusTObjectIdentifiers.ripemd256);
        oidMap.put("SHA-1", X509ObjectIdentifiers.id_SHA1);
        oidMap.put("SHA-224", NISTObjectIdentifiers.id_sha224);
        oidMap.put("SHA-256", NISTObjectIdentifiers.id_sha256);
        oidMap.put("SHA-384", NISTObjectIdentifiers.id_sha384);
        oidMap.put("SHA-512", NISTObjectIdentifiers.id_sha512);
        oidMap.put("MD2", PKCSObjectIdentifiers.md2);
        oidMap.put("MD4", PKCSObjectIdentifiers.md4);
        oidMap.put("MD5", PKCSObjectIdentifiers.md5);
    }

    public RSADigestSigner(Digest digest2) {
        this.digest = digest2;
        this.algId = new AlgorithmIdentifier((DERObjectIdentifier) oidMap.get(digest2.getAlgorithmName()), DERNull.INSTANCE);
    }

    public String getAlgorithmName() {
        return String.valueOf(this.digest.getAlgorithmName()) + "withRSA";
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.forSigning = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.rsaEngine.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("verification requires public key");
        }
    }

    public void update(byte b) {
        this.digest.update(b);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    public byte[] generateSignature() throws CryptoException, DataLengthException {
        if (this.forSigning) {
            byte[] bArr = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr, 0);
            byte[] derEncode = derEncode(bArr);
            return this.rsaEngine.processBlock(derEncode, 0, derEncode.length);
        }
        throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
    }

    public boolean verifySignature(byte[] bArr) {
        if (!this.forSigning) {
            byte[] bArr2 = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr2, 0);
            try {
                byte[] processBlock = this.rsaEngine.processBlock(bArr, 0, bArr.length);
                byte[] derEncode = derEncode(bArr2);
                if (processBlock.length == derEncode.length) {
                    for (int i = 0; i < processBlock.length; i++) {
                        if (processBlock[i] != derEncode[i]) {
                            return false;
                        }
                    }
                } else {
                    if (processBlock.length == derEncode.length - 2) {
                        int length = (processBlock.length - bArr2.length) - 2;
                        int length2 = (derEncode.length - bArr2.length) - 2;
                        derEncode[1] = (byte) (derEncode[1] - 2);
                        derEncode[3] = (byte) (derEncode[3] - 2);
                        for (int i2 = 0; i2 < bArr2.length; i2++) {
                            if (processBlock[length + i2] != derEncode[length2 + i2]) {
                                return false;
                            }
                        }
                        for (int i3 = 0; i3 < length; i3++) {
                            if (processBlock[i3] != derEncode[i3]) {
                                return false;
                            }
                        }
                    }
                    return false;
                }
                return true;
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("RSADigestSigner not initialised for verification");
        }
    }

    public void reset() {
        this.digest.reset();
    }

    private byte[] derEncode(byte[] bArr) {
        return new DigestInfo(this.algId, bArr).getDEREncoded();
    }
}
