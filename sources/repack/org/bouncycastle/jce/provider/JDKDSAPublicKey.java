package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DSAParameter;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.params.DSAPublicKeyParameters;

public class JDKDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;
    private DSAParams dsaSpec;

    /* renamed from: y */
    private BigInteger f6238y;

    public String getAlgorithm() {
        return "DSA";
    }

    public String getFormat() {
        return "X.509";
    }

    JDKDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.f6238y = dSAPublicKeySpec.getY();
        this.dsaSpec = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
    }

    JDKDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.f6238y = dSAPublicKey.getY();
        this.dsaSpec = dSAPublicKey.getParams();
    }

    JDKDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.f6238y = dSAPublicKeyParameters.getY();
        this.dsaSpec = new DSAParameterSpec(dSAPublicKeyParameters.getParameters().getP(), dSAPublicKeyParameters.getParameters().getQ(), dSAPublicKeyParameters.getParameters().getG());
    }

    JDKDSAPublicKey(BigInteger bigInteger, DSAParameterSpec dSAParameterSpec) {
        this.f6238y = bigInteger;
        this.dsaSpec = dSAParameterSpec;
    }

    JDKDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            this.f6238y = ((DERInteger) subjectPublicKeyInfo.getPublicKey()).getValue();
            if (isNotNull(subjectPublicKeyInfo.getAlgorithmId().getParameters())) {
                DSAParameter dSAParameter = new DSAParameter((ASN1Sequence) subjectPublicKeyInfo.getAlgorithmId().getParameters());
                this.dsaSpec = new DSAParameterSpec(dSAParameter.getP(), dSAParameter.getQ(), dSAParameter.getG());
            }
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    private boolean isNotNull(DEREncodable dEREncodable) {
        return dEREncodable != null && !DERNull.INSTANCE.equals(dEREncodable);
    }

    public byte[] getEncoded() {
        if (this.dsaSpec == null) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier((DERObjectIdentifier) X9ObjectIdentifiers.id_dsa), (DEREncodable) new DERInteger(this.f6238y)).getDEREncoded();
        }
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).getDERObject()), (DEREncodable) new DERInteger(this.f6238y)).getDEREncoded();
    }

    public DSAParams getParams() {
        return this.dsaSpec;
    }

    public BigInteger getY() {
        return this.f6238y;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("DSA Public Key");
        stringBuffer.append(property);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(property);
        return stringBuffer.toString();
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        if (!getY().equals(dSAPublicKey.getY()) || !getParams().getG().equals(dSAPublicKey.getParams().getG()) || !getParams().getP().equals(dSAPublicKey.getParams().getP()) || !getParams().getQ().equals(dSAPublicKey.getParams().getQ())) {
            return false;
        }
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6238y = (BigInteger) objectInputStream.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f6238y);
        objectOutputStream.writeObject(this.dsaSpec.getP());
        objectOutputStream.writeObject(this.dsaSpec.getQ());
        objectOutputStream.writeObject(this.dsaSpec.getG());
    }
}
