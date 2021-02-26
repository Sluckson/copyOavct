package p011io.grpc.internal;

import java.io.IOException;
import java.net.SocketAddress;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import p011io.grpc.InternalChannelz;
import p011io.grpc.InternalInstrumented;

@ThreadSafe
/* renamed from: io.grpc.internal.InternalServer */
public interface InternalServer {
    SocketAddress getListenSocketAddress();

    @Nullable
    InternalInstrumented<InternalChannelz.SocketStats> getListenSocketStats();

    void shutdown();

    void start(ServerListener serverListener) throws IOException;
}
