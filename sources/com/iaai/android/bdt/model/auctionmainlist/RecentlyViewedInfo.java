package com.iaai.android.bdt.model.auctionmainlist;

import android.content.ContentValues;
import android.database.Cursor;
import com.iaai.android.bdt.database.RecentViewContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u0011\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/RecentlyViewedInfo;", "", "()V", "userID", "", "branchNumber", "frequency", "priority", "utcDateTime", "", "auctionDate", "", "(IIIIJLjava/lang/String;)V", "suggestionsCursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "getAuctionDate", "()Ljava/lang/String;", "setAuctionDate", "(Ljava/lang/String;)V", "getBranchNumber", "()I", "setBranchNumber", "(I)V", "contentValues", "Landroid/content/ContentValues;", "getContentValues", "()Landroid/content/ContentValues;", "getFrequency", "setFrequency", "getPriority", "setPriority", "suggestionsID", "getSuggestionsID", "setSuggestionsID", "getUserID", "setUserID", "getUtcDateTime", "()J", "setUtcDateTime", "(J)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RecentlyViewedInfo.kt */
public final class RecentlyViewedInfo {
    @NotNull
    private String auctionDate;
    private int branchNumber;
    private int frequency;
    private int priority;
    private int suggestionsID;
    private int userID;
    private long utcDateTime;

    public final int getSuggestionsID() {
        return this.suggestionsID;
    }

    public final void setSuggestionsID(int i) {
        this.suggestionsID = i;
    }

    public final int getUserID() {
        return this.userID;
    }

    public final void setUserID(int i) {
        this.userID = i;
    }

    public final int getBranchNumber() {
        return this.branchNumber;
    }

    public final void setBranchNumber(int i) {
        this.branchNumber = i;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final void setFrequency(int i) {
        this.frequency = i;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final long getUtcDateTime() {
        return this.utcDateTime;
    }

    public final void setUtcDateTime(long j) {
        this.utcDateTime = j;
    }

    @NotNull
    public final String getAuctionDate() {
        return this.auctionDate;
    }

    public final void setAuctionDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.auctionDate = str;
    }

    @NotNull
    public final ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_USER_ID(), Integer.valueOf(this.userID));
        contentValues.put(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_BRANCH_NO(), Integer.valueOf(this.branchNumber));
        contentValues.put(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_FREQUENCY(), Integer.valueOf(this.frequency));
        contentValues.put(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_PRIORITY(), Integer.valueOf(this.priority));
        contentValues.put(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_AUCTION_DATE(), this.auctionDate);
        contentValues.put(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_UTC_DATE(), Long.valueOf(this.utcDateTime));
        return contentValues;
    }

    public RecentlyViewedInfo() {
        this.auctionDate = "";
    }

    public RecentlyViewedInfo(int i, int i2, int i3, int i4, long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "auctionDate");
        this.auctionDate = "";
        this.userID = i;
        this.branchNumber = i2;
        this.frequency = i3;
        this.priority = i4;
        this.utcDateTime = j / ((long) 1000);
        this.auctionDate = str;
    }

    public RecentlyViewedInfo(@Nullable Cursor cursor) {
        this.auctionDate = "";
        this.suggestionsID = 0;
        this.userID = 0;
        this.branchNumber = 0;
        this.frequency = 0;
        this.priority = 0;
        this.utcDateTime = 0;
        this.auctionDate = "";
        if (cursor != null && !cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_SUGGESTIONS_ID());
            if (!(columnIndex == -1 || cursor.getString(columnIndex) == null)) {
                this.suggestionsID = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_USER_ID());
            if (!(columnIndex2 == -1 || cursor.getString(columnIndex2) == null)) {
                this.userID = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_BRANCH_NO());
            if (!(columnIndex3 == -1 || cursor.getString(columnIndex3) == null)) {
                this.branchNumber = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_FREQUENCY());
            if (!(columnIndex4 == -1 || cursor.getString(columnIndex4) == null)) {
                this.frequency = cursor.getInt(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_PRIORITY());
            if (!(columnIndex5 == -1 || cursor.getString(columnIndex5) == null)) {
                this.priority = cursor.getInt(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_UTC_DATE());
            if (!(columnIndex6 == -1 || cursor.getString(columnIndex6) == null)) {
                this.utcDateTime = (long) cursor.getInt(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_AUCTION_DATE());
            if (columnIndex7 != -1 && cursor.getString(columnIndex7) != null) {
                this.auctionDate = String.valueOf(cursor.getInt(columnIndex7));
            }
        }
    }
}
