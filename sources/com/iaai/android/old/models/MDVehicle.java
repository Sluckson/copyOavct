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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import roboguice.util.C5058Ln;

public class MDVehicle implements Parcelable {
    public static final Parcelable.Creator<MDVehicle> CREATOR = new Parcelable.Creator<MDVehicle>() {
        public MDVehicle createFromParcel(Parcel parcel) {
            return new MDVehicle(parcel);
        }

        public MDVehicle[] newArray(int i) {
            return new MDVehicle[i];
        }
    };
    public static final int PREBID_STATE_CLOSED = 2;
    public static final int PREBID_STATE_IN_PROGRESS = 1;
    public static final int PREBID_STATE_NOT_STARTED = 0;
    @JsonProperty("PredictedTimeOnBlock")
    public String PredictedTimeOnBlock;
    @JsonIgnore
    public Date TimedAuctionCloseTimeCST;
    @JsonIgnore
    public boolean TimedAuctionIndicator;
    @JsonIgnore
    public String aceInd;
    @JsonIgnore
    public String aceLink;
    @JsonIgnore
    public String aceText;
    @JsonIgnore
    public MDVehicleDetailGroup additionalInfo;
    @JsonProperty("auctionid")
    public String auctionId;
    @JsonIgnore
    public int bidCount;
    public int bidamount;
    @JsonIgnore
    public int bidderCount;
    public String biddername;
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
    public String datepaidstring;
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
    @JsonIgnore
    public String image360Url;
    @JsonProperty("thumbnailurl")
    public String imageUrl;
    @JsonIgnore
    public boolean isAuctionClosed;
    @JsonIgnore
    public boolean isBeingWatched;
    @JsonIgnore
    public boolean isCurrentUserHighBidder;
    @JsonIgnore
    public boolean isDeepZoom;
    @JsonIgnore
    public boolean isIBuyFastSold;
    @JsonIgnore
    public boolean isImage360;
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
    @JsonIgnore
    public String laneItem;
    public String liveDatePreSale;
    @JsonProperty("LossType")
    public String lossType;
    @JsonProperty("vehiclemake")
    public String make;
    @JsonProperty("vehiclemodel")
    public String model;
    @JsonIgnore
    public int odometerInt;
    public String pickedupDate;
    public String pickedupdatestring;
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
    @JsonProperty("Salvage_Id")
    public String salvage_Id;
    public String slot;
    public String stateAbbrivation;
    public int status;
    @JsonProperty("stockno")
    public String stockNo;
    @JsonProperty("TBOInd")
    public Boolean tBOInd;
    @JsonProperty("TimedAuctionIndicator")
    public boolean timedAuctionRowIndicator;
    @JsonIgnore
    public String userCurrentBidAmount;
    @JsonIgnore
    public String userPreBidMaxAmount;
    @JsonIgnore
    public String userStartBidAmount;
    public int win_amount;
    public String year;

    public int describeContents() {
        return 0;
    }

    public MDVehicle() {
    }

    public MDVehicle(Parcel parcel) {
        this.auctionId = parcel.readString();
        this.branchName = parcel.readString();
        this.branchCode = parcel.readString();
        this.itemId = parcel.readString();
        this.lossType = parcel.readString();
        this.odometerInt = parcel.readInt();
        this.primaryDamage = parcel.readString();
        this.pickedupDate = parcel.readString();
        this.datepaidstring = parcel.readString();
        this.pickedupdatestring = parcel.readString();
        this.slot = parcel.readString();
        this.lane = parcel.readString();
        this.providerName = parcel.readString();
        this.biddername = parcel.readString();
        this.bidamount = parcel.readInt();
        this.win_amount = parcel.readInt();
        this.stockNo = parcel.readString();
        this.stateAbbrivation = parcel.readString();
        this.status = parcel.readInt();
        this.prebidStatus = parcel.readString();
        this.prebidStatusColor = parcel.readString();
        this.liveDatePreSale = parcel.readString();
        this.fourthElementHistory = parcel.readString();
        this.receiptNo = parcel.readString();
        this.salvage_Id = parcel.readString();
        this.receiptDescription = parcel.readString();
        this.make = parcel.readString();
        this.model = parcel.readString();
        this.year = parcel.readString();
        this.imageUrl = parcel.readString();
        this.isRunDrive = ParcelUtils.readBoolean(parcel);
        this.isRunStarts = ParcelUtils.readBoolean(parcel);
        this.isOffSite = ParcelUtils.readBoolean(parcel);
        this.isShrinkWrap = ParcelUtils.readBoolean(parcel);
        this.isDeepZoom = ParcelUtils.readBoolean(parcel);
        this.isImage360 = ParcelUtils.readBoolean(parcel);
        this.image360Url = parcel.readString();
        this.aceInd = parcel.readString();
        this.aceText = parcel.readString();
        this.aceLink = parcel.readString();
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
        this.TimedAuctionIndicator = ParcelUtils.readBoolean(parcel);
        this.timedAuctionRowIndicator = ParcelUtils.readBoolean(parcel);
        this.TimedAuctionCloseTimeCST = ParcelUtils.readDate(parcel);
        this.prebidState = parcel.readInt();
        this.canUserBid = ParcelUtils.readBoolean(parcel);
        this.reasonUserCannotBid = parcel.readString();
        this.canUserBuyNow = ParcelUtils.readBoolean(parcel);
        this.reasonUserCannotBuyNow = parcel.readString();
        this.userCurrentBidAmount = parcel.readString();
        this.bidderCount = parcel.readInt();
        this.bidCount = parcel.readInt();
        this.itemNumber = parcel.readString();
        this.laneItem = parcel.readString();
        this.isAuctionClosed = ParcelUtils.readBoolean(parcel);
        this.isBeingWatched = ParcelUtils.readBoolean(parcel);
        this.canBeWatched = ParcelUtils.readBoolean(parcel);
        this.isPublic = ParcelUtils.readBoolean(parcel);
        this.userPreBidMaxAmount = parcel.readString();
        this.userStartBidAmount = parcel.readString();
        this.PredictedTimeOnBlock = parcel.readString();
        this.tBOInd = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
        this.fullImageUrls = new ArrayList<>();
        this.deepZoomImageUrls = new ArrayList<>();
        this.deepZoomImageWidths = new ArrayList<>();
        this.deepZoomImageHeights = new ArrayList<>();
        parcel.readStringList(this.fullImageUrls);
        parcel.readStringList(this.deepZoomImageUrls);
        parcel.readStringList(this.deepZoomImageWidths);
        parcel.readStringList(this.deepZoomImageHeights);
        try {
            this.additionalInfo = (MDVehicleDetailGroup) parcel.readParcelable(MDVehicleDetailGroup.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception in Reading additionalInfo ", e.getMessage());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.auctionId);
        parcel.writeString(this.branchName);
        parcel.writeString(this.branchCode);
        parcel.writeString(this.itemId);
        parcel.writeString(this.lossType);
        parcel.writeInt(this.odometerInt);
        parcel.writeString(this.primaryDamage);
        parcel.writeString(this.pickedupDate);
        parcel.writeString(this.datepaidstring);
        parcel.writeString(this.pickedupdatestring);
        parcel.writeString(this.slot);
        parcel.writeString(this.lane);
        parcel.writeString(this.providerName);
        parcel.writeString(this.biddername);
        parcel.writeInt(this.bidamount);
        parcel.writeInt(this.win_amount);
        parcel.writeString(this.stockNo);
        parcel.writeString(this.stateAbbrivation);
        parcel.writeInt(this.status);
        parcel.writeString(this.prebidStatus);
        parcel.writeString(this.prebidStatusColor);
        parcel.writeString(this.liveDatePreSale);
        parcel.writeString(this.fourthElementHistory);
        parcel.writeString(this.receiptNo);
        parcel.writeString(this.salvage_Id);
        parcel.writeString(this.receiptDescription);
        parcel.writeString(this.make);
        parcel.writeString(this.model);
        parcel.writeString(this.year);
        parcel.writeString(this.imageUrl);
        ParcelUtils.writeBoolean(parcel, this.isRunDrive);
        ParcelUtils.writeBoolean(parcel, this.isRunStarts);
        ParcelUtils.writeBoolean(parcel, this.isOffSite);
        ParcelUtils.writeBoolean(parcel, this.isShrinkWrap);
        ParcelUtils.writeBoolean(parcel, this.isDeepZoom);
        ParcelUtils.writeBoolean(parcel, this.isImage360);
        parcel.writeString(this.image360Url);
        parcel.writeString(this.aceInd);
        parcel.writeString(this.aceText);
        parcel.writeString(this.aceLink);
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
        ParcelUtils.writeBoolean(parcel, this.TimedAuctionIndicator);
        ParcelUtils.writeBoolean(parcel, this.timedAuctionRowIndicator);
        ParcelUtils.writeDate(parcel, this.TimedAuctionCloseTimeCST);
        parcel.writeInt(this.prebidState);
        ParcelUtils.writeBoolean(parcel, this.canUserBid);
        parcel.writeString(this.reasonUserCannotBid);
        ParcelUtils.writeBoolean(parcel, this.canUserBuyNow);
        parcel.writeString(this.reasonUserCannotBuyNow);
        parcel.writeString(this.userCurrentBidAmount);
        parcel.writeInt(this.bidderCount);
        parcel.writeInt(this.bidCount);
        parcel.writeString(this.itemNumber);
        parcel.writeString(this.laneItem);
        ParcelUtils.writeBoolean(parcel, this.isAuctionClosed);
        ParcelUtils.writeBoolean(parcel, this.isBeingWatched);
        ParcelUtils.writeBoolean(parcel, this.canBeWatched);
        ParcelUtils.writeBoolean(parcel, this.isPublic);
        parcel.writeString(this.userPreBidMaxAmount);
        parcel.writeString(this.userStartBidAmount);
        parcel.writeString(this.PredictedTimeOnBlock);
        ParcelUtils.writeBoolean(parcel, this.tBOInd.booleanValue());
        parcel.writeStringList(this.fullImageUrls);
        parcel.writeStringList(this.deepZoomImageUrls);
        parcel.writeStringList(this.deepZoomImageWidths);
        parcel.writeStringList(this.deepZoomImageHeights);
        parcel.writeParcelable(this.additionalInfo, 0);
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

    @JsonSetter("pickedupDate")
    public void setPickedupDate(String str) {
        this.pickedupDate = str;
    }

    @JsonSetter("datepaidstring")
    public void setDatepaidstring(String str) throws ParseException {
        if (str != null) {
            try {
                str = new SimpleDateFormat("EEE MMM dd").format(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse(str));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.datepaidstring = str;
        }
    }

    @JsonSetter("pickedupdatestring")
    public void setPickedupdatestring(String str) throws ParseException {
        if (str != null) {
            try {
                str = new SimpleDateFormat("EEE MMM dd").format(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse(str));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.pickedupdatestring = str;
        }
    }

    @JsonSetter("Damage2")
    public void setDamage2(String str) {
        this.lossType = str;
    }

    @JsonSetter("timedAuctionRowIndicator")
    public void settimedAuctionRowIndicator(boolean z) {
        this.timedAuctionRowIndicator = z;
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

    @JsonSetter("BidderName")
    public void serBidderName(String str) {
        this.biddername = str;
    }

    @JsonSetter("bidamount")
    public void setTotalPaid(int i) {
        this.bidamount = i;
    }

    @JsonSetter("win_amount")
    public void setWin_amount(int i) {
        this.win_amount = i;
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
        if (str != null) {
            this.ibidLiveStartTime = DateHelper.parseDateInServerTimezone(str);
        }
    }

    @JsonSetter("StockNumber")
    public void setStockNumber(String str) {
        this.stockNo = str;
    }

    @JsonSetter("Itemid")
    public void setItemId(String str) {
        this.itemId = str;
    }

    public void populate(MDVehicleDetailGroup mDVehicleDetailGroup) {
        this.additionalInfo = mDVehicleDetailGroup;
        populateHeaderData(mDVehicleDetailGroup.header_value);
        populateIconsData(mDVehicleDetailGroup.icons_value);
        populateFullImageData(mDVehicleDetailGroup.fullImages_value);
        populateActionInfo(mDVehicleDetailGroup.action_value);
    }

    public static MDVehicle fromVehicleDetails(MDVehicleDetailGroup mDVehicleDetailGroup) {
        MDVehicle mDVehicle = new MDVehicle();
        mDVehicle.populate(mDVehicleDetailGroup);
        return mDVehicle;
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

    private void populateHeaderData(MDVehicleDetailItem[] mDVehicleDetailItemArr) {
        for (MDVehicleDetailItem mDVehicleDetailItem : mDVehicleDetailItemArr) {
            String str = mDVehicleDetailItem.key;
            String str2 = mDVehicleDetailItem.value;
            if ("Year".equals(str)) {
                this.year = str2;
            } else if (ExifInterface.TAG_MAKE.equals(str)) {
                this.make = str2;
            } else if (ExifInterface.TAG_MODEL.equals(str)) {
                this.model = str2;
            } else if ("Item #".equals(str)) {
                this.itemNumber = str2;
            } else if ("LaneItem".equals(str)) {
                this.laneItem = str2;
            } else if ("ItemId".equals(str)) {
                this.itemId = str2;
            } else if ("AuctionId".equals(str)) {
                this.auctionId = str2;
            } else {
                C5058Ln.m4832e("Header Data Variable is not handled - %s", mDVehicleDetailItem);
            }
        }
    }

    private void populateIconsData(MDVehicleDetailItem[] mDVehicleDetailItemArr) {
        for (MDVehicleDetailItem mDVehicleDetailItem : mDVehicleDetailItemArr) {
            String str = mDVehicleDetailItem.key;
            boolean isTrue = ParcelUtils.isTrue(mDVehicleDetailItem.value);
            if ("R&D".equals(str)) {
                this.isRunDrive = isTrue;
            } else if ("Starts".equals(str)) {
                this.isRunStarts = isTrue;
            } else if ("Off Site".equals(str)) {
                this.isOffSite = isTrue;
            } else if ("Shrink Wrap".equals(str)) {
                this.isShrinkWrap = isTrue;
            } else if ("DeepZoom".equals(str)) {
                this.isDeepZoom = isTrue;
            } else if ("Image360".equals(str)) {
                this.isImage360 = isTrue;
            } else if ("Image360Url".equals(str)) {
                this.image360Url = mDVehicleDetailItem.value;
            } else if ("ACE Ind".equals(str)) {
                this.aceInd = mDVehicleDetailItem.value;
            } else if ("ACE Text".equals(str)) {
                this.aceText = mDVehicleDetailItem.value;
            } else if ("ACE Link".equals(str)) {
                this.aceLink = mDVehicleDetailItem.value;
            } else {
                C5058Ln.m4832e("Icon Data Variable is not handled - %s", mDVehicleDetailItem);
            }
        }
    }

    private void populateActionInfo(MDVehicleDetailItem[] mDVehicleDetailItemArr) {
        for (MDVehicleDetailItem mDVehicleDetailItem : mDVehicleDetailItemArr) {
            String str = mDVehicleDetailItem.key;
            String str2 = mDVehicleDetailItem.value;
            Log.d("populateActionInfo-->", "detailItem--->" + mDVehicleDetailItem.key);
            if ("PreBidCurrentHigh".equals(str)) {
                this.currentHighAmount = ParcelUtils.toBigDecimal(str2);
            } else if ("IsCurrentUserHighBidder".equals(str)) {
                this.isCurrentUserHighBidder = ParcelUtils.isTrue(str2);
            } else if ("PreBidEndTime".equals(str)) {
                if (str2 != null) {
                    this.preBidEndTime = DateHelper.parseDateInServerTimezone(str2);
                }
            } else if ("IBidLiveStartTime".equals(str)) {
                if (str2 != null) {
                    this.ibidLiveStartTime = DateHelper.parseDateInServerTimezone(str2);
                }
            } else if ("IBuyFastAmount".equals(str)) {
                this.ibuyFastAmount = ParcelUtils.toBigDecimal(str2);
            } else if ("IBuyFastEndTime".equals(str)) {
                if (str2 != null) {
                    this.ibuyFastEndTime = DateHelper.parseDateInServerTimezone(str2);
                }
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
            } else if ("TimedAuctionIndicator".equals(str)) {
                this.TimedAuctionIndicator = ParcelUtils.isTrue(str2);
            } else if ("TimedAuctionCloseTimeCST".equals(str)) {
                if (str2 != null) {
                    this.TimedAuctionCloseTimeCST = DateHelper.parseDateInServerTimezone(str2);
                }
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
            } else if ("StartBid".equals(str)) {
                this.userStartBidAmount = str2;
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
                C5058Ln.m4832e("Bid Info Variable is not handled - %s", mDVehicleDetailItem);
            }
        }
    }

    private void populateFullImageData(ArrayList<String> arrayList) {
        int size = arrayList == null ? 0 : arrayList.size();
        if (size == 0) {
            this.imageUrl = null;
            ArrayList<String> arrayList2 = this.fullImageUrls;
            if (arrayList2 != null) {
                arrayList2.clear();
                return;
            }
            return;
        }
        this.imageUrl = arrayList.get(0);
        ArrayList<String> arrayList3 = this.fullImageUrls;
        if (arrayList3 == null) {
            this.fullImageUrls = new ArrayList<>(size);
        } else {
            arrayList3.clear();
        }
        this.fullImageUrls.addAll(arrayList);
    }
}
