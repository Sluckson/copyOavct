package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.bdt.model.toBePaid.saleDocument.RowModelForSetSaleDoc;
import com.iaai.android.databinding.RowItemLayoutLevel0Binding;
import com.iaai.android.databinding.RowItemLayoutLevel1Binding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/NotSetSaleDocAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "rowModels", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "p1", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "BranchViewHolder", "StockViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: NotSetSaleDocAdapter.kt */
public final class NotSetSaleDocAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private final Context context;
    private List<RowModelForSetSaleDoc> rowModels = new ArrayList();

    public NotSetSaleDocAdapter(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/NotSetSaleDocAdapter$BranchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/NotSetSaleDocAdapter;Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;)V", "bindInfo", "", "rowInfo", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: NotSetSaleDocAdapter.kt */
    public final class BranchViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemLayoutLevel0Binding binding;
        final /* synthetic */ NotSetSaleDocAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BranchViewHolder(@NotNull NotSetSaleDocAdapter notSetSaleDocAdapter, RowItemLayoutLevel0Binding rowItemLayoutLevel0Binding) {
            super(rowItemLayoutLevel0Binding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemLayoutLevel0Binding, "binding");
            this.this$0 = notSetSaleDocAdapter;
            this.binding = rowItemLayoutLevel0Binding;
        }

        @NotNull
        public final RowItemLayoutLevel0Binding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemLayoutLevel0Binding rowItemLayoutLevel0Binding) {
            Intrinsics.checkParameterIsNotNull(rowItemLayoutLevel0Binding, "<set-?>");
            this.binding = rowItemLayoutLevel0Binding;
        }

        public final void bindInfo(@NotNull RowModelForSetSaleDoc rowModelForSetSaleDoc) {
            Intrinsics.checkParameterIsNotNull(rowModelForSetSaleDoc, "rowInfo");
            TextView textView = this.binding.tvBranchName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvBranchName");
            textView.setText(rowModelForSetSaleDoc.getBranch());
            TextView textView2 = this.binding.tvChange;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvChange");
            textView2.setVisibility(8);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/NotSetSaleDocAdapter$StockViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemLayoutLevel1Binding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/NotSetSaleDocAdapter;Lcom/iaai/android/databinding/RowItemLayoutLevel1Binding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemLayoutLevel1Binding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemLayoutLevel1Binding;)V", "bindInfo", "", "rowInfo", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: NotSetSaleDocAdapter.kt */
    public final class StockViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemLayoutLevel1Binding binding;
        final /* synthetic */ NotSetSaleDocAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StockViewHolder(@NotNull NotSetSaleDocAdapter notSetSaleDocAdapter, RowItemLayoutLevel1Binding rowItemLayoutLevel1Binding) {
            super(rowItemLayoutLevel1Binding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemLayoutLevel1Binding, "binding");
            this.this$0 = notSetSaleDocAdapter;
            this.binding = rowItemLayoutLevel1Binding;
        }

        @NotNull
        public final RowItemLayoutLevel1Binding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemLayoutLevel1Binding rowItemLayoutLevel1Binding) {
            Intrinsics.checkParameterIsNotNull(rowItemLayoutLevel1Binding, "<set-?>");
            this.binding = rowItemLayoutLevel1Binding;
        }

        public final void bindInfo(@NotNull RowModelForSetSaleDoc rowModelForSetSaleDoc) {
            Intrinsics.checkParameterIsNotNull(rowModelForSetSaleDoc, "rowInfo");
            TextView textView = this.binding.tvMakeModel;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvMakeModel");
            textView.setText(rowModelForSetSaleDoc.getStock().getVehicleDescription());
            TextView textView2 = this.binding.tvStockNo;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvStockNo");
            textView2.setText(rowModelForSetSaleDoc.getStock().getStockNumber());
        }
    }

    public int getItemViewType(int i) {
        return this.rowModels.get(i).getType();
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        RowItemLayoutLevel0Binding inflate = RowItemLayoutLevel0Binding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "RowItemLayoutLevel0Bindi…tInflater, parent, false)");
        RecyclerView.ViewHolder branchViewHolder = new BranchViewHolder(this, inflate);
        if (i == 1) {
            RowItemLayoutLevel0Binding inflate2 = RowItemLayoutLevel0Binding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "RowItemLayoutLevel0Bindi…tInflater, parent, false)");
            return new BranchViewHolder(this, inflate2);
        } else if (i != 2) {
            return branchViewHolder;
        } else {
            RowItemLayoutLevel1Binding inflate3 = RowItemLayoutLevel1Binding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "RowItemLayoutLevel1Bindi…tInflater, parent, false)");
            return new StockViewHolder(this, inflate3);
        }
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        RowModelForSetSaleDoc rowModelForSetSaleDoc = this.rowModels.get(i);
        int type = rowModelForSetSaleDoc.getType();
        if (type == 1) {
            ((BranchViewHolder) viewHolder).bindInfo(rowModelForSetSaleDoc);
        } else if (type == 2) {
            ((StockViewHolder) viewHolder).bindInfo(rowModelForSetSaleDoc);
        }
    }

    public int getItemCount() {
        return this.rowModels.size();
    }

    public final void setData(@NotNull List<RowModelForSetSaleDoc> list) {
        Intrinsics.checkParameterIsNotNull(list, "data");
        this.rowModels = list;
    }
}
