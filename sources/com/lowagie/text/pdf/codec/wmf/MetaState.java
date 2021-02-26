package com.lowagie.text.pdf.codec.wmf;

import com.lowagie.text.pdf.PdfContentByte;
import harmony.java.awt.Color;
import harmony.java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class MetaState {
    public static final int ALTERNATE = 1;
    public static final int OPAQUE = 2;
    public static final int TA_BASELINE = 24;
    public static final int TA_BOTTOM = 8;
    public static final int TA_CENTER = 6;
    public static final int TA_LEFT = 0;
    public static final int TA_NOUPDATECP = 0;
    public static final int TA_RIGHT = 2;
    public static final int TA_TOP = 0;
    public static final int TA_UPDATECP = 1;
    public static final int TRANSPARENT = 1;
    public static final int WINDING = 2;
    public ArrayList MetaObjects;
    public int backgroundMode;
    public Color currentBackgroundColor;
    public MetaBrush currentBrush;
    public MetaFont currentFont;
    public MetaPen currentPen;
    public Point currentPoint;
    public Color currentTextColor;
    public int extentWx;
    public int extentWy;
    public int lineJoin;
    public int offsetWx;
    public int offsetWy;
    public int polyFillMode;
    public Stack savedStates;
    public float scalingX;
    public float scalingY;
    public int textAlign;

    public MetaState() {
        this.currentBackgroundColor = Color.white;
        this.currentTextColor = Color.black;
        this.backgroundMode = 2;
        this.polyFillMode = 1;
        this.lineJoin = 1;
        this.savedStates = new Stack();
        this.MetaObjects = new ArrayList();
        this.currentPoint = new Point(0, 0);
        this.currentPen = new MetaPen();
        this.currentBrush = new MetaBrush();
        this.currentFont = new MetaFont();
    }

    public MetaState(MetaState metaState) {
        this.currentBackgroundColor = Color.white;
        this.currentTextColor = Color.black;
        this.backgroundMode = 2;
        this.polyFillMode = 1;
        this.lineJoin = 1;
        setMetaState(metaState);
    }

    public void setMetaState(MetaState metaState) {
        this.savedStates = metaState.savedStates;
        this.MetaObjects = metaState.MetaObjects;
        this.currentPoint = metaState.currentPoint;
        this.currentPen = metaState.currentPen;
        this.currentBrush = metaState.currentBrush;
        this.currentFont = metaState.currentFont;
        this.currentBackgroundColor = metaState.currentBackgroundColor;
        this.currentTextColor = metaState.currentTextColor;
        this.backgroundMode = metaState.backgroundMode;
        this.polyFillMode = metaState.polyFillMode;
        this.textAlign = metaState.textAlign;
        this.lineJoin = metaState.lineJoin;
        this.offsetWx = metaState.offsetWx;
        this.offsetWy = metaState.offsetWy;
        this.extentWx = metaState.extentWx;
        this.extentWy = metaState.extentWy;
        this.scalingX = metaState.scalingX;
        this.scalingY = metaState.scalingY;
    }

    public void addMetaObject(MetaObject metaObject) {
        for (int i = 0; i < this.MetaObjects.size(); i++) {
            if (this.MetaObjects.get(i) == null) {
                this.MetaObjects.set(i, metaObject);
                return;
            }
        }
        this.MetaObjects.add(metaObject);
    }

    public void selectMetaObject(int i, PdfContentByte pdfContentByte) {
        MetaObject metaObject = (MetaObject) this.MetaObjects.get(i);
        if (metaObject != null) {
            int type = metaObject.getType();
            if (type == 1) {
                this.currentPen = (MetaPen) metaObject;
                int style = this.currentPen.getStyle();
                if (style != 5) {
                    pdfContentByte.setColorStroke(this.currentPen.getColor());
                    pdfContentByte.setLineWidth(Math.abs((((float) this.currentPen.getPenWidth()) * this.scalingX) / ((float) this.extentWx)));
                    if (style == 1) {
                        pdfContentByte.setLineDash(18.0f, 6.0f, 0.0f);
                    } else if (style == 2) {
                        pdfContentByte.setLineDash(3.0f, 0.0f);
                    } else if (style == 3) {
                        pdfContentByte.setLiteral("[9 6 3 6]0 d\n");
                    } else if (style != 4) {
                        pdfContentByte.setLineDash(0.0f);
                    } else {
                        pdfContentByte.setLiteral("[9 3 3 3 3 3]0 d\n");
                    }
                }
            } else if (type == 2) {
                this.currentBrush = (MetaBrush) metaObject;
                int style2 = this.currentBrush.getStyle();
                if (style2 == 0) {
                    pdfContentByte.setColorFill(this.currentBrush.getColor());
                } else if (style2 == 2) {
                    pdfContentByte.setColorFill(this.currentBackgroundColor);
                }
            } else if (type == 3) {
                this.currentFont = (MetaFont) metaObject;
            }
        }
    }

    public void deleteMetaObject(int i) {
        this.MetaObjects.set(i, (Object) null);
    }

    public void saveState(PdfContentByte pdfContentByte) {
        pdfContentByte.saveState();
        this.savedStates.push(new MetaState(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.lowagie.text.pdf.codec.wmf.MetaState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void restoreState(int r3, com.lowagie.text.pdf.PdfContentByte r4) {
        /*
            r2 = this;
            if (r3 >= 0) goto L_0x000e
            int r3 = -r3
            java.util.Stack r0 = r2.savedStates
            int r0 = r0.size()
            int r3 = java.lang.Math.min(r3, r0)
            goto L_0x001a
        L_0x000e:
            java.util.Stack r0 = r2.savedStates
            int r0 = r0.size()
            int r0 = r0 - r3
            r3 = 0
            int r3 = java.lang.Math.max(r0, r3)
        L_0x001a:
            if (r3 != 0) goto L_0x001d
            return
        L_0x001d:
            r0 = 0
        L_0x001e:
            int r1 = r3 + -1
            if (r3 != 0) goto L_0x0026
            r2.setMetaState(r0)
            return
        L_0x0026:
            r4.restoreState()
            java.util.Stack r3 = r2.savedStates
            java.lang.Object r3 = r3.pop()
            r0 = r3
            com.lowagie.text.pdf.codec.wmf.MetaState r0 = (com.lowagie.text.pdf.codec.wmf.MetaState) r0
            r3 = r1
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.wmf.MetaState.restoreState(int, com.lowagie.text.pdf.PdfContentByte):void");
    }

    public void cleanup(PdfContentByte pdfContentByte) {
        int size = this.savedStates.size();
        while (true) {
            int i = size - 1;
            if (size > 0) {
                pdfContentByte.restoreState();
                size = i;
            } else {
                return;
            }
        }
    }

    public float transformX(int i) {
        return ((((float) i) - ((float) this.offsetWx)) * this.scalingX) / ((float) this.extentWx);
    }

    public float transformY(int i) {
        return (1.0f - ((((float) i) - ((float) this.offsetWy)) / ((float) this.extentWy))) * this.scalingY;
    }

    public void setScalingX(float f) {
        this.scalingX = f;
    }

    public void setScalingY(float f) {
        this.scalingY = f;
    }

    public void setOffsetWx(int i) {
        this.offsetWx = i;
    }

    public void setOffsetWy(int i) {
        this.offsetWy = i;
    }

    public void setExtentWx(int i) {
        this.extentWx = i;
    }

    public void setExtentWy(int i) {
        this.extentWy = i;
    }

    public float transformAngle(float f) {
        if (this.scalingY < 0.0f) {
            f = -f;
        }
        return (float) (this.scalingX < 0.0f ? 3.141592653589793d - ((double) f) : (double) f);
    }

    public void setCurrentPoint(Point point) {
        this.currentPoint = point;
    }

    public Point getCurrentPoint() {
        return this.currentPoint;
    }

    public MetaBrush getCurrentBrush() {
        return this.currentBrush;
    }

    public MetaPen getCurrentPen() {
        return this.currentPen;
    }

    public MetaFont getCurrentFont() {
        return this.currentFont;
    }

    public Color getCurrentBackgroundColor() {
        return this.currentBackgroundColor;
    }

    public void setCurrentBackgroundColor(Color color) {
        this.currentBackgroundColor = color;
    }

    public Color getCurrentTextColor() {
        return this.currentTextColor;
    }

    public void setCurrentTextColor(Color color) {
        this.currentTextColor = color;
    }

    public int getBackgroundMode() {
        return this.backgroundMode;
    }

    public void setBackgroundMode(int i) {
        this.backgroundMode = i;
    }

    public int getTextAlign() {
        return this.textAlign;
    }

    public void setTextAlign(int i) {
        this.textAlign = i;
    }

    public int getPolyFillMode() {
        return this.polyFillMode;
    }

    public void setPolyFillMode(int i) {
        this.polyFillMode = i;
    }

    public void setLineJoinRectangle(PdfContentByte pdfContentByte) {
        if (this.lineJoin != 0) {
            this.lineJoin = 0;
            pdfContentByte.setLineJoin(0);
        }
    }

    public void setLineJoinPolygon(PdfContentByte pdfContentByte) {
        if (this.lineJoin == 0) {
            this.lineJoin = 1;
            pdfContentByte.setLineJoin(1);
        }
    }

    public boolean getLineNeutral() {
        return this.lineJoin == 0;
    }
}
