package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class DERT61String extends ASN1Object implements DERString {
    String string;

    public static DERT61String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERT61String)) {
            return (DERT61String) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERT61String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z) {
            return getInstance(object);
        }
        return new DERT61String(ASN1OctetString.getInstance(object).getOctets());
    }

    public DERT61String(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.string = new String(cArr);
    }

    public DERT61String(String str) {
        this.string = str;
    }

    public String getString() {
        return this.string;
    }

    public String toString() {
        return this.string;
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(20, getOctets());
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
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERT61String)) {
            return false;
        }
        return getString().equals(((DERT61String) dERObject).getString());
    }

    public int hashCode() {
        return getString().hashCode();
    }
}
