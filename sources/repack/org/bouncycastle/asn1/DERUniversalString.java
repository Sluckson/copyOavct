package repack.org.bouncycastle.asn1;

import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERUniversalString extends ASN1Object implements DERString {
    private static final char[] table = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private byte[] string;

    public static DERUniversalString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUniversalString)) {
            return (DERUniversalString) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERUniversalString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERUniversalString)) {
            return getInstance(object);
        }
        return new DERUniversalString(((ASN1OctetString) object).getOctets());
    }

    public DERUniversalString(byte[] bArr) {
        this.string = bArr;
    }

    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).writeObject(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != byteArray.length; i++) {
                stringBuffer.append(table[(byteArray[i] >>> 4) & 15]);
                stringBuffer.append(table[byteArray[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException unused) {
            throw new RuntimeException("internal error encoding BitString");
        }
    }

    public String toString() {
        return getString();
    }

    public byte[] getOctets() {
        return this.string;
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(28, getOctets());
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERUniversalString)) {
            return false;
        }
        return getString().equals(((DERUniversalString) dERObject).getString());
    }

    public int hashCode() {
        return getString().hashCode();
    }
}
