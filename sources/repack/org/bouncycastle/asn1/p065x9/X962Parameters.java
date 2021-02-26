package repack.org.bouncycastle.asn1.p065x9;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Null;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;

/* renamed from: repack.org.bouncycastle.asn1.x9.X962Parameters */
public class X962Parameters extends ASN1Encodable implements ASN1Choice {
    private DERObject params = null;

    public static X962Parameters getInstance(Object obj) {
        if (obj == null || (obj instanceof X962Parameters)) {
            return (X962Parameters) obj;
        }
        if (obj instanceof DERObject) {
            return new X962Parameters((DERObject) obj);
        }
        throw new IllegalArgumentException("unknown object in getInstance()");
    }

    public static X962Parameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public X962Parameters(X9ECParameters x9ECParameters) {
        this.params = x9ECParameters.getDERObject();
    }

    public X962Parameters(DERObjectIdentifier dERObjectIdentifier) {
        this.params = dERObjectIdentifier;
    }

    public X962Parameters(DERObject dERObject) {
        this.params = dERObject;
    }

    public boolean isNamedCurve() {
        return this.params instanceof DERObjectIdentifier;
    }

    public boolean isImplicitlyCA() {
        return this.params instanceof ASN1Null;
    }

    public DERObject getParameters() {
        return this.params;
    }

    public DERObject toASN1Object() {
        return this.params;
    }
}
