package com.iaai.android.bdt.feature.digitalNegotiation;

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
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import com.iaai.android.databinding.RowItemManageOfferFilterBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002+,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u001c\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u0018H\u0016J\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010'\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\bR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "filterList", "", "Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "[Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mobileNegotiationList", "", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "getMobileNegotiationList", "()Ljava/util/List;", "setMobileNegotiationList", "(Ljava/util/List;)V", "onItemClickListener", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter$OnItemClickListener;", "selectedPos", "", "getSelectedPos", "()I", "setSelectedPos", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setNegotiationList", "results", "setSelectedFilter", "filterSelected", "OnItemClickListener", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferFilterAdapter.kt */
public final class ManageOfferFilterAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public FilterSelected[] filterList = {FilterSelected.ALL, FilterSelected.PENDING_BIDDER, FilterSelected.PENDING_SELLER, FilterSelected.CLOSED, FilterSelected.EXPIRED};
    @NotNull
    private Context mContext;
    @Nullable
    private List<MobileNegotiationsList> mobileNegotiationList;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    private int selectedPos;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter$OnItemClickListener;", "", "onItemClick", "", "filterSelected", "Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferFilterAdapter.kt */
    public interface OnItemClickListener {
        void onItemClick(@NotNull FilterSelected filterSelected, int i);
    }

    public ManageOfferFilterAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(ManageOfferFilterAdapter manageOfferFilterAdapter) {
        OnItemClickListener onItemClickListener2 = manageOfferFilterAdapter.onItemClickListener;
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

    @Nullable
    public final List<MobileNegotiationsList> getMobileNegotiationList() {
        return this.mobileNegotiationList;
    }

    public final void setMobileNegotiationList(@Nullable List<MobileNegotiationsList> list) {
        this.mobileNegotiationList = list;
    }

    public final int getSelectedPos() {
        return this.selectedPos;
    }

    public final void setSelectedPos(int i) {
        this.selectedPos = i;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        viewHolder.bindInfo(viewHolder.getAdapterPosition());
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C2723R.C2726id.rlContainer);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "holder.itemView.rlContainer");
        relativeLayout.setSelected(this.selectedPos == i);
        viewHolder.itemView.setOnClickListener(new ManageOfferFilterAdapter$onBindViewHolder$1(this, viewHolder));
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public final void setSelectedFilter(@NotNull FilterSelected filterSelected) {
        Intrinsics.checkParameterIsNotNull(filterSelected, "filterSelected");
        this.selectedPos = ArraysKt.indexOf((T[]) this.filterList, filterSelected);
    }

    public final void setNegotiationList(@NotNull List<MobileNegotiationsList> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.mobileNegotiationList = list;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_manage_offer_filter, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemManageOfferFilterBinding) inflate);
    }

    public int getItemCount() {
        FilterSelected[] filterSelectedArr = this.filterList;
        if (filterSelectedArr == null) {
            Intrinsics.throwNpe();
        }
        return filterSelectedArr.length;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemManageOfferFilterBinding;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter;Lcom/iaai/android/databinding/RowItemManageOfferFilterBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemManageOfferFilterBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemManageOfferFilterBinding;)V", "bindInfo", "", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferFilterAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemManageOfferFilterBinding binding;
        final /* synthetic */ ManageOfferFilterAdapter this$0;

        @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[FilterSelected.values().length];
            public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[FilterSelected.values().length];

            static {
                $EnumSwitchMapping$0[FilterSelected.ALL.ordinal()] = 1;
                $EnumSwitchMapping$0[FilterSelected.PENDING_BIDDER.ordinal()] = 2;
                $EnumSwitchMapping$0[FilterSelected.PENDING_SELLER.ordinal()] = 3;
                $EnumSwitchMapping$0[FilterSelected.CLOSED.ordinal()] = 4;
                $EnumSwitchMapping$0[FilterSelected.EXPIRED.ordinal()] = 5;
                $EnumSwitchMapping$1[FilterSelected.ALL.ordinal()] = 1;
                $EnumSwitchMapping$1[FilterSelected.PENDING_BIDDER.ordinal()] = 2;
                $EnumSwitchMapping$1[FilterSelected.PENDING_SELLER.ordinal()] = 3;
                $EnumSwitchMapping$1[FilterSelected.CLOSED.ordinal()] = 4;
                $EnumSwitchMapping$1[FilterSelected.EXPIRED.ordinal()] = 5;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ManageOfferFilterAdapter manageOfferFilterAdapter, RowItemManageOfferFilterBinding rowItemManageOfferFilterBinding) {
            super(rowItemManageOfferFilterBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemManageOfferFilterBinding, "binding");
            this.this$0 = manageOfferFilterAdapter;
            this.binding = rowItemManageOfferFilterBinding;
        }

        @NotNull
        public final RowItemManageOfferFilterBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemManageOfferFilterBinding rowItemManageOfferFilterBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemManageOfferFilterBinding, "<set-?>");
            this.binding = rowItemManageOfferFilterBinding;
        }

        public final void bindInfo(int i) {
            CharSequence charSequence;
            TextView textView = this.binding.tvFilterName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvFilterName");
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.this$0.filterList[i].ordinal()];
            if (i2 == 1) {
                charSequence = this.this$0.getMContext().getResources().getString(C2723R.string.lbl_all);
            } else if (i2 == 2) {
                charSequence = this.this$0.getMContext().getResources().getString(C2723R.string.lbl_pending_buyer);
            } else if (i2 == 3) {
                charSequence = this.this$0.getMContext().getResources().getString(C2723R.string.lbl_pending_seller);
            } else if (i2 == 4) {
                charSequence = this.this$0.getMContext().getResources().getString(C2723R.string.lbl_closed);
            } else if (i2 == 5) {
                charSequence = this.this$0.getMContext().getResources().getString(C2723R.string.lbl_expired);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            textView.setText(charSequence);
            int i3 = WhenMappings.$EnumSwitchMapping$1[this.this$0.filterList[i].ordinal()];
            Integer num = null;
            if (i3 == 1) {
                List<MobileNegotiationsList> mobileNegotiationList = this.this$0.getMobileNegotiationList();
                if (mobileNegotiationList != null) {
                    num = Integer.valueOf(mobileNegotiationList.size());
                }
            } else if (i3 == 2) {
                List<MobileNegotiationsList> mobileNegotiationList2 = this.this$0.getMobileNegotiationList();
                if (mobileNegotiationList2 != null) {
                    Collection arrayList = new ArrayList();
                    for (Object next : mobileNegotiationList2) {
                        if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next).getStatus(), (Object) "PendingBidder")) {
                            arrayList.add(next);
                        }
                    }
                    num = Integer.valueOf(((List) arrayList).size());
                }
            } else if (i3 == 3) {
                List<MobileNegotiationsList> mobileNegotiationList3 = this.this$0.getMobileNegotiationList();
                if (mobileNegotiationList3 != null) {
                    Collection arrayList2 = new ArrayList();
                    for (Object next2 : mobileNegotiationList3) {
                        if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next2).getStatus(), (Object) "PendingSeller")) {
                            arrayList2.add(next2);
                        }
                    }
                    num = Integer.valueOf(((List) arrayList2).size());
                }
            } else if (i3 == 4) {
                List<MobileNegotiationsList> mobileNegotiationList4 = this.this$0.getMobileNegotiationList();
                if (mobileNegotiationList4 != null) {
                    Collection arrayList3 = new ArrayList();
                    for (Object next3 : mobileNegotiationList4) {
                        if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next3).getStatus(), (Object) "Closed")) {
                            arrayList3.add(next3);
                        }
                    }
                    num = Integer.valueOf(((List) arrayList3).size());
                }
            } else if (i3 == 5) {
                List<MobileNegotiationsList> mobileNegotiationList5 = this.this$0.getMobileNegotiationList();
                if (mobileNegotiationList5 != null) {
                    Collection arrayList4 = new ArrayList();
                    for (Object next4 : mobileNegotiationList5) {
                        if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next4).getStatus(), (Object) "Expired")) {
                            arrayList4.add(next4);
                        }
                    }
                    num = Integer.valueOf(((List) arrayList4).size());
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            TextView textView2 = this.binding.tvCount;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvCount");
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(num);
            sb.append(')');
            textView2.setText(sb.toString());
        }
    }
}
