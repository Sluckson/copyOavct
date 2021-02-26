package repack.org.bouncycastle.asn1.pkcs;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.BERSequence;
import repack.org.bouncycastle.asn1.DERObject;

public class AuthenticatedSafe extends ASN1Encodable {
    ContentInfo[] info;

    public AuthenticatedSafe(ASN1Sequence aSN1Sequence) {
        this.info = new ContentInfo[aSN1Sequence.size()];
        int i = 0;
        while (true) {
            ContentInfo[] contentInfoArr = this.info;
            if (i != contentInfoArr.length) {
                contentInfoArr[i] = ContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
                i++;
            } else {
                return;
            }
        }
    }

    public AuthenticatedSafe(ContentInfo[] contentInfoArr) {
        this.info = contentInfoArr;
    }

    public ContentInfo[] getContentInfo() {
        return this.info;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            ContentInfo[] contentInfoArr = this.info;
            if (i == contentInfoArr.length) {
                return new BERSequence(aSN1EncodableVector);
            }
            aSN1EncodableVector.add(contentInfoArr[i]);
            i++;
        }
    }
}
