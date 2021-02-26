package repack.org.bouncycastle.asn1.x500.style;

import androidx.exifinterface.media.ExifInterface;
import com.lowagie.text.xml.xmp.DublinCoreSchema;
import java.io.IOException;
import java.util.Hashtable;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERPrintableString;
import repack.org.bouncycastle.asn1.DERUTF8String;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import repack.org.bouncycastle.asn1.x500.RDN;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x500.X500NameStyle;
import repack.org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle implements X500NameStyle {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY = new ASN1ObjectIdentifier("2.5.4.15");

    /* renamed from: C */
    public static final ASN1ObjectIdentifier f5855C = new ASN1ObjectIdentifier("2.5.4.6");

    /* renamed from: CN */
    public static final ASN1ObjectIdentifier f5856CN = new ASN1ObjectIdentifier("2.5.4.3");
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");

    /* renamed from: DC */
    public static final ASN1ObjectIdentifier f5857DC = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
    public static final ASN1ObjectIdentifier DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
    public static final ASN1ObjectIdentifier DN_QUALIFIER = new ASN1ObjectIdentifier("2.5.4.46");
    private static final Hashtable DefaultLookUp = new Hashtable();
    private static final Hashtable DefaultSymbols = new Hashtable();

    /* renamed from: E */
    public static final ASN1ObjectIdentifier f5858E = EmailAddress;
    public static final ASN1ObjectIdentifier EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
    public static final ASN1ObjectIdentifier GENDER = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
    public static final ASN1ObjectIdentifier GENERATION = new ASN1ObjectIdentifier("2.5.4.44");
    public static final ASN1ObjectIdentifier GIVENNAME = new ASN1ObjectIdentifier("2.5.4.42");
    public static final ASN1ObjectIdentifier INITIALS = new ASN1ObjectIdentifier("2.5.4.43");
    public static final X500NameStyle INSTANCE = new BCStyle();

    /* renamed from: L */
    public static final ASN1ObjectIdentifier f5859L = new ASN1ObjectIdentifier("2.5.4.7");
    public static final ASN1ObjectIdentifier NAME = X509ObjectIdentifiers.id_at_name;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH = new ASN1ObjectIdentifier("1.3.36.8.3.14");

    /* renamed from: O */
    public static final ASN1ObjectIdentifier f5860O = new ASN1ObjectIdentifier("2.5.4.10");

    /* renamed from: OU */
    public static final ASN1ObjectIdentifier f5861OU = new ASN1ObjectIdentifier("2.5.4.11");
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS = new ASN1ObjectIdentifier("2.5.4.16");
    public static final ASN1ObjectIdentifier POSTAL_CODE = new ASN1ObjectIdentifier("2.5.4.17");
    public static final ASN1ObjectIdentifier PSEUDONYM = new ASN1ObjectIdentifier("2.5.4.65");
    public static final ASN1ObjectIdentifier SERIALNUMBER = f5862SN;

    /* renamed from: SN */
    public static final ASN1ObjectIdentifier f5862SN = new ASN1ObjectIdentifier("2.5.4.5");

    /* renamed from: ST */
    public static final ASN1ObjectIdentifier f5863ST = new ASN1ObjectIdentifier("2.5.4.8");
    public static final ASN1ObjectIdentifier STREET = new ASN1ObjectIdentifier("2.5.4.9");
    public static final ASN1ObjectIdentifier SURNAME = new ASN1ObjectIdentifier("2.5.4.4");

    /* renamed from: T */
    public static final ASN1ObjectIdentifier f5864T = new ASN1ObjectIdentifier("2.5.4.12");
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
    public static final ASN1ObjectIdentifier UID = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER = new ASN1ObjectIdentifier("2.5.4.45");
    public static final ASN1ObjectIdentifier UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
    public static final ASN1ObjectIdentifier UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;

    static {
        DefaultSymbols.put(f5855C, "C");
        DefaultSymbols.put(f5860O, "O");
        DefaultSymbols.put(f5864T, ExifInterface.GPS_DIRECTION_TRUE);
        DefaultSymbols.put(f5861OU, "OU");
        DefaultSymbols.put(f5856CN, "CN");
        DefaultSymbols.put(f5859L, "L");
        DefaultSymbols.put(f5863ST, "ST");
        DefaultSymbols.put(f5862SN, "SERIALNUMBER");
        DefaultSymbols.put(EmailAddress, ExifInterface.LONGITUDE_EAST);
        DefaultSymbols.put(f5857DC, "DC");
        DefaultSymbols.put(UID, "UID");
        DefaultSymbols.put(STREET, "STREET");
        DefaultSymbols.put(SURNAME, "SURNAME");
        DefaultSymbols.put(GIVENNAME, "GIVENNAME");
        DefaultSymbols.put(INITIALS, "INITIALS");
        DefaultSymbols.put(GENERATION, "GENERATION");
        DefaultSymbols.put(UnstructuredAddress, "unstructuredAddress");
        DefaultSymbols.put(UnstructuredName, "unstructuredName");
        DefaultSymbols.put(UNIQUE_IDENTIFIER, "UniqueIdentifier");
        DefaultSymbols.put(DN_QUALIFIER, "DN");
        DefaultSymbols.put(PSEUDONYM, "Pseudonym");
        DefaultSymbols.put(POSTAL_ADDRESS, "PostalAddress");
        DefaultSymbols.put(NAME_AT_BIRTH, "NameAtBirth");
        DefaultSymbols.put(COUNTRY_OF_CITIZENSHIP, "CountryOfCitizenship");
        DefaultSymbols.put(COUNTRY_OF_RESIDENCE, "CountryOfResidence");
        DefaultSymbols.put(GENDER, "Gender");
        DefaultSymbols.put(PLACE_OF_BIRTH, "PlaceOfBirth");
        DefaultSymbols.put(DATE_OF_BIRTH, "DateOfBirth");
        DefaultSymbols.put(POSTAL_CODE, "PostalCode");
        DefaultSymbols.put(BUSINESS_CATEGORY, "BusinessCategory");
        DefaultSymbols.put(TELEPHONE_NUMBER, "TelephoneNumber");
        DefaultSymbols.put(NAME, "Name");
        DefaultLookUp.put("c", f5855C);
        DefaultLookUp.put("o", f5860O);
        DefaultLookUp.put("t", f5864T);
        DefaultLookUp.put("ou", f5861OU);
        DefaultLookUp.put("cn", f5856CN);
        DefaultLookUp.put("l", f5859L);
        DefaultLookUp.put("st", f5863ST);
        DefaultLookUp.put("sn", f5862SN);
        DefaultLookUp.put("serialnumber", f5862SN);
        DefaultLookUp.put("street", STREET);
        DefaultLookUp.put("emailaddress", f5858E);
        DefaultLookUp.put(DublinCoreSchema.DEFAULT_XPATH_ID, f5857DC);
        DefaultLookUp.put("e", f5858E);
        DefaultLookUp.put("uid", UID);
        DefaultLookUp.put("surname", SURNAME);
        DefaultLookUp.put("givenname", GIVENNAME);
        DefaultLookUp.put("initials", INITIALS);
        DefaultLookUp.put("generation", GENERATION);
        DefaultLookUp.put("unstructuredaddress", UnstructuredAddress);
        DefaultLookUp.put("unstructuredname", UnstructuredName);
        DefaultLookUp.put("uniqueidentifier", UNIQUE_IDENTIFIER);
        DefaultLookUp.put("dn", DN_QUALIFIER);
        DefaultLookUp.put("pseudonym", PSEUDONYM);
        DefaultLookUp.put("postaladdress", POSTAL_ADDRESS);
        DefaultLookUp.put("nameofbirth", NAME_AT_BIRTH);
        DefaultLookUp.put("countryofcitizenship", COUNTRY_OF_CITIZENSHIP);
        DefaultLookUp.put("countryofresidence", COUNTRY_OF_RESIDENCE);
        DefaultLookUp.put("gender", GENDER);
        DefaultLookUp.put("placeofbirth", PLACE_OF_BIRTH);
        DefaultLookUp.put("dateofbirth", DATE_OF_BIRTH);
        DefaultLookUp.put("postalcode", POSTAL_CODE);
        DefaultLookUp.put("businesscategory", BUSINESS_CATEGORY);
        DefaultLookUp.put("telephonenumber", TELEPHONE_NUMBER);
        DefaultLookUp.put("name", NAME);
    }

    protected BCStyle() {
    }

    public ASN1Encodable stringToValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            if (aSN1ObjectIdentifier.equals(EmailAddress) || aSN1ObjectIdentifier.equals(f5857DC)) {
                return new DERIA5String(str);
            }
            if (aSN1ObjectIdentifier.equals(DATE_OF_BIRTH)) {
                return new DERGeneralizedTime(str);
            }
            if (aSN1ObjectIdentifier.equals(f5855C) || aSN1ObjectIdentifier.equals(f5862SN) || aSN1ObjectIdentifier.equals(DN_QUALIFIER) || aSN1ObjectIdentifier.equals(TELEPHONE_NUMBER)) {
                return new DERPrintableString(str);
            }
            return new DERUTF8String(str);
        }
        try {
            return IETFUtils.valueFromHexString(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + aSN1ObjectIdentifier.getId());
        }
    }

    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, DefaultLookUp);
    }

    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        RDN[] rDNs = x500Name.getRDNs();
        RDN[] rDNs2 = x500Name2.getRDNs();
        if (rDNs.length != rDNs2.length) {
            return false;
        }
        boolean z = (rDNs[0].getFirst() == null || rDNs2[0].getFirst() == null) ? false : !rDNs[0].getFirst().getType().equals(rDNs2[0].getFirst().getType());
        for (int i = 0; i != rDNs.length; i++) {
            if (!foundMatch(z, rDNs[i], rDNs2)) {
                return false;
            }
        }
        return true;
    }

    private boolean foundMatch(boolean z, RDN rdn, RDN[] rdnArr) {
        if (z) {
            int length = rdnArr.length - 1;
            while (length >= 0) {
                if (rdnArr[length] == null || !rdnAreEqual(rdn, rdnArr[length])) {
                    length--;
                } else {
                    rdnArr[length] = null;
                    return true;
                }
            }
        } else {
            int i = 0;
            while (i != rdnArr.length) {
                if (rdnArr[i] == null || !rdnAreEqual(rdn, rdnArr[i])) {
                    i++;
                } else {
                    rdnArr[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean rdnAreEqual(RDN rdn, RDN rdn2) {
        if (rdn.isMultiValued()) {
            if (!rdn2.isMultiValued()) {
                return false;
            }
            AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
            AttributeTypeAndValue[] typesAndValues2 = rdn2.getTypesAndValues();
            if (typesAndValues.length != typesAndValues2.length) {
                return false;
            }
            for (int i = 0; i != typesAndValues.length; i++) {
                if (!atvAreEqual(typesAndValues[i], typesAndValues2[i])) {
                    return false;
                }
            }
            return true;
        } else if (!rdn2.isMultiValued()) {
            return atvAreEqual(rdn.getFirst(), rdn2.getFirst());
        } else {
            return false;
        }
    }

    private boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.getType().equals(attributeTypeAndValue2.getType()) && IETFUtils.canonicalize(IETFUtils.valueToString(attributeTypeAndValue.getValue())).equals(IETFUtils.canonicalize(IETFUtils.valueToString(attributeTypeAndValue2.getValue())));
    }

    public RDN[] fromString(String str) {
        return IETFUtils.rDNsFromString(str, this);
    }

    public int calculateHashCode(X500Name x500Name) {
        RDN[] rDNs = x500Name.getRDNs();
        int i = 0;
        for (int i2 = 0; i2 != rDNs.length; i2++) {
            if (rDNs[i2].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rDNs[i2].getTypesAndValues();
                int i3 = i;
                for (int i4 = 0; i4 != typesAndValues.length; i4++) {
                    i3 = (i3 ^ typesAndValues[i4].getType().hashCode()) ^ calcHashCode(typesAndValues[i4].getValue());
                }
                i = i3;
            } else {
                i = (i ^ rDNs[i2].getFirst().getType().hashCode()) ^ calcHashCode(rDNs[i2].getFirst().getValue());
            }
        }
        return i;
    }

    private int calcHashCode(ASN1Encodable aSN1Encodable) {
        return IETFUtils.canonicalize(IETFUtils.valueToString(aSN1Encodable)).hashCode();
    }

    public String toString(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z = true;
        for (int i = 0; i < rDNs.length; i++) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            if (rDNs[i].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rDNs[i].getTypesAndValues();
                boolean z2 = true;
                for (int i2 = 0; i2 != typesAndValues.length; i2++) {
                    if (z2) {
                        z2 = false;
                    } else {
                        stringBuffer.append('+');
                    }
                    IETFUtils.appendTypeAndValue(stringBuffer, typesAndValues[i2], DefaultSymbols);
                }
            } else {
                IETFUtils.appendTypeAndValue(stringBuffer, rDNs[i].getFirst(), DefaultSymbols);
            }
        }
        return stringBuffer.toString();
    }
}
