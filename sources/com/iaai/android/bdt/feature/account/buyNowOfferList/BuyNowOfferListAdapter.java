package com.iaai.android.bdt.feature.account.buyNowOfferList;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.databinding.ItemAuctionSalesListBinding;
import com.iaai.android.databinding.RowItemAuctinSalesListHeaderBinding;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.squareup.picasso.Picasso;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003234B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\"H\u0016J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"H\u0016J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001bJ\u000e\u0010.\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u00101R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010 ¨\u00065"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "buyNowOfferListViewModel", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListViewModel;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowItemClickListener;", "(Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListViewModel;Landroid/content/Context;Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowItemClickListener;)V", "auctionSalesListHeader", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "getAuctionSalesListHeader", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "setAuctionSalesListHeader", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;)V", "hashMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "getListener", "()Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowItemClickListener;", "mBuyNowCloseTime", "", "mCloseTime", "getMContext", "()Landroid/content/Context;", "selectedIemID", "Ljava/lang/Long;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBuyNowOfferCloseTime", "buyNowOfferCloseTime", "setHeaderItem", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Long;)V", "Companion", "HeaderDataViewHolder", "ResultDataItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListAdapter.kt */
public final class BuyNowOfferListAdapter extends PagedListAdapter<BuyNowOfferListModel, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    @NotNull
    public AuctionSalesListHeader auctionSalesListHeader;
    private final BuyNowOfferListViewModel buyNowOfferListViewModel;
    @NotNull
    private final HashMap<Long, Boolean> hashMap = new HashMap<>();
    @NotNull
    private final BuyNowItemClickListener listener;
    /* access modifiers changed from: private */
    public String mBuyNowCloseTime;
    /* access modifiers changed from: private */
    public String mCloseTime = "";
    @NotNull
    private final Context mContext;
    private Long selectedIemID = -1L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuyNowOfferListAdapter(@NotNull BuyNowOfferListViewModel buyNowOfferListViewModel2, @NotNull Context context, @NotNull BuyNowItemClickListener buyNowItemClickListener) {
        super(BuyNowOfferListModel.Companion.getDiffCallback());
        Intrinsics.checkParameterIsNotNull(buyNowOfferListViewModel2, "buyNowOfferListViewModel");
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(buyNowItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.buyNowOfferListViewModel = buyNowOfferListViewModel2;
        this.mContext = context;
        this.listener = buyNowItemClickListener;
    }

    public static final /* synthetic */ BuyNowOfferListModel access$getItem(BuyNowOfferListAdapter buyNowOfferListAdapter, int i) {
        return (BuyNowOfferListModel) buyNowOfferListAdapter.getItem(i);
    }

    @NotNull
    public final BuyNowItemClickListener getListener() {
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BuyNowOfferListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return BuyNowOfferListAdapter.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return BuyNowOfferListAdapter.TYPE_ITEM;
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
        } else if (i == TYPE_ITEM) {
            ItemAuctionSalesListBinding inflate3 = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemAuctionSalesListBind…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate3);
            View view = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            ((ConstraintLayout) view.findViewById(C2723R.C2726id.parent_item)).setOnClickListener(new BuyNowOfferListAdapter$onCreateViewHolder$1(this, objectRef));
            View view2 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ((ImageView) view2.findViewById(C2723R.C2726id.img_arrow_right)).setOnClickListener(new BuyNowOfferListAdapter$onCreateViewHolder$2(this, objectRef));
        }
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public final void setHeaderItem(@NotNull AuctionSalesListHeader auctionSalesListHeader2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "auctionSalesListHeader");
        this.auctionSalesListHeader = auctionSalesListHeader2;
    }

    public final void setBuyNowOfferCloseTime(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "buyNowOfferCloseTime");
        this.mCloseTime = str;
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
            ((ResultDataItemViewHolder) viewHolder).bindTo((BuyNowOfferListModel) getItem(i - 1), i);
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter$HeaderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;", "(Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter;Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;)V", "isClickedEnabled", "", "()Z", "setClickedEnabled", "(Z)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BuyNowOfferListAdapter.kt */
    public final class HeaderDataViewHolder extends RecyclerView.ViewHolder {
        private final RowItemAuctinSalesListHeaderBinding binding;
        private boolean isClickedEnabled;
        final /* synthetic */ BuyNowOfferListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderDataViewHolder(@NotNull BuyNowOfferListAdapter buyNowOfferListAdapter, RowItemAuctinSalesListHeaderBinding rowItemAuctinSalesListHeaderBinding) {
            super(rowItemAuctinSalesListHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemAuctinSalesListHeaderBinding, "binding");
            this.this$0 = buyNowOfferListAdapter;
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
            ConstraintLayout constraintLayout2 = this.binding.layoutSortContainer;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.layoutSortContainer");
            constraintLayout2.setVisibility(8);
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
                ConstraintLayout constraintLayout3 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.clEmptyView");
                constraintLayout3.setVisibility(0);
                return;
            }
            ConstraintLayout constraintLayout4 = this.binding.clEmptyView;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, "binding.clEmptyView");
            constraintLayout4.setVisibility(8);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter$ResultDataItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "(Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter;Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;)V", "bindTo", "", "resultDatum", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BuyNowOfferListAdapter.kt */
    public final class ResultDataItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemAuctionSalesListBinding binding;
        final /* synthetic */ BuyNowOfferListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultDataItemViewHolder(@NotNull BuyNowOfferListAdapter buyNowOfferListAdapter, ItemAuctionSalesListBinding itemAuctionSalesListBinding) {
            super(itemAuctionSalesListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            this.this$0 = buyNowOfferListAdapter;
            this.binding = itemAuctionSalesListBinding;
        }

        public final void bindTo(@Nullable BuyNowOfferListModel buyNowOfferListModel, int i) {
            String str;
            LinearLayout linearLayout = this.binding.llWatch;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llWatch");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.binding.llUnWatch;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llUnWatch");
            linearLayout2.setVisibility(8);
            StringBuilder sb = new StringBuilder();
            String str2 = null;
            sb.append(buyNowOfferListModel != null ? buyNowOfferListModel.getYear() : null);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(buyNowOfferListModel != null ? buyNowOfferListModel.getMake() : null);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(buyNowOfferListModel != null ? buyNowOfferListModel.getModel() : null);
            String sb2 = sb.toString();
            TextView textView = this.binding.yearMakeModel;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.yearMakeModel");
            textView.setText(String_ExtensionKt.toCamelCase(sb2));
            Picasso picasso = Picasso.get();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.this$0.getMContext().getResources().getString(C2723R.string.base_https_url_vehicle_thumbnail));
            Resources resources = this.this$0.getMContext().getResources();
            Object[] objArr = new Object[1];
            if (buyNowOfferListModel != null) {
                str2 = buyNowOfferListModel.getSalvageId();
            }
            objArr[0] = str2;
            sb3.append(resources.getString(C2723R.string.vehicle_thumbnail_url_for_buy_now_offer, objArr));
            picasso.load(sb3.toString()).placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(this.binding.vehicleImage1);
            StringBuilder sb4 = new StringBuilder();
            String str3 = "";
            sb4.append(str3);
            if (buyNowOfferListModel == null) {
                Intrinsics.throwNpe();
            }
            sb4.append(buyNowOfferListModel.getOfferAmount());
            String str4 = "Buy Now Offer: " + ("<b>" + UiUtils.formatCurrencyFromString(sb4.toString(), false) + "</b>");
            TextView textView2 = this.binding.tvPrimaryDamageValue;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvPrimaryDamageValue");
            textView2.setText(Html.fromHtml(str4));
            if (Build.VERSION.SDK_INT >= 24) {
                TextView textView3 = this.binding.tvPrimaryDamageValue;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvPrimaryDamageValue");
                textView3.setText(Html.fromHtml(str4, 0));
            } else {
                TextView textView4 = this.binding.tvPrimaryDamageValue;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvPrimaryDamageValue");
                textView4.setText(Html.fromHtml(str4));
            }
            if (this.this$0.mBuyNowCloseTime != null) {
                TextView textView5 = this.binding.tvBranchName;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvBranchName");
                textView5.setVisibility(0);
                TextView textView6 = this.binding.tvSeparator;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvSeparator");
                textView6.setVisibility(8);
                TextView textView7 = this.binding.tvBranchName;
                Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvBranchName");
                textView7.setText(this.this$0.getMContext().getString(C2723R.string.lbl_offer_expire_at, new Object[]{this.this$0.mBuyNowCloseTime}));
                TextView textView8 = this.binding.tvBranchName;
                TextView textView9 = this.binding.estimateTimeOnBlock;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.estimateTimeOnBlock");
                textView8.setTypeface(textView9.getTypeface(), 1);
                TextView textView10 = this.binding.tvLongDataLane;
                Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvLongDataLane");
                textView10.setVisibility(0);
                String access$getMBuyNowCloseTime$p = this.this$0.mBuyNowCloseTime;
                if (access$getMBuyNowCloseTime$p == null) {
                    Intrinsics.throwNpe();
                }
                if (StringsKt.contains((CharSequence) access$getMBuyNowCloseTime$p, (CharSequence) "d", false)) {
                    NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
                    String access$getMCloseTime$p = this.this$0.mCloseTime;
                    if (access$getMCloseTime$p == null) {
                        access$getMCloseTime$p = str3;
                    }
                    str = StringsKt.replace$default(StringsKt.replace$default(newDateHelper.getBuyNowExpireDate(access$getMCloseTime$p), "AM", "am", false, 4, (Object) null), "PM", "pm", false, 4, (Object) null);
                } else {
                    NewDateHelper newDateHelper2 = NewDateHelper.INSTANCE;
                    String access$getMCloseTime$p2 = this.this$0.mCloseTime;
                    if (access$getMCloseTime$p2 == null) {
                        access$getMCloseTime$p2 = str3;
                    }
                    str = StringsKt.replace$default(StringsKt.replace$default(newDateHelper2.getBNOfferExpireDate(access$getMCloseTime$p2), "AM", "am", false, 4, (Object) null), "PM", "pm", false, 4, (Object) null);
                }
                TextView textView11 = this.binding.tvLongDataLane;
                Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvLongDataLane");
                textView11.setText('(' + str + ')');
            } else {
                TextView textView12 = this.binding.tvBranchName;
                Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvBranchName");
                textView12.setVisibility(0);
                TextView textView13 = this.binding.tvSeparator;
                Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.tvSeparator");
                textView13.setVisibility(8);
                Date date = new Date();
                NewDateHelper newDateHelper3 = NewDateHelper.INSTANCE;
                NewDateHelper newDateHelper4 = NewDateHelper.INSTANCE;
                String access$getMCloseTime$p3 = this.this$0.mCloseTime;
                if (access$getMCloseTime$p3 == null) {
                    access$getMCloseTime$p3 = str3;
                }
                Long calculateTimeDiffInMillis = newDateHelper3.calculateTimeDiffInMillis(date, newDateHelper4.getBuyNowOfferExpireDate(access$getMCloseTime$p3));
                long longValue = calculateTimeDiffInMillis != null ? calculateTimeDiffInMillis.longValue() : 0;
                new BuyNowOfferListAdapter$ResultDataItemViewHolder$bindTo$1(this, i, longValue, 60000, longValue, (long) 60000).start();
                TextView textView14 = this.binding.tvBranchName;
                Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.tvBranchName");
                textView14.setText(this.this$0.getMContext().getString(C2723R.string.lbl_offer_expire_at, new Object[]{this.this$0.mBuyNowCloseTime}));
                TextView textView15 = this.binding.tvBranchName;
                TextView textView16 = this.binding.estimateTimeOnBlock;
                Intrinsics.checkExpressionValueIsNotNull(textView16, "binding.estimateTimeOnBlock");
                textView15.setTypeface(textView16.getTypeface(), 1);
            }
            if (buyNowOfferListModel.getSlot() != null && !StringsKt.equals(buyNowOfferListModel.getSlot(), str3, true)) {
                " - #" + buyNowOfferListModel.getSlot();
            }
            if (buyNowOfferListModel.getLane() != null && !StringsKt.equals(buyNowOfferListModel.getLane(), str3, true)) {
                str3 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + buyNowOfferListModel.getLane();
            }
            str3.toString();
            TextView textView17 = this.binding.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView17, "binding.preSaleRow3Right");
            textView17.setText(buyNowOfferListModel.getBranchName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + buyNowOfferListModel.getLaneAndItemNumber());
        }
    }
}
