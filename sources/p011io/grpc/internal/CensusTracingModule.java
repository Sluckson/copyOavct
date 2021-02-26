package p011io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import p011io.grpc.CallOptions;
import p011io.grpc.Channel;
import p011io.grpc.ClientCall;
import p011io.grpc.ClientInterceptor;
import p011io.grpc.ClientStreamTracer;
import p011io.grpc.Context;
import p011io.grpc.ForwardingClientCall;
import p011io.grpc.ForwardingClientCallListener;
import p011io.grpc.Metadata;
import p011io.grpc.MethodDescriptor;
import p011io.grpc.ServerStreamTracer;
import p011io.opencensus.trace.BlankSpan;
import p011io.opencensus.trace.EndSpanOptions;
import p011io.opencensus.trace.MessageEvent;
import p011io.opencensus.trace.Span;
import p011io.opencensus.trace.SpanContext;
import p011io.opencensus.trace.Status;
import p011io.opencensus.trace.Tracer;
import p011io.opencensus.trace.propagation.BinaryFormat;
import p011io.opencensus.trace.unsafe.ContextUtils;

/* renamed from: io.grpc.internal.CensusTracingModule */
final class CensusTracingModule {
    /* access modifiers changed from: private */
    @Nullable
    public static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(CensusTracingModule.class.getName());
    /* access modifiers changed from: private */
    @Nullable
    public static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;
    /* access modifiers changed from: private */
    public final Tracer censusTracer;
    private final TracingClientInterceptor clientInterceptor = new TracingClientInterceptor();
    private final ServerTracerFactory serverTracerFactory = new ServerTracerFactory();
    @VisibleForTesting
    final Metadata.Key<SpanContext> tracingHeader;

    static {
        AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater2 = null;
        try {
            AtomicIntegerFieldUpdater<ClientCallTracer> newUpdater = AtomicIntegerFieldUpdater.newUpdater(ClientCallTracer.class, "callEnded");
            atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ServerTracer.class, "streamClosed");
            atomicIntegerFieldUpdater2 = newUpdater;
        } catch (Throwable th) {
            logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
            atomicIntegerFieldUpdater = null;
        }
        callEndedUpdater = atomicIntegerFieldUpdater2;
        streamClosedUpdater = atomicIntegerFieldUpdater;
    }

    CensusTracingModule(Tracer tracer, final BinaryFormat binaryFormat) {
        this.censusTracer = (Tracer) Preconditions.checkNotNull(tracer, "censusTracer");
        Preconditions.checkNotNull(binaryFormat, "censusPropagationBinaryFormat");
        this.tracingHeader = Metadata.Key.m4595of("grpc-trace-bin", new Metadata.BinaryMarshaller<SpanContext>() {
            public byte[] toBytes(SpanContext spanContext) {
                return binaryFormat.toByteArray(spanContext);
            }

            public SpanContext parseBytes(byte[] bArr) {
                try {
                    return binaryFormat.fromByteArray(bArr);
                } catch (Exception e) {
                    CensusTracingModule.logger.log(Level.FINE, "Failed to parse tracing header", e);
                    return SpanContext.INVALID;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ClientCallTracer newClientCallTracer(@Nullable Span span, MethodDescriptor<?, ?> methodDescriptor) {
        return new ClientCallTracer(span, methodDescriptor);
    }

    /* access modifiers changed from: package-private */
    public ServerStreamTracer.Factory getServerTracerFactory() {
        return this.serverTracerFactory;
    }

    /* access modifiers changed from: package-private */
    public ClientInterceptor getClientInterceptor() {
        return this.clientInterceptor;
    }

    @VisibleForTesting
    static Status convertStatus(p011io.grpc.Status status) {
        Status status2;
        switch (status.getCode()) {
            case OK:
                status2 = Status.f4996OK;
                break;
            case CANCELLED:
                status2 = Status.CANCELLED;
                break;
            case UNKNOWN:
                status2 = Status.UNKNOWN;
                break;
            case INVALID_ARGUMENT:
                status2 = Status.INVALID_ARGUMENT;
                break;
            case DEADLINE_EXCEEDED:
                status2 = Status.DEADLINE_EXCEEDED;
                break;
            case NOT_FOUND:
                status2 = Status.NOT_FOUND;
                break;
            case ALREADY_EXISTS:
                status2 = Status.ALREADY_EXISTS;
                break;
            case PERMISSION_DENIED:
                status2 = Status.PERMISSION_DENIED;
                break;
            case RESOURCE_EXHAUSTED:
                status2 = Status.RESOURCE_EXHAUSTED;
                break;
            case FAILED_PRECONDITION:
                status2 = Status.FAILED_PRECONDITION;
                break;
            case ABORTED:
                status2 = Status.ABORTED;
                break;
            case OUT_OF_RANGE:
                status2 = Status.OUT_OF_RANGE;
                break;
            case UNIMPLEMENTED:
                status2 = Status.UNIMPLEMENTED;
                break;
            case INTERNAL:
                status2 = Status.INTERNAL;
                break;
            case UNAVAILABLE:
                status2 = Status.UNAVAILABLE;
                break;
            case DATA_LOSS:
                status2 = Status.DATA_LOSS;
                break;
            case UNAUTHENTICATED:
                status2 = Status.UNAUTHENTICATED;
                break;
            default:
                throw new AssertionError("Unhandled status code " + status.getCode());
        }
        return status.getDescription() != null ? status2.withDescription(status.getDescription()) : status2;
    }

    /* access modifiers changed from: private */
    public static EndSpanOptions createEndSpanOptions(p011io.grpc.Status status, boolean z) {
        return EndSpanOptions.builder().setStatus(convertStatus(status)).setSampleToLocalSpanStore(z).build();
    }

    /* access modifiers changed from: private */
    public static void recordMessageEvent(Span span, MessageEvent.Type type, int i, long j, long j2) {
        MessageEvent.Builder builder = MessageEvent.builder(type, (long) i);
        if (j2 != -1) {
            builder.setUncompressedMessageSize(j2);
        }
        if (j != -1) {
            builder.setCompressedMessageSize(j);
        }
        span.addMessageEvent(builder.build());
    }

    @VisibleForTesting
    /* renamed from: io.grpc.internal.CensusTracingModule$ClientCallTracer */
    final class ClientCallTracer extends ClientStreamTracer.Factory {
        volatile int callEnded;
        private final boolean isSampledToLocalTracing;
        private final Span span;

        ClientCallTracer(@Nullable Span span2, MethodDescriptor<?, ?> methodDescriptor) {
            Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD);
            this.isSampledToLocalTracing = methodDescriptor.isSampledToLocalTracing();
            this.span = CensusTracingModule.this.censusTracer.spanBuilderWithExplicitParent(CensusTracingModule.generateTraceSpanName(false, methodDescriptor.getFullMethodName()), span2).setRecordEvents(true).startSpan();
        }

        public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
            if (this.span != BlankSpan.INSTANCE) {
                metadata.discardAll(CensusTracingModule.this.tracingHeader);
                metadata.put(CensusTracingModule.this.tracingHeader, this.span.getContext());
            }
            return new ClientTracer(this.span);
        }

        /* access modifiers changed from: package-private */
        public void callEnded(p011io.grpc.Status status) {
            if (CensusTracingModule.callEndedUpdater != null) {
                if (CensusTracingModule.callEndedUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.callEnded == 0) {
                this.callEnded = 1;
            } else {
                return;
            }
            this.span.end(CensusTracingModule.createEndSpanOptions(status, this.isSampledToLocalTracing));
        }
    }

    /* renamed from: io.grpc.internal.CensusTracingModule$ClientTracer */
    private static final class ClientTracer extends ClientStreamTracer {
        private final Span span;

        ClientTracer(Span span2) {
            this.span = (Span) Preconditions.checkNotNull(span2, "span");
        }

        public void outboundMessageSent(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.SENT, i, j, j2);
        }

        public void inboundMessageRead(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.RECEIVED, i, j, j2);
        }
    }

    /* renamed from: io.grpc.internal.CensusTracingModule$ServerTracer */
    private final class ServerTracer extends ServerStreamTracer {
        volatile boolean isSampledToLocalTracing;
        private final Span span;
        volatile int streamClosed;

        ServerTracer(String str, @Nullable SpanContext spanContext) {
            Preconditions.checkNotNull(str, "fullMethodName");
            this.span = CensusTracingModule.this.censusTracer.spanBuilderWithRemoteParent(CensusTracingModule.generateTraceSpanName(true, str), spanContext).setRecordEvents(true).startSpan();
        }

        public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> serverCallInfo) {
            this.isSampledToLocalTracing = serverCallInfo.getMethodDescriptor().isSampledToLocalTracing();
        }

        public void streamClosed(p011io.grpc.Status status) {
            if (CensusTracingModule.streamClosedUpdater != null) {
                if (CensusTracingModule.streamClosedUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.streamClosed == 0) {
                this.streamClosed = 1;
            } else {
                return;
            }
            this.span.end(CensusTracingModule.createEndSpanOptions(status, this.isSampledToLocalTracing));
        }

        public Context filterContext(Context context) {
            return ContextUtils.withValue(context, this.span);
        }

        public void outboundMessageSent(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.SENT, i, j, j2);
        }

        public void inboundMessageRead(int i, long j, long j2) {
            CensusTracingModule.recordMessageEvent(this.span, MessageEvent.Type.RECEIVED, i, j, j2);
        }
    }

    @VisibleForTesting
    /* renamed from: io.grpc.internal.CensusTracingModule$ServerTracerFactory */
    final class ServerTracerFactory extends ServerStreamTracer.Factory {
        ServerTracerFactory() {
        }

        public ServerStreamTracer newServerStreamTracer(String str, Metadata metadata) {
            SpanContext spanContext = (SpanContext) metadata.get(CensusTracingModule.this.tracingHeader);
            if (spanContext == SpanContext.INVALID) {
                spanContext = null;
            }
            return new ServerTracer(str, spanContext);
        }
    }

    @VisibleForTesting
    /* renamed from: io.grpc.internal.CensusTracingModule$TracingClientInterceptor */
    final class TracingClientInterceptor implements ClientInterceptor {
        TracingClientInterceptor() {
        }

        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            final ClientCallTracer newClientCallTracer = CensusTracingModule.this.newClientCallTracer(ContextUtils.getValue(Context.current()), methodDescriptor);
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions.withStreamTracerFactory(newClientCallTracer))) {
                public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                    delegate().start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(listener) {
                        public void onClose(p011io.grpc.Status status, Metadata metadata) {
                            newClientCallTracer.callEnded(status);
                            super.onClose(status, metadata);
                        }
                    }, metadata);
                }
            };
        }
    }

    @VisibleForTesting
    static String generateTraceSpanName(boolean z, String str) {
        String str2 = z ? "Recv" : "Sent";
        return str2 + "." + str.replace('/', '.');
    }
}
