package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.databinding.RowItemFastSearchFilterFacetCheckboxBinding;
import com.iaai.android.databinding.RowItemFastSearchMoreFacetRadioButtonBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0004)*+,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\u000eJ\b\u0010 \u001a\u00020\u000eH\u0016J\u001c\u0010!\u001a\u00020\u001c2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010#\u001a\u00020\u000eH\u0016J\u001c\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000eH\u0016J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$BaseViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "facetxxList", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mParentPosition", "", "getMParentPosition", "()I", "setMParentPosition", "(I)V", "onItemClickListener", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$OnItemClickListener;", "viewTypeText", "", "getViewTypeText", "()Ljava/lang/String;", "setViewTypeText", "(Ljava/lang/String;)V", "facetXXData", "", "results", "viewtypeText", "parentPosition", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "BaseViewHolder", "OnItemClickListener", "ViewHolderCheckBox", "ViewHolderRadioButton", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchMoreFilterAdapter.kt */
public final class FastSearchMoreFilterAdapter extends RecyclerView.Adapter<BaseViewHolder<?>> {
    /* access modifiers changed from: private */
    public List<FacetXX> facetxxList = new ArrayList();
    @NotNull
    private Context mContext;
    private int mParentPosition;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    @NotNull
    private String viewTypeText;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$OnItemClickListener;", "", "onItemClick", "", "facetxx", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "isSingleSelection", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FastSearchMoreFilterAdapter.kt */
    public interface OnItemClickListener {
        void onItemClick(@NotNull FacetXX facetXX, boolean z);
    }

    public FastSearchMoreFilterAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.viewTypeText = "checkbox";
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(FastSearchMoreFilterAdapter fastSearchMoreFilterAdapter) {
        OnItemClickListener onItemClickListener2 = fastSearchMoreFilterAdapter.onItemClickListener;
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

    public final int getMParentPosition() {
        return this.mParentPosition;
    }

    public final void setMParentPosition(int i) {
        this.mParentPosition = i;
    }

    @NotNull
    public final String getViewTypeText() {
        return this.viewTypeText;
    }

    public final void setViewTypeText(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.viewTypeText = str;
    }

    public void onBindViewHolder(@NotNull BaseViewHolder<?> baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        List<FacetXX> list = this.facetxxList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        FacetXX facetXX = list.get(i);
        String str = this.viewTypeText;
        int hashCode = str.hashCode();
        if (hashCode != 108270587) {
            if (hashCode == 1536891843 && str.equals("checkbox")) {
                baseViewHolder.itemView.setOnClickListener(new FastSearchMoreFilterAdapter$onBindViewHolder$1(this, baseViewHolder));
                baseViewHolder.bind(facetXX);
            }
        } else if (str.equals("radio")) {
            baseViewHolder.bind(facetXX);
        }
    }

    public final void facetXXData(@Nullable List<FacetXX> list, @Nullable String str, int i) {
        if (list == null) {
            Intrinsics.throwNpe();
        }
        this.facetxxList = list;
        if (str == null) {
            str = "checkbox";
        }
        this.viewTypeText = str;
        this.mParentPosition = i;
    }

    @NotNull
    public BaseViewHolder<?> onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = this.viewTypeText;
        int hashCode = str.hashCode();
        if (hashCode != 108270587) {
            if (hashCode == 1536891843 && str.equals("checkbox")) {
                ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…_checkbox, parent, false)");
                return new ViewHolderCheckBox(this, (RowItemFastSearchFilterFacetCheckboxBinding) inflate);
            }
        } else if (str.equals("radio")) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_fast_search_more_facet_radio_button, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…io_button, parent, false)");
            return new ViewHolderRadioButton(this, (RowItemFastSearchMoreFacetRadioButtonBinding) inflate2);
        }
        throw new IllegalArgumentException("Invalid view type");
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public int getItemCount() {
        List<FacetXX> list = this.facetxxList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$BaseViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FastSearchMoreFilterAdapter.kt */
    public static abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        public abstract void bind(@NotNull FacetXX facetXX);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$ViewHolderCheckBox;", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "binding", "Lcom/iaai/android/databinding/RowItemFastSearchFilterFacetCheckboxBinding;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter;Lcom/iaai/android/databinding/RowItemFastSearchFilterFacetCheckboxBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemFastSearchFilterFacetCheckboxBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemFastSearchFilterFacetCheckboxBinding;)V", "bind", "", "item", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FastSearchMoreFilterAdapter.kt */
    public final class ViewHolderCheckBox extends BaseViewHolder<FacetXX> {
        @NotNull
        private RowItemFastSearchFilterFacetCheckboxBinding binding;
        final /* synthetic */ FastSearchMoreFilterAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolderCheckBox(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter r2, com.iaai.android.databinding.RowItemFastSearchFilterFacetCheckboxBinding r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter.ViewHolderCheckBox.<init>(com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter, com.iaai.android.databinding.RowItemFastSearchFilterFacetCheckboxBinding):void");
        }

        @NotNull
        public final RowItemFastSearchFilterFacetCheckboxBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemFastSearchFilterFacetCheckboxBinding rowItemFastSearchFilterFacetCheckboxBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemFastSearchFilterFacetCheckboxBinding, "<set-?>");
            this.binding = rowItemFastSearchFilterFacetCheckboxBinding;
        }

        public void bind(@NotNull FacetXX facetXX) {
            Intrinsics.checkParameterIsNotNull(facetXX, "item");
            this.binding.tvMultiSelectValue.setTypeface(Typeface.SANS_SERIF, 0);
            TextView textView = this.binding.tvMultiSelectValue;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvMultiSelectValue");
            textView.setText(facetXX.getValue());
            this.binding.tvMultiSelectValue.setTextColor(ContextCompat.getColor(this.this$0.getMContext(), C2723R.C2724color.bdt_gray_darker));
            ImageView imageView = this.binding.ivCheck;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivCheck");
            imageView.setSelected(facetXX.isSelected());
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$ViewHolderRadioButton;", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "binding", "Lcom/iaai/android/databinding/RowItemFastSearchMoreFacetRadioButtonBinding;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter;Lcom/iaai/android/databinding/RowItemFastSearchMoreFacetRadioButtonBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemFastSearchMoreFacetRadioButtonBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemFastSearchMoreFacetRadioButtonBinding;)V", "bind", "", "item", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FastSearchMoreFilterAdapter.kt */
    public final class ViewHolderRadioButton extends BaseViewHolder<FacetXX> {
        @NotNull
        private RowItemFastSearchMoreFacetRadioButtonBinding binding;
        final /* synthetic */ FastSearchMoreFilterAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolderRadioButton(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter r2, com.iaai.android.databinding.RowItemFastSearchMoreFacetRadioButtonBinding r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter.ViewHolderRadioButton.<init>(com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter, com.iaai.android.databinding.RowItemFastSearchMoreFacetRadioButtonBinding):void");
        }

        @NotNull
        public final RowItemFastSearchMoreFacetRadioButtonBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemFastSearchMoreFacetRadioButtonBinding rowItemFastSearchMoreFacetRadioButtonBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemFastSearchMoreFacetRadioButtonBinding, "<set-?>");
            this.binding = rowItemFastSearchMoreFacetRadioButtonBinding;
        }

        public void bind(@NotNull FacetXX facetXX) {
            Intrinsics.checkParameterIsNotNull(facetXX, "item");
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{Color.parseColor("#cccccc"), Color.parseColor("#238723")});
            RadioButton radioButton = this.binding.rlRadioButton;
            Intrinsics.checkExpressionValueIsNotNull(radioButton, "binding.rlRadioButton");
            radioButton.setText(facetXX.getValue());
            RadioButton radioButton2 = this.binding.rlRadioButton;
            Intrinsics.checkExpressionValueIsNotNull(radioButton2, "binding.rlRadioButton");
            radioButton2.setButtonTintList(colorStateList);
            this.binding.rlRadioButton.setTypeface(Typeface.SANS_SERIF, 0);
            RadioButton radioButton3 = this.binding.rlRadioButton;
            Intrinsics.checkExpressionValueIsNotNull(radioButton3, "binding.rlRadioButton");
            radioButton3.setTextSize(14.0f);
            this.binding.rlRadioButton.setTextColor(this.this$0.getMContext().getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            RadioButton radioButton4 = this.binding.rlRadioButton;
            Intrinsics.checkExpressionValueIsNotNull(radioButton4, "binding.rlRadioButton");
            radioButton4.setChecked(facetXX.isSelected());
            this.binding.rlRadioButton.setOnClickListener(new FastSearchMoreFilterAdapter$ViewHolderRadioButton$bind$1(this));
        }
    }
}
