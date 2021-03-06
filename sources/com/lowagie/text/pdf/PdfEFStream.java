package com.lowagie.text.pdf;

import java.io.InputStream;

public class PdfEFStream extends PdfStream {
    public PdfEFStream(InputStream inputStream, PdfWriter pdfWriter) {
        super(inputStream, pdfWriter);
    }

    public PdfEFStream(byte[] bArr) {
        super(bArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.lowagie.text.pdf.OutputStreamEncryption} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (com.lowagie.text.pdf.PdfName.CRYPT.equals(r3.getPdfObject(0)) != false) goto L_0x002b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void toPdf(com.lowagie.text.pdf.PdfWriter r9, java.io.OutputStream r10) throws java.io.IOException {
        /*
            r8 = this;
            java.io.InputStream r0 = r8.inputStream
            if (r0 == 0) goto L_0x000f
            boolean r0 = r8.compressed
            if (r0 == 0) goto L_0x000f
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.FILTER
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.FLATEDECODE
            r8.put(r0, r1)
        L_0x000f:
            r0 = 0
            if (r9 == 0) goto L_0x0017
            com.lowagie.text.pdf.PdfEncryption r1 = r9.getEncryption()
            goto L_0x0018
        L_0x0017:
            r1 = r0
        L_0x0018:
            r2 = 0
            if (r1 == 0) goto L_0x0048
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.FILTER
            com.lowagie.text.pdf.PdfObject r3 = r8.get(r3)
            if (r3 == 0) goto L_0x0048
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.CRYPT
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x002d
        L_0x002b:
            r1 = r0
            goto L_0x0048
        L_0x002d:
            boolean r4 = r3.isArray()
            if (r4 == 0) goto L_0x0048
            com.lowagie.text.pdf.PdfArray r3 = (com.lowagie.text.pdf.PdfArray) r3
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0048
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.CRYPT
            com.lowagie.text.pdf.PdfObject r3 = r3.getPdfObject(r2)
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0048
            goto L_0x002b
        L_0x0048:
            if (r1 == 0) goto L_0x0089
            boolean r3 = r1.isEmbeddedFilesOnly()
            if (r3 == 0) goto L_0x0089
            com.lowagie.text.pdf.PdfArray r3 = new com.lowagie.text.pdf.PdfArray
            r3.<init>()
            com.lowagie.text.pdf.PdfArray r4 = new com.lowagie.text.pdf.PdfArray
            r4.<init>()
            com.lowagie.text.pdf.PdfDictionary r5 = new com.lowagie.text.pdf.PdfDictionary
            r5.<init>()
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.NAME
            com.lowagie.text.pdf.PdfName r7 = com.lowagie.text.pdf.PdfName.STDCF
            r5.put(r6, r7)
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.CRYPT
            r3.add((com.lowagie.text.pdf.PdfObject) r6)
            r4.add((com.lowagie.text.pdf.PdfObject) r5)
            boolean r5 = r8.compressed
            if (r5 == 0) goto L_0x007f
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.FLATEDECODE
            r3.add((com.lowagie.text.pdf.PdfObject) r5)
            com.lowagie.text.pdf.PdfNull r5 = new com.lowagie.text.pdf.PdfNull
            r5.<init>()
            r4.add((com.lowagie.text.pdf.PdfObject) r5)
        L_0x007f:
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.FILTER
            r8.put(r5, r3)
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.DECODEPARMS
            r8.put(r3, r4)
        L_0x0089:
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.LENGTH
            com.lowagie.text.pdf.PdfObject r3 = r8.get(r3)
            if (r1 == 0) goto L_0x00b7
            if (r3 == 0) goto L_0x00b7
            boolean r4 = r3.isNumber()
            if (r4 == 0) goto L_0x00b7
            r4 = r3
            com.lowagie.text.pdf.PdfNumber r4 = (com.lowagie.text.pdf.PdfNumber) r4
            int r4 = r4.intValue()
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.LENGTH
            com.lowagie.text.pdf.PdfNumber r6 = new com.lowagie.text.pdf.PdfNumber
            int r4 = r1.calculateStreamSize(r4)
            r6.<init>((int) r4)
            r8.put(r5, r6)
            r8.superToPdf(r9, r10)
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.LENGTH
            r8.put(r9, r3)
            goto L_0x00ba
        L_0x00b7:
            r8.superToPdf(r9, r10)
        L_0x00ba:
            byte[] r9 = STARTSTREAM
            r10.write(r9)
            java.io.InputStream r9 = r8.inputStream
            if (r9 == 0) goto L_0x0115
            r8.rawLength = r2
            com.lowagie.text.pdf.OutputStreamCounter r9 = new com.lowagie.text.pdf.OutputStreamCounter
            r9.<init>(r10)
            if (r1 == 0) goto L_0x00d2
            com.lowagie.text.pdf.OutputStreamEncryption r1 = r1.getEncryptionStream(r9)
            r3 = r1
            goto L_0x00d4
        L_0x00d2:
            r1 = r9
            r3 = r0
        L_0x00d4:
            boolean r4 = r8.compressed
            if (r4 == 0) goto L_0x00ea
            java.util.zip.Deflater r0 = new java.util.zip.Deflater
            int r4 = r8.compressionLevel
            r0.<init>(r4)
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream
            r5 = 32768(0x8000, float:4.5918E-41)
            r4.<init>(r1, r0, r5)
            r5 = r0
            r0 = r4
            goto L_0x00ec
        L_0x00ea:
            r5 = r0
            r4 = r1
        L_0x00ec:
            r1 = 4192(0x1060, float:5.874E-42)
            byte[] r6 = new byte[r1]
        L_0x00f0:
            java.io.InputStream r1 = r8.inputStream
            int r1 = r1.read(r6)
            if (r1 > 0) goto L_0x010c
            if (r0 == 0) goto L_0x0100
            r0.finish()
            r5.end()
        L_0x0100:
            if (r3 == 0) goto L_0x0105
            r3.finish()
        L_0x0105:
            int r9 = r9.getCounter()
            r8.inputStreamLength = r9
            goto L_0x013f
        L_0x010c:
            r4.write(r6, r2, r1)
            int r7 = r8.rawLength
            int r7 = r7 + r1
            r8.rawLength = r7
            goto L_0x00f0
        L_0x0115:
            if (r1 != 0) goto L_0x0127
            java.io.ByteArrayOutputStream r9 = r8.streamBytes
            if (r9 == 0) goto L_0x0121
            java.io.ByteArrayOutputStream r9 = r8.streamBytes
            r9.writeTo(r10)
            goto L_0x013f
        L_0x0121:
            byte[] r9 = r8.bytes
            r10.write(r9)
            goto L_0x013f
        L_0x0127:
            java.io.ByteArrayOutputStream r9 = r8.streamBytes
            if (r9 == 0) goto L_0x0136
            java.io.ByteArrayOutputStream r9 = r8.streamBytes
            byte[] r9 = r9.toByteArray()
            byte[] r9 = r1.encryptByteArray(r9)
            goto L_0x013c
        L_0x0136:
            byte[] r9 = r8.bytes
            byte[] r9 = r1.encryptByteArray(r9)
        L_0x013c:
            r10.write(r9)
        L_0x013f:
            byte[] r9 = ENDSTREAM
            r10.write(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfEFStream.toPdf(com.lowagie.text.pdf.PdfWriter, java.io.OutputStream):void");
    }
}
