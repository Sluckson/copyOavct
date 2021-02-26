package com.iaai.android.old.analytics;

import android.net.Uri;
import android.provider.BaseColumns;

public final class AnalyticsContract {
    public static final String AUTHORITY = "com.iaai.provider.AnalyticsLite";

    private AnalyticsContract() {
    }

    public static final class Analytics implements BaseColumns {
        public static final String COLUMN_NAME_ANALYTICS_ID = "AnalyticsID";
        public static final String COLUMN_NAME_ANALYTICS_TYPE_ID = "AnalyticsTypeID";
        public static final String COLUMN_NAME_BEACON_MAJOR = "BeaconMajor";
        public static final String COLUMN_NAME_BEACON_MINOR = "BeaconMinor";
        public static final String COLUMN_NAME_BRANCH_NO = "BranchNumber";
        public static final String COLUMN_NAME_DEVICE_MODEL_NO = "DeviceModel";
        public static final String COLUMN_NAME_LANE_NO = "LaneNumber";
        public static final String COLUMN_NAME_OS_VERSION = "OSVersion";
        public static final String COLUMN_NAME_STOCK_NO = "StockNumber";
        public static final String COLUMN_NAME_USER_ID = "UserID";
        public static final String COLUMN_NAME_UTC_DATE = "UTCDateTime";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.iaai.analytics";
        public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.provider.AnalyticsLite/analytics");
        private static final String PATH_ANALYTICS = "/analytics";
        private static final String SCHEME = "content://";
        public static final String TABLE_NAME = "Analytics";

        private Analytics() {
        }
    }

    public static final class Reference implements BaseColumns {
        public static final String COLUMN_NAME_ANALYTICS_TYPE_DESC = "AnalyticsTypeDesc";
        public static final String COLUMN_NAME_ANALYTICS_TYPE_ID = "AnalyticsTypeID";
        public static final String COLUMN_NAME_IS_ACTIVE = "IsActive";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.iaai.Reference";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.iaai.Reference";
        public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.provider.AnalyticsLite/reference");
        private static final String PATH_ANALYTICS = "/reference";
        private static final String SCHEME = "content://";
        public static final String TABLE_NAME = "Reference";

        private Reference() {
        }
    }
}
