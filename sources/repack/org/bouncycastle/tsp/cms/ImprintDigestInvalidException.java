package repack.org.bouncycastle.tsp.cms;

import repack.org.bouncycastle.tsp.TimeStampToken;

public class ImprintDigestInvalidException extends Exception {
    private TimeStampToken token;

    public ImprintDigestInvalidException(String str, TimeStampToken timeStampToken) {
        super(str);
        this.token = timeStampToken;
    }

    public TimeStampToken getTimeStampToken() {
        return this.token;
    }
}
