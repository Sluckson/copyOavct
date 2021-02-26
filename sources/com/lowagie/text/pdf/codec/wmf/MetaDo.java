package com.lowagie.text.pdf.codec.wmf;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.codec.BmpImage;
import harmony.java.awt.Color;
import harmony.java.awt.Point;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MetaDo {
    public static final int META_ANIMATEPALETTE = 1078;
    public static final int META_ARC = 2071;
    public static final int META_BITBLT = 2338;
    public static final int META_CHORD = 2096;
    public static final int META_CREATEBRUSHINDIRECT = 764;
    public static final int META_CREATEFONTINDIRECT = 763;
    public static final int META_CREATEPALETTE = 247;
    public static final int META_CREATEPATTERNBRUSH = 505;
    public static final int META_CREATEPENINDIRECT = 762;
    public static final int META_CREATEREGION = 1791;
    public static final int META_DELETEOBJECT = 496;
    public static final int META_DIBBITBLT = 2368;
    public static final int META_DIBCREATEPATTERNBRUSH = 322;
    public static final int META_DIBSTRETCHBLT = 2881;
    public static final int META_ELLIPSE = 1048;
    public static final int META_ESCAPE = 1574;
    public static final int META_EXCLUDECLIPRECT = 1045;
    public static final int META_EXTFLOODFILL = 1352;
    public static final int META_EXTTEXTOUT = 2610;
    public static final int META_FILLREGION = 552;
    public static final int META_FLOODFILL = 1049;
    public static final int META_FRAMEREGION = 1065;
    public static final int META_INTERSECTCLIPRECT = 1046;
    public static final int META_INVERTREGION = 298;
    public static final int META_LINETO = 531;
    public static final int META_MOVETO = 532;
    public static final int META_OFFSETCLIPRGN = 544;
    public static final int META_OFFSETVIEWPORTORG = 529;
    public static final int META_OFFSETWINDOWORG = 527;
    public static final int META_PAINTREGION = 299;
    public static final int META_PATBLT = 1565;
    public static final int META_PIE = 2074;
    public static final int META_POLYGON = 804;
    public static final int META_POLYLINE = 805;
    public static final int META_POLYPOLYGON = 1336;
    public static final int META_REALIZEPALETTE = 53;
    public static final int META_RECTANGLE = 1051;
    public static final int META_RESIZEPALETTE = 313;
    public static final int META_RESTOREDC = 295;
    public static final int META_ROUNDRECT = 1564;
    public static final int META_SAVEDC = 30;
    public static final int META_SCALEVIEWPORTEXT = 1042;
    public static final int META_SCALEWINDOWEXT = 1040;
    public static final int META_SELECTCLIPREGION = 300;
    public static final int META_SELECTOBJECT = 301;
    public static final int META_SELECTPALETTE = 564;
    public static final int META_SETBKCOLOR = 513;
    public static final int META_SETBKMODE = 258;
    public static final int META_SETDIBTODEV = 3379;
    public static final int META_SETMAPMODE = 259;
    public static final int META_SETMAPPERFLAGS = 561;
    public static final int META_SETPALENTRIES = 55;
    public static final int META_SETPIXEL = 1055;
    public static final int META_SETPOLYFILLMODE = 262;
    public static final int META_SETRELABS = 261;
    public static final int META_SETROP2 = 260;
    public static final int META_SETSTRETCHBLTMODE = 263;
    public static final int META_SETTEXTALIGN = 302;
    public static final int META_SETTEXTCHAREXTRA = 264;
    public static final int META_SETTEXTCOLOR = 521;
    public static final int META_SETTEXTJUSTIFICATION = 522;
    public static final int META_SETVIEWPORTEXT = 526;
    public static final int META_SETVIEWPORTORG = 525;
    public static final int META_SETWINDOWEXT = 524;
    public static final int META_SETWINDOWORG = 523;
    public static final int META_STRETCHBLT = 2851;
    public static final int META_STRETCHDIB = 3907;
    public static final int META_TEXTOUT = 1313;
    int bottom;

    /* renamed from: cb */
    public PdfContentByte f791cb;

    /* renamed from: in */
    public InputMeta f792in;
    int inch;
    int left;
    int right;
    MetaState state = new MetaState();
    int top;

    public MetaDo(InputStream inputStream, PdfContentByte pdfContentByte) {
        this.f791cb = pdfContentByte;
        this.f792in = new InputMeta(inputStream);
    }

    public void readAll() throws IOException, DocumentException {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        if (this.f792in.readInt() == -1698247209) {
            this.f792in.readWord();
            this.left = this.f792in.readShort();
            this.top = this.f792in.readShort();
            this.right = this.f792in.readShort();
            this.bottom = this.f792in.readShort();
            this.inch = this.f792in.readWord();
            this.state.setScalingX((((float) (this.right - this.left)) / ((float) this.inch)) * 72.0f);
            this.state.setScalingY((((float) (this.bottom - this.top)) / ((float) this.inch)) * 72.0f);
            this.state.setOffsetWx(this.left);
            this.state.setOffsetWy(this.top);
            this.state.setExtentWx(this.right - this.left);
            this.state.setExtentWy(this.bottom - this.top);
            this.f792in.readInt();
            this.f792in.readWord();
            this.f792in.skip(18);
            this.f791cb.setLineCap(1);
            this.f791cb.setLineJoin(1);
            while (true) {
                int length = this.f792in.getLength();
                int readInt = this.f792in.readInt();
                if (readInt < 3) {
                    this.state.cleanup(this.f791cb);
                    return;
                }
                int readWord = this.f792in.readWord();
                int i5 = 0;
                switch (readWord) {
                    case 30:
                        this.state.saveState(this.f791cb);
                        break;
                    case META_CREATEPALETTE /*247*/:
                    case 322:
                    case META_CREATEREGION /*1791*/:
                        this.state.addMetaObject(new MetaObject());
                        break;
                    case 258:
                        this.state.setBackgroundMode(this.f792in.readWord());
                        break;
                    case 262:
                        this.state.setPolyFillMode(this.f792in.readWord());
                        break;
                    case META_RESTOREDC /*295*/:
                        this.state.restoreState(this.f792in.readShort(), this.f791cb);
                        break;
                    case 301:
                        this.state.selectMetaObject(this.f792in.readWord(), this.f791cb);
                        break;
                    case 302:
                        this.state.setTextAlign(this.f792in.readWord());
                        break;
                    case META_DELETEOBJECT /*496*/:
                        this.state.deleteMetaObject(this.f792in.readWord());
                        break;
                    case 513:
                        this.state.setCurrentBackgroundColor(this.f792in.readColor());
                        break;
                    case 521:
                        this.state.setCurrentTextColor(this.f792in.readColor());
                        break;
                    case META_SETWINDOWORG /*523*/:
                        this.state.setOffsetWy(this.f792in.readShort());
                        this.state.setOffsetWx(this.f792in.readShort());
                        break;
                    case META_SETWINDOWEXT /*524*/:
                        this.state.setExtentWy(this.f792in.readShort());
                        this.state.setExtentWx(this.f792in.readShort());
                        break;
                    case 531:
                        int readShort = this.f792in.readShort();
                        int readShort2 = this.f792in.readShort();
                        Point currentPoint = this.state.getCurrentPoint();
                        this.f791cb.moveTo(this.state.transformX(currentPoint.f4903x), this.state.transformY(currentPoint.f4904y));
                        this.f791cb.lineTo(this.state.transformX(readShort2), this.state.transformY(readShort));
                        this.f791cb.stroke();
                        this.state.setCurrentPoint(new Point(readShort2, readShort));
                        break;
                    case 532:
                        this.state.setCurrentPoint(new Point(this.f792in.readShort(), this.f792in.readShort()));
                        break;
                    case META_CREATEPENINDIRECT /*762*/:
                        MetaPen metaPen = new MetaPen();
                        metaPen.init(this.f792in);
                        this.state.addMetaObject(metaPen);
                        break;
                    case META_CREATEFONTINDIRECT /*763*/:
                        MetaFont metaFont = new MetaFont();
                        metaFont.init(this.f792in);
                        this.state.addMetaObject(metaFont);
                        break;
                    case META_CREATEBRUSHINDIRECT /*764*/:
                        MetaBrush metaBrush = new MetaBrush();
                        metaBrush.init(this.f792in);
                        this.state.addMetaObject(metaBrush);
                        break;
                    case META_POLYGON /*804*/:
                        if (!isNullStrokeFill(false)) {
                            int readWord2 = this.f792in.readWord();
                            int readShort3 = this.f792in.readShort();
                            int readShort4 = this.f792in.readShort();
                            this.f791cb.moveTo(this.state.transformX(readShort3), this.state.transformY(readShort4));
                            for (int i6 = 1; i6 < readWord2; i6++) {
                                this.f791cb.lineTo(this.state.transformX(this.f792in.readShort()), this.state.transformY(this.f792in.readShort()));
                            }
                            this.f791cb.lineTo(this.state.transformX(readShort3), this.state.transformY(readShort4));
                            strokeAndFill();
                            break;
                        } else {
                            break;
                        }
                    case META_POLYLINE /*805*/:
                        this.state.setLineJoinPolygon(this.f791cb);
                        int readWord3 = this.f792in.readWord();
                        this.f791cb.moveTo(this.state.transformX(this.f792in.readShort()), this.state.transformY(this.f792in.readShort()));
                        for (int i7 = 1; i7 < readWord3; i7++) {
                            this.f791cb.lineTo(this.state.transformX(this.f792in.readShort()), this.state.transformY(this.f792in.readShort()));
                        }
                        this.f791cb.stroke();
                        break;
                    case META_INTERSECTCLIPRECT /*1046*/:
                        float transformY = this.state.transformY(this.f792in.readShort());
                        float transformX = this.state.transformX(this.f792in.readShort());
                        float transformY2 = this.state.transformY(this.f792in.readShort());
                        float transformX2 = this.state.transformX(this.f792in.readShort());
                        this.f791cb.rectangle(transformX2, transformY, transformX - transformX2, transformY2 - transformY);
                        this.f791cb.eoClip();
                        this.f791cb.newPath();
                        break;
                    case META_ELLIPSE /*1048*/:
                        if (!isNullStrokeFill(this.state.getLineNeutral())) {
                            this.f791cb.arc(this.state.transformX(this.f792in.readShort()), this.state.transformY(this.f792in.readShort()), this.state.transformX(this.f792in.readShort()), this.state.transformY(this.f792in.readShort()), 0.0f, 360.0f);
                            strokeAndFill();
                            break;
                        } else {
                            break;
                        }
                    case META_RECTANGLE /*1051*/:
                        if (!isNullStrokeFill(true)) {
                            float transformY3 = this.state.transformY(this.f792in.readShort());
                            float transformX3 = this.state.transformX(this.f792in.readShort());
                            float transformY4 = this.state.transformY(this.f792in.readShort());
                            float transformX4 = this.state.transformX(this.f792in.readShort());
                            this.f791cb.rectangle(transformX4, transformY3, transformX3 - transformX4, transformY4 - transformY3);
                            strokeAndFill();
                            break;
                        } else {
                            break;
                        }
                    case META_SETPIXEL /*1055*/:
                        Color readColor = this.f792in.readColor();
                        int readShort5 = this.f792in.readShort();
                        int readShort6 = this.f792in.readShort();
                        this.f791cb.saveState();
                        this.f791cb.setColorFill(readColor);
                        this.f791cb.rectangle(this.state.transformX(readShort6), this.state.transformY(readShort5), 0.2f, 0.2f);
                        this.f791cb.fill();
                        this.f791cb.restoreState();
                        break;
                    case META_TEXTOUT /*1313*/:
                        int readWord4 = this.f792in.readWord();
                        byte[] bArr = new byte[readWord4];
                        int i8 = 0;
                        while (i8 < readWord4) {
                            byte readByte = (byte) this.f792in.readByte();
                            if (readByte != 0) {
                                bArr[i8] = readByte;
                                i8++;
                            }
                        }
                        try {
                            str = new String(bArr, 0, i8, "Cp1252");
                        } catch (UnsupportedEncodingException unused) {
                            str = new String(bArr, 0, i8);
                        }
                        this.f792in.skip(((readWord4 + 1) & 65534) - i8);
                        outputText(this.f792in.readShort(), this.f792in.readShort(), 0, 0, 0, 0, 0, str);
                        break;
                    case META_POLYPOLYGON /*1336*/:
                        if (!isNullStrokeFill(false)) {
                            int[] iArr = new int[this.f792in.readWord()];
                            for (int i9 = 0; i9 < iArr.length; i9++) {
                                iArr[i9] = this.f792in.readWord();
                            }
                            for (int i10 : iArr) {
                                int readShort7 = this.f792in.readShort();
                                int readShort8 = this.f792in.readShort();
                                this.f791cb.moveTo(this.state.transformX(readShort7), this.state.transformY(readShort8));
                                for (int i11 = 1; i11 < i10; i11++) {
                                    this.f791cb.lineTo(this.state.transformX(this.f792in.readShort()), this.state.transformY(this.f792in.readShort()));
                                }
                                this.f791cb.lineTo(this.state.transformX(readShort7), this.state.transformY(readShort8));
                            }
                            strokeAndFill();
                            break;
                        } else {
                            break;
                        }
                    case META_ROUNDRECT /*1564*/:
                        if (!isNullStrokeFill(true)) {
                            float transformY5 = this.state.transformY(0) - this.state.transformY(this.f792in.readShort());
                            float transformX5 = this.state.transformX(this.f792in.readShort()) - this.state.transformX(0);
                            float transformY6 = this.state.transformY(this.f792in.readShort());
                            float transformX6 = this.state.transformX(this.f792in.readShort());
                            float transformY7 = this.state.transformY(this.f792in.readShort());
                            float transformX7 = this.state.transformX(this.f792in.readShort());
                            this.f791cb.roundRectangle(transformX7, transformY6, transformX6 - transformX7, transformY7 - transformY6, (transformY5 + transformX5) / 4.0f);
                            strokeAndFill();
                            break;
                        } else {
                            break;
                        }
                    case META_ARC /*2071*/:
                        if (!isNullStrokeFill(this.state.getLineNeutral())) {
                            float transformY8 = this.state.transformY(this.f792in.readShort());
                            float transformX8 = this.state.transformX(this.f792in.readShort());
                            float transformY9 = this.state.transformY(this.f792in.readShort());
                            float transformX9 = this.state.transformX(this.f792in.readShort());
                            float transformY10 = this.state.transformY(this.f792in.readShort());
                            float transformX10 = this.state.transformX(this.f792in.readShort());
                            float transformY11 = this.state.transformY(this.f792in.readShort());
                            float transformX11 = this.state.transformX(this.f792in.readShort());
                            float f = (transformX10 + transformX11) / 2.0f;
                            float f2 = (transformY11 + transformY10) / 2.0f;
                            float arc = getArc(f, f2, transformX9, transformY9);
                            float arc2 = getArc(f, f2, transformX8, transformY8) - arc;
                            if (arc2 <= 0.0f) {
                                arc2 += 360.0f;
                            }
                            this.f791cb.arc(transformX11, transformY10, transformX10, transformY11, arc, arc2);
                            this.f791cb.stroke();
                            break;
                        } else {
                            break;
                        }
                    case META_PIE /*2074*/:
                        if (!isNullStrokeFill(this.state.getLineNeutral())) {
                            float transformY12 = this.state.transformY(this.f792in.readShort());
                            float transformX12 = this.state.transformX(this.f792in.readShort());
                            float transformY13 = this.state.transformY(this.f792in.readShort());
                            float transformX13 = this.state.transformX(this.f792in.readShort());
                            float transformY14 = this.state.transformY(this.f792in.readShort());
                            float transformX14 = this.state.transformX(this.f792in.readShort());
                            float transformY15 = this.state.transformY(this.f792in.readShort());
                            float transformX15 = this.state.transformX(this.f792in.readShort());
                            float f3 = (transformX14 + transformX15) / 2.0f;
                            float f4 = (transformY15 + transformY14) / 2.0f;
                            float arc3 = getArc(f3, f4, transformX13, transformY13);
                            float arc4 = getArc(f3, f4, transformX12, transformY12) - arc3;
                            if (arc4 <= 0.0f) {
                                arc4 += 360.0f;
                            }
                            ArrayList bezierArc = PdfContentByte.bezierArc(transformX15, transformY14, transformX14, transformY15, arc3, arc4);
                            if (!bezierArc.isEmpty()) {
                                float[] fArr = (float[]) bezierArc.get(0);
                                this.f791cb.moveTo(f3, f4);
                                this.f791cb.lineTo(fArr[0], fArr[1]);
                                while (i5 < bezierArc.size()) {
                                    float[] fArr2 = (float[]) bezierArc.get(i5);
                                    this.f791cb.curveTo(fArr2[2], fArr2[3], fArr2[4], fArr2[5], fArr2[6], fArr2[7]);
                                    i5++;
                                }
                                this.f791cb.lineTo(f3, f4);
                                strokeAndFill();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case META_CHORD /*2096*/:
                        if (!isNullStrokeFill(this.state.getLineNeutral())) {
                            float transformY16 = this.state.transformY(this.f792in.readShort());
                            float transformX16 = this.state.transformX(this.f792in.readShort());
                            float transformY17 = this.state.transformY(this.f792in.readShort());
                            float transformX17 = this.state.transformX(this.f792in.readShort());
                            float transformY18 = this.state.transformY(this.f792in.readShort());
                            float transformX18 = this.state.transformX(this.f792in.readShort());
                            float transformY19 = this.state.transformY(this.f792in.readShort());
                            float transformX19 = this.state.transformX(this.f792in.readShort());
                            float f5 = (transformX18 + transformX19) / 2.0f;
                            float f6 = (transformY19 + transformY18) / 2.0f;
                            float arc5 = getArc(f5, f6, transformX17, transformY17);
                            float arc6 = getArc(f5, f6, transformX16, transformY16) - arc5;
                            if (arc6 <= 0.0f) {
                                arc6 += 360.0f;
                            }
                            ArrayList bezierArc2 = PdfContentByte.bezierArc(transformX19, transformY18, transformX18, transformY19, arc5, arc6);
                            if (!bezierArc2.isEmpty()) {
                                float[] fArr3 = (float[]) bezierArc2.get(0);
                                float f7 = fArr3[0];
                                float f8 = fArr3[1];
                                this.f791cb.moveTo(f7, f8);
                                while (i5 < bezierArc2.size()) {
                                    float[] fArr4 = (float[]) bezierArc2.get(i5);
                                    this.f791cb.curveTo(fArr4[2], fArr4[3], fArr4[4], fArr4[5], fArr4[6], fArr4[7]);
                                    i5++;
                                }
                                this.f791cb.lineTo(f7, f8);
                                strokeAndFill();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case META_EXTTEXTOUT /*2610*/:
                        int readShort9 = this.f792in.readShort();
                        int readShort10 = this.f792in.readShort();
                        int readWord5 = this.f792in.readWord();
                        int readWord6 = this.f792in.readWord();
                        if ((readWord6 & 6) != 0) {
                            int readShort11 = this.f792in.readShort();
                            i4 = readShort11;
                            i3 = this.f792in.readShort();
                            i2 = this.f792in.readShort();
                            i = this.f792in.readShort();
                        } else {
                            i4 = 0;
                            i3 = 0;
                            i2 = 0;
                            i = 0;
                        }
                        byte[] bArr2 = new byte[readWord5];
                        int i12 = 0;
                        while (i12 < readWord5) {
                            byte readByte2 = (byte) this.f792in.readByte();
                            if (readByte2 != 0) {
                                bArr2[i12] = readByte2;
                                i12++;
                            }
                        }
                        try {
                            str2 = new String(bArr2, 0, i12, "Cp1252");
                        } catch (UnsupportedEncodingException unused2) {
                            str2 = new String(bArr2, 0, i12);
                        }
                        outputText(readShort10, readShort9, readWord6, i4, i3, i2, i, str2);
                        break;
                    case META_DIBSTRETCHBLT /*2881*/:
                    case META_STRETCHDIB /*3907*/:
                        this.f792in.readInt();
                        if (readWord == 3907) {
                            this.f792in.readWord();
                        }
                        int readShort12 = this.f792in.readShort();
                        int readShort13 = this.f792in.readShort();
                        int readShort14 = this.f792in.readShort();
                        int readShort15 = this.f792in.readShort();
                        float transformY20 = this.state.transformY(this.f792in.readShort()) - this.state.transformY(0);
                        float transformX20 = this.state.transformX(this.f792in.readShort()) - this.state.transformX(0);
                        float transformY21 = this.state.transformY(this.f792in.readShort());
                        float transformX21 = this.state.transformX(this.f792in.readShort());
                        byte[] bArr3 = new byte[((readInt * 2) - (this.f792in.getLength() - length))];
                        while (i5 < bArr3.length) {
                            bArr3[i5] = (byte) this.f792in.readByte();
                            i5++;
                        }
                        try {
                            Image image = BmpImage.getImage(new ByteArrayInputStream(bArr3), true, bArr3.length);
                            this.f791cb.saveState();
                            this.f791cb.rectangle(transformX21, transformY21, transformX20, transformY20);
                            this.f791cb.clip();
                            this.f791cb.newPath();
                            float f9 = (float) readShort13;
                            float f10 = (float) readShort12;
                            image.scaleAbsolute((image.getWidth() * transformX20) / f9, ((-transformY20) * image.getHeight()) / f10);
                            image.setAbsolutePosition(transformX21 - ((transformX20 * ((float) readShort15)) / f9), (transformY21 + ((transformY20 * ((float) readShort14)) / f10)) - image.getScaledHeight());
                            this.f791cb.addImage(image);
                            this.f791cb.restoreState();
                            break;
                        } catch (Exception unused3) {
                            break;
                        }
                }
                InputMeta inputMeta = this.f792in;
                inputMeta.skip((readInt * 2) - (inputMeta.getLength() - length));
            }
        } else {
            throw new DocumentException("Not a placeable windows metafile");
        }
    }

    public void outputText(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        String str2 = str;
        MetaFont currentFont = this.state.getCurrentFont();
        float transformX = this.state.transformX(i);
        float transformY = this.state.transformY(i2);
        double transformAngle = (double) this.state.transformAngle(currentFont.getAngle());
        float sin = (float) Math.sin(transformAngle);
        float cos = (float) Math.cos(transformAngle);
        float fontSize = currentFont.getFontSize(this.state);
        BaseFont font = currentFont.getFont();
        int textAlign = this.state.getTextAlign();
        float widthPoint = font.getWidthPoint(str2, fontSize);
        float fontDescriptor = font.getFontDescriptor(3, fontSize);
        float fontDescriptor2 = font.getFontDescriptor(8, fontSize);
        this.f791cb.saveState();
        this.f791cb.concatCTM(cos, sin, -sin, cos, transformX, transformY);
        float f = 0.0f;
        float f2 = (textAlign & 6) == 6 ? (-widthPoint) / 2.0f : (textAlign & 2) == 2 ? -widthPoint : 0.0f;
        if ((textAlign & 24) != 24) {
            f = (textAlign & 8) == 8 ? -fontDescriptor : -fontDescriptor2;
        }
        if (this.state.getBackgroundMode() == 2) {
            this.f791cb.setColorFill(this.state.getCurrentBackgroundColor());
            this.f791cb.rectangle(f2, f + fontDescriptor, widthPoint, fontDescriptor2 - fontDescriptor);
            this.f791cb.fill();
        }
        this.f791cb.setColorFill(this.state.getCurrentTextColor());
        this.f791cb.beginText();
        this.f791cb.setFontAndSize(font, fontSize);
        this.f791cb.setTextMatrix(f2, f);
        this.f791cb.showText(str2);
        this.f791cb.endText();
        if (currentFont.isUnderline()) {
            this.f791cb.rectangle(f2, f - (fontSize / 4.0f), widthPoint, fontSize / 15.0f);
            this.f791cb.fill();
        }
        if (currentFont.isStrikeout()) {
            this.f791cb.rectangle(f2, f + (fontSize / 3.0f), widthPoint, fontSize / 15.0f);
            this.f791cb.fill();
        }
        this.f791cb.restoreState();
    }

    public boolean isNullStrokeFill(boolean z) {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        boolean z2 = true;
        boolean z3 = currentPen.getStyle() == 5;
        int style = currentBrush.getStyle();
        boolean z4 = style == 0 || (style == 2 && this.state.getBackgroundMode() == 2);
        if (!z3 || z4) {
            z2 = false;
        }
        if (!z3) {
            if (z) {
                this.state.setLineJoinRectangle(this.f791cb);
            } else {
                this.state.setLineJoinPolygon(this.f791cb);
            }
        }
        return z2;
    }

    public void strokeAndFill() {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        int style = currentPen.getStyle();
        int style2 = currentBrush.getStyle();
        if (style == 5) {
            this.f791cb.closePath();
            if (this.state.getPolyFillMode() == 1) {
                this.f791cb.eoFill();
            } else {
                this.f791cb.fill();
            }
        } else {
            if (!(style2 == 0 || (style2 == 2 && this.state.getBackgroundMode() == 2))) {
                this.f791cb.closePathStroke();
            } else if (this.state.getPolyFillMode() == 1) {
                this.f791cb.closePathEoFillStroke();
            } else {
                this.f791cb.closePathFillStroke();
            }
        }
    }

    static float getArc(float f, float f2, float f3, float f4) {
        double atan2 = Math.atan2((double) (f4 - f2), (double) (f3 - f));
        if (atan2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            atan2 += 6.283185307179586d;
        }
        return (float) ((atan2 / 3.141592653589793d) * 180.0d);
    }

    public static byte[] wrapBMP(Image image) throws IOException {
        byte[] bArr;
        if (image.getOriginalType() == 4) {
            if (image.getOriginalData() == null) {
                InputStream openStream = FirebasePerfUrlConnection.openStream(image.getUrl());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = openStream.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                openStream.close();
                bArr = byteArrayOutputStream.toByteArray();
            } else {
                bArr = image.getOriginalData();
            }
            int length = ((bArr.length - 14) + 1) >>> 1;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            writeWord(byteArrayOutputStream2, 1);
            writeWord(byteArrayOutputStream2, 9);
            writeWord(byteArrayOutputStream2, 768);
            int i = length + 13;
            writeDWord(byteArrayOutputStream2, i + 23 + 3);
            writeWord(byteArrayOutputStream2, 1);
            writeDWord(byteArrayOutputStream2, length + 14);
            writeWord(byteArrayOutputStream2, 0);
            writeDWord(byteArrayOutputStream2, 4);
            writeWord(byteArrayOutputStream2, 259);
            writeWord(byteArrayOutputStream2, 8);
            writeDWord(byteArrayOutputStream2, 5);
            writeWord(byteArrayOutputStream2, META_SETWINDOWORG);
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, 0);
            writeDWord(byteArrayOutputStream2, 5);
            writeWord(byteArrayOutputStream2, META_SETWINDOWEXT);
            writeWord(byteArrayOutputStream2, (int) image.getHeight());
            writeWord(byteArrayOutputStream2, (int) image.getWidth());
            writeDWord(byteArrayOutputStream2, i);
            writeWord(byteArrayOutputStream2, META_DIBSTRETCHBLT);
            writeDWord(byteArrayOutputStream2, 13369376);
            writeWord(byteArrayOutputStream2, (int) image.getHeight());
            writeWord(byteArrayOutputStream2, (int) image.getWidth());
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, (int) image.getHeight());
            writeWord(byteArrayOutputStream2, (int) image.getWidth());
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, 0);
            byteArrayOutputStream2.write(bArr, 14, bArr.length - 14);
            if ((bArr.length & 1) == 1) {
                byteArrayOutputStream2.write(0);
            }
            writeDWord(byteArrayOutputStream2, 3);
            writeWord(byteArrayOutputStream2, 0);
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        }
        throw new IOException("Only BMP can be wrapped in WMF.");
    }

    public static void writeWord(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >>> 8) & 255);
    }

    public static void writeDWord(OutputStream outputStream, int i) throws IOException {
        writeWord(outputStream, i & 65535);
        writeWord(outputStream, (i >>> 16) & 65535);
    }
}
