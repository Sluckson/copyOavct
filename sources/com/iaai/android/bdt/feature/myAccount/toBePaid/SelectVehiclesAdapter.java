package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.VehicleFees;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.RowListItemSelectVehiclesBinding;
import com.iaai.android.databinding.RowListItemSelectVehiclesBindingImpl;
import com.iaai.android.databinding.ToBePaidHeaderBinding;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003567B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010(\u001a\u00020\u001aH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u001aH\u0016J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001aH\u0016J.\u00102\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010%\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000e¨\u00068"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/SelectVehiclesAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "toBePaidClickListener", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidClickListener;)V", "amountDueHeader", "", "getAmountDueHeader", "()Ljava/lang/String;", "setAmountDueHeader", "(Ljava/lang/String;)V", "isAllVehicleSelected", "", "()Z", "setAllVehicleSelected", "(Z)V", "getMContext", "()Landroid/content/Context;", "paymentMode", "getPaymentMode", "setPaymentMode", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "sortBy", "getSortBy", "setSortBy", "totalVehicleCount", "getTotalVehicleCount", "setTotalVehicleCount", "username", "getUsername", "setUsername", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHeaderData", "vehicleCount", "totalAmount", "Companion", "ToBePaidHeaderViewHolder", "ToBePaidItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SelectVehiclesAdapter.kt */
public final class SelectVehiclesAdapter extends PagedListAdapter<PaymentDue, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    @NotNull
    private String amountDueHeader = "";
    private boolean isAllVehicleSelected;
    @NotNull
    private final Context mContext;
    @NotNull
    private String paymentMode = "";
    private int selectedPosition = -1;
    @NotNull
    private String sortBy = "";
    /* access modifiers changed from: private */
    public final ToBePaidClickListener toBePaidClickListener;
    @NotNull
    private String totalVehicleCount = "";
    @NotNull
    private String username = "";

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectVehiclesAdapter(@NotNull Context context, @NotNull ToBePaidClickListener toBePaidClickListener2) {
        super(PaymentDue.Companion.getDIFF_CALLBACK());
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(toBePaidClickListener2, "toBePaidClickListener");
        this.mContext = context;
        this.toBePaidClickListener = toBePaidClickListener2;
    }

    public static final /* synthetic */ PaymentDue access$getItem(SelectVehiclesAdapter selectVehiclesAdapter, int i) {
        return (PaymentDue) selectVehiclesAdapter.getItem(i);
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        RowListItemSelectVehiclesBinding inflate = RowListItemSelectVehiclesBindingImpl.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "RowListItemSelectVehicle…tInflater, parent, false)");
        RecyclerView.ViewHolder toBePaidItemViewHolder = new ToBePaidItemViewHolder(this, inflate);
        if (i == 0) {
            ToBePaidHeaderBinding inflate2 = ToBePaidHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "ToBePaidHeaderBinding.in…tInflater, parent, false)");
            return new ToBePaidHeaderViewHolder(this, inflate2);
        } else if (i != 1) {
            return toBePaidItemViewHolder;
        } else {
            RowListItemSelectVehiclesBinding inflate3 = RowListItemSelectVehiclesBindingImpl.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "RowListItemSelectVehicle…tInflater, parent, false)");
            return new ToBePaidItemViewHolder(this, inflate3);
        }
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() <= 0) {
            return;
        }
        if (viewHolder instanceof ToBePaidItemViewHolder) {
            ((ToBePaidItemViewHolder) viewHolder).bindTo((PaymentDue) getItem(i - 1), i);
        } else if (viewHolder instanceof ToBePaidHeaderViewHolder) {
            ((ToBePaidHeaderViewHolder) viewHolder).bindTo();
        }
    }

    public int getItemCount() {
        if (super.getItemCount() == 0) {
            return super.getItemCount();
        }
        return super.getItemCount() + 1;
    }

    public final void setHeaderData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "paymentMode");
        Intrinsics.checkParameterIsNotNull(str2, "vehicleCount");
        Intrinsics.checkParameterIsNotNull(str3, "totalAmount");
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_SORT_BY);
        Intrinsics.checkParameterIsNotNull(str5, "username");
        this.paymentMode = str;
        this.amountDueHeader = str3;
        this.totalVehicleCount = str2;
        this.sortBy = str4;
        this.username = str5;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/SelectVehiclesAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SelectVehiclesAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/SelectVehiclesAdapter$ToBePaidHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ToBePaidHeaderBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/SelectVehiclesAdapter;Lcom/iaai/android/databinding/ToBePaidHeaderBinding;)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SelectVehiclesAdapter.kt */
    public final class ToBePaidHeaderViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final ToBePaidHeaderBinding binding;
        final /* synthetic */ SelectVehiclesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToBePaidHeaderViewHolder(@NotNull SelectVehiclesAdapter selectVehiclesAdapter, ToBePaidHeaderBinding toBePaidHeaderBinding) {
            super(toBePaidHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(toBePaidHeaderBinding, "binding");
            this.this$0 = selectVehiclesAdapter;
            this.binding = toBePaidHeaderBinding;
        }

        public final void bindTo() {
            if (this.this$0.getPaymentMode().length() > 0) {
                TextView textView = this.binding.tvChangePayment;
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvChangePayment");
                textView.setVisibility(0);
                TextView textView2 = this.binding.tvPaymentMsg;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvPaymentMsg");
                textView2.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_selected_payment_method));
                TextView textView3 = this.binding.tvPaymentMode;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvPaymentMode");
                textView3.setVisibility(0);
                TextView textView4 = this.binding.tvPaymentMode;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvPaymentMode");
                textView4.setText(this.this$0.getPaymentMode());
                TextView textView5 = this.binding.tvSelectPayment;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvSelectPayment");
                textView5.setVisibility(8);
                ImageView imageView = this.binding.ivSelectPayment;
                Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivSelectPayment");
                imageView.setVisibility(8);
            } else {
                TextView textView6 = this.binding.tvChangePayment;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvChangePayment");
                textView6.setVisibility(8);
                TextView textView7 = this.binding.tvPaymentMode;
                Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvPaymentMode");
                textView7.setVisibility(8);
                TextView textView8 = this.binding.tvPaymentMsg;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvPaymentMsg");
                textView8.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_select_payment_method_message));
                TextView textView9 = this.binding.tvSelectPayment;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvSelectPayment");
                textView9.setVisibility(0);
                ImageView imageView2 = this.binding.ivSelectPayment;
                Intrinsics.checkExpressionValueIsNotNull(imageView2, "binding.ivSelectPayment");
                imageView2.setVisibility(0);
            }
            if (Integer.parseInt(this.this$0.getTotalVehicleCount()) == 0 || Integer.parseInt(this.this$0.getTotalVehicleCount()) == 1) {
                LinearLayout linearLayout = this.binding.llSelectAll;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llSelectAll");
                linearLayout.setVisibility(8);
                View view = this.binding.viewSeparator2;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.viewSeparator2");
                view.setVisibility(8);
            } else {
                LinearLayout linearLayout2 = this.binding.llSelectAll;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llSelectAll");
                linearLayout2.setVisibility(0);
                View view2 = this.binding.viewSeparator2;
                Intrinsics.checkExpressionValueIsNotNull(view2, "binding.viewSeparator2");
                view2.setVisibility(0);
            }
            Drawable drawable = ContextCompat.getDrawable(this.this$0.getMContext(), C2723R.C2725drawable.ic_filter_list);
            if (drawable == null) {
                Intrinsics.throwNpe();
            }
            drawable.setBounds(0, 0, (int) (((double) drawable.getIntrinsicWidth()) * 0.5d), (int) (((double) drawable.getIntrinsicHeight()) * 0.5d));
            new ScaleDrawable(drawable, 0, (float) 16843260, (float) 16843261);
            TextView textView10 = this.binding.tvSelectAll;
            Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvSelectAll");
            textView10.setSelected(this.this$0.isAllVehicleSelected());
            TextView textView11 = this.binding.tvSelectAll;
            Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvSelectAll");
            if (textView11.isSelected()) {
                TextView textView12 = this.binding.tvSelectMsg;
                Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvSelectMsg");
                textView12.setVisibility(0);
            } else {
                TextView textView13 = this.binding.tvSelectMsg;
                Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.tvSelectMsg");
                textView13.setVisibility(8);
            }
            TextView textView14 = this.binding.tvCountAndDue;
            Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.tvCountAndDue");
            textView14.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_items_amount_due, new Object[]{this.this$0.getTotalVehicleCount(), UiUtils.formatCurrencyFromString(this.this$0.getAmountDueHeader(), true)}));
            this.binding.ivSelectPayment.setOnClickListener(new SelectVehiclesAdapter$ToBePaidHeaderViewHolder$bindTo$1(this));
            this.binding.tvSelectPayment.setOnClickListener(new SelectVehiclesAdapter$ToBePaidHeaderViewHolder$bindTo$2(this));
            this.binding.tvChangePayment.setOnClickListener(new SelectVehiclesAdapter$ToBePaidHeaderViewHolder$bindTo$3(this));
            this.binding.llSort.setOnClickListener(new SelectVehiclesAdapter$ToBePaidHeaderViewHolder$bindTo$4(this));
            this.binding.tvSelectAll.setOnClickListener(new SelectVehiclesAdapter$ToBePaidHeaderViewHolder$bindTo$5(this));
            TextView textView15 = this.binding.tvSortValue;
            Intrinsics.checkExpressionValueIsNotNull(textView15, "binding.tvSortValue");
            textView15.setText(this.this$0.getSortBy());
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/SelectVehiclesAdapter$ToBePaidItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowListItemSelectVehiclesBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/SelectVehiclesAdapter;Lcom/iaai/android/databinding/RowListItemSelectVehiclesBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowListItemSelectVehiclesBinding;", "bindTo", "", "tobePaid", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "position", "", "createFeeLayout", "feeList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/VehicleFees;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SelectVehiclesAdapter.kt */
    public final class ToBePaidItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final RowListItemSelectVehiclesBinding binding;
        final /* synthetic */ SelectVehiclesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToBePaidItemViewHolder(@NotNull SelectVehiclesAdapter selectVehiclesAdapter, RowListItemSelectVehiclesBinding rowListItemSelectVehiclesBinding) {
            super(rowListItemSelectVehiclesBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowListItemSelectVehiclesBinding, "binding");
            this.this$0 = selectVehiclesAdapter;
            this.binding = rowListItemSelectVehiclesBinding;
        }

        @NotNull
        public final RowListItemSelectVehiclesBinding getBinding() {
            return this.binding;
        }

        public final void bindTo(@Nullable PaymentDue paymentDue, int i) {
            Integer oAAuctionItemId;
            TextView textView = this.binding.vehicleTitle;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.vehicleTitle");
            List<VehicleFees> list = null;
            textView.setText(paymentDue != null ? paymentDue.getDescription() : null);
            TextView textView2 = this.binding.tvCCStockNo;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvCCStockNo");
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.getMContext().getString(C2723R.string.lbl_cc_stock));
            sb.append(' ');
            sb.append(paymentDue != null ? paymentDue.getStockNo() : null);
            textView2.setText(sb.toString());
            TextView textView3 = this.binding.tvTotalDue;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvTotalDue");
            textView3.setText(UiUtils.formatCurrencyFromString(String.valueOf(paymentDue != null ? Double.valueOf(paymentDue.getTotalDue()) : null), true));
            TextView textView4 = this.binding.tvBranchInfo;
            Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvBranchInfo");
            textView4.setText(String.valueOf(paymentDue != null ? paymentDue.getIAABranchName() : null));
            CharSequence stockNumber = paymentDue != null ? paymentDue.getStockNumber() : null;
            if (stockNumber == null || stockNumber.length() == 0) {
                TextView textView5 = this.binding.tvStockNumber;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvStockNumber");
                textView5.setVisibility(8);
            } else {
                TextView textView6 = this.binding.tvStockNumber;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvStockNumber");
                textView6.setVisibility(0);
                TextView textView7 = this.binding.tvStockNumber;
                Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvStockNumber");
                textView7.setText(String.valueOf(paymentDue != null ? paymentDue.getStockNo() : null));
            }
            if (StringsKt.equals$default(paymentDue != null ? paymentDue.getBidderName() : null, "0", false, 2, (Object) null)) {
                TextView textView8 = this.binding.tvUsername;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvUsername");
                textView8.setVisibility(8);
            } else {
                TextView textView9 = this.binding.tvUsername;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvUsername");
                textView9.setVisibility(0);
                TextView textView10 = this.binding.tvUsername;
                Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvUsername");
                textView10.setText(String.valueOf(paymentDue != null ? paymentDue.getBidderName() : null));
            }
            if (paymentDue == null || !paymentDue.getPartial_Payment_Ind()) {
                TextView textView11 = this.binding.tvPartialPaid;
                Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvPartialPaid");
                textView11.setVisibility(8);
            } else {
                TextView textView12 = this.binding.tvPartialPaid;
                Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvPartialPaid");
                textView12.setVisibility(0);
            }
            TextView textView13 = this.binding.tvUsername;
            Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.tvUsername");
            textView13.setText(String.valueOf(paymentDue != null ? paymentDue.getBidderName() : null));
            ConstraintLayout constraintLayout = this.binding.clToBePaidContainer;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clToBePaidContainer");
            Boolean valueOf = paymentDue != null ? Boolean.valueOf(paymentDue.isSelected()) : null;
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            constraintLayout.setSelected(valueOf.booleanValue());
            if (paymentDue.isFeeVisible()) {
                if (paymentDue != null) {
                    list = paymentDue.getVehicleFees();
                }
                createFeeLayout(list);
                LinearLayout linearLayout = this.binding.llFeeCreditCardLayout;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llFeeCreditCardLayout");
                linearLayout.setVisibility(0);
                ImageView imageView = this.binding.ivTotalDueArrow;
                Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivTotalDueArrow");
                imageView.setSelected(true);
            } else {
                LinearLayout linearLayout2 = this.binding.llFeeCreditCardLayout;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llFeeCreditCardLayout");
                linearLayout2.setVisibility(8);
                ImageView imageView2 = this.binding.ivTotalDueArrow;
                Intrinsics.checkExpressionValueIsNotNull(imageView2, "binding.ivTotalDueArrow");
                imageView2.setSelected(false);
            }
            TextView textView14 = this.binding.tvBidWonMethod;
            Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.tvBidWonMethod");
            textView14.setText(paymentDue.getBidWonMethod());
            Glide.with(this.this$0.getMContext()).load(paymentDue.getThumbnailImageUrl()).apply(new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation)).into(this.binding.vehicleImage);
            this.binding.clToBePaidContainer.setOnClickListener(new SelectVehiclesAdapter$ToBePaidItemViewHolder$bindTo$1(this, i));
            if (paymentDue.getPaymentDueDate() != null) {
                TextView textView15 = this.binding.tvDueDate;
                Intrinsics.checkExpressionValueIsNotNull(textView15, "binding.tvDueDate");
                textView15.setVisibility(0);
                Pair<Boolean, String> dueDateInfo = Context_ExtensionKt.getDueDateInfo(this.this$0.getMContext(), paymentDue.getPaymentDueDate());
                if (dueDateInfo.getFirst().booleanValue()) {
                    this.binding.tvDueDate.setBackgroundResource(C2723R.C2725drawable.custom_rounded_button_orange);
                } else {
                    this.binding.tvDueDate.setBackgroundResource(C2723R.C2724color.bdt_white);
                }
                TextView textView16 = this.binding.tvDueDate;
                Intrinsics.checkExpressionValueIsNotNull(textView16, "binding.tvDueDate");
                textView16.setText(dueDateInfo.getSecond());
            } else {
                TextView textView17 = this.binding.tvDueDate;
                Intrinsics.checkExpressionValueIsNotNull(textView17, "binding.tvDueDate");
                textView17.setVisibility(8);
            }
            if (paymentDue.getEnableRow()) {
                ImageView imageView3 = this.binding.rowItemRadioBtn;
                Intrinsics.checkExpressionValueIsNotNull(imageView3, "binding.rowItemRadioBtn");
                imageView3.setVisibility(0);
            } else {
                ImageView imageView4 = this.binding.rowItemRadioBtn;
                Intrinsics.checkExpressionValueIsNotNull(imageView4, "binding.rowItemRadioBtn");
                imageView4.setVisibility(4);
            }
            if (paymentDue.getOAAuctionItemId() == null || ((oAAuctionItemId = paymentDue.getOAAuctionItemId()) != null && oAAuctionItemId.intValue() == -1)) {
                ImageView imageView5 = this.binding.ivArrowRight;
                Intrinsics.checkExpressionValueIsNotNull(imageView5, "binding.ivArrowRight");
                imageView5.setVisibility(8);
                ConstraintLayout constraintLayout2 = this.binding.clToBePaidContainer;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clToBePaidContainer");
                constraintLayout2.setClickable(false);
            } else {
                ImageView imageView6 = this.binding.ivArrowRight;
                Intrinsics.checkExpressionValueIsNotNull(imageView6, "binding.ivArrowRight");
                imageView6.setVisibility(0);
                ConstraintLayout constraintLayout3 = this.binding.clToBePaidContainer;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.clToBePaidContainer");
                constraintLayout3.setClickable(true);
            }
            this.binding.tvReviewFees.setOnClickListener(new SelectVehiclesAdapter$ToBePaidItemViewHolder$bindTo$2(this, i));
            this.binding.ivTotalDueArrow.setOnClickListener(new SelectVehiclesAdapter$ToBePaidItemViewHolder$bindTo$3(this, i));
            this.binding.rowItemRadioBtn.setOnClickListener(new SelectVehiclesAdapter$ToBePaidItemViewHolder$bindTo$4(this, i));
        }

        private final void createFeeLayout(List<VehicleFees> list) {
            this.binding.llFeeCreditCardLayout.removeAllViews();
            if (list != null) {
                for (VehicleFees vehicleFees : list) {
                    View inflate = LayoutInflater.from(this.this$0.getMContext()).inflate(C2723R.C2728layout.row_cc_fee_layout, (ViewGroup) null, false);
                    TextView textView = (TextView) inflate.findViewById(C2723R.C2726id.tvFeeLabel);
                    TextView textView2 = (TextView) inflate.findViewById(C2723R.C2726id.tvFeeValue);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tvLabel");
                    textView.setText(vehicleFees.getDisplayText());
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "tvValue");
                    textView2.setText(UiUtils.formatCurrencyFromString(String.valueOf(vehicleFees.getAmount()), true));
                    this.binding.llFeeCreditCardLayout.addView(inflate);
                }
            }
        }
    }
}
