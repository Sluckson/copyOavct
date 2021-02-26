package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import repack.org.bouncycastle.asn1.p065x9.X962Parameters;
import repack.org.bouncycastle.asn1.p065x9.X9ECParameters;
import repack.org.bouncycastle.asn1.p065x9.X9ECPoint;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.jce.interfaces.ECPointEncoder;
import repack.org.bouncycastle.jce.interfaces.ECPublicKey;
import repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil;
import repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import repack.org.bouncycastle.jce.spec.ECParameterSpec;
import repack.org.bouncycastle.jce.spec.ECPublicKeySpec;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECPoint;

public class JCEECPublicKey implements ECPublicKey, ECPointEncoder {
    private String algorithm = "EC";
    private ECParameterSpec ecSpec;
    private GOST3410PublicKeyAlgParameters gostParams;

    /* renamed from: q */
    private ECPoint f6229q;
    private boolean withCompression;

    public String getFormat() {
        return "X.509";
    }

    public JCEECPublicKey(String str, JCEECPublicKey jCEECPublicKey) {
        this.algorithm = str;
        this.f6229q = jCEECPublicKey.f6229q;
        this.ecSpec = jCEECPublicKey.ecSpec;
        this.withCompression = jCEECPublicKey.withCompression;
        this.gostParams = jCEECPublicKey.gostParams;
    }

    public JCEECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = str;
        this.f6229q = eCPublicKeySpec.getQ();
        if (eCPublicKeySpec.getParams() != null) {
            this.ecSpec = eCPublicKeySpec.getParams();
            return;
        }
        if (this.f6229q.getCurve() == null) {
            this.f6229q = ProviderUtil.getEcImplicitlyCa().getCurve().createPoint(this.f6229q.getX().toBigInteger(), this.f6229q.getY().toBigInteger(), false);
        }
        this.ecSpec = null;
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.f6229q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            this.ecSpec = new ECParameterSpec(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed());
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.f6229q = eCPublicKeyParameters.getQ();
        this.ecSpec = null;
    }

    JCEECPublicKey(ECPublicKey eCPublicKey) {
        this.f6229q = eCPublicKey.getQ();
        this.algorithm = eCPublicKey.getAlgorithm();
        this.ecSpec = eCPublicKey.getParameters();
    }

    JCEECPublicKey(String str, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        this.algorithm = str;
        this.f6229q = eCPoint;
        this.ecSpec = eCParameterSpec;
    }

    JCEECPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    /* JADX WARNING: type inference failed for: r14v6, types: [repack.org.bouncycastle.asn1.ASN1Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo r14) {
        /*
            r13 = this;
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r14.getAlgorithmId()
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = r0.getObjectId()
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers.gostR3410_2001
            boolean r0 = r0.equals(r1)
            java.lang.String r1 = "error recovering public key"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0087
            repack.org.bouncycastle.asn1.DERBitString r0 = r14.getPublicKeyData()
            java.lang.String r4 = "ECGOST3410"
            r13.algorithm = r4
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0081 }
            repack.org.bouncycastle.asn1.ASN1Object r0 = repack.org.bouncycastle.asn1.ASN1Object.fromByteArray(r0)     // Catch:{ IOException -> 0x0081 }
            repack.org.bouncycastle.asn1.ASN1OctetString r0 = (repack.org.bouncycastle.asn1.ASN1OctetString) r0     // Catch:{ IOException -> 0x0081 }
            byte[] r0 = r0.getOctets()
            r1 = 32
            byte[] r4 = new byte[r1]
            byte[] r5 = new byte[r1]
            r1 = 0
        L_0x0031:
            int r6 = r4.length
            if (r1 != r6) goto L_0x0078
            r1 = 0
        L_0x0035:
            int r6 = r5.length
            if (r1 != r6) goto L_0x006f
            repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r0 = new repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r14 = r14.getAlgorithmId()
            repack.org.bouncycastle.asn1.DEREncodable r14 = r14.getParameters()
            repack.org.bouncycastle.asn1.ASN1Sequence r14 = (repack.org.bouncycastle.asn1.ASN1Sequence) r14
            r0.<init>(r14)
            r13.gostParams = r0
            repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r14 = r13.gostParams
            repack.org.bouncycastle.asn1.DERObjectIdentifier r14 = r14.getPublicKeyParamSet()
            java.lang.String r14 = repack.org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r14)
            repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec r14 = repack.org.bouncycastle.jce.ECGOST3410NamedCurveTable.getParameterSpec(r14)
            r13.ecSpec = r14
            repack.org.bouncycastle.math.ec.ECCurve r14 = r14.getCurve()
            java.math.BigInteger r0 = new java.math.BigInteger
            r0.<init>(r3, r4)
            java.math.BigInteger r1 = new java.math.BigInteger
            r1.<init>(r3, r5)
            repack.org.bouncycastle.math.ec.ECPoint r14 = r14.createPoint(r0, r1, r2)
            r13.f6229q = r14
            goto L_0x0154
        L_0x006f:
            int r6 = 63 - r1
            byte r6 = r0[r6]
            r5[r1] = r6
            int r1 = r1 + 1
            goto L_0x0035
        L_0x0078:
            int r6 = 31 - r1
            byte r6 = r0[r6]
            r4[r1] = r6
            int r1 = r1 + 1
            goto L_0x0031
        L_0x0081:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            r14.<init>(r1)
            throw r14
        L_0x0087:
            repack.org.bouncycastle.asn1.x9.X962Parameters r0 = new repack.org.bouncycastle.asn1.x9.X962Parameters
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r4 = r14.getAlgorithmId()
            repack.org.bouncycastle.asn1.DEREncodable r4 = r4.getParameters()
            repack.org.bouncycastle.asn1.DERObject r4 = (repack.org.bouncycastle.asn1.DERObject) r4
            r0.<init>((repack.org.bouncycastle.asn1.DERObject) r4)
            boolean r4 = r0.isNamedCurve()
            if (r4 == 0) goto L_0x00cd
            repack.org.bouncycastle.asn1.DERObject r0 = r0.getParameters()
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r0
            repack.org.bouncycastle.asn1.x9.X9ECParameters r4 = repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil.getNamedCurveByOid(r0)
            repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec r12 = new repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec
            java.lang.String r6 = repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil.getCurveName(r0)
            repack.org.bouncycastle.math.ec.ECCurve r7 = r4.getCurve()
            repack.org.bouncycastle.math.ec.ECPoint r8 = r4.getG()
            java.math.BigInteger r9 = r4.getN()
            java.math.BigInteger r10 = r4.getH()
            byte[] r11 = r4.getSeed()
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r13.ecSpec = r12
            repack.org.bouncycastle.jce.spec.ECParameterSpec r0 = r13.ecSpec
            repack.org.bouncycastle.math.ec.ECCurve r0 = r0.getCurve()
            goto L_0x010c
        L_0x00cd:
            boolean r4 = r0.isImplicitlyCA()
            if (r4 == 0) goto L_0x00df
            r0 = 0
            r13.ecSpec = r0
            repack.org.bouncycastle.jce.spec.ECParameterSpec r0 = repack.org.bouncycastle.jce.provider.ProviderUtil.getEcImplicitlyCa()
            repack.org.bouncycastle.math.ec.ECCurve r0 = r0.getCurve()
            goto L_0x010c
        L_0x00df:
            repack.org.bouncycastle.asn1.x9.X9ECParameters r4 = new repack.org.bouncycastle.asn1.x9.X9ECParameters
            repack.org.bouncycastle.asn1.DERObject r0 = r0.getParameters()
            repack.org.bouncycastle.asn1.ASN1Sequence r0 = (repack.org.bouncycastle.asn1.ASN1Sequence) r0
            r4.<init>(r0)
            repack.org.bouncycastle.jce.spec.ECParameterSpec r0 = new repack.org.bouncycastle.jce.spec.ECParameterSpec
            repack.org.bouncycastle.math.ec.ECCurve r6 = r4.getCurve()
            repack.org.bouncycastle.math.ec.ECPoint r7 = r4.getG()
            java.math.BigInteger r8 = r4.getN()
            java.math.BigInteger r9 = r4.getH()
            byte[] r10 = r4.getSeed()
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r13.ecSpec = r0
            repack.org.bouncycastle.jce.spec.ECParameterSpec r0 = r13.ecSpec
            repack.org.bouncycastle.math.ec.ECCurve r0 = r0.getCurve()
        L_0x010c:
            repack.org.bouncycastle.asn1.DERBitString r14 = r14.getPublicKeyData()
            byte[] r14 = r14.getBytes()
            repack.org.bouncycastle.asn1.DEROctetString r4 = new repack.org.bouncycastle.asn1.DEROctetString
            r4.<init>((byte[]) r14)
            byte r2 = r14[r2]
            r5 = 4
            if (r2 != r5) goto L_0x0149
            byte r2 = r14[r3]
            int r3 = r14.length
            r5 = 2
            int r3 = r3 - r5
            if (r2 != r3) goto L_0x0149
            byte r2 = r14[r5]
            r3 = 3
            if (r2 == r5) goto L_0x012e
            byte r2 = r14[r5]
            if (r2 != r3) goto L_0x0149
        L_0x012e:
            repack.org.bouncycastle.asn1.x9.X9IntegerConverter r2 = new repack.org.bouncycastle.asn1.x9.X9IntegerConverter
            r2.<init>()
            int r2 = r2.getByteLength((repack.org.bouncycastle.math.p070ec.ECCurve) r0)
            int r5 = r14.length
            int r5 = r5 - r3
            if (r2 < r5) goto L_0x0149
            repack.org.bouncycastle.asn1.ASN1Object r14 = repack.org.bouncycastle.asn1.ASN1Object.fromByteArray(r14)     // Catch:{ IOException -> 0x0143 }
            r4 = r14
            repack.org.bouncycastle.asn1.ASN1OctetString r4 = (repack.org.bouncycastle.asn1.ASN1OctetString) r4     // Catch:{ IOException -> 0x0143 }
            goto L_0x0149
        L_0x0143:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            r14.<init>(r1)
            throw r14
        L_0x0149:
            repack.org.bouncycastle.asn1.x9.X9ECPoint r14 = new repack.org.bouncycastle.asn1.x9.X9ECPoint
            r14.<init>(r0, r4)
            repack.org.bouncycastle.math.ec.ECPoint r14 = r14.getPoint()
            r13.f6229q = r14
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.JCEECPublicKey.populateFromPubKeyInfo(repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        X962Parameters x962Parameters;
        if (this.algorithm.equals("ECGOST3410")) {
            DEREncodable dEREncodable = this.gostParams;
            if (dEREncodable == null) {
                ECParameterSpec eCParameterSpec = this.ecSpec;
                if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
                    dEREncodable = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveParameterSpec) eCParameterSpec).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
                } else {
                    dEREncodable = new X962Parameters(new X9ECParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG().getCurve().createPoint(eCParameterSpec.getG().getX().toBigInteger(), eCParameterSpec.getG().getY().toBigInteger(), this.withCompression), eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed()));
                }
            }
            ECPoint q = getQ();
            ASN1OctetString aSN1OctetString = (ASN1OctetString) new X9ECPoint(q.getCurve().createPoint(q.getX().toBigInteger(), q.getY().toBigInteger(), false)).getDERObject();
            BigInteger bigInteger = this.f6229q.getX().toBigInteger();
            BigInteger bigInteger2 = this.f6229q.getY().toBigInteger();
            byte[] bArr = new byte[64];
            byte[] byteArray = bigInteger.toByteArray();
            for (int i = 0; i != 32; i++) {
                bArr[i] = byteArray[(byteArray.length - 1) - i];
            }
            byte[] byteArray2 = bigInteger2.toByteArray();
            for (int i2 = 0; i2 != 32; i2++) {
                bArr[i2 + 32] = byteArray2[(byteArray2.length - 1) - i2];
            }
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, dEREncodable.getDERObject()), (DEREncodable) new DEROctetString(bArr));
        } else {
            ECParameterSpec eCParameterSpec2 = this.ecSpec;
            if (eCParameterSpec2 instanceof ECNamedCurveParameterSpec) {
                DERObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveParameterSpec) eCParameterSpec2).getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new DERObjectIdentifier(((ECNamedCurveParameterSpec) this.ecSpec).getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
            } else if (eCParameterSpec2 == null) {
                x962Parameters = new X962Parameters((DERObject) DERNull.INSTANCE);
            } else {
                x962Parameters = new X962Parameters(new X9ECParameters(eCParameterSpec2.getCurve(), eCParameterSpec2.getG().getCurve().createPoint(eCParameterSpec2.getG().getX().toBigInteger(), eCParameterSpec2.getG().getY().toBigInteger(), this.withCompression), eCParameterSpec2.getN(), eCParameterSpec2.getH(), eCParameterSpec2.getSeed()));
            }
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters.getDERObject()), ((ASN1OctetString) new X9ECPoint(engineGetQ().getCurve().createPoint(getQ().getX().toBigInteger(), getQ().getY().toBigInteger(), this.withCompression)).getDERObject()).getOctets());
        }
        return subjectPublicKeyInfo.getDEREncoded();
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public ECParameterSpec getParameters() {
        return this.ecSpec;
    }

    public ECPoint getQ() {
        if (this.ecSpec != null) {
            return this.f6229q;
        }
        ECPoint eCPoint = this.f6229q;
        if (eCPoint instanceof ECPoint.C5030Fp) {
            return new ECPoint.C5030Fp((ECCurve) null, eCPoint.getX(), this.f6229q.getY());
        }
        return new ECPoint.F2m((ECCurve) null, eCPoint.getX(), this.f6229q.getY());
    }

    public ECPoint engineGetQ() {
        return this.f6229q;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("EC Public Key");
        stringBuffer.append(property);
        stringBuffer.append("            X: ");
        stringBuffer.append(getQ().getX().toBigInteger().toString(16));
        stringBuffer.append(property);
        stringBuffer.append("            Y: ");
        stringBuffer.append(getQ().getY().toBigInteger().toString(16));
        stringBuffer.append(property);
        return stringBuffer.toString();
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
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        if (!getQ().equals(jCEECPublicKey.getQ()) || !engineGetSpec().equals(jCEECPublicKey.engineGetSpec())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getQ().hashCode() ^ engineGetSpec().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
    }
}
