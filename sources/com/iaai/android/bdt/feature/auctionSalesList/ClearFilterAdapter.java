package com.iaai.android.bdt.feature.auctionSalesList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.auctionSalesList.ClearFilter;
import com.iaai.android.databinding.RowItemClearfilterLayoutBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u001b\u001a\u00020\u00132\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tR\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearFilterList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/auctionSalesList/ClearFilter;", "Lkotlin/collections/ArrayList;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter$OnItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setclearFilterList", "results", "OnItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ClearFilterAdapter.kt */
public final class ClearFilterAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<ClearFilter> clearFilterList = new ArrayList<>();
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter$OnItemClickListener;", "", "onFilterLaneCancelClick", "", "onFilterLossTypeCancelClick", "onFilterYearCancelClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ClearFilterAdapter.kt */
    public interface OnItemClickListener {
        void onFilterLaneCancelClick();

        void onFilterLossTypeCancelClick();

        void onFilterYearCancelClick();
    }

    public ClearFilterAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(ClearFilterAdapter clearFilterAdapter) {
        OnItemClickListener onItemClickListener2 = clearFilterAdapter.onItemClickListener;
        if (onItemClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        return onItemClickListener2;
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
        ArrayList<ClearFilter> arrayList = this.clearFilterList;
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        ClearFilter clearFilter = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(clearFilter, "clearFilterList!![position]");
        viewHolder.bindLaneInfo(clearFilter);
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public final void setclearFilterList(@Nullable ArrayList<ClearFilter> arrayList) {
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        this.clearFilterList = arrayList;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_clearfilter_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemClearfilterLayoutBinding) inflate);
    }

    public int getItemCount() {
        if (this.clearFilterList.isEmpty()) {
            return 0;
        }
        ArrayList<ClearFilter> arrayList = this.clearFilterList;
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        return arrayList.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter;Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;)V", "bindLaneInfo", "", "clearFilter", "Lcom/iaai/android/bdt/model/auctionSalesList/ClearFilter;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ClearFilterAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemClearfilterLayoutBinding binding;
        final /* synthetic */ ClearFilterAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ClearFilterAdapter clearFilterAdapter, RowItemClearfilterLayoutBinding rowItemClearfilterLayoutBinding) {
            super(rowItemClearfilterLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemClearfilterLayoutBinding, "binding");
            this.this$0 = clearFilterAdapter;
            this.binding = rowItemClearfilterLayoutBinding;
        }

        @NotNull
        public final RowItemClearfilterLayoutBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemClearfilterLayoutBinding rowItemClearfilterLayoutBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemClearfilterLayoutBinding, "<set-?>");
            this.binding = rowItemClearfilterLayoutBinding;
        }

        public final void bindLaneInfo(@NotNull ClearFilter clearFilter) {
            Intrinsics.checkParameterIsNotNull(clearFilter, "clearFilter");
            TextView textView = this.binding.tvClearfilter;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvClearfilter");
            textView.setText(clearFilter.getFilterName());
            this.binding.layoutClearfilterContainer.setOnClickListener(new ClearFilterAdapter$ViewHolder$bindLaneInfo$1(this));
        }
    }
}
