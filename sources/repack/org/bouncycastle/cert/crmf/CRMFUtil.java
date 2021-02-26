package repack.org.bouncycastle.cert.crmf;

import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.DEROutputStream;

class CRMFUtil {
    CRMFUtil() {
    }

    static void derEncodeToStream(ASN1Encodable aSN1Encodable, OutputStream outputStream) {
        DEROutputStream dEROutputStream = new DEROutputStream(outputStream);
        try {
            dEROutputStream.writeObject(aSN1Encodable);
            dEROutputStream.close();
        } catch (IOException e) {
            throw new CRMFRuntimeException("unable to DER encode object: " + e.getMessage(), e);
        }
    }
}