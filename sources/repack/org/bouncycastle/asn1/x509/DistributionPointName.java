package repack.org.bouncycastle.asn1.x509;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class DistributionPointName extends ASN1Encodable implements ASN1Choice {
    public static final int FULL_NAME = 0;
    public static final int NAME_RELATIVE_TO_CRL_ISSUER = 1;
    DEREncodable name;
    int type;

    public static DistributionPointName getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1TaggedObject.getInstance(aSN1TaggedObject, true));
    }

    public static DistributionPointName getInstance(Object obj) {
        if (obj == null || (obj instanceof DistributionPointName)) {
            return (DistributionPointName) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new DistributionPointName((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public DistributionPointName(int i, DEREncodable dEREncodable) {
        this.type = i;
        this.name = dEREncodable;
    }

    public DistributionPointName(int i, ASN1Encodable aSN1Encodable) {
        this.type = i;
        this.name = aSN1Encodable;
    }

    public DistributionPointName(GeneralNames generalNames) {
        this(0, (ASN1Encodable) generalNames);
    }

    public int getType() {
        return this.type;
    }

    public ASN1Encodable getName() {
        return (ASN1Encodable) this.name;
    }

    public DistributionPointName(ASN1TaggedObject aSN1TaggedObject) {
        this.type = aSN1TaggedObject.getTagNo();
        if (this.type == 0) {
            this.name = GeneralNames.getInstance(aSN1TaggedObject, false);
        } else {
            this.name = ASN1Set.getInstance(aSN1TaggedObject, false);
        }
    }

    public DERObject toASN1Object() {
        return new DERTaggedObject(false, this.type, this.name);
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPointName: [");
        stringBuffer.append(property);
        if (this.type == 0) {
            appendObject(stringBuffer, property, "fullName", this.name.toString());
        } else {
            appendObject(stringBuffer, property, "nameRelativeToCRLIssuer", this.name.toString());
        }
        stringBuffer.append("]");
        stringBuffer.append(property);
        return stringBuffer.toString();
    }

    private void appendObject(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }
}
