package repack.org.bouncycastle.util.test;

public class SimpleTestResult implements TestResult {
    private static final String SEPARATOR = System.getProperty("line.separator");
    private Throwable exception;
    private String message;
    private boolean success;

    public SimpleTestResult(boolean z, String str) {
        this.success = z;
        this.message = str;
    }

    public SimpleTestResult(boolean z, String str, Throwable th) {
        this.success = z;
        this.message = str;
        this.exception = th;
    }

    public static TestResult successful(Test test, String str) {
        return new SimpleTestResult(true, String.valueOf(test.getName()) + ": " + str);
    }

    public static TestResult failed(Test test, String str) {
        return new SimpleTestResult(false, String.valueOf(test.getName()) + ": " + str);
    }

    public static TestResult failed(Test test, String str, Throwable th) {
        return new SimpleTestResult(false, String.valueOf(test.getName()) + ": " + str, th);
    }

    public static TestResult failed(Test test, String str, Object obj, Object obj2) {
        return failed(test, String.valueOf(str) + SEPARATOR + "Expected: " + obj + SEPARATOR + "Found   : " + obj2);
    }

    public static String failedMessage(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(" failing ");
        stringBuffer.append(str2);
        stringBuffer.append(SEPARATOR);
        stringBuffer.append("    expected: ");
        stringBuffer.append(str3);
        stringBuffer.append(SEPARATOR);
        stringBuffer.append("    got     : ");
        stringBuffer.append(str4);
        return stringBuffer.toString();
    }

    public boolean isSuccessful() {
        return this.success;
    }

    public String toString() {
        return this.message;
    }

    public Throwable getException() {
        return this.exception;
    }
}
