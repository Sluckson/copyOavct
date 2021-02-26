package com.google.firebase.inappmessaging;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class ClientAppInfo extends GeneratedMessageLite<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final ClientAppInfo DEFAULT_INSTANCE = new ClientAppInfo();
    public static final int FIREBASE_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ClientAppInfo> PARSER;
    private int bitField0_;
    private String firebaseInstanceId_ = "";
    private String googleAppId_ = "";

    private ClientAppInfo() {
    }

    public boolean hasGoogleAppId() {
        return (this.bitField0_ & 1) == 1;
    }

    public String getGoogleAppId() {
        return this.googleAppId_;
    }

    public ByteString getGoogleAppIdBytes() {
        return ByteString.copyFromUtf8(this.googleAppId_);
    }

    /* access modifiers changed from: private */
    public void setGoogleAppId(String str) {
        if (str != null) {
            this.bitField0_ |= 1;
            this.googleAppId_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearGoogleAppId() {
        this.bitField0_ &= -2;
        this.googleAppId_ = getDefaultInstance().getGoogleAppId();
    }

    /* access modifiers changed from: private */
    public void setGoogleAppIdBytes(ByteString byteString) {
        if (byteString != null) {
            this.bitField0_ |= 1;
            this.googleAppId_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public boolean hasFirebaseInstanceId() {
        return (this.bitField0_ & 2) == 2;
    }

    public String getFirebaseInstanceId() {
        return this.firebaseInstanceId_;
    }

    public ByteString getFirebaseInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.firebaseInstanceId_);
    }

    /* access modifiers changed from: private */
    public void setFirebaseInstanceId(String str) {
        if (str != null) {
            this.bitField0_ |= 2;
            this.firebaseInstanceId_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearFirebaseInstanceId() {
        this.bitField0_ &= -3;
        this.firebaseInstanceId_ = getDefaultInstance().getFirebaseInstanceId();
    }

    /* access modifiers changed from: private */
    public void setFirebaseInstanceIdBytes(ByteString byteString) {
        if (byteString != null) {
            this.bitField0_ |= 2;
            this.firebaseInstanceId_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeString(1, getGoogleAppId());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeString(2, getFirebaseInstanceId());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            i2 = 0 + CodedOutputStream.computeStringSize(1, getGoogleAppId());
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeStringSize(2, getFirebaseInstanceId());
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = serializedSize;
        return serializedSize;
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

    public static final class Builder extends GeneratedMessageLite.Builder<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
        private Builder() {
            super(ClientAppInfo.DEFAULT_INSTANCE);
        }

        public boolean hasGoogleAppId() {
            return ((ClientAppInfo) this.instance).hasGoogleAppId();
        }

        public String getGoogleAppId() {
            return ((ClientAppInfo) this.instance).getGoogleAppId();
        }

        public ByteString getGoogleAppIdBytes() {
            return ((ClientAppInfo) this.instance).getGoogleAppIdBytes();
        }

        public Builder setGoogleAppId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGoogleAppId(str);
            return this;
        }

        public Builder clearGoogleAppId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearGoogleAppId();
            return this;
        }

        public Builder setGoogleAppIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGoogleAppIdBytes(byteString);
            return this;
        }

        public boolean hasFirebaseInstanceId() {
            return ((ClientAppInfo) this.instance).hasFirebaseInstanceId();
        }

        public String getFirebaseInstanceId() {
            return ((ClientAppInfo) this.instance).getFirebaseInstanceId();
        }

        public ByteString getFirebaseInstanceIdBytes() {
            return ((ClientAppInfo) this.instance).getFirebaseInstanceIdBytes();
        }

        public Builder setFirebaseInstanceId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setFirebaseInstanceId(str);
            return this;
        }

        public Builder clearFirebaseInstanceId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearFirebaseInstanceId();
            return this;
        }

        public Builder setFirebaseInstanceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setFirebaseInstanceIdBytes(byteString);
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
                this.googleAppId_ = visitor.visitString(hasGoogleAppId(), this.googleAppId_, clientAppInfo.hasGoogleAppId(), clientAppInfo.googleAppId_);
                this.firebaseInstanceId_ = visitor.visitString(hasFirebaseInstanceId(), this.firebaseInstanceId_, clientAppInfo.hasFirebaseInstanceId(), clientAppInfo.firebaseInstanceId_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= clientAppInfo.bitField0_;
                }
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
                                String readString = codedInputStream.readString();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.googleAppId_ = readString;
                            } else if (readTag == 18) {
                                String readString2 = codedInputStream.readString();
                                this.bitField0_ |= 2;
                                this.firebaseInstanceId_ = readString2;
                            } else if (!parseUnknownField(readTag, codedInputStream)) {
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
