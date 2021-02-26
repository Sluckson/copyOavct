package repack.org.bouncycastle.asn1;

import java.util.Vector;

public class DEREncodableVector {

    /* renamed from: v */
    Vector f5829v = new Vector();

    public void add(DEREncodable dEREncodable) {
        this.f5829v.addElement(dEREncodable);
    }

    public DEREncodable get(int i) {
        return (DEREncodable) this.f5829v.elementAt(i);
    }

    public int size() {
        return this.f5829v.size();
    }
}
