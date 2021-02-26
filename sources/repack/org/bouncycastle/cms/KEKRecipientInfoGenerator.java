package repack.org.bouncycastle.cms;

import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cms.KEKIdentifier;
import repack.org.bouncycastle.asn1.cms.KEKRecipientInfo;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.OperatorException;
import repack.org.bouncycastle.operator.SymmetricKeyWrapper;

public abstract class KEKRecipientInfoGenerator implements RecipientInfoGenerator {
    private final KEKIdentifier kekIdentifier;
    protected final SymmetricKeyWrapper wrapper;

    protected KEKRecipientInfoGenerator(KEKIdentifier kEKIdentifier, SymmetricKeyWrapper symmetricKeyWrapper) {
        this.kekIdentifier = kEKIdentifier;
        this.wrapper = symmetricKeyWrapper;
    }

    public final RecipientInfo generate(GenericKey genericKey) throws CMSException {
        try {
            return new RecipientInfo(new KEKRecipientInfo(this.kekIdentifier, this.wrapper.getAlgorithmIdentifier(), new DEROctetString(this.wrapper.generateWrappedKey(genericKey))));
        } catch (OperatorException e) {
            throw new CMSException("exception wrapping content key: " + e.getMessage(), e);
        }
    }
}
