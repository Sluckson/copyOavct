package com.lowagie.text.pdf.codec;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.ImgJBIG2;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.codec.JBIG2SegmentReader;

public class JBIG2Image {
    public static byte[] getGlobalSegment(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
            jBIG2SegmentReader.read();
            return jBIG2SegmentReader.getGlobal(true);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Image getJbig2Image(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        if (i >= 1) {
            try {
                JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
                jBIG2SegmentReader.read();
                JBIG2SegmentReader.JBIG2Page page = jBIG2SegmentReader.getPage(i);
                return new ImgJBIG2(page.pageBitmapWidth, page.pageBitmapHeight, page.getData(true), jBIG2SegmentReader.getGlobal(true));
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new IllegalArgumentException("The page number must be >= 1.");
        }
    }

    public static int getNumberOfPages(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
            jBIG2SegmentReader.read();
            return jBIG2SegmentReader.numberOfPages();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
