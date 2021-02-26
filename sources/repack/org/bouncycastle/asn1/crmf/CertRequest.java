package repack.org.bouncycastle.asn1.crmf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class CertRequest extends ASN1Encodable {
    private DERInteger certReqId;
    private CertTemplate certTemplate;
    private Controls controls;

    private CertRequest(ASN1Sequence aSN1Sequence) {
        this.certReqId = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.certTemplate = CertTemplate.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.controls = Controls.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static CertRequest getInstance(Object obj) {
        if (obj instanceof CertRequest) {
            return (CertRequest) obj;
        }
        if (obj != null) {
            return new CertRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertRequest(int i, CertTemplate certTemplate2, Controls controls2) {
        this(new DERInteger(i), certTemplate2, controls2);
    }

    public CertRequest(DERInteger dERInteger, CertTemplate certTemplate2, Controls controls2) {
        this.certReqId = dERInteger;
        this.certTemplate = certTemplate2;
        this.controls = controls2;
    }

    public DERInteger getCertReqId() {
        return this.certReqId;
    }

    public CertTemplate getCertTemplate() {
        return this.certTemplate;
    }

    public Controls getControls() {
        return this.controls;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certReqId);
        aSN1EncodableVector.add(this.certTemplate);
        Controls controls2 = this.controls;
        if (controls2 != null) {
            aSN1EncodableVector.add(controls2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
