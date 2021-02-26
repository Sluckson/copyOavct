package repack.org.bouncycastle.crypto.agreement.kdf;

import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.DerivationFunction;
import repack.org.bouncycastle.crypto.DerivationParameters;
import repack.org.bouncycastle.crypto.Digest;

public class DHKEKGenerator implements DerivationFunction {
    private DERObjectIdentifier algorithm;
    private final Digest digest;
    private int keySize;
    private byte[] partyAInfo;

    /* renamed from: z */
    private byte[] f5906z;

    public DHKEKGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.f5906z = dHKDFParameters.getZ();
        this.partyAInfo = dHKDFParameters.getExtraInfo();
    }

    public Digest getDigest() {
        return this.digest;
    }

    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i2 >= i) {
            long j = (long) i2;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = (long) digestSize;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr2 = new byte[this.digest.getDigestSize()];
                int i4 = i;
                int i5 = i2;
                int i6 = 1;
                for (int i7 = 0; i7 < i3; i7++) {
                    Digest digest2 = this.digest;
                    byte[] bArr3 = this.f5906z;
                    digest2.update(bArr3, 0, bArr3.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(this.algorithm);
                    aSN1EncodableVector2.add(new DEROctetString(integerToBytes(i6)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    byte[] bArr4 = this.partyAInfo;
                    if (bArr4 != null) {
                        aSN1EncodableVector.add(new DERTaggedObject(true, 0, new DEROctetString(bArr4)));
                    }
                    aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(integerToBytes(this.keySize))));
                    byte[] dEREncoded = new DERSequence(aSN1EncodableVector).getDEREncoded();
                    this.digest.update(dEREncoded, 0, dEREncoded.length);
                    this.digest.doFinal(bArr2, 0);
                    if (i5 > digestSize) {
                        System.arraycopy(bArr2, 0, bArr, i4, digestSize);
                        i4 += digestSize;
                        i5 -= digestSize;
                    } else {
                        System.arraycopy(bArr2, 0, bArr, i4, i5);
                    }
                    i6++;
                }
                this.digest.reset();
                return i5;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new DataLengthException("output buffer too small");
    }

    private byte[] integerToBytes(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }
}
