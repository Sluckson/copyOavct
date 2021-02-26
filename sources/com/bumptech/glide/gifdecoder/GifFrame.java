package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class GifFrame {
    static final int DISPOSAL_BACKGROUND = 2;
    static final int DISPOSAL_NONE = 1;
    static final int DISPOSAL_PREVIOUS = 3;
    static final int DISPOSAL_UNSPECIFIED = 0;
    int bufferFrameStart;
    int delay;
    int dispose;

    /* renamed from: ih */
    int f101ih;
    boolean interlace;

    /* renamed from: iw */
    int f102iw;

    /* renamed from: ix */
    int f103ix;

    /* renamed from: iy */
    int f104iy;
    @ColorInt
    int[] lct;
    int transIndex;
    boolean transparency;

    @Retention(RetentionPolicy.SOURCE)
    private @interface GifDisposalMethod {
    }

    GifFrame() {
    }
}
