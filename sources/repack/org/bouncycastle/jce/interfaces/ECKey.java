package repack.org.bouncycastle.jce.interfaces;

import repack.org.bouncycastle.jce.spec.ECParameterSpec;

public interface ECKey {
    ECParameterSpec getParameters();

    ECParameterSpec getParams();
}
