package repack.org.bouncycastle.asn1.x500;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x500.style.BCStyle;
import repack.org.bouncycastle.asn1.x509.X509Name;

public class X500Name extends ASN1Encodable implements ASN1Choice {
    private static X500NameStyle defaultStyle = BCStyle.INSTANCE;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;
    private RDN[] rdns;
    private X500NameStyle style;

    public X500Name(X500NameStyle x500NameStyle, X500Name x500Name) {
        this.rdns = x500Name.rdns;
        this.style = x500NameStyle;
    }

    public static X500Name getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, true));
    }

    public static X500Name getInstance(Object obj) {
        if (obj instanceof X500Name) {
            return (X500Name) obj;
        }
        if (obj instanceof X509Name) {
            return new X500Name(ASN1Sequence.getInstance(((X509Name) obj).getDERObject()));
        }
        if (obj != null) {
            return new X500Name(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private X500Name(ASN1Sequence aSN1Sequence) {
        this(defaultStyle, aSN1Sequence);
    }

    private X500Name(X500NameStyle x500NameStyle, ASN1Sequence aSN1Sequence) {
        this.style = x500NameStyle;
        this.rdns = new RDN[aSN1Sequence.size()];
        Enumeration objects = aSN1Sequence.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            this.rdns[i] = RDN.getInstance(objects.nextElement());
            i++;
        }
    }

    public X500Name(RDN[] rdnArr) {
        this(defaultStyle, rdnArr);
    }

    public X500Name(X500NameStyle x500NameStyle, RDN[] rdnArr) {
        this.rdns = rdnArr;
        this.style = x500NameStyle;
    }

    public X500Name(String str) {
        this(defaultStyle, str);
    }

    public X500Name(X500NameStyle x500NameStyle, String str) {
        this(x500NameStyle.fromString(str));
        this.style = x500NameStyle;
    }

    public RDN[] getRDNs() {
        RDN[] rdnArr = this.rdns;
        RDN[] rdnArr2 = new RDN[rdnArr.length];
        System.arraycopy(rdnArr, 0, rdnArr2, 0, rdnArr2.length);
        return rdnArr2;
    }

    public RDN[] getRDNs(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int i;
        RDN[] rdnArr = new RDN[this.rdns.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            RDN[] rdnArr2 = this.rdns;
            if (i2 == rdnArr2.length) {
                RDN[] rdnArr3 = new RDN[i3];
                System.arraycopy(rdnArr, 0, rdnArr3, 0, rdnArr3.length);
                return rdnArr3;
            }
            RDN rdn = rdnArr2[i2];
            if (rdn.isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
                int i4 = 0;
                while (true) {
                    if (i4 == typesAndValues.length) {
                        break;
                    } else if (typesAndValues[i4].getType().equals(aSN1ObjectIdentifier)) {
                        i = i3 + 1;
                        rdnArr[i3] = rdn;
                        break;
                    } else {
                        i4++;
                    }
                }
            } else if (rdn.getFirst().getType().equals(aSN1ObjectIdentifier)) {
                i = i3 + 1;
                rdnArr[i3] = rdn;
            } else {
                i2++;
            }
            i3 = i;
            i2++;
        }
    }

    public DERObject toASN1Object() {
        return new DERSequence((ASN1Encodable[]) this.rdns);
    }

    public int hashCode() {
        if (this.isHashCodeCalculated) {
            return this.hashCodeValue;
        }
        this.isHashCodeCalculated = true;
        this.hashCodeValue = this.style.calculateHashCode(this);
        return this.hashCodeValue;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X500Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (getDERObject().equals(((DEREncodable) obj).getDERObject())) {
            return true;
        }
        try {
            return this.style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((DEREncodable) obj).getDERObject())));
        } catch (Exception unused) {
            return false;
        }
    }

    public String toString() {
        return this.style.toString(this);
    }

    public static void setDefaultStyle(X500NameStyle x500NameStyle) {
        if (x500NameStyle != null) {
            defaultStyle = x500NameStyle;
            return;
        }
        throw new NullPointerException("cannot set style to null");
    }

    public static X500NameStyle getDefaultStyle() {
        return defaultStyle;
    }
}
