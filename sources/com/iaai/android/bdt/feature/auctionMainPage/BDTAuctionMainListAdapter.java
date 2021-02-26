package com.iaai.android.bdt.feature.auctionMainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.databinding.RowItemAuctionEmptySeparatorLayoutBinding;
import com.iaai.android.databinding.RowItemAuctionMainListBinding;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0004*+,-B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u001c\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020\u001dH\u0016J\u001c\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dH\u0016J\u0016\u0010(\u001a\u00020\"2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006."}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter$BaseViewHolder;", "context", "Landroid/content/Context;", "auctionMainListViewModel", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListViewModel;", "listener", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionItemClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListViewModel;Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionItemClickListener;)V", "auctionResultsList", "", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "isBidLive", "", "getListener", "()Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionItemClickListener;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getDateText", "", "dateString", "isPreBid", "getIsAuctionToday", "getItem", "long", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "results", "AuctionMainEmptyViewHolder", "BaseViewHolder", "Companion", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTAuctionMainListAdapter.kt */
public final class BDTAuctionMainListAdapter extends RecyclerView.Adapter<BaseViewHolder<?>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_AUCTION = 1;
    public static final int TYPE_NO_RECENTLY_VIEWED = 2;
    public static final int TYPE_SEPARATOR = 0;
    private List<AuctionLocations> auctionResultsList;
    /* access modifiers changed from: private */
    public boolean isBidLive;
    @NotNull
    private final AuctionItemClickListener listener;
    @NotNull
    private Context mContext;

    public BDTAuctionMainListAdapter(@NotNull Context context, @NotNull AuctionMainListViewModel auctionMainListViewModel, @NotNull AuctionItemClickListener auctionItemClickListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(auctionMainListViewModel, "auctionMainListViewModel");
        Intrinsics.checkParameterIsNotNull(auctionItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = auctionItemClickListener;
        this.mContext = context;
    }

    @NotNull
    public final AuctionItemClickListener getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter$Companion;", "", "()V", "TYPE_AUCTION", "", "TYPE_NO_RECENTLY_VIEWED", "TYPE_SEPARATOR", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTAuctionMainListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onBindViewHolder(@NotNull BaseViewHolder<?> baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        List<AuctionLocations> list = this.auctionResultsList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        AuctionLocations auctionLocations = list.get(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            baseViewHolder.bind(auctionLocations);
        } else if (itemViewType == 0) {
            if (i == 0) {
                View view = baseViewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
                TextView textView = (TextView) view.findViewById(C2723R.C2726id.empty_separator);
                Intrinsics.checkExpressionValueIsNotNull(textView, "holder.itemView.empty_separator");
                textView.setText(this.mContext.getString(C2723R.string.recently_joined_auctions_txt));
                return;
            }
            View view2 = baseViewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            TextView textView2 = (TextView) view2.findViewById(C2723R.C2726id.empty_separator);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.itemView.empty_separator");
            textView2.setText(this.mContext.getString(C2723R.string.lbl_bdt_upcoming_auction));
        } else if (itemViewType == 2) {
            View view3 = baseViewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            TextView textView3 = (TextView) view3.findViewById(C2723R.C2726id.empty_separator);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "holder.itemView.empty_separator");
            textView3.setText(this.mContext.getString(C2723R.string.lbl_bdt_upcoming_auction));
        }
    }

    public final void setData(@Nullable List<AuctionLocations> list) {
        this.auctionResultsList = list;
        notifyDataSetChanged();
    }

    @NotNull
    public final AuctionLocations getItem(int i) {
        List<AuctionLocations> list = this.auctionResultsList;
        AuctionLocations auctionLocations = list != null ? list.get(i) : null;
        if (auctionLocations == null) {
            Intrinsics.throwNpe();
        }
        return auctionLocations;
    }

    @NotNull
    public BaseViewHolder<?> onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i != 0) {
            if (i == 1) {
                ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_auction_main_list, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…main_list, parent, false)");
                ViewHolder viewHolder = new ViewHolder(this, (RowItemAuctionMainListBinding) inflate);
                View view = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
                ((Button) view.findViewById(C2723R.C2726id.btnBidAuction)).setOnClickListener(new BDTAuctionMainListAdapter$onCreateViewHolder$1(this, viewHolder));
                viewHolder.itemView.setOnClickListener(new BDTAuctionMainListAdapter$onCreateViewHolder$2(this, viewHolder));
                View view2 = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
                ((LinearLayout) view2.findViewById(C2723R.C2726id.llBidButtonAuction)).setOnClickListener(new BDTAuctionMainListAdapter$onCreateViewHolder$3(this, viewHolder));
                View view3 = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
                ((TextView) view3.findViewById(C2723R.C2726id.tvAuctionBranch)).setOnClickListener(new BDTAuctionMainListAdapter$onCreateViewHolder$4(this, viewHolder));
                return viewHolder;
            } else if (i != 2) {
                throw new IllegalArgumentException("Invalid view type");
            }
        }
        ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_auction_empty_separator_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…or_layout, parent, false)");
        AuctionMainEmptyViewHolder auctionMainEmptyViewHolder = new AuctionMainEmptyViewHolder(this, (RowItemAuctionEmptySeparatorLayoutBinding) inflate2);
        ViewDataBinding inflate3 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_auction_empty_separator_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate3, "DataBindingUtil.inflate(…or_layout, parent, false)");
        new AuctionMainEmptyViewHolder(this, (RowItemAuctionEmptySeparatorLayoutBinding) inflate3);
        return auctionMainEmptyViewHolder;
    }

    public int getItemViewType(int i) {
        if (getItem(i).getBranchid() != null) {
            return Intrinsics.areEqual((Object) getItem(i).getBranchid(), (Object) "DummyAuction") ? 2 : 1;
        }
        return 0;
    }

    public int getItemCount() {
        List<AuctionLocations> list = this.auctionResultsList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter$ViewHolder;", "Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "auctionMainListBinding", "Lcom/iaai/android/databinding/RowItemAuctionMainListBinding;", "(Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter;Lcom/iaai/android/databinding/RowItemAuctionMainListBinding;)V", "getAuctionMainListBinding", "()Lcom/iaai/android/databinding/RowItemAuctionMainListBinding;", "setAuctionMainListBinding", "(Lcom/iaai/android/databinding/RowItemAuctionMainListBinding;)V", "bind", "", "auctionItem", "updateBindingData", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTAuctionMainListAdapter.kt */
    public final class ViewHolder extends BaseViewHolder<AuctionLocations> {
        @NotNull
        private RowItemAuctionMainListBinding auctionMainListBinding;
        final /* synthetic */ BDTAuctionMainListAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolder(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r2, com.iaai.android.databinding.RowItemAuctionMainListBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "auctionMainListBinding"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
                r1.this$0 = r2
                android.view.View r2 = r3.getRoot()
                java.lang.String r0 = "auctionMainListBinding.root"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)
                r1.<init>(r2)
                r1.auctionMainListBinding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter.ViewHolder.<init>(com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter, com.iaai.android.databinding.RowItemAuctionMainListBinding):void");
        }

        @NotNull
        public final RowItemAuctionMainListBinding getAuctionMainListBinding() {
            return this.auctionMainListBinding;
        }

        public final void setAuctionMainListBinding(@NotNull RowItemAuctionMainListBinding rowItemAuctionMainListBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemAuctionMainListBinding, "<set-?>");
            this.auctionMainListBinding = rowItemAuctionMainListBinding;
        }

        public void bind(@NotNull AuctionLocations auctionLocations) {
            Intrinsics.checkParameterIsNotNull(auctionLocations, "auctionItem");
            updateBindingData(auctionLocations);
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x0321  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x036a  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x037c  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x03de  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x03e7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void updateBindingData(com.iaai.android.bdt.model.auctionmainlist.AuctionLocations r24) {
            /*
                r23 = this;
                r0 = r23
                int r1 = r24.getStatus()
                java.lang.Boolean r2 = r24.getAuctionCloseInd()
                if (r2 != 0) goto L_0x000f
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x000f:
                boolean r2 = r2.booleanValue()
                java.lang.String r3 = "itemView.llBidButtonAuction"
                java.lang.String r4 = "itemView.tvPreBidCloseTime"
                r5 = 1
                java.lang.String r6 = ""
                java.lang.String r7 = "itemView.tvAuctionStatus"
                r8 = 8
                r9 = 0
                java.lang.String r10 = "itemView"
                if (r2 == 0) goto L_0x0073
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r9)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r2 = 2131821134(0x7f11024e, float:1.9275003E38)
                r1.setText(r2)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.llBidButtonAuction
                android.view.View r1 = r1.findViewById(r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                r1.setVisibility(r8)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r8)
            L_0x006f:
                r2 = r24
                goto L_0x02b7
            L_0x0073:
                java.lang.Boolean r2 = r24.getSealedauction()
                if (r2 != 0) goto L_0x007c
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x007c:
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L_0x00b9
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r2 = r0.this$0
                java.lang.String r4 = r24.getCloseDate()
                if (r4 == 0) goto L_0x009b
                goto L_0x009c
            L_0x009b:
                r4 = r6
            L_0x009c:
                java.lang.String r2 = r2.getDateText(r4, r5)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.llBidButtonAuction
                android.view.View r1 = r1.findViewById(r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                r1.setVisibility(r8)
                goto L_0x006f
            L_0x00b9:
                int r2 = r24.getSTATUS_BEFORE_PRE_BID_ENDS()
                r11 = 2131821142(0x7f110256, float:1.9275019E38)
                if (r1 != r2) goto L_0x018f
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r9)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r2 = r0.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r4 = 2131821135(0x7f11024f, float:1.9275005E38)
                java.lang.Object[] r12 = new java.lang.Object[r5]
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r13 = r0.this$0
                java.lang.String r14 = r24.getCloseDate()
                if (r14 == 0) goto L_0x00fd
                goto L_0x00fe
            L_0x00fd:
                r14 = r6
            L_0x00fe:
                java.lang.String r13 = r13.getDateText(r14, r5)
                r12[r9] = r13
                java.lang.String r2 = r2.getString(r4, r12)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.llBidButtonAuction
                android.view.View r1 = r1.findViewById(r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                r1.setVisibility(r8)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r1 = r0.this$0
                java.lang.String r2 = r24.getLiveDate()
                if (r2 == 0) goto L_0x0129
                goto L_0x012a
            L_0x0129:
                r2 = r6
            L_0x012a:
                boolean r1 = r1.getIsAuctionToday(r2)
                if (r1 == 0) goto L_0x017a
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r9)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r2 = r0.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                java.lang.Object[] r3 = new java.lang.Object[r5]
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r4 = r0.this$0
                java.lang.String r7 = r24.getLiveDate()
                if (r7 == 0) goto L_0x0168
                goto L_0x0169
            L_0x0168:
                r7 = r6
            L_0x0169:
                java.lang.String r4 = r4.getDateText(r7, r9)
                r3[r9] = r4
                java.lang.String r2 = r2.getString(r11, r3)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                goto L_0x006f
            L_0x017a:
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r2 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r8)
                goto L_0x006f
            L_0x018f:
                r2 = r24
                boolean r1 = r2.isIBuyLive(r1)
                r12 = 2131821138(0x7f110252, float:1.927501E38)
                if (r1 == 0) goto L_0x01fd
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r1 = r0.this$0
                r1.isBidLive = r5
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r11 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r11)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r1.setText(r12)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r11 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r11)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r8)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r4 = com.iaai.android.C2723R.C2726id.llBidButtonAuction
                android.view.View r1 = r1.findViewById(r4)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                r1.setVisibility(r9)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.btnBidAuction
                android.view.View r1 = r1.findViewById(r3)
                android.widget.Button r1 = (android.widget.Button) r1
                r3 = 2131821151(0x7f11025f, float:1.9275037E38)
                r1.setText(r3)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r8)
                goto L_0x02b7
            L_0x01fd:
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r1 = r0.this$0
                r1.isBidLive = r9
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r13 = com.iaai.android.C2723R.C2726id.llBidButtonAuction
                android.view.View r1 = r1.findViewById(r13)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                r1.setVisibility(r9)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r1.setText(r12)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvPreBidCloseTime
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r8)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.btnBidAuction
                android.view.View r1 = r1.findViewById(r3)
                android.widget.Button r1 = (android.widget.Button) r1
                r3 = 2131821193(0x7f110289, float:1.9275122E38)
                r1.setText(r3)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r1 = r0.this$0
                java.lang.String r3 = r24.getLiveDate()
                if (r3 == 0) goto L_0x0254
                goto L_0x0255
            L_0x0254:
                r3 = r6
            L_0x0255:
                boolean r1 = r1.getIsAuctionToday(r3)
                if (r1 == 0) goto L_0x02a4
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r9)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r3 = r0.this$0
                android.content.Context r3 = r3.getMContext()
                android.content.res.Resources r3 = r3.getResources()
                java.lang.Object[] r4 = new java.lang.Object[r5]
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r7 = r0.this$0
                java.lang.String r12 = r24.getLiveDate()
                if (r12 == 0) goto L_0x0293
                goto L_0x0294
            L_0x0293:
                r12 = r6
            L_0x0294:
                java.lang.String r7 = r7.getDateText(r12, r9)
                r4[r9] = r7
                java.lang.String r3 = r3.getString(r11, r4)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r1.setText(r3)
                goto L_0x02b7
            L_0x02a4:
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvAuctionStatus
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                r1.setVisibility(r8)
            L_0x02b7:
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvAuctionBranch
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r3 = "itemView.tvAuctionBranch"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                r1.setPaintFlags(r8)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r4 = com.iaai.android.C2723R.C2726id.tvAuctionBranch
                android.view.View r1 = r1.findViewById(r4)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                java.lang.String r3 = r24.getName()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r1.setText(r3)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvAuctionStateName
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r3 = "itemView.tvAuctionStateName"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = r24.getCity()
                r3.append(r4)
                java.lang.String r4 = ", "
                r3.append(r4)
                java.lang.String r4 = r24.getState()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r1.setText(r3)
                com.iaai.android.bdt.utils.NewDateHelper r1 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
                java.lang.String r3 = r24.getLiveDate()
                if (r3 == 0) goto L_0x0321
                goto L_0x0322
            L_0x0321:
                r3 = r6
            L_0x0322:
                java.lang.String r11 = r1.getAuctionTimeLiveCalender(r3)
                r14 = 0
                r15 = 4
                r16 = 0
                java.lang.String r12 = "AM"
                java.lang.String r13 = "am"
                java.lang.String r17 = kotlin.text.StringsKt.replace$default((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (int) r15, (java.lang.Object) r16)
                r20 = 0
                r21 = 4
                r22 = 0
                java.lang.String r18 = "PM"
                java.lang.String r19 = "pm"
                java.lang.String r1 = kotlin.text.StringsKt.replace$default((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (boolean) r20, (int) r21, (java.lang.Object) r22)
                android.view.View r3 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r10)
                int r4 = com.iaai.android.C2723R.C2726id.tvAuctionTime
                android.view.View r3 = r3.findViewById(r4)
                android.widget.TextView r3 = (android.widget.TextView) r3
                java.lang.String r4 = "itemView.tvAuctionTime"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r3.setText(r1)
                java.lang.Integer r1 = r24.getVehiclecount()
                java.lang.String r3 = " "
                if (r1 != 0) goto L_0x0364
                goto L_0x037c
            L_0x0364:
                int r1 = r1.intValue()
                if (r1 != r5) goto L_0x037c
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r3 = r0.this$0
                android.content.Context r3 = r3.getMContext()
                r4 = 2131821249(0x7f1102c1, float:1.9275236E38)
                goto L_0x038d
            L_0x037c:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r3 = r0.this$0
                android.content.Context r3 = r3.getMContext()
                r4 = 2131821206(0x7f110296, float:1.9275149E38)
            L_0x038d:
                java.lang.String r3 = r3.getString(r4)
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                java.lang.Integer r3 = r24.getVehiclecount()
                java.lang.String r3 = java.lang.String.valueOf(r3)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                android.view.View r3 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r10)
                int r4 = com.iaai.android.C2723R.C2726id.tvVehicleCount
                android.view.View r3 = r3.findViewById(r4)
                android.widget.TextView r3 = (android.widget.TextView) r3
                java.lang.String r4 = "itemView.tvVehicleCount"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r3.setText(r1)
                android.view.View r1 = r0.itemView
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r10)
                int r3 = com.iaai.android.C2723R.C2726id.tvPublicAuction
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r3 = "itemView.tvPublicAuction"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                java.lang.Boolean r2 = r24.getPublicAuction()
                if (r2 != 0) goto L_0x03e1
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x03e1:
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L_0x03e8
                r8 = 0
            L_0x03e8:
                r1.setVisibility(r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter.ViewHolder.updateBindingData(com.iaai.android.bdt.model.auctionmainlist.AuctionLocations):void");
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter$AuctionMainEmptyViewHolder;", "Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "auctionEmptySepartorBinding", "Lcom/iaai/android/databinding/RowItemAuctionEmptySeparatorLayoutBinding;", "(Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter;Lcom/iaai/android/databinding/RowItemAuctionEmptySeparatorLayoutBinding;)V", "bind", "", "item", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTAuctionMainListAdapter.kt */
    public final class AuctionMainEmptyViewHolder extends BaseViewHolder<AuctionLocations> {
        final /* synthetic */ BDTAuctionMainListAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AuctionMainEmptyViewHolder(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r2, com.iaai.android.databinding.RowItemAuctionEmptySeparatorLayoutBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "auctionEmptySepartorBinding"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
                r1.this$0 = r2
                android.view.View r2 = r3.getRoot()
                java.lang.String r3 = "auctionEmptySepartorBinding.root"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter.AuctionMainEmptyViewHolder.<init>(com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter, com.iaai.android.databinding.RowItemAuctionEmptySeparatorLayoutBinding):void");
        }

        public void bind(@NotNull AuctionLocations auctionLocations) {
            Intrinsics.checkParameterIsNotNull(auctionLocations, "item");
            throw new NotImplementedError("An operation is not implemented: " + "not implemented");
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter$BaseViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTAuctionMainListAdapter.kt */
    public static abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        public abstract void bind(@NotNull AuctionLocations auctionLocations);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
        }
    }

    /* access modifiers changed from: private */
    public final String getDateText(String str, boolean z) {
        String auctionMainPageTimeString;
        if (!(!Intrinsics.areEqual((Object) str, (Object) ""))) {
            return "";
        }
        NewDateHelper.TimeDiff calculateDateTimeDiff = NewDateHelper.INSTANCE.calculateDateTimeDiff(new Date(), NewDateHelper.INSTANCE.parseDateInServerTimezone(str));
        if (z) {
            if (calculateDateTimeDiff == null || (auctionMainPageTimeString = calculateDateTimeDiff.getPreBidTimeString()) == null) {
                return "";
            }
        } else if (calculateDateTimeDiff == null || (auctionMainPageTimeString = calculateDateTimeDiff.getAuctionMainPageTimeString()) == null) {
            return "";
        }
        return auctionMainPageTimeString;
    }

    /* access modifiers changed from: private */
    public final boolean getIsAuctionToday(String str) {
        if (!(!Intrinsics.areEqual((Object) str, (Object) ""))) {
            return false;
        }
        return NewDateHelper.INSTANCE.isSameDay(new Date(), NewDateHelper.INSTANCE.parseDateInServerTimezone(str));
    }
}
