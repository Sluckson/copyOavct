package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.databinding.RowHeaderDeliveryInstructionBinding;
import com.iaai.android.databinding.RowItemDeliveryInstructionBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004)*+,B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018H\u0016J\u0014\u0010'\u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "onClickListener", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$OnClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$OnClickListener;)V", "allNotSet", "", "getAllNotSet", "()Z", "setAllNotSet", "(Z)V", "isAllSelected", "setAllSelected", "itemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "getMContext", "()Landroid/content/Context;", "getOnClickListener", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$OnClickListener;", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setDataList", "results", "Companion", "HeaderViewHolder", "ItemViewHolder", "OnClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionAdapter.kt */
public final class DeliveryInstructionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    private boolean allNotSet = true;
    private boolean isAllSelected;
    /* access modifiers changed from: private */
    public List<TitleInstructionItem> itemsList = CollectionsKt.emptyList();
    @NotNull
    private final Context mContext;
    @NotNull
    private final OnClickListener onClickListener;
    private int selectedPosition = -1;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$OnClickListener;", "", "onSelectAllClicked", "", "isSelected", "", "onSingleStockClicked", "itemsList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "Lkotlin/collections/ArrayList;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: DeliveryInstructionAdapter.kt */
    public interface OnClickListener {
        void onSelectAllClicked(boolean z);

        void onSingleStockClicked(@NotNull ArrayList<TitleInstructionItem> arrayList);
    }

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public DeliveryInstructionAdapter(@NotNull Context context, @NotNull OnClickListener onClickListener2) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(onClickListener2, "onClickListener");
        this.mContext = context;
        this.onClickListener = onClickListener2;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    public final boolean isAllSelected() {
        return this.isAllSelected;
    }

    public final void setAllSelected(boolean z) {
        this.isAllSelected = z;
    }

    public final boolean getAllNotSet() {
        return this.allNotSet;
    }

    public final void setAllNotSet(boolean z) {
        this.allNotSet = z;
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        RowItemDeliveryInstructionBinding inflate = RowItemDeliveryInstructionBinding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "RowItemDeliveryInstructi…tInflater, parent, false)");
        RecyclerView.ViewHolder itemViewHolder = new ItemViewHolder(this, inflate);
        if (i == 0) {
            RowHeaderDeliveryInstructionBinding inflate2 = RowHeaderDeliveryInstructionBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "RowHeaderDeliveryInstruc…tInflater, parent, false)");
            return new HeaderViewHolder(this, inflate2);
        } else if (i != 1) {
            return itemViewHolder;
        } else {
            RowItemDeliveryInstructionBinding inflate3 = RowItemDeliveryInstructionBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "RowItemDeliveryInstructi…tInflater, parent, false)");
            return new ItemViewHolder(this, inflate3);
        }
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (getItemCount() <= 0) {
            return;
        }
        if (viewHolder instanceof ItemViewHolder) {
            ((ItemViewHolder) viewHolder).bindTo(this.itemsList.get(i - 1), i);
        } else if (viewHolder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) viewHolder).bindTo();
        }
    }

    public final void setDataList(@NotNull List<TitleInstructionItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.itemsList = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<TitleInstructionItem> list = this.itemsList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size() + 1;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: DeliveryInstructionAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowHeaderDeliveryInstructionBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter;Lcom/iaai/android/databinding/RowHeaderDeliveryInstructionBinding;)V", "bindTo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: DeliveryInstructionAdapter.kt */
    public final class HeaderViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final RowHeaderDeliveryInstructionBinding binding;
        final /* synthetic */ DeliveryInstructionAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(@NotNull DeliveryInstructionAdapter deliveryInstructionAdapter, RowHeaderDeliveryInstructionBinding rowHeaderDeliveryInstructionBinding) {
            super(rowHeaderDeliveryInstructionBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowHeaderDeliveryInstructionBinding, "binding");
            this.this$0 = deliveryInstructionAdapter;
            this.binding = rowHeaderDeliveryInstructionBinding;
        }

        public final void bindTo() {
            Iterator it = this.this$0.itemsList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((TitleInstructionItem) it.next()).getTitleDeliveryMethodCode() == null) {
                    this.this$0.setAllNotSet(true);
                    break;
                } else {
                    this.this$0.setAllNotSet(false);
                }
            }
            if (this.this$0.getAllNotSet()) {
                TextView textView = this.binding.tvHeaderMsg;
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvHeaderMsg");
                textView.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_set_delivery_method_msg));
            } else {
                TextView textView2 = this.binding.tvHeaderMsg;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvHeaderMsg");
                textView2.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_change_delivery_method_msg));
            }
            TextView textView3 = this.binding.tvSetForAll;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvSetForAll");
            textView3.setSelected(this.this$0.isAllSelected());
            this.binding.tvSetForAll.setOnClickListener(new DeliveryInstructionAdapter$HeaderViewHolder$bindTo$1(this));
            if (this.this$0.itemsList.size() == 1) {
                TextView textView4 = this.binding.tvSetForAll;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvSetForAll");
                textView4.setVisibility(8);
                View view = this.binding.viewSeparator2;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.viewSeparator2");
                view.setVisibility(8);
                return;
            }
            TextView textView5 = this.binding.tvSetForAll;
            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvSetForAll");
            textView5.setVisibility(0);
            View view2 = this.binding.viewSeparator2;
            Intrinsics.checkExpressionValueIsNotNull(view2, "binding.viewSeparator2");
            view2.setVisibility(0);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemDeliveryInstructionBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter;Lcom/iaai/android/databinding/RowItemDeliveryInstructionBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemDeliveryInstructionBinding;", "bindTo", "", "titleInstructionItem", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: DeliveryInstructionAdapter.kt */
    public final class ItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final RowItemDeliveryInstructionBinding binding;
        final /* synthetic */ DeliveryInstructionAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(@NotNull DeliveryInstructionAdapter deliveryInstructionAdapter, RowItemDeliveryInstructionBinding rowItemDeliveryInstructionBinding) {
            super(rowItemDeliveryInstructionBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemDeliveryInstructionBinding, "binding");
            this.this$0 = deliveryInstructionAdapter;
            this.binding = rowItemDeliveryInstructionBinding;
        }

        @NotNull
        public final RowItemDeliveryInstructionBinding getBinding() {
            return this.binding;
        }

        public final void bindTo(@NotNull TitleInstructionItem titleInstructionItem, int i) {
            String str;
            Intrinsics.checkParameterIsNotNull(titleInstructionItem, "titleInstructionItem");
            TextView textView = this.binding.vehicleTitle;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.vehicleTitle");
            textView.setText(titleInstructionItem.getVehicleDescription());
            TextView textView2 = this.binding.tvBranchInfo;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvBranchInfo");
            textView2.setText(titleInstructionItem.getBranchName());
            boolean z = true;
            if (titleInstructionItem.getStockNumber().length() == 0) {
                TextView textView3 = this.binding.tvStockNumber;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvStockNumber");
                textView3.setVisibility(8);
            } else {
                TextView textView4 = this.binding.tvStockNumber;
                Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvStockNumber");
                textView4.setVisibility(0);
                TextView textView5 = this.binding.tvStockNumber;
                Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvStockNumber");
                textView5.setText(titleInstructionItem.getStockNumber());
            }
            ConstraintLayout constraintLayout = this.binding.clStockContainer;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clStockContainer");
            constraintLayout.setSelected(titleInstructionItem.isSelected());
            Glide.with(this.this$0.getMContext()).load(titleInstructionItem.getThumbnailUrl()).apply(new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation)).into(this.binding.vehicleImage);
            this.binding.ivSelectItem.setOnClickListener(new DeliveryInstructionAdapter$ItemViewHolder$bindTo$1(this, i));
            String titleDeliveryMethodCode = titleInstructionItem.getTitleDeliveryMethodCode();
            if (titleDeliveryMethodCode == null) {
                ImageView imageView = this.binding.ivIsSet;
                Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivIsSet");
                imageView.setVisibility(8);
                TextView textView6 = this.binding.tvDeliveryMode;
                Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvDeliveryMode");
                textView6.setVisibility(8);
                return;
            }
            switch (titleDeliveryMethodCode.hashCode()) {
                case 65661:
                    if (titleDeliveryMethodCode.equals("BFA")) {
                        ImageView imageView2 = this.binding.ivIsSet;
                        Intrinsics.checkExpressionValueIsNotNull(imageView2, "binding.ivIsSet");
                        imageView2.setVisibility(0);
                        TextView textView7 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvDeliveryMode");
                        textView7.setVisibility(0);
                        TextView textView8 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvDeliveryMode");
                        textView8.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_my_fed_ex_account));
                        return;
                    }
                    break;
                case 72388:
                    if (titleDeliveryMethodCode.equals("IFA")) {
                        ImageView imageView3 = this.binding.ivIsSet;
                        Intrinsics.checkExpressionValueIsNotNull(imageView3, "binding.ivIsSet");
                        imageView3.setVisibility(0);
                        TextView textView9 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvDeliveryMode");
                        textView9.setVisibility(0);
                        TextView textView10 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvDeliveryMode");
                        textView10.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_iaa_fed_ex_account));
                        return;
                    }
                    break;
                case 78484:
                    if (titleDeliveryMethodCode.equals("OPU")) {
                        ImageView imageView4 = this.binding.ivIsSet;
                        Intrinsics.checkExpressionValueIsNotNull(imageView4, "binding.ivIsSet");
                        imageView4.setVisibility(0);
                        TextView textView11 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvDeliveryMode");
                        textView11.setVisibility(0);
                        TextView textView12 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvDeliveryMode");
                        textView12.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_pick_up_with_colon) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + titleInstructionItem.getOwnerName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.this$0.getMContext().getResources().getString(C2723R.string.lbl_sale_doc_owner));
                        return;
                    }
                    break;
                case 81367:
                    if (titleDeliveryMethodCode.equals("RPU")) {
                        ImageView imageView5 = this.binding.ivIsSet;
                        Intrinsics.checkExpressionValueIsNotNull(imageView5, "binding.ivIsSet");
                        imageView5.setVisibility(0);
                        CharSequence representativeName = titleInstructionItem.getRepresentativeName();
                        if (!(representativeName == null || representativeName.length() == 0)) {
                            z = false;
                        }
                        if (z) {
                            str = "";
                        } else {
                            str = titleInstructionItem.getRepresentativeName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                        }
                        TextView textView13 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.tvDeliveryMode");
                        textView13.setVisibility(0);
                        TextView textView14 = this.binding.tvDeliveryMode;
                        Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.tvDeliveryMode");
                        textView14.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_pick_up_with_colon) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str + this.this$0.getMContext().getResources().getString(C2723R.string.lbl_sale_doc_representative));
                        return;
                    }
                    break;
            }
            ImageView imageView6 = this.binding.ivIsSet;
            Intrinsics.checkExpressionValueIsNotNull(imageView6, "binding.ivIsSet");
            imageView6.setVisibility(8);
            TextView textView15 = this.binding.tvDeliveryMode;
            Intrinsics.checkExpressionValueIsNotNull(textView15, "binding.tvDeliveryMode");
            textView15.setVisibility(8);
        }
    }
}
