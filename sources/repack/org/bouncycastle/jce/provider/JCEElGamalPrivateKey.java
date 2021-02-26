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
import repack.org.bouncycastle.asn1.oiw.ElGamalParameter;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import repack.org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import repack.org.bouncycastle.jce.spec.ElGamalParameterSpec;
import repack.org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;

public class JCEElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    private PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
    ElGamalParameterSpec elSpec;

    /* renamed from: x */
    BigInteger f6230x;

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JCEElGamalPrivateKey() {
    }

    JCEElGamalPrivateKey(ElGamalPrivateKey elGamalPrivateKey) {
        this.f6230x = elGamalPrivateKey.getX();
        this.elSpec = elGamalPrivateKey.getParameters();
    }

    JCEElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f6230x = dHPrivateKey.getX();
        this.elSpec = new ElGamalParameterSpec(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    JCEElGamalPrivateKey(ElGamalPrivateKeySpec elGamalPrivateKeySpec) {
        this.f6230x = elGamalPrivateKeySpec.getX();
        this.elSpec = new ElGamalParameterSpec(elGamalPrivateKeySpec.getParams().getP(), elGamalPrivateKeySpec.getParams().getG());
    }

    JCEElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f6230x = dHPrivateKeySpec.getX();
        this.elSpec = new ElGamalParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    JCEElGamalPrivateKey(PrivateKeyInfo privateKeyInfo) {
        ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence) privateKeyInfo.getAlgorithmId().getParameters());
        this.f6230x = ((DERInteger) privateKeyInfo.getPrivateKey()).getValue();
        this.elSpec = new ElGamalParameterSpec(elGamalParameter.getP(), elGamalParameter.getG());
    }

    JCEElGamalPrivateKey(ElGamalPrivateKeyParameters elGamalPrivateKeyParameters) {
        this.f6230x = elGamalPrivateKeyParameters.getX();
        this.elSpec = new ElGamalParameterSpec(elGamalPrivateKeyParameters.getParameters().getP(), elGamalPrivateKeyParameters.getParameters().getG());
    }

    public byte[] getEncoded() {
        return new PrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG()).getDERObject()), new DERInteger(getX())).getDEREncoded();
    }

    public ElGamalParameterSpec getParameters() {
        return this.elSpec;
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
    }

    public BigInteger getX() {
        return this.f6230x;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6230x = (BigInteger) objectInputStream.readObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.elSpec.getP());
        objectOutputStream.writeObject(this.elSpec.getG());
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
