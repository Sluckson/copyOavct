package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERUTF8String;

public class MetaData extends ASN1Encodable {
    private DERUTF8String fileName;
    private DERBoolean hashProtected;
    private DERIA5String mediaType;
    private Attributes otherMetaData;

    public MetaData(DERBoolean dERBoolean, DERUTF8String dERUTF8String, DERIA5String dERIA5String, Attributes attributes) {
        this.hashProtected = dERBoolean;
        this.fileName = dERUTF8String;
        this.mediaType = dERIA5String;
        this.otherMetaData = attributes;
    }

    private MetaData(ASN1Sequence aSN1Sequence) {
        int i;
        this.hashProtected = DERBoolean.getInstance((Object) aSN1Sequence.getObjectAt(0));
        if (1 >= aSN1Sequence.size() || !(aSN1Sequence.getObjectAt(1) instanceof DERUTF8String)) {
            i = 1;
        } else {
            i = 2;
            this.fileName = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(1));
        }
        if (i < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(i) instanceof DERIA5String)) {
            this.mediaType = DERIA5String.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (i < aSN1Sequence.size()) {
            this.otherMetaData = Attributes.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }

    public static MetaData getInstance(Object obj) {
        if (obj instanceof MetaData) {
            return (MetaData) obj;
        }
        if (obj != null) {
            return new MetaData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.hashProtected);
        DERUTF8String dERUTF8String = this.fileName;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        DERIA5String dERIA5String = this.mediaType;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(dERIA5String);
        }
        Attributes attributes = this.otherMetaData;
        if (attributes != null) {
            aSN1EncodableVector.add(attributes);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public boolean isHashProtected() {
        return this.hashProtected.isTrue();
    }

    public DERUTF8String getFileName() {
        return this.fileName;
    }

    public DERIA5String getMediaType() {
        return this.mediaType;
    }

    public Attributes getOtherMetaData() {
        return this.otherMetaData;
    }
}
