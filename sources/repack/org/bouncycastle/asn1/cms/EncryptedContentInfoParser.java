package repack.org.bouncycastle.asn1.cms;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1SequenceParser;
import repack.org.bouncycastle.asn1.ASN1TaggedObjectParser;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedContentInfoParser {
    private AlgorithmIdentifier _contentEncryptionAlgorithm;
    private DERObjectIdentifier _contentType;
    private ASN1TaggedObjectParser _encryptedContent;

    public EncryptedContentInfoParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this._contentType = (DERObjectIdentifier) aSN1SequenceParser.readObject();
        this._contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(aSN1SequenceParser.readObject().getDERObject());
        this._encryptedContent = (ASN1TaggedObjectParser) aSN1SequenceParser.readObject();
    }

    public DERObjectIdentifier getContentType() {
        return this._contentType;
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this._contentEncryptionAlgorithm;
    }

    public DEREncodable getEncryptedContent(int i) throws IOException {
        return this._encryptedContent.getObjectParser(i, false);
    }
}
