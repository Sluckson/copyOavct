package com.google.android.exoplayer2.extractor.p008ts;

import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.extractor.ts.TsDurationReader */
final class TsDurationReader {
    private static final int TIMESTAMP_SEARCH_BYTES = 112800;
    private long durationUs = C1119C.TIME_UNSET;
    private long firstPcrValue = C1119C.TIME_UNSET;
    private boolean isDurationRead;
    private boolean isFirstPcrValueRead;
    private boolean isLastPcrValueRead;
    private long lastPcrValue = C1119C.TIME_UNSET;
    private final ParsableByteArray packetBuffer = new ParsableByteArray();
    private final TimestampAdjuster pcrTimestampAdjuster = new TimestampAdjuster(0);

    TsDurationReader() {
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(ExtractorInput extractorInput, PositionHolder positionHolder, int i) throws IOException, InterruptedException {
        if (i <= 0) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isLastPcrValueRead) {
            return readLastPcrValue(extractorInput, positionHolder, i);
        }
        if (this.lastPcrValue == C1119C.TIME_UNSET) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isFirstPcrValueRead) {
            return readFirstPcrValue(extractorInput, positionHolder, i);
        }
        long j = this.firstPcrValue;
        if (j == C1119C.TIME_UNSET) {
            return finishReadDuration(extractorInput);
        }
        this.durationUs = this.pcrTimestampAdjuster.adjustTsTimestamp(this.lastPcrValue) - this.pcrTimestampAdjuster.adjustTsTimestamp(j);
        return finishReadDuration(extractorInput);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TimestampAdjuster getPcrTimestampAdjuster() {
        return this.pcrTimestampAdjuster;
    }

    private int finishReadDuration(ExtractorInput extractorInput) {
        this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        this.isDurationRead = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    private int readFirstPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int i) throws IOException, InterruptedException {
        int min = (int) Math.min(112800, extractorInput.getLength());
        long j = (long) 0;
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.packetBuffer.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, min);
        this.firstPcrValue = readFirstPcrValueFromBuffer(this.packetBuffer, i);
        this.isFirstPcrValueRead = true;
        return 0;
    }

    private long readFirstPcrValueFromBuffer(ParsableByteArray parsableByteArray, int i) {
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            if (parsableByteArray.data[position] == 71) {
                long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, position, i);
                if (readPcrFromPacket != C1119C.TIME_UNSET) {
                    return readPcrFromPacket;
                }
            }
        }
        return C1119C.TIME_UNSET;
    }

    private int readLastPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int i) throws IOException, InterruptedException {
        long length = extractorInput.getLength();
        int min = (int) Math.min(112800, length);
        long j = length - ((long) min);
        if (extractorInput.getPosition() != j) {
            positionHolder.position = j;
            return 1;
        }
        this.packetBuffer.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, min);
        this.lastPcrValue = readLastPcrValueFromBuffer(this.packetBuffer, i);
        this.isLastPcrValueRead = true;
        return 0;
    }

    private long readLastPcrValueFromBuffer(ParsableByteArray parsableByteArray, int i) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (true) {
            limit--;
            if (limit < position) {
                return C1119C.TIME_UNSET;
            }
            if (parsableByteArray.data[limit] == 71) {
                long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, limit, i);
                if (readPcrFromPacket != C1119C.TIME_UNSET) {
                    return readPcrFromPacket;
                }
            }
        }
    }
}
