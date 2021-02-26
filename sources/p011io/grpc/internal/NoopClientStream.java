package p011io.grpc.internal;

import java.io.InputStream;
import javax.annotation.Nonnull;
import p011io.grpc.Attributes;
import p011io.grpc.Compressor;
import p011io.grpc.Deadline;
import p011io.grpc.DecompressorRegistry;
import p011io.grpc.Status;

/* renamed from: io.grpc.internal.NoopClientStream */
public class NoopClientStream implements ClientStream {
    public static final NoopClientStream INSTANCE = new NoopClientStream();

    public void cancel(Status status) {
    }

    public void flush() {
    }

    public void halfClose() {
    }

    public boolean isReady() {
        return false;
    }

    public void request(int i) {
    }

    public void setAuthority(String str) {
    }

    public void setCompressor(Compressor compressor) {
    }

    public void setDeadline(@Nonnull Deadline deadline) {
    }

    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
    }

    public void setFullStreamDecompression(boolean z) {
    }

    public void setMaxInboundMessageSize(int i) {
    }

    public void setMaxOutboundMessageSize(int i) {
    }

    public void setMessageCompression(boolean z) {
    }

    public void start(ClientStreamListener clientStreamListener) {
    }

    public void writeMessage(InputStream inputStream) {
    }

    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }
}
