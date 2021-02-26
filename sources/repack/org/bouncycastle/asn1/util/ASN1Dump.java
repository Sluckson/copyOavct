package repack.org.bouncycastle.asn1.util;

import java.io.IOException;
import java.util.Enumeration;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.BERApplicationSpecific;
import repack.org.bouncycastle.asn1.BERConstructedOctetString;
import repack.org.bouncycastle.asn1.BERSequence;
import repack.org.bouncycastle.asn1.BERSet;
import repack.org.bouncycastle.asn1.BERTaggedObject;
import repack.org.bouncycastle.asn1.DERApplicationSpecific;
import repack.org.bouncycastle.asn1.DERBMPString;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DEREnumerated;
import repack.org.bouncycastle.asn1.DERExternal;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERPrintableString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.DERT61String;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.DERUTCTime;
import repack.org.bouncycastle.asn1.DERUTF8String;
import repack.org.bouncycastle.asn1.DERUnknownTag;
import repack.org.bouncycastle.asn1.DERVisibleString;
import repack.org.bouncycastle.util.encoders.Hex;

public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    static void _dumpAsString(String str, boolean z, DERObject dERObject, StringBuffer stringBuffer) {
        String property = System.getProperty("line.separator");
        if (dERObject instanceof ASN1Sequence) {
            Enumeration objects = ((ASN1Sequence) dERObject).getObjects();
            String str2 = String.valueOf(str) + TAB;
            stringBuffer.append(str);
            if (dERObject instanceof BERSequence) {
                stringBuffer.append("BER Sequence");
            } else if (dERObject instanceof DERSequence) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(property);
            while (objects.hasMoreElements()) {
                Object nextElement = objects.nextElement();
                if (nextElement == null || nextElement.equals(new DERNull())) {
                    stringBuffer.append(str2);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement instanceof DERObject) {
                    _dumpAsString(str2, z, (DERObject) nextElement, stringBuffer);
                } else {
                    _dumpAsString(str2, z, ((DEREncodable) nextElement).getDERObject(), stringBuffer);
                }
            }
        } else if (dERObject instanceof DERTaggedObject) {
            String str3 = String.valueOf(str) + TAB;
            stringBuffer.append(str);
            if (dERObject instanceof BERTaggedObject) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            DERTaggedObject dERTaggedObject = (DERTaggedObject) dERObject;
            stringBuffer.append(Integer.toString(dERTaggedObject.getTagNo()));
            stringBuffer.append(']');
            if (!dERTaggedObject.isExplicit()) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(property);
            if (dERTaggedObject.isEmpty()) {
                stringBuffer.append(str3);
                stringBuffer.append("EMPTY");
                stringBuffer.append(property);
                return;
            }
            _dumpAsString(str3, z, dERTaggedObject.getObject(), stringBuffer);
        } else if (dERObject instanceof BERSet) {
            Enumeration objects2 = ((ASN1Set) dERObject).getObjects();
            String str4 = String.valueOf(str) + TAB;
            stringBuffer.append(str);
            stringBuffer.append("BER Set");
            stringBuffer.append(property);
            while (objects2.hasMoreElements()) {
                Object nextElement2 = objects2.nextElement();
                if (nextElement2 == null) {
                    stringBuffer.append(str4);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement2 instanceof DERObject) {
                    _dumpAsString(str4, z, (DERObject) nextElement2, stringBuffer);
                } else {
                    _dumpAsString(str4, z, ((DEREncodable) nextElement2).getDERObject(), stringBuffer);
                }
            }
        } else if (dERObject instanceof DERSet) {
            Enumeration objects3 = ((ASN1Set) dERObject).getObjects();
            String str5 = String.valueOf(str) + TAB;
            stringBuffer.append(str);
            stringBuffer.append("DER Set");
            stringBuffer.append(property);
            while (objects3.hasMoreElements()) {
                Object nextElement3 = objects3.nextElement();
                if (nextElement3 == null) {
                    stringBuffer.append(str5);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement3 instanceof DERObject) {
                    _dumpAsString(str5, z, (DERObject) nextElement3, stringBuffer);
                } else {
                    _dumpAsString(str5, z, ((DEREncodable) nextElement3).getDERObject(), stringBuffer);
                }
            }
        } else if (dERObject instanceof DERObjectIdentifier) {
            stringBuffer.append(String.valueOf(str) + "ObjectIdentifier(" + ((DERObjectIdentifier) dERObject).getId() + ")" + property);
        } else if (dERObject instanceof DERBoolean) {
            stringBuffer.append(String.valueOf(str) + "Boolean(" + ((DERBoolean) dERObject).isTrue() + ")" + property);
        } else if (dERObject instanceof DERInteger) {
            stringBuffer.append(String.valueOf(str) + "Integer(" + ((DERInteger) dERObject).getValue() + ")" + property);
        } else if (dERObject instanceof BERConstructedOctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString) dERObject;
            stringBuffer.append(String.valueOf(str) + "BER Constructed Octet String" + "[" + aSN1OctetString.getOctets().length + "] ");
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, aSN1OctetString.getOctets()));
            } else {
                stringBuffer.append(property);
            }
        } else if (dERObject instanceof DEROctetString) {
            ASN1OctetString aSN1OctetString2 = (ASN1OctetString) dERObject;
            stringBuffer.append(String.valueOf(str) + "DER Octet String" + "[" + aSN1OctetString2.getOctets().length + "] ");
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, aSN1OctetString2.getOctets()));
            } else {
                stringBuffer.append(property);
            }
        } else if (dERObject instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString) dERObject;
            stringBuffer.append(String.valueOf(str) + "DER Bit String" + "[" + dERBitString.getBytes().length + ", " + dERBitString.getPadBits() + "] ");
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, dERBitString.getBytes()));
            } else {
                stringBuffer.append(property);
            }
        } else if (dERObject instanceof DERIA5String) {
            stringBuffer.append(String.valueOf(str) + "IA5String(" + ((DERIA5String) dERObject).getString() + ") " + property);
        } else if (dERObject instanceof DERUTF8String) {
            stringBuffer.append(String.valueOf(str) + "UTF8String(" + ((DERUTF8String) dERObject).getString() + ") " + property);
        } else if (dERObject instanceof DERPrintableString) {
            stringBuffer.append(String.valueOf(str) + "PrintableString(" + ((DERPrintableString) dERObject).getString() + ") " + property);
        } else if (dERObject instanceof DERVisibleString) {
            stringBuffer.append(String.valueOf(str) + "VisibleString(" + ((DERVisibleString) dERObject).getString() + ") " + property);
        } else if (dERObject instanceof DERBMPString) {
            stringBuffer.append(String.valueOf(str) + "BMPString(" + ((DERBMPString) dERObject).getString() + ") " + property);
        } else if (dERObject instanceof DERT61String) {
            stringBuffer.append(String.valueOf(str) + "T61String(" + ((DERT61String) dERObject).getString() + ") " + property);
        } else if (dERObject instanceof DERUTCTime) {
            stringBuffer.append(String.valueOf(str) + "UTCTime(" + ((DERUTCTime) dERObject).getTime() + ") " + property);
        } else if (dERObject instanceof DERGeneralizedTime) {
            stringBuffer.append(String.valueOf(str) + "GeneralizedTime(" + ((DERGeneralizedTime) dERObject).getTime() + ") " + property);
        } else if (dERObject instanceof DERUnknownTag) {
            StringBuilder sb = new StringBuilder(String.valueOf(str));
            sb.append("Unknown ");
            DERUnknownTag dERUnknownTag = (DERUnknownTag) dERObject;
            sb.append(Integer.toString(dERUnknownTag.getTag(), 16));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(new String(Hex.encode(dERUnknownTag.getData())));
            sb.append(property);
            stringBuffer.append(sb.toString());
        } else if (dERObject instanceof BERApplicationSpecific) {
            stringBuffer.append(outputApplicationSpecific(ASN1Encodable.BER, str, z, dERObject, property));
        } else if (dERObject instanceof DERApplicationSpecific) {
            stringBuffer.append(outputApplicationSpecific(ASN1Encodable.DER, str, z, dERObject, property));
        } else if (dERObject instanceof DEREnumerated) {
            stringBuffer.append(String.valueOf(str) + "DER Enumerated(" + ((DEREnumerated) dERObject).getValue() + ")" + property);
        } else if (dERObject instanceof DERExternal) {
            DERExternal dERExternal = (DERExternal) dERObject;
            stringBuffer.append(String.valueOf(str) + "External " + property);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str));
            sb2.append(TAB);
            String sb3 = sb2.toString();
            if (dERExternal.getDirectReference() != null) {
                stringBuffer.append(String.valueOf(sb3) + "Direct Reference: " + dERExternal.getDirectReference().getId() + property);
            }
            if (dERExternal.getIndirectReference() != null) {
                stringBuffer.append(String.valueOf(sb3) + "Indirect Reference: " + dERExternal.getIndirectReference().toString() + property);
            }
            if (dERExternal.getDataValueDescriptor() != null) {
                _dumpAsString(sb3, z, dERExternal.getDataValueDescriptor(), stringBuffer);
            }
            stringBuffer.append(String.valueOf(sb3) + "Encoding: " + dERExternal.getEncoding() + property);
            _dumpAsString(sb3, z, dERExternal.getExternalContent(), stringBuffer);
        } else {
            stringBuffer.append(String.valueOf(str) + dERObject.toString() + property);
        }
    }

    private static String outputApplicationSpecific(String str, String str2, boolean z, DERObject dERObject, String str3) {
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) dERObject;
        StringBuffer stringBuffer = new StringBuffer();
        if (dERApplicationSpecific.isConstructed()) {
            try {
                ASN1Sequence instance = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
                stringBuffer.append(String.valueOf(str2) + str + " ApplicationSpecific[" + dERApplicationSpecific.getApplicationTag() + "]" + str3);
                Enumeration objects = instance.getObjects();
                while (objects.hasMoreElements()) {
                    _dumpAsString(String.valueOf(str2) + TAB, z, (DERObject) objects.nextElement(), stringBuffer);
                }
            } catch (IOException e) {
                stringBuffer.append(e);
            }
            return stringBuffer.toString();
        }
        return String.valueOf(str2) + str + " ApplicationSpecific[" + dERApplicationSpecific.getApplicationTag() + "] (" + new String(Hex.encode(dERApplicationSpecific.getContents())) + ")" + str3;
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    public static String dumpAsString(Object obj, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof DERObject) {
            _dumpAsString("", z, (DERObject) obj, stringBuffer);
        } else if (obj instanceof DEREncodable) {
            _dumpAsString("", z, ((DEREncodable) obj).getDERObject(), stringBuffer);
        } else {
            return "unknown object type " + obj.toString();
        }
        return stringBuffer.toString();
    }

    private static String dumpBinaryDataAsString(String str, byte[] bArr) {
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = String.valueOf(str) + TAB;
        stringBuffer.append(property);
        for (int i = 0; i < bArr.length; i += 32) {
            if (bArr.length - i > 32) {
                stringBuffer.append(str2);
                stringBuffer.append(new String(Hex.encode(bArr, i, 32)));
                stringBuffer.append(TAB);
                stringBuffer.append(calculateAscString(bArr, i, 32));
                stringBuffer.append(property);
            } else {
                stringBuffer.append(str2);
                stringBuffer.append(new String(Hex.encode(bArr, i, bArr.length - i)));
                for (int length = bArr.length - i; length != 32; length++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(TAB);
                stringBuffer.append(calculateAscString(bArr, i, bArr.length - i));
                stringBuffer.append(property);
            }
        }
        return stringBuffer.toString();
    }

    private static String calculateAscString(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 != i + i2; i3++) {
            if (bArr[i3] >= 32 && bArr[i3] <= 126) {
                stringBuffer.append((char) bArr[i3]);
            }
        }
        return stringBuffer.toString();
    }
}
