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
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.p065x9.DHDomainParameters;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.DHParameter;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.params.DHPublicKeyParameters;

public class JCEDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private DHParameterSpec dhSpec;
    private SubjectPublicKeyInfo info;

    /* renamed from: y */
    private BigInteger f6227y;

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "X.509";
    }

    JCEDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f6227y = dHPublicKeySpec.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    JCEDHPublicKey(DHPublicKey dHPublicKey) {
        this.f6227y = dHPublicKey.getY();
        this.dhSpec = dHPublicKey.getParams();
    }

    JCEDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.f6227y = dHPublicKeyParameters.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeyParameters.getParameters().getP(), dHPublicKeyParameters.getParameters().getG(), dHPublicKeyParameters.getParameters().getL());
    }

    JCEDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.f6227y = bigInteger;
        this.dhSpec = dHParameterSpec;
    }

    JCEDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.info = subjectPublicKeyInfo;
        try {
            this.f6227y = ((DERInteger) subjectPublicKeyInfo.getPublicKey()).getValue();
            ASN1Sequence instance = ASN1Sequence.getInstance(subjectPublicKeyInfo.getAlgorithmId().getParameters());
            DERObjectIdentifier objectId = subjectPublicKeyInfo.getAlgorithmId().getObjectId();
            if (objectId.equals(PKCSObjectIdentifiers.dhKeyAgreement) || isPKCSParam(instance)) {
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
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.info;
        if (subjectPublicKeyInfo != null) {
            return subjectPublicKeyInfo.getDEREncoded();
        }
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).getDERObject()), (DEREncodable) new DERInteger(this.f6227y)).getDEREncoded();
    }

    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    public BigInteger getY() {
        return this.f6227y;
    }

    private boolean isPKCSParam(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            return true;
        }
        if (aSN1Sequence.size() > 3) {
            return false;
        }
        if (DERInteger.getInstance(aSN1Sequence.getObjectAt(2)).getValue().compareTo(BigInteger.valueOf((long) DERInteger.getInstance(aSN1Sequence.getObjectAt(0)).getValue().bitLength())) > 0) {
            return false;
        }
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6227y = (BigInteger) objectInputStream.readObject();
        this.dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.dhSpec.getP());
        objectOutputStream.writeObject(this.dhSpec.getG());
        objectOutputStream.writeInt(this.dhSpec.getL());
    }
}
