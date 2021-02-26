package repack.org.bouncycastle.crypto.agreement.kdf;

import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.DerivationFunction;
import repack.org.bouncycastle.crypto.DerivationParameters;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import repack.org.bouncycastle.crypto.params.KDFParameters;

public class ECDHKEKGenerator implements DerivationFunction {
    private DERObjectIdentifier algorithm;
    private DerivationFunction kdf;
    private int keySize;

    /* renamed from: z */
    private byte[] f5907z;

    public ECDHKEKGenerator(Digest digest) {
        this.kdf = new KDF2BytesGenerator(digest);
    }

    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.f5907z = dHKDFParameters.getZ();
    }

    public Digest getDigest() {
        return this.kdf.getDigest();
    }

    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new AlgorithmIdentifier(this.algorithm, new DERNull()));
        aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(integerToBytes(this.keySize))));
        this.kdf.init(new KDFParameters(this.f5907z, new DERSequence(aSN1EncodableVector).getDEREncoded()));
        return this.kdf.generateBytes(bArr, i, i2);
    }

    private byte[] integerToBytes(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }
}
