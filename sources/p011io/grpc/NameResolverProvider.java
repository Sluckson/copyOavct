package p011io.grpc;

import java.util.List;
import p011io.grpc.Attributes;
import p011io.grpc.NameResolver;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
/* renamed from: io.grpc.NameResolverProvider */
public abstract class NameResolverProvider extends NameResolver.Factory {
    @Deprecated
    public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = NameResolver.Factory.PARAMS_DEFAULT_PORT;

    /* access modifiers changed from: protected */
    public abstract boolean isAvailable();

    /* access modifiers changed from: protected */
    public abstract int priority();

    @Deprecated
    public static List<NameResolverProvider> providers() {
        return NameResolverRegistry.getDefaultRegistry().providers();
    }

    @Deprecated
    public static NameResolver.Factory asFactory() {
        return NameResolverRegistry.getDefaultRegistry().asFactory();
    }
}
