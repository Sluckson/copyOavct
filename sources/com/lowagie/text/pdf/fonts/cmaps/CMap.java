package com.lowagie.text.pdf.fonts.cmaps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CMap {
    private List codeSpaceRanges = new ArrayList();
    private Map doubleByteMappings = new HashMap();
    private Map singleByteMappings = new HashMap();

    public boolean hasOneByteMappings() {
        return !this.singleByteMappings.isEmpty();
    }

    public boolean hasTwoByteMappings() {
        return !this.doubleByteMappings.isEmpty();
    }

    public String lookup(byte[] bArr, int i, int i2) {
        if (i2 == 1) {
            return (String) this.singleByteMappings.get(new Integer((bArr[i] + 256) % 256));
        } else if (i2 != 2) {
            return null;
        } else {
            return (String) this.doubleByteMappings.get(new Integer((((bArr[i] + 256) % 256) << 8) + ((bArr[i + 1] + 256) % 256)));
        }
    }

    public void addMapping(byte[] bArr, String str) throws IOException {
        if (bArr.length == 1) {
            this.singleByteMappings.put(new Integer(bArr[0]), str);
        } else if (bArr.length == 2) {
            this.doubleByteMappings.put(new Integer((bArr[1] & 255) | ((bArr[0] & 255) << 8)), str);
        } else {
            throw new IOException("Mapping code should be 1 or two bytes and not " + bArr.length);
        }
    }

    public void addCodespaceRange(CodespaceRange codespaceRange) {
        this.codeSpaceRanges.add(codespaceRange);
    }

    public List getCodeSpaceRanges() {
        return this.codeSpaceRanges;
    }
}
