package repack.org.bouncycastle.jce.provider.asymmetric.p069ec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DEROutputStream;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.digests.RIPEMD160Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA224Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.digests.SHA384Digest;
import repack.org.bouncycastle.crypto.digests.SHA512Digest;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.crypto.signers.ECDSASigner;
import repack.org.bouncycastle.crypto.signers.ECNRSigner;
import repack.org.bouncycastle.jce.interfaces.ECKey;
import repack.org.bouncycastle.jce.interfaces.ECPublicKey;
import repack.org.bouncycastle.jce.provider.DSABase;
import repack.org.bouncycastle.jce.provider.DSAEncoder;
import repack.org.bouncycastle.jce.provider.JDKKeyFactory;

/* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature */
public class Signature extends DSABase {
    Signature(String str, Digest digest, DSA dsa, DSAEncoder dSAEncoder) {
        super(str, digest, dsa, dSAEncoder);
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (publicKey instanceof ECPublicKey) {
            asymmetricKeyParameter = ECUtil.generatePublicKeyParameter(publicKey);
        } else {
            try {
                PublicKey createPublicKeyFromDERStream = JDKKeyFactory.createPublicKeyFromDERStream(publicKey.getEncoded());
                if (createPublicKeyFromDERStream instanceof ECPublicKey) {
                    asymmetricKeyParameter = ECUtil.generatePublicKeyParameter(createPublicKeyFromDERStream);
                } else {
                    throw new InvalidKeyException("can't recognise key type in ECDSA based signer");
                }
            } catch (Exception unused) {
                throw new InvalidKeyException("can't recognise key type in ECDSA based signer");
            }
        }
        this.digest.reset();
        this.signer.init(false, asymmetricKeyParameter);
    }

    /* access modifiers changed from: protected */
    public void doEngineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        if (privateKey instanceof ECKey) {
            AsymmetricKeyParameter generatePrivateKeyParameter = ECUtil.generatePrivateKeyParameter(privateKey);
            this.digest.reset();
            if (secureRandom != null) {
                this.signer.init(true, new ParametersWithRandom(generatePrivateKeyParameter, secureRandom));
            } else {
                this.signer.init(true, generatePrivateKeyParameter);
            }
        } else {
            throw new InvalidKeyException("can't recognise key type in ECDSA based signer");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecDSA */
    public static class ecDSA extends Signature {
        public ecDSA() {
            super("ECDSA", new SHA1Digest(), new ECDSASigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecDSAnone */
    public static class ecDSAnone extends Signature {
        public ecDSAnone() {
            super("NONEwithECDSA", new NullDigest((NullDigest) null), new ECDSASigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecDSA224 */
    public static class ecDSA224 extends Signature {
        public ecDSA224() {
            super("ECDSAwithSHA224", new SHA224Digest(), new ECDSASigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecDSA256 */
    public static class ecDSA256 extends Signature {
        public ecDSA256() {
            super("ECDSAwithSHA256", new SHA256Digest(), new ECDSASigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecDSA384 */
    public static class ecDSA384 extends Signature {
        public ecDSA384() {
            super("ECDSAwithSHA384", new SHA384Digest(), new ECDSASigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecDSA512 */
    public static class ecDSA512 extends Signature {
        public ecDSA512() {
            super("ECDSAwithSHA512", new SHA512Digest(), new ECDSASigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecDSARipeMD160 */
    public static class ecDSARipeMD160 extends Signature {
        public ecDSARipeMD160() {
            super("ECDSAwithRIPEMD160", new RIPEMD160Digest(), new ECDSASigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecNR */
    public static class ecNR extends Signature {
        public ecNR() {
            super("ECNR", new SHA1Digest(), new ECNRSigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecNR224 */
    public static class ecNR224 extends Signature {
        public ecNR224() {
            super("ECNRwithSHA224", new SHA224Digest(), new ECNRSigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecNR256 */
    public static class ecNR256 extends Signature {
        public ecNR256() {
            super("ECNRwithSHA256", new SHA256Digest(), new ECNRSigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecNR384 */
    public static class ecNR384 extends Signature {
        public ecNR384() {
            super("ECNRwithSHA384", new SHA384Digest(), new ECNRSigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecNR512 */
    public static class ecNR512 extends Signature {
        public ecNR512() {
            super("ECNRwithSHA512", new SHA512Digest(), new ECNRSigner(), new StdDSAEncoder((StdDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecCVCDSA */
    public static class ecCVCDSA extends Signature {
        public ecCVCDSA() {
            super("CVC-ECDSA", new SHA1Digest(), new ECDSASigner(), new CVCDSAEncoder((CVCDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecCVCDSA224 */
    public static class ecCVCDSA224 extends Signature {
        public ecCVCDSA224() {
            super("CVC-ECDSAwithSHA224", new SHA224Digest(), new ECDSASigner(), new CVCDSAEncoder((CVCDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$ecCVCDSA256 */
    public static class ecCVCDSA256 extends Signature {
        public ecCVCDSA256() {
            super("CVC-ECDSAwithSHA256", new SHA256Digest(), new ECDSASigner(), new CVCDSAEncoder((CVCDSAEncoder) null));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$StdDSAEncoder */
    private static class StdDSAEncoder implements DSAEncoder {
        private StdDSAEncoder() {
        }

        /* synthetic */ StdDSAEncoder(StdDSAEncoder stdDSAEncoder) {
            this();
        }

        public byte[] encode(BigInteger bigInteger, BigInteger bigInteger2) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new DERInteger(bigInteger));
            aSN1EncodableVector.add(new DERInteger(bigInteger2));
            dEROutputStream.writeObject(new DERSequence(aSN1EncodableVector));
            return byteArrayOutputStream.toByteArray();
        }

        public BigInteger[] decode(byte[] bArr) throws IOException {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(bArr).readObject();
            return new BigInteger[]{((DERInteger) aSN1Sequence.getObjectAt(0)).getValue(), ((DERInteger) aSN1Sequence.getObjectAt(1)).getValue()};
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$CVCDSAEncoder */
    private static class CVCDSAEncoder implements DSAEncoder {
        private CVCDSAEncoder() {
        }

        /* synthetic */ CVCDSAEncoder(CVCDSAEncoder cVCDSAEncoder) {
            this();
        }

        public byte[] encode(BigInteger bigInteger, BigInteger bigInteger2) throws IOException {
            byte[] bArr;
            byte[] makeUnsigned = makeUnsigned(bigInteger);
            byte[] makeUnsigned2 = makeUnsigned(bigInteger2);
            if (makeUnsigned.length > makeUnsigned2.length) {
                bArr = new byte[(makeUnsigned.length * 2)];
            } else {
                bArr = new byte[(makeUnsigned2.length * 2)];
            }
            System.arraycopy(makeUnsigned, 0, bArr, (bArr.length / 2) - makeUnsigned.length, makeUnsigned.length);
            System.arraycopy(makeUnsigned2, 0, bArr, bArr.length - makeUnsigned2.length, makeUnsigned2.length);
            return bArr;
        }

        private byte[] makeUnsigned(BigInteger bigInteger) {
            byte[] byteArray = bigInteger.toByteArray();
            if (byteArray[0] != 0) {
                return byteArray;
            }
            byte[] bArr = new byte[(byteArray.length - 1)];
            System.arraycopy(byteArray, 1, bArr, 0, bArr.length);
            return bArr;
        }

        public BigInteger[] decode(byte[] bArr) throws IOException {
            byte[] bArr2 = new byte[(bArr.length / 2)];
            byte[] bArr3 = new byte[(bArr.length / 2)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            System.arraycopy(bArr, bArr2.length, bArr3, 0, bArr3.length);
            return new BigInteger[]{new BigInteger(1, bArr2), new BigInteger(1, bArr3)};
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.Signature$NullDigest */
    private static class NullDigest implements Digest {
        private ByteArrayOutputStream bOut;

        public String getAlgorithmName() {
            return "NULL";
        }

        private NullDigest() {
            this.bOut = new ByteArrayOutputStream();
        }

        /* synthetic */ NullDigest(NullDigest nullDigest) {
            this();
        }

        public int getDigestSize() {
            return this.bOut.size();
        }

        public void update(byte b) {
            this.bOut.write(b);
        }

        public void update(byte[] bArr, int i, int i2) {
            this.bOut.write(bArr, i, i2);
        }

        public int doFinal(byte[] bArr, int i) {
            byte[] byteArray = this.bOut.toByteArray();
            System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
            return byteArray.length;
        }

        public void reset() {
            this.bOut.reset();
        }
    }
}
