package repack.org.bouncycastle.operator.p071bc;

import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;

/* renamed from: repack.org.bouncycastle.operator.bc.BcDigestCalculatorProvider */
public class BcDigestCalculatorProvider implements DigestCalculatorProvider {
    /* access modifiers changed from: private */
    public DigestOutputStream stream;

    public DigestCalculator get(final AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
        this.stream = new DigestOutputStream(BcUtil.createDigest(algorithmIdentifier));
        return new DigestCalculator() {
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier;
            }

            public OutputStream getOutputStream() {
                return BcDigestCalculatorProvider.this.stream;
            }

            public byte[] getDigest() {
                return BcDigestCalculatorProvider.this.stream.getDigest();
            }
        };
    }

    /* renamed from: repack.org.bouncycastle.operator.bc.BcDigestCalculatorProvider$DigestOutputStream */
    private class DigestOutputStream extends OutputStream {
        private Digest dig;

        DigestOutputStream(Digest digest) {
            this.dig = digest;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dig.update(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.dig.update(bArr, 0, bArr.length);
        }

        public void write(int i) throws IOException {
            this.dig.update((byte) i);
        }

        /* access modifiers changed from: package-private */
        public byte[] getDigest() {
            byte[] bArr = new byte[this.dig.getDigestSize()];
            this.dig.doFinal(bArr, 0);
            return bArr;
        }
    }
}
