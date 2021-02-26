package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.client.utils.DateUtils;

/* renamed from: cz.msebera.android.httpclient.impl.client.cache.WarningValue */
class WarningValue {
    private static final String ASCTIME_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}";
    private static final String DATE1 = "\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}";
    private static final String DATE2 = "\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}";
    private static final String DATE3 = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d";
    private static final String DOMAINLABEL = "\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String HOST = "((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+)";
    private static final String HOSTNAME = "(\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?";
    private static final String HOSTPORT = "(((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+))(\\:\\d*)?";
    private static final Pattern HOSTPORT_PATTERN = Pattern.compile(HOSTPORT);
    private static final String HTTP_DATE = "((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4})";
    private static final String IPV4ADDRESS = "\\d+\\.\\d+\\.\\d+\\.\\d+";
    private static final String MONTH = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
    private static final String PORT = "\\d*";
    private static final String RFC1123_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String RFC850_DATE = "(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String TIME = "\\d{2}:\\d{2}:\\d{2}";
    private static final String TOPLABEL = "\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String WARN_DATE = "\"(((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}))\"";
    private static final Pattern WARN_DATE_PATTERN = Pattern.compile(WARN_DATE);
    private static final String WEEKDAY = "Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday";
    private static final String WKDAY = "Mon|Tue|Wed|Thu|Fri|Sat|Sun";
    private int init_offs;
    private int offs;
    private final String src;
    private String warnAgent;
    private int warnCode;
    private Date warnDate;
    private String warnText;

    private boolean isChar(char c) {
        return c >= 0 && c <= 127;
    }

    private boolean isControl(char c) {
        return c == 127 || (c >= 0 && c <= 31);
    }

    private boolean isSeparator(char c) {
        return c == '(' || c == ')' || c == '<' || c == '>' || c == '@' || c == ',' || c == ';' || c == ':' || c == '\\' || c == '\"' || c == '/' || c == '[' || c == ']' || c == '?' || c == '=' || c == '{' || c == '}' || c == ' ' || c == 9;
    }

    WarningValue(String str) {
        this(str, 0);
    }

    WarningValue(String str, int i) {
        this.init_offs = i;
        this.offs = i;
        this.src = str;
        consumeWarnValue();
    }

    public static WarningValue[] getWarningValues(Header header) {
        ArrayList arrayList = new ArrayList();
        String value = header.getValue();
        int i = 0;
        while (i < value.length()) {
            try {
                WarningValue warningValue = new WarningValue(value, i);
                arrayList.add(warningValue);
                i = warningValue.offs;
            } catch (IllegalArgumentException unused) {
                int indexOf = value.indexOf(44, i);
                if (indexOf == -1) {
                    break;
                }
                i = indexOf + 1;
            }
        }
        return (WarningValue[]) arrayList.toArray(new WarningValue[0]);
    }

    /* access modifiers changed from: protected */
    public void consumeLinearWhitespace() {
        while (this.offs < this.src.length()) {
            char charAt = this.src.charAt(this.offs);
            if (charAt != 9) {
                if (charAt != 13) {
                    if (charAt != ' ') {
                        return;
                    }
                } else if (this.offs + 2 < this.src.length() && this.src.charAt(this.offs + 1) == 10) {
                    if (this.src.charAt(this.offs + 2) == ' ' || this.src.charAt(this.offs + 2) == 9) {
                        this.offs += 2;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.offs++;
        }
    }

    /* access modifiers changed from: protected */
    public void consumeToken() {
        if (!isTokenChar(this.src.charAt(this.offs))) {
            parseError();
        }
        while (this.offs < this.src.length() && isTokenChar(this.src.charAt(this.offs))) {
            this.offs++;
        }
    }

    private boolean isTokenChar(char c) {
        return isChar(c) && !isControl(c) && !isSeparator(c);
    }

    /* access modifiers changed from: protected */
    public void consumeHostPort() {
        Matcher matcher = HOSTPORT_PATTERN.matcher(this.src.substring(this.offs));
        if (!matcher.find()) {
            parseError();
        }
        if (matcher.start() != 0) {
            parseError();
        }
        this.offs += matcher.end();
    }

    /* access modifiers changed from: protected */
    public void consumeWarnAgent() {
        int i = this.offs;
        try {
            consumeHostPort();
            this.warnAgent = this.src.substring(i, this.offs);
            consumeCharacter(' ');
        } catch (IllegalArgumentException unused) {
            this.offs = i;
            consumeToken();
            this.warnAgent = this.src.substring(i, this.offs);
            consumeCharacter(' ');
        }
    }

    /* access modifiers changed from: protected */
    public void consumeQuotedString() {
        if (this.src.charAt(this.offs) != '\"') {
            parseError();
        }
        this.offs++;
        boolean z = false;
        while (this.offs < this.src.length() && !z) {
            char charAt = this.src.charAt(this.offs);
            if (this.offs + 1 < this.src.length() && charAt == '\\' && isChar(this.src.charAt(this.offs + 1))) {
                this.offs += 2;
            } else if (charAt == '\"') {
                this.offs++;
                z = true;
            } else if (charAt == '\"' || isControl(charAt)) {
                parseError();
            } else {
                this.offs++;
            }
        }
        if (!z) {
            parseError();
        }
    }

    /* access modifiers changed from: protected */
    public void consumeWarnText() {
        int i = this.offs;
        consumeQuotedString();
        this.warnText = this.src.substring(i, this.offs);
    }

    /* access modifiers changed from: protected */
    public void consumeWarnDate() {
        int i = this.offs;
        Matcher matcher = WARN_DATE_PATTERN.matcher(this.src.substring(i));
        if (!matcher.lookingAt()) {
            parseError();
        }
        this.offs += matcher.end();
        this.warnDate = DateUtils.parseDate(this.src.substring(i + 1, this.offs - 1));
    }

    /* access modifiers changed from: protected */
    public void consumeWarnValue() {
        consumeLinearWhitespace();
        consumeWarnCode();
        consumeWarnAgent();
        consumeWarnText();
        if (this.offs + 1 < this.src.length() && this.src.charAt(this.offs) == ' ' && this.src.charAt(this.offs + 1) == '\"') {
            consumeCharacter(' ');
            consumeWarnDate();
        }
        consumeLinearWhitespace();
        if (this.offs != this.src.length()) {
            consumeCharacter(',');
        }
    }

    /* access modifiers changed from: protected */
    public void consumeCharacter(char c) {
        if (this.offs + 1 > this.src.length() || c != this.src.charAt(this.offs)) {
            parseError();
        }
        this.offs++;
    }

    /* access modifiers changed from: protected */
    public void consumeWarnCode() {
        if (this.offs + 4 > this.src.length() || !Character.isDigit(this.src.charAt(this.offs)) || !Character.isDigit(this.src.charAt(this.offs + 1)) || !Character.isDigit(this.src.charAt(this.offs + 2)) || this.src.charAt(this.offs + 3) != ' ') {
            parseError();
        }
        String str = this.src;
        int i = this.offs;
        this.warnCode = Integer.parseInt(str.substring(i, i + 3));
        this.offs += 4;
    }

    private void parseError() {
        String substring = this.src.substring(this.init_offs);
        throw new IllegalArgumentException("Bad warn code \"" + substring + "\"");
    }

    public int getWarnCode() {
        return this.warnCode;
    }

    public String getWarnAgent() {
        return this.warnAgent;
    }

    public String getWarnText() {
        return this.warnText;
    }

    public Date getWarnDate() {
        return this.warnDate;
    }

    public String toString() {
        if (this.warnDate != null) {
            return String.format("%d %s %s \"%s\"", new Object[]{Integer.valueOf(this.warnCode), this.warnAgent, this.warnText, DateUtils.formatDate(this.warnDate)});
        }
        return String.format("%d %s %s", new Object[]{Integer.valueOf(this.warnCode), this.warnAgent, this.warnText});
    }
}
