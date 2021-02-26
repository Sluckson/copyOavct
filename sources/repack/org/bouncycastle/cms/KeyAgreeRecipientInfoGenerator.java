package repack.org.bouncycastle.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import repack.org.bouncycastle.asn1.cms.OriginatorIdentifierOrKey;
import repack.org.bouncycastle.asn1.cms.OriginatorPublicKey;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.operator.GenericKey;

public abstract class KeyAgreeRecipientInfoGenerator implements RecipientInfoGenerator {
    private ASN1ObjectIdentifier keyAgreementOID;
    private ASN1ObjectIdentifier keyEncryptionOID;
    private SubjectPublicKeyInfo originatorKeyInfo;

    /* access modifiers changed from: protected */
    public abstract ASN1Sequence generateRecipientEncryptedKeys(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, GenericKey genericKey) throws CMSException;

    /* access modifiers changed from: protected */
    public abstract ASN1Encodable getUserKeyingMaterial(AlgorithmIdentifier algorithmIdentifier) throws CMSException;

    protected KeyAgreeRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.originatorKeyInfo = subjectPublicKeyInfo;
        this.keyAgreementOID = aSN1ObjectIdentifier;
        this.keyEncryptionOID = aSN1ObjectIdentifier2;
    }

    public RecipientInfo generate(GenericKey genericKey) throws CMSException {
        OriginatorIdentifierOrKey originatorIdentifierOrKey = new OriginatorIdentifierOrKey(createOriginatorPublicKey(this.originatorKeyInfo));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.keyEncryptionOID);
        aSN1EncodableVector.add(DERNull.INSTANCE);
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(this.keyEncryptionOID, DERNull.INSTANCE);
        AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(this.keyAgreementOID, algorithmIdentifier);
        ASN1Sequence generateRecipientEncryptedKeys = generateRecipientEncryptedKeys(algorithmIdentifier2, algorithmIdentifier, genericKey);
        ASN1Encodable userKeyingMaterial = getUserKeyingMaterial(algorithmIdentifier2);
        if (userKeyingMaterial != null) {
            return new RecipientInfo(new KeyAgreeRecipientInfo(originatorIdentifierOrKey, new DEROctetString((DEREncodable) userKeyingMaterial), algorithmIdentifier2, generateRecipientEncryptedKeys));
        }
        return new RecipientInfo(new KeyAgreeRecipientInfo(originatorIdentifierOrKey, (ASN1OctetString) null, algorithmIdentifier2, generateRecipientEncryptedKeys));
    }

    /* access modifiers changed from: protected */
    public OriginatorPublicKey createOriginatorPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new OriginatorPublicKey(new AlgorithmIdentifier(subjectPublicKeyInfo.getAlgorithmId().getAlgorithm(), DERNull.INSTANCE), subjectPublicKeyInfo.getPublicKeyData().getBytes());
    }
}
