package com.salesforce.marketingcloud.p022d;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.d.e */
public interface C4011e {

    /* renamed from: a */
    public static final int f2893a = 0;

    /* renamed from: b */
    public static final int f2894b = 1;

    /* renamed from: c */
    public static final int f2895c = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.d.e$a */
    public @interface C4012a {
    }

    @NonNull
    /* renamed from: a */
    Map<String, Integer> mo56478a();

    /* renamed from: a */
    void mo56479a(int i, @Size(min = 1) @NonNull String... strArr);

    /* renamed from: a */
    void mo56480a(@NonNull InboxMessage inboxMessage);

    /* renamed from: a */
    void mo56481a(@NonNull String... strArr);

    /* renamed from: b */
    int mo56482b();
}
