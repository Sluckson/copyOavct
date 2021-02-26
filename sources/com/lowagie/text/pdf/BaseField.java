package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import harmony.java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class BaseField {
    public static final float BORDER_WIDTH_MEDIUM = 2.0f;
    public static final float BORDER_WIDTH_THICK = 3.0f;
    public static final float BORDER_WIDTH_THIN = 1.0f;
    public static final int COMB = 16777216;
    public static final int DO_NOT_SCROLL = 8388608;
    public static final int DO_NOT_SPELL_CHECK = 4194304;
    public static final int EDIT = 262144;
    public static final int FILE_SELECTION = 1048576;
    public static final int HIDDEN = 1;
    public static final int HIDDEN_BUT_PRINTABLE = 3;
    public static final int MULTILINE = 4096;
    public static final int PASSWORD = 8192;
    public static final int READ_ONLY = 1;
    public static final int REQUIRED = 2;
    public static final int VISIBLE = 0;
    public static final int VISIBLE_BUT_DOES_NOT_PRINT = 2;
    private static final HashMap fieldKeys = new HashMap();
    protected int alignment = 0;
    protected Color backgroundColor;
    protected Color borderColor;
    protected int borderStyle = 0;
    protected float borderWidth = 1.0f;
    protected Rectangle box;
    protected String fieldName;
    protected BaseFont font;
    protected float fontSize = 0.0f;
    protected int maxCharacterLength;
    protected int options;
    protected int rotation = 0;
    protected String text;
    protected Color textColor;
    protected int visibility;
    protected PdfWriter writer;

    static {
        fieldKeys.putAll(PdfCopyFieldsImp.fieldKeys);
        fieldKeys.put(PdfName.f723T, new Integer(1));
    }

    public BaseField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        this.writer = pdfWriter;
        setBox(rectangle);
        this.fieldName = str;
    }

    /* access modifiers changed from: protected */
    public BaseFont getRealFont() throws IOException, DocumentException {
        BaseFont baseFont = this.font;
        return baseFont == null ? BaseFont.createFont("Helvetica", "Cp1252", false) : baseFont;
    }

    /* access modifiers changed from: protected */
    public PdfAppearance getBorderAppearance() {
        Color color;
        Color color2;
        Color color3;
        PdfAppearance createAppearance = PdfAppearance.createAppearance(this.writer, this.box.getWidth(), this.box.getHeight());
        int i = this.rotation;
        if (i == 90) {
            createAppearance.setMatrix(0.0f, 1.0f, -1.0f, 0.0f, this.box.getHeight(), 0.0f);
        } else if (i == 180) {
            createAppearance.setMatrix(-1.0f, 0.0f, 0.0f, -1.0f, this.box.getWidth(), this.box.getHeight());
        } else if (i == 270) {
            createAppearance.setMatrix(0.0f, -1.0f, 1.0f, 0.0f, 0.0f, this.box.getWidth());
        }
        createAppearance.saveState();
        Color color4 = this.backgroundColor;
        if (color4 != null) {
            createAppearance.setColorFill(color4);
            createAppearance.rectangle(0.0f, 0.0f, this.box.getWidth(), this.box.getHeight());
            createAppearance.fill();
        }
        int i2 = this.borderStyle;
        if (i2 == 4) {
            if (!(this.borderWidth == 0.0f || (color3 = this.borderColor) == null)) {
                createAppearance.setColorStroke(color3);
                createAppearance.setLineWidth(this.borderWidth);
                createAppearance.moveTo(0.0f, this.borderWidth / 2.0f);
                createAppearance.lineTo(this.box.getWidth(), this.borderWidth / 2.0f);
                createAppearance.stroke();
            }
        } else if (i2 == 2) {
            if (!(this.borderWidth == 0.0f || (color2 = this.borderColor) == null)) {
                createAppearance.setColorStroke(color2);
                createAppearance.setLineWidth(this.borderWidth);
                float f = this.borderWidth;
                createAppearance.rectangle(f / 2.0f, f / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
                createAppearance.stroke();
            }
            Color color5 = this.backgroundColor;
            if (color5 == null) {
                color5 = Color.white;
            }
            createAppearance.setGrayFill(1.0f);
            drawTopFrame(createAppearance);
            createAppearance.setColorFill(color5.darker());
            drawBottomFrame(createAppearance);
        } else if (i2 == 3) {
            if (!(this.borderWidth == 0.0f || (color = this.borderColor) == null)) {
                createAppearance.setColorStroke(color);
                createAppearance.setLineWidth(this.borderWidth);
                float f2 = this.borderWidth;
                createAppearance.rectangle(f2 / 2.0f, f2 / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
                createAppearance.stroke();
            }
            createAppearance.setGrayFill(0.5f);
            drawTopFrame(createAppearance);
            createAppearance.setGrayFill(0.75f);
            drawBottomFrame(createAppearance);
        } else if (!(this.borderWidth == 0.0f || this.borderColor == null)) {
            if (i2 == 1) {
                createAppearance.setLineDash(3.0f, 0.0f);
            }
            createAppearance.setColorStroke(this.borderColor);
            createAppearance.setLineWidth(this.borderWidth);
            float f3 = this.borderWidth;
            createAppearance.rectangle(f3 / 2.0f, f3 / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
            createAppearance.stroke();
            if ((this.options & 16777216) != 0 && this.maxCharacterLength > 1) {
                float width = this.box.getWidth() / ((float) this.maxCharacterLength);
                float f4 = this.borderWidth / 2.0f;
                float height = this.box.getHeight() - (this.borderWidth / 2.0f);
                for (int i3 = 1; i3 < this.maxCharacterLength; i3++) {
                    float f5 = ((float) i3) * width;
                    createAppearance.moveTo(f5, f4);
                    createAppearance.lineTo(f5, height);
                }
                createAppearance.stroke();
            }
        }
        createAppearance.restoreState();
        return createAppearance;
    }

    protected static ArrayList getHardBreaks(String str) {
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < length) {
            char c = charArray[i];
            if (c == 13) {
                int i2 = i + 1;
                if (i2 < length && charArray[i2] == 10) {
                    i = i2;
                }
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else if (c == 10) {
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }

    protected static void trimRight(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        while (length != 0) {
            length--;
            if (stringBuffer.charAt(length) == ' ') {
                stringBuffer.setLength(length);
            } else {
                return;
            }
        }
    }

    protected static ArrayList breakLines(ArrayList arrayList, BaseFont baseFont, float f, float f2) {
        BaseFont baseFont2 = baseFont;
        float f3 = f;
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            stringBuffer.setLength(i);
            char[] charArray = ((String) arrayList.get(i2)).toCharArray();
            int length = charArray.length;
            int i3 = 0;
            char c = 0;
            float f4 = 0.0f;
            int i4 = -1;
            int i5 = 0;
            while (i3 < length) {
                char c2 = charArray[i3];
                if (c != 0) {
                    if (c == 1) {
                        f4 += baseFont2.getWidthPoint((int) c2, f3);
                        stringBuffer.append(c2);
                        if (c2 == ' ') {
                            i4 = i3;
                        }
                        if (f4 > f2) {
                            if (i4 >= 0) {
                                stringBuffer.setLength(i4 - i5);
                                trimRight(stringBuffer);
                                arrayList2.add(stringBuffer.toString());
                                stringBuffer.setLength(0);
                                i3 = i4;
                                i5 = i3;
                                c = 2;
                                f4 = 0.0f;
                                i4 = -1;
                            } else {
                                if (stringBuffer.length() > 1) {
                                    i3--;
                                    stringBuffer.setLength(stringBuffer.length() - 1);
                                }
                                arrayList2.add(stringBuffer.toString());
                                stringBuffer.setLength(0);
                                if (c2 != ' ') {
                                    i5 = i3;
                                    f4 = 0.0f;
                                }
                                i5 = i3;
                                c = 2;
                                f4 = 0.0f;
                            }
                        }
                    } else if (c == 2 && c2 != ' ') {
                        i3--;
                    }
                    i3++;
                    i = 0;
                } else {
                    f4 += baseFont2.getWidthPoint((int) c2, f3);
                    stringBuffer.append(c2);
                    if (f4 > f2) {
                        if (stringBuffer.length() > 1) {
                            i3--;
                            stringBuffer.setLength(stringBuffer.length() - 1);
                        }
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        if (c2 != ' ') {
                            i5 = i3;
                        }
                        i5 = i3;
                        c = 2;
                        f4 = 0.0f;
                        i3++;
                        i = 0;
                    } else {
                        if (c2 != ' ') {
                            c = 1;
                        }
                        i3++;
                        i = 0;
                    }
                }
                c = 1;
                f4 = 0.0f;
                i3++;
                i = 0;
            }
            trimRight(stringBuffer);
            arrayList2.add(stringBuffer.toString());
        }
        return arrayList2;
    }

    private void drawTopFrame(PdfAppearance pdfAppearance) {
        float f = this.borderWidth;
        pdfAppearance.moveTo(f, f);
        pdfAppearance.lineTo(this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - (this.borderWidth * 2.0f), this.box.getHeight() - (this.borderWidth * 2.0f));
        pdfAppearance.lineTo(this.borderWidth * 2.0f, this.box.getHeight() - (this.borderWidth * 2.0f));
        float f2 = this.borderWidth;
        pdfAppearance.lineTo(f2 * 2.0f, f2 * 2.0f);
        float f3 = this.borderWidth;
        pdfAppearance.lineTo(f3, f3);
        pdfAppearance.fill();
    }

    private void drawBottomFrame(PdfAppearance pdfAppearance) {
        float f = this.borderWidth;
        pdfAppearance.moveTo(f, f);
        float width = this.box.getWidth();
        float f2 = this.borderWidth;
        pdfAppearance.lineTo(width - f2, f2);
        pdfAppearance.lineTo(this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - (this.borderWidth * 2.0f), this.box.getHeight() - (this.borderWidth * 2.0f));
        float width2 = this.box.getWidth();
        float f3 = this.borderWidth;
        pdfAppearance.lineTo(width2 - (f3 * 2.0f), f3 * 2.0f);
        float f4 = this.borderWidth;
        pdfAppearance.lineTo(f4 * 2.0f, f4 * 2.0f);
        float f5 = this.borderWidth;
        pdfAppearance.lineTo(f5, f5);
        pdfAppearance.fill();
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public void setBorderWidth(float f) {
        this.borderWidth = f;
    }

    public int getBorderStyle() {
        return this.borderStyle;
    }

    public void setBorderStyle(int i) {
        this.borderStyle = i;
    }

    public Color getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public Color getTextColor() {
        return this.textColor;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
    }

    public BaseFont getFont() {
        return this.font;
    }

    public void setFont(BaseFont baseFont) {
        this.font = baseFont;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(float f) {
        this.fontSize = f;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public Rectangle getBox() {
        return this.box;
    }

    public void setBox(Rectangle rectangle) {
        if (rectangle == null) {
            this.box = null;
            return;
        }
        this.box = new Rectangle(rectangle);
        this.box.normalize();
    }

    public int getRotation() {
        return this.rotation;
    }

    public void setRotation(int i) {
        if (i % 90 == 0) {
            int i2 = i % 360;
            if (i2 < 0) {
                i2 += 360;
            }
            this.rotation = i2;
            return;
        }
        throw new IllegalArgumentException("Rotation must be a multiple of 90.");
    }

    public void setRotationFromPage(Rectangle rectangle) {
        setRotation(rectangle.getRotation());
    }

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int i) {
        this.visibility = i;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public int getOptions() {
        return this.options;
    }

    public void setOptions(int i) {
        this.options = i;
    }

    public int getMaxCharacterLength() {
        return this.maxCharacterLength;
    }

    public void setMaxCharacterLength(int i) {
        this.maxCharacterLength = i;
    }

    public PdfWriter getWriter() {
        return this.writer;
    }

    public void setWriter(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public static void moveFields(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        Iterator it = pdfDictionary.getKeys().iterator();
        while (it.hasNext()) {
            PdfName pdfName = (PdfName) it.next();
            if (fieldKeys.containsKey(pdfName)) {
                if (pdfDictionary2 != null) {
                    pdfDictionary2.put(pdfName, pdfDictionary.get(pdfName));
                }
                it.remove();
            }
        }
    }
}
