package p011io.grpc;

import p011io.grpc.Metadata;

@Internal
/* renamed from: io.grpc.InternalStatus */
public final class InternalStatus {
    @Internal
    public static final Metadata.Key<Status> CODE_KEY = Status.CODE_KEY;
    @Internal
    public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;

    private InternalStatus() {
    }
}
