package com.iaai.android.bdt.feature.landing.recommendedVehicles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.databinding.ItemBreBadgePopupBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0016R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/BadgesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/BadgesAdapter$ViewHolder;", "context", "Landroid/content/Context;", "badgesList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "badgesDrawable", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BadgesAdapter.kt */
public final class BadgesAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<Integer> badgesDrawable;
    private final ArrayList<Integer> badgesList;
    /* access modifiers changed from: private */
    public final Context context;

    public BadgesAdapter(@NotNull Context context2, @NotNull ArrayList<Integer> arrayList, @NotNull ArrayList<Integer> arrayList2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(arrayList, "badgesList");
        Intrinsics.checkParameterIsNotNull(arrayList2, "badgesDrawable");
        this.context = context2;
        this.badgesList = arrayList;
        this.badgesDrawable = arrayList2;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Integer num = this.badgesList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(num, "badgesList[position]");
        int intValue = num.intValue();
        Integer num2 = this.badgesDrawable.get(i);
        Intrinsics.checkExpressionValueIsNotNull(num2, "badgesDrawable[position]");
        viewHolder.bindBadge(intValue, num2.intValue());
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.item_bre_badge_popup, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (ItemBreBadgePopupBinding) inflate);
    }

    public int getItemCount() {
        return this.badgesList.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/BadgesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemBreBadgePopupBinding;", "(Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/BadgesAdapter;Lcom/iaai/android/databinding/ItemBreBadgePopupBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemBreBadgePopupBinding;", "setBinding", "(Lcom/iaai/android/databinding/ItemBreBadgePopupBinding;)V", "bindBadge", "", "badge", "", "badgeDrawable", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BadgesAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private ItemBreBadgePopupBinding binding;
        final /* synthetic */ BadgesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull BadgesAdapter badgesAdapter, ItemBreBadgePopupBinding itemBreBadgePopupBinding) {
            super(itemBreBadgePopupBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemBreBadgePopupBinding, "binding");
            this.this$0 = badgesAdapter;
            this.binding = itemBreBadgePopupBinding;
        }

        @NotNull
        public final ItemBreBadgePopupBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull ItemBreBadgePopupBinding itemBreBadgePopupBinding) {
            Intrinsics.checkParameterIsNotNull(itemBreBadgePopupBinding, "<set-?>");
            this.binding = itemBreBadgePopupBinding;
        }

        public final void bindBadge(int i, int i2) {
            TextView textView = this.binding.tvBadgeText;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvBadgeText");
            textView.setText(this.this$0.context.getResources().getString(i));
            this.binding.ivBadge.setImageDrawable(ContextCompat.getDrawable(this.this$0.context, i2));
        }
    }
}
