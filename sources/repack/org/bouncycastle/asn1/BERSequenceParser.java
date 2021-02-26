package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class BERSequenceParser implements ASN1SequenceParser {
    private ASN1StreamParser _parser;

    BERSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public DEREncodable readObject() throws IOException {
        return this._parser.readObject();
    }

    public DERObject getLoadedObject() throws IOException {
        return new BERSequence(this._parser.readVector());
    }

    public DERObject getDERObject() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
