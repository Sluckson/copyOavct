package repack.org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PSSParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DEROutputStream;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import repack.org.bouncycastle.asn1.misc.CAST5CBCParameters;
import repack.org.bouncycastle.asn1.oiw.ElGamalParameter;
import repack.org.bouncycastle.asn1.pkcs.DHParameter;
import repack.org.bouncycastle.asn1.pkcs.PBKDF2Params;
import repack.org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import repack.org.bouncycastle.asn1.pkcs.RC2CBCParameter;
import repack.org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import repack.org.bouncycastle.asn1.x509.DSAParameter;
import repack.org.bouncycastle.crypto.tls.AlertDescription;
import repack.org.bouncycastle.jce.spec.ElGamalParameterSpec;
import repack.org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import repack.org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import repack.org.bouncycastle.jce.spec.IESParameterSpec;

public abstract class JDKAlgorithmParameters extends AlgorithmParametersSpi {
    /* access modifiers changed from: protected */
    public abstract AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException;

    /* access modifiers changed from: protected */
    public boolean isASN1FormatString(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls != null) {
            return localEngineGetParameterSpec(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    public static class IVAlgorithmParameters extends JDKAlgorithmParameters {

        /* renamed from: iv */
        private byte[] f6235iv;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "IV Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return new DEROctetString(engineGetEncoded("RAW")).getEncoded();
            }
            if (!str.equals("RAW")) {
                return null;
            }
            byte[] bArr = this.f6235iv;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f6235iv);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6235iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            if (bArr.length % 8 != 0 && bArr[0] == 4 && bArr[1] == bArr.length - 2) {
                bArr = ((ASN1OctetString) new ASN1InputStream(bArr).readObject()).getOctets();
            }
            this.f6235iv = new byte[bArr.length];
            byte[] bArr2 = this.f6235iv;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                try {
                    engineInit(((ASN1OctetString) new ASN1InputStream(bArr).readObject()).getOctets());
                } catch (Exception e) {
                    throw new IOException("Exception decoding: " + e);
                }
            } else if (str.equals("RAW")) {
                engineInit(bArr);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class RC2AlgorithmParameters extends JDKAlgorithmParameters {
        private short[] ekb;

        /* renamed from: iv */
        private byte[] f6236iv;
        private int parameterVersion = 58;
        private short[] table;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "RC2 Parameters";
        }

        public RC2AlgorithmParameters() {
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
            this.table = sArr;
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
            this.ekb = sArr2;
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            byte[] bArr = this.f6236iv;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                int i = this.parameterVersion;
                if (i == -1) {
                    return new RC2CBCParameter(engineGetEncoded()).getEncoded();
                }
                return new RC2CBCParameter(i, engineGetEncoded()).getEncoded();
            } else if (str.equals("RAW")) {
                return engineGetEncoded();
            } else {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            int i;
            if (cls != RC2ParameterSpec.class || (i = this.parameterVersion) == -1) {
                if (cls == IvParameterSpec.class) {
                    return new IvParameterSpec(this.f6236iv);
                }
                throw new InvalidParameterSpecException("unknown parameter spec passed to RC2 parameters object.");
            } else if (i < 256) {
                return new RC2ParameterSpec(this.ekb[i], this.f6236iv);
            } else {
                return new RC2ParameterSpec(i, this.f6236iv);
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6236iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                int effectiveKeyBits = rC2ParameterSpec.getEffectiveKeyBits();
                if (effectiveKeyBits != -1) {
                    if (effectiveKeyBits < 256) {
                        this.parameterVersion = this.table[effectiveKeyBits];
                    } else {
                        this.parameterVersion = effectiveKeyBits;
                    }
                }
                this.f6236iv = rC2ParameterSpec.getIV();
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec or RC2ParameterSpec required to initialise a RC2 parameters algorithm parameters object");
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            this.f6236iv = new byte[bArr.length];
            byte[] bArr2 = this.f6236iv;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                RC2CBCParameter instance = RC2CBCParameter.getInstance(new ASN1InputStream(bArr).readObject());
                if (instance.getRC2ParameterVersion() != null) {
                    this.parameterVersion = instance.getRC2ParameterVersion().intValue();
                }
                this.f6236iv = instance.getIV();
            } else if (str.equals("RAW")) {
                engineInit(bArr);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class CAST5AlgorithmParameters extends JDKAlgorithmParameters {

        /* renamed from: iv */
        private byte[] f6234iv;
        private int keyLength = 128;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "CAST5 Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            byte[] bArr = this.f6234iv;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return new CAST5CBCParameters(engineGetEncoded(), this.keyLength).getEncoded();
            }
            if (str.equals("RAW")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f6234iv);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to CAST5 parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6234iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a CAST5 parameters algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            this.f6234iv = new byte[bArr.length];
            byte[] bArr2 = this.f6234iv;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                CAST5CBCParameters instance = CAST5CBCParameters.getInstance(new ASN1InputStream(bArr).readObject());
                this.keyLength = instance.getKeyLength();
                this.f6234iv = instance.getIV();
            } else if (str.equals("RAW")) {
                engineInit(bArr);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class PKCS12PBE extends JDKAlgorithmParameters {
        PKCS12PBEParams params;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "PKCS12 PBE Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                new DEROutputStream(byteArrayOutputStream).writeObject(this.params);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Oooops! " + e.toString());
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.params.getIV(), this.params.getIterations().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PKCS12 PBE parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.params = new PKCS12PBEParams(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PKCS12 PBE parameters algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            this.params = PKCS12PBEParams.getInstance(new ASN1InputStream(bArr).readObject());
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PKCS12 PBE parameters object");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters$DH */
    public static class C5021DH extends JDKAlgorithmParameters {
        DHParameterSpec currentSpec;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "Diffie-Hellman Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            try {
                dEROutputStream.writeObject(new DHParameter(this.currentSpec.getP(), this.currentSpec.getG(), this.currentSpec.getL()));
                dEROutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding DHParameters");
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == DHParameterSpec.class) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof DHParameterSpec) {
                this.currentSpec = (DHParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                DHParameter dHParameter = new DHParameter((ASN1Sequence) new ASN1InputStream(bArr).readObject());
                if (dHParameter.getL() != null) {
                    this.currentSpec = new DHParameterSpec(dHParameter.getP(), dHParameter.getG(), dHParameter.getL().intValue());
                } else {
                    this.currentSpec = new DHParameterSpec(dHParameter.getP(), dHParameter.getG());
                }
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid DH Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid DH Parameter encoding.");
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }
    }

    public static class DSA extends JDKAlgorithmParameters {
        DSAParameterSpec currentSpec;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "DSA Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            try {
                dEROutputStream.writeObject(new DSAParameter(this.currentSpec.getP(), this.currentSpec.getQ(), this.currentSpec.getG()));
                dEROutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding DSAParameters");
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == DSAParameterSpec.class) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to DSA parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof DSAParameterSpec) {
                this.currentSpec = (DSAParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("DSAParameterSpec required to initialise a DSA algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                DSAParameter dSAParameter = new DSAParameter((ASN1Sequence) new ASN1InputStream(bArr).readObject());
                this.currentSpec = new DSAParameterSpec(dSAParameter.getP(), dSAParameter.getQ(), dSAParameter.getG());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid DSA Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid DSA Parameter encoding.");
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }
    }

    public static class GOST3410 extends JDKAlgorithmParameters {
        GOST3410ParameterSpec currentSpec;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "GOST3410 Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            try {
                dEROutputStream.writeObject(new GOST3410PublicKeyAlgParameters(new DERObjectIdentifier(this.currentSpec.getPublicKeyParamSetOID()), new DERObjectIdentifier(this.currentSpec.getDigestParamSetOID()), new DERObjectIdentifier(this.currentSpec.getEncryptionParamSetOID())));
                dEROutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding GOST3410Parameters");
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == GOST3410PublicKeyParameterSetSpec.class) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to GOST3410 parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof GOST3410ParameterSpec) {
                this.currentSpec = (GOST3410ParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("GOST3410ParameterSpec required to initialise a GOST3410 algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence) new ASN1InputStream(bArr).readObject());
                this.currentSpec = new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().getId(), gOST3410PublicKeyAlgParameters.getDigestParamSet().getId(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet().getId());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid GOST3410 Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid GOST3410 Parameter encoding.");
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }
    }

    public static class ElGamal extends JDKAlgorithmParameters {
        ElGamalParameterSpec currentSpec;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "ElGamal Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            try {
                dEROutputStream.writeObject(new ElGamalParameter(this.currentSpec.getP(), this.currentSpec.getG()));
                dEROutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding ElGamalParameters");
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == ElGamalParameterSpec.class) {
                return this.currentSpec;
            }
            if (cls == DHParameterSpec.class) {
                return new DHParameterSpec(this.currentSpec.getP(), this.currentSpec.getG());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
            if (!z && !(algorithmParameterSpec instanceof DHParameterSpec)) {
                throw new InvalidParameterSpecException("DHParameterSpec required to initialise a ElGamal algorithm parameters object");
            } else if (z) {
                this.currentSpec = (ElGamalParameterSpec) algorithmParameterSpec;
            } else {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.currentSpec = new ElGamalParameterSpec(dHParameterSpec.getP(), dHParameterSpec.getG());
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence) new ASN1InputStream(bArr).readObject());
                this.currentSpec = new ElGamalParameterSpec(elGamalParameter.getP(), elGamalParameter.getG());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid ElGamal Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid ElGamal Parameter encoding.");
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }
    }

    public static class IES extends JDKAlgorithmParameters {
        IESParameterSpec currentSpec;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "IES Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            try {
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.add(new DEROctetString(this.currentSpec.getDerivationV()));
                aSN1EncodableVector.add(new DEROctetString(this.currentSpec.getEncodingV()));
                aSN1EncodableVector.add(new DERInteger(this.currentSpec.getMacKeySize()));
                dEROutputStream.writeObject(new DERSequence(aSN1EncodableVector));
                dEROutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding IESParameters");
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IESParameterSpec.class) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IESParameterSpec) {
                this.currentSpec = (IESParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(bArr).readObject();
                this.currentSpec = new IESParameterSpec(((ASN1OctetString) aSN1Sequence.getObjectAt(0)).getOctets(), ((ASN1OctetString) aSN1Sequence.getObjectAt(0)).getOctets(), ((DERInteger) aSN1Sequence.getObjectAt(0)).getValue().intValue());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid IES Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid IES Parameter encoding.");
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }
    }

    public static class PSS extends JDKAlgorithmParameters {
        PSSParameterSpec currentSpec;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "PSS Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            try {
                dEROutputStream.writeObject(new RSASSAPSSparams(RSASSAPSSparams.DEFAULT_HASH_ALGORITHM, RSASSAPSSparams.DEFAULT_MASK_GEN_FUNCTION, new DERInteger(this.currentSpec.getSaltLength()), RSASSAPSSparams.DEFAULT_TRAILER_FIELD));
                dEROutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding PSSParameters");
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == PSSParameterSpec.class) {
                PSSParameterSpec pSSParameterSpec = this.currentSpec;
                if (pSSParameterSpec instanceof PSSParameterSpec) {
                    return pSSParameterSpec;
                }
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PSSParameterSpec) {
                this.currentSpec = (PSSParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                this.currentSpec = new PSSParameterSpec(new RSASSAPSSparams((ASN1Sequence) new ASN1InputStream(bArr).readObject()).getSaltLength().getValue().intValue());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }
    }

    public static class PBKDF2 extends JDKAlgorithmParameters {
        PBKDF2Params params;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "PBKDF2 Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            try {
                return this.params.getEncoded(ASN1Encodable.DER);
            } catch (IOException e) {
                throw new RuntimeException("Oooops! " + e.toString());
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.params.getSalt(), this.params.getIterationCount().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PKCS12 PBE parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.params = new PBKDF2Params(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PKCS12 PBE parameters algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            this.params = PBKDF2Params.getInstance(ASN1Object.fromByteArray(bArr));
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PWRIKEK parameters object");
        }
    }
}
