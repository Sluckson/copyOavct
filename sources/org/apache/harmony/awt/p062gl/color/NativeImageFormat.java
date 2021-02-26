package org.apache.harmony.awt.p062gl.color;

import org.apache.harmony.awt.internal.nls.Messages;

/* renamed from: org.apache.harmony.awt.gl.color.NativeImageFormat */
class NativeImageFormat {
    private static final int BYTE_GRAY_LCMS_FMT = ((colorspaceSh(3) | channelsSh(1)) | bytesSh(1));
    private static final int FOUR_BYTE_ABGR_LCMS_FMT = ((((colorspaceSh(4) | extraSh(1)) | channelsSh(3)) | bytesSh(1)) | doswapSh(1));
    private static final int INT_ARGB_LCMS_FMT = INT_RGB_LCMS_FMT;
    private static final int INT_BGR_LCMS_FMT = (((colorspaceSh(4) | extraSh(1)) | channelsSh(3)) | bytesSh(1));
    private static final int INT_RGB_LCMS_FMT = (((((colorspaceSh(4) | extraSh(1)) | channelsSh(3)) | bytesSh(1)) | doswapSh(1)) | swapfirstSh(1));
    private static final int PT_ANY = 0;
    private static final int PT_GRAY = 3;
    private static final int PT_RGB = 4;
    private static final int THREE_BYTE_BGR_LCMS_FMT = (((colorspaceSh(4) | channelsSh(3)) | bytesSh(1)) | doswapSh(1));
    private static final int USHORT_GRAY_LCMS_FMT = ((colorspaceSh(3) | channelsSh(1)) | bytesSh(2));
    private int alphaOffset = -1;
    private int cmmFormat = 0;
    private int cols = 0;
    private int dataOffset;
    private Object imageData;
    private int rows = 0;
    private int scanlineStride = -1;

    private static int bytesSh(int i) {
        return i;
    }

    private static int channelsSh(int i) {
        return i << 3;
    }

    private static int colorspaceSh(int i) {
        return i << 16;
    }

    private static int doswapSh(int i) {
        return i << 10;
    }

    private static int endianSh(int i) {
        return i << 11;
    }

    private static int extraSh(int i) {
        return i << 7;
    }

    private static int flavorSh(int i) {
        return i << 13;
    }

    private static native void initIDs();

    private static int planarSh(int i) {
        return i << 12;
    }

    private static int swapfirstSh(int i) {
        return i << 14;
    }

    static {
        initIDs();
    }

    /* access modifiers changed from: package-private */
    public Object getChannelData() {
        return this.imageData;
    }

    /* access modifiers changed from: package-private */
    public int getNumCols() {
        return this.cols;
    }

    /* access modifiers changed from: package-private */
    public int getNumRows() {
        return this.rows;
    }

    public NativeImageFormat() {
    }

    public NativeImageFormat(Object obj, int i, int i2, int i3) {
        if (obj instanceof short[]) {
            this.cmmFormat |= bytesSh(2);
        } else if (obj instanceof byte[]) {
            this.cmmFormat |= bytesSh(1);
        } else {
            throw new IllegalArgumentException(Messages.getString("awt.47"));
        }
        this.cmmFormat = channelsSh(i) | this.cmmFormat;
        this.rows = i2;
        this.cols = i3;
        this.imageData = obj;
        this.dataOffset = 0;
    }
}
