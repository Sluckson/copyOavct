package com.lowagie.text;

import com.lowagie.text.pdf.PdfChunk;

public interface SplitCharacter {
    boolean isSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr);
}
