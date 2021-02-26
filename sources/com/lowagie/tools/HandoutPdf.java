package com.lowagie.tools;

public class HandoutPdf {
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016f A[Catch:{ Exception -> 0x01af }, LOOP:2: B:13:0x007c->B:40:0x016f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0175 A[Catch:{ Exception -> 0x01af }, LOOP:3: B:35:0x0133->B:41:0x0175, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0168 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r24) {
        /*
            r0 = r24
            int r1 = r0.length
            r2 = 3
            if (r1 == r2) goto L_0x000f
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.String r1 = "arguments: srcfile destfile pages"
            r0.println(r1)
            goto L_0x01d6
        L_0x000f:
            r1 = 2
            r2 = r0[r1]     // Catch:{ Exception -> 0x01af }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x01af }
            if (r2 < r1) goto L_0x0196
            r1 = 8
            if (r2 > r1) goto L_0x0196
            r1 = 1106247680(0x41f00000, float:30.0)
            r3 = 1134559232(0x43a00000, float:320.0)
            float[] r5 = new float[r2]     // Catch:{ Exception -> 0x01af }
            float[] r6 = new float[r2]     // Catch:{ Exception -> 0x01af }
            r7 = 1145208832(0x44428000, float:778.0)
            int r8 = r2 + -1
            float r8 = (float) r8     // Catch:{ Exception -> 0x01af }
            r9 = 1101004800(0x41a00000, float:20.0)
            float r8 = r8 * r9
            float r7 = r7 - r8
            float r8 = (float) r2     // Catch:{ Exception -> 0x01af }
            float r7 = r7 / r8
            r8 = 1145765888(0x444b0000, float:812.0)
            r10 = 0
            r5[r10] = r8     // Catch:{ Exception -> 0x01af }
            float r8 = r8 - r7
            r6[r10] = r8     // Catch:{ Exception -> 0x01af }
            r8 = 1
            r11 = 1
        L_0x003b:
            if (r11 < r2) goto L_0x0182
            com.lowagie.text.pdf.PdfReader r7 = new com.lowagie.text.pdf.PdfReader     // Catch:{ Exception -> 0x01af }
            r9 = r0[r10]     // Catch:{ Exception -> 0x01af }
            r7.<init>((java.lang.String) r9)     // Catch:{ Exception -> 0x01af }
            int r9 = r7.getNumberOfPages()     // Catch:{ Exception -> 0x01af }
            java.io.PrintStream r11 = java.lang.System.out     // Catch:{ Exception -> 0x01af }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01af }
            java.lang.String r13 = "There are "
            r12.<init>(r13)     // Catch:{ Exception -> 0x01af }
            r12.append(r9)     // Catch:{ Exception -> 0x01af }
            java.lang.String r13 = " pages in the original file."
            r12.append(r13)     // Catch:{ Exception -> 0x01af }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x01af }
            r11.println(r12)     // Catch:{ Exception -> 0x01af }
            com.lowagie.text.Document r11 = new com.lowagie.text.Document     // Catch:{ Exception -> 0x01af }
            com.lowagie.text.Rectangle r12 = com.lowagie.text.PageSize.f586A4     // Catch:{ Exception -> 0x01af }
            r11.<init>(r12)     // Catch:{ Exception -> 0x01af }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01af }
            r0 = r0[r8]     // Catch:{ Exception -> 0x01af }
            r12.<init>(r0)     // Catch:{ Exception -> 0x01af }
            com.lowagie.text.pdf.PdfWriter r0 = com.lowagie.text.pdf.PdfWriter.getInstance(r11, r12)     // Catch:{ Exception -> 0x01af }
            r11.open()     // Catch:{ Exception -> 0x01af }
            com.lowagie.text.pdf.PdfContentByte r8 = r0.getDirectContent()     // Catch:{ Exception -> 0x01af }
            r12 = 0
        L_0x007a:
            r20 = 0
        L_0x007c:
            if (r12 < r9) goto L_0x0083
            r11.close()     // Catch:{ Exception -> 0x01af }
            goto L_0x01d6
        L_0x0083:
            int r15 = r12 + 1
            com.lowagie.text.Rectangle r21 = r7.getPageSizeWithRotation((int) r15)     // Catch:{ Exception -> 0x01af }
            r12 = 1132068864(0x437a0000, float:250.0)
            float r13 = r21.getWidth()     // Catch:{ Exception -> 0x01af }
            float r13 = r12 / r13
            r14 = r5[r20]     // Catch:{ Exception -> 0x01af }
            r16 = r6[r20]     // Catch:{ Exception -> 0x01af }
            float r14 = r14 - r16
            float r16 = r21.getHeight()     // Catch:{ Exception -> 0x01af }
            float r14 = r14 / r16
            int r16 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x00a3
            r10 = r13
            goto L_0x00a4
        L_0x00a3:
            r10 = r14
        L_0x00a4:
            r16 = 1073741824(0x40000000, float:2.0)
            r17 = 0
            int r13 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r13 != 0) goto L_0x00af
            r22 = 0
            goto L_0x00ba
        L_0x00af:
            float r13 = r21.getWidth()     // Catch:{ Exception -> 0x01af }
            float r13 = r13 * r10
            float r12 = r12 - r13
            float r12 = r12 / r16
            r22 = r12
        L_0x00ba:
            int r12 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x00c1
            r23 = 0
            goto L_0x00d1
        L_0x00c1:
            r12 = r5[r20]     // Catch:{ Exception -> 0x01af }
            r13 = r6[r20]     // Catch:{ Exception -> 0x01af }
            float r12 = r12 - r13
            float r13 = r21.getHeight()     // Catch:{ Exception -> 0x01af }
            float r13 = r13 * r10
            float r12 = r12 - r13
            float r17 = r12 / r16
            r23 = r17
        L_0x00d1:
            com.lowagie.text.pdf.PdfImportedPage r13 = r0.getImportedPage(r7, r15)     // Catch:{ Exception -> 0x01af }
            int r12 = r7.getPageRotation((int) r15)     // Catch:{ Exception -> 0x01af }
            r14 = 90
            if (r12 == r14) goto L_0x00f9
            r14 = 270(0x10e, float:3.78E-43)
            if (r12 != r14) goto L_0x00e2
            goto L_0x00f9
        L_0x00e2:
            r16 = 0
            r17 = 0
            float r18 = r1 + r22
            r12 = r6[r20]     // Catch:{ Exception -> 0x01af }
            float r19 = r12 + r23
            r12 = r8
            r14 = r10
            r4 = r15
            r15 = r16
            r16 = r17
            r17 = r10
            r12.addTemplate(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01af }
            goto L_0x0112
        L_0x00f9:
            r4 = r15
            r14 = 0
            float r15 = -r10
            r17 = 0
            float r18 = r1 + r22
            r12 = r6[r20]     // Catch:{ Exception -> 0x01af }
            float r12 = r12 + r23
            float r16 = r21.getHeight()     // Catch:{ Exception -> 0x01af }
            float r16 = r16 * r10
            float r19 = r12 + r16
            r12 = r8
            r16 = r10
            r12.addTemplate(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01af }
        L_0x0112:
            r12 = 192(0xc0, float:2.69E-43)
            r8.setRGBColorStroke(r12, r12, r12)     // Catch:{ Exception -> 0x01af }
            r12 = 1134395392(0x439d8000, float:315.0)
            r13 = r6[r20]     // Catch:{ Exception -> 0x01af }
            r14 = 1084227584(0x40a00000, float:5.0)
            float r13 = r13 - r14
            r14 = 1132396544(0x437f0000, float:255.0)
            r15 = r5[r20]     // Catch:{ Exception -> 0x01af }
            r16 = r6[r20]     // Catch:{ Exception -> 0x01af }
            float r15 = r15 - r16
            r16 = 1092616192(0x41200000, float:10.0)
            float r15 = r15 + r16
            r8.rectangle(r12, r13, r14, r15)     // Catch:{ Exception -> 0x01af }
            r12 = r5[r20]     // Catch:{ Exception -> 0x01af }
            r13 = 1100480512(0x41980000, float:19.0)
            float r12 = r12 - r13
        L_0x0133:
            r13 = r6[r20]     // Catch:{ Exception -> 0x01af }
            int r13 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r13 > 0) goto L_0x0175
            float r12 = r1 + r22
            r13 = r6[r20]     // Catch:{ Exception -> 0x01af }
            float r13 = r13 + r23
            float r14 = r21.getWidth()     // Catch:{ Exception -> 0x01af }
            float r14 = r14 * r10
            float r15 = r21.getHeight()     // Catch:{ Exception -> 0x01af }
            float r15 = r15 * r10
            r8.rectangle(r12, r13, r14, r15)     // Catch:{ Exception -> 0x01af }
            r8.stroke()     // Catch:{ Exception -> 0x01af }
            java.io.PrintStream r10 = java.lang.System.out     // Catch:{ Exception -> 0x01af }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01af }
            java.lang.String r13 = "Processed page "
            r12.<init>(r13)     // Catch:{ Exception -> 0x01af }
            r12.append(r4)     // Catch:{ Exception -> 0x01af }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x01af }
            r10.println(r12)     // Catch:{ Exception -> 0x01af }
            int r10 = r20 + 1
            if (r10 != r2) goto L_0x016f
            r11.newPage()     // Catch:{ Exception -> 0x01af }
            r12 = r4
            r10 = 0
            goto L_0x007a
        L_0x016f:
            r12 = r4
            r20 = r10
            r10 = 0
            goto L_0x007c
        L_0x0175:
            r8.moveTo(r3, r12)     // Catch:{ Exception -> 0x01af }
            r13 = 1141719040(0x440d4000, float:565.0)
            r8.lineTo(r13, r12)     // Catch:{ Exception -> 0x01af }
            r14 = 1098907648(0x41800000, float:16.0)
            float r12 = r12 - r14
            goto L_0x0133
        L_0x0182:
            r13 = 1141719040(0x440d4000, float:565.0)
            int r4 = r11 + -1
            r4 = r6[r4]     // Catch:{ Exception -> 0x01af }
            float r4 = r4 - r9
            r5[r11] = r4     // Catch:{ Exception -> 0x01af }
            r4 = r5[r11]     // Catch:{ Exception -> 0x01af }
            float r4 = r4 - r7
            r6[r11] = r4     // Catch:{ Exception -> 0x01af }
            int r11 = r11 + 1
            r10 = 0
            goto L_0x003b
        L_0x0196:
            com.lowagie.text.DocumentException r0 = new com.lowagie.text.DocumentException     // Catch:{ Exception -> 0x01af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01af }
            java.lang.String r3 = "You can't have "
            r1.<init>(r3)     // Catch:{ Exception -> 0x01af }
            r1.append(r2)     // Catch:{ Exception -> 0x01af }
            java.lang.String r2 = " pages on one page (minimum 2; maximum 8)."
            r1.append(r2)     // Catch:{ Exception -> 0x01af }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01af }
            r0.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x01af }
            throw r0     // Catch:{ Exception -> 0x01af }
        L_0x01af:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.<init>(r3)
            java.lang.String r3 = ": "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.println(r0)
        L_0x01d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.tools.HandoutPdf.main(java.lang.String[]):void");
    }
}
