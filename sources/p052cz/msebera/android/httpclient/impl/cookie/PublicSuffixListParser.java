package p052cz.msebera.android.httpclient.impl.cookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.PublicSuffixListParser */
public class PublicSuffixListParser {
    private static final int MAX_LINE_LEN = 256;
    private final PublicSuffixFilter filter;

    PublicSuffixListParser(PublicSuffixFilter publicSuffixFilter) {
        this.filter = publicSuffixFilter;
    }

    public void parse(Reader reader) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder(256);
        boolean z = true;
        while (z) {
            z = readLine(bufferedReader, sb);
            String sb2 = sb.toString();
            if (sb2.length() != 0 && !sb2.startsWith("//")) {
                if (sb2.startsWith(".")) {
                    sb2 = sb2.substring(1);
                }
                boolean startsWith = sb2.startsWith("!");
                if (startsWith) {
                    sb2 = sb2.substring(1);
                }
                if (startsWith) {
                    arrayList2.add(sb2);
                } else {
                    arrayList.add(sb2);
                }
            }
        }
        this.filter.setPublicSuffixes(arrayList);
        this.filter.setExceptions(arrayList2);
    }

    private boolean readLine(Reader reader, StringBuilder sb) throws IOException {
        char c;
        sb.setLength(0);
        boolean z = false;
        do {
            int read = reader.read();
            if (read != -1 && (c = (char) read) != 10) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                if (!z) {
                    sb.append(c);
                }
            } else if (read != -1) {
                return true;
            } else {
                return false;
            }
        } while (sb.length() <= 256);
        throw new IOException("Line too long");
    }
}
