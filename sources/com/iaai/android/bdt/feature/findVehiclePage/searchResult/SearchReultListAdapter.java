package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.findVehiclePage.filter.HeaderListAdapter;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.databinding.ItemAuctionSalesListBinding;
import com.iaai.android.databinding.RowItemAuctinSalesListHeaderBinding;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 M2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003MNOB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\f\u00105\u001a\b\u0012\u0004\u0012\u00020706J\b\u00108\u001a\u00020\u0018H\u0016J\u0010\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018H\u0016J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0018H\u0016J\u0018\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0018H\u0016J\u000e\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020\u0018J\u0016\u0010D\u001a\u00020<2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010E\u001a\u00020FJ\u0015\u0010G\u001a\u00020<2\b\u0010H\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u0018R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u001aj\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b`\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0004\n\u0002\u00104¨\u0006P"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchReultListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fastSearchViewModel", "Lcom/iaai/android/bdt/feature/viewPager/FastSearchViewModel;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListner;", "(Lcom/iaai/android/bdt/feature/viewPager/FastSearchViewModel;Landroid/content/Context;Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListner;)V", "auctionSalesListHeader", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "getAuctionSalesListHeader", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "setAuctionSalesListHeader", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;)V", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "getConstraintSet", "()Landroidx/constraintlayout/widget/ConstraintSet;", "setConstraintSet", "(Landroidx/constraintlayout/widget/ConstraintSet;)V", "deviceWidth", "", "hashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "headerListAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter;", "getHeaderListAdapter", "()Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter;", "setHeaderListAdapter", "(Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter;)V", "imageContainerWidth", "isOffsiteTruncate", "isPublicTruncate", "isRunDriveTruncate", "layoutManager", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "getLayoutManager", "()Lcom/google/android/flexbox/FlexboxLayoutManager;", "setLayoutManager", "(Lcom/google/android/flexbox/FlexboxLayoutManager;)V", "getListener", "()Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListner;", "getMContext", "()Landroid/content/Context;", "selectedIemID", "Ljava/lang/Integer;", "createSetFromHashMap", "Ljava/util/HashSet;", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setDeviceWidth", "width", "setHeaderItem", "searchResultFragment", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment;", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Integer;)V", "setWatchingData", "isWatching", "itemID", "Companion", "HeaderDataViewHolder", "ResultDataItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListAdapter.kt */
public final class SearchReultListAdapter extends PagedListAdapter<Vehicle, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    @NotNull
    public AuctionSalesListHeader auctionSalesListHeader;
    @NotNull
    private ConstraintSet constraintSet = new ConstraintSet();
    private int deviceWidth;
    /* access modifiers changed from: private */
    public final FastSearchViewModel fastSearchViewModel;
    @NotNull
    private final HashMap<Integer, Boolean> hashMap = new HashMap<>();
    @NotNull
    public HeaderListAdapter headerListAdapter;
    private int imageContainerWidth;
    /* access modifiers changed from: private */
    public boolean isOffsiteTruncate;
    /* access modifiers changed from: private */
    public boolean isPublicTruncate;
    /* access modifiers changed from: private */
    public boolean isRunDriveTruncate;
    @NotNull
    private FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.mContext);
    @NotNull
    private final SearchResultListner listener;
    @NotNull
    private final Context mContext;
    /* access modifiers changed from: private */
    public Integer selectedIemID = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchReultListAdapter(@NotNull FastSearchViewModel fastSearchViewModel2, @NotNull Context context, @NotNull SearchResultListner searchResultListner) {
        super(Vehicle.Companion.getDIFF_CALLBACK());
        Intrinsics.checkParameterIsNotNull(fastSearchViewModel2, "fastSearchViewModel");
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(searchResultListner, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.fastSearchViewModel = fastSearchViewModel2;
        this.mContext = context;
        this.listener = searchResultListner;
    }

    public static final /* synthetic */ Vehicle access$getItem(SearchReultListAdapter searchReultListAdapter, int i) {
        return (Vehicle) searchReultListAdapter.getItem(i);
    }

    @NotNull
    public final SearchResultListner getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final AuctionSalesListHeader getAuctionSalesListHeader() {
        AuctionSalesListHeader auctionSalesListHeader2 = this.auctionSalesListHeader;
        if (auctionSalesListHeader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListHeader");
        }
        return auctionSalesListHeader2;
    }

    public final void setAuctionSalesListHeader(@NotNull AuctionSalesListHeader auctionSalesListHeader2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "<set-?>");
        this.auctionSalesListHeader = auctionSalesListHeader2;
    }

    @NotNull
    public final HeaderListAdapter getHeaderListAdapter() {
        HeaderListAdapter headerListAdapter2 = this.headerListAdapter;
        if (headerListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        return headerListAdapter2;
    }

    public final void setHeaderListAdapter(@NotNull HeaderListAdapter headerListAdapter2) {
        Intrinsics.checkParameterIsNotNull(headerListAdapter2, "<set-?>");
        this.headerListAdapter = headerListAdapter2;
    }

    @NotNull
    public final HashMap<Integer, Boolean> getHashMap() {
        return this.hashMap;
    }

    @NotNull
    public final FlexboxLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public final void setLayoutManager(@NotNull FlexboxLayoutManager flexboxLayoutManager) {
        Intrinsics.checkParameterIsNotNull(flexboxLayoutManager, "<set-?>");
        this.layoutManager = flexboxLayoutManager;
    }

    @NotNull
    public final ConstraintSet getConstraintSet() {
        return this.constraintSet;
    }

    public final void setConstraintSet(@NotNull ConstraintSet constraintSet2) {
        Intrinsics.checkParameterIsNotNull(constraintSet2, "<set-?>");
        this.constraintSet = constraintSet2;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchReultListAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchResultListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return SearchReultListAdapter.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return SearchReultListAdapter.TYPE_ITEM;
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ItemAuctionSalesListBinding inflate = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemAuctionSalesListBind…tInflater, parent, false)");
        objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate);
        if (i == TYPE_HEADER) {
            RowItemAuctinSalesListHeaderBinding inflate2 = RowItemAuctinSalesListHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "RowItemAuctinSalesListHe…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new HeaderDataViewHolder(this, inflate2);
            View view = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            ((TextView) view.findViewById(C2723R.C2726id.tv_filter_label)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$1(this, objectRef));
            View view2 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ((TextView) view2.findViewById(C2723R.C2726id.tv_filterCount)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$2(this, objectRef));
            View view3 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            ((ImageView) view3.findViewById(C2723R.C2726id.img_filter)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$3(this, objectRef));
            View view4 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
            ((ImageView) view4.findViewById(C2723R.C2726id.iv_sort)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$4(this, objectRef));
            View view5 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
            ((TextView) view5.findViewById(C2723R.C2726id.tv_SortLabel)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$5(this, objectRef));
        } else if (i == TYPE_ITEM) {
            ItemAuctionSalesListBinding inflate3 = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemAuctionSalesListBind…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate3);
            View view6 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
            ((FrameLayout) view6.findViewById(C2723R.C2726id.fl_unwatch)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$6(this, objectRef));
            View view7 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view7, "holder.itemView");
            ((FrameLayout) view7.findViewById(C2723R.C2726id.fl_watch)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$7(this, objectRef));
            View view8 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view8, "holder.itemView");
            ((LinearLayout) view8.findViewById(C2723R.C2726id.llUnWatch)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$8(this, objectRef));
            View view9 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view9, "holder.itemView");
            ((LinearLayout) view9.findViewById(C2723R.C2726id.llWatch)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$9(this, objectRef));
            View view10 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view10, "holder.itemView");
            ((ConstraintLayout) view10.findViewById(C2723R.C2726id.parent_item)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$10(this, objectRef));
            View view11 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view11, "holder.itemView");
            ((ImageView) view11.findViewById(C2723R.C2726id.img_arrow_right)).setOnClickListener(new SearchReultListAdapter$onCreateViewHolder$11(this, objectRef));
        }
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() <= 0) {
            return;
        }
        if (viewHolder instanceof ResultDataItemViewHolder) {
            int i2 = i - 1;
            Vehicle vehicle = (Vehicle) getItem(i2);
            ((ResultDataItemViewHolder) viewHolder).bindTo((Vehicle) getItem(i2));
        } else if (viewHolder instanceof HeaderDataViewHolder) {
            ((HeaderDataViewHolder) viewHolder).bindTo();
        }
    }

    public final void setHeaderItem(@NotNull AuctionSalesListHeader auctionSalesListHeader2, @NotNull SearchResultListFragment searchResultListFragment) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "auctionSalesListHeader");
        Intrinsics.checkParameterIsNotNull(searchResultListFragment, "searchResultFragment");
        this.layoutManager.setFlexWrap(1);
        this.headerListAdapter = new HeaderListAdapter(this.mContext);
        this.auctionSalesListHeader = auctionSalesListHeader2;
        HeaderListAdapter headerListAdapter2 = this.headerListAdapter;
        if (headerListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        headerListAdapter2.setHeaderListData(createSetFromHashMap());
        HeaderListAdapter headerListAdapter3 = this.headerListAdapter;
        if (headerListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        headerListAdapter3.notifyDataSetChanged();
        HeaderListAdapter headerListAdapter4 = this.headerListAdapter;
        if (headerListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerListAdapter");
        }
        headerListAdapter4.setClickListener(searchResultListFragment);
    }

    @NotNull
    public final HashSet<SelectedRefinerV2> createSetFromHashMap() {
        Set<Map.Entry<String, SelectedRefinerV2>> entrySet;
        HashSet<SelectedRefinerV2> hashSet = new HashSet<>();
        AuctionSalesListHeader auctionSalesListHeader2 = this.auctionSalesListHeader;
        if (auctionSalesListHeader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListHeader");
        }
        LinkedHashMap<String, SelectedRefinerV2> selectedRefinerHashMap = auctionSalesListHeader2.getSelectedRefinerHashMap();
        if (!(selectedRefinerHashMap == null || (entrySet = selectedRefinerHashMap.entrySet()) == null)) {
            for (Map.Entry entry : entrySet) {
                if (!StringsKt.equals((String) entry.getKey(), "readyforbid", true)) {
                    hashSet.add(entry.getValue());
                }
            }
        }
        return hashSet;
    }

    public final void setDeviceWidth(int i) {
        this.deviceWidth = i;
    }

    public final void setSelectedItemForTablet(@Nullable Integer num) {
        this.selectedIemID = num;
    }

    public int getItemViewType(int i) {
        return i == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    public int getItemCount() {
        if (this.auctionSalesListHeader != null) {
            AuctionSalesListHeader auctionSalesListHeader2 = this.auctionSalesListHeader;
            if (auctionSalesListHeader2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListHeader");
            }
            if (auctionSalesListHeader2.isError()) {
                return 1;
            }
        }
        if (super.getItemCount() == 0) {
            return super.getItemCount();
        }
        return 1 + super.getItemCount();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchReultListAdapter$HeaderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchReultListAdapter;Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;)V", "isClickedEnabled", "", "()Z", "setClickedEnabled", "(Z)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchResultListAdapter.kt */
    public final class HeaderDataViewHolder extends RecyclerView.ViewHolder {
        private final RowItemAuctinSalesListHeaderBinding binding;
        private boolean isClickedEnabled;
        final /* synthetic */ SearchReultListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderDataViewHolder(@NotNull SearchReultListAdapter searchReultListAdapter, RowItemAuctinSalesListHeaderBinding rowItemAuctinSalesListHeaderBinding) {
            super(rowItemAuctinSalesListHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemAuctinSalesListHeaderBinding, "binding");
            this.this$0 = searchReultListAdapter;
            this.binding = rowItemAuctinSalesListHeaderBinding;
        }

        public final boolean isClickedEnabled() {
            return this.isClickedEnabled;
        }

        public final void setClickedEnabled(boolean z) {
            this.isClickedEnabled = z;
        }

        public final void bindTo() {
            ConstraintLayout constraintLayout = this.binding.clHeader;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clHeader");
            constraintLayout.setVisibility(8);
            Map selectedRefinerHashMap = this.this$0.getAuctionSalesListHeader().getSelectedRefinerHashMap();
            if (selectedRefinerHashMap == null || selectedRefinerHashMap.isEmpty()) {
                RelativeLayout relativeLayout = this.binding.rlSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "binding.rlSearchSelectedRefiner");
                relativeLayout.setVisibility(8);
            } else {
                RelativeLayout relativeLayout2 = this.binding.rlSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "binding.rlSearchSelectedRefiner");
                relativeLayout2.setVisibility(0);
                RecyclerView recyclerView = this.binding.rvSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(recyclerView, "binding.rvSearchSelectedRefiner");
                recyclerView.setLayoutManager(this.this$0.getLayoutManager());
                RecyclerView recyclerView2 = this.binding.rvSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "binding.rvSearchSelectedRefiner");
                recyclerView2.setAdapter(this.this$0.getHeaderListAdapter());
            }
            if (this.this$0.getAuctionSalesListHeader().isError()) {
                View view = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.emptyView");
                TextView textView = (TextView) view.findViewById(C2723R.C2726id.errorTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.emptyView.errorTitle");
                textView.setText(this.this$0.getAuctionSalesListHeader().getErrorMessage());
                View view2 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "binding.emptyView");
                TextView textView2 = (TextView) view2.findViewById(C2723R.C2726id.errorBody);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.emptyView.errorBody");
                textView2.setText(this.this$0.getAuctionSalesListHeader().getErrorMessage());
                ConstraintLayout constraintLayout2 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clEmptyView");
                constraintLayout2.setVisibility(0);
            } else {
                ConstraintLayout constraintLayout3 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.clEmptyView");
                constraintLayout3.setVisibility(8);
            }
            if (this.this$0.getAuctionSalesListHeader().getFilterCount() != 0) {
                TextView textView3 = this.binding.tvFilterCount;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvFilterCount");
                textView3.setText(String.valueOf(this.this$0.getAuctionSalesListHeader().getFilterCount()));
                TextView textView4 = this.binding.tvFilterCount;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvFilterCount");
                textView4.setVisibility(0);
                return;
            }
            TextView textView5 = this.binding.tvFilterCount;
            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvFilterCount");
            textView5.setVisibility(8);
        }
    }

    public final void setWatchingData(boolean z, int i) {
        if (z) {
            this.hashMap.put(Integer.valueOf(i), Boolean.valueOf(z));
        } else {
            this.hashMap.remove(Integer.valueOf(i));
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ&\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchReultListAdapter$ResultDataItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchReultListAdapter;Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;)V", "bindTo", "", "resultDatum", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "handleBadgeAlignment", "isPublicTruncate", "", "isRunDriveTruncate", "isOffsiteTruncate", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchResultListAdapter.kt */
    public final class ResultDataItemViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final ItemAuctionSalesListBinding binding;
        final /* synthetic */ SearchReultListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultDataItemViewHolder(@NotNull SearchReultListAdapter searchReultListAdapter, ItemAuctionSalesListBinding itemAuctionSalesListBinding) {
            super(itemAuctionSalesListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            this.this$0 = searchReultListAdapter;
            this.binding = itemAuctionSalesListBinding;
        }

        /* JADX WARNING: Removed duplicated region for block: B:105:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x021b  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0220  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x0229  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x0252  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x02a2  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x02ab  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x02b4  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x02b9  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x02c0  */
        /* JADX WARNING: Removed duplicated region for block: B:135:0x02e9  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0313  */
        /* JADX WARNING: Removed duplicated region for block: B:138:0x0318  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x03de  */
        /* JADX WARNING: Removed duplicated region for block: B:152:0x03e3  */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x03ff  */
        /* JADX WARNING: Removed duplicated region for block: B:156:0x0404  */
        /* JADX WARNING: Removed duplicated region for block: B:159:0x0416  */
        /* JADX WARNING: Removed duplicated region for block: B:160:0x041b  */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x0427  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x0429  */
        /* JADX WARNING: Removed duplicated region for block: B:169:0x042e  */
        /* JADX WARNING: Removed duplicated region for block: B:174:0x044d  */
        /* JADX WARNING: Removed duplicated region for block: B:176:0x0459  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x045e  */
        /* JADX WARNING: Removed duplicated region for block: B:182:0x046a  */
        /* JADX WARNING: Removed duplicated region for block: B:183:0x046c  */
        /* JADX WARNING: Removed duplicated region for block: B:185:0x046f  */
        /* JADX WARNING: Removed duplicated region for block: B:190:0x0492  */
        /* JADX WARNING: Removed duplicated region for block: B:193:0x04bc  */
        /* JADX WARNING: Removed duplicated region for block: B:194:0x04c1  */
        /* JADX WARNING: Removed duplicated region for block: B:199:0x04cd  */
        /* JADX WARNING: Removed duplicated region for block: B:200:0x04cf  */
        /* JADX WARNING: Removed duplicated region for block: B:202:0x04d2  */
        /* JADX WARNING: Removed duplicated region for block: B:203:0x04df  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x04ed  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x04f2  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x04fe  */
        /* JADX WARNING: Removed duplicated region for block: B:212:0x0500  */
        /* JADX WARNING: Removed duplicated region for block: B:214:0x0503  */
        /* JADX WARNING: Removed duplicated region for block: B:215:0x0510  */
        /* JADX WARNING: Removed duplicated region for block: B:217:0x051e  */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x0523  */
        /* JADX WARNING: Removed duplicated region for block: B:223:0x052f  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x0531  */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x0534  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x0541  */
        /* JADX WARNING: Removed duplicated region for block: B:230:0x059c  */
        /* JADX WARNING: Removed duplicated region for block: B:233:0x05aa  */
        /* JADX WARNING: Removed duplicated region for block: B:234:0x05b7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindTo(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.fastSearch.Vehicle r12) {
            /*
                r11 = this;
                r0 = 0
                if (r12 == 0) goto L_0x000c
                int r1 = r12.getItemId()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x000d
            L_0x000c:
                r1 = r0
            L_0x000d:
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                java.lang.Integer r2 = r2.selectedIemID
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
                if (r1 == 0) goto L_0x0051
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 23
                if (r1 < r2) goto L_0x0038
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r2 = r2.getColor(r3, r0)
                r1.setBackgroundColor(r2)
                goto L_0x0088
            L_0x0038:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r2 = r2.getColor(r3)
                r1.setBackgroundColor(r2)
                goto L_0x0088
            L_0x0051:
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 23
                if (r1 < r2) goto L_0x0070
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099728(0x7f060050, float:1.7811817E38)
                int r2 = r2.getColor(r3, r0)
                r1.setBackgroundColor(r2)
                goto L_0x0088
            L_0x0070:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099728(0x7f060050, float:1.7811817E38)
                int r2 = r2.getColor(r3)
                r1.setBackgroundColor(r2)
            L_0x0088:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                java.lang.String r2 = "binding.llWatch"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r3 = 8
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                java.lang.String r4 = "binding.llUnWatch"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r3)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                if (r12 == 0) goto L_0x00ae
                java.lang.String r5 = r12.getYear()
                goto L_0x00af
            L_0x00ae:
                r5 = r0
            L_0x00af:
                r1.append(r5)
                java.lang.String r5 = " "
                r1.append(r5)
                if (r12 == 0) goto L_0x00be
                java.lang.String r6 = r12.getMake()
                goto L_0x00bf
            L_0x00be:
                r6 = r0
            L_0x00bf:
                r1.append(r6)
                r1.append(r5)
                if (r12 == 0) goto L_0x00cc
                java.lang.String r6 = r12.getModel()
                goto L_0x00cd
            L_0x00cc:
                r6 = r0
            L_0x00cd:
                r1.append(r6)
                r1.append(r5)
                if (r12 == 0) goto L_0x00da
                java.lang.String r5 = r12.getSeries()
                goto L_0x00db
            L_0x00da:
                r5 = r0
            L_0x00db:
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                com.iaai.android.databinding.ItemAuctionSalesListBinding r5 = r11.binding
                android.widget.TextView r5 = r5.yearMakeModel
                java.lang.String r6 = "binding.yearMakeModel"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
                java.lang.String r1 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r5.setText(r1)
                if (r12 == 0) goto L_0x00fb
                java.lang.String r1 = r12.getLossType()
                goto L_0x00fc
            L_0x00fb:
                r1 = r0
            L_0x00fc:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L_0x010b
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0109
                goto L_0x010b
            L_0x0109:
                r1 = 0
                goto L_0x010c
            L_0x010b:
                r1 = 1
            L_0x010c:
                java.lang.String r7 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r1 == 0) goto L_0x0133
                if (r12 == 0) goto L_0x0131
                java.lang.String r1 = r12.getDamage()
                if (r1 == 0) goto L_0x0131
                java.lang.String r1 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r1)
                if (r1 == 0) goto L_0x0131
                if (r1 == 0) goto L_0x012b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
                java.lang.String r1 = r1.toString()
                goto L_0x018b
            L_0x012b:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r7)
                throw r12
            L_0x0131:
                r1 = r0
                goto L_0x018b
            L_0x0133:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                if (r12 == 0) goto L_0x0159
                java.lang.String r8 = r12.getLossType()
                if (r8 == 0) goto L_0x0159
                java.lang.String r8 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r8)
                if (r8 == 0) goto L_0x0159
                if (r8 == 0) goto L_0x0153
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.CharSequence r8 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r8)
                java.lang.String r8 = r8.toString()
                goto L_0x015a
            L_0x0153:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r7)
                throw r12
            L_0x0159:
                r8 = r0
            L_0x015a:
                r1.append(r8)
                java.lang.String r8 = ", "
                r1.append(r8)
                if (r12 == 0) goto L_0x0183
                java.lang.String r8 = r12.getDamage()
                if (r8 == 0) goto L_0x0183
                java.lang.String r8 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r8)
                if (r8 == 0) goto L_0x0183
                if (r8 == 0) goto L_0x017d
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.CharSequence r7 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r8)
                java.lang.String r7 = r7.toString()
                goto L_0x0184
            L_0x017d:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r7)
                throw r12
            L_0x0183:
                r7 = r0
            L_0x0184:
                r1.append(r7)
                java.lang.String r1 = r1.toString()
            L_0x018b:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r7 = r11.binding
                android.widget.TextView r7 = r7.tvSeparator
                java.lang.String r8 = "binding.tvSeparator"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
                r7.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r7 = r11.binding
                android.widget.TextView r7 = r7.tvAisleValue
                java.lang.String r8 = "binding.tvAisleValue"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
                r7.setVisibility(r3)
                if (r12 == 0) goto L_0x01aa
                java.lang.String r7 = r12.getOdometer()
                goto L_0x01ab
            L_0x01aa:
                r7 = r0
            L_0x01ab:
                r8 = 2
                java.lang.String r9 = ""
                boolean r7 = kotlin.text.StringsKt.equals$default(r7, r9, r6, r8, r0)
                if (r7 == 0) goto L_0x01c5
                if (r12 == 0) goto L_0x01bb
                java.lang.String r7 = r12.getOdobrand()
                goto L_0x01bc
            L_0x01bb:
                r7 = r0
            L_0x01bc:
                boolean r7 = kotlin.text.StringsKt.equals$default(r7, r9, r6, r8, r0)
                if (r7 == 0) goto L_0x01c5
                java.lang.String r7 = "Mileage Unavailable"
                goto L_0x0200
            L_0x01c5:
                if (r12 == 0) goto L_0x01cc
                java.lang.String r7 = r12.getOdometer()
                goto L_0x01cd
            L_0x01cc:
                r7 = r0
            L_0x01cd:
                boolean r7 = kotlin.text.StringsKt.equals$default(r7, r9, r6, r8, r0)
                if (r7 == 0) goto L_0x01dc
                if (r12 == 0) goto L_0x01da
                java.lang.String r7 = r12.getOdobrand()
                goto L_0x0200
            L_0x01da:
                r7 = r0
                goto L_0x0200
            L_0x01dc:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                if (r12 == 0) goto L_0x01e8
                java.lang.String r8 = r12.getOdometer()
                goto L_0x01e9
            L_0x01e8:
                r8 = r0
            L_0x01e9:
                r7.append(r8)
                java.lang.String r8 = " mi "
                r7.append(r8)
                if (r12 == 0) goto L_0x01f8
                java.lang.String r8 = r12.getOdobrand()
                goto L_0x01f9
            L_0x01f8:
                r8 = r0
            L_0x01f9:
                r7.append(r8)
                java.lang.String r7 = r7.toString()
            L_0x0200:
                if (r7 != 0) goto L_0x0205
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0205:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r11.binding
                android.widget.TextView r8 = r8.tvPrimaryDamageValue
                java.lang.String r9 = "binding.tvPrimaryDamageValue"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r8.setText(r1)
                if (r12 == 0) goto L_0x0220
                java.lang.String r1 = r12.getBranchName()
                if (r1 == 0) goto L_0x0220
                int r1 = r1.length()
                goto L_0x0221
            L_0x0220:
                r1 = 0
            L_0x0221:
                r8 = 15
                java.lang.String r9 = "binding.tvLongDataLane"
                java.lang.String r10 = "binding.tvLaneSalesValue"
                if (r1 <= r8) goto L_0x0252
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvLaneSalesValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvLongDataLane
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r9)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvLongDataLane
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r9)
                if (r12 == 0) goto L_0x024b
                java.lang.String r8 = r12.getLaneAndItemNumber()
                goto L_0x024c
            L_0x024b:
                r8 = r0
            L_0x024c:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r1.setText(r8)
                goto L_0x027a
            L_0x0252:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvLaneSalesValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvLongDataLane
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r9)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvLaneSalesValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                if (r12 == 0) goto L_0x0274
                java.lang.String r8 = r12.getLaneAndItemNumber()
                goto L_0x0275
            L_0x0274:
                r8 = r0
            L_0x0275:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r1.setText(r8)
            L_0x027a:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.preSaleRow3Right
                java.lang.String r8 = "binding.preSaleRow3Right"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r1.setText(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r7 = r11.this$0
                com.iaai.android.bdt.feature.viewPager.FastSearchViewModel r7 = r7.fastSearchViewModel
                r1.setVehicleSearchModel(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                r1.setVehicleData(r12)
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r1 = r11.this$0
                java.util.HashMap r1 = r1.getHashMap()
                java.util.Map r1 = (java.util.Map) r1
                if (r12 == 0) goto L_0x02ab
                int r7 = r12.getItemId()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                goto L_0x02ac
            L_0x02ab:
                r7 = r0
            L_0x02ac:
                java.lang.Object r1 = r1.get(r7)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                if (r1 == 0) goto L_0x02b9
                boolean r1 = r1.booleanValue()
                goto L_0x02ba
            L_0x02b9:
                r1 = 0
            L_0x02ba:
                java.lang.String r7 = "binding.flWatch"
                java.lang.String r8 = "binding.flUnwatch"
                if (r1 == 0) goto L_0x02e9
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r3)
                goto L_0x0311
            L_0x02e9:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r6)
            L_0x0311:
                if (r12 == 0) goto L_0x0318
                java.lang.Boolean r1 = r12.isWatchable()
                goto L_0x0319
            L_0x0318:
                r1 = r0
            L_0x0319:
                if (r1 == 0) goto L_0x036f
                if (r12 == 0) goto L_0x0322
                java.lang.Boolean r1 = r12.isWatchable()
                goto L_0x0323
            L_0x0322:
                r1 = r0
            L_0x0323:
                if (r1 != 0) goto L_0x0328
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0328:
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x036f
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setEnabled(r5)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setEnabled(r5)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r4 = 1065353216(0x3f800000, float:1.0)
                r1.setAlpha(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r2 = 1065353216(0x3f800000, float:1.0)
                r1.setAlpha(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setEnabled(r5)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setEnabled(r5)
                goto L_0x03af
            L_0x036f:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r4 = 1056964608(0x3f000000, float:0.5)
                r1.setAlpha(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r2 = 1056964608(0x3f000000, float:0.5)
                r1.setAlpha(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setEnabled(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setEnabled(r6)
            L_0x03af:
                com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
                r1.<init>()
                com.bumptech.glide.request.RequestOptions r1 = r1.centerCrop()
                r2 = 2131231231(0x7f0801ff, float:1.8078537E38)
                com.bumptech.glide.request.RequestOptions r1 = r1.error((int) r2)
                com.bumptech.glide.load.engine.DiskCacheStrategy r2 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
                com.bumptech.glide.request.RequestOptions r1 = r1.diskCacheStrategy(r2)
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.HIGH
                com.bumptech.glide.request.RequestOptions r1 = r1.priority(r2)
                r2 = 2131231567(0x7f08034f, float:1.8079219E38)
                com.bumptech.glide.request.RequestOptions r1 = r1.placeholder((int) r2)
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
                if (r12 == 0) goto L_0x03e3
                java.lang.Object r4 = r12.getImageUrl()
                goto L_0x03e4
            L_0x03e3:
                r4 = r0
            L_0x03e4:
                com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.Object) r4)
                com.bumptech.glide.RequestBuilder r2 = r2.apply(r1)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.ImageView r4 = r4.vehicleImage1
                r2.into((android.widget.ImageView) r4)
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
                if (r12 == 0) goto L_0x0404
                java.lang.Object r4 = r12.getImageUrl()
                goto L_0x0405
            L_0x0404:
                r4 = r0
            L_0x0405:
                com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.Object) r4)
                com.bumptech.glide.RequestBuilder r1 = r2.apply(r1)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r2 = r11.binding
                android.widget.ImageView r2 = r2.vehicleImage2
                r1.into((android.widget.ImageView) r2)
                if (r12 == 0) goto L_0x041b
                java.lang.String r1 = r12.getBranchName()
                goto L_0x041c
            L_0x041b:
                r1 = r0
            L_0x041c:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0429
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0427
                goto L_0x0429
            L_0x0427:
                r1 = 0
                goto L_0x042a
            L_0x0429:
                r1 = 1
            L_0x042a:
                java.lang.String r2 = "binding.tvBranchName"
                if (r1 != 0) goto L_0x044d
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvBranchName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvBranchName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                if (r12 == 0) goto L_0x0446
                java.lang.String r2 = r12.getBranchName()
                goto L_0x0447
            L_0x0446:
                r2 = r0
            L_0x0447:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                goto L_0x0457
            L_0x044d:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvBranchName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x0457:
                if (r12 == 0) goto L_0x045e
                java.lang.String r1 = r12.getAuctionTime()
                goto L_0x045f
            L_0x045e:
                r1 = r0
            L_0x045f:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x046c
                int r1 = r1.length()
                if (r1 != 0) goto L_0x046a
                goto L_0x046c
            L_0x046a:
                r1 = 0
                goto L_0x046d
            L_0x046c:
                r1 = 1
            L_0x046d:
                if (r1 != 0) goto L_0x0492
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvAuctionTime
                java.lang.String r2 = "binding.tvAuctionTime"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvAuctionTime
                java.lang.String r2 = "binding.tvAuctionTime"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                if (r12 == 0) goto L_0x048b
                java.lang.String r2 = r12.getAuctionTime()
                goto L_0x048c
            L_0x048b:
                r2 = r0
            L_0x048c:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                goto L_0x049e
            L_0x0492:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvAuctionTime
                java.lang.String r2 = "binding.tvAuctionTime"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x049e:
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r1 = r11.this$0
                r1.isOffsiteTruncate = r6
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r1 = r11.this$0
                r1.isRunDriveTruncate = r6
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r1 = r11.this$0
                r1.isPublicTruncate = r6
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llBadgeConatiner
                java.lang.String r2 = "binding.llBadgeConatiner"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r2 = 4
                r1.setVisibility(r2)
                if (r12 == 0) goto L_0x04c1
                java.lang.String r1 = r12.getRunAndDrive()
                goto L_0x04c2
            L_0x04c1:
                r1 = r0
            L_0x04c2:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x04cf
                int r1 = r1.length()
                if (r1 != 0) goto L_0x04cd
                goto L_0x04cf
            L_0x04cd:
                r1 = 0
                goto L_0x04d0
            L_0x04cf:
                r1 = 1
            L_0x04d0:
                if (r1 != 0) goto L_0x04df
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvRunDrive
                java.lang.String r2 = "binding.tvRunDrive"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r6)
                goto L_0x04eb
            L_0x04df:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvRunDrive
                java.lang.String r2 = "binding.tvRunDrive"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x04eb:
                if (r12 == 0) goto L_0x04f2
                java.lang.String r1 = r12.getOffsiteSaleIndicator()
                goto L_0x04f3
            L_0x04f2:
                r1 = r0
            L_0x04f3:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0500
                int r1 = r1.length()
                if (r1 != 0) goto L_0x04fe
                goto L_0x0500
            L_0x04fe:
                r1 = 0
                goto L_0x0501
            L_0x0500:
                r1 = 1
            L_0x0501:
                if (r1 != 0) goto L_0x0510
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvOffsite
                java.lang.String r2 = "binding.tvOffsite"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r6)
                goto L_0x051c
            L_0x0510:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvOffsite
                java.lang.String r2 = "binding.tvOffsite"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x051c:
                if (r12 == 0) goto L_0x0523
                java.lang.String r1 = r12.getPublicVehicle()
                goto L_0x0524
            L_0x0523:
                r1 = r0
            L_0x0524:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0531
                int r1 = r1.length()
                if (r1 != 0) goto L_0x052f
                goto L_0x0531
            L_0x052f:
                r1 = 0
                goto L_0x0532
            L_0x0531:
                r1 = 1
            L_0x0532:
                if (r1 != 0) goto L_0x0541
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvIsPublic
                java.lang.String r2 = "binding.tvIsPublic"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r6)
                goto L_0x054d
            L_0x0541:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvIsPublic
                java.lang.String r2 = "binding.tvIsPublic"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x054d:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvIsPublic
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter$ResultDataItemViewHolder$bindTo$1 r2 = new com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter$ResultDataItemViewHolder$bindTo$1
                r2.<init>(r11)
                android.view.ViewTreeObserver$OnPreDrawListener r2 = (android.view.ViewTreeObserver.OnPreDrawListener) r2
                r1.addOnPreDrawListener(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvRunDrive
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter$ResultDataItemViewHolder$bindTo$2 r2 = new com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter$ResultDataItemViewHolder$bindTo$2
                r2.<init>(r11)
                android.view.ViewTreeObserver$OnPreDrawListener r2 = (android.view.ViewTreeObserver.OnPreDrawListener) r2
                r1.addOnPreDrawListener(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvOffsite
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter$ResultDataItemViewHolder$bindTo$3 r2 = new com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter$ResultDataItemViewHolder$bindTo$3
                r2.<init>(r11)
                android.view.ViewTreeObserver$OnPreDrawListener r2 = (android.view.ViewTreeObserver.OnPreDrawListener) r2
                r1.addOnPreDrawListener(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r2 = r11.this$0
                boolean r2 = r2.isPublicTruncate
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r4 = r11.this$0
                boolean r4 = r4.isRunDriveTruncate
                com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r7 = r11.this$0
                boolean r7 = r7.isOffsiteTruncate
                r11.handleBadgeAlignment(r1, r2, r4, r7)
                if (r12 == 0) goto L_0x05a0
                java.lang.Boolean r0 = r12.getTBOIndicator()
            L_0x05a0:
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r5)
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
                if (r12 == 0) goto L_0x05b7
                com.iaai.android.databinding.ItemAuctionSalesListBinding r12 = r11.binding
                android.widget.TextView r12 = r12.tvTitleNotAvailable
                java.lang.String r0 = "binding.tvTitleNotAvailable"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)
                r12.setVisibility(r6)
                goto L_0x05dc
            L_0x05b7:
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
                if (r12 == 0) goto L_0x05ce
                com.iaai.android.databinding.ItemAuctionSalesListBinding r12 = r11.binding
                android.widget.TextView r12 = r12.tvTitleNotAvailable
                java.lang.String r0 = "binding.tvTitleNotAvailable"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)
                r12.setVisibility(r3)
                goto L_0x05dc
            L_0x05ce:
                if (r0 != 0) goto L_0x05dc
                com.iaai.android.databinding.ItemAuctionSalesListBinding r12 = r11.binding
                android.widget.TextView r12 = r12.tvTitleNotAvailable
                java.lang.String r0 = "binding.tvTitleNotAvailable"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)
                r12.setVisibility(r3)
            L_0x05dc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter.ResultDataItemViewHolder.bindTo(com.iaai.android.bdt.model.fastSearch.Vehicle):void");
        }

        public final void handleBadgeAlignment(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            if (z || z2 || z3) {
                LinearLayout linearLayout = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llBadgeConatiner");
                linearLayout.setGravity(5);
                this.this$0.getConstraintSet().clone(itemAuctionSalesListBinding.parentItem);
                ConstraintSet constraintSet = this.this$0.getConstraintSet();
                LinearLayout linearLayout2 = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llBadgeConatiner");
                int id = linearLayout2.getId();
                ConstraintLayout constraintLayout = itemAuctionSalesListBinding.parentItem;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.parentItem");
                constraintSet.connect(id, 6, constraintLayout.getId(), 6, 0);
                this.this$0.getConstraintSet().applyTo(itemAuctionSalesListBinding.parentItem);
            } else {
                LinearLayout linearLayout3 = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "binding.llBadgeConatiner");
                linearLayout3.setGravity(3);
                this.this$0.getConstraintSet().clone(itemAuctionSalesListBinding.parentItem);
                ConstraintSet constraintSet2 = this.this$0.getConstraintSet();
                LinearLayout linearLayout4 = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "binding.llBadgeConatiner");
                int id2 = linearLayout4.getId();
                ConstraintLayout constraintLayout2 = itemAuctionSalesListBinding.constraintLayout;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.constraintLayout");
                constraintSet2.connect(id2, 6, constraintLayout2.getId(), 6, 0);
                this.this$0.getConstraintSet().applyTo(itemAuctionSalesListBinding.parentItem);
            }
            LinearLayout linearLayout5 = itemAuctionSalesListBinding.llBadgeConatiner;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "binding.llBadgeConatiner");
            linearLayout5.setVisibility(0);
        }
    }
}
