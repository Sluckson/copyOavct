package p011io.grpc.internal;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.ThreadSafe;
import p011io.grpc.CallOptions;
import p011io.grpc.InternalChannelz;
import p011io.grpc.InternalInstrumented;
import p011io.grpc.Metadata;
import p011io.grpc.MethodDescriptor;

@ThreadSafe
/* renamed from: io.grpc.internal.ClientTransport */
public interface ClientTransport extends InternalInstrumented<InternalChannelz.SocketStats> {

    /* renamed from: io.grpc.internal.ClientTransport$PingCallback */
    public interface PingCallback {
        void onFailure(Throwable th);

        void onSuccess(long j);
    }

    ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions);

    void ping(PingCallback pingCallback, Executor executor);
}
