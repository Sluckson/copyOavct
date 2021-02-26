package com.lowagie.text;

import com.lowagie.text.pdf.GrayColor;
import harmony.java.awt.Color;
import java.util.ArrayList;

public class Rectangle implements Element {
    public static final int BOTTOM = 2;
    public static final int BOX = 15;
    public static final int LEFT = 4;
    public static final int NO_BORDER = 0;
    public static final int RIGHT = 8;
    public static final int TOP = 1;
    public static final int UNDEFINED = -1;
    protected Color backgroundColor;
    protected int border;
    protected Color borderColor;
    protected Color borderColorBottom;
    protected Color borderColorLeft;
    protected Color borderColorRight;
    protected Color borderColorTop;
    protected float borderWidth;
    protected float borderWidthBottom;
    protected float borderWidthLeft;
    protected float borderWidthRight;
    protected float borderWidthTop;
    protected float llx;
    protected float lly;
    protected int rotation;
    protected float urx;
    protected float ury;
    protected boolean useVariableBorders;

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return false;
    }

    public int type() {
        return 30;
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this.rotation = 0;
        this.backgroundColor = null;
        this.border = -1;
        this.useVariableBorders = false;
        this.borderWidth = -1.0f;
        this.borderWidthLeft = -1.0f;
        this.borderWidthRight = -1.0f;
        this.borderWidthTop = -1.0f;
        this.borderWidthBottom = -1.0f;
        this.borderColor = null;
        this.borderColorLeft = null;
        this.borderColorRight = null;
        this.borderColorTop = null;
        this.borderColorBottom = null;
        this.llx = f;
        this.lly = f2;
        this.urx = f3;
        this.ury = f4;
    }

    public Rectangle(float f, float f2) {
        this(0.0f, 0.0f, f, f2);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.llx, rectangle.lly, rectangle.urx, rectangle.ury);
        cloneNonPositionParameters(rectangle);
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ArrayList getChunks() {
        return new ArrayList();
    }

    public void setLeft(float f) {
        this.llx = f;
    }

    public float getLeft() {
        return this.llx;
    }

    public float getLeft(float f) {
        return this.llx + f;
    }

    public void setRight(float f) {
        this.urx = f;
    }

    public float getRight() {
        return this.urx;
    }

    public float getRight(float f) {
        return this.urx - f;
    }

    public float getWidth() {
        return this.urx - this.llx;
    }

    public void setTop(float f) {
        this.ury = f;
    }

    public float getTop() {
        return this.ury;
    }

    public float getTop(float f) {
        return this.ury - f;
    }

    public void setBottom(float f) {
        this.lly = f;
    }

    public float getBottom() {
        return this.lly;
    }

    public float getBottom(float f) {
        return this.lly + f;
    }

    public float getHeight() {
        return this.ury - this.lly;
    }

    public void normalize() {
        float f = this.llx;
        float f2 = this.urx;
        if (f > f2) {
            this.llx = f2;
            this.urx = f;
        }
        float f3 = this.lly;
        float f4 = this.ury;
        if (f3 > f4) {
            this.lly = f4;
            this.ury = f3;
        }
    }

    public int getRotation() {
        return this.rotation;
    }

    public Rectangle rotate() {
        Rectangle rectangle = new Rectangle(this.lly, this.llx, this.ury, this.urx);
        rectangle.rotation = this.rotation + 90;
        rectangle.rotation %= 360;
        return rectangle;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public float getGrayFill() {
        Color color = this.backgroundColor;
        if (color instanceof GrayColor) {
            return ((GrayColor) color).getGray();
        }
        return 0.0f;
    }

    public void setGrayFill(float f) {
        this.backgroundColor = new GrayColor(f);
    }

    public int getBorder() {
        return this.border;
    }

    public boolean hasBorders() {
        int i = this.border;
        if (i == -1 || i == 0) {
            return false;
        }
        if (this.borderWidth > 0.0f || this.borderWidthLeft > 0.0f || this.borderWidthRight > 0.0f || this.borderWidthTop > 0.0f || this.borderWidthBottom > 0.0f) {
            return true;
        }
        return false;
    }

    public boolean hasBorder(int i) {
        int i2 = this.border;
        return i2 != -1 && (i2 & i) == i;
    }

    public void setBorder(int i) {
        this.border = i;
    }

    public boolean isUseVariableBorders() {
        return this.useVariableBorders;
    }

    public void setUseVariableBorders(boolean z) {
        this.useVariableBorders = z;
    }

    public void enableBorderSide(int i) {
        if (this.border == -1) {
            this.border = 0;
        }
        this.border = i | this.border;
    }

    public void disableBorderSide(int i) {
        if (this.border == -1) {
            this.border = 0;
        }
        this.border = (~i) & this.border;
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public void setBorderWidth(float f) {
        this.borderWidth = f;
    }

    private float getVariableBorderWidth(float f, int i) {
        if ((i & this.border) != 0) {
            return f != -1.0f ? f : this.borderWidth;
        }
        return 0.0f;
    }

    private void updateBorderBasedOnWidth(float f, int i) {
        this.useVariableBorders = true;
        if (f > 0.0f) {
            enableBorderSide(i);
        } else {
            disableBorderSide(i);
        }
    }

    public float getBorderWidthLeft() {
        return getVariableBorderWidth(this.borderWidthLeft, 4);
    }

    public void setBorderWidthLeft(float f) {
        this.borderWidthLeft = f;
        updateBorderBasedOnWidth(f, 4);
    }

    public float getBorderWidthRight() {
        return getVariableBorderWidth(this.borderWidthRight, 8);
    }

    public void setBorderWidthRight(float f) {
        this.borderWidthRight = f;
        updateBorderBasedOnWidth(f, 8);
    }

    public float getBorderWidthTop() {
        return getVariableBorderWidth(this.borderWidthTop, 1);
    }

    public void setBorderWidthTop(float f) {
        this.borderWidthTop = f;
        updateBorderBasedOnWidth(f, 1);
    }

    public float getBorderWidthBottom() {
        return getVariableBorderWidth(this.borderWidthBottom, 2);
    }

    public void setBorderWidthBottom(float f) {
        this.borderWidthBottom = f;
        updateBorderBasedOnWidth(f, 2);
    }

    public Color getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    public Color getBorderColorLeft() {
        Color color = this.borderColorLeft;
        return color == null ? this.borderColor : color;
    }

    public void setBorderColorLeft(Color color) {
        this.borderColorLeft = color;
    }

    public Color getBorderColorRight() {
        Color color = this.borderColorRight;
        return color == null ? this.borderColor : color;
    }

    public void setBorderColorRight(Color color) {
        this.borderColorRight = color;
    }

    public Color getBorderColorTop() {
        Color color = this.borderColorTop;
        return color == null ? this.borderColor : color;
    }

    public void setBorderColorTop(Color color) {
        this.borderColorTop = color;
    }

    public Color getBorderColorBottom() {
        Color color = this.borderColorBottom;
        return color == null ? this.borderColor : color;
    }

    public void setBorderColorBottom(Color color) {
        this.borderColorBottom = color;
    }

    public Rectangle rectangle(float f, float f2) {
        Rectangle rectangle = new Rectangle(this);
        if (getTop() > f) {
            rectangle.setTop(f);
            rectangle.disableBorderSide(1);
        }
        if (getBottom() < f2) {
            rectangle.setBottom(f2);
            rectangle.disableBorderSide(2);
        }
        return rectangle;
    }

    public void cloneNonPositionParameters(Rectangle rectangle) {
        this.rotation = rectangle.rotation;
        this.backgroundColor = rectangle.backgroundColor;
        this.border = rectangle.border;
        this.useVariableBorders = rectangle.useVariableBorders;
        this.borderWidth = rectangle.borderWidth;
        this.borderWidthLeft = rectangle.borderWidthLeft;
        this.borderWidthRight = rectangle.borderWidthRight;
        this.borderWidthTop = rectangle.borderWidthTop;
        this.borderWidthBottom = rectangle.borderWidthBottom;
        this.borderColor = rectangle.borderColor;
        this.borderColorLeft = rectangle.borderColorLeft;
        this.borderColorRight = rectangle.borderColorRight;
        this.borderColorTop = rectangle.borderColorTop;
        this.borderColorBottom = rectangle.borderColorBottom;
    }

    public void softCloneNonPositionParameters(Rectangle rectangle) {
        int i = rectangle.rotation;
        if (i != 0) {
            this.rotation = i;
        }
        Color color = rectangle.backgroundColor;
        if (color != null) {
            this.backgroundColor = color;
        }
        int i2 = rectangle.border;
        if (i2 != -1) {
            this.border = i2;
        }
        if (this.useVariableBorders) {
            this.useVariableBorders = rectangle.useVariableBorders;
        }
        float f = rectangle.borderWidth;
        if (f != -1.0f) {
            this.borderWidth = f;
        }
        float f2 = rectangle.borderWidthLeft;
        if (f2 != -1.0f) {
            this.borderWidthLeft = f2;
        }
        float f3 = rectangle.borderWidthRight;
        if (f3 != -1.0f) {
            this.borderWidthRight = f3;
        }
        float f4 = rectangle.borderWidthTop;
        if (f4 != -1.0f) {
            this.borderWidthTop = f4;
        }
        float f5 = rectangle.borderWidthBottom;
        if (f5 != -1.0f) {
            this.borderWidthBottom = f5;
        }
        Color color2 = rectangle.borderColor;
        if (color2 != null) {
            this.borderColor = color2;
        }
        Color color3 = rectangle.borderColorLeft;
        if (color3 != null) {
            this.borderColorLeft = color3;
        }
        Color color4 = rectangle.borderColorRight;
        if (color4 != null) {
            this.borderColorRight = color4;
        }
        Color color5 = rectangle.borderColorTop;
        if (color5 != null) {
            this.borderColorTop = color5;
        }
        Color color6 = rectangle.borderColorBottom;
        if (color6 != null) {
            this.borderColorBottom = color6;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Rectangle: ");
        stringBuffer.append(getWidth());
        stringBuffer.append('x');
        stringBuffer.append(getHeight());
        stringBuffer.append(" (rot: ");
        stringBuffer.append(this.rotation);
        stringBuffer.append(" degrees)");
        return stringBuffer.toString();
    }
}
