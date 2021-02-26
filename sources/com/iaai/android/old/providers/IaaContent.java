package com.iaai.android.old.providers;

import android.net.Uri;
import android.provider.BaseColumns;

public final class IaaContent {
    public static final String AUTHORITY = "com.iaai.android.old.providers.Iaa";

    protected static abstract class IaaBaseColumns implements BaseColumns {
        public static final String CREATED_ON = "created";

        protected IaaBaseColumns() {
        }
    }

    public static final class SearchHistory extends IaaBaseColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.iaa.searchhistory";
        public static final String CONTENT_NAME = "searchhistory";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.iaa.searchhistory";
        public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.android.old.providers.Iaa/searchhistory");
        public static final String DEFAULT_SORT_ORDER = "created DESC";
        public static final String SEARCH_TEXT = "searchText";
        public static final String SORT_ORDER_DESC_CREATED_ON = "created DESC";

        private SearchHistory() {
        }
    }

    public static final class C2dmRegistration extends IaaBaseColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.iaa.c2dmregistration";
        public static final String CONTENT_NAME = "c2dmregistration";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.iaa.c2dmregistration";
        public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.android.old.providers.Iaa/c2dmregistration");
        public static final String DEFAULT_SORT_ORDER = "created DESC";
        public static final String IS_SYNC = "isSync";
        public static final String REGISTRATION_ID = "registrationId";
        public static final String SENDER_ID = "senderId";
        public static final String SORT_ORDER_DESC_CREATED_ON = "created DESC";

        private C2dmRegistration() {
        }
    }

    public static final class Alert extends IaaBaseColumns {
        public static final String ALERT_DATETIME = "alertDateTime";
        public static final String ALERT_ID = "alertId";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.iaa.alert";
        public static final String CONTENT_NAME = "alert";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.iaa.alert";
        public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.android.old.providers.Iaa/alert");
        public static final String DEFAULT_SORT_ORDER = "created DESC";
        public static final String DETAIL = "detail";
        public static final String EVENT_ID = "eventId";
        public static final String IS_READ = "isRead";
        public static final String SORT_ORDER_DESC_CREATED_ON = "created DESC";
        public static final String TITLE = "title";

        private Alert() {
        }
    }
}
