package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.VehicleFees;
import com.iaai.android.databinding.ItemFooterToBePaidReviewBinding;
import com.iaai.android.databinding.ItemToPaidReviewBinding;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004 !\"#B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0014\u0010\u001e\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006$"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "onClickListener", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$OnClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$OnClickListener;)V", "getMContext", "()Landroid/content/Context;", "getOnClickListener", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$OnClickListener;", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "getSelectedItemsList", "()Ljava/util/List;", "setSelectedItemsList", "(Ljava/util/List;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemsList", "results", "Companion", "OnClickListener", "ToBePaidFooterViewHolder", "ToBePaidItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ReviewPaymentAdapter.kt */
public final class ReviewPaymentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_ITEM = 1;
    @NotNull
    private final Context mContext;
    @NotNull
    private final OnClickListener onClickListener;
    @Nullable
    private List<PaymentDue> selectedItemsList;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$OnClickListener;", "", "onChangePaymentClicked", "", "onRemoveClicked", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ReviewPaymentAdapter.kt */
    public interface OnClickListener {
        void onChangePaymentClicked();

        void onRemoveClicked(int i);
    }

    public ReviewPaymentAdapter(@NotNull Context context, @NotNull OnClickListener onClickListener2) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(onClickListener2, "onClickListener");
        this.mContext = context;
        this.onClickListener = onClickListener2;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    @Nullable
    public final List<PaymentDue> getSelectedItemsList() {
        return this.selectedItemsList;
    }

    public final void setSelectedItemsList(@Nullable List<PaymentDue> list) {
        this.selectedItemsList = list;
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ItemToPaidReviewBinding inflate = ItemToPaidReviewBinding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemToPaidReviewBinding.…tInflater, parent, false)");
        RecyclerView.ViewHolder toBePaidItemViewHolder = new ToBePaidItemViewHolder(this, inflate);
        if (i == 1) {
            ItemToPaidReviewBinding inflate2 = ItemToPaidReviewBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "ItemToPaidReviewBinding.…tInflater, parent, false)");
            return new ToBePaidItemViewHolder(this, inflate2);
        } else if (i != 2) {
            return toBePaidItemViewHolder;
        } else {
            ItemFooterToBePaidReviewBinding inflate3 = ItemFooterToBePaidReviewBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemFooterToBePaidReview…tInflater, parent, false)");
            return new ToBePaidFooterViewHolder(this, inflate3);
        }
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        List<PaymentDue> list;
        PaymentDue paymentDue;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() > 0) {
            List<PaymentDue> list2 = this.selectedItemsList;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            if (i == list2.size()) {
                if (viewHolder instanceof ToBePaidFooterViewHolder) {
                    ((ToBePaidFooterViewHolder) viewHolder).bindTo();
                }
            } else if ((viewHolder instanceof ToBePaidItemViewHolder) && (list = this.selectedItemsList) != null && (paymentDue = list.get(i)) != null) {
                ((ToBePaidItemViewHolder) viewHolder).bindTo(paymentDue);
            }
        }
    }

    public final void setItemsList(@NotNull List<PaymentDue> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.selectedItemsList = list;
        notifyDataSetChanged();
    }

    public int getItemViewType(int i) {
        List<PaymentDue> list = this.selectedItemsList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return i == list.size() ? 2 : 1;
    }

    public int getItemCount() {
        List<PaymentDue> list = this.selectedItemsList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size() + 1;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$Companion;", "", "()V", "TYPE_FOOTER", "", "TYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ReviewPaymentAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$ToBePaidItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemToPaidReviewBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter;Lcom/iaai/android/databinding/ItemToPaidReviewBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemToPaidReviewBinding;", "bindTo", "", "tobePaid", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "createFeeLayout", "feeList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/VehicleFees;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ReviewPaymentAdapter.kt */
    public final class ToBePaidItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final ItemToPaidReviewBinding binding;
        final /* synthetic */ ReviewPaymentAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToBePaidItemViewHolder(@NotNull ReviewPaymentAdapter reviewPaymentAdapter, ItemToPaidReviewBinding itemToPaidReviewBinding) {
            super(itemToPaidReviewBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemToPaidReviewBinding, "binding");
            this.this$0 = reviewPaymentAdapter;
            this.binding = itemToPaidReviewBinding;
        }

        @NotNull
        public final ItemToPaidReviewBinding getBinding() {
            return this.binding;
        }

        public final void bindTo(@NotNull PaymentDue paymentDue) {
            Intrinsics.checkParameterIsNotNull(paymentDue, "tobePaid");
            TextView textView = this.binding.tvMakeModel;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvMakeModel");
            textView.setText(paymentDue.getDescription());
            TextView textView2 = this.binding.tvAmount;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvAmount");
            textView2.setText(UiUtils.formatCurrencyFromString(String.valueOf(paymentDue.getTotalDue()), true));
            TextView textView3 = this.binding.tvBranch;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvBranch");
            textView3.setText(paymentDue.getIAABranchName());
            TextView textView4 = this.binding.tvIndicator;
            Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvIndicator");
            textView4.setText(paymentDue.getBidWonMethod());
            createFeeLayout(paymentDue.getVehicleFees());
            this.binding.tvRemove.setOnClickListener(new ReviewPaymentAdapter$ToBePaidItemViewHolder$bindTo$1(this, paymentDue));
        }

        private final void createFeeLayout(List<VehicleFees> list) {
            this.binding.llFeeLayout.removeAllViews();
            if (list != null) {
                for (VehicleFees vehicleFees : list) {
                    View inflate = LayoutInflater.from(this.this$0.getMContext()).inflate(C2723R.C2728layout.row_fee_layout, (ViewGroup) null, false);
                    TextView textView = (TextView) inflate.findViewById(C2723R.C2726id.tvFeeLabel);
                    TextView textView2 = (TextView) inflate.findViewById(C2723R.C2726id.tvFeeValue);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tvLabel");
                    textView.setText(vehicleFees.getDisplayText());
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "tvValue");
                    textView2.setText(UiUtils.formatCurrencyFromString(String.valueOf(vehicleFees.getAmount()), true));
                    this.binding.llFeeLayout.addView(inflate);
                }
            }
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$ToBePaidFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemFooterToBePaidReviewBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter;Lcom/iaai/android/databinding/ItemFooterToBePaidReviewBinding;)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ReviewPaymentAdapter.kt */
    public final class ToBePaidFooterViewHolder extends RecyclerView.ViewHolder {
        private final ItemFooterToBePaidReviewBinding binding;
        final /* synthetic */ ReviewPaymentAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToBePaidFooterViewHolder(@NotNull ReviewPaymentAdapter reviewPaymentAdapter, ItemFooterToBePaidReviewBinding itemFooterToBePaidReviewBinding) {
            super(itemFooterToBePaidReviewBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemFooterToBePaidReviewBinding, "binding");
            this.this$0 = reviewPaymentAdapter;
            this.binding = itemFooterToBePaidReviewBinding;
        }

        public final void bindTo() {
            this.binding.tvChangePayment.setOnClickListener(new ReviewPaymentAdapter$ToBePaidFooterViewHolder$bindTo$1(this));
        }
    }
}
