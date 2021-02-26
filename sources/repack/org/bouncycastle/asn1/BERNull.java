package repack.org.bouncycastle.asn1;

import java.io.IOException;

public class BERNull extends DERNull {
    public static final BERNull INSTANCE = new BERNull();

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        if ((dEROutputStream instanceof ASN1OutputStream) || (dEROutputStream instanceof BEROutputStream)) {
            dEROutputStream.write(5);
        } else {
            super.encode(dEROutputStream);
        }
    }
}
