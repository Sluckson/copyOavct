package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.p065x9.DHDomainParameters;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.DHParameter;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JCEDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private DHParameterSpec dhSpec;
    private PrivateKeyInfo info;

    /* renamed from: x */
    BigInteger f6226x;

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JCEDHPrivateKey() {
    }

    JCEDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f6226x = dHPrivateKey.getX();
        this.dhSpec = dHPrivateKey.getParams();
    }

    JCEDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f6226x = dHPrivateKeySpec.getX();
        this.dhSpec = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    JCEDHPrivateKey(PrivateKeyInfo privateKeyInfo) {
        ASN1Sequence instance = ASN1Sequence.getInstance(privateKeyInfo.getAlgorithmId().getParameters());
        DERObjectIdentifier objectId = privateKeyInfo.getAlgorithmId().getObjectId();
        this.info = privateKeyInfo;
        this.f6226x = ((DERInteger) privateKeyInfo.getPrivateKey()).getValue();
        if (objectId.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = new DHParameter(instance);
            if (dHParameter.getL() != null) {
                this.dhSpec = new DHParameterSpec(dHParameter.getP(), dHParameter.getG(), dHParameter.getL().intValue());
            } else {
                this.dhSpec = new DHParameterSpec(dHParameter.getP(), dHParameter.getG());
            }
        } else if (objectId.equals(X9ObjectIdentifiers.dhpublicnumber)) {
            DHDomainParameters instance2 = DHDomainParameters.getInstance(instance);
            this.dhSpec = new DHParameterSpec(instance2.getP().getValue(), instance2.getG().getValue());
        } else {
            throw new IllegalArgumentException("unknown algorithm type: " + objectId);
        }
    }

    JCEDHPrivateKey(DHPrivateKeyParameters dHPrivateKeyParameters) {
        this.f6226x = dHPrivateKeyParameters.getX();
        this.dhSpec = new DHParameterSpec(dHPrivateKeyParameters.getParameters().getP(), dHPrivateKeyParameters.getParameters().getG(), dHPrivateKeyParameters.getParameters().getL());
    }

    public byte[] getEncoded() {
        PrivateKeyInfo privateKeyInfo = this.info;
        if (privateKeyInfo != null) {
            return privateKeyInfo.getDEREncoded();
        }
        return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).getDERObject()), new DERInteger(getX())).getDEREncoded();
    }

    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    public BigInteger getX() {
        return this.f6226x;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6226x = (BigInteger) objectInputStream.readObject();
        this.dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.dhSpec.getP());
        objectOutputStream.writeObject(this.dhSpec.getG());
        objectOutputStream.writeInt(this.dhSpec.getL());
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
}
