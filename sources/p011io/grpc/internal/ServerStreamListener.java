package p011io.grpc.internal;

import p011io.grpc.Status;

/* renamed from: io.grpc.internal.ServerStreamListener */
public interface ServerStreamListener extends StreamListener {
    void closed(Status status);

    void halfClosed();
}
