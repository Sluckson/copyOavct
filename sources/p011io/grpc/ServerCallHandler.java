package p011io.grpc;

import javax.annotation.concurrent.ThreadSafe;
import p011io.grpc.ServerCall;

@ThreadSafe
/* renamed from: io.grpc.ServerCallHandler */
public interface ServerCallHandler<RequestT, ResponseT> {
    ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> serverCall, Metadata metadata);
}
