package com.lowagie.text.pdf;

import com.lowagie.text.SplitCharacter;

public class DefaultSplitCharacter implements SplitCharacter {
    public static final SplitCharacter DEFAULT = new DefaultSplitCharacter();

    public boolean isSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr) {
        char currentCharacter = getCurrentCharacter(i2, cArr, pdfChunkArr);
        if (currentCharacter <= ' ' || currentCharacter == '-' || currentCharacter == 8208) {
            return true;
        }
        if (currentCharacter < 8194) {
            return false;
        }
        return (currentCharacter >= 8194 && currentCharacter <= 8203) || (currentCharacter >= 11904 && currentCharacter < 55200) || ((currentCharacter >= 63744 && currentCharacter < 64256) || ((currentCharacter >= 65072 && currentCharacter < 65104) || (currentCharacter >= 65377 && currentCharacter < 65440)));
    }

    /* access modifiers changed from: protected */
    public char getCurrentCharacter(int i, char[] cArr, PdfChunk[] pdfChunkArr) {
        if (pdfChunkArr == null) {
            return cArr[i];
        }
        return (char) pdfChunkArr[Math.min(i, pdfChunkArr.length - 1)].getUnicodeEquivalent(cArr[i]);
    }
}
