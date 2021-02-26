package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterViewModel;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.RefinerHeaderAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.databinding.ItemAuctionSalesListBinding;
import com.iaai.android.databinding.RowItemFastSearchRefinerHeaderBinding;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 J2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003JKLB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u00105\u001a\u00020\u0012H\u0016J\u0010\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0012H\u0016J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0012H\u0016J\u000e\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\u0012J\u0016\u0010A\u001a\u0002092\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020CJ\u0015\u0010D\u001a\u0002092\b\u0010E\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010FJ\u0016\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\u00152\u0006\u0010I\u001a\u00020\u0012R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0015`\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0012\u00103\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u00104¨\u0006M"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fastSearchViewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListener;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;Landroid/content/Context;Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListener;)V", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "getConstraintSet", "()Landroidx/constraintlayout/widget/ConstraintSet;", "setConstraintSet", "(Landroidx/constraintlayout/widget/ConstraintSet;)V", "deviceWidth", "", "hashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "imageContainerWidth", "isOffsiteTruncate", "isPublicTruncate", "isRunDriveTruncate", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "getListener", "()Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListener;", "getMContext", "()Landroid/content/Context;", "refinerHeaderAdapter", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter;", "getRefinerHeaderAdapter", "()Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter;", "setRefinerHeaderAdapter", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter;)V", "refinerResultHeaderModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultHeaderModel;", "getRefinerResultHeaderModel", "()Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultHeaderModel;", "setRefinerResultHeaderModel", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultHeaderModel;)V", "selectedIemID", "Ljava/lang/Integer;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setDeviceWidth", "width", "setHeaderItem", "refinerResultFragment", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment;", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Integer;)V", "setWatchingData", "isWatching", "itemID", "Companion", "HeaderDataViewHolder", "ResultDataItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultListAdapter.kt */
public final class RefinerResultListAdapter extends PagedListAdapter<FormattedResult, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    @NotNull
    private ConstraintSet constraintSet = new ConstraintSet();
    private int deviceWidth;
    private final FastSearchFilterViewModel fastSearchViewModel;
    @NotNull
    private final HashMap<Integer, Boolean> hashMap = new HashMap<>();
    private int imageContainerWidth;
    /* access modifiers changed from: private */
    public boolean isOffsiteTruncate;
    /* access modifiers changed from: private */
    public boolean isPublicTruncate;
    /* access modifiers changed from: private */
    public boolean isRunDriveTruncate;
    @NotNull
    private LinearLayoutManager layoutManager = new LinearLayoutManager(this.mContext, 0, false);
    @NotNull
    private final RefinerResultListener listener;
    @NotNull
    private final Context mContext;
    @NotNull
    public RefinerHeaderAdapter refinerHeaderAdapter;
    @NotNull
    public RefinerResultHeaderModel refinerResultHeaderModel;
    /* access modifiers changed from: private */
    public Integer selectedIemID = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefinerResultListAdapter(@NotNull FastSearchFilterViewModel fastSearchFilterViewModel, @NotNull Context context, @NotNull RefinerResultListener refinerResultListener) {
        super(FormattedResult.Companion.getDIFF_CALLBACK());
        Intrinsics.checkParameterIsNotNull(fastSearchFilterViewModel, "fastSearchViewModel");
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(refinerResultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.fastSearchViewModel = fastSearchFilterViewModel;
        this.mContext = context;
        this.listener = refinerResultListener;
    }

    public static final /* synthetic */ FormattedResult access$getItem(RefinerResultListAdapter refinerResultListAdapter, int i) {
        return (FormattedResult) refinerResultListAdapter.getItem(i);
    }

    @NotNull
    public final RefinerResultListener getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final RefinerHeaderAdapter getRefinerHeaderAdapter() {
        RefinerHeaderAdapter refinerHeaderAdapter2 = this.refinerHeaderAdapter;
        if (refinerHeaderAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerHeaderAdapter");
        }
        return refinerHeaderAdapter2;
    }

    public final void setRefinerHeaderAdapter(@NotNull RefinerHeaderAdapter refinerHeaderAdapter2) {
        Intrinsics.checkParameterIsNotNull(refinerHeaderAdapter2, "<set-?>");
        this.refinerHeaderAdapter = refinerHeaderAdapter2;
    }

    @NotNull
    public final RefinerResultHeaderModel getRefinerResultHeaderModel() {
        RefinerResultHeaderModel refinerResultHeaderModel2 = this.refinerResultHeaderModel;
        if (refinerResultHeaderModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultHeaderModel");
        }
        return refinerResultHeaderModel2;
    }

    public final void setRefinerResultHeaderModel(@NotNull RefinerResultHeaderModel refinerResultHeaderModel2) {
        Intrinsics.checkParameterIsNotNull(refinerResultHeaderModel2, "<set-?>");
        this.refinerResultHeaderModel = refinerResultHeaderModel2;
    }

    @NotNull
    public final HashMap<Integer, Boolean> getHashMap() {
        return this.hashMap;
    }

    @NotNull
    public final LinearLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public final void setLayoutManager(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkParameterIsNotNull(linearLayoutManager, "<set-?>");
        this.layoutManager = linearLayoutManager;
    }

    @NotNull
    public final ConstraintSet getConstraintSet() {
        return this.constraintSet;
    }

    public final void setConstraintSet(@NotNull ConstraintSet constraintSet2) {
        Intrinsics.checkParameterIsNotNull(constraintSet2, "<set-?>");
        this.constraintSet = constraintSet2;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerResultListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return RefinerResultListAdapter.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return RefinerResultListAdapter.TYPE_ITEM;
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ItemAuctionSalesListBinding inflate = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemAuctionSalesListBind…tInflater, parent, false)");
        objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate);
        if (i == TYPE_HEADER) {
            RowItemFastSearchRefinerHeaderBinding inflate2 = RowItemFastSearchRefinerHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "RowItemFastSearchRefiner…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new HeaderDataViewHolder(this, inflate2);
            View view = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            ((TextView) view.findViewById(C2723R.C2726id.tv_filter_label)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$1(this, objectRef));
            View view2 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ((TextView) view2.findViewById(C2723R.C2726id.tv_filterCount)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$2(this, objectRef));
            View view3 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            ((ImageView) view3.findViewById(C2723R.C2726id.img_filter)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$3(this, objectRef));
            View view4 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
            ((ImageView) view4.findViewById(C2723R.C2726id.iv_sort)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$4(this, objectRef));
            View view5 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
            ((TextView) view5.findViewById(C2723R.C2726id.tv_SortLabel)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$5(this, objectRef));
        } else if (i == TYPE_ITEM) {
            ItemAuctionSalesListBinding inflate3 = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemAuctionSalesListBind…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate3);
            View view6 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
            ((FrameLayout) view6.findViewById(C2723R.C2726id.fl_unwatch)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$6(this, objectRef));
            View view7 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view7, "holder.itemView");
            ((FrameLayout) view7.findViewById(C2723R.C2726id.fl_watch)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$7(this, objectRef));
            View view8 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view8, "holder.itemView");
            ((LinearLayout) view8.findViewById(C2723R.C2726id.llUnWatch)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$8(this, objectRef));
            View view9 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view9, "holder.itemView");
            ((LinearLayout) view9.findViewById(C2723R.C2726id.llWatch)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$9(this, objectRef));
            View view10 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view10, "holder.itemView");
            ((ConstraintLayout) view10.findViewById(C2723R.C2726id.parent_item)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$10(this, objectRef));
            View view11 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view11, "holder.itemView");
            ((ImageView) view11.findViewById(C2723R.C2726id.img_arrow_right)).setOnClickListener(new RefinerResultListAdapter$onCreateViewHolder$11(this, objectRef));
        }
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() <= 0) {
            return;
        }
        if (viewHolder instanceof ResultDataItemViewHolder) {
            int i2 = i - 1;
            FormattedResult formattedResult = (FormattedResult) getItem(i2);
            ((ResultDataItemViewHolder) viewHolder).bindTo((FormattedResult) getItem(i2));
        } else if (viewHolder instanceof HeaderDataViewHolder) {
            ((HeaderDataViewHolder) viewHolder).bindTo();
        }
    }

    public final void setHeaderItem(@NotNull RefinerResultHeaderModel refinerResultHeaderModel2, @NotNull RefinerResultFragment refinerResultFragment) {
        Intrinsics.checkParameterIsNotNull(refinerResultHeaderModel2, "refinerResultHeaderModel");
        Intrinsics.checkParameterIsNotNull(refinerResultFragment, "refinerResultFragment");
        this.refinerHeaderAdapter = new RefinerHeaderAdapter(this.mContext);
        this.refinerResultHeaderModel = refinerResultHeaderModel2;
        RefinerHeaderAdapter refinerHeaderAdapter2 = this.refinerHeaderAdapter;
        if (refinerHeaderAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerHeaderAdapter");
        }
        refinerHeaderAdapter2.addHeaderListData(refinerResultHeaderModel2.getItemList(), refinerResultHeaderModel2.getIndicesList());
        RefinerHeaderAdapter refinerHeaderAdapter3 = this.refinerHeaderAdapter;
        if (refinerHeaderAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerHeaderAdapter");
        }
        refinerHeaderAdapter3.notifyDataSetChanged();
        RefinerHeaderAdapter refinerHeaderAdapter4 = this.refinerHeaderAdapter;
        if (refinerHeaderAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerHeaderAdapter");
        }
        refinerHeaderAdapter4.setClickListener(refinerResultFragment.getHeaderClickListener());
    }

    public final void setDeviceWidth(int i) {
        this.deviceWidth = i;
    }

    public final void setSelectedItemForTablet(@Nullable Integer num) {
        this.selectedIemID = num;
    }

    public int getItemViewType(int i) {
        return i == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    public int getItemCount() {
        if (this.refinerResultHeaderModel != null) {
            RefinerResultHeaderModel refinerResultHeaderModel2 = this.refinerResultHeaderModel;
            if (refinerResultHeaderModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultHeaderModel");
            }
            if (refinerResultHeaderModel2.isError()) {
                return 1;
            }
        }
        if (super.getItemCount() == 0) {
            return super.getItemCount();
        }
        return 1 + super.getItemCount();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListAdapter$HeaderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemFastSearchRefinerHeaderBinding;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListAdapter;Lcom/iaai/android/databinding/RowItemFastSearchRefinerHeaderBinding;)V", "isClickedEnabled", "", "()Z", "setClickedEnabled", "(Z)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerResultListAdapter.kt */
    public final class HeaderDataViewHolder extends RecyclerView.ViewHolder {
        private final RowItemFastSearchRefinerHeaderBinding binding;
        private boolean isClickedEnabled;
        final /* synthetic */ RefinerResultListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderDataViewHolder(@NotNull RefinerResultListAdapter refinerResultListAdapter, RowItemFastSearchRefinerHeaderBinding rowItemFastSearchRefinerHeaderBinding) {
            super(rowItemFastSearchRefinerHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemFastSearchRefinerHeaderBinding, "binding");
            this.this$0 = refinerResultListAdapter;
            this.binding = rowItemFastSearchRefinerHeaderBinding;
        }

        public final boolean isClickedEnabled() {
            return this.isClickedEnabled;
        }

        public final void setClickedEnabled(boolean z) {
            this.isClickedEnabled = z;
        }

        public final void bindTo() {
            Collection itemList = this.this$0.getRefinerResultHeaderModel().getItemList();
            if (itemList == null || itemList.isEmpty()) {
                RelativeLayout relativeLayout = this.binding.rlSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "binding.rlSearchSelectedRefiner");
                relativeLayout.setVisibility(8);
            } else {
                RelativeLayout relativeLayout2 = this.binding.rlSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "binding.rlSearchSelectedRefiner");
                relativeLayout2.setVisibility(0);
                RecyclerView recyclerView = this.binding.rvSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(recyclerView, "binding.rvSearchSelectedRefiner");
                recyclerView.setLayoutManager(this.this$0.getLayoutManager());
                RecyclerView recyclerView2 = this.binding.rvSearchSelectedRefiner;
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "binding.rvSearchSelectedRefiner");
                recyclerView2.setAdapter(this.this$0.getRefinerHeaderAdapter());
            }
            if (this.this$0.getRefinerResultHeaderModel().isError()) {
                View view = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.emptyView");
                TextView textView = (TextView) view.findViewById(C2723R.C2726id.errorTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.emptyView.errorTitle");
                textView.setText(this.this$0.getRefinerResultHeaderModel().getErrorMessage());
                View view2 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "binding.emptyView");
                TextView textView2 = (TextView) view2.findViewById(C2723R.C2726id.errorBody);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.emptyView.errorBody");
                textView2.setText(this.this$0.getRefinerResultHeaderModel().getErrorMessage());
                ConstraintLayout constraintLayout = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clEmptyView");
                constraintLayout.setVisibility(0);
            } else {
                ConstraintLayout constraintLayout2 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clEmptyView");
                constraintLayout2.setVisibility(8);
            }
            if (this.this$0.getRefinerResultHeaderModel().getFilterCount() != 0) {
                TextView textView3 = this.binding.tvFilterCount;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvFilterCount");
                textView3.setText(String.valueOf(this.this$0.getRefinerResultHeaderModel().getFilterCount()));
                TextView textView4 = this.binding.tvFilterCount;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvFilterCount");
                textView4.setVisibility(0);
                return;
            }
            TextView textView5 = this.binding.tvFilterCount;
            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvFilterCount");
            textView5.setVisibility(8);
        }
    }

    public final void setWatchingData(boolean z, int i) {
        if (z) {
            this.hashMap.put(Integer.valueOf(i), Boolean.valueOf(z));
        } else {
            this.hashMap.remove(Integer.valueOf(i));
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ&\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListAdapter$ResultDataItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListAdapter;Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;)V", "bindTo", "", "resultDatum", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "handleBadgeAlignment", "isPublicTruncate", "", "isRunDriveTruncate", "isOffsiteTruncate", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerResultListAdapter.kt */
    public final class ResultDataItemViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final ItemAuctionSalesListBinding binding;
        final /* synthetic */ RefinerResultListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultDataItemViewHolder(@NotNull RefinerResultListAdapter refinerResultListAdapter, ItemAuctionSalesListBinding itemAuctionSalesListBinding) {
            super(itemAuctionSalesListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            this.this$0 = refinerResultListAdapter;
            this.binding = itemAuctionSalesListBinding;
        }

        /* JADX WARNING: Removed duplicated region for block: B:109:0x0207  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x0215  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x0217  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x021c  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x0227  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x024a  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x024c  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x025d  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x0278  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x0284  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x0289  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0294  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x02ad  */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x02b6  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x02c3  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x02fb  */
        /* JADX WARNING: Removed duplicated region for block: B:157:0x034f  */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x0354  */
        /* JADX WARNING: Removed duplicated region for block: B:161:0x035d  */
        /* JADX WARNING: Removed duplicated region for block: B:162:0x0362  */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x0369  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x0392  */
        /* JADX WARNING: Removed duplicated region for block: B:168:0x03bc  */
        /* JADX WARNING: Removed duplicated region for block: B:169:0x03c5  */
        /* JADX WARNING: Removed duplicated region for block: B:171:0x03c8  */
        /* JADX WARNING: Removed duplicated region for block: B:182:0x046c  */
        /* JADX WARNING: Removed duplicated region for block: B:183:0x0485  */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x04f1  */
        /* JADX WARNING: Removed duplicated region for block: B:190:0x04f6  */
        /* JADX WARNING: Removed duplicated region for block: B:193:0x0512  */
        /* JADX WARNING: Removed duplicated region for block: B:194:0x0517  */
        /* JADX WARNING: Removed duplicated region for block: B:197:0x0529  */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x052e  */
        /* JADX WARNING: Removed duplicated region for block: B:203:0x053a  */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x053c  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x053f  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x0562  */
        /* JADX WARNING: Removed duplicated region for block: B:213:0x0570  */
        /* JADX WARNING: Removed duplicated region for block: B:214:0x0575  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x0581  */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x0583  */
        /* JADX WARNING: Removed duplicated region for block: B:222:0x0586  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x05a9  */
        /* JADX WARNING: Removed duplicated region for block: B:230:0x05d3  */
        /* JADX WARNING: Removed duplicated region for block: B:231:0x05dc  */
        /* JADX WARNING: Removed duplicated region for block: B:234:0x05e3  */
        /* JADX WARNING: Removed duplicated region for block: B:235:0x05f0  */
        /* JADX WARNING: Removed duplicated region for block: B:237:0x05fe  */
        /* JADX WARNING: Removed duplicated region for block: B:238:0x0603  */
        /* JADX WARNING: Removed duplicated region for block: B:241:0x060e  */
        /* JADX WARNING: Removed duplicated region for block: B:242:0x061b  */
        /* JADX WARNING: Removed duplicated region for block: B:244:0x0629  */
        /* JADX WARNING: Removed duplicated region for block: B:245:0x0632  */
        /* JADX WARNING: Removed duplicated region for block: B:248:0x0639  */
        /* JADX WARNING: Removed duplicated region for block: B:249:0x0646  */
        /* JADX WARNING: Removed duplicated region for block: B:252:0x06a1  */
        /* JADX WARNING: Removed duplicated region for block: B:255:0x06af  */
        /* JADX WARNING: Removed duplicated region for block: B:256:0x06bc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindTo(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult r13) {
            /*
                r12 = this;
                r0 = 0
                if (r13 == 0) goto L_0x0008
                java.lang.Integer r1 = r13.getItemId()
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                java.lang.Integer r2 = r2.selectedIemID
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
                if (r1 == 0) goto L_0x004d
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 23
                if (r1 < r2) goto L_0x0034
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r2 = r2.getColor(r3, r0)
                r1.setBackgroundColor(r2)
                goto L_0x0084
            L_0x0034:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r2 = r2.getColor(r3)
                r1.setBackgroundColor(r2)
                goto L_0x0084
            L_0x004d:
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 23
                if (r1 < r2) goto L_0x006c
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099728(0x7f060050, float:1.7811817E38)
                int r2 = r2.getColor(r3, r0)
                r1.setBackgroundColor(r2)
                goto L_0x0084
            L_0x006c:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.mainRowLayout
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                android.content.Context r2 = r2.getMContext()
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099728(0x7f060050, float:1.7811817E38)
                int r2 = r2.getColor(r3)
                r1.setBackgroundColor(r2)
            L_0x0084:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llWatch
                java.lang.String r2 = "binding.llWatch"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r3 = 8
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                java.lang.String r4 = "binding.llUnWatch"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r3)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                if (r13 == 0) goto L_0x00aa
                java.lang.Integer r5 = r13.getYear()
                goto L_0x00ab
            L_0x00aa:
                r5 = r0
            L_0x00ab:
                r1.append(r5)
                r5 = 32
                r1.append(r5)
                if (r13 == 0) goto L_0x00ba
                java.lang.String r6 = r13.getMake()
                goto L_0x00bb
            L_0x00ba:
                r6 = r0
            L_0x00bb:
                r1.append(r6)
                r1.append(r5)
                if (r13 == 0) goto L_0x00c8
                java.lang.String r6 = r13.getModel()
                goto L_0x00c9
            L_0x00c8:
                r6 = r0
            L_0x00c9:
                r1.append(r6)
                r1.append(r5)
                if (r13 == 0) goto L_0x00d6
                java.lang.String r6 = r13.getSeries()
                goto L_0x00d7
            L_0x00d6:
                r6 = r0
            L_0x00d7:
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                com.iaai.android.databinding.ItemAuctionSalesListBinding r6 = r12.binding
                android.widget.TextView r6 = r6.yearMakeModel
                java.lang.String r7 = "binding.yearMakeModel"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
                if (r1 == 0) goto L_0x06e2
                java.lang.String r1 = r1.toUpperCase()
                java.lang.String r7 = "(this as java.lang.String).toUpperCase()"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r6.setText(r1)
                if (r13 == 0) goto L_0x00fe
                java.lang.String r1 = r13.getLossType()
                goto L_0x00ff
            L_0x00fe:
                r1 = r0
            L_0x00ff:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r6 = 1
                r7 = 0
                if (r1 == 0) goto L_0x010e
                int r1 = r1.length()
                if (r1 != 0) goto L_0x010c
                goto L_0x010e
            L_0x010c:
                r1 = 0
                goto L_0x010f
            L_0x010e:
                r1 = 1
            L_0x010f:
                java.lang.String r8 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r1 == 0) goto L_0x0136
                if (r13 == 0) goto L_0x0134
                java.lang.String r1 = r13.getPrimaryDamage()
                if (r1 == 0) goto L_0x0134
                java.lang.String r1 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r1)
                if (r1 == 0) goto L_0x0134
                if (r1 == 0) goto L_0x012e
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
                java.lang.String r1 = r1.toString()
                goto L_0x018e
            L_0x012e:
                kotlin.TypeCastException r13 = new kotlin.TypeCastException
                r13.<init>(r8)
                throw r13
            L_0x0134:
                r1 = r0
                goto L_0x018e
            L_0x0136:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                if (r13 == 0) goto L_0x015c
                java.lang.String r9 = r13.getLossType()
                if (r9 == 0) goto L_0x015c
                java.lang.String r9 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r9)
                if (r9 == 0) goto L_0x015c
                if (r9 == 0) goto L_0x0156
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                java.lang.CharSequence r9 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r9)
                java.lang.String r9 = r9.toString()
                goto L_0x015d
            L_0x0156:
                kotlin.TypeCastException r13 = new kotlin.TypeCastException
                r13.<init>(r8)
                throw r13
            L_0x015c:
                r9 = r0
            L_0x015d:
                r1.append(r9)
                java.lang.String r9 = ", "
                r1.append(r9)
                if (r13 == 0) goto L_0x0186
                java.lang.String r9 = r13.getPrimaryDamage()
                if (r9 == 0) goto L_0x0186
                java.lang.String r9 = com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(r9)
                if (r9 == 0) goto L_0x0186
                if (r9 == 0) goto L_0x0180
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                java.lang.CharSequence r8 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r9)
                java.lang.String r8 = r8.toString()
                goto L_0x0187
            L_0x0180:
                kotlin.TypeCastException r13 = new kotlin.TypeCastException
                r13.<init>(r8)
                throw r13
            L_0x0186:
                r8 = r0
            L_0x0187:
                r1.append(r8)
                java.lang.String r1 = r1.toString()
            L_0x018e:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvSeparator
                java.lang.String r9 = "binding.tvSeparator"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
                r8.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvAisleValue
                java.lang.String r9 = "binding.tvAisleValue"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
                r8.setVisibility(r3)
                if (r13 == 0) goto L_0x01ad
                java.lang.String r8 = r13.getOdometer()
                goto L_0x01ae
            L_0x01ad:
                r8 = r0
            L_0x01ae:
                if (r8 != 0) goto L_0x01b3
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x01b3:
                java.lang.String r9 = ""
                boolean r8 = r8.equals(r9)
                if (r8 == 0) goto L_0x01cc
                if (r13 == 0) goto L_0x01c2
                java.lang.String r8 = r13.getOdoBrand()
                goto L_0x01c3
            L_0x01c2:
                r8 = r0
            L_0x01c3:
                boolean r8 = r8.equals(r9)
                if (r8 == 0) goto L_0x01cc
                java.lang.String r5 = "Mileage Unavailable"
                goto L_0x0205
            L_0x01cc:
                if (r13 == 0) goto L_0x01d3
                java.lang.String r8 = r13.getOdometer()
                goto L_0x01d4
            L_0x01d3:
                r8 = r0
            L_0x01d4:
                boolean r8 = r8.equals(r9)
                if (r8 == 0) goto L_0x01e3
                if (r13 == 0) goto L_0x01e1
                java.lang.String r5 = r13.getOdoBrand()
                goto L_0x0205
            L_0x01e1:
                r5 = r0
                goto L_0x0205
            L_0x01e3:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                if (r13 == 0) goto L_0x01ef
                java.lang.String r9 = r13.getOdometer()
                goto L_0x01f0
            L_0x01ef:
                r9 = r0
            L_0x01f0:
                r8.append(r9)
                r8.append(r5)
                if (r13 == 0) goto L_0x01fd
                java.lang.String r5 = r13.getOdoBrand()
                goto L_0x01fe
            L_0x01fd:
                r5 = r0
            L_0x01fe:
                r8.append(r5)
                java.lang.String r5 = r8.toString()
            L_0x0205:
                if (r5 != 0) goto L_0x020a
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x020a:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0217
                int r8 = r1.length()
                if (r8 != 0) goto L_0x0215
                goto L_0x0217
            L_0x0215:
                r8 = 0
                goto L_0x0218
            L_0x0217:
                r8 = 1
            L_0x0218:
                java.lang.String r9 = "binding.tvPrimaryDamageValue"
                if (r8 == 0) goto L_0x0227
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvPrimaryDamageValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r9)
                r1.setVisibility(r3)
                goto L_0x023b
            L_0x0227:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvPrimaryDamageValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
                r8.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvPrimaryDamageValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
                r8.setText(r1)
            L_0x023b:
                java.lang.String r1 = r13.getTenant()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x024c
                int r1 = r1.length()
                if (r1 != 0) goto L_0x024a
                goto L_0x024c
            L_0x024a:
                r1 = 0
                goto L_0x024d
            L_0x024c:
                r1 = 1
            L_0x024d:
                java.lang.String r8 = "binding.preSaleRow4Right"
                if (r1 != 0) goto L_0x0278
                java.lang.String r1 = r13.getTenant()
                java.lang.String r9 = "US"
                boolean r1 = kotlin.text.StringsKt.equals(r1, r9, r6)
                if (r1 != 0) goto L_0x0278
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.preSaleRow4Right
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.preSaleRow4Right
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                java.lang.String r8 = r13.getTenant()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r1.setText(r8)
                goto L_0x0282
            L_0x0278:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.preSaleRow4Right
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r3)
            L_0x0282:
                if (r13 == 0) goto L_0x0289
                java.lang.String r1 = r13.getAuctionLane()
                goto L_0x028a
            L_0x0289:
                r1 = r0
            L_0x028a:
                r8 = r1
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                boolean r8 = kotlin.text.StringsKt.isBlank(r8)
                r8 = r8 ^ r6
                if (r8 == 0) goto L_0x02a5
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r1)
                java.lang.String r1 = " -#"
                r8.append(r1)
                java.lang.String r1 = r8.toString()
            L_0x02a5:
                if (r13 == 0) goto L_0x02b6
                java.lang.String r8 = r13.getBranchName()
                if (r8 == 0) goto L_0x02b6
                int r8 = r8.length()
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                goto L_0x02b7
            L_0x02b6:
                r8 = r0
            L_0x02b7:
                int r8 = r8.intValue()
                r9 = 15
                java.lang.String r10 = "binding.tvLongDataLane"
                java.lang.String r11 = "binding.tvLaneSalesValue"
                if (r8 <= r9) goto L_0x02fb
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvLaneSalesValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r11)
                r8.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvLongDataLane
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r10)
                r8.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvLongDataLane
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r10)
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r1)
                if (r13 == 0) goto L_0x02ed
                java.lang.String r1 = r13.getItemNumber()
                goto L_0x02ee
            L_0x02ed:
                r1 = r0
            L_0x02ee:
                r9.append(r1)
                java.lang.String r1 = r9.toString()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r8.setText(r1)
                goto L_0x0332
            L_0x02fb:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvLaneSalesValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r11)
                r8.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvLongDataLane
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r10)
                r8.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r8 = r12.binding
                android.widget.TextView r8 = r8.tvLaneSalesValue
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r11)
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r1)
                if (r13 == 0) goto L_0x0325
                java.lang.String r1 = r13.getItemNumber()
                goto L_0x0326
            L_0x0325:
                r1 = r0
            L_0x0326:
                r9.append(r1)
                java.lang.String r1 = r9.toString()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r8.setText(r1)
            L_0x0332:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.preSaleRow3Right
                java.lang.String r8 = "binding.preSaleRow3Right"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                r1.setFormattedResult(r13)
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r1 = r12.this$0
                java.util.HashMap r1 = r1.getHashMap()
                java.util.Map r1 = (java.util.Map) r1
                if (r13 == 0) goto L_0x0354
                java.lang.Integer r5 = r13.getItemId()
                goto L_0x0355
            L_0x0354:
                r5 = r0
            L_0x0355:
                java.lang.Object r1 = r1.get(r5)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                if (r1 == 0) goto L_0x0362
                boolean r1 = r1.booleanValue()
                goto L_0x0363
            L_0x0362:
                r1 = 0
            L_0x0363:
                java.lang.String r5 = "binding.flWatch"
                java.lang.String r8 = "binding.flUnwatch"
                if (r1 == 0) goto L_0x0392
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setVisibility(r3)
                goto L_0x03ba
            L_0x0392:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setVisibility(r7)
            L_0x03ba:
                if (r13 == 0) goto L_0x03c5
                boolean r1 = r13.isWatchable()
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                goto L_0x03c6
            L_0x03c5:
                r1 = r0
            L_0x03c6:
                if (r1 == 0) goto L_0x0420
                if (r13 == 0) goto L_0x03d3
                boolean r1 = r13.isWatchable()
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                goto L_0x03d4
            L_0x03d3:
                r1 = r0
            L_0x03d4:
                if (r1 != 0) goto L_0x03d9
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x03d9:
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x0420
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setEnabled(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setEnabled(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r4 = 1065353216(0x3f800000, float:1.0)
                r1.setAlpha(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r2 = 1065353216(0x3f800000, float:1.0)
                r1.setAlpha(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setEnabled(r6)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setEnabled(r6)
                goto L_0x0460
            L_0x0420:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUnWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
                r4 = 1056964608(0x3f000000, float:0.5)
                r1.setAlpha(r4)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r2 = 1056964608(0x3f000000, float:0.5)
                r1.setAlpha(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flUnwatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r8)
                r1.setEnabled(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.FrameLayout r1 = r1.flWatch
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
                r1.setEnabled(r7)
            L_0x0460:
                java.lang.String r1 = r13.getTenant()
                java.lang.String r2 = "CA"
                boolean r1 = kotlin.text.StringsKt.equals(r1, r2, r6)
                if (r1 == 0) goto L_0x0485
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUKFlag
                java.lang.String r2 = "binding.llUKFlag"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llCAFlag
                java.lang.String r2 = "binding.llCAFlag"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                goto L_0x04c2
            L_0x0485:
                java.lang.String r1 = r13.getTenant()
                java.lang.String r2 = "UK"
                boolean r1 = kotlin.text.StringsKt.equals(r1, r2, r6)
                if (r1 == 0) goto L_0x04aa
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUKFlag
                java.lang.String r2 = "binding.llUKFlag"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llCAFlag
                java.lang.String r2 = "binding.llCAFlag"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
                goto L_0x04c2
            L_0x04aa:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llUKFlag
                java.lang.String r2 = "binding.llUKFlag"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llCAFlag
                java.lang.String r2 = "binding.llCAFlag"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x04c2:
                com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
                r1.<init>()
                com.bumptech.glide.request.RequestOptions r1 = r1.centerCrop()
                r2 = 2131231231(0x7f0801ff, float:1.8078537E38)
                com.bumptech.glide.request.RequestOptions r1 = r1.error((int) r2)
                com.bumptech.glide.load.engine.DiskCacheStrategy r2 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
                com.bumptech.glide.request.RequestOptions r1 = r1.diskCacheStrategy(r2)
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.HIGH
                com.bumptech.glide.request.RequestOptions r1 = r1.priority(r2)
                r2 = 2131231567(0x7f08034f, float:1.8079219E38)
                com.bumptech.glide.request.RequestOptions r1 = r1.placeholder((int) r2)
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                android.content.Context r2 = r2.getMContext()
                com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
                if (r13 == 0) goto L_0x04f6
                java.lang.String r4 = r13.getImageUrl()
                goto L_0x04f7
            L_0x04f6:
                r4 = r0
            L_0x04f7:
                com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.String) r4)
                com.bumptech.glide.RequestBuilder r2 = r2.apply(r1)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r4 = r12.binding
                android.widget.ImageView r4 = r4.vehicleImage1
                r2.into((android.widget.ImageView) r4)
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                android.content.Context r2 = r2.getMContext()
                com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
                if (r13 == 0) goto L_0x0517
                java.lang.String r4 = r13.getImageUrl()
                goto L_0x0518
            L_0x0517:
                r4 = r0
            L_0x0518:
                com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.String) r4)
                com.bumptech.glide.RequestBuilder r1 = r2.apply(r1)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r2 = r12.binding
                android.widget.ImageView r2 = r2.vehicleImage2
                r1.into((android.widget.ImageView) r2)
                if (r13 == 0) goto L_0x052e
                java.lang.String r1 = r13.getBranchName()
                goto L_0x052f
            L_0x052e:
                r1 = r0
            L_0x052f:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x053c
                int r1 = r1.length()
                if (r1 != 0) goto L_0x053a
                goto L_0x053c
            L_0x053a:
                r1 = 0
                goto L_0x053d
            L_0x053c:
                r1 = 1
            L_0x053d:
                if (r1 != 0) goto L_0x0562
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvBranchName
                java.lang.String r2 = "binding.tvBranchName"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvBranchName
                java.lang.String r2 = "binding.tvBranchName"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                if (r13 == 0) goto L_0x055b
                java.lang.String r2 = r13.getBranchName()
                goto L_0x055c
            L_0x055b:
                r2 = r0
            L_0x055c:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                goto L_0x056e
            L_0x0562:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvBranchName
                java.lang.String r2 = "binding.tvBranchName"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x056e:
                if (r13 == 0) goto L_0x0575
                java.lang.String r1 = r13.getLiveDateTime()
                goto L_0x0576
            L_0x0575:
                r1 = r0
            L_0x0576:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0583
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0581
                goto L_0x0583
            L_0x0581:
                r1 = 0
                goto L_0x0584
            L_0x0583:
                r1 = 1
            L_0x0584:
                if (r1 != 0) goto L_0x05a9
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvAuctionTime
                java.lang.String r2 = "binding.tvAuctionTime"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvAuctionTime
                java.lang.String r2 = "binding.tvAuctionTime"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                if (r13 == 0) goto L_0x05a2
                java.lang.String r2 = r13.getLiveDateTime()
                goto L_0x05a3
            L_0x05a2:
                r2 = r0
            L_0x05a3:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                goto L_0x05b5
            L_0x05a9:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvAuctionTime
                java.lang.String r2 = "binding.tvAuctionTime"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x05b5:
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r1 = r12.this$0
                r1.isOffsiteTruncate = r7
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r1 = r12.this$0
                r1.isRunDriveTruncate = r7
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r1 = r12.this$0
                r1.isPublicTruncate = r7
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.LinearLayout r1 = r1.llBadgeConatiner
                java.lang.String r2 = "binding.llBadgeConatiner"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r2 = 4
                r1.setVisibility(r2)
                if (r13 == 0) goto L_0x05dc
                boolean r1 = r13.getRunAndDrive()
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                goto L_0x05dd
            L_0x05dc:
                r1 = r0
            L_0x05dd:
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x05f0
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvRunDrive
                java.lang.String r2 = "binding.tvRunDrive"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                goto L_0x05fc
            L_0x05f0:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvRunDrive
                java.lang.String r2 = "binding.tvRunDrive"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x05fc:
                if (r13 == 0) goto L_0x0603
                java.lang.Boolean r1 = r13.getOffSiteSaleIndicator()
                goto L_0x0604
            L_0x0603:
                r1 = r0
            L_0x0604:
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r6)
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
                if (r1 == 0) goto L_0x061b
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvOffsite
                java.lang.String r2 = "binding.tvOffsite"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                goto L_0x0627
            L_0x061b:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvOffsite
                java.lang.String r2 = "binding.tvOffsite"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x0627:
                if (r13 == 0) goto L_0x0632
                boolean r1 = r13.getPublicVehicle()
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                goto L_0x0633
            L_0x0632:
                r1 = r0
            L_0x0633:
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x0646
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvIsPublic
                java.lang.String r2 = "binding.tvIsPublic"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r7)
                goto L_0x0652
            L_0x0646:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvIsPublic
                java.lang.String r2 = "binding.tvIsPublic"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                r1.setVisibility(r3)
            L_0x0652:
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvIsPublic
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter$ResultDataItemViewHolder$bindTo$1 r2 = new com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter$ResultDataItemViewHolder$bindTo$1
                r2.<init>(r12)
                android.view.ViewTreeObserver$OnPreDrawListener r2 = (android.view.ViewTreeObserver.OnPreDrawListener) r2
                r1.addOnPreDrawListener(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvRunDrive
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter$ResultDataItemViewHolder$bindTo$2 r2 = new com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter$ResultDataItemViewHolder$bindTo$2
                r2.<init>(r12)
                android.view.ViewTreeObserver$OnPreDrawListener r2 = (android.view.ViewTreeObserver.OnPreDrawListener) r2
                r1.addOnPreDrawListener(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                android.widget.TextView r1 = r1.tvOffsite
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter$ResultDataItemViewHolder$bindTo$3 r2 = new com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter$ResultDataItemViewHolder$bindTo$3
                r2.<init>(r12)
                android.view.ViewTreeObserver$OnPreDrawListener r2 = (android.view.ViewTreeObserver.OnPreDrawListener) r2
                r1.addOnPreDrawListener(r2)
                com.iaai.android.databinding.ItemAuctionSalesListBinding r1 = r12.binding
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r2 = r12.this$0
                boolean r2 = r2.isPublicTruncate
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r4 = r12.this$0
                boolean r4 = r4.isRunDriveTruncate
                com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r5 = r12.this$0
                boolean r5 = r5.isOffsiteTruncate
                r12.handleBadgeAlignment(r1, r2, r4, r5)
                if (r13 == 0) goto L_0x06a5
                java.lang.Boolean r0 = r13.getTBOIndicator()
            L_0x06a5:
                java.lang.Boolean r13 = java.lang.Boolean.valueOf(r6)
                boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r13)
                if (r13 == 0) goto L_0x06bc
                com.iaai.android.databinding.ItemAuctionSalesListBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvTitleNotAvailable
                java.lang.String r0 = "binding.tvTitleNotAvailable"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r0)
                r13.setVisibility(r7)
                goto L_0x06e1
            L_0x06bc:
                java.lang.Boolean r13 = java.lang.Boolean.valueOf(r7)
                boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r13)
                if (r13 == 0) goto L_0x06d3
                com.iaai.android.databinding.ItemAuctionSalesListBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvTitleNotAvailable
                java.lang.String r0 = "binding.tvTitleNotAvailable"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r0)
                r13.setVisibility(r3)
                goto L_0x06e1
            L_0x06d3:
                if (r0 != 0) goto L_0x06e1
                com.iaai.android.databinding.ItemAuctionSalesListBinding r13 = r12.binding
                android.widget.TextView r13 = r13.tvTitleNotAvailable
                java.lang.String r0 = "binding.tvTitleNotAvailable"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r0)
                r13.setVisibility(r3)
            L_0x06e1:
                return
            L_0x06e2:
                kotlin.TypeCastException r13 = new kotlin.TypeCastException
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                r13.<init>(r0)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter.ResultDataItemViewHolder.bindTo(com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult):void");
        }

        public final void handleBadgeAlignment(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            if (z || z2 || z3) {
                LinearLayout linearLayout = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llBadgeConatiner");
                linearLayout.setGravity(5);
                this.this$0.getConstraintSet().clone(itemAuctionSalesListBinding.parentItem);
                ConstraintSet constraintSet = this.this$0.getConstraintSet();
                LinearLayout linearLayout2 = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llBadgeConatiner");
                int id = linearLayout2.getId();
                ConstraintLayout constraintLayout = itemAuctionSalesListBinding.parentItem;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.parentItem");
                constraintSet.connect(id, 6, constraintLayout.getId(), 6, 0);
                this.this$0.getConstraintSet().applyTo(itemAuctionSalesListBinding.parentItem);
            } else {
                LinearLayout linearLayout3 = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "binding.llBadgeConatiner");
                linearLayout3.setGravity(3);
                this.this$0.getConstraintSet().clone(itemAuctionSalesListBinding.parentItem);
                ConstraintSet constraintSet2 = this.this$0.getConstraintSet();
                LinearLayout linearLayout4 = itemAuctionSalesListBinding.llBadgeConatiner;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "binding.llBadgeConatiner");
                int id2 = linearLayout4.getId();
                ConstraintLayout constraintLayout2 = itemAuctionSalesListBinding.constraintLayout;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.constraintLayout");
                constraintSet2.connect(id2, 6, constraintLayout2.getId(), 6, 0);
                this.this$0.getConstraintSet().applyTo(itemAuctionSalesListBinding.parentItem);
            }
            LinearLayout linearLayout5 = itemAuctionSalesListBinding.llBadgeConatiner;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "binding.llBadgeConatiner");
            linearLayout5.setVisibility(0);
        }
    }
}
