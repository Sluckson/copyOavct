package repack.org.bouncycastle.asn1.cms;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1SequenceParser;
import repack.org.bouncycastle.asn1.ASN1TaggedObjectParser;
import repack.org.bouncycastle.asn1.DEREncodable;

public class ContentInfoParser {
    private ASN1TaggedObjectParser content;
    private ASN1ObjectIdentifier contentType;

    public ContentInfoParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.contentType = (ASN1ObjectIdentifier) aSN1SequenceParser.readObject();
        this.content = (ASN1TaggedObjectParser) aSN1SequenceParser.readObject();
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public DEREncodable getContent(int i) throws IOException {
        ASN1TaggedObjectParser aSN1TaggedObjectParser = this.content;
        if (aSN1TaggedObjectParser != null) {
            return aSN1TaggedObjectParser.getObjectParser(i, true);
        }
        return null;
    }
}
