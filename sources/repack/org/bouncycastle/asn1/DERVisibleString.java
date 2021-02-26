package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class DERVisibleString extends ASN1Object implements DERString {
    String string;

    public static DERVisibleString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERVisibleString)) {
            return (DERVisibleString) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERVisibleString(((ASN1OctetString) obj).getOctets());
        }
        if (obj instanceof ASN1TaggedObject) {
            return getInstance(((ASN1TaggedObject) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERVisibleString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERVisibleString(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.string = new String(cArr);
    }

    public DERVisibleString(String str) {
        this.string = str;
    }

    public String getString() {
        return this.string;
    }

    public String toString() {
        return this.string;
    }

    public byte[] getOctets() {
        char[] charArray = this.string.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i != charArray.length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(26, getOctets());
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERVisibleString)) {
            return false;
        }
        return getString().equals(((DERVisibleString) dERObject).getString());
    }

    public int hashCode() {
        return getString().hashCode();
    }
}
