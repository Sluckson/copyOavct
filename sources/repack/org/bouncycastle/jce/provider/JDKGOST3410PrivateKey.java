package repack.org.bouncycastle.jce.provider;

import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import repack.org.bouncycastle.jce.interfaces.GOST3410Params;
import repack.org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import repack.org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import repack.org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import repack.org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class JDKGOST3410PrivateKey implements GOST3410PrivateKey, PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
    GOST3410Params gost3410Spec;

    /* renamed from: x */
    BigInteger f6239x;

    public String getAlgorithm() {
        return "GOST3410";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JDKGOST3410PrivateKey() {
    }

    JDKGOST3410PrivateKey(GOST3410PrivateKey gOST3410PrivateKey) {
        this.f6239x = gOST3410PrivateKey.getX();
        this.gost3410Spec = gOST3410PrivateKey.getParameters();
    }

    JDKGOST3410PrivateKey(GOST3410PrivateKeySpec gOST3410PrivateKeySpec) {
        this.f6239x = gOST3410PrivateKeySpec.getX();
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410PrivateKeySpec.getP(), gOST3410PrivateKeySpec.getQ(), gOST3410PrivateKeySpec.getA()));
    }

    JDKGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) {
        GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence) privateKeyInfo.getAlgorithmId().getParameters());
        byte[] octets = ((DEROctetString) privateKeyInfo.getPrivateKey()).getOctets();
        byte[] bArr = new byte[octets.length];
        for (int i = 0; i != octets.length; i++) {
            bArr[i] = octets[(octets.length - 1) - i];
        }
        this.f6239x = new BigInteger(1, bArr);
        this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(gOST3410PublicKeyAlgParameters);
    }

    JDKGOST3410PrivateKey(GOST3410PrivateKeyParameters gOST3410PrivateKeyParameters, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.f6239x = gOST3410PrivateKeyParameters.getX();
        this.gost3410Spec = gOST3410ParameterSpec;
        if (gOST3410ParameterSpec == null) {
            throw new IllegalArgumentException("spec is null");
        }
    }

    public byte[] getEncoded() {
        byte[] bArr;
        PrivateKeyInfo privateKeyInfo;
        byte[] byteArray = getX().toByteArray();
        if (byteArray[0] == 0) {
            bArr = new byte[(byteArray.length - 1)];
        } else {
            bArr = new byte[byteArray.length];
        }
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = byteArray[(byteArray.length - 1) - i];
        }
        if (this.gost3410Spec instanceof GOST3410ParameterSpec) {
            privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new DERObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new DERObjectIdentifier(this.gost3410Spec.getDigestParamSetOID())).getDERObject()), new DEROctetString(bArr));
        } else {
            privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(bArr));
        }
        return privateKeyInfo.getDEREncoded();
    }

    public GOST3410Params getParameters() {
        return this.gost3410Spec;
    }

    public BigInteger getX() {
        return this.f6239x;
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
