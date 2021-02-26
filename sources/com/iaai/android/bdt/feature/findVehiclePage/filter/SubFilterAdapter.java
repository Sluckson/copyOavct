package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.filter.FilterValues;
import com.iaai.android.databinding.RowItemSubFilterBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002'(B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u001c\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010%\u001a\u00020\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006)"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "filterValues", "", "Lcom/iaai/android/bdt/model/filter/FilterValues;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter$OnItemClickListener;", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "selectedReinerValue", "", "getSelectedReinerValue", "()Ljava/lang/String;", "setSelectedReinerValue", "(Ljava/lang/String;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setFilterData", "results", "OnItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SubFilterAdapter.kt */
public final class SubFilterAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public List<FilterValues> filterValues;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    private int selectedPosition = -1;
    @NotNull
    private String selectedReinerValue = "";

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter$OnItemClickListener;", "", "onItemClick", "", "selectedFilter", "Lcom/iaai/android/bdt/model/filter/FilterValues;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SubFilterAdapter.kt */
    public interface OnItemClickListener {
        void onItemClick(@NotNull FilterValues filterValues, int i);
    }

    public SubFilterAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ List access$getFilterValues$p(SubFilterAdapter subFilterAdapter) {
        List<FilterValues> list = subFilterAdapter.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        return list;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(SubFilterAdapter subFilterAdapter) {
        OnItemClickListener onItemClickListener2 = subFilterAdapter.onItemClickListener;
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

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    @NotNull
    public final String getSelectedReinerValue() {
        return this.selectedReinerValue;
    }

    public final void setSelectedReinerValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.selectedReinerValue = str;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        List<FilterValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        String valuesId = list.get(i).getValuesId();
        if (valuesId == null) {
            valuesId = "";
        }
        List<FilterValues> list2 = this.filterValues;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        Integer count = list2.get(i).getCount();
        if (count != null) {
            count.intValue();
        }
        if (i != 0) {
            viewHolder.bindFilterText(String.valueOf(valuesId));
        } else {
            viewHolder.bindFilterText(String.valueOf(valuesId));
        }
        boolean z = false;
        if (!(this.selectedReinerValue.length() > 0) || !StringsKt.equals(this.selectedReinerValue, valuesId, true)) {
            if (i == 0) {
                CharSequence charSequence = this.selectedReinerValue;
                if (charSequence == null || charSequence.length() == 0) {
                    View view = viewHolder.itemView;
                    Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C2723R.C2726id.clContainer);
                    Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "holder.itemView.clContainer");
                    constraintLayout.setSelected(true);
                }
            }
            View view2 = viewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(C2723R.C2726id.clContainer);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "holder.itemView.clContainer");
            if (this.selectedPosition == i) {
                z = true;
            }
            constraintLayout2.setSelected(z);
        } else {
            View view3 = viewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            ConstraintLayout constraintLayout3 = (ConstraintLayout) view3.findViewById(C2723R.C2726id.clContainer);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "holder.itemView.clContainer");
            constraintLayout3.setSelected(true);
        }
        viewHolder.itemView.setOnClickListener(new SubFilterAdapter$onBindViewHolder$1(this, viewHolder));
    }

    public final void setFilterData(@NotNull List<FilterValues> list, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        Intrinsics.checkParameterIsNotNull(str, "selectedReinerValue");
        this.filterValues = list;
        this.selectedReinerValue = str;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_sub_filter, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemSubFilterBinding) inflate);
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public int getItemCount() {
        List<FilterValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemSubFilterBinding;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter;Lcom/iaai/android/databinding/RowItemSubFilterBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemSubFilterBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemSubFilterBinding;)V", "bindFilterText", "", "filterText", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SubFilterAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemSubFilterBinding binding;
        final /* synthetic */ SubFilterAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull SubFilterAdapter subFilterAdapter, RowItemSubFilterBinding rowItemSubFilterBinding) {
            super(rowItemSubFilterBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemSubFilterBinding, "binding");
            this.this$0 = subFilterAdapter;
            this.binding = rowItemSubFilterBinding;
        }

        @NotNull
        public final RowItemSubFilterBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemSubFilterBinding rowItemSubFilterBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemSubFilterBinding, "<set-?>");
            this.binding = rowItemSubFilterBinding;
        }

        public final void bindFilterText(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "filterText");
            TextView textView = this.binding.tvFilterText;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvFilterText");
            textView.setText(str);
        }
    }
}
