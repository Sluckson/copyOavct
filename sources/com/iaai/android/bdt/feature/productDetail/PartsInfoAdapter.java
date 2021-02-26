package com.iaai.android.bdt.feature.productDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.partsSection.PartsSectionResponse;
import com.iaai.android.databinding.RowItemPartsBinding;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/PartsInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/productDetail/PartsInfoAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "partsSectionResponse", "", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setPartsData", "results", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PartsInfoAdapter.kt */
public final class PartsInfoAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private Context mContext;
    private List<PartsSectionResponse> partsSectionResponse;

    public PartsInfoAdapter(@NotNull Context context) {
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

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        List<PartsSectionResponse> list = this.partsSectionResponse;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        viewHolder.bindPartsInfo(list.get(i), i);
    }

    public final void setPartsData(@NotNull List<PartsSectionResponse> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.partsSectionResponse = list;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_parts, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemPartsBinding) inflate);
    }

    public int getItemCount() {
        List<PartsSectionResponse> list = this.partsSectionResponse;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/PartsInfoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemPartsBinding;", "(Lcom/iaai/android/bdt/feature/productDetail/PartsInfoAdapter;Lcom/iaai/android/databinding/RowItemPartsBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemPartsBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemPartsBinding;)V", "bindPartsInfo", "", "partsSectionResponse", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PartsInfoAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemPartsBinding binding;
        final /* synthetic */ PartsInfoAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull PartsInfoAdapter partsInfoAdapter, RowItemPartsBinding rowItemPartsBinding) {
            super(rowItemPartsBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemPartsBinding, "binding");
            this.this$0 = partsInfoAdapter;
            this.binding = rowItemPartsBinding;
        }

        @NotNull
        public final RowItemPartsBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemPartsBinding rowItemPartsBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemPartsBinding, "<set-?>");
            this.binding = rowItemPartsBinding;
        }

        public final void bindPartsInfo(@NotNull PartsSectionResponse partsSectionResponse, int i) {
            Intrinsics.checkParameterIsNotNull(partsSectionResponse, "partsSectionResponse");
            Boolean vinDetailsViewLessPreferencesMVVM = IAASharedPreference.getVinDetailsViewLessPreferencesMVVM(this.this$0.getMContext());
            Intrinsics.checkExpressionValueIsNotNull(vinDetailsViewLessPreferencesMVVM, "IAASharedPreference.getV…PreferencesMVVM(mContext)");
            if (vinDetailsViewLessPreferencesMVVM.booleanValue() || i < 3) {
                TextView textView = this.binding.tvPartsValue;
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvPartsValue");
                textView.setVisibility(0);
                TextView textView2 = this.binding.tvICChangeValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvICChangeValue");
                textView2.setVisibility(0);
                TextView textView3 = this.binding.tvICDescriptionValue;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvICDescriptionValue");
                textView3.setVisibility(0);
                TextView textView4 = this.binding.tvPartsValue;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvPartsValue");
                textView4.setText(partsSectionResponse.getPartName());
                TextView textView5 = this.binding.tvICChangeValue;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvICChangeValue");
                textView5.setText(partsSectionResponse.getInterchangeNumber());
                TextView textView6 = this.binding.tvICDescriptionValue;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvICDescriptionValue");
                textView6.setText(partsSectionResponse.getInterchangeDescription());
                View view = this.binding.Separator1;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.Separator1");
                view.setVisibility(0);
                return;
            }
            TextView textView7 = this.binding.tvPartsValue;
            Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvPartsValue");
            textView7.setVisibility(8);
            TextView textView8 = this.binding.tvICChangeValue;
            Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvICChangeValue");
            textView8.setVisibility(8);
            TextView textView9 = this.binding.tvICDescriptionValue;
            Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvICDescriptionValue");
            textView9.setVisibility(8);
            View view2 = this.binding.Separator1;
            Intrinsics.checkExpressionValueIsNotNull(view2, "binding.Separator1");
            view2.setVisibility(8);
        }
    }
}
