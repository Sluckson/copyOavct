package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.ParcelUtils;
import com.iaai.android.old.utils.constants.Constants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import roboguice.util.C5058Ln;

public class Vehicle implements Parcelable {
    public static final Parcelable.Creator<Vehicle> CREATOR = new Parcelable.Creator<Vehicle>() {
        public Vehicle createFromParcel(Parcel parcel) {
            return new Vehicle(parcel);
        }

        public Vehicle[] newArray(int i) {
            return new Vehicle[i];
        }
    };
    public static final int PREBID_STATE_CLOSED = 2;
    public static final int PREBID_STATE_IN_PROGRESS = 1;
    public static final int PREBID_STATE_NOT_STARTED = 0;
    @JsonIgnore
    public ArrayList<VehicleDetailGroup> additionalInfo;
    @JsonProperty("auctionid")
    public String auctionId;
    @JsonIgnore
    public int bidCount;
    @JsonIgnore
    public int bidderCount;
    @JsonProperty("branchcode")
    public String branchCode;
    public String branchName;
    @JsonIgnore
    public boolean canBeWatched;
    @JsonIgnore
    public boolean canUserBid;
    @JsonIgnore
    public boolean canUserBuyNow;
    @JsonProperty("FloatingFifthElement")
    public String contextDrivenField;
    @JsonProperty("CurrentHigh")
    public BigDecimal currentHighAmount;
    @JsonIgnore
    public ArrayList<String> deepZoomImageHeights;
    @JsonIgnore
    public ArrayList<String> deepZoomImageUrls;
    @JsonIgnore
    public ArrayList<String> deepZoomImageWidths;
    public String fourthElementHistory;
    @JsonIgnore
    public ArrayList<String> fullImageUrls;
    @JsonIgnore
    public boolean hasIBuyFast;
    @JsonIgnore
    public boolean hasUserData;
    @JsonIgnore
    public boolean hasUserPlacedBidBefore;
    @JsonProperty
    public Date ibidLiveStartTime;
    @JsonIgnore
    public BigDecimal ibuyFastAmount;
    @JsonIgnore
    public Date ibuyFastEndTime;
    @JsonProperty("thumbnailurl")
    public String imageUrl;
    @JsonIgnore
    public boolean isAuctionClosed;
    @JsonIgnore
    public boolean isBeingWatched;
    @JsonIgnore
    public boolean isCurrentUserHighBidder;
    @JsonIgnore
    public boolean isIBuyFastSold;
    @JsonIgnore
    public boolean isOffSite;
    @JsonIgnore
    public boolean isPublic;
    @JsonIgnore
    public boolean isRunDrive;
    @JsonIgnore
    public boolean isRunStarts;
    @JsonIgnore
    public boolean isSealedbid;
    @JsonIgnore
    public boolean isShrinkWrap;
    @JsonIgnore
    public boolean isSoldIndicator;
    @JsonProperty("itemid")
    public String itemId;
    @JsonIgnore
    public String itemNumber;
    public String lane;
    public String liveDatePreSale;
    @JsonProperty("LossType")
    public String lossType;
    @JsonProperty("vehiclemake")
    public String make;
    @JsonProperty("vehiclemodel")
    public String model;
    @JsonIgnore
    public int odometerInt;
    @JsonProperty
    public Date preBidEndTime;
    @JsonIgnore
    public int prebidState;
    public String prebidStatus;
    public String prebidStatusColor;
    public String primaryDamage;
    public String providerName;
    @JsonIgnore
    public String reasonUserCannotBid;
    @JsonIgnore
    public String reasonUserCannotBuyNow;
    @JsonProperty("ReceiptDescription")
    public String receiptDescription;
    @JsonProperty("ReceiptNo")
    public String receiptNo;
    public String slot;
    public String stateAbbrivation;
    public int status;
    @JsonProperty("stockno")
    public String stockNo;
    @JsonIgnore
    public String userCurrentBidAmount;
    @JsonIgnore
    public String userPreBidMaxAmount;
    public String year;

    public int describeContents() {
        return 0;
    }

    public Vehicle() {
    }

    public Vehicle(Parcel parcel) {
        this.auctionId = parcel.readString();
        this.branchName = parcel.readString();
        this.branchCode = parcel.readString();
        this.itemId = parcel.readString();
        this.lossType = parcel.readString();
        this.odometerInt = parcel.readInt();
        this.primaryDamage = parcel.readString();
        this.slot = parcel.readString();
        this.lane = parcel.readString();
        this.providerName = parcel.readString();
        this.stockNo = parcel.readString();
        this.stateAbbrivation = parcel.readString();
        this.status = parcel.readInt();
        this.prebidStatus = parcel.readString();
        this.prebidStatusColor = parcel.readString();
        this.liveDatePreSale = parcel.readString();
        this.fourthElementHistory = parcel.readString();
        this.receiptNo = parcel.readString();
        this.receiptDescription = parcel.readString();
        this.make = parcel.readString();
        this.model = parcel.readString();
        this.year = parcel.readString();
        this.imageUrl = parcel.readString();
        this.isRunDrive = ParcelUtils.readBoolean(parcel);
        this.isRunStarts = ParcelUtils.readBoolean(parcel);
        this.isOffSite = ParcelUtils.readBoolean(parcel);
        this.isShrinkWrap = ParcelUtils.readBoolean(parcel);
        this.currentHighAmount = ParcelUtils.readBigDecimal(parcel);
        this.isCurrentUserHighBidder = ParcelUtils.readBoolean(parcel);
        this.preBidEndTime = ParcelUtils.readDate(parcel);
        this.ibidLiveStartTime = ParcelUtils.readDate(parcel);
        this.ibuyFastAmount = ParcelUtils.readBigDecimal(parcel);
        this.ibuyFastEndTime = ParcelUtils.readDate(parcel);
        this.hasIBuyFast = ParcelUtils.readBoolean(parcel);
        this.isIBuyFastSold = ParcelUtils.readBoolean(parcel);
        this.isSoldIndicator = ParcelUtils.readBoolean(parcel);
        this.hasUserData = ParcelUtils.readBoolean(parcel);
        this.hasUserPlacedBidBefore = ParcelUtils.readBoolean(parcel);
        this.isSealedbid = ParcelUtils.readBoolean(parcel);
        this.prebidState = parcel.readInt();
        this.canUserBid = ParcelUtils.readBoolean(parcel);
        this.reasonUserCannotBid = parcel.readString();
        this.canUserBuyNow = ParcelUtils.readBoolean(parcel);
        this.reasonUserCannotBuyNow = parcel.readString();
        this.userCurrentBidAmount = parcel.readString();
        this.bidderCount = parcel.readInt();
        this.bidCount = parcel.readInt();
        this.itemNumber = parcel.readString();
        this.isAuctionClosed = ParcelUtils.readBoolean(parcel);
        this.isBeingWatched = ParcelUtils.readBoolean(parcel);
        this.canBeWatched = ParcelUtils.readBoolean(parcel);
        this.isPublic = ParcelUtils.readBoolean(parcel);
        this.userPreBidMaxAmount = parcel.readString();
        this.fullImageUrls = new ArrayList<>();
        parcel.readStringList(this.fullImageUrls);
        this.additionalInfo = parcel.readArrayList(VehicleDetailGroup.class.getClassLoader());
        this.deepZoomImageUrls = new ArrayList<>();
        this.deepZoomImageWidths = new ArrayList<>();
        this.deepZoomImageHeights = new ArrayList<>();
        parcel.readStringList(this.deepZoomImageUrls);
        parcel.readStringList(this.deepZoomImageWidths);
        parcel.readStringList(this.deepZoomImageHeights);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.auctionId);
        parcel.writeString(this.branchName);
        parcel.writeString(this.branchCode);
        parcel.writeString(this.itemId);
        parcel.writeString(this.lossType);
        parcel.writeInt(this.odometerInt);
        parcel.writeString(this.primaryDamage);
        parcel.writeString(this.slot);
        parcel.writeString(this.lane);
        parcel.writeString(this.providerName);
        parcel.writeString(this.stockNo);
        parcel.writeString(this.stateAbbrivation);
        parcel.writeInt(this.status);
        parcel.writeString(this.prebidStatus);
        parcel.writeString(this.prebidStatusColor);
        parcel.writeString(this.liveDatePreSale);
        parcel.writeString(this.fourthElementHistory);
        parcel.writeString(this.receiptNo);
        parcel.writeString(this.receiptDescription);
        parcel.writeString(this.make);
        parcel.writeString(this.model);
        parcel.writeString(this.year);
        parcel.writeString(this.imageUrl);
        ParcelUtils.writeBoolean(parcel, this.isRunDrive);
        ParcelUtils.writeBoolean(parcel, this.isRunStarts);
        ParcelUtils.writeBoolean(parcel, this.isOffSite);
        ParcelUtils.writeBoolean(parcel, this.isShrinkWrap);
        ParcelUtils.writeBigDecimal(parcel, this.currentHighAmount);
        ParcelUtils.writeBoolean(parcel, this.isCurrentUserHighBidder);
        ParcelUtils.writeDate(parcel, this.preBidEndTime);
        ParcelUtils.writeDate(parcel, this.ibidLiveStartTime);
        ParcelUtils.writeBigDecimal(parcel, this.ibuyFastAmount);
        ParcelUtils.writeDate(parcel, this.ibuyFastEndTime);
        ParcelUtils.writeBoolean(parcel, this.hasIBuyFast);
        ParcelUtils.writeBoolean(parcel, this.isIBuyFastSold);
        ParcelUtils.writeBoolean(parcel, this.isSoldIndicator);
        ParcelUtils.writeBoolean(parcel, this.hasUserData);
        ParcelUtils.writeBoolean(parcel, this.hasUserPlacedBidBefore);
        ParcelUtils.writeBoolean(parcel, this.isSealedbid);
        parcel.writeInt(this.prebidState);
        ParcelUtils.writeBoolean(parcel, this.canUserBid);
        this.reasonUserCannotBid = parcel.readString();
        ParcelUtils.writeBoolean(parcel, this.canUserBuyNow);
        this.reasonUserCannotBuyNow = parcel.readString();
        this.userCurrentBidAmount = parcel.readString();
        parcel.writeInt(this.bidderCount);
        parcel.writeInt(this.bidCount);
        parcel.writeString(this.itemNumber);
        ParcelUtils.writeBoolean(parcel, this.isAuctionClosed);
        ParcelUtils.writeBoolean(parcel, this.isBeingWatched);
        ParcelUtils.writeBoolean(parcel, this.canBeWatched);
        ParcelUtils.writeBoolean(parcel, this.isPublic);
        parcel.writeString(this.userPreBidMaxAmount);
        parcel.writeStringList(this.fullImageUrls);
        parcel.writeTypedList(this.additionalInfo);
        parcel.writeStringList(this.deepZoomImageUrls);
        parcel.writeStringList(this.deepZoomImageWidths);
        parcel.writeStringList(this.deepZoomImageHeights);
    }

    @JsonSetter("offsitesaleindicator")
    public void setOffsitesaleindicator(String str) {
        this.isOffSite = ParcelUtils.isTrue(str);
    }

    @JsonSetter("runanddrive")
    public void setRunAndDrive(String str) {
        this.isRunDrive = ParcelUtils.isTrue(str);
    }

    @JsonSetter("odometer")
    public void setOdometerString(String str) {
        int i;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!Constants.STR_NA.equals(str)) {
                    i = Integer.parseInt(str);
                    this.odometerInt = i;
                }
            }
            i = 0;
            this.odometerInt = i;
        } catch (Exception unused) {
            this.odometerInt = 0;
        }
    }

    @JsonSetter("BranchCode")
    public void setBranchCode(String str) {
        this.branchCode = str;
    }

    @JsonSetter("BranchName")
    public void setBranchName(String str) {
        this.branchName = str;
    }

    @JsonSetter("Branchname")
    public void setBranchName2(String str) {
        this.branchName = str;
    }

    @JsonSetter("AuctionId")
    public void setAuctionId(String str) {
        this.auctionId = str;
    }

    @JsonSetter("Damage")
    public void setDamage(String str) {
        this.primaryDamage = str;
    }

    @JsonSetter("primarydamage")
    public void setpDamage(String str) {
        if (str != null && str.trim() != "") {
            this.primaryDamage = str;
        }
    }

    @JsonSetter("Damage2")
    public void setDamage2(String str) {
        this.lossType = str;
    }

    @JsonSetter("LossType")
    public void setLossType(String str) {
        this.lossType = str;
    }

    @JsonSetter("losstype")
    public void setlosstype(String str) {
        if (str != null && str.trim() != "") {
            this.lossType = str;
        }
    }

    @JsonSetter("ItemId")
    public void setItemId(int i) {
        this.itemId = Integer.toString(i);
    }

    @JsonSetter("Make")
    public void setMake(String str) {
        this.make = str;
    }

    @JsonSetter("Model")
    public void setModel(String str) {
        this.model = str;
    }

    @JsonSetter("Odometer")
    public void setOdometerInt(String str) {
        setOdometerString(str);
    }

    @JsonSetter("ThumbnailUrl")
    public void setThumbnailUrl(String str) {
        this.imageUrl = str;
    }

    @JsonSetter("ImageURL")
    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    @JsonSetter("Year")
    public void setYear(int i) {
        this.year = i == 0 ? null : Integer.toString(i);
    }

    @JsonSetter("Slot")
    public void setSlot(String str) {
        this.slot = str;
    }

    @JsonSetter("Lane")
    public void setLane(String str) {
        this.lane = str;
    }

    @JsonSetter("ProviderName")
    public void serProviderName(String str) {
        this.providerName = str;
    }

    @JsonSetter("state")
    public void setStateAbbrivation(String str) {
        this.stateAbbrivation = str;
    }

    @JsonSetter("status")
    public void setstatus(int i) {
        this.status = i;
    }

    @JsonSetter("prebidStatus")
    public void setPrebidStatus(String str) {
        this.prebidStatus = str;
    }

    @JsonSetter("prebidStatusColor")
    public void setPrebidStatusColor(String str) {
        this.prebidStatusColor = str;
    }

    @JsonSetter("liveDatePreSale")
    public void setLiveDatePreSale(String str) {
        this.liveDatePreSale = str;
    }

    @JsonSetter("fourthElementHistory")
    public void setLivefourthElementHistory(String str) {
        this.fourthElementHistory = str;
    }

    @JsonSetter("AuctionStartsAt")
    public void setAutcionStartsAt(String str) {
        this.ibidLiveStartTime = DateHelper.parseDateInServerTimezone(str);
    }

    @JsonSetter("StockNumber")
    public void setStockNumber(String str) {
        this.stockNo = str;
    }

    @JsonSetter("Itemid")
    public void setItemId(String str) {
        this.itemId = str;
    }

    public void populate(VehicleDetailGroup[] vehicleDetailGroupArr) {
        ArrayList<VehicleDetailGroup> arrayList = this.additionalInfo;
        if (arrayList == null) {
            this.additionalInfo = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        for (VehicleDetailGroup vehicleDetailGroup : vehicleDetailGroupArr) {
            if ("Header".equals(vehicleDetailGroup.key)) {
                populateHeaderData(vehicleDetailGroup.value);
            } else if ("Icons".equals(vehicleDetailGroup.key)) {
                populateIconsData(vehicleDetailGroup.value);
            } else if ("Full Images".equals(vehicleDetailGroup.key)) {
                populateFullImageData(vehicleDetailGroup.value);
            } else if ("Actions".equals(vehicleDetailGroup.key)) {
                populateActionInfo(vehicleDetailGroup.value);
            } else if ("Deep Zoom Images".equals(vehicleDetailGroup.key)) {
                populateDeepZoomImageURLsData(vehicleDetailGroup.value);
            } else if ("DeepZoom ImageWidth".equals(vehicleDetailGroup.key)) {
                populateDeepZoomImageWidthData(vehicleDetailGroup.value);
            } else if ("DeepZoom ImageHeight".equals(vehicleDetailGroup.key)) {
                populateDeepZoomImageHeightData(vehicleDetailGroup.value);
            } else if (!"Thumb Nails".equals(vehicleDetailGroup.key) && !"Icons".equals(vehicleDetailGroup.key)) {
                this.additionalInfo.add(vehicleDetailGroup);
            }
        }
    }

    public static Vehicle fromVehicleDetails(VehicleDetailGroup[] vehicleDetailGroupArr) {
        Vehicle vehicle = new Vehicle();
        vehicle.populate(vehicleDetailGroupArr);
        return vehicle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.year)) {
            sb.append(this.year);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
        if (!TextUtils.isEmpty(this.make)) {
            sb.append(this.make);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
        if (!TextUtils.isEmpty(this.model)) {
            sb.append(this.model);
        }
        return sb.toString();
    }

    private void populateHeaderData(VehicleDetailItem[] vehicleDetailItemArr) {
        for (VehicleDetailItem vehicleDetailItem : vehicleDetailItemArr) {
            String str = vehicleDetailItem.key;
            String str2 = vehicleDetailItem.value;
            if ("Year".equals(str)) {
                this.year = str2;
            } else if (ExifInterface.TAG_MAKE.equals(str)) {
                this.make = str2;
            } else if (ExifInterface.TAG_MODEL.equals(str)) {
                this.model = str2;
            } else if ("Item #".equals(str)) {
                this.itemNumber = str2;
            } else if ("ItemId".equals(str)) {
                this.itemId = str2;
            } else if ("AuctionId".equals(str)) {
                this.auctionId = str2;
            } else {
                C5058Ln.m4832e("Header Data Variable is not handled - %s", vehicleDetailItem);
            }
        }
    }

    private void populateIconsData(VehicleDetailItem[] vehicleDetailItemArr) {
        for (VehicleDetailItem vehicleDetailItem : vehicleDetailItemArr) {
            String str = vehicleDetailItem.key;
            boolean isTrue = ParcelUtils.isTrue(vehicleDetailItem.value);
            if ("R&D".equals(str)) {
                this.isRunDrive = isTrue;
            } else if ("Starts".equals(str)) {
                this.isRunStarts = isTrue;
            } else if ("Off Site".equals(str)) {
                this.isOffSite = isTrue;
            } else if ("Shrink Wrap".equals(str)) {
                this.isShrinkWrap = isTrue;
            } else {
                C5058Ln.m4832e("Icon Data Variable is not handled - %s", vehicleDetailItem);
            }
        }
    }

    private void populateActionInfo(VehicleDetailItem[] vehicleDetailItemArr) {
        for (VehicleDetailItem vehicleDetailItem : vehicleDetailItemArr) {
            String str = vehicleDetailItem.key;
            String str2 = vehicleDetailItem.value;
            Log.d("populateActionInfo-->", "detailItem--->" + vehicleDetailItem.key);
            if ("PreBidCurrentHigh".equals(str)) {
                this.currentHighAmount = ParcelUtils.toBigDecimal(str2);
            } else if ("IsCurrentUserHighBidder".equals(str)) {
                this.isCurrentUserHighBidder = ParcelUtils.isTrue(str2);
            } else if ("PreBidEndTime".equals(str)) {
                this.preBidEndTime = DateHelper.parseDateInServerTimezone(str2);
            } else if ("IBidLiveStartTime".equals(str)) {
                this.ibidLiveStartTime = DateHelper.parseDateInServerTimezone(str2);
            } else if ("IBuyFastAmount".equals(str)) {
                this.ibuyFastAmount = ParcelUtils.toBigDecimal(str2);
            } else if ("IBuyFastEndTime".equals(str)) {
                this.ibuyFastEndTime = DateHelper.parseDateInServerTimezone(str2);
            } else if ("IBuyFastIndicator".equals(str)) {
                this.hasIBuyFast = ParcelUtils.isTrue(str2);
            } else if ("IBuyFastSoldIndicator".equals(str)) {
                this.isIBuyFastSold = ParcelUtils.isTrue(str2);
                Log.d("populateActionInfo-->", "populateActionInfo-isIBuyFastSold-->" + this.isIBuyFastSold);
            } else if ("soldindicator".equals(str)) {
                this.isSoldIndicator = ParcelUtils.isTrue(str2);
                Log.d("populateActionInfo-->", "populateActionInfo-isSoldIndicator-->" + this.isSoldIndicator);
            } else if ("LoginIndicator".equals(str)) {
                this.hasUserData = ParcelUtils.isTrue(str2);
            } else if ("UserPlacedBidBefore".equals(str)) {
                this.hasUserPlacedBidBefore = ParcelUtils.isTrue(str2);
            } else if ("IsSealedbid".equals(str)) {
                this.isSealedbid = ParcelUtils.isTrue(str2);
            } else if ("Pre-BidFlag".equals(str)) {
                this.prebidState = ParcelUtils.toInt(str2);
            } else if ("CanUserBid".equals(str)) {
                this.canUserBid = ParcelUtils.isTrue(str2);
            } else if ("WhyUserCannotBid".equals(str)) {
                this.reasonUserCannotBid = str2;
            } else if ("CanUserBuyUsingIbuyfast".equals(str)) {
                this.canUserBuyNow = ParcelUtils.isTrue(str2);
            } else if ("WhyUserCannotBuyUsingIbuyfast".equals(str)) {
                this.reasonUserCannotBuyNow = str2;
            } else if ("MyCurrent".equals(str)) {
                this.userCurrentBidAmount = str2;
            } else if ("NumberOfBiddersOnThatItem".equals(str)) {
                this.bidderCount = TextUtils.isDigitsOnly(str2) ? Integer.parseInt(str2) : 0;
            } else if ("NumberOfBidsOnThatItem".equals(str)) {
                this.bidCount = TextUtils.isDigitsOnly(str2) ? Integer.parseInt(str2) : 0;
            } else if ("MyMax".equals(str)) {
                this.userPreBidMaxAmount = str2;
            } else if ("AuctionClosedIndicator".equals(str)) {
                this.isAuctionClosed = ParcelUtils.isTrue(str2);
            } else if ("IsBeingWatched".equals(str)) {
                this.isBeingWatched = ParcelUtils.isTrue(str2);
            } else if ("CanBeWatched".equals(str)) {
                this.canBeWatched = ParcelUtils.isTrue(str2);
            } else if ("IsPublic".equals(str)) {
                this.isPublic = ParcelUtils.isTrue(str2);
            } else if ("branchcode".equals(str)) {
                this.branchCode = str2;
            } else {
                C5058Ln.m4832e("Bid Info Variable is not handled - %s", vehicleDetailItem);
            }
        }
    }

    private void populateFullImageData(VehicleDetailItem[] vehicleDetailItemArr) {
        int length = vehicleDetailItemArr == null ? 0 : vehicleDetailItemArr.length;
        if (length == 0) {
            this.imageUrl = null;
            ArrayList<String> arrayList = this.fullImageUrls;
            if (arrayList != null) {
                arrayList.clear();
                return;
            }
            return;
        }
        this.imageUrl = vehicleDetailItemArr[0].value;
        ArrayList<String> arrayList2 = this.fullImageUrls;
        if (arrayList2 == null) {
            this.fullImageUrls = new ArrayList<>(length);
        } else {
            arrayList2.clear();
        }
        for (VehicleDetailItem vehicleDetailItem : vehicleDetailItemArr) {
            this.fullImageUrls.add(vehicleDetailItem.value);
        }
    }

    private void populateDeepZoomImageURLsData(VehicleDetailItem[] vehicleDetailItemArr) {
        int length = vehicleDetailItemArr == null ? 0 : vehicleDetailItemArr.length;
        if (length == 0) {
            ArrayList<String> arrayList = this.deepZoomImageUrls;
            if (arrayList != null) {
                arrayList.clear();
                return;
            }
            return;
        }
        ArrayList<String> arrayList2 = this.deepZoomImageUrls;
        if (arrayList2 == null) {
            this.deepZoomImageUrls = new ArrayList<>(length);
        } else {
            arrayList2.clear();
        }
        for (VehicleDetailItem vehicleDetailItem : vehicleDetailItemArr) {
            this.deepZoomImageUrls.add(vehicleDetailItem.value);
        }
    }

    private void populateDeepZoomImageWidthData(VehicleDetailItem[] vehicleDetailItemArr) {
        int length = vehicleDetailItemArr == null ? 0 : vehicleDetailItemArr.length;
        if (length == 0) {
            ArrayList<String> arrayList = this.deepZoomImageWidths;
            if (arrayList != null) {
                arrayList.clear();
                return;
            }
            return;
        }
        ArrayList<String> arrayList2 = this.deepZoomImageWidths;
        if (arrayList2 == null) {
            this.deepZoomImageWidths = new ArrayList<>(length);
        } else {
            arrayList2.clear();
        }
        for (VehicleDetailItem vehicleDetailItem : vehicleDetailItemArr) {
            Log.d("deepZoomImageWidths-->", "detailItem.value--->" + vehicleDetailItem.value);
            this.deepZoomImageWidths.add(vehicleDetailItem.value);
        }
    }

    private void populateDeepZoomImageHeightData(VehicleDetailItem[] vehicleDetailItemArr) {
        int length = vehicleDetailItemArr == null ? 0 : vehicleDetailItemArr.length;
        if (length == 0) {
            ArrayList<String> arrayList = this.deepZoomImageHeights;
            if (arrayList != null) {
                arrayList.clear();
                return;
            }
            return;
        }
        ArrayList<String> arrayList2 = this.deepZoomImageHeights;
        if (arrayList2 == null) {
            this.deepZoomImageHeights = new ArrayList<>(length);
        } else {
            arrayList2.clear();
        }
        for (VehicleDetailItem vehicleDetailItem : vehicleDetailItemArr) {
            this.deepZoomImageHeights.add(vehicleDetailItem.value);
        }
    }
}
