package com.iaai.android.old.models;

import android.text.TextUtils;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.utils.JsonSerializer;
import com.iaai.android.old.utils.constants.SortOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class VehicleSearchResult {
    @JsonProperty("auctionDetails")
    public AuctionDetail auctionDetail;
    @JsonIgnore
    private List<ScopeDetail> nonEmptyScopes;
    @JsonProperty("scope")
    List<ScopeDetail> scopes;
    public String selectedScope;
    @JsonIgnore
    private SortOption sort;
    @JsonProperty("selectedsortoption")
    String sortByKey;
    @JsonProperty("selectedsortdirection")
    String sortDirection;
    @JsonIgnore
    public int total;
    @JsonProperty("actualData")
    public List<Vehicle> vehicles;

    public static class AuctionDetail {
        @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
        @JsonProperty("AdjCloseddate")
        public Date closeDate;
        @JsonProperty("IBidLiveIndicator")
        public int iBidLiveStatus;
        @JsonProperty("AuctionClosed")
        public boolean isClosed;
        @JsonProperty("SealedIndicator")
        public boolean isSealed;
        @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
        @JsonProperty("AdjLivedate")
        public Date liveDate;

        @JsonIgnore
        public boolean isIBidLiveActive() {
            return !this.isSealed && !this.isClosed && this.iBidLiveStatus == 1;
        }
    }

    @JsonProperty("resultData")
    public void setResultData(List<Vehicle> list) {
        this.vehicles = list;
    }

    @JsonProperty("list")
    public void setResultList(List<Vehicle> list) {
        this.vehicles = list;
    }

    @JsonSetter("listCount")
    public void setListCount(int i) {
        this.total = i;
    }

    @JsonSetter("totalCount")
    public void setTotalCount(String str) {
        this.total = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.total = Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
    }

    @JsonSetter("totalcount")
    public void setTotalCount2(String str) {
        setTotalCount(str);
    }

    public VehicleSearchResult() {
    }

    public VehicleSearchResult(Vehicle[] vehicleArr) {
        List<Vehicle> list;
        int i;
        if (vehicleArr == null) {
            list = null;
        } else {
            list = Arrays.asList(vehicleArr);
        }
        this.vehicles = list;
        if (vehicleArr == null) {
            i = 0;
        } else {
            i = vehicleArr.length;
        }
        this.total = i;
    }

    @JsonIgnore
    public SortOption getSortOption() {
        if (this.sort == null && !TextUtils.isEmpty(this.sortByKey) && !TextUtils.isEmpty(this.sortDirection)) {
            this.sort = SortOption.fromWSString(this.sortByKey, this.sortDirection);
        }
        return this.sort;
    }

    @JsonSetter("sort")
    public void setSort(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.sort = SortOption.fromWSString(str);
            } catch (Exception unused) {
            }
        }
    }

    @JsonIgnore
    public List<ScopeDetail> getNonEmptyScopes() {
        if (this.nonEmptyScopes == null) {
            this.nonEmptyScopes = new ArrayList();
            List<ScopeDetail> list = this.scopes;
            if (list != null) {
                for (ScopeDetail next : list) {
                    if (next.count > 0) {
                        this.nonEmptyScopes.add(next);
                    }
                }
            }
        }
        return this.nonEmptyScopes;
    }

    public ScopeDetail findScopeDetailByName(String str) {
        List<ScopeDetail> list;
        if (!TextUtils.isEmpty(str) && (list = this.scopes) != null) {
            for (ScopeDetail next : list) {
                if (next.name.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public int getVehicleCountBasedOnScope() {
        if (IaaiApplication.isfromDateSelected && IaaiApplication.isToDateSelected) {
            return this.total;
        }
        if (this.scopes == null) {
            return this.total;
        }
        ScopeDetail findScopeDetailByName = findScopeDetailByName(TextUtils.isEmpty(this.selectedScope) ? IaaiApplication.mContext.getString(C2723R.string.lbl_all) : this.selectedScope);
        return findScopeDetailByName == null ? this.total : findScopeDetailByName.count;
    }
}
