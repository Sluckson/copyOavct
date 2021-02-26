package com.iaai.android.bdt.feature.account.tobepickedup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.databinding.ItemAuctionSalesListBinding;
import com.iaai.android.databinding.RowItemAuctinSalesListHeaderBinding;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003./0B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020 H\u0016J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nJ\u0015\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u00061"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/feature/account/tobepickedup/OnItemClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/account/tobepickedup/OnItemClickListener;)V", "auctionSalesListHeader", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "getAuctionSalesListHeader", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "setAuctionSalesListHeader", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;)V", "getListener", "()Lcom/iaai/android/bdt/feature/account/tobepickedup/OnItemClickListener;", "getMContext", "()Landroid/content/Context;", "selectedIemID", "", "Ljava/lang/Long;", "calculateDue", "", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "resultDatum", "getDate", "Ljava/util/Date;", "date", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHeaderItem", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Long;)V", "toBePickedUpRowItem", "Companion", "HeaderDataViewHolder", "ResultDataItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpAdapter.kt */
public final class ToBePickedUpAdapter extends PagedListAdapter<ToBePickedUpVehiclesModel, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    @NotNull
    public AuctionSalesListHeader auctionSalesListHeader;
    @NotNull
    private final OnItemClickListener listener;
    @NotNull
    private final Context mContext;
    private Long selectedIemID = -1L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToBePickedUpAdapter(@NotNull Context context, @NotNull OnItemClickListener onItemClickListener) {
        super(ToBePickedUpVehiclesModel.Companion.getDiffCallback());
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(onItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mContext = context;
        this.listener = onItemClickListener;
    }

    public static final /* synthetic */ ToBePickedUpVehiclesModel access$getItem(ToBePickedUpAdapter toBePickedUpAdapter, int i) {
        return (ToBePickedUpVehiclesModel) toBePickedUpAdapter.getItem(i);
    }

    @NotNull
    public final OnItemClickListener getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePickedUpAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return ToBePickedUpAdapter.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return ToBePickedUpAdapter.TYPE_ITEM;
        }
    }

    @NotNull
    public final AuctionSalesListHeader getAuctionSalesListHeader() {
        AuctionSalesListHeader auctionSalesListHeader2 = this.auctionSalesListHeader;
        if (auctionSalesListHeader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListHeader");
        }
        return auctionSalesListHeader2;
    }

    public final void setAuctionSalesListHeader(@NotNull AuctionSalesListHeader auctionSalesListHeader2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "<set-?>");
        this.auctionSalesListHeader = auctionSalesListHeader2;
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
            RowItemAuctinSalesListHeaderBinding inflate2 = RowItemAuctinSalesListHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "RowItemAuctinSalesListHe…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new HeaderDataViewHolder(this, inflate2);
            View view = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            ((ImageView) view.findViewById(C2723R.C2726id.iv_sort)).setOnClickListener(new ToBePickedUpAdapter$onCreateViewHolder$1(this, objectRef));
            View view2 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            ((TextView) view2.findViewById(C2723R.C2726id.tv_SortLabel)).setOnClickListener(new ToBePickedUpAdapter$onCreateViewHolder$2(this, objectRef));
        } else if (i == TYPE_ITEM) {
            ItemAuctionSalesListBinding inflate3 = ItemAuctionSalesListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemAuctionSalesListBind…tInflater, parent, false)");
            objectRef.element = (RecyclerView.ViewHolder) new ResultDataItemViewHolder(this, inflate3);
            View view3 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
            ((ConstraintLayout) view3.findViewById(C2723R.C2726id.parent_item)).setOnClickListener(new ToBePickedUpAdapter$onCreateViewHolder$3(this, objectRef));
            View view4 = ((RecyclerView.ViewHolder) objectRef.element).itemView;
            Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
            ((ImageView) view4.findViewById(C2723R.C2726id.img_arrow_right)).setOnClickListener(new ToBePickedUpAdapter$onCreateViewHolder$4(this, objectRef));
        }
        return (RecyclerView.ViewHolder) objectRef.element;
    }

    public final void setHeaderItem(@NotNull AuctionSalesListHeader auctionSalesListHeader2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListHeader2, "auctionSalesListHeader");
        this.auctionSalesListHeader = auctionSalesListHeader2;
    }

    public final void setSelectedItemForTablet(@Nullable Long l) {
        this.selectedIemID = l;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() <= 0) {
            return;
        }
        if (viewHolder instanceof ResultDataItemViewHolder) {
            ((ResultDataItemViewHolder) viewHolder).bindTo((ToBePickedUpVehiclesModel) getItem(i - 1));
        } else if (viewHolder instanceof HeaderDataViewHolder) {
            ((HeaderDataViewHolder) viewHolder).bindTo();
        }
    }

    public int getItemViewType(int i) {
        return i == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    public int getItemCount() {
        if (this.auctionSalesListHeader != null) {
            AuctionSalesListHeader auctionSalesListHeader2 = this.auctionSalesListHeader;
            if (auctionSalesListHeader2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListHeader");
            }
            if (auctionSalesListHeader2.isError()) {
                return 1;
            }
        }
        if (super.getItemCount() == 0) {
            return super.getItemCount();
        }
        return 1 + super.getItemCount();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpAdapter$HeaderDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;", "(Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpAdapter;Lcom/iaai/android/databinding/RowItemAuctinSalesListHeaderBinding;)V", "isClickedEnabled", "", "()Z", "setClickedEnabled", "(Z)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePickedUpAdapter.kt */
    public final class HeaderDataViewHolder extends RecyclerView.ViewHolder {
        private final RowItemAuctinSalesListHeaderBinding binding;
        private boolean isClickedEnabled;
        final /* synthetic */ ToBePickedUpAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderDataViewHolder(@NotNull ToBePickedUpAdapter toBePickedUpAdapter, RowItemAuctinSalesListHeaderBinding rowItemAuctinSalesListHeaderBinding) {
            super(rowItemAuctinSalesListHeaderBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemAuctinSalesListHeaderBinding, "binding");
            this.this$0 = toBePickedUpAdapter;
            this.binding = rowItemAuctinSalesListHeaderBinding;
        }

        public final boolean isClickedEnabled() {
            return this.isClickedEnabled;
        }

        public final void setClickedEnabled(boolean z) {
            this.isClickedEnabled = z;
        }

        public final void bindTo() {
            ConstraintLayout constraintLayout = this.binding.clHeader;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clHeader");
            constraintLayout.setVisibility(8);
            ImageView imageView = this.binding.imgFilter;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.imgFilter");
            imageView.setVisibility(8);
            TextView textView = this.binding.tvFilterCount;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvFilterCount");
            textView.setVisibility(8);
            TextView textView2 = this.binding.tvFilterLabel;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvFilterLabel");
            textView2.setVisibility(8);
            View view = this.binding.viewHeader;
            Intrinsics.checkExpressionValueIsNotNull(view, "binding.viewHeader");
            view.setVisibility(8);
            View view2 = this.binding.viewHeader;
            Intrinsics.checkExpressionValueIsNotNull(view2, "binding.viewHeader");
            view2.setVisibility(8);
            if (this.this$0.getAuctionSalesListHeader().isError()) {
                View view3 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view3, "binding.emptyView");
                TextView textView3 = (TextView) view3.findViewById(C2723R.C2726id.errorTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.emptyView.errorTitle");
                textView3.setText(this.this$0.getAuctionSalesListHeader().getErrorType().getValue());
                View view4 = this.binding.emptyView;
                Intrinsics.checkExpressionValueIsNotNull(view4, "binding.emptyView");
                TextView textView4 = (TextView) view4.findViewById(C2723R.C2726id.errorBody);
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.emptyView.errorBody");
                textView4.setText(this.this$0.getAuctionSalesListHeader().getErrorMessage());
                ConstraintLayout constraintLayout2 = this.binding.clEmptyView;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clEmptyView");
                constraintLayout2.setVisibility(0);
                return;
            }
            ConstraintLayout constraintLayout3 = this.binding.clEmptyView;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.clEmptyView");
            constraintLayout3.setVisibility(8);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpAdapter$ResultDataItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;", "(Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpAdapter;Lcom/iaai/android/databinding/ItemAuctionSalesListBinding;)V", "bindTo", "", "resultDatum", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePickedUpAdapter.kt */
    public final class ResultDataItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemAuctionSalesListBinding binding;
        final /* synthetic */ ToBePickedUpAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResultDataItemViewHolder(@NotNull ToBePickedUpAdapter toBePickedUpAdapter, ItemAuctionSalesListBinding itemAuctionSalesListBinding) {
            super(itemAuctionSalesListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
            this.this$0 = toBePickedUpAdapter;
            this.binding = itemAuctionSalesListBinding;
        }

        public final void bindTo(@Nullable ToBePickedUpVehiclesModel toBePickedUpVehiclesModel) {
            LinearLayout linearLayout = this.binding.llUnWatch;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llUnWatch");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.binding.llWatch;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llWatch");
            linearLayout2.setVisibility(8);
            TextView textView = this.binding.tvSeparator;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvSeparator");
            textView.setVisibility(8);
            this.this$0.toBePickedUpRowItem(this.binding, toBePickedUpVehiclesModel);
            RequestOptions placeholder = new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation);
            String str = null;
            Glide.with(this.this$0.getMContext()).load(toBePickedUpVehiclesModel != null ? toBePickedUpVehiclesModel.getImageUrl() : null).apply(placeholder).into(this.binding.vehicleImage1);
            RequestManager with = Glide.with(this.this$0.getMContext());
            if (toBePickedUpVehiclesModel != null) {
                str = toBePickedUpVehiclesModel.getImageUrl();
            }
            with.load(str).apply(placeholder).into(this.binding.vehicleImage2);
        }
    }

    public final void toBePickedUpRowItem(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, @Nullable ToBePickedUpVehiclesModel toBePickedUpVehiclesModel) {
        String str;
        String yearMakeModel;
        String camelCase;
        Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding, "binding");
        String str2 = null;
        CharSequence yearMakeModel2 = toBePickedUpVehiclesModel != null ? toBePickedUpVehiclesModel.getYearMakeModel() : null;
        if (yearMakeModel2 == null || yearMakeModel2.length() == 0) {
            str = "";
        } else if (toBePickedUpVehiclesModel == null || (yearMakeModel = toBePickedUpVehiclesModel.getYearMakeModel()) == null || (camelCase = String_ExtensionKt.toCamelCase(yearMakeModel)) == null) {
            str = null;
        } else if (camelCase != null) {
            str = StringsKt.trim((CharSequence) camelCase).toString();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        TextView textView = itemAuctionSalesListBinding.yearMakeModel;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.yearMakeModel");
        textView.setText(str);
        TextView textView2 = itemAuctionSalesListBinding.tvPrimaryDamageValue;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvPrimaryDamageValue");
        StringBuilder sb = new StringBuilder();
        sb.append("Stock # ");
        sb.append(toBePickedUpVehiclesModel != null ? toBePickedUpVehiclesModel.getStockNumber() : null);
        textView2.setText(sb.toString());
        calculateDue(itemAuctionSalesListBinding, toBePickedUpVehiclesModel);
        TextView textView3 = itemAuctionSalesListBinding.tvLaneSalesValue;
        Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvLaneSalesValue");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(toBePickedUpVehiclesModel != null ? toBePickedUpVehiclesModel.getBranchName() : null);
        sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (toBePickedUpVehiclesModel != null) {
            str2 = toBePickedUpVehiclesModel.getLaneItemNumber();
        }
        sb2.append(str2);
        textView3.setText(sb2.toString());
    }

    public final void calculateDue(@NotNull ItemAuctionSalesListBinding itemAuctionSalesListBinding, @Nullable ToBePickedUpVehiclesModel toBePickedUpVehiclesModel) {
        ItemAuctionSalesListBinding itemAuctionSalesListBinding2 = itemAuctionSalesListBinding;
        Intrinsics.checkParameterIsNotNull(itemAuctionSalesListBinding2, "binding");
        TextView textView = itemAuctionSalesListBinding2.preSaleRow3Right;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.preSaleRow3Right");
        textView.setBackground(this.mContext.getDrawable(C2723R.C2725drawable.tbpickup_no_customborder));
        TextView textView2 = itemAuctionSalesListBinding2.preSaleRow3Right;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.preSaleRow3Right");
        textView2.setTextSize(14.0f);
        String actionDate = toBePickedUpVehiclesModel != null ? toBePickedUpVehiclesModel.getActionDate() : null;
        Date date = null;
        new Date();
        if (actionDate != null) {
            date = getDate(actionDate);
            new Date();
        }
        Date resetTodayDateTimeToMidNight = AppUtils.resetTodayDateTimeToMidNight();
        if (date == null || resetTodayDateTimeToMidNight == null) {
            TextView textView3 = itemAuctionSalesListBinding2.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.preSaleRow3Right");
            textView3.setVisibility(8);
            return;
        }
        TextView textView4 = itemAuctionSalesListBinding2.preSaleRow3Right;
        Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.preSaleRow3Right");
        textView4.setVisibility(0);
        if (date.compareTo(resetTodayDateTimeToMidNight) > 0) {
            long time = (date.getTime() - resetTodayDateTimeToMidNight.getTime()) / ((long) 86400000);
            if (time == 0) {
                TextView textView5 = itemAuctionSalesListBinding2.preSaleRow3Right;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.preSaleRow3Right");
                textView5.setBackground(this.mContext.getDrawable(C2723R.C2725drawable.tbpickup_yellow_customborder));
                itemAuctionSalesListBinding2.preSaleRow3Right.setTextSize(2, 10.0f);
                TextView textView6 = itemAuctionSalesListBinding2.preSaleRow3Right;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.preSaleRow3Right");
                textView6.setText(this.mContext.getString(C2723R.string.lbl_srt_due).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(C2723R.string.lbl_today));
            } else if (time == 1) {
                TextView textView7 = itemAuctionSalesListBinding2.preSaleRow3Right;
                Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.preSaleRow3Right");
                textView7.setBackground(this.mContext.getDrawable(C2723R.C2725drawable.tbpickup_yellow_customborder));
                itemAuctionSalesListBinding2.preSaleRow3Right.setTextSize(2, 10.0f);
                TextView textView8 = itemAuctionSalesListBinding2.preSaleRow3Right;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.preSaleRow3Right");
                textView8.setText(this.mContext.getString(C2723R.string.lbl_srt_due).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(C2723R.string.lbl_tomorrow));
            } else {
                String format = new SimpleDateFormat(Constants.DATE_PATTERN_NEXT_AUCTION_DATE_SHORT).format(date);
                TextView textView9 = itemAuctionSalesListBinding2.preSaleRow3Right;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.preSaleRow3Right");
                textView9.setText(this.mContext.getString(C2723R.string.lbl_srt_due).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + format);
            }
        } else if (date.compareTo(resetTodayDateTimeToMidNight) < 0) {
            long time2 = (resetTodayDateTimeToMidNight.getTime() - date.getTime()) / ((long) 86400000);
            if (time2 != 0) {
                TextView textView10 = itemAuctionSalesListBinding2.preSaleRow3Right;
                Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.preSaleRow3Right");
                textView10.setBackground(this.mContext.getDrawable(C2723R.C2725drawable.orange_customborder));
                itemAuctionSalesListBinding2.preSaleRow3Right.setTextSize(2, 10.0f);
                if (time2 == 1) {
                    TextView textView11 = itemAuctionSalesListBinding2.preSaleRow3Right;
                    Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.preSaleRow3Right");
                    textView11.setText(this.mContext.getString(C2723R.string.tobe_pickedup_passdue).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + time2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(C2723R.string.tobe_pickedup_day));
                    return;
                }
                TextView textView12 = itemAuctionSalesListBinding2.preSaleRow3Right;
                Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.preSaleRow3Right");
                textView12.setText(this.mContext.getString(C2723R.string.tobe_pickedup_passdue).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + time2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(C2723R.string.tobe_pickedup_days));
                return;
            }
            TextView textView13 = itemAuctionSalesListBinding2.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.preSaleRow3Right");
            textView13.setBackground(this.mContext.getDrawable(C2723R.C2725drawable.tbpickup_yellow_customborder));
            itemAuctionSalesListBinding2.preSaleRow3Right.setTextSize(2, 10.0f);
            TextView textView14 = itemAuctionSalesListBinding2.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.preSaleRow3Right");
            textView14.setText(this.mContext.getString(C2723R.string.lbl_srt_due).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(C2723R.string.lbl_today));
        } else if (date.compareTo(resetTodayDateTimeToMidNight) == 0) {
            TextView textView15 = itemAuctionSalesListBinding2.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView15, "binding.preSaleRow3Right");
            textView15.setBackground(this.mContext.getDrawable(C2723R.C2725drawable.tbpickup_yellow_customborder));
            itemAuctionSalesListBinding2.preSaleRow3Right.setTextSize(2, 10.0f);
            TextView textView16 = itemAuctionSalesListBinding2.preSaleRow3Right;
            Intrinsics.checkExpressionValueIsNotNull(textView16, "binding.preSaleRow3Right");
            textView16.setText(this.mContext.getString(C2723R.string.lbl_srt_due).toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(C2723R.string.lbl_today));
        }
    }

    private final Date getDate(String str) {
        Date date = null;
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }
}
