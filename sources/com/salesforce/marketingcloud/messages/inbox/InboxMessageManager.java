package com.salesforce.marketingcloud.messages.inbox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;
import java.util.List;

@MCKeep
public interface InboxMessageManager {

    @MCKeep
    public interface InboxRefreshListener {
        void onRefreshComplete(boolean z);
    }

    @MCKeep
    public interface InboxResponseListener {
        void onInboxMessagesChanged(@NonNull List<InboxMessage> list);
    }

    void deleteMessage(@NonNull InboxMessage inboxMessage);

    int getDeletedMessageCount();

    @NonNull
    List<InboxMessage> getDeletedMessages();

    int getMessageCount();

    @NonNull
    List<InboxMessage> getMessages();

    int getReadMessageCount();

    @NonNull
    List<InboxMessage> getReadMessages();

    int getUnreadMessageCount();

    @NonNull
    List<InboxMessage> getUnreadMessages();

    void markAllMessagesDeleted();

    void markAllMessagesRead();

    void refreshInbox(@Nullable InboxRefreshListener inboxRefreshListener);

    void registerInboxResponseListener(@NonNull InboxResponseListener inboxResponseListener);

    void setMessageRead(@NonNull InboxMessage inboxMessage);

    void unregisterInboxResponseListener(@NonNull InboxResponseListener inboxResponseListener);
}
