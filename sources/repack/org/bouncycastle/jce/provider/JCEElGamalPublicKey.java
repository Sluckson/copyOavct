package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.oiw.ElGamalParameter;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import repack.org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import repack.org.bouncycastle.jce.spec.ElGamalParameterSpec;
import repack.org.bouncycastle.jce.spec.ElGamalPublicKeySpec;

public class JCEElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    private ElGamalParameterSpec elSpec;

    /* renamed from: y */
    private BigInteger f6231y;

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "X.509";
    }

    JCEElGamalPublicKey(ElGamalPublicKeySpec elGamalPublicKeySpec) {
        this.f6231y = elGamalPublicKeySpec.getY();
        this.elSpec = new ElGamalParameterSpec(elGamalPublicKeySpec.getParams().getP(), elGamalPublicKeySpec.getParams().getG());
    }

    JCEElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f6231y = dHPublicKeySpec.getY();
        this.elSpec = new ElGamalParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    JCEElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.f6231y = elGamalPublicKey.getY();
        this.elSpec = elGamalPublicKey.getParameters();
    }

    JCEElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.f6231y = dHPublicKey.getY();
        this.elSpec = new ElGamalParameterSpec(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    JCEElGamalPublicKey(ElGamalPublicKeyParameters elGamalPublicKeyParameters) {
        this.f6231y = elGamalPublicKeyParameters.getY();
        this.elSpec = new ElGamalParameterSpec(elGamalPublicKeyParameters.getParameters().getP(), elGamalPublicKeyParameters.getParameters().getG());
    }

    JCEElGamalPublicKey(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        this.f6231y = bigInteger;
        this.elSpec = elGamalParameterSpec;
    }

    JCEElGamalPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence) subjectPublicKeyInfo.getAlgorithmId().getParameters());
        try {
            this.f6231y = ((DERInteger) subjectPublicKeyInfo.getPublicKey()).getValue();
            this.elSpec = new ElGamalParameterSpec(elGamalParameter.getP(), elGamalParameter.getG());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    public byte[] getEncoded() {
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG()).getDERObject()), (DEREncodable) new DERInteger(this.f6231y)).getDEREncoded();
    }

    public ElGamalParameterSpec getParameters() {
        return this.elSpec;
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
    }

    public BigInteger getY() {
        return this.f6231y;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6231y = (BigInteger) objectInputStream.readObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.elSpec.getP());
        objectOutputStream.writeObject(this.elSpec.getG());
    }
}
