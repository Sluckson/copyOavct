package repack.org.bouncycastle.cms;

import java.io.InputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.InputDecryptor;
import repack.org.bouncycastle.operator.MacCalculator;
import repack.org.bouncycastle.util.p072io.TeeInputStream;

public class RecipientOperator {
    private final AlgorithmIdentifier algorithmIdentifier;
    private final Object operator;

    public RecipientOperator(InputDecryptor inputDecryptor) {
        this.algorithmIdentifier = inputDecryptor.getAlgorithmIdentifier();
        this.operator = inputDecryptor;
    }

    public RecipientOperator(MacCalculator macCalculator) {
        this.algorithmIdentifier = macCalculator.getAlgorithmIdentifier();
        this.operator = macCalculator;
    }

    public InputStream getInputStream(InputStream inputStream) {
        Object obj = this.operator;
        if (obj instanceof InputDecryptor) {
            return ((InputDecryptor) obj).getInputStream(inputStream);
        }
        return new TeeInputStream(inputStream, ((MacCalculator) obj).getOutputStream());
    }

    public boolean isMacBased() {
        return this.operator instanceof MacCalculator;
    }

    public byte[] getMac() {
        return ((MacCalculator) this.operator).getMac();
    }
}
