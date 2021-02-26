package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class DERIA5String extends ASN1Object implements DERString {
    String string;

    public static DERIA5String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERIA5String)) {
            return (DERIA5String) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERIA5String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERIA5String)) {
            return getInstance(object);
        }
        return new DERIA5String(((ASN1OctetString) object).getOctets());
    }

    public DERIA5String(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.string = new String(cArr);
    }

    public DERIA5String(String str) {
        this(str, false);
    }

    public DERIA5String(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("string cannot be null");
        } else if (!z || isIA5String(str)) {
            this.string = str;
        } else {
            throw new IllegalArgumentException("string contains illegal characters");
        }
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
        dEROutputStream.writeEncoded(22, getOctets());
    }

    public int hashCode() {
        return getString().hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERIA5String)) {
            return false;
        }
        return getString().equals(((DERIA5String) dERObject).getString());
    }

    public static boolean isIA5String(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > 127) {
                return false;
            }
        }
        return true;
    }
}
