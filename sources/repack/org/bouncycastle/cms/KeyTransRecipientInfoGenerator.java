package repack.org.bouncycastle.cms;

import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import repack.org.bouncycastle.asn1.cms.RecipientIdentifier;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.operator.AsymmetricKeyWrapper;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.OperatorException;

public abstract class KeyTransRecipientInfoGenerator implements RecipientInfoGenerator {
    private IssuerAndSerialNumber issuerAndSerial;
    private byte[] subjectKeyIdentifier;
    protected final AsymmetricKeyWrapper wrapper;

    protected KeyTransRecipientInfoGenerator(IssuerAndSerialNumber issuerAndSerialNumber, AsymmetricKeyWrapper asymmetricKeyWrapper) {
        this.issuerAndSerial = issuerAndSerialNumber;
        this.wrapper = asymmetricKeyWrapper;
    }

    protected KeyTransRecipientInfoGenerator(byte[] bArr, AsymmetricKeyWrapper asymmetricKeyWrapper) {
        this.subjectKeyIdentifier = bArr;
        this.wrapper = asymmetricKeyWrapper;
    }

    public final RecipientInfo generate(GenericKey genericKey) throws CMSException {
        RecipientIdentifier recipientIdentifier;
        try {
            byte[] generateWrappedKey = this.wrapper.generateWrappedKey(genericKey);
            IssuerAndSerialNumber issuerAndSerialNumber = this.issuerAndSerial;
            if (issuerAndSerialNumber != null) {
                recipientIdentifier = new RecipientIdentifier(issuerAndSerialNumber);
            } else {
                recipientIdentifier = new RecipientIdentifier((ASN1OctetString) new DEROctetString(this.subjectKeyIdentifier));
            }
            return new RecipientInfo(new KeyTransRecipientInfo(recipientIdentifier, this.wrapper.getAlgorithmIdentifier(), new DEROctetString(generateWrappedKey)));
        } catch (OperatorException e) {
            throw new CMSException("exception wrapping content key: " + e.getMessage(), e);
        }
    }
}
