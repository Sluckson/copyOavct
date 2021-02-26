package repack.org.bouncycastle.asn1.crmf;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.cms.EnvelopedData;

public class POPOPrivKey extends ASN1Encodable implements ASN1Choice {
    public static final int agreeMAC = 3;
    public static final int dhMAC = 2;
    public static final int encryptedKey = 4;
    public static final int subsequentMessage = 1;
    public static final int thisMessage = 0;
    private ASN1Encodable obj;
    private int tagNo;

    private POPOPrivKey(ASN1TaggedObject aSN1TaggedObject) {
        this.tagNo = aSN1TaggedObject.getTagNo();
        int i = this.tagNo;
        if (i == 0) {
            this.obj = DERBitString.getInstance(aSN1TaggedObject, false);
        } else if (i == 1) {
            this.obj = SubsequentMessage.valueOf(DERInteger.getInstance(aSN1TaggedObject, false).getValue().intValue());
        } else if (i == 2) {
            this.obj = DERBitString.getInstance(aSN1TaggedObject, false);
        } else if (i == 3) {
            this.obj = PKMACValue.getInstance(aSN1TaggedObject, false);
        } else if (i == 4) {
            this.obj = EnvelopedData.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag in POPOPrivKey");
        }
    }

    public static POPOPrivKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new POPOPrivKey(ASN1TaggedObject.getInstance(aSN1TaggedObject.getObject()));
    }

    public POPOPrivKey(SubsequentMessage subsequentMessage2) {
        this.tagNo = 1;
        this.obj = subsequentMessage2;
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.obj;
    }

    public DERObject toASN1Object() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}
