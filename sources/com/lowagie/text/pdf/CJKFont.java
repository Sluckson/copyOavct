package com.lowagie.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;

class CJKFont extends BaseFont {
    private static final int BRACKET = 1;
    static final String CJK_ENCODING = "UnicodeBigUnmarked";
    private static final int FIRST = 0;
    private static final int SERIAL = 2;
    private static final int V1Y = 880;
    static Hashtable allCMaps = new Hashtable();
    static Hashtable allFonts = new Hashtable();
    static Properties cjkEncodings = new Properties();
    static Properties cjkFonts = new Properties();
    private static boolean propertiesLoaded = false;
    private String CMap;
    private boolean cidDirect;
    private HashMap fontDesc;
    private String fontName;
    private IntHashtable hMetrics;
    private String style = "";
    private char[] translationMap;
    private IntHashtable vMetrics;
    private boolean vertical;

    public int[] getCharBBox(int i) {
        return null;
    }

    public PdfStream getFullFontStream() {
        return null;
    }

    public int getKerning(int i, int i2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int[] getRawCharBBox(int i, String str) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getRawWidth(int i, String str) {
        return 0;
    }

    public boolean hasKernPairs() {
        return false;
    }

    public boolean setCharAdvance(int i, int i2) {
        return false;
    }

    public boolean setKerning(int i, int i2, int i3) {
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:10|11|12|13|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void loadProperties() {
        /*
            boolean r0 = propertiesLoaded
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.util.Hashtable r0 = allFonts
            monitor-enter(r0)
            boolean r1 = propertiesLoaded     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x000e:
            java.lang.String r1 = "com/lowagie/text/pdf/fonts/cjkfonts.properties"
            java.io.InputStream r1 = getResourceStream(r1)     // Catch:{ Exception -> 0x002b }
            java.util.Properties r2 = cjkFonts     // Catch:{ Exception -> 0x002b }
            r2.load(r1)     // Catch:{ Exception -> 0x002b }
            r1.close()     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = "com/lowagie/text/pdf/fonts/cjkencodings.properties"
            java.io.InputStream r1 = getResourceStream(r1)     // Catch:{ Exception -> 0x002b }
            java.util.Properties r2 = cjkEncodings     // Catch:{ Exception -> 0x002b }
            r2.load(r1)     // Catch:{ Exception -> 0x002b }
            r1.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x0039
        L_0x002b:
            java.util.Properties r1 = new java.util.Properties     // Catch:{ all -> 0x003e }
            r1.<init>()     // Catch:{ all -> 0x003e }
            cjkFonts = r1     // Catch:{ all -> 0x003e }
            java.util.Properties r1 = new java.util.Properties     // Catch:{ all -> 0x003e }
            r1.<init>()     // Catch:{ all -> 0x003e }
            cjkEncodings = r1     // Catch:{ all -> 0x003e }
        L_0x0039:
            r1 = 1
            propertiesLoaded = r1     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x003e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.CJKFont.loadProperties():void");
    }

    CJKFont(String str, String str2, boolean z) throws DocumentException {
        this.cidDirect = false;
        this.vertical = false;
        loadProperties();
        this.fontType = 2;
        String baseName = getBaseName(str);
        if (isCJKFont(baseName, str2)) {
            if (baseName.length() < str.length()) {
                this.style = str.substring(baseName.length());
                str = baseName;
            }
            this.fontName = str;
            this.encoding = CJK_ENCODING;
            this.vertical = str2.endsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            this.CMap = str2;
            if (str2.startsWith("Identity-")) {
                this.cidDirect = true;
                String property = cjkFonts.getProperty(str);
                String substring = property.substring(0, property.indexOf(95));
                char[] cArr = (char[]) allCMaps.get(substring);
                if (cArr == null) {
                    cArr = readCMap(substring);
                    if (cArr != null) {
                        cArr[32767] = 10;
                        allCMaps.put(substring, cArr);
                    } else {
                        throw new DocumentException("The cmap " + substring + " does not exist as a resource.");
                    }
                }
                this.translationMap = cArr;
            } else {
                char[] cArr2 = (char[]) allCMaps.get(str2);
                if (cArr2 == null) {
                    String property2 = cjkEncodings.getProperty(str2);
                    if (property2 != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(property2);
                        String nextToken = stringTokenizer.nextToken();
                        char[] cArr3 = (char[]) allCMaps.get(nextToken);
                        if (cArr3 == null) {
                            cArr3 = readCMap(nextToken);
                            allCMaps.put(nextToken, cArr3);
                        }
                        cArr2 = cArr3;
                        if (stringTokenizer.hasMoreTokens()) {
                            char[] readCMap = readCMap(stringTokenizer.nextToken());
                            for (int i = 0; i < 65536; i++) {
                                if (readCMap[i] == 0) {
                                    readCMap[i] = cArr2[i];
                                }
                            }
                            allCMaps.put(str2, readCMap);
                            cArr2 = readCMap;
                        }
                    } else {
                        throw new DocumentException("The resource cjkencodings.properties does not contain the encoding " + str2);
                    }
                }
                this.translationMap = cArr2;
            }
            this.fontDesc = (HashMap) allFonts.get(str);
            if (this.fontDesc == null) {
                this.fontDesc = readFontProperties(str);
                allFonts.put(str, this.fontDesc);
            }
            this.hMetrics = (IntHashtable) this.fontDesc.get(ExifInterface.LONGITUDE_WEST);
            this.vMetrics = (IntHashtable) this.fontDesc.get("W2");
            return;
        }
        throw new DocumentException("Font '" + str + "' with '" + str2 + "' encoding is not a CJK font.");
    }

    public static boolean isCJKFont(String str, String str2) {
        loadProperties();
        String property = cjkFonts.getProperty(str);
        if (property == null) {
            return false;
        }
        if (str2.equals(BaseFont.IDENTITY_H) || str2.equals(BaseFont.IDENTITY_V)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("_");
        sb.append(str2);
        sb.append("_");
        return property.indexOf(sb.toString()) >= 0;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r2v0 ?, r2v1 ?, r2v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public int getWidth(
/*
Method generation error in method: com.lowagie.text.pdf.CJKFont.getWidth(int):int, dex: classes3.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/

    public int getWidth(String str) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (!this.cidDirect) {
                charAt = this.translationMap[charAt];
            }
            if (this.vertical) {
                i = this.vMetrics.get(charAt);
            } else {
                i = this.hMetrics.get(charAt);
            }
            i2 = i > 0 ? i2 + i : i2 + 1000;
        }
        return i2;
    }

    private PdfDictionary getFontDescriptor() {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfLiteral((String) this.fontDesc.get("Ascent")));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfLiteral((String) this.fontDesc.get("CapHeight")));
        pdfDictionary.put(PdfName.DESCENT, new PdfLiteral((String) this.fontDesc.get("Descent")));
        pdfDictionary.put(PdfName.FLAGS, new PdfLiteral((String) this.fontDesc.get("Flags")));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfLiteral((String) this.fontDesc.get("FontBBox")));
        PdfName pdfName = PdfName.FONTNAME;
        pdfDictionary.put(pdfName, new PdfName(String.valueOf(this.fontName) + this.style));
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfLiteral((String) this.fontDesc.get("ItalicAngle")));
        pdfDictionary.put(PdfName.STEMV, new PdfLiteral((String) this.fontDesc.get("StemV")));
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.put(PdfName.PANOSE, new PdfString((String) this.fontDesc.get("Panose"), (String) null));
        pdfDictionary.put(PdfName.STYLE, pdfDictionary2);
        return pdfDictionary;
    }

    private PdfDictionary getCIDFont(PdfIndirectReference pdfIndirectReference, IntHashtable intHashtable) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.CIDFONTTYPE0);
        PdfName pdfName = PdfName.BASEFONT;
        pdfDictionary.put(pdfName, new PdfName(String.valueOf(this.fontName) + this.style));
        pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        int[] orderedKeys = intHashtable.toOrderedKeys();
        String convertToHCIDMetrics = convertToHCIDMetrics(orderedKeys, this.hMetrics);
        if (convertToHCIDMetrics != null) {
            pdfDictionary.put(PdfName.f738W, new PdfLiteral(convertToHCIDMetrics));
        }
        if (this.vertical) {
            String convertToVCIDMetrics = convertToVCIDMetrics(orderedKeys, this.vMetrics, this.hMetrics);
            if (convertToVCIDMetrics != null) {
                pdfDictionary.put(PdfName.f739W2, new PdfLiteral(convertToVCIDMetrics));
            }
        } else {
            pdfDictionary.put(PdfName.f670DW, new PdfNumber(1000));
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.put(PdfName.REGISTRY, new PdfString((String) this.fontDesc.get("Registry"), (String) null));
        pdfDictionary2.put(PdfName.ORDERING, new PdfString((String) this.fontDesc.get("Ordering"), (String) null));
        pdfDictionary2.put(PdfName.SUPPLEMENT, new PdfLiteral((String) this.fontDesc.get("Supplement")));
        pdfDictionary.put(PdfName.CIDSYSTEMINFO, pdfDictionary2);
        return pdfDictionary;
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE0);
        String str = this.fontName;
        if (this.style.length() > 0) {
            str = String.valueOf(str) + "-" + this.style.substring(1);
        }
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(String.valueOf(str) + "-" + this.CMap));
        pdfDictionary.put(PdfName.ENCODING, new PdfName(this.CMap));
        pdfDictionary.put(PdfName.DESCENDANTFONTS, new PdfArray((PdfObject) pdfIndirectReference));
        return pdfDictionary;
    }

    /* access modifiers changed from: package-private */
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        IntHashtable intHashtable = objArr[0];
        PdfDictionary fontDescriptor = getFontDescriptor();
        PdfIndirectReference indirectReference = fontDescriptor != null ? pdfWriter.addToBody(fontDescriptor).getIndirectReference() : null;
        PdfDictionary cIDFont = getCIDFont(indirectReference, intHashtable);
        if (cIDFont != null) {
            indirectReference = pdfWriter.addToBody(cIDFont).getIndirectReference();
        }
        pdfWriter.addToBody((PdfObject) getFontBaseType(indirectReference), pdfIndirectReference);
    }

    private float getDescNumber(String str) {
        return (float) Integer.parseInt((String) this.fontDesc.get(str));
    }

    private float getBBox(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer((String) this.fontDesc.get("FontBBox"), " []\r\n\t\f");
        String nextToken = stringTokenizer.nextToken();
        for (int i2 = 0; i2 < i; i2++) {
            nextToken = stringTokenizer.nextToken();
        }
        return (float) Integer.parseInt(nextToken);
    }

    public float getFontDescriptor(int i, float f) {
        float bBox;
        switch (i) {
            case 1:
            case 9:
                return (getDescNumber("Ascent") * f) / 1000.0f;
            case 2:
                return (getDescNumber("CapHeight") * f) / 1000.0f;
            case 3:
            case 10:
                return (getDescNumber("Descent") * f) / 1000.0f;
            case 4:
                return getDescNumber("ItalicAngle");
            case 5:
                bBox = getBBox(0);
                break;
            case 6:
                bBox = getBBox(1);
                break;
            case 7:
                bBox = getBBox(2);
                break;
            case 8:
                bBox = getBBox(3);
                break;
            case 11:
                return 0.0f;
            case 12:
                bBox = getBBox(2) - getBBox(0);
                break;
            default:
                return 0.0f;
        }
        return (f * bBox) / 1000.0f;
    }

    public String getPostscriptFontName() {
        return this.fontName;
    }

    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.fontName}};
    }

    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.fontName}};
    }

    public String[][] getFamilyFontName() {
        return getFullFontName();
    }

    static char[] readCMap(String str) {
        try {
            InputStream resourceStream = getResourceStream(BaseFont.RESOURCE_PATH + (String.valueOf(str) + ".cmap"));
            char[] cArr = new char[65536];
            for (int i = 0; i < 65536; i++) {
                cArr[i] = (char) ((resourceStream.read() << 8) + resourceStream.read());
            }
            resourceStream.close();
            return cArr;
        } catch (Exception unused) {
            return null;
        }
    }

    static IntHashtable createMetric(String str) {
        IntHashtable intHashtable = new IntHashtable();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            intHashtable.put(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
        return intHashtable;
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String convertToHCIDMetrics(int[] r13, com.lowagie.text.pdf.IntHashtable r14) {
        /*
            int r0 = r13.length
            r1 = 0
            if (r0 != 0) goto L_0x0005
            return r1
        L_0x0005:
            r0 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0009:
            int r5 = r13.length
            if (r2 < r5) goto L_0x000d
            goto L_0x0017
        L_0x000d:
            r3 = r13[r2]
            int r4 = r14.get(r3)
            if (r4 == 0) goto L_0x00d5
            int r2 = r2 + 1
        L_0x0017:
            if (r4 != 0) goto L_0x001a
            return r1
        L_0x001a:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
            r6 = 91
            r5.append(r6)
            r5.append(r3)
            r1 = 0
        L_0x0028:
            int r7 = r13.length
            r8 = 93
            r9 = 2
            r10 = 32
            r11 = 1
            if (r2 < r7) goto L_0x0062
            java.lang.String r13 = "]]"
            if (r1 == 0) goto L_0x0054
            if (r1 == r11) goto L_0x004a
            if (r1 == r9) goto L_0x003a
            goto L_0x005d
        L_0x003a:
            r5.append(r10)
            r5.append(r3)
            r5.append(r10)
            r5.append(r4)
            r5.append(r8)
            goto L_0x005d
        L_0x004a:
            r5.append(r10)
            r5.append(r4)
            r5.append(r13)
            goto L_0x005d
        L_0x0054:
            r5.append(r6)
            r5.append(r4)
            r5.append(r13)
        L_0x005d:
            java.lang.String r13 = r5.toString()
            return r13
        L_0x0062:
            r7 = r13[r2]
            int r12 = r14.get(r7)
            if (r12 != 0) goto L_0x006c
            goto L_0x00d1
        L_0x006c:
            if (r1 == 0) goto L_0x00b0
            if (r1 == r11) goto L_0x008d
            if (r1 == r9) goto L_0x0073
            goto L_0x00cd
        L_0x0073:
            int r8 = r3 + 1
            if (r7 != r8) goto L_0x0079
            if (r12 == r4) goto L_0x00cd
        L_0x0079:
            r5.append(r10)
            r5.append(r3)
            r5.append(r10)
            r5.append(r4)
            r5.append(r10)
            r5.append(r7)
        L_0x008b:
            r9 = 0
            goto L_0x00ce
        L_0x008d:
            int r11 = r3 + 1
            if (r7 != r11) goto L_0x009a
            if (r12 != r4) goto L_0x009a
            r5.append(r8)
            r5.append(r3)
            goto L_0x00ce
        L_0x009a:
            if (r7 != r11) goto L_0x00a3
            r5.append(r10)
            r5.append(r4)
            goto L_0x00cd
        L_0x00a3:
            r5.append(r10)
            r5.append(r4)
            r5.append(r8)
            r5.append(r7)
            goto L_0x008b
        L_0x00b0:
            int r3 = r3 + 1
            if (r7 != r3) goto L_0x00b7
            if (r12 != r4) goto L_0x00b7
            goto L_0x00ce
        L_0x00b7:
            if (r7 != r3) goto L_0x00c1
            r5.append(r6)
            r5.append(r4)
            r9 = 1
            goto L_0x00ce
        L_0x00c1:
            r5.append(r6)
            r5.append(r4)
            r5.append(r8)
            r5.append(r7)
        L_0x00cd:
            r9 = r1
        L_0x00ce:
            r3 = r7
            r1 = r9
            r4 = r12
        L_0x00d1:
            int r2 = r2 + 1
            goto L_0x0028
        L_0x00d5:
            int r2 = r2 + 1
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.CJKFont.convertToHCIDMetrics(int[], com.lowagie.text.pdf.IntHashtable):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String convertToVCIDMetrics(int[] r17, com.lowagie.text.pdf.IntHashtable r18, com.lowagie.text.pdf.IntHashtable r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            int r3 = r0.length
            r4 = 0
            if (r3 != 0) goto L_0x000b
            return r4
        L_0x000b:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000f:
            int r9 = r0.length
            if (r5 < r9) goto L_0x0013
            goto L_0x001d
        L_0x0013:
            r8 = r0[r5]
            int r6 = r1.get(r8)
            if (r6 == 0) goto L_0x00d6
            int r5 = r5 + 1
        L_0x001d:
            if (r6 != 0) goto L_0x0020
            return r4
        L_0x0020:
            if (r7 != 0) goto L_0x0024
            r7 = 1000(0x3e8, float:1.401E-42)
        L_0x0024:
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            r4 = 91
            r10.append(r4)
            r10.append(r8)
            r4 = 0
        L_0x0032:
            int r11 = r0.length
            r12 = 880(0x370, float:1.233E-42)
            r13 = 2
            r14 = 32
            if (r5 < r11) goto L_0x005e
            r10.append(r14)
            r10.append(r8)
            r10.append(r14)
            int r0 = -r6
            r10.append(r0)
            r10.append(r14)
            int r7 = r7 / r13
            r10.append(r7)
            r10.append(r14)
            r10.append(r12)
            java.lang.String r0 = " ]"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            return r0
        L_0x005e:
            r11 = r0[r5]
            int r15 = r1.get(r11)
            if (r15 != 0) goto L_0x0068
            goto L_0x00d2
        L_0x0068:
            int r16 = r2.get(r8)
            if (r16 != 0) goto L_0x0071
            r3 = 1000(0x3e8, float:1.401E-42)
            goto L_0x0073
        L_0x0071:
            r3 = r16
        L_0x0073:
            if (r4 == 0) goto L_0x00a3
            if (r4 == r13) goto L_0x0078
            goto L_0x00cd
        L_0x0078:
            int r13 = r8 + 1
            if (r11 != r13) goto L_0x0080
            if (r15 != r6) goto L_0x0080
            if (r3 == r7) goto L_0x00cd
        L_0x0080:
            r10.append(r14)
            r10.append(r8)
            r10.append(r14)
            int r4 = -r6
            r10.append(r4)
            r10.append(r14)
            int r7 = r7 / 2
            r10.append(r7)
            r10.append(r14)
            r10.append(r12)
            r10.append(r14)
            r10.append(r11)
            r13 = 0
            goto L_0x00ce
        L_0x00a3:
            int r9 = r8 + 1
            if (r11 != r9) goto L_0x00ac
            if (r15 != r6) goto L_0x00ac
            if (r3 != r7) goto L_0x00ac
            goto L_0x00ce
        L_0x00ac:
            r10.append(r14)
            r10.append(r8)
            r10.append(r14)
            int r6 = -r6
            r10.append(r6)
            r10.append(r14)
            int r7 = r7 / 2
            r10.append(r7)
            r10.append(r14)
            r10.append(r12)
            r10.append(r14)
            r10.append(r11)
        L_0x00cd:
            r13 = r4
        L_0x00ce:
            r7 = r3
            r8 = r11
            r4 = r13
            r6 = r15
        L_0x00d2:
            int r5 = r5 + 1
            goto L_0x0032
        L_0x00d6:
            int r7 = r2.get(r8)
            int r5 = r5 + 1
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.CJKFont.convertToVCIDMetrics(int[], com.lowagie.text.pdf.IntHashtable, com.lowagie.text.pdf.IntHashtable):java.lang.String");
    }

    static HashMap readFontProperties(String str) {
        try {
            InputStream resourceStream = getResourceStream(BaseFont.RESOURCE_PATH + (String.valueOf(str) + ".properties"));
            Properties properties = new Properties();
            properties.load(resourceStream);
            resourceStream.close();
            IntHashtable createMetric = createMetric(properties.getProperty(ExifInterface.LONGITUDE_WEST));
            properties.remove(ExifInterface.LONGITUDE_WEST);
            IntHashtable createMetric2 = createMetric(properties.getProperty("W2"));
            properties.remove("W2");
            HashMap hashMap = new HashMap();
            Enumeration keys = properties.keys();
            while (keys.hasMoreElements()) {
                Object nextElement = keys.nextElement();
                hashMap.put(nextElement, properties.getProperty((String) nextElement));
            }
            hashMap.put(ExifInterface.LONGITUDE_WEST, createMetric);
            hashMap.put("W2", createMetric2);
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public int getUnicodeEquivalent(int i) {
        return this.cidDirect ? this.translationMap[i] : i;
    }

    public int getCidCode(int i) {
        if (this.cidDirect) {
            return i;
        }
        return this.translationMap[i];
    }

    public boolean charExists(int i) {
        return this.translationMap[i] != 0;
    }

    public void setPostscriptFontName(String str) {
        this.fontName = str;
    }
}
