package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.MimeTypes;

public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT = new MetadataDecoderFactory() {
        public boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || MimeTypes.APPLICATION_ICY.equals(str);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.metadata.MetadataDecoder createDecoder(com.google.android.exoplayer2.Format r5) {
            /*
                r4 = this;
                java.lang.String r5 = r5.sampleMimeType
                int r0 = r5.hashCode()
                r1 = 3
                r2 = 2
                r3 = 1
                switch(r0) {
                    case -1348231605: goto L_0x002b;
                    case -1248341703: goto L_0x0021;
                    case 1154383568: goto L_0x0017;
                    case 1652648887: goto L_0x000d;
                    default: goto L_0x000c;
                }
            L_0x000c:
                goto L_0x0035
            L_0x000d:
                java.lang.String r0 = "application/x-scte35"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0035
                r5 = 2
                goto L_0x0036
            L_0x0017:
                java.lang.String r0 = "application/x-emsg"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0035
                r5 = 1
                goto L_0x0036
            L_0x0021:
                java.lang.String r0 = "application/id3"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0035
                r5 = 0
                goto L_0x0036
            L_0x002b:
                java.lang.String r0 = "application/x-icy"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0035
                r5 = 3
                goto L_0x0036
            L_0x0035:
                r5 = -1
            L_0x0036:
                if (r5 == 0) goto L_0x0058
                if (r5 == r3) goto L_0x0052
                if (r5 == r2) goto L_0x004c
                if (r5 != r1) goto L_0x0044
                com.google.android.exoplayer2.metadata.icy.IcyDecoder r5 = new com.google.android.exoplayer2.metadata.icy.IcyDecoder
                r5.<init>()
                return r5
            L_0x0044:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Attempted to create decoder for unsupported format"
                r5.<init>(r0)
                throw r5
            L_0x004c:
                com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder r5 = new com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder
                r5.<init>()
                return r5
            L_0x0052:
                com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder r5 = new com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder
                r5.<init>()
                return r5
            L_0x0058:
                com.google.android.exoplayer2.metadata.id3.Id3Decoder r5 = new com.google.android.exoplayer2.metadata.id3.Id3Decoder
                r5.<init>()
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.MetadataDecoderFactory.C11641.createDecoder(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.metadata.MetadataDecoder");
        }
    };

    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
