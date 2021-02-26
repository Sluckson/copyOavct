package com.lowagie.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.exceptions.IllegalPdfSyntaxException;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.pdf.internal.PdfXConformanceImp;
import harmony.java.awt.Color;
import harmony.java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;

public class PdfContentByte {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    public static final int LINE_CAP_BUTT = 0;
    public static final int LINE_CAP_PROJECTING_SQUARE = 2;
    public static final int LINE_CAP_ROUND = 1;
    public static final int LINE_JOIN_BEVEL = 2;
    public static final int LINE_JOIN_MITER = 0;
    public static final int LINE_JOIN_ROUND = 1;
    public static final int TEXT_RENDER_MODE_CLIP = 7;
    public static final int TEXT_RENDER_MODE_FILL = 0;
    public static final int TEXT_RENDER_MODE_FILL_CLIP = 4;
    public static final int TEXT_RENDER_MODE_FILL_STROKE = 2;
    public static final int TEXT_RENDER_MODE_FILL_STROKE_CLIP = 6;
    public static final int TEXT_RENDER_MODE_INVISIBLE = 3;
    public static final int TEXT_RENDER_MODE_STROKE = 1;
    public static final int TEXT_RENDER_MODE_STROKE_CLIP = 5;
    private static HashMap abrev = new HashMap();
    private static final float[] unitRect = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    protected ByteBuffer content = new ByteBuffer();
    private boolean inText = false;
    protected ArrayList layerDepth;
    private int mcDepth = 0;
    protected PdfDocument pdf;
    protected int separator = 10;
    protected GraphicState state = new GraphicState();
    protected ArrayList stateList = new ArrayList();
    protected PdfWriter writer;

    static class GraphicState {
        protected float charSpace = 0.0f;
        ColorDetails colorDetails;
        FontDetails fontDetails;
        protected float leading = 0.0f;
        protected float scale = 100.0f;
        float size;
        protected float wordSpace = 0.0f;
        protected float xTLM = 0.0f;
        protected float yTLM = 0.0f;

        GraphicState() {
        }

        GraphicState(GraphicState graphicState) {
            this.fontDetails = graphicState.fontDetails;
            this.colorDetails = graphicState.colorDetails;
            this.size = graphicState.size;
            this.xTLM = graphicState.xTLM;
            this.yTLM = graphicState.yTLM;
            this.leading = graphicState.leading;
            this.scale = graphicState.scale;
            this.charSpace = graphicState.charSpace;
            this.wordSpace = graphicState.wordSpace;
        }
    }

    static {
        abrev.put(PdfName.BITSPERCOMPONENT, "/BPC ");
        abrev.put(PdfName.COLORSPACE, "/CS ");
        abrev.put(PdfName.DECODE, "/D ");
        abrev.put(PdfName.DECODEPARMS, "/DP ");
        abrev.put(PdfName.FILTER, "/F ");
        abrev.put(PdfName.HEIGHT, "/H ");
        abrev.put(PdfName.IMAGEMASK, "/IM ");
        abrev.put(PdfName.INTENT, "/Intent ");
        abrev.put(PdfName.INTERPOLATE, "/I ");
        abrev.put(PdfName.WIDTH, "/W ");
    }

    public PdfContentByte(PdfWriter pdfWriter) {
        if (pdfWriter != null) {
            this.writer = pdfWriter;
            this.pdf = this.writer.getPdfDocument();
        }
    }

    public String toString() {
        return this.content.toString();
    }

    public ByteBuffer getInternalBuffer() {
        return this.content;
    }

    public byte[] toPdf(PdfWriter pdfWriter) {
        sanityCheck();
        return this.content.toByteArray();
    }

    public void add(PdfContentByte pdfContentByte) {
        PdfWriter pdfWriter = pdfContentByte.writer;
        if (pdfWriter == null || this.writer == pdfWriter) {
            this.content.append(pdfContentByte.content);
            return;
        }
        throw new RuntimeException("Inconsistent writers. Are you mixing two documents?");
    }

    public float getXTLM() {
        return this.state.xTLM;
    }

    public float getYTLM() {
        return this.state.yTLM;
    }

    public float getLeading() {
        return this.state.leading;
    }

    public float getCharacterSpacing() {
        return this.state.charSpace;
    }

    public float getWordSpacing() {
        return this.state.wordSpace;
    }

    public float getHorizontalScaling() {
        return this.state.scale;
    }

    public void setFlatness(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            this.content.append(f).append(" i").append_i(this.separator);
        }
    }

    public void setLineCap(int i) {
        if (i >= 0 && i <= 2) {
            this.content.append(i).append(" J").append_i(this.separator);
        }
    }

    public void setLineDash(float f) {
        this.content.append("[] ").append(f).append(" d").append_i(this.separator);
    }

    public void setLineDash(float f, float f2) {
        this.content.append("[").append(f).append("] ").append(f2).append(" d").append_i(this.separator);
    }

    public void setLineDash(float f, float f2, float f3) {
        this.content.append("[").append(f).append(' ').append(f2).append("] ").append(f3).append(" d").append_i(this.separator);
    }

    public final void setLineDash(float[] fArr, float f) {
        this.content.append("[");
        for (int i = 0; i < fArr.length; i++) {
            this.content.append(fArr[i]);
            if (i < fArr.length - 1) {
                this.content.append(' ');
            }
        }
        this.content.append("] ").append(f).append(" d").append_i(this.separator);
    }

    public void setLineJoin(int i) {
        if (i >= 0 && i <= 2) {
            this.content.append(i).append(" j").append_i(this.separator);
        }
    }

    public void setLineWidth(float f) {
        this.content.append(f).append(" w").append_i(this.separator);
    }

    public void setMiterLimit(float f) {
        if (f > 1.0f) {
            this.content.append(f).append(" M").append_i(this.separator);
        }
    }

    public void clip() {
        this.content.append(ExifInterface.LONGITUDE_WEST).append_i(this.separator);
    }

    public void eoClip() {
        this.content.append("W*").append_i(this.separator);
    }

    public void setGrayFill(float f) {
        this.content.append(f).append(" g").append_i(this.separator);
    }

    public void resetGrayFill() {
        this.content.append("0 g").append_i(this.separator);
    }

    public void setGrayStroke(float f) {
        this.content.append(f).append(" G").append_i(this.separator);
    }

    public void resetGrayStroke() {
        this.content.append("0 G").append_i(this.separator);
    }

    private void HelperRGB(float f, float f2, float f3) {
        PdfXConformanceImp.checkPDFXConformance(this.writer, 3, (Object) null);
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.content.append(f).append(' ').append(f2).append(' ').append(f3);
    }

    public void setRGBColorFillF(float f, float f2, float f3) {
        HelperRGB(f, f2, f3);
        this.content.append(" rg").append_i(this.separator);
    }

    public void resetRGBColorFill() {
        this.content.append("0 g").append_i(this.separator);
    }

    public void setRGBColorStrokeF(float f, float f2, float f3) {
        HelperRGB(f, f2, f3);
        this.content.append(" RG").append_i(this.separator);
    }

    public void resetRGBColorStroke() {
        this.content.append("0 G").append_i(this.separator);
    }

    private void HelperCMYK(float f, float f2, float f3, float f4) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ').append(f4);
    }

    public void setCMYKColorFillF(float f, float f2, float f3, float f4) {
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" k").append_i(this.separator);
    }

    public void resetCMYKColorFill() {
        this.content.append("0 0 0 1 k").append_i(this.separator);
    }

    public void setCMYKColorStrokeF(float f, float f2, float f3, float f4) {
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" K").append_i(this.separator);
    }

    public void resetCMYKColorStroke() {
        this.content.append("0 0 0 1 K").append_i(this.separator);
    }

    public void moveTo(float f, float f2) {
        this.content.append(f).append(' ').append(f2).append(" m").append_i(this.separator);
    }

    public void lineTo(float f, float f2) {
        this.content.append(f).append(' ').append(f2).append(" l").append_i(this.separator);
    }

    public void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ').append(f4).append(' ').append(f5).append(' ').append(f6).append(" c").append_i(this.separator);
    }

    public void curveTo(float f, float f2, float f3, float f4) {
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ').append(f4).append(" v").append_i(this.separator);
    }

    public void curveFromTo(float f, float f2, float f3, float f4) {
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ').append(f4).append(" y").append_i(this.separator);
    }

    public void circle(float f, float f2, float f3) {
        float f4 = f2;
        float f5 = f + f3;
        moveTo(f5, f4);
        float f6 = f3 * 0.5523f;
        float f7 = f4 + f6;
        float f8 = f + f6;
        float f9 = f4 + f3;
        curveTo(f5, f7, f8, f9, f, f9);
        float f10 = f - f6;
        float f11 = f - f3;
        curveTo(f10, f9, f11, f7, f11, f2);
        float f12 = f4 - f6;
        float f13 = f4 - f3;
        curveTo(f11, f12, f10, f13, f, f13);
        curveTo(f8, f13, f5, f12, f5, f2);
    }

    public void rectangle(float f, float f2, float f3, float f4) {
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ').append(f4).append(" re").append_i(this.separator);
    }

    private boolean compareColors(Color color, Color color2) {
        if (color == null && color2 == null) {
            return true;
        }
        if (color == null || color2 == null) {
            return false;
        }
        if (color instanceof ExtendedColor) {
            return color.equals(color2);
        }
        return color2.equals(color);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void variableRectangle(com.lowagie.text.Rectangle r25) {
        /*
            r24 = this;
            r0 = r24
            float r1 = r25.getTop()
            float r2 = r25.getBottom()
            float r3 = r25.getRight()
            float r4 = r25.getLeft()
            float r5 = r25.getBorderWidthTop()
            float r6 = r25.getBorderWidthBottom()
            float r7 = r25.getBorderWidthRight()
            float r8 = r25.getBorderWidthLeft()
            harmony.java.awt.Color r9 = r25.getBorderColorTop()
            harmony.java.awt.Color r10 = r25.getBorderColorBottom()
            harmony.java.awt.Color r11 = r25.getBorderColorRight()
            harmony.java.awt.Color r12 = r25.getBorderColorLeft()
            r24.saveState()
            r13 = 0
            r0.setLineCap(r13)
            r0.setLineJoin(r13)
            r15 = 1073741824(0x40000000, float:2.0)
            r16 = 1
            r17 = 0
            int r18 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r18 <= 0) goto L_0x0064
            r0.setLineWidth(r5)
            if (r9 != 0) goto L_0x004f
            r24.resetRGBColorStroke()
            goto L_0x0052
        L_0x004f:
            r0.setColorStroke(r9)
        L_0x0052:
            float r18 = r5 / r15
            float r13 = r1 - r18
            r0.moveTo(r4, r13)
            r0.lineTo(r3, r13)
            r24.stroke()
            r13 = r5
            r14 = r9
            r18 = 1
            goto L_0x0068
        L_0x0064:
            r13 = 0
            r14 = 0
            r18 = 0
        L_0x0068:
            int r19 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r19 <= 0) goto L_0x0095
            int r19 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r19 == 0) goto L_0x0074
            r0.setLineWidth(r6)
            r13 = r6
        L_0x0074:
            if (r18 == 0) goto L_0x007c
            boolean r19 = r0.compareColors(r14, r10)
            if (r19 != 0) goto L_0x0088
        L_0x007c:
            if (r10 != 0) goto L_0x0082
            r24.resetRGBColorStroke()
            goto L_0x0085
        L_0x0082:
            r0.setColorStroke(r10)
        L_0x0085:
            r14 = r10
            r18 = 1
        L_0x0088:
            float r19 = r6 / r15
            float r15 = r2 + r19
            r0.moveTo(r3, r15)
            r0.lineTo(r4, r15)
            r24.stroke()
        L_0x0095:
            int r15 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0117
            int r15 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x00a1
            r0.setLineWidth(r7)
            r13 = r7
        L_0x00a1:
            if (r18 == 0) goto L_0x00a9
            boolean r15 = r0.compareColors(r14, r11)
            if (r15 != 0) goto L_0x00b5
        L_0x00a9:
            if (r11 != 0) goto L_0x00af
            r24.resetRGBColorStroke()
            goto L_0x00b2
        L_0x00af:
            r0.setColorStroke(r11)
        L_0x00b2:
            r14 = r11
            r18 = 1
        L_0x00b5:
            boolean r15 = r0.compareColors(r9, r11)
            boolean r19 = r0.compareColors(r10, r11)
            r20 = 1073741824(0x40000000, float:2.0)
            float r21 = r7 / r20
            r22 = r13
            float r13 = r3 - r21
            if (r15 == 0) goto L_0x00cb
            r23 = r14
            r14 = r1
            goto L_0x00d1
        L_0x00cb:
            float r21 = r1 - r5
            r23 = r14
            r14 = r21
        L_0x00d1:
            r0.moveTo(r13, r14)
            if (r19 == 0) goto L_0x00d8
            r14 = r2
            goto L_0x00da
        L_0x00d8:
            float r14 = r2 + r6
        L_0x00da:
            r0.lineTo(r13, r14)
            r24.stroke()
            if (r15 == 0) goto L_0x00e8
            if (r19 != 0) goto L_0x00e5
            goto L_0x00e8
        L_0x00e5:
            r14 = r23
            goto L_0x0119
        L_0x00e8:
            if (r11 != 0) goto L_0x00ee
            r24.resetRGBColorFill()
            goto L_0x00f1
        L_0x00ee:
            r0.setColorFill(r11)
        L_0x00f1:
            if (r15 != 0) goto L_0x0103
            r0.moveTo(r3, r1)
            float r13 = r1 - r5
            r0.lineTo(r3, r13)
            float r14 = r3 - r7
            r0.lineTo(r14, r13)
            r24.fill()
        L_0x0103:
            if (r19 != 0) goto L_0x0114
            r0.moveTo(r3, r2)
            float r13 = r2 + r6
            r0.lineTo(r3, r13)
            float r3 = r3 - r7
            r0.lineTo(r3, r13)
            r24.fill()
        L_0x0114:
            r14 = r23
            goto L_0x011c
        L_0x0117:
            r22 = r13
        L_0x0119:
            r11 = 0
            r16 = 0
        L_0x011c:
            int r3 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0190
            int r3 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r3 == 0) goto L_0x0127
            r0.setLineWidth(r8)
        L_0x0127:
            if (r18 == 0) goto L_0x012f
            boolean r3 = r0.compareColors(r14, r12)
            if (r3 != 0) goto L_0x0138
        L_0x012f:
            if (r12 != 0) goto L_0x0135
            r24.resetRGBColorStroke()
            goto L_0x0138
        L_0x0135:
            r0.setColorStroke(r12)
        L_0x0138:
            boolean r3 = r0.compareColors(r9, r12)
            boolean r7 = r0.compareColors(r10, r12)
            r9 = 1073741824(0x40000000, float:2.0)
            float r9 = r8 / r9
            float r9 = r9 + r4
            if (r3 == 0) goto L_0x0149
            r10 = r1
            goto L_0x014b
        L_0x0149:
            float r10 = r1 - r5
        L_0x014b:
            r0.moveTo(r9, r10)
            if (r7 == 0) goto L_0x0152
            r10 = r2
            goto L_0x0154
        L_0x0152:
            float r10 = r2 + r6
        L_0x0154:
            r0.lineTo(r9, r10)
            r24.stroke()
            if (r3 == 0) goto L_0x015e
            if (r7 != 0) goto L_0x0190
        L_0x015e:
            if (r16 == 0) goto L_0x0166
            boolean r9 = r0.compareColors(r11, r12)
            if (r9 != 0) goto L_0x016f
        L_0x0166:
            if (r12 != 0) goto L_0x016c
            r24.resetRGBColorFill()
            goto L_0x016f
        L_0x016c:
            r0.setColorFill(r12)
        L_0x016f:
            if (r3 != 0) goto L_0x0180
            r0.moveTo(r4, r1)
            float r1 = r1 - r5
            r0.lineTo(r4, r1)
            float r3 = r4 + r8
            r0.lineTo(r3, r1)
            r24.fill()
        L_0x0180:
            if (r7 != 0) goto L_0x0190
            r0.moveTo(r4, r2)
            float r2 = r2 + r6
            r0.lineTo(r4, r2)
            float r4 = r4 + r8
            r0.lineTo(r4, r2)
            r24.fill()
        L_0x0190:
            r24.restoreState()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfContentByte.variableRectangle(com.lowagie.text.Rectangle):void");
    }

    public void rectangle(Rectangle rectangle) {
        float left = rectangle.getLeft();
        float bottom = rectangle.getBottom();
        float right = rectangle.getRight();
        float top = rectangle.getTop();
        Color backgroundColor = rectangle.getBackgroundColor();
        if (backgroundColor != null) {
            setColorFill(backgroundColor);
            rectangle(left, bottom, right - left, top - bottom);
            fill();
            resetRGBColorFill();
        }
        if (rectangle.hasBorders()) {
            if (rectangle.isUseVariableBorders()) {
                variableRectangle(rectangle);
                return;
            }
            if (rectangle.getBorderWidth() != -1.0f) {
                setLineWidth(rectangle.getBorderWidth());
            }
            Color borderColor = rectangle.getBorderColor();
            if (borderColor != null) {
                setColorStroke(borderColor);
            }
            if (rectangle.hasBorder(15)) {
                rectangle(left, bottom, right - left, top - bottom);
            } else {
                if (rectangle.hasBorder(8)) {
                    moveTo(right, bottom);
                    lineTo(right, top);
                }
                if (rectangle.hasBorder(4)) {
                    moveTo(left, bottom);
                    lineTo(left, top);
                }
                if (rectangle.hasBorder(2)) {
                    moveTo(left, bottom);
                    lineTo(right, bottom);
                }
                if (rectangle.hasBorder(1)) {
                    moveTo(left, top);
                    lineTo(right, top);
                }
            }
            stroke();
            if (borderColor != null) {
                resetRGBColorStroke();
            }
        }
    }

    public void closePath() {
        this.content.append("h").append_i(this.separator);
    }

    public void newPath() {
        this.content.append("n").append_i(this.separator);
    }

    public void stroke() {
        this.content.append(ExifInterface.LATITUDE_SOUTH).append_i(this.separator);
    }

    public void closePathStroke() {
        this.content.append(HtmlTags.f607S).append_i(this.separator);
    }

    public void fill() {
        this.content.append("f").append_i(this.separator);
    }

    public void eoFill() {
        this.content.append("f*").append_i(this.separator);
    }

    public void fillStroke() {
        this.content.append("B").append_i(this.separator);
    }

    public void closePathFillStroke() {
        this.content.append(HtmlTags.f603B).append_i(this.separator);
    }

    public void eoFillStroke() {
        this.content.append("B*").append_i(this.separator);
    }

    public void closePathEoFillStroke() {
        this.content.append("b*").append_i(this.separator);
    }

    public void addImage(Image image) throws DocumentException {
        addImage(image, false);
    }

    public void addImage(Image image, boolean z) throws DocumentException {
        if (image.hasAbsoluteY()) {
            float[] matrix = image.matrix();
            matrix[4] = image.getAbsoluteX() - matrix[4];
            matrix[5] = image.getAbsoluteY() - matrix[5];
            addImage(image, matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[5], z);
            return;
        }
        throw new DocumentException("The image must have absolute positioning.");
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        addImage(image, f, f2, f3, f4, f5, f6, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0166 A[Catch:{ Exception -> 0x028b }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017e A[Catch:{ Exception -> 0x028b }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d9 A[Catch:{ Exception -> 0x028b }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0204 A[Catch:{ Exception -> 0x028b }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x020e A[Catch:{ Exception -> 0x028b }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0217 A[Catch:{ Exception -> 0x028b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0218 A[Catch:{ Exception -> 0x028b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addImage(com.lowagie.text.Image r19, float r20, float r21, float r22, float r23, float r24, float r25, boolean r26) throws com.lowagie.text.DocumentException {
        /*
            r18 = this;
            r9 = r18
            r0 = r19
            r10 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            r14 = r24
            r15 = r25
            com.lowagie.text.pdf.PdfOCG r1 = r19.getLayer()     // Catch:{ Exception -> 0x028b }
            if (r1 == 0) goto L_0x001d
            com.lowagie.text.pdf.PdfOCG r1 = r19.getLayer()     // Catch:{ Exception -> 0x028b }
            r9.beginLayer(r1)     // Catch:{ Exception -> 0x028b }
        L_0x001d:
            boolean r1 = r19.isImgTemplate()     // Catch:{ Exception -> 0x028b }
            r8 = 2
            r7 = 0
            r6 = 1
            if (r1 == 0) goto L_0x0052
            com.lowagie.text.pdf.PdfWriter r1 = r9.writer     // Catch:{ Exception -> 0x028b }
            r1.addDirectImageSimple(r0)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfTemplate r2 = r19.getTemplateData()     // Catch:{ Exception -> 0x028b }
            float r1 = r2.getWidth()     // Catch:{ Exception -> 0x028b }
            float r3 = r2.getHeight()     // Catch:{ Exception -> 0x028b }
            float r4 = r10 / r1
            float r5 = r11 / r1
            float r16 = r12 / r3
            float r17 = r13 / r3
            r1 = r18
            r3 = r4
            r4 = r5
            r5 = r16
            r6 = r17
            r7 = r24
            r8 = r25
            r1.addTemplate(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x028b }
        L_0x004e:
            r7 = 1
            r8 = 0
            goto L_0x01d3
        L_0x0052:
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            java.lang.String r2 = "q "
            r1.append((java.lang.String) r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((float) r10)     // Catch:{ Exception -> 0x028b }
            r2 = 32
            r1.append((char) r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((float) r11)     // Catch:{ Exception -> 0x028b }
            r1.append((char) r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((float) r12)     // Catch:{ Exception -> 0x028b }
            r1.append((char) r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((float) r13)     // Catch:{ Exception -> 0x028b }
            r1.append((char) r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((float) r14)     // Catch:{ Exception -> 0x028b }
            r1.append((char) r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((float) r15)     // Catch:{ Exception -> 0x028b }
            java.lang.String r3 = " cm"
            r1.append((java.lang.String) r3)     // Catch:{ Exception -> 0x028b }
            if (r26 == 0) goto L_0x018f
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            java.lang.String r2 = "\nBI\n"
            r1.append((java.lang.String) r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfImage r1 = new com.lowagie.text.pdf.PdfImage     // Catch:{ Exception -> 0x028b }
            java.lang.String r2 = ""
            r3 = 0
            r1.<init>(r0, r2, r3)     // Catch:{ Exception -> 0x028b }
            boolean r2 = r0 instanceof com.lowagie.text.ImgJBIG2     // Catch:{ Exception -> 0x028b }
            if (r2 == 0) goto L_0x00c6
            r2 = r0
            com.lowagie.text.ImgJBIG2 r2 = (com.lowagie.text.ImgJBIG2) r2     // Catch:{ Exception -> 0x028b }
            byte[] r2 = r2.getGlobalBytes()     // Catch:{ Exception -> 0x028b }
            if (r2 == 0) goto L_0x00c6
            com.lowagie.text.pdf.PdfDictionary r4 = new com.lowagie.text.pdf.PdfDictionary     // Catch:{ Exception -> 0x028b }
            r4.<init>()     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.JBIG2GLOBALS     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfWriter r6 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfIndirectReference r2 = r6.getReferenceJBIG2Globals(r2)     // Catch:{ Exception -> 0x028b }
            r4.put(r5, r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.DECODEPARMS     // Catch:{ Exception -> 0x028b }
            r1.put(r2, r4)     // Catch:{ Exception -> 0x028b }
        L_0x00c6:
            java.util.Set r2 = r1.getKeys()     // Catch:{ Exception -> 0x028b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x028b }
        L_0x00ce:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x028b }
            if (r4 != 0) goto L_0x00ef
            com.lowagie.text.pdf.ByteBuffer r2 = r9.content     // Catch:{ Exception -> 0x028b }
            java.lang.String r3 = "ID\n"
            r2.append((java.lang.String) r3)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r2 = r9.content     // Catch:{ Exception -> 0x028b }
            r1.writeContent(r2)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r9.content     // Catch:{ Exception -> 0x028b }
            java.lang.String r2 = "\nEI\nQ"
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((java.lang.String) r2)     // Catch:{ Exception -> 0x028b }
            int r2 = r9.separator     // Catch:{ Exception -> 0x028b }
            r1.append_i(r2)     // Catch:{ Exception -> 0x028b }
            goto L_0x004e
        L_0x00ef:
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r4 = (com.lowagie.text.pdf.PdfName) r4     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfObject r5 = r1.get(r4)     // Catch:{ Exception -> 0x028b }
            java.util.HashMap r6 = abrev     // Catch:{ Exception -> 0x028b }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x028b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x028b }
            if (r6 != 0) goto L_0x0104
            goto L_0x00ce
        L_0x0104:
            com.lowagie.text.pdf.ByteBuffer r7 = r9.content     // Catch:{ Exception -> 0x028b }
            r7.append((java.lang.String) r6)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.COLORSPACE     // Catch:{ Exception -> 0x028b }
            boolean r6 = r4.equals(r6)     // Catch:{ Exception -> 0x028b }
            if (r6 == 0) goto L_0x0153
            boolean r6 = r5.isArray()     // Catch:{ Exception -> 0x028b }
            if (r6 == 0) goto L_0x0153
            r6 = r5
            com.lowagie.text.pdf.PdfArray r6 = (com.lowagie.text.pdf.PdfArray) r6     // Catch:{ Exception -> 0x028b }
            int r7 = r6.size()     // Catch:{ Exception -> 0x028b }
            r8 = 4
            if (r7 != r8) goto L_0x0153
            com.lowagie.text.pdf.PdfName r7 = com.lowagie.text.pdf.PdfName.INDEXED     // Catch:{ Exception -> 0x028b }
            r8 = 0
            com.lowagie.text.pdf.PdfName r3 = r6.getAsName(r8)     // Catch:{ Exception -> 0x028b }
            boolean r3 = r7.equals(r3)     // Catch:{ Exception -> 0x028b }
            if (r3 == 0) goto L_0x0151
            r7 = 1
            com.lowagie.text.pdf.PdfObject r3 = r6.getPdfObject(r7)     // Catch:{ Exception -> 0x028b }
            boolean r3 = r3.isName()     // Catch:{ Exception -> 0x028b }
            if (r3 == 0) goto L_0x0155
            r3 = 2
            com.lowagie.text.pdf.PdfObject r16 = r6.getPdfObject(r3)     // Catch:{ Exception -> 0x028b }
            boolean r16 = r16.isNumber()     // Catch:{ Exception -> 0x028b }
            if (r16 == 0) goto L_0x0155
            r3 = 3
            com.lowagie.text.pdf.PdfObject r3 = r6.getPdfObject(r3)     // Catch:{ Exception -> 0x028b }
            boolean r3 = r3.isString()     // Catch:{ Exception -> 0x028b }
            if (r3 == 0) goto L_0x0155
            r3 = 0
            goto L_0x0156
        L_0x0151:
            r7 = 1
            goto L_0x0155
        L_0x0153:
            r7 = 1
            r8 = 0
        L_0x0155:
            r3 = 1
        L_0x0156:
            if (r3 == 0) goto L_0x017e
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.COLORSPACE     // Catch:{ Exception -> 0x028b }
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x028b }
            if (r3 == 0) goto L_0x017e
            boolean r3 = r5.isName()     // Catch:{ Exception -> 0x028b }
            if (r3 != 0) goto L_0x017e
            com.lowagie.text.pdf.PdfWriter r3 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r3 = r3.getColorspaceName()     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PageResources r4 = r18.getPageResources()     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfWriter r6 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfIndirectObject r5 = r6.addToBody(r5)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfIndirectReference r5 = r5.getIndirectReference()     // Catch:{ Exception -> 0x028b }
            r4.addColor(r3, r5)     // Catch:{ Exception -> 0x028b }
            goto L_0x017f
        L_0x017e:
            r3 = r5
        L_0x017f:
            com.lowagie.text.pdf.ByteBuffer r4 = r9.content     // Catch:{ Exception -> 0x028b }
            r5 = 0
            r3.toPdf(r5, r4)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r3 = r9.content     // Catch:{ Exception -> 0x028b }
            r4 = 10
            r3.append((char) r4)     // Catch:{ Exception -> 0x028b }
            r3 = r5
            goto L_0x00ce
        L_0x018f:
            r7 = 1
            r8 = 0
            com.lowagie.text.pdf.PageResources r1 = r18.getPageResources()     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.Image r3 = r19.getImageMask()     // Catch:{ Exception -> 0x028b }
            if (r3 == 0) goto L_0x01aa
            com.lowagie.text.pdf.PdfWriter r4 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r3 = r4.addDirectImageSimple(r3)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfWriter r4 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfIndirectReference r4 = r4.getImageReference(r3)     // Catch:{ Exception -> 0x028b }
            r1.addXObject(r3, r4)     // Catch:{ Exception -> 0x028b }
        L_0x01aa:
            com.lowagie.text.pdf.PdfWriter r3 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r3 = r3.addDirectImageSimple(r0)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfWriter r4 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfIndirectReference r4 = r4.getImageReference(r3)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfName r1 = r1.addXObject(r3, r4)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r3 = r9.content     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r2 = r3.append((char) r2)     // Catch:{ Exception -> 0x028b }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.ByteBuffer r1 = r2.append((byte[]) r1)     // Catch:{ Exception -> 0x028b }
            java.lang.String r2 = " Do Q"
            com.lowagie.text.pdf.ByteBuffer r1 = r1.append((java.lang.String) r2)     // Catch:{ Exception -> 0x028b }
            int r2 = r9.separator     // Catch:{ Exception -> 0x028b }
            r1.append_i(r2)     // Catch:{ Exception -> 0x028b }
        L_0x01d3:
            boolean r1 = r19.hasBorders()     // Catch:{ Exception -> 0x028b }
            if (r1 == 0) goto L_0x0204
            r18.saveState()     // Catch:{ Exception -> 0x028b }
            float r1 = r19.getWidth()     // Catch:{ Exception -> 0x028b }
            float r2 = r19.getHeight()     // Catch:{ Exception -> 0x028b }
            float r3 = r10 / r1
            float r4 = r11 / r1
            float r5 = r12 / r2
            float r6 = r13 / r2
            r1 = r18
            r2 = r3
            r16 = 2
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r24
            r17 = 1
            r7 = r25
            r1.concatCTM(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x028b }
            r18.rectangle(r19)     // Catch:{ Exception -> 0x028b }
            r18.restoreState()     // Catch:{ Exception -> 0x028b }
            goto L_0x0208
        L_0x0204:
            r16 = 2
            r17 = 1
        L_0x0208:
            com.lowagie.text.pdf.PdfOCG r1 = r19.getLayer()     // Catch:{ Exception -> 0x028b }
            if (r1 == 0) goto L_0x0211
            r18.endLayer()     // Catch:{ Exception -> 0x028b }
        L_0x0211:
            com.lowagie.text.Annotation r0 = r19.getAnnotation()     // Catch:{ Exception -> 0x028b }
            if (r0 != 0) goto L_0x0218
            return
        L_0x0218:
            float[] r1 = unitRect     // Catch:{ Exception -> 0x028b }
            int r1 = r1.length     // Catch:{ Exception -> 0x028b }
            float[] r1 = new float[r1]     // Catch:{ Exception -> 0x028b }
            r2 = 0
        L_0x021e:
            float[] r3 = unitRect     // Catch:{ Exception -> 0x028b }
            int r3 = r3.length     // Catch:{ Exception -> 0x028b }
            if (r2 < r3) goto L_0x0266
            r2 = r1[r8]     // Catch:{ Exception -> 0x028b }
            r3 = r1[r17]     // Catch:{ Exception -> 0x028b }
            r5 = r2
            r4 = r3
            r6 = r4
            r3 = r5
            r2 = 2
        L_0x022c:
            int r7 = r1.length     // Catch:{ Exception -> 0x028b }
            if (r2 < r7) goto L_0x0249
            com.lowagie.text.Annotation r1 = new com.lowagie.text.Annotation     // Catch:{ Exception -> 0x028b }
            r1.<init>(r0)     // Catch:{ Exception -> 0x028b }
            r1.setDimensions(r3, r4, r5, r6)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfWriter r0 = r9.writer     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.Rectangle r2 = new com.lowagie.text.Rectangle     // Catch:{ Exception -> 0x028b }
            r2.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x028b }
            com.lowagie.text.pdf.PdfAnnotation r0 = com.lowagie.text.pdf.internal.PdfAnnotationsImp.convertAnnotation(r0, r1, r2)     // Catch:{ Exception -> 0x028b }
            if (r0 != 0) goto L_0x0245
            return
        L_0x0245:
            r9.addAnnotation(r0)     // Catch:{ Exception -> 0x028b }
            return
        L_0x0249:
            r7 = r1[r2]     // Catch:{ Exception -> 0x028b }
            float r3 = java.lang.Math.min(r3, r7)     // Catch:{ Exception -> 0x028b }
            int r7 = r2 + 1
            r8 = r1[r7]     // Catch:{ Exception -> 0x028b }
            float r4 = java.lang.Math.min(r4, r8)     // Catch:{ Exception -> 0x028b }
            r8 = r1[r2]     // Catch:{ Exception -> 0x028b }
            float r5 = java.lang.Math.max(r5, r8)     // Catch:{ Exception -> 0x028b }
            r7 = r1[r7]     // Catch:{ Exception -> 0x028b }
            float r6 = java.lang.Math.max(r6, r7)     // Catch:{ Exception -> 0x028b }
            int r2 = r2 + 2
            goto L_0x022c
        L_0x0266:
            float[] r3 = unitRect     // Catch:{ Exception -> 0x028b }
            r3 = r3[r2]     // Catch:{ Exception -> 0x028b }
            float r3 = r3 * r10
            float[] r4 = unitRect     // Catch:{ Exception -> 0x028b }
            int r5 = r2 + 1
            r4 = r4[r5]     // Catch:{ Exception -> 0x028b }
            float r4 = r4 * r12
            float r3 = r3 + r4
            float r3 = r3 + r14
            r1[r2] = r3     // Catch:{ Exception -> 0x028b }
            float[] r3 = unitRect     // Catch:{ Exception -> 0x028b }
            r3 = r3[r2]     // Catch:{ Exception -> 0x028b }
            float r3 = r3 * r11
            float[] r4 = unitRect     // Catch:{ Exception -> 0x028b }
            r4 = r4[r5]     // Catch:{ Exception -> 0x028b }
            float r4 = r4 * r13
            float r3 = r3 + r4
            float r3 = r3 + r15
            r1[r5] = r3     // Catch:{ Exception -> 0x028b }
            int r2 = r2 + 2
            goto L_0x021e
        L_0x028b:
            r0 = move-exception
            com.lowagie.text.DocumentException r1 = new com.lowagie.text.DocumentException
            r1.<init>((java.lang.Exception) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfContentByte.addImage(com.lowagie.text.Image, float, float, float, float, float, float, boolean):void");
    }

    public void reset() {
        reset(true);
    }

    public void reset(boolean z) {
        this.content.reset();
        if (z) {
            sanityCheck();
        }
        this.state = new GraphicState();
    }

    public void beginText() {
        if (!this.inText) {
            this.inText = true;
            GraphicState graphicState = this.state;
            graphicState.xTLM = 0.0f;
            graphicState.yTLM = 0.0f;
            this.content.append("BT").append_i(this.separator);
            return;
        }
        throw new IllegalPdfSyntaxException("Unbalanced begin/end text operators.");
    }

    public void endText() {
        if (this.inText) {
            this.inText = false;
            this.content.append("ET").append_i(this.separator);
            return;
        }
        throw new IllegalPdfSyntaxException("Unbalanced begin/end text operators.");
    }

    public void saveState() {
        this.content.append("q").append_i(this.separator);
        this.stateList.add(new GraphicState(this.state));
    }

    public void restoreState() {
        this.content.append("Q").append_i(this.separator);
        int size = this.stateList.size() - 1;
        if (size >= 0) {
            this.state = (GraphicState) this.stateList.get(size);
            this.stateList.remove(size);
            return;
        }
        throw new IllegalPdfSyntaxException("Unbalanced save/restore state operators.");
    }

    public void setCharacterSpacing(float f) {
        this.state.charSpace = f;
        this.content.append(f).append(" Tc").append_i(this.separator);
    }

    public void setWordSpacing(float f) {
        this.state.wordSpace = f;
        this.content.append(f).append(" Tw").append_i(this.separator);
    }

    public void setHorizontalScaling(float f) {
        this.state.scale = f;
        this.content.append(f).append(" Tz").append_i(this.separator);
    }

    public void setLeading(float f) {
        this.state.leading = f;
        this.content.append(f).append(" TL").append_i(this.separator);
    }

    public void setFontAndSize(BaseFont baseFont, float f) {
        checkWriter();
        if (f >= 1.0E-4f || f <= -1.0E-4f) {
            GraphicState graphicState = this.state;
            graphicState.size = f;
            graphicState.fontDetails = this.writer.addSimple(baseFont);
            this.content.append(getPageResources().addFont(this.state.fontDetails.getFontName(), this.state.fontDetails.getIndirectReference()).getBytes()).append(' ').append(f).append(" Tf").append_i(this.separator);
            return;
        }
        throw new IllegalArgumentException("Font size too small: " + f);
    }

    public void setTextRenderingMode(int i) {
        this.content.append(i).append(" Tr").append_i(this.separator);
    }

    public void setTextRise(float f) {
        this.content.append(f).append(" Ts").append_i(this.separator);
    }

    private void showText2(String str) {
        if (this.state.fontDetails != null) {
            escapeString(this.state.fontDetails.convertToBytes(str), this.content);
            return;
        }
        throw new NullPointerException("Font and size must be set before writing any text");
    }

    public void showText(String str) {
        showText2(str);
        this.content.append("Tj").append_i(this.separator);
    }

    public static PdfTextArray getKernArray(String str, BaseFont baseFont) {
        PdfTextArray pdfTextArray = new PdfTextArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        if (length >= 0) {
            stringBuffer.append(charArray, 0, 1);
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char c = charArray[i2];
            int kerning = baseFont.getKerning(charArray[i], c);
            if (kerning == 0) {
                stringBuffer.append(c);
            } else {
                pdfTextArray.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                stringBuffer.append(charArray, i2, 1);
                pdfTextArray.add((float) (-kerning));
            }
            i = i2;
        }
        pdfTextArray.add(stringBuffer.toString());
        return pdfTextArray;
    }

    public void showTextKerned(String str) {
        if (this.state.fontDetails != null) {
            BaseFont baseFont = this.state.fontDetails.getBaseFont();
            if (baseFont.hasKernPairs()) {
                showText(getKernArray(str, baseFont));
            } else {
                showText(str);
            }
        } else {
            throw new NullPointerException("Font and size must be set before writing any text");
        }
    }

    public void newlineShowText(String str) {
        this.state.yTLM -= this.state.leading;
        showText2(str);
        this.content.append("'").append_i(this.separator);
    }

    public void newlineShowText(float f, float f2, String str) {
        this.state.yTLM -= this.state.leading;
        this.content.append(f).append(' ').append(f2);
        showText2(str);
        this.content.append("\"").append_i(this.separator);
        GraphicState graphicState = this.state;
        graphicState.charSpace = f2;
        graphicState.wordSpace = f;
    }

    public void setTextMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        GraphicState graphicState = this.state;
        graphicState.xTLM = f5;
        graphicState.yTLM = f6;
        this.content.append(f).append(' ').append(f2).append_i(32).append(f3).append_i(32).append(f4).append_i(32).append(f5).append_i(32).append(f6).append(" Tm").append_i(this.separator);
    }

    public void setTextMatrix(float f, float f2) {
        setTextMatrix(1.0f, 0.0f, 0.0f, 1.0f, f, f2);
    }

    public void moveText(float f, float f2) {
        this.state.xTLM += f;
        this.state.yTLM += f2;
        this.content.append(f).append(' ').append(f2).append(" Td").append_i(this.separator);
    }

    public void moveTextWithLeading(float f, float f2) {
        this.state.xTLM += f;
        this.state.yTLM += f2;
        this.state.leading = -f2;
        this.content.append(f).append(' ').append(f2).append(" TD").append_i(this.separator);
    }

    public void newlineText() {
        this.state.yTLM -= this.state.leading;
        this.content.append("T*").append_i(this.separator);
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.content.size();
    }

    static byte[] escapeString(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        escapeString(bArr, byteBuffer);
        return byteBuffer.toByteArray();
    }

    static void escapeString(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.append_i(40);
        for (byte b : bArr) {
            if (b == 12) {
                byteBuffer.append("\\f");
            } else if (b != 13) {
                if (b != 40 && b != 41 && b != 92) {
                    switch (b) {
                        case 8:
                            byteBuffer.append("\\b");
                            break;
                        case 9:
                            byteBuffer.append("\\t");
                            break;
                        case 10:
                            byteBuffer.append("\\n");
                            break;
                        default:
                            byteBuffer.append_i(b);
                            break;
                    }
                } else {
                    byteBuffer.append_i(92).append_i(b);
                }
            } else {
                byteBuffer.append("\\r");
            }
        }
        byteBuffer.append(")");
    }

    public void addOutline(PdfOutline pdfOutline, String str) {
        checkWriter();
        this.pdf.addOutline(pdfOutline, str);
    }

    public PdfOutline getRootOutline() {
        checkWriter();
        return this.pdf.getRootOutline();
    }

    public float getEffectiveStringWidth(String str, boolean z) {
        float f;
        BaseFont baseFont = this.state.fontDetails.getBaseFont();
        if (z) {
            f = baseFont.getWidthPointKerned(str, this.state.size);
        } else {
            f = baseFont.getWidthPoint(str, this.state.size);
        }
        if (this.state.charSpace != 0.0f && str.length() > 1) {
            f += this.state.charSpace * ((float) (str.length() - 1));
        }
        int fontType = baseFont.getFontType();
        if (this.state.wordSpace != 0.0f && (fontType == 0 || fontType == 1 || fontType == 5)) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == ' ') {
                    f += this.state.wordSpace;
                }
            }
        }
        return ((double) this.state.scale) != 100.0d ? (f * this.state.scale) / 100.0f : f;
    }

    public void showTextAligned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showTextAligned(int r16, java.lang.String r17, float r18, float r19, float r20, boolean r21) {
        /*
            r15 = this;
            r7 = r15
            r0 = r16
            r8 = r17
            r1 = r19
            r2 = r20
            r9 = r21
            com.lowagie.text.pdf.PdfContentByte$GraphicState r3 = r7.state
            com.lowagie.text.pdf.FontDetails r3 = r3.fontDetails
            if (r3 == 0) goto L_0x0083
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 2
            r5 = 1
            r10 = 0
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x003a
            if (r0 == r5) goto L_0x0026
            if (r0 == r4) goto L_0x0021
            r0 = r18
            goto L_0x002d
        L_0x0021:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            goto L_0x002b
        L_0x0026:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            float r0 = r0 / r3
        L_0x002b:
            float r0 = r18 - r0
        L_0x002d:
            r15.setTextMatrix(r0, r1)
            if (r9 == 0) goto L_0x0036
            r15.showTextKerned(r8)
            goto L_0x0082
        L_0x0036:
            r15.showText((java.lang.String) r8)
            goto L_0x0082
        L_0x003a:
            double r11 = (double) r2
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r11 = r11 * r13
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r11 = r11 / r13
            double r13 = java.lang.Math.cos(r11)
            float r6 = (float) r13
            double r11 = java.lang.Math.sin(r11)
            float r2 = (float) r11
            if (r0 == r5) goto L_0x005f
            if (r0 == r4) goto L_0x005a
            r5 = r18
            r11 = r1
            goto L_0x006e
        L_0x005a:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            goto L_0x0064
        L_0x005f:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            float r0 = r0 / r3
        L_0x0064:
            float r3 = r0 * r6
            float r3 = r18 - r3
            float r0 = r0 * r2
            float r0 = r1 - r0
            r11 = r0
            r5 = r3
        L_0x006e:
            float r3 = -r2
            r0 = r15
            r1 = r6
            r4 = r6
            r6 = r11
            r0.setTextMatrix(r1, r2, r3, r4, r5, r6)
            if (r9 == 0) goto L_0x007c
            r15.showTextKerned(r8)
            goto L_0x007f
        L_0x007c:
            r15.showText((java.lang.String) r8)
        L_0x007f:
            r15.setTextMatrix(r10, r10)
        L_0x0082:
            return
        L_0x0083:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Font and size must be set before writing any text"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfContentByte.showTextAligned(int, java.lang.String, float, float, float, boolean):void");
    }

    public void showTextAlignedKerned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, true);
    }

    public void concatCTM(float f, float f2, float f3, float f4, float f5, float f6) {
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ');
        this.content.append(f4).append(' ').append(f5).append(' ').append(f6).append(" cm").append_i(this.separator);
    }

    public static ArrayList bezierArc(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        int i;
        if (f > f3) {
            f7 = f;
            f8 = f3;
        } else {
            f8 = f;
            f7 = f3;
        }
        if (f4 > f2) {
            f9 = f2;
            f10 = f4;
        } else {
            f10 = f2;
            f9 = f4;
        }
        if (Math.abs(f6) <= 90.0f) {
            f11 = f6;
            i = 1;
        } else {
            i = (int) Math.ceil((double) (Math.abs(f6) / 90.0f));
            f11 = f6 / ((float) i);
        }
        float f12 = (f10 + f9) / 2.0f;
        float f13 = (f7 - f8) / 2.0f;
        float f14 = (f9 - f10) / 2.0f;
        double d = 3.141592653589793d;
        float f15 = (f8 + f7) / 2.0f;
        double d2 = (double) ((float) ((((double) f11) * 3.141592653589793d) / 360.0d));
        float abs = (float) Math.abs(((1.0d - Math.cos(d2)) * 1.3333333333333333d) / Math.sin(d2));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            float f16 = (float) ((((double) (f5 + (((float) i2) * f11))) * d) / 180.0d);
            i2++;
            double d3 = (double) f16;
            float cos = (float) Math.cos(d3);
            double d4 = (double) ((float) ((((double) (f5 + (((float) i2) * f11))) * d) / 180.0d));
            float cos2 = (float) Math.cos(d4);
            float sin = (float) Math.sin(d3);
            float sin2 = (float) Math.sin(d4);
            if (f11 > 0.0f) {
                arrayList.add(new float[]{f15 + (f13 * cos), f12 - (f14 * sin), f15 + ((cos - (abs * sin)) * f13), f12 - ((sin + (cos * abs)) * f14), f15 + (((abs * sin2) + cos2) * f13), f12 - ((sin2 - (abs * cos2)) * f14), f15 + (cos2 * f13), f12 - (sin2 * f14)});
            } else {
                arrayList.add(new float[]{f15 + (f13 * cos), f12 - (f14 * sin), f15 + (((abs * sin) + cos) * f13), f12 - ((sin - (cos * abs)) * f14), f15 + ((cos2 - (abs * sin2)) * f13), f12 - (((abs * cos2) + sin2) * f14), f15 + (cos2 * f13), f12 - (sin2 * f14)});
            }
            d = 3.141592653589793d;
        }
        return arrayList;
    }

    public void arc(float f, float f2, float f3, float f4, float f5, float f6) {
        ArrayList bezierArc = bezierArc(f, f2, f3, f4, f5, f6);
        if (!bezierArc.isEmpty()) {
            float[] fArr = (float[]) bezierArc.get(0);
            moveTo(fArr[0], fArr[1]);
            for (int i = 0; i < bezierArc.size(); i++) {
                float[] fArr2 = (float[]) bezierArc.get(i);
                curveTo(fArr2[2], fArr2[3], fArr2[4], fArr2[5], fArr2[6], fArr2[7]);
            }
        }
    }

    public void ellipse(float f, float f2, float f3, float f4) {
        arc(f, f2, f3, f4, 0.0f, 360.0f);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4) {
        checkWriter();
        if (f3 == 0.0f || f4 == 0.0f) {
            throw new RuntimeException("XStep or YStep can not be ZERO.");
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer);
        pdfPatternPainter.setWidth(f);
        pdfPatternPainter.setHeight(f2);
        pdfPatternPainter.setXStep(f3);
        pdfPatternPainter.setYStep(f4);
        this.writer.addSimplePattern(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public PdfPatternPainter createPattern(float f, float f2) {
        return createPattern(f, f2, f, f2);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4, Color color) {
        checkWriter();
        if (f3 == 0.0f || f4 == 0.0f) {
            throw new RuntimeException("XStep or YStep can not be ZERO.");
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer, color);
        pdfPatternPainter.setWidth(f);
        pdfPatternPainter.setHeight(f2);
        pdfPatternPainter.setXStep(f3);
        pdfPatternPainter.setYStep(f4);
        this.writer.addSimplePattern(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public PdfPatternPainter createPattern(float f, float f2, Color color) {
        return createPattern(f, f2, f, f2, color);
    }

    public PdfTemplate createTemplate(float f, float f2) {
        return createTemplate(f, f2, (PdfName) null);
    }

    /* access modifiers changed from: package-private */
    public PdfTemplate createTemplate(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfTemplate pdfTemplate = new PdfTemplate(this.writer);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public PdfAppearance createAppearance(float f, float f2) {
        return createAppearance(f, f2, (PdfName) null);
    }

    /* access modifiers changed from: package-private */
    public PdfAppearance createAppearance(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfAppearance pdfAppearance = new PdfAppearance(this.writer);
        pdfAppearance.setWidth(f);
        pdfAppearance.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    public void addPSXObject(PdfPSXObject pdfPSXObject) {
        checkWriter();
        this.content.append(getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfPSXObject, (PdfName) null), pdfPSXObject.getIndirectReference()).getBytes()).append(" Do").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6) {
        checkWriter();
        checkNoPattern(pdfTemplate);
        PdfName addXObject = getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfTemplate, (PdfName) null), pdfTemplate.getIndirectReference());
        this.content.append("q ");
        this.content.append(f).append(' ');
        this.content.append(f2).append(' ');
        this.content.append(f3).append(' ');
        this.content.append(f4).append(' ');
        this.content.append(f5).append(' ');
        this.content.append(f6).append(" cm ");
        this.content.append(addXObject.getBytes()).append(" Do Q").append_i(this.separator);
    }

    /* access modifiers changed from: package-private */
    public void addTemplateReference(PdfIndirectReference pdfIndirectReference, PdfName pdfName, float f, float f2, float f3, float f4, float f5, float f6) {
        checkWriter();
        PdfName addXObject = getPageResources().addXObject(pdfName, pdfIndirectReference);
        this.content.append("q ");
        this.content.append(f).append(' ');
        this.content.append(f2).append(' ');
        this.content.append(f3).append(' ');
        this.content.append(f4).append(' ');
        this.content.append(f5).append(' ');
        this.content.append(f6).append(" cm ");
        this.content.append(addXObject.getBytes()).append(" Do Q").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2) {
        addTemplate(pdfTemplate, 1.0f, 0.0f, 0.0f, 1.0f, f, f2);
    }

    public void setCMYKColorFill(int i, int i2, int i3, int i4) {
        this.content.append(((float) (i & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i2 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i3 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i4 & 255)) / 255.0f);
        this.content.append(" k").append_i(this.separator);
    }

    public void setCMYKColorStroke(int i, int i2, int i3, int i4) {
        this.content.append(((float) (i & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i2 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i3 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i4 & 255)) / 255.0f);
        this.content.append(" K").append_i(this.separator);
    }

    public void setRGBColorFill(int i, int i2, int i3) {
        HelperRGB(((float) (i & 255)) / 255.0f, ((float) (i2 & 255)) / 255.0f, ((float) (i3 & 255)) / 255.0f);
        this.content.append(" rg").append_i(this.separator);
    }

    public void setRGBColorStroke(int i, int i2, int i3) {
        HelperRGB(((float) (i & 255)) / 255.0f, ((float) (i2 & 255)) / 255.0f, ((float) (i3 & 255)) / 255.0f);
        this.content.append(" RG").append_i(this.separator);
    }

    public void setColorStroke(Color color) {
        PdfXConformanceImp.checkPDFXConformance(this.writer, 1, color);
        int type = ExtendedColor.getType(color);
        if (type == 1) {
            setGrayStroke(((GrayColor) color).getGray());
        } else if (type == 2) {
            CMYKColor cMYKColor = (CMYKColor) color;
            setCMYKColorStrokeF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
        } else if (type == 3) {
            SpotColor spotColor = (SpotColor) color;
            setColorStroke(spotColor.getPdfSpotColor(), spotColor.getTint());
        } else if (type == 4) {
            setPatternStroke(((PatternColor) color).getPainter());
        } else if (type != 5) {
            setRGBColorStroke(color.getRed(), color.getGreen(), color.getBlue());
        } else {
            setShadingStroke(((ShadingColor) color).getPdfShadingPattern());
        }
    }

    public void setColorFill(Color color) {
        PdfXConformanceImp.checkPDFXConformance(this.writer, 1, color);
        int type = ExtendedColor.getType(color);
        if (type == 1) {
            setGrayFill(((GrayColor) color).getGray());
        } else if (type == 2) {
            CMYKColor cMYKColor = (CMYKColor) color;
            setCMYKColorFillF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
        } else if (type == 3) {
            SpotColor spotColor = (SpotColor) color;
            setColorFill(spotColor.getPdfSpotColor(), spotColor.getTint());
        } else if (type == 4) {
            setPatternFill(((PatternColor) color).getPainter());
        } else if (type != 5) {
            setRGBColorFill(color.getRed(), color.getGreen(), color.getBlue());
        } else {
            setShadingFill(((ShadingColor) color).getPdfShadingPattern());
        }
    }

    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        this.content.append(getPageResources().addColor(this.state.colorDetails.getColorName(), this.state.colorDetails.getIndirectReference()).getBytes()).append(" cs ").append(f).append(" scn").append_i(this.separator);
    }

    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        this.content.append(getPageResources().addColor(this.state.colorDetails.getColorName(), this.state.colorDetails.getIndirectReference()).getBytes()).append(" CS ").append(f).append(" SCN").append_i(this.separator);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternFill(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference()).getBytes()).append(" scn").append_i(this.separator);
    }

    /* access modifiers changed from: package-private */
    public void outputColorNumbers(Color color, float f) {
        PdfXConformanceImp.checkPDFXConformance(this.writer, 1, color);
        int type = ExtendedColor.getType(color);
        if (type == 0) {
            this.content.append(((float) color.getRed()) / 255.0f);
            this.content.append(' ');
            this.content.append(((float) color.getGreen()) / 255.0f);
            this.content.append(' ');
            this.content.append(((float) color.getBlue()) / 255.0f);
        } else if (type == 1) {
            this.content.append(((GrayColor) color).getGray());
        } else if (type == 2) {
            CMYKColor cMYKColor = (CMYKColor) color;
            this.content.append(cMYKColor.getCyan()).append(' ').append(cMYKColor.getMagenta());
            this.content.append(' ').append(cMYKColor.getYellow()).append(' ').append(cMYKColor.getBlack());
        } else if (type == 3) {
            this.content.append(f);
        } else {
            throw new RuntimeException("Invalid color type.");
        }
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, Color color) {
        if (ExtendedColor.getType(color) == 3) {
            setPatternFill(pdfPatternPainter, color, ((SpotColor) color).getTint());
        } else {
            setPatternFill(pdfPatternPainter, color, 0.0f);
        }
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, Color color, float f) {
        checkWriter();
        if (pdfPatternPainter.isStencil()) {
            PageResources pageResources = getPageResources();
            PdfName addPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
            ColorDetails addSimplePatternColorspace = this.writer.addSimplePatternColorspace(color);
            this.content.append(pageResources.addColor(addSimplePatternColorspace.getColorName(), addSimplePatternColorspace.getIndirectReference()).getBytes()).append(" cs").append_i(this.separator);
            outputColorNumbers(color, f);
            this.content.append(' ').append(addPattern.getBytes()).append(" scn").append_i(this.separator);
            return;
        }
        throw new RuntimeException("An uncolored pattern was expected.");
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, Color color) {
        if (ExtendedColor.getType(color) == 3) {
            setPatternStroke(pdfPatternPainter, color, ((SpotColor) color).getTint());
        } else {
            setPatternStroke(pdfPatternPainter, color, 0.0f);
        }
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, Color color, float f) {
        checkWriter();
        if (pdfPatternPainter.isStencil()) {
            PageResources pageResources = getPageResources();
            PdfName addPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
            ColorDetails addSimplePatternColorspace = this.writer.addSimplePatternColorspace(color);
            this.content.append(pageResources.addColor(addSimplePatternColorspace.getColorName(), addSimplePatternColorspace.getIndirectReference()).getBytes()).append(" CS").append_i(this.separator);
            outputColorNumbers(color, f);
            this.content.append(' ').append(addPattern.getBytes()).append(" SCN").append_i(this.separator);
            return;
        }
        throw new RuntimeException("An uncolored pattern was expected.");
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternStroke(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference()).getBytes()).append(" SCN").append_i(this.separator);
    }

    public void paintShading(PdfShading pdfShading) {
        this.writer.addSimpleShading(pdfShading);
        PageResources pageResources = getPageResources();
        this.content.append(pageResources.addShading(pdfShading.getShadingName(), pdfShading.getShadingReference()).getBytes()).append(" sh").append_i(this.separator);
        ColorDetails colorDetails = pdfShading.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorName(), colorDetails.getIndirectReference());
        }
    }

    public void paintShading(PdfShadingPattern pdfShadingPattern) {
        paintShading(pdfShadingPattern.getShading());
    }

    public void setShadingFill(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference()).getBytes()).append(" scn").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorName(), colorDetails.getIndirectReference());
        }
    }

    public void setShadingStroke(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference()).getBytes()).append(" SCN").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorName(), colorDetails.getIndirectReference());
        }
    }

    /* access modifiers changed from: protected */
    public void checkWriter() {
        if (this.writer == null) {
            throw new NullPointerException("The writer in PdfContentByte is null.");
        }
    }

    public void showText(PdfTextArray pdfTextArray) {
        if (this.state.fontDetails != null) {
            this.content.append("[");
            ArrayList arrayList = pdfTextArray.getArrayList();
            boolean z = false;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof String) {
                    showText2((String) obj);
                    z = false;
                } else {
                    if (z) {
                        this.content.append(' ');
                    } else {
                        z = true;
                    }
                    this.content.append(((Float) obj).floatValue());
                }
            }
            this.content.append("]TJ").append_i(this.separator);
            return;
        }
        throw new NullPointerException("Font and size must be set before writing any text");
    }

    public PdfWriter getPdfWriter() {
        return this.writer;
    }

    public PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.pdf.localGoto(str, f, f2, f3, f4);
    }

    public boolean localDestination(String str, PdfDestination pdfDestination) {
        return this.pdf.localDestination(str, pdfDestination);
    }

    public PdfContentByte getDuplicate() {
        return new PdfContentByte(this.writer);
    }

    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, str2, f, f2, f3, f4);
    }

    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, i, f, f2, f3, f4);
    }

    public void roundRectangle(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9 = f3;
        float f10 = f4;
        float f11 = f5;
        if (f9 < 0.0f) {
            float f12 = f + f9;
            f9 = -f9;
            f6 = f12;
        } else {
            f6 = f;
        }
        if (f10 < 0.0f) {
            f7 = -f10;
            f8 = f2 + f10;
        } else {
            f8 = f2;
            f7 = f10;
        }
        float f13 = f11 < 0.0f ? -f11 : f11;
        float f14 = f6 + f13;
        moveTo(f14, f8);
        float f15 = f6 + f9;
        float f16 = f15 - f13;
        lineTo(f16, f8);
        float f17 = f13 * 0.4477f;
        float f18 = f15 - f17;
        float f19 = f8 + f17;
        float f20 = f8 + f13;
        curveTo(f18, f8, f15, f19, f15, f20);
        float f21 = f7 + f8;
        float f22 = f21 - f13;
        lineTo(f15, f22);
        float f23 = f21 - f17;
        curveTo(f15, f23, f18, f21, f16, f21);
        lineTo(f14, f21);
        float f24 = f6 + f17;
        curveTo(f24, f21, f6, f23, f6, f22);
        lineTo(f6, f20);
        curveTo(f6, f19, f24, f8, f14, f8);
    }

    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        this.pdf.setAction(pdfAction, f, f2, f3, f4);
    }

    public void setLiteral(String str) {
        this.content.append(str);
    }

    public void setLiteral(char c) {
        this.content.append(c);
    }

    public void setLiteral(float f) {
        this.content.append(f);
    }

    /* access modifiers changed from: package-private */
    public void checkNoPattern(PdfTemplate pdfTemplate) {
        if (pdfTemplate.getType() == 3) {
            throw new RuntimeException("Invalid use of a pattern. A template was expected.");
        }
    }

    public void drawRadioField(float f, float f2, float f3, float f4, boolean z) {
        float f5;
        float f6;
        float f7;
        float f8;
        if (f > f3) {
            f5 = f;
            f6 = f3;
        } else {
            f6 = f;
            f5 = f3;
        }
        if (f2 > f4) {
            f7 = f2;
            f8 = f4;
        } else {
            f8 = f2;
            f7 = f4;
        }
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new Color((int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM));
        arc(f6 + 1.0f, f8 + 1.0f, f5 - 1.0f, f7 - 1.0f, 0.0f, 360.0f);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new Color(160, 160, 160));
        arc(f6 + 0.5f, f8 + 0.5f, f5 - 0.5f, f7 - 0.5f, 45.0f, 180.0f);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new Color(0, 0, 0));
        arc(f6 + 1.5f, f8 + 1.5f, f5 - 1.5f, f7 - 1.5f, 45.0f, 180.0f);
        stroke();
        if (z) {
            setLineWidth(1.0f);
            setLineCap(1);
            setColorFill(new Color(0, 0, 0));
            arc(f6 + 4.0f, f8 + 4.0f, f5 - 4.0f, f7 - 4.0f, 0.0f, 360.0f);
            fill();
        }
    }

    public void drawTextField(float f, float f2, float f3, float f4) {
        if (f > f3) {
            float f5 = f3;
            f3 = f;
            f = f5;
        }
        if (f2 > f4) {
            float f6 = f4;
            f4 = f2;
            f2 = f6;
        }
        setColorStroke(new Color((int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM));
        setLineWidth(1.0f);
        setLineCap(0);
        float f7 = f3 - f;
        float f8 = f4 - f2;
        rectangle(f, f2, f7, f8);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new Color(255, 255, 255));
        rectangle(f + 0.5f, 0.5f + f2, f7 - 1.0f, f8 - 1.0f);
        fill();
        setColorStroke(new Color((int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM));
        setLineWidth(1.0f);
        setLineCap(0);
        float f9 = f + 1.0f;
        float f10 = f2 + 1.5f;
        moveTo(f9, f10);
        float f11 = f3 - 1.5f;
        lineTo(f11, f10);
        float f12 = f4 - 1.0f;
        lineTo(f11, f12);
        stroke();
        setColorStroke(new Color(160, 160, 160));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(f9, f2 + 1.0f);
        lineTo(f9, f12);
        lineTo(f3 - 1.0f, f12);
        stroke();
        setColorStroke(new Color(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        float f13 = f + 2.0f;
        moveTo(f13, f2 + 2.0f);
        float f14 = f4 - 2.0f;
        lineTo(f13, f14);
        lineTo(f3 - 2.0f, f14);
        stroke();
    }

    public void drawButton(float f, float f2, float f3, float f4, String str, BaseFont baseFont, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = f5;
        if (f > f3) {
            f6 = f;
            f7 = f3;
        } else {
            f7 = f;
            f6 = f3;
        }
        if (f2 > f4) {
            f8 = f2;
            f9 = f4;
        } else {
            f9 = f2;
            f8 = f4;
        }
        setColorStroke(new Color(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        float f11 = f6 - f7;
        float f12 = f8 - f9;
        rectangle(f7, f9, f11, f12);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new Color((int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM));
        rectangle(f7 + 0.5f, 0.5f + f9, f11 - 1.0f, f12 - 1.0f);
        fill();
        setColorStroke(new Color(255, 255, 255));
        setLineWidth(1.0f);
        setLineCap(0);
        float f13 = f7 + 1.0f;
        float f14 = f9 + 1.0f;
        moveTo(f13, f14);
        float f15 = f8 - 1.0f;
        lineTo(f13, f15);
        float f16 = f6 - 1.0f;
        lineTo(f16, f15);
        stroke();
        setColorStroke(new Color(160, 160, 160));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(f13, f14);
        lineTo(f16, f14);
        lineTo(f16, f15);
        stroke();
        resetRGBColorFill();
        beginText();
        setFontAndSize(baseFont, f10);
        showTextAligned(1, str, f7 + (f11 / 2.0f), f9 + ((f12 - f10) / 2.0f), 0.0f);
        endText();
    }

    /* access modifiers changed from: package-private */
    public PageResources getPageResources() {
        return this.pdf.getPageResources();
    }

    public void setGState(PdfGState pdfGState) {
        PdfObject[] addSimpleExtGState = this.writer.addSimpleExtGState(pdfGState);
        this.content.append(getPageResources().addExtGState((PdfName) addSimpleExtGState[0], (PdfIndirectReference) addSimpleExtGState[1]).getBytes()).append(" gs").append_i(this.separator);
    }

    public void beginLayer(PdfOCG pdfOCG) {
        if (!(pdfOCG instanceof PdfLayer) || ((PdfLayer) pdfOCG).getTitle() == null) {
            if (this.layerDepth == null) {
                this.layerDepth = new ArrayList();
            }
            if (pdfOCG instanceof PdfLayerMembership) {
                this.layerDepth.add(new Integer(1));
                beginLayer2(pdfOCG);
                return;
            }
            int i = 0;
            for (PdfLayer pdfLayer = (PdfLayer) pdfOCG; pdfLayer != null; pdfLayer = pdfLayer.getParent()) {
                if (pdfLayer.getTitle() == null) {
                    beginLayer2(pdfLayer);
                    i++;
                }
            }
            this.layerDepth.add(new Integer(i));
            return;
        }
        throw new IllegalArgumentException("A title is not a layer");
    }

    private void beginLayer2(PdfOCG pdfOCG) {
        this.content.append("/OC ").append(getPageResources().addProperty((PdfName) this.writer.addSimpleProperty(pdfOCG, pdfOCG.getRef())[0], pdfOCG.getRef()).getBytes()).append(" BDC").append_i(this.separator);
    }

    public void endLayer() {
        ArrayList arrayList = this.layerDepth;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalPdfSyntaxException("Unbalanced layer operators.");
        }
        ArrayList arrayList2 = this.layerDepth;
        int intValue = ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue();
        ArrayList arrayList3 = this.layerDepth;
        arrayList3.remove(arrayList3.size() - 1);
        while (true) {
            int i = intValue - 1;
            if (intValue > 0) {
                this.content.append("EMC").append_i(this.separator);
                intValue = i;
            } else {
                return;
            }
        }
    }

    public void transform(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        this.content.append(dArr[0]).append(' ').append(dArr[1]).append(' ').append(dArr[2]).append(' ');
        this.content.append(dArr[3]).append(' ').append(dArr[4]).append(' ').append(dArr[5]).append(" cm").append_i(this.separator);
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.writer.addAnnotation(pdfAnnotation);
    }

    public void setDefaultColorspace(PdfName pdfName, PdfObject pdfObject) {
        getPageResources().addDefaultColor(pdfName, pdfObject);
    }

    public void beginMarkedContentSequence(PdfStructureElement pdfStructureElement) {
        PdfArray pdfArray;
        PdfObject pdfObject = pdfStructureElement.get(PdfName.f691K);
        int markPoint = this.pdf.getMarkPoint();
        if (pdfObject != null) {
            if (pdfObject.isNumber()) {
                pdfArray = new PdfArray();
                pdfArray.add(pdfObject);
                pdfStructureElement.put(PdfName.f691K, pdfArray);
            } else if (pdfObject.isArray()) {
                pdfArray = (PdfArray) pdfObject;
                if (!pdfArray.getPdfObject(0).isNumber()) {
                    throw new IllegalArgumentException("The structure has kids.");
                }
            } else {
                throw new IllegalArgumentException("Unknown object at /K " + pdfObject.getClass().toString());
            }
            PdfDictionary pdfDictionary = new PdfDictionary(PdfName.MCR);
            pdfDictionary.put(PdfName.f709PG, this.writer.getCurrentPage());
            pdfDictionary.put(PdfName.MCID, new PdfNumber(markPoint));
            pdfArray.add((PdfObject) pdfDictionary);
            pdfStructureElement.setPageMark(this.writer.getPageNumber() - 1, -1);
        } else {
            pdfStructureElement.setPageMark(this.writer.getPageNumber() - 1, markPoint);
            pdfStructureElement.put(PdfName.f709PG, this.writer.getCurrentPage());
        }
        this.pdf.incMarkPoint();
        this.mcDepth++;
        this.content.append(pdfStructureElement.get(PdfName.f719S).getBytes()).append(" <</MCID ").append(markPoint).append(">> BDC").append_i(this.separator);
    }

    public void endMarkedContentSequence() {
        int i = this.mcDepth;
        if (i != 0) {
            this.mcDepth = i - 1;
            this.content.append("EMC").append_i(this.separator);
            return;
        }
        throw new IllegalPdfSyntaxException("Unbalanced begin/end marked content operators.");
    }

    public void beginMarkedContentSequence(PdfName pdfName, PdfDictionary pdfDictionary, boolean z) {
        PdfObject[] pdfObjectArr;
        if (pdfDictionary == null) {
            this.content.append(pdfName.getBytes()).append(" BMC").append_i(this.separator);
            return;
        }
        this.content.append(pdfName.getBytes()).append(' ');
        if (z) {
            try {
                pdfDictionary.toPdf(this.writer, this.content);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            if (this.writer.propertyExists(pdfDictionary)) {
                pdfObjectArr = this.writer.addSimpleProperty(pdfDictionary, (PdfIndirectReference) null);
            } else {
                PdfWriter pdfWriter = this.writer;
                pdfObjectArr = pdfWriter.addSimpleProperty(pdfDictionary, pdfWriter.getPdfIndirectReference());
            }
            this.content.append(getPageResources().addProperty((PdfName) pdfObjectArr[0], (PdfIndirectReference) pdfObjectArr[1]).getBytes());
        }
        this.content.append(" BDC").append_i(this.separator);
        this.mcDepth++;
    }

    public void beginMarkedContentSequence(PdfName pdfName) {
        beginMarkedContentSequence(pdfName, (PdfDictionary) null, false);
    }

    public void sanityCheck() {
        if (this.mcDepth != 0) {
            throw new IllegalPdfSyntaxException("Unbalanced marked content operators.");
        } else if (!this.inText) {
            ArrayList arrayList = this.layerDepth;
            if (arrayList != null && !arrayList.isEmpty()) {
                throw new IllegalPdfSyntaxException("Unbalanced layer operators.");
            } else if (!this.stateList.isEmpty()) {
                throw new IllegalPdfSyntaxException("Unbalanced save/restore state operators.");
            }
        } else {
            throw new IllegalPdfSyntaxException("Unbalanced begin/end text operators.");
        }
    }
}
