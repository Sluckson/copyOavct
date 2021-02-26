package repack.org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSet;

public class AttributeTable {
    private Hashtable attributes;

    public AttributeTable(Hashtable hashtable) {
        this.attributes = new Hashtable();
        this.attributes = copyTable(hashtable);
    }

    public AttributeTable(ASN1EncodableVector aSN1EncodableVector) {
        this.attributes = new Hashtable();
        for (int i = 0; i != aSN1EncodableVector.size(); i++) {
            Attribute instance = Attribute.getInstance(aSN1EncodableVector.get(i));
            addAttribute(instance.getAttrType(), instance);
        }
    }

    public AttributeTable(ASN1Set aSN1Set) {
        this.attributes = new Hashtable();
        for (int i = 0; i != aSN1Set.size(); i++) {
            Attribute instance = Attribute.getInstance(aSN1Set.getObjectAt(i));
            addAttribute(instance.getAttrType(), instance);
        }
    }

    public AttributeTable(Attributes attributes2) {
        this(ASN1Set.getInstance(attributes2.getDERObject()));
    }

    private void addAttribute(DERObjectIdentifier dERObjectIdentifier, Attribute attribute) {
        Vector vector;
        Object obj = this.attributes.get(dERObjectIdentifier);
        if (obj == null) {
            this.attributes.put(dERObjectIdentifier, attribute);
            return;
        }
        if (obj instanceof Attribute) {
            vector = new Vector();
            vector.addElement(obj);
            vector.addElement(attribute);
        } else {
            vector = (Vector) obj;
            vector.addElement(attribute);
        }
        this.attributes.put(dERObjectIdentifier, vector);
    }

    public Attribute get(DERObjectIdentifier dERObjectIdentifier) {
        Object obj = this.attributes.get(dERObjectIdentifier);
        if (obj instanceof Vector) {
            return (Attribute) ((Vector) obj).elementAt(0);
        }
        return (Attribute) obj;
    }

    public ASN1EncodableVector getAll(DERObjectIdentifier dERObjectIdentifier) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Object obj = this.attributes.get(dERObjectIdentifier);
        if (obj instanceof Vector) {
            Enumeration elements = ((Vector) obj).elements();
            while (elements.hasMoreElements()) {
                aSN1EncodableVector.add((Attribute) elements.nextElement());
            }
        } else if (obj != null) {
            aSN1EncodableVector.add((Attribute) obj);
        }
        return aSN1EncodableVector;
    }

    public int size() {
        Enumeration elements = this.attributes.elements();
        int i = 0;
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            i = nextElement instanceof Vector ? i + ((Vector) nextElement).size() : i + 1;
        }
        return i;
    }

    public Hashtable toHashtable() {
        return copyTable(this.attributes);
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.attributes.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Vector) {
                Enumeration elements2 = ((Vector) nextElement).elements();
                while (elements2.hasMoreElements()) {
                    aSN1EncodableVector.add(Attribute.getInstance(elements2.nextElement()));
                }
            } else {
                aSN1EncodableVector.add(Attribute.getInstance(nextElement));
            }
        }
        return aSN1EncodableVector;
    }

    public Attributes toAttributes() {
        return new Attributes(toASN1EncodableVector());
    }

    private Hashtable copyTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    public AttributeTable add(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        AttributeTable attributeTable = new AttributeTable(this.attributes);
        attributeTable.addAttribute(aSN1ObjectIdentifier, new Attribute(aSN1ObjectIdentifier, new DERSet((DEREncodable) aSN1Encodable)));
        return attributeTable;
    }

    public AttributeTable remove(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AttributeTable attributeTable = new AttributeTable(this.attributes);
        attributeTable.attributes.remove(aSN1ObjectIdentifier);
        return attributeTable;
    }
}
