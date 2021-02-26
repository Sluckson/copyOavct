package repack.org.bouncycastle.asn1;

import java.util.Vector;

public class ASN1EncodableVector extends DEREncodableVector {

    /* renamed from: v */
    Vector f5828v = new Vector();

    public void add(DEREncodable dEREncodable) {
        this.f5828v.addElement(dEREncodable);
    }

    public DEREncodable get(int i) {
        return (DEREncodable) this.f5828v.elementAt(i);
    }

    public int size() {
        return this.f5828v.size();
    }
}
