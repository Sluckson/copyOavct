package com.lowagie.text.pdf;

import java.io.IOException;
import java.util.ArrayList;

public class PdfContentParser {
    public static final int COMMAND_TYPE = 200;
    private PRTokeniser tokeniser;

    public PdfContentParser(PRTokeniser pRTokeniser) {
        this.tokeniser = pRTokeniser;
    }

    public ArrayList parse(ArrayList arrayList) throws IOException {
        PdfObject readPRObject;
        if (arrayList == null) {
            arrayList = new ArrayList();
        } else {
            arrayList.clear();
        }
        do {
            readPRObject = readPRObject();
            if (readPRObject == null) {
                break;
            }
            arrayList.add(readPRObject);
        } while (readPRObject.type() != 200);
        return arrayList;
    }

    public PRTokeniser getTokeniser() {
        return this.tokeniser;
    }

    public void setTokeniser(PRTokeniser pRTokeniser) {
        this.tokeniser = pRTokeniser;
    }

    public PdfDictionary readDictionary() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (nextValidToken()) {
            if (this.tokeniser.getTokenType() == 8) {
                return pdfDictionary;
            }
            if (this.tokeniser.getTokenType() == 3) {
                PdfName pdfName = new PdfName(this.tokeniser.getStringValue(), false);
                PdfObject readPRObject = readPRObject();
                int i = -readPRObject.type();
                if (i == 8) {
                    throw new IOException("Unexpected '>>'");
                } else if (i != 6) {
                    pdfDictionary.put(pdfName, readPRObject);
                } else {
                    throw new IOException("Unexpected ']'");
                }
            } else {
                throw new IOException("Dictionary key is not a name.");
            }
        }
        throw new IOException("Unexpected end of file.");
    }

    public PdfArray readArray() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject readPRObject = readPRObject();
            int i = -readPRObject.type();
            if (i == 6) {
                return pdfArray;
            }
            if (i != 8) {
                pdfArray.add(readPRObject);
            } else {
                throw new IOException("Unexpected '>>'");
            }
        }
    }

    public PdfObject readPRObject() throws IOException {
        if (!nextValidToken()) {
            return null;
        }
        int tokenType = this.tokeniser.getTokenType();
        if (tokenType == 1) {
            return new PdfNumber(this.tokeniser.getStringValue());
        }
        if (tokenType == 2) {
            return new PdfString(this.tokeniser.getStringValue(), (String) null).setHexWriting(this.tokeniser.isHexString());
        }
        if (tokenType == 3) {
            return new PdfName(this.tokeniser.getStringValue(), false);
        }
        if (tokenType == 5) {
            return readArray();
        }
        if (tokenType == 7) {
            return readDictionary();
        }
        if (tokenType != 10) {
            return new PdfLiteral(-tokenType, this.tokeniser.getStringValue());
        }
        return new PdfLiteral(200, this.tokeniser.getStringValue());
    }

    public boolean nextValidToken() throws IOException {
        while (this.tokeniser.nextToken()) {
            if (this.tokeniser.getTokenType() != 4) {
                return true;
            }
        }
        return false;
    }
}
