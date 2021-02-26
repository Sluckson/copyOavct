package repack.org.bouncycastle.asn1.x509;

import androidx.exifinterface.media.ExifInterface;
import com.lowagie.text.xml.xmp.DublinCoreSchema;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.DERString;
import repack.org.bouncycastle.asn1.DERUniversalString;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.util.Strings;
import repack.org.bouncycastle.util.encoders.Hex;

public class X509Name extends ASN1Encodable {
    public static final DERObjectIdentifier BUSINESS_CATEGORY = new DERObjectIdentifier("2.5.4.15");

    /* renamed from: C */
    public static final DERObjectIdentifier f5878C = new DERObjectIdentifier("2.5.4.6");

    /* renamed from: CN */
    public static final DERObjectIdentifier f5879CN = new DERObjectIdentifier("2.5.4.3");
    public static final DERObjectIdentifier COUNTRY_OF_CITIZENSHIP = new DERObjectIdentifier("1.3.6.1.5.5.7.9.4");
    public static final DERObjectIdentifier COUNTRY_OF_RESIDENCE = new DERObjectIdentifier("1.3.6.1.5.5.7.9.5");
    public static final DERObjectIdentifier DATE_OF_BIRTH = new DERObjectIdentifier("1.3.6.1.5.5.7.9.1");

    /* renamed from: DC */
    public static final DERObjectIdentifier f5880DC = new DERObjectIdentifier("0.9.2342.19200300.100.1.25");
    public static final DERObjectIdentifier DMD_NAME = new DERObjectIdentifier("2.5.4.54");
    public static final DERObjectIdentifier DN_QUALIFIER = new DERObjectIdentifier("2.5.4.46");
    public static final Hashtable DefaultLookUp = new Hashtable();
    public static boolean DefaultReverse = false;
    public static final Hashtable DefaultSymbols = new Hashtable();

    /* renamed from: E */
    public static final DERObjectIdentifier f5881E = EmailAddress;
    public static final DERObjectIdentifier EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
    private static final Boolean FALSE = new Boolean(false);
    public static final DERObjectIdentifier GENDER = new DERObjectIdentifier("1.3.6.1.5.5.7.9.3");
    public static final DERObjectIdentifier GENERATION = new DERObjectIdentifier("2.5.4.44");
    public static final DERObjectIdentifier GIVENNAME = new DERObjectIdentifier("2.5.4.42");
    public static final DERObjectIdentifier INITIALS = new DERObjectIdentifier("2.5.4.43");

    /* renamed from: L */
    public static final DERObjectIdentifier f5882L = new DERObjectIdentifier("2.5.4.7");
    public static final DERObjectIdentifier NAME = X509ObjectIdentifiers.id_at_name;
    public static final DERObjectIdentifier NAME_AT_BIRTH = new DERObjectIdentifier("1.3.36.8.3.14");

    /* renamed from: O */
    public static final DERObjectIdentifier f5883O = new DERObjectIdentifier("2.5.4.10");
    public static final Hashtable OIDLookUp = DefaultSymbols;

    /* renamed from: OU */
    public static final DERObjectIdentifier f5884OU = new DERObjectIdentifier("2.5.4.11");
    public static final DERObjectIdentifier PLACE_OF_BIRTH = new DERObjectIdentifier("1.3.6.1.5.5.7.9.2");
    public static final DERObjectIdentifier POSTAL_ADDRESS = new DERObjectIdentifier("2.5.4.16");
    public static final DERObjectIdentifier POSTAL_CODE = new DERObjectIdentifier("2.5.4.17");
    public static final DERObjectIdentifier PSEUDONYM = new DERObjectIdentifier("2.5.4.65");
    public static final Hashtable RFC1779Symbols = new Hashtable();
    public static final Hashtable RFC2253Symbols = new Hashtable();
    public static final DERObjectIdentifier SERIALNUMBER = f5885SN;

    /* renamed from: SN */
    public static final DERObjectIdentifier f5885SN = new DERObjectIdentifier("2.5.4.5");

    /* renamed from: ST */
    public static final DERObjectIdentifier f5886ST = new DERObjectIdentifier("2.5.4.8");
    public static final DERObjectIdentifier STREET = new DERObjectIdentifier("2.5.4.9");
    public static final DERObjectIdentifier SURNAME = new DERObjectIdentifier("2.5.4.4");
    public static final Hashtable SymbolLookUp = DefaultLookUp;

    /* renamed from: T */
    public static final DERObjectIdentifier f5887T = new DERObjectIdentifier("2.5.4.12");
    public static final DERObjectIdentifier TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
    private static final Boolean TRUE = new Boolean(true);
    public static final DERObjectIdentifier UID = new DERObjectIdentifier("0.9.2342.19200300.100.1.1");
    public static final DERObjectIdentifier UNIQUE_IDENTIFIER = new DERObjectIdentifier("2.5.4.45");
    public static final DERObjectIdentifier UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
    public static final DERObjectIdentifier UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
    private Vector added;
    private X509NameEntryConverter converter;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;
    private Vector ordering;
    private ASN1Sequence seq;
    private Vector values;

    static {
        DefaultSymbols.put(f5878C, "C");
        DefaultSymbols.put(f5883O, "O");
        DefaultSymbols.put(f5887T, ExifInterface.GPS_DIRECTION_TRUE);
        DefaultSymbols.put(f5884OU, "OU");
        DefaultSymbols.put(f5879CN, "CN");
        DefaultSymbols.put(f5882L, "L");
        DefaultSymbols.put(f5886ST, "ST");
        DefaultSymbols.put(f5885SN, "SERIALNUMBER");
        DefaultSymbols.put(EmailAddress, ExifInterface.LONGITUDE_EAST);
        DefaultSymbols.put(f5880DC, "DC");
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
        RFC2253Symbols.put(f5878C, "C");
        RFC2253Symbols.put(f5883O, "O");
        RFC2253Symbols.put(f5884OU, "OU");
        RFC2253Symbols.put(f5879CN, "CN");
        RFC2253Symbols.put(f5882L, "L");
        RFC2253Symbols.put(f5886ST, "ST");
        RFC2253Symbols.put(STREET, "STREET");
        RFC2253Symbols.put(f5880DC, "DC");
        RFC2253Symbols.put(UID, "UID");
        RFC1779Symbols.put(f5878C, "C");
        RFC1779Symbols.put(f5883O, "O");
        RFC1779Symbols.put(f5884OU, "OU");
        RFC1779Symbols.put(f5879CN, "CN");
        RFC1779Symbols.put(f5882L, "L");
        RFC1779Symbols.put(f5886ST, "ST");
        RFC1779Symbols.put(STREET, "STREET");
        DefaultLookUp.put("c", f5878C);
        DefaultLookUp.put("o", f5883O);
        DefaultLookUp.put("t", f5887T);
        DefaultLookUp.put("ou", f5884OU);
        DefaultLookUp.put("cn", f5879CN);
        DefaultLookUp.put("l", f5882L);
        DefaultLookUp.put("st", f5886ST);
        DefaultLookUp.put("sn", f5885SN);
        DefaultLookUp.put("serialnumber", f5885SN);
        DefaultLookUp.put("street", STREET);
        DefaultLookUp.put("emailaddress", f5881E);
        DefaultLookUp.put(DublinCoreSchema.DEFAULT_XPATH_ID, f5880DC);
        DefaultLookUp.put("e", f5881E);
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

    public static X509Name getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static X509Name getInstance(Object obj) {
        if (obj == null || (obj instanceof X509Name)) {
            return (X509Name) obj;
        }
        if (obj instanceof X500Name) {
            return new X509Name(ASN1Sequence.getInstance(((X500Name) obj).getDERObject()));
        }
        if (obj != null) {
            return new X509Name(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    protected X509Name() {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
    }

    public X509Name(ASN1Sequence aSN1Sequence) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.seq = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Set instance = ASN1Set.getInstance(((DEREncodable) objects.nextElement()).getDERObject());
            int i = 0;
            while (true) {
                if (i < instance.size()) {
                    ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObjectAt(i));
                    if (instance2.size() == 2) {
                        this.ordering.addElement(DERObjectIdentifier.getInstance(instance2.getObjectAt(0)));
                        DEREncodable objectAt = instance2.getObjectAt(1);
                        if (!(objectAt instanceof DERString) || (objectAt instanceof DERUniversalString)) {
                            Vector vector = this.values;
                            vector.addElement("#" + bytesToString(Hex.encode(objectAt.getDERObject().getDEREncoded())));
                        } else {
                            String string = ((DERString) objectAt).getString();
                            if (string.length() <= 0 || string.charAt(0) != '#') {
                                this.values.addElement(string);
                            } else {
                                Vector vector2 = this.values;
                                vector2.addElement("\\" + string);
                            }
                        }
                        this.added.addElement(i != 0 ? TRUE : FALSE);
                        i++;
                    } else {
                        throw new IllegalArgumentException("badly sized pair");
                    }
                }
            }
        }
    }

    public X509Name(Hashtable hashtable) {
        this((Vector) null, hashtable);
    }

    public X509Name(Vector vector, Hashtable hashtable) {
        this(vector, hashtable, (X509NameEntryConverter) new X509DefaultEntryConverter());
    }

    public X509Name(Vector vector, Hashtable hashtable, X509NameEntryConverter x509NameEntryConverter) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.converter = x509NameEntryConverter;
        int i = 0;
        if (vector != null) {
            for (int i2 = 0; i2 != vector.size(); i2++) {
                this.ordering.addElement(vector.elementAt(i2));
                this.added.addElement(FALSE);
            }
        } else {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                this.ordering.addElement(keys.nextElement());
                this.added.addElement(FALSE);
            }
        }
        while (i != this.ordering.size()) {
            DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) this.ordering.elementAt(i);
            if (hashtable.get(dERObjectIdentifier) != null) {
                this.values.addElement(hashtable.get(dERObjectIdentifier));
                i++;
            } else {
                throw new IllegalArgumentException("No attribute for object id - " + dERObjectIdentifier.getId() + " - passed to distinguished name");
            }
        }
    }

    public X509Name(Vector vector, Vector vector2) {
        this(vector, vector2, (X509NameEntryConverter) new X509DefaultEntryConverter());
    }

    public X509Name(Vector vector, Vector vector2, X509NameEntryConverter x509NameEntryConverter) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.converter = x509NameEntryConverter;
        if (vector.size() == vector2.size()) {
            for (int i = 0; i < vector.size(); i++) {
                this.ordering.addElement(vector.elementAt(i));
                this.values.addElement(vector2.elementAt(i));
                this.added.addElement(FALSE);
            }
            return;
        }
        throw new IllegalArgumentException("oids vector must be same length as values.");
    }

    public X509Name(String str) {
        this(DefaultReverse, DefaultLookUp, str);
    }

    public X509Name(String str, X509NameEntryConverter x509NameEntryConverter) {
        this(DefaultReverse, DefaultLookUp, str, x509NameEntryConverter);
    }

    public X509Name(boolean z, String str) {
        this(z, DefaultLookUp, str);
    }

    public X509Name(boolean z, String str, X509NameEntryConverter x509NameEntryConverter) {
        this(z, DefaultLookUp, str, x509NameEntryConverter);
    }

    public X509Name(boolean z, Hashtable hashtable, String str) {
        this(z, hashtable, str, new X509DefaultEntryConverter());
    }

    private DERObjectIdentifier decodeOID(String str, Hashtable hashtable) {
        if (Strings.toUpperCase(str).startsWith("OID.")) {
            return new DERObjectIdentifier(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new DERObjectIdentifier(str);
        }
        DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) hashtable.get(Strings.toLowerCase(str));
        if (dERObjectIdentifier != null) {
            return dERObjectIdentifier;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    public X509Name(boolean z, Hashtable hashtable, String str, X509NameEntryConverter x509NameEntryConverter) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.converter = x509NameEntryConverter;
        X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str);
        while (x509NameTokenizer.hasMoreTokens()) {
            String nextToken = x509NameTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf != -1) {
                String substring = nextToken.substring(0, indexOf);
                String substring2 = nextToken.substring(indexOf + 1);
                DERObjectIdentifier decodeOID = decodeOID(substring, hashtable);
                if (substring2.indexOf(43) > 0) {
                    X509NameTokenizer x509NameTokenizer2 = new X509NameTokenizer(substring2, '+');
                    String nextToken2 = x509NameTokenizer2.nextToken();
                    this.ordering.addElement(decodeOID);
                    this.values.addElement(nextToken2);
                    this.added.addElement(FALSE);
                    while (x509NameTokenizer2.hasMoreTokens()) {
                        String nextToken3 = x509NameTokenizer2.nextToken();
                        int indexOf2 = nextToken3.indexOf(61);
                        String substring3 = nextToken3.substring(0, indexOf2);
                        String substring4 = nextToken3.substring(indexOf2 + 1);
                        this.ordering.addElement(decodeOID(substring3, hashtable));
                        this.values.addElement(substring4);
                        this.added.addElement(TRUE);
                    }
                } else {
                    this.ordering.addElement(decodeOID);
                    this.values.addElement(substring2);
                    this.added.addElement(FALSE);
                }
            } else {
                throw new IllegalArgumentException("badly formated directory string");
            }
        }
        if (z) {
            Vector vector = new Vector();
            Vector vector2 = new Vector();
            Vector vector3 = new Vector();
            int i = 1;
            for (int i2 = 0; i2 < this.ordering.size(); i2++) {
                if (((Boolean) this.added.elementAt(i2)).booleanValue()) {
                    vector.insertElementAt(this.ordering.elementAt(i2), i);
                    vector2.insertElementAt(this.values.elementAt(i2), i);
                    vector3.insertElementAt(this.added.elementAt(i2), i);
                    i++;
                } else {
                    vector.insertElementAt(this.ordering.elementAt(i2), 0);
                    vector2.insertElementAt(this.values.elementAt(i2), 0);
                    vector3.insertElementAt(this.added.elementAt(i2), 0);
                    i = 1;
                }
            }
            this.ordering = vector;
            this.values = vector2;
            this.added = vector3;
        }
    }

    public Vector getOIDs() {
        Vector vector = new Vector();
        for (int i = 0; i != this.ordering.size(); i++) {
            vector.addElement(this.ordering.elementAt(i));
        }
        return vector;
    }

    public Vector getValues() {
        Vector vector = new Vector();
        for (int i = 0; i != this.values.size(); i++) {
            vector.addElement(this.values.elementAt(i));
        }
        return vector;
    }

    public Vector getValues(DERObjectIdentifier dERObjectIdentifier) {
        Vector vector = new Vector();
        for (int i = 0; i != this.values.size(); i++) {
            if (this.ordering.elementAt(i).equals(dERObjectIdentifier)) {
                String str = (String) this.values.elementAt(i);
                if (str.length() > 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
                    vector.addElement(str.substring(1));
                } else {
                    vector.addElement(str);
                }
            }
        }
        return vector;
    }

    public DERObject toASN1Object() {
        if (this.seq == null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            DERObjectIdentifier dERObjectIdentifier = null;
            int i = 0;
            while (i != this.ordering.size()) {
                ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                DERObjectIdentifier dERObjectIdentifier2 = (DERObjectIdentifier) this.ordering.elementAt(i);
                aSN1EncodableVector3.add(dERObjectIdentifier2);
                aSN1EncodableVector3.add(this.converter.getConvertedValue(dERObjectIdentifier2, (String) this.values.elementAt(i)));
                if (dERObjectIdentifier == null || ((Boolean) this.added.elementAt(i)).booleanValue()) {
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector3));
                } else {
                    aSN1EncodableVector.add(new DERSet(aSN1EncodableVector2));
                    aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector3));
                }
                i++;
                dERObjectIdentifier = dERObjectIdentifier2;
            }
            aSN1EncodableVector.add(new DERSet(aSN1EncodableVector2));
            this.seq = new DERSequence(aSN1EncodableVector);
        }
        return this.seq;
    }

    public boolean equals(Object obj, boolean z) {
        if (!z) {
            return equals(obj);
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (getDERObject().equals(((DEREncodable) obj).getDERObject())) {
            return true;
        }
        try {
            X509Name instance = getInstance(obj);
            int size = this.ordering.size();
            if (size != instance.ordering.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!((DERObjectIdentifier) this.ordering.elementAt(i)).equals((DERObjectIdentifier) instance.ordering.elementAt(i)) || !equivalentStrings((String) this.values.elementAt(i), (String) instance.values.elementAt(i))) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException unused) {
        }
        return false;
    }

    public int hashCode() {
        if (this.isHashCodeCalculated) {
            return this.hashCodeValue;
        }
        this.isHashCodeCalculated = true;
        for (int i = 0; i != this.ordering.size(); i++) {
            String stripInternalSpaces = stripInternalSpaces(canonicalize((String) this.values.elementAt(i)));
            this.hashCodeValue ^= this.ordering.elementAt(i).hashCode();
            this.hashCodeValue = stripInternalSpaces.hashCode() ^ this.hashCodeValue;
        }
        return this.hashCodeValue;
    }

    public boolean equals(Object obj) {
        int i;
        int i2;
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (getDERObject().equals(((DEREncodable) obj).getDERObject())) {
            return true;
        }
        try {
            X509Name instance = getInstance(obj);
            int size = this.ordering.size();
            if (size != instance.ordering.size()) {
                return false;
            }
            boolean[] zArr = new boolean[size];
            int i3 = -1;
            if (this.ordering.elementAt(0).equals(instance.ordering.elementAt(0))) {
                i3 = size;
                i2 = 0;
                i = 1;
            } else {
                i2 = size - 1;
                i = -1;
            }
            while (i2 != i3) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) this.ordering.elementAt(i2);
                String str = (String) this.values.elementAt(i2);
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        z = false;
                        break;
                    } else if (!zArr[i4] && dERObjectIdentifier.equals((DERObjectIdentifier) instance.ordering.elementAt(i4)) && equivalentStrings(str, (String) instance.values.elementAt(i4))) {
                        zArr[i4] = true;
                        z = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z) {
                    return false;
                }
                i2 += i;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private boolean equivalentStrings(String str, String str2) {
        String canonicalize = canonicalize(str);
        String canonicalize2 = canonicalize(str2);
        return canonicalize.equals(canonicalize2) || stripInternalSpaces(canonicalize).equals(stripInternalSpaces(canonicalize2));
    }

    private String canonicalize(String str) {
        String lowerCase = Strings.toLowerCase(str.trim());
        if (lowerCase.length() <= 0 || lowerCase.charAt(0) != '#') {
            return lowerCase;
        }
        ASN1Object decodeObject = decodeObject(lowerCase);
        return decodeObject instanceof DERString ? Strings.toLowerCase(((DERString) decodeObject).getString().trim()) : lowerCase;
    }

    private ASN1Object decodeObject(String str) {
        try {
            return ASN1Object.fromByteArray(Hex.decode(str.substring(1)));
        } catch (IOException e) {
            throw new IllegalStateException("unknown encoding in name: " + e);
        }
    }

    private String stripInternalSpaces(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            stringBuffer.append(charAt);
            int i = 1;
            while (i < str.length()) {
                char charAt2 = str.charAt(i);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    private void appendValue(StringBuffer stringBuffer, Hashtable hashtable, DERObjectIdentifier dERObjectIdentifier, String str) {
        String str2 = (String) hashtable.get(dERObjectIdentifier);
        if (str2 != null) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append(dERObjectIdentifier.getId());
        }
        stringBuffer.append('=');
        int length = stringBuffer.length();
        stringBuffer.append(str);
        int length2 = stringBuffer.length();
        if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
            length += 2;
        }
        while (length != length2) {
            if (stringBuffer.charAt(length) == ',' || stringBuffer.charAt(length) == '\"' || stringBuffer.charAt(length) == '\\' || stringBuffer.charAt(length) == '+' || stringBuffer.charAt(length) == '=' || stringBuffer.charAt(length) == '<' || stringBuffer.charAt(length) == '>' || stringBuffer.charAt(length) == ';') {
                stringBuffer.insert(length, "\\");
                length++;
                length2++;
            }
            length++;
        }
    }

    public String toString(boolean z, Hashtable hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        StringBuffer stringBuffer2 = null;
        for (int i = 0; i < this.ordering.size(); i++) {
            if (((Boolean) this.added.elementAt(i)).booleanValue()) {
                stringBuffer2.append('+');
                appendValue(stringBuffer2, hashtable, (DERObjectIdentifier) this.ordering.elementAt(i), (String) this.values.elementAt(i));
            } else {
                stringBuffer2 = new StringBuffer();
                appendValue(stringBuffer2, hashtable, (DERObjectIdentifier) this.ordering.elementAt(i), (String) this.values.elementAt(i));
                vector.addElement(stringBuffer2);
            }
        }
        boolean z2 = true;
        if (z) {
            for (int size = vector.size() - 1; size >= 0; size--) {
                if (z2) {
                    z2 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(size).toString());
            }
        } else {
            for (int i2 = 0; i2 < vector.size(); i2++) {
                if (z2) {
                    z2 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(i2).toString());
            }
        }
        return stringBuffer.toString();
    }

    private String bytesToString(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    public String toString() {
        return toString(DefaultReverse, DefaultSymbols);
    }
}
