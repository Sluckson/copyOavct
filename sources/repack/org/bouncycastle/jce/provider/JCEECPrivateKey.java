package repack.org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROutputStream;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.p065x9.X962Parameters;
import repack.org.bouncycastle.asn1.p065x9.X9ECParameters;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.jce.interfaces.ECPointEncoder;
import repack.org.bouncycastle.jce.interfaces.ECPrivateKey;
import repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil;
import repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import repack.org.bouncycastle.jce.spec.ECParameterSpec;
import repack.org.bouncycastle.jce.spec.ECPrivateKeySpec;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECPoint;

public class JCEECPrivateKey implements ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    private String algorithm = "EC";
    private PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: d */
    private BigInteger f6228d;
    private ECParameterSpec ecSpec;
    private DERBitString publicKey;
    private boolean withCompression;

    public String getFormat() {
        return "PKCS#8";
    }

    protected JCEECPrivateKey() {
    }

    JCEECPrivateKey(ECPrivateKey eCPrivateKey) {
        this.f6228d = eCPrivateKey.getD();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParameters();
    }

    public JCEECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = str;
        this.f6228d = eCPrivateKeySpec.getD();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    public JCEECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, JCEECPublicKey jCEECPublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f6228d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.ecSpec = new ECParameterSpec(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed());
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.publicKey = getPublicKeyDetails(jCEECPublicKey);
    }

    public JCEECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = str;
        this.f6228d = eCPrivateKeyParameters.getD();
        this.ecSpec = null;
    }

    public JCEECPrivateKey(String str, JCEECPrivateKey jCEECPrivateKey) {
        this.algorithm = str;
        this.f6228d = jCEECPrivateKey.f6228d;
        this.ecSpec = jCEECPrivateKey.ecSpec;
        this.withCompression = jCEECPrivateKey.withCompression;
        this.publicKey = jCEECPrivateKey.publicKey;
        this.attrCarrier = jCEECPrivateKey.attrCarrier;
    }

    JCEECPrivateKey(PrivateKeyInfo privateKeyInfo) {
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo privateKeyInfo) {
        X962Parameters x962Parameters = new X962Parameters((DERObject) privateKeyInfo.getAlgorithmId().getParameters());
        if (x962Parameters.isNamedCurve()) {
            DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) x962Parameters.getParameters();
            X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(dERObjectIdentifier);
            this.ecSpec = new ECNamedCurveParameterSpec(ECUtil.getCurveName(dERObjectIdentifier), namedCurveByOid.getCurve(), namedCurveByOid.getG(), namedCurveByOid.getN(), namedCurveByOid.getH(), namedCurveByOid.getSeed());
        } else if (x962Parameters.isImplicitlyCA()) {
            this.ecSpec = null;
        } else {
            X9ECParameters x9ECParameters = new X9ECParameters((ASN1Sequence) x962Parameters.getParameters());
            this.ecSpec = new ECParameterSpec(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
        }
        if (privateKeyInfo.getPrivateKey() instanceof DERInteger) {
            this.f6228d = ((DERInteger) privateKeyInfo.getPrivateKey()).getValue();
            return;
        }
        ECPrivateKeyStructure eCPrivateKeyStructure = new ECPrivateKeyStructure((ASN1Sequence) privateKeyInfo.getPrivateKey());
        this.f6228d = eCPrivateKeyStructure.getKey();
        this.publicKey = eCPrivateKeyStructure.getPublicKey();
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        ECPrivateKeyStructure eCPrivateKeyStructure;
        PrivateKeyInfo privateKeyInfo;
        ECPoint f2m;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            x962Parameters = new X962Parameters(ECUtil.getNamedCurveOid(((ECNamedCurveParameterSpec) eCParameterSpec).getName()));
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters((DERObject) DERNull.INSTANCE);
        } else {
            ECCurve curve = eCParameterSpec.getG().getCurve();
            if (curve instanceof ECCurve.C5028Fp) {
                f2m = new ECPoint.C5030Fp(curve, eCParameterSpec.getG().getX(), eCParameterSpec.getG().getY(), this.withCompression);
            } else if (curve instanceof ECCurve.F2m) {
                f2m = new ECPoint.F2m(curve, eCParameterSpec.getG().getX(), eCParameterSpec.getG().getY(), this.withCompression);
            } else {
                throw new UnsupportedOperationException("Subclass of ECPoint " + curve.getClass().toString() + "not supported");
            }
            x962Parameters = new X962Parameters(new X9ECParameters(eCParameterSpec.getCurve(), f2m, eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed()));
        }
        if (this.publicKey != null) {
            eCPrivateKeyStructure = new ECPrivateKeyStructure(getD(), this.publicKey, x962Parameters);
        } else {
            eCPrivateKeyStructure = new ECPrivateKeyStructure(getD(), x962Parameters);
        }
        if (this.algorithm.equals("ECGOST3410")) {
            privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, x962Parameters.getDERObject()), eCPrivateKeyStructure.getDERObject());
        } else {
            privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters.getDERObject()), eCPrivateKeyStructure.getDERObject());
        }
        try {
            dEROutputStream.writeObject(privateKeyInfo);
            dEROutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding EC private key");
        }
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public ECParameterSpec getParameters() {
        return this.ecSpec;
    }

    public BigInteger getD() {
        return this.f6228d;
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

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    /* access modifiers changed from: package-private */
    public ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec != null) {
            return eCParameterSpec;
        }
        return ProviderUtil.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPrivateKey)) {
            return false;
        }
        JCEECPrivateKey jCEECPrivateKey = (JCEECPrivateKey) obj;
        if (!getD().equals(jCEECPrivateKey.getD()) || !engineGetSpec().equals(jCEECPrivateKey.engineGetSpec())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getD().hashCode() ^ engineGetSpec().hashCode();
    }

    private DERBitString getPublicKeyDetails(JCEECPublicKey jCEECPublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(jCEECPublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Object.fromByteArray((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.attrCarrier.readObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
        this.attrCarrier.writeObject(objectOutputStream);
    }
}
