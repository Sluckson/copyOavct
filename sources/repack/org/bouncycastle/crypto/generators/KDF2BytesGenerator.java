package repack.org.bouncycastle.crypto.generators;

import repack.org.bouncycastle.crypto.Digest;

public class KDF2BytesGenerator extends BaseKDFBytesGenerator {
    public KDF2BytesGenerator(Digest digest) {
        super(1, digest);
    }
}
