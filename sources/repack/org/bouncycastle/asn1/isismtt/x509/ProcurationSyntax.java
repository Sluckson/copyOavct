package repack.org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERPrintableString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x500.DirectoryString;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.IssuerSerial;

public class ProcurationSyntax extends ASN1Encodable {
    private IssuerSerial certRef;
    private String country;
    private GeneralName thirdPerson;
    private DirectoryString typeOfSubstitution;

    public static ProcurationSyntax getInstance(Object obj) {
        if (obj == null || (obj instanceof ProcurationSyntax)) {
            return (ProcurationSyntax) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ProcurationSyntax((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    private ProcurationSyntax(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 1) {
                this.country = DERPrintableString.getInstance(instance, true).getString();
            } else if (tagNo == 2) {
                this.typeOfSubstitution = DirectoryString.getInstance(instance, true);
            } else if (tagNo == 3) {
                DERObject object = instance.getObject();
                if (object instanceof ASN1TaggedObject) {
                    this.thirdPerson = GeneralName.getInstance(object);
                } else {
                    this.certRef = IssuerSerial.getInstance(object);
                }
            } else {
                throw new IllegalArgumentException("Bad tag number: " + instance.getTagNo());
            }
        }
    }

    public ProcurationSyntax(String str, DirectoryString directoryString, IssuerSerial issuerSerial) {
        this.country = str;
        this.typeOfSubstitution = directoryString;
        this.thirdPerson = null;
        this.certRef = issuerSerial;
    }

    public ProcurationSyntax(String str, DirectoryString directoryString, GeneralName generalName) {
        this.country = str;
        this.typeOfSubstitution = directoryString;
        this.thirdPerson = generalName;
        this.certRef = null;
    }

    public String getCountry() {
        return this.country;
    }

    public DirectoryString getTypeOfSubstitution() {
        return this.typeOfSubstitution;
    }

    public GeneralName getThirdPerson() {
        return this.thirdPerson;
    }

    public IssuerSerial getCertRef() {
        return this.certRef;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        String str = this.country;
        if (str != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, new DERPrintableString(str, true)));
        }
        DirectoryString directoryString = this.typeOfSubstitution;
        if (directoryString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, directoryString));
        }
        GeneralName generalName = this.thirdPerson;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 3, generalName));
        } else {
            aSN1EncodableVector.add(new DERTaggedObject(true, 3, this.certRef));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
