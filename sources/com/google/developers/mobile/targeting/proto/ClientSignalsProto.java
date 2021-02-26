package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class ClientSignalsProto {

    public interface AppInstanceClaimOrBuilder extends MessageLiteOrBuilder {
        String getAppInstanceId();

        ByteString getAppInstanceIdBytes();

        String getAppInstanceToken();

        ByteString getAppInstanceTokenBytes();

        String getGmpAppId();

        ByteString getGmpAppIdBytes();
    }

    public interface ClientSignalsOrBuilder extends MessageLiteOrBuilder {
        String getAppVersion();

        ByteString getAppVersionBytes();

        String getLanguageCode();

        ByteString getLanguageCodeBytes();

        String getPlatformVersion();

        ByteString getPlatformVersionBytes();

        String getTimeZone();

        ByteString getTimeZoneBytes();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ClientSignalsProto() {
    }

    public static final class ClientSignals extends GeneratedMessageLite<ClientSignals, Builder> implements ClientSignalsOrBuilder {
        public static final int APP_VERSION_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final ClientSignals DEFAULT_INSTANCE = new ClientSignals();
        public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
        private static volatile Parser<ClientSignals> PARSER = null;
        public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 4;
        private String appVersion_ = "";
        private String languageCode_ = "";
        private String platformVersion_ = "";
        private String timeZone_ = "";

        private ClientSignals() {
        }

        public String getAppVersion() {
            return this.appVersion_;
        }

        public ByteString getAppVersionBytes() {
            return ByteString.copyFromUtf8(this.appVersion_);
        }

        /* access modifiers changed from: private */
        public void setAppVersion(String str) {
            if (str != null) {
                this.appVersion_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearAppVersion() {
            this.appVersion_ = getDefaultInstance().getAppVersion();
        }

        /* access modifiers changed from: private */
        public void setAppVersionBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.appVersion_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public String getPlatformVersion() {
            return this.platformVersion_;
        }

        public ByteString getPlatformVersionBytes() {
            return ByteString.copyFromUtf8(this.platformVersion_);
        }

        /* access modifiers changed from: private */
        public void setPlatformVersion(String str) {
            if (str != null) {
                this.platformVersion_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearPlatformVersion() {
            this.platformVersion_ = getDefaultInstance().getPlatformVersion();
        }

        /* access modifiers changed from: private */
        public void setPlatformVersionBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.platformVersion_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public String getLanguageCode() {
            return this.languageCode_;
        }

        public ByteString getLanguageCodeBytes() {
            return ByteString.copyFromUtf8(this.languageCode_);
        }

        /* access modifiers changed from: private */
        public void setLanguageCode(String str) {
            if (str != null) {
                this.languageCode_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearLanguageCode() {
            this.languageCode_ = getDefaultInstance().getLanguageCode();
        }

        /* access modifiers changed from: private */
        public void setLanguageCodeBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.languageCode_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public String getTimeZone() {
            return this.timeZone_;
        }

        public ByteString getTimeZoneBytes() {
            return ByteString.copyFromUtf8(this.timeZone_);
        }

        /* access modifiers changed from: private */
        public void setTimeZone(String str) {
            if (str != null) {
                this.timeZone_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearTimeZone() {
            this.timeZone_ = getDefaultInstance().getTimeZone();
        }

        /* access modifiers changed from: private */
        public void setTimeZoneBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.timeZone_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.appVersion_.isEmpty()) {
                codedOutputStream.writeString(1, getAppVersion());
            }
            if (!this.platformVersion_.isEmpty()) {
                codedOutputStream.writeString(2, getPlatformVersion());
            }
            if (!this.languageCode_.isEmpty()) {
                codedOutputStream.writeString(3, getLanguageCode());
            }
            if (!this.timeZone_.isEmpty()) {
                codedOutputStream.writeString(4, getTimeZone());
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!this.appVersion_.isEmpty()) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getAppVersion());
            }
            if (!this.platformVersion_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(2, getPlatformVersion());
            }
            if (!this.languageCode_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(3, getLanguageCode());
            }
            if (!this.timeZone_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(4, getTimeZone());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static ClientSignals parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ClientSignals parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClientSignals parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(InputStream inputStream) throws IOException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientSignals parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientSignals parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ClientSignals) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientSignals parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientSignals) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientSignals parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientSignals parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientSignals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ClientSignals clientSignals) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(clientSignals);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ClientSignals, Builder> implements ClientSignalsOrBuilder {
            private Builder() {
                super(ClientSignals.DEFAULT_INSTANCE);
            }

            public String getAppVersion() {
                return ((ClientSignals) this.instance).getAppVersion();
            }

            public ByteString getAppVersionBytes() {
                return ((ClientSignals) this.instance).getAppVersionBytes();
            }

            public Builder setAppVersion(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setAppVersion(str);
                return this;
            }

            public Builder clearAppVersion() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearAppVersion();
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setAppVersionBytes(byteString);
                return this;
            }

            public String getPlatformVersion() {
                return ((ClientSignals) this.instance).getPlatformVersion();
            }

            public ByteString getPlatformVersionBytes() {
                return ((ClientSignals) this.instance).getPlatformVersionBytes();
            }

            public Builder setPlatformVersion(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setPlatformVersion(str);
                return this;
            }

            public Builder clearPlatformVersion() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearPlatformVersion();
                return this;
            }

            public Builder setPlatformVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setPlatformVersionBytes(byteString);
                return this;
            }

            public String getLanguageCode() {
                return ((ClientSignals) this.instance).getLanguageCode();
            }

            public ByteString getLanguageCodeBytes() {
                return ((ClientSignals) this.instance).getLanguageCodeBytes();
            }

            public Builder setLanguageCode(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setLanguageCode(str);
                return this;
            }

            public Builder clearLanguageCode() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearLanguageCode();
                return this;
            }

            public Builder setLanguageCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setLanguageCodeBytes(byteString);
                return this;
            }

            public String getTimeZone() {
                return ((ClientSignals) this.instance).getTimeZone();
            }

            public ByteString getTimeZoneBytes() {
                return ((ClientSignals) this.instance).getTimeZoneBytes();
            }

            public Builder setTimeZone(String str) {
                copyOnWrite();
                ((ClientSignals) this.instance).setTimeZone(str);
                return this;
            }

            public Builder clearTimeZone() {
                copyOnWrite();
                ((ClientSignals) this.instance).clearTimeZone();
                return this;
            }

            public Builder setTimeZoneBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientSignals) this.instance).setTimeZoneBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ClientSignals();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ClientSignals clientSignals = (ClientSignals) obj2;
                    this.appVersion_ = visitor.visitString(!this.appVersion_.isEmpty(), this.appVersion_, !clientSignals.appVersion_.isEmpty(), clientSignals.appVersion_);
                    this.platformVersion_ = visitor.visitString(!this.platformVersion_.isEmpty(), this.platformVersion_, !clientSignals.platformVersion_.isEmpty(), clientSignals.platformVersion_);
                    this.languageCode_ = visitor.visitString(!this.languageCode_.isEmpty(), this.languageCode_, !clientSignals.languageCode_.isEmpty(), clientSignals.languageCode_);
                    this.timeZone_ = visitor.visitString(!this.timeZone_.isEmpty(), this.timeZone_, true ^ clientSignals.timeZone_.isEmpty(), clientSignals.timeZone_);
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
                                    this.appVersion_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.platformVersion_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
                                    this.languageCode_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 34) {
                                    this.timeZone_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (ClientSignals.class) {
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

        public static ClientSignals getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientSignals> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AppInstanceClaim extends GeneratedMessageLite<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {
        public static final int APP_INSTANCE_ID_FIELD_NUMBER = 1;
        public static final int APP_INSTANCE_TOKEN_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final AppInstanceClaim DEFAULT_INSTANCE = new AppInstanceClaim();
        public static final int GMP_APP_ID_FIELD_NUMBER = 3;
        private static volatile Parser<AppInstanceClaim> PARSER;
        private String appInstanceId_ = "";
        private String appInstanceToken_ = "";
        private String gmpAppId_ = "";

        private AppInstanceClaim() {
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

        public String getAppInstanceToken() {
            return this.appInstanceToken_;
        }

        public ByteString getAppInstanceTokenBytes() {
            return ByteString.copyFromUtf8(this.appInstanceToken_);
        }

        /* access modifiers changed from: private */
        public void setAppInstanceToken(String str) {
            if (str != null) {
                this.appInstanceToken_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearAppInstanceToken() {
            this.appInstanceToken_ = getDefaultInstance().getAppInstanceToken();
        }

        /* access modifiers changed from: private */
        public void setAppInstanceTokenBytes(ByteString byteString) {
            if (byteString != null) {
                checkByteStringIsUtf8(byteString);
                this.appInstanceToken_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
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

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.appInstanceId_.isEmpty()) {
                codedOutputStream.writeString(1, getAppInstanceId());
            }
            if (!this.appInstanceToken_.isEmpty()) {
                codedOutputStream.writeString(2, getAppInstanceToken());
            }
            if (!this.gmpAppId_.isEmpty()) {
                codedOutputStream.writeString(3, getGmpAppId());
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!this.appInstanceId_.isEmpty()) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getAppInstanceId());
            }
            if (!this.appInstanceToken_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(2, getAppInstanceToken());
            }
            if (!this.gmpAppId_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(3, getGmpAppId());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static AppInstanceClaim parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AppInstanceClaim parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AppInstanceClaim parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(InputStream inputStream) throws IOException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInstanceClaim parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInstanceClaim parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AppInstanceClaim) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInstanceClaim parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppInstanceClaim) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInstanceClaim parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AppInstanceClaim parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppInstanceClaim) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AppInstanceClaim appInstanceClaim) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(appInstanceClaim);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {
            private Builder() {
                super(AppInstanceClaim.DEFAULT_INSTANCE);
            }

            public String getAppInstanceId() {
                return ((AppInstanceClaim) this.instance).getAppInstanceId();
            }

            public ByteString getAppInstanceIdBytes() {
                return ((AppInstanceClaim) this.instance).getAppInstanceIdBytes();
            }

            public Builder setAppInstanceId(String str) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceId(str);
                return this;
            }

            public Builder clearAppInstanceId() {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).clearAppInstanceId();
                return this;
            }

            public Builder setAppInstanceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceIdBytes(byteString);
                return this;
            }

            public String getAppInstanceToken() {
                return ((AppInstanceClaim) this.instance).getAppInstanceToken();
            }

            public ByteString getAppInstanceTokenBytes() {
                return ((AppInstanceClaim) this.instance).getAppInstanceTokenBytes();
            }

            public Builder setAppInstanceToken(String str) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceToken(str);
                return this;
            }

            public Builder clearAppInstanceToken() {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).clearAppInstanceToken();
                return this;
            }

            public Builder setAppInstanceTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setAppInstanceTokenBytes(byteString);
                return this;
            }

            public String getGmpAppId() {
                return ((AppInstanceClaim) this.instance).getGmpAppId();
            }

            public ByteString getGmpAppIdBytes() {
                return ((AppInstanceClaim) this.instance).getGmpAppIdBytes();
            }

            public Builder setGmpAppId(String str) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setGmpAppId(str);
                return this;
            }

            public Builder clearGmpAppId() {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).clearGmpAppId();
                return this;
            }

            public Builder setGmpAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AppInstanceClaim) this.instance).setGmpAppIdBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new AppInstanceClaim();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AppInstanceClaim appInstanceClaim = (AppInstanceClaim) obj2;
                    this.appInstanceId_ = visitor.visitString(!this.appInstanceId_.isEmpty(), this.appInstanceId_, !appInstanceClaim.appInstanceId_.isEmpty(), appInstanceClaim.appInstanceId_);
                    this.appInstanceToken_ = visitor.visitString(!this.appInstanceToken_.isEmpty(), this.appInstanceToken_, !appInstanceClaim.appInstanceToken_.isEmpty(), appInstanceClaim.appInstanceToken_);
                    this.gmpAppId_ = visitor.visitString(!this.gmpAppId_.isEmpty(), this.gmpAppId_, true ^ appInstanceClaim.gmpAppId_.isEmpty(), appInstanceClaim.gmpAppId_);
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
                                    this.appInstanceId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.appInstanceToken_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
                                    this.gmpAppId_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (AppInstanceClaim.class) {
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

        public static AppInstanceClaim getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AppInstanceClaim> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}