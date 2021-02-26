package com.google.internal.firebase.inappmessaging.p014v1.sdkserving;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo */
public final class ClientAppInfo extends GeneratedMessageLite<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int APP_INSTANCE_ID_TOKEN_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final ClientAppInfo DEFAULT_INSTANCE = new ClientAppInfo();
    public static final int GMP_APP_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ClientAppInfo> PARSER;
    private String appInstanceIdToken_ = "";
    private String appInstanceId_ = "";
    private String gmpAppId_ = "";

    private ClientAppInfo() {
    }

    public String getGmpAppId() {
        return this.gmpAppId_;
    }

    public ByteString getGmpAppIdBytes() {
        return ByteString.copyFromUtf8(this.gmpAppId_);
    }

    /* access modifiers changed from: private */
    public void setGmpAppId(String str) {
        if (str != null) {
            this.gmpAppId_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearGmpAppId() {
        this.gmpAppId_ = getDefaultInstance().getGmpAppId();
    }

    /* access modifiers changed from: private */
    public void setGmpAppIdBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.gmpAppId_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getAppInstanceId() {
        return this.appInstanceId_;
    }

    public ByteString getAppInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.appInstanceId_);
    }

    /* access modifiers changed from: private */
    public void setAppInstanceId(String str) {
        if (str != null) {
            this.appInstanceId_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearAppInstanceId() {
        this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
    }

    /* access modifiers changed from: private */
    public void setAppInstanceIdBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.appInstanceId_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public String getAppInstanceIdToken() {
        return this.appInstanceIdToken_;
    }

    public ByteString getAppInstanceIdTokenBytes() {
        return ByteString.copyFromUtf8(this.appInstanceIdToken_);
    }

    /* access modifiers changed from: private */
    public void setAppInstanceIdToken(String str) {
        if (str != null) {
            this.appInstanceIdToken_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearAppInstanceIdToken() {
        this.appInstanceIdToken_ = getDefaultInstance().getAppInstanceIdToken();
    }

    /* access modifiers changed from: private */
    public void setAppInstanceIdTokenBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.appInstanceIdToken_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.gmpAppId_.isEmpty()) {
            codedOutputStream.writeString(1, getGmpAppId());
        }
        if (!this.appInstanceId_.isEmpty()) {
            codedOutputStream.writeString(2, getAppInstanceId());
        }
        if (!this.appInstanceIdToken_.isEmpty()) {
            codedOutputStream.writeString(3, getAppInstanceIdToken());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.gmpAppId_.isEmpty()) {
            i2 = 0 + CodedOutputStream.computeStringSize(1, getGmpAppId());
        }
        if (!this.appInstanceId_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(2, getAppInstanceId());
        }
        if (!this.appInstanceIdToken_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(3, getAppInstanceIdToken());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static ClientAppInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientAppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientAppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(InputStream inputStream) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAppInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ClientAppInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAppInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientAppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ClientAppInfo clientAppInfo) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(clientAppInfo);
    }

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo$Builder */
    public static final class Builder extends GeneratedMessageLite.Builder<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
        private Builder() {
            super(ClientAppInfo.DEFAULT_INSTANCE);
        }

        public String getGmpAppId() {
            return ((ClientAppInfo) this.instance).getGmpAppId();
        }

        public ByteString getGmpAppIdBytes() {
            return ((ClientAppInfo) this.instance).getGmpAppIdBytes();
        }

        public Builder setGmpAppId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGmpAppId(str);
            return this;
        }

        public Builder clearGmpAppId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearGmpAppId();
            return this;
        }

        public Builder setGmpAppIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGmpAppIdBytes(byteString);
            return this;
        }

        public String getAppInstanceId() {
            return ((ClientAppInfo) this.instance).getAppInstanceId();
        }

        public ByteString getAppInstanceIdBytes() {
            return ((ClientAppInfo) this.instance).getAppInstanceIdBytes();
        }

        public Builder setAppInstanceId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceId(str);
            return this;
        }

        public Builder clearAppInstanceId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearAppInstanceId();
            return this;
        }

        public Builder setAppInstanceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceIdBytes(byteString);
            return this;
        }

        public String getAppInstanceIdToken() {
            return ((ClientAppInfo) this.instance).getAppInstanceIdToken();
        }

        public ByteString getAppInstanceIdTokenBytes() {
            return ((ClientAppInfo) this.instance).getAppInstanceIdTokenBytes();
        }

        public Builder setAppInstanceIdToken(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceIdToken(str);
            return this;
        }

        public Builder clearAppInstanceIdToken() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearAppInstanceIdToken();
            return this;
        }

        public Builder setAppInstanceIdTokenBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceIdTokenBytes(byteString);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new ClientAppInfo();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ClientAppInfo clientAppInfo = (ClientAppInfo) obj2;
                this.gmpAppId_ = visitor.visitString(!this.gmpAppId_.isEmpty(), this.gmpAppId_, !clientAppInfo.gmpAppId_.isEmpty(), clientAppInfo.gmpAppId_);
                this.appInstanceId_ = visitor.visitString(!this.appInstanceId_.isEmpty(), this.appInstanceId_, !clientAppInfo.appInstanceId_.isEmpty(), clientAppInfo.appInstanceId_);
                this.appInstanceIdToken_ = visitor.visitString(!this.appInstanceIdToken_.isEmpty(), this.appInstanceIdToken_, true ^ clientAppInfo.appInstanceIdToken_.isEmpty(), clientAppInfo.appInstanceIdToken_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.gmpAppId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.appInstanceId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.appInstanceIdToken_ = codedInputStream.readStringRequireUtf8();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case GET_DEFAULT_INSTANCE:
                break;
            case GET_PARSER:
                if (PARSER == null) {
                    synchronized (ClientAppInfo.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    public static ClientAppInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ClientAppInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
