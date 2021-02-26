package com.wowza.gocoder.sdk.support.wse.jni.wmstransport;

import com.wowza.gocoder.sdk.api.data.WOWZDataEvent;
import com.wowza.gocoder.sdk.api.data.WOWZDataList;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI;

/* compiled from: GoCoderSDK */
public final class WMSTransport {
    public static final int PUSHPUBLISHSESSIONWOWZ_CHANNELCOUNT = 40;
    public static final int PUSHPUBLISHSESSIONWOWZ_CONFIRM_BYTESRECEIVED = 625500;
    public static final int PUSHPUBLISHSESSIONWOWZ_DEFAULTINPUTBUFFERSIZE = 65000;
    public static final int PUSHPUBLISHSESSIONWOWZ_HANDSHAKESIZE_CLIENT0 = 1537;
    public static final int PUSHPUBLISHSESSIONWOWZ_HANDSHAKESIZE_CLIENT1 = 1536;
    public static final int PUSHPUBLISHSESSIONWOWZ_HANDSHAKESIZE_SERVER0 = 3073;
    public static final int PUSHPUBLISHSESSIONWOWZ_MAXERRORSTR = 1024;
    public static final int PUSHPUBLISHSESSIONWOWZ_MAXSTREAMCOUNT = 12;
    public static final int SESSIONDIRECTION_PLAY = 1;
    public static final int SESSIONDIRECTION_PUBLISH = 0;
    public static final int SESSIONERROR_ALLOCFAILED = 1;
    public static final int SESSIONERROR_CONNECTIONAUTHFAILED = 9;
    public static final int SESSIONERROR_CONNECTIONAUTHWRONGCREDENTIALS = 11;
    public static final int SESSIONERROR_CONNECTIONFAILED = 8;
    public static final int SESSIONERROR_CONNECTIONREJECTED = 10;
    public static final int SESSIONERROR_INVALIDMESSAGETYPE_MEDIA = 4;
    public static final int SESSIONERROR_INVALIDMESSAGETYPE_SHAREDOBJECT = 6;
    public static final int SESSIONERROR_INVALIDMESSAGETYPE_UNKNOWN = 5;
    public static final int SESSIONERROR_INVALIDPROTOCOL = 3;
    public static final int SESSIONERROR_MESSAGEOUTOFORDER = 2;
    public static final int SESSIONERROR_NOERROR = 0;
    public static final int SESSIONERROR_NOTFOUNDRESULT = 7;
    public static final int SESSIONERROR_STREAMCREATECANNOTFINDSTREAM = 13;
    public static final int SESSIONERROR_STREAMCREATEFAILED = 12;
    public static final int SESSIONERROR_STREAMFAILURE = 14;
    public static final int SESSIONLOGLEVEL_DEBUG = 100;
    public static final int SESSIONLOGLEVEL_ERROR = 400;
    public static final int SESSIONLOGLEVEL_INFO = 200;
    public static final int SESSIONLOGLEVEL_VERBOSE = 50;
    public static final int SESSIONLOGLEVEL_WARN = 300;
    public static final int SESSIONPENDINGFUNCTION_CONNECT = 0;
    public static final int SESSIONPENDINGFUNCTION_CREATESTREAM = 1;
    public static final int SESSIONPENDINGFUNCTION_TOTAL = 2;
    public static final int SESSIONSTATE_CLOSED = 999;
    public static final int SESSIONSTATE_CLOSING = 900;
    public static final int SESSIONSTATE_CONNECTED = 299;
    public static final int SESSIONSTATE_CONNECT_AUTH_AUTHFAILED = 202;
    public static final int SESSIONSTATE_CONNECT_AUTH_AUTHREQ = 203;
    public static final int SESSIONSTATE_CONNECT_AUTH_NEEDAUTH = 201;
    public static final int SESSIONSTATE_CONNECT_REDIRECT = 210;
    public static final int SESSIONSTATE_CONNECT_REJECTED = 220;
    public static final int SESSIONSTATE_CONNECT_SENT = 200;
    public static final int SESSIONSTATE_HANDSHAKE_SERVER0_SEND = 100;
    public static final int SESSIONSTATE_HANDSHAKE_SERVER0_SENT = 101;
    public static final int SESSIONSTATE_HANDSHAKE_SERVER1_SEND = 102;
    public static final int SESSIONSTATE_HANDSHAKE_SERVER1_SENT = 103;
    public static final int SESSIONSTATE_PUBLISH_DENIED = 230;
    public static final int STREAMPENDINGFUNCTION_PUBLISH = 0;
    public static final int STREAMPENDINGFUNCTION_TOTAL = 1;
    public static final int STREAMSTATE_PLAY = 400;
    public static final int STREAMSTATE_PLAYFAILED = 401;
    public static final int STREAMSTATE_PLAYSTOP = 402;
    public static final int STREAMSTATE_PUBLISH = 200;
    public static final int STREAMSTATE_PUBLISH_DENIED = 230;
    public static final int STREAMSTATE_START = 100;
    public static final int STREAMSTATE_UNPUBLISH = 300;
    public static final int WZ_LOGLEVEL_DEBUG = 2;
    public static final int WZ_LOGLEVEL_ERROR = 5;
    public static final int WZ_LOGLEVEL_INFO = 3;
    public static final int WZ_LOGLEVEL_VERBOSE = 1;
    public static final int WZ_LOGLEVEL_WARN = 4;
    private FunctionListener mFunctionListener;
    private WOWZDataMap mStreamMetadata;
    private long pushPublishMessageHolderPtr;
    private long pushPublishParserSessionPtr;
    private long pushPublishSessionWOWZPtr;

    /* compiled from: GoCoderSDK */
    public interface FunctionListener {
        void onFunctionCallRequestReceived(String str, WOWZDataMap wOWZDataMap, int i, int i2, int i3);

        void onFunctionCallResultReceived(int i, WOWZDataMap wOWZDataMap, boolean z, int i2, int i3);
    }

    public native int addStream();

    public native int audioGenerateElementary(byte[] bArr, int[] iArr, boolean[] zArr);

    public native int audioSetCodecConfig();

    public native void clearError();

    public native int closeSession(int i);

    public native int closeStream(int i);

    public native void destroySession();

    public native int getAudioCodec();

    public native int getAudioDataOffset();

    public native String getAuthChallenge(int i);

    public native String getAuthOpaque(int i);

    public native String getAuthSalt(int i);

    public native int getInputBufferSize();

    public native byte[] getMessagesToWrite();

    public native int getMessagesToWriteLen();

    public native void getRedirectURL(StringBuffer stringBuffer, int i);

    public native int getSessionError();

    public native String getSessionErrorDescription();

    public native int getSessionState();

    public native long getTotalBytesPending();

    public native long getTotalBytesRead();

    public native long getTotalBytesWritten();

    public native int getVideoCodec();

    public native int getVideoDataOffset();

    public native int getVideoFrameType();

    public native int holderGetBufferLen();

    public native byte[] holderGetBufferPtr();

    public native long holderGetTimecode();

    public native int holderGetType();

    public native int incrementMessageBytesWritten(int i);

    public native boolean isAudioCodecConfig();

    public native boolean isVideoCodecConfig();

    public native boolean isVideoEnhancedSeek(int i);

    public native boolean isVideoKeyFrame();

    public native boolean newSession();

    public native int parseBytes(int i, WOWZPlayerAPI.WZVideoStreamReceiver wZVideoStreamReceiver, WOWZPlayerAPI.WZAudioStreamReceiver wZAudioStreamReceiver);

    public native int parserDone();

    public native int parserInit(int i);

    public native int parserNextMessage();

    public native int prepareSession();

    public native int pushPublishAudioCodecStringToId(String str);

    public native int pushPublishVideoCodecStringToId(String str);

    public native int readParseBytes(int i);

    public native int registerDataEventListener(String str, WOWZDataEvent.EventListener eventListener);

    public native int sendModuleFunctionCall(int i, long j, String str, WOWZDataMap wOWZDataMap, WOWZDataEvent.ResultCallback resultCallback);

    public native int sendModuleFunctionResult(int i, long j, long j2, WOWZDataMap wOWZDataMap, boolean z);

    public native int sendPingRequest(WOWZDataEvent.ResultCallback resultCallback);

    public native int sendStreamDataEvent(int i, long j, String str, WOWZDataMap wOWZDataMap);

    public native void setAuthChallenge(String str);

    public native void setAuthOpaque(String str);

    public native void setAuthPassword(String str);

    public native void setAuthSalt(String str);

    public native void setAuthUserName(String str);

    public native void setConnectionFlashVersion(String str);

    public native void setConnectionURL(String str);

    public native void setDirection(int i);

    public native void setInputBuffer(byte[] bArr, int i);

    public native void setLogLevel(int i);

    public native int streamAddAudioFrame(int i, long j, byte[] bArr, int i2);

    public native int streamAddDataFrame(int i, long j, WOWZDataList wOWZDataList);

    public native int streamAddVideoFrame(int i, long j, long j2, int i2, byte[] bArr, int i3);

    public native int streamGetState(int i);

    public native void streamSetAudioAACObjectType(int i, int i2);

    public native void streamSetAudioChannels(int i, int i2);

    public native void streamSetAudioCodecId(int i, int i2);

    public native void streamSetAudioDataRate(int i, int i2);

    public native void streamSetAudioSampleRate(int i, int i2);

    public native void streamSetOnMetaDataExtra(int i, WOWZDataMap wOWZDataMap);

    public native void streamSetPlayStart(int i, long j);

    public native void streamSetStreamName(int i, String str);

    public native void streamSetVideoAVCLevel(int i, int i2);

    public native void streamSetVideoAVCProfile(int i, int i2);

    public native void streamSetVideoCodecId(int i, int i2);

    public native void streamSetVideoDataRate(int i, int i2);

    public native void streamSetVideoDisplaySize(int i, int i2, int i3);

    public native void streamSetVideoFrameRate(int i, double d);

    public native void streamSetVideoFrameSize(int i, int i2, int i3);

    public native void streamSetVideoNALPPS(int i, byte[] bArr, int i2);

    public native void streamSetVideoNALSPS(int i, byte[] bArr, int i2);

    public native int unregisterDataEventListener(String str, WOWZDataEvent.EventListener eventListener);

    public native int videoGenerateElementary(byte[] bArr, int[] iArr, boolean[] zArr);

    public native int videoSetCodecConfig();

    public WOWZDataMap getStreamMetadata() {
        return this.mStreamMetadata;
    }

    public WMSTransport(FunctionListener functionListener) {
        this.mFunctionListener = functionListener;
    }
}
