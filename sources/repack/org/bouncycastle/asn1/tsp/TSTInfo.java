package repack.org.bouncycastle.asn1.tsp;

import java.io.IOException;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class TSTInfo extends ASN1Encodable {
    Accuracy accuracy;
    X509Extensions extensions;
    DERGeneralizedTime genTime;
    MessageImprint messageImprint;
    DERInteger nonce;
    DERBoolean ordering;
    DERInteger serialNumber;
    GeneralName tsa;
    DERObjectIdentifier tsaPolicyId;
    DERInteger version;

    public static TSTInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof TSTInfo)) {
            return (TSTInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TSTInfo((ASN1Sequence) obj);
        }
        if (obj instanceof ASN1OctetString) {
            try {
                return getInstance(new ASN1InputStream(((ASN1OctetString) obj).getOctets()).readObject());
            } catch (IOException unused) {
                throw new IllegalArgumentException("Bad object format in 'TSTInfo' factory.");
            }
        } else {
            throw new IllegalArgumentException("Unknown object in 'TSTInfo' factory : " + obj.getClass().getName() + ".");
        }
    }

    public TSTInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.version = DERInteger.getInstance(objects.nextElement());
        this.tsaPolicyId = DERObjectIdentifier.getInstance(objects.nextElement());
        this.messageImprint = MessageImprint.getInstance(objects.nextElement());
        this.serialNumber = DERInteger.getInstance(objects.nextElement());
        this.genTime = DERGeneralizedTime.getInstance(objects.nextElement());
        this.ordering = new DERBoolean(false);
        while (objects.hasMoreElements()) {
            DERObject dERObject = (DERObject) objects.nextElement();
            if (dERObject instanceof ASN1TaggedObject) {
                DERTaggedObject dERTaggedObject = (DERTaggedObject) dERObject;
                int tagNo = dERTaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.tsa = GeneralName.getInstance(dERTaggedObject, true);
                } else if (tagNo == 1) {
                    this.extensions = X509Extensions.getInstance(dERTaggedObject, false);
                } else {
                    throw new IllegalArgumentException("Unknown tag value " + dERTaggedObject.getTagNo());
                }
            } else if (dERObject instanceof DERSequence) {
                this.accuracy = Accuracy.getInstance(dERObject);
            } else if (dERObject instanceof DERBoolean) {
                this.ordering = DERBoolean.getInstance((Object) dERObject);
            } else if (dERObject instanceof DERInteger) {
                this.nonce = DERInteger.getInstance(dERObject);
            }
        }
    }

    public TSTInfo(DERObjectIdentifier dERObjectIdentifier, MessageImprint messageImprint2, DERInteger dERInteger, DERGeneralizedTime dERGeneralizedTime, Accuracy accuracy2, DERBoolean dERBoolean, DERInteger dERInteger2, GeneralName generalName, X509Extensions x509Extensions) {
        this.version = new DERInteger(1);
        this.tsaPolicyId = dERObjectIdentifier;
        this.messageImprint = messageImprint2;
        this.serialNumber = dERInteger;
        this.genTime = dERGeneralizedTime;
        this.accuracy = accuracy2;
        this.ordering = dERBoolean;
        this.nonce = dERInteger2;
        this.tsa = generalName;
        this.extensions = x509Extensions;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public DERObjectIdentifier getPolicy() {
        return this.tsaPolicyId;
    }

    public DERInteger getSerialNumber() {
        return this.serialNumber;
    }

    public Accuracy getAccuracy() {
        return this.accuracy;
    }

    public DERGeneralizedTime getGenTime() {
        return this.genTime;
    }

    public DERBoolean getOrdering() {
        return this.ordering;
    }

    public DERInteger getNonce() {
        return this.nonce;
    }

    public GeneralName getTsa() {
        return this.tsa;
    }

    public X509Extensions getExtensions() {
        return this.extensions;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.tsaPolicyId);
        aSN1EncodableVector.add(this.messageImprint);
        aSN1EncodableVector.add(this.serialNumber);
        aSN1EncodableVector.add(this.genTime);
        Accuracy accuracy2 = this.accuracy;
        if (accuracy2 != null) {
            aSN1EncodableVector.add(accuracy2);
        }
        DERBoolean dERBoolean = this.ordering;
        if (dERBoolean != null && dERBoolean.isTrue()) {
            aSN1EncodableVector.add(this.ordering);
        }
        DERInteger dERInteger = this.nonce;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        GeneralName generalName = this.tsa;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, generalName));
        }
        X509Extensions x509Extensions = this.extensions;
        if (x509Extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, x509Extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
