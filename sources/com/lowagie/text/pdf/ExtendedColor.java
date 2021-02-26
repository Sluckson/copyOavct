package com.lowagie.text.pdf;

import harmony.java.awt.Color;

public abstract class ExtendedColor extends Color {
    public static final int TYPE_CMYK = 2;
    public static final int TYPE_GRAY = 1;
    public static final int TYPE_PATTERN = 4;
    public static final int TYPE_RGB = 0;
    public static final int TYPE_SEPARATION = 3;
    public static final int TYPE_SHADING = 5;
    private static final long serialVersionUID = 2722660170712380080L;
    protected int type;

    static final float normalize(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public ExtendedColor(int i) {
        super(0, 0, 0);
        this.type = i;
    }

    public ExtendedColor(int i, float f, float f2, float f3) {
        super(normalize(f), normalize(f2), normalize(f3));
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public static int getType(Color color) {
        if (color instanceof ExtendedColor) {
            return ((ExtendedColor) color).getType();
        }
        return 0;
    }
}
