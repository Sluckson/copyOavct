package com.lowagie.text;

import harmony.java.awt.Color;

public class RectangleReadOnly extends Rectangle {
    public RectangleReadOnly(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }

    public RectangleReadOnly(float f, float f2) {
        super(0.0f, 0.0f, f, f2);
    }

    public RectangleReadOnly(Rectangle rectangle) {
        super(rectangle.llx, rectangle.lly, rectangle.urx, rectangle.ury);
        super.cloneNonPositionParameters(rectangle);
    }

    private void throwReadOnlyError() {
        throw new UnsupportedOperationException("RectangleReadOnly: this Rectangle is read only.");
    }

    public void setLeft(float f) {
        throwReadOnlyError();
    }

    public void setRight(float f) {
        throwReadOnlyError();
    }

    public void setTop(float f) {
        throwReadOnlyError();
    }

    public void setBottom(float f) {
        throwReadOnlyError();
    }

    public void normalize() {
        throwReadOnlyError();
    }

    public void setBackgroundColor(Color color) {
        throwReadOnlyError();
    }

    public void setGrayFill(float f) {
        throwReadOnlyError();
    }

    public void setBorder(int i) {
        throwReadOnlyError();
    }

    public void setUseVariableBorders(boolean z) {
        throwReadOnlyError();
    }

    public void enableBorderSide(int i) {
        throwReadOnlyError();
    }

    public void disableBorderSide(int i) {
        throwReadOnlyError();
    }

    public void setBorderWidth(float f) {
        throwReadOnlyError();
    }

    public void setBorderWidthLeft(float f) {
        throwReadOnlyError();
    }

    public void setBorderWidthRight(float f) {
        throwReadOnlyError();
    }

    public void setBorderWidthTop(float f) {
        throwReadOnlyError();
    }

    public void setBorderWidthBottom(float f) {
        throwReadOnlyError();
    }

    public void setBorderColor(Color color) {
        throwReadOnlyError();
    }

    public void setBorderColorLeft(Color color) {
        throwReadOnlyError();
    }

    public void setBorderColorRight(Color color) {
        throwReadOnlyError();
    }

    public void setBorderColorTop(Color color) {
        throwReadOnlyError();
    }

    public void setBorderColorBottom(Color color) {
        throwReadOnlyError();
    }

    public void cloneNonPositionParameters(Rectangle rectangle) {
        throwReadOnlyError();
    }

    public void softCloneNonPositionParameters(Rectangle rectangle) {
        throwReadOnlyError();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RectangleReadOnly: ");
        stringBuffer.append(getWidth());
        stringBuffer.append('x');
        stringBuffer.append(getHeight());
        stringBuffer.append(" (rot: ");
        stringBuffer.append(this.rotation);
        stringBuffer.append(" degrees)");
        return stringBuffer.toString();
    }
}
