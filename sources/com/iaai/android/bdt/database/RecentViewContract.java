package com.iaai.android.bdt.database;

import android.net.Uri;
import android.provider.BaseColumns;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewContract;", "", "()V", "SuggestionsContract", "", "Companion", "Suggestions", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RecentViewContract.kt */
public final class RecentViewContract {
    /* access modifiers changed from: private */
    @NotNull
    public static final String AUTHORITY = AUTHORITY;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    private final void SuggestionsContract() {
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewContract$Companion;", "", "()V", "AUTHORITY", "", "getAUTHORITY", "()Ljava/lang/String;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RecentViewContract.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getAUTHORITY() {
            return RecentViewContract.AUTHORITY;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewContract$Suggestions;", "Landroid/provider/BaseColumns;", "()V", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RecentViewContract.kt */
    public static final class Suggestions implements BaseColumns {
        /* access modifiers changed from: private */
        @NotNull
        public static final String COLUMN_NAME_AUCTION_DATE = COLUMN_NAME_AUCTION_DATE;
        /* access modifiers changed from: private */
        @NotNull
        public static final String COLUMN_NAME_BRANCH_NO = "branchnumber";
        /* access modifiers changed from: private */
        @NotNull
        public static final String COLUMN_NAME_FREQUENCY = "frequency";
        /* access modifiers changed from: private */
        @NotNull
        public static final String COLUMN_NAME_PRIORITY = "priority";
        /* access modifiers changed from: private */
        @NotNull
        public static final String COLUMN_NAME_SUGGESTIONS_ID = "suggestionsID";
        /* access modifiers changed from: private */
        @NotNull
        public static final String COLUMN_NAME_USER_ID = "userID";
        /* access modifiers changed from: private */
        @NotNull
        public static final String COLUMN_NAME_UTC_DATE = "utcdatetime";
        /* access modifiers changed from: private */
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + RecentViewContract.Companion.getAUTHORITY() + PATH_SUGGESTIONS);
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String PATH_SUGGESTIONS = PATH_SUGGESTIONS;
        private static final String SCHEME = SCHEME;
        /* access modifiers changed from: private */
        @NotNull
        public static final String TABLE_NAME = TABLE_NAME;

        @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/database/RecentViewContract$Suggestions$Companion;", "", "()V", "COLUMN_NAME_AUCTION_DATE", "", "getCOLUMN_NAME_AUCTION_DATE", "()Ljava/lang/String;", "COLUMN_NAME_BRANCH_NO", "getCOLUMN_NAME_BRANCH_NO", "COLUMN_NAME_FREQUENCY", "getCOLUMN_NAME_FREQUENCY", "COLUMN_NAME_PRIORITY", "getCOLUMN_NAME_PRIORITY", "COLUMN_NAME_SUGGESTIONS_ID", "getCOLUMN_NAME_SUGGESTIONS_ID", "COLUMN_NAME_USER_ID", "getCOLUMN_NAME_USER_ID", "COLUMN_NAME_UTC_DATE", "getCOLUMN_NAME_UTC_DATE", "CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getCONTENT_URI", "()Landroid/net/Uri;", "PATH_SUGGESTIONS", "SCHEME", "TABLE_NAME", "getTABLE_NAME", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
        /* compiled from: RecentViewContract.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final String getTABLE_NAME() {
                return Suggestions.TABLE_NAME;
            }

            public final Uri getCONTENT_URI() {
                return Suggestions.CONTENT_URI;
            }

            @NotNull
            public final String getCOLUMN_NAME_SUGGESTIONS_ID() {
                return Suggestions.COLUMN_NAME_SUGGESTIONS_ID;
            }

            @NotNull
            public final String getCOLUMN_NAME_USER_ID() {
                return Suggestions.COLUMN_NAME_USER_ID;
            }

            @NotNull
            public final String getCOLUMN_NAME_BRANCH_NO() {
                return Suggestions.COLUMN_NAME_BRANCH_NO;
            }

            @NotNull
            public final String getCOLUMN_NAME_FREQUENCY() {
                return Suggestions.COLUMN_NAME_FREQUENCY;
            }

            @NotNull
            public final String getCOLUMN_NAME_UTC_DATE() {
                return Suggestions.COLUMN_NAME_UTC_DATE;
            }

            @NotNull
            public final String getCOLUMN_NAME_AUCTION_DATE() {
                return Suggestions.COLUMN_NAME_AUCTION_DATE;
            }

            @NotNull
            public final String getCOLUMN_NAME_PRIORITY() {
                return Suggestions.COLUMN_NAME_PRIORITY;
            }
        }

        private Suggestions() {
        }
    }
}
