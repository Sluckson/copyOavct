package repack.org.bouncycastle.crypto.signers;

import java.io.IOException;
import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;

public class DSADigestSigner implements Signer {
    private final Digest digest;
    private final DSA dsaSigner;
    private boolean forSigning;

    public DSADigestSigner(DSA dsa, Digest digest2) {
        this.digest = digest2;
        this.dsaSigner = dsa;
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
            throw new IllegalArgumentException("Signing Requires Private Key.");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.dsaSigner.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
    }

    public void update(byte b) {
        this.digest.update(b);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    public byte[] generateSignature() {
        if (this.forSigning) {
            byte[] bArr = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr, 0);
            BigInteger[] generateSignature = this.dsaSigner.generateSignature(bArr);
            return derEncode(generateSignature[0], generateSignature[1]);
        }
        throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
    }

    public boolean verifySignature(byte[] bArr) {
        if (!this.forSigning) {
            byte[] bArr2 = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr2, 0);
            try {
                BigInteger[] derDecode = derDecode(bArr);
                return this.dsaSigner.verifySignature(bArr2, derDecode[0], derDecode[1]);
            } catch (IOException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("DSADigestSigner not initialised for verification");
        }
    }

    public void reset() {
        this.digest.reset();
    }

    private byte[] derEncode(BigInteger bigInteger, BigInteger bigInteger2) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(bigInteger));
        aSN1EncodableVector.add(new DERInteger(bigInteger2));
        return new DERSequence(aSN1EncodableVector).getDEREncoded();
    }

    private BigInteger[] derDecode(byte[] bArr) throws IOException {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Object.fromByteArray(bArr);
        return new BigInteger[]{((DERInteger) aSN1Sequence.getObjectAt(0)).getValue(), ((DERInteger) aSN1Sequence.getObjectAt(1)).getValue()};
    }
}
