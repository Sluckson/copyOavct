package com.iaai.android.bdt.feature.productDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ConditionInfo;
import com.iaai.android.databinding.RowItemConditionInfoBinding;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0014\u0010\u001f\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\fR\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ConditionInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/productDetail/ConditionInfoAdapter$ViewHolder;", "context", "Landroid/content/Context;", "productDetailInfoListener", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailInfoListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/productDetail/ProductDetailInfoListener;)V", "conditionInfoList", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInfo;", "isEngineVideoPresent", "", "isKeyImagePresent", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getProductDetailInfoListener", "()Lcom/iaai/android/bdt/feature/productDetail/ProductDetailInfoListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setConditionsData", "results", "setIsEngineVideoPresent", "isVideoPresent", "setIsKeyImagePresent", "isKeyPresent", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ConditionInfoAdapter.kt */
public final class ConditionInfoAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<ConditionInfo> conditionInfoList;
    /* access modifiers changed from: private */
    public boolean isEngineVideoPresent;
    /* access modifiers changed from: private */
    public boolean isKeyImagePresent;
    @NotNull
    private Context mContext;
    @NotNull
    private final ProductDetailInfoListener productDetailInfoListener;

    public ConditionInfoAdapter(@NotNull Context context, @NotNull ProductDetailInfoListener productDetailInfoListener2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(productDetailInfoListener2, "productDetailInfoListener");
        this.productDetailInfoListener = productDetailInfoListener2;
        this.mContext = context;
    }

    @NotNull
    public final ProductDetailInfoListener getProductDetailInfoListener() {
        return this.productDetailInfoListener;
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
        List<ConditionInfo> list = this.conditionInfoList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        viewHolder.bindConditionInfo(list.get(i), i);
    }

    public final void setConditionsData(@NotNull List<ConditionInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.conditionInfoList = list;
    }

    public final void setIsKeyImagePresent(boolean z) {
        this.isKeyImagePresent = z;
    }

    public final void setIsEngineVideoPresent(boolean z) {
        this.isEngineVideoPresent = z;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_condition_info, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        ViewHolder viewHolder = new ViewHolder(this, (RowItemConditionInfoBinding) inflate);
        viewHolder.getBinding().tvValueCondition.setOnClickListener(new ConditionInfoAdapter$onCreateViewHolder$1(this, viewHolder));
        viewHolder.getBinding().ivEngineLink.setOnClickListener(new ConditionInfoAdapter$onCreateViewHolder$2(this, viewHolder));
        return viewHolder;
    }

    public int getItemCount() {
        List<ConditionInfo> list = this.conditionInfoList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ConditionInfoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemConditionInfoBinding;", "(Lcom/iaai/android/bdt/feature/productDetail/ConditionInfoAdapter;Lcom/iaai/android/databinding/RowItemConditionInfoBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemConditionInfoBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemConditionInfoBinding;)V", "bindConditionInfo", "", "conditionInfo", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInfo;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ConditionInfoAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemConditionInfoBinding binding;
        final /* synthetic */ ConditionInfoAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ConditionInfoAdapter conditionInfoAdapter, RowItemConditionInfoBinding rowItemConditionInfoBinding) {
            super(rowItemConditionInfoBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemConditionInfoBinding, "binding");
            this.this$0 = conditionInfoAdapter;
            this.binding = rowItemConditionInfoBinding;
        }

        @NotNull
        public final RowItemConditionInfoBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemConditionInfoBinding rowItemConditionInfoBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemConditionInfoBinding, "<set-?>");
            this.binding = rowItemConditionInfoBinding;
        }

        public final void bindConditionInfo(@NotNull ConditionInfo conditionInfo, int i) {
            String str;
            Intrinsics.checkParameterIsNotNull(conditionInfo, "conditionInfo");
            ImageView imageView = this.binding.ivEngineLink;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivEngineLink");
            imageView.setVisibility(8);
            Boolean vCConditionViewLessPreferencesMVVM = IAASharedPreference.getVCConditionViewLessPreferencesMVVM(this.this$0.getMContext());
            Intrinsics.checkExpressionValueIsNotNull(vCConditionViewLessPreferencesMVVM, "IAASharedPreference.getV…PreferencesMVVM(mContext)");
            if (vCConditionViewLessPreferencesMVVM.booleanValue() || i < 3) {
                int displayPattern = conditionInfo.getDisplayPattern();
                if (displayPattern == 10 || displayPattern == 3) {
                    str = "" + conditionInfo.getDisplayValues().get(0).getText();
                    for (int i2 = 1; i2 < conditionInfo.getDisplayValues().size(); i2++) {
                        str = str + " (" + conditionInfo.getDisplayValues().get(i2).getText() + ") ";
                    }
                } else if (displayPattern == 7) {
                    int size = conditionInfo.getDisplayValues().size() - 1;
                    String str2 = "";
                    for (int i3 = 0; i3 < size; i3++) {
                        str2 = str2 + conditionInfo.getDisplayValues().get(i3).getText() + " / ";
                    }
                    str = str2 + conditionInfo.getDisplayValues().get(size).getText();
                } else if (displayPattern == 4) {
                    int size2 = conditionInfo.getDisplayValues().size() - 1;
                    String str3 = "";
                    for (int i4 = 0; i4 < size2; i4++) {
                        str3 = str3 + conditionInfo.getDisplayValues().get(i4).getText() + ", ";
                    }
                    str = str3 + conditionInfo.getDisplayValues().get(size2).getText();
                } else {
                    str = conditionInfo.getDisplayValues().get(0).getText();
                }
                if (this.this$0.isKeyImagePresent && StringsKt.equals(conditionInfo.getDisplayText(), "Key/Fob", true) && StringsKt.equals(str, "Present", true)) {
                    TextView textView = this.binding.tvValueCondition;
                    Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvValueCondition");
                    textView.setPaintFlags(8);
                    TextView textView2 = this.binding.tvValueCondition;
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvValueCondition");
                    textView2.setClickable(true);
                } else if (!this.this$0.isEngineVideoPresent || !StringsKt.equals(conditionInfo.getDisplayText(), "Start Code", true)) {
                    TextView textView3 = this.binding.tvValueCondition;
                    Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvValueCondition");
                    textView3.setPaintFlags(0);
                    TextView textView4 = this.binding.tvValueCondition;
                    Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvValueCondition");
                    textView4.setClickable(false);
                    ImageView imageView2 = this.binding.ivEngineLink;
                    Intrinsics.checkExpressionValueIsNotNull(imageView2, "binding.ivEngineLink");
                    imageView2.setVisibility(8);
                } else {
                    TextView textView5 = this.binding.tvValueCondition;
                    Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvValueCondition");
                    textView5.setPaintFlags(8);
                    TextView textView6 = this.binding.tvValueCondition;
                    Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvValueCondition");
                    textView6.setClickable(true);
                    ImageView imageView3 = this.binding.ivEngineLink;
                    Intrinsics.checkExpressionValueIsNotNull(imageView3, "binding.ivEngineLink");
                    imageView3.setVisibility(0);
                }
                TextView textView7 = this.binding.tvLabelCondition;
                Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvLabelCondition");
                textView7.setText(conditionInfo.getDisplayText() + ':');
                TextView textView8 = this.binding.tvValueCondition;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvValueCondition");
                textView8.setText(str);
                TextView textView9 = this.binding.tvLabelCondition;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvLabelCondition");
                textView9.setVisibility(0);
                TextView textView10 = this.binding.tvValueCondition;
                Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvValueCondition");
                textView10.setVisibility(0);
                return;
            }
            TextView textView11 = this.binding.tvLabelCondition;
            Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvLabelCondition");
            textView11.setVisibility(8);
            TextView textView12 = this.binding.tvValueCondition;
            Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvValueCondition");
            textView12.setVisibility(8);
        }
    }
}
