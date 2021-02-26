package com.lowagie.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.HtmlTags;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PdfName extends PdfObject implements Comparable {

    /* renamed from: A */
    public static final PdfName f641A = new PdfName(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);

    /* renamed from: AA */
    public static final PdfName f642AA = new PdfName("AA");
    public static final PdfName ABSOLUTECOLORIMETRIC = new PdfName("AbsoluteColorimetric");

    /* renamed from: AC */
    public static final PdfName f643AC = new PdfName("AC");
    public static final PdfName ACROFORM = new PdfName("AcroForm");
    public static final PdfName ACTION = new PdfName("Action");
    public static final PdfName ACTIVATION = new PdfName("Activation");
    public static final PdfName ACTUALTEXT = new PdfName("ActualText");
    public static final PdfName ADBE = new PdfName("ADBE");
    public static final PdfName ADBE_PKCS7_DETACHED = new PdfName("adbe.pkcs7.detached");
    public static final PdfName ADBE_PKCS7_S4 = new PdfName("adbe.pkcs7.s4");
    public static final PdfName ADBE_PKCS7_S5 = new PdfName("adbe.pkcs7.s5");
    public static final PdfName ADBE_PKCS7_SHA1 = new PdfName("adbe.pkcs7.sha1");
    public static final PdfName ADBE_X509_RSA_SHA1 = new PdfName("adbe.x509.rsa_sha1");
    public static final PdfName ADOBE_PPKLITE = new PdfName("Adobe.PPKLite");
    public static final PdfName ADOBE_PPKMS = new PdfName("Adobe.PPKMS");
    public static final PdfName AESV2 = new PdfName("AESV2");
    public static final PdfName AIS = new PdfName("AIS");
    public static final PdfName ALLPAGES = new PdfName("AllPages");
    public static final PdfName ALT = new PdfName("Alt");
    public static final PdfName ALTERNATE = new PdfName("Alternate");
    public static final PdfName ANIMATION = new PdfName("Animation");
    public static final PdfName ANNOT = new PdfName("Annot");
    public static final PdfName ANNOTS = new PdfName("Annots");
    public static final PdfName ANTIALIAS = new PdfName("AntiAlias");

    /* renamed from: AP */
    public static final PdfName f644AP = new PdfName("AP");
    public static final PdfName APPDEFAULT = new PdfName("AppDefault");
    public static final PdfName ART = new PdfName("Art");
    public static final PdfName ARTBOX = new PdfName("ArtBox");

    /* renamed from: AS */
    public static final PdfName f645AS = new PdfName("AS");
    public static final PdfName ASCENT = new PdfName("Ascent");
    public static final PdfName ASCII85DECODE = new PdfName("ASCII85Decode");
    public static final PdfName ASCIIHEXDECODE = new PdfName("ASCIIHexDecode");
    public static final PdfName ASSET = new PdfName("Asset");
    public static final PdfName ASSETS = new PdfName("Assets");
    public static final PdfName AUTHEVENT = new PdfName("AuthEvent");
    public static final PdfName AUTHOR = new PdfName("Author");

    /* renamed from: B */
    public static final PdfName f646B = new PdfName("B");
    public static final PdfName BACKGROUND = new PdfName("Background");
    public static final PdfName BASEENCODING = new PdfName("BaseEncoding");
    public static final PdfName BASEFONT = new PdfName("BaseFont");
    public static final PdfName BASEVERSION = new PdfName("BaseVersion");
    public static final PdfName BBOX = new PdfName("BBox");

    /* renamed from: BC */
    public static final PdfName f647BC = new PdfName("BC");

    /* renamed from: BG */
    public static final PdfName f648BG = new PdfName("BG");
    public static final PdfName BIBENTRY = new PdfName("BibEntry");
    public static final PdfName BIGFIVE = new PdfName("BigFive");
    public static final PdfName BINDING = new PdfName("Binding");
    public static final PdfName BINDINGMATERIALNAME = new PdfName("BindingMaterialName");
    public static final PdfName BITSPERCOMPONENT = new PdfName("BitsPerComponent");
    public static final PdfName BITSPERSAMPLE = new PdfName(ExifInterface.TAG_BITS_PER_SAMPLE);

    /* renamed from: BL */
    public static final PdfName f649BL = new PdfName("Bl");
    public static final PdfName BLACKIS1 = new PdfName("BlackIs1");
    public static final PdfName BLACKPOINT = new PdfName("BlackPoint");
    public static final PdfName BLEEDBOX = new PdfName("BleedBox");
    public static final PdfName BLINDS = new PdfName("Blinds");
    public static final PdfName BLOCKQUOTE = new PdfName("BlockQuote");

    /* renamed from: BM */
    public static final PdfName f650BM = new PdfName("BM");
    public static final PdfName BORDER = new PdfName("Border");
    public static final PdfName BOUNDS = new PdfName("Bounds");
    public static final PdfName BOX = new PdfName("Box");

    /* renamed from: BS */
    public static final PdfName f651BS = new PdfName("BS");
    public static final PdfName BTN = new PdfName("Btn");
    public static final PdfName BYTERANGE = new PdfName("ByteRange");

    /* renamed from: C */
    public static final PdfName f652C = new PdfName("C");

    /* renamed from: C0 */
    public static final PdfName f653C0 = new PdfName("C0");

    /* renamed from: C1 */
    public static final PdfName f654C1 = new PdfName("C1");

    /* renamed from: CA */
    public static final PdfName f655CA = new PdfName("CA");
    public static final PdfName CALGRAY = new PdfName("CalGray");
    public static final PdfName CALRGB = new PdfName("CalRGB");
    public static final PdfName CAPHEIGHT = new PdfName("CapHeight");
    public static final PdfName CAPTION = new PdfName("Caption");
    public static final PdfName CATALOG = new PdfName("Catalog");
    public static final PdfName CATEGORY = new PdfName("Category");
    public static final PdfName CCITTFAXDECODE = new PdfName("CCITTFaxDecode");
    public static final PdfName CENTER = new PdfName("Center");
    public static final PdfName CENTERWINDOW = new PdfName("CenterWindow");
    public static final PdfName CERT = new PdfName("Cert");

    /* renamed from: CF */
    public static final PdfName f656CF = new PdfName("CF");
    public static final PdfName CFM = new PdfName("CFM");

    /* renamed from: CH */
    public static final PdfName f657CH = new PdfName("Ch");
    public static final PdfName CHARPROCS = new PdfName("CharProcs");

    /* renamed from: CI */
    public static final PdfName f658CI = new PdfName("CI");
    public static final PdfName CIDFONTTYPE0 = new PdfName("CIDFontType0");
    public static final PdfName CIDFONTTYPE2 = new PdfName("CIDFontType2");
    public static final PdfName CIDSET = new PdfName("CIDSet");
    public static final PdfName CIDSYSTEMINFO = new PdfName("CIDSystemInfo");
    public static final PdfName CIDTOGIDMAP = new PdfName("CIDToGIDMap");
    public static final PdfName CIRCLE = new PdfName("Circle");
    public static final PdfName CMD = new PdfName("CMD");

    /* renamed from: CO */
    public static final PdfName f659CO = new PdfName("CO");
    public static final PdfName CODE = new PdfName("Code");
    public static final PdfName COLLECTION = new PdfName("Collection");
    public static final PdfName COLLECTIONFIELD = new PdfName("CollectionField");
    public static final PdfName COLLECTIONITEM = new PdfName("CollectionItem");
    public static final PdfName COLLECTIONSCHEMA = new PdfName("CollectionSchema");
    public static final PdfName COLLECTIONSORT = new PdfName("CollectionSort");
    public static final PdfName COLLECTIONSUBITEM = new PdfName("CollectionSubitem");
    public static final PdfName COLORS = new PdfName("Colors");
    public static final PdfName COLORSPACE = new PdfName(ExifInterface.TAG_COLOR_SPACE);
    public static final PdfName COLUMNS = new PdfName("Columns");
    public static final PdfName CONDITION = new PdfName("Condition");
    public static final PdfName CONFIGURATION = new PdfName("Configuration");
    public static final PdfName CONFIGURATIONS = new PdfName("Configurations");
    public static final PdfName CONTACTINFO = new PdfName("ContactInfo");
    public static final PdfName CONTENT = new PdfName("Content");
    public static final PdfName CONTENTS = new PdfName("Contents");
    public static final PdfName COORDS = new PdfName("Coords");
    public static final PdfName COUNT = new PdfName("Count");
    public static final PdfName COURIER = new PdfName("Courier");
    public static final PdfName COURIER_BOLD = new PdfName("Courier-Bold");
    public static final PdfName COURIER_BOLDOBLIQUE = new PdfName("Courier-BoldOblique");
    public static final PdfName COURIER_OBLIQUE = new PdfName("Courier-Oblique");
    public static final PdfName CREATIONDATE = new PdfName("CreationDate");
    public static final PdfName CREATOR = new PdfName("Creator");
    public static final PdfName CREATORINFO = new PdfName("CreatorInfo");
    public static final PdfName CROPBOX = new PdfName("CropBox");
    public static final PdfName CRYPT = new PdfName("Crypt");

    /* renamed from: CS */
    public static final PdfName f660CS = new PdfName("CS");
    public static final PdfName CUEPOINT = new PdfName("CuePoint");
    public static final PdfName CUEPOINTS = new PdfName("CuePoints");

    /* renamed from: D */
    public static final PdfName f661D = new PdfName("D");

    /* renamed from: DA */
    public static final PdfName f662DA = new PdfName("DA");
    public static final PdfName DATA = new PdfName("Data");

    /* renamed from: DC */
    public static final PdfName f663DC = new PdfName("DC");
    public static final PdfName DCTDECODE = new PdfName("DCTDecode");
    public static final PdfName DEACTIVATION = new PdfName("Deactivation");
    public static final PdfName DECODE = new PdfName("Decode");
    public static final PdfName DECODEPARMS = new PdfName("DecodeParms");
    public static final PdfName DEFAULT = new PdfName("Default");
    public static final PdfName DEFAULTCMYK = new PdfName("DefaultCMYK");
    public static final PdfName DEFAULTCRYPTFILTER = new PdfName("DefaultCryptFilter");
    public static final PdfName DEFAULTGRAY = new PdfName("DefaultGray");
    public static final PdfName DEFAULTRGB = new PdfName("DefaultRGB");
    public static final PdfName DESC = new PdfName("Desc");
    public static final PdfName DESCENDANTFONTS = new PdfName("DescendantFonts");
    public static final PdfName DESCENT = new PdfName("Descent");
    public static final PdfName DEST = new PdfName("Dest");
    public static final PdfName DESTOUTPUTPROFILE = new PdfName("DestOutputProfile");
    public static final PdfName DESTS = new PdfName("Dests");
    public static final PdfName DEVICECMYK = new PdfName("DeviceCMYK");
    public static final PdfName DEVICEGRAY = new PdfName("DeviceGray");
    public static final PdfName DEVICERGB = new PdfName("DeviceRGB");

    /* renamed from: DI */
    public static final PdfName f664DI = new PdfName("Di");
    public static final PdfName DIFFERENCES = new PdfName("Differences");
    public static final PdfName DIRECTION = new PdfName("Direction");
    public static final PdfName DISPLAYDOCTITLE = new PdfName("DisplayDocTitle");
    public static final PdfName DISSOLVE = new PdfName("Dissolve");
    public static final PdfName DIV = new PdfName("Div");

    /* renamed from: DM */
    public static final PdfName f665DM = new PdfName("Dm");
    public static final PdfName DOCMDP = new PdfName("DocMDP");
    public static final PdfName DOCOPEN = new PdfName("DocOpen");
    public static final PdfName DOCUMENT = new PdfName("Document");
    public static final PdfName DOMAIN = new PdfName("Domain");

    /* renamed from: DP */
    public static final PdfName f666DP = new PdfName("DP");

    /* renamed from: DR */
    public static final PdfName f667DR = new PdfName("DR");

    /* renamed from: DS */
    public static final PdfName f668DS = new PdfName("DS");
    public static final PdfName DUPLEX = new PdfName("Duplex");
    public static final PdfName DUPLEXFLIPLONGEDGE = new PdfName("DuplexFlipLongEdge");
    public static final PdfName DUPLEXFLIPSHORTEDGE = new PdfName("DuplexFlipShortEdge");
    public static final PdfName DUR = new PdfName("Dur");

    /* renamed from: DV */
    public static final PdfName f669DV = new PdfName("DV");

    /* renamed from: DW */
    public static final PdfName f670DW = new PdfName("DW");

    /* renamed from: E */
    public static final PdfName f671E = new PdfName(ExifInterface.LONGITUDE_EAST);
    public static final PdfName EARLYCHANGE = new PdfName("EarlyChange");

    /* renamed from: EF */
    public static final PdfName f672EF = new PdfName("EF");
    public static final PdfName EFF = new PdfName("EFF");
    public static final PdfName EFOPEN = new PdfName("EFOpen");
    public static final PdfName EMBEDDED = new PdfName("Embedded");
    public static final PdfName EMBEDDEDFILE = new PdfName("EmbeddedFile");
    public static final PdfName EMBEDDEDFILES = new PdfName("EmbeddedFiles");
    public static final PdfName ENCODE = new PdfName("Encode");
    public static final PdfName ENCODEDBYTEALIGN = new PdfName("EncodedByteAlign");
    public static final PdfName ENCODING = new PdfName("Encoding");
    public static final PdfName ENCRYPT = new PdfName("Encrypt");
    public static final PdfName ENCRYPTMETADATA = new PdfName("EncryptMetadata");
    public static final PdfName ENDOFBLOCK = new PdfName("EndOfBlock");
    public static final PdfName ENDOFLINE = new PdfName("EndOfLine");
    public static final PdfName EVENT = new PdfName("Event");
    public static final PdfName EXPORT = new PdfName("Export");
    public static final PdfName EXPORTSTATE = new PdfName("ExportState");
    public static final PdfName EXTEND = new PdfName("Extend");
    public static final PdfName EXTENSIONLEVEL = new PdfName("ExtensionLevel");
    public static final PdfName EXTENSIONS = new PdfName("Extensions");
    public static final PdfName EXTGSTATE = new PdfName("ExtGState");

    /* renamed from: F */
    public static final PdfName f673F = new PdfName("F");
    public static final PdfName FAR = new PdfName("Far");

    /* renamed from: FB */
    public static final PdfName f674FB = new PdfName("FB");
    public static final PdfName FDECODEPARMS = new PdfName("FDecodeParms");
    public static final PdfName FDF = new PdfName("FDF");

    /* renamed from: FF */
    public static final PdfName f675FF = new PdfName("Ff");
    public static final PdfName FFILTER = new PdfName("FFilter");
    public static final PdfName FIELDS = new PdfName("Fields");
    public static final PdfName FIGURE = new PdfName("Figure");
    public static final PdfName FILEATTACHMENT = new PdfName("FileAttachment");
    public static final PdfName FILESPEC = new PdfName("Filespec");
    public static final PdfName FILTER = new PdfName("Filter");
    public static final PdfName FIRST = new PdfName("First");
    public static final PdfName FIRSTCHAR = new PdfName("FirstChar");
    public static final PdfName FIRSTPAGE = new PdfName("FirstPage");
    public static final PdfName FIT = new PdfName("Fit");
    public static final PdfName FITB = new PdfName("FitB");
    public static final PdfName FITBH = new PdfName("FitBH");
    public static final PdfName FITBV = new PdfName("FitBV");
    public static final PdfName FITH = new PdfName("FitH");
    public static final PdfName FITR = new PdfName("FitR");
    public static final PdfName FITV = new PdfName("FitV");
    public static final PdfName FITWINDOW = new PdfName("FitWindow");
    public static final PdfName FLAGS = new PdfName("Flags");
    public static final PdfName FLASH = new PdfName(ExifInterface.TAG_FLASH);
    public static final PdfName FLASHVARS = new PdfName("FlashVars");
    public static final PdfName FLATEDECODE = new PdfName("FlateDecode");

    /* renamed from: FO */
    public static final PdfName f676FO = new PdfName("Fo");
    public static final PdfName FONT = new PdfName("Font");
    public static final PdfName FONTBBOX = new PdfName("FontBBox");
    public static final PdfName FONTDESCRIPTOR = new PdfName("FontDescriptor");
    public static final PdfName FONTFILE = new PdfName("FontFile");
    public static final PdfName FONTFILE2 = new PdfName("FontFile2");
    public static final PdfName FONTFILE3 = new PdfName("FontFile3");
    public static final PdfName FONTMATRIX = new PdfName("FontMatrix");
    public static final PdfName FONTNAME = new PdfName("FontName");
    public static final PdfName FOREGROUND = new PdfName("Foreground");
    public static final PdfName FORM = new PdfName("Form");
    public static final PdfName FORMTYPE = new PdfName("FormType");
    public static final PdfName FORMULA = new PdfName("Formula");
    public static final PdfName FREETEXT = new PdfName("FreeText");
    public static final PdfName FRM = new PdfName("FRM");

    /* renamed from: FS */
    public static final PdfName f677FS = new PdfName("FS");

    /* renamed from: FT */
    public static final PdfName f678FT = new PdfName("FT");
    public static final PdfName FULLSCREEN = new PdfName("FullScreen");
    public static final PdfName FUNCTION = new PdfName("Function");
    public static final PdfName FUNCTIONS = new PdfName("Functions");
    public static final PdfName FUNCTIONTYPE = new PdfName("FunctionType");
    public static final PdfName GAMMA = new PdfName(ExifInterface.TAG_GAMMA);
    public static final PdfName GBK = new PdfName("GBK");
    public static final PdfName GLITTER = new PdfName("Glitter");
    public static final PdfName GOTO = new PdfName("GoTo");
    public static final PdfName GOTOE = new PdfName("GoToE");
    public static final PdfName GOTOR = new PdfName("GoToR");
    public static final PdfName GROUP = new PdfName("Group");
    public static final PdfName GTS_PDFA1 = new PdfName("GTS_PDFA1");
    public static final PdfName GTS_PDFX = new PdfName("GTS_PDFX");
    public static final PdfName GTS_PDFXVERSION = new PdfName("GTS_PDFXVersion");

    /* renamed from: H */
    public static final PdfName f679H = new PdfName("H");

    /* renamed from: H1 */
    public static final PdfName f680H1 = new PdfName("H1");

    /* renamed from: H2 */
    public static final PdfName f681H2 = new PdfName("H2");

    /* renamed from: H3 */
    public static final PdfName f682H3 = new PdfName("H3");

    /* renamed from: H4 */
    public static final PdfName f683H4 = new PdfName("H4");

    /* renamed from: H5 */
    public static final PdfName f684H5 = new PdfName("H5");

    /* renamed from: H6 */
    public static final PdfName f685H6 = new PdfName("H6");
    public static final PdfName HALIGN = new PdfName("HAlign");
    public static final PdfName HEIGHT = new PdfName("Height");
    public static final PdfName HELV = new PdfName("Helv");
    public static final PdfName HELVETICA = new PdfName("Helvetica");
    public static final PdfName HELVETICA_BOLD = new PdfName("Helvetica-Bold");
    public static final PdfName HELVETICA_BOLDOBLIQUE = new PdfName("Helvetica-BoldOblique");
    public static final PdfName HELVETICA_OBLIQUE = new PdfName("Helvetica-Oblique");
    public static final PdfName HID = new PdfName("Hid");
    public static final PdfName HIDE = new PdfName("Hide");
    public static final PdfName HIDEMENUBAR = new PdfName("HideMenubar");
    public static final PdfName HIDETOOLBAR = new PdfName("HideToolbar");
    public static final PdfName HIDEWINDOWUI = new PdfName("HideWindowUI");
    public static final PdfName HIGHLIGHT = new PdfName("Highlight");
    public static final PdfName HOFFSET = new PdfName("HOffset");

    /* renamed from: I */
    public static final PdfName f686I = new PdfName("I");
    public static final PdfName ICCBASED = new PdfName("ICCBased");

    /* renamed from: ID */
    public static final PdfName f687ID = new PdfName("ID");
    public static final PdfName IDENTITY = new PdfName("Identity");

    /* renamed from: IF */
    public static final PdfName f688IF = new PdfName("IF");
    public static final PdfName IMAGE = new PdfName("Image");
    public static final PdfName IMAGEB = new PdfName("ImageB");
    public static final PdfName IMAGEC = new PdfName("ImageC");
    public static final PdfName IMAGEI = new PdfName("ImageI");
    public static final PdfName IMAGEMASK = new PdfName("ImageMask");
    public static final PdfName IMPORTDATA = new PdfName("ImportData");
    public static final PdfName INDEX = new PdfName("Index");
    public static final PdfName INDEXED = new PdfName("Indexed");
    public static final PdfName INFO = new PdfName("Info");
    public static final PdfName INK = new PdfName("Ink");
    public static final PdfName INKLIST = new PdfName("InkList");
    public static final PdfName INSTANCES = new PdfName("Instances");
    public static final PdfName INTENT = new PdfName("Intent");
    public static final PdfName INTERPOLATE = new PdfName("Interpolate");
    public static final PdfName IRT = new PdfName("IRT");
    public static final PdfName ISMAP = new PdfName("IsMap");
    public static final PdfName ITALICANGLE = new PdfName("ItalicAngle");
    public static final PdfName ITXT = new PdfName("ITXT");

    /* renamed from: IX */
    public static final PdfName f689IX = new PdfName("IX");
    public static final PdfName JAVASCRIPT = new PdfName(HtmlTags.JAVASCRIPT);
    public static final PdfName JBIG2DECODE = new PdfName("JBIG2Decode");
    public static final PdfName JBIG2GLOBALS = new PdfName("JBIG2Globals");
    public static final PdfName JPXDECODE = new PdfName("JPXDecode");

    /* renamed from: JS */
    public static final PdfName f690JS = new PdfName("JS");

    /* renamed from: K */
    public static final PdfName f691K = new PdfName("K");
    public static final PdfName KEYWORDS = new PdfName("Keywords");
    public static final PdfName KIDS = new PdfName("Kids");

    /* renamed from: L */
    public static final PdfName f692L = new PdfName("L");
    public static final PdfName L2R = new PdfName("L2R");
    public static final PdfName LANG = new PdfName("Lang");
    public static final PdfName LANGUAGE = new PdfName("Language");
    public static final PdfName LAST = new PdfName("Last");
    public static final PdfName LASTCHAR = new PdfName("LastChar");
    public static final PdfName LASTPAGE = new PdfName("LastPage");
    public static final PdfName LAUNCH = new PdfName("Launch");
    public static final PdfName LBL = new PdfName("Lbl");
    public static final PdfName LBODY = new PdfName("LBody");
    public static final PdfName LENGTH = new PdfName("Length");
    public static final PdfName LENGTH1 = new PdfName("Length1");

    /* renamed from: LI */
    public static final PdfName f693LI = new PdfName("LI");
    public static final PdfName LIMITS = new PdfName("Limits");
    public static final PdfName LINE = new PdfName("Line");
    public static final PdfName LINEAR = new PdfName("Linear");
    public static final PdfName LINK = new PdfName(HttpHeaders.LINK);
    public static final PdfName LISTMODE = new PdfName("ListMode");
    public static final PdfName LOCATION = new PdfName("Location");
    public static final PdfName LOCK = new PdfName("Lock");
    public static final PdfName LOCKED = new PdfName("Locked");
    public static final PdfName LZWDECODE = new PdfName("LZWDecode");

    /* renamed from: M */
    public static final PdfName f694M = new PdfName("M");
    public static final PdfName MAC_EXPERT_ENCODING = new PdfName("MacExpertEncoding");
    public static final PdfName MAC_ROMAN_ENCODING = new PdfName("MacRomanEncoding");
    public static final PdfName MARKED = new PdfName("Marked");
    public static final PdfName MARKINFO = new PdfName("MarkInfo");
    public static final PdfName MASK = new PdfName("Mask");
    public static final PdfName MATERIAL = new PdfName("Material");
    public static final PdfName MATRIX = new PdfName("Matrix");
    public static final PdfName MAXLEN = new PdfName("MaxLen");
    public static final PdfName MAX_CAMEL_CASE = new PdfName("Max");
    public static final PdfName MAX_LOWER_CASE = new PdfName("max");
    public static final PdfName MCID = new PdfName("MCID");
    public static final PdfName MCR = new PdfName("MCR");
    public static final PdfName MEDIABOX = new PdfName("MediaBox");
    public static final PdfName METADATA = new PdfName("Metadata");
    public static final PdfName MIN_CAMEL_CASE = new PdfName("Min");
    public static final PdfName MIN_LOWER_CASE = new PdfName("min");

    /* renamed from: MK */
    public static final PdfName f695MK = new PdfName("MK");
    public static final PdfName MMTYPE1 = new PdfName("MMType1");
    public static final PdfName MODDATE = new PdfName("ModDate");

    /* renamed from: N */
    public static final PdfName f696N = new PdfName("N");

    /* renamed from: N0 */
    public static final PdfName f697N0 = new PdfName("n0");

    /* renamed from: N1 */
    public static final PdfName f698N1 = new PdfName("n1");

    /* renamed from: N2 */
    public static final PdfName f699N2 = new PdfName("n2");

    /* renamed from: N3 */
    public static final PdfName f700N3 = new PdfName("n3");

    /* renamed from: N4 */
    public static final PdfName f701N4 = new PdfName("n4");
    public static final PdfName NAME = new PdfName("Name");
    public static final PdfName NAMED = new PdfName("Named");
    public static final PdfName NAMES = new PdfName("Names");
    public static final PdfName NAVIGATION = new PdfName("Navigation");
    public static final PdfName NAVIGATIONPANE = new PdfName("NavigationPane");
    public static final PdfName NEAR = new PdfName("Near");
    public static final PdfName NEEDAPPEARANCES = new PdfName("NeedAppearances");
    public static final PdfName NEWWINDOW = new PdfName("NewWindow");
    public static final PdfName NEXT = new PdfName("Next");
    public static final PdfName NEXTPAGE = new PdfName("NextPage");

    /* renamed from: NM */
    public static final PdfName f702NM = new PdfName("NM");
    public static final PdfName NONE = new PdfName(Constants.STR_NONE);
    public static final PdfName NONFULLSCREENPAGEMODE = new PdfName("NonFullScreenPageMode");
    public static final PdfName NONSTRUCT = new PdfName("NonStruct");
    public static final PdfName NOTE = new PdfName("Note");
    public static final PdfName NUMCOPIES = new PdfName("NumCopies");
    public static final PdfName NUMS = new PdfName("Nums");

    /* renamed from: O */
    public static final PdfName f703O = new PdfName("O");
    public static final PdfName OBJ = new PdfName("Obj");
    public static final PdfName OBJR = new PdfName("OBJR");
    public static final PdfName OBJSTM = new PdfName("ObjStm");

    /* renamed from: OC */
    public static final PdfName f704OC = new PdfName("OC");
    public static final PdfName OCG = new PdfName("OCG");
    public static final PdfName OCGS = new PdfName("OCGs");
    public static final PdfName OCMD = new PdfName("OCMD");
    public static final PdfName OCPROPERTIES = new PdfName("OCProperties");
    public static final PdfName OFF = new PdfName("OFF");

    /* renamed from: ON */
    public static final PdfName f705ON = new PdfName("ON");
    public static final PdfName ONECOLUMN = new PdfName("OneColumn");

    /* renamed from: OP */
    public static final PdfName f706OP = new PdfName("OP");
    public static final PdfName OPEN = new PdfName("Open");
    public static final PdfName OPENACTION = new PdfName("OpenAction");
    public static final PdfName OPM = new PdfName("OPM");
    public static final PdfName OPT = new PdfName("Opt");
    public static final PdfName ORDER = new PdfName("Order");
    public static final PdfName ORDERING = new PdfName("Ordering");
    public static final PdfName OSCILLATING = new PdfName("Oscillating");
    public static final PdfName OUTLINES = new PdfName("Outlines");
    public static final PdfName OUTPUTCONDITION = new PdfName("OutputCondition");
    public static final PdfName OUTPUTCONDITIONIDENTIFIER = new PdfName("OutputConditionIdentifier");
    public static final PdfName OUTPUTINTENT = new PdfName("OutputIntent");
    public static final PdfName OUTPUTINTENTS = new PdfName("OutputIntents");
    public static final PdfName Off = new PdfName("Off");

    /* renamed from: P */
    public static final PdfName f707P = new PdfName("P");
    public static final PdfName PAGE = new PdfName("Page");
    public static final PdfName PAGELABELS = new PdfName("PageLabels");
    public static final PdfName PAGELAYOUT = new PdfName("PageLayout");
    public static final PdfName PAGEMODE = new PdfName("PageMode");
    public static final PdfName PAGES = new PdfName("Pages");
    public static final PdfName PAINTTYPE = new PdfName("PaintType");
    public static final PdfName PANOSE = new PdfName("Panose");
    public static final PdfName PARAMS = new PdfName("Params");
    public static final PdfName PARENT = new PdfName("Parent");
    public static final PdfName PARENTTREE = new PdfName("ParentTree");
    public static final PdfName PARENTTREENEXTKEY = new PdfName("ParentTreeNextKey");
    public static final PdfName PART = new PdfName("Part");
    public static final PdfName PASSCONTEXTCLICK = new PdfName("PassContextClick");
    public static final PdfName PATTERN = new PdfName("Pattern");
    public static final PdfName PATTERNTYPE = new PdfName("PatternType");

    /* renamed from: PC */
    public static final PdfName f708PC = new PdfName("PC");
    public static final PdfName PDF = new PdfName(PdfObject.TEXT_PDFDOCENCODING);
    public static final PdfName PDFDOCENCODING = new PdfName("PDFDocEncoding");
    public static final PdfName PERCEPTUAL = new PdfName("Perceptual");
    public static final PdfName PERMS = new PdfName("Perms");

    /* renamed from: PG */
    public static final PdfName f709PG = new PdfName("Pg");

    /* renamed from: PI */
    public static final PdfName f710PI = new PdfName("PI");
    public static final PdfName PICKTRAYBYPDFSIZE = new PdfName("PickTrayByPDFSize");
    public static final PdfName PLAYCOUNT = new PdfName("PlayCount");

    /* renamed from: PO */
    public static final PdfName f711PO = new PdfName("PO");
    public static final PdfName POPUP = new PdfName("Popup");
    public static final PdfName POSITION = new PdfName("Position");
    public static final PdfName PREDICTOR = new PdfName("Predictor");
    public static final PdfName PREFERRED = new PdfName("Preferred");
    public static final PdfName PRESENTATION = new PdfName("Presentation");
    public static final PdfName PRESERVERB = new PdfName("PreserveRB");
    public static final PdfName PREV = new PdfName("Prev");
    public static final PdfName PREVPAGE = new PdfName("PrevPage");
    public static final PdfName PRINT = new PdfName("Print");
    public static final PdfName PRINTAREA = new PdfName("PrintArea");
    public static final PdfName PRINTCLIP = new PdfName("PrintClip");
    public static final PdfName PRINTPAGERANGE = new PdfName("PrintPageRange");
    public static final PdfName PRINTSCALING = new PdfName("PrintScaling");
    public static final PdfName PRINTSTATE = new PdfName("PrintState");
    public static final PdfName PRIVATE = new PdfName("Private");
    public static final PdfName PROCSET = new PdfName("ProcSet");
    public static final PdfName PRODUCER = new PdfName("Producer");
    public static final PdfName PROPERTIES = new PdfName("Properties");

    /* renamed from: PS */
    public static final PdfName f712PS = new PdfName("PS");
    public static final PdfName PUBSEC = new PdfName("Adobe.PubSec");

    /* renamed from: PV */
    public static final PdfName f713PV = new PdfName("PV");

    /* renamed from: Q */
    public static final PdfName f714Q = new PdfName("Q");
    public static final PdfName QUADPOINTS = new PdfName("QuadPoints");
    public static final PdfName QUOTE = new PdfName("Quote");

    /* renamed from: R */
    public static final PdfName f715R = new PdfName("R");
    public static final PdfName R2L = new PdfName("R2L");
    public static final PdfName RANGE = new PdfName("Range");
    public static final PdfName RBGROUPS = new PdfName("RBGroups");

    /* renamed from: RC */
    public static final PdfName f716RC = new PdfName("RC");
    public static final PdfName REASON = new PdfName("Reason");
    public static final PdfName RECIPIENTS = new PdfName("Recipients");
    public static final PdfName RECT = new PdfName("Rect");
    public static final PdfName REFERENCE = new PdfName(AnalyticsContract.Reference.TABLE_NAME);
    public static final PdfName REGISTRY = new PdfName("Registry");
    public static final PdfName REGISTRYNAME = new PdfName("RegistryName");
    public static final PdfName RELATIVECOLORIMETRIC = new PdfName("RelativeColorimetric");
    public static final PdfName RENDITION = new PdfName("Rendition");
    public static final PdfName RESETFORM = new PdfName("ResetForm");
    public static final PdfName RESOURCES = new PdfName("Resources");

    /* renamed from: RI */
    public static final PdfName f717RI = new PdfName("RI");
    public static final PdfName RICHMEDIA = new PdfName("RichMedia");
    public static final PdfName RICHMEDIAACTIVATION = new PdfName("RichMediaActivation");
    public static final PdfName RICHMEDIAANIMATION = new PdfName("RichMediaAnimation");
    public static final PdfName RICHMEDIACOMMAND = new PdfName("RichMediaCommand");
    public static final PdfName RICHMEDIACONFIGURATION = new PdfName("RichMediaConfiguration");
    public static final PdfName RICHMEDIACONTENT = new PdfName("RichMediaContent");
    public static final PdfName RICHMEDIADEACTIVATION = new PdfName("RichMediaDeactivation");
    public static final PdfName RICHMEDIAEXECUTE = new PdfName("RichMediaExecute");
    public static final PdfName RICHMEDIAINSTANCE = new PdfName("RichMediaInstance");
    public static final PdfName RICHMEDIAPARAMS = new PdfName("RichMediaParams");
    public static final PdfName RICHMEDIAPOSITION = new PdfName("RichMediaPosition");
    public static final PdfName RICHMEDIAPRESENTATION = new PdfName("RichMediaPresentation");
    public static final PdfName RICHMEDIASETTINGS = new PdfName("RichMediaSettings");
    public static final PdfName RICHMEDIAWINDOW = new PdfName("RichMediaWindow");
    public static final PdfName ROLEMAP = new PdfName("RoleMap");
    public static final PdfName ROOT = new PdfName("Root");
    public static final PdfName ROTATE = new PdfName("Rotate");
    public static final PdfName ROWS = new PdfName("Rows");
    public static final PdfName RUBY = new PdfName("Ruby");
    public static final PdfName RUNLENGTHDECODE = new PdfName("RunLengthDecode");

    /* renamed from: RV */
    public static final PdfName f718RV = new PdfName("RV");

    /* renamed from: S */
    public static final PdfName f719S = new PdfName(ExifInterface.LATITUDE_SOUTH);
    public static final PdfName SATURATION = new PdfName(ExifInterface.TAG_SATURATION);
    public static final PdfName SCHEMA = new PdfName("Schema");
    public static final PdfName SCREEN = new PdfName("Screen");
    public static final PdfName SCRIPTS = new PdfName("Scripts");
    public static final PdfName SECT = new PdfName("Sect");
    public static final PdfName SEPARATION = new PdfName("Separation");
    public static final PdfName SETOCGSTATE = new PdfName("SetOCGState");
    public static final PdfName SETTINGS = new PdfName("Settings");
    public static final PdfName SHADING = new PdfName("Shading");
    public static final PdfName SHADINGTYPE = new PdfName("ShadingType");
    public static final PdfName SHIFT_JIS = new PdfName("Shift-JIS");
    public static final PdfName SIG = new PdfName("Sig");
    public static final PdfName SIGFLAGS = new PdfName("SigFlags");
    public static final PdfName SIGREF = new PdfName("SigRef");
    public static final PdfName SIMPLEX = new PdfName("Simplex");
    public static final PdfName SINGLEPAGE = new PdfName("SinglePage");
    public static final PdfName SIZE = new PdfName("Size");
    public static final PdfName SMASK = new PdfName("SMask");
    public static final PdfName SORT = new PdfName("Sort");
    public static final PdfName SOUND = new PdfName("Sound");
    public static final PdfName SPAN = new PdfName("Span");
    public static final PdfName SPEED = new PdfName("Speed");
    public static final PdfName SPLIT = new PdfName("Split");
    public static final PdfName SQUARE = new PdfName("Square");
    public static final PdfName SQUIGGLY = new PdfName("Squiggly");

    /* renamed from: ST */
    public static final PdfName f720ST = new PdfName("St");
    public static final PdfName STAMP = new PdfName("Stamp");
    public static final PdfName STANDARD = new PdfName("Standard");
    public static final PdfName STATE = new PdfName("State");
    public static final PdfName STDCF = new PdfName("StdCF");
    public static final PdfName STEMV = new PdfName("StemV");
    public static final PdfName STMF = new PdfName("StmF");
    public static final PdfName STRF = new PdfName("StrF");
    public static final PdfName STRIKEOUT = new PdfName("StrikeOut");
    public static final PdfName STRUCTPARENT = new PdfName("StructParent");
    public static final PdfName STRUCTPARENTS = new PdfName("StructParents");
    public static final PdfName STRUCTTREEROOT = new PdfName("StructTreeRoot");
    public static final PdfName STYLE = new PdfName("Style");
    public static final PdfName SUBFILTER = new PdfName("SubFilter");
    public static final PdfName SUBJECT = new PdfName("Subject");
    public static final PdfName SUBMITFORM = new PdfName("SubmitForm");
    public static final PdfName SUBTYPE = new PdfName("Subtype");
    public static final PdfName SUPPLEMENT = new PdfName("Supplement");

    /* renamed from: SV */
    public static final PdfName f721SV = new PdfName("SV");

    /* renamed from: SW */
    public static final PdfName f722SW = new PdfName("SW");
    public static final PdfName SYMBOL = new PdfName("Symbol");

    /* renamed from: T */
    public static final PdfName f723T = new PdfName(ExifInterface.GPS_DIRECTION_TRUE);

    /* renamed from: TA */
    public static final PdfName f724TA = new PdfName("TA");
    public static final PdfName TABLE = new PdfName("Table");
    public static final PdfName TABLEROW = new PdfName("TR");
    public static final PdfName TABS = new PdfName("Tabs");
    public static final PdfName TBODY = new PdfName("TBody");

    /* renamed from: TD */
    public static final PdfName f725TD = new PdfName("TD");
    public static final PdfName TEXT = new PdfName("Text");
    public static final PdfName TFOOT = new PdfName("TFoot");

    /* renamed from: TH */
    public static final PdfName f726TH = new PdfName("TH");
    public static final PdfName THEAD = new PdfName("THead");
    public static final PdfName THREADS = new PdfName("Threads");
    public static final PdfName THUMB = new PdfName("Thumb");

    /* renamed from: TI */
    public static final PdfName f727TI = new PdfName("TI");
    public static final PdfName TILINGTYPE = new PdfName("TilingType");
    public static final PdfName TIME = new PdfName("Time");
    public static final PdfName TIMES_BOLD = new PdfName("Times-Bold");
    public static final PdfName TIMES_BOLDITALIC = new PdfName("Times-BoldItalic");
    public static final PdfName TIMES_ITALIC = new PdfName("Times-Italic");
    public static final PdfName TIMES_ROMAN = new PdfName("Times-Roman");
    public static final PdfName TITLE = new PdfName("Title");

    /* renamed from: TK */
    public static final PdfName f728TK = new PdfName("TK");

    /* renamed from: TM */
    public static final PdfName f729TM = new PdfName("TM");
    public static final PdfName TOC = new PdfName("TOC");
    public static final PdfName TOCI = new PdfName("TOCI");
    public static final PdfName TOGGLE = new PdfName("Toggle");
    public static final PdfName TOOLBAR = new PdfName("Toolbar");
    public static final PdfName TOUNICODE = new PdfName("ToUnicode");

    /* renamed from: TP */
    public static final PdfName f730TP = new PdfName("TP");
    public static final PdfName TRANS = new PdfName("Trans");
    public static final PdfName TRANSFORMMETHOD = new PdfName("TransformMethod");
    public static final PdfName TRANSFORMPARAMS = new PdfName("TransformParams");
    public static final PdfName TRANSPARENCY = new PdfName("Transparency");
    public static final PdfName TRANSPARENT = new PdfName("Transparent");
    public static final PdfName TRAPPED = new PdfName("Trapped");
    public static final PdfName TRIMBOX = new PdfName("TrimBox");
    public static final PdfName TRUETYPE = new PdfName("TrueType");

    /* renamed from: TU */
    public static final PdfName f731TU = new PdfName("TU");
    public static final PdfName TWOCOLUMNLEFT = new PdfName("TwoColumnLeft");
    public static final PdfName TWOCOLUMNRIGHT = new PdfName("TwoColumnRight");
    public static final PdfName TWOPAGELEFT = new PdfName("TwoPageLeft");
    public static final PdfName TWOPAGERIGHT = new PdfName("TwoPageRight");

    /* renamed from: TX */
    public static final PdfName f732TX = new PdfName("Tx");
    public static final PdfName TYPE = new PdfName("Type");
    public static final PdfName TYPE0 = new PdfName("Type0");
    public static final PdfName TYPE1 = new PdfName("Type1");
    public static final PdfName TYPE3 = new PdfName("Type3");

    /* renamed from: U */
    public static final PdfName f733U = new PdfName("U");

    /* renamed from: UF */
    public static final PdfName f734UF = new PdfName("UF");
    public static final PdfName UHC = new PdfName("UHC");
    public static final PdfName UNDERLINE = new PdfName("Underline");

    /* renamed from: UR */
    public static final PdfName f735UR = new PdfName("UR");
    public static final PdfName UR3 = new PdfName("UR3");
    public static final PdfName URI = new PdfName("URI");
    public static final PdfName URL = new PdfName("URL");
    public static final PdfName USAGE = new PdfName("Usage");
    public static final PdfName USEATTACHMENTS = new PdfName("UseAttachments");
    public static final PdfName USENONE = new PdfName("UseNone");
    public static final PdfName USEOC = new PdfName("UseOC");
    public static final PdfName USEOUTLINES = new PdfName("UseOutlines");
    public static final PdfName USER = new PdfName("User");
    public static final PdfName USERPROPERTIES = new PdfName("UserProperties");
    public static final PdfName USERUNIT = new PdfName("UserUnit");
    public static final PdfName USETHUMBS = new PdfName("UseThumbs");

    /* renamed from: V */
    public static final PdfName f736V = new PdfName(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);

    /* renamed from: V2 */
    public static final PdfName f737V2 = new PdfName("V2");
    public static final PdfName VALIGN = new PdfName("VAlign");
    public static final PdfName VERISIGN_PPKVS = new PdfName("VeriSign.PPKVS");
    public static final PdfName VERSION = new PdfName("Version");
    public static final PdfName VIDEO = new PdfName("Video");
    public static final PdfName VIEW = new PdfName("View");
    public static final PdfName VIEWAREA = new PdfName("ViewArea");
    public static final PdfName VIEWCLIP = new PdfName("ViewClip");
    public static final PdfName VIEWERPREFERENCES = new PdfName("ViewerPreferences");
    public static final PdfName VIEWS = new PdfName("Views");
    public static final PdfName VIEWSTATE = new PdfName("ViewState");
    public static final PdfName VISIBLEPAGES = new PdfName("VisiblePages");
    public static final PdfName VOFFSET = new PdfName("VOffset");

    /* renamed from: W */
    public static final PdfName f738W = new PdfName(ExifInterface.LONGITUDE_WEST);

    /* renamed from: W2 */
    public static final PdfName f739W2 = new PdfName("W2");
    public static final PdfName WARICHU = new PdfName("Warichu");

    /* renamed from: WC */
    public static final PdfName f740WC = new PdfName("WC");
    public static final PdfName WHITEPOINT = new PdfName(ExifInterface.TAG_WHITE_POINT);
    public static final PdfName WIDGET = new PdfName("Widget");
    public static final PdfName WIDTH = new PdfName("Width");
    public static final PdfName WIDTHS = new PdfName("Widths");
    public static final PdfName WIN = new PdfName("Win");
    public static final PdfName WINDOW = new PdfName("Window");
    public static final PdfName WINDOWED = new PdfName("Windowed");
    public static final PdfName WIN_ANSI_ENCODING = new PdfName("WinAnsiEncoding");
    public static final PdfName WIPE = new PdfName("Wipe");

    /* renamed from: WP */
    public static final PdfName f741WP = new PdfName("WP");

    /* renamed from: WS */
    public static final PdfName f742WS = new PdfName("WS");

    /* renamed from: X */
    public static final PdfName f743X = new PdfName("X");

    /* renamed from: XA */
    public static final PdfName f744XA = new PdfName("XA");

    /* renamed from: XD */
    public static final PdfName f745XD = new PdfName("XD");
    public static final PdfName XFA = new PdfName("XFA");
    public static final PdfName XML = new PdfName("XML");
    public static final PdfName XOBJECT = new PdfName("XObject");
    public static final PdfName XREF = new PdfName("XRef");
    public static final PdfName XREFSTM = new PdfName("XRefStm");
    public static final PdfName XSTEP = new PdfName("XStep");
    public static final PdfName XYZ = new PdfName("XYZ");
    public static final PdfName YSTEP = new PdfName("YStep");
    public static final PdfName ZADB = new PdfName("ZaDb");
    public static final PdfName ZAPFDINGBATS = new PdfName("ZapfDingbats");
    public static final PdfName ZOOM = new PdfName("Zoom");
    public static final PdfName _3D = new PdfName("3D");

    /* renamed from: ca */
    public static final PdfName f746ca = new PdfName("ca");

    /* renamed from: op */
    public static final PdfName f747op = new PdfName("op");
    public static Map staticNames;
    private int hash;

    static {
        Field[] declaredFields = PdfName.class.getDeclaredFields();
        staticNames = new HashMap(declaredFields.length);
        int i = 0;
        while (i < declaredFields.length) {
            try {
                Field field = declaredFields[i];
                if ((field.getModifiers() & 25) == 25 && field.getType().equals(PdfName.class)) {
                    PdfName pdfName = (PdfName) field.get((Object) null);
                    staticNames.put(decodeName(pdfName.toString()), pdfName);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public PdfName(String str) {
        this(str, true);
    }

    public PdfName(String str, boolean z) {
        super(4);
        this.hash = 0;
        int length = str.length();
        if (!z || length <= 127) {
            this.bytes = encodeName(str);
            return;
        }
        throw new IllegalArgumentException("The name '" + str + "' is too long (" + length + " characters).");
    }

    public PdfName(byte[] bArr) {
        super(4, bArr);
        this.hash = 0;
    }

    public int compareTo(Object obj) {
        byte[] bArr = this.bytes;
        byte[] bArr2 = ((PdfName) obj).bytes;
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            if (bArr[i] > bArr2[i]) {
                return 1;
            }
            if (bArr[i] < bArr2[i]) {
                return -1;
            }
        }
        if (bArr.length < bArr2.length) {
            return -1;
        }
        return bArr.length > bArr2.length ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PdfName) && compareTo(obj) == 0;
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int length = this.bytes.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                i = (i * 31) + (this.bytes[i3] & 255);
                i2++;
                i3++;
            }
            this.hash = i;
        }
        return i;
    }

    public static byte[] encodeName(String str) {
        int length = str.length();
        ByteBuffer byteBuffer = new ByteBuffer(length + 20);
        byteBuffer.append('/');
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            char c = (char) (charArray[i] & 255);
            if (c == ' ' || c == '#' || c == '%' || c == '/' || c == '<' || c == '>' || c == '[' || c == ']' || c == '{' || c == '}' || c == '(' || c == ')') {
                byteBuffer.append('#');
                byteBuffer.append(Integer.toString(c, 16));
            } else if (c < ' ' || c > '~') {
                byteBuffer.append('#');
                if (c < 16) {
                    byteBuffer.append('0');
                }
                byteBuffer.append(Integer.toString(c, 16));
            } else {
                byteBuffer.append(c);
            }
        }
        return byteBuffer.toByteArray();
    }

    public static String decodeName(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            int length = str.length();
            int i = 1;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt == '#') {
                    char charAt2 = str.charAt(i + 1);
                    i += 2;
                    charAt = (char) ((PRTokeniser.getHex(charAt2) << 4) + PRTokeniser.getHex(str.charAt(i)));
                }
                stringBuffer.append(charAt);
                i++;
            }
        } catch (IndexOutOfBoundsException unused) {
        }
        return stringBuffer.toString();
    }
}
