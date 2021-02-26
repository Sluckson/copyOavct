package repack.org.bouncycastle.util.p072io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: repack.org.bouncycastle.util.io.pem.PemObject */
public class PemObject implements PemObjectGenerator {
    private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    private byte[] content;
    private List headers;
    private String type;

    public PemObject generate() throws PemGenerationException {
        return this;
    }

    public PemObject(String str, byte[] bArr) {
        this(str, EMPTY_LIST, bArr);
    }

    public PemObject(String str, List list, byte[] bArr) {
        this.type = str;
        this.headers = Collections.unmodifiableList(list);
        this.content = bArr;
    }

    public String getType() {
        return this.type;
    }

    public List getHeaders() {
        return this.headers;
    }

    public byte[] getContent() {
        return this.content;
    }
}
