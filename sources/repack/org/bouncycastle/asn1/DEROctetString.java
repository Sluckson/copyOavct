package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class DEROctetString extends ASN1OctetString {
    public DEROctetString(byte[] bArr) {
        super(bArr);
    }

    public DEROctetString(DEREncodable dEREncodable) {
        super(dEREncodable);
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(4, this.string);
    }

    static void encode(DEROutputStream dEROutputStream, byte[] bArr) throws IOException {
        dEROutputStream.writeEncoded(4, bArr);
    }
}
