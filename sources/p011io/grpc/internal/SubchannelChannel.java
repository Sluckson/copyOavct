package p011io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import p011io.grpc.CallOptions;
import p011io.grpc.Channel;
import p011io.grpc.ClientCall;
import p011io.grpc.Context;
import p011io.grpc.LoadBalancer;
import p011io.grpc.Metadata;
import p011io.grpc.MethodDescriptor;
import p011io.grpc.Status;
import p011io.grpc.internal.ClientCallImpl;
import p011io.grpc.internal.ClientStreamListener;

/* renamed from: io.grpc.internal.SubchannelChannel */
final class SubchannelChannel extends Channel {
    @VisibleForTesting
    static final Status NOT_READY_ERROR = Status.UNAVAILABLE.withDescription("Subchannel is NOT READY");
    @VisibleForTesting
    static final Status WAIT_FOR_READY_ERROR = Status.UNAVAILABLE.withDescription("wait-for-ready RPC is not supported on Subchannel.asChannel()");
    /* access modifiers changed from: private */
    public static final FailingClientTransport notReadyTransport = new FailingClientTransport(NOT_READY_ERROR, ClientStreamListener.RpcProgress.REFUSED);
    private final CallTracer callsTracer;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final Executor executor;
    /* access modifiers changed from: private */
    public final InternalSubchannel subchannel;
    private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider() {
        public ClientTransport get(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            ClientTransport transport = SubchannelChannel.this.subchannel.getTransport();
            return transport == null ? SubchannelChannel.notReadyTransport : transport;
        }

        public <ReqT> ClientStream newRetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context) {
            throw new UnsupportedOperationException("OobChannel should not create retriable streams");
        }
    };

    SubchannelChannel(InternalSubchannel internalSubchannel, Executor executor2, ScheduledExecutorService scheduledExecutorService, CallTracer callTracer) {
        this.subchannel = (InternalSubchannel) Preconditions.checkNotNull(internalSubchannel, "subchannel");
        this.executor = (Executor) Preconditions.checkNotNull(executor2, "executor");
        this.deadlineCancellationExecutor = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "deadlineCancellationExecutor");
        this.callsTracer = (CallTracer) Preconditions.checkNotNull(callTracer, "callsTracer");
    }

    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        final Executor executor2 = callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor();
        if (callOptions.isWaitForReady()) {
            return new ClientCall<RequestT, ResponseT>() {
                public void cancel(String str, Throwable th) {
                }

                public void halfClose() {
                }

                public void request(int i) {
                }

                public void sendMessage(RequestT requestt) {
                }

                public void start(final ClientCall.Listener<ResponseT> listener, Metadata metadata) {
                    executor2.execute(new Runnable() {
                        public void run() {
                            listener.onClose(SubchannelChannel.WAIT_FOR_READY_ERROR, new Metadata());
                        }
                    });
                }
            };
        }
        return new ClientCallImpl(methodDescriptor, executor2, callOptions.withOption(GrpcUtil.CALL_OPTIONS_RPC_OWNED_BY_BALANCER, Boolean.TRUE), this.transportProvider, this.deadlineCancellationExecutor, this.callsTracer, false);
    }

    public String authority() {
        return this.subchannel.getAuthority();
    }
}
