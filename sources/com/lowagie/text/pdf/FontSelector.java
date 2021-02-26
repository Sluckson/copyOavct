package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Utilities;
import java.util.ArrayList;

public class FontSelector {
    protected ArrayList fonts = new ArrayList();

    public void addFont(Font font) {
        if (font.getBaseFont() != null) {
            this.fonts.add(font);
            return;
        }
        this.fonts.add(new Font(font.getCalculatedBaseFont(true), font.getSize(), font.getCalculatedStyle(), font.getColor()));
    }

    public Phrase process(String str) {
        int size = this.fonts.size();
        if (size != 0) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            StringBuffer stringBuffer = new StringBuffer();
            Phrase phrase = new Phrase();
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < length) {
                char c = charArray[i2];
                if (c != 10 && c != 13) {
                    if (!Utilities.isSurrogatePair(charArray, i2)) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                break;
                            } else if (((Font) this.fonts.get(i4)).getBaseFont().charExists(c)) {
                                if (i3 != i4) {
                                    if (stringBuffer.length() > 0 && i3 != -1) {
                                        phrase.add(new Chunk(stringBuffer.toString(), (Font) this.fonts.get(i3)));
                                        stringBuffer.setLength(0);
                                    }
                                    i3 = i4;
                                }
                                stringBuffer.append(c);
                            } else {
                                i4++;
                            }
                        }
                    } else {
                        int convertToUtf32 = Utilities.convertToUtf32(charArray, i2);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size) {
                                break;
                            } else if (((Font) this.fonts.get(i5)).getBaseFont().charExists(convertToUtf32)) {
                                if (i3 != i5) {
                                    if (stringBuffer.length() > 0 && i3 != -1) {
                                        phrase.add(new Chunk(stringBuffer.toString(), (Font) this.fonts.get(i3)));
                                        stringBuffer.setLength(0);
                                    }
                                    i3 = i5;
                                }
                                stringBuffer.append(c);
                                i2++;
                                stringBuffer.append(charArray[i2]);
                            } else {
                                i5++;
                            }
                        }
                    }
                } else {
                    stringBuffer.append(c);
                }
                i2++;
            }
            if (stringBuffer.length() > 0) {
                String stringBuffer2 = stringBuffer.toString();
                ArrayList arrayList = this.fonts;
                if (i3 != -1) {
                    i = i3;
                }
                phrase.add(new Chunk(stringBuffer2, (Font) arrayList.get(i)));
            }
            return phrase;
        }
        throw new IndexOutOfBoundsException("No font is defined.");
    }
}
