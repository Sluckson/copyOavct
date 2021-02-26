package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.MyAccount.BranchModel;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.RowItemManageBranchPrefHeaderBinding;
import com.iaai.android.databinding.RowListItemManageBranchPrefBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0003789B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0016J\u001c\u0010)\u001a\u00020*2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010(\u001a\u00020\tH\u0016J\u001c\u0010,\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\tH\u0016J\"\u00100\u001a\u00020*2\u001a\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001cJ\"\u00102\u001a\u00020*2\u001a\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001cJ\u000e\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\u0015J\u000e\u00106\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010%¨\u0006:"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter$BaseViewHolder;", "context", "Landroid/content/Context;", "branchPrefClickListener", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/BranchPrefClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/BranchPrefClickListener;)V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "auctionSalesListHeader", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "getAuctionSalesListHeader", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "setAuctionSalesListHeader", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;)V", "isFromDeliveryMethod", "", "()Z", "setFromDeliveryMethod", "(Z)V", "mBranchList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "Lkotlin/collections/ArrayList;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "selectedPosition", "getSelectedPosition", "setSelectedPosition", "(I)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBranchFilterData", "filteredList", "setBranchListData", "results", "setBranchSearchField", "isFromDelivery", "setHeaderItem", "BaseViewHolder", "ViewHolder", "ViewHolderHeader", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchListAdapter.kt */
public final class ManageBranchListAdapter extends RecyclerView.Adapter<BaseViewHolder<?>> {
    private final int TYPE_HEADER;
    private final int TYPE_ITEM = 1;
    @NotNull
    public AuctionSalesListHeader auctionSalesListHeader;
    /* access modifiers changed from: private */
    public final BranchPrefClickListener branchPrefClickListener;
    private boolean isFromDeliveryMethod;
    /* access modifiers changed from: private */
    public ArrayList<BranchModel> mBranchList;
    @NotNull
    private Context mContext;
    private int selectedPosition;

    public ManageBranchListAdapter(@NotNull Context context, @NotNull BranchPrefClickListener branchPrefClickListener2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(branchPrefClickListener2, "branchPrefClickListener");
        this.branchPrefClickListener = branchPrefClickListener2;
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

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    public final int getTYPE_HEADER() {
        return this.TYPE_HEADER;
    }

    public final int getTYPE_ITEM() {
        return this.TYPE_ITEM;
    }

    public final boolean isFromDeliveryMethod() {
        return this.isFromDeliveryMethod;
    }

    public final void setFromDeliveryMethod(boolean z) {
        this.isFromDeliveryMethod = z;
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

    public void onBindViewHolder(@NotNull BaseViewHolder<?> baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        int itemViewType = getItemViewType(i);
        if (itemViewType == this.TYPE_HEADER) {
            baseViewHolder.bindHeader();
        } else if (itemViewType == this.TYPE_ITEM) {
            ArrayList<BranchModel> arrayList = this.mBranchList;
            if (arrayList == null) {
                Intrinsics.throwNpe();
            }
            BranchModel branchModel = arrayList.get(i - 1);
            Intrinsics.checkExpressionValueIsNotNull(branchModel, "mBranchList!![position - 1]");
            baseViewHolder.bind(branchModel, i);
        }
    }

    public final void setBranchListData(@Nullable ArrayList<BranchModel> arrayList) {
        this.mBranchList = arrayList;
        notifyDataSetChanged();
    }

    public final void setBranchSearchField(boolean z) {
        this.isFromDeliveryMethod = z;
        notifyItemChanged(0);
    }

    public final void setBranchFilterData(@Nullable ArrayList<BranchModel> arrayList) {
        this.mBranchList = arrayList;
        notifyDataSetChanged();
    }

    public int getItemViewType(int i) {
        return i == 0 ? this.TYPE_HEADER : this.TYPE_ITEM;
    }

    @NotNull
    public BaseViewHolder<?> onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == this.TYPE_HEADER) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_manage_branch_pref_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…ef_header, parent, false)");
            return new ViewHolderHeader(this, (RowItemManageBranchPrefHeaderBinding) inflate);
        } else if (i == this.TYPE_ITEM) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_list_item_manage_branch_pref, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…anch_pref, parent, false)");
            return new ViewHolder(this, (RowListItemManageBranchPrefBinding) inflate2);
        } else {
            throw new IllegalArgumentException("Invalid view type");
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
        ArrayList<BranchModel> arrayList = this.mBranchList;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        return 1 + arrayList.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter$BaseViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "position", "", "bindHeader", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageBranchListAdapter.kt */
    public static abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        public abstract void bind(@NotNull BranchModel branchModel, int i);

        public abstract void bindHeader();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter$ViewHolder;", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "binding", "Lcom/iaai/android/databinding/RowListItemManageBranchPrefBinding;", "(Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter;Lcom/iaai/android/databinding/RowListItemManageBranchPrefBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowListItemManageBranchPrefBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowListItemManageBranchPrefBinding;)V", "bind", "", "branchList", "position", "", "bindHeader", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageBranchListAdapter.kt */
    public final class ViewHolder extends BaseViewHolder<BranchModel> {
        @NotNull
        private RowListItemManageBranchPrefBinding binding;
        final /* synthetic */ ManageBranchListAdapter this$0;

        public void bindHeader() {
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolder(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter r2, com.iaai.android.databinding.RowListItemManageBranchPrefBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
                r1.this$0 = r2
                android.view.View r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)
                r1.<init>(r2)
                r1.binding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter.ViewHolder.<init>(com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter, com.iaai.android.databinding.RowListItemManageBranchPrefBinding):void");
        }

        @NotNull
        public final RowListItemManageBranchPrefBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowListItemManageBranchPrefBinding rowListItemManageBranchPrefBinding) {
            Intrinsics.checkParameterIsNotNull(rowListItemManageBranchPrefBinding, "<set-?>");
            this.binding = rowListItemManageBranchPrefBinding;
        }

        public void bind(@NotNull BranchModel branchModel, int i) {
            Intrinsics.checkParameterIsNotNull(branchModel, "branchList");
            TextView textView = this.binding.branchTitle;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.branchTitle");
            String branchName = branchModel.getBranchName();
            textView.setText(Intrinsics.stringPlus(branchName, " (" + branchModel.getAssignedToState() + ')'));
            if (StringsKt.equals(branchModel.getAssignedToCode(), Constants_MVVM.BranchAssignCode.OPU.getValue(), true)) {
                TextView textView2 = this.binding.branchSubTitle;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.branchSubTitle");
                textView2.setText(branchModel.getAssignedToName() + ' ' + this.this$0.getMContext().getResources().getString(C2723R.string.lbl_sale_doc_owner));
            } else if (StringsKt.equals(branchModel.getAssignedToCode(), Constants_MVVM.BranchAssignCode.RPU.getValue(), true)) {
                TextView textView3 = this.binding.branchSubTitle;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.branchSubTitle");
                textView3.setText(branchModel.getAssignedToName() + ' ' + this.this$0.getMContext().getResources().getString(C2723R.string.lbl_sale_doc_representative));
            } else if (StringsKt.equals(branchModel.getAssignedToCode(), Constants_MVVM.BranchAssignCode.IFA.getValue(), true)) {
                TextView textView4 = this.binding.branchSubTitle;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.branchSubTitle");
                textView4.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_iaa_fed_ex_account));
            } else if (StringsKt.equals(branchModel.getAssignedToCode(), Constants_MVVM.BranchAssignCode.BFA.getValue(), true)) {
                TextView textView5 = this.binding.branchSubTitle;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.branchSubTitle");
                textView5.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_my_fed_ex_account));
            } else if (StringsKt.equals$default(branchModel.getAssignedToCode(), "", false, 2, (Object) null)) {
                TextView textView6 = this.binding.branchSubTitle;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.branchSubTitle");
                textView6.setText("");
            }
            ImageView imageView = this.binding.rowItemRadioBtn;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.rowItemRadioBtn");
            imageView.setSelected(branchModel.isSelected());
            this.binding.rowItemRadioBtn.setOnClickListener(new ManageBranchListAdapter$ViewHolder$bind$1(this, i));
        }
    }

    public final void setHeaderItem(@NotNull AuctionSalesListHeader auctionSalesListHeader2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "auctionSalesListHeader");
        this.auctionSalesListHeader = auctionSalesListHeader2;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter$ViewHolderHeader;", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "binding", "Lcom/iaai/android/databinding/RowItemManageBranchPrefHeaderBinding;", "(Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter;Lcom/iaai/android/databinding/RowItemManageBranchPrefHeaderBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemManageBranchPrefHeaderBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemManageBranchPrefHeaderBinding;)V", "bind", "", "item", "position", "", "bindHeader", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageBranchListAdapter.kt */
    public final class ViewHolderHeader extends BaseViewHolder<BranchModel> {
        @NotNull
        private RowItemManageBranchPrefHeaderBinding binding;
        final /* synthetic */ ManageBranchListAdapter this$0;

        public void bind(@NotNull BranchModel branchModel, int i) {
            Intrinsics.checkParameterIsNotNull(branchModel, "item");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolderHeader(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter r2, com.iaai.android.databinding.RowItemManageBranchPrefHeaderBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
                r1.this$0 = r2
                android.view.View r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)
                r1.<init>(r2)
                r1.binding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter.ViewHolderHeader.<init>(com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter, com.iaai.android.databinding.RowItemManageBranchPrefHeaderBinding):void");
        }

        @NotNull
        public final RowItemManageBranchPrefHeaderBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemManageBranchPrefHeaderBinding rowItemManageBranchPrefHeaderBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemManageBranchPrefHeaderBinding, "<set-?>");
            this.binding = rowItemManageBranchPrefHeaderBinding;
        }

        public void bindHeader() {
            if (this.this$0.getAuctionSalesListHeader().isError()) {
                View view = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.emptyView");
                TextView textView = (TextView) view.findViewById(C2723R.C2726id.errorTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.emptyView.errorTitle");
                textView.setText(this.this$0.getAuctionSalesListHeader().getErrorType().getValue());
                View view2 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "binding.emptyView");
                TextView textView2 = (TextView) view2.findViewById(C2723R.C2726id.errorBody);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.emptyView.errorBody");
                textView2.setText(this.this$0.getAuctionSalesListHeader().getErrorMessage());
                ConstraintLayout constraintLayout = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clEmptyView");
                constraintLayout.setVisibility(0);
            } else {
                ConstraintLayout constraintLayout2 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clEmptyView");
                constraintLayout2.setVisibility(8);
            }
            if (this.this$0.isFromDeliveryMethod()) {
                this.binding.etBranchSearch.setText("");
                this.this$0.setFromDeliveryMethod(false);
                EditText editText = this.binding.etBranchSearch;
                Intrinsics.checkExpressionValueIsNotNull(editText, "binding.etBranchSearch");
                editText.getText().clear();
                ImageView imageView = this.binding.ivBranchClear;
                Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivBranchClear");
                imageView.setVisibility(8);
                EditText editText2 = this.binding.etBranchSearch;
                Intrinsics.checkExpressionValueIsNotNull(editText2, "binding.etBranchSearch");
                editText2.setHint(this.this$0.getMContext().getString(C2723R.string.lbl_select_branch_search_hint));
            } else {
                this.binding.etBranchSearch.addTextChangedListener(new ManageBranchListAdapter$ViewHolderHeader$bindHeader$1(this));
            }
            this.binding.ivBranchClear.setOnClickListener(new ManageBranchListAdapter$ViewHolderHeader$bindHeader$2(this));
        }
    }
}
