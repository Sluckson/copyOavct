package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.util.HashMap;

class EnumerateTTC extends TrueTypeFont {
    protected String[] names;

    EnumerateTTC(String str) throws DocumentException, IOException {
        this.fileName = str;
        this.f765rf = new RandomAccessFileOrArray(str);
        findNames();
    }

    EnumerateTTC(byte[] bArr) throws DocumentException, IOException {
        this.fileName = "Byte array TTC";
        this.f765rf = new RandomAccessFileOrArray(bArr);
        findNames();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void findNames() throws DocumentException, IOException {
        this.tables = new HashMap();
        try {
            if (readStandardString(4).equals("ttcf")) {
                this.f765rf.skipBytes(4);
                int readInt = this.f765rf.readInt();
                this.names = new String[readInt];
                int filePointer = this.f765rf.getFilePointer();
                int i = 0;
                while (i < readInt) {
                    this.tables.clear();
                    this.f765rf.seek(filePointer);
                    this.f765rf.skipBytes(i * 4);
                    this.directoryOffset = this.f765rf.readInt();
                    this.f765rf.seek(this.directoryOffset);
                    if (this.f765rf.readInt() == 65536) {
                        int readUnsignedShort = this.f765rf.readUnsignedShort();
                        this.f765rf.skipBytes(6);
                        for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                            String readStandardString = readStandardString(4);
                            this.f765rf.skipBytes(4);
                            this.tables.put(readStandardString, new int[]{this.f765rf.readInt(), this.f765rf.readInt()});
                        }
                        this.names[i] = getBaseFont();
                        i++;
                    } else {
                        throw new DocumentException(String.valueOf(this.fileName) + " is not a valid TTF file.");
                    }
                }
                if (this.f765rf != null) {
                    this.f765rf.close();
                    return;
                }
                return;
            }
            throw new DocumentException(String.valueOf(this.fileName) + " is not a valid TTC file.");
        } catch (Throwable th) {
            if (this.f765rf != null) {
                this.f765rf.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public String[] getNames() {
        return this.names;
    }
}
