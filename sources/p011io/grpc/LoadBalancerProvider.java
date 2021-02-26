package p011io.grpc;

import com.google.common.base.MoreObjects;
import java.util.Map;
import p011io.grpc.LoadBalancer;
import p011io.grpc.NameResolver;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* renamed from: io.grpc.LoadBalancerProvider */
public abstract class LoadBalancerProvider extends LoadBalancer.Factory {
    private static final NameResolver.ConfigOrError UNKNOWN_CONFIG = NameResolver.ConfigOrError.fromConfig(new UnknownConfig());

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public abstract String getPolicyName();

    public abstract int getPriority();

    public abstract boolean isAvailable();

    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> map) {
        return UNKNOWN_CONFIG;
    }

    public final String toString() {
        return MoreObjects.toStringHelper((Object) this).add("policy", (Object) getPolicyName()).add("priority", getPriority()).add("available", isAvailable()).toString();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* renamed from: io.grpc.LoadBalancerProvider$UnknownConfig */
    private static final class UnknownConfig {
        public String toString() {
            return "service config is unused";
        }

        UnknownConfig() {
        }
    }
}
