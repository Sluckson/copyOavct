package p052cz.msebera.android.httpclient.impl.auth;

import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.InvalidCredentialsException;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.auth.NTCredentials;
import p052cz.msebera.android.httpclient.message.BufferedHeader;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.auth.NTLMScheme */
public class NTLMScheme extends AuthSchemeBase {
    private String challenge;
    private final NTLMEngine engine;
    private State state;

    /* renamed from: cz.msebera.android.httpclient.impl.auth.NTLMScheme$State */
    enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED
    }

    public String getParameter(String str) {
        return null;
    }

    public String getRealm() {
        return null;
    }

    public String getSchemeName() {
        return "ntlm";
    }

    public boolean isConnectionBased() {
        return true;
    }

    public NTLMScheme(NTLMEngine nTLMEngine) {
        Args.notNull(nTLMEngine, "NTLM engine");
        this.engine = nTLMEngine;
        this.state = State.UNINITIATED;
        this.challenge = null;
    }

    public NTLMScheme() {
        this(new NTLMEngineImpl());
    }

    /* access modifiers changed from: protected */
    public void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException {
        this.challenge = charArrayBuffer.substringTrimmed(i, i2);
        if (this.challenge.length() == 0) {
            if (this.state == State.UNINITIATED) {
                this.state = State.CHALLENGE_RECEIVED;
            } else {
                this.state = State.FAILED;
            }
        } else if (this.state.compareTo(State.MSG_TYPE1_GENERATED) < 0) {
            this.state = State.FAILED;
            throw new MalformedChallengeException("Out of sequence NTLM response message");
        } else if (this.state == State.MSG_TYPE1_GENERATED) {
            this.state = State.MSG_TYPE2_RECEVIED;
        }
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String str;
        try {
            NTCredentials nTCredentials = (NTCredentials) credentials;
            if (this.state != State.FAILED) {
                if (this.state == State.CHALLENGE_RECEIVED) {
                    str = this.engine.generateType1Msg(nTCredentials.getDomain(), nTCredentials.getWorkstation());
                    this.state = State.MSG_TYPE1_GENERATED;
                } else if (this.state == State.MSG_TYPE2_RECEVIED) {
                    str = this.engine.generateType3Msg(nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getDomain(), nTCredentials.getWorkstation(), this.challenge);
                    this.state = State.MSG_TYPE3_GENERATED;
                } else {
                    throw new AuthenticationException("Unexpected state: " + this.state);
                }
                CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
                if (isProxy()) {
                    charArrayBuffer.append("Proxy-Authorization");
                } else {
                    charArrayBuffer.append("Authorization");
                }
                charArrayBuffer.append(": NTLM ");
                charArrayBuffer.append(str);
                return new BufferedHeader(charArrayBuffer);
            }
            throw new AuthenticationException("NTLM authentication failed");
        } catch (ClassCastException unused) {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + credentials.getClass().getName());
        }
    }

    public boolean isComplete() {
        return this.state == State.MSG_TYPE3_GENERATED || this.state == State.FAILED;
    }
}
