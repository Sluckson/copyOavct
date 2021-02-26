package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.common.base.Preconditions;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.Button;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.inappmessaging.model.Text;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProtoMarshallerClient {
    @Inject
    ProtoMarshallerClient() {
    }

    @Nonnull
    private static ModalMessage.Builder from(MessagesProto.ModalMessage modalMessage) {
        ModalMessage.Builder builder = ModalMessage.builder();
        if (!TextUtils.isEmpty(modalMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(modalMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(modalMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(modalMessage.getImageUrl()).build());
        }
        if (modalMessage.hasAction()) {
            builder.setAction(decode(modalMessage.getAction(), modalMessage.getActionButton()));
        }
        if (modalMessage.hasBody()) {
            builder.setBody(decode(modalMessage.getBody()));
        }
        if (modalMessage.hasTitle()) {
            builder.setTitle(decode(modalMessage.getTitle()));
        }
        return builder;
    }

    @Nonnull
    private static ImageOnlyMessage.Builder from(MessagesProto.ImageOnlyMessage imageOnlyMessage) {
        ImageOnlyMessage.Builder builder = ImageOnlyMessage.builder();
        if (!TextUtils.isEmpty(imageOnlyMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(imageOnlyMessage.getImageUrl()).build());
        }
        if (imageOnlyMessage.hasAction()) {
            builder.setAction(decode(imageOnlyMessage.getAction()).build());
        }
        return builder;
    }

    @Nonnull
    private static BannerMessage.Builder from(MessagesProto.BannerMessage bannerMessage) {
        BannerMessage.Builder builder = BannerMessage.builder();
        if (!TextUtils.isEmpty(bannerMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(bannerMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(bannerMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(bannerMessage.getImageUrl()).build());
        }
        if (bannerMessage.hasAction()) {
            builder.setAction(decode(bannerMessage.getAction()).build());
        }
        if (bannerMessage.hasBody()) {
            builder.setBody(decode(bannerMessage.getBody()));
        }
        if (bannerMessage.hasTitle()) {
            builder.setTitle(decode(bannerMessage.getTitle()));
        }
        return builder;
    }

    @Nonnull
    private static CardMessage.Builder from(MessagesProto.CardMessage cardMessage) {
        CardMessage.Builder builder = CardMessage.builder();
        if (cardMessage.hasTitle()) {
            builder.setTitle(decode(cardMessage.getTitle()));
        }
        if (cardMessage.hasBody()) {
            builder.setBody(decode(cardMessage.getBody()));
        }
        if (!TextUtils.isEmpty(cardMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(cardMessage.getBackgroundHexColor());
        }
        if (cardMessage.hasPrimaryAction() || cardMessage.hasPrimaryActionButton()) {
            builder.setPrimaryAction(decode(cardMessage.getPrimaryAction(), cardMessage.getPrimaryActionButton()));
        }
        if (cardMessage.hasSecondaryAction() || cardMessage.hasSecondaryActionButton()) {
            builder.setSecondaryAction(decode(cardMessage.getSecondaryAction(), cardMessage.getSecondaryActionButton()));
        }
        if (!TextUtils.isEmpty(cardMessage.getPortraitImageUrl())) {
            builder.setPortraitImageData(ImageData.builder().setImageUrl(cardMessage.getPortraitImageUrl()).build());
        }
        if (!TextUtils.isEmpty(cardMessage.getLandscapeImageUrl())) {
            builder.setLandscapeImageData(ImageData.builder().setImageUrl(cardMessage.getLandscapeImageUrl()).build());
        }
        return builder;
    }

    private static Button decode(MessagesProto.Button button) {
        Button.Builder builder = Button.builder();
        if (!TextUtils.isEmpty(button.getButtonHexColor())) {
            builder.setButtonHexColor(button.getButtonHexColor());
        }
        if (button.hasText()) {
            builder.setText(decode(button.getText()));
        }
        return builder.build();
    }

    private static Action decode(MessagesProto.Action action, MessagesProto.Button button) {
        Action.Builder decode = decode(action);
        if (!button.equals(MessagesProto.Button.getDefaultInstance())) {
            Button.Builder builder = Button.builder();
            if (!TextUtils.isEmpty(button.getButtonHexColor())) {
                builder.setButtonHexColor(button.getButtonHexColor());
            }
            if (button.hasText()) {
                Text.Builder builder2 = Text.builder();
                MessagesProto.Text text = button.getText();
                if (!TextUtils.isEmpty(text.getText())) {
                    builder2.setText(text.getText());
                }
                if (!TextUtils.isEmpty(text.getHexColor())) {
                    builder2.setHexColor(text.getHexColor());
                }
                builder.setText(builder2.build());
            }
            decode.setButton(builder.build());
        }
        return decode.build();
    }

    private static Action.Builder decode(MessagesProto.Action action) {
        Action.Builder builder = Action.builder();
        if (!TextUtils.isEmpty(action.getActionUrl())) {
            builder.setActionUrl(action.getActionUrl());
        }
        return builder;
    }

    private static Text decode(MessagesProto.Text text) {
        Text.Builder builder = Text.builder();
        if (!TextUtils.isEmpty(text.getHexColor())) {
            builder.setHexColor(text.getHexColor());
        }
        if (!TextUtils.isEmpty(text.getText())) {
            builder.setText(text.getText());
        }
        return builder.build();
    }

    public static InAppMessage decode(@Nonnull MessagesProto.Content content, @NonNull String str, @NonNull String str2, boolean z, @Nullable Map<String, String> map) {
        Preconditions.checkNotNull(content, "FirebaseInAppMessaging content cannot be null.");
        Preconditions.checkNotNull(str, "FirebaseInAppMessaging campaign id cannot be null.");
        Preconditions.checkNotNull(str2, "FirebaseInAppMessaging campaign name cannot be null.");
        Logging.logd("Decoding message: " + content.toString());
        CampaignMetadata campaignMetadata = new CampaignMetadata(str, str2, z);
        int i = C23762.f371x95e22605[content.getMessageDetailsCase().ordinal()];
        if (i == 1) {
            return from(content.getBanner()).build(campaignMetadata, map);
        }
        if (i == 2) {
            return from(content.getImageOnly()).build(campaignMetadata, map);
        }
        if (i == 3) {
            return from(content.getModal()).build(campaignMetadata, map);
        }
        if (i != 4) {
            return new InAppMessage(new CampaignMetadata(str, str2, z), MessageType.UNSUPPORTED, map) {
                public Action getAction() {
                    return null;
                }
            };
        }
        return from(content.getCard()).build(campaignMetadata, map);
    }

    /* renamed from: com.google.firebase.inappmessaging.model.ProtoMarshallerClient$2 */
    static /* synthetic */ class C23762 {

        /* renamed from: $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase */
        static final /* synthetic */ int[] f371x95e22605 = new int[MessagesProto.Content.MessageDetailsCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase[] r0 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f371x95e22605 = r0
                int[] r0 = f371x95e22605     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.BANNER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f371x95e22605     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f371x95e22605     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.MODAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f371x95e22605     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.CARD     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.model.ProtoMarshallerClient.C23762.<clinit>():void");
        }
    }
}
