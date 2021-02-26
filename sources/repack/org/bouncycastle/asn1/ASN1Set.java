package repack.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ASN1Set extends ASN1Object {
    protected Vector set = new Vector();

    /* access modifiers changed from: package-private */
    public abstract void encode(DEROutputStream dEROutputStream) throws IOException;

    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (aSN1TaggedObject.isExplicit()) {
                return (ASN1Set) aSN1TaggedObject.getObject();
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (aSN1TaggedObject.isExplicit()) {
            return new DERSet((DEREncodable) aSN1TaggedObject.getObject());
        } else {
            if (aSN1TaggedObject.getObject() instanceof ASN1Set) {
                return (ASN1Set) aSN1TaggedObject.getObject();
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
                Enumeration objects = ((ASN1Sequence) aSN1TaggedObject.getObject()).getObjects();
                while (objects.hasMoreElements()) {
                    aSN1EncodableVector.add((DEREncodable) objects.nextElement());
                }
                return new DERSet(aSN1EncodableVector, false);
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + aSN1TaggedObject.getClass().getName());
        }
    }

    public Enumeration getObjects() {
        return this.set.elements();
    }

    public DEREncodable getObjectAt(int i) {
        return (DEREncodable) this.set.elementAt(i);
    }

    public int size() {
        return this.set.size();
    }

    public ASN1Encodable[] toArray() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++) {
            aSN1EncodableArr[i] = (ASN1Encodable) getObjectAt(i);
        }
        return aSN1EncodableArr;
    }

    public ASN1SetParser parser() {
        return new ASN1SetParser() {
            private int index;
            private final int max;

            {
                this.max = ASN1Set.this.size();
            }

            public DEREncodable readObject() throws IOException {
                int i = this.index;
                if (i == this.max) {
                    return null;
                }
                ASN1Set aSN1Set = ASN1Set.this;
                this.index = i + 1;
                DEREncodable objectAt = aSN1Set.getObjectAt(i);
                if (objectAt instanceof ASN1Sequence) {
                    return ((ASN1Sequence) objectAt).parser();
                }
                return objectAt instanceof ASN1Set ? ((ASN1Set) objectAt).parser() : objectAt;
            }

            public DERObject getLoadedObject() {
                return this;
            }

            public DERObject getDERObject() {
                return this;
            }
        };
    }

    public int hashCode() {
        Enumeration objects = getObjects();
        int size = size();
        while (objects.hasMoreElements()) {
            size = (size * 17) ^ getNext(objects).hashCode();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) dERObject;
        if (size() != aSN1Set.size()) {
            return false;
        }
        Enumeration objects = getObjects();
        Enumeration objects2 = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            DEREncodable next = getNext(objects);
            DEREncodable next2 = getNext(objects2);
            DERObject dERObject2 = next.getDERObject();
            DERObject dERObject3 = next2.getDERObject();
            if (dERObject2 != dERObject3 && !dERObject2.equals(dERObject3)) {
                return false;
            }
        }
        return true;
    }

    private DEREncodable getNext(Enumeration enumeration) {
        DEREncodable dEREncodable = (DEREncodable) enumeration.nextElement();
        return dEREncodable == null ? DERNull.INSTANCE : dEREncodable;
    }

    private boolean lessThanOrEqual(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i != min; i++) {
            if (bArr[i] != bArr2[i]) {
                return (bArr[i] & 255) < (bArr2[i] & 255);
            }
        }
        return min == bArr.length;
    }

    private byte[] getEncoded(DEREncodable dEREncodable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).writeObject(dEREncodable);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    /* access modifiers changed from: protected */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void sort() {
        /*
            r9 = this;
            java.util.Vector r0 = r9.set
            int r0 = r0.size()
            r1 = 1
            if (r0 <= r1) goto L_0x0057
            java.util.Vector r0 = r9.set
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = r0
            r0 = 1
        L_0x0012:
            if (r0 != 0) goto L_0x0015
            goto L_0x0057
        L_0x0015:
            java.util.Vector r0 = r9.set
            r3 = 0
            java.lang.Object r0 = r0.elementAt(r3)
            repack.org.bouncycastle.asn1.DEREncodable r0 = (repack.org.bouncycastle.asn1.DEREncodable) r0
            byte[] r0 = r9.getEncoded(r0)
            r4 = 0
            r5 = 0
        L_0x0024:
            if (r3 != r2) goto L_0x0029
            r2 = r4
            r0 = r5
            goto L_0x0012
        L_0x0029:
            java.util.Vector r6 = r9.set
            int r7 = r3 + 1
            java.lang.Object r6 = r6.elementAt(r7)
            repack.org.bouncycastle.asn1.DEREncodable r6 = (repack.org.bouncycastle.asn1.DEREncodable) r6
            byte[] r6 = r9.getEncoded(r6)
            boolean r8 = r9.lessThanOrEqual(r0, r6)
            if (r8 == 0) goto L_0x003f
            r0 = r6
            goto L_0x0055
        L_0x003f:
            java.util.Vector r4 = r9.set
            java.lang.Object r4 = r4.elementAt(r3)
            java.util.Vector r5 = r9.set
            java.lang.Object r6 = r5.elementAt(r7)
            r5.setElementAt(r6, r3)
            java.util.Vector r5 = r9.set
            r5.setElementAt(r4, r7)
            r4 = r3
            r5 = 1
        L_0x0055:
            r3 = r7
            goto L_0x0024
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.asn1.ASN1Set.sort():void");
    }

    /* access modifiers changed from: protected */
    public void addObject(DEREncodable dEREncodable) {
        this.set.addElement(dEREncodable);
    }

    public String toString() {
        return this.set.toString();
    }
}
