package com.iaai.android.bdt.feature.auctionSalesList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.RowItemLaneLayoutBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002,-B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020\u001bH\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001bH\u0016J\u000e\u0010)\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0014J:\u0010*\u001a\u00020\"2\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006."}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isFristTime", "", "()Z", "setFristTime", "(Z)V", "lanesListCount", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter$OnItemClickListener;)V", "scopeList", "selected_position", "", "getSelected_position", "()I", "setSelected_position", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setLaneData", "results", "OnItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LaneAdapter.kt */
public final class LaneAdapter extends RecyclerView.Adapter<ViewHolder> {
    private boolean isFristTime;
    private ArrayList<String> lanesListCount = new ArrayList<>();
    @NotNull
    private Context mContext;
    @NotNull
    public OnItemClickListener onItemClickListener;
    /* access modifiers changed from: private */
    public ArrayList<String> scopeList = new ArrayList<>();
    private int selected_position;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter$OnItemClickListener;", "", "OnItemSelected", "", "position", "", "lane", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: LaneAdapter.kt */
    public interface OnItemClickListener {
        void OnItemSelected(int i, @NotNull String str);
    }

    public LaneAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.isFristTime = true;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public final boolean isFristTime() {
        return this.isFristTime;
    }

    public final void setFristTime(boolean z) {
        this.isFristTime = z;
    }

    public final int getSelected_position() {
        return this.selected_position;
    }

    public final void setSelected_position(int i) {
        this.selected_position = i;
    }

    @NotNull
    public final OnItemClickListener getOnItemClickListener() {
        OnItemClickListener onItemClickListener2 = this.onItemClickListener;
        if (onItemClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        return onItemClickListener2;
    }

    public final void setOnItemClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "<set-?>");
        this.onItemClickListener = onItemClickListener2;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        ArrayList<String> arrayList = this.scopeList;
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        String str = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(str, "scopeList!![position]");
        String str2 = this.lanesListCount.get(i);
        Intrinsics.checkExpressionValueIsNotNull(str2, "lanesListCount[position]");
        viewHolder.bindLaneInfo(str, str2);
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C2723R.C2726id.layout_lane_container);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "holder.itemView.layout_lane_container");
        relativeLayout.setSelected(this.selected_position == i);
        viewHolder.itemView.setOnClickListener(new LaneAdapter$onBindViewHolder$1(this, viewHolder));
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public final void setLaneData(@Nullable ArrayList<String> arrayList, @NotNull ArrayList<String> arrayList2) {
        Intrinsics.checkParameterIsNotNull(arrayList2, "lanesListCount");
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        this.scopeList = arrayList;
        this.lanesListCount = arrayList2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_lane_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemLaneLayoutBinding) inflate);
    }

    public int getItemCount() {
        ArrayList<String> arrayList = this.scopeList;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        return arrayList.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemLaneLayoutBinding;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter;Lcom/iaai/android/databinding/RowItemLaneLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemLaneLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemLaneLayoutBinding;)V", "bindLaneInfo", "", "scopeList", "", "laneCount", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: LaneAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemLaneLayoutBinding binding;
        final /* synthetic */ LaneAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull LaneAdapter laneAdapter, RowItemLaneLayoutBinding rowItemLaneLayoutBinding) {
            super(rowItemLaneLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemLaneLayoutBinding, "binding");
            this.this$0 = laneAdapter;
            this.binding = rowItemLaneLayoutBinding;
        }

        @NotNull
        public final RowItemLaneLayoutBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemLaneLayoutBinding rowItemLaneLayoutBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemLaneLayoutBinding, "<set-?>");
            this.binding = rowItemLaneLayoutBinding;
        }

        public final void bindLaneInfo(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "scopeList");
            Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_LANE_COUNT);
            TextView textView = this.binding.tvLane;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvLane");
            textView.setText(str + " (" + str2 + ')');
        }
    }
}
