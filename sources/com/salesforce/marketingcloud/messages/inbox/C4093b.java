package com.salesforce.marketingcloud.messages.inbox;

import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;

/* renamed from: com.salesforce.marketingcloud.messages.inbox.b */
final class C4093b extends InboxMessage.Media {

    /* renamed from: a */
    private final String f3194a;

    /* renamed from: b */
    private final String f3195b;

    C4093b(@Nullable String str, @Nullable String str2) {
        this.f3194a = str;
        this.f3195b = str2;
    }

    @Nullable
    public String altText() {
        return this.f3195b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InboxMessage.Media)) {
            return false;
        }
        InboxMessage.Media media = (InboxMessage.Media) obj;
        String str = this.f3194a;
        if (str != null ? str.equals(media.url()) : media.url() == null) {
            String str2 = this.f3195b;
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
        String str = this.f3194a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f3195b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Media{url=" + this.f3194a + ", altText=" + this.f3195b + "}";
    }

    @Nullable
    public String url() {
        return this.f3194a;
    }
}
