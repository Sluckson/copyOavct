package repack.org.bouncycastle.asn1.p064bc;

import repack.org.bouncycastle.asn1.DERObjectIdentifier;

/* renamed from: repack.org.bouncycastle.asn1.bc.BCObjectIdentifiers */
public interface BCObjectIdentifiers {

    /* renamed from: bc */
    public static final DERObjectIdentifier f5830bc = new DERObjectIdentifier("1.3.6.1.4.1.22554");
    public static final DERObjectIdentifier bc_pbe = new DERObjectIdentifier(String.valueOf(f5830bc.getId()) + ".1");
    public static final DERObjectIdentifier bc_pbe_sha1 = new DERObjectIdentifier(String.valueOf(bc_pbe.getId()) + ".1");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12 = new DERObjectIdentifier(String.valueOf(bc_pbe_sha1.getId()) + ".2");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc = new DERObjectIdentifier(String.valueOf(bc_pbe_sha1_pkcs12.getId()) + ".1.2");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc = new DERObjectIdentifier(String.valueOf(bc_pbe_sha1_pkcs12.getId()) + ".1.22");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc = new DERObjectIdentifier(String.valueOf(bc_pbe_sha1_pkcs12.getId()) + ".1.42");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs5 = new DERObjectIdentifier(String.valueOf(bc_pbe_sha1.getId()) + ".1");
    public static final DERObjectIdentifier bc_pbe_sha224 = new DERObjectIdentifier(String.valueOf(bc_pbe.getId()) + ".2.4");
    public static final DERObjectIdentifier bc_pbe_sha256 = new DERObjectIdentifier(String.valueOf(bc_pbe.getId()) + ".2.1");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12 = new DERObjectIdentifier(String.valueOf(bc_pbe_sha256.getId()) + ".2");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc = new DERObjectIdentifier(String.valueOf(bc_pbe_sha256_pkcs12.getId()) + ".1.2");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc = new DERObjectIdentifier(String.valueOf(bc_pbe_sha256_pkcs12.getId()) + ".1.22");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc = new DERObjectIdentifier(String.valueOf(bc_pbe_sha256_pkcs12.getId()) + ".1.42");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs5 = new DERObjectIdentifier(String.valueOf(bc_pbe_sha256.getId()) + ".1");
    public static final DERObjectIdentifier bc_pbe_sha384 = new DERObjectIdentifier(String.valueOf(bc_pbe.getId()) + ".2.2");
    public static final DERObjectIdentifier bc_pbe_sha512 = new DERObjectIdentifier(String.valueOf(bc_pbe.getId()) + ".2.3");
}
