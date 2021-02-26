package com.iaai.android.old.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.providers.IaaContent;
import com.iaai.android.old.utils.JsonSerializer;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class Alert implements Parcelable {
    public static final Parcelable.Creator<Alert> CREATOR = new Parcelable.Creator<Alert>() {
        public Alert createFromParcel(Parcel parcel) {
            return new Alert(parcel);
        }

        public Alert[] newArray(int i) {
            return new Alert[i];
        }
    };
    @JsonProperty("alertID")
    public int alertId;
    @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
    @JsonProperty("alertDate")
    public Date datetime;
    @JsonProperty("message")
    public String detail;
    @JsonProperty("EventID")
    public int eventID;
    @JsonIgnore
    public boolean isRead;
    @JsonIgnore

    /* renamed from: pk */
    public int f511pk;
    @JsonProperty("header")
    public String title;

    public int describeContents() {
        return 0;
    }

    public Alert() {
    }

    public Alert(Parcel parcel) {
        this.f511pk = parcel.readInt();
        this.alertId = parcel.readInt();
        this.eventID = parcel.readInt();
        this.title = parcel.readString();
        this.detail = parcel.readString();
        this.isRead = ParcelUtils.readBoolean(parcel);
        this.datetime = ParcelUtils.readDate(parcel);
    }

    public Alert(Cursor cursor) {
        Date date;
        this.f511pk = cursor.getInt(cursor.getColumnIndex("_id"));
        this.alertId = cursor.getInt(cursor.getColumnIndex(IaaContent.Alert.ALERT_ID));
        this.eventID = cursor.getInt(cursor.getColumnIndex(IaaContent.Alert.EVENT_ID));
        this.isRead = cursor.getInt(cursor.getColumnIndex(IaaContent.Alert.IS_READ)) != 1 ? false : true;
        this.title = cursor.getString(cursor.getColumnIndex("title"));
        this.detail = cursor.getString(cursor.getColumnIndex(IaaContent.Alert.DETAIL));
        long j = cursor.getLong(cursor.getColumnIndex(IaaContent.Alert.ALERT_DATETIME));
        j = j == 0 ? cursor.getLong(cursor.getColumnIndex(IaaContent.IaaBaseColumns.CREATED_ON)) : j;
        if (j == 0) {
            date = null;
        } else {
            date = new Date(j);
        }
        this.datetime = date;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f511pk);
        parcel.writeInt(this.alertId);
        parcel.writeInt(this.eventID);
        parcel.writeString(this.title);
        parcel.writeString(this.detail);
        ParcelUtils.writeBoolean(parcel, this.isRead);
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IaaContent.Alert.ALERT_ID, Integer.valueOf(this.alertId));
        contentValues.put(IaaContent.Alert.EVENT_ID, Integer.valueOf(this.eventID));
        contentValues.put(IaaContent.Alert.IS_READ, Boolean.valueOf(this.isRead));
        contentValues.put("title", this.title);
        contentValues.put(IaaContent.Alert.DETAIL, this.detail);
        Date date = this.datetime;
        contentValues.put(IaaContent.Alert.ALERT_DATETIME, Long.valueOf(date == null ? 0 : date.getTime()));
        return contentValues;
    }
}
