package com.lowagie.text.pdf;

import java.util.HashMap;

public class GlyphList {
    private static HashMap names2unicode = new HashMap();
    private static HashMap unicode2names = new HashMap();

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4 A[SYNTHETIC, Splitter:B:38:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[SYNTHETIC, Splitter:B:42:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            unicode2names = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            names2unicode = r0
            r0 = 0
            java.lang.String r1 = "com/lowagie/text/pdf/fonts/glyphlist.txt"
            com.lowagie.text.pdf.fonts.FontsResourceAnchor r2 = new com.lowagie.text.pdf.fonts.FontsResourceAnchor     // Catch:{ Exception -> 0x00aa }
            r2.<init>()     // Catch:{ Exception -> 0x00aa }
            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x00aa }
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x00aa }
            java.io.InputStream r1 = com.lowagie.text.pdf.BaseFont.getResourceStream(r1, r2)     // Catch:{ Exception -> 0x00aa }
            if (r1 == 0) goto L_0x00a0
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            r3.<init>()     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
        L_0x002d:
            int r4 = r1.read(r2)     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            r5 = 0
            if (r4 >= 0) goto L_0x0092
            r1.close()     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            byte[] r1 = r3.toByteArray()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r1 = com.lowagie.text.pdf.PdfEncodings.convertToString(r1, r0)     // Catch:{ Exception -> 0x00aa }
            java.util.StringTokenizer r2 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x00aa }
            java.lang.String r3 = "\r\n"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00aa }
        L_0x0046:
            boolean r1 = r2.hasMoreTokens()     // Catch:{ Exception -> 0x00aa }
            if (r1 != 0) goto L_0x004e
            goto L_0x00c7
        L_0x004e:
            java.lang.String r1 = r2.nextToken()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r3 = "#"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x00aa }
            if (r3 == 0) goto L_0x005b
            goto L_0x0046
        L_0x005b:
            java.util.StringTokenizer r3 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x00aa }
            java.lang.String r4 = " ;\r\n\t\f"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x00aa }
            boolean r1 = r3.hasMoreTokens()     // Catch:{ Exception -> 0x00aa }
            if (r1 != 0) goto L_0x0069
            goto L_0x0046
        L_0x0069:
            java.lang.String r1 = r3.nextToken()     // Catch:{ Exception -> 0x00aa }
            boolean r4 = r3.hasMoreTokens()     // Catch:{ Exception -> 0x00aa }
            if (r4 != 0) goto L_0x0074
            goto L_0x0046
        L_0x0074:
            java.lang.String r3 = r3.nextToken()     // Catch:{ Exception -> 0x00aa }
            r4 = 16
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3, r4)     // Catch:{ Exception -> 0x00aa }
            java.util.HashMap r4 = unicode2names     // Catch:{ Exception -> 0x00aa }
            r4.put(r3, r1)     // Catch:{ Exception -> 0x00aa }
            java.util.HashMap r4 = names2unicode     // Catch:{ Exception -> 0x00aa }
            r6 = 1
            int[] r6 = new int[r6]     // Catch:{ Exception -> 0x00aa }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00aa }
            r6[r5] = r3     // Catch:{ Exception -> 0x00aa }
            r4.put(r1, r6)     // Catch:{ Exception -> 0x00aa }
            goto L_0x0046
        L_0x0092:
            r3.write(r2, r5, r4)     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            goto L_0x002d
        L_0x0096:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x00c8
        L_0x009b:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x00ab
        L_0x00a0:
            java.lang.String r0 = "glyphlist.txt not found as resource. (It must exist as resource in the package com.lowagie.text.pdf.fonts)"
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            throw r2     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
        L_0x00a8:
            r1 = move-exception
            goto L_0x00c8
        L_0x00aa:
            r1 = move-exception
        L_0x00ab:
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = "glyphlist.txt loading error: "
            r3.<init>(r4)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00a8 }
            r3.append(r1)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00a8 }
            r2.println(r1)     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00c7
            r0.close()     // Catch:{ Exception -> 0x00c7 }
        L_0x00c7:
            return
        L_0x00c8:
            if (r0 == 0) goto L_0x00cd
            r0.close()     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.GlyphList.<clinit>():void");
    }

    public static int[] nameToUnicode(String str) {
        return (int[]) names2unicode.get(str);
    }

    public static String unicodeToName(int i) {
        return (String) unicode2names.get(new Integer(i));
    }
}
