package repack.org.bouncycastle.asn1.isismtt.x509;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERPrintableString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class DeclarationOfMajority extends ASN1Encodable implements ASN1Choice {
    public static final int dateOfBirth = 2;
    public static final int fullAgeAtCountry = 1;
    public static final int notYoungerThan = 0;
    private ASN1TaggedObject declaration;

    public DeclarationOfMajority(int i) {
        this.declaration = new DERTaggedObject(false, 0, new DERInteger(i));
    }

    public DeclarationOfMajority(boolean z, String str) {
        if (str.length() > 2) {
            throw new IllegalArgumentException("country can only be 2 characters");
        } else if (z) {
            this.declaration = new DERTaggedObject(false, 1, new DERSequence((DEREncodable) new DERPrintableString(str, true)));
        } else {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(DERBoolean.FALSE);
            aSN1EncodableVector.add(new DERPrintableString(str, true));
            this.declaration = new DERTaggedObject(false, 1, new DERSequence(aSN1EncodableVector));
        }
    }

    public DeclarationOfMajority(DERGeneralizedTime dERGeneralizedTime) {
        this.declaration = new DERTaggedObject(false, 2, dERGeneralizedTime);
    }

    public static DeclarationOfMajority getInstance(Object obj) {
        if (obj == null || (obj instanceof DeclarationOfMajority)) {
            return (DeclarationOfMajority) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new DeclarationOfMajority((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    private DeclarationOfMajority(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() <= 2) {
            this.declaration = aSN1TaggedObject;
            return;
        }
        throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
    }

    public DERObject toASN1Object() {
        return this.declaration;
    }

    public int getType() {
        return this.declaration.getTagNo();
    }

    public int notYoungerThan() {
        if (this.declaration.getTagNo() != 0) {
            return -1;
        }
        return DERInteger.getInstance(this.declaration, false).getValue().intValue();
    }

    public ASN1Sequence fullAgeAtCountry() {
        if (this.declaration.getTagNo() != 1) {
            return null;
        }
        return ASN1Sequence.getInstance(this.declaration, false);
    }

    public DERGeneralizedTime getDateOfBirth() {
        if (this.declaration.getTagNo() != 2) {
            return null;
        }
        return DERGeneralizedTime.getInstance(this.declaration, false);
    }
}
