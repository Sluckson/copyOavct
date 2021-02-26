package p011io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import p011io.grpc.InternalChannelz;
import p011io.grpc.InternalInstrumented;
import p011io.grpc.LoadBalancer;

/* renamed from: io.grpc.internal.AbstractSubchannel */
abstract class AbstractSubchannel extends LoadBalancer.Subchannel {
    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract InternalInstrumented<InternalChannelz.ChannelStats> getInternalSubchannel();

    /* access modifiers changed from: package-private */
    @Nullable
    public abstract ClientTransport obtainActiveTransport();

    AbstractSubchannel() {
    }
}
