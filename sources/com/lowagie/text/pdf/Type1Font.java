package com.lowagie.text.pdf;

import com.google.logging.type.LogSeverity;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.fonts.FontsResourceAnchor;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import java.io.IOException;
import java.util.HashMap;

class Type1Font extends BaseFont {
    private static final int[] PFB_TYPES = {1, 2, 1};
    private static FontsResourceAnchor resourceAnchor;
    private int Ascender = LogSeverity.EMERGENCY_VALUE;
    private int CapHeight = LogSeverity.ALERT_VALUE;
    private HashMap CharMetrics = new HashMap();
    private String CharacterSet;
    private int Descender = -200;
    private String EncodingScheme = "FontSpecific";
    private String FamilyName;
    private String FontName;
    private String FullName;
    private boolean IsFixedPitch = false;
    private float ItalicAngle = 0.0f;
    private HashMap KernPairs = new HashMap();
    private int StdHW;
    private int StdVW = 80;
    private int UnderlinePosition = -100;
    private int UnderlineThickness = 50;
    private String Weight = "";
    private int XHeight = WOWZMediaConfig.DEFAULT_VIDEO_FRAME_HEIGHT;
    private boolean builtinFont = false;
    private String fileName;
    private int llx = -50;
    private int lly = -200;
    protected byte[] pfb;
    private int urx = 1000;
    private int ury = WMSTransport.SESSIONSTATE_CLOSING;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:18|19|(2:20|(1:101)(2:41|42))|22|(2:24|25)|26|27|(4:28|29|30|31)) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        r4 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00bc */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d2 A[SYNTHETIC, Splitter:B:37:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fd A[SYNTHETIC, Splitter:B:50:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0199 A[SYNTHETIC, Splitter:B:95:0x0199] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Type1Font(java.lang.String r4, java.lang.String r5, boolean r6, byte[] r7, byte[] r8, boolean r9) throws com.lowagie.text.DocumentException, java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            java.lang.String r0 = ""
            r3.Weight = r0
            r0 = 0
            r3.ItalicAngle = r0
            r0 = 0
            r3.IsFixedPitch = r0
            r1 = -50
            r3.llx = r1
            r1 = -200(0xffffffffffffff38, float:NaN)
            r3.lly = r1
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.urx = r2
            r2 = 900(0x384, float:1.261E-42)
            r3.ury = r2
            r2 = -100
            r3.UnderlinePosition = r2
            r2 = 50
            r3.UnderlineThickness = r2
            java.lang.String r2 = "FontSpecific"
            r3.EncodingScheme = r2
            r2 = 700(0x2bc, float:9.81E-43)
            r3.CapHeight = r2
            r2 = 480(0x1e0, float:6.73E-43)
            r3.XHeight = r2
            r2 = 800(0x320, float:1.121E-42)
            r3.Ascender = r2
            r3.Descender = r1
            r1 = 80
            r3.StdVW = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.CharMetrics = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.KernPairs = r1
            r3.builtinFont = r0
            if (r6 == 0) goto L_0x005a
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x0052
            goto L_0x005a
        L_0x0052:
            com.lowagie.text.DocumentException r4 = new com.lowagie.text.DocumentException
            java.lang.String r5 = "Two byte arrays are needed if the Type1 font is embedded."
            r4.<init>((java.lang.String) r5)
            throw r4
        L_0x005a:
            if (r6 == 0) goto L_0x0060
            if (r7 == 0) goto L_0x0060
            r3.pfb = r8
        L_0x0060:
            r3.encoding = r5
            r3.embedded = r6
            r3.fileName = r4
            r3.fontType = r0
            java.util.HashMap r6 = BuiltinFonts14
            boolean r6 = r6.containsKey(r4)
            java.lang.String r8 = ".afm"
            r1 = 0
            if (r6 == 0) goto L_0x0101
            r3.embedded = r0
            r6 = 1
            r3.builtinFont = r6
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]
            com.lowagie.text.pdf.fonts.FontsResourceAnchor r7 = resourceAnchor     // Catch:{ all -> 0x00f9 }
            if (r7 != 0) goto L_0x0087
            com.lowagie.text.pdf.fonts.FontsResourceAnchor r7 = new com.lowagie.text.pdf.fonts.FontsResourceAnchor     // Catch:{ all -> 0x00f9 }
            r7.<init>()     // Catch:{ all -> 0x00f9 }
            resourceAnchor = r7     // Catch:{ all -> 0x00f9 }
        L_0x0087:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = "com/lowagie/text/pdf/fonts/"
            r7.<init>(r9)     // Catch:{ all -> 0x00f9 }
            r7.append(r4)     // Catch:{ all -> 0x00f9 }
            r7.append(r8)     // Catch:{ all -> 0x00f9 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f9 }
            com.lowagie.text.pdf.fonts.FontsResourceAnchor r8 = resourceAnchor     // Catch:{ all -> 0x00f9 }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x00f9 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x00f9 }
            java.io.InputStream r7 = getResourceStream(r7, r8)     // Catch:{ all -> 0x00f9 }
            if (r7 == 0) goto L_0x00dc
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00da }
            r4.<init>()     // Catch:{ all -> 0x00da }
        L_0x00ad:
            int r8 = r7.read(r6)     // Catch:{ all -> 0x00da }
            if (r8 >= 0) goto L_0x00d6
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x00da }
            if (r7 == 0) goto L_0x00bc
            r7.close()     // Catch:{ Exception -> 0x00bc }
        L_0x00bc:
            com.lowagie.text.pdf.RandomAccessFileOrArray r6 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x00cf }
            r6.<init>((byte[]) r4)     // Catch:{ all -> 0x00cf }
            r3.process(r6)     // Catch:{ all -> 0x00cc }
            r6.close()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x0161
        L_0x00c9:
            goto L_0x0161
        L_0x00cc:
            r4 = move-exception
            r1 = r6
            goto L_0x00d0
        L_0x00cf:
            r4 = move-exception
        L_0x00d0:
            if (r1 == 0) goto L_0x00d5
            r1.close()     // Catch:{ Exception -> 0x00d5 }
        L_0x00d5:
            throw r4
        L_0x00d6:
            r4.write(r6, r0, r8)     // Catch:{ all -> 0x00da }
            goto L_0x00ad
        L_0x00da:
            r4 = move-exception
            goto L_0x00fb
        L_0x00dc:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00da }
            r5.<init>(r4)     // Catch:{ all -> 0x00da }
            java.lang.String r4 = " not found as resource. (The *.afm files must exist as resources in the package com.lowagie.text.pdf.fonts)"
            r5.append(r4)     // Catch:{ all -> 0x00da }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00da }
            java.io.PrintStream r5 = java.lang.System.err     // Catch:{ all -> 0x00da }
            r5.println(r4)     // Catch:{ all -> 0x00da }
            com.lowagie.text.DocumentException r5 = new com.lowagie.text.DocumentException     // Catch:{ all -> 0x00da }
            r5.<init>((java.lang.String) r4)     // Catch:{ all -> 0x00da }
            throw r5     // Catch:{ all -> 0x00da }
        L_0x00f9:
            r4 = move-exception
            r7 = r1
        L_0x00fb:
            if (r7 == 0) goto L_0x0100
            r7.close()     // Catch:{ Exception -> 0x0100 }
        L_0x0100:
            throw r4
        L_0x0101:
            java.lang.String r6 = r4.toLowerCase()
            boolean r6 = r6.endsWith(r8)
            if (r6 == 0) goto L_0x012a
            if (r7 != 0) goto L_0x0116
            com.lowagie.text.pdf.RandomAccessFileOrArray r6 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0123 }
            boolean r7 = com.lowagie.text.Document.plainRandomAccess     // Catch:{ all -> 0x0123 }
            r6.<init>(r4, r9, r7)     // Catch:{ all -> 0x0123 }
            r1 = r6
            goto L_0x011c
        L_0x0116:
            com.lowagie.text.pdf.RandomAccessFileOrArray r4 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0123 }
            r4.<init>((byte[]) r7)     // Catch:{ all -> 0x0123 }
            r1 = r4
        L_0x011c:
            r3.process(r1)     // Catch:{ all -> 0x0123 }
            r1.close()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x0161
        L_0x0123:
            r4 = move-exception
            if (r1 == 0) goto L_0x0129
            r1.close()     // Catch:{ Exception -> 0x0129 }
        L_0x0129:
            throw r4
        L_0x012a:
            java.lang.String r6 = r4.toLowerCase()
            java.lang.String r8 = ".pfm"
            boolean r6 = r6.endsWith(r8)
            if (r6 == 0) goto L_0x019d
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0196 }
            r6.<init>()     // Catch:{ all -> 0x0196 }
            if (r7 != 0) goto L_0x0146
            com.lowagie.text.pdf.RandomAccessFileOrArray r7 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0196 }
            boolean r8 = com.lowagie.text.Document.plainRandomAccess     // Catch:{ all -> 0x0196 }
            r7.<init>(r4, r9, r8)     // Catch:{ all -> 0x0196 }
            r1 = r7
            goto L_0x014c
        L_0x0146:
            com.lowagie.text.pdf.RandomAccessFileOrArray r4 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0196 }
            r4.<init>((byte[]) r7)     // Catch:{ all -> 0x0196 }
            r1 = r4
        L_0x014c:
            com.lowagie.text.pdf.Pfm2afm.convert(r1, r6)     // Catch:{ all -> 0x0196 }
            r1.close()     // Catch:{ all -> 0x0196 }
            com.lowagie.text.pdf.RandomAccessFileOrArray r4 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0196 }
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0196 }
            r4.<init>((byte[]) r6)     // Catch:{ all -> 0x0196 }
            r3.process(r4)     // Catch:{ all -> 0x0192 }
            r4.close()     // Catch:{ Exception -> 0x00c9 }
        L_0x0161:
            java.lang.String r4 = r3.EncodingScheme
            java.lang.String r4 = r4.trim()
            r3.EncodingScheme = r4
            java.lang.String r4 = r3.EncodingScheme
            java.lang.String r6 = "AdobeStandardEncoding"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x017d
            java.lang.String r4 = r3.EncodingScheme
            java.lang.String r6 = "StandardEncoding"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x017f
        L_0x017d:
            r3.fontSpecific = r0
        L_0x017f:
            java.lang.String r4 = r3.encoding
            java.lang.String r6 = "#"
            boolean r4 = r4.startsWith(r6)
            if (r4 != 0) goto L_0x018e
            java.lang.String r4 = " "
            com.lowagie.text.pdf.PdfEncodings.convertToBytes((java.lang.String) r4, (java.lang.String) r5)
        L_0x018e:
            r3.createEncoding()
            return
        L_0x0192:
            r5 = move-exception
            r1 = r4
            r4 = r5
            goto L_0x0197
        L_0x0196:
            r4 = move-exception
        L_0x0197:
            if (r1 == 0) goto L_0x019c
            r1.close()     // Catch:{ Exception -> 0x019c }
        L_0x019c:
            throw r4
        L_0x019d:
            com.lowagie.text.DocumentException r5 = new com.lowagie.text.DocumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            java.lang.String r4 = " is not an AFM or PFM font file."
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>((java.lang.String) r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.Type1Font.<init>(java.lang.String, java.lang.String, boolean, byte[], byte[], boolean):void");
    }

    /* access modifiers changed from: package-private */
    public int getRawWidth(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = (Object[]) this.CharMetrics.get(new Integer(i));
        } else if (str.equals(BaseFont.notdef)) {
            return 0;
        } else {
            objArr = (Object[]) this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return ((Integer) objArr[1]).intValue();
        }
        return 0;
    }

    public int getKerning(int i, int i2) {
        String unicodeToName;
        Object[] objArr;
        String unicodeToName2 = GlyphList.unicodeToName(i);
        if (unicodeToName2 == null || (unicodeToName = GlyphList.unicodeToName(i2)) == null || (objArr = (Object[]) this.KernPairs.get(unicodeToName2)) == null) {
            return 0;
        }
        for (int i3 = 0; i3 < objArr.length; i3 += 2) {
            if (unicodeToName.equals(objArr[i3])) {
                return ((Integer) objArr[i3 + 1]).intValue();
            }
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void process(com.lowagie.text.pdf.RandomAccessFileOrArray r15) throws com.lowagie.text.DocumentException, java.io.IOException {
        /*
            r14 = this;
        L_0x0000:
            java.lang.String r0 = r15.readLine()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000b
            r0 = 0
            goto L_0x01a4
        L_0x000b:
            java.util.StringTokenizer r3 = new java.util.StringTokenizer
            java.lang.String r4 = " ,\n\r\t\f"
            r3.<init>(r0, r4)
            boolean r0 = r3.hasMoreTokens()
            if (r0 != 0) goto L_0x0019
            goto L_0x0000
        L_0x0019:
            java.lang.String r0 = r3.nextToken()
            java.lang.String r4 = "FontName"
            boolean r4 = r0.equals(r4)
            java.lang.String r5 = "ÿ"
            if (r4 == 0) goto L_0x0033
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.FontName = r0
            goto L_0x0000
        L_0x0033:
            java.lang.String r4 = "FullName"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0046
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.FullName = r0
            goto L_0x0000
        L_0x0046:
            java.lang.String r4 = "FamilyName"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0059
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.FamilyName = r0
            goto L_0x0000
        L_0x0059:
            java.lang.String r4 = "Weight"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x006c
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.Weight = r0
            goto L_0x0000
        L_0x006c:
            java.lang.String r4 = "ItalicAngle"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x007f
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            r14.ItalicAngle = r0
            goto L_0x0000
        L_0x007f:
            java.lang.String r4 = "IsFixedPitch"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0095
            java.lang.String r0 = r3.nextToken()
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)
            r14.IsFixedPitch = r0
            goto L_0x0000
        L_0x0095:
            java.lang.String r4 = "CharacterSet"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x00a9
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.CharacterSet = r0
            goto L_0x0000
        L_0x00a9:
            java.lang.String r4 = "FontBBox"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x00df
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.llx = r0
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.lly = r0
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.urx = r0
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.ury = r0
            goto L_0x0000
        L_0x00df:
            java.lang.String r4 = "UnderlinePosition"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x00f4
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.UnderlinePosition = r0
            goto L_0x0000
        L_0x00f4:
            java.lang.String r4 = "UnderlineThickness"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0109
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.UnderlineThickness = r0
            goto L_0x0000
        L_0x0109:
            java.lang.String r4 = "EncodingScheme"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x011d
            java.lang.String r0 = r3.nextToken(r5)
            java.lang.String r0 = r0.substring(r2)
            r14.EncodingScheme = r0
            goto L_0x0000
        L_0x011d:
            java.lang.String r4 = "CapHeight"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0132
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.CapHeight = r0
            goto L_0x0000
        L_0x0132:
            java.lang.String r4 = "XHeight"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0147
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.XHeight = r0
            goto L_0x0000
        L_0x0147:
            java.lang.String r4 = "Ascender"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x015c
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.Ascender = r0
            goto L_0x0000
        L_0x015c:
            java.lang.String r4 = "Descender"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0171
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.Descender = r0
            goto L_0x0000
        L_0x0171:
            java.lang.String r4 = "StdHW"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0186
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.StdHW = r0
            goto L_0x0000
        L_0x0186:
            java.lang.String r4 = "StdVW"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x019b
            java.lang.String r0 = r3.nextToken()
            float r0 = java.lang.Float.parseFloat(r0)
            int r0 = (int) r0
            r14.StdVW = r0
            goto L_0x0000
        L_0x019b:
            java.lang.String r3 = "StartCharMetrics"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0000
            r0 = 1
        L_0x01a4:
            if (r0 == 0) goto L_0x0376
        L_0x01a6:
            java.lang.String r3 = r15.readLine()
            r4 = 2
            if (r3 != 0) goto L_0x01ae
            goto L_0x01c7
        L_0x01ae:
            java.util.StringTokenizer r5 = new java.util.StringTokenizer
            r5.<init>(r3)
            boolean r6 = r5.hasMoreTokens()
            if (r6 != 0) goto L_0x01ba
            goto L_0x01a6
        L_0x01ba:
            java.lang.String r5 = r5.nextToken()
            java.lang.String r6 = "EndCharMetrics"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x02be
            r0 = 0
        L_0x01c7:
            if (r0 != 0) goto L_0x02a8
            java.util.HashMap r3 = r14.CharMetrics
            java.lang.String r5 = "nonbreakingspace"
            boolean r3 = r3.containsKey(r5)
            if (r3 != 0) goto L_0x01e4
            java.util.HashMap r3 = r14.CharMetrics
            java.lang.String r6 = "space"
            java.lang.Object r3 = r3.get(r6)
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            if (r3 == 0) goto L_0x01e4
            java.util.HashMap r6 = r14.CharMetrics
            r6.put(r5, r3)
        L_0x01e4:
            java.lang.String r3 = r15.readLine()
            if (r3 != 0) goto L_0x01eb
            goto L_0x020d
        L_0x01eb:
            java.util.StringTokenizer r5 = new java.util.StringTokenizer
            r5.<init>(r3)
            boolean r3 = r5.hasMoreTokens()
            if (r3 != 0) goto L_0x01f7
            goto L_0x01e4
        L_0x01f7:
            java.lang.String r3 = r5.nextToken()
            java.lang.String r5 = "EndFontMetrics"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0204
            return
        L_0x0204:
            java.lang.String r5 = "StartKernPairs"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x01e4
            r0 = 1
        L_0x020d:
            if (r0 == 0) goto L_0x0292
        L_0x020f:
            java.lang.String r3 = r15.readLine()
            if (r3 != 0) goto L_0x0216
            goto L_0x0276
        L_0x0216:
            java.util.StringTokenizer r5 = new java.util.StringTokenizer
            r5.<init>(r3)
            boolean r3 = r5.hasMoreTokens()
            if (r3 != 0) goto L_0x0222
            goto L_0x020f
        L_0x0222:
            java.lang.String r3 = r5.nextToken()
            java.lang.String r6 = "KPX"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x026d
            java.lang.String r3 = r5.nextToken()
            java.lang.String r6 = r5.nextToken()
            java.lang.Integer r7 = new java.lang.Integer
            java.lang.String r5 = r5.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r7.<init>(r5)
            java.util.HashMap r5 = r14.KernPairs
            java.lang.Object r5 = r5.get(r3)
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            if (r5 != 0) goto L_0x025a
            java.util.HashMap r5 = r14.KernPairs
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r1] = r6
            r8[r2] = r7
            r5.put(r3, r8)
            goto L_0x020f
        L_0x025a:
            int r8 = r5.length
            int r9 = r8 + 2
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.System.arraycopy(r5, r1, r9, r1, r8)
            r9[r8] = r6
            int r8 = r8 + r2
            r9[r8] = r7
            java.util.HashMap r5 = r14.KernPairs
            r5.put(r3, r9)
            goto L_0x020f
        L_0x026d:
            java.lang.String r5 = "EndKernPairs"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x020f
            r0 = 0
        L_0x0276:
            if (r0 != 0) goto L_0x027c
            r15.close()
            return
        L_0x027c:
            com.lowagie.text.DocumentException r15 = new com.lowagie.text.DocumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Missing EndKernPairs in "
            r0.<init>(r1)
            java.lang.String r1 = r14.fileName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x0292:
            com.lowagie.text.DocumentException r15 = new com.lowagie.text.DocumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Missing EndFontMetrics in "
            r0.<init>(r1)
            java.lang.String r1 = r14.fileName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x02a8:
            com.lowagie.text.DocumentException r15 = new com.lowagie.text.DocumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Missing EndCharMetrics in "
            r0.<init>(r1)
            java.lang.String r1 = r14.fileName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x02be:
            java.lang.Integer r5 = new java.lang.Integer
            r6 = -1
            r5.<init>(r6)
            java.lang.Integer r6 = new java.lang.Integer
            r7 = 250(0xfa, float:3.5E-43)
            r6.<init>(r7)
            r7 = 0
            java.util.StringTokenizer r8 = new java.util.StringTokenizer
            java.lang.String r9 = ";"
            r8.<init>(r3, r9)
            java.lang.String r3 = ""
        L_0x02d5:
            boolean r9 = r8.hasMoreTokens()
            r10 = 3
            r11 = 4
            if (r9 != 0) goto L_0x02f9
            java.lang.Object[] r8 = new java.lang.Object[r11]
            r8[r1] = r5
            r8[r2] = r6
            r8[r4] = r3
            r8[r10] = r7
            int r4 = r5.intValue()
            if (r4 < 0) goto L_0x02f2
            java.util.HashMap r4 = r14.CharMetrics
            r4.put(r5, r8)
        L_0x02f2:
            java.util.HashMap r4 = r14.CharMetrics
            r4.put(r3, r8)
            goto L_0x01a6
        L_0x02f9:
            java.util.StringTokenizer r9 = new java.util.StringTokenizer
            java.lang.String r12 = r8.nextToken()
            r9.<init>(r12)
            boolean r12 = r9.hasMoreTokens()
            if (r12 != 0) goto L_0x0309
            goto L_0x02d5
        L_0x0309:
            java.lang.String r12 = r9.nextToken()
            java.lang.String r13 = "C"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x031e
            java.lang.String r5 = r9.nextToken()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x02d5
        L_0x031e:
            java.lang.String r13 = "WX"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x0335
            java.lang.Integer r6 = new java.lang.Integer
            java.lang.String r9 = r9.nextToken()
            float r9 = java.lang.Float.parseFloat(r9)
            int r9 = (int) r9
            r6.<init>(r9)
            goto L_0x02d5
        L_0x0335:
            java.lang.String r13 = "N"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x0342
            java.lang.String r3 = r9.nextToken()
            goto L_0x02d5
        L_0x0342:
            java.lang.String r13 = "B"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x02d5
            int[] r7 = new int[r11]
            java.lang.String r11 = r9.nextToken()
            int r11 = java.lang.Integer.parseInt(r11)
            r7[r1] = r11
            java.lang.String r11 = r9.nextToken()
            int r11 = java.lang.Integer.parseInt(r11)
            r7[r2] = r11
            java.lang.String r11 = r9.nextToken()
            int r11 = java.lang.Integer.parseInt(r11)
            r7[r4] = r11
            java.lang.String r9 = r9.nextToken()
            int r9 = java.lang.Integer.parseInt(r9)
            r7[r10] = r9
            goto L_0x02d5
        L_0x0376:
            com.lowagie.text.DocumentException r15 = new com.lowagie.text.DocumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Missing StartCharMetrics in "
            r0.<init>(r1)
            java.lang.String r1 = r14.fileName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>((java.lang.String) r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.Type1Font.process(com.lowagie.text.pdf.RandomAccessFileOrArray):void");
    }

    public PdfStream getFullFontStream() throws DocumentException {
        RandomAccessFileOrArray randomAccessFileOrArray;
        RandomAccessFileOrArray randomAccessFileOrArray2 = null;
        if (this.builtinFont || !this.embedded) {
            return null;
        }
        try {
            int i = 0;
            String str = String.valueOf(this.fileName.substring(0, this.fileName.length() - 3)) + "pfb";
            if (this.pfb == null) {
                randomAccessFileOrArray = new RandomAccessFileOrArray(str, true, Document.plainRandomAccess);
            } else {
                randomAccessFileOrArray = new RandomAccessFileOrArray(this.pfb);
            }
            randomAccessFileOrArray2 = randomAccessFileOrArray;
            byte[] bArr = new byte[(randomAccessFileOrArray2.length() - 18)];
            int[] iArr = new int[3];
            int i2 = 0;
            while (i < 3) {
                if (randomAccessFileOrArray2.read() != 128) {
                    throw new DocumentException("Start marker missing in " + str);
                } else if (randomAccessFileOrArray2.read() == PFB_TYPES[i]) {
                    int read = randomAccessFileOrArray2.read() + (randomAccessFileOrArray2.read() << 8) + (randomAccessFileOrArray2.read() << 16) + (randomAccessFileOrArray2.read() << 24);
                    iArr[i] = read;
                    while (read != 0) {
                        int read2 = randomAccessFileOrArray2.read(bArr, i2, read);
                        if (read2 >= 0) {
                            i2 += read2;
                            read -= read2;
                        } else {
                            throw new DocumentException("Premature end in " + str);
                        }
                    }
                    i++;
                } else {
                    throw new DocumentException("Incorrect segment type in " + str);
                }
            }
            BaseFont.StreamFont streamFont = new BaseFont.StreamFont(bArr, iArr, this.compressionLevel);
            try {
                randomAccessFileOrArray2.close();
            } catch (Exception unused) {
            }
            return streamFont;
        } catch (Exception e) {
            throw new DocumentException(e);
        } catch (Throwable th) {
            if (randomAccessFileOrArray2 != null) {
                try {
                    randomAccessFileOrArray2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private PdfDictionary getFontDescriptor(PdfIndirectReference pdfIndirectReference) {
        if (this.builtinFont) {
            return null;
        }
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfNumber(this.Ascender));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfNumber(this.CapHeight));
        pdfDictionary.put(PdfName.DESCENT, new PdfNumber(this.Descender));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfRectangle((float) this.llx, (float) this.lly, (float) this.urx, (float) this.ury));
        pdfDictionary.put(PdfName.FONTNAME, new PdfName(this.FontName));
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfNumber(this.ItalicAngle));
        pdfDictionary.put(PdfName.STEMV, new PdfNumber(this.StdVW));
        if (pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTFILE, pdfIndirectReference);
        }
        int i = 0;
        if (this.IsFixedPitch) {
            i = 1;
        }
        int i2 = i | (this.fontSpecific ? 4 : 32);
        if (this.ItalicAngle < 0.0f) {
            i2 |= 64;
        }
        if (this.FontName.indexOf("Caps") >= 0 || this.FontName.endsWith("SC")) {
            i2 |= 131072;
        }
        if (this.Weight.equals("Bold")) {
            i2 |= 262144;
        }
        pdfDictionary.put(PdfName.FLAGS, new PdfNumber(i2));
        return pdfDictionary;
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, int i, int i2, byte[] bArr) {
        int i3;
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE1);
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(this.FontName));
        boolean z = this.encoding.equals("Cp1252") || this.encoding.equals(BaseFont.MACROMAN);
        if (!this.fontSpecific || this.specialMap != null) {
            int i4 = i;
            while (true) {
                if (i4 > i2) {
                    i3 = i;
                    break;
                } else if (!this.differences[i4].equals(BaseFont.notdef)) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (z) {
                pdfDictionary.put(PdfName.ENCODING, this.encoding.equals("Cp1252") ? PdfName.WIN_ANSI_ENCODING : PdfName.MAC_ROMAN_ENCODING);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.ENCODING);
                PdfArray pdfArray = new PdfArray();
                boolean z2 = true;
                for (int i5 = i3; i5 <= i2; i5++) {
                    if (bArr[i5] != 0) {
                        if (z2) {
                            pdfArray.add((PdfObject) new PdfNumber(i5));
                            z2 = false;
                        }
                        pdfArray.add((PdfObject) new PdfName(this.differences[i5]));
                    } else {
                        z2 = true;
                    }
                }
                pdfDictionary2.put(PdfName.DIFFERENCES, pdfArray);
                pdfDictionary.put(PdfName.ENCODING, pdfDictionary2);
            }
            i = i3;
        }
        if (this.specialMap != null || this.forceWidthsOutput || !this.builtinFont || (!this.fontSpecific && !z)) {
            pdfDictionary.put(PdfName.FIRSTCHAR, new PdfNumber(i));
            pdfDictionary.put(PdfName.LASTCHAR, new PdfNumber(i2));
            PdfArray pdfArray2 = new PdfArray();
            while (i <= i2) {
                if (bArr[i] == 0) {
                    pdfArray2.add((PdfObject) new PdfNumber(0));
                } else {
                    pdfArray2.add((PdfObject) new PdfNumber(this.widths[i]));
                }
                i++;
            }
            pdfDictionary.put(PdfName.WIDTHS, pdfArray2);
        }
        if (!this.builtinFont && pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    /* access modifiers changed from: package-private */
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        int i;
        int i2 = 0;
        int intValue = objArr[0].intValue();
        int intValue2 = objArr[1].intValue();
        byte[] bArr = objArr[2];
        if (!(objArr[3].booleanValue() && this.subset)) {
            i = bArr.length - 1;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = 1;
            }
        } else {
            i2 = intValue;
            i = intValue2;
        }
        PdfIndirectReference pdfIndirectReference2 = null;
        PdfStream fullFontStream = getFullFontStream();
        if (fullFontStream != null) {
            pdfIndirectReference2 = pdfWriter.addToBody(fullFontStream).getIndirectReference();
        }
        PdfDictionary fontDescriptor = getFontDescriptor(pdfIndirectReference2);
        if (fontDescriptor != null) {
            pdfIndirectReference2 = pdfWriter.addToBody(fontDescriptor).getIndirectReference();
        }
        pdfWriter.addToBody((PdfObject) getFontBaseType(pdfIndirectReference2, i2, i, bArr), pdfIndirectReference);
    }

    public float getFontDescriptor(int i, float f) {
        int i2;
        switch (i) {
            case 1:
            case 9:
                i2 = this.Ascender;
                break;
            case 2:
                i2 = this.CapHeight;
                break;
            case 3:
            case 10:
                i2 = this.Descender;
                break;
            case 4:
                return this.ItalicAngle;
            case 5:
                i2 = this.llx;
                break;
            case 6:
                i2 = this.lly;
                break;
            case 7:
                i2 = this.urx;
                break;
            case 8:
                i2 = this.ury;
                break;
            case 11:
                return 0.0f;
            case 12:
                i2 = this.urx - this.llx;
                break;
            case 13:
                i2 = this.UnderlinePosition;
                break;
            case 14:
                i2 = this.UnderlineThickness;
                break;
            default:
                return 0.0f;
        }
        return (((float) i2) * f) / 1000.0f;
    }

    public String getPostscriptFontName() {
        return this.FontName;
    }

    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.FullName}};
    }

    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.FullName}};
    }

    public String[][] getFamilyFontName() {
        return new String[][]{new String[]{"", "", "", this.FamilyName}};
    }

    public boolean hasKernPairs() {
        return !this.KernPairs.isEmpty();
    }

    public void setPostscriptFontName(String str) {
        this.FontName = str;
    }

    public boolean setKerning(int i, int i2, int i3) {
        String unicodeToName;
        String unicodeToName2 = GlyphList.unicodeToName(i);
        if (unicodeToName2 == null || (unicodeToName = GlyphList.unicodeToName(i2)) == null) {
            return false;
        }
        Object[] objArr = (Object[]) this.KernPairs.get(unicodeToName2);
        if (objArr == null) {
            this.KernPairs.put(unicodeToName2, new Object[]{unicodeToName, new Integer(i3)});
            return true;
        }
        for (int i4 = 0; i4 < objArr.length; i4 += 2) {
            if (unicodeToName.equals(objArr[i4])) {
                objArr[i4 + 1] = new Integer(i3);
                return true;
            }
        }
        int length = objArr.length;
        Object[] objArr2 = new Object[(length + 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[length] = unicodeToName;
        objArr2[length + 1] = new Integer(i3);
        this.KernPairs.put(unicodeToName2, objArr2);
        return true;
    }

    /* access modifiers changed from: protected */
    public int[] getRawCharBBox(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = (Object[]) this.CharMetrics.get(new Integer(i));
        } else if (str.equals(BaseFont.notdef)) {
            return null;
        } else {
            objArr = (Object[]) this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return (int[]) objArr[3];
        }
        return null;
    }
}
