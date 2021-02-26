package com.lowagie.text.xml.simpleparser;

import androidx.exifinterface.media.ExifInterface;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.pdf.Barcode128;
import java.util.HashMap;
import kotlin.text.Typography;

public class EntitiesToUnicode {
    public static final HashMap map = new HashMap();

    static {
        map.put("nbsp", new Character(Typography.nbsp));
        map.put("iexcl", new Character(161));
        map.put("cent", new Character(Typography.cent));
        map.put("pound", new Character(Typography.pound));
        map.put("curren", new Character(164));
        map.put("yen", new Character(165));
        map.put("brvbar", new Character(166));
        map.put("sect", new Character(Typography.section));
        map.put("uml", new Character(168));
        map.put("copy", new Character(Typography.copyright));
        map.put("ordf", new Character(170));
        map.put("laquo", new Character(Typography.leftGuillemete));
        map.put("not", new Character(172));
        map.put("shy", new Character(173));
        map.put("reg", new Character(Typography.registered));
        map.put("macr", new Character(175));
        map.put("deg", new Character(Typography.degree));
        map.put("plusmn", new Character(Typography.plusMinus));
        map.put("sup2", new Character(178));
        map.put("sup3", new Character(179));
        map.put("acute", new Character(180));
        map.put("micro", new Character(181));
        map.put("para", new Character(Typography.paragraph));
        map.put("middot", new Character(Typography.middleDot));
        map.put("cedil", new Character(184));
        map.put("sup1", new Character(185));
        map.put("ordm", new Character(186));
        map.put("raquo", new Character(Typography.rightGuillemete));
        map.put("frac14", new Character(188));
        map.put("frac12", new Character(Typography.half));
        map.put("frac34", new Character(190));
        map.put("iquest", new Character(191));
        map.put("Agrave", new Character(192));
        map.put("Aacute", new Character(193));
        map.put("Acirc", new Character(194));
        map.put("Atilde", new Character(Barcode128.DEL));
        map.put("Auml", new Character(Barcode128.FNC3));
        map.put("Aring", new Character(Barcode128.FNC2));
        map.put("AElig", new Character(Barcode128.SHIFT));
        map.put("Ccedil", new Character(Barcode128.CODE_C));
        map.put("Egrave", new Character(200));
        map.put("Eacute", new Character(201));
        map.put("Ecirc", new Character(Barcode128.FNC1));
        map.put("Euml", new Character(Barcode128.STARTA));
        map.put("Igrave", new Character(Barcode128.STARTB));
        map.put("Iacute", new Character(Barcode128.STARTC));
        map.put("Icirc", new Character(206));
        map.put("Iuml", new Character(207));
        map.put("ETH", new Character(208));
        map.put("Ntilde", new Character(209));
        map.put("Ograve", new Character(210));
        map.put("Oacute", new Character(211));
        map.put("Ocirc", new Character(212));
        map.put("Otilde", new Character(213));
        map.put("Ouml", new Character(214));
        map.put("times", new Character(Typography.times));
        map.put("Oslash", new Character(216));
        map.put("Ugrave", new Character(217));
        map.put("Uacute", new Character(218));
        map.put("Ucirc", new Character(219));
        map.put("Uuml", new Character(220));
        map.put("Yacute", new Character(221));
        map.put("THORN", new Character(222));
        map.put("szlig", new Character(223));
        map.put("agrave", new Character(224));
        map.put("aacute", new Character(225));
        map.put("acirc", new Character(226));
        map.put("atilde", new Character(227));
        map.put("auml", new Character(228));
        map.put("aring", new Character(229));
        map.put("aelig", new Character(230));
        map.put("ccedil", new Character(231));
        map.put("egrave", new Character(232));
        map.put("eacute", new Character(233));
        map.put("ecirc", new Character(234));
        map.put("euml", new Character(235));
        map.put("igrave", new Character(236));
        map.put("iacute", new Character(237));
        map.put("icirc", new Character(238));
        map.put("iuml", new Character(239));
        map.put("eth", new Character(240));
        map.put("ntilde", new Character(241));
        map.put("ograve", new Character(242));
        map.put("oacute", new Character(243));
        map.put("ocirc", new Character(244));
        map.put("otilde", new Character(245));
        map.put("ouml", new Character(246));
        map.put("divide", new Character(247));
        map.put("oslash", new Character(248));
        map.put("ugrave", new Character(249));
        map.put("uacute", new Character(250));
        map.put("ucirc", new Character(251));
        map.put("uuml", new Character(252));
        map.put("yacute", new Character(253));
        map.put("thorn", new Character(254));
        map.put("yuml", new Character(255));
        map.put("fnof", new Character(402));
        map.put("Alpha", new Character(913));
        map.put("Beta", new Character(914));
        map.put(ExifInterface.TAG_GAMMA, new Character(915));
        map.put("Delta", new Character(916));
        map.put("Epsilon", new Character(917));
        map.put("Zeta", new Character(918));
        map.put("Eta", new Character(919));
        map.put("Theta", new Character(920));
        map.put("Iota", new Character(921));
        map.put("Kappa", new Character(922));
        map.put("Lambda", new Character(923));
        map.put("Mu", new Character(924));
        map.put("Nu", new Character(925));
        map.put("Xi", new Character(926));
        map.put("Omicron", new Character(927));
        map.put("Pi", new Character(928));
        map.put("Rho", new Character(929));
        map.put("Sigma", new Character(931));
        map.put("Tau", new Character(932));
        map.put("Upsilon", new Character(933));
        map.put("Phi", new Character(934));
        map.put("Chi", new Character(935));
        map.put("Psi", new Character(936));
        map.put("Omega", new Character(937));
        map.put("alpha", new Character(945));
        map.put("beta", new Character(946));
        map.put("gamma", new Character(947));
        map.put("delta", new Character(948));
        map.put("epsilon", new Character(949));
        map.put("zeta", new Character(950));
        map.put("eta", new Character(951));
        map.put("theta", new Character(952));
        map.put("iota", new Character(953));
        map.put("kappa", new Character(954));
        map.put("lambda", new Character(955));
        map.put("mu", new Character(956));
        map.put("nu", new Character(957));
        map.put("xi", new Character(958));
        map.put("omicron", new Character(959));
        map.put("pi", new Character(960));
        map.put("rho", new Character(961));
        map.put("sigmaf", new Character(962));
        map.put("sigma", new Character(963));
        map.put("tau", new Character(964));
        map.put("upsilon", new Character(965));
        map.put("phi", new Character(966));
        map.put("chi", new Character(967));
        map.put("psi", new Character(968));
        map.put("omega", new Character(969));
        map.put("thetasym", new Character(977));
        map.put("upsih", new Character(978));
        map.put("piv", new Character(982));
        map.put("bull", new Character(Typography.bullet));
        map.put("hellip", new Character(Typography.ellipsis));
        map.put("prime", new Character(Typography.prime));
        map.put("Prime", new Character(Typography.doublePrime));
        map.put("oline", new Character(8254));
        map.put("frasl", new Character(8260));
        map.put("weierp", new Character(8472));
        map.put("image", new Character(8465));
        map.put("real", new Character(8476));
        map.put("trade", new Character(Typography.f5414tm));
        map.put("alefsym", new Character(8501));
        map.put("larr", new Character(8592));
        map.put("uarr", new Character(8593));
        map.put("rarr", new Character(8594));
        map.put("darr", new Character(8595));
        map.put("harr", new Character(8596));
        map.put("crarr", new Character(8629));
        map.put("lArr", new Character(8656));
        map.put("uArr", new Character(8657));
        map.put("rArr", new Character(8658));
        map.put("dArr", new Character(8659));
        map.put("hArr", new Character(8660));
        map.put("forall", new Character(8704));
        map.put("part", new Character(8706));
        map.put("exist", new Character(8707));
        map.put("empty", new Character(8709));
        map.put("nabla", new Character(8711));
        map.put("isin", new Character(8712));
        map.put("notin", new Character(8713));
        map.put("ni", new Character(8715));
        map.put("prod", new Character(8719));
        map.put("sum", new Character(8721));
        map.put("minus", new Character(8722));
        map.put("lowast", new Character(8727));
        map.put("radic", new Character(8730));
        map.put("prop", new Character(8733));
        map.put("infin", new Character(8734));
        map.put("ang", new Character(8736));
        map.put("and", new Character(8743));
        map.put("or", new Character(8744));
        map.put("cap", new Character(8745));
        map.put("cup", new Character(8746));
        map.put("int", new Character(8747));
        map.put("there4", new Character(8756));
        map.put("sim", new Character(8764));
        map.put("cong", new Character(8773));
        map.put("asymp", new Character(Typography.almostEqual));
        map.put("ne", new Character(Typography.notEqual));
        map.put("equiv", new Character(8801));
        map.put("le", new Character(Typography.lessOrEqual));
        map.put("ge", new Character(Typography.greaterOrEqual));
        map.put(HtmlTags.SUB, new Character(8834));
        map.put(HtmlTags.SUP, new Character(8835));
        map.put("nsub", new Character(8836));
        map.put("sube", new Character(8838));
        map.put("supe", new Character(8839));
        map.put("oplus", new Character(8853));
        map.put("otimes", new Character(8855));
        map.put("perp", new Character(8869));
        map.put("sdot", new Character(8901));
        map.put("lceil", new Character(8968));
        map.put("rceil", new Character(8969));
        map.put("lfloor", new Character(8970));
        map.put("rfloor", new Character(8971));
        map.put("lang", new Character(9001));
        map.put("rang", new Character(9002));
        map.put("loz", new Character(9674));
        map.put("spades", new Character(9824));
        map.put("clubs", new Character(9827));
        map.put("hearts", new Character(9829));
        map.put("diams", new Character(9830));
        map.put("quot", new Character(Typography.quote));
        map.put("amp", new Character(Typography.amp));
        map.put("apos", new Character('\''));
        map.put("lt", new Character(Typography.less));
        map.put("gt", new Character(Typography.greater));
        map.put("OElig", new Character(338));
        map.put("oelig", new Character(339));
        map.put("Scaron", new Character(352));
        map.put("scaron", new Character(353));
        map.put("Yuml", new Character(376));
        map.put("circ", new Character(710));
        map.put("tilde", new Character(732));
        map.put("ensp", new Character(8194));
        map.put("emsp", new Character(8195));
        map.put("thinsp", new Character(8201));
        map.put("zwnj", new Character(8204));
        map.put("zwj", new Character(8205));
        map.put("lrm", new Character(8206));
        map.put("rlm", new Character(8207));
        map.put("ndash", new Character(Typography.ndash));
        map.put("mdash", new Character(Typography.mdash));
        map.put("lsquo", new Character(Typography.leftSingleQuote));
        map.put("rsquo", new Character(Typography.rightSingleQuote));
        map.put("sbquo", new Character(Typography.lowSingleQuote));
        map.put("ldquo", new Character(Typography.leftDoubleQuote));
        map.put("rdquo", new Character(Typography.rightDoubleQuote));
        map.put("bdquo", new Character(Typography.lowDoubleQuote));
        map.put("dagger", new Character(Typography.f6321dagger));
        map.put("Dagger", new Character(Typography.doubleDagger));
        map.put("permil", new Character(8240));
        map.put("lsaquo", new Character(8249));
        map.put("rsaquo", new Character(8250));
        map.put("euro", new Character(Typography.euro));
    }

    public static char decodeEntity(String str) {
        if (str.startsWith("#x")) {
            try {
                return (char) Integer.parseInt(str.substring(2), 16);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else if (str.startsWith("#")) {
            try {
                return (char) Integer.parseInt(str.substring(1));
            } catch (NumberFormatException unused2) {
                return 0;
            }
        } else {
            Character ch = (Character) map.get(str);
            if (ch == null) {
                return 0;
            }
            return ch.charValue();
        }
    }

    public static String decodeString(String str) {
        int i;
        int indexOf = str.indexOf(38);
        if (indexOf == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
        while (true) {
            int indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                stringBuffer.append(str.substring(indexOf));
                return stringBuffer.toString();
            }
            int indexOf3 = str.indexOf(38, indexOf + 1);
            while (true) {
                int i2 = indexOf3;
                i = indexOf;
                indexOf = i2;
                if (indexOf == -1 || indexOf >= indexOf2) {
                    char decodeEntity = decodeEntity(str.substring(i + 1, indexOf2));
                    int i3 = indexOf2 + 1;
                } else {
                    stringBuffer.append(str.substring(i, indexOf));
                    indexOf3 = str.indexOf(38, indexOf + 1);
                }
            }
            char decodeEntity2 = decodeEntity(str.substring(i + 1, indexOf2));
            int i32 = indexOf2 + 1;
            if (str.length() < i32) {
                return stringBuffer.toString();
            }
            if (decodeEntity2 == 0) {
                stringBuffer.append(str.substring(i, i32));
            } else {
                stringBuffer.append(decodeEntity2);
            }
            indexOf = str.indexOf(38, indexOf2);
            if (indexOf == -1) {
                stringBuffer.append(str.substring(i32));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(i32, indexOf));
        }
    }
}
