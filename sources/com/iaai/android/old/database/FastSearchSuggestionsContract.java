package com.iaai.android.old.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class FastSearchSuggestionsContract {
    public static final String AUTHORITY = "com.iaai.provider.fastsearch.suggestions";

    private FastSearchSuggestionsContract() {
    }

    public static final class FastSearchSuggestions implements BaseColumns {
        public static final String COLUMN_NAME_FS_BRANCH_NAME = "branchName";
        public static final String COLUMN_NAME_FS_BRANCH_NO = "branchnumber";
        public static final String COLUMN_NAME_FS_FREQUENCY = "frequency";
        public static final String COLUMN_NAME_FS_PRIORITY = "priority";
        public static final String COLUMN_NAME_FS_SUGGESTIONS_ID = "suggestionsID";
        public static final String COLUMN_NAME_FS_UTC_DATE = "utcdatetime";
        public static final Uri CONTENT_URI = Uri.parse("content://com.iaai.provider.fastsearch.suggestions/fastsearchsuggestions");
        private static final String PATH_SUGGESTIONS = "/fastsearchsuggestions";
        private static final String SCHEME = "content://";
        public static final String TABLE_NAME = "fastsearchsuggestions";

        private FastSearchSuggestions() {
        }
    }
}
