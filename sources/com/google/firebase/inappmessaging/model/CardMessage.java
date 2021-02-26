package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public class CardMessage extends InAppMessage {
    @NonNull
    private final String backgroundHexColor;
    @Nullable
    private final Text body;
    @Nullable
    private final ImageData landscapeImageData;
    @Nullable
    private final ImageData portraitImageData;
    @NonNull
    private final Action primaryAction;
    @Nullable
    private final Action secondaryAction;
    @NonNull
    private final Text title;

    public int hashCode() {
        Text text = this.body;
        int i = 0;
        int hashCode = text != null ? text.hashCode() : 0;
        Action action = this.secondaryAction;
        int hashCode2 = action != null ? action.hashCode() : 0;
        ImageData imageData = this.portraitImageData;
        int hashCode3 = imageData != null ? imageData.hashCode() : 0;
        ImageData imageData2 = this.landscapeImageData;
        if (imageData2 != null) {
            i = imageData2.hashCode();
        }
        return this.title.hashCode() + hashCode + this.backgroundHexColor.hashCode() + this.primaryAction.hashCode() + hashCode2 + hashCode3 + i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005e, code lost:
        r1 = r4.landscapeImageData;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.inappmessaging.model.CardMessage
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.firebase.inappmessaging.model.CardMessage r5 = (com.google.firebase.inappmessaging.model.CardMessage) r5
            int r1 = r4.hashCode()
            int r3 = r5.hashCode()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            com.google.firebase.inappmessaging.model.Text r1 = r4.body
            if (r1 != 0) goto L_0x001f
            com.google.firebase.inappmessaging.model.Text r1 = r5.body
            if (r1 != 0) goto L_0x002b
        L_0x001f:
            com.google.firebase.inappmessaging.model.Text r1 = r4.body
            if (r1 == 0) goto L_0x002c
            com.google.firebase.inappmessaging.model.Text r3 = r5.body
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x002c
        L_0x002b:
            return r2
        L_0x002c:
            com.google.firebase.inappmessaging.model.Action r1 = r4.secondaryAction
            if (r1 != 0) goto L_0x0034
            com.google.firebase.inappmessaging.model.Action r1 = r5.secondaryAction
            if (r1 != 0) goto L_0x0040
        L_0x0034:
            com.google.firebase.inappmessaging.model.Action r1 = r4.secondaryAction
            if (r1 == 0) goto L_0x0041
            com.google.firebase.inappmessaging.model.Action r3 = r5.secondaryAction
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0041
        L_0x0040:
            return r2
        L_0x0041:
            com.google.firebase.inappmessaging.model.ImageData r1 = r4.portraitImageData
            if (r1 != 0) goto L_0x0049
            com.google.firebase.inappmessaging.model.ImageData r1 = r5.portraitImageData
            if (r1 != 0) goto L_0x0055
        L_0x0049:
            com.google.firebase.inappmessaging.model.ImageData r1 = r4.portraitImageData
            if (r1 == 0) goto L_0x0056
            com.google.firebase.inappmessaging.model.ImageData r3 = r5.portraitImageData
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0056
        L_0x0055:
            return r2
        L_0x0056:
            com.google.firebase.inappmessaging.model.ImageData r1 = r4.landscapeImageData
            if (r1 != 0) goto L_0x005e
            com.google.firebase.inappmessaging.model.ImageData r1 = r5.landscapeImageData
            if (r1 != 0) goto L_0x006a
        L_0x005e:
            com.google.firebase.inappmessaging.model.ImageData r1 = r4.landscapeImageData
            if (r1 == 0) goto L_0x006b
            com.google.firebase.inappmessaging.model.ImageData r3 = r5.landscapeImageData
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x006b
        L_0x006a:
            return r2
        L_0x006b:
            com.google.firebase.inappmessaging.model.Text r1 = r4.title
            com.google.firebase.inappmessaging.model.Text r3 = r5.title
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0076
            return r2
        L_0x0076:
            com.google.firebase.inappmessaging.model.Action r1 = r4.primaryAction
            com.google.firebase.inappmessaging.model.Action r3 = r5.primaryAction
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0081
            return r2
        L_0x0081:
            java.lang.String r1 = r4.backgroundHexColor
            java.lang.String r5 = r5.backgroundHexColor
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x008c
            return r0
        L_0x008c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.model.CardMessage.equals(java.lang.Object):boolean");
    }

    private CardMessage(@NonNull CampaignMetadata campaignMetadata, @NonNull Text text, @Nullable Text text2, @Nullable ImageData imageData, @Nullable ImageData imageData2, @NonNull String str, @NonNull Action action, @Nullable Action action2, @Nullable Map<String, String> map) {
        super(campaignMetadata, MessageType.CARD, map);
        this.title = text;
        this.body = text2;
        this.portraitImageData = imageData;
        this.landscapeImageData = imageData2;
        this.backgroundHexColor = str;
        this.primaryAction = action;
        this.secondaryAction = action2;
    }

    @Nullable
    public ImageData getPortraitImageData() {
        return this.portraitImageData;
    }

    @Nullable
    public ImageData getLandscapeImageData() {
        return this.landscapeImageData;
    }

    @NonNull
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @NonNull
    public Action getPrimaryAction() {
        return this.primaryAction;
    }

    @Nullable
    public Action getSecondaryAction() {
        return this.secondaryAction;
    }

    @Deprecated
    @Nullable
    public Action getAction() {
        return this.primaryAction;
    }

    @NonNull
    public Text getTitle() {
        return this.title;
    }

    @Nullable
    public Text getBody() {
        return this.body;
    }

    @Deprecated
    @Nullable
    public ImageData getImageData() {
        return this.portraitImageData;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        @Nullable
        String backgroundHexColor;
        @Nullable
        Text body;
        @Nullable
        ImageData landscapeImageData;
        @Nullable
        ImageData portraitImageData;
        @Nullable
        Action primaryAction;
        @Nullable
        Action secondaryAction;
        @Nullable
        Text title;

        public Builder setPortraitImageData(@Nullable ImageData imageData) {
            this.portraitImageData = imageData;
            return this;
        }

        public Builder setLandscapeImageData(@Nullable ImageData imageData) {
            this.landscapeImageData = imageData;
            return this;
        }

        public Builder setBackgroundHexColor(@Nullable String str) {
            this.backgroundHexColor = str;
            return this;
        }

        public Builder setPrimaryAction(@Nullable Action action) {
            this.primaryAction = action;
            return this;
        }

        public Builder setSecondaryAction(@Nullable Action action) {
            this.secondaryAction = action;
            return this;
        }

        public Builder setTitle(@Nullable Text text) {
            this.title = text;
            return this;
        }

        public Builder setBody(@Nullable Text text) {
            this.body = text;
            return this;
        }

        public CardMessage build(CampaignMetadata campaignMetadata, @Nullable Map<String, String> map) {
            Action action = this.primaryAction;
            if (action == null) {
                throw new IllegalArgumentException("Card model must have a primary action");
            } else if (action.getButton() != null) {
                Action action2 = this.secondaryAction;
                if (action2 != null && action2.getButton() == null) {
                    throw new IllegalArgumentException("Card model secondary action must be null or have a button");
                } else if (this.title == null) {
                    throw new IllegalArgumentException("Card model must have a title");
                } else if (this.portraitImageData == null && this.landscapeImageData == null) {
                    throw new IllegalArgumentException("Card model must have at least one image");
                } else if (!TextUtils.isEmpty(this.backgroundHexColor)) {
                    return new CardMessage(campaignMetadata, this.title, this.body, this.portraitImageData, this.landscapeImageData, this.backgroundHexColor, this.primaryAction, this.secondaryAction, map);
                } else {
                    throw new IllegalArgumentException("Card model must have a background color");
                }
            } else {
                throw new IllegalArgumentException("Card model must have a primary action button");
            }
        }
    }
}
