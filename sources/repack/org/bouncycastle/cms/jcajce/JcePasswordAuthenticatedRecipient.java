package repack.org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.Key;
import javax.crypto.Mac;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.cms.RecipientOperator;
import repack.org.bouncycastle.jcajce.p068io.MacOutputStream;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.MacCalculator;

public class JcePasswordAuthenticatedRecipient extends JcePasswordRecipient {
    public JcePasswordAuthenticatedRecipient(char[] cArr) {
        super(cArr);
    }

    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, final AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2) throws CMSException {
        final Key extractSecretKey = extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr, bArr2);
        final Mac createContentMac = this.helper.createContentMac(extractSecretKey, algorithmIdentifier2);
        return new RecipientOperator((MacCalculator) new MacCalculator() {
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier2;
            }

            public GenericKey getKey() {
                return new GenericKey(extractSecretKey);
            }

            public OutputStream getOutputStream() {
                return new MacOutputStream(createContentMac);
            }

            public byte[] getMac() {
                return createContentMac.doFinal();
            }
        });
    }
}
