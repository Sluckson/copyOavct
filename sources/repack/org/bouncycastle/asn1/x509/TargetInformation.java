package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class TargetInformation extends ASN1Encodable {
    private ASN1Sequence targets;

    public static TargetInformation getInstance(Object obj) {
        if (obj instanceof TargetInformation) {
            return (TargetInformation) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TargetInformation((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass());
    }

    private TargetInformation(ASN1Sequence aSN1Sequence) {
        this.targets = aSN1Sequence;
    }

    public Targets[] getTargetsObjects() {
        Targets[] targetsArr = new Targets[this.targets.size()];
        Enumeration objects = this.targets.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            targetsArr[i] = Targets.getInstance(objects.nextElement());
            i++;
        }
        return targetsArr;
    }

    public TargetInformation(Targets targets2) {
        this.targets = new DERSequence((DEREncodable) targets2);
    }

    public TargetInformation(Target[] targetArr) {
        this(new Targets(targetArr));
    }

    public DERObject toASN1Object() {
        return this.targets;
    }
}
