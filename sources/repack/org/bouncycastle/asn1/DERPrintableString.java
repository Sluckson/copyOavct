package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class DERPrintableString extends ASN1Object implements DERString {
    String string;

    public static DERPrintableString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERPrintableString)) {
            return (DERPrintableString) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERPrintableString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERPrintableString)) {
            return getInstance(object);
        }
        return new DERPrintableString(ASN1OctetString.getInstance(object).getOctets());
    }

    public DERPrintableString(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.string = new String(cArr);
    }

    public DERPrintableString(String str) {
        this(str, false);
    }

    public DERPrintableString(String str, boolean z) {
        if (!z || isPrintableString(str)) {
            this.string = str;
            return;
        }
        throw new IllegalArgumentException("string contains illegal characters");
    }

    public String getString() {
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
        dEROutputStream.writeEncoded(19, getOctets());
    }

    public int hashCode() {
        return getString().hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERPrintableString)) {
            return false;
        }
        return getString().equals(((DERPrintableString) dERObject).getString());
    }

    public String toString() {
        return this.string;
    }

    public static boolean isPrintableString(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt > 127) {
                return false;
            }
            if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && !(('0' <= charAt && charAt <= '9') || charAt == ' ' || charAt == ':' || charAt == '=' || charAt == '?'))) {
                switch (charAt) {
                    case '\'':
                    case '(':
                    case ')':
                        continue;
                    default:
                        switch (charAt) {
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                                break;
                            default:
                                return false;
                        }
                }
            }
        }
        return true;
    }
}
