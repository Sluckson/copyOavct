package com.iaai.android.bdt.feature.findVehiclePage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.fastSearch.RefinerX;
import com.iaai.android.databinding.RowItemPopularCategoryLayoutBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002()B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u000fJ\u001e\u0010&\u001a\u00020\u00182\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tR\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX.¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006*"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearch/RefinerX;", "Lkotlin/collections/ArrayList;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter$OnPopularCategoryItemClickListener;", "selected_position", "", "getSelected_position", "()I", "setSelected_position", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "popularCategorySelect", "refiner", "", "isSelect", "", "setClickListener", "onHeaderItemClickListener", "setPopularCategoryListData", "results", "OnPopularCategoryItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PopularCategoryListAdapter.kt */
public final class PopularCategoryListAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<RefinerX> itemList;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnPopularCategoryItemClickListener onItemClickListener;
    private int selected_position;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter$OnPopularCategoryItemClickListener;", "", "onPopularCategoryItemClick", "", "clickedItem", "Lcom/iaai/android/bdt/model/fastSearch/RefinerX;", "isSelect", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PopularCategoryListAdapter.kt */
    public interface OnPopularCategoryItemClickListener {
        void onPopularCategoryItemClick(@NotNull RefinerX refinerX, boolean z);
    }

    public PopularCategoryListAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ ArrayList access$getItemList$p(PopularCategoryListAdapter popularCategoryListAdapter) {
        ArrayList<RefinerX> arrayList = popularCategoryListAdapter.itemList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemList");
        }
        return arrayList;
    }

    public static final /* synthetic */ OnPopularCategoryItemClickListener access$getOnItemClickListener$p(PopularCategoryListAdapter popularCategoryListAdapter) {
        OnPopularCategoryItemClickListener onPopularCategoryItemClickListener = popularCategoryListAdapter.onItemClickListener;
        if (onPopularCategoryItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        return onPopularCategoryItemClickListener;
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
        ArrayList<RefinerX> arrayList = this.itemList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemList");
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        RefinerX refinerX = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(refinerX, "itemList!![position]");
        viewHolder.bindFilterInfo(refinerX);
        viewHolder.itemView.setOnClickListener(new PopularCategoryListAdapter$onBindViewHolder$1(this, i));
    }

    public final void popularCategorySelect(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "refiner");
        ArrayList<RefinerX> arrayList = this.itemList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemList");
        }
        int i = 0;
        for (RefinerX displayName : arrayList) {
            if (StringsKt.equals(str, displayName.getDisplayName(), true) || StringsKt.equals(str, "Popular Category", true)) {
                ArrayList<RefinerX> arrayList2 = this.itemList;
                if (arrayList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemList");
                }
                arrayList2.get(i).setSelect(z);
            }
            i++;
        }
        notifyDataSetChanged();
    }

    public final void setPopularCategoryListData(@NotNull ArrayList<RefinerX> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "results");
        this.itemList = new ArrayList<>(CollectionsKt.toList(arrayList));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_popular_category_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemPopularCategoryLayoutBinding) inflate);
    }

    public final void setClickListener(@NotNull OnPopularCategoryItemClickListener onPopularCategoryItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onPopularCategoryItemClickListener, "onHeaderItemClickListener");
        this.onItemClickListener = onPopularCategoryItemClickListener;
    }

    public int getItemCount() {
        if (this.itemList == null) {
            return 0;
        }
        ArrayList<RefinerX> arrayList = this.itemList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemList");
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        return arrayList.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter;Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemPopularCategoryLayoutBinding;)V", "bindFilterInfo", "", "selectedRefiner", "Lcom/iaai/android/bdt/model/fastSearch/RefinerX;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PopularCategoryListAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemPopularCategoryLayoutBinding binding;
        final /* synthetic */ PopularCategoryListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull PopularCategoryListAdapter popularCategoryListAdapter, RowItemPopularCategoryLayoutBinding rowItemPopularCategoryLayoutBinding) {
            super(rowItemPopularCategoryLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemPopularCategoryLayoutBinding, "binding");
            this.this$0 = popularCategoryListAdapter;
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

        public final void bindFilterInfo(@NotNull RefinerX refinerX) {
            Intrinsics.checkParameterIsNotNull(refinerX, "selectedRefiner");
            TextView textView = this.binding.tvPopularCategory;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvPopularCategory");
            textView.setText(refinerX.getDisplayName());
            LinearLayout linearLayout = this.binding.llPopularCategory;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llPopularCategory");
            linearLayout.setSelected(refinerX.isSelect());
        }
    }
}
