package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DSAParameter;
import repack.org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JDKDSAPrivateKey implements DSAPrivateKey, PKCS12BagAttributeCarrier {
    private static final long serialVersionUID = -4677259546958385734L;
    private PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
    DSAParams dsaSpec;

    /* renamed from: x */
    BigInteger f6237x;

    public String getAlgorithm() {
        return "DSA";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JDKDSAPrivateKey() {
    }

    JDKDSAPrivateKey(DSAPrivateKey dSAPrivateKey) {
        this.f6237x = dSAPrivateKey.getX();
        this.dsaSpec = dSAPrivateKey.getParams();
    }

    JDKDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) {
        this.f6237x = dSAPrivateKeySpec.getX();
        this.dsaSpec = new DSAParameterSpec(dSAPrivateKeySpec.getP(), dSAPrivateKeySpec.getQ(), dSAPrivateKeySpec.getG());
    }

    JDKDSAPrivateKey(PrivateKeyInfo privateKeyInfo) {
        DSAParameter dSAParameter = new DSAParameter((ASN1Sequence) privateKeyInfo.getAlgorithmId().getParameters());
        this.f6237x = ((DERInteger) privateKeyInfo.getPrivateKey()).getValue();
        this.dsaSpec = new DSAParameterSpec(dSAParameter.getP(), dSAParameter.getQ(), dSAParameter.getG());
    }

    JDKDSAPrivateKey(DSAPrivateKeyParameters dSAPrivateKeyParameters) {
        this.f6237x = dSAPrivateKeyParameters.getX();
        this.dsaSpec = new DSAParameterSpec(dSAPrivateKeyParameters.getParameters().getP(), dSAPrivateKeyParameters.getParameters().getQ(), dSAPrivateKeyParameters.getParameters().getG());
    }

    public byte[] getEncoded() {
        return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).getDERObject()), new DERInteger(getX())).getDEREncoded();
    }

    public DSAParams getParams() {
        return this.dsaSpec;
    }

    public BigInteger getX() {
        return this.f6237x;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPrivateKey)) {
            return false;
        }
        DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj;
        if (!getX().equals(dSAPrivateKey.getX()) || !getParams().getG().equals(dSAPrivateKey.getParams().getG()) || !getParams().getP().equals(dSAPrivateKey.getParams().getP()) || !getParams().getQ().equals(dSAPrivateKey.getParams().getQ())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public void setBagAttribute(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.attrCarrier.setBagAttribute(dERObjectIdentifier, dEREncodable);
    }

    public DEREncodable getBagAttribute(DERObjectIdentifier dERObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(dERObjectIdentifier);
    }

    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6237x = (BigInteger) objectInputStream.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.attrCarrier.readObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f6237x);
        objectOutputStream.writeObject(this.dsaSpec.getP());
        objectOutputStream.writeObject(this.dsaSpec.getQ());
        objectOutputStream.writeObject(this.dsaSpec.getG());
        this.attrCarrier.writeObject(objectOutputStream);
    }
}
