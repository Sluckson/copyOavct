package com.salesforce.marketingcloud.p022d;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.util.List;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.f */
public interface C4013f {

    /* renamed from: com.salesforce.marketingcloud.d.f$a */
    public enum C4014a {
        UNREAD,
        READ,
        DELETED,
        NOT_DELETED
    }

    /* renamed from: a */
    int mo56465a();

    /* renamed from: a */
    int mo56466a(@NonNull C4014a aVar);

    @Nullable
    /* renamed from: a */
    InboxMessage mo56467a(@NonNull String str, @NonNull C4022a aVar);

    /* renamed from: a */
    List<InboxMessage> mo56468a(@NonNull C4022a aVar);

    @NonNull
    /* renamed from: a */
    List<InboxMessage> mo56469a(@NonNull C4022a aVar, C4014a aVar2);

    /* renamed from: a */
    void mo56470a(@NonNull InboxMessage inboxMessage, @NonNull C4022a aVar);

    /* renamed from: a */
    boolean mo56471a(@NonNull String str);

    /* renamed from: b */
    int mo56472b(@NonNull InboxMessage inboxMessage, @NonNull C4022a aVar);

    /* renamed from: b */
    List<InboxMessage> mo56473b(@NonNull C4022a aVar);

    @NonNull
    /* renamed from: b */
    String[] mo56474b();

    @NonNull
    /* renamed from: c */
    String[] mo56475c();
}
