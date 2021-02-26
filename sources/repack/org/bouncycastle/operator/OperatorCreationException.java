package repack.org.bouncycastle.operator;

public class OperatorCreationException extends OperatorException {
    public OperatorCreationException(String str, Throwable th) {
        super(str, th);
    }

    public OperatorCreationException(String str) {
        super(str);
    }
}
