package com.google.internal.firebase.inappmessaging.p014v1.sdkserving;

import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.ClientAppInfo;
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

/* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest */
public final class FetchEligibleCampaignsRequest extends GeneratedMessageLite<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 3;
    public static final int CLIENT_SIGNALS_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final FetchEligibleCampaignsRequest DEFAULT_INSTANCE = new FetchEligibleCampaignsRequest();
    private static volatile Parser<FetchEligibleCampaignsRequest> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int REQUESTING_CLIENT_APP_FIELD_NUMBER = 2;
    private Internal.ProtobufList<CampaignImpression> alreadySeenCampaigns_ = emptyProtobufList();
    private int bitField0_;
    private ClientSignalsProto.ClientSignals clientSignals_;
    private String projectNumber_ = "";
    private ClientAppInfo requestingClientApp_;

    private FetchEligibleCampaignsRequest() {
    }

    public String getProjectNumber() {
        return this.projectNumber_;
    }

    public ByteString getProjectNumberBytes() {
        return ByteString.copyFromUtf8(this.projectNumber_);
    }

    /* access modifiers changed from: private */
    public void setProjectNumber(String str) {
        if (str != null) {
            this.projectNumber_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearProjectNumber() {
        this.projectNumber_ = getDefaultInstance().getProjectNumber();
    }

    /* access modifiers changed from: private */
    public void setProjectNumberBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.projectNumber_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public boolean hasRequestingClientApp() {
        return this.requestingClientApp_ != null;
    }

    public ClientAppInfo getRequestingClientApp() {
        ClientAppInfo clientAppInfo = this.requestingClientApp_;
        return clientAppInfo == null ? ClientAppInfo.getDefaultInstance() : clientAppInfo;
    }

    /* access modifiers changed from: private */
    public void setRequestingClientApp(ClientAppInfo clientAppInfo) {
        if (clientAppInfo != null) {
            this.requestingClientApp_ = clientAppInfo;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setRequestingClientApp(ClientAppInfo.Builder builder) {
        this.requestingClientApp_ = (ClientAppInfo) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeRequestingClientApp(ClientAppInfo clientAppInfo) {
        ClientAppInfo clientAppInfo2 = this.requestingClientApp_;
        if (clientAppInfo2 == null || clientAppInfo2 == ClientAppInfo.getDefaultInstance()) {
            this.requestingClientApp_ = clientAppInfo;
        } else {
            this.requestingClientApp_ = (ClientAppInfo) ((ClientAppInfo.Builder) ClientAppInfo.newBuilder(this.requestingClientApp_).mergeFrom(clientAppInfo)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearRequestingClientApp() {
        this.requestingClientApp_ = null;
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

    public boolean hasClientSignals() {
        return this.clientSignals_ != null;
    }

    public ClientSignalsProto.ClientSignals getClientSignals() {
        ClientSignalsProto.ClientSignals clientSignals = this.clientSignals_;
        return clientSignals == null ? ClientSignalsProto.ClientSignals.getDefaultInstance() : clientSignals;
    }

    /* access modifiers changed from: private */
    public void setClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
        if (clientSignals != null) {
            this.clientSignals_ = clientSignals;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setClientSignals(ClientSignalsProto.ClientSignals.Builder builder) {
        this.clientSignals_ = (ClientSignalsProto.ClientSignals) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
        ClientSignalsProto.ClientSignals clientSignals2 = this.clientSignals_;
        if (clientSignals2 == null || clientSignals2 == ClientSignalsProto.ClientSignals.getDefaultInstance()) {
            this.clientSignals_ = clientSignals;
        } else {
            this.clientSignals_ = (ClientSignalsProto.ClientSignals) ((ClientSignalsProto.ClientSignals.Builder) ClientSignalsProto.ClientSignals.newBuilder(this.clientSignals_).mergeFrom(clientSignals)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearClientSignals() {
        this.clientSignals_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.projectNumber_.isEmpty()) {
            codedOutputStream.writeString(1, getProjectNumber());
        }
        if (this.requestingClientApp_ != null) {
            codedOutputStream.writeMessage(2, getRequestingClientApp());
        }
        for (int i = 0; i < this.alreadySeenCampaigns_.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.alreadySeenCampaigns_.get(i));
        }
        if (this.clientSignals_ != null) {
            codedOutputStream.writeMessage(4, getClientSignals());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.projectNumber_.isEmpty() ? CodedOutputStream.computeStringSize(1, getProjectNumber()) + 0 : 0;
        if (this.requestingClientApp_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getRequestingClientApp());
        }
        for (int i2 = 0; i2 < this.alreadySeenCampaigns_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, (MessageLite) this.alreadySeenCampaigns_.get(i2));
        }
        if (this.clientSignals_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getClientSignals());
        }
        this.memoizedSerializedSize = computeStringSize;
        return computeStringSize;
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FetchEligibleCampaignsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(fetchEligibleCampaignsRequest);
    }

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest$Builder */
    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
        private Builder() {
            super(FetchEligibleCampaignsRequest.DEFAULT_INSTANCE);
        }

        public String getProjectNumber() {
            return ((FetchEligibleCampaignsRequest) this.instance).getProjectNumber();
        }

        public ByteString getProjectNumberBytes() {
            return ((FetchEligibleCampaignsRequest) this.instance).getProjectNumberBytes();
        }

        public Builder setProjectNumber(String str) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setProjectNumber(str);
            return this;
        }

        public Builder clearProjectNumber() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearProjectNumber();
            return this;
        }

        public Builder setProjectNumberBytes(ByteString byteString) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setProjectNumberBytes(byteString);
            return this;
        }

        public boolean hasRequestingClientApp() {
            return ((FetchEligibleCampaignsRequest) this.instance).hasRequestingClientApp();
        }

        public ClientAppInfo getRequestingClientApp() {
            return ((FetchEligibleCampaignsRequest) this.instance).getRequestingClientApp();
        }

        public Builder setRequestingClientApp(ClientAppInfo clientAppInfo) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setRequestingClientApp(clientAppInfo);
            return this;
        }

        public Builder setRequestingClientApp(ClientAppInfo.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setRequestingClientApp(builder);
            return this;
        }

        public Builder mergeRequestingClientApp(ClientAppInfo clientAppInfo) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).mergeRequestingClientApp(clientAppInfo);
            return this;
        }

        public Builder clearRequestingClientApp() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearRequestingClientApp();
            return this;
        }

        public List<CampaignImpression> getAlreadySeenCampaignsList() {
            return Collections.unmodifiableList(((FetchEligibleCampaignsRequest) this.instance).getAlreadySeenCampaignsList());
        }

        public int getAlreadySeenCampaignsCount() {
            return ((FetchEligibleCampaignsRequest) this.instance).getAlreadySeenCampaignsCount();
        }

        public CampaignImpression getAlreadySeenCampaigns(int i) {
            return ((FetchEligibleCampaignsRequest) this.instance).getAlreadySeenCampaigns(i);
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(builder);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(i, builder);
            return this;
        }

        public Builder addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAllAlreadySeenCampaigns(iterable);
            return this;
        }

        public Builder clearAlreadySeenCampaigns() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearAlreadySeenCampaigns();
            return this;
        }

        public Builder removeAlreadySeenCampaigns(int i) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).removeAlreadySeenCampaigns(i);
            return this;
        }

        public boolean hasClientSignals() {
            return ((FetchEligibleCampaignsRequest) this.instance).hasClientSignals();
        }

        public ClientSignalsProto.ClientSignals getClientSignals() {
            return ((FetchEligibleCampaignsRequest) this.instance).getClientSignals();
        }

        public Builder setClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setClientSignals(clientSignals);
            return this;
        }

        public Builder setClientSignals(ClientSignalsProto.ClientSignals.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setClientSignals(builder);
            return this;
        }

        public Builder mergeClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).mergeClientSignals(clientSignals);
            return this;
        }

        public Builder clearClientSignals() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearClientSignals();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new FetchEligibleCampaignsRequest();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.alreadySeenCampaigns_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest = (FetchEligibleCampaignsRequest) obj2;
                this.projectNumber_ = visitor.visitString(!this.projectNumber_.isEmpty(), this.projectNumber_, true ^ fetchEligibleCampaignsRequest.projectNumber_.isEmpty(), fetchEligibleCampaignsRequest.projectNumber_);
                this.requestingClientApp_ = (ClientAppInfo) visitor.visitMessage(this.requestingClientApp_, fetchEligibleCampaignsRequest.requestingClientApp_);
                this.alreadySeenCampaigns_ = visitor.visitList(this.alreadySeenCampaigns_, fetchEligibleCampaignsRequest.alreadySeenCampaigns_);
                this.clientSignals_ = (ClientSignalsProto.ClientSignals) visitor.visitMessage(this.clientSignals_, fetchEligibleCampaignsRequest.clientSignals_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= fetchEligibleCampaignsRequest.bitField0_;
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
                                this.projectNumber_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                ClientAppInfo.Builder builder = this.requestingClientApp_ != null ? (ClientAppInfo.Builder) this.requestingClientApp_.toBuilder() : null;
                                this.requestingClientApp_ = (ClientAppInfo) codedInputStream.readMessage(ClientAppInfo.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.requestingClientApp_);
                                    this.requestingClientApp_ = (ClientAppInfo) builder.buildPartial();
                                }
                            } else if (readTag == 26) {
                                if (!this.alreadySeenCampaigns_.isModifiable()) {
                                    this.alreadySeenCampaigns_ = GeneratedMessageLite.mutableCopy(this.alreadySeenCampaigns_);
                                }
                                this.alreadySeenCampaigns_.add((CampaignImpression) codedInputStream.readMessage(CampaignImpression.parser(), extensionRegistryLite));
                            } else if (readTag == 34) {
                                ClientSignalsProto.ClientSignals.Builder builder2 = this.clientSignals_ != null ? (ClientSignalsProto.ClientSignals.Builder) this.clientSignals_.toBuilder() : null;
                                this.clientSignals_ = (ClientSignalsProto.ClientSignals) codedInputStream.readMessage(ClientSignalsProto.ClientSignals.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.clientSignals_);
                                    this.clientSignals_ = (ClientSignalsProto.ClientSignals) builder2.buildPartial();
                                }
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
                    synchronized (FetchEligibleCampaignsRequest.class) {
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

    public static FetchEligibleCampaignsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FetchEligibleCampaignsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
