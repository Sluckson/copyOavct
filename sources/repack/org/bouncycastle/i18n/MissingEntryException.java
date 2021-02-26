package repack.org.bouncycastle.i18n;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class MissingEntryException extends RuntimeException {
    private String debugMsg;
    protected final String key;
    protected final ClassLoader loader;
    protected final Locale locale;
    protected final String resource;

    public MissingEntryException(String str, String str2, String str3, Locale locale2, ClassLoader classLoader) {
        super(str);
        this.resource = str2;
        this.key = str3;
        this.locale = locale2;
        this.loader = classLoader;
    }

    public MissingEntryException(String str, Throwable th, String str2, String str3, Locale locale2, ClassLoader classLoader) {
        super(str, th);
        this.resource = str2;
        this.key = str3;
        this.locale = locale2;
        this.loader = classLoader;
    }

    public String getKey() {
        return this.key;
    }

    public String getResource() {
        return this.resource;
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getDebugMsg() {
        if (this.debugMsg == null) {
            this.debugMsg = "Can not find entry " + this.key + " in resource file " + this.resource + " for the locale " + this.locale + ".";
            ClassLoader classLoader = this.loader;
            if (classLoader instanceof URLClassLoader) {
                URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
                this.debugMsg = String.valueOf(this.debugMsg) + " The following entries in the classpath were searched: ";
                for (int i = 0; i != uRLs.length; i++) {
                    this.debugMsg = String.valueOf(this.debugMsg) + uRLs[i] + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                }
            }
        }
        return this.debugMsg;
    }
}
