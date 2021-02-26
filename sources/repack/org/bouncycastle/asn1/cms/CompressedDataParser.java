package repack.org.bouncycastle.asn1.cms;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1SequenceParser;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CompressedDataParser {
    private AlgorithmIdentifier _compressionAlgorithm;
    private ContentInfoParser _encapContentInfo;
    private DERInteger _version;

    public CompressedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this._version = (DERInteger) aSN1SequenceParser.readObject();
        this._compressionAlgorithm = AlgorithmIdentifier.getInstance(aSN1SequenceParser.readObject().getDERObject());
        this._encapContentInfo = new ContentInfoParser((ASN1SequenceParser) aSN1SequenceParser.readObject());
    }

    public DERInteger getVersion() {
        return this._version;
    }

    public AlgorithmIdentifier getCompressionAlgorithmIdentifier() {
        return this._compressionAlgorithm;
    }

    public ContentInfoParser getEncapContentInfo() {
        return this._encapContentInfo;
    }
}
