package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import java.io.IOException;

public class PushbuttonField extends BaseField {
    public static final int LAYOUT_ICON_LEFT_LABEL_RIGHT = 5;
    public static final int LAYOUT_ICON_ONLY = 2;
    public static final int LAYOUT_ICON_TOP_LABEL_BOTTOM = 3;
    public static final int LAYOUT_LABEL_LEFT_ICON_RIGHT = 6;
    public static final int LAYOUT_LABEL_ONLY = 1;
    public static final int LAYOUT_LABEL_OVER_ICON = 7;
    public static final int LAYOUT_LABEL_TOP_ICON_BOTTOM = 4;
    public static final int SCALE_ICON_ALWAYS = 1;
    public static final int SCALE_ICON_IS_TOO_BIG = 3;
    public static final int SCALE_ICON_IS_TOO_SMALL = 4;
    public static final int SCALE_ICON_NEVER = 2;
    private boolean iconFitToBounds;
    private float iconHorizontalAdjustment = 0.5f;
    private PRIndirectReference iconReference;
    private float iconVerticalAdjustment = 0.5f;
    private Image image;
    private int layout = 1;
    private boolean proportionalIcon = true;
    private int scaleIcon = 1;
    private PdfTemplate template;

    /* renamed from: tp */
    private PdfTemplate f761tp;

    public PushbuttonField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
    }

    public int getLayout() {
        return this.layout;
    }

    public void setLayout(int i) {
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Layout out of bounds.");
        }
        this.layout = i;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image2) {
        this.image = image2;
        this.template = null;
    }

    public PdfTemplate getTemplate() {
        return this.template;
    }

    public void setTemplate(PdfTemplate pdfTemplate) {
        this.template = pdfTemplate;
        this.image = null;
    }

    public int getScaleIcon() {
        return this.scaleIcon;
    }

    public void setScaleIcon(int i) {
        if (i < 1 || i > 4) {
            i = 1;
        }
        this.scaleIcon = i;
    }

    public boolean isProportionalIcon() {
        return this.proportionalIcon;
    }

    public void setProportionalIcon(boolean z) {
        this.proportionalIcon = z;
    }

    public float getIconVerticalAdjustment() {
        return this.iconVerticalAdjustment;
    }

    public void setIconVerticalAdjustment(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.iconVerticalAdjustment = f;
    }

    public float getIconHorizontalAdjustment() {
        return this.iconHorizontalAdjustment;
    }

    public void setIconHorizontalAdjustment(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.iconHorizontalAdjustment = f;
    }

    private float calculateFontSize(float f, float f2) throws IOException, DocumentException {
        BaseFont realFont = getRealFont();
        float f3 = this.fontSize;
        if (f3 != 0.0f) {
            return f3;
        }
        float widthPoint = realFont.getWidthPoint(this.text, 1.0f);
        float min = Math.min(widthPoint == 0.0f ? 12.0f : f / widthPoint, f2 / (1.0f - realFont.getFontDescriptor(3, 1.0f)));
        if (min < 4.0f) {
            return 4.0f;
        }
        return min;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0261, code lost:
        if (r6 == 7) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0264, code lost:
        if (r6 != 2) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0267, code lost:
        r14 = r1;
        r1 = r3;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x026b, code lost:
        r14 = r1;
        r1 = r3;
        r3 = new com.lowagie.text.Rectangle(r11.getLeft() + r4, r11.getBottom() + r4, r11.getRight() - r4, r11.getTop() - r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009b, code lost:
        if (r0.iconReference == null) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0144, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0494  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.pdf.PdfAppearance getAppearance() throws java.io.IOException, com.lowagie.text.DocumentException {
        /*
            r32 = this;
            r0 = r32
            com.lowagie.text.pdf.PdfAppearance r10 = r32.getBorderAppearance()
            com.lowagie.text.Rectangle r11 = new com.lowagie.text.Rectangle
            com.lowagie.text.Rectangle r1 = r10.getBoundingBox()
            r11.<init>(r1)
            java.lang.String r1 = r0.text
            r2 = 1
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r0.text
            int r1 = r1.length()
            if (r1 != 0) goto L_0x002e
        L_0x001c:
            int r1 = r0.layout
            if (r1 == r2) goto L_0x04cf
            com.lowagie.text.Image r1 = r0.image
            if (r1 != 0) goto L_0x002e
            com.lowagie.text.pdf.PdfTemplate r1 = r0.template
            if (r1 != 0) goto L_0x002e
            com.lowagie.text.pdf.PRIndirectReference r1 = r0.iconReference
            if (r1 != 0) goto L_0x002e
            goto L_0x04cf
        L_0x002e:
            int r1 = r0.layout
            r3 = 2
            if (r1 != r3) goto L_0x0040
            com.lowagie.text.Image r1 = r0.image
            if (r1 != 0) goto L_0x0040
            com.lowagie.text.pdf.PdfTemplate r1 = r0.template
            if (r1 != 0) goto L_0x0040
            com.lowagie.text.pdf.PRIndirectReference r1 = r0.iconReference
            if (r1 != 0) goto L_0x0040
            return r10
        L_0x0040:
            com.lowagie.text.pdf.BaseFont r12 = r32.getRealFont()
            int r1 = r0.borderStyle
            r5 = 3
            if (r1 == r3) goto L_0x004f
            int r1 = r0.borderStyle
            if (r1 == r5) goto L_0x004f
            r1 = 0
            goto L_0x0050
        L_0x004f:
            r1 = 1
        L_0x0050:
            r11.getHeight()
            float r6 = r0.borderWidth
            float r6 = r0.borderWidth
            r7 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x005f
            float r8 = r0.borderWidth
            float r6 = r6 * r7
        L_0x005f:
            if (r1 == 0) goto L_0x0066
            float r1 = r0.borderWidth
            float r1 = r1 * r7
            goto L_0x0068
        L_0x0066:
            float r1 = r0.borderWidth
        L_0x0068:
            r8 = 1065353216(0x3f800000, float:1.0)
            float r1 = java.lang.Math.max(r1, r8)
            float r13 = java.lang.Math.min(r6, r1)
            r1 = 0
            r0.f761tp = r1
            float r9 = r0.fontSize
            float r14 = r11.getWidth()
            float r15 = r13 * r7
            float r14 = r14 - r15
            float r14 = r14 - r7
            float r16 = r11.getHeight()
            float r1 = r16 - r15
            boolean r4 = r0.iconFitToBounds
            r18 = 0
            if (r4 == 0) goto L_0x008d
            r4 = 0
            goto L_0x008f
        L_0x008d:
            float r4 = r13 + r8
        L_0x008f:
            int r6 = r0.layout
            com.lowagie.text.Image r3 = r0.image
            if (r3 != 0) goto L_0x009f
            com.lowagie.text.pdf.PdfTemplate r3 = r0.template
            if (r3 != 0) goto L_0x009f
            com.lowagie.text.pdf.PRIndirectReference r3 = r0.iconReference
            if (r3 != 0) goto L_0x009f
            goto L_0x0144
        L_0x009f:
            r3 = 1082130432(0x40800000, float:4.0)
            r21 = 1051931443(0x3eb33333, float:0.35)
            switch(r6) {
                case 1: goto L_0x022e;
                case 2: goto L_0x025d;
                case 3: goto L_0x01d5;
                case 4: goto L_0x0178;
                case 5: goto L_0x010e;
                case 6: goto L_0x00ad;
                case 7: goto L_0x022e;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            r1 = 0
            r3 = 0
            r14 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0288
        L_0x00ad:
            java.lang.String r6 = r0.text
            if (r6 == 0) goto L_0x022a
            java.lang.String r6 = r0.text
            int r6 = r6.length()
            if (r6 == 0) goto L_0x022a
            int r6 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r6 <= 0) goto L_0x022a
            int r6 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r6 > 0) goto L_0x00c3
            goto L_0x022a
        L_0x00c3:
            float r6 = r11.getWidth()
            float r6 = r6 * r21
            float r6 = r6 - r13
            int r9 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r9 <= 0) goto L_0x00d4
            float r3 = r0.calculateFontSize(r14, r6)
            r9 = r3
            goto L_0x00d6
        L_0x00d4:
            r9 = 1082130432(0x40800000, float:4.0)
        L_0x00d6:
            java.lang.String r3 = r0.text
            float r3 = r12.getWidthPoint((java.lang.String) r3, (float) r9)
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x00e3
            float r9 = r0.fontSize
            goto L_0x0144
        L_0x00e3:
            float r6 = r13 + r8
            float r1 = r11.getHeight()
            float r3 = r12.getFontDescriptor(r2, r9)
            float r1 = r1 - r3
            float r1 = r1 / r7
            com.lowagie.text.Rectangle r3 = new com.lowagie.text.Rectangle
            java.lang.String r7 = r0.text
            float r7 = r12.getWidthPoint((java.lang.String) r7, (float) r9)
            float r7 = r7 + r6
            float r14 = r11.getBottom()
            float r14 = r14 + r4
            float r19 = r11.getRight()
            float r5 = r19 - r4
            float r19 = r11.getTop()
            float r4 = r19 - r4
            r3.<init>(r7, r14, r5, r4)
            goto L_0x0228
        L_0x010e:
            java.lang.String r5 = r0.text
            if (r5 == 0) goto L_0x022a
            java.lang.String r5 = r0.text
            int r5 = r5.length()
            if (r5 == 0) goto L_0x022a
            int r5 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x022a
            int r5 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r5 > 0) goto L_0x0124
            goto L_0x022a
        L_0x0124:
            float r5 = r11.getWidth()
            float r5 = r5 * r21
            float r5 = r5 - r13
            int r6 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r6 <= 0) goto L_0x0135
            float r3 = r0.calculateFontSize(r14, r5)
            r9 = r3
            goto L_0x0137
        L_0x0135:
            r9 = 1082130432(0x40800000, float:4.0)
        L_0x0137:
            java.lang.String r3 = r0.text
            float r3 = r12.getWidthPoint((java.lang.String) r3, (float) r9)
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x0147
            float r9 = r0.fontSize
            r5 = 3
        L_0x0144:
            r6 = 1
            goto L_0x009f
        L_0x0147:
            float r1 = r11.getWidth()
            java.lang.String r3 = r0.text
            float r3 = r12.getWidthPoint((java.lang.String) r3, (float) r9)
            float r1 = r1 - r3
            float r1 = r1 - r13
            float r6 = r1 - r8
            float r1 = r11.getHeight()
            float r3 = r12.getFontDescriptor(r2, r9)
            float r1 = r1 - r3
            float r1 = r1 / r7
            com.lowagie.text.Rectangle r3 = new com.lowagie.text.Rectangle
            float r5 = r11.getLeft()
            float r5 = r5 + r4
            float r7 = r11.getBottom()
            float r7 = r7 + r4
            float r14 = r6 - r8
            float r19 = r11.getTop()
            float r4 = r19 - r4
            r3.<init>(r5, r7, r14, r4)
            goto L_0x0228
        L_0x0178:
            java.lang.String r5 = r0.text
            if (r5 == 0) goto L_0x022a
            java.lang.String r5 = r0.text
            int r5 = r5.length()
            if (r5 == 0) goto L_0x022a
            int r5 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x022a
            int r5 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r5 > 0) goto L_0x018e
            goto L_0x022a
        L_0x018e:
            float r1 = r11.getHeight()
            float r1 = r1 * r21
            float r1 = r1 - r13
            int r5 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x019f
            float r1 = r0.calculateFontSize(r14, r1)
            r9 = r1
            goto L_0x01a1
        L_0x019f:
            r9 = 1082130432(0x40800000, float:4.0)
        L_0x01a1:
            float r1 = r11.getWidth()
            java.lang.String r3 = r0.text
            float r3 = r12.getWidthPoint((java.lang.String) r3, (float) r9)
            float r1 = r1 - r3
            float r6 = r1 / r7
            float r1 = r11.getHeight()
            float r1 = r1 - r13
            float r1 = r1 - r9
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 >= 0) goto L_0x01b9
            r1 = r13
        L_0x01b9:
            com.lowagie.text.Rectangle r3 = new com.lowagie.text.Rectangle
            float r5 = r11.getLeft()
            float r5 = r5 + r4
            float r7 = r11.getBottom()
            float r7 = r7 + r4
            float r14 = r11.getRight()
            float r14 = r14 - r4
            r4 = 3
            float r19 = r12.getFontDescriptor(r4, r9)
            float r4 = r1 + r19
            r3.<init>(r5, r7, r14, r4)
            goto L_0x0228
        L_0x01d5:
            java.lang.String r5 = r0.text
            if (r5 == 0) goto L_0x022a
            java.lang.String r5 = r0.text
            int r5 = r5.length()
            if (r5 == 0) goto L_0x022a
            int r5 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x022a
            int r5 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r5 > 0) goto L_0x01ea
            goto L_0x022a
        L_0x01ea:
            float r1 = r11.getHeight()
            float r1 = r1 * r21
            float r1 = r1 - r13
            int r5 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x01fb
            float r1 = r0.calculateFontSize(r14, r1)
            r9 = r1
            goto L_0x01fd
        L_0x01fb:
            r9 = 1082130432(0x40800000, float:4.0)
        L_0x01fd:
            float r1 = r11.getWidth()
            java.lang.String r3 = r0.text
            float r3 = r12.getWidthPoint((java.lang.String) r3, (float) r9)
            float r1 = r1 - r3
            float r6 = r1 / r7
            r1 = 3
            float r3 = r12.getFontDescriptor(r1, r9)
            float r1 = r13 - r3
            com.lowagie.text.Rectangle r3 = new com.lowagie.text.Rectangle
            float r5 = r11.getLeft()
            float r5 = r5 + r4
            float r7 = r1 + r9
            float r14 = r11.getRight()
            float r14 = r14 - r4
            float r19 = r11.getTop()
            float r4 = r19 - r4
            r3.<init>(r5, r7, r14, r4)
        L_0x0228:
            r14 = r6
            goto L_0x0288
        L_0x022a:
            r5 = 3
            r6 = 2
            goto L_0x009f
        L_0x022e:
            java.lang.String r3 = r0.text
            if (r3 == 0) goto L_0x025d
            java.lang.String r3 = r0.text
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x025d
            int r3 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r3 <= 0) goto L_0x025d
            int r3 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r3 <= 0) goto L_0x025d
            float r9 = r0.calculateFontSize(r14, r1)
            float r1 = r11.getWidth()
            java.lang.String r3 = r0.text
            float r3 = r12.getWidthPoint((java.lang.String) r3, (float) r9)
            float r1 = r1 - r3
            float r1 = r1 / r7
            float r3 = r11.getHeight()
            float r5 = r12.getFontDescriptor(r2, r9)
            float r3 = r3 - r5
            float r3 = r3 / r7
            goto L_0x0260
        L_0x025d:
            r1 = 2143289344(0x7fc00000, float:NaN)
            r3 = 0
        L_0x0260:
            r5 = 7
            if (r6 == r5) goto L_0x026b
            r5 = 2
            if (r6 != r5) goto L_0x0267
            goto L_0x026b
        L_0x0267:
            r14 = r1
            r1 = r3
            r3 = 0
            goto L_0x0288
        L_0x026b:
            com.lowagie.text.Rectangle r5 = new com.lowagie.text.Rectangle
            float r6 = r11.getLeft()
            float r6 = r6 + r4
            float r7 = r11.getBottom()
            float r7 = r7 + r4
            float r14 = r11.getRight()
            float r14 = r14 - r4
            float r19 = r11.getTop()
            float r4 = r19 - r4
            r5.<init>(r6, r7, r14, r4)
            r14 = r1
            r1 = r3
            r3 = r5
        L_0x0288:
            float r4 = r11.getBottom()
            float r4 = r4 + r13
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0296
            float r1 = r11.getBottom()
            float r1 = r1 + r13
        L_0x0296:
            r7 = r1
            if (r3 == 0) goto L_0x02aa
            float r1 = r3.getWidth()
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 <= 0) goto L_0x02a9
            float r1 = r3.getHeight()
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 > 0) goto L_0x02aa
        L_0x02a9:
            r3 = 0
        L_0x02aa:
            if (r3 == 0) goto L_0x0385
            com.lowagie.text.Image r1 = r0.image
            if (r1 == 0) goto L_0x0301
            com.lowagie.text.pdf.PdfTemplate r1 = new com.lowagie.text.pdf.PdfTemplate
            com.lowagie.text.pdf.PdfWriter r4 = r0.writer
            r1.<init>(r4)
            r0.f761tp = r1
            com.lowagie.text.pdf.PdfTemplate r1 = r0.f761tp
            com.lowagie.text.Rectangle r4 = new com.lowagie.text.Rectangle
            com.lowagie.text.Image r5 = r0.image
            r4.<init>(r5)
            r1.setBoundingBox(r4)
            com.lowagie.text.pdf.PdfWriter r1 = r0.writer
            com.lowagie.text.pdf.PdfTemplate r4 = r0.f761tp
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.FRM
            r1.addDirectTemplateSimple(r4, r5)
            com.lowagie.text.pdf.PdfTemplate r1 = r0.f761tp
            com.lowagie.text.Image r4 = r0.image
            float r24 = r4.getWidth()
            r25 = 0
            r26 = 0
            com.lowagie.text.Image r5 = r0.image
            float r27 = r5.getHeight()
            r28 = 0
            r29 = 0
            r22 = r1
            r23 = r4
            r22.addImage(r23, r24, r25, r26, r27, r28, r29)
            com.lowagie.text.pdf.PdfTemplate r1 = r0.f761tp
            com.lowagie.text.Rectangle r1 = r1.getBoundingBox()
            float r1 = r1.getWidth()
            com.lowagie.text.pdf.PdfTemplate r4 = r0.f761tp
            com.lowagie.text.Rectangle r4 = r4.getBoundingBox()
            float r4 = r4.getHeight()
            goto L_0x0388
        L_0x0301:
            com.lowagie.text.pdf.PdfTemplate r1 = r0.template
            if (r1 == 0) goto L_0x035b
            com.lowagie.text.pdf.PdfTemplate r1 = new com.lowagie.text.pdf.PdfTemplate
            com.lowagie.text.pdf.PdfWriter r4 = r0.writer
            r1.<init>(r4)
            r0.f761tp = r1
            com.lowagie.text.pdf.PdfTemplate r1 = r0.f761tp
            com.lowagie.text.Rectangle r4 = new com.lowagie.text.Rectangle
            com.lowagie.text.pdf.PdfTemplate r5 = r0.template
            float r5 = r5.getWidth()
            com.lowagie.text.pdf.PdfTemplate r6 = r0.template
            float r6 = r6.getHeight()
            r4.<init>(r5, r6)
            r1.setBoundingBox(r4)
            com.lowagie.text.pdf.PdfWriter r1 = r0.writer
            com.lowagie.text.pdf.PdfTemplate r4 = r0.f761tp
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.FRM
            r1.addDirectTemplateSimple(r4, r5)
            com.lowagie.text.pdf.PdfTemplate r1 = r0.f761tp
            com.lowagie.text.pdf.PdfTemplate r4 = r0.template
            com.lowagie.text.Rectangle r5 = r4.getBoundingBox()
            float r5 = r5.getLeft()
            com.lowagie.text.pdf.PdfTemplate r6 = r0.template
            com.lowagie.text.Rectangle r6 = r6.getBoundingBox()
            float r6 = r6.getBottom()
            r1.addTemplate(r4, r5, r6)
            com.lowagie.text.pdf.PdfTemplate r1 = r0.f761tp
            com.lowagie.text.Rectangle r1 = r1.getBoundingBox()
            float r1 = r1.getWidth()
            com.lowagie.text.pdf.PdfTemplate r4 = r0.f761tp
            com.lowagie.text.Rectangle r4 = r4.getBoundingBox()
            float r4 = r4.getHeight()
            goto L_0x0388
        L_0x035b:
            com.lowagie.text.pdf.PRIndirectReference r1 = r0.iconReference
            if (r1 == 0) goto L_0x0385
            com.lowagie.text.pdf.PdfObject r1 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r1)
            com.lowagie.text.pdf.PdfDictionary r1 = (com.lowagie.text.pdf.PdfDictionary) r1
            if (r1 == 0) goto L_0x0385
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.BBOX
            com.lowagie.text.pdf.PdfArray r4 = r1.getAsArray(r4)
            com.lowagie.text.Rectangle r4 = com.lowagie.text.pdf.PdfReader.getNormalizedRectangle(r4)
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.MATRIX
            com.lowagie.text.pdf.PdfArray r1 = r1.getAsArray(r5)
            float r5 = r4.getWidth()
            float r4 = r4.getHeight()
            r31 = r5
            r5 = r1
            r1 = r31
            goto L_0x0389
        L_0x0385:
            r1 = 0
            r2 = 0
            r4 = 0
        L_0x0388:
            r5 = 0
        L_0x0389:
            if (r2 == 0) goto L_0x0489
            float r2 = r3.getWidth()
            float r2 = r2 / r1
            float r6 = r3.getHeight()
            float r6 = r6 / r4
            boolean r8 = r0.proportionalIcon
            r17 = r7
            if (r8 == 0) goto L_0x03c5
            int r8 = r0.scaleIcon
            r7 = 2
            if (r8 == r7) goto L_0x03c1
            r7 = 3
            if (r8 == r7) goto L_0x03b6
            r7 = 4
            if (r8 == r7) goto L_0x03ab
            float r8 = java.lang.Math.min(r2, r6)
            goto L_0x03c3
        L_0x03ab:
            float r2 = java.lang.Math.min(r2, r6)
            r8 = 1065353216(0x3f800000, float:1.0)
            float r8 = java.lang.Math.max(r2, r8)
            goto L_0x03c3
        L_0x03b6:
            r8 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.min(r2, r6)
            float r8 = java.lang.Math.min(r2, r8)
            goto L_0x03c3
        L_0x03c1:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x03c3:
            r7 = r8
            goto L_0x03ef
        L_0x03c5:
            r8 = 1065353216(0x3f800000, float:1.0)
            int r7 = r0.scaleIcon
            r8 = 2
            if (r7 == r8) goto L_0x03eb
            r8 = 3
            if (r7 == r8) goto L_0x03e0
            r8 = 4
            if (r7 == r8) goto L_0x03d5
        L_0x03d2:
            r7 = r2
            r8 = r6
            goto L_0x03ef
        L_0x03d5:
            r7 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.max(r2, r7)
            float r6 = java.lang.Math.max(r6, r7)
            goto L_0x03d2
        L_0x03e0:
            r7 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.min(r2, r7)
            float r6 = java.lang.Math.min(r6, r7)
            goto L_0x03d2
        L_0x03eb:
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x03ef:
            float r2 = r3.getLeft()
            float r6 = r3.getWidth()
            float r1 = r1 * r7
            float r6 = r6 - r1
            float r1 = r0.iconHorizontalAdjustment
            float r6 = r6 * r1
            float r16 = r2 + r6
            float r1 = r3.getBottom()
            float r2 = r3.getHeight()
            float r4 = r4 * r8
            float r2 = r2 - r4
            float r4 = r0.iconVerticalAdjustment
            float r2 = r2 * r4
            float r20 = r1 + r2
            r10.saveState()
            float r1 = r3.getLeft()
            float r2 = r3.getBottom()
            float r4 = r3.getWidth()
            float r3 = r3.getHeight()
            r10.rectangle(r1, r2, r4, r3)
            r10.clip()
            r10.newPath()
            com.lowagie.text.pdf.PdfTemplate r2 = r0.f761tp
            if (r2 == 0) goto L_0x0445
            r4 = 0
            r5 = 0
            r1 = r10
            r3 = r7
            r6 = r8
            r8 = r17
            r7 = r16
            r30 = r8
            r8 = r20
            r1.addTemplate(r2, r3, r4, r5, r6, r7, r8)
            r16 = r12
            r12 = r9
            goto L_0x0485
        L_0x0445:
            r30 = r17
            if (r5 == 0) goto L_0x0469
            int r1 = r5.size()
            r2 = 6
            if (r1 != r2) goto L_0x0469
            r1 = 4
            com.lowagie.text.pdf.PdfNumber r1 = r5.getAsNumber(r1)
            if (r1 == 0) goto L_0x045c
            float r1 = r1.floatValue()
            goto L_0x045d
        L_0x045c:
            r1 = 0
        L_0x045d:
            r2 = 5
            com.lowagie.text.pdf.PdfNumber r2 = r5.getAsNumber(r2)
            if (r2 == 0) goto L_0x046a
            float r18 = r2.floatValue()
            goto L_0x046a
        L_0x0469:
            r1 = 0
        L_0x046a:
            com.lowagie.text.pdf.PRIndirectReference r2 = r0.iconReference
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.FRM
            r5 = 0
            r6 = 0
            float r1 = r1 * r7
            float r16 = r16 - r1
            float r18 = r18 * r8
            float r17 = r20 - r18
            r1 = r10
            r4 = r7
            r7 = r8
            r8 = r16
            r16 = r12
            r12 = r9
            r9 = r17
            r1.addTemplateReference(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0485:
            r10.restoreState()
            goto L_0x048e
        L_0x0489:
            r30 = r7
            r16 = r12
            r12 = r9
        L_0x048e:
            boolean r1 = java.lang.Float.isNaN(r14)
            if (r1 != 0) goto L_0x04cf
            r10.saveState()
            float r1 = r11.getWidth()
            float r1 = r1 - r15
            float r2 = r11.getHeight()
            float r2 = r2 - r15
            r10.rectangle(r13, r13, r1, r2)
            r10.clip()
            r10.newPath()
            harmony.java.awt.Color r1 = r0.textColor
            if (r1 != 0) goto L_0x04b2
            r10.resetGrayFill()
            goto L_0x04b7
        L_0x04b2:
            harmony.java.awt.Color r1 = r0.textColor
            r10.setColorFill(r1)
        L_0x04b7:
            r10.beginText()
            r1 = r16
            r10.setFontAndSize(r1, r12)
            r1 = r30
            r10.setTextMatrix(r14, r1)
            java.lang.String r1 = r0.text
            r10.showText((java.lang.String) r1)
            r10.endText()
            r10.restoreState()
        L_0x04cf:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PushbuttonField.getAppearance():com.lowagie.text.pdf.PdfAppearance");
    }

    public PdfFormField getField() throws IOException, DocumentException {
        PdfFormField createPushButton = PdfFormField.createPushButton(this.writer);
        createPushButton.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        if (this.fieldName != null) {
            createPushButton.setFieldName(this.fieldName);
            if ((this.options & 1) != 0) {
                createPushButton.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                createPushButton.setFieldFlags(2);
            }
        }
        if (this.text != null) {
            createPushButton.setMKNormalCaption(this.text);
        }
        if (this.rotation != 0) {
            createPushButton.setMKRotation(this.rotation);
        }
        createPushButton.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance();
        createPushButton.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        if (this.textColor == null) {
            pdfAppearance.setGrayFill(0.0f);
        } else {
            pdfAppearance.setColorFill(this.textColor);
        }
        createPushButton.setDefaultAppearanceString(pdfAppearance);
        if (this.borderColor != null) {
            createPushButton.setMKBorderColor(this.borderColor);
        }
        if (this.backgroundColor != null) {
            createPushButton.setMKBackgroundColor(this.backgroundColor);
        }
        int i = this.visibility;
        if (i == 1) {
            createPushButton.setFlags(6);
        } else if (i != 2) {
            if (i != 3) {
                createPushButton.setFlags(4);
            } else {
                createPushButton.setFlags(36);
            }
        }
        PdfTemplate pdfTemplate = this.f761tp;
        if (pdfTemplate != null) {
            createPushButton.setMKNormalIcon(pdfTemplate);
        }
        createPushButton.setMKTextPosition(this.layout - 1);
        PdfName pdfName = PdfName.f641A;
        int i2 = this.scaleIcon;
        if (i2 == 3) {
            pdfName = PdfName.f646B;
        } else if (i2 == 4) {
            pdfName = PdfName.f719S;
        } else if (i2 == 2) {
            pdfName = PdfName.f696N;
        }
        createPushButton.setMKIconFit(pdfName, this.proportionalIcon ? PdfName.f707P : PdfName.f641A, this.iconHorizontalAdjustment, this.iconVerticalAdjustment, this.iconFitToBounds);
        return createPushButton;
    }

    public boolean isIconFitToBounds() {
        return this.iconFitToBounds;
    }

    public void setIconFitToBounds(boolean z) {
        this.iconFitToBounds = z;
    }

    public PRIndirectReference getIconReference() {
        return this.iconReference;
    }

    public void setIconReference(PRIndirectReference pRIndirectReference) {
        this.iconReference = pRIndirectReference;
    }
}
