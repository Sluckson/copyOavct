package repack.org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import repack.org.bouncycastle.asn1.ASN1Null;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSAlgorithm;
import repack.org.bouncycastle.cms.CMSEnvelopedDataGenerator;
import repack.org.bouncycastle.cms.CMSEnvelopedGenerator;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.crypto.tls.AlertDescription;
import repack.org.bouncycastle.jcajce.JcaJceHelper;
import repack.org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import repack.org.bouncycastle.operator.SymmetricKeyUnwrapper;

class EnvelopedDataHelper {
    protected static final Map BASE_CIPHER_NAMES = new HashMap();
    protected static final Map CIPHER_ALG_NAMES = new HashMap();
    protected static final Map MAC_ALG_NAMES = new HashMap();
    private static final short[] rc2Ekb;
    private static final short[] rc2Table;
    private JcaJceHelper helper;

    interface JCECallback {
        Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException;
    }

    static {
        BASE_CIPHER_NAMES.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE");
        BASE_CIPHER_NAMES.put(CMSAlgorithm.AES128_CBC, "AES");
        BASE_CIPHER_NAMES.put(CMSAlgorithm.AES192_CBC, "AES");
        BASE_CIPHER_NAMES.put(CMSAlgorithm.AES256_CBC, "AES");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.AES128_CBC, "AES/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.AES192_CBC, "AES/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.AES256_CBC, "AES/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(new ASN1ObjectIdentifier(PKCSObjectIdentifiers.rsaEncryption.getId()), "RSA/ECB/PKCS1Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.CAST5_CBC, "CAST5/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.CAMELLIA128_CBC, "Camellia/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.CAMELLIA192_CBC, "Camellia/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.CAMELLIA256_CBC, "Camellia/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSAlgorithm.SEED_CBC, "SEED/CBC/PKCS5Padding");
        MAC_ALG_NAMES.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDEMac");
        MAC_ALG_NAMES.put(CMSAlgorithm.AES128_CBC, "AESMac");
        MAC_ALG_NAMES.put(CMSAlgorithm.AES192_CBC, "AESMac");
        MAC_ALG_NAMES.put(CMSAlgorithm.AES256_CBC, "AESMac");
        MAC_ALG_NAMES.put(CMSAlgorithm.RC2_CBC, "RC2Mac");
        short[] sArr = new short[256];
        sArr[0] = 189;
        sArr[1] = 86;
        sArr[2] = 234;
        sArr[3] = 242;
        sArr[4] = 162;
        sArr[5] = 241;
        sArr[6] = 172;
        sArr[7] = 42;
        sArr[8] = 176;
        sArr[9] = 147;
        sArr[10] = 209;
        sArr[11] = 156;
        sArr[12] = 27;
        sArr[13] = 51;
        sArr[14] = 253;
        sArr[15] = 208;
        sArr[16] = 48;
        sArr[17] = 4;
        sArr[18] = 182;
        sArr[19] = 220;
        sArr[20] = 125;
        sArr[21] = 223;
        sArr[22] = 50;
        sArr[23] = 75;
        sArr[24] = 247;
        sArr[25] = 203;
        sArr[26] = 69;
        sArr[27] = 155;
        sArr[28] = 49;
        sArr[29] = 187;
        sArr[30] = 33;
        sArr[31] = 90;
        sArr[32] = 65;
        sArr[33] = 159;
        sArr[34] = 225;
        sArr[35] = 217;
        sArr[36] = 74;
        sArr[37] = 77;
        sArr[38] = 158;
        sArr[39] = 218;
        sArr[40] = 160;
        sArr[41] = 104;
        sArr[42] = 44;
        sArr[43] = 195;
        sArr[44] = 39;
        sArr[45] = 95;
        sArr[46] = 128;
        sArr[47] = 54;
        sArr[48] = 62;
        sArr[49] = 238;
        sArr[50] = 251;
        sArr[51] = 149;
        sArr[52] = 26;
        sArr[53] = 254;
        sArr[54] = 206;
        sArr[55] = 168;
        sArr[56] = 52;
        sArr[57] = 169;
        sArr[58] = 19;
        sArr[59] = 240;
        sArr[60] = 166;
        sArr[61] = 63;
        sArr[62] = 216;
        sArr[63] = 12;
        sArr[64] = 120;
        sArr[65] = 36;
        sArr[66] = 175;
        sArr[67] = 35;
        sArr[68] = 82;
        sArr[69] = 193;
        sArr[70] = 103;
        sArr[71] = 23;
        sArr[72] = 245;
        sArr[73] = 102;
        sArr[74] = 144;
        sArr[75] = 231;
        sArr[76] = 232;
        sArr[77] = 7;
        sArr[78] = 184;
        sArr[79] = 96;
        sArr[80] = 72;
        sArr[81] = 230;
        sArr[82] = 30;
        sArr[83] = 83;
        sArr[84] = 243;
        sArr[85] = 146;
        sArr[86] = 164;
        sArr[87] = AlertDescription.bad_certificate_hash_value;
        sArr[88] = 140;
        sArr[89] = 8;
        sArr[90] = 21;
        sArr[91] = AlertDescription.unsupported_extension;
        sArr[92] = 134;
        sArr[94] = 132;
        sArr[95] = 250;
        sArr[96] = 244;
        sArr[97] = 127;
        sArr[98] = 138;
        sArr[99] = 66;
        sArr[100] = 25;
        sArr[101] = 246;
        sArr[102] = 219;
        sArr[103] = 205;
        sArr[104] = 20;
        sArr[105] = 141;
        sArr[106] = 80;
        sArr[107] = 18;
        sArr[108] = 186;
        sArr[109] = 60;
        sArr[110] = 6;
        sArr[111] = 78;
        sArr[112] = 236;
        sArr[113] = 179;
        sArr[114] = 53;
        sArr[115] = 17;
        sArr[116] = 161;
        sArr[117] = 136;
        sArr[118] = 142;
        sArr[119] = 43;
        sArr[120] = 148;
        sArr[121] = 153;
        sArr[122] = 183;
        sArr[123] = AlertDescription.bad_certificate_status_response;
        sArr[124] = 116;
        sArr[125] = 211;
        sArr[126] = 228;
        sArr[127] = 191;
        sArr[128] = 58;
        sArr[129] = 222;
        sArr[130] = 150;
        sArr[131] = 14;
        sArr[132] = 188;
        sArr[133] = 10;
        sArr[134] = 237;
        sArr[135] = 119;
        sArr[136] = 252;
        sArr[137] = 55;
        sArr[138] = 107;
        sArr[139] = 3;
        sArr[140] = 121;
        sArr[141] = 137;
        sArr[142] = 98;
        sArr[143] = 198;
        sArr[144] = 215;
        sArr[145] = 192;
        sArr[146] = 210;
        sArr[147] = 124;
        sArr[148] = 106;
        sArr[149] = 139;
        sArr[150] = 34;
        sArr[151] = 163;
        sArr[152] = 91;
        sArr[153] = 5;
        sArr[154] = 93;
        sArr[155] = 2;
        sArr[156] = 117;
        sArr[157] = 213;
        sArr[158] = 97;
        sArr[159] = 227;
        sArr[160] = 24;
        sArr[161] = 143;
        sArr[162] = 85;
        sArr[163] = 81;
        sArr[164] = 173;
        sArr[165] = 31;
        sArr[166] = 11;
        sArr[167] = 94;
        sArr[168] = 133;
        sArr[169] = 229;
        sArr[170] = 194;
        sArr[171] = 87;
        sArr[172] = 99;
        sArr[173] = 202;
        sArr[174] = 61;
        sArr[175] = 108;
        sArr[176] = 180;
        sArr[177] = 197;
        sArr[178] = 204;
        sArr[179] = AlertDescription.unrecognized_name;
        sArr[180] = 178;
        sArr[181] = 145;
        sArr[182] = 89;
        sArr[183] = 13;
        sArr[184] = 71;
        sArr[185] = 32;
        sArr[186] = 200;
        sArr[187] = 79;
        sArr[188] = 88;
        sArr[189] = 224;
        sArr[190] = 1;
        sArr[191] = 226;
        sArr[192] = 22;
        sArr[193] = 56;
        sArr[194] = 196;
        sArr[195] = AlertDescription.certificate_unobtainable;
        sArr[196] = 59;
        sArr[197] = 15;
        sArr[198] = 101;
        sArr[199] = 70;
        sArr[200] = 190;
        sArr[201] = 126;
        sArr[202] = 45;
        sArr[203] = 123;
        sArr[204] = 130;
        sArr[205] = 249;
        sArr[206] = 64;
        sArr[207] = 181;
        sArr[208] = 29;
        sArr[209] = AlertDescription.unknown_psk_identity;
        sArr[210] = 248;
        sArr[211] = 235;
        sArr[212] = 38;
        sArr[213] = 199;
        sArr[214] = 135;
        sArr[215] = 151;
        sArr[216] = 37;
        sArr[217] = 84;
        sArr[218] = 177;
        sArr[219] = 40;
        sArr[220] = 170;
        sArr[221] = 152;
        sArr[222] = 157;
        sArr[223] = 165;
        sArr[224] = 100;
        sArr[225] = 109;
        sArr[226] = 122;
        sArr[227] = 212;
        sArr[228] = 16;
        sArr[229] = 129;
        sArr[230] = 68;
        sArr[231] = 239;
        sArr[232] = 73;
        sArr[233] = 214;
        sArr[234] = 174;
        sArr[235] = 46;
        sArr[236] = 221;
        sArr[237] = 118;
        sArr[238] = 92;
        sArr[239] = 47;
        sArr[240] = 167;
        sArr[241] = 28;
        sArr[242] = 201;
        sArr[243] = 9;
        sArr[244] = 105;
        sArr[245] = 154;
        sArr[246] = 131;
        sArr[247] = 207;
        sArr[248] = 41;
        sArr[249] = 57;
        sArr[250] = 185;
        sArr[251] = 233;
        sArr[252] = 76;
        sArr[253] = 255;
        sArr[254] = 67;
        sArr[255] = 171;
        rc2Table = sArr;
        short[] sArr2 = new short[256];
        sArr2[0] = 93;
        sArr2[1] = 190;
        sArr2[2] = 155;
        sArr2[3] = 139;
        sArr2[4] = 17;
        sArr2[5] = 153;
        sArr2[6] = AlertDescription.unsupported_extension;
        sArr2[7] = 77;
        sArr2[8] = 89;
        sArr2[9] = 243;
        sArr2[10] = 133;
        sArr2[11] = 166;
        sArr2[12] = 63;
        sArr2[13] = 183;
        sArr2[14] = 131;
        sArr2[15] = 197;
        sArr2[16] = 228;
        sArr2[17] = AlertDescription.unknown_psk_identity;
        sArr2[18] = 107;
        sArr2[19] = 58;
        sArr2[20] = 104;
        sArr2[21] = 90;
        sArr2[22] = 192;
        sArr2[23] = 71;
        sArr2[24] = 160;
        sArr2[25] = 100;
        sArr2[26] = 52;
        sArr2[27] = 12;
        sArr2[28] = 241;
        sArr2[29] = 208;
        sArr2[30] = 82;
        sArr2[31] = 165;
        sArr2[32] = 185;
        sArr2[33] = 30;
        sArr2[34] = 150;
        sArr2[35] = 67;
        sArr2[36] = 65;
        sArr2[37] = 216;
        sArr2[38] = 212;
        sArr2[39] = 44;
        sArr2[40] = 219;
        sArr2[41] = 248;
        sArr2[42] = 7;
        sArr2[43] = 119;
        sArr2[44] = 42;
        sArr2[45] = 202;
        sArr2[46] = 235;
        sArr2[47] = 239;
        sArr2[48] = 16;
        sArr2[49] = 28;
        sArr2[50] = 22;
        sArr2[51] = 13;
        sArr2[52] = 56;
        sArr2[53] = AlertDescription.bad_certificate_hash_value;
        sArr2[54] = 47;
        sArr2[55] = 137;
        sArr2[56] = 193;
        sArr2[57] = 249;
        sArr2[58] = 128;
        sArr2[59] = 196;
        sArr2[60] = 109;
        sArr2[61] = 174;
        sArr2[62] = 48;
        sArr2[63] = 61;
        sArr2[64] = 206;
        sArr2[65] = 32;
        sArr2[66] = 99;
        sArr2[67] = 254;
        sArr2[68] = 230;
        sArr2[69] = 26;
        sArr2[70] = 199;
        sArr2[71] = 184;
        sArr2[72] = 80;
        sArr2[73] = 232;
        sArr2[74] = 36;
        sArr2[75] = 23;
        sArr2[76] = 252;
        sArr2[77] = 37;
        sArr2[78] = AlertDescription.certificate_unobtainable;
        sArr2[79] = 187;
        sArr2[80] = 106;
        sArr2[81] = 163;
        sArr2[82] = 68;
        sArr2[83] = 83;
        sArr2[84] = 217;
        sArr2[85] = 162;
        sArr2[86] = 1;
        sArr2[87] = 171;
        sArr2[88] = 188;
        sArr2[89] = 182;
        sArr2[90] = 31;
        sArr2[91] = 152;
        sArr2[92] = 238;
        sArr2[93] = 154;
        sArr2[94] = 167;
        sArr2[95] = 45;
        sArr2[96] = 79;
        sArr2[97] = 158;
        sArr2[98] = 142;
        sArr2[99] = 172;
        sArr2[100] = 224;
        sArr2[101] = 198;
        sArr2[102] = 73;
        sArr2[103] = 70;
        sArr2[104] = 41;
        sArr2[105] = 244;
        sArr2[106] = 148;
        sArr2[107] = 138;
        sArr2[108] = 175;
        sArr2[109] = 225;
        sArr2[110] = 91;
        sArr2[111] = 195;
        sArr2[112] = 179;
        sArr2[113] = 123;
        sArr2[114] = 87;
        sArr2[115] = 209;
        sArr2[116] = 124;
        sArr2[117] = 156;
        sArr2[118] = 237;
        sArr2[119] = 135;
        sArr2[120] = 64;
        sArr2[121] = 140;
        sArr2[122] = 226;
        sArr2[123] = 203;
        sArr2[124] = 147;
        sArr2[125] = 20;
        sArr2[126] = 201;
        sArr2[127] = 97;
        sArr2[128] = 46;
        sArr2[129] = 229;
        sArr2[130] = 204;
        sArr2[131] = 246;
        sArr2[132] = 94;
        sArr2[133] = 168;
        sArr2[134] = 92;
        sArr2[135] = 214;
        sArr2[136] = 117;
        sArr2[137] = 141;
        sArr2[138] = 98;
        sArr2[139] = 149;
        sArr2[140] = 88;
        sArr2[141] = 105;
        sArr2[142] = 118;
        sArr2[143] = 161;
        sArr2[144] = 74;
        sArr2[145] = 181;
        sArr2[146] = 85;
        sArr2[147] = 9;
        sArr2[148] = 120;
        sArr2[149] = 51;
        sArr2[150] = 130;
        sArr2[151] = 215;
        sArr2[152] = 221;
        sArr2[153] = 121;
        sArr2[154] = 245;
        sArr2[155] = 27;
        sArr2[156] = 11;
        sArr2[157] = 222;
        sArr2[158] = 38;
        sArr2[159] = 33;
        sArr2[160] = 40;
        sArr2[161] = 116;
        sArr2[162] = 4;
        sArr2[163] = 151;
        sArr2[164] = 86;
        sArr2[165] = 223;
        sArr2[166] = 60;
        sArr2[167] = 240;
        sArr2[168] = 55;
        sArr2[169] = 57;
        sArr2[170] = 220;
        sArr2[171] = 255;
        sArr2[172] = 6;
        sArr2[173] = 164;
        sArr2[174] = 234;
        sArr2[175] = 66;
        sArr2[176] = 8;
        sArr2[177] = 218;
        sArr2[178] = 180;
        sArr2[179] = AlertDescription.bad_certificate_status_response;
        sArr2[180] = 176;
        sArr2[181] = 207;
        sArr2[182] = 18;
        sArr2[183] = 122;
        sArr2[184] = 78;
        sArr2[185] = 250;
        sArr2[186] = 108;
        sArr2[187] = 29;
        sArr2[188] = 132;
        sArr2[190] = 200;
        sArr2[191] = 127;
        sArr2[192] = 145;
        sArr2[193] = 69;
        sArr2[194] = 170;
        sArr2[195] = 43;
        sArr2[196] = 194;
        sArr2[197] = 177;
        sArr2[198] = 143;
        sArr2[199] = 213;
        sArr2[200] = 186;
        sArr2[201] = 242;
        sArr2[202] = 173;
        sArr2[203] = 25;
        sArr2[204] = 178;
        sArr2[205] = 103;
        sArr2[206] = 54;
        sArr2[207] = 247;
        sArr2[208] = 15;
        sArr2[209] = 10;
        sArr2[210] = 146;
        sArr2[211] = 125;
        sArr2[212] = 227;
        sArr2[213] = 157;
        sArr2[214] = 233;
        sArr2[215] = 144;
        sArr2[216] = 62;
        sArr2[217] = 35;
        sArr2[218] = 39;
        sArr2[219] = 102;
        sArr2[220] = 19;
        sArr2[221] = 236;
        sArr2[222] = 129;
        sArr2[223] = 21;
        sArr2[224] = 189;
        sArr2[225] = 34;
        sArr2[226] = 191;
        sArr2[227] = 159;
        sArr2[228] = 126;
        sArr2[229] = 169;
        sArr2[230] = 81;
        sArr2[231] = 75;
        sArr2[232] = 76;
        sArr2[233] = 251;
        sArr2[234] = 2;
        sArr2[235] = 211;
        sArr2[236] = AlertDescription.unrecognized_name;
        sArr2[237] = 134;
        sArr2[238] = 49;
        sArr2[239] = 231;
        sArr2[240] = 59;
        sArr2[241] = 5;
        sArr2[242] = 3;
        sArr2[243] = 84;
        sArr2[244] = 96;
        sArr2[245] = 72;
        sArr2[246] = 101;
        sArr2[247] = 24;
        sArr2[248] = 210;
        sArr2[249] = 205;
        sArr2[250] = 95;
        sArr2[251] = 50;
        sArr2[252] = 136;
        sArr2[253] = 14;
        sArr2[254] = 53;
        sArr2[255] = 253;
        rc2Ekb = sArr2;
    }

    EnvelopedDataHelper(JcaJceHelper jcaJceHelper) {
        this.helper = jcaJceHelper;
    }

    /* access modifiers changed from: package-private */
    public String getBaseCipherName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        return str == null ? aSN1ObjectIdentifier.getId() : str;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.Cipher createCipher(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4) throws repack.org.bouncycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = CIPHER_ALG_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.Cipher r4 = r1.createCipher(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.Cipher r4 = r0.createCipher(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.cms.CMSException r0 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create cipher: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.jcajce.EnvelopedDataHelper.createCipher(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier):javax.crypto.Cipher");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.Mac createMac(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4) throws repack.org.bouncycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = MAC_ALG_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.Mac r4 = r1.createMac(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.Mac r4 = r0.createMac(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.cms.CMSException r0 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create mac: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.jcajce.EnvelopedDataHelper.createMac(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier):javax.crypto.Mac");
    }

    /* access modifiers changed from: package-private */
    public Cipher createRFC3211Wrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.helper.createCipher(String.valueOf(str) + "RFC3211Wrap");
            } catch (GeneralSecurityException e) {
                throw new CMSException("cannot create cipher: " + e.getMessage(), e);
            }
        } else {
            throw new CMSException("no name for " + aSN1ObjectIdentifier);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.KeyAgreement createKeyAgreement(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4) throws repack.org.bouncycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.KeyAgreement r4 = r1.createKeyAgreement(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.KeyAgreement r4 = r0.createKeyAgreement(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.cms.CMSException r0 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create key pair generator: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.jcajce.EnvelopedDataHelper.createKeyAgreement(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier):javax.crypto.KeyAgreement");
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws GeneralSecurityException {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.helper.createAlgorithmParameterGenerator(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.helper.createAlgorithmParameterGenerator(aSN1ObjectIdentifier.getId());
    }

    /* access modifiers changed from: package-private */
    public Cipher createContentCipher(final Key key, final AlgorithmIdentifier algorithmIdentifier) throws CMSException {
        return (Cipher) execute(new JCECallback() {
            public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
                Cipher createCipher = EnvelopedDataHelper.this.createCipher(algorithmIdentifier.getAlgorithm());
                ASN1Object aSN1Object = (ASN1Object) algorithmIdentifier.getParameters().getDERObject();
                String id = algorithmIdentifier.getAlgorithm().getId();
                if (aSN1Object != null && !(aSN1Object instanceof ASN1Null)) {
                    try {
                        AlgorithmParameters createAlgorithmParameters = EnvelopedDataHelper.this.createAlgorithmParameters(algorithmIdentifier.getAlgorithm());
                        createAlgorithmParameters.init(aSN1Object.getEncoded(), "ASN.1");
                        createCipher.init(2, key, createAlgorithmParameters);
                    } catch (IOException e) {
                        throw new CMSException("error decoding algorithm parameters.", e);
                    } catch (NoSuchAlgorithmException e2) {
                        if (id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals(CMSEnvelopedGenerator.IDEA_CBC) || id.equals(CMSEnvelopedDataGenerator.AES128_CBC) || id.equals(CMSEnvelopedDataGenerator.AES192_CBC) || id.equals(CMSEnvelopedDataGenerator.AES256_CBC)) {
                            createCipher.init(2, key, new IvParameterSpec(ASN1OctetString.getInstance(aSN1Object).getOctets()));
                        } else {
                            throw e2;
                        }
                    }
                } else if (id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals(CMSEnvelopedGenerator.IDEA_CBC) || id.equals(CMSEnvelopedGenerator.CAST5_CBC)) {
                    createCipher.init(2, key, new IvParameterSpec(new byte[8]));
                } else {
                    createCipher.init(2, key);
                }
                return createCipher;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Mac createContentMac(final Key key, final AlgorithmIdentifier algorithmIdentifier) throws CMSException {
        return (Mac) execute(new JCECallback() {
            public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
                Mac createMac = EnvelopedDataHelper.this.createMac(algorithmIdentifier.getAlgorithm());
                ASN1Object aSN1Object = (ASN1Object) algorithmIdentifier.getParameters().getDERObject();
                algorithmIdentifier.getAlgorithm().getId();
                if (aSN1Object == null || (aSN1Object instanceof ASN1Null)) {
                    createMac.init(key);
                } else {
                    try {
                        AlgorithmParameters createAlgorithmParameters = EnvelopedDataHelper.this.createAlgorithmParameters(algorithmIdentifier.getAlgorithm());
                        createAlgorithmParameters.init(aSN1Object.getEncoded(), "ASN.1");
                        createMac.init(key, createAlgorithmParameters.getParameterSpec(IvParameterSpec.class));
                    } catch (IOException e) {
                        throw new CMSException("error decoding algorithm parameters.", e);
                    } catch (NoSuchAlgorithmException e2) {
                        throw e2;
                    }
                }
                return createMac;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters createAlgorithmParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws NoSuchAlgorithmException, NoSuchProviderException {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.helper.createAlgorithmParameters(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.helper.createAlgorithmParameters(aSN1ObjectIdentifier.getId());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.KeyPairGenerator createKeyPairGenerator(repack.org.bouncycastle.asn1.DERObjectIdentifier r4) throws repack.org.bouncycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            java.security.KeyPairGenerator r4 = r1.createKeyPairGenerator(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            java.security.KeyPairGenerator r4 = r0.createKeyPairGenerator(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.cms.CMSException r0 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create key pair generator: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.jcajce.EnvelopedDataHelper.createKeyPairGenerator(repack.org.bouncycastle.asn1.DERObjectIdentifier):java.security.KeyPairGenerator");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.KeyGenerator createKeyGenerator(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4) throws repack.org.bouncycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.KeyGenerator r4 = r1.createKeyGenerator(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.KeyGenerator r4 = r0.createKeyGenerator(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.cms.CMSException r0 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create key generator: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.jcajce.EnvelopedDataHelper.createKeyGenerator(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier):javax.crypto.KeyGenerator");
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters generateParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey, SecureRandom secureRandom) throws CMSException {
        try {
            AlgorithmParameterGenerator createAlgorithmParameterGenerator = createAlgorithmParameterGenerator(aSN1ObjectIdentifier);
            if (aSN1ObjectIdentifier.equals(CMSEnvelopedDataGenerator.RC2_CBC)) {
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                createAlgorithmParameterGenerator.init(new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr), secureRandom);
            }
            return createAlgorithmParameterGenerator.generateParameters();
        } catch (InvalidAlgorithmParameterException e) {
            throw new CMSException("parameters generation error: " + e, e);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (GeneralSecurityException e2) {
            throw new CMSException("exception creating algorithm parameter generator: " + e2, e2);
        }
    }

    /* access modifiers changed from: package-private */
    public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameters algorithmParameters) throws CMSException {
        DEREncodable dEREncodable;
        if (algorithmParameters != null) {
            try {
                dEREncodable = ASN1Object.fromByteArray(algorithmParameters.getEncoded("ASN.1"));
            } catch (IOException e) {
                throw new CMSException("cannot encode parameters: " + e.getMessage(), e);
            }
        } else {
            dEREncodable = DERNull.INSTANCE;
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier, dEREncodable);
    }

    static Object execute(JCECallback jCECallback) throws CMSException {
        try {
            return jCECallback.doInJCE();
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find algorithm.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (NoSuchProviderException e3) {
            throw new CMSException("can't find provider.", e3);
        } catch (NoSuchPaddingException e4) {
            throw new CMSException("required padding not supported.", e4);
        } catch (InvalidAlgorithmParameterException e5) {
            throw new CMSException("algorithm parameters invalid.", e5);
        } catch (InvalidParameterSpecException e6) {
            throw new CMSException("MAC algorithm parameter spec invalid.", e6);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.KeyFactory createKeyFactory(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4) throws repack.org.bouncycastle.cms.CMSException {
        /*
            r3 = this;
            java.util.Map r0 = BASE_CIPHER_NAMES     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            java.security.KeyFactory r4 = r1.createKeyFactory(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            java.security.KeyFactory r4 = r0.createKeyFactory(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.cms.CMSException r0 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create key factory: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.jcajce.EnvelopedDataHelper.createKeyFactory(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier):java.security.KeyFactory");
    }

    public AsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return this.helper.createAsymmetricUnwrapper(algorithmIdentifier, privateKey);
    }

    public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        return this.helper.createSymmetricUnwrapper(algorithmIdentifier, secretKey);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: short} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier getAlgorithmIdentifier(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4, java.security.spec.AlgorithmParameterSpec r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof javax.crypto.spec.IvParameterSpec
            if (r0 == 0) goto L_0x0015
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = new repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier
            repack.org.bouncycastle.asn1.DEROctetString r1 = new repack.org.bouncycastle.asn1.DEROctetString
            javax.crypto.spec.IvParameterSpec r5 = (javax.crypto.spec.IvParameterSpec) r5
            byte[] r5 = r5.getIV()
            r1.<init>((byte[]) r5)
            r0.<init>(r4, r1)
            return r0
        L_0x0015:
            boolean r0 = r5 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r0 == 0) goto L_0x0048
            javax.crypto.spec.RC2ParameterSpec r5 = (javax.crypto.spec.RC2ParameterSpec) r5
            int r0 = r5.getEffectiveKeyBits()
            r1 = -1
            if (r0 == r1) goto L_0x0039
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L_0x002a
            short[] r1 = rc2Table
            short r0 = r1[r0]
        L_0x002a:
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = new repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier
            repack.org.bouncycastle.asn1.pkcs.RC2CBCParameter r2 = new repack.org.bouncycastle.asn1.pkcs.RC2CBCParameter
            byte[] r5 = r5.getIV()
            r2.<init>(r0, r5)
            r1.<init>(r4, r2)
            return r1
        L_0x0039:
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = new repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier
            repack.org.bouncycastle.asn1.pkcs.RC2CBCParameter r1 = new repack.org.bouncycastle.asn1.pkcs.RC2CBCParameter
            byte[] r5 = r5.getIV()
            r1.<init>((byte[]) r5)
            r0.<init>(r4, r1)
            return r0
        L_0x0048:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "unknown parameter spec"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.jcajce.EnvelopedDataHelper.getAlgorithmIdentifier(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier, java.security.spec.AlgorithmParameterSpec):repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier");
    }
}
