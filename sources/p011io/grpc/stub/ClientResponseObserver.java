package p011io.grpc.stub;

import p011io.grpc.ExperimentalApi;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4693")
/* renamed from: io.grpc.stub.ClientResponseObserver */
public interface ClientResponseObserver<ReqT, RespT> extends StreamObserver<RespT> {
    void beforeStart(ClientCallStreamObserver<ReqT> clientCallStreamObserver);
}
