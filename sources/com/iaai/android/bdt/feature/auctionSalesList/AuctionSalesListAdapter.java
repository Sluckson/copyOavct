package com.iaai.android.bdt.feature.auctionSalesList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.auctionSalesList.AuctionDetails;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.utils.CustomItemClickListener;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.databinding.ItemAuctionSalesListBinding;
import com.iaai.android.databinding.RowItemAuctinSalesListHeaderBinding;
import com.iaai.android.old.utils.DateHelper;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003456B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 H\u0016J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0013R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u001e¨\u00067"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "auctionSalesListViewModel", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListViewModel;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/utils/CustomItemClickListener;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListViewModel;Landroid/content/Context;Lcom/iaai/android/bdt/utils/CustomItemClickListener;)V", "auctionSalesListHeader", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "getAuctionSalesListHeader", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "setAuctionSalesListHeader", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;)V", "hashMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "isBidLive", "getListener", "()Lcom/iaai/android/bdt/utils/CustomItemClickListener;", "getMContext", "()Landroid/content/Context;", "selectedIemID", "Ljava/lang/Long;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBidLiveInfo", "auctionDetails", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "setHeaderItem", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Long;)V", "setWatchingData", "isWatching", "itemID", "Companion", "HeaderDataViewHolder", "ResultDataItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListAdapter.kt */
public final class AuctionSalesListAdapter extends PagedListAdapter<ResultData, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    @NotNull
    public AuctionSalesListHeader auctionSalesListHeader;
    /* access modifiers changed from: private */
    public final AuctionSalesListViewModel auctionSalesListViewModel;
    @NotNull
    private final HashMap<Long, Boolean> hashMap = new HashMap<>();
    /* access modifiers changed from: private */
    public boolean isBidLive;
    @NotNull
    private final CustomItemClickListener listener;
    @NotNull
    private final Context mContext;
    /* access modifiers changed from: private */
    public Long selectedIemID = -1L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuctionSalesListAdapter(@NotNull AuctionSalesListViewModel auctionSalesListViewModel2, @NotNull Context context, @NotNull CustomItemClickListener customItemClickListener) {
        super(ResultData.Companion.getDIFF_CALLBACK());
        Intrinsics.checkParameterIsNotNull(auctionSalesListViewModel2, "auctionSalesListViewModel");
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(customItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.auctionSalesListViewModel = auctionSalesListViewModel2;
        this.mContext = context;
        this.listener = customItemClickListener;
    }

    public static final /* synthetic */ ResultData access$getItem(AuctionSalesListAdapter auctionSalesListAdapter, int i) {
        return (ResultData) auctionSalesListAdapter.getItem(i);
    }

    @NotNull
    public final CustomItemClickListener getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final HashMap<Long, Boolean> getHashMap() {
        return this.hashMap;
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AuctionSalesListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return AuctionSalesListAdapter.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return AuctionSalesListAdapter.TYPE_ITEM;
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
            ((TextView) view.findViewById(C2723R.C2726id.tv_filter_label)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$1(this, objectRef));
            View view2 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ((TextView) view2.findViewById(C2723R.C2726id.tv_filterCount)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$2(this, objectRef));
            View view3 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            ((ImageView) view3.findViewById(C2723R.C2726id.img_filter)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$3(this, objectRef));
            View view4 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
            ((ImageView) view4.findViewById(C2723R.C2726id.iv_sort)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$4(this, objectRef));
            View view5 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
            ((TextView) view5.findViewById(C2723R.C2726id.tv_SortLabel)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$5(this, objectRef));
            View view6 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
            ((Button) view6.findViewById(C2723R.C2726id.btnBidAuctionSales)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$6(this, objectRef));
        } else if (i == TYPE_ITEM) {
            ItemAuctionSalesListBinding inflate3 = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemAuctionSalesListBind…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate3);
            View view7 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view7, "holder.itemView");
            ((FrameLayout) view7.findViewById(C2723R.C2726id.fl_unwatch)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$7(this, objectRef));
            View view8 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view8, "holder.itemView");
            ((FrameLayout) view8.findViewById(C2723R.C2726id.fl_watch)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$8(this, objectRef));
            View view9 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view9, "holder.itemView");
            ((LinearLayout) view9.findViewById(C2723R.C2726id.llUnWatch)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$9(this, objectRef));
            View view10 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view10, "holder.itemView");
            ((LinearLayout) view10.findViewById(C2723R.C2726id.llWatch)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$10(this, objectRef));
            View view11 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view11, "holder.itemView");
            ((ConstraintLayout) view11.findViewById(C2723R.C2726id.parent_item)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$11(this, objectRef));
            View view12 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view12, "holder.itemView");
            ((ImageView) view12.findViewById(C2723R.C2726id.img_arrow_right)).setOnClickListener(new AuctionSalesListAdapter$onCreateViewHolder$12(this, objectRef));
        }
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public final void setHeaderItem(@NotNull AuctionSalesListHeader auctionSalesListHeader2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "auctionSalesListHeader");
        this.auctionSalesListHeader = auctionSalesListHeader2;
    }

    public final void setBidLiveInfo(@NotNull AuctionDetails auctionDetails) {
        Intrinsics.checkParameterIsNotNull(auctionDetails, "auctionDetails");
        if (this.auctionSalesListHeader != null) {
            AuctionSalesListHeader auctionSalesListHeader2 = this.auctionSalesListHeader;
            if (auctionSalesListHeader2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListHeader");
            }
            auctionSalesListHeader2.setAuctionDetails(auctionDetails);
        }
    }

    public final void setWatchingData(boolean z, long j) {
        if (z) {
            this.hashMap.put(Long.valueOf(j), Boolean.valueOf(z));
        } else {
            this.hashMap.remove(Long.valueOf(j));
        }
    }

    public final void setSelectedItemForTablet(@Nullable Long l) {
        this.selectedIemID = l;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() <= 0) {
            return;
        }
        if (viewHolder instanceof ResultDataItemViewHolder) {
            ((ResultDataItemViewHolder) viewHolder).bindTo((ResultData) getItem(i - 1));
        } else if (viewHolder instanceof HeaderDataViewHolder) {
            ((HeaderDataViewHolder) viewHolder).bindTo();
        }
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListAdapter$HeaderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListAdapter;Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;)V", "isClickedEnabled", "", "()Z", "setClickedEnabled", "(Z)V", "bindTo", "", "updateBidLive", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AuctionSalesListAdapter.kt */
    public final class HeaderDataViewHolder extends RecyclerView.ViewHolder {
        private final RowItemAuctinSalesListHeaderBinding binding;
        private boolean isClickedEnabled;
        final /* synthetic */ AuctionSalesListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderDataViewHolder(@NotNull AuctionSalesListAdapter auctionSalesListAdapter, RowItemAuctinSalesListHeaderBinding rowItemAuctinSalesListHeaderBinding) {
            super(rowItemAuctinSalesListHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemAuctinSalesListHeaderBinding, "binding");
            this.this$0 = auctionSalesListAdapter;
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
            constraintLayout.setVisibility(0);
            TextView textView = this.binding.tvBranchNameLabel;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvBranchNameLabel");
            textView.setText(this.this$0.getAuctionSalesListHeader().getBranchName());
            if (this.this$0.getAuctionSalesListHeader().getFilterCount() == 0) {
                TextView textView2 = this.binding.tvFilterCount;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvFilterCount");
                textView2.setVisibility(8);
            } else {
                TextView textView3 = this.binding.tvFilterCount;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvFilterCount");
                textView3.setVisibility(0);
                String valueOf = String.valueOf(this.this$0.getAuctionSalesListHeader().getFilterCount());
                TextView textView4 = this.binding.tvFilterCount;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvFilterCount");
                textView4.setText(valueOf);
            }
            if (this.this$0.getAuctionSalesListHeader().isError()) {
                View view = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.emptyView");
                TextView textView5 = (TextView) view.findViewById(C2723R.C2726id.errorTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.emptyView.errorTitle");
                textView5.setText(this.this$0.getAuctionSalesListHeader().getErrorType().getValue());
                View view2 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "binding.emptyView");
                TextView textView6 = (TextView) view2.findViewById(C2723R.C2726id.errorBody);
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.emptyView.errorBody");
                textView6.setText(this.this$0.getAuctionSalesListHeader().getErrorMessage());
                ConstraintLayout constraintLayout2 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clEmptyView");
                constraintLayout2.setVisibility(0);
            } else {
                ConstraintLayout constraintLayout3 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.clEmptyView");
                constraintLayout3.setVisibility(8);
            }
            TextView textView7 = this.binding.tvTodaysDay;
            Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvTodaysDay");
            NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
            String auctionDate = this.this$0.getAuctionSalesListHeader().getAuctionDate();
            if (auctionDate == null) {
                Intrinsics.throwNpe();
            }
            textView7.setText(newDateHelper.getAuctionDay(auctionDate));
            NewDateHelper newDateHelper2 = NewDateHelper.INSTANCE;
            String auctionDate2 = this.this$0.getAuctionSalesListHeader().getAuctionDate();
            if (auctionDate2 == null) {
                Intrinsics.throwNpe();
            }
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(newDateHelper2.getAuctionTime(auctionDate2), "AM", "am", false, 4, (Object) null), "PM", "pm", false, 4, (Object) null);
            if (this.this$0.getAuctionSalesListHeader().isError()) {
                TextView textView8 = this.binding.tvVehicleCountSalesList;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvVehicleCountSalesList");
                textView8.setText("0 " + this.this$0.getMContext().getString(C2723R.string.lbl_bdt_single_vehicle));
            } else {
                String vehicalCount = this.this$0.getAuctionSalesListHeader().getVehicalCount();
                TextView textView9 = this.binding.tvVehicleCountSalesList;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvVehicleCountSalesList");
                textView9.setText(vehicalCount + ' ' + this.this$0.getMContext().getString(C2723R.string.lbl_bdt_single_vehicle));
            }
            TextView textView10 = this.binding.tvAuctionDateTime;
            Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvAuctionDateTime");
            textView10.setText(replace$default);
            TextView textView11 = this.binding.tvTodaysDate;
            Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvTodaysDate");
            NewDateHelper newDateHelper3 = NewDateHelper.INSTANCE;
            String auctionDate3 = this.this$0.getAuctionSalesListHeader().getAuctionDate();
            if (auctionDate3 == null) {
                Intrinsics.throwNpe();
            }
            textView11.setText(newDateHelper3.getAuctionDate(auctionDate3));
            if (this.this$0.getAuctionSalesListHeader().getAuctionDetails() != null) {
                updateBidLive();
            }
        }

        private final void updateBidLive() {
            AuctionDetails auctionDetails = this.this$0.getAuctionSalesListHeader().getAuctionDetails();
            Boolean valueOf = auctionDetails != null ? Boolean.valueOf(auctionDetails.getAuctionClosed()) : null;
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            if (valueOf.booleanValue()) {
                Button button = this.binding.btnBidAuctionSales;
                Intrinsics.checkExpressionValueIsNotNull(button, "binding.btnBidAuctionSales");
                button.setText(this.this$0.getMContext().getString(C2723R.string.lbl_bdt_bid_live));
                Button button2 = this.binding.btnBidAuctionSales;
                Intrinsics.checkExpressionValueIsNotNull(button2, "binding.btnBidAuctionSales");
                button2.setClickable(false);
                Button button3 = this.binding.btnBidAuctionSales;
                Intrinsics.checkExpressionValueIsNotNull(button3, "binding.btnBidAuctionSales");
                button3.setAlpha(0.5f);
                Button button4 = this.binding.btnBidAuctionSales;
                Intrinsics.checkExpressionValueIsNotNull(button4, "binding.btnBidAuctionSales");
                button4.setVisibility(0);
                return;
            }
            String auctionDate = this.this$0.getAuctionSalesListHeader().getAuctionDate();
            if (auctionDate == null) {
                Intrinsics.throwNpe();
            }
            if (!Intrinsics.areEqual((Object) auctionDate, (Object) "")) {
                Date date = new Date();
                String auctionDate2 = this.this$0.getAuctionSalesListHeader().getAuctionDate();
                if (auctionDate2 == null) {
                    Intrinsics.throwNpe();
                }
                DateHelper.TimeDiff calculateDateTimeDiffWithoutAbs = DateHelper.calculateDateTimeDiffWithoutAbs(date, DateHelper.parseDateInServerTimezone(auctionDate2));
                if (calculateDateTimeDiffWithoutAbs.days == 0 && calculateDateTimeDiffWithoutAbs.hours == 0 && calculateDateTimeDiffWithoutAbs.minutes <= 0 && calculateDateTimeDiffWithoutAbs.seconds <= 0) {
                    Button button5 = this.binding.btnBidAuctionSales;
                    Intrinsics.checkExpressionValueIsNotNull(button5, "binding.btnBidAuctionSales");
                    button5.setVisibility(0);
                    Button button6 = this.binding.btnBidAuctionSales;
                    Intrinsics.checkExpressionValueIsNotNull(button6, "binding.btnBidAuctionSales");
                    button6.setClickable(true);
                    Button button7 = this.binding.btnBidAuctionSales;
                    Intrinsics.checkExpressionValueIsNotNull(button7, "binding.btnBidAuctionSales");
                    button7.setText(this.this$0.getMContext().getString(C2723R.string.lbl_bdt_bid_live));
                    this.this$0.isBidLive = true;
                } else if (calculateDateTimeDiffWithoutAbs.days > 0 || calculateDateTimeDiffWithoutAbs.hours > 0) {
                    Button button8 = this.binding.btnBidAuctionSales;
                    Intrinsics.checkExpressionValueIsNotNull(button8, "binding.btnBidAuctionSales");
                    button8.setVisibility(8);
                } else {
                    int i = calculateDateTimeDiffWithoutAbs.minutes;
                    if (i >= 0 && 59 >= i) {
                        Button button9 = this.binding.btnBidAuctionSales;
                        Intrinsics.checkExpressionValueIsNotNull(button9, "binding.btnBidAuctionSales");
                        button9.setText(this.this$0.getMContext().getString(C2723R.string.lbl_bdt_join_auction));
                        Button button10 = this.binding.btnBidAuctionSales;
                        Intrinsics.checkExpressionValueIsNotNull(button10, "binding.btnBidAuctionSales");
                        button10.setClickable(true);
                        Button button11 = this.binding.btnBidAuctionSales;
                        Intrinsics.checkExpressionValueIsNotNull(button11, "binding.btnBidAuctionSales");
                        button11.setVisibility(0);
                        this.this$0.isBidLive = false;
                        return;
                    }
                    Button button12 = this.binding.btnBidAuctionSales;
                    Intrinsics.checkExpressionValueIsNotNull(button12, "binding.btnBidAuctionSales");
                    button12.setVisibility(8);
                }
            }
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListAdapter$ResultDataItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListAdapter;Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;)V", "bindTo", "", "resultDatum", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AuctionSalesListAdapter.kt */
    public final class ResultDataItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemAuctionSalesListBinding binding;
        final /* synthetic */ AuctionSalesListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultDataItemViewHolder(@NotNull AuctionSalesListAdapter auctionSalesListAdapter, ItemAuctionSalesListBinding itemAuctionSalesListBinding) {
            super(itemAuctionSalesListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            this.this$0 = auctionSalesListAdapter;
            this.binding = itemAuctionSalesListBinding;
        }

        /* JADX WARNING: Removed duplicated region for block: B:128:0x0257  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x025c  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x0267  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x026c  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x027b  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0280  */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x028c  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x028e  */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x0295  */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x02fb  */
        /* JADX WARNING: Removed duplicated region for block: B:168:0x0321  */
        /* JADX WARNING: Removed duplicated region for block: B:169:0x0326  */
        /* JADX WARNING: Removed duplicated region for block: B:174:0x0332  */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x0334  */
        /* JADX WARNING: Removed duplicated region for block: B:178:0x0339  */
        /* JADX WARNING: Removed duplicated region for block: B:179:0x0344  */
        /* JADX WARNING: Removed duplicated region for block: B:187:0x0395  */
        /* JADX WARNING: Removed duplicated region for block: B:188:0x039a  */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x03a3  */
        /* JADX WARNING: Removed duplicated region for block: B:192:0x03a8  */
        /* JADX WARNING: Removed duplicated region for block: B:194:0x03ab  */
        /* JADX WARNING: Removed duplicated region for block: B:195:0x03b0  */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x03bb  */
        /* JADX WARNING: Removed duplicated region for block: B:208:0x044d  */
        /* JADX WARNING: Removed duplicated region for block: B:209:0x0476  */
        /* JADX WARNING: Removed duplicated region for block: B:212:0x04cd  */
        /* JADX WARNING: Removed duplicated region for block: B:213:0x04d2  */
        /* JADX WARNING: Removed duplicated region for block: B:216:0x04ee  */
        /* JADX WARNING: Removed duplicated region for block: B:217:0x04f3  */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x0505  */
        /* JADX WARNING: Removed duplicated region for block: B:223:0x0515  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x0520  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindTo(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.auctionSalesList.ResultData r12) {
            /*
                r11 = this;
                r0 = 0
                if (r12 == 0) goto L_0x0008
                java.lang.Long r1 = r12.getItemId()
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r2 = r11.this$0
                java.lang.Long r2 = r2.selectedIemID
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
                r2 = 23
                if (r1 == 0) goto L_0x004d
                int r1 = android.os.Build.VERSION.SDK_INT
                if (r1 < r2) goto L_0x0034
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r2 = r2.getColor(r3, r0)
                r1.setBackgroundColor(r2)
                goto L_0x0082
            L_0x0034:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r2 = r2.getColor(r3)
                r1.setBackgroundColor(r2)
                goto L_0x0082
            L_0x004d:
                int r1 = android.os.Build.VERSION.SDK_INT
                if (r1 < r2) goto L_0x006a
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099728(0x7f060050, float:1.7811817E38)
                int r2 = r2.getColor(r3, r0)
                r1.setBackgroundColor(r2)
                goto L_0x0082
            L_0x006a:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099728(0x7f060050, float:1.7811817E38)
                int r2 = r2.getColor(r3)
                r1.setBackgroundColor(r2)
            L_0x0082:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.yearMakeModel
                java.lang.String r2 = "binding.yearMakeModel"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                if (r12 == 0) goto L_0x00a7
                java.lang.String r2 = r12.getVehicleTitle()
                if (r2 == 0) goto L_0x00a7
                if (r2 == 0) goto L_0x009f
                java.lang.String r2 = r2.toUpperCase()
                java.lang.String r3 = "(this as java.lang.String).toUpperCase()"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
                goto L_0x00a8
            L_0x009f:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                r12.<init>(r0)
                throw r12
            L_0x00a7:
                r2 = r0
            L_0x00a8:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                if (r12 == 0) goto L_0x00b4
                java.lang.String r1 = r12.getDamage2()
                goto L_0x00b5
            L_0x00b4:
                r1 = r0
            L_0x00b5:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x00c4
                int r1 = r1.length()
                if (r1 != 0) goto L_0x00c2
                goto L_0x00c4
            L_0x00c2:
                r1 = 0
                goto L_0x00c5
            L_0x00c4:
                r1 = 1
            L_0x00c5:
                java.lang.String r4 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r1 == 0) goto L_0x00ec
                if (r12 == 0) goto L_0x00ea
                java.lang.String r1 = r12.getDamage()
                if (r1 == 0) goto L_0x00ea
                java.lang.String r1 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r1)
                if (r1 == 0) goto L_0x00ea
                if (r1 == 0) goto L_0x00e4
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
                java.lang.String r1 = r1.toString()
                goto L_0x0130
            L_0x00e4:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r4)
                throw r12
            L_0x00ea:
                r1 = r0
                goto L_0x0130
            L_0x00ec:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                if (r12 == 0) goto L_0x0112
                java.lang.String r5 = r12.getDamage2()
                if (r5 == 0) goto L_0x0112
                java.lang.String r5 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r5)
                if (r5 == 0) goto L_0x0112
                if (r5 == 0) goto L_0x010c
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.CharSequence r5 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r5)
                java.lang.String r5 = r5.toString()
                goto L_0x0113
            L_0x010c:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r4)
                throw r12
            L_0x0112:
                r5 = r0
            L_0x0113:
                r1.append(r5)
                java.lang.String r5 = ", "
                r1.append(r5)
                if (r12 == 0) goto L_0x0128
                java.lang.String r5 = r12.getDamage()
                if (r5 == 0) goto L_0x0128
                java.lang.String r5 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r5)
                goto L_0x0129
            L_0x0128:
                r5 = r0
            L_0x0129:
                r1.append(r5)
                java.lang.String r1 = r1.toString()
            L_0x0130:
                if (r12 == 0) goto L_0x0137
                java.lang.String r5 = r12.getOdometer()
                goto L_0x0138
            L_0x0137:
                r5 = r0
            L_0x0138:
                r6 = 2
                java.lang.String r7 = ""
                boolean r5 = kotlin.text.StringsKt.equals$default(r5, r7, r3, r6, r0)
                if (r5 == 0) goto L_0x0153
                if (r12 == 0) goto L_0x0148
                java.lang.String r5 = r12.getOdometerStatus()
                goto L_0x0149
            L_0x0148:
                r5 = r0
            L_0x0149:
                boolean r5 = kotlin.text.StringsKt.equals$default(r5, r7, r3, r6, r0)
                if (r5 == 0) goto L_0x0153
                java.lang.String r4 = "Mileage Unavailable"
                goto L_0x0239
            L_0x0153:
                if (r12 == 0) goto L_0x015a
                java.lang.String r5 = r12.getOdometer()
                goto L_0x015b
            L_0x015a:
                r5 = r0
            L_0x015b:
                boolean r5 = kotlin.text.StringsKt.equals$default(r5, r7, r3, r6, r0)
                if (r5 == 0) goto L_0x019b
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r6 = 40
                r5.append(r6)
                if (r12 == 0) goto L_0x018c
                java.lang.String r6 = r12.getOdometerStatus()
                if (r6 == 0) goto L_0x018c
                java.lang.String r6 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r6)
                if (r6 == 0) goto L_0x018c
                if (r6 == 0) goto L_0x0186
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                java.lang.CharSequence r4 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r6)
                java.lang.String r4 = r4.toString()
                goto L_0x018d
            L_0x0186:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r4)
                throw r12
            L_0x018c:
                r4 = r0
            L_0x018d:
                r5.append(r4)
                r4 = 41
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                goto L_0x0239
            L_0x019b:
                if (r12 == 0) goto L_0x01a2
                java.lang.String r5 = r12.getOdometerStatus()
                goto L_0x01a3
            L_0x01a2:
                r5 = r0
            L_0x01a3:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                if (r5 == 0) goto L_0x01b0
                int r5 = r5.length()
                if (r5 != 0) goto L_0x01ae
                goto L_0x01b0
            L_0x01ae:
                r5 = 0
                goto L_0x01b1
            L_0x01b0:
                r5 = 1
            L_0x01b1:
                if (r5 == 0) goto L_0x01df
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.text.NumberFormat r5 = java.text.NumberFormat.getIntegerInstance()
                if (r12 == 0) goto L_0x01cd
                java.lang.String r6 = r12.getOdometer()
                if (r6 == 0) goto L_0x01cd
                long r8 = java.lang.Long.parseLong(r6)
                java.lang.Long r6 = java.lang.Long.valueOf(r8)
                goto L_0x01ce
            L_0x01cd:
                r6 = r0
            L_0x01ce:
                java.lang.String r5 = r5.format(r6)
                r4.append(r5)
                java.lang.String r5 = " mi."
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                goto L_0x0239
            L_0x01df:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.text.NumberFormat r6 = java.text.NumberFormat.getIntegerInstance()
                if (r12 == 0) goto L_0x01f9
                java.lang.String r8 = r12.getOdometer()
                if (r8 == 0) goto L_0x01f9
                long r8 = java.lang.Long.parseLong(r8)
                java.lang.Long r8 = java.lang.Long.valueOf(r8)
                goto L_0x01fa
            L_0x01f9:
                r8 = r0
            L_0x01fa:
                java.lang.String r6 = r6.format(r8)
                r5.append(r6)
                java.lang.String r6 = " mi."
                r5.append(r6)
                java.lang.String r6 = " ("
                r5.append(r6)
                if (r12 == 0) goto L_0x022c
                java.lang.String r6 = r12.getOdometerStatus()
                if (r6 == 0) goto L_0x022c
                java.lang.String r6 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r6)
                if (r6 == 0) goto L_0x022c
                if (r6 == 0) goto L_0x0226
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                java.lang.CharSequence r4 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r6)
                java.lang.String r4 = r4.toString()
                goto L_0x022d
            L_0x0226:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r4)
                throw r12
            L_0x022c:
                r4 = r0
            L_0x022d:
                r5.append(r4)
                r4 = 41
                r5.append(r4)
                java.lang.String r4 = r5.toString()
            L_0x0239:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r5 = r11.binding
                android.widget.TextView r5 = r5.tvPrimaryDamageValue
                java.lang.String r6 = "binding.tvPrimaryDamageValue"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r5.setText(r1)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvLaneSalesValue
                java.lang.String r5 = "binding.tvLaneSalesValue"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                if (r12 == 0) goto L_0x025c
                java.lang.String r6 = r12.getLane()
                goto L_0x025d
            L_0x025c:
                r6 = r0
            L_0x025d:
                r5.append(r6)
                java.lang.String r6 = " - #"
                r5.append(r6)
                if (r12 == 0) goto L_0x026c
                java.lang.String r6 = r12.getSlot()
                goto L_0x026d
            L_0x026c:
                r6 = r0
            L_0x026d:
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
                if (r12 == 0) goto L_0x0280
                java.lang.String r1 = r12.getAisleRow()
                goto L_0x0281
            L_0x0280:
                r1 = r0
            L_0x0281:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x028e
                int r1 = r1.length()
                if (r1 != 0) goto L_0x028c
                goto L_0x028e
            L_0x028c:
                r1 = 0
                goto L_0x028f
            L_0x028e:
                r1 = 1
            L_0x028f:
                java.lang.String r5 = "binding.tvAisleValue"
                r6 = 8
                if (r1 != 0) goto L_0x02fb
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvSeparator
                java.lang.String r8 = "binding.tvSeparator"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvAisleValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setVisibility(r3)
                if (r12 == 0) goto L_0x02b2
                java.lang.Integer r1 = r12.getStallNumber()
                goto L_0x02b3
            L_0x02b2:
                r1 = r0
            L_0x02b3:
                if (r1 == 0) goto L_0x02e6
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvAisleValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                if (r12 == 0) goto L_0x02c8
                java.lang.String r8 = r12.getAisleRow()
                goto L_0x02c9
            L_0x02c8:
                r8 = r0
            L_0x02c9:
                r5.append(r8)
                java.lang.String r8 = " - "
                r5.append(r8)
                if (r12 == 0) goto L_0x02d8
                java.lang.Integer r8 = r12.getStallNumber()
                goto L_0x02d9
            L_0x02d8:
                r8 = r0
            L_0x02d9:
                r5.append(r8)
                java.lang.String r5 = r5.toString()
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
                goto L_0x0311
            L_0x02e6:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvAisleValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                if (r12 == 0) goto L_0x02f4
                java.lang.String r5 = r12.getAisleRow()
                goto L_0x02f5
            L_0x02f4:
                r5 = r0
            L_0x02f5:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
                goto L_0x0311
            L_0x02fb:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvSeparator
                java.lang.String r8 = "binding.tvSeparator"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvAisleValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setVisibility(r6)
            L_0x0311:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.preSaleRow3Right
                java.lang.String r5 = "binding.preSaleRow3Right"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r1.setText(r4)
                if (r12 == 0) goto L_0x0326
                java.lang.String r1 = r12.getPredictedtimeonblock()
                goto L_0x0327
            L_0x0326:
                r1 = r0
            L_0x0327:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0334
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0332
                goto L_0x0334
            L_0x0332:
                r1 = 0
                goto L_0x0335
            L_0x0334:
                r1 = 1
            L_0x0335:
                java.lang.String r4 = "binding.estimateTimeOnBlock"
                if (r1 == 0) goto L_0x0344
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.estimateTimeOnBlock
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r6)
                goto L_0x037b
            L_0x0344:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.estimateTimeOnBlock
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r3)
                com.iaai.android.bdt.utils.NewDateHelper r1 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
                if (r12 == 0) goto L_0x0359
                java.lang.String r5 = r12.getPredictedtimeonblock()
                if (r5 == 0) goto L_0x0359
                goto L_0x035a
            L_0x0359:
                r5 = r7
            L_0x035a:
                java.lang.String r1 = r1.getETOBDateFormat(r5)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r5 = r11.binding
                android.widget.TextView r5 = r5.estimateTimeOnBlock
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r4)
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r4 = r11.this$0
                android.content.Context r4 = r4.getMContext()
                r7 = 2131821180(0x7f11027c, float:1.9275096E38)
                java.lang.Object[] r8 = new java.lang.Object[r2]
                r8[r3] = r1
                java.lang.String r1 = r4.getString(r7, r8)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r5.setText(r1)
            L_0x037b:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r4 = r11.this$0
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel r4 = r4.auctionSalesListViewModel
                r1.setViewModel(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                r1.setResultData(r12)
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r1 = r11.this$0
                java.util.HashMap r1 = r1.getHashMap()
                java.util.Map r1 = (java.util.Map) r1
                if (r12 == 0) goto L_0x039a
                java.lang.Long r4 = r12.getItemId()
                goto L_0x039b
            L_0x039a:
                r4 = r0
            L_0x039b:
                java.lang.Object r1 = r1.get(r4)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                if (r1 == 0) goto L_0x03a8
                boolean r1 = r1.booleanValue()
                goto L_0x03a9
            L_0x03a8:
                r1 = 0
            L_0x03a9:
                if (r12 == 0) goto L_0x03b0
                java.lang.Boolean r4 = r12.isWatchAvailable()
                goto L_0x03b1
            L_0x03b0:
                r4 = r0
            L_0x03b1:
                java.lang.String r5 = "binding.flWatch"
                java.lang.String r7 = "binding.flUnwatch"
                java.lang.String r8 = "binding.llUnWatch"
                java.lang.String r9 = "binding.llWatch"
                if (r4 == 0) goto L_0x040d
                if (r12 == 0) goto L_0x03c2
                java.lang.Boolean r4 = r12.isWatchAvailable()
                goto L_0x03c3
            L_0x03c2:
                r4 = r0
            L_0x03c3:
                if (r4 != 0) goto L_0x03c8
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x03c8:
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x040d
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r9)
                r4.setEnabled(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r8)
                r4.setEnabled(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r8)
                r10 = 1065353216(0x3f800000, float:1.0)
                r4.setAlpha(r10)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r9)
                r4.setAlpha(r10)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.FrameLayout r4 = r4.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r7)
                r4.setEnabled(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.FrameLayout r4 = r4.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
                r4.setEnabled(r2)
                goto L_0x044b
            L_0x040d:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r9)
                r4.setEnabled(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r8)
                r4.setEnabled(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r8)
                r10 = 1056964608(0x3f000000, float:0.5)
                r4.setAlpha(r10)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.LinearLayout r4 = r4.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r9)
                r4.setAlpha(r10)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.FrameLayout r4 = r4.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r7)
                r4.setEnabled(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.FrameLayout r4 = r4.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
                r4.setEnabled(r3)
            L_0x044b:
                if (r1 == 0) goto L_0x0476
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r9)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setVisibility(r6)
                goto L_0x049e
            L_0x0476:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r9)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r11.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setVisibility(r3)
            L_0x049e:
                com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
                r1.<init>()
                com.bumptech.glide.request.RequestOptions r1 = r1.centerCrop()
                r4 = 2131231231(0x7f0801ff, float:1.8078537E38)
                com.bumptech.glide.request.RequestOptions r1 = r1.error((int) r4)
                com.bumptech.glide.load.engine.DiskCacheStrategy r4 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
                com.bumptech.glide.request.RequestOptions r1 = r1.diskCacheStrategy(r4)
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH
                com.bumptech.glide.request.RequestOptions r1 = r1.priority(r4)
                r4 = 2131231567(0x7f08034f, float:1.8079219E38)
                com.bumptech.glide.request.RequestOptions r1 = r1.placeholder((int) r4)
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r4 = r11.this$0
                android.content.Context r4 = r4.getMContext()
                com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with((android.content.Context) r4)
                if (r12 == 0) goto L_0x04d2
                java.lang.String r5 = r12.getThumbnailUrl()
                goto L_0x04d3
            L_0x04d2:
                r5 = r0
            L_0x04d3:
                com.bumptech.glide.RequestBuilder r4 = r4.load((java.lang.String) r5)
                com.bumptech.glide.RequestBuilder r4 = r4.apply(r1)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r5 = r11.binding
                android.widget.ImageView r5 = r5.vehicleImage1
                r4.into((android.widget.ImageView) r5)
                com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r4 = r11.this$0
                android.content.Context r4 = r4.getMContext()
                com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with((android.content.Context) r4)
                if (r12 == 0) goto L_0x04f3
                java.lang.String r5 = r12.getThumbnailUrl()
                goto L_0x04f4
            L_0x04f3:
                r5 = r0
            L_0x04f4:
                com.bumptech.glide.RequestBuilder r4 = r4.load((java.lang.String) r5)
                com.bumptech.glide.RequestBuilder r1 = r4.apply(r1)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r11.binding
                android.widget.ImageView r4 = r4.vehicleImage2
                r1.into((android.widget.ImageView) r4)
                if (r12 == 0) goto L_0x0509
                java.lang.Boolean r0 = r12.getTBOInd()
            L_0x0509:
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r2)
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
                java.lang.String r1 = "binding.tvTitleNotAvailable"
                if (r12 == 0) goto L_0x0520
                com.iaai.android.databinding.ItemAuctionSalesListBinding r12 = r11.binding
                android.widget.TextView r12 = r12.tvTitleNotAvailable
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r1)
                r12.setVisibility(r3)
                goto L_0x0541
            L_0x0520:
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r3)
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r12)
                if (r12 == 0) goto L_0x0535
                com.iaai.android.databinding.ItemAuctionSalesListBinding r12 = r11.binding
                android.widget.TextView r12 = r12.tvTitleNotAvailable
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r1)
                r12.setVisibility(r6)
                goto L_0x0541
            L_0x0535:
                if (r0 != 0) goto L_0x0541
                com.iaai.android.databinding.ItemAuctionSalesListBinding r12 = r11.binding
                android.widget.TextView r12 = r12.tvTitleNotAvailable
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r1)
                r12.setVisibility(r6)
            L_0x0541:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter.ResultDataItemViewHolder.bindTo(com.iaai.android.bdt.model.auctionSalesList.ResultData):void");
        }
    }
}
