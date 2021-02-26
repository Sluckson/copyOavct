package com.iaai.android.old.analytics.classes;

import android.content.ContentValues;
import android.database.Cursor;
import com.iaai.android.old.analytics.AnalyticsContract;
import org.codehaus.jackson.annotate.JsonProperty;

public class ReferenceInfo {
    @JsonProperty("AnalyticsTypeDesc")
    private String mAnalyticsTypeDesc;
    @JsonProperty("AnalyticsTypeID")
    private int mAnalyticsTypeID;
    @JsonProperty("isActive")
    private boolean mIsActive;

    public ReferenceInfo() {
    }

    public ReferenceInfo(int i, String str, boolean z) {
        this.mAnalyticsTypeID = i;
        this.mAnalyticsTypeDesc = str;
        this.mIsActive = z;
    }

    public ReferenceInfo(Cursor cursor) {
        boolean z = false;
        this.mAnalyticsTypeID = 0;
        this.mAnalyticsTypeDesc = null;
        this.mIsActive = false;
        if (cursor != null && !cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex("AnalyticsTypeID");
            if (!(columnIndex == -1 || cursor.getString(columnIndex) == null)) {
                this.mAnalyticsTypeID = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(AnalyticsContract.Reference.COLUMN_NAME_ANALYTICS_TYPE_DESC);
            if (!(columnIndex2 == -1 || cursor.getString(columnIndex2) == null)) {
                this.mAnalyticsTypeDesc = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex(AnalyticsContract.Reference.COLUMN_NAME_IS_ACTIVE);
            if (columnIndex3 != -1 && cursor.getString(columnIndex3) != null) {
                this.mIsActive = cursor.getInt(columnIndex3) == 1 ? true : z;
            }
        }
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("AnalyticsTypeID", Integer.valueOf(this.mAnalyticsTypeID));
        contentValues.put(AnalyticsContract.Reference.COLUMN_NAME_ANALYTICS_TYPE_DESC, this.mAnalyticsTypeDesc);
        contentValues.put(AnalyticsContract.Reference.COLUMN_NAME_IS_ACTIVE, Integer.valueOf(this.mIsActive ? 1 : 0));
        return contentValues;
    }

    public boolean getIsActive() {
        return this.mIsActive;
    }

    public void setIsActive(boolean z) {
        this.mIsActive = z;
    }

    public String getAnalyticsTypeDesc() {
        return this.mAnalyticsTypeDesc;
    }

    public void setAnalyticsTypeDesc(String str) {
        this.mAnalyticsTypeDesc = str;
    }

    public int getAnalyticsTypeID() {
        return this.mAnalyticsTypeID;
    }

    public void setAnalyticsTypeID(int i) {
        this.mAnalyticsTypeID = i;
    }
}
