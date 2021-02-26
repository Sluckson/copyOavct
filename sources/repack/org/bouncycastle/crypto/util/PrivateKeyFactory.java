package repack.org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.nist.NISTNamedCurves;
import repack.org.bouncycastle.asn1.oiw.ElGamalParameter;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.p065x9.X962NamedCurves;
import repack.org.bouncycastle.asn1.p065x9.X962Parameters;
import repack.org.bouncycastle.asn1.p065x9.X9ECParameters;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.DHParameter;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import repack.org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import repack.org.bouncycastle.asn1.sec.SECNamedCurves;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DSAParameter;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DSAParameters;
import repack.org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ElGamalParameters;
import repack.org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class PrivateKeyFactory {
    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(bArr)));
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        ECDomainParameters eCDomainParameters;
        int i;
        AlgorithmIdentifier algorithmId = privateKeyInfo.getAlgorithmId();
        if (algorithmId.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption)) {
            RSAPrivateKeyStructure rSAPrivateKeyStructure = new RSAPrivateKeyStructure((ASN1Sequence) privateKeyInfo.getPrivateKey());
            return new RSAPrivateCrtKeyParameters(rSAPrivateKeyStructure.getModulus(), rSAPrivateKeyStructure.getPublicExponent(), rSAPrivateKeyStructure.getPrivateExponent(), rSAPrivateKeyStructure.getPrime1(), rSAPrivateKeyStructure.getPrime2(), rSAPrivateKeyStructure.getExponent1(), rSAPrivateKeyStructure.getExponent2(), rSAPrivateKeyStructure.getCoefficient());
        }
        DSAParameters dSAParameters = null;
        if (algorithmId.getObjectId().equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = new DHParameter((ASN1Sequence) privateKeyInfo.getAlgorithmId().getParameters());
            DERInteger dERInteger = (DERInteger) privateKeyInfo.getPrivateKey();
            BigInteger l = dHParameter.getL();
            if (l == null) {
                i = 0;
            } else {
                i = l.intValue();
            }
            return new DHPrivateKeyParameters(dERInteger.getValue(), new DHParameters(dHParameter.getP(), dHParameter.getG(), (BigInteger) null, i));
        } else if (algorithmId.getObjectId().equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence) privateKeyInfo.getAlgorithmId().getParameters());
            return new ElGamalPrivateKeyParameters(((DERInteger) privateKeyInfo.getPrivateKey()).getValue(), new ElGamalParameters(elGamalParameter.getP(), elGamalParameter.getG()));
        } else if (algorithmId.getObjectId().equals(X9ObjectIdentifiers.id_dsa)) {
            DERInteger dERInteger2 = (DERInteger) privateKeyInfo.getPrivateKey();
            DEREncodable parameters = privateKeyInfo.getAlgorithmId().getParameters();
            if (parameters != null) {
                DSAParameter instance = DSAParameter.getInstance(parameters.getDERObject());
                dSAParameters = new DSAParameters(instance.getP(), instance.getQ(), instance.getG());
            }
            return new DSAPrivateKeyParameters(dERInteger2.getValue(), dSAParameters);
        } else if (algorithmId.getObjectId().equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            X962Parameters x962Parameters = new X962Parameters((DERObject) privateKeyInfo.getAlgorithmId().getParameters());
            if (x962Parameters.isNamedCurve()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) x962Parameters.getParameters();
                X9ECParameters byOID = X962NamedCurves.getByOID(dERObjectIdentifier);
                if (byOID == null && (byOID = SECNamedCurves.getByOID(dERObjectIdentifier)) == null && (byOID = NISTNamedCurves.getByOID(dERObjectIdentifier)) == null) {
                    byOID = TeleTrusTNamedCurves.getByOID(dERObjectIdentifier);
                }
                eCDomainParameters = new ECDomainParameters(byOID.getCurve(), byOID.getG(), byOID.getN(), byOID.getH(), byOID.getSeed());
            } else {
                X9ECParameters x9ECParameters = new X9ECParameters((ASN1Sequence) x962Parameters.getParameters());
                eCDomainParameters = new ECDomainParameters(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
            }
            return new ECPrivateKeyParameters(new ECPrivateKeyStructure((ASN1Sequence) privateKeyInfo.getPrivateKey()).getKey(), eCDomainParameters);
        } else {
            throw new RuntimeException("algorithm identifier in key not recognised");
        }
    }
}
