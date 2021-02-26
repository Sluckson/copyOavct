package com.iaai.android.old.models;

import android.content.ContentValues;
import android.database.Cursor;

public class SuggestionsInfo {
    private int branchNumber;
    private int frequency;
    private int priority;
    private int suggestionsID;
    private int userID;
    private long utcDateTime;

    public int getSuggestionsID() {
        return this.suggestionsID;
    }

    public void setSuggestionsID(int i) {
        this.suggestionsID = i;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int i) {
        this.userID = i;
    }

    public int getBranchNumber() {
        return this.branchNumber;
    }

    public void setBranchNumber(int i) {
        this.branchNumber = i;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int i) {
        this.frequency = i;
    }

    public long getUtcDateTime() {
        return this.utcDateTime;
    }

    public void setUtcDateTime(long j) {
        this.utcDateTime = j;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public SuggestionsInfo() {
    }

    public SuggestionsInfo(int i, int i2, int i3, int i4, long j) {
        this.userID = i;
        this.branchNumber = i2;
        this.frequency = i3;
        this.priority = i4;
        this.utcDateTime = j / 1000;
    }

    public SuggestionsInfo(Cursor cursor) {
        this.suggestionsID = 0;
        this.userID = 0;
        this.branchNumber = 0;
        this.frequency = 0;
        this.priority = 0;
        this.utcDateTime = 0;
        if (cursor != null && !cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex("suggestionsID");
            if (!(columnIndex == -1 || cursor.getString(columnIndex) == null)) {
                this.suggestionsID = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("userID");
            if (!(columnIndex2 == -1 || cursor.getString(columnIndex2) == null)) {
                this.userID = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("branchnumber");
            if (!(columnIndex3 == -1 || cursor.getString(columnIndex3) == null)) {
                this.branchNumber = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("frequency");
            if (!(columnIndex4 == -1 || cursor.getString(columnIndex4) == null)) {
                this.frequency = cursor.getInt(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("priority");
            if (!(columnIndex5 == -1 || cursor.getString(columnIndex5) == null)) {
                this.priority = cursor.getInt(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("utcdatetime");
            if (columnIndex6 != -1 && cursor.getString(columnIndex6) != null) {
                this.utcDateTime = (long) cursor.getInt(columnIndex6);
            }
        }
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("userID", Integer.valueOf(this.userID));
        contentValues.put("branchnumber", Integer.valueOf(this.branchNumber));
        contentValues.put("frequency", Integer.valueOf(this.frequency));
        contentValues.put("priority", Integer.valueOf(this.priority));
        contentValues.put("utcdatetime", Long.valueOf(this.utcDateTime));
        return contentValues;
    }
}
