package repack.org.bouncycastle.asn1;

import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

public class DERObjectIdentifier extends ASN1Object {
    String identifier;

    public static DERObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof DERObjectIdentifier)) {
            return (DERObjectIdentifier) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERObjectIdentifier)) {
            return getInstance(object);
        }
        return new ASN1ObjectIdentifier(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    DERObjectIdentifier(byte[] bArr) {
        long j;
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        BigInteger bigInteger = null;
        long j2 = 0;
        boolean z = true;
        for (int i = 0; i != bArr2.length; i++) {
            byte b = bArr2[i] & 255;
            if (j2 < 36028797018963968L) {
                j2 = (j2 * 128) + ((long) (b & Byte.MAX_VALUE));
                if ((b & 128) != 0) {
                } else {
                    if (z) {
                        int i2 = ((int) j2) / 40;
                        if (i2 != 0) {
                            if (i2 != 1) {
                                stringBuffer.append(PdfWriter.VERSION_1_2);
                                j = 80;
                            } else {
                                stringBuffer.append('1');
                                j = 40;
                            }
                            j2 -= j;
                        } else {
                            stringBuffer.append('0');
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                }
            } else {
                bigInteger = (bigInteger == null ? BigInteger.valueOf(j2) : bigInteger).shiftLeft(7).or(BigInteger.valueOf((long) (b & Byte.MAX_VALUE)));
                if ((b & 128) == 0) {
                    stringBuffer.append('.');
                    stringBuffer.append(bigInteger);
                    bigInteger = null;
                }
            }
            j2 = 0;
        }
        this.identifier = stringBuffer.toString();
    }

    public DERObjectIdentifier(String str) {
        if (isValidIdentifier(str)) {
            this.identifier = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public String getId() {
        return this.identifier;
    }

    private void writeField(OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        outputStream.write(bArr, i, 9 - i);
    }

    private void writeField(OutputStream outputStream, BigInteger bigInteger) throws IOException {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            outputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        BigInteger bigInteger2 = bigInteger;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger2.intValue() & 127) | 128);
            bigInteger2 = bigInteger2.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        outputStream.write(bArr);
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream2 = new DEROutputStream(byteArrayOutputStream);
        writeField((OutputStream) byteArrayOutputStream, (long) ((Integer.parseInt(oIDTokenizer.nextToken()) * 40) + Integer.parseInt(oIDTokenizer.nextToken())));
        while (oIDTokenizer.hasMoreTokens()) {
            String nextToken = oIDTokenizer.nextToken();
            if (nextToken.length() < 18) {
                writeField((OutputStream) byteArrayOutputStream, Long.parseLong(nextToken));
            } else {
                writeField((OutputStream) byteArrayOutputStream, new BigInteger(nextToken));
            }
        }
        dEROutputStream2.close();
        dEROutputStream.writeEncoded(6, byteArrayOutputStream.toByteArray());
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((DERObjectIdentifier) dERObject).identifier);
    }

    public String toString() {
        return getId();
    }

    private static boolean isValidIdentifier(String str) {
        char charAt;
        if (str.length() >= 3 && str.charAt(1) == '.' && (charAt = str.charAt(0)) >= '0' && charAt <= '2') {
            boolean z = false;
            for (int length = str.length() - 1; length >= 2; length--) {
                char charAt2 = str.charAt(length);
                if ('0' <= charAt2 && charAt2 <= '9') {
                    z = true;
                } else if (charAt2 != '.' || !z) {
                    return false;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return false;
    }
}
