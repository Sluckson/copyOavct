package com.iaai.android.bdt.feature.productDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.biddingInfo.VINInfo;
import com.iaai.android.databinding.RowItemConditionInfoBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\tJ\u0014\u0010\u001e\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/VinInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/productDetail/VinInfoAdapter$ViewHolder;", "context", "Landroid/content/Context;", "productDetailInfoListener", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailInfoListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/productDetail/ProductDetailInfoListener;)V", "isEngineVideoPresent", "", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "vinInfoList", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VINInfo;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setIsEngineVideoPresent", "isVideoPresent", "setVinInfoData", "results", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: VinInfoAdapter.kt */
public final class VinInfoAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public boolean isEngineVideoPresent;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public final ProductDetailInfoListener productDetailInfoListener;
    private List<VINInfo> vinInfoList;

    public VinInfoAdapter(@NotNull Context context, @NotNull ProductDetailInfoListener productDetailInfoListener2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(productDetailInfoListener2, "productDetailInfoListener");
        this.productDetailInfoListener = productDetailInfoListener2;
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
        List<VINInfo> list = this.vinInfoList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        viewHolder.bindVinInfo(list.get(i), i);
    }

    public final void setVinInfoData(@NotNull List<VINInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.vinInfoList = list;
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
        viewHolder.getBinding().tvValueCondition.setOnClickListener(new VinInfoAdapter$onCreateViewHolder$1(this, viewHolder));
        viewHolder.getBinding().ivEngineLink.setOnClickListener(new VinInfoAdapter$onCreateViewHolder$2(this, viewHolder));
        return viewHolder;
    }

    public int getItemCount() {
        List<VINInfo> list = this.vinInfoList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/VinInfoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemConditionInfoBinding;", "(Lcom/iaai/android/bdt/feature/productDetail/VinInfoAdapter;Lcom/iaai/android/databinding/RowItemConditionInfoBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemConditionInfoBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemConditionInfoBinding;)V", "bindVinInfo", "", "vinInfo", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VINInfo;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: VinInfoAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemConditionInfoBinding binding;
        final /* synthetic */ VinInfoAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull VinInfoAdapter vinInfoAdapter, RowItemConditionInfoBinding rowItemConditionInfoBinding) {
            super(rowItemConditionInfoBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemConditionInfoBinding, "binding");
            this.this$0 = vinInfoAdapter;
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

        /* JADX WARNING: Removed duplicated region for block: B:18:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00ca  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindVinInfo(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.model.productDetail.biddingInfo.VINInfo r13, int r14) {
            /*
                r12 = this;
                java.lang.String r0 = "vinInfo"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.ImageView r0 = r0.ivEngineLink
                java.lang.String r1 = "binding.ivEngineLink"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r2 = 8
                r0.setVisibility(r2)
                com.iaai.android.bdt.feature.productDetail.VinInfoAdapter r0 = r12.this$0
                android.content.Context r0 = r0.getMContext()
                java.lang.Boolean r0 = com.iaai.android.old.utils.IAASharedPreference.getVinDetailsViewLessPreferencesMVVM(r0)
                java.lang.String r3 = "IAASharedPreference.getV…PreferencesMVVM(mContext)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                boolean r0 = r0.booleanValue()
                java.lang.String r3 = "binding.tvLabelCondition"
                java.lang.String r4 = "binding.tvValueCondition"
                if (r0 != 0) goto L_0x0046
                r0 = 3
                if (r14 >= r0) goto L_0x0030
                goto L_0x0046
            L_0x0030:
                com.iaai.android.databinding.RowItemConditionInfoBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvLabelCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r3)
                r13.setVisibility(r2)
                com.iaai.android.databinding.RowItemConditionInfoBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvValueCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r4)
                r13.setVisibility(r2)
                goto L_0x020e
            L_0x0046:
                java.lang.String r14 = r13.getDisplayText()
                r0 = 0
                r5 = 2
                r6 = 0
                java.lang.String r7 = "VIN"
                boolean r14 = kotlin.text.StringsKt.startsWith$default(r14, r7, r6, r5, r0)
                java.lang.String r0 = "/"
                java.lang.String r7 = ")"
                java.lang.String r8 = " ("
                r9 = 1
                r10 = 14
                r11 = 7
                if (r14 == 0) goto L_0x00ee
                java.util.List r14 = r13.getDisplayValues()
                int r14 = r14.size()
                if (r14 != r5) goto L_0x0088
                java.util.List r14 = r13.getDisplayValues()
                java.lang.Object r14 = r14.get(r6)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r14 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r14
                java.lang.String r14 = r14.getText()
                if (r14 != 0) goto L_0x007c
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x007c:
                java.lang.String r5 = "Un"
                boolean r14 = kotlin.text.StringsKt.startsWith(r14, r5, r9)
                if (r14 != 0) goto L_0x0085
                goto L_0x0088
            L_0x0085:
                java.lang.String r14 = "Unknown"
                goto L_0x009f
            L_0x0088:
                java.util.List r14 = r13.getDisplayValues()
                java.lang.Object r14 = r14.get(r6)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r14 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r14
                java.lang.String r14 = r14.getText()
                java.lang.String r14 = com.iaai.android.bdt.utils.Utils.unMaskVinNumber(r14)
                java.lang.String r5 = "Utils.unMaskVinNumber(vi…fo.DisplayValues[0].Text)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r5)
            L_0x009f:
                int r5 = r13.getDisplayPattern()
                if (r5 != r10) goto L_0x00ca
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r14)
                r0.append(r8)
                java.util.List r14 = r13.getDisplayValues()
                java.lang.Object r14 = r14.get(r9)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r14 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r14
                java.lang.String r14 = r14.getText()
                r0.append(r14)
                r0.append(r7)
                java.lang.String r14 = r0.toString()
                goto L_0x017c
            L_0x00ca:
                if (r5 != r11) goto L_0x017c
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r14)
                r5.append(r0)
                java.util.List r14 = r13.getDisplayValues()
                java.lang.Object r14 = r14.get(r9)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r14 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r14
                java.lang.String r14 = r14.getText()
                r5.append(r14)
                java.lang.String r14 = r5.toString()
                goto L_0x017c
            L_0x00ee:
                int r14 = r13.getDisplayPattern()
                if (r14 != r10) goto L_0x0130
                java.util.List r14 = r13.getDisplayValues()
                int r14 = r14.size()
                if (r14 != r5) goto L_0x016b
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.util.List r0 = r13.getDisplayValues()
                java.lang.Object r0 = r0.get(r6)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r0 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r0
                java.lang.String r0 = r0.getText()
                r14.append(r0)
                r14.append(r8)
                java.util.List r0 = r13.getDisplayValues()
                java.lang.Object r0 = r0.get(r9)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r0 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r0
                java.lang.String r0 = r0.getText()
                r14.append(r0)
                r14.append(r7)
                java.lang.String r14 = r14.toString()
                goto L_0x017c
            L_0x0130:
                if (r14 != r11) goto L_0x016e
                java.util.List r14 = r13.getDisplayValues()
                int r14 = r14.size()
                if (r14 != r5) goto L_0x016b
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.util.List r5 = r13.getDisplayValues()
                java.lang.Object r5 = r5.get(r6)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r5 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r5
                java.lang.String r5 = r5.getText()
                r14.append(r5)
                r14.append(r0)
                java.util.List r0 = r13.getDisplayValues()
                java.lang.Object r0 = r0.get(r9)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r0 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r0
                java.lang.String r0 = r0.getText()
                r14.append(r0)
                java.lang.String r14 = r14.toString()
                goto L_0x017c
            L_0x016b:
                java.lang.String r14 = ""
                goto L_0x017c
            L_0x016e:
                java.util.List r14 = r13.getDisplayValues()
                java.lang.Object r14 = r14.get(r6)
                com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue r14 = (com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue) r14
                java.lang.String r14 = r14.getText()
            L_0x017c:
                com.iaai.android.bdt.feature.productDetail.VinInfoAdapter r0 = r12.this$0
                boolean r0 = r0.isEngineVideoPresent
                if (r0 == 0) goto L_0x01af
                java.lang.String r0 = r13.getDisplayText()
                java.lang.String r5 = "Engine"
                boolean r0 = kotlin.text.StringsKt.equals(r0, r5, r9)
                if (r0 == 0) goto L_0x01af
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.TextView r0 = r0.tvValueCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
                r0.setPaintFlags(r2)
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.TextView r0 = r0.tvValueCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
                r0.setClickable(r9)
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.ImageView r0 = r0.ivEngineLink
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r6)
                goto L_0x01cd
            L_0x01af:
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.TextView r0 = r0.tvValueCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
                r0.setPaintFlags(r6)
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.TextView r0 = r0.tvValueCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
                r0.setClickable(r6)
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.ImageView r0 = r0.ivEngineLink
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                r0.setVisibility(r2)
            L_0x01cd:
                com.iaai.android.databinding.RowItemConditionInfoBinding r0 = r12.binding
                android.widget.TextView r0 = r0.tvLabelCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r13 = r13.getDisplayText()
                r1.append(r13)
                r13 = 58
                r1.append(r13)
                java.lang.String r13 = r1.toString()
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                r0.setText(r13)
                com.iaai.android.databinding.RowItemConditionInfoBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvValueCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r4)
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                r13.setText(r14)
                com.iaai.android.databinding.RowItemConditionInfoBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvLabelCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r3)
                r13.setVisibility(r6)
                com.iaai.android.databinding.RowItemConditionInfoBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvValueCondition
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r4)
                r13.setVisibility(r6)
            L_0x020e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.VinInfoAdapter.ViewHolder.bindVinInfo(com.iaai.android.bdt.model.productDetail.biddingInfo.VINInfo, int):void");
        }
    }
}
