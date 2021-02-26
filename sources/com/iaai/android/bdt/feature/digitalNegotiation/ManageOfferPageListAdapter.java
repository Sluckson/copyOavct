package com.iaai.android.bdt.feature.digitalNegotiation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferListHeader;
import com.iaai.android.databinding.ItemManageOfferListBinding;
import com.iaai.android.databinding.RowItemAuctinSalesListHeaderBinding;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004/012B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 H\u0016J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0018J\u0015\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010.R-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u001e¨\u00063"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "manageOfferListViewModel", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListViewModel;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter$CustomManageItemClickListener;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListViewModel;Landroid/content/Context;Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter$CustomManageItemClickListener;)V", "hashMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "isBidLive", "getListener", "()Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter$CustomManageItemClickListener;", "getMContext", "()Landroid/content/Context;", "mManageOfferListHeader", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;", "getMManageOfferListHeader", "()Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;", "setMManageOfferListHeader", "(Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;)V", "selectedIemID", "Ljava/lang/Long;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHeaderItem", "manageOfferListHeader", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Long;)V", "Companion", "CustomManageItemClickListener", "HeaderDataViewHolder", "ResultDataItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferPageListAdapter.kt */
public final class ManageOfferPageListAdapter extends PagedListAdapter<ResultData, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    @NotNull
    private final HashMap<Long, Boolean> hashMap = new HashMap<>();
    private boolean isBidLive;
    @NotNull
    private final CustomManageItemClickListener listener;
    @NotNull
    private final Context mContext;
    @NotNull
    public ManageOfferListHeader mManageOfferListHeader;
    private final ManageOfferListViewModel manageOfferListViewModel;
    private Long selectedIemID = -1L;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter$CustomManageItemClickListener;", "", "onManageOfferListClick", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferPageListAdapter.kt */
    public interface CustomManageItemClickListener {
        void onManageOfferListClick(@NotNull View view, @Nullable ResultData resultData, int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ManageOfferPageListAdapter(@NotNull ManageOfferListViewModel manageOfferListViewModel2, @NotNull Context context, @NotNull CustomManageItemClickListener customManageItemClickListener) {
        super(ResultData.Companion.getDIFF_CALLBACK());
        Intrinsics.checkParameterIsNotNull(manageOfferListViewModel2, "manageOfferListViewModel");
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(customManageItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.manageOfferListViewModel = manageOfferListViewModel2;
        this.mContext = context;
        this.listener = customManageItemClickListener;
    }

    public static final /* synthetic */ ResultData access$getItem(ManageOfferPageListAdapter manageOfferPageListAdapter, int i) {
        return (ResultData) manageOfferPageListAdapter.getItem(i);
    }

    @NotNull
    public final CustomManageItemClickListener getListener() {
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
    public final ManageOfferListHeader getMManageOfferListHeader() {
        ManageOfferListHeader manageOfferListHeader = this.mManageOfferListHeader;
        if (manageOfferListHeader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManageOfferListHeader");
        }
        return manageOfferListHeader;
    }

    public final void setMManageOfferListHeader(@NotNull ManageOfferListHeader manageOfferListHeader) {
        Intrinsics.checkParameterIsNotNull(manageOfferListHeader, "<set-?>");
        this.mManageOfferListHeader = manageOfferListHeader;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferPageListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return ManageOfferPageListAdapter.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return ManageOfferPageListAdapter.TYPE_ITEM;
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ItemManageOfferListBinding inflate = ItemManageOfferListBinding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemManageOfferListBindi…tInflater, parent, false)");
        objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate);
        if (i == TYPE_HEADER) {
            RowItemAuctinSalesListHeaderBinding inflate2 = RowItemAuctinSalesListHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "RowItemAuctinSalesListHe…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new HeaderDataViewHolder(this, inflate2);
        } else if (i == TYPE_ITEM) {
            ItemManageOfferListBinding inflate3 = ItemManageOfferListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemManageOfferListBindi…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate3);
            View view = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            ((ConstraintLayout) view.findViewById(C2723R.C2726id.parent_item)).setOnClickListener(new ManageOfferPageListAdapter$onCreateViewHolder$1(this, objectRef));
        }
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public final void setHeaderItem(@NotNull ManageOfferListHeader manageOfferListHeader) {
        Intrinsics.checkParameterIsNotNull(manageOfferListHeader, "manageOfferListHeader");
        this.mManageOfferListHeader = manageOfferListHeader;
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
        if (this.mManageOfferListHeader != null) {
            ManageOfferListHeader manageOfferListHeader = this.mManageOfferListHeader;
            if (manageOfferListHeader == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mManageOfferListHeader");
            }
            if (manageOfferListHeader.isError()) {
                return 1;
            }
        }
        if (super.getItemCount() == 0) {
            return super.getItemCount();
        }
        return 1 + super.getItemCount();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter$HeaderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter;Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;)V", "isClickedEnabled", "", "()Z", "setClickedEnabled", "(Z)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferPageListAdapter.kt */
    public final class HeaderDataViewHolder extends RecyclerView.ViewHolder {
        private final RowItemAuctinSalesListHeaderBinding binding;
        private boolean isClickedEnabled;
        final /* synthetic */ ManageOfferPageListAdapter this$0;

        public final void bindTo() {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderDataViewHolder(@NotNull ManageOfferPageListAdapter manageOfferPageListAdapter, RowItemAuctinSalesListHeaderBinding rowItemAuctinSalesListHeaderBinding) {
            super(rowItemAuctinSalesListHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemAuctinSalesListHeaderBinding, "binding");
            this.this$0 = manageOfferPageListAdapter;
            this.binding = rowItemAuctinSalesListHeaderBinding;
        }

        public final boolean isClickedEnabled() {
            return this.isClickedEnabled;
        }

        public final void setClickedEnabled(boolean z) {
            this.isClickedEnabled = z;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter$ResultDataItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemManageOfferListBinding;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferPageListAdapter;Lcom/iaai/android/databinding/ItemManageOfferListBinding;)V", "bindTo", "", "resultDatum", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferPageListAdapter.kt */
    public final class ResultDataItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemManageOfferListBinding binding;
        final /* synthetic */ ManageOfferPageListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultDataItemViewHolder(@NotNull ManageOfferPageListAdapter manageOfferPageListAdapter, ItemManageOfferListBinding itemManageOfferListBinding) {
            super(itemManageOfferListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemManageOfferListBinding, "binding");
            this.this$0 = manageOfferPageListAdapter;
            this.binding = itemManageOfferListBinding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
            r2 = r5.getVehicleTitle();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindTo(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.auctionSalesList.ResultData r5) {
            /*
                r4 = this;
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r4.binding
                android.widget.TextView r0 = r0.tvYearMakeModel
                java.lang.String r1 = "binding.tvYearMakeModel"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r1 = 0
                if (r5 == 0) goto L_0x0017
                java.lang.String r2 = r5.getVehicleTitle()
                if (r2 == 0) goto L_0x0017
                java.lang.String r2 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r2)
                goto L_0x0018
            L_0x0017:
                r2 = r1
            L_0x0018:
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r4.binding
                android.widget.TextView r0 = r0.tvStockNo
                java.lang.String r2 = "binding.tvStockNo"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Stock # : "
                r2.append(r3)
                if (r5 == 0) goto L_0x003b
                java.lang.String r3 = r5.getStockNumber()
                goto L_0x003c
            L_0x003b:
                r3 = r1
            L_0x003c:
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r4.binding
                android.widget.TextView r0 = r0.tvBranchNameLane
                java.lang.String r2 = "binding.tvBranchNameLane"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                if (r5 == 0) goto L_0x005d
                java.lang.String r3 = r5.getBranchName()
                goto L_0x005e
            L_0x005d:
                r3 = r1
            L_0x005e:
                r2.append(r3)
                java.lang.String r3 = " - "
                r2.append(r3)
                if (r5 == 0) goto L_0x006c
                java.lang.String r1 = r5.getLane()
            L_0x006c:
                r2.append(r1)
                java.lang.String r5 = r2.toString()
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r0.setText(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferPageListAdapter.ResultDataItemViewHolder.bindTo(com.iaai.android.bdt.model.auctionSalesList.ResultData):void");
        }
    }
}
