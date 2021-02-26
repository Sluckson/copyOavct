package repack.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class LazyDERSequence extends DERSequence {
    private byte[] encoded;
    private boolean parsed = false;
    private int size = -1;

    LazyDERSequence(byte[] bArr) throws IOException {
        this.encoded = bArr;
    }

    private void parse() {
        LazyDERConstructionEnumeration lazyDERConstructionEnumeration = new LazyDERConstructionEnumeration(this.encoded);
        while (lazyDERConstructionEnumeration.hasMoreElements()) {
            addObject((DEREncodable) lazyDERConstructionEnumeration.nextElement());
        }
        this.parsed = true;
    }

    public synchronized DEREncodable getObjectAt(int i) {
        if (!this.parsed) {
            parse();
        }
        return super.getObjectAt(i);
    }

    public synchronized Enumeration getObjects() {
        if (this.parsed) {
            return super.getObjects();
        }
        return new LazyDERConstructionEnumeration(this.encoded);
    }

    public int size() {
        if (this.size < 0) {
            LazyDERConstructionEnumeration lazyDERConstructionEnumeration = new LazyDERConstructionEnumeration(this.encoded);
            this.size = 0;
            while (lazyDERConstructionEnumeration.hasMoreElements()) {
                lazyDERConstructionEnumeration.nextElement();
                this.size++;
            }
        }
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(48, this.encoded);
    }
}
