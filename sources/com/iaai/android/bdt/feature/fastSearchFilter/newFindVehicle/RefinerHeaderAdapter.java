package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

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
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.databinding.RowItemClearfilterLayoutBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00029:B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J^\u0010\u001d\u001a\u00020\u001e2\u001a\u0010\u001f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\n2:\u0010 \u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0007j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b`\nJ(\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00112\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\tJ \u0010&\u001a\u00020\u001e2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u001a\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\nJZ\u0010(\u001aV\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\n\u00128\u00126\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0007j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b`\n0)J\b\u0010*\u001a\u00020\tH\u0016J\u001c\u0010+\u001a\u00020\u001e2\n\u0010,\u001a\u00060\u0002R\u00020\u00002\u0006\u0010%\u001a\u00020\tH\u0016J\u001c\u0010-\u001a\u00060\u0002R\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tH\u0016J^\u00101\u001a\u00020\u001e2\u001a\u0010\u001f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\n2:\u0010 \u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0007j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b`\nJ\u0006\u00102\u001a\u00020\u001eJ\u0016\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tJ\u001e\u00106\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00105\u001a\u00020\tJ\u000e\u00108\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017RB\u0010\u0006\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0007j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b`\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006;"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "indicesList", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "", "Lkotlin/collections/ArrayList;", "isNewHeaderItemAdded", "", "()Z", "setNewHeaderItemAdded", "(Z)V", "itemList", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onRefinerHeaderItemClickListener", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$OnRefinerHeaderItemClickListener;", "selectedIndicesCount", "getSelectedIndicesCount", "()I", "setSelectedIndicesCount", "(I)V", "addHeaderListData", "", "itemListArray", "indicesListArray", "addMakeModelToHeaderListData", "value", "indices", "addPopularCategoryToHeaderList", "position", "addToHeaderListData", "getHeaderItem", "getHeaderItemData", "Lkotlin/Pair;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAllHeaderData", "removeAllRefinerFromHeader", "removeGroupFromHeaderData", "parentPos", "tabPosition", "removeSingleGroupRefinerFromHeader", "childPos", "setClickListener", "OnRefinerHeaderItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerHeaderAdapter.kt */
public final class RefinerHeaderAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<Triple<Integer, Integer, Integer>> indicesList = new ArrayList<>();
    private boolean isNewHeaderItemAdded;
    /* access modifiers changed from: private */
    public ArrayList<FacetXX> itemList = new ArrayList<>();
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnRefinerHeaderItemClickListener onRefinerHeaderItemClickListener;
    private int selectedIndicesCount;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H&¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$OnRefinerHeaderItemClickListener;", "", "onItemClick", "", "indices", "Lkotlin/Triple;", "", "facetXX", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "position", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerHeaderAdapter.kt */
    public interface OnRefinerHeaderItemClickListener {
        void onItemClick(@NotNull Triple<Integer, Integer, Integer> triple, @Nullable FacetXX facetXX, int i);
    }

    public RefinerHeaderAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ OnRefinerHeaderItemClickListener access$getOnRefinerHeaderItemClickListener$p(RefinerHeaderAdapter refinerHeaderAdapter) {
        OnRefinerHeaderItemClickListener onRefinerHeaderItemClickListener2 = refinerHeaderAdapter.onRefinerHeaderItemClickListener;
        if (onRefinerHeaderItemClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onRefinerHeaderItemClickListener");
        }
        return onRefinerHeaderItemClickListener2;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public final int getSelectedIndicesCount() {
        return this.selectedIndicesCount;
    }

    public final void setSelectedIndicesCount(int i) {
        this.selectedIndicesCount = i;
    }

    public final boolean isNewHeaderItemAdded() {
        return this.isNewHeaderItemAdded;
    }

    public final void setNewHeaderItemAdded(boolean z) {
        this.isNewHeaderItemAdded = z;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        FacetXX facetXX = this.itemList.get(i);
        viewHolder.bindFilterInfo(facetXX);
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        ((LinearLayout) view.findViewById(C2723R.C2726id.layout_clearfilter_container)).setOnClickListener(new RefinerHeaderAdapter$onBindViewHolder$1(this, i, facetXX));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_clearfilter_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemClearfilterLayoutBinding) inflate);
    }

    public final void setClickListener(@NotNull OnRefinerHeaderItemClickListener onRefinerHeaderItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onRefinerHeaderItemClickListener2, "onRefinerHeaderItemClickListener");
        this.onRefinerHeaderItemClickListener = onRefinerHeaderItemClickListener2;
    }

    public final void addToHeaderListData(@NotNull Triple<Integer, Integer, Integer> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "indices");
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(triple.getFirst().intValue()).getGroups().get(triple.getSecond().intValue()));
        this.itemList.add(0, list != null ? (FacetXX) list.get(triple.getThird().intValue()) : null);
        this.indicesList.add(0, triple);
        this.selectedIndicesCount++;
        notifyDataSetChanged();
        this.isNewHeaderItemAdded = true;
    }

    public final void addMakeModelToHeaderListData(@NotNull FacetXX facetXX, @NotNull Triple<Integer, Integer, Integer> triple) {
        Intrinsics.checkParameterIsNotNull(facetXX, "value");
        Intrinsics.checkParameterIsNotNull(triple, "indices");
        this.itemList.add(0, facetXX);
        this.indicesList.add(0, triple);
        this.selectedIndicesCount++;
        notifyDataSetChanged();
        this.isNewHeaderItemAdded = true;
    }

    public final void addHeaderListData(@NotNull ArrayList<FacetXX> arrayList, @NotNull ArrayList<Triple<Integer, Integer, Integer>> arrayList2) {
        Intrinsics.checkParameterIsNotNull(arrayList, "itemListArray");
        Intrinsics.checkParameterIsNotNull(arrayList2, "indicesListArray");
        this.itemList.addAll(arrayList);
        this.indicesList.addAll(arrayList2);
        this.selectedIndicesCount += arrayList.size();
        notifyDataSetChanged();
        this.isNewHeaderItemAdded = true;
    }

    public final void removeAllHeaderData(@NotNull ArrayList<FacetXX> arrayList, @NotNull ArrayList<Triple<Integer, Integer, Integer>> arrayList2) {
        Intrinsics.checkParameterIsNotNull(arrayList, "itemListArray");
        Intrinsics.checkParameterIsNotNull(arrayList2, "indicesListArray");
        this.itemList.clear();
        this.indicesList.clear();
        addHeaderListData(arrayList, arrayList2);
    }

    public final void addPopularCategoryToHeaderList(int i) {
        List list = BDTUtils.INSTANCE.getExpandableListDetailPC().get(BDTUtils.INSTANCE.getSearchMappingArray().get(2).getGroups().get(0));
        this.itemList.add(0, list != null ? (FacetXX) list.get(i) : null);
        this.indicesList.add(0, new Triple(2, 0, Integer.valueOf(i)));
        this.selectedIndicesCount++;
        notifyDataSetChanged();
        this.isNewHeaderItemAdded = true;
    }

    public final void removeSingleGroupRefinerFromHeader(int i, int i2, int i3) {
        int size = this.indicesList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i4 = -1;
                break;
            }
            Triple<Integer, Integer, Integer> triple = this.indicesList.get(i4);
            Intrinsics.checkExpressionValueIsNotNull(triple, "indicesList[index]");
            Triple triple2 = triple;
            if (((Number) triple2.getFirst()).intValue() == i3 && ((Number) triple2.getSecond()).intValue() == i && ((Number) triple2.getThird()).intValue() == i2) {
                break;
            }
            i4++;
        }
        if (i4 != -1) {
            this.itemList.remove(i4);
            this.indicesList.remove(i4);
            this.selectedIndicesCount--;
            notifyDataSetChanged();
        }
    }

    public final void removeGroupFromHeaderData(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = this.indicesList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Triple<Integer, Integer, Integer> triple = this.indicesList.get(i3);
            Intrinsics.checkExpressionValueIsNotNull(triple, "indicesList[index]");
            Triple triple2 = triple;
            if (((Number) triple2.getFirst()).intValue() == i2 && ((Number) triple2.getSecond()).intValue() == i) {
                arrayList.add(triple2);
                FacetXX facetXX = this.itemList.get(i3);
                if (facetXX != null) {
                    arrayList2.add(facetXX);
                }
            }
        }
        this.itemList.removeAll(arrayList2);
        this.indicesList.removeAll(arrayList);
        this.selectedIndicesCount -= arrayList2.size();
        notifyDataSetChanged();
    }

    public final void removeAllRefinerFromHeader() {
        this.itemList.clear();
        this.indicesList.clear();
        this.selectedIndicesCount = 0;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.indicesList.size();
    }

    @NotNull
    public final ArrayList<FacetXX> getHeaderItem() {
        return this.itemList;
    }

    @NotNull
    public final Pair<ArrayList<FacetXX>, ArrayList<Triple<Integer, Integer, Integer>>> getHeaderItemData() {
        return new Pair<>(this.itemList, this.indicesList);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter;Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemClearfilterLayoutBinding;)V", "bindFilterInfo", "", "facetXX", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerHeaderAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemClearfilterLayoutBinding binding;
        final /* synthetic */ RefinerHeaderAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull RefinerHeaderAdapter refinerHeaderAdapter, RowItemClearfilterLayoutBinding rowItemClearfilterLayoutBinding) {
            super(rowItemClearfilterLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemClearfilterLayoutBinding, "binding");
            this.this$0 = refinerHeaderAdapter;
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

        public final void bindFilterInfo(@Nullable FacetXX facetXX) {
            TextView textView = this.binding.tvClearfilter;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvClearfilter");
            textView.setText(facetXX != null ? facetXX.getValue() : null);
        }
    }
}
