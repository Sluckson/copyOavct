package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.model.Text;

public class Button {
    @NonNull
    private final String buttonHexColor;
    @NonNull
    private final Text text;

    public int hashCode() {
        return this.text.hashCode() + this.buttonHexColor.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Button)) {
            return false;
        }
        Button button = (Button) obj;
        return hashCode() == button.hashCode() && this.text.equals(button.text) && this.buttonHexColor.equals(button.buttonHexColor);
    }

    private Button(@NonNull Text text2, @NonNull String str) {
        this.text = text2;
        this.buttonHexColor = str;
    }

    @NonNull
    public Text getText() {
        return this.text;
    }

    @NonNull
    public String getButtonHexColor() {
        return this.buttonHexColor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        @Nullable
        private String buttonHexColor;
        @Nullable
        private Text text;

        public Builder setText(@Nullable Text text2) {
            this.text = text2;
            return this;
        }

        public Builder setText(MessagesProto.Text text2) {
            Text.Builder builder = new Text.Builder();
            builder.setText(text2);
            this.text = builder.build();
            return this;
        }

        public Builder setButtonHexColor(@Nullable String str) {
            this.buttonHexColor = str;
            return this;
        }

        public Button build() {
            if (!TextUtils.isEmpty(this.buttonHexColor)) {
                Text text2 = this.text;
                if (text2 != null) {
                    return new Button(text2, this.buttonHexColor);
                }
                throw new IllegalArgumentException("Button model must have text");
            }
            throw new IllegalArgumentException("Button model must have a color");
        }
    }
}
