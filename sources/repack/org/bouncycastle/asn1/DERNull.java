package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = new DERNull();
    byte[] zeroBytes = new byte[0];

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(5, this.zeroBytes);
    }
}