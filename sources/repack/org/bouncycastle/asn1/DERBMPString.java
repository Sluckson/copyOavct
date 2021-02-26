package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class DERBMPString extends ASN1Object implements DERString {
    String string;

    public static DERBMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBMPString)) {
            return (DERBMPString) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERBMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERBMPString)) {
            return getInstance(object);
        }
        return new DERBMPString(ASN1OctetString.getInstance(object).getOctets());
    }

    public DERBMPString(byte[] bArr) {
        char[] cArr = new char[(bArr.length / 2)];
        for (int i = 0; i != cArr.length; i++) {
            int i2 = i * 2;
            cArr[i] = (char) ((bArr[i2 + 1] & 255) | (bArr[i2] << 8));
        }
        this.string = new String(cArr);
    }

    public DERBMPString(String str) {
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

    /* access modifiers changed from: protected */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERBMPString)) {
            return false;
        }
        return getString().equals(((DERBMPString) dERObject).getString());
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        char[] charArray = this.string.toCharArray();
        byte[] bArr = new byte[(charArray.length * 2)];
        for (int i = 0; i != charArray.length; i++) {
            int i2 = i * 2;
            bArr[i2] = (byte) (charArray[i] >> 8);
            bArr[i2 + 1] = (byte) charArray[i];
        }
        dEROutputStream.writeEncoded(30, bArr);
    }
}
