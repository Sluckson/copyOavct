package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.DateHelper;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class BranchDetail implements Parcelable {
    public static final Parcelable.Creator<BranchDetail> CREATOR = new Parcelable.Creator<BranchDetail>() {
        public BranchDetail createFromParcel(Parcel parcel) {
            return new BranchDetail(parcel);
        }

        public BranchDetail[] newArray(int i) {
            return new BranchDetail[i];
        }
    };
    @JsonProperty("br_additional_info")
    public String additionalInfo;
    @JsonProperty("br_auction_schedule")
    public String auctionSchedule;
    @JsonProperty("br_city_state_zip")
    public String cityStateZip;
    @JsonProperty("br_fax")
    public String fax;
    @JsonProperty("br_is_dirty")
    public String isDirty;
    @JsonProperty("br_is_public")
    public String isPublic;
    @JsonProperty("br_mgr_email")
    public String managerEmail;
    @JsonProperty("br_mgr_name")
    public String managerName;
    @JsonProperty("br_name")
    public String name;
    @JsonProperty("br_office_hrs_holiday")
    public String officeHoursHoliday;
    @JsonProperty("br_office_hrs_working")
    public String officeHoursWorking;
    @JsonProperty("br_onsite_preview")
    public String onsitePreview;
    @JsonProperty("br_phone")
    public String phone;
    @JsonProperty("br_street_address")
    public String streetAddress;
    @JsonIgnore
    public Date[] upcomingAuctions;
    @JsonProperty("br_yard_hrs_holiday")
    public String yardHoursHoliday;
    @JsonProperty("br_yard_hrs_working")
    public String yardHoursWorking;

    public int describeContents() {
        return 0;
    }

    public BranchDetail() {
    }

    public BranchDetail(Parcel parcel) {
        this.additionalInfo = parcel.readString();
        this.auctionSchedule = parcel.readString();
        this.cityStateZip = parcel.readString();
        this.fax = parcel.readString();
        this.isDirty = parcel.readString();
        this.isPublic = parcel.readString();
        this.managerEmail = parcel.readString();
        this.managerName = parcel.readString();
        this.name = parcel.readString();
        this.officeHoursHoliday = parcel.readString();
        this.officeHoursWorking = parcel.readString();
        this.onsitePreview = parcel.readString();
        this.phone = parcel.readString();
        this.streetAddress = parcel.readString();
        this.upcomingAuctions = (Date[]) parcel.readArray(Date[].class.getClassLoader());
        this.yardHoursHoliday = parcel.readString();
        this.yardHoursWorking = parcel.readString();
    }

    @JsonProperty("br_upcoming_auctions")
    public void setUpcomingAuctionStrings(String[] strArr) {
        if (strArr == null) {
            this.upcomingAuctions = null;
            return;
        }
        this.upcomingAuctions = new Date[strArr.length];
        int i = 0;
        for (String parseDateInServerTimezone : strArr) {
            this.upcomingAuctions[i] = DateHelper.parseDateInServerTimezone(parseDateInServerTimezone);
            i++;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.additionalInfo);
        parcel.writeString(this.auctionSchedule);
        parcel.writeString(this.cityStateZip);
        parcel.writeString(this.fax);
        parcel.writeString(this.isDirty);
        parcel.writeString(this.isPublic);
        parcel.writeString(this.managerEmail);
        parcel.writeString(this.managerName);
        parcel.writeString(this.name);
        parcel.writeString(this.officeHoursHoliday);
        parcel.writeString(this.officeHoursWorking);
        parcel.writeString(this.onsitePreview);
        parcel.writeString(this.phone);
        parcel.writeString(this.streetAddress);
        parcel.writeArray(this.upcomingAuctions);
        parcel.writeString(this.yardHoursHoliday);
        parcel.writeString(this.yardHoursWorking);
    }
}
