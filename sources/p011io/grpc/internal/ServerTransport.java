package p011io.grpc.internal;

import java.util.concurrent.ScheduledExecutorService;
import p011io.grpc.InternalChannelz;
import p011io.grpc.InternalInstrumented;
import p011io.grpc.Status;

/* renamed from: io.grpc.internal.ServerTransport */
public interface ServerTransport extends InternalInstrumented<InternalChannelz.SocketStats> {
    ScheduledExecutorService getScheduledExecutorService();

    void shutdown();

    void shutdownNow(Status status);
}
