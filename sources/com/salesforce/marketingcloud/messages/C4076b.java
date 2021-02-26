package com.salesforce.marketingcloud.messages;

import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.messages.Message;

/* renamed from: com.salesforce.marketingcloud.messages.b */
final class C4076b extends Message.Media {

    /* renamed from: a */
    private final String f3095a;

    /* renamed from: b */
    private final String f3096b;

    C4076b(@Nullable String str, @Nullable String str2) {
        this.f3095a = str;
        this.f3096b = str2;
    }

    @Nullable
    public String altText() {
        return this.f3096b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Message.Media)) {
            return false;
        }
        Message.Media media = (Message.Media) obj;
        String str = this.f3095a;
        if (str != null ? str.equals(media.url()) : media.url() == null) {
            String str2 = this.f3096b;
            if (str2 == null) {
                if (media.altText() == null) {
                    return true;
                }
            } else if (str2.equals(media.altText())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f3095a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f3096b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Media{url=" + this.f3095a + ", altText=" + this.f3096b + "}";
    }

    @Nullable
    public String url() {
        return this.f3095a;
    }
}
