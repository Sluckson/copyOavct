package repack.org.bouncycastle.asn1;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import repack.org.bouncycastle.util.Arrays;

public class DERApplicationSpecific extends ASN1Object {
    private final boolean isConstructed;
    private final byte[] octets;
    private final int tag;

    DERApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i;
        this.octets = bArr;
    }

    public DERApplicationSpecific(int i, byte[] bArr) {
        this(false, i, bArr);
    }

    public DERApplicationSpecific(int i, DEREncodable dEREncodable) throws IOException {
        this(true, i, dEREncodable);
    }

    public DERApplicationSpecific(boolean z, int i, DEREncodable dEREncodable) throws IOException {
        byte[] dEREncoded = dEREncodable.getDERObject().getDEREncoded();
        this.isConstructed = z;
        this.tag = i;
        if (z) {
            this.octets = dEREncoded;
            return;
        }
        int lengthOfLength = getLengthOfLength(dEREncoded);
        byte[] bArr = new byte[(dEREncoded.length - lengthOfLength)];
        System.arraycopy(dEREncoded, lengthOfLength, bArr, 0, bArr.length);
        this.octets = bArr;
    }

    public DERApplicationSpecific(int i, ASN1EncodableVector aSN1EncodableVector) {
        this.tag = i;
        this.isConstructed = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 != aSN1EncodableVector.size()) {
            try {
                byteArrayOutputStream.write(((ASN1Encodable) aSN1EncodableVector.get(i2)).getEncoded());
                i2++;
            } catch (IOException e) {
                throw new ASN1ParsingException("malformed object: " + e, e);
            }
        }
        this.octets = byteArrayOutputStream.toByteArray();
    }

    private int getLengthOfLength(byte[] bArr) {
        int i = 2;
        while ((bArr[i - 1] & 128) != 0) {
            i++;
        }
        return i;
    }

    public boolean isConstructed() {
        return this.isConstructed;
    }

    public byte[] getContents() {
        return this.octets;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public DERObject getObject() throws IOException {
        return new ASN1InputStream(getContents()).readObject();
    }

    public DERObject getObject(int i) throws IOException {
        if (i < 31) {
            byte[] encoded = getEncoded();
            byte[] replaceTagNumber = replaceTagNumber(i, encoded);
            if ((encoded[0] & 32) != 0) {
                replaceTagNumber[0] = (byte) (replaceTagNumber[0] | 32);
            }
            return new ASN1InputStream(replaceTagNumber).readObject();
        }
        throw new IOException("unsupported tag number");
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERApplicationSpecific)) {
            return false;
        }
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) dERObject;
        if (this.isConstructed == dERApplicationSpecific.isConstructed && this.tag == dERApplicationSpecific.tag && Arrays.areEqual(this.octets, dERApplicationSpecific.octets)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.isConstructed ^ this.tag) ^ Arrays.hashCode(this.octets) ? 1 : 0;
    }

    private byte[] replaceTagNumber(int i, byte[] bArr) throws IOException {
        int i2;
        if ((bArr[0] & Ascii.f275US) == 31) {
            i2 = 2;
            byte b = bArr[1] & 255;
            if ((b & Byte.MAX_VALUE) != 0) {
                while (b >= 0 && (b & 128) != 0) {
                    int i3 = i2 + 1;
                    b = bArr[i2] & 255;
                    i2 = i3;
                }
            } else {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
        } else {
            i2 = 1;
        }
        byte[] bArr2 = new byte[((bArr.length - i2) + 1)];
        System.arraycopy(bArr, i2, bArr2, 1, bArr2.length - 1);
        bArr2[0] = (byte) i;
        return bArr2;
    }
}
