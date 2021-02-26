package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.databinding.RowItemPopularCategoryLayoutBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u0014J\u001a\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0016\u001a\u00020\rH\u0002R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter$PopularCategoriesItemClickListener;", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setQuickLinksData", "updateListOnSelectItem", "facet", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "PopularCategoriesItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PopularCategoriesAdapter.kt */
public final class PopularCategoriesAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private Context mContext;
    private PopularCategoriesItemClickListener onItemClickListener;
    private int selectedPosition;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter$PopularCategoriesItemClickListener;", "", "onPopularCategoriesItemClick", "", "clickedItem", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "isSelect", "", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PopularCategoriesAdapter.kt */
    public interface PopularCategoriesItemClickListener {
        void onPopularCategoriesItemClick(@Nullable FacetXX facetXX, boolean z, int i);
    }

    public PopularCategoriesAdapter(@NotNull Context context) {
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

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        List list = BDTUtils.INSTANCE.getExpandableListDetailPC().get(BDTUtils.INSTANCE.getSearchMappingArray().get(2).getGroups().get(0));
        FacetXX facetXX = list != null ? (FacetXX) list.get(i) : null;
        viewHolder.bindFilterInfo(facetXX);
        viewHolder.itemView.setOnClickListener(new PopularCategoriesAdapter$onBindViewHolder$1(this, facetXX, i));
    }

    /* access modifiers changed from: private */
    public final void updateListOnSelectItem(FacetXX facetXX, int i) {
        PopularCategoriesItemClickListener popularCategoriesItemClickListener = this.onItemClickListener;
        if (popularCategoriesItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        popularCategoriesItemClickListener.onPopularCategoriesItemClick(facetXX, facetXX != null ? facetXX.isSelected() : true, i);
    }

    public final void setQuickLinksData() {
        BDTUtils.INSTANCE.getFilterPopularCategories();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_popular_category_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemPopularCategoryLayoutBinding) inflate);
    }

    public final void setClickListener(@NotNull PopularCategoriesItemClickListener popularCategoriesItemClickListener) {
        Intrinsics.checkParameterIsNotNull(popularCategoriesItemClickListener, "onItemClickListener");
        this.onItemClickListener = popularCategoriesItemClickListener;
    }

    public int getItemCount() {
        List list = BDTUtils.INSTANCE.getExpandableListDetailPC().get(BDTUtils.INSTANCE.getSearchMappingArray().get(2).getGroups().get(0));
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter;Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;)V", "bindFilterInfo", "", "facet", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PopularCategoriesAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemPopularCategoryLayoutBinding binding;
        final /* synthetic */ PopularCategoriesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull PopularCategoriesAdapter popularCategoriesAdapter, RowItemPopularCategoryLayoutBinding rowItemPopularCategoryLayoutBinding) {
            super(rowItemPopularCategoryLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemPopularCategoryLayoutBinding, "binding");
            this.this$0 = popularCategoriesAdapter;
            this.binding = rowItemPopularCategoryLayoutBinding;
        }

        @NotNull
        public final RowItemPopularCategoryLayoutBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemPopularCategoryLayoutBinding rowItemPopularCategoryLayoutBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemPopularCategoryLayoutBinding, "<set-?>");
            this.binding = rowItemPopularCategoryLayoutBinding;
        }

        public final void bindFilterInfo(@Nullable FacetXX facetXX) {
            TextView textView = this.binding.tvPopularCategory;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvPopularCategory");
            textView.setText(facetXX != null ? facetXX.getValue() : null);
            LinearLayout linearLayout = this.binding.llPopularCategory;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llPopularCategory");
            linearLayout.setSelected(facetXX != null ? facetXX.isSelected() : false);
        }
    }
}
