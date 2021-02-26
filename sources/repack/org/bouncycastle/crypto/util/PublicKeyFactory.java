package repack.org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class PublicKeyFactory {
    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(bArr)));
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: repack.org.bouncycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: repack.org.bouncycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: repack.org.bouncycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: repack.org.bouncycastle.crypto.params.DHValidationParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: repack.org.bouncycastle.crypto.params.DSAParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: repack.org.bouncycastle.crypto.params.DSAParameters} */
    /* JADX WARNING: type inference failed for: r3v9, types: [repack.org.bouncycastle.crypto.params.DHValidationParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter createKey(repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo r10) throws java.io.IOException {
        /*
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r10.getAlgorithmId()
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.rsaEncryption
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 != 0) goto L_0x020a
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = repack.org.bouncycastle.asn1.x509.X509ObjectIdentifiers.id_ea_rsa
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x001f
            goto L_0x020a
        L_0x001f:
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers.dhpublicnumber
            boolean r1 = r1.equals(r3)
            r3 = 0
            if (r1 == 0) goto L_0x009d
            repack.org.bouncycastle.asn1.DERObject r0 = r10.getPublicKey()
            repack.org.bouncycastle.asn1.x9.DHPublicKey r0 = repack.org.bouncycastle.asn1.p065x9.DHPublicKey.getInstance(r0)
            repack.org.bouncycastle.asn1.DERInteger r0 = r0.getY()
            java.math.BigInteger r0 = r0.getValue()
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r10 = r10.getAlgorithmId()
            repack.org.bouncycastle.asn1.DEREncodable r10 = r10.getParameters()
            repack.org.bouncycastle.asn1.x9.DHDomainParameters r10 = repack.org.bouncycastle.asn1.p065x9.DHDomainParameters.getInstance(r10)
            repack.org.bouncycastle.asn1.DERInteger r1 = r10.getP()
            java.math.BigInteger r5 = r1.getValue()
            repack.org.bouncycastle.asn1.DERInteger r1 = r10.getG()
            java.math.BigInteger r6 = r1.getValue()
            repack.org.bouncycastle.asn1.DERInteger r1 = r10.getQ()
            java.math.BigInteger r7 = r1.getValue()
            repack.org.bouncycastle.asn1.DERInteger r1 = r10.getJ()
            if (r1 == 0) goto L_0x0070
            repack.org.bouncycastle.asn1.DERInteger r1 = r10.getJ()
            java.math.BigInteger r1 = r1.getValue()
            r8 = r1
            goto L_0x0071
        L_0x0070:
            r8 = r3
        L_0x0071:
            repack.org.bouncycastle.asn1.x9.DHValidationParms r10 = r10.getValidationParms()
            if (r10 == 0) goto L_0x0090
            repack.org.bouncycastle.asn1.DERBitString r1 = r10.getSeed()
            byte[] r1 = r1.getBytes()
            repack.org.bouncycastle.asn1.DERInteger r10 = r10.getPgenCounter()
            java.math.BigInteger r10 = r10.getValue()
            repack.org.bouncycastle.crypto.params.DHValidationParameters r3 = new repack.org.bouncycastle.crypto.params.DHValidationParameters
            int r10 = r10.intValue()
            r3.<init>(r1, r10)
        L_0x0090:
            r9 = r3
            repack.org.bouncycastle.crypto.params.DHPublicKeyParameters r10 = new repack.org.bouncycastle.crypto.params.DHPublicKeyParameters
            repack.org.bouncycastle.crypto.params.DHParameters r1 = new repack.org.bouncycastle.crypto.params.DHParameters
            r4 = r1
            r4.<init>((java.math.BigInteger) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7, (java.math.BigInteger) r8, (repack.org.bouncycastle.crypto.params.DHValidationParameters) r9)
            r10.<init>(r0, r1)
            return r10
        L_0x009d:
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4 = repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.dhKeyAgreement
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00e0
            repack.org.bouncycastle.asn1.pkcs.DHParameter r0 = new repack.org.bouncycastle.asn1.pkcs.DHParameter
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r10.getAlgorithmId()
            repack.org.bouncycastle.asn1.DEREncodable r1 = r1.getParameters()
            repack.org.bouncycastle.asn1.ASN1Sequence r1 = (repack.org.bouncycastle.asn1.ASN1Sequence) r1
            r0.<init>(r1)
            repack.org.bouncycastle.asn1.DERObject r10 = r10.getPublicKey()
            repack.org.bouncycastle.asn1.DERInteger r10 = (repack.org.bouncycastle.asn1.DERInteger) r10
            java.math.BigInteger r1 = r0.getL()
            if (r1 != 0) goto L_0x00c5
            goto L_0x00c9
        L_0x00c5:
            int r2 = r1.intValue()
        L_0x00c9:
            repack.org.bouncycastle.crypto.params.DHParameters r1 = new repack.org.bouncycastle.crypto.params.DHParameters
            java.math.BigInteger r4 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r1.<init>(r4, r0, r3, r2)
            repack.org.bouncycastle.crypto.params.DHPublicKeyParameters r0 = new repack.org.bouncycastle.crypto.params.DHPublicKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r1)
            return r0
        L_0x00e0:
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers.elGamalAlgorithm
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0118
            repack.org.bouncycastle.asn1.oiw.ElGamalParameter r0 = new repack.org.bouncycastle.asn1.oiw.ElGamalParameter
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r10.getAlgorithmId()
            repack.org.bouncycastle.asn1.DEREncodable r1 = r1.getParameters()
            repack.org.bouncycastle.asn1.ASN1Sequence r1 = (repack.org.bouncycastle.asn1.ASN1Sequence) r1
            r0.<init>(r1)
            repack.org.bouncycastle.asn1.DERObject r10 = r10.getPublicKey()
            repack.org.bouncycastle.asn1.DERInteger r10 = (repack.org.bouncycastle.asn1.DERInteger) r10
            repack.org.bouncycastle.crypto.params.ElGamalPublicKeyParameters r1 = new repack.org.bouncycastle.crypto.params.ElGamalPublicKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            repack.org.bouncycastle.crypto.params.ElGamalParameters r2 = new repack.org.bouncycastle.crypto.params.ElGamalParameters
            java.math.BigInteger r3 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r2.<init>(r3, r0)
            r1.<init>(r10, r2)
            return r1
        L_0x0118:
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers.id_dsa
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01d7
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers.dsaWithSHA1
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0132
            goto L_0x01d7
        L_0x0132:
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = r0.getObjectId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers.id_ecPublicKey
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01cf
            repack.org.bouncycastle.asn1.x9.X962Parameters r0 = new repack.org.bouncycastle.asn1.x9.X962Parameters
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r10.getAlgorithmId()
            repack.org.bouncycastle.asn1.DEREncodable r1 = r1.getParameters()
            repack.org.bouncycastle.asn1.DERObject r1 = (repack.org.bouncycastle.asn1.DERObject) r1
            r0.<init>((repack.org.bouncycastle.asn1.DERObject) r1)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x018a
            repack.org.bouncycastle.asn1.DERObject r0 = r0.getParameters()
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r0
            repack.org.bouncycastle.asn1.x9.X9ECParameters r1 = repack.org.bouncycastle.asn1.p065x9.X962NamedCurves.getByOID(r0)
            if (r1 != 0) goto L_0x016f
            repack.org.bouncycastle.asn1.x9.X9ECParameters r1 = repack.org.bouncycastle.asn1.sec.SECNamedCurves.getByOID(r0)
            if (r1 != 0) goto L_0x016f
            repack.org.bouncycastle.asn1.x9.X9ECParameters r1 = repack.org.bouncycastle.asn1.nist.NISTNamedCurves.getByOID(r0)
            if (r1 != 0) goto L_0x016f
            repack.org.bouncycastle.asn1.x9.X9ECParameters r1 = repack.org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves.getByOID(r0)
        L_0x016f:
            repack.org.bouncycastle.crypto.params.ECDomainParameters r0 = new repack.org.bouncycastle.crypto.params.ECDomainParameters
            repack.org.bouncycastle.math.ec.ECCurve r3 = r1.getCurve()
            repack.org.bouncycastle.math.ec.ECPoint r4 = r1.getG()
            java.math.BigInteger r5 = r1.getN()
            java.math.BigInteger r6 = r1.getH()
            byte[] r7 = r1.getSeed()
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x01af
        L_0x018a:
            repack.org.bouncycastle.asn1.x9.X9ECParameters r1 = new repack.org.bouncycastle.asn1.x9.X9ECParameters
            repack.org.bouncycastle.asn1.DERObject r0 = r0.getParameters()
            repack.org.bouncycastle.asn1.ASN1Sequence r0 = (repack.org.bouncycastle.asn1.ASN1Sequence) r0
            r1.<init>(r0)
            repack.org.bouncycastle.crypto.params.ECDomainParameters r0 = new repack.org.bouncycastle.crypto.params.ECDomainParameters
            repack.org.bouncycastle.math.ec.ECCurve r3 = r1.getCurve()
            repack.org.bouncycastle.math.ec.ECPoint r4 = r1.getG()
            java.math.BigInteger r5 = r1.getN()
            java.math.BigInteger r6 = r1.getH()
            byte[] r7 = r1.getSeed()
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x01af:
            repack.org.bouncycastle.asn1.DERBitString r10 = r10.getPublicKeyData()
            byte[] r10 = r10.getBytes()
            repack.org.bouncycastle.asn1.DEROctetString r1 = new repack.org.bouncycastle.asn1.DEROctetString
            r1.<init>((byte[]) r10)
            repack.org.bouncycastle.asn1.x9.X9ECPoint r10 = new repack.org.bouncycastle.asn1.x9.X9ECPoint
            repack.org.bouncycastle.math.ec.ECCurve r2 = r0.getCurve()
            r10.<init>(r2, r1)
            repack.org.bouncycastle.crypto.params.ECPublicKeyParameters r1 = new repack.org.bouncycastle.crypto.params.ECPublicKeyParameters
            repack.org.bouncycastle.math.ec.ECPoint r10 = r10.getPoint()
            r1.<init>(r10, r0)
            return r1
        L_0x01cf:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "algorithm identifier in key not recognised"
            r10.<init>(r0)
            throw r10
        L_0x01d7:
            repack.org.bouncycastle.asn1.DERObject r0 = r10.getPublicKey()
            repack.org.bouncycastle.asn1.DERInteger r0 = (repack.org.bouncycastle.asn1.DERInteger) r0
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r10 = r10.getAlgorithmId()
            repack.org.bouncycastle.asn1.DEREncodable r10 = r10.getParameters()
            if (r10 == 0) goto L_0x0200
            repack.org.bouncycastle.asn1.DERObject r10 = r10.getDERObject()
            repack.org.bouncycastle.asn1.x509.DSAParameter r10 = repack.org.bouncycastle.asn1.x509.DSAParameter.getInstance(r10)
            repack.org.bouncycastle.crypto.params.DSAParameters r3 = new repack.org.bouncycastle.crypto.params.DSAParameters
            java.math.BigInteger r1 = r10.getP()
            java.math.BigInteger r2 = r10.getQ()
            java.math.BigInteger r10 = r10.getG()
            r3.<init>(r1, r2, r10)
        L_0x0200:
            repack.org.bouncycastle.crypto.params.DSAPublicKeyParameters r10 = new repack.org.bouncycastle.crypto.params.DSAPublicKeyParameters
            java.math.BigInteger r0 = r0.getValue()
            r10.<init>(r0, r3)
            return r10
        L_0x020a:
            repack.org.bouncycastle.asn1.x509.RSAPublicKeyStructure r0 = new repack.org.bouncycastle.asn1.x509.RSAPublicKeyStructure
            repack.org.bouncycastle.asn1.DERObject r10 = r10.getPublicKey()
            repack.org.bouncycastle.asn1.ASN1Sequence r10 = (repack.org.bouncycastle.asn1.ASN1Sequence) r10
            r0.<init>(r10)
            repack.org.bouncycastle.crypto.params.RSAKeyParameters r10 = new repack.org.bouncycastle.crypto.params.RSAKeyParameters
            java.math.BigInteger r1 = r0.getModulus()
            java.math.BigInteger r0 = r0.getPublicExponent()
            r10.<init>(r2, r1, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.crypto.util.PublicKeyFactory.createKey(repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo):repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter");
    }
}
