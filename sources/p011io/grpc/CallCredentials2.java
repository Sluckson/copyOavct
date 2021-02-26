package p011io.grpc;

import java.util.concurrent.Executor;
import p011io.grpc.CallCredentials;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4901")
@Deprecated
/* renamed from: io.grpc.CallCredentials2 */
public abstract class CallCredentials2 extends CallCredentials {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    /* renamed from: io.grpc.CallCredentials2$MetadataApplier */
    public static abstract class MetadataApplier extends CallCredentials.MetadataApplier {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    public abstract void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier);

    public final void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, final CallCredentials.MetadataApplier metadataApplier) {
        applyRequestMetadata(requestInfo, executor, (MetadataApplier) new MetadataApplier() {
            public void apply(Metadata metadata) {
                metadataApplier.apply(metadata);
            }

            public void fail(Status status) {
                metadataApplier.fail(status);
            }
        });
    }
}