package com.iaai.android.old.database;

import android.net.Uri;
import android.provider.BaseColumns;

public final class SuggestionsContract {
    public static final String AUTHORITY = "com.iaai.provider.suggestions";

    private SuggestionsContract() {
    }

    public static final class Suggestions implements BaseColumns {
        public static final String COLUMN_NAME_BRANCH_NO = "branchnumber";
        public static final String COLUMN_NAME_FREQUENCY = "frequency";
        public static final String COLUMN_NAME_PRIORITY = "priority";
        public static final String COLUMN_NAME_SUGGESTIONS_ID = "suggestionsID";
        public static final String COLUMN_NAME_USER_ID = "userID";
        public static final String COLUMN_NAME_UTC_DATE = "utcdatetime";
        public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.provider.suggestions/suggestions");
        private static final String PATH_SUGGESTIONS = "/suggestions";
        private static final String SCHEME = "content://";
        public static final String TABLE_NAME = "suggestions";

        private Suggestions() {
        }
    }
}
