package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.ArrayList;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.ParseException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.message.BasicHeaderElement;
import p052cz.msebera.android.httpclient.message.BasicNameValuePair;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.NetscapeDraftHeaderParser */
public class NetscapeDraftHeaderParser {
    public static final NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();

    public HeaderElement parseHeader(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair parseNameValuePair = parseNameValuePair(charArrayBuffer, parserCursor);
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(parseNameValuePair(charArrayBuffer, parserCursor));
        }
        return new BasicHeaderElement(parseNameValuePair.getName(), parseNameValuePair.getValue(), (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]));
    }

    private NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        boolean z;
        boolean z2;
        String str;
        char charAt;
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (true) {
            z = true;
            if (pos >= upperBound || (charAt = charArrayBuffer.charAt(pos)) == '=') {
                z2 = false;
            } else if (charAt == ';') {
                z2 = true;
                break;
            } else {
                pos++;
            }
        }
        z2 = false;
        if (pos == upperBound) {
            str = charArrayBuffer.substringTrimmed(pos2, upperBound);
            z2 = true;
        } else {
            str = charArrayBuffer.substringTrimmed(pos2, pos);
            pos++;
        }
        if (z2) {
            parserCursor.updatePos(pos);
            return new BasicNameValuePair(str, (String) null);
        }
        int i = pos;
        while (true) {
            if (i >= upperBound) {
                z = z2;
                break;
            } else if (charArrayBuffer.charAt(i) == ';') {
                break;
            } else {
                i++;
            }
        }
        while (pos < i && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        int i2 = i;
        while (i2 > pos && HTTP.isWhitespace(charArrayBuffer.charAt(i2 - 1))) {
            i2--;
        }
        String substring = charArrayBuffer.substring(pos, i2);
        if (z) {
            i++;
        }
        parserCursor.updatePos(i);
        return new BasicNameValuePair(str, substring);
    }
}
