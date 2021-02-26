package repack.org.bouncycastle.asn1.util;

import java.io.FileInputStream;
import java.io.InputStream;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.DERObject;

public class Dump {
    public static void main(String[] strArr) throws Exception {
        ASN1InputStream aSN1InputStream = new ASN1InputStream((InputStream) new FileInputStream(strArr[0]));
        while (true) {
            DERObject readObject = aSN1InputStream.readObject();
            if (readObject != null) {
                System.out.println(ASN1Dump.dumpAsString(readObject));
            } else {
                return;
            }
        }
    }
}
