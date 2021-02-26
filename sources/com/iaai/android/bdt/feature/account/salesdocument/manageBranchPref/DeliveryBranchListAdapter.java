package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.databinding.RowItemDeliveryBranchListBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u001e\u0010\u0017\u001a\u00020\u00102\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0019j\b\u0012\u0004\u0012\u00020\b`\u001aR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/DeliveryBranchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/DeliveryBranchListAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "branchInfoList", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBranchInfoData", "results", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryBranchListAdapter.kt */
public final class DeliveryBranchListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<TitleInstructionItem> branchInfoList;
    @NotNull
    private Context mContext;

    public DeliveryBranchListAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        List<TitleInstructionItem> list = this.branchInfoList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        viewHolder.bindVinInfo(list.get(i), i);
    }

    public final void setBranchInfoData(@NotNull ArrayList<TitleInstructionItem> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "results");
        this.branchInfoList = arrayList;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_delivery_branch_list, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemDeliveryBranchListBinding) inflate);
    }

    public int getItemCount() {
        List<TitleInstructionItem> list = this.branchInfoList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/DeliveryBranchListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemDeliveryBranchListBinding;", "(Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/DeliveryBranchListAdapter;Lcom/iaai/android/databinding/RowItemDeliveryBranchListBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemDeliveryBranchListBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemDeliveryBranchListBinding;)V", "bindVinInfo", "", "titleInstructionItem", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: DeliveryBranchListAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemDeliveryBranchListBinding binding;
        final /* synthetic */ DeliveryBranchListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull DeliveryBranchListAdapter deliveryBranchListAdapter, RowItemDeliveryBranchListBinding rowItemDeliveryBranchListBinding) {
            super(rowItemDeliveryBranchListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemDeliveryBranchListBinding, "binding");
            this.this$0 = deliveryBranchListAdapter;
            this.binding = rowItemDeliveryBranchListBinding;
        }

        @NotNull
        public final RowItemDeliveryBranchListBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemDeliveryBranchListBinding rowItemDeliveryBranchListBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemDeliveryBranchListBinding, "<set-?>");
            this.binding = rowItemDeliveryBranchListBinding;
        }

        public final void bindVinInfo(@NotNull TitleInstructionItem titleInstructionItem, int i) {
            Intrinsics.checkParameterIsNotNull(titleInstructionItem, "titleInstructionItem");
            TextView textView = this.binding.branchName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.branchName");
            textView.setText(titleInstructionItem.getBranchName() + " (" + titleInstructionItem.getState() + ')');
        }
    }
}
