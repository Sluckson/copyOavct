package repack.org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.GeneralName;

public class PKIHeader extends ASN1Encodable {
    public static final int CMP_1999 = 1;
    public static final int CMP_2000 = 2;
    public static final GeneralName NULL_NAME = new GeneralName(X500Name.getInstance(new DERSequence()));
    private PKIFreeText freeText;
    private ASN1Sequence generalInfo;
    private DERGeneralizedTime messageTime;
    private AlgorithmIdentifier protectionAlg;
    private DERInteger pvno;
    private ASN1OctetString recipKID;
    private ASN1OctetString recipNonce;
    private GeneralName recipient;
    private GeneralName sender;
    private ASN1OctetString senderKID;
    private ASN1OctetString senderNonce;
    private ASN1OctetString transactionID;

    private PKIHeader(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.pvno = DERInteger.getInstance(objects.nextElement());
        this.sender = GeneralName.getInstance(objects.nextElement());
        this.recipient = GeneralName.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            switch (aSN1TaggedObject.getTagNo()) {
                case 0:
                    this.messageTime = DERGeneralizedTime.getInstance(aSN1TaggedObject, true);
                    break;
                case 1:
                    this.protectionAlg = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
                    break;
                case 2:
                    this.senderKID = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 3:
                    this.recipKID = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 4:
                    this.transactionID = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 5:
                    this.senderNonce = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 6:
                    this.recipNonce = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 7:
                    this.freeText = PKIFreeText.getInstance(aSN1TaggedObject, true);
                    break;
                case 8:
                    this.generalInfo = ASN1Sequence.getInstance(aSN1TaggedObject, true);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
            }
        }
    }

    public static PKIHeader getInstance(Object obj) {
        if (obj instanceof PKIHeader) {
            return (PKIHeader) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PKIHeader((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public PKIHeader(int i, GeneralName generalName, GeneralName generalName2) {
        this(new DERInteger(i), generalName, generalName2);
    }

    private PKIHeader(DERInteger dERInteger, GeneralName generalName, GeneralName generalName2) {
        this.pvno = dERInteger;
        this.sender = generalName;
        this.recipient = generalName2;
    }

    public DERInteger getPvno() {
        return this.pvno;
    }

    public GeneralName getSender() {
        return this.sender;
    }

    public GeneralName getRecipient() {
        return this.recipient;
    }

    public DERGeneralizedTime getMessageTime() {
        return this.messageTime;
    }

    public AlgorithmIdentifier getProtectionAlg() {
        return this.protectionAlg;
    }

    public ASN1OctetString getSenderKID() {
        return this.senderKID;
    }

    public ASN1OctetString getRecipKID() {
        return this.recipKID;
    }

    public ASN1OctetString getTransactionID() {
        return this.transactionID;
    }

    public ASN1OctetString getSenderNonce() {
        return this.senderNonce;
    }

    public ASN1OctetString getRecipNonce() {
        return this.recipNonce;
    }

    public PKIFreeText getFreeText() {
        return this.freeText;
    }

    public InfoTypeAndValue[] getGeneralInfo() {
        ASN1Sequence aSN1Sequence = this.generalInfo;
        if (aSN1Sequence == null) {
            return null;
        }
        InfoTypeAndValue[] infoTypeAndValueArr = new InfoTypeAndValue[aSN1Sequence.size()];
        for (int i = 0; i < infoTypeAndValueArr.length; i++) {
            infoTypeAndValueArr[i] = InfoTypeAndValue.getInstance(this.generalInfo.getObjectAt(i));
        }
        return infoTypeAndValueArr;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.pvno);
        aSN1EncodableVector.add(this.sender);
        aSN1EncodableVector.add(this.recipient);
        addOptional(aSN1EncodableVector, 0, this.messageTime);
        addOptional(aSN1EncodableVector, 1, this.protectionAlg);
        addOptional(aSN1EncodableVector, 2, this.senderKID);
        addOptional(aSN1EncodableVector, 3, this.recipKID);
        addOptional(aSN1EncodableVector, 4, this.transactionID);
        addOptional(aSN1EncodableVector, 5, this.senderNonce);
        addOptional(aSN1EncodableVector, 6, this.recipNonce);
        addOptional(aSN1EncodableVector, 7, this.freeText);
        addOptional(aSN1EncodableVector, 8, this.generalInfo);
        return new DERSequence(aSN1EncodableVector);
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }
}
