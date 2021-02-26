package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class MDLocationBranchDetail {
    @SerializedName("br_additional_info")
    public String additionalInfo;
    @SerializedName("AdditionalStateReq")
    public String additionalStateReq;
    @SerializedName("br_AuctionNumberingSystem")
    public ArrayList<BranchAuctionNumbering> auctionNumbering;
    @SerializedName("br_auction_schedule")
    public String auctionSchedule;
    @SerializedName("branchImage")
    public String branchImage;
    @SerializedName("branchImage2")
    public String branchImage2;
    @SerializedName("br_city_state_zip")
    public String cityStateZip;
    @SerializedName("DrivingDirections")
    public String drivingDirection;
    @SerializedName("ErrorCode")
    public String errorCode;
    @SerializedName("br_fax")
    public String fax;
    @SerializedName("br_is_dirty")
    public String isDirty;
    @SerializedName("br_is_public")
    public String isPublic;
    @SerializedName("latitude")
    public String latitude;
    @SerializedName("longitude")
    public String longitude;
    @SerializedName("br_mgr_email")
    public String managerEmail;
    @SerializedName("br_mgr_name")
    public String managerName;
    @SerializedName("br_name")
    public String name;
    @SerializedName("br_office_hours")
    public ArrayList<BranchOfficeHours> officeHours;
    @SerializedName("br_office_hrs_holiday")
    public String officeHoursHoliday;
    @SerializedName("br_office_hrs_working")
    public String officeHoursWorking;
    @SerializedName("br_onsite_preview")
    public String onsitePreview;
    @SerializedName("br_phone")
    public String phone;
    @SerializedName("br_SpecialtyNumberingSystem")
    public ArrayList<BranchSpecialityNumbering> specialityNumbering;
    @SerializedName("br_street_address")
    public String streetAddress;
    @SerializedName("br_upcoming_auctions")
    public ArrayList<String> upcomingAuctions;
    @SerializedName("week_day")
    public String weekDay;
    @SerializedName("br_yard_hours")
    public ArrayList<BranchYardHours> yardHours;
    @SerializedName("br_yard_hrs_holiday")
    public String yardHoursHoliday;
    @SerializedName("br_yard_hrs_working")
    public String yardHoursWorking;
}
