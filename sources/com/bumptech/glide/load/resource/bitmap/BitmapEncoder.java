package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    private static final String TAG = "BitmapEncoder";

    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|(2:34|35)|36|37) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00ca */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[SYNTHETIC, Splitter:B:23:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7 A[SYNTHETIC, Splitter:B:34:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r9, java.io.File r10, com.bumptech.glide.load.Options r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.getFormat(r9, r11)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "encode: ["
            r2.append(r3)
            int r3 = r9.getWidth()
            r2.append(r3)
            java.lang.String r3 = "x"
            r2.append(r3)
            int r3 = r9.getHeight()
            r2.append(r3)
            java.lang.String r3 = "] "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            androidx.core.p003os.TraceCompat.beginSection(r2)
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = COMPRESSION_QUALITY     // Catch:{ all -> 0x00cb }
            java.lang.Object r4 = r11.get(r4)     // Catch:{ all -> 0x00cb }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00cb }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00cb }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0062 }
            r7.<init>(r10)     // Catch:{ IOException -> 0x0062 }
            r9.compress(r1, r4, r7)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r7.close()     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r5 = 1
            r7.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0074
        L_0x005a:
            r9 = move-exception
            r6 = r7
            goto L_0x00c5
        L_0x005d:
            r10 = move-exception
            r6 = r7
            goto L_0x0063
        L_0x0060:
            r9 = move-exception
            goto L_0x00c5
        L_0x0062:
            r10 = move-exception
        L_0x0063:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x006f
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch:{ all -> 0x0060 }
        L_0x006f:
            if (r6 == 0) goto L_0x0074
            r6.close()     // Catch:{ IOException -> 0x0074 }
        L_0x0074:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x00cb }
            if (r10 == 0) goto L_0x00c1
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r10.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = "Compressed with type: "
            r10.append(r4)     // Catch:{ all -> 0x00cb }
            r10.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = " of size "
            r10.append(r1)     // Catch:{ all -> 0x00cb }
            int r1 = com.bumptech.glide.util.Util.getBitmapByteSize(r9)     // Catch:{ all -> 0x00cb }
            r10.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = " in "
            r10.append(r1)     // Catch:{ all -> 0x00cb }
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x00cb }
            r10.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = ", options format: "
            r10.append(r1)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = COMPRESSION_FORMAT     // Catch:{ all -> 0x00cb }
            java.lang.Object r11 = r11.get(r1)     // Catch:{ all -> 0x00cb }
            r10.append(r11)     // Catch:{ all -> 0x00cb }
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch:{ all -> 0x00cb }
            boolean r9 = r9.hasAlpha()     // Catch:{ all -> 0x00cb }
            r10.append(r9)     // Catch:{ all -> 0x00cb }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x00cb }
            android.util.Log.v(r0, r9)     // Catch:{ all -> 0x00cb }
        L_0x00c1:
            androidx.core.p003os.TraceCompat.endSection()
            return r5
        L_0x00c5:
            if (r6 == 0) goto L_0x00ca
            r6.close()     // Catch:{ IOException -> 0x00ca }
        L_0x00ca:
            throw r9     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r9 = move-exception
            androidx.core.p003os.TraceCompat.endSection()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
