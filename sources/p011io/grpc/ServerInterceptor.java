package p011io.grpc;

import javax.annotation.concurrent.ThreadSafe;
import p011io.grpc.ServerCall;

@ThreadSafe
/* renamed from: io.grpc.ServerInterceptor */
public interface ServerInterceptor {
    <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler);
}
