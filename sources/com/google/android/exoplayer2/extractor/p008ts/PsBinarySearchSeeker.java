package com.google.android.exoplayer2.extractor.p008ts;

import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker */
final class PsBinarySearchSeeker extends BinarySearchSeeker {
    private static final int MINIMUM_SEARCH_RANGE_BYTES = 1000;
    private static final long SEEK_TOLERANCE_US = 100000;
    private static final int TIMESTAMP_SEARCH_BYTES = 20000;

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j, long j2) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new PsScrSeeker(timestampAdjuster), j, 0, j + 1, 0, j2, 188, 1000);
    }

    /* renamed from: com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker$PsScrSeeker */
    private static final class PsScrSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final ParsableByteArray packetBuffer;
        private final TimestampAdjuster scrTimestampAdjuster;

        private PsScrSeeker(TimestampAdjuster timestampAdjuster) {
            this.scrTimestampAdjuster = timestampAdjuster;
            this.packetBuffer = new ParsableByteArray();
        }

        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j, BinarySearchSeeker.OutputFrameHolder outputFrameHolder) throws IOException, InterruptedException {
            long position = extractorInput.getPosition();
            int min = (int) Math.min(20000, extractorInput.getLength() - position);
            this.packetBuffer.reset(min);
            extractorInput.peekFully(this.packetBuffer.data, 0, min);
            return searchForScrValueInBuffer(this.packetBuffer, j, position);
        }

        public void onSeekFinished() {
            this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        }

        private BinarySearchSeeker.TimestampSearchResult searchForScrValueInBuffer(ParsableByteArray parsableByteArray, long j, long j2) {
            int i = -1;
            long j3 = -9223372036854775807L;
            int i2 = -1;
            while (parsableByteArray.bytesLeft() >= 4) {
                if (PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition()) != 442) {
                    parsableByteArray.skipBytes(1);
                } else {
                    parsableByteArray.skipBytes(4);
                    long readScrValueFromPack = PsDurationReader.readScrValueFromPack(parsableByteArray);
                    if (readScrValueFromPack != C1119C.TIME_UNSET) {
                        long adjustTsTimestamp = this.scrTimestampAdjuster.adjustTsTimestamp(readScrValueFromPack);
                        if (adjustTsTimestamp > j) {
                            if (j3 == C1119C.TIME_UNSET) {
                                return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, j2);
                            }
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + ((long) i2));
                        } else if (PsBinarySearchSeeker.SEEK_TOLERANCE_US + adjustTsTimestamp > j) {
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + ((long) parsableByteArray.getPosition()));
                        } else {
                            i2 = parsableByteArray.getPosition();
                            j3 = adjustTsTimestamp;
                        }
                    }
                    skipToEndOfCurrentPack(parsableByteArray);
                    i = parsableByteArray.getPosition();
                }
            }
            if (j3 != C1119C.TIME_UNSET) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j3, j2 + ((long) i));
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        private static void skipToEndOfCurrentPack(ParsableByteArray parsableByteArray) {
            int limit = parsableByteArray.limit();
            if (parsableByteArray.bytesLeft() < 10) {
                parsableByteArray.setPosition(limit);
                return;
            }
            parsableByteArray.skipBytes(9);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 7;
            if (parsableByteArray.bytesLeft() < readUnsignedByte) {
                parsableByteArray.setPosition(limit);
                return;
            }
            parsableByteArray.skipBytes(readUnsignedByte);
            if (parsableByteArray.bytesLeft() < 4) {
                parsableByteArray.setPosition(limit);
                return;
            }
            if (PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition()) == 443) {
                parsableByteArray.skipBytes(4);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                if (parsableByteArray.bytesLeft() < readUnsignedShort) {
                    parsableByteArray.setPosition(limit);
                    return;
                }
                parsableByteArray.skipBytes(readUnsignedShort);
            }
            while (parsableByteArray.bytesLeft() >= 4 && (r1 = PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition())) != 442 && r1 != 441 && (r1 >>> 8) == 1) {
                parsableByteArray.skipBytes(4);
                if (parsableByteArray.bytesLeft() < 2) {
                    parsableByteArray.setPosition(limit);
                    return;
                } else {
                    parsableByteArray.setPosition(Math.min(parsableByteArray.limit(), parsableByteArray.getPosition() + parsableByteArray.readUnsignedShort()));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static int peekIntAtPosition(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
