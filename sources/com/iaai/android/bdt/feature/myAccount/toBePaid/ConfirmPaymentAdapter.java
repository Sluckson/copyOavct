package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.databinding.ItemToPaidConfirmBinding;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0014\u0010\u001e\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006#"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ConfirmPaymentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isViewAllSelected", "", "()Z", "setViewAllSelected", "(Z)V", "getMContext", "()Landroid/content/Context;", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "getSelectedItemsList", "()Ljava/util/List;", "setSelectedItemsList", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemsList", "results", "shouldDisplayAll", "isViewAll", "ToBePaidItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ConfirmPaymentAdapter.kt */
public final class ConfirmPaymentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean isViewAllSelected;
    @NotNull
    private final Context mContext;
    @Nullable
    private List<PaymentDue> selectedItemsList;

    public ConfirmPaymentAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        this.mContext = context;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final List<PaymentDue> getSelectedItemsList() {
        return this.selectedItemsList;
    }

    public final void setSelectedItemsList(@Nullable List<PaymentDue> list) {
        this.selectedItemsList = list;
    }

    public final boolean isViewAllSelected() {
        return this.isViewAllSelected;
    }

    public final void setViewAllSelected(boolean z) {
        this.isViewAllSelected = z;
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ItemToPaidConfirmBinding inflate = ItemToPaidConfirmBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemToPaidConfirmBinding…tInflater, parent, false)");
        return new ToBePaidItemViewHolder(this, inflate);
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        List<PaymentDue> list;
        PaymentDue paymentDue;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if ((viewHolder instanceof ToBePaidItemViewHolder) && (list = this.selectedItemsList) != null && (paymentDue = list.get(i)) != null) {
            ((ToBePaidItemViewHolder) viewHolder).bindTo(paymentDue);
        }
    }

    public final void setItemsList(@NotNull List<PaymentDue> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.selectedItemsList = list;
    }

    public final void shouldDisplayAll(boolean z) {
        this.isViewAllSelected = z;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<PaymentDue> list = this.selectedItemsList;
        if ((list != null ? list.size() : 0) <= 5) {
            List<PaymentDue> list2 = this.selectedItemsList;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            return list2.size();
        } else if (!this.isViewAllSelected) {
            return 5;
        } else {
            List<PaymentDue> list3 = this.selectedItemsList;
            if (list3 == null) {
                Intrinsics.throwNpe();
            }
            return list3.size();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ConfirmPaymentAdapter$ToBePaidItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemToPaidConfirmBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ConfirmPaymentAdapter;Lcom/iaai/android/databinding/ItemToPaidConfirmBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemToPaidConfirmBinding;", "bindTo", "", "tobePaid", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ConfirmPaymentAdapter.kt */
    public final class ToBePaidItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final ItemToPaidConfirmBinding binding;
        final /* synthetic */ ConfirmPaymentAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToBePaidItemViewHolder(@NotNull ConfirmPaymentAdapter confirmPaymentAdapter, ItemToPaidConfirmBinding itemToPaidConfirmBinding) {
            super(itemToPaidConfirmBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemToPaidConfirmBinding, "binding");
            this.this$0 = confirmPaymentAdapter;
            this.binding = itemToPaidConfirmBinding;
        }

        @NotNull
        public final ItemToPaidConfirmBinding getBinding() {
            return this.binding;
        }

        public final void bindTo(@NotNull PaymentDue paymentDue) {
            Intrinsics.checkParameterIsNotNull(paymentDue, "tobePaid");
            TextView textView = this.binding.tvConfirmYearMakeModel;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvConfirmYearMakeModel");
            textView.setText(paymentDue.getDescription());
            TextView textView2 = this.binding.tvConfirmAmount;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvConfirmAmount");
            textView2.setText(UiUtils.formatCurrencyFromString(String.valueOf(paymentDue.getTotalDue()), true));
        }
    }
}
