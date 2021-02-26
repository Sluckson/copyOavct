package p011io.opencensus.contrib.grpc.metrics;

import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p011io.opencensus.common.Duration;
import p011io.opencensus.stats.Aggregation;
import p011io.opencensus.stats.BucketBoundaries;
import p011io.opencensus.stats.View;
import p011io.opencensus.tags.TagKey;

/* renamed from: io.opencensus.contrib.grpc.metrics.RpcViewConstants */
public final class RpcViewConstants {
    @VisibleForTesting
    static final Aggregation AGGREGATION_WITH_BYTES_HISTOGRAM = Aggregation.Distribution.create(BucketBoundaries.create(RPC_BYTES_BUCKET_BOUNDARIES));
    @VisibleForTesting
    static final Aggregation AGGREGATION_WITH_COUNT_HISTOGRAM = Aggregation.Distribution.create(BucketBoundaries.create(RPC_COUNT_BUCKET_BOUNDARIES));
    @VisibleForTesting
    static final Aggregation AGGREGATION_WITH_MILLIS_HISTOGRAM = Aggregation.Distribution.create(BucketBoundaries.create(RPC_MILLIS_BUCKET_BOUNDARIES));
    static final Aggregation AGGREGATION_WITH_MILLIS_HISTOGRAM_DEPRECATED = Aggregation.Distribution.create(BucketBoundaries.create(RPC_MILLIS_BUCKET_BOUNDARIES_DEPRECATED));
    @VisibleForTesting
    static final Aggregation COUNT = Aggregation.Count.create();
    @VisibleForTesting
    static final View.AggregationWindow CUMULATIVE = View.AggregationWindow.Cumulative.create();
    public static final View GRPC_CLIENT_COMPLETED_RPC_VIEW = View.create(View.Name.create("grpc.io/client/completed_rpcs"), "Number of completed client RPCs", RpcMeasureConstants.GRPC_CLIENT_ROUNDTRIP_LATENCY, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD, RpcMeasureConstants.GRPC_CLIENT_STATUS}));
    public static final View GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/client/received_bytes_per_method"), "Received bytes per method", RpcMeasureConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD, SUM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_RECEIVED_BYTES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/client/received_bytes_per_rpc"), "Received bytes per RPC", RpcMeasureConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_RPC, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/client/received_messages_per_method"), "Number of messages received", RpcMeasureConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_RECEIVED_MESSAGES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/client/received_messages_per_rpc"), "Number of response messages received per RPC", RpcMeasureConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_RPC, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_ROUNDTRIP_LATENCY_VIEW = View.create(View.Name.create("grpc.io/client/roundtrip_latency"), "Latency in msecs", RpcMeasureConstants.GRPC_CLIENT_ROUNDTRIP_LATENCY, AGGREGATION_WITH_MILLIS_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_SENT_BYTES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/client/sent_bytes_per_method"), "Sent bytes per method", RpcMeasureConstants.GRPC_CLIENT_SENT_BYTES_PER_METHOD, SUM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_SENT_BYTES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/client/sent_bytes_per_rpc"), "Sent bytes per RPC", RpcMeasureConstants.GRPC_CLIENT_SENT_BYTES_PER_RPC, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_SENT_MESSAGES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/client/sent_messages_per_method"), "Number of messages sent", RpcMeasureConstants.GRPC_CLIENT_SENT_MESSAGES_PER_METHOD, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_SENT_MESSAGES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/client/sent_messages_per_rpc"), "Number of messages sent in the RPC", RpcMeasureConstants.GRPC_CLIENT_SENT_MESSAGES_PER_RPC, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_SERVER_LATENCY_VIEW = View.create(View.Name.create("grpc.io/client/server_latency"), "Server latency in msecs", RpcMeasureConstants.GRPC_CLIENT_SERVER_LATENCY, AGGREGATION_WITH_MILLIS_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_CLIENT_STARTED_RPC_VIEW = View.create(View.Name.create("grpc.io/client/started_rpcs"), "Number of started client RPCs", RpcMeasureConstants.GRPC_CLIENT_STARTED_RPCS, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_CLIENT_METHOD}));
    public static final View GRPC_SERVER_COMPLETED_RPC_VIEW = View.create(View.Name.create("grpc.io/server/completed_rpcs"), "Number of completed server RPCs", RpcMeasureConstants.GRPC_SERVER_SERVER_LATENCY, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD, RpcMeasureConstants.GRPC_SERVER_STATUS}));
    public static final View GRPC_SERVER_RECEIVED_BYTES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/server/received_bytes_per_method"), "Received bytes per method", RpcMeasureConstants.GRPC_SERVER_RECEIVED_BYTES_PER_METHOD, SUM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_RECEIVED_BYTES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/server/received_bytes_per_rpc"), "Received bytes per RPC", RpcMeasureConstants.GRPC_SERVER_RECEIVED_BYTES_PER_RPC, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/server/received_messages_per_method"), "Number of messages received", RpcMeasureConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_RECEIVED_MESSAGES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/server/received_messages_per_rpc"), "Number of response messages received in each RPC", RpcMeasureConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_RPC, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_SENT_BYTES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/server/sent_bytes_per_method"), "Sent bytes per method", RpcMeasureConstants.GRPC_SERVER_SENT_BYTES_PER_METHOD, SUM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_SENT_BYTES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/server/sent_bytes_per_rpc"), "Sent bytes per RPC", RpcMeasureConstants.GRPC_SERVER_SENT_BYTES_PER_RPC, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_SENT_MESSAGES_PER_METHOD_VIEW = View.create(View.Name.create("grpc.io/server/sent_messages_per_method"), "Number of messages sent", RpcMeasureConstants.GRPC_SERVER_SENT_MESSAGES_PER_METHOD, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_SENT_MESSAGES_PER_RPC_VIEW = View.create(View.Name.create("grpc.io/server/sent_messages_per_rpc"), "Number of messages sent in each RPC", RpcMeasureConstants.GRPC_SERVER_SENT_MESSAGES_PER_RPC, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_SERVER_LATENCY_VIEW = View.create(View.Name.create("grpc.io/server/server_latency"), "Server latency in msecs", RpcMeasureConstants.GRPC_SERVER_SERVER_LATENCY, AGGREGATION_WITH_MILLIS_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    public static final View GRPC_SERVER_STARTED_RPC_VIEW = View.create(View.Name.create("grpc.io/server/started_rpcs"), "Number of started server RPCs", RpcMeasureConstants.GRPC_SERVER_STARTED_RPCS, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.GRPC_SERVER_METHOD}));
    @VisibleForTesting
    static final Duration HOUR = Duration.create(3600, 0);
    @VisibleForTesting
    static final View.AggregationWindow INTERVAL_HOUR = View.AggregationWindow.Interval.create(HOUR);
    @VisibleForTesting
    static final View.AggregationWindow INTERVAL_MINUTE = View.AggregationWindow.Interval.create(MINUTE);
    @VisibleForTesting
    static final Aggregation MEAN = Aggregation.Mean.create();
    @VisibleForTesting
    static final Duration MINUTE = Duration.create(60, 0);
    @VisibleForTesting
    static final List<Double> RPC_BYTES_BUCKET_BOUNDARIES;
    public static final View RPC_CLIENT_ERROR_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/error_count/hour"), "Hour stats for rpc errors", RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_ERROR_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/error_count/minute"), "Minute stats for rpc errors", RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_ERROR_COUNT_VIEW = View.create(View.Name.create("grpc.io/client/error_count/cumulative"), "RPC Errors", RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_STATUS, RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    @Deprecated
    public static final View RPC_CLIENT_FINISHED_COUNT_CUMULATIVE_VIEW = View.create(View.Name.create("grpc.io/client/finished_count/cumulative"), "Number of finished client RPCs", RpcMeasureConstants.RPC_CLIENT_FINISHED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_FINISHED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/finished_count/hour"), "Hour stats on the number of client RPCs finished", RpcMeasureConstants.RPC_CLIENT_FINISHED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_FINISHED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/finished_count/minute"), "Minute stats on the number of client RPCs finished", RpcMeasureConstants.RPC_CLIENT_FINISHED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    public static final View RPC_CLIENT_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/request_bytes/hour"), "Hour stats for request size in bytes", RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/request_bytes/minute"), "Minute stats for request size in bytes", RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/request_bytes/cumulative"), "Request bytes", RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_REQUEST_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/request_count/hour"), "Hour stats on the count of request messages per client RPC", RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_REQUEST_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/request_count/minute"), "Minute stats on the count of request messages per client RPC", RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_REQUEST_COUNT_VIEW = View.create(View.Name.create("grpc.io/client/request_count/cumulative"), "Count of request messages per client RPC", RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/response_bytes/hour"), "Hour stats for response size in bytes", RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/response_bytes/minute"), "Minute stats for response size in bytes", RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/response_bytes/cumulative"), "Response bytes", RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_RESPONSE_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/response_count/hour"), "Hour stats on the count of response messages per client RPC", RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_RESPONSE_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/response_count/minute"), "Minute stats on the count of response messages per client RPC", RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_RESPONSE_COUNT_VIEW = View.create(View.Name.create("grpc.io/client/response_count/cumulative"), "Count of response messages per client RPC", RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_ROUNDTRIP_LATENCY_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/roundtrip_latency/hour"), "Hour stats for latency in msecs", RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_ROUNDTRIP_LATENCY_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/roundtrip_latency/minute"), "Minute stats for latency in msecs", RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW = View.create(View.Name.create("grpc.io/client/roundtrip_latency/cumulative"), "Latency in msecs", RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, AGGREGATION_WITH_MILLIS_HISTOGRAM_DEPRECATED, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_SERVER_ELAPSED_TIME_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/server_elapsed_time/hour"), "Hour stats for server elapsed time in msecs", RpcMeasureConstants.RPC_CLIENT_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_SERVER_ELAPSED_TIME_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/server_elapsed_time/minute"), "Minute stats for server elapsed time in msecs", RpcMeasureConstants.RPC_CLIENT_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW = View.create(View.Name.create("grpc.io/client/server_elapsed_time/cumulative"), "Server elapsed time in msecs", RpcMeasureConstants.RPC_CLIENT_SERVER_ELAPSED_TIME, AGGREGATION_WITH_MILLIS_HISTOGRAM_DEPRECATED, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    @Deprecated
    public static final View RPC_CLIENT_STARTED_COUNT_CUMULATIVE_VIEW = View.create(View.Name.create("grpc.io/client/started_count/cumulative"), "Number of started client RPCs", RpcMeasureConstants.RPC_CLIENT_STARTED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_STARTED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/started_count/hour"), "Hour stats on the number of client RPCs started", RpcMeasureConstants.RPC_CLIENT_STARTED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_STARTED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/started_count/minute"), "Minute stats on the number of client RPCs started", RpcMeasureConstants.RPC_CLIENT_STARTED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    public static final View RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_request_bytes/hour"), "Hour stats for uncompressed request size in bytes", RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_request_bytes/minute"), "Minute stats for uncompressed request size in bytes", RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_request_bytes/cumulative"), "Uncompressed Request bytes", RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_response_bytes/hour"), "Hour stats for uncompressed response size in bytes", RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_response_bytes/minute"), "Minute stats for uncompressed response size in bytes", RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_response_bytes/cumulative"), "Uncompressed Response bytes", RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    @VisibleForTesting
    static final List<Double> RPC_COUNT_BUCKET_BOUNDARIES;
    @VisibleForTesting
    static final List<Double> RPC_MILLIS_BUCKET_BOUNDARIES;
    static final List<Double> RPC_MILLIS_BUCKET_BOUNDARIES_DEPRECATED;
    public static final View RPC_SERVER_ERROR_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/error_count/hour"), "Hour stats for rpc errors", RpcMeasureConstants.RPC_SERVER_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_ERROR_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/error_count/minute"), "Minute stats for rpc errors", RpcMeasureConstants.RPC_SERVER_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_ERROR_COUNT_VIEW = View.create(View.Name.create("grpc.io/server/error_count/cumulative"), "RPC Errors", RpcMeasureConstants.RPC_SERVER_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_STATUS, RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    @Deprecated
    public static final View RPC_SERVER_FINISHED_COUNT_CUMULATIVE_VIEW = View.create(View.Name.create("grpc.io/server/finished_count/cumulative"), "Number of finished server RPCs", RpcMeasureConstants.RPC_SERVER_FINISHED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_FINISHED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/finished_count/hour"), "Hour stats on the number of server RPCs finished", RpcMeasureConstants.RPC_SERVER_FINISHED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_FINISHED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/finished_count/minute"), "Minute stats on the number of server RPCs finished", RpcMeasureConstants.RPC_SERVER_FINISHED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    public static final View RPC_SERVER_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/request_bytes/hour"), "Hour stats for request size in bytes", RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/request_bytes/minute"), "Minute stats for request size in bytes", RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/request_bytes/cumulative"), "Request bytes", RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_REQUEST_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/request_count/hour"), "Hour stats on the count of request messages per server RPC", RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_REQUEST_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/request_count/minute"), "Minute stats on the count of request messages per server RPC", RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_REQUEST_COUNT_VIEW = View.create(View.Name.create("grpc.io/server/request_count/cumulative"), "Count of request messages per server RPC", RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/response_bytes/hour"), "Hour stats for response size in bytes", RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/response_bytes/minute"), "Minute stats for response size in bytes", RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/response_bytes/cumulative"), "Response bytes", RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_RESPONSE_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/response_count/hour"), "Hour stats on the count of response messages per server RPC", RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_RESPONSE_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/response_count/minute"), "Minute stats on the count of response messages per server RPC", RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_RESPONSE_COUNT_VIEW = View.create(View.Name.create("grpc.io/server/response_count/cumulative"), "Count of response messages per server RPC", RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_SERVER_ELAPSED_TIME_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/server_elapsed_time/hour"), "Hour stats for server elapsed time in msecs", RpcMeasureConstants.RPC_SERVER_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_SERVER_ELAPSED_TIME_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/server_elapsed_time/minute"), "Minute stats for server elapsed time in msecs", RpcMeasureConstants.RPC_SERVER_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_SERVER_ELAPSED_TIME_VIEW = View.create(View.Name.create("grpc.io/server/elapsed_time/cumulative"), "Server elapsed time in msecs", RpcMeasureConstants.RPC_SERVER_SERVER_ELAPSED_TIME, AGGREGATION_WITH_MILLIS_HISTOGRAM_DEPRECATED, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_SERVER_LATENCY_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/server_latency/hour"), "Hour stats for server latency in msecs", RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_SERVER_LATENCY_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/server_latency/minute"), "Minute stats for server latency in msecs", RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_SERVER_LATENCY_VIEW = View.create(View.Name.create("grpc.io/server/server_latency/cumulative"), "Latency in msecs", RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY, AGGREGATION_WITH_MILLIS_HISTOGRAM_DEPRECATED, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    @Deprecated
    public static final View RPC_SERVER_STARTED_COUNT_CUMULATIVE_VIEW = View.create(View.Name.create("grpc.io/server/started_count/cumulative"), "Number of started server RPCs", RpcMeasureConstants.RPC_SERVER_STARTED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_STARTED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/started_count/hour"), "Hour stats on the number of server RPCs started", RpcMeasureConstants.RPC_SERVER_STARTED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_STARTED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/started_count/minute"), "Minute stats on the number of server RPCs started", RpcMeasureConstants.RPC_SERVER_STARTED_COUNT, COUNT, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    public static final View RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_request_bytes/hour"), "Hour stats for uncompressed request size in bytes", RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_request_bytes/minute"), "Minute stats for uncompressed request size in bytes", RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_request_bytes/cumulative"), "Uncompressed Request bytes", RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    public static final View RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_response_bytes/hour"), "Hour stats for uncompressed response size in bytes", RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_HOUR);
    public static final View RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_response_bytes/minute"), "Minute stats for uncompressed response size in bytes", RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), INTERVAL_MINUTE);
    @Deprecated
    public static final View RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_response_bytes/cumulative"), "Uncompressed Response bytes", RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[]{RpcMeasureConstants.RPC_METHOD}), CUMULATIVE);
    @VisibleForTesting
    static final Aggregation SUM = Aggregation.Sum.create();

    static {
        Double valueOf = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        RPC_BYTES_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(new Double[]{valueOf, Double.valueOf(1024.0d), Double.valueOf(2048.0d), Double.valueOf(4096.0d), Double.valueOf(16384.0d), Double.valueOf(65536.0d), Double.valueOf(262144.0d), Double.valueOf(1048576.0d), Double.valueOf(4194304.0d), Double.valueOf(1.6777216E7d), Double.valueOf(6.7108864E7d), Double.valueOf(2.68435456E8d), Double.valueOf(1.073741824E9d), Double.valueOf(4.294967296E9d)}));
        RPC_MILLIS_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(new Double[]{valueOf, Double.valueOf(0.01d), Double.valueOf(0.05d), Double.valueOf(0.1d), Double.valueOf(0.3d), Double.valueOf(0.6d), Double.valueOf(0.8d), Double.valueOf(1.0d), Double.valueOf(2.0d), Double.valueOf(3.0d), Double.valueOf(4.0d), Double.valueOf(5.0d), Double.valueOf(6.0d), Double.valueOf(8.0d), Double.valueOf(10.0d), Double.valueOf(13.0d), Double.valueOf(16.0d), Double.valueOf(20.0d), Double.valueOf(25.0d), Double.valueOf(30.0d), Double.valueOf(40.0d), Double.valueOf(50.0d), Double.valueOf(65.0d), Double.valueOf(80.0d), Double.valueOf(100.0d), Double.valueOf(130.0d), Double.valueOf(160.0d), Double.valueOf(200.0d), Double.valueOf(250.0d), Double.valueOf(300.0d), Double.valueOf(400.0d), Double.valueOf(500.0d), Double.valueOf(650.0d), Double.valueOf(800.0d), Double.valueOf(1000.0d), Double.valueOf(2000.0d), Double.valueOf(5000.0d), Double.valueOf(10000.0d), Double.valueOf(20000.0d), Double.valueOf(50000.0d), Double.valueOf(100000.0d)}));
        RPC_MILLIS_BUCKET_BOUNDARIES_DEPRECATED = Collections.unmodifiableList(Arrays.asList(new Double[]{valueOf, Double.valueOf(1.0d), Double.valueOf(2.0d), Double.valueOf(3.0d), Double.valueOf(4.0d), Double.valueOf(5.0d), Double.valueOf(6.0d), Double.valueOf(8.0d), Double.valueOf(10.0d), Double.valueOf(13.0d), Double.valueOf(16.0d), Double.valueOf(20.0d), Double.valueOf(25.0d), Double.valueOf(30.0d), Double.valueOf(40.0d), Double.valueOf(50.0d), Double.valueOf(65.0d), Double.valueOf(80.0d), Double.valueOf(100.0d), Double.valueOf(130.0d), Double.valueOf(160.0d), Double.valueOf(200.0d), Double.valueOf(250.0d), Double.valueOf(300.0d), Double.valueOf(400.0d), Double.valueOf(500.0d), Double.valueOf(650.0d), Double.valueOf(800.0d), Double.valueOf(1000.0d), Double.valueOf(2000.0d), Double.valueOf(5000.0d), Double.valueOf(10000.0d), Double.valueOf(20000.0d), Double.valueOf(50000.0d), Double.valueOf(100000.0d)}));
        RPC_COUNT_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(new Double[]{valueOf, Double.valueOf(1.0d), Double.valueOf(2.0d), Double.valueOf(4.0d), Double.valueOf(8.0d), Double.valueOf(16.0d), Double.valueOf(32.0d), Double.valueOf(64.0d), Double.valueOf(128.0d), Double.valueOf(256.0d), Double.valueOf(512.0d), Double.valueOf(1024.0d), Double.valueOf(2048.0d), Double.valueOf(4096.0d), Double.valueOf(8192.0d), Double.valueOf(16384.0d), Double.valueOf(32768.0d), Double.valueOf(65536.0d)}));
    }

    private RpcViewConstants() {
    }
}
