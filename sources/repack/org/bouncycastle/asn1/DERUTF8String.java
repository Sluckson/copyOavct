package repack.org.bouncycastle.asn1;

import java.io.IOException;
import repack.org.bouncycastle.util.Strings;

public class DERUTF8String extends ASN1Object implements DERString {
    String string;

    public static DERUTF8String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUTF8String)) {
            return (DERUTF8String) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERUTF8String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERUTF8String)) {
            return getInstance(object);
        }
        return new DERUTF8String(ASN1OctetString.getInstance(object).getOctets());
    }

    public DERUTF8String(byte[] bArr) {
        try {
            this.string = Strings.fromUTF8ByteArray(bArr);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("UTF8 encoding invalid");
        }
    }

    public DERUTF8String(String str) {
        this.string = str;
    }

    public String getString() {
        return this.string;
    }

    public String toString() {
        return this.string;
    }

    public int hashCode() {
        return getString().hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERUTF8String)) {
            return false;
        }
        return getString().equals(((DERUTF8String) dERObject).getString());
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(12, Strings.toUTF8ByteArray(this.string));
    }
}
