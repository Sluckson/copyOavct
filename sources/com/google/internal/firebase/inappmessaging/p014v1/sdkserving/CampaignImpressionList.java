package com.google.internal.firebase.inappmessaging.p014v1.sdkserving;

import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.CampaignImpression;
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

/* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList */
public final class CampaignImpressionList extends GeneratedMessageLite<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final CampaignImpressionList DEFAULT_INSTANCE = new CampaignImpressionList();
    private static volatile Parser<CampaignImpressionList> PARSER;
    private Internal.ProtobufList<CampaignImpression> alreadySeenCampaigns_ = emptyProtobufList();

    private CampaignImpressionList() {
    }

    public List<CampaignImpression> getAlreadySeenCampaignsList() {
        return this.alreadySeenCampaigns_;
    }

    public List<? extends CampaignImpressionOrBuilder> getAlreadySeenCampaignsOrBuilderList() {
        return this.alreadySeenCampaigns_;
    }

    public int getAlreadySeenCampaignsCount() {
        return this.alreadySeenCampaigns_.size();
    }

    public CampaignImpression getAlreadySeenCampaigns(int i) {
        return (CampaignImpression) this.alreadySeenCampaigns_.get(i);
    }

    public CampaignImpressionOrBuilder getAlreadySeenCampaignsOrBuilder(int i) {
        return (CampaignImpressionOrBuilder) this.alreadySeenCampaigns_.get(i);
    }

    private void ensureAlreadySeenCampaignsIsMutable() {
        if (!this.alreadySeenCampaigns_.isModifiable()) {
            this.alreadySeenCampaigns_ = GeneratedMessageLite.mutableCopy(this.alreadySeenCampaigns_);
        }
    }

    /* access modifiers changed from: private */
    public void setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
        if (campaignImpression != null) {
            ensureAlreadySeenCampaignsIsMutable();
            this.alreadySeenCampaigns_.set(i, campaignImpression);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.set(i, (CampaignImpression) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
        if (campaignImpression != null) {
            ensureAlreadySeenCampaignsIsMutable();
            this.alreadySeenCampaigns_.add(campaignImpression);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
        if (campaignImpression != null) {
            ensureAlreadySeenCampaignsIsMutable();
            this.alreadySeenCampaigns_.add(i, campaignImpression);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add((CampaignImpression) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add(i, (CampaignImpression) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
        ensureAlreadySeenCampaignsIsMutable();
        AbstractMessageLite.addAll(iterable, this.alreadySeenCampaigns_);
    }

    /* access modifiers changed from: private */
    public void clearAlreadySeenCampaigns() {
        this.alreadySeenCampaigns_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeAlreadySeenCampaigns(int i) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.alreadySeenCampaigns_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.alreadySeenCampaigns_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.alreadySeenCampaigns_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.alreadySeenCampaigns_.get(i3));
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static CampaignImpressionList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CampaignImpressionList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CampaignImpressionList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(InputStream inputStream) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpressionList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpressionList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CampaignImpressionList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpressionList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpressionList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CampaignImpressionList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CampaignImpressionList campaignImpressionList) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(campaignImpressionList);
    }

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList$Builder */
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {
        private Builder() {
            super(CampaignImpressionList.DEFAULT_INSTANCE);
        }

        public List<CampaignImpression> getAlreadySeenCampaignsList() {
            return Collections.unmodifiableList(((CampaignImpressionList) this.instance).getAlreadySeenCampaignsList());
        }

        public int getAlreadySeenCampaignsCount() {
            return ((CampaignImpressionList) this.instance).getAlreadySeenCampaignsCount();
        }

        public CampaignImpression getAlreadySeenCampaigns(int i) {
            return ((CampaignImpressionList) this.instance).getAlreadySeenCampaigns(i);
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).setAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).setAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAllAlreadySeenCampaigns(iterable);
            return this;
        }

        public Builder clearAlreadySeenCampaigns() {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).clearAlreadySeenCampaigns();
            return this;
        }

        public Builder removeAlreadySeenCampaigns(int i) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).removeAlreadySeenCampaigns(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new CampaignImpressionList();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.alreadySeenCampaigns_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                this.alreadySeenCampaigns_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.alreadySeenCampaigns_, ((CampaignImpressionList) obj2).alreadySeenCampaigns_);
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
                                if (!this.alreadySeenCampaigns_.isModifiable()) {
                                    this.alreadySeenCampaigns_ = GeneratedMessageLite.mutableCopy(this.alreadySeenCampaigns_);
                                }
                                this.alreadySeenCampaigns_.add((CampaignImpression) codedInputStream.readMessage(CampaignImpression.parser(), extensionRegistryLite));
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
                    synchronized (CampaignImpressionList.class) {
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

    public static CampaignImpressionList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CampaignImpressionList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
