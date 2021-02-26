package p011io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import p011io.grpc.Metadata;
import p011io.grpc.Status;
import p011io.grpc.internal.ClientStreamListener;

/* renamed from: io.grpc.internal.FailingClientStream */
public final class FailingClientStream extends NoopClientStream {
    private final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;
    private boolean started;

    public FailingClientStream(Status status) {
        this(status, ClientStreamListener.RpcProgress.PROCESSED);
    }

    public FailingClientStream(Status status, ClientStreamListener.RpcProgress rpcProgress2) {
        Preconditions.checkArgument(!status.isOk(), "error must not be OK");
        this.error = status;
        this.rpcProgress = rpcProgress2;
    }

    public void start(ClientStreamListener clientStreamListener) {
        Preconditions.checkState(!this.started, "already started");
        this.started = true;
        clientStreamListener.closed(this.error, this.rpcProgress, new Metadata());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Status getError() {
        return this.error;
    }
}
