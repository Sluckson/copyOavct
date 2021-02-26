package repack.org.bouncycastle.asn1.cms;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1SequenceParser;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1SetParser;
import repack.org.bouncycastle.asn1.ASN1TaggedObjectParser;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;

public class SignedDataParser {
    private boolean _certsCalled;
    private boolean _crlsCalled;
    private Object _nextObject;
    private ASN1SequenceParser _seq;
    private DERInteger _version;

    public static SignedDataParser getInstance(Object obj) throws IOException {
        if (obj instanceof ASN1Sequence) {
            return new SignedDataParser(((ASN1Sequence) obj).parser());
        }
        if (obj instanceof ASN1SequenceParser) {
            return new SignedDataParser((ASN1SequenceParser) obj);
        }
        throw new IOException("unknown object encountered: " + obj.getClass().getName());
    }

    private SignedDataParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this._seq = aSN1SequenceParser;
        this._version = (DERInteger) aSN1SequenceParser.readObject();
    }

    public DERInteger getVersion() {
        return this._version;
    }

    public ASN1SetParser getDigestAlgorithms() throws IOException {
        DEREncodable readObject = this._seq.readObject();
        if (readObject instanceof ASN1Set) {
            return ((ASN1Set) readObject).parser();
        }
        return (ASN1SetParser) readObject;
    }

    public ContentInfoParser getEncapContentInfo() throws IOException {
        return new ContentInfoParser((ASN1SequenceParser) this._seq.readObject());
    }

    public ASN1SetParser getCertificates() throws IOException {
        this._certsCalled = true;
        this._nextObject = this._seq.readObject();
        Object obj = this._nextObject;
        if (!(obj instanceof ASN1TaggedObjectParser) || ((ASN1TaggedObjectParser) obj).getTagNo() != 0) {
            return null;
        }
        ASN1SetParser aSN1SetParser = (ASN1SetParser) ((ASN1TaggedObjectParser) this._nextObject).getObjectParser(17, false);
        this._nextObject = null;
        return aSN1SetParser;
    }

    public ASN1SetParser getCrls() throws IOException {
        if (this._certsCalled) {
            this._crlsCalled = true;
            if (this._nextObject == null) {
                this._nextObject = this._seq.readObject();
            }
            Object obj = this._nextObject;
            if (!(obj instanceof ASN1TaggedObjectParser) || ((ASN1TaggedObjectParser) obj).getTagNo() != 1) {
                return null;
            }
            ASN1SetParser aSN1SetParser = (ASN1SetParser) ((ASN1TaggedObjectParser) this._nextObject).getObjectParser(17, false);
            this._nextObject = null;
            return aSN1SetParser;
        }
        throw new IOException("getCerts() has not been called.");
    }

    public ASN1SetParser getSignerInfos() throws IOException {
        if (!this._certsCalled || !this._crlsCalled) {
            throw new IOException("getCerts() and/or getCrls() has not been called.");
        }
        if (this._nextObject == null) {
            this._nextObject = this._seq.readObject();
        }
        return (ASN1SetParser) this._nextObject;
    }
}
