package com.google.firebase.inappmessaging.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageData {
    @Nullable
    private final Bitmap bitmapData;
    @NonNull
    private final String imageUrl;

    public int hashCode() {
        Bitmap bitmap = this.bitmapData;
        return this.imageUrl.hashCode() + (bitmap != null ? bitmap.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageData)) {
            return false;
        }
        ImageData imageData = (ImageData) obj;
        return hashCode() == imageData.hashCode() && this.imageUrl.equals(imageData.imageUrl);
    }

    public ImageData(@NonNull String str, @Nullable Bitmap bitmap) {
        this.imageUrl = str;
        this.bitmapData = bitmap;
    }

    @NonNull
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public Bitmap getBitmapData() {
        return this.bitmapData;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        @Nullable
        private Bitmap bitmapData;
        @Nullable
        private String imageUrl;

        public Builder setImageUrl(@Nullable String str) {
            if (!TextUtils.isEmpty(str)) {
                this.imageUrl = str;
            }
            return this;
        }

        public Builder setBitmapData(@Nullable Bitmap bitmap) {
            this.bitmapData = bitmap;
            return this;
        }

        public ImageData build() {
            if (!TextUtils.isEmpty(this.imageUrl)) {
                return new ImageData(this.imageUrl, this.bitmapData);
            }
            throw new IllegalArgumentException("ImageData model must have an imageUrl");
        }
    }
}
