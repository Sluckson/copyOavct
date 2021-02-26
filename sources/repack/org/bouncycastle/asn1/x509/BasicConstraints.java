package repack.org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class BasicConstraints extends ASN1Encodable {

    /* renamed from: cA */
    DERBoolean f5873cA;
    DERInteger pathLenConstraint;

    public static BasicConstraints getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static BasicConstraints getInstance(Object obj) {
        if (obj == null || (obj instanceof BasicConstraints)) {
            return (BasicConstraints) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new BasicConstraints((ASN1Sequence) obj);
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public BasicConstraints(ASN1Sequence aSN1Sequence) {
        this.f5873cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (aSN1Sequence.size() == 0) {
            this.f5873cA = null;
            this.pathLenConstraint = null;
            return;
        }
        if (aSN1Sequence.getObjectAt(0) instanceof DERBoolean) {
            this.f5873cA = DERBoolean.getInstance((Object) aSN1Sequence.getObjectAt(0));
        } else {
            this.f5873cA = null;
            this.pathLenConstraint = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() <= 1) {
            return;
        }
        if (this.f5873cA != null) {
            this.pathLenConstraint = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    public BasicConstraints(boolean z, int i) {
        this.f5873cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (z) {
            this.f5873cA = new DERBoolean(z);
            this.pathLenConstraint = new DERInteger(i);
            return;
        }
        this.f5873cA = null;
        this.pathLenConstraint = null;
    }

    public BasicConstraints(boolean z) {
        this.f5873cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (z) {
            this.f5873cA = new DERBoolean(true);
        } else {
            this.f5873cA = null;
        }
        this.pathLenConstraint = null;
    }

    public BasicConstraints(int i) {
        this.f5873cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        this.f5873cA = new DERBoolean(true);
        this.pathLenConstraint = new DERInteger(i);
    }

    public boolean isCA() {
        DERBoolean dERBoolean = this.f5873cA;
        return dERBoolean != null && dERBoolean.isTrue();
    }

    public BigInteger getPathLenConstraint() {
        DERInteger dERInteger = this.pathLenConstraint;
        if (dERInteger != null) {
            return dERInteger.getValue();
        }
        return null;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERBoolean dERBoolean = this.f5873cA;
        if (dERBoolean != null) {
            aSN1EncodableVector.add(dERBoolean);
        }
        DERInteger dERInteger = this.pathLenConstraint;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        if (this.pathLenConstraint != null) {
            return "BasicConstraints: isCa(" + isCA() + "), pathLenConstraint = " + this.pathLenConstraint.getValue();
        } else if (this.f5873cA == null) {
            return "BasicConstraints: isCa(false)";
        } else {
            return "BasicConstraints: isCa(" + isCA() + ")";
        }
    }
}
