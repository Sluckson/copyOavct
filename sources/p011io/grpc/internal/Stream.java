package p011io.grpc.internal;

import java.io.InputStream;
import p011io.grpc.Compressor;

/* renamed from: io.grpc.internal.Stream */
public interface Stream {
    void flush();

    boolean isReady();

    void request(int i);

    void setCompressor(Compressor compressor);

    void setMessageCompression(boolean z);

    void writeMessage(InputStream inputStream);
}
