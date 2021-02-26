package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import com.iaai.android.databinding.RowItemClearfilterLayoutBinding;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002$%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010 \u001a\u00020\u00182\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\b0\"j\b\u0012\u0004\u0012\u00020\b`#R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX.¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006&"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "Lkotlin/collections/ArrayList;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onHeaderItemClickListener", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter$OnHeaderItemClickListener;", "selected_position", "", "getSelected_position", "()I", "setSelected_position", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setHeaderListData", "results", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "OnHeaderItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: HeaderListAdapter.kt */
public final class HeaderListAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<SelectedRefinerV2> itemList;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnHeaderItemClickListener onHeaderItemClickListener;
    private int selected_position;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter$OnHeaderItemClickListener;", "", "onItemClick", "", "clickedItem", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: HeaderListAdapter.kt */
    public interface OnHeaderItemClickListener {
        void onItemClick(@NotNull SelectedRefinerV2 selectedRefinerV2, int i);
    }

    public HeaderListAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ ArrayList access$getItemList$p(HeaderListAdapter headerListAdapter) {
        ArrayList<SelectedRefinerV2> arrayList = headerListAdapter.itemList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemList");
        }
        return arrayList;
    }

    public static final /* synthetic */ OnHeaderItemClickListener access$getOnHeaderItemClickListener$p(HeaderListAdapter headerListAdapter) {
        OnHeaderItemClickListener onHeaderItemClickListener2 = headerListAdapter.onHeaderItemClickListener;
        if (onHeaderItemClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onHeaderItemClickListener");
        }
        return onHeaderItemClickListener2;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public final int getSelected_position() {
        return this.selected_position;
    }

    public final void setSelected_position(int i) {
        this.selected_position = i;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        ArrayList<SelectedRefinerV2> arrayList = this.itemList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemList");
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        SelectedRefinerV2 selectedRefinerV2 = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(selectedRefinerV2, "itemList!![position]");
        viewHolder.bindFilterInfo(selectedRefinerV2);
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        ((LinearLayout) view.findViewById(C2723R.C2726id.layout_clearfilter_container)).setOnClickListener(new HeaderListAdapter$onBindViewHolder$1(this, i));
    }

    public final void setHeaderListData(@NotNull HashSet<SelectedRefinerV2> hashSet) {
        Intrinsics.checkParameterIsNotNull(hashSet, "results");
        this.itemList = new ArrayList<>(CollectionsKt.toList(hashSet));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_clearfilter_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemClearfilterLayoutBinding) inflate);
    }

    public final void setClickListener(@NotNull OnHeaderItemClickListener onHeaderItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onHeaderItemClickListener2, "onHeaderItemClickListener");
        this.onHeaderItemClickListener = onHeaderItemClickListener2;
    }

    public int getItemCount() {
        if (this.itemList == null) {
            return 0;
        }
        ArrayList<SelectedRefinerV2> arrayList = this.itemList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemList");
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        return arrayList.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter;Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;)V", "bindFilterInfo", "", "selectedRefiner", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: HeaderListAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemClearfilterLayoutBinding binding;
        final /* synthetic */ HeaderListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull HeaderListAdapter headerListAdapter, RowItemClearfilterLayoutBinding rowItemClearfilterLayoutBinding) {
            super(rowItemClearfilterLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemClearfilterLayoutBinding, "binding");
            this.this$0 = headerListAdapter;
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

        public final void bindFilterInfo(@NotNull SelectedRefinerV2 selectedRefinerV2) {
            Intrinsics.checkParameterIsNotNull(selectedRefinerV2, "selectedRefiner");
            if (selectedRefinerV2.getQuickLink()) {
                TextView textView = this.binding.tvClearfilter;
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvClearfilter");
                textView.setText(selectedRefinerV2.getRefinerTypeValue());
                return;
            }
            TextView textView2 = this.binding.tvClearfilter;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvClearfilter");
            textView2.setText(selectedRefinerV2.getRefinerValue().get(0));
        }
    }
}
