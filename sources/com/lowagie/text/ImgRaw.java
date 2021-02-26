package com.lowagie.text;

import java.net.URL;

public class ImgRaw extends Image {
    ImgRaw(Image image) {
        super(image);
    }

    public ImgRaw(int i, int i2, int i3, int i4, byte[] bArr) throws BadElementException {
        super((URL) null);
        this.type = 34;
        this.scaledHeight = (float) i2;
        setTop(this.scaledHeight);
        this.scaledWidth = (float) i;
        setRight(this.scaledWidth);
        if (i3 != 1 && i3 != 3 && i3 != 4) {
            throw new BadElementException("Components must be 1, 3, or 4.");
        } else if (i4 == 1 || i4 == 2 || i4 == 4 || i4 == 8) {
            this.colorspace = i3;
            this.bpc = i4;
            this.rawData = bArr;
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
        } else {
            throw new BadElementException("Bits-per-component must be 1, 2, 4, or 8.");
        }
    }
}
