package repack.org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import repack.org.bouncycastle.util.Arrays;
import repack.org.bouncycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Object implements ASN1OctetStringParser {
    byte[] string;

    /* access modifiers changed from: package-private */
    public abstract void encode(DEROutputStream dEROutputStream) throws IOException;

    public ASN1OctetStringParser parser() {
        return this;
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1OctetString)) {
            return getInstance(object);
        }
        return BERConstructedOctetString.fromSequence(ASN1Sequence.getInstance(object));
    }

    public static ASN1OctetString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1OctetString)) {
            return (ASN1OctetString) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public ASN1OctetString(byte[] bArr) {
        if (bArr != null) {
            this.string = bArr;
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    public ASN1OctetString(DEREncodable dEREncodable) {
        try {
            this.string = dEREncodable.getDERObject().getEncoded(ASN1Encodable.DER);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error processing object : " + e.toString());
        }
    }

    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    public byte[] getOctets() {
        return this.string;
    }

    public int hashCode() {
        return Arrays.hashCode(getOctets());
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof ASN1OctetString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((ASN1OctetString) dERObject).string);
    }

    public DERObject getLoadedObject() {
        return getDERObject();
    }

    public String toString() {
        return "#" + new String(Hex.encode(this.string));
    }
}
