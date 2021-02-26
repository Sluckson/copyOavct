package repack.org.bouncycastle.cms.jcajce;

import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.cms.KeyTransRecipient;
import repack.org.bouncycastle.jcajce.DefaultJcaJceHelper;
import repack.org.bouncycastle.jcajce.NamedJcaJceHelper;
import repack.org.bouncycastle.jcajce.ProviderJcaJceHelper;
import repack.org.bouncycastle.operator.OperatorException;

public abstract class JceKeyTransRecipient implements KeyTransRecipient {
    protected EnvelopedDataHelper contentHelper = this.helper;
    protected EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceHelper());
    private PrivateKey recipientKey;

    public JceKeyTransRecipient(PrivateKey privateKey) {
        this.recipientKey = privateKey;
    }

    public JceKeyTransRecipient setProvider(Provider provider) {
        this.helper = new EnvelopedDataHelper(new ProviderJcaJceHelper(provider));
        this.contentHelper = this.helper;
        return this;
    }

    public JceKeyTransRecipient setProvider(String str) {
        this.helper = new EnvelopedDataHelper(new NamedJcaJceHelper(str));
        this.contentHelper = this.helper;
        return this;
    }

    public JceKeyTransRecipient setContentProvider(Provider provider) {
        this.contentHelper = new EnvelopedDataHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceKeyTransRecipient setContentProvider(String str) {
        this.contentHelper = new EnvelopedDataHelper(new NamedJcaJceHelper(str));
        return this;
    }

    /* access modifiers changed from: protected */
    public Key extractSecretKey(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) throws CMSException {
        try {
            return CMSUtils.getJceKey(this.helper.createAsymmetricUnwrapper(algorithmIdentifier, this.recipientKey).generateUnwrappedKey(algorithmIdentifier2, bArr));
        } catch (OperatorException e) {
            throw new CMSException("exception unwrapping key: " + e.getMessage(), e);
        }
    }
}
