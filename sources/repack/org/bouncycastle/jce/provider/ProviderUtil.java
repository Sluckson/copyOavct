package repack.org.bouncycastle.jce.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;
import repack.org.bouncycastle.jce.ProviderConfigurationPermission;
import repack.org.bouncycastle.jce.interfaces.ConfigurableProvider;
import repack.org.bouncycastle.jce.spec.ECParameterSpec;

public class ProviderUtil {
    private static Permission BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);
    private static Permission BC_EC_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.EC_IMPLICITLY_CA);
    private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();
    private static volatile ECParameterSpec ecImplicitCaParams;
    private static ThreadLocal threadSpec = new ThreadLocal();

    static void setParameter(String str, Object obj) {
        SecurityManager securityManager = System.getSecurityManager();
        if (str.equals(ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_LOCAL_PERMISSION);
            }
            threadSpec.set((ECParameterSpec) obj);
        } else if (str.equals(ConfigurableProvider.EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_PERMISSION);
            }
            ecImplicitCaParams = (ECParameterSpec) obj;
        }
    }

    public static ECParameterSpec getEcImplicitlyCa() {
        ECParameterSpec eCParameterSpec = (ECParameterSpec) threadSpec.get();
        if (eCParameterSpec != null) {
            return eCParameterSpec;
        }
        return ecImplicitCaParams;
    }

    static int getReadLimit(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            return inputStream.available();
        }
        long j = MAX_MEMORY;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }
}
