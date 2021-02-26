package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.DERUTF8String;

public class IetfAttrSyntax extends ASN1Encodable {
    public static final int VALUE_OCTETS = 1;
    public static final int VALUE_OID = 2;
    public static final int VALUE_UTF8 = 3;
    GeneralNames policyAuthority = null;
    int valueChoice = -1;
    Vector values = new Vector();

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IetfAttrSyntax(repack.org.bouncycastle.asn1.ASN1Sequence r6) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r5.policyAuthority = r0
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            r5.values = r0
            r0 = -1
            r5.valueChoice = r0
            r0 = 0
            repack.org.bouncycastle.asn1.DEREncodable r1 = r6.getObjectAt(r0)
            boolean r1 = r1 instanceof repack.org.bouncycastle.asn1.ASN1TaggedObject
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0029
            repack.org.bouncycastle.asn1.DEREncodable r1 = r6.getObjectAt(r0)
            repack.org.bouncycastle.asn1.ASN1TaggedObject r1 = (repack.org.bouncycastle.asn1.ASN1TaggedObject) r1
            repack.org.bouncycastle.asn1.x509.GeneralNames r0 = repack.org.bouncycastle.asn1.x509.GeneralNames.getInstance(r1, r0)
            r5.policyAuthority = r0
        L_0x0027:
            r0 = 1
            goto L_0x003a
        L_0x0029:
            int r1 = r6.size()
            if (r1 != r2) goto L_0x003a
            repack.org.bouncycastle.asn1.DEREncodable r0 = r6.getObjectAt(r0)
            repack.org.bouncycastle.asn1.x509.GeneralNames r0 = repack.org.bouncycastle.asn1.x509.GeneralNames.getInstance(r0)
            r5.policyAuthority = r0
            goto L_0x0027
        L_0x003a:
            repack.org.bouncycastle.asn1.DEREncodable r1 = r6.getObjectAt(r0)
            boolean r1 = r1 instanceof repack.org.bouncycastle.asn1.ASN1Sequence
            if (r1 == 0) goto L_0x008a
            repack.org.bouncycastle.asn1.DEREncodable r6 = r6.getObjectAt(r0)
            repack.org.bouncycastle.asn1.ASN1Sequence r6 = (repack.org.bouncycastle.asn1.ASN1Sequence) r6
            java.util.Enumeration r6 = r6.getObjects()
        L_0x004c:
            boolean r0 = r6.hasMoreElements()
            if (r0 != 0) goto L_0x0053
            return
        L_0x0053:
            java.lang.Object r0 = r6.nextElement()
            repack.org.bouncycastle.asn1.DERObject r0 = (repack.org.bouncycastle.asn1.DERObject) r0
            boolean r1 = r0 instanceof repack.org.bouncycastle.asn1.DERObjectIdentifier
            if (r1 == 0) goto L_0x005f
            r1 = 2
            goto L_0x006a
        L_0x005f:
            boolean r1 = r0 instanceof repack.org.bouncycastle.asn1.DERUTF8String
            if (r1 == 0) goto L_0x0065
            r1 = 3
            goto L_0x006a
        L_0x0065:
            boolean r1 = r0 instanceof repack.org.bouncycastle.asn1.DEROctetString
            if (r1 == 0) goto L_0x0082
            r1 = 1
        L_0x006a:
            int r4 = r5.valueChoice
            if (r4 >= 0) goto L_0x0070
            r5.valueChoice = r1
        L_0x0070:
            int r4 = r5.valueChoice
            if (r1 != r4) goto L_0x007a
            java.util.Vector r1 = r5.values
            r1.addElement(r0)
            goto L_0x004c
        L_0x007a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Mix of value types in IetfAttrSyntax"
            r6.<init>(r0)
            throw r6
        L_0x0082:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Bad value type encoding IetfAttrSyntax"
            r6.<init>(r0)
            throw r6
        L_0x008a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Non-IetfAttrSyntax encoding"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.asn1.x509.IetfAttrSyntax.<init>(repack.org.bouncycastle.asn1.ASN1Sequence):void");
    }

    public GeneralNames getPolicyAuthority() {
        return this.policyAuthority;
    }

    public int getValueType() {
        return this.valueChoice;
    }

    public Object[] getValues() {
        int i = 0;
        if (getValueType() == 1) {
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[this.values.size()];
            while (i != aSN1OctetStringArr.length) {
                aSN1OctetStringArr[i] = (ASN1OctetString) this.values.elementAt(i);
                i++;
            }
            return aSN1OctetStringArr;
        } else if (getValueType() == 2) {
            DERObjectIdentifier[] dERObjectIdentifierArr = new DERObjectIdentifier[this.values.size()];
            while (i != dERObjectIdentifierArr.length) {
                dERObjectIdentifierArr[i] = (DERObjectIdentifier) this.values.elementAt(i);
                i++;
            }
            return dERObjectIdentifierArr;
        } else {
            DERUTF8String[] dERUTF8StringArr = new DERUTF8String[this.values.size()];
            while (i != dERUTF8StringArr.length) {
                dERUTF8StringArr[i] = (DERUTF8String) this.values.elementAt(i);
                i++;
            }
            return dERUTF8StringArr;
        }
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralNames generalNames = this.policyAuthority;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, generalNames));
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        Enumeration elements = this.values.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector2.add((ASN1Encodable) elements.nextElement());
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}
