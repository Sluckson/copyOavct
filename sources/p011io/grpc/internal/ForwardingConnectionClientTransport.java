package p011io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import p011io.grpc.Attributes;
import p011io.grpc.CallOptions;
import p011io.grpc.InternalChannelz;
import p011io.grpc.InternalLogId;
import p011io.grpc.Metadata;
import p011io.grpc.MethodDescriptor;
import p011io.grpc.Status;
import p011io.grpc.internal.ClientTransport;
import p011io.grpc.internal.ManagedClientTransport;

/* renamed from: io.grpc.internal.ForwardingConnectionClientTransport */
abstract class ForwardingConnectionClientTransport implements ConnectionClientTransport {
    /* access modifiers changed from: protected */
    public abstract ConnectionClientTransport delegate();

    ForwardingConnectionClientTransport() {
    }

    public Runnable start(ManagedClientTransport.Listener listener) {
        return delegate().start(listener);
    }

    public void shutdown(Status status) {
        delegate().shutdown(status);
    }

    public void shutdownNow(Status status) {
        delegate().shutdownNow(status);
    }

    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        return delegate().newStream(methodDescriptor, metadata, callOptions);
    }

    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        delegate().ping(pingCallback, executor);
    }

    public InternalLogId getLogId() {
        return delegate().getLogId();
    }

    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) delegate()).toString();
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        return delegate().getStats();
    }
}
