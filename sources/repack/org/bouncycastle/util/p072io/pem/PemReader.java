package repack.org.bouncycastle.util.p072io.pem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import repack.org.bouncycastle.util.encoders.Base64;

/* renamed from: repack.org.bouncycastle.util.io.pem.PemReader */
public class PemReader extends BufferedReader {
    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";

    public PemReader(Reader reader) {
        super(reader);
    }

    public PemObject readPemObject() throws IOException {
        String readLine = readLine();
        if (readLine == null || !readLine.startsWith(BEGIN)) {
            return null;
        }
        String substring = readLine.substring(11);
        int indexOf = substring.indexOf(45);
        String substring2 = substring.substring(0, indexOf);
        if (indexOf > 0) {
            return loadObject(substring2);
        }
        return null;
    }

    private PemObject loadObject(String str) throws IOException {
        String readLine;
        String str2 = END + str;
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = readLine();
            if (readLine == null) {
                break;
            } else if (readLine.indexOf(":") >= 0) {
                int indexOf = readLine.indexOf(58);
                arrayList.add(new PemHeader(readLine.substring(0, indexOf), readLine.substring(indexOf + 1).trim()));
            } else if (readLine.indexOf(str2) != -1) {
                break;
            } else {
                stringBuffer.append(readLine.trim());
            }
        }
        if (readLine != null) {
            return new PemObject(str, arrayList, Base64.decode(stringBuffer.toString()));
        }
        throw new IOException(String.valueOf(str2) + " not found");
    }
}
