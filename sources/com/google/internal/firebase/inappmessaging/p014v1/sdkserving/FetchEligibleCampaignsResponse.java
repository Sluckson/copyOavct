package com.google.internal.firebase.inappmessaging.p014v1.sdkserving;

import com.google.internal.firebase.inappmessaging.p014v1.CampaignProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse */
public final class FetchEligibleCampaignsResponse extends GeneratedMessageLite<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
    /* access modifiers changed from: private */
    public static final FetchEligibleCampaignsResponse DEFAULT_INSTANCE = new FetchEligibleCampaignsResponse();
    public static final int EXPIRATION_EPOCH_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile Parser<FetchEligibleCampaignsResponse> PARSER;
    private int bitField0_;
    private long expirationEpochTimestampMillis_;
    private Internal.ProtobufList<CampaignProto.ThickContent> messages_ = emptyProtobufList();

    private FetchEligibleCampaignsResponse() {
    }

    public List<CampaignProto.ThickContent> getMessagesList() {
        return this.messages_;
    }

    public List<? extends CampaignProto.ThickContentOrBuilder> getMessagesOrBuilderList() {
        return this.messages_;
    }

    public int getMessagesCount() {
        return this.messages_.size();
    }

    public CampaignProto.ThickContent getMessages(int i) {
        return (CampaignProto.ThickContent) this.messages_.get(i);
    }

    public CampaignProto.ThickContentOrBuilder getMessagesOrBuilder(int i) {
        return (CampaignProto.ThickContentOrBuilder) this.messages_.get(i);
    }

    private void ensureMessagesIsMutable() {
        if (!this.messages_.isModifiable()) {
            this.messages_ = GeneratedMessageLite.mutableCopy(this.messages_);
        }
    }

    /* access modifiers changed from: private */
    public void setMessages(int i, CampaignProto.ThickContent thickContent) {
        if (thickContent != null) {
            ensureMessagesIsMutable();
            this.messages_.set(i, thickContent);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setMessages(int i, CampaignProto.ThickContent.Builder builder) {
        ensureMessagesIsMutable();
        this.messages_.set(i, (CampaignProto.ThickContent) builder.build());
    }

    /* access modifiers changed from: private */
    public void addMessages(CampaignProto.ThickContent thickContent) {
        if (thickContent != null) {
            ensureMessagesIsMutable();
            this.messages_.add(thickContent);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addMessages(int i, CampaignProto.ThickContent thickContent) {
        if (thickContent != null) {
            ensureMessagesIsMutable();
            this.messages_.add(i, thickContent);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addMessages(CampaignProto.ThickContent.Builder builder) {
        ensureMessagesIsMutable();
        this.messages_.add((CampaignProto.ThickContent) builder.build());
    }

    /* access modifiers changed from: private */
    public void addMessages(int i, CampaignProto.ThickContent.Builder builder) {
        ensureMessagesIsMutable();
        this.messages_.add(i, (CampaignProto.ThickContent) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllMessages(Iterable<? extends CampaignProto.ThickContent> iterable) {
        ensureMessagesIsMutable();
        AbstractMessageLite.addAll(iterable, this.messages_);
    }

    /* access modifiers changed from: private */
    public void clearMessages() {
        this.messages_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeMessages(int i) {
        ensureMessagesIsMutable();
        this.messages_.remove(i);
    }

    public long getExpirationEpochTimestampMillis() {
        return this.expirationEpochTimestampMillis_;
    }

    /* access modifiers changed from: private */
    public void setExpirationEpochTimestampMillis(long j) {
        this.expirationEpochTimestampMillis_ = j;
    }

    /* access modifiers changed from: private */
    public void clearExpirationEpochTimestampMillis() {
        this.expirationEpochTimestampMillis_ = 0;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.messages_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.messages_.get(i));
        }
        long j = this.expirationEpochTimestampMillis_;
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
        for (int i3 = 0; i3 < this.messages_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.messages_.get(i3));
        }
        long j = this.expirationEpochTimestampMillis_;
        if (j != 0) {
            i2 += CodedOutputStream.computeInt64Size(2, j);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FetchEligibleCampaignsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(fetchEligibleCampaignsResponse);
    }

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse$Builder */
    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
        private Builder() {
            super(FetchEligibleCampaignsResponse.DEFAULT_INSTANCE);
        }

        public List<CampaignProto.ThickContent> getMessagesList() {
            return Collections.unmodifiableList(((FetchEligibleCampaignsResponse) this.instance).getMessagesList());
        }

        public int getMessagesCount() {
            return ((FetchEligibleCampaignsResponse) this.instance).getMessagesCount();
        }

        public CampaignProto.ThickContent getMessages(int i) {
            return ((FetchEligibleCampaignsResponse) this.instance).getMessages(i);
        }

        public Builder setMessages(int i, CampaignProto.ThickContent thickContent) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).setMessages(i, thickContent);
            return this;
        }

        public Builder setMessages(int i, CampaignProto.ThickContent.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).setMessages(i, builder);
            return this;
        }

        public Builder addMessages(CampaignProto.ThickContent thickContent) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(thickContent);
            return this;
        }

        public Builder addMessages(int i, CampaignProto.ThickContent thickContent) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(i, thickContent);
            return this;
        }

        public Builder addMessages(CampaignProto.ThickContent.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(builder);
            return this;
        }

        public Builder addMessages(int i, CampaignProto.ThickContent.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(i, builder);
            return this;
        }

        public Builder addAllMessages(Iterable<? extends CampaignProto.ThickContent> iterable) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addAllMessages(iterable);
            return this;
        }

        public Builder clearMessages() {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).clearMessages();
            return this;
        }

        public Builder removeMessages(int i) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).removeMessages(i);
            return this;
        }

        public long getExpirationEpochTimestampMillis() {
            return ((FetchEligibleCampaignsResponse) this.instance).getExpirationEpochTimestampMillis();
        }

        public Builder setExpirationEpochTimestampMillis(long j) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).setExpirationEpochTimestampMillis(j);
            return this;
        }

        public Builder clearExpirationEpochTimestampMillis() {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).clearExpirationEpochTimestampMillis();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new FetchEligibleCampaignsResponse();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.messages_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse = (FetchEligibleCampaignsResponse) obj2;
                this.messages_ = visitor.visitList(this.messages_, fetchEligibleCampaignsResponse.messages_);
                this.expirationEpochTimestampMillis_ = visitor.visitLong(this.expirationEpochTimestampMillis_ != 0, this.expirationEpochTimestampMillis_, fetchEligibleCampaignsResponse.expirationEpochTimestampMillis_ != 0, fetchEligibleCampaignsResponse.expirationEpochTimestampMillis_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= fetchEligibleCampaignsResponse.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (!this.messages_.isModifiable()) {
                                    this.messages_ = GeneratedMessageLite.mutableCopy(this.messages_);
                                }
                                this.messages_.add((CampaignProto.ThickContent) codedInputStream.readMessage(CampaignProto.ThickContent.parser(), extensionRegistryLite));
                            } else if (readTag == 16) {
                                this.expirationEpochTimestampMillis_ = codedInputStream.readInt64();
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
                    synchronized (FetchEligibleCampaignsResponse.class) {
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

    public static FetchEligibleCampaignsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FetchEligibleCampaignsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
