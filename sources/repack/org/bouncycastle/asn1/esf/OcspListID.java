package repack.org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class OcspListID extends ASN1Encodable {
    private ASN1Sequence ocspResponses;

    public static OcspListID getInstance(Object obj) {
        if (obj instanceof OcspListID) {
            return (OcspListID) obj;
        }
        if (obj != null) {
            return new OcspListID(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance");
    }

    private OcspListID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1) {
            this.ocspResponses = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
            Enumeration objects = this.ocspResponses.getObjects();
            while (objects.hasMoreElements()) {
                OcspResponsesID.getInstance(objects.nextElement());
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public OcspListID(OcspResponsesID[] ocspResponsesIDArr) {
        this.ocspResponses = new DERSequence((ASN1Encodable[]) ocspResponsesIDArr);
    }

    public OcspResponsesID[] getOcspResponses() {
        OcspResponsesID[] ocspResponsesIDArr = new OcspResponsesID[this.ocspResponses.size()];
        for (int i = 0; i < ocspResponsesIDArr.length; i++) {
            ocspResponsesIDArr[i] = OcspResponsesID.getInstance(this.ocspResponses.getObjectAt(i));
        }
        return ocspResponsesIDArr;
    }

    public DERObject toASN1Object() {
        return new DERSequence((DEREncodable) this.ocspResponses);
    }
}
