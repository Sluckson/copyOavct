package repack.org.bouncycastle.tsp;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.tsp.MessageImprint;
import repack.org.bouncycastle.asn1.tsp.TimeStampReq;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class TimeStampRequestGenerator {
    private DERBoolean certReq;
    private Vector extOrdering = new Vector();
    private Hashtable extensions = new Hashtable();
    private DERObjectIdentifier reqPolicy;

    public void setReqPolicy(String str) {
        this.reqPolicy = new DERObjectIdentifier(str);
    }

    public void setCertReq(boolean z) {
        this.certReq = new DERBoolean(z);
    }

    public void addExtension(String str, boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        addExtension(str, z, aSN1Encodable.getEncoded());
    }

    public void addExtension(String str, boolean z, byte[] bArr) {
        DERObjectIdentifier dERObjectIdentifier = new DERObjectIdentifier(str);
        this.extensions.put(dERObjectIdentifier, new X509Extension(z, (ASN1OctetString) new DEROctetString(bArr)));
        this.extOrdering.addElement(dERObjectIdentifier);
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        addExtension(aSN1ObjectIdentifier, z, aSN1Encodable.getEncoded());
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extensions.put(aSN1ObjectIdentifier, new X509Extension(z, (ASN1OctetString) new DEROctetString(bArr)));
        this.extOrdering.addElement(aSN1ObjectIdentifier);
    }

    public TimeStampRequest generate(String str, byte[] bArr) {
        return generate(str, bArr, (BigInteger) null);
    }

    public TimeStampRequest generate(String str, byte[] bArr, BigInteger bigInteger) {
        if (str != null) {
            MessageImprint messageImprint = new MessageImprint(new AlgorithmIdentifier(new DERObjectIdentifier(str), new DERNull()), bArr);
            X509Extensions x509Extensions = null;
            if (this.extOrdering.size() != 0) {
                x509Extensions = new X509Extensions(this.extOrdering, this.extensions);
            }
            X509Extensions x509Extensions2 = x509Extensions;
            if (bigInteger != null) {
                return new TimeStampRequest(new TimeStampReq(messageImprint, this.reqPolicy, new DERInteger(bigInteger), this.certReq, x509Extensions2));
            }
            return new TimeStampRequest(new TimeStampReq(messageImprint, this.reqPolicy, (DERInteger) null, this.certReq, x509Extensions2));
        }
        throw new IllegalArgumentException("No digest algorithm specified");
    }

    public TimeStampRequest generate(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, BigInteger bigInteger) {
        return generate(aSN1ObjectIdentifier.getId(), bArr, bigInteger);
    }
}
