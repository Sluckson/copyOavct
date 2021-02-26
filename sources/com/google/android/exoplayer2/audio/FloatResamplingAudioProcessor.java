package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

final class FloatResamplingAudioProcessor extends BaseAudioProcessor {
    private static final int FLOAT_NAN_AS_INT = Float.floatToIntBits(Float.NaN);
    private static final double PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR = 4.656612875245797E-10d;

    public int getOutputEncoding() {
        return 4;
    }

    FloatResamplingAudioProcessor() {
    }

    public boolean configure(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (Util.isEncodingHighResolutionIntegerPcm(i3)) {
            return setInputFormat(i, i2, i3);
        }
        throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
    }

    public boolean isActive() {
        return Util.isEncodingHighResolutionIntegerPcm(this.encoding);
    }

    public void queueInput(ByteBuffer byteBuffer) {
        boolean z = this.encoding == 1073741824;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (!z) {
            i = (i / 3) * 4;
        }
        ByteBuffer replaceOutputBuffer = replaceOutputBuffer(i);
        if (z) {
            while (position < limit) {
                writePcm32BitFloat((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << Ascii.CAN), replaceOutputBuffer);
                position += 4;
            }
        } else {
            while (position < limit) {
                writePcm32BitFloat(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << Ascii.CAN), replaceOutputBuffer);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        replaceOutputBuffer.flip();
    }

    private static void writePcm32BitFloat(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i) * PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR));
        if (floatToIntBits == FLOAT_NAN_AS_INT) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }
}
