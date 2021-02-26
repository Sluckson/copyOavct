package com.google.android.gms.config.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class Logs {

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface AndroidConfigFetchProtoOrBuilder extends MessageLiteOrBuilder {
        ConfigFetchReason getReason();

        boolean hasReason();
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public interface ConfigFetchReasonOrBuilder extends MessageLiteOrBuilder {
        ConfigFetchReason.AndroidConfigFetchType getType();

        boolean hasType();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Logs() {
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class ConfigFetchReason extends GeneratedMessageLite<ConfigFetchReason, Builder> implements ConfigFetchReasonOrBuilder {
        /* access modifiers changed from: private */
        public static final ConfigFetchReason DEFAULT_INSTANCE = new ConfigFetchReason();
        private static volatile Parser<ConfigFetchReason> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private int type_;

        private ConfigFetchReason() {
        }

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public enum AndroidConfigFetchType implements Internal.EnumLite {
            UNKNOWN(0),
            SCHEDULED(1),
            BOOT_COMPLETED(2),
            PACKAGE_ADDED(3),
            PACKAGE_REMOVED(4),
            GMS_CORE_UPDATED(5),
            SECRET_CODE(6);
            
            public static final int BOOT_COMPLETED_VALUE = 2;
            public static final int GMS_CORE_UPDATED_VALUE = 5;
            public static final int PACKAGE_ADDED_VALUE = 3;
            public static final int PACKAGE_REMOVED_VALUE = 4;
            public static final int SCHEDULED_VALUE = 1;
            public static final int SECRET_CODE_VALUE = 6;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<AndroidConfigFetchType> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<AndroidConfigFetchType>() {
                    public AndroidConfigFetchType findValueByNumber(int i) {
                        return AndroidConfigFetchType.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static AndroidConfigFetchType valueOf(int i) {
                return forNumber(i);
            }

            public static AndroidConfigFetchType forNumber(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return SCHEDULED;
                    case 2:
                        return BOOT_COMPLETED;
                    case 3:
                        return PACKAGE_ADDED;
                    case 4:
                        return PACKAGE_REMOVED;
                    case 5:
                        return GMS_CORE_UPDATED;
                    case 6:
                        return SECRET_CODE;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<AndroidConfigFetchType> internalGetValueMap() {
                return internalValueMap;
            }

            private AndroidConfigFetchType(int i) {
                this.value = i;
            }
        }

        public boolean hasType() {
            return (this.bitField0_ & 1) == 1;
        }

        public AndroidConfigFetchType getType() {
            AndroidConfigFetchType forNumber = AndroidConfigFetchType.forNumber(this.type_);
            return forNumber == null ? AndroidConfigFetchType.UNKNOWN : forNumber;
        }

        /* access modifiers changed from: private */
        public void setType(AndroidConfigFetchType androidConfigFetchType) {
            if (androidConfigFetchType != null) {
                this.bitField0_ |= 1;
                this.type_ = androidConfigFetchType.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -2;
            this.type_ = 0;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.type_);
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
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.type_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static ConfigFetchReason parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConfigFetchReason parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConfigFetchReason parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchReason parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchReason parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConfigFetchReason) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConfigFetchReason parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigFetchReason) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConfigFetchReason parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConfigFetchReason parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConfigFetchReason) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ConfigFetchReason configFetchReason) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(configFetchReason);
        }

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends GeneratedMessageLite.Builder<ConfigFetchReason, Builder> implements ConfigFetchReasonOrBuilder {
            private Builder() {
                super(ConfigFetchReason.DEFAULT_INSTANCE);
            }

            public boolean hasType() {
                return ((ConfigFetchReason) this.instance).hasType();
            }

            public AndroidConfigFetchType getType() {
                return ((ConfigFetchReason) this.instance).getType();
            }

            public Builder setType(AndroidConfigFetchType androidConfigFetchType) {
                copyOnWrite();
                ((ConfigFetchReason) this.instance).setType(androidConfigFetchType);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((ConfigFetchReason) this.instance).clearType();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ConfigFetchReason();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ConfigFetchReason configFetchReason = (ConfigFetchReason) obj2;
                    this.type_ = visitor.visitInt(hasType(), this.type_, configFetchReason.hasType(), configFetchReason.type_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= configFetchReason.bitField0_;
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
                                if (readTag == 8) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (AndroidConfigFetchType.forNumber(readEnum) == null) {
                                        super.mergeVarintField(1, readEnum);
                                    } else {
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.type_ = readEnum;
                                    }
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
                        synchronized (ConfigFetchReason.class) {
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

        public static ConfigFetchReason getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConfigFetchReason> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class AndroidConfigFetchProto extends GeneratedMessageLite<AndroidConfigFetchProto, Builder> implements AndroidConfigFetchProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final AndroidConfigFetchProto DEFAULT_INSTANCE = new AndroidConfigFetchProto();
        private static volatile Parser<AndroidConfigFetchProto> PARSER = null;
        public static final int REASON_FIELD_NUMBER = 1;
        private int bitField0_;
        private ConfigFetchReason reason_;

        private AndroidConfigFetchProto() {
        }

        public boolean hasReason() {
            return (this.bitField0_ & 1) == 1;
        }

        public ConfigFetchReason getReason() {
            ConfigFetchReason configFetchReason = this.reason_;
            return configFetchReason == null ? ConfigFetchReason.getDefaultInstance() : configFetchReason;
        }

        /* access modifiers changed from: private */
        public void setReason(ConfigFetchReason configFetchReason) {
            if (configFetchReason != null) {
                this.reason_ = configFetchReason;
                this.bitField0_ |= 1;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setReason(ConfigFetchReason.Builder builder) {
            this.reason_ = (ConfigFetchReason) builder.build();
            this.bitField0_ |= 1;
        }

        /* access modifiers changed from: private */
        public void mergeReason(ConfigFetchReason configFetchReason) {
            ConfigFetchReason configFetchReason2 = this.reason_;
            if (configFetchReason2 == null || configFetchReason2 == ConfigFetchReason.getDefaultInstance()) {
                this.reason_ = configFetchReason;
            } else {
                this.reason_ = (ConfigFetchReason) ((ConfigFetchReason.Builder) ConfigFetchReason.newBuilder(this.reason_).mergeFrom(configFetchReason)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        /* access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = null;
            this.bitField0_ &= -2;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, getReason());
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
                i2 = 0 + CodedOutputStream.computeMessageSize(1, getReason());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static AndroidConfigFetchProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AndroidConfigFetchProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AndroidConfigFetchProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(InputStream inputStream) throws IOException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AndroidConfigFetchProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AndroidConfigFetchProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AndroidConfigFetchProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AndroidConfigFetchProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AndroidConfigFetchProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AndroidConfigFetchProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AndroidConfigFetchProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AndroidConfigFetchProto androidConfigFetchProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(androidConfigFetchProto);
        }

        /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
        public static final class Builder extends GeneratedMessageLite.Builder<AndroidConfigFetchProto, Builder> implements AndroidConfigFetchProtoOrBuilder {
            private Builder() {
                super(AndroidConfigFetchProto.DEFAULT_INSTANCE);
            }

            public boolean hasReason() {
                return ((AndroidConfigFetchProto) this.instance).hasReason();
            }

            public ConfigFetchReason getReason() {
                return ((AndroidConfigFetchProto) this.instance).getReason();
            }

            public Builder setReason(ConfigFetchReason configFetchReason) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).setReason(configFetchReason);
                return this;
            }

            public Builder setReason(ConfigFetchReason.Builder builder) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).setReason(builder);
                return this;
            }

            public Builder mergeReason(ConfigFetchReason configFetchReason) {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).mergeReason(configFetchReason);
                return this;
            }

            public Builder clearReason() {
                copyOnWrite();
                ((AndroidConfigFetchProto) this.instance).clearReason();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new AndroidConfigFetchProto();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AndroidConfigFetchProto androidConfigFetchProto = (AndroidConfigFetchProto) obj2;
                    this.reason_ = (ConfigFetchReason) visitor.visitMessage(this.reason_, androidConfigFetchProto.reason_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= androidConfigFetchProto.bitField0_;
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
                                    ConfigFetchReason.Builder builder = (this.bitField0_ & 1) == 1 ? (ConfigFetchReason.Builder) this.reason_.toBuilder() : null;
                                    this.reason_ = (ConfigFetchReason) codedInputStream.readMessage(ConfigFetchReason.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.reason_);
                                        this.reason_ = (ConfigFetchReason) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
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
                        synchronized (AndroidConfigFetchProto.class) {
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

        public static AndroidConfigFetchProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AndroidConfigFetchProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
