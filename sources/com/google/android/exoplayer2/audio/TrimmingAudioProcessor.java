package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class TrimmingAudioProcessor extends BaseAudioProcessor {
    private static final int OUTPUT_ENCODING = 2;
    private int bytesPerFrame;
    private byte[] endBuffer = Util.EMPTY_BYTE_ARRAY;
    private int endBufferSize;
    private boolean isActive;
    private int pendingTrimStartBytes;
    private boolean receivedInputSinceConfigure;
    private int trimEndFrames;
    private int trimStartFrames;
    private long trimmedFrameCount;

    public void setTrimFrameCount(int i, int i2) {
        this.trimStartFrames = i;
        this.trimEndFrames = i2;
    }

    public void resetTrimmedFrameCount() {
        this.trimmedFrameCount = 0;
    }

    public long getTrimmedFrameCount() {
        return this.trimmedFrameCount;
    }

    public boolean configure(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 == 2) {
            int i4 = this.endBufferSize;
            if (i4 > 0) {
                this.trimmedFrameCount += (long) (i4 / this.bytesPerFrame);
            }
            this.bytesPerFrame = Util.getPcmFrameSize(2, i2);
            int i5 = this.trimEndFrames;
            int i6 = this.bytesPerFrame;
            this.endBuffer = new byte[(i5 * i6)];
            this.endBufferSize = 0;
            int i7 = this.trimStartFrames;
            this.pendingTrimStartBytes = i6 * i7;
            boolean z = this.isActive;
            this.isActive = (i7 == 0 && i5 == 0) ? false : true;
            this.receivedInputSinceConfigure = false;
            setInputFormat(i, i2, i3);
            if (z != this.isActive) {
                return true;
            }
            return false;
        }
        throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i != 0) {
            this.receivedInputSinceConfigure = true;
            int min = Math.min(i, this.pendingTrimStartBytes);
            this.trimmedFrameCount += (long) (min / this.bytesPerFrame);
            this.pendingTrimStartBytes -= min;
            byteBuffer.position(position + min);
            if (this.pendingTrimStartBytes <= 0) {
                int i2 = i - min;
                int length = (this.endBufferSize + i2) - this.endBuffer.length;
                ByteBuffer replaceOutputBuffer = replaceOutputBuffer(length);
                int constrainValue = Util.constrainValue(length, 0, this.endBufferSize);
                replaceOutputBuffer.put(this.endBuffer, 0, constrainValue);
                int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i2);
                byteBuffer.limit(byteBuffer.position() + constrainValue2);
                replaceOutputBuffer.put(byteBuffer);
                byteBuffer.limit(limit);
                int i3 = i2 - constrainValue2;
                this.endBufferSize -= constrainValue;
                byte[] bArr = this.endBuffer;
                System.arraycopy(bArr, constrainValue, bArr, 0, this.endBufferSize);
                byteBuffer.get(this.endBuffer, this.endBufferSize, i3);
                this.endBufferSize += i3;
                replaceOutputBuffer.flip();
            }
        }
    }

    public ByteBuffer getOutput() {
        int i;
        if (super.isEnded() && (i = this.endBufferSize) > 0) {
            replaceOutputBuffer(i).put(this.endBuffer, 0, this.endBufferSize).flip();
            this.endBufferSize = 0;
        }
        return super.getOutput();
    }

    public boolean isEnded() {
        return super.isEnded() && this.endBufferSize == 0;
    }

    /* access modifiers changed from: protected */
    public void onFlush() {
        if (this.receivedInputSinceConfigure) {
            this.pendingTrimStartBytes = 0;
        }
        this.endBufferSize = 0;
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.endBuffer = Util.EMPTY_BYTE_ARRAY;
    }
}
