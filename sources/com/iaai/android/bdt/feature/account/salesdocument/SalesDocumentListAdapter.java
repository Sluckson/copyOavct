package com.iaai.android.bdt.feature.account.salesdocument;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.databinding.RowItemSalesLdocumentHeaderBinding;
import com.iaai.android.databinding.RowListItemSalesDocumentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 E2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003EFGB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00105\u001a\u00020$H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020$H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020$H\u0016J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020$H\u0016J\u000e\u0010?\u001a\u0002092\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010@\u001a\u0002092\b\u0010A\u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020\nR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0004\n\u0002\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\u001a\u0010,\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR\u001a\u00102\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000e¨\u0006H"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "salesDocumentClickListener", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentClickListener;)V", "amountDueHeader", "", "getAmountDueHeader", "()Ljava/lang/String;", "setAmountDueHeader", "(Ljava/lang/String;)V", "auctionSalesListHeader", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "getAuctionSalesListHeader", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "setAuctionSalesListHeader", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;)V", "isAllVehicleSelected", "", "()Z", "setAllVehicleSelected", "(Z)V", "isFristTime", "getMContext", "()Landroid/content/Context;", "paymentMode", "getPaymentMode", "setPaymentMode", "selectedIemID", "", "Ljava/lang/Long;", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "sortBy", "getSortBy", "setSortBy", "titleStatus", "getTitleStatus", "setTitleStatus", "totalVehicleCount", "getTotalVehicleCount", "setTotalVehicleCount", "username", "getUsername", "setUsername", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHeaderItem", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Long;)V", "setTitleStatusTab", "status", "Companion", "SalesDocumentHeaderViewHolder", "SalesDocumentItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentListAdapter.kt */
public final class SalesDocumentListAdapter extends PagedListAdapter<SaleDocumentListModel, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    @NotNull
    private String amountDueHeader = "";
    @NotNull
    public AuctionSalesListHeader auctionSalesListHeader;
    private boolean isAllVehicleSelected;
    private boolean isFristTime = true;
    @NotNull
    private final Context mContext;
    @NotNull
    private String paymentMode = "";
    /* access modifiers changed from: private */
    public final SalesDocumentClickListener salesDocumentClickListener;
    private Long selectedIemID = -1L;
    private int selectedPosition = -1;
    @NotNull
    private String sortBy = "";
    @NotNull
    private String titleStatus = "All";
    @NotNull
    private String totalVehicleCount = "";
    @NotNull
    private String username = "";

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SalesDocumentListAdapter(@NotNull Context context, @NotNull SalesDocumentClickListener salesDocumentClickListener2) {
        super(SaleDocumentListModel.Companion.getDIFF_CALLBACK());
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(salesDocumentClickListener2, "salesDocumentClickListener");
        this.mContext = context;
        this.salesDocumentClickListener = salesDocumentClickListener2;
    }

    public static final /* synthetic */ SaleDocumentListModel access$getItem(SalesDocumentListAdapter salesDocumentListAdapter, int i) {
        return (SaleDocumentListModel) salesDocumentListAdapter.getItem(i);
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    @NotNull
    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.paymentMode = str;
    }

    @NotNull
    public final String getAmountDueHeader() {
        return this.amountDueHeader;
    }

    public final void setAmountDueHeader(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.amountDueHeader = str;
    }

    @NotNull
    public final String getTotalVehicleCount() {
        return this.totalVehicleCount;
    }

    public final void setTotalVehicleCount(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.totalVehicleCount = str;
    }

    public final boolean isAllVehicleSelected() {
        return this.isAllVehicleSelected;
    }

    public final void setAllVehicleSelected(boolean z) {
        this.isAllVehicleSelected = z;
    }

    @NotNull
    public final String getSortBy() {
        return this.sortBy;
    }

    public final void setSortBy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.sortBy = str;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.username = str;
    }

    @NotNull
    public final String getTitleStatus() {
        return this.titleStatus;
    }

    public final void setTitleStatus(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.titleStatus = str;
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        RowListItemSalesDocumentBinding inflate = RowListItemSalesDocumentBinding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "RowListItemSalesDocument…tInflater, parent, false)");
        RecyclerView.ViewHolder salesDocumentItemViewHolder = new SalesDocumentItemViewHolder(this, inflate);
        if (i == 0) {
            RowItemSalesLdocumentHeaderBinding inflate2 = RowItemSalesLdocumentHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "RowItemSalesLdocumentHea…tInflater, parent, false)");
            return new SalesDocumentHeaderViewHolder(this, inflate2);
        } else if (i != 1) {
            return salesDocumentItemViewHolder;
        } else {
            RowListItemSalesDocumentBinding inflate3 = RowListItemSalesDocumentBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "RowListItemSalesDocument…tInflater, parent, false)");
            return new SalesDocumentItemViewHolder(this, inflate3);
        }
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() <= 0) {
            return;
        }
        if (viewHolder instanceof SalesDocumentItemViewHolder) {
            ((SalesDocumentItemViewHolder) viewHolder).bindTo((SaleDocumentListModel) getItem(i - 1), i);
        } else if (viewHolder instanceof SalesDocumentHeaderViewHolder) {
            ((SalesDocumentHeaderViewHolder) viewHolder).bindTo();
        }
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

    public final void setHeaderItem(@NotNull AuctionSalesListHeader auctionSalesListHeader2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "auctionSalesListHeader");
        this.auctionSalesListHeader = auctionSalesListHeader2;
    }

    public final void setTitleStatusTab(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        this.titleStatus = str;
    }

    public final void setSelectedItemForTablet(@Nullable Long l) {
        this.selectedIemID = l;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentListAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SalesDocumentListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentListAdapter$SalesDocumentHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemSalesLdocumentHeaderBinding;", "(Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentListAdapter;Lcom/iaai/android/databinding/RowItemSalesLdocumentHeaderBinding;)V", "bindTo", "", "setTabSelection", "status", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SalesDocumentListAdapter.kt */
    public final class SalesDocumentHeaderViewHolder extends RecyclerView.ViewHolder {
        private final RowItemSalesLdocumentHeaderBinding binding;
        final /* synthetic */ SalesDocumentListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SalesDocumentHeaderViewHolder(@NotNull SalesDocumentListAdapter salesDocumentListAdapter, RowItemSalesLdocumentHeaderBinding rowItemSalesLdocumentHeaderBinding) {
            super(rowItemSalesLdocumentHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemSalesLdocumentHeaderBinding, "binding");
            this.this$0 = salesDocumentListAdapter;
            this.binding = rowItemSalesLdocumentHeaderBinding;
        }

        public final void bindTo() {
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
                ConstraintLayout constraintLayout = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clEmptyView");
                constraintLayout.setVisibility(0);
            } else {
                ConstraintLayout constraintLayout2 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clEmptyView");
                constraintLayout2.setVisibility(8);
            }
            this.binding.tvSortLabel.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$1(this));
            this.binding.ivSort.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$2(this));
            this.binding.tvFilterLabel.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$3(this));
            this.binding.imgFilter.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$4(this));
            this.binding.tvSalesDocManageBranch.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$5(this));
            setTabSelection(this.this$0.getTitleStatus());
            this.binding.tvAllStatus.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$6(this));
            this.binding.tvCloseStatus.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$7(this));
            this.binding.tvOpenStatus.setOnClickListener(new SalesDocumentListAdapter$SalesDocumentHeaderViewHolder$bindTo$8(this));
        }

        public final void setTabSelection(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "status");
            String obj = StringsKt.trim((CharSequence) str).toString();
            int hashCode = obj.hashCode();
            if (hashCode != 65921) {
                if (hashCode != 2464362) {
                    if (hashCode == 2021313932 && obj.equals("Closed")) {
                        TextView textView = this.binding.tvAllStatus;
                        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvAllStatus");
                        textView.setSelected(false);
                        TextView textView2 = this.binding.tvCloseStatus;
                        Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvCloseStatus");
                        textView2.setSelected(true);
                        TextView textView3 = this.binding.tvOpenStatus;
                        Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvOpenStatus");
                        textView3.setSelected(false);
                        TextView textView4 = this.binding.tvOpenStatus;
                        Context mContext = this.this$0.getMContext();
                        if (mContext == null) {
                            Intrinsics.throwNpe();
                        }
                        textView4.setTextColor(ContextCompat.getColor(mContext.getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
                        TextView textView5 = this.binding.tvCloseStatus;
                        Context mContext2 = this.this$0.getMContext();
                        if (mContext2 == null) {
                            Intrinsics.throwNpe();
                        }
                        textView5.setTextColor(ContextCompat.getColor(mContext2.getApplicationContext(), C2723R.C2724color.bdt_red));
                        TextView textView6 = this.binding.tvAllStatus;
                        Context mContext3 = this.this$0.getMContext();
                        if (mContext3 == null) {
                            Intrinsics.throwNpe();
                        }
                        textView6.setTextColor(ContextCompat.getColor(mContext3.getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
                    }
                } else if (obj.equals("Open")) {
                    TextView textView7 = this.binding.tvAllStatus;
                    Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvAllStatus");
                    textView7.setSelected(false);
                    TextView textView8 = this.binding.tvCloseStatus;
                    Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvCloseStatus");
                    textView8.setSelected(false);
                    TextView textView9 = this.binding.tvOpenStatus;
                    Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvOpenStatus");
                    textView9.setSelected(true);
                    TextView textView10 = this.binding.tvOpenStatus;
                    Context mContext4 = this.this$0.getMContext();
                    if (mContext4 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView10.setTextColor(ContextCompat.getColor(mContext4.getApplicationContext(), C2723R.C2724color.bdt_red));
                    TextView textView11 = this.binding.tvCloseStatus;
                    Context mContext5 = this.this$0.getMContext();
                    if (mContext5 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView11.setTextColor(ContextCompat.getColor(mContext5.getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
                    TextView textView12 = this.binding.tvAllStatus;
                    Context mContext6 = this.this$0.getMContext();
                    if (mContext6 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView12.setTextColor(ContextCompat.getColor(mContext6.getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
                }
            } else if (obj.equals("All")) {
                TextView textView13 = this.binding.tvAllStatus;
                Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.tvAllStatus");
                textView13.setSelected(true);
                TextView textView14 = this.binding.tvCloseStatus;
                Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.tvCloseStatus");
                textView14.setSelected(false);
                TextView textView15 = this.binding.tvOpenStatus;
                Intrinsics.checkExpressionValueIsNotNull(textView15, "binding.tvOpenStatus");
                textView15.setSelected(false);
                TextView textView16 = this.binding.tvOpenStatus;
                Context mContext7 = this.this$0.getMContext();
                if (mContext7 == null) {
                    Intrinsics.throwNpe();
                }
                textView16.setTextColor(ContextCompat.getColor(mContext7.getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
                TextView textView17 = this.binding.tvCloseStatus;
                Context mContext8 = this.this$0.getMContext();
                if (mContext8 == null) {
                    Intrinsics.throwNpe();
                }
                textView17.setTextColor(ContextCompat.getColor(mContext8.getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
                TextView textView18 = this.binding.tvAllStatus;
                Context mContext9 = this.this$0.getMContext();
                if (mContext9 == null) {
                    Intrinsics.throwNpe();
                }
                textView18.setTextColor(ContextCompat.getColor(mContext9.getApplicationContext(), C2723R.C2724color.bdt_red));
            }
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentListAdapter$SalesDocumentItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowListItemSalesDocumentBinding;", "(Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentListAdapter;Lcom/iaai/android/databinding/RowListItemSalesDocumentBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowListItemSalesDocumentBinding;", "bindTo", "", "salesDocumentListModel", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SalesDocumentListAdapter.kt */
    public final class SalesDocumentItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final RowListItemSalesDocumentBinding binding;
        final /* synthetic */ SalesDocumentListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SalesDocumentItemViewHolder(@NotNull SalesDocumentListAdapter salesDocumentListAdapter, RowListItemSalesDocumentBinding rowListItemSalesDocumentBinding) {
            super(rowListItemSalesDocumentBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowListItemSalesDocumentBinding, "binding");
            this.this$0 = salesDocumentListAdapter;
            this.binding = rowListItemSalesDocumentBinding;
        }

        @NotNull
        public final RowListItemSalesDocumentBinding getBinding() {
            return this.binding;
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0285  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x028a  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x0294  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x02ab  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x02b0  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x02b8  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x02d9  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x02de  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x02ea  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0333  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0338  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x033b  */
        /* JADX WARNING: Removed duplicated region for block: B:156:0x039a  */
        /* JADX WARNING: Removed duplicated region for block: B:157:0x039f  */
        /* JADX WARNING: Removed duplicated region for block: B:160:0x03a9  */
        /* JADX WARNING: Removed duplicated region for block: B:170:0x03ff  */
        /* JADX WARNING: Removed duplicated region for block: B:173:0x045e  */
        /* JADX WARNING: Removed duplicated region for block: B:179:0x04ea  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindTo(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel r12, int r13) {
            /*
                r11 = this;
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.vehicleTitle
                java.lang.String r1 = "binding.vehicleTitle"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r1 = 0
                if (r12 == 0) goto L_0x0011
                java.lang.String r2 = r12.getVehicleDescription()
                goto L_0x0012
            L_0x0011:
                r2 = r1
            L_0x0012:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvStockNumber
                java.lang.String r2 = "binding.tvStockNumber"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter r3 = r11.this$0
                android.content.Context r3 = r3.getMContext()
                r4 = 2131821329(0x7f110311, float:1.9275398E38)
                java.lang.String r3 = r3.getString(r4)
                r2.append(r3)
                java.lang.String r3 = ": "
                r2.append(r3)
                java.lang.String r4 = ""
                if (r12 == 0) goto L_0x0045
                java.lang.String r5 = r12.getStockNumber()
                if (r5 == 0) goto L_0x0045
                goto L_0x0046
            L_0x0045:
                r5 = r4
            L_0x0046:
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvVinNumber
                java.lang.String r2 = "binding.tvVinNumber"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter r5 = r11.this$0
                android.content.Context r5 = r5.getMContext()
                r6 = 2131821877(0x7f110535, float:1.927651E38)
                java.lang.String r5 = r5.getString(r6)
                r2.append(r5)
                r2.append(r3)
                if (r12 == 0) goto L_0x007c
                java.lang.String r3 = r12.getVIN()
                if (r3 == 0) goto L_0x007c
                goto L_0x007d
            L_0x007c:
                r3 = r4
            L_0x007d:
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                if (r12 == 0) goto L_0x0090
                java.lang.String r0 = r12.getTitleStatus()
                goto L_0x0091
            L_0x0090:
                r0 = r1
            L_0x0091:
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r0 == 0) goto L_0x04f2
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
                java.lang.String r0 = r0.toString()
                r3 = 0
                java.lang.String r5 = "Closed"
                boolean r0 = kotlin.text.StringsKt.equals(r0, r5, r3)
                java.lang.String r5 = "binding.rowItemRadioBtn"
                r6 = 8
                if (r0 == 0) goto L_0x00bb
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.rowItemRadioBtn
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r0.setVisibility(r6)
                goto L_0x00c5
            L_0x00bb:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.rowItemRadioBtn
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r0.setVisibility(r3)
            L_0x00c5:
                if (r12 == 0) goto L_0x00cc
                java.lang.String r0 = r12.getTitleDeliveryMethodCode()
                goto L_0x00cd
            L_0x00cc:
                r0 = r1
            L_0x00cd:
                r7 = 1
                java.lang.String r8 = "OPU"
                boolean r0 = kotlin.text.StringsKt.equals(r0, r8, r7)
                java.lang.String r8 = "Pick up: "
                java.lang.String r9 = "binding.tvOwnerName"
                if (r0 == 0) goto L_0x0133
                if (r12 == 0) goto L_0x00e1
                java.lang.String r0 = r12.getOwnerName()
                goto L_0x00e2
            L_0x00e1:
                r0 = r1
            L_0x00e2:
                if (r0 == 0) goto L_0x0127
                if (r12 == 0) goto L_0x00eb
                java.lang.String r0 = r12.getOwnerName()
                goto L_0x00ec
            L_0x00eb:
                r0 = r1
            L_0x00ec:
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                r0 = r0 ^ r7
                if (r0 == 0) goto L_0x0127
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r8)
                if (r12 == 0) goto L_0x0109
                java.lang.String r8 = r12.getOwnerName()
                goto L_0x010a
            L_0x0109:
                r8 = r1
            L_0x010a:
                r10.append(r8)
                java.lang.String r8 = " (Owner)"
                r10.append(r8)
                java.lang.String r8 = r10.toString()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r0.setText(r8)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                r0.setVisibility(r3)
                goto L_0x0199
            L_0x0127:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                r0.setVisibility(r6)
                goto L_0x0199
            L_0x0133:
                if (r12 == 0) goto L_0x013a
                java.lang.String r0 = r12.getTitleDeliveryMethodCode()
                goto L_0x013b
            L_0x013a:
                r0 = r1
            L_0x013b:
                java.lang.String r10 = "RPU"
                boolean r0 = kotlin.text.StringsKt.equals(r0, r10, r7)
                if (r0 == 0) goto L_0x0199
                if (r12 == 0) goto L_0x014a
                java.lang.String r0 = r12.getRepresentativeName()
                goto L_0x014b
            L_0x014a:
                r0 = r1
            L_0x014b:
                if (r0 == 0) goto L_0x018f
                if (r12 == 0) goto L_0x0154
                java.lang.String r0 = r12.getRepresentativeName()
                goto L_0x0155
            L_0x0154:
                r0 = r1
            L_0x0155:
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                r0 = r0 ^ r7
                if (r0 == 0) goto L_0x018f
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r8)
                if (r12 == 0) goto L_0x0172
                java.lang.String r8 = r12.getRepresentativeName()
                goto L_0x0173
            L_0x0172:
                r8 = r1
            L_0x0173:
                r10.append(r8)
                java.lang.String r8 = " (Representative)"
                r10.append(r8)
                java.lang.String r8 = r10.toString()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r0.setText(r8)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                r0.setVisibility(r3)
                goto L_0x0199
            L_0x018f:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                r0.setVisibility(r6)
            L_0x0199:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                androidx.constraintlayout.widget.ConstraintLayout r0 = r0.clToBePaidContainer
                java.lang.String r8 = "binding.clToBePaidContainer"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r8)
                if (r12 == 0) goto L_0x01ad
                boolean r8 = r12.isSelected()
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
                goto L_0x01ae
            L_0x01ad:
                r8 = r1
            L_0x01ae:
                if (r8 != 0) goto L_0x01b3
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x01b3:
                boolean r8 = r8.booleanValue()
                r0.setSelected(r8)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvBranchName
                java.lang.String r8 = "binding.tvBranchName"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r8)
                if (r12 == 0) goto L_0x01ca
                java.lang.String r8 = r12.getBranchName()
                goto L_0x01cb
            L_0x01ca:
                r8 = r1
            L_0x01cb:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r0.setText(r8)
                if (r12 == 0) goto L_0x01eb
                java.lang.String r0 = r12.getTitleStatus()
                if (r0 == 0) goto L_0x01eb
                if (r0 == 0) goto L_0x01e5
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
                java.lang.String r0 = r0.toString()
                goto L_0x01ec
            L_0x01e5:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r2)
                throw r12
            L_0x01eb:
                r0 = r1
            L_0x01ec:
                r2 = 2
                java.lang.String r8 = "Open"
                boolean r0 = kotlin.text.StringsKt.equals$default(r0, r8, r3, r2, r1)
                java.lang.String r2 = "binding.tvTitleStatus"
                if (r0 == 0) goto L_0x0220
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvTitleStatus
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvTitleStatus
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                if (r12 == 0) goto L_0x020f
                java.lang.String r2 = r12.getTitleStatus()
                goto L_0x0210
            L_0x020f:
                r2 = r1
            L_0x0210:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.rowItemRadioBtn
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r0.setVisibility(r3)
                goto L_0x0235
            L_0x0220:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvTitleStatus
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r6)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.rowItemRadioBtn
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r2 = 4
                r0.setVisibility(r2)
            L_0x0235:
                if (r12 == 0) goto L_0x023c
                java.lang.String r0 = r12.getTitleDeliveryMethodCode()
                goto L_0x023d
            L_0x023c:
                r0 = r1
            L_0x023d:
                java.lang.String r2 = "IFA"
                boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r7)
                if (r0 != 0) goto L_0x026d
                if (r12 == 0) goto L_0x024c
                java.lang.String r0 = r12.getTitleDeliveryMethodCode()
                goto L_0x024d
            L_0x024c:
                r0 = r1
            L_0x024d:
                java.lang.String r2 = "BFA"
                boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r7)
                if (r0 == 0) goto L_0x0256
                goto L_0x026d
            L_0x0256:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvFedEx
                java.lang.String r2 = "binding.tvFedEx"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r6)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                r0.setVisibility(r3)
                goto L_0x0283
            L_0x026d:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvFedEx
                java.lang.String r2 = "binding.tvFedEx"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvOwnerName
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r9)
                r0.setVisibility(r6)
            L_0x0283:
                if (r12 == 0) goto L_0x028a
                java.lang.String r0 = r12.getAdditionalNotes()
                goto L_0x028b
            L_0x028a:
                r0 = r1
            L_0x028b:
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                r0 = r0 ^ r7
                java.lang.String r2 = "binding.llReviewFees"
                if (r0 == 0) goto L_0x02a9
                if (r12 == 0) goto L_0x029b
                java.lang.String r0 = r12.getAdditionalNotes()
                goto L_0x029c
            L_0x029b:
                r0 = r1
            L_0x029c:
                if (r0 == 0) goto L_0x02a9
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llReviewFees
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r3)
                goto L_0x02d7
            L_0x02a9:
                if (r12 == 0) goto L_0x02b0
                java.lang.String r0 = r12.getBuyerNotes()
                goto L_0x02b1
            L_0x02b0:
                r0 = r1
            L_0x02b1:
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                r0 = r0 ^ r7
                if (r0 == 0) goto L_0x02cd
                if (r12 == 0) goto L_0x02bf
                java.lang.String r0 = r12.getBuyerNotes()
                goto L_0x02c0
            L_0x02bf:
                r0 = r1
            L_0x02c0:
                if (r0 == 0) goto L_0x02cd
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llReviewFees
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r3)
                goto L_0x02d7
            L_0x02cd:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llReviewFees
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r6)
            L_0x02d7:
                if (r12 == 0) goto L_0x02de
                java.lang.String r0 = r12.getAdditionalNotes()
                goto L_0x02df
            L_0x02de:
                r0 = r1
            L_0x02df:
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                r0 = r0 ^ r7
                java.lang.String r2 = "binding.tvNotesForBranchValue"
                java.lang.String r5 = "binding.tvNotesForBranch"
                if (r0 == 0) goto L_0x031d
                if (r12 == 0) goto L_0x02f1
                java.lang.String r0 = r12.getAdditionalNotes()
                goto L_0x02f2
            L_0x02f1:
                r0 = r1
            L_0x02f2:
                if (r0 == 0) goto L_0x031d
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesForBranchValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesForBranch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesForBranchValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                if (r12 == 0) goto L_0x0316
                java.lang.String r2 = r12.getAdditionalNotes()
                goto L_0x0317
            L_0x0316:
                r2 = r1
            L_0x0317:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                goto L_0x0331
            L_0x031d:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesForBranchValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r6)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesForBranch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r0.setVisibility(r6)
            L_0x0331:
                if (r12 == 0) goto L_0x0338
                java.lang.String r0 = r12.getTrackingNumber()
                goto L_0x0339
            L_0x0338:
                r0 = r1
            L_0x0339:
                if (r0 == 0) goto L_0x038c
                if (r12 == 0) goto L_0x0342
                java.lang.String r0 = r12.getTrackingNumber()
                goto L_0x0343
            L_0x0342:
                r0 = r1
            L_0x0343:
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                r0 = r0 ^ r7
                if (r0 == 0) goto L_0x038c
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llTrackingId
                java.lang.String r2 = "binding.llTrackingId"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvTrackingId
                java.lang.String r2 = "binding.tvTrackingId"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = "Tracking #: "
                r2.append(r8)
                if (r12 == 0) goto L_0x0372
                java.lang.String r8 = r12.getTrackingNumber()
                if (r8 == 0) goto L_0x0372
                goto L_0x0373
            L_0x0372:
                r8 = r4
            L_0x0373:
                r2.append(r8)
                java.lang.String r2 = r2.toString()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvTrackingId
                java.lang.String r2 = "binding.tvTrackingId"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setPaintFlags(r6)
                goto L_0x0398
            L_0x038c:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llTrackingId
                java.lang.String r2 = "binding.llTrackingId"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r6)
            L_0x0398:
                if (r12 == 0) goto L_0x039f
                java.lang.String r0 = r12.getBuyerNotes()
                goto L_0x03a0
            L_0x039f:
                r0 = r1
            L_0x03a0:
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                r0 = r0 ^ r7
                java.lang.String r2 = "binding.tvNotesFromBranchValue"
                if (r0 == 0) goto L_0x03dc
                if (r12 == 0) goto L_0x03b0
                java.lang.String r0 = r12.getBuyerNotes()
                goto L_0x03b1
            L_0x03b0:
                r0 = r1
            L_0x03b1:
                if (r0 == 0) goto L_0x03dc
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesFromBranchValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesFromBranch
                java.lang.String r5 = "binding.tvNotesFromBranch"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesFromBranchValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                if (r12 == 0) goto L_0x03d6
                java.lang.String r1 = r12.getBuyerNotes()
            L_0x03d6:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                goto L_0x0412
            L_0x03dc:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesFromBranch
                java.lang.String r1 = "binding.tvNotesFromBranch"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r6)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesFromBranchValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r6)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvNotesForBranch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
                if (r0 == 0) goto L_0x04ea
                android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
                r1 = 30
                r0.setMargins(r1, r3, r3, r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvNotesForBranch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
                r1.setLayoutParams(r0)
            L_0x0412:
                com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
                r0.<init>()
                com.bumptech.glide.request.RequestOptions r0 = r0.centerCrop()
                r1 = 2131231231(0x7f0801ff, float:1.8078537E38)
                com.bumptech.glide.request.RequestOptions r0 = r0.error((int) r1)
                com.bumptech.glide.load.engine.DiskCacheStrategy r1 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
                com.bumptech.glide.request.RequestOptions r0 = r0.diskCacheStrategy(r1)
                com.bumptech.glide.Priority r1 = com.bumptech.glide.Priority.HIGH
                com.bumptech.glide.request.RequestOptions r0 = r0.priority(r1)
                r1 = 2131231567(0x7f08034f, float:1.8079219E38)
                com.bumptech.glide.request.RequestOptions r0 = r0.placeholder((int) r1)
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                com.bumptech.glide.RequestManager r1 = com.bumptech.glide.Glide.with((android.content.Context) r1)
                com.bumptech.glide.RequestBuilder r1 = r1.load((java.lang.String) r4)
                com.bumptech.glide.RequestBuilder r0 = r1.apply(r0)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r1 = r11.binding
                android.widget.ImageView r1 = r1.vehicleImage
                r0.into((android.widget.ImageView) r1)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvReviewFees
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$1 r1 = new com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$1
                r1.<init>(r11)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                if (r12 == 0) goto L_0x0495
                boolean r0 = r12.isFeeVisible()
                if (r0 == 0) goto L_0x047d
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                androidx.constraintlayout.widget.ConstraintLayout r0 = r0.ClReviewDetailsContainer
                java.lang.String r1 = "binding.ClReviewDetailsContainer"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r3)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.ivTotalDueArrow
                java.lang.String r1 = "binding.ivTotalDueArrow"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setSelected(r7)
                goto L_0x0495
            L_0x047d:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                androidx.constraintlayout.widget.ConstraintLayout r0 = r0.ClReviewDetailsContainer
                java.lang.String r1 = "binding.ClReviewDetailsContainer"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r6)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.ivTotalDueArrow
                java.lang.String r1 = "binding.ivTotalDueArrow"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setSelected(r3)
            L_0x0495:
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvReviewFees
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$2 r1 = new com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$2
                r1.<init>(r11, r13)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.ivTotalDueArrow
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$3 r1 = new com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$3
                r1.<init>(r11, r13)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llReviewFees
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$4 r1 = new com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$4
                r1.<init>(r11, r13)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvTrackingId
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$5 r1 = new com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$5
                r1.<init>(r11, r12)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r12 = r11.binding
                androidx.constraintlayout.widget.ConstraintLayout r12 = r12.clToBePaidContainer
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$6 r0 = new com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$6
                r0.<init>(r11, r13)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r12.setOnClickListener(r0)
                com.iaai.android.databinding.RowListItemSalesDocumentBinding r12 = r11.binding
                android.widget.ImageView r12 = r12.rowItemRadioBtn
                com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$7 r0 = new com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$7
                r0.<init>(r11, r13)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r12.setOnClickListener(r0)
                return
            L_0x04ea:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                java.lang.String r13 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
                r12.<init>(r13)
                throw r12
            L_0x04f2:
                kotlin.TypeCastException r12 = new kotlin.TypeCastException
                r12.<init>(r2)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter.SalesDocumentItemViewHolder.bindTo(com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel, int):void");
        }
    }
}
