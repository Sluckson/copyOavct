package com.iaai.android.bdt.feature.landing.quickFilter;

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
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.databinding.RowItemQuickFilterBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u001d\u001a\u00020\u00152\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0011R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onQuickFilterClickListener", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$OnQuickFilterClickListener;", "quickFilterList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "Lkotlin/collections/ArrayList;", "quickFilterType", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$Companion$QuickFilterType;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setQuickFilterData", "quickFilter", "setQuickFilterType", "type", "Companion", "OnQuickFilterClickListener", "QuickFilterHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: QuickFilterAdapter.kt */
public final class QuickFilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_ITEM = 0;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnQuickFilterClickListener onQuickFilterClickListener;
    /* access modifiers changed from: private */
    public ArrayList<QuickFilterResponse> quickFilterList = new ArrayList<>();
    private Companion.QuickFilterType quickFilterType;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$OnQuickFilterClickListener;", "", "onItemClick", "", "selectedFilter", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: QuickFilterAdapter.kt */
    public interface OnQuickFilterClickListener {
        void onItemClick(@NotNull QuickFilterResponse quickFilterResponse);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Companion.QuickFilterType.values().length];

        static {
            $EnumSwitchMapping$0[Companion.QuickFilterType.VEHICLE_QUICK_FILTER.ordinal()] = 1;
            $EnumSwitchMapping$0[Companion.QuickFilterType.AUCTION_QUICK_FILTER.ordinal()] = 2;
        }
    }

    public QuickFilterAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.quickFilterType = Companion.QuickFilterType.VEHICLE_QUICK_FILTER;
    }

    public static final /* synthetic */ OnQuickFilterClickListener access$getOnQuickFilterClickListener$p(QuickFilterAdapter quickFilterAdapter) {
        OnQuickFilterClickListener onQuickFilterClickListener2 = quickFilterAdapter.onQuickFilterClickListener;
        if (onQuickFilterClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onQuickFilterClickListener");
        }
        return onQuickFilterClickListener2;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$Companion;", "", "()V", "TYPE_ITEM", "", "QuickFilterType", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: QuickFilterAdapter.kt */
    public static final class Companion {

        @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$Companion$QuickFilterType;", "", "(Ljava/lang/String;I)V", "VEHICLE_QUICK_FILTER", "AUCTION_QUICK_FILTER", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
        /* compiled from: QuickFilterAdapter.kt */
        public enum QuickFilterType {
            VEHICLE_QUICK_FILTER,
            AUCTION_QUICK_FILTER
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_quick_filter, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…rent, false\n            )");
        objectRef.element = (RecyclerView.ViewHolder) new QuickFilterHolder(this, (RowItemQuickFilterBinding) inflate);
        View view = ((RecyclerView.ViewHolder) objectRef.element).itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        ((ConstraintLayout) view.findViewById(C2723R.C2726id.clQuickFilter)).setOnClickListener(new QuickFilterAdapter$onCreateViewHolder$1(this, objectRef));
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public int getItemCount() {
        if (this.quickFilterList.size() == 0) {
            return 0;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.quickFilterType.ordinal()];
        if (i == 1) {
            return this.quickFilterList.size();
        }
        if (i == 2) {
            return this.quickFilterList.size();
        }
        throw new NoWhenBranchMatchedException();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof QuickFilterHolder) {
            QuickFilterResponse quickFilterResponse = this.quickFilterList.get(i);
            Intrinsics.checkExpressionValueIsNotNull(quickFilterResponse, "quickFilterList[position]");
            ((QuickFilterHolder) viewHolder).bindQuickFilter(quickFilterResponse);
        }
    }

    public final void setQuickFilterData(@NotNull ArrayList<QuickFilterResponse> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "quickFilter");
        this.quickFilterList = arrayList;
    }

    public final void setQuickFilterType(@NotNull Companion.QuickFilterType quickFilterType2) {
        Intrinsics.checkParameterIsNotNull(quickFilterType2, "type");
        this.quickFilterType = quickFilterType2;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$QuickFilterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemQuickFilterBinding;", "(Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter;Lcom/iaai/android/databinding/RowItemQuickFilterBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemQuickFilterBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemQuickFilterBinding;)V", "bindQuickFilter", "", "quickFilter", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: QuickFilterAdapter.kt */
    public final class QuickFilterHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemQuickFilterBinding binding;
        final /* synthetic */ QuickFilterAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public QuickFilterHolder(@NotNull QuickFilterAdapter quickFilterAdapter, RowItemQuickFilterBinding rowItemQuickFilterBinding) {
            super(rowItemQuickFilterBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemQuickFilterBinding, "binding");
            this.this$0 = quickFilterAdapter;
            this.binding = rowItemQuickFilterBinding;
        }

        @NotNull
        public final RowItemQuickFilterBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemQuickFilterBinding rowItemQuickFilterBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemQuickFilterBinding, "<set-?>");
            this.binding = rowItemQuickFilterBinding;
        }

        public final void bindQuickFilter(@NotNull QuickFilterResponse quickFilterResponse) {
            Intrinsics.checkParameterIsNotNull(quickFilterResponse, "quickFilter");
            TextView textView = this.binding.tvFilterTitle;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvFilterTitle");
            textView.setText(quickFilterResponse.getDisplayValue());
        }
    }

    public final void setClickListener(@NotNull OnQuickFilterClickListener onQuickFilterClickListener2) {
        Intrinsics.checkParameterIsNotNull(onQuickFilterClickListener2, "onQuickFilterClickListener");
        this.onQuickFilterClickListener = onQuickFilterClickListener2;
    }
}
