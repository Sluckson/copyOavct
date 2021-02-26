package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.saleDocument.RowModelForSetSaleDoc;
import com.iaai.android.databinding.RowItemLayoutLevel0Binding;
import com.iaai.android.databinding.RowItemLayoutLevel1SetBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0014\u0010\u001a\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SetSaleDocAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "rowModels", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "getAddress", "", "rowInfo", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "p1", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "BranchViewHolder", "StockViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SetSaleDocAdapter.kt */
public final class SetSaleDocAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private final Context context;
    private List<RowModelForSetSaleDoc> rowModels = new ArrayList();

    public SetSaleDocAdapter(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SetSaleDocAdapter$BranchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SetSaleDocAdapter;Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemLayoutLevel0Binding;)V", "bindInfo", "", "rowInfo", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SetSaleDocAdapter.kt */
    public final class BranchViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemLayoutLevel0Binding binding;
        final /* synthetic */ SetSaleDocAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BranchViewHolder(@NotNull SetSaleDocAdapter setSaleDocAdapter, RowItemLayoutLevel0Binding rowItemLayoutLevel0Binding) {
            super(rowItemLayoutLevel0Binding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemLayoutLevel0Binding, "binding");
            this.this$0 = setSaleDocAdapter;
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
            textView2.setVisibility(0);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SetSaleDocAdapter$StockViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemLayoutLevel1SetBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SetSaleDocAdapter;Lcom/iaai/android/databinding/RowItemLayoutLevel1SetBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemLayoutLevel1SetBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemLayoutLevel1SetBinding;)V", "bindInfo", "", "rowInfo", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SetSaleDocAdapter.kt */
    public final class StockViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemLayoutLevel1SetBinding binding;
        final /* synthetic */ SetSaleDocAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StockViewHolder(@NotNull SetSaleDocAdapter setSaleDocAdapter, RowItemLayoutLevel1SetBinding rowItemLayoutLevel1SetBinding) {
            super(rowItemLayoutLevel1SetBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemLayoutLevel1SetBinding, "binding");
            this.this$0 = setSaleDocAdapter;
            this.binding = rowItemLayoutLevel1SetBinding;
        }

        @NotNull
        public final RowItemLayoutLevel1SetBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemLayoutLevel1SetBinding rowItemLayoutLevel1SetBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemLayoutLevel1SetBinding, "<set-?>");
            this.binding = rowItemLayoutLevel1SetBinding;
        }

        public final void bindInfo(@NotNull RowModelForSetSaleDoc rowModelForSetSaleDoc) {
            Intrinsics.checkParameterIsNotNull(rowModelForSetSaleDoc, "rowInfo");
            TextView textView = this.binding.tvMakeModel;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvMakeModel");
            textView.setText(rowModelForSetSaleDoc.getStock().getVehicleDescription());
            TextView textView2 = this.binding.tvStockNo;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvStockNo");
            textView2.setText(rowModelForSetSaleDoc.getStock().getStockNumber());
            String titleDeliveryMethodCode = rowModelForSetSaleDoc.getStock().getTitleDeliveryMethodCode();
            if (titleDeliveryMethodCode != null) {
                switch (titleDeliveryMethodCode.hashCode()) {
                    case 65661:
                        if (titleDeliveryMethodCode.equals("BFA")) {
                            TextView textView3 = this.binding.tvAddress;
                            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvAddress");
                            textView3.setVisibility(0);
                            TextView textView4 = this.binding.tvPickUpBy;
                            Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvPickUpBy");
                            textView4.setVisibility(8);
                            TextView textView5 = this.binding.tvPickUpRole;
                            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvPickUpRole");
                            textView5.setVisibility(8);
                            TextView textView6 = this.binding.tvMode;
                            Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvMode");
                            textView6.setText(this.this$0.getContext().getResources().getString(C2723R.string.lbl_my_fed_ex_account));
                            TextView textView7 = this.binding.tvAddress;
                            Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvAddress");
                            textView7.setText(this.this$0.getAddress(rowModelForSetSaleDoc));
                            return;
                        }
                        return;
                    case 72388:
                        if (titleDeliveryMethodCode.equals("IFA")) {
                            TextView textView8 = this.binding.tvAddress;
                            Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvAddress");
                            textView8.setVisibility(0);
                            TextView textView9 = this.binding.tvPickUpBy;
                            Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvPickUpBy");
                            textView9.setVisibility(8);
                            TextView textView10 = this.binding.tvPickUpRole;
                            Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvPickUpRole");
                            textView10.setVisibility(8);
                            TextView textView11 = this.binding.tvMode;
                            Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvMode");
                            textView11.setText(this.this$0.getContext().getResources().getString(C2723R.string.lbl_iaa_fed_ex_account));
                            TextView textView12 = this.binding.tvAddress;
                            Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvAddress");
                            textView12.setText(this.this$0.getAddress(rowModelForSetSaleDoc));
                            return;
                        }
                        return;
                    case 78484:
                        if (titleDeliveryMethodCode.equals("OPU")) {
                            TextView textView13 = this.binding.tvAddress;
                            Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.tvAddress");
                            textView13.setVisibility(8);
                            TextView textView14 = this.binding.tvPickUpBy;
                            Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.tvPickUpBy");
                            textView14.setVisibility(0);
                            TextView textView15 = this.binding.tvPickUpRole;
                            Intrinsics.checkExpressionValueIsNotNull(textView15, "binding.tvPickUpRole");
                            textView15.setVisibility(0);
                            TextView textView16 = this.binding.tvMode;
                            Intrinsics.checkExpressionValueIsNotNull(textView16, "binding.tvMode");
                            textView16.setText(this.this$0.getContext().getResources().getString(C2723R.string.lbl_sale_doc_pick_up));
                            TextView textView17 = this.binding.tvPickUpBy;
                            Intrinsics.checkExpressionValueIsNotNull(textView17, "binding.tvPickUpBy");
                            textView17.setText(rowModelForSetSaleDoc.getStock().getOwnerName());
                            TextView textView18 = this.binding.tvPickUpRole;
                            Intrinsics.checkExpressionValueIsNotNull(textView18, "binding.tvPickUpRole");
                            textView18.setText(this.this$0.getContext().getResources().getString(C2723R.string.lbl_sale_doc_owner));
                            return;
                        }
                        return;
                    case 81367:
                        if (titleDeliveryMethodCode.equals("RPU")) {
                            TextView textView19 = this.binding.tvAddress;
                            Intrinsics.checkExpressionValueIsNotNull(textView19, "binding.tvAddress");
                            textView19.setVisibility(8);
                            TextView textView20 = this.binding.tvPickUpBy;
                            Intrinsics.checkExpressionValueIsNotNull(textView20, "binding.tvPickUpBy");
                            textView20.setVisibility(0);
                            TextView textView21 = this.binding.tvPickUpRole;
                            Intrinsics.checkExpressionValueIsNotNull(textView21, "binding.tvPickUpRole");
                            textView21.setVisibility(0);
                            TextView textView22 = this.binding.tvMode;
                            Intrinsics.checkExpressionValueIsNotNull(textView22, "binding.tvMode");
                            textView22.setText(this.this$0.getContext().getResources().getString(C2723R.string.lbl_sale_doc_pick_up));
                            TextView textView23 = this.binding.tvPickUpBy;
                            Intrinsics.checkExpressionValueIsNotNull(textView23, "binding.tvPickUpBy");
                            textView23.setText(rowModelForSetSaleDoc.getStock().getRepresentativeName());
                            TextView textView24 = this.binding.tvPickUpRole;
                            Intrinsics.checkExpressionValueIsNotNull(textView24, "binding.tvPickUpRole");
                            textView24.setText(this.this$0.getContext().getResources().getString(C2723R.string.lbl_sale_doc_representative));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
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
            RowItemLayoutLevel1SetBinding inflate3 = RowItemLayoutLevel1SetBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "RowItemLayoutLevel1SetBi…tInflater, parent, false)");
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

    /* access modifiers changed from: private */
    public final String getAddress(RowModelForSetSaleDoc rowModelForSetSaleDoc) {
        CharSequence address1 = rowModelForSetSaleDoc.getStock().getAddress1();
        boolean z = false;
        String str = "";
        if (!(address1 == null || address1.length() == 0)) {
            str = str + rowModelForSetSaleDoc.getStock().getAddress1();
        }
        CharSequence address2 = rowModelForSetSaleDoc.getStock().getAddress2();
        if (!(address2 == null || address2.length() == 0)) {
            str = str + rowModelForSetSaleDoc.getStock().getAddress2();
        }
        CharSequence city = rowModelForSetSaleDoc.getStock().getCity();
        if (!(city == null || city.length() == 0)) {
            str = str + "\n" + rowModelForSetSaleDoc.getStock().getCity();
        }
        CharSequence state = rowModelForSetSaleDoc.getStock().getState();
        if (!(state == null || state.length() == 0)) {
            str = str + ", " + rowModelForSetSaleDoc.getStock().getState();
        }
        CharSequence zipCode = rowModelForSetSaleDoc.getStock().getZipCode();
        if (zipCode == null || zipCode.length() == 0) {
            z = true;
        }
        if (z) {
            return str;
        }
        return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + rowModelForSetSaleDoc.getStock().getZipCode();
    }
}
