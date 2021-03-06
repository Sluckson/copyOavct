package repack.org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class TimeStampTokenEvidence extends ASN1Encodable {
    private TimeStampAndCRL[] timeStampAndCRLs;

    public TimeStampTokenEvidence(TimeStampAndCRL[] timeStampAndCRLArr) {
        this.timeStampAndCRLs = timeStampAndCRLArr;
    }

    public TimeStampTokenEvidence(TimeStampAndCRL timeStampAndCRL) {
        this.timeStampAndCRLs = new TimeStampAndCRL[1];
        this.timeStampAndCRLs[0] = timeStampAndCRL;
    }

    private TimeStampTokenEvidence(ASN1Sequence aSN1Sequence) {
        this.timeStampAndCRLs = new TimeStampAndCRL[aSN1Sequence.size()];
        Enumeration objects = aSN1Sequence.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            this.timeStampAndCRLs[i] = TimeStampAndCRL.getInstance(objects.nextElement());
            i++;
        }
    }

    public static TimeStampTokenEvidence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static TimeStampTokenEvidence getInstance(Object obj) {
        if (obj instanceof TimeStampTokenEvidence) {
            return (TimeStampTokenEvidence) obj;
        }
        if (obj != null) {
            return new TimeStampTokenEvidence(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public TimeStampAndCRL[] toTimeStampAndCRLArray() {
        return this.timeStampAndCRLs;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            TimeStampAndCRL[] timeStampAndCRLArr = this.timeStampAndCRLs;
            if (i == timeStampAndCRLArr.length) {
                return new DERSequence(aSN1EncodableVector);
            }
            aSN1EncodableVector.add(timeStampAndCRLArr[i]);
            i++;
        }
    }
}
