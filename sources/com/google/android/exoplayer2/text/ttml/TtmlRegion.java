package com.google.android.exoplayer2.text.ttml;

final class TtmlRegion {
    public final float height;

    /* renamed from: id */
    public final String f149id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final float width;

    public TtmlRegion(String str) {
        this(str, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public TtmlRegion(String str, float f, float f2, int i, int i2, float f3, float f4, int i3, float f5) {
        this.f149id = str;
        this.position = f;
        this.line = f2;
        this.lineType = i;
        this.lineAnchor = i2;
        this.width = f3;
        this.height = f4;
        this.textSizeType = i3;
        this.textSize = f5;
    }
}