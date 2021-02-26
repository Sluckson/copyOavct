package p011io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
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
import p011io.grpc.Status;
import p011io.opencensus.contrib.grpc.metrics.RpcMeasureConstants;
import p011io.opencensus.stats.Measure;
import p011io.opencensus.stats.MeasureMap;
import p011io.opencensus.stats.Stats;
import p011io.opencensus.stats.StatsRecorder;
import p011io.opencensus.tags.TagContext;
import p011io.opencensus.tags.TagValue;
import p011io.opencensus.tags.Tagger;
import p011io.opencensus.tags.Tags;
import p011io.opencensus.tags.unsafe.ContextUtils;

/* renamed from: io.grpc.internal.CensusStatsModule */
public final class CensusStatsModule {
    /* access modifiers changed from: private */
    public static final double NANOS_PER_MILLI = ((double) TimeUnit.MILLISECONDS.toNanos(1));
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(CensusStatsModule.class.getName());
    /* access modifiers changed from: private */
    public final boolean propagateTags;
    /* access modifiers changed from: private */
    public final boolean recordFinishedRpcs;
    private final boolean recordRealTimeMetrics;
    /* access modifiers changed from: private */
    public final boolean recordStartedRpcs;
    @VisibleForTesting
    final Metadata.Key<TagContext> statsHeader;
    /* access modifiers changed from: private */
    public final StatsRecorder statsRecorder;
    /* access modifiers changed from: private */
    public final Supplier<Stopwatch> stopwatchSupplier;
    /* access modifiers changed from: private */
    public final Tagger tagger;

    CensusStatsModule(Supplier<Stopwatch> supplier, boolean z, boolean z2, boolean z3, boolean z4) {
        this(Tags.getTagger(), Tags.getTagPropagationComponent().getBinarySerializer(), Stats.getStatsRecorder(), supplier, z, z2, z3, z4);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, com.google.common.base.Supplier<com.google.common.base.Stopwatch>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CensusStatsModule(final p011io.opencensus.tags.Tagger r2, final p011io.opencensus.tags.propagation.TagContextBinarySerializer r3, p011io.opencensus.stats.StatsRecorder r4, com.google.common.base.Supplier<com.google.common.base.Stopwatch> r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "tagger"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r2, r0)
            io.opencensus.tags.Tagger r0 = (p011io.opencensus.tags.Tagger) r0
            r1.tagger = r0
            java.lang.String r0 = "statsRecorder"
            java.lang.Object r4 = com.google.common.base.Preconditions.checkNotNull(r4, r0)
            io.opencensus.stats.StatsRecorder r4 = (p011io.opencensus.stats.StatsRecorder) r4
            r1.statsRecorder = r4
            java.lang.String r4 = "tagCtxSerializer"
            com.google.common.base.Preconditions.checkNotNull(r3, r4)
            java.lang.String r4 = "stopwatchSupplier"
            java.lang.Object r4 = com.google.common.base.Preconditions.checkNotNull(r5, r4)
            com.google.common.base.Supplier r4 = (com.google.common.base.Supplier) r4
            r1.stopwatchSupplier = r4
            r1.propagateTags = r6
            r1.recordStartedRpcs = r7
            r1.recordFinishedRpcs = r8
            r1.recordRealTimeMetrics = r9
            io.grpc.internal.CensusStatsModule$1 r4 = new io.grpc.internal.CensusStatsModule$1
            r4.<init>(r3, r2)
            java.lang.String r2 = "grpc-tags-bin"
            io.grpc.Metadata$Key r2 = p011io.grpc.Metadata.Key.m4595of((java.lang.String) r2, r4)
            r1.statsHeader = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p011io.grpc.internal.CensusStatsModule.<init>(io.opencensus.tags.Tagger, io.opencensus.tags.propagation.TagContextBinarySerializer, io.opencensus.stats.StatsRecorder, com.google.common.base.Supplier, boolean, boolean, boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ClientCallTracer newClientCallTracer(TagContext tagContext, String str) {
        return new ClientCallTracer(this, tagContext, str);
    }

    /* access modifiers changed from: package-private */
    public ServerStreamTracer.Factory getServerTracerFactory() {
        return new ServerTracerFactory();
    }

    /* access modifiers changed from: package-private */
    public ClientInterceptor getClientInterceptor() {
        return new StatsClientInterceptor();
    }

    /* access modifiers changed from: private */
    public void recordRealTimeMetric(TagContext tagContext, Measure.MeasureDouble measureDouble, double d) {
        if (this.recordRealTimeMetrics) {
            this.statsRecorder.newMeasureMap().put(measureDouble, d).record(tagContext);
        }
    }

    /* access modifiers changed from: private */
    public void recordRealTimeMetric(TagContext tagContext, Measure.MeasureLong measureLong, long j) {
        if (this.recordRealTimeMetrics) {
            this.statsRecorder.newMeasureMap().put(measureLong, j).record(tagContext);
        }
    }

    /* renamed from: io.grpc.internal.CensusStatsModule$ClientTracer */
    private static final class ClientTracer extends ClientStreamTracer {
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> inboundWireSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ClientTracer> outboundWireSizeUpdater;
        volatile long inboundMessageCount;
        volatile long inboundUncompressedSize;
        volatile long inboundWireSize;
        private final CensusStatsModule module;
        volatile long outboundMessageCount;
        volatile long outboundUncompressedSize;
        volatile long outboundWireSize;
        private final TagContext startCtx;

        static {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater2;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater3;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater4;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater5;
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater6 = null;
            try {
                AtomicLongFieldUpdater<ClientTracer> newUpdater = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "outboundMessageCount");
                atomicLongFieldUpdater4 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "inboundMessageCount");
                atomicLongFieldUpdater3 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "outboundWireSize");
                atomicLongFieldUpdater2 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "inboundWireSize");
                atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "outboundUncompressedSize");
                AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater7 = newUpdater;
                atomicLongFieldUpdater5 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "inboundUncompressedSize");
                atomicLongFieldUpdater6 = atomicLongFieldUpdater7;
            } catch (Throwable th) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicLongFieldUpdater5 = null;
                atomicLongFieldUpdater4 = null;
                atomicLongFieldUpdater3 = null;
                atomicLongFieldUpdater2 = null;
                atomicLongFieldUpdater = null;
            }
            outboundMessageCountUpdater = atomicLongFieldUpdater6;
            inboundMessageCountUpdater = atomicLongFieldUpdater4;
            outboundWireSizeUpdater = atomicLongFieldUpdater3;
            inboundWireSizeUpdater = atomicLongFieldUpdater2;
            outboundUncompressedSizeUpdater = atomicLongFieldUpdater;
            inboundUncompressedSizeUpdater = atomicLongFieldUpdater5;
        }

        ClientTracer(CensusStatsModule censusStatsModule, TagContext tagContext) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(censusStatsModule, "module");
            this.startCtx = (TagContext) Preconditions.checkNotNull(tagContext, "startCtx");
        }

        public void outboundWireSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.outboundWireSize += j;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_SENT_BYTES_PER_METHOD, (double) j);
        }

        public void inboundWireSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.inboundWireSize += j;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD, (double) j);
        }

        public void outboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.outboundUncompressedSize += j;
            }
        }

        public void inboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.inboundUncompressedSize += j;
            }
        }

        public void inboundMessage(int i) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.inboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD, 1);
        }

        public void outboundMessage(int i) {
            AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.outboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.startCtx, RpcMeasureConstants.GRPC_CLIENT_SENT_MESSAGES_PER_METHOD, 1);
        }
    }

    @VisibleForTesting
    /* renamed from: io.grpc.internal.CensusStatsModule$ClientCallTracer */
    static final class ClientCallTracer extends ClientStreamTracer.Factory {
        @Nullable
        private static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;
        @Nullable
        private static final AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> streamTracerUpdater;
        private volatile int callEnded;
        private final CensusStatsModule module;
        private final TagContext parentCtx;
        private final TagContext startCtx;
        private final Stopwatch stopwatch;
        private volatile ClientTracer streamTracer;

        static {
            AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater;
            AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> atomicReferenceFieldUpdater = null;
            try {
                AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> newUpdater = AtomicReferenceFieldUpdater.newUpdater(ClientCallTracer.class, ClientTracer.class, "streamTracer");
                atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ClientCallTracer.class, "callEnded");
                atomicReferenceFieldUpdater = newUpdater;
            } catch (Throwable th) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicIntegerFieldUpdater = null;
            }
            streamTracerUpdater = atomicReferenceFieldUpdater;
            callEndedUpdater = atomicIntegerFieldUpdater;
        }

        ClientCallTracer(CensusStatsModule censusStatsModule, TagContext tagContext, String str) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(censusStatsModule);
            this.parentCtx = (TagContext) Preconditions.checkNotNull(tagContext);
            this.startCtx = censusStatsModule.tagger.toBuilder(tagContext).putPropagating(DeprecatedCensusConstants.RPC_METHOD, TagValue.create(str)).build();
            this.stopwatch = ((Stopwatch) censusStatsModule.stopwatchSupplier.get()).start();
            if (censusStatsModule.recordStartedRpcs) {
                censusStatsModule.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_CLIENT_STARTED_COUNT, 1).record(this.startCtx);
            }
        }

        public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
            ClientTracer clientTracer = new ClientTracer(this.module, this.startCtx);
            AtomicReferenceFieldUpdater<ClientCallTracer, ClientTracer> atomicReferenceFieldUpdater = streamTracerUpdater;
            if (atomicReferenceFieldUpdater != null) {
                Preconditions.checkState(atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, clientTracer), "Are you creating multiple streams per call? This class doesn't yet support this case");
            } else {
                Preconditions.checkState(this.streamTracer == null, "Are you creating multiple streams per call? This class doesn't yet support this case");
                this.streamTracer = clientTracer;
            }
            if (this.module.propagateTags) {
                metadata.discardAll(this.module.statsHeader);
                if (!this.module.tagger.empty().equals(this.parentCtx)) {
                    metadata.put(this.module.statsHeader, this.parentCtx);
                }
            }
            return clientTracer;
        }

        /* access modifiers changed from: package-private */
        public void callEnded(Status status) {
            AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater = callEndedUpdater;
            if (atomicIntegerFieldUpdater != null) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.callEnded == 0) {
                this.callEnded = 1;
            } else {
                return;
            }
            if (this.module.recordFinishedRpcs) {
                this.stopwatch.stop();
                long elapsed = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
                ClientTracer clientTracer = this.streamTracer;
                if (clientTracer == null) {
                    clientTracer = new ClientTracer(this.module, this.startCtx);
                }
                MeasureMap put = this.module.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_CLIENT_FINISHED_COUNT, 1).put(DeprecatedCensusConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, ((double) elapsed) / CensusStatsModule.NANOS_PER_MILLI).put(DeprecatedCensusConstants.RPC_CLIENT_REQUEST_COUNT, clientTracer.outboundMessageCount).put(DeprecatedCensusConstants.RPC_CLIENT_RESPONSE_COUNT, clientTracer.inboundMessageCount).put(DeprecatedCensusConstants.RPC_CLIENT_REQUEST_BYTES, (double) clientTracer.outboundWireSize).put(DeprecatedCensusConstants.RPC_CLIENT_RESPONSE_BYTES, (double) clientTracer.inboundWireSize).put(DeprecatedCensusConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, (double) clientTracer.outboundUncompressedSize).put(DeprecatedCensusConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, (double) clientTracer.inboundUncompressedSize);
                if (!status.isOk()) {
                    put.put(DeprecatedCensusConstants.RPC_CLIENT_ERROR_COUNT, 1);
                }
                put.record(this.module.tagger.toBuilder(this.startCtx).putPropagating(DeprecatedCensusConstants.RPC_STATUS, TagValue.create(status.getCode().toString())).build());
            }
        }
    }

    /* renamed from: io.grpc.internal.CensusStatsModule$ServerTracer */
    private static final class ServerTracer extends ServerStreamTracer {
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> inboundWireSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundMessageCountUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundUncompressedSizeUpdater;
        @Nullable
        private static final AtomicLongFieldUpdater<ServerTracer> outboundWireSizeUpdater;
        @Nullable
        private static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;
        private volatile long inboundMessageCount;
        private volatile long inboundUncompressedSize;
        private volatile long inboundWireSize;
        private final CensusStatsModule module;
        private volatile long outboundMessageCount;
        private volatile long outboundUncompressedSize;
        private volatile long outboundWireSize;
        private final TagContext parentCtx;
        private final Stopwatch stopwatch;
        private volatile int streamClosed;

        static {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater2;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater3;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater4;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater5;
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater6;
            AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater = null;
            try {
                AtomicIntegerFieldUpdater<ServerTracer> newUpdater = AtomicIntegerFieldUpdater.newUpdater(ServerTracer.class, "streamClosed");
                atomicLongFieldUpdater5 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundMessageCount");
                atomicLongFieldUpdater4 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundMessageCount");
                atomicLongFieldUpdater3 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundWireSize");
                atomicLongFieldUpdater2 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundWireSize");
                atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundUncompressedSize");
                AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater2 = newUpdater;
                atomicLongFieldUpdater6 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundUncompressedSize");
                atomicIntegerFieldUpdater = atomicIntegerFieldUpdater2;
            } catch (Throwable th) {
                CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicLongFieldUpdater6 = null;
                atomicLongFieldUpdater5 = null;
                atomicLongFieldUpdater4 = null;
                atomicLongFieldUpdater3 = null;
                atomicLongFieldUpdater2 = null;
                atomicLongFieldUpdater = null;
            }
            streamClosedUpdater = atomicIntegerFieldUpdater;
            outboundMessageCountUpdater = atomicLongFieldUpdater5;
            inboundMessageCountUpdater = atomicLongFieldUpdater4;
            outboundWireSizeUpdater = atomicLongFieldUpdater3;
            inboundWireSizeUpdater = atomicLongFieldUpdater2;
            outboundUncompressedSizeUpdater = atomicLongFieldUpdater;
            inboundUncompressedSizeUpdater = atomicLongFieldUpdater6;
        }

        ServerTracer(CensusStatsModule censusStatsModule, TagContext tagContext) {
            this.module = (CensusStatsModule) Preconditions.checkNotNull(censusStatsModule, "module");
            this.parentCtx = (TagContext) Preconditions.checkNotNull(tagContext, "parentCtx");
            this.stopwatch = ((Stopwatch) censusStatsModule.stopwatchSupplier.get()).start();
            if (censusStatsModule.recordStartedRpcs) {
                censusStatsModule.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_SERVER_STARTED_COUNT, 1).record(tagContext);
            }
        }

        public void outboundWireSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.outboundWireSize += j;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_SENT_BYTES_PER_METHOD, (double) j);
        }

        public void inboundWireSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.inboundWireSize += j;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_RECEIVED_BYTES_PER_METHOD, (double) j);
        }

        public void outboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.outboundUncompressedSize += j;
            }
        }

        public void inboundUncompressedSize(long j) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.inboundUncompressedSize += j;
            }
        }

        public void inboundMessage(int i) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.inboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD, 1);
        }

        public void outboundMessage(int i) {
            AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.outboundMessageCount++;
            }
            this.module.recordRealTimeMetric(this.parentCtx, RpcMeasureConstants.GRPC_SERVER_SENT_MESSAGES_PER_METHOD, 1);
        }

        public void streamClosed(Status status) {
            AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater = streamClosedUpdater;
            if (atomicIntegerFieldUpdater != null) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.streamClosed == 0) {
                this.streamClosed = 1;
            } else {
                return;
            }
            if (this.module.recordFinishedRpcs) {
                this.stopwatch.stop();
                MeasureMap put = this.module.statsRecorder.newMeasureMap().put(DeprecatedCensusConstants.RPC_SERVER_FINISHED_COUNT, 1).put(DeprecatedCensusConstants.RPC_SERVER_SERVER_LATENCY, ((double) this.stopwatch.elapsed(TimeUnit.NANOSECONDS)) / CensusStatsModule.NANOS_PER_MILLI).put(DeprecatedCensusConstants.RPC_SERVER_RESPONSE_COUNT, this.outboundMessageCount).put(DeprecatedCensusConstants.RPC_SERVER_REQUEST_COUNT, this.inboundMessageCount).put(DeprecatedCensusConstants.RPC_SERVER_RESPONSE_BYTES, (double) this.outboundWireSize).put(DeprecatedCensusConstants.RPC_SERVER_REQUEST_BYTES, (double) this.inboundWireSize).put(DeprecatedCensusConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, (double) this.outboundUncompressedSize).put(DeprecatedCensusConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, (double) this.inboundUncompressedSize);
                if (!status.isOk()) {
                    put.put(DeprecatedCensusConstants.RPC_SERVER_ERROR_COUNT, 1);
                }
                put.record(this.module.tagger.toBuilder(this.parentCtx).putPropagating(DeprecatedCensusConstants.RPC_STATUS, TagValue.create(status.getCode().toString())).build());
            }
        }

        public Context filterContext(Context context) {
            return !this.module.tagger.empty().equals(this.parentCtx) ? ContextUtils.withValue(context, this.parentCtx) : context;
        }
    }

    @VisibleForTesting
    /* renamed from: io.grpc.internal.CensusStatsModule$ServerTracerFactory */
    final class ServerTracerFactory extends ServerStreamTracer.Factory {
        ServerTracerFactory() {
        }

        public ServerStreamTracer newServerStreamTracer(String str, Metadata metadata) {
            TagContext tagContext = (TagContext) metadata.get(CensusStatsModule.this.statsHeader);
            if (tagContext == null) {
                tagContext = CensusStatsModule.this.tagger.empty();
            }
            return new ServerTracer(CensusStatsModule.this, CensusStatsModule.this.tagger.toBuilder(tagContext).putPropagating(DeprecatedCensusConstants.RPC_METHOD, TagValue.create(str)).build());
        }
    }

    @VisibleForTesting
    /* renamed from: io.grpc.internal.CensusStatsModule$StatsClientInterceptor */
    final class StatsClientInterceptor implements ClientInterceptor {
        StatsClientInterceptor() {
        }

        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            final ClientCallTracer newClientCallTracer = CensusStatsModule.this.newClientCallTracer(CensusStatsModule.this.tagger.getCurrentTagContext(), methodDescriptor.getFullMethodName());
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions.withStreamTracerFactory(newClientCallTracer))) {
                public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                    delegate().start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(listener) {
                        public void onClose(Status status, Metadata metadata) {
                            newClientCallTracer.callEnded(status);
                            super.onClose(status, metadata);
                        }
                    }, metadata);
                }
            };
        }
    }
}
