package repack.org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    private boolean _constructed;
    private ASN1StreamParser _parser;
    private int _tagNumber;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected BERTaggedObjectParser(int i, int i2, InputStream inputStream) {
        this((i & 32) != 0, i2, new ASN1StreamParser(inputStream));
    }

    BERTaggedObjectParser(boolean z, int i, ASN1StreamParser aSN1StreamParser) {
        this._constructed = z;
        this._tagNumber = i;
        this._parser = aSN1StreamParser;
    }

    public boolean isConstructed() {
        return this._constructed;
    }

    public int getTagNo() {
        return this._tagNumber;
    }

    public DEREncodable getObjectParser(int i, boolean z) throws IOException {
        if (!z) {
            return this._parser.readImplicit(this._constructed, i);
        }
        if (this._constructed) {
            return this._parser.readObject();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    public DERObject getLoadedObject() throws IOException {
        return this._parser.readTaggedObject(this._constructed, this._tagNumber);
    }

    public DERObject getDERObject() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage());
        }
    }
}
