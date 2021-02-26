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

/* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression */
public final class CampaignImpression extends GeneratedMessageLite<CampaignImpression, Builder> implements CampaignImpressionOrBuilder {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final CampaignImpression DEFAULT_INSTANCE = new CampaignImpression();
    public static final int IMPRESSION_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    private static volatile Parser<CampaignImpression> PARSER;
    private String campaignId_ = "";
    private long impressionTimestampMillis_;

    private CampaignImpression() {
    }

    public String getCampaignId() {
        return this.campaignId_;
    }

    public ByteString getCampaignIdBytes() {
        return ByteString.copyFromUtf8(this.campaignId_);
    }

    /* access modifiers changed from: private */
    public void setCampaignId(String str) {
        if (str != null) {
            this.campaignId_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearCampaignId() {
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    /* access modifiers changed from: private */
    public void setCampaignIdBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.campaignId_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public long getImpressionTimestampMillis() {
        return this.impressionTimestampMillis_;
    }

    /* access modifiers changed from: private */
    public void setImpressionTimestampMillis(long j) {
        this.impressionTimestampMillis_ = j;
    }

    /* access modifiers changed from: private */
    public void clearImpressionTimestampMillis() {
        this.impressionTimestampMillis_ = 0;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.campaignId_.isEmpty()) {
            codedOutputStream.writeString(1, getCampaignId());
        }
        long j = this.impressionTimestampMillis_;
        if (j != 0) {
            codedOutputStream.writeInt64(2, j);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.campaignId_.isEmpty()) {
            i2 = 0 + CodedOutputStream.computeStringSize(1, getCampaignId());
        }
        long j = this.impressionTimestampMillis_;
        if (j != 0) {
            i2 += CodedOutputStream.computeInt64Size(2, j);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static CampaignImpression parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CampaignImpression parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CampaignImpression parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CampaignImpression parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CampaignImpression parseFrom(InputStream inputStream) throws IOException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpression parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpression parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CampaignImpression) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpression parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpression) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpression parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CampaignImpression parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CampaignImpression campaignImpression) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(campaignImpression);
    }

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression$Builder */
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpression, Builder> implements CampaignImpressionOrBuilder {
        private Builder() {
            super(CampaignImpression.DEFAULT_INSTANCE);
        }

        public String getCampaignId() {
            return ((CampaignImpression) this.instance).getCampaignId();
        }

        public ByteString getCampaignIdBytes() {
            return ((CampaignImpression) this.instance).getCampaignIdBytes();
        }

        public Builder setCampaignId(String str) {
            copyOnWrite();
            ((CampaignImpression) this.instance).setCampaignId(str);
            return this;
        }

        public Builder clearCampaignId() {
            copyOnWrite();
            ((CampaignImpression) this.instance).clearCampaignId();
            return this;
        }

        public Builder setCampaignIdBytes(ByteString byteString) {
            copyOnWrite();
            ((CampaignImpression) this.instance).setCampaignIdBytes(byteString);
            return this;
        }

        public long getImpressionTimestampMillis() {
            return ((CampaignImpression) this.instance).getImpressionTimestampMillis();
        }

        public Builder setImpressionTimestampMillis(long j) {
            copyOnWrite();
            ((CampaignImpression) this.instance).setImpressionTimestampMillis(j);
            return this;
        }

        public Builder clearImpressionTimestampMillis() {
            copyOnWrite();
            ((CampaignImpression) this.instance).clearImpressionTimestampMillis();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new CampaignImpression();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CampaignImpression campaignImpression = (CampaignImpression) obj2;
                this.campaignId_ = visitor.visitString(!this.campaignId_.isEmpty(), this.campaignId_, !campaignImpression.campaignId_.isEmpty(), campaignImpression.campaignId_);
                this.impressionTimestampMillis_ = visitor.visitLong(this.impressionTimestampMillis_ != 0, this.impressionTimestampMillis_, campaignImpression.impressionTimestampMillis_ != 0, campaignImpression.impressionTimestampMillis_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.campaignId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.impressionTimestampMillis_ = codedInputStream.readInt64();
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
                    synchronized (CampaignImpression.class) {
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

    public static CampaignImpression getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CampaignImpression> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
