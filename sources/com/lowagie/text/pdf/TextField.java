package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import harmony.java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TextField extends BaseField {
    private String[] choiceExports;
    private int choiceSelection;
    private String[] choices;
    private String defaultText;
    private BaseFont extensionFont;
    private float extraMarginLeft;
    private float extraMarginTop;
    private ArrayList substitutionFonts;
    private int topFirst;

    public TextField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
    }

    private static boolean checkRTL(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c >= 1424 && c < 1920) {
                return true;
            }
        }
        return false;
    }

    private static void changeFontSize(Phrase phrase, float f) {
        for (int i = 0; i < phrase.size(); i++) {
            ((Chunk) phrase.get(i)).getFont().setSize(f);
        }
    }

    private Phrase composePhrase(String str, BaseFont baseFont, Color color, float f) {
        ArrayList arrayList;
        if (this.extensionFont == null && ((arrayList = this.substitutionFonts) == null || arrayList.isEmpty())) {
            return new Phrase(new Chunk(str, new Font(baseFont, f, 0, color)));
        }
        FontSelector fontSelector = new FontSelector();
        fontSelector.addFont(new Font(baseFont, f, 0, color));
        BaseFont baseFont2 = this.extensionFont;
        if (baseFont2 != null) {
            fontSelector.addFont(new Font(baseFont2, f, 0, color));
        }
        if (this.substitutionFonts != null) {
            for (int i = 0; i < this.substitutionFonts.size(); i++) {
                fontSelector.addFont(new Font((BaseFont) this.substitutionFonts.get(i), f, 0, color));
            }
        }
        return fontSelector.process(str);
    }

    public static String removeCRLF(String str) {
        if (str.indexOf(10) < 0 && str.indexOf(13) < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(charArray.length);
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            if (c == 10) {
                stringBuffer.append(' ');
            } else if (c == 13) {
                stringBuffer.append(' ');
                if (i < charArray.length - 1) {
                    int i2 = i + 1;
                    if (charArray[i2] == 10) {
                        i = i2;
                    }
                }
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String obfuscatePassword(String str) {
        char[] cArr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            cArr[i] = '*';
        }
        return new String(cArr);
    }

    public PdfAppearance getAppearance() throws IOException, DocumentException {
        String str;
        float width;
        int i;
        float min;
        PdfAppearance borderAppearance = getBorderAppearance();
        borderAppearance.beginVariableText();
        if (this.text == null || this.text.length() == 0) {
            borderAppearance.endVariableText();
            return borderAppearance;
        }
        boolean z = this.borderStyle == 2 || this.borderStyle == 3;
        float height = (this.box.getHeight() - (this.borderWidth * 2.0f)) - this.extraMarginTop;
        float f = this.borderWidth;
        if (z) {
            height -= this.borderWidth * 2.0f;
            f *= 2.0f;
        }
        float max = Math.max(f, 1.0f);
        float min2 = Math.min(f, max);
        borderAppearance.saveState();
        float f2 = min2 * 2.0f;
        borderAppearance.rectangle(min2, min2, this.box.getWidth() - f2, this.box.getHeight() - f2);
        borderAppearance.clip();
        borderAppearance.newPath();
        if ((this.options & 8192) != 0) {
            str = obfuscatePassword(this.text);
        } else if ((this.options & 4096) == 0) {
            str = removeCRLF(this.text);
        } else {
            str = this.text;
        }
        BaseFont realFont = getRealFont();
        Color color = this.textColor == null ? GrayColor.GRAYBLACK : this.textColor;
        int i2 = checkRTL(str) ? 2 : 1;
        float f3 = this.fontSize;
        Phrase composePhrase = composePhrase(str, realFont, color, f3);
        if ((this.options & 4096) != 0) {
            float width2 = (this.box.getWidth() - (max * 4.0f)) - this.extraMarginLeft;
            float fontDescriptor = realFont.getFontDescriptor(8, 1.0f) - realFont.getFontDescriptor(6, 1.0f);
            ColumnText columnText = new ColumnText((PdfContentByte) null);
            if (f3 == 0.0f) {
                f3 = height / fontDescriptor;
                if (f3 > 4.0f) {
                    if (f3 > 12.0f) {
                        f3 = 12.0f;
                    }
                    float max2 = Math.max((f3 - 4.0f) / 10.0f, 0.2f);
                    columnText.setSimpleColumn(0.0f, -height, width2, 0.0f);
                    columnText.setAlignment(this.alignment);
                    columnText.setRunDirection(i2);
                    while (f3 > 4.0f) {
                        columnText.setYLine(0.0f);
                        changeFontSize(composePhrase, f3);
                        columnText.setText(composePhrase);
                        columnText.setLeading(fontDescriptor * f3);
                        if ((columnText.mo52495go(true) & 2) == 0) {
                            break;
                        }
                        f3 -= max2;
                    }
                }
                if (f3 < 4.0f) {
                    f3 = 4.0f;
                }
            }
            changeFontSize(composePhrase, f3);
            columnText.setCanvas(borderAppearance);
            float f4 = fontDescriptor * f3;
            float fontDescriptor2 = (height + max) - realFont.getFontDescriptor(8, f3);
            float f5 = max * 2.0f;
            columnText.setSimpleColumn(this.extraMarginLeft + f5, -20000.0f, this.box.getWidth() - f5, fontDescriptor2 + f4);
            columnText.setLeading(f4);
            columnText.setAlignment(this.alignment);
            columnText.setRunDirection(i2);
            columnText.setText(composePhrase);
            columnText.mo52494go();
        } else {
            if (f3 == 0.0f) {
                float fontDescriptor3 = height / (realFont.getFontDescriptor(7, 1.0f) - realFont.getFontDescriptor(6, 1.0f));
                changeFontSize(composePhrase, 1.0f);
                float width3 = ColumnText.getWidth(composePhrase, i2, 0);
                if (width3 == 0.0f) {
                    min = fontDescriptor3;
                } else {
                    min = Math.min(fontDescriptor3, ((this.box.getWidth() - this.extraMarginLeft) - (max * 4.0f)) / width3);
                }
                if (f3 < 4.0f) {
                    f3 = 4.0f;
                }
            }
            changeFontSize(composePhrase, f3);
            float height2 = (((this.box.getHeight() - f2) - realFont.getFontDescriptor(1, f3)) / 2.0f) + min2;
            if (height2 < min2) {
                height2 = min2;
            }
            if (height2 - min2 < (-realFont.getFontDescriptor(3, f3))) {
                height2 = Math.min((-realFont.getFontDescriptor(3, f3)) + min2, Math.max(height2, (this.box.getHeight() - min2) - realFont.getFontDescriptor(1, f3)));
            }
            if ((this.options & 16777216) == 0 || this.maxCharacterLength <= 0) {
                int i3 = this.alignment;
                if (i3 != 1) {
                    width = i3 != 2 ? this.extraMarginLeft + (max * 2.0f) : (this.extraMarginLeft + this.box.getWidth()) - (max * 2.0f);
                } else {
                    width = this.extraMarginLeft + (this.box.getWidth() / 2.0f);
                }
                ColumnText.showTextAligned(borderAppearance, this.alignment, composePhrase, width, height2 - this.extraMarginTop, 0.0f, i2, 0);
            } else {
                int min3 = Math.min(this.maxCharacterLength, str.length());
                if (this.alignment == 2) {
                    i = this.maxCharacterLength - min3;
                } else {
                    i = this.alignment == 1 ? (this.maxCharacterLength - min3) / 2 : 0;
                }
                float width4 = (this.box.getWidth() - this.extraMarginLeft) / ((float) this.maxCharacterLength);
                float f6 = (width4 / 2.0f) + (((float) i) * width4);
                if (this.textColor == null) {
                    borderAppearance.setGrayFill(0.0f);
                } else {
                    borderAppearance.setColorFill(this.textColor);
                }
                borderAppearance.beginText();
                for (int i4 = 0; i4 < composePhrase.size(); i4++) {
                    Chunk chunk = (Chunk) composePhrase.get(i4);
                    BaseFont baseFont = chunk.getFont().getBaseFont();
                    borderAppearance.setFontAndSize(baseFont, f3);
                    StringBuffer append = chunk.append("");
                    int i5 = 0;
                    while (i5 < append.length()) {
                        int i6 = i5 + 1;
                        String substring = append.substring(i5, i6);
                        borderAppearance.setTextMatrix((this.extraMarginLeft + f6) - (baseFont.getWidthPoint(substring, f3) / 2.0f), height2 - this.extraMarginTop);
                        borderAppearance.showText(substring);
                        f6 += width4;
                        i5 = i6;
                    }
                }
                borderAppearance.endText();
            }
        }
        borderAppearance.restoreState();
        borderAppearance.endVariableText();
        return borderAppearance;
    }

    /* access modifiers changed from: package-private */
    public PdfAppearance getListAppearance() throws IOException, DocumentException {
        PdfAppearance borderAppearance = getBorderAppearance();
        borderAppearance.beginVariableText();
        String[] strArr = this.choices;
        if (strArr == null || strArr.length == 0) {
            borderAppearance.endVariableText();
            return borderAppearance;
        }
        int i = this.choiceSelection;
        if (i >= strArr.length) {
            i = strArr.length - 1;
        }
        int i2 = 0;
        int i3 = i < 0 ? 0 : i;
        BaseFont realFont = getRealFont();
        float f = this.fontSize;
        float f2 = f == 0.0f ? 12.0f : f;
        boolean z = this.borderStyle == 2 || this.borderStyle == 3;
        float height = this.box.getHeight() - (this.borderWidth * 2.0f);
        float f3 = this.borderWidth;
        if (z) {
            height -= this.borderWidth * 2.0f;
            f3 *= 2.0f;
        }
        float fontDescriptor = realFont.getFontDescriptor(8, f2) - realFont.getFontDescriptor(6, f2);
        int i4 = ((int) (height / fontDescriptor)) + 1;
        int i5 = (((i4 / 2) + i3) + 1) - i4;
        if (i5 >= 0) {
            i2 = i5;
        }
        int i6 = i4 + i2;
        String[] strArr2 = this.choices;
        if (i6 > strArr2.length) {
            i6 = strArr2.length;
        }
        this.topFirst = i2;
        borderAppearance.saveState();
        float f4 = f3 * 2.0f;
        borderAppearance.rectangle(f3, f3, this.box.getWidth() - f4, this.box.getHeight() - f4);
        borderAppearance.clip();
        borderAppearance.newPath();
        Color color = this.textColor == null ? GrayColor.GRAYBLACK : this.textColor;
        borderAppearance.setColorFill(new Color(10, 36, 106));
        float f5 = height + f3;
        borderAppearance.rectangle(f3, f5 - (((float) ((i3 - i2) + 1)) * fontDescriptor), this.box.getWidth() - f4, fontDescriptor);
        borderAppearance.fill();
        int i7 = i2;
        float fontDescriptor2 = f5 - realFont.getFontDescriptor(8, f2);
        for (int i8 = i6; i7 < i8; i8 = i8) {
            String str = this.choices[i7];
            ColumnText.showTextAligned(borderAppearance, 0, composePhrase(removeCRLF(str), realFont, i7 == i3 ? GrayColor.GRAYWHITE : color, f2), f4, fontDescriptor2, 0.0f, checkRTL(str) ? 2 : 1, 0);
            i7++;
            fontDescriptor2 -= fontDescriptor;
        }
        borderAppearance.restoreState();
        borderAppearance.endVariableText();
        return borderAppearance;
    }

    public PdfFormField getTextField() throws IOException, DocumentException {
        if (this.maxCharacterLength <= 0) {
            this.options &= -16777217;
        }
        if ((this.options & 16777216) != 0) {
            this.options &= -4097;
        }
        PdfFormField createTextField = PdfFormField.createTextField(this.writer, false, false, this.maxCharacterLength);
        createTextField.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        int i = this.alignment;
        if (i == 1) {
            createTextField.setQuadding(1);
        } else if (i == 2) {
            createTextField.setQuadding(2);
        }
        if (this.rotation != 0) {
            createTextField.setMKRotation(this.rotation);
        }
        if (this.fieldName != null) {
            createTextField.setFieldName(this.fieldName);
            if (!"".equals(this.text)) {
                createTextField.setValueAsString(this.text);
            }
            String str = this.defaultText;
            if (str != null) {
                createTextField.setDefaultValueAsString(str);
            }
            if ((this.options & 1) != 0) {
                createTextField.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                createTextField.setFieldFlags(2);
            }
            if ((this.options & 4096) != 0) {
                createTextField.setFieldFlags(4096);
            }
            if ((this.options & 8388608) != 0) {
                createTextField.setFieldFlags(8388608);
            }
            if ((this.options & 8192) != 0) {
                createTextField.setFieldFlags(8192);
            }
            if ((this.options & 1048576) != 0) {
                createTextField.setFieldFlags(1048576);
            }
            if ((this.options & 4194304) != 0) {
                createTextField.setFieldFlags(4194304);
            }
            if ((this.options & 16777216) != 0) {
                createTextField.setFieldFlags(16777216);
            }
        }
        createTextField.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance();
        createTextField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        if (this.textColor == null) {
            pdfAppearance.setGrayFill(0.0f);
        } else {
            pdfAppearance.setColorFill(this.textColor);
        }
        createTextField.setDefaultAppearanceString(pdfAppearance);
        if (this.borderColor != null) {
            createTextField.setMKBorderColor(this.borderColor);
        }
        if (this.backgroundColor != null) {
            createTextField.setMKBackgroundColor(this.backgroundColor);
        }
        int i2 = this.visibility;
        if (i2 == 1) {
            createTextField.setFlags(6);
        } else if (i2 != 2) {
            if (i2 != 3) {
                createTextField.setFlags(4);
            } else {
                createTextField.setFlags(36);
            }
        }
        return createTextField;
    }

    public PdfFormField getComboField() throws IOException, DocumentException {
        return getChoiceField(false);
    }

    public PdfFormField getListField() throws IOException, DocumentException {
        return getChoiceField(true);
    }

    /* access modifiers changed from: protected */
    public PdfFormField getChoiceField(boolean z) throws IOException, DocumentException {
        PdfFormField pdfFormField;
        PdfAppearance pdfAppearance;
        this.options &= -16781313;
        String[] strArr = this.choices;
        if (strArr == null) {
            strArr = new String[0];
        }
        int i = this.choiceSelection;
        if (i >= strArr.length) {
            i = strArr.length - 1;
        }
        if (this.text == null) {
            this.text = "";
        }
        if (i >= 0) {
            this.text = strArr[i];
        }
        if (i < 0) {
            i = 0;
        }
        String[][] strArr2 = null;
        if (this.choiceExports != null) {
            strArr2 = (String[][]) Array.newInstance(String.class, new int[]{strArr.length, 2});
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                String[] strArr3 = strArr2[i2];
                String[] strArr4 = strArr2[i2];
                String str = strArr[i2];
                strArr4[1] = str;
                strArr3[0] = str;
            }
            int min = Math.min(strArr.length, this.choiceExports.length);
            for (int i3 = 0; i3 < min; i3++) {
                String[] strArr5 = this.choiceExports;
                if (strArr5[i3] != null) {
                    strArr2[i3][0] = strArr5[i3];
                }
            }
            if (z) {
                pdfFormField = PdfFormField.createList(this.writer, strArr2, i);
            } else {
                pdfFormField = PdfFormField.createCombo(this.writer, (262144 & this.options) != 0, strArr2, i);
            }
        } else if (z) {
            pdfFormField = PdfFormField.createList(this.writer, strArr, i);
        } else {
            pdfFormField = PdfFormField.createCombo(this.writer, (262144 & this.options) != 0, strArr, i);
        }
        pdfFormField.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        if (this.rotation != 0) {
            pdfFormField.setMKRotation(this.rotation);
        }
        if (this.fieldName != null) {
            pdfFormField.setFieldName(this.fieldName);
            if (strArr.length > 0) {
                if (strArr2 != null) {
                    pdfFormField.setValueAsString(strArr2[i][0]);
                    pdfFormField.setDefaultValueAsString(strArr2[i][0]);
                } else {
                    pdfFormField.setValueAsString(this.text);
                    pdfFormField.setDefaultValueAsString(this.text);
                }
            }
            if ((this.options & 1) != 0) {
                pdfFormField.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                pdfFormField.setFieldFlags(2);
            }
            if ((this.options & 4194304) != 0) {
                pdfFormField.setFieldFlags(4194304);
            }
        }
        pdfFormField.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        if (z) {
            pdfAppearance = getListAppearance();
            if (this.topFirst > 0) {
                pdfFormField.put(PdfName.f727TI, new PdfNumber(this.topFirst));
            }
        } else {
            pdfAppearance = getAppearance();
        }
        pdfFormField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, pdfAppearance);
        PdfAppearance pdfAppearance2 = (PdfAppearance) pdfAppearance.getDuplicate();
        pdfAppearance2.setFontAndSize(getRealFont(), this.fontSize);
        if (this.textColor == null) {
            pdfAppearance2.setGrayFill(0.0f);
        } else {
            pdfAppearance2.setColorFill(this.textColor);
        }
        pdfFormField.setDefaultAppearanceString(pdfAppearance2);
        if (this.borderColor != null) {
            pdfFormField.setMKBorderColor(this.borderColor);
        }
        if (this.backgroundColor != null) {
            pdfFormField.setMKBackgroundColor(this.backgroundColor);
        }
        int i4 = this.visibility;
        if (i4 == 1) {
            pdfFormField.setFlags(6);
        } else if (i4 != 2) {
            if (i4 != 3) {
                pdfFormField.setFlags(4);
            } else {
                pdfFormField.setFlags(36);
            }
        }
        return pdfFormField;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public void setChoices(String[] strArr) {
        this.choices = strArr;
    }

    public String[] getChoiceExports() {
        return this.choiceExports;
    }

    public void setChoiceExports(String[] strArr) {
        this.choiceExports = strArr;
    }

    public int getChoiceSelection() {
        return this.choiceSelection;
    }

    public void setChoiceSelection(int i) {
        this.choiceSelection = i;
    }

    /* access modifiers changed from: package-private */
    public int getTopFirst() {
        return this.topFirst;
    }

    public void setExtraMargin(float f, float f2) {
        this.extraMarginLeft = f;
        this.extraMarginTop = f2;
    }

    public ArrayList getSubstitutionFonts() {
        return this.substitutionFonts;
    }

    public void setSubstitutionFonts(ArrayList arrayList) {
        this.substitutionFonts = arrayList;
    }

    public BaseFont getExtensionFont() {
        return this.extensionFont;
    }

    public void setExtensionFont(BaseFont baseFont) {
        this.extensionFont = baseFont;
    }
}
