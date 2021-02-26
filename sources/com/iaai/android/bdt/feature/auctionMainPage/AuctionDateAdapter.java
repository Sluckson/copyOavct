package com.iaai.android.bdt.feature.auctionMainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.databinding.ItemAuctionDateLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002#$B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fJ\u001b\u0010 \u001a\u00020\u00182\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\"R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "auctionDateItemList", "", "", "[Ljava/lang/String;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter$OnItemClickListener;", "selected_position", "", "getSelected_position", "()I", "setSelected_position", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setLaneData", "results", "([Ljava/lang/String;)V", "OnItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionDateAdapter.kt */
public final class AuctionDateAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public String[] auctionDateItemList;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    private int selected_position;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter$OnItemClickListener;", "", "onItemClick", "", "sortItem", "", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AuctionDateAdapter.kt */
    public interface OnItemClickListener {
        void onItemClick(@NotNull String str, int i);
    }

    public AuctionDateAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ String[] access$getAuctionDateItemList$p(AuctionDateAdapter auctionDateAdapter) {
        String[] strArr = auctionDateAdapter.auctionDateItemList;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateItemList");
        }
        return strArr;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(AuctionDateAdapter auctionDateAdapter) {
        OnItemClickListener onItemClickListener2 = auctionDateAdapter.onItemClickListener;
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

    public final int getSelected_position() {
        return this.selected_position;
    }

    public final void setSelected_position(int i) {
        this.selected_position = i;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        String[] strArr = this.auctionDateItemList;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateItemList");
        }
        if (strArr == null) {
            Intrinsics.throwNpe();
        }
        viewHolder.bindLaneInfo(strArr[i]);
        viewHolder.itemView.setOnClickListener(new AuctionDateAdapter$onBindViewHolder$1(this, viewHolder));
    }

    public final void setLaneData(@Nullable String[] strArr) {
        if (strArr == null) {
            Intrinsics.throwNpe();
        }
        this.auctionDateItemList = strArr;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.item_auction_date_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (ItemAuctionDateLayoutBinding) inflate);
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public int getItemCount() {
        String[] strArr = this.auctionDateItemList;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateItemList");
        }
        if (strArr == null) {
            return 0;
        }
        String[] strArr2 = this.auctionDateItemList;
        if (strArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateItemList");
        }
        if (strArr2 == null) {
            Intrinsics.throwNpe();
        }
        return strArr2.length;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemAuctionDateLayoutBinding;", "(Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter;Lcom/iaai/android/databinding/ItemAuctionDateLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemAuctionDateLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/ItemAuctionDateLayoutBinding;)V", "bindLaneInfo", "", "scopeList", "", "updateUIForSelection", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AuctionDateAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private ItemAuctionDateLayoutBinding binding;
        final /* synthetic */ AuctionDateAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull AuctionDateAdapter auctionDateAdapter, ItemAuctionDateLayoutBinding itemAuctionDateLayoutBinding) {
            super(itemAuctionDateLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemAuctionDateLayoutBinding, "binding");
            this.this$0 = auctionDateAdapter;
            this.binding = itemAuctionDateLayoutBinding;
        }

        @NotNull
        public final ItemAuctionDateLayoutBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull ItemAuctionDateLayoutBinding itemAuctionDateLayoutBinding) {
            Intrinsics.checkParameterIsNotNull(itemAuctionDateLayoutBinding, "<set-?>");
            this.binding = itemAuctionDateLayoutBinding;
        }

        public final void bindLaneInfo(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "scopeList");
            TextView textView = this.binding.tvAuctionDate;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvAuctionDate");
            textView.setText(str);
        }

        public final void updateUIForSelection() {
            this.binding.tvAuctionDate.setTextColor(ContextCompat.getColor(this.this$0.getMContext(), C2723R.C2724color.bdt_white));
            this.binding.llAuctionDateContainer.setBackgroundColor(ContextCompat.getColor(this.this$0.getMContext(), C2723R.C2724color.bdt_red));
        }
    }
}
