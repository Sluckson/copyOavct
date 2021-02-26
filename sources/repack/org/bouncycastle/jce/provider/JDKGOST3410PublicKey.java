package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import repack.org.bouncycastle.jce.interfaces.GOST3410Params;
import repack.org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import repack.org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import repack.org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import repack.org.bouncycastle.jce.spec.GOST3410PublicKeySpec;

public class JDKGOST3410PublicKey implements GOST3410PublicKey {
    private GOST3410Params gost3410Spec;

    /* renamed from: y */
    private BigInteger f6240y;

    public String getAlgorithm() {
        return "GOST3410";
    }

    public String getFormat() {
        return "X.509";
    }

    JDKGOST3410PublicKey(GOST3410PublicKeySpec gOST3410PublicKeySpec) {
        this.f6240y = gOST3410PublicKeySpec.getY();
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410PublicKeySpec.getP(), gOST3410PublicKeySpec.getQ(), gOST3410PublicKeySpec.getA()));
    }

    JDKGOST3410PublicKey(GOST3410PublicKey gOST3410PublicKey) {
        this.f6240y = gOST3410PublicKey.getY();
        this.gost3410Spec = gOST3410PublicKey.getParameters();
    }

    JDKGOST3410PublicKey(GOST3410PublicKeyParameters gOST3410PublicKeyParameters, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.f6240y = gOST3410PublicKeyParameters.getY();
        this.gost3410Spec = gOST3410ParameterSpec;
    }

    JDKGOST3410PublicKey(BigInteger bigInteger, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.f6240y = bigInteger;
        this.gost3410Spec = gOST3410ParameterSpec;
    }

    JDKGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence) subjectPublicKeyInfo.getAlgorithmId().getParameters());
        try {
            byte[] octets = ((DEROctetString) subjectPublicKeyInfo.getPublicKey()).getOctets();
            byte[] bArr = new byte[octets.length];
            for (int i = 0; i != octets.length; i++) {
                bArr[i] = octets[(octets.length - 1) - i];
            }
            this.f6240y = new BigInteger(1, bArr);
            this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(gOST3410PublicKeyAlgParameters);
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
        }
    }

    public byte[] getEncoded() {
        byte[] bArr;
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        byte[] byteArray = getY().toByteArray();
        if (byteArray[0] == 0) {
            bArr = new byte[(byteArray.length - 1)];
        } else {
            bArr = new byte[byteArray.length];
        }
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = byteArray[(byteArray.length - 1) - i];
        }
        GOST3410Params gOST3410Params = this.gost3410Spec;
        if (!(gOST3410Params instanceof GOST3410ParameterSpec)) {
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), (DEREncodable) new DEROctetString(bArr));
        } else if (gOST3410Params.getEncryptionParamSetOID() != null) {
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new DERObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new DERObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()), new DERObjectIdentifier(this.gost3410Spec.getEncryptionParamSetOID())).getDERObject()), (DEREncodable) new DEROctetString(bArr));
        } else {
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new DERObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new DERObjectIdentifier(this.gost3410Spec.getDigestParamSetOID())).getDERObject()), (DEREncodable) new DEROctetString(bArr));
        }
        return subjectPublicKeyInfo.getDEREncoded();
    }

    public GOST3410Params getParameters() {
        return this.gost3410Spec;
    }

    public BigInteger getY() {
        return this.f6240y;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("GOST3410 Public Key");
        stringBuffer.append(property);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(property);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof JDKGOST3410PublicKey) {
            JDKGOST3410PublicKey jDKGOST3410PublicKey = (JDKGOST3410PublicKey) obj;
            if (!this.f6240y.equals(jDKGOST3410PublicKey.f6240y) || !this.gost3410Spec.equals(jDKGOST3410PublicKey.gost3410Spec)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6240y.hashCode() ^ this.gost3410Spec.hashCode();
    }
}
