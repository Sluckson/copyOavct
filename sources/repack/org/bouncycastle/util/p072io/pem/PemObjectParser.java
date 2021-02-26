package repack.org.bouncycastle.util.p072io.pem;

import java.io.IOException;

/* renamed from: repack.org.bouncycastle.util.io.pem.PemObjectParser */
public interface PemObjectParser {
    Object parseObject(PemObject pemObject) throws IOException;
}
