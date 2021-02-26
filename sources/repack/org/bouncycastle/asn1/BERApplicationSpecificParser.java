package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    private final ASN1StreamParser parser;
    private final int tag;

    BERApplicationSpecificParser(int i, ASN1StreamParser aSN1StreamParser) {
        this.tag = i;
        this.parser = aSN1StreamParser;
    }

    public DEREncodable readObject() throws IOException {
        return this.parser.readObject();
    }

    public DERObject getLoadedObject() throws IOException {
        return new BERApplicationSpecific(this.tag, this.parser.readVector());
    }

    public DERObject getDERObject() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
