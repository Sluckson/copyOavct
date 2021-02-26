package com.iaai.android.bdt.feature.account.watchlist;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.auctionSalesList.AuctionDetails;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.bdt.utils.CustomItemClickListener;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.databinding.ItemAuctionSalesListBinding;
import com.iaai.android.databinding.RowItemAuctinSalesListHeaderBinding;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 H2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003HIJB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0002J\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000200H\u0016J&\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aJ\u0018\u00104\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0002J\u0018\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u00032\u0006\u00102\u001a\u000200H\u0016J\u0018\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000200H\u0016J\u0018\u0010;\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0002J\u001a\u0010<\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020?J\u0016\u0010@\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020'J\u0015\u0010A\u001a\u00020+2\b\u0010B\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010CJ\u0016\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u0019J\u0018\u0010G\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R-\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a`\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "watchingListViewModel", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/utils/CustomItemClickListener;", "(Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;Landroid/content/Context;Lcom/iaai/android/bdt/utils/CustomItemClickListener;)V", "auctionSalesListHeader", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "getAuctionSalesListHeader", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "setAuctionSalesListHeader", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;)V", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "getConstraintSet", "()Landroidx/constraintlayout/widget/ConstraintSet;", "setConstraintSet", "(Landroidx/constraintlayout/widget/ConstraintSet;)V", "hashMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "isBidLive", "isOffsiteTruncate", "isPublicTruncate", "isRunDriveTruncate", "getListener", "()Lcom/iaai/android/bdt/utils/CustomItemClickListener;", "getMContext", "()Landroid/content/Context;", "myAccountStatus", "", "selectedIemID", "Ljava/lang/Long;", "awardPendingRowData", "", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "resultDatum", "getItemCount", "", "getItemViewType", "position", "handleBadgeAlignment", "lostPreBidRowData", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "preBidsRowData", "purchaseHistoryRowData", "setBidLiveInfo", "auctionDetails", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "setHeaderItem", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Long;)V", "setWatchingData", "isWatching", "itemID", "watchListRow", "Companion", "HeaderDataViewHolder", "ResultDataItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListAdapter.kt */
public final class PreSaleListAdapter extends PagedListAdapter<WatchListModel, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    @NotNull
    public AuctionSalesListHeader auctionSalesListHeader;
    @NotNull
    private ConstraintSet constraintSet = new ConstraintSet();
    @NotNull
    private final HashMap<Long, Boolean> hashMap = new HashMap<>();
    private boolean isBidLive;
    /* access modifiers changed from: private */
    public boolean isOffsiteTruncate;
    /* access modifiers changed from: private */
    public boolean isPublicTruncate;
    /* access modifiers changed from: private */
    public boolean isRunDriveTruncate;
    @NotNull
    private final CustomItemClickListener listener;
    @NotNull
    private final Context mContext;
    /* access modifiers changed from: private */
    public String myAccountStatus = "";
    private Long selectedIemID = -1L;
    private final PreSaleListViewModel watchingListViewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreSaleListAdapter(@NotNull PreSaleListViewModel preSaleListViewModel, @NotNull Context context, @NotNull CustomItemClickListener customItemClickListener) {
        super(WatchListModel.Companion.getDiffCallback());
        Intrinsics.checkParameterIsNotNull(preSaleListViewModel, "watchingListViewModel");
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(customItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.watchingListViewModel = preSaleListViewModel;
        this.mContext = context;
        this.listener = customItemClickListener;
    }

    public static final /* synthetic */ WatchListModel access$getItem(PreSaleListAdapter preSaleListAdapter, int i) {
        return (WatchListModel) preSaleListAdapter.getItem(i);
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

    @NotNull
    public final ConstraintSet getConstraintSet() {
        return this.constraintSet;
    }

    public final void setConstraintSet(@NotNull ConstraintSet constraintSet2) {
        Intrinsics.checkParameterIsNotNull(constraintSet2, "<set-?>");
        this.constraintSet = constraintSet2;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PreSaleListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return PreSaleListAdapter.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return PreSaleListAdapter.TYPE_ITEM;
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
            ((ImageView) view.findViewById(C2723R.C2726id.iv_sort)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$1(this, objectRef));
            View view2 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ((TextView) view2.findViewById(C2723R.C2726id.tv_SortLabel)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$2(this, objectRef));
        } else if (i == TYPE_ITEM) {
            ItemAuctionSalesListBinding inflate3 = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemAuctionSalesListBind…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate3);
            View view3 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            ((ConstraintLayout) view3.findViewById(C2723R.C2726id.parent_item)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$3(this, objectRef));
            View view4 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
            ((ImageView) view4.findViewById(C2723R.C2726id.img_arrow_right)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$4(this, objectRef));
            View view5 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
            ((FrameLayout) view5.findViewById(C2723R.C2726id.fl_unwatch)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$5(this, objectRef));
            View view6 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
            ((FrameLayout) view6.findViewById(C2723R.C2726id.fl_watch)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$6(this, objectRef));
            View view7 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view7, "holder.itemView");
            ((LinearLayout) view7.findViewById(C2723R.C2726id.llUnWatch)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$7(this, objectRef));
            View view8 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view8, "holder.itemView");
            ((LinearLayout) view8.findViewById(C2723R.C2726id.llWatch)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$8(this, objectRef));
            View view9 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view9, "holder.itemView");
            ((TextView) view9.findViewById(C2723R.C2726id.tvStockReceipt)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$9(this, objectRef));
            View view10 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view10, "holder.itemView");
            ((TextView) view10.findViewById(C2723R.C2726id.tvBundledReceipt)).setOnClickListener(new PreSaleListAdapter$onCreateViewHolder$10(this, objectRef));
        }
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public final void setHeaderItem(@NotNull AuctionSalesListHeader auctionSalesListHeader2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "auctionSalesListHeader");
        Intrinsics.checkParameterIsNotNull(str, "myAccountStatus");
        this.auctionSalesListHeader = auctionSalesListHeader2;
        this.myAccountStatus = str;
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
            ((ResultDataItemViewHolder) viewHolder).bindTo((WatchListModel) getItem(i - 1));
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListAdapter$HeaderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;", "(Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListAdapter;Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;)V", "isClickedEnabled", "", "()Z", "setClickedEnabled", "(Z)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PreSaleListAdapter.kt */
    public final class HeaderDataViewHolder extends RecyclerView.ViewHolder {
        private final RowItemAuctinSalesListHeaderBinding binding;
        private boolean isClickedEnabled;
        final /* synthetic */ PreSaleListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderDataViewHolder(@NotNull PreSaleListAdapter preSaleListAdapter, RowItemAuctinSalesListHeaderBinding rowItemAuctinSalesListHeaderBinding) {
            super(rowItemAuctinSalesListHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemAuctinSalesListHeaderBinding, "binding");
            this.this$0 = preSaleListAdapter;
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
            ImageView imageView = this.binding.imgFilter;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.imgFilter");
            imageView.setVisibility(8);
            TextView textView = this.binding.tvFilterCount;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvFilterCount");
            textView.setVisibility(8);
            TextView textView2 = this.binding.tvFilterLabel;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvFilterLabel");
            textView2.setVisibility(8);
            View view = this.binding.viewHeader;
            Intrinsics.checkExpressionValueIsNotNull(view, "binding.viewHeader");
            view.setVisibility(8);
            if (this.this$0.getAuctionSalesListHeader().isError()) {
                View view2 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "binding.emptyView");
                TextView textView3 = (TextView) view2.findViewById(C2723R.C2726id.errorTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.emptyView.errorTitle");
                textView3.setText(this.this$0.getAuctionSalesListHeader().getErrorType().getValue());
                View view3 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view3, "binding.emptyView");
                TextView textView4 = (TextView) view3.findViewById(C2723R.C2726id.errorBody);
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.emptyView.errorBody");
                textView4.setText(this.this$0.getAuctionSalesListHeader().getErrorMessage());
                ConstraintLayout constraintLayout2 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clEmptyView");
                constraintLayout2.setVisibility(0);
            } else {
                ConstraintLayout constraintLayout3 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.clEmptyView");
                constraintLayout3.setVisibility(8);
            }
            if (StringsKt.equals(this.this$0.myAccountStatus, String.valueOf(PreSaleListStatus.LOST_PREBID.getValue()), false)) {
                TextView textView5 = this.binding.headerMdlostPrebid;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.headerMdlostPrebid");
                textView5.setVisibility(0);
                TextView textView6 = this.binding.headerMdlostPrebid;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.headerMdlostPrebid");
                textView6.setText(this.this$0.getMContext().getResources().getString(C2723R.string.header_lost_prebid));
            } else if (StringsKt.equals(this.this$0.myAccountStatus, String.valueOf(PreSaleListStatus.PURCHASE_HISTORY.getValue()), false)) {
                TextView textView7 = this.binding.headerMdlostPrebid;
                Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.headerMdlostPrebid");
                textView7.setVisibility(0);
                TextView textView8 = this.binding.headerMdlostPrebid;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.headerMdlostPrebid");
                textView8.setText(this.this$0.getMContext().getResources().getString(C2723R.string.header_purchase_history));
            }
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListAdapter$ResultDataItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "(Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListAdapter;Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;)V", "bindTo", "", "resultDatum", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PreSaleListAdapter.kt */
    public final class ResultDataItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemAuctionSalesListBinding binding;
        final /* synthetic */ PreSaleListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultDataItemViewHolder(@NotNull PreSaleListAdapter preSaleListAdapter, ItemAuctionSalesListBinding itemAuctionSalesListBinding) {
            super(itemAuctionSalesListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            this.this$0 = preSaleListAdapter;
            this.binding = itemAuctionSalesListBinding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0028, code lost:
            r6 = r9.getItemid();
         */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0181  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0189  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01f7  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01fc  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x021d  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x022f  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x023f  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x024a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindTo(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.MyAccount.WatchListModel r9) {
            /*
                r8 = this;
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                java.lang.String r0 = r0.myAccountStatus
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus r1 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus.WATCHING_LIST
                int r1 = r1.getValue()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r2 = 0
                boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r2)
                java.lang.String r1 = "binding.llUnWatch"
                java.lang.String r3 = "binding.llWatch"
                r4 = 8
                r5 = 0
                if (r0 == 0) goto L_0x009e
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                java.util.HashMap r0 = r0.getHashMap()
                java.util.Map r0 = (java.util.Map) r0
                if (r9 == 0) goto L_0x0037
                java.lang.String r6 = r9.getItemid()
                if (r6 == 0) goto L_0x0037
                long r6 = java.lang.Long.parseLong(r6)
                java.lang.Long r6 = java.lang.Long.valueOf(r6)
                goto L_0x0038
            L_0x0037:
                r6 = r5
            L_0x0038:
                java.lang.Object r0 = r0.get(r6)
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                if (r0 == 0) goto L_0x0045
                boolean r0 = r0.booleanValue()
                goto L_0x0046
            L_0x0045:
                r0 = 0
            L_0x0046:
                java.lang.String r6 = "binding.flWatch"
                java.lang.String r7 = "binding.flUnwatch"
                if (r0 == 0) goto L_0x0075
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.LinearLayout r0 = r0.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.FrameLayout r0 = r0.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
                r0.setVisibility(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.LinearLayout r0 = r0.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                r0.setVisibility(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.FrameLayout r0 = r0.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
                r0.setVisibility(r4)
                goto L_0x00b2
            L_0x0075:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.LinearLayout r0 = r0.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.FrameLayout r0 = r0.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
                r0.setVisibility(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.LinearLayout r0 = r0.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                r0.setVisibility(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.FrameLayout r0 = r0.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
                r0.setVisibility(r2)
                goto L_0x00b2
            L_0x009e:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.LinearLayout r0 = r0.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                r0.setVisibility(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.LinearLayout r0 = r0.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r4)
            L_0x00b2:
                if (r9 == 0) goto L_0x00b9
                java.lang.String r0 = r9.getYear()
                goto L_0x00ba
            L_0x00b9:
                r0 = r5
            L_0x00ba:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1 = 1
                if (r0 == 0) goto L_0x00c8
                int r0 = r0.length()
                if (r0 != 0) goto L_0x00c6
                goto L_0x00c8
            L_0x00c6:
                r0 = 0
                goto L_0x00c9
            L_0x00c8:
                r0 = 1
            L_0x00c9:
                java.lang.String r3 = "binding.yearMakeModel"
                if (r0 != 0) goto L_0x014a
                if (r9 == 0) goto L_0x00d4
                java.lang.String r0 = r9.getMake()
                goto L_0x00d5
            L_0x00d4:
                r0 = r5
            L_0x00d5:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                if (r0 == 0) goto L_0x00e2
                int r0 = r0.length()
                if (r0 != 0) goto L_0x00e0
                goto L_0x00e2
            L_0x00e0:
                r0 = 0
                goto L_0x00e3
            L_0x00e2:
                r0 = 1
            L_0x00e3:
                if (r0 != 0) goto L_0x014a
                if (r9 == 0) goto L_0x00ec
                java.lang.String r0 = r9.getModel()
                goto L_0x00ed
            L_0x00ec:
                r0 = r5
            L_0x00ed:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                if (r0 == 0) goto L_0x00fa
                int r0 = r0.length()
                if (r0 != 0) goto L_0x00f8
                goto L_0x00fa
            L_0x00f8:
                r0 = 0
                goto L_0x00fb
            L_0x00fa:
                r0 = 1
            L_0x00fb:
                if (r0 != 0) goto L_0x014a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                if (r9 == 0) goto L_0x0109
                java.lang.String r6 = r9.getYear()
                goto L_0x010a
            L_0x0109:
                r6 = r5
            L_0x010a:
                r0.append(r6)
                java.lang.String r6 = " "
                r0.append(r6)
                if (r9 == 0) goto L_0x0119
                java.lang.String r7 = r9.getMake()
                goto L_0x011a
            L_0x0119:
                r7 = r5
            L_0x011a:
                r0.append(r7)
                r0.append(r6)
                if (r9 == 0) goto L_0x0127
                java.lang.String r6 = r9.getModel()
                goto L_0x0128
            L_0x0127:
                r6 = r5
            L_0x0128:
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                com.iaai.android.databinding.ItemAuctionSalesListBinding r6 = r8.binding
                android.widget.TextView r6 = r6.yearMakeModel
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
                java.lang.String r0 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r0)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r6.setText(r0)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.TextView r0 = r0.yearMakeModel
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                r0.setVisibility(r2)
                goto L_0x0163
            L_0x014a:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.TextView r0 = r0.yearMakeModel
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                java.lang.String r6 = "Dummy text"
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r0.setText(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.TextView r0 = r0.yearMakeModel
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                r3 = 4
                r0.setVisibility(r3)
            L_0x0163:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r0 = r8.binding
                android.widget.TextView r0 = r0.tvSeparator
                java.lang.String r3 = "binding.tvSeparator"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                r0.setVisibility(r4)
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                java.lang.String r0 = r0.myAccountStatus
                int r0 = java.lang.Integer.parseInt(r0)
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus r3 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus.WATCHING_LIST
                int r3 = r3.getValue()
                if (r0 != r3) goto L_0x0189
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                com.iaai.android.databinding.ItemAuctionSalesListBinding r3 = r8.binding
                r0.watchListRow(r3, r9)
                goto L_0x01c8
            L_0x0189:
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus r3 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus.AWARD_PENDING
                int r3 = r3.getValue()
                if (r0 != r3) goto L_0x0199
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                com.iaai.android.databinding.ItemAuctionSalesListBinding r3 = r8.binding
                r0.awardPendingRowData(r3, r9)
                goto L_0x01c8
            L_0x0199:
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus r3 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus.LOST_PREBID
                int r3 = r3.getValue()
                if (r0 != r3) goto L_0x01a9
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                com.iaai.android.databinding.ItemAuctionSalesListBinding r3 = r8.binding
                r0.lostPreBidRowData(r3, r9)
                goto L_0x01c8
            L_0x01a9:
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus r3 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus.PRE_BID
                int r3 = r3.getValue()
                if (r0 != r3) goto L_0x01b9
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                com.iaai.android.databinding.ItemAuctionSalesListBinding r3 = r8.binding
                r0.preBidsRowData(r3, r9)
                goto L_0x01c8
            L_0x01b9:
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus r3 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus.PURCHASE_HISTORY
                int r3 = r3.getValue()
                if (r0 != r3) goto L_0x01c8
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r8.this$0
                com.iaai.android.databinding.ItemAuctionSalesListBinding r3 = r8.binding
                r0.purchaseHistoryRowData(r3, r9)
            L_0x01c8:
                com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
                r0.<init>()
                com.bumptech.glide.request.RequestOptions r0 = r0.centerCrop()
                r3 = 2131231231(0x7f0801ff, float:1.8078537E38)
                com.bumptech.glide.request.RequestOptions r0 = r0.error((int) r3)
                com.bumptech.glide.load.engine.DiskCacheStrategy r3 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
                com.bumptech.glide.request.RequestOptions r0 = r0.diskCacheStrategy(r3)
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.HIGH
                com.bumptech.glide.request.RequestOptions r0 = r0.priority(r3)
                r3 = 2131231567(0x7f08034f, float:1.8079219E38)
                com.bumptech.glide.request.RequestOptions r0 = r0.placeholder((int) r3)
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r3 = r8.this$0
                android.content.Context r3 = r3.getMContext()
                com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with((android.content.Context) r3)
                if (r9 == 0) goto L_0x01fc
                java.lang.String r6 = r9.getImageURL()
                goto L_0x01fd
            L_0x01fc:
                r6 = r5
            L_0x01fd:
                com.bumptech.glide.RequestBuilder r3 = r3.load((java.lang.String) r6)
                com.bumptech.glide.RequestBuilder r3 = r3.apply(r0)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r6 = r8.binding
                android.widget.ImageView r6 = r6.vehicleImage1
                r3.into((android.widget.ImageView) r6)
                com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r3 = r8.this$0
                android.content.Context r3 = r3.getMContext()
                com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with((android.content.Context) r3)
                if (r9 == 0) goto L_0x021d
                java.lang.String r6 = r9.getImageURL()
                goto L_0x021e
            L_0x021d:
                r6 = r5
            L_0x021e:
                com.bumptech.glide.RequestBuilder r3 = r3.load((java.lang.String) r6)
                com.bumptech.glide.RequestBuilder r0 = r3.apply(r0)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r3 = r8.binding
                android.widget.ImageView r3 = r3.vehicleImage2
                r0.into((android.widget.ImageView) r3)
                if (r9 == 0) goto L_0x0233
                java.lang.Boolean r5 = r9.getTBOInd()
            L_0x0233:
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r1)
                boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
                java.lang.String r0 = "binding.tvTitleNotAvailable"
                if (r9 == 0) goto L_0x024a
                com.iaai.android.databinding.ItemAuctionSalesListBinding r9 = r8.binding
                android.widget.TextView r9 = r9.tvTitleNotAvailable
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r0)
                r9.setVisibility(r2)
                goto L_0x026b
            L_0x024a:
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
                boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
                if (r9 == 0) goto L_0x025f
                com.iaai.android.databinding.ItemAuctionSalesListBinding r9 = r8.binding
                android.widget.TextView r9 = r9.tvTitleNotAvailable
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r0)
                r9.setVisibility(r4)
                goto L_0x026b
            L_0x025f:
                if (r5 != 0) goto L_0x026b
                com.iaai.android.databinding.ItemAuctionSalesListBinding r9 = r8.binding
                android.widget.TextView r9 = r9.tvTitleNotAvailable
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r0)
                r9.setVisibility(r4)
            L_0x026b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter.ResultDataItemViewHolder.bindTo(com.iaai.android.bdt.model.MyAccount.WatchListModel):void");
        }
    }

    /* access modifiers changed from: private */
    public final void purchaseHistoryRowData(ItemAuctionSalesListBinding itemAuctionSalesListBinding, WatchListModel watchListModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        String str = null;
        sb.append(watchListModel != null ? watchListModel.getTotalPaid() : null);
        boolean z = true;
        String str2 = "<b>" + UiUtils.formatCurrencyFromString(sb.toString(), true) + "</b>";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" (");
        sb2.append(this.mContext.getResources().getString(C2723R.string.bdt_date_paid));
        sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb2.append(NewDateHelper.INSTANCE.getPaidDate(String.valueOf(watchListModel != null ? watchListModel.getDatepaidstring() : null)));
        sb2.append(")");
        String str3 = str2 + sb2.toString();
        TextView textView = itemAuctionSalesListBinding.tvPrimaryDamageValue;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvPrimaryDamageValue");
        textView.setText(Html.fromHtml(str3));
        if (Build.VERSION.SDK_INT >= 24) {
            TextView textView2 = itemAuctionSalesListBinding.tvPrimaryDamageValue;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvPrimaryDamageValue");
            textView2.setText(Html.fromHtml(str3, 0));
        } else {
            TextView textView3 = itemAuctionSalesListBinding.tvPrimaryDamageValue;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvPrimaryDamageValue");
            textView3.setText(Html.fromHtml(str3));
        }
        CharSequence pickedupdatestring = watchListModel != null ? watchListModel.getPickedupdatestring() : null;
        if (!(pickedupdatestring == null || pickedupdatestring.length() == 0)) {
            z = false;
        }
        if (z) {
            TextView textView4 = itemAuctionSalesListBinding.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.preSaleRow3Right");
            textView4.setVisibility(8);
        } else {
            TextView textView5 = itemAuctionSalesListBinding.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.preSaleRow3Right");
            textView5.setVisibility(0);
            TextView textView6 = itemAuctionSalesListBinding.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.preSaleRow3Right");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.mContext.getResources().getString(C2723R.string.bdt_picked_up_date));
            sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb3.append(NewDateHelper.INSTANCE.getPaidDate(String.valueOf(watchListModel != null ? watchListModel.getPickedupdatestring() : null)));
            textView6.setText(sb3.toString());
        }
        TextView textView7 = itemAuctionSalesListBinding.preSaleRow3Right;
        Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.preSaleRow3Right");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.mContext.getResources().getString(C2723R.string.bdt_picked_up_date));
        sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb4.append(NewDateHelper.INSTANCE.getPaidDate(String.valueOf(watchListModel != null ? watchListModel.getPickedupdatestring() : null)));
        textView7.setText(sb4.toString());
        TextView textView8 = itemAuctionSalesListBinding.tvBranchName;
        Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvBranchName");
        textView8.setVisibility(0);
        TextView textView9 = itemAuctionSalesListBinding.tvBranchName;
        Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvBranchName");
        if (watchListModel != null) {
            str = watchListModel.getBranchname();
        }
        textView9.setText(str);
        ConstraintLayout constraintLayout = itemAuctionSalesListBinding.llReceiptConatiner;
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.llReceiptConatiner");
        constraintLayout.setVisibility(0);
        TextView textView10 = itemAuctionSalesListBinding.tvStockReceipt;
        Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvStockReceipt");
        textView10.setPaintFlags(8);
        TextView textView11 = itemAuctionSalesListBinding.tvBundledReceipt;
        Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvBundledReceipt");
        textView11.setPaintFlags(8);
        TextView textView12 = itemAuctionSalesListBinding.tvOffsiteRelease;
        Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvOffsiteRelease");
        textView12.setPaintFlags(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void watchListRow(@org.jetbrains.annotations.NotNull com.iaai.android.databinding.ItemAuctionSalesListBinding r10, @org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.MyAccount.WatchListModel r11) {
        /*
            r9 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r0 = 0
            if (r11 == 0) goto L_0x000d
            java.lang.String r1 = r11.getDamage()
            goto L_0x000e
        L_0x000d:
            r1 = r0
        L_0x000e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r1 = 0
            goto L_0x001e
        L_0x001d:
            r1 = 1
        L_0x001e:
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.CharSequence"
            if (r1 == 0) goto L_0x0047
            if (r11 == 0) goto L_0x0044
            java.lang.String r1 = r11.getLossType()
            if (r1 == 0) goto L_0x0044
            java.lang.String r1 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r1)
            if (r1 == 0) goto L_0x0044
            if (r1 == 0) goto L_0x003e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
            java.lang.String r1 = r1.toString()
            goto L_0x00c4
        L_0x003e:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r4)
            throw r10
        L_0x0044:
            r1 = r0
            goto L_0x00c4
        L_0x0047:
            if (r11 == 0) goto L_0x004e
            java.lang.String r1 = r11.getLossType()
            goto L_0x004f
        L_0x004e:
            r1 = r0
        L_0x004f:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x005c
            int r1 = r1.length()
            if (r1 != 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r1 = 0
            goto L_0x005d
        L_0x005c:
            r1 = 1
        L_0x005d:
            if (r1 == 0) goto L_0x0080
            if (r11 == 0) goto L_0x0044
            java.lang.String r1 = r11.getDamage()
            if (r1 == 0) goto L_0x0044
            java.lang.String r1 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r1)
            if (r1 == 0) goto L_0x0044
            if (r1 == 0) goto L_0x007a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
            java.lang.String r1 = r1.toString()
            goto L_0x00c4
        L_0x007a:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r4)
            throw r10
        L_0x0080:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            if (r11 == 0) goto L_0x00a6
            java.lang.String r5 = r11.getLossType()
            if (r5 == 0) goto L_0x00a6
            java.lang.String r5 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r5)
            if (r5 == 0) goto L_0x00a6
            if (r5 == 0) goto L_0x00a0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r4 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r5)
            java.lang.String r4 = r4.toString()
            goto L_0x00a7
        L_0x00a0:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r4)
            throw r10
        L_0x00a6:
            r4 = r0
        L_0x00a7:
            r1.append(r4)
            java.lang.String r4 = ", "
            r1.append(r4)
            if (r11 == 0) goto L_0x00bc
            java.lang.String r4 = r11.getDamage()
            if (r4 == 0) goto L_0x00bc
            java.lang.String r4 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r4)
            goto L_0x00bd
        L_0x00bc:
            r4 = r0
        L_0x00bd:
            r1.append(r4)
            java.lang.String r1 = r1.toString()
        L_0x00c4:
            if (r11 == 0) goto L_0x00cb
            java.lang.String r4 = r11.getOdometer()
            goto L_0x00cc
        L_0x00cb:
            r4 = r0
        L_0x00cc:
            r5 = 2
            java.lang.String r6 = ""
            boolean r4 = kotlin.text.StringsKt.equals$default(r4, r6, r3, r5, r0)
            if (r4 == 0) goto L_0x00d8
            java.lang.String r4 = "Mileage Unavailable"
            goto L_0x0103
        L_0x00d8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.text.NumberFormat r5 = java.text.NumberFormat.getIntegerInstance()
            if (r11 == 0) goto L_0x00f2
            java.lang.String r7 = r11.getOdometer()
            if (r7 == 0) goto L_0x00f2
            long r7 = java.lang.Long.parseLong(r7)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            goto L_0x00f3
        L_0x00f2:
            r7 = r0
        L_0x00f3:
            java.lang.String r5 = r5.format(r7)
            r4.append(r5)
            java.lang.String r5 = " mi."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x0103:
            android.widget.TextView r5 = r10.preSaleRow3Right
            java.lang.String r7 = "binding.preSaleRow3Right"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r7)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x011c
            int r1 = r4.length()
            if (r1 != 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r1 = 0
            goto L_0x011d
        L_0x011c:
            r1 = 1
        L_0x011d:
            if (r1 != 0) goto L_0x0131
            android.widget.TextView r1 = r10.tvBranchName
            java.lang.String r5 = "binding.tvBranchName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
            r1.setVisibility(r3)
            android.widget.TextView r1 = r10.tvBranchName
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
            r1.setText(r4)
        L_0x0131:
            if (r11 == 0) goto L_0x0138
            java.lang.String r1 = r11.getFormattedAdjLiveDate()
            goto L_0x0139
        L_0x0138:
            r1 = r0
        L_0x0139:
            java.lang.String r4 = "binding.tvPrimaryDamageValue"
            r5 = 8
            if (r1 == 0) goto L_0x0180
            if (r11 == 0) goto L_0x0146
            java.lang.String r1 = r11.getFormattedAdjLiveDate()
            goto L_0x0147
        L_0x0146:
            r1 = r0
        L_0x0147:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0157
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0156
            goto L_0x0157
        L_0x0156:
            r2 = 0
        L_0x0157:
            if (r2 == 0) goto L_0x015a
            goto L_0x0180
        L_0x015a:
            android.widget.TextView r1 = r10.tvPrimaryDamageValue
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r3)
            com.iaai.android.bdt.utils.NewDateHelper r1 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
            if (r11 != 0) goto L_0x0169
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0169:
            java.lang.String r2 = r11.getFormattedAdjLiveDate()
            if (r2 == 0) goto L_0x0170
            goto L_0x0171
        L_0x0170:
            r2 = r6
        L_0x0171:
            java.lang.String r1 = r1.getAuctionCompleteTime(r2)
            android.widget.TextView r2 = r10.tvPrimaryDamageValue
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            goto L_0x0188
        L_0x0180:
            android.widget.TextView r1 = r10.tvPrimaryDamageValue
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r5)
        L_0x0188:
            android.widget.TextView r1 = r10.estimateTimeOnBlock
            java.lang.String r2 = "binding.estimateTimeOnBlock"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r3)
            android.widget.TextView r1 = r10.estimateTimeOnBlock
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            if (r11 == 0) goto L_0x01a3
            java.lang.String r4 = r11.getBranchname()
            goto L_0x01a4
        L_0x01a3:
            r4 = r0
        L_0x01a4:
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            if (r11 == 0) goto L_0x01b2
            java.lang.String r0 = r11.getSlot()
        L_0x01b2:
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            r9.isOffsiteTruncate = r3
            r9.isRunDriveTruncate = r3
            r9.isPublicTruncate = r3
            android.widget.LinearLayout r0 = r10.llBadgeConatiner
            java.lang.String r1 = "binding.llBadgeConatiner"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r1 = 4
            r0.setVisibility(r1)
            if (r11 == 0) goto L_0x01dc
            java.lang.Boolean r0 = r11.getRunAndDrive()
            if (r0 == 0) goto L_0x01dc
            boolean r0 = r0.booleanValue()
            goto L_0x01dd
        L_0x01dc:
            r0 = 0
        L_0x01dd:
            java.lang.String r1 = "binding.tvRunDrive"
            if (r0 == 0) goto L_0x01ea
            android.widget.TextView r0 = r10.tvRunDrive
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r3)
            goto L_0x01f2
        L_0x01ea:
            android.widget.TextView r0 = r10.tvRunDrive
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r5)
        L_0x01f2:
            if (r11 == 0) goto L_0x01ff
            java.lang.Boolean r0 = r11.getOffsiteSaleIndicator()
            if (r0 == 0) goto L_0x01ff
            boolean r0 = r0.booleanValue()
            goto L_0x0200
        L_0x01ff:
            r0 = 0
        L_0x0200:
            java.lang.String r1 = "binding.tvOffsite"
            if (r0 == 0) goto L_0x020d
            android.widget.TextView r0 = r10.tvOffsite
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r3)
            goto L_0x0215
        L_0x020d:
            android.widget.TextView r0 = r10.tvOffsite
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r5)
        L_0x0215:
            if (r11 == 0) goto L_0x0222
            java.lang.Boolean r11 = r11.getItempublicauction()
            if (r11 == 0) goto L_0x0222
            boolean r11 = r11.booleanValue()
            goto L_0x0223
        L_0x0222:
            r11 = 0
        L_0x0223:
            java.lang.String r0 = "binding.tvIsPublic"
            if (r11 == 0) goto L_0x0230
            android.widget.TextView r11 = r10.tvIsPublic
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r0)
            r11.setVisibility(r3)
            goto L_0x0238
        L_0x0230:
            android.widget.TextView r11 = r10.tvIsPublic
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r0)
            r11.setVisibility(r5)
        L_0x0238:
            android.widget.TextView r11 = r10.tvIsPublic
            android.view.ViewTreeObserver r11 = r11.getViewTreeObserver()
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$watchListRow$1 r0 = new com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$watchListRow$1
            r0.<init>(r9, r10)
            android.view.ViewTreeObserver$OnPreDrawListener r0 = (android.view.ViewTreeObserver.OnPreDrawListener) r0
            r11.addOnPreDrawListener(r0)
            android.widget.TextView r11 = r10.tvRunDrive
            android.view.ViewTreeObserver r11 = r11.getViewTreeObserver()
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$watchListRow$2 r0 = new com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$watchListRow$2
            r0.<init>(r9, r10)
            android.view.ViewTreeObserver$OnPreDrawListener r0 = (android.view.ViewTreeObserver.OnPreDrawListener) r0
            r11.addOnPreDrawListener(r0)
            android.widget.TextView r11 = r10.tvOffsite
            android.view.ViewTreeObserver r11 = r11.getViewTreeObserver()
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$watchListRow$3 r0 = new com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$watchListRow$3
            r0.<init>(r9, r10)
            android.view.ViewTreeObserver$OnPreDrawListener r0 = (android.view.ViewTreeObserver.OnPreDrawListener) r0
            r11.addOnPreDrawListener(r0)
            boolean r11 = r9.isPublicTruncate
            boolean r0 = r9.isRunDriveTruncate
            boolean r1 = r9.isOffsiteTruncate
            r9.handleBadgeAlignment(r10, r11, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter.watchListRow(com.iaai.android.databinding.ItemAuctionSalesListBinding, com.iaai.android.bdt.model.MyAccount.WatchListModel):void");
    }

    public final void handleBadgeAlignment(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
        if (z || z2 || z3) {
            LinearLayout linearLayout = itemAuctionSalesListBinding.llBadgeConatiner;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llBadgeConatiner");
            linearLayout.setGravity(5);
            this.constraintSet.clone(itemAuctionSalesListBinding.parentItem);
            ConstraintSet constraintSet2 = this.constraintSet;
            LinearLayout linearLayout2 = itemAuctionSalesListBinding.llBadgeConatiner;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llBadgeConatiner");
            int id = linearLayout2.getId();
            ConstraintLayout constraintLayout = itemAuctionSalesListBinding.parentItem;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.parentItem");
            constraintSet2.connect(id, 6, constraintLayout.getId(), 6, 0);
            this.constraintSet.applyTo(itemAuctionSalesListBinding.parentItem);
        } else {
            LinearLayout linearLayout3 = itemAuctionSalesListBinding.llBadgeConatiner;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "binding.llBadgeConatiner");
            linearLayout3.setGravity(3);
            this.constraintSet.clone(itemAuctionSalesListBinding.parentItem);
            ConstraintSet constraintSet3 = this.constraintSet;
            LinearLayout linearLayout4 = itemAuctionSalesListBinding.llBadgeConatiner;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "binding.llBadgeConatiner");
            int id2 = linearLayout4.getId();
            ConstraintLayout constraintLayout2 = itemAuctionSalesListBinding.constraintLayout;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.constraintLayout");
            constraintSet3.connect(id2, 6, constraintLayout2.getId(), 6, 0);
            this.constraintSet.applyTo(itemAuctionSalesListBinding.parentItem);
        }
        LinearLayout linearLayout5 = itemAuctionSalesListBinding.llBadgeConatiner;
        Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "binding.llBadgeConatiner");
        linearLayout5.setVisibility(0);
    }

    public final void awardPendingRowData(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, @Nullable WatchListModel watchListModel) {
        Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (watchListModel == null) {
            Intrinsics.throwNpe();
        }
        sb.append(watchListModel.getBidamount());
        String formatCurrencyFromString = UiUtils.formatCurrencyFromString(sb.toString(), false);
        TextView textView = itemAuctionSalesListBinding.tvPrimaryDamageValue;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvPrimaryDamageValue");
        textView.setText(formatCurrencyFromString);
        itemAuctionSalesListBinding.tvPrimaryDamageValue.setTypeface(itemAuctionSalesListBinding.tvPrimaryDamageValue.getTypeface(), 1);
        if (watchListModel.getProviderName() != null) {
            String providerName = watchListModel.getProviderName();
            if (providerName == null) {
                Intrinsics.throwNpe();
            }
            if (!StringsKt.equals(providerName, "", true)) {
                TextView textView2 = itemAuctionSalesListBinding.tvLongDataLane;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvLongDataLane");
                textView2.setVisibility(0);
                TextView textView3 = itemAuctionSalesListBinding.tvLongDataLane;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvLongDataLane");
                textView3.setText(this.mContext.getString(C2723R.string.award_pending) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + watchListModel.getProviderName());
            }
        }
        TextView textView4 = itemAuctionSalesListBinding.tvBranchName;
        Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvBranchName");
        textView4.setVisibility(0);
        TextView textView5 = itemAuctionSalesListBinding.tvBranchName;
        Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvBranchName");
        textView5.setText(watchListModel.getBranchname() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + watchListModel.getSlot());
        itemAuctionSalesListBinding.tvLongDataLane.setTypeface(itemAuctionSalesListBinding.estimateTimeOnBlock.getTypeface(), 1);
        if (watchListModel.getBidderName() != null) {
            TextView textView6 = itemAuctionSalesListBinding.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.preSaleRow3Right");
            textView6.setText("Bidder: " + String.valueOf(watchListModel.getBidderName()));
            return;
        }
        TextView textView7 = itemAuctionSalesListBinding.preSaleRow3Right;
        Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.preSaleRow3Right");
        textView7.setVisibility(8);
    }

    public final void lostPreBidRowData(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, @Nullable WatchListModel watchListModel) {
        Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
        TextView textView = itemAuctionSalesListBinding.preSaleRow4Right;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.preSaleRow4Right");
        textView.setVisibility(0);
        TextView textView2 = itemAuctionSalesListBinding.tvLaneSalesValue;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvLaneSalesValue");
        StringBuilder sb = new StringBuilder();
        String str = null;
        sb.append(watchListModel != null ? watchListModel.getBranchname() : null);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (watchListModel != null) {
            str = watchListModel.getSlot();
        }
        sb.append(str);
        textView2.setText(sb.toString());
        if (watchListModel == null) {
            Intrinsics.throwNpe();
        }
        if (!(watchListModel.getBidamount() == null || watchListModel.getBidderName() == null)) {
            Object bidderName = watchListModel.getBidderName();
            if (bidderName == null) {
                bidderName = "";
            }
            TextView textView3 = itemAuctionSalesListBinding.tvPrimaryDamageValue;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvPrimaryDamageValue");
            textView3.setText(bidderName.toString());
        }
        if (watchListModel.getBidamount() != null) {
            int formatCurrencyFromString = UiUtils.formatCurrencyFromString("" + watchListModel.getBidamount(), false);
            if (formatCurrencyFromString == null) {
                formatCurrencyFromString = 0;
            }
            TextView textView4 = itemAuctionSalesListBinding.preSaleRow4Right;
            Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.preSaleRow4Right");
            textView4.setText(this.mContext.getString(C2723R.string.lbl_bid_amount) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + formatCurrencyFromString);
        }
        if (watchListModel.getWinAmount() != null) {
            TextView textView5 = itemAuctionSalesListBinding.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.preSaleRow3Right");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mContext.getString(C2723R.string.winning_bid));
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb2.append(UiUtils.formatCurrencyFromString("" + watchListModel.getWinAmount(), false));
            textView5.setText(sb2.toString());
            return;
        }
        TextView textView6 = itemAuctionSalesListBinding.preSaleRow3Right;
        Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.preSaleRow3Right");
        textView6.setText(this.mContext.getString(C2723R.string.winning_bid) + " $0");
    }

    public final void preBidsRowData(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, @Nullable WatchListModel watchListModel) {
        Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        if (watchListModel == null) {
            Intrinsics.throwNpe();
        }
        sb.append(watchListModel.getCurrentHigh());
        String str2 = UiUtils.formatCurrencyFromString(sb.toString(), false) + ' ' + ("<b>(" + watchListModel.getPrebidStatus() + ")</b>");
        TextView textView = itemAuctionSalesListBinding.tvPrimaryDamageValue;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvPrimaryDamageValue");
        textView.setText(Html.fromHtml(str2));
        if (Build.VERSION.SDK_INT >= 24) {
            TextView textView2 = itemAuctionSalesListBinding.tvPrimaryDamageValue;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvPrimaryDamageValue");
            textView2.setText(Html.fromHtml(str2, 0));
        } else {
            TextView textView3 = itemAuctionSalesListBinding.tvPrimaryDamageValue;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvPrimaryDamageValue");
            textView3.setText(Html.fromHtml(str2));
        }
        if (!StringsKt.equals(watchListModel.getPrebidStatusColor(), "Green", true)) {
            ImageView imageView = itemAuctionSalesListBinding.imgCircle;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.imgCircle");
            imageView.setVisibility(0);
        } else {
            ImageView imageView2 = itemAuctionSalesListBinding.imgCircle;
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "binding.imgCircle");
            imageView2.setVisibility(4);
        }
        TextView textView4 = itemAuctionSalesListBinding.preSaleRow3Right;
        Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.preSaleRow3Right");
        textView4.setText(watchListModel.getRowOwner());
        ImageView imageView3 = itemAuctionSalesListBinding.imgArrowRight;
        Intrinsics.checkExpressionValueIsNotNull(imageView3, "binding.imgArrowRight");
        ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(0, 0, 0, 24);
            ImageView imageView4 = itemAuctionSalesListBinding.imgArrowRight;
            Intrinsics.checkExpressionValueIsNotNull(imageView4, "binding.imgArrowRight");
            imageView4.setLayoutParams(marginLayoutParams);
            TextView textView5 = itemAuctionSalesListBinding.tvBranchName;
            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvBranchName");
            textView5.setVisibility(0);
            TextView textView6 = itemAuctionSalesListBinding.tvBranchName;
            Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvBranchName");
            NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
            String formattedAdjLiveDate = watchListModel.getFormattedAdjLiveDate();
            if (formattedAdjLiveDate != null) {
                str = formattedAdjLiveDate;
            }
            textView6.setText(newDateHelper.getAuctionCompleteTime(str));
            TextView textView7 = itemAuctionSalesListBinding.tvLongDataLane;
            Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvLongDataLane");
            textView7.setVisibility(0);
            TextView textView8 = itemAuctionSalesListBinding.tvLongDataLane;
            Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvLongDataLane");
            textView8.setText(watchListModel.getBranchname() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + watchListModel.getSlot());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
