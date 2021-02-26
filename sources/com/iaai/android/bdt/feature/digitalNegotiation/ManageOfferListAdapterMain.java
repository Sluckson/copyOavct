package com.iaai.android.bdt.feature.digitalNegotiation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferListHeader;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import com.iaai.android.bdt.model.digitalNegotiation.NegotiationsBidHistory;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.databinding.ItemHeaderManageOfferListBinding;
import com.iaai.android.databinding.ItemManageOfferListBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004IJKLB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u00102\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0010\u00105\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u000bH\u0002J\u0018\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u000bH\u0016J\u0018\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000bH\u0016J\u000e\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020\u001bJ\u000e\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020!J\u0014\u0010A\u001a\u0002072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020(0'J\u0014\u0010C\u001a\u0002072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020.0'J\u000e\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020\u000bJ\u0015\u0010F\u001a\u0002072\b\u0010G\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010HR\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR-\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u00101¨\u0006M"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "manageOfferListViewModel", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListViewModel;", "mContext", "Landroid/content/Context;", "listener", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$CustomManageItemClickListener;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListViewModel;Landroid/content/Context;Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$CustomManageItemClickListener;)V", "ACTION_BUTTON_DISABLE_ALL", "", "getACTION_BUTTON_DISABLE_ALL", "()I", "ACTION_BUTTON_DISABLE_RAISE", "getACTION_BUTTON_DISABLE_RAISE", "ACTION_BUTTON_ENABLE_ALL", "getACTION_BUTTON_ENABLE_ALL", "hashMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "isBidLive", "isSelected", "Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "getListener", "()Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$CustomManageItemClickListener;", "getMContext", "()Landroid/content/Context;", "mManageOfferListHeader", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;", "getMManageOfferListHeader", "()Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;", "setMManageOfferListHeader", "(Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;)V", "mobileNegotiationList", "", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "getMobileNegotiationList", "()Ljava/util/List;", "setMobileNegotiationList", "(Ljava/util/List;)V", "negotiationsBidHistory", "Lcom/iaai/android/bdt/model/digitalNegotiation/NegotiationsBidHistory;", "requireAction", "selectedIemID", "Ljava/lang/Integer;", "getItemCount", "getItemViewType", "position", "isPositionHeader", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setFilterSelected", "filterSelected", "setHeaderItem", "manageOfferListHeader", "setNegotiationList", "results", "setNegotiationsBidHistory", "setRequireActionCount", "count", "setSelectedItemForTablet", "selectedIndex", "(Ljava/lang/Integer;)V", "Companion", "CustomManageItemClickListener", "ViewHolderHeader", "ViewHolderItem", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListAdapterMain.kt */
public final class ManageOfferListAdapterMain extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int TYPE_HEADER = 0;
    /* access modifiers changed from: private */
    public static final int TYPE_ITEM = 1;
    private final int ACTION_BUTTON_DISABLE_ALL = 1;
    private final int ACTION_BUTTON_DISABLE_RAISE = 2;
    private final int ACTION_BUTTON_ENABLE_ALL;
    @NotNull
    private final HashMap<Long, Boolean> hashMap = new HashMap<>();
    private boolean isBidLive;
    private FilterSelected isSelected = FilterSelected.ALL;
    @NotNull
    private final CustomManageItemClickListener listener;
    @NotNull
    private final Context mContext;
    @NotNull
    public ManageOfferListHeader mManageOfferListHeader;
    private final ManageOfferListViewModel manageOfferListViewModel;
    @Nullable
    private List<MobileNegotiationsList> mobileNegotiationList;
    /* access modifiers changed from: private */
    public List<NegotiationsBidHistory> negotiationsBidHistory;
    /* access modifiers changed from: private */
    public int requireAction;
    /* access modifiers changed from: private */
    public Integer selectedIemID = -1;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J*\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$CustomManageItemClickListener;", "", "onFilterButtonClick", "", "onManageActionButtonClick", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "position", "", "action", "Lcom/iaai/android/bdt/feature/digitalNegotiation/NegotiationActionEnum;", "onManageOfferListClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferListAdapterMain.kt */
    public interface CustomManageItemClickListener {
        void onFilterButtonClick();

        void onManageActionButtonClick(@NotNull View view, @Nullable MobileNegotiationsList mobileNegotiationsList, int i, @NotNull NegotiationActionEnum negotiationActionEnum);

        void onManageOfferListClick(@NotNull View view, @Nullable MobileNegotiationsList mobileNegotiationsList, int i);
    }

    private final boolean isPositionHeader(int i) {
        return i == 0;
    }

    public ManageOfferListAdapterMain(@NotNull ManageOfferListViewModel manageOfferListViewModel2, @NotNull Context context, @NotNull CustomManageItemClickListener customManageItemClickListener) {
        Intrinsics.checkParameterIsNotNull(manageOfferListViewModel2, "manageOfferListViewModel");
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(customManageItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.manageOfferListViewModel = manageOfferListViewModel2;
        this.mContext = context;
        this.listener = customManageItemClickListener;
    }

    @NotNull
    public final CustomManageItemClickListener getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final HashMap<Long, Boolean> getHashMap() {
        return this.hashMap;
    }

    @NotNull
    public final ManageOfferListHeader getMManageOfferListHeader() {
        ManageOfferListHeader manageOfferListHeader = this.mManageOfferListHeader;
        if (manageOfferListHeader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManageOfferListHeader");
        }
        return manageOfferListHeader;
    }

    public final void setMManageOfferListHeader(@NotNull ManageOfferListHeader manageOfferListHeader) {
        Intrinsics.checkParameterIsNotNull(manageOfferListHeader, "<set-?>");
        this.mManageOfferListHeader = manageOfferListHeader;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$Companion;", "", "()V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferListAdapterMain.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTYPE_HEADER() {
            return ManageOfferListAdapterMain.TYPE_HEADER;
        }

        public final int getTYPE_ITEM() {
            return ManageOfferListAdapterMain.TYPE_ITEM;
        }
    }

    public final int getACTION_BUTTON_ENABLE_ALL() {
        return this.ACTION_BUTTON_ENABLE_ALL;
    }

    public final int getACTION_BUTTON_DISABLE_ALL() {
        return this.ACTION_BUTTON_DISABLE_ALL;
    }

    public final int getACTION_BUTTON_DISABLE_RAISE() {
        return this.ACTION_BUTTON_DISABLE_RAISE;
    }

    @Nullable
    public final List<MobileNegotiationsList> getMobileNegotiationList() {
        return this.mobileNegotiationList;
    }

    public final void setMobileNegotiationList(@Nullable List<MobileNegotiationsList> list) {
        this.mobileNegotiationList = list;
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ItemHeaderManageOfferListBinding inflate = ItemHeaderManageOfferListBinding.inflate(from, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemHeaderManageOfferLis…tInflater, parent, false)");
        RecyclerView.ViewHolder viewHolderHeader = new ViewHolderHeader(this, inflate);
        if (i == TYPE_HEADER) {
            ItemHeaderManageOfferListBinding inflate2 = ItemHeaderManageOfferListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "ItemHeaderManageOfferLis…tInflater, parent, false)");
            return new ViewHolderHeader(this, inflate2);
        } else if (i != TYPE_ITEM) {
            return viewHolderHeader;
        } else {
            ItemManageOfferListBinding inflate3 = ItemManageOfferListBinding.inflate(from, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "ItemManageOfferListBindi…tInflater, parent, false)");
            return new ViewHolderItem(this, inflate3);
        }
    }

    public int getItemCount() {
        List<MobileNegotiationsList> list = this.mobileNegotiationList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size() + 1;
    }

    public int getItemViewType(int i) {
        return isPositionHeader(i) ? TYPE_HEADER : TYPE_ITEM;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof ViewHolderHeader) {
            ((ViewHolderHeader) viewHolder).bindInfo();
        } else if (viewHolder instanceof ViewHolderItem) {
            List<MobileNegotiationsList> list = this.mobileNegotiationList;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            ((ViewHolderItem) viewHolder).bindInfo(list.get(i - 1), i);
        }
    }

    public final void setNegotiationList(@NotNull List<MobileNegotiationsList> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.mobileNegotiationList = list;
        notifyDataSetChanged();
    }

    public final void setNegotiationsBidHistory(@NotNull List<NegotiationsBidHistory> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.negotiationsBidHistory = list;
    }

    public final void setFilterSelected(@NotNull FilterSelected filterSelected) {
        Intrinsics.checkParameterIsNotNull(filterSelected, "filterSelected");
        this.isSelected = filterSelected;
    }

    public final void setHeaderItem(@NotNull ManageOfferListHeader manageOfferListHeader) {
        Intrinsics.checkParameterIsNotNull(manageOfferListHeader, "manageOfferListHeader");
        this.mManageOfferListHeader = manageOfferListHeader;
    }

    public final void setSelectedItemForTablet(@Nullable Integer num) {
        this.selectedIemID = num;
    }

    public final void setRequireActionCount(int i) {
        this.requireAction = i;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$ViewHolderHeader;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemHeaderManageOfferListBinding;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain;Lcom/iaai/android/databinding/ItemHeaderManageOfferListBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemHeaderManageOfferListBinding;", "setBinding", "(Lcom/iaai/android/databinding/ItemHeaderManageOfferListBinding;)V", "bindInfo", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferListAdapterMain.kt */
    public final class ViewHolderHeader extends RecyclerView.ViewHolder {
        @NotNull
        private ItemHeaderManageOfferListBinding binding;
        final /* synthetic */ ManageOfferListAdapterMain this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderHeader(@NotNull ManageOfferListAdapterMain manageOfferListAdapterMain, ItemHeaderManageOfferListBinding itemHeaderManageOfferListBinding) {
            super(itemHeaderManageOfferListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemHeaderManageOfferListBinding, "binding");
            this.this$0 = manageOfferListAdapterMain;
            this.binding = itemHeaderManageOfferListBinding;
        }

        @NotNull
        public final ItemHeaderManageOfferListBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull ItemHeaderManageOfferListBinding itemHeaderManageOfferListBinding) {
            Intrinsics.checkParameterIsNotNull(itemHeaderManageOfferListBinding, "<set-?>");
            this.binding = itemHeaderManageOfferListBinding;
        }

        public final void bindInfo() {
            if (this.this$0.requireAction > 0) {
                TextView textView = this.binding.tvManageOfferVehicleCount;
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvManageOfferVehicleCount");
                textView.setVisibility(0);
                View view = this.binding.vehicleCountSeparator;
                Intrinsics.checkExpressionValueIsNotNull(view, "binding.vehicleCountSeparator");
                view.setVisibility(0);
                TextView textView2 = this.binding.tvManageOfferVehicleCount;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvManageOfferVehicleCount");
                textView2.setText(this.this$0.getMContext().getResources().getString(C2723R.string.lbl_multiple_vehicle_require_action, new Object[]{Integer.valueOf(this.this$0.requireAction)}));
            } else {
                TextView textView3 = this.binding.tvManageOfferVehicleCount;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvManageOfferVehicleCount");
                textView3.setVisibility(8);
                View view2 = this.binding.vehicleCountSeparator;
                Intrinsics.checkExpressionValueIsNotNull(view2, "binding.vehicleCountSeparator");
                view2.setVisibility(8);
            }
            this.binding.llFilter.setOnClickListener(new ManageOfferListAdapterMain$ViewHolderHeader$bindInfo$1(this));
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$ViewHolderItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemManageOfferListBinding;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain;Lcom/iaai/android/databinding/ItemManageOfferListBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemManageOfferListBinding;", "setBinding", "(Lcom/iaai/android/databinding/ItemManageOfferListBinding;)V", "bindInfo", "", "mobileNegotiationsList", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "position", "", "createBidHistoryLayout", "salvageId", "bidHistoryData", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/digitalNegotiation/NegotiationsBidHistory;", "getBidHistoryData", "updateActionButtonVisibility", "showActionButton", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferListAdapterMain.kt */
    public final class ViewHolderItem extends RecyclerView.ViewHolder {
        @NotNull
        private ItemManageOfferListBinding binding;
        final /* synthetic */ ManageOfferListAdapterMain this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderItem(@NotNull ManageOfferListAdapterMain manageOfferListAdapterMain, ItemManageOfferListBinding itemManageOfferListBinding) {
            super(itemManageOfferListBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemManageOfferListBinding, "binding");
            this.this$0 = manageOfferListAdapterMain;
            this.binding = itemManageOfferListBinding;
        }

        @NotNull
        public final ItemManageOfferListBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull ItemManageOfferListBinding itemManageOfferListBinding) {
            Intrinsics.checkParameterIsNotNull(itemManageOfferListBinding, "<set-?>");
            this.binding = itemManageOfferListBinding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:141:0x06bd, code lost:
            if (r0.equals("Closed") != true) goto L_0x06c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x06cd, code lost:
            if (r0.equals("Expired") == r1) goto L_0x06cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x06cf, code lost:
            updateActionButtonVisibility(r11.this$0.getACTION_BUTTON_DISABLE_ALL());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x053d, code lost:
            if (r0.equals("IBidFast") != true) goto L_0x0541;
         */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0657  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x0662  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindInfo(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList r30, int r31) {
            /*
                r29 = this;
                r11 = r29
                r12 = r30
                r13 = r31
                java.lang.String r0 = "mobileNegotiationsList"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
                java.lang.Integer r0 = r30.getItemId()
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                java.lang.Integer r1 = r1.selectedIemID
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
                r1 = 23
                r2 = 0
                if (r0 == 0) goto L_0x0054
                int r0 = android.os.Build.VERSION.SDK_INT
                if (r0 < r1) goto L_0x003b
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.mainRowLayout
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r1 = r1.getColor(r3, r2)
                r0.setBackgroundColor(r1)
                goto L_0x0086
            L_0x003b:
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.mainRowLayout
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                r3 = 2131099693(0x7f06002d, float:1.7811746E38)
                int r1 = r1.getColor(r3)
                r0.setBackgroundColor(r1)
                goto L_0x0086
            L_0x0054:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 2131099728(0x7f060050, float:1.7811817E38)
                if (r0 < r1) goto L_0x0071
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.mainRowLayout
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                int r1 = r1.getColor(r3, r2)
                r0.setBackgroundColor(r1)
                goto L_0x0086
            L_0x0071:
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.mainRowLayout
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                int r1 = r1.getColor(r3)
                r0.setBackgroundColor(r1)
            L_0x0086:
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvStockNoValue
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$1 r1 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$1
                r1.<init>(r11, r12, r13)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvWhyThisIs
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$2 r1 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$2
                r1.<init>(r11, r12, r13)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
                android.text.SpannableString r0 = new android.text.SpannableString
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                r3 = 2131821890(0x7f110542, float:1.9276536E38)
                java.lang.String r1 = r1.getString(r3)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.<init>(r1)
                android.text.style.UnderlineSpan r1 = new android.text.style.UnderlineSpan
                r1.<init>()
                int r3 = r0.length()
                r14 = 0
                r0.setSpan(r1, r14, r3, r14)
                com.iaai.android.databinding.ItemManageOfferListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvWhyThisIs
                java.lang.String r3 = "binding.tvWhyThisIs"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1.setText(r0)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvYearMakeModel
                java.lang.String r1 = "binding.tvYearMakeModel"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.Integer r3 = r30.getYear()
                r1.append(r3)
                r3 = 32
                r1.append(r3)
                java.lang.String r3 = r30.getMake()
                r1.append(r3)
                r3 = 32
                r1.append(r3)
                java.lang.String r3 = r30.getModel()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                android.text.SpannableString r0 = new android.text.SpannableString
                java.lang.String r1 = r30.getStockNumber()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.<init>(r1)
                android.text.style.UnderlineSpan r1 = new android.text.style.UnderlineSpan
                r1.<init>()
                int r3 = r0.length()
                r0.setSpan(r1, r14, r3, r14)
                com.iaai.android.databinding.ItemManageOfferListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvStockNoValue
                java.lang.String r3 = "binding.tvStockNoValue"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1.setText(r0)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvStockNo
                java.lang.String r1 = "binding.tvStockNo"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r3 = r11.this$0
                android.content.Context r3 = r3.getMContext()
                r4 = 2131821329(0x7f110311, float:1.9275398E38)
                java.lang.String r3 = r3.getString(r4)
                r1.append(r3)
                r3 = 58
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                java.lang.String r0 = r30.getSlot()
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
                if (r0 == 0) goto L_0x0173
                if (r0 == 0) goto L_0x016d
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
                java.lang.String r0 = r0.toString()
                goto L_0x0174
            L_0x016d:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r1)
                throw r0
            L_0x0173:
                r0 = r2
            L_0x0174:
                com.iaai.android.databinding.ItemManageOfferListBinding r3 = r11.binding
                android.widget.TextView r3 = r3.tvBranchNameLane
                java.lang.String r4 = "binding.tvBranchNameLane"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = r30.getBranchName()
                r4.append(r5)
                java.lang.String r5 = " - "
                r4.append(r5)
                java.lang.String r5 = r30.getAuctionLane()
                r4.append(r5)
                java.lang.String r5 = " #"
                r4.append(r5)
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r3.setText(r0)
                com.iaai.android.bdt.utils.NewDateHelper r0 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
                java.lang.String r3 = r30.getExpiryDatetime()
                java.lang.String r15 = ""
                if (r3 == 0) goto L_0x01b1
                goto L_0x01b2
            L_0x01b1:
                r3 = r15
            L_0x01b2:
                java.lang.String r4 = r0.getOfferExpireDate(r3)
                r7 = 0
                r8 = 4
                r9 = 0
                java.lang.String r5 = "AM"
                java.lang.String r6 = "am"
                java.lang.String r16 = kotlin.text.StringsKt.replace$default((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (boolean) r7, (int) r8, (java.lang.Object) r9)
                r19 = 0
                r20 = 4
                r21 = 0
                java.lang.String r17 = "PM"
                java.lang.String r18 = "pm"
                java.lang.String r0 = kotlin.text.StringsKt.replace$default((java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (boolean) r19, (int) r20, (java.lang.Object) r21)
                java.lang.String r3 = r30.getRemainingTime()
                r9 = 41
                java.lang.String r10 = "</b> ("
                r7 = 2131821598(0x7f11041e, float:1.9275944E38)
                java.lang.String r8 = "<b>"
                java.lang.String r6 = "binding.tvDigitalNegotiationDateTime"
                r4 = 1
                if (r3 == 0) goto L_0x0293
                int r3 = android.os.Build.VERSION.SDK_INT
                r5 = 24
                if (r3 < r5) goto L_0x023e
                com.iaai.android.databinding.ItemManageOfferListBinding r3 = r11.binding
                android.widget.TextView r3 = r3.tvDigitalNegotiationDateTime
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r8)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r6 = r11.this$0
                android.content.Context r6 = r6.getMContext()
                java.lang.Object[] r8 = new java.lang.Object[r4]
                java.lang.String r15 = r30.getRemainingTime()
                if (r15 == 0) goto L_0x0217
                if (r15 == 0) goto L_0x0211
                java.lang.CharSequence r15 = (java.lang.CharSequence) r15
                java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r15)
                java.lang.String r2 = r1.toString()
                goto L_0x0217
            L_0x0211:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r1)
                throw r0
            L_0x0217:
                java.lang.String r1 = java.lang.String.valueOf(r2)
                r8[r14] = r1
                java.lang.String r1 = r6.getString(r7, r8)
                r5.append(r1)
                r5.append(r10)
                r5.append(r0)
                r5.append(r9)
                java.lang.String r0 = r5.toString()
                r1 = 63
                android.text.Spanned r0 = android.text.Html.fromHtml(r0, r1)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r3.setText(r0)
                goto L_0x038b
            L_0x023e:
                com.iaai.android.databinding.ItemManageOfferListBinding r3 = r11.binding
                android.widget.TextView r3 = r3.tvDigitalNegotiationDateTime
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r8)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r6 = r11.this$0
                android.content.Context r6 = r6.getMContext()
                java.lang.Object[] r8 = new java.lang.Object[r4]
                java.lang.String r15 = r30.getRemainingTime()
                if (r15 == 0) goto L_0x026e
                if (r15 == 0) goto L_0x0268
                java.lang.CharSequence r15 = (java.lang.CharSequence) r15
                java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r15)
                java.lang.String r2 = r1.toString()
                goto L_0x026e
            L_0x0268:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                r0.<init>(r1)
                throw r0
            L_0x026e:
                java.lang.String r1 = java.lang.String.valueOf(r2)
                r8[r14] = r1
                java.lang.String r1 = r6.getString(r7, r8)
                r5.append(r1)
                r5.append(r10)
                r5.append(r0)
                r5.append(r9)
                java.lang.String r0 = r5.toString()
                android.text.Spanned r0 = android.text.Html.fromHtml(r0)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r3.setText(r0)
                goto L_0x038b
            L_0x0293:
                java.util.Date r0 = new java.util.Date
                r0.<init>()
                com.iaai.android.bdt.utils.NewDateHelper r1 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
                com.iaai.android.bdt.utils.NewDateHelper r2 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
                java.lang.String r3 = r30.getExpiryDatetime()
                if (r3 == 0) goto L_0x02a3
                goto L_0x02a4
            L_0x02a3:
                r3 = r15
            L_0x02a4:
                java.util.Date r2 = r2.getManageOfferExpireDate(r3)
                java.lang.Long r0 = r1.calculateTimeDiffInMillis(r0, r2)
                if (r0 == 0) goto L_0x02b3
                long r0 = r0.longValue()
                goto L_0x02b5
            L_0x02b3:
                r0 = 0
            L_0x02b5:
                r16 = r0
                r0 = 60000(0xea60, float:8.4078E-41)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$3 r18 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$3
                long r2 = (long) r0
                r19 = 60000(0xea60, float:8.4078E-41)
                r0 = r18
                r1 = r29
                r20 = r2
                r2 = r30
                r3 = r31
                r14 = 1
                r4 = r16
                r14 = r6
                r6 = r19
                r22 = r8
                r7 = r16
                r12 = r10
                r9 = r20
                r0.<init>(r1, r2, r3, r4, r6, r7, r9)
                r18.start()
                com.iaai.android.bdt.utils.NewDateHelper r0 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
                java.lang.String r1 = r30.getExpiryDatetime()
                if (r1 == 0) goto L_0x02e6
                goto L_0x02e7
            L_0x02e6:
                r1 = r15
            L_0x02e7:
                java.lang.String r2 = r0.getOfferExpireDate(r1)
                r5 = 0
                r6 = 4
                r7 = 0
                java.lang.String r3 = "AM"
                java.lang.String r4 = "am"
                java.lang.String r23 = kotlin.text.StringsKt.replace$default((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
                r26 = 0
                r27 = 4
                r28 = 0
                java.lang.String r24 = "PM"
                java.lang.String r25 = "pm"
                java.lang.String r0 = kotlin.text.StringsKt.replace$default((java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (boolean) r26, (int) r27, (java.lang.Object) r28)
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 24
                if (r1 < r2) goto L_0x034c
                com.iaai.android.databinding.ItemManageOfferListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvDigitalNegotiationDateTime
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r14)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r3 = r22
                r2.append(r3)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r3 = r11.this$0
                android.content.Context r3 = r3.getMContext()
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]
                r4 = 0
                r5[r4] = r15
                r4 = 2131821598(0x7f11041e, float:1.9275944E38)
                java.lang.String r3 = r3.getString(r4, r5)
                r2.append(r3)
                r2.append(r12)
                r2.append(r0)
                r0 = 41
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r2 = 63
                android.text.Spanned r0 = android.text.Html.fromHtml(r0, r2)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1.setText(r0)
                goto L_0x038b
            L_0x034c:
                r3 = r22
                r4 = 2131821598(0x7f11041e, float:1.9275944E38)
                com.iaai.android.databinding.ItemManageOfferListBinding r1 = r11.binding
                android.widget.TextView r1 = r1.tvDigitalNegotiationDateTime
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r14)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r3)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r3 = r11.this$0
                android.content.Context r3 = r3.getMContext()
                r5 = 1
                java.lang.Object[] r6 = new java.lang.Object[r5]
                r5 = 0
                r6[r5] = r15
                java.lang.String r3 = r3.getString(r4, r6)
                r2.append(r3)
                r2.append(r12)
                r2.append(r0)
                r0 = 41
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                android.text.Spanned r0 = android.text.Html.fromHtml(r0)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1.setText(r0)
            L_0x038b:
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                java.lang.String r1 = "binding.tvSellerCounterOffer"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r2 = r11.this$0
                android.content.Context r2 = r2.getMContext()
                r3 = 2131821740(0x7f1104ac, float:1.9276232E38)
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]
                java.lang.String r4 = r30.getFormattedSellerOfferAmount()
                java.lang.String r4 = java.lang.String.valueOf(r4)
                r6 = 0
                r5[r6] = r4
                java.lang.String r2 = r2.getString(r3, r5)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvYourHighBid
                java.lang.String r2 = "binding.tvYourHighBid"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                java.lang.String r2 = r30.getFormattedCurrentBidAmount()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerOfferAmount
                java.lang.String r2 = "binding.tvSellerOfferAmount"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                java.lang.String r2 = r30.getFormattedSellerOfferAmount()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r0.setText(r2)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.Button r0 = r0.btnBuyIt
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$4 r2 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$4
                r3 = r30
                r2.<init>(r11, r3, r13)
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                r0.setOnClickListener(r2)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.Button r0 = r0.btnKeepMyBid
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$5 r2 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$5
                r2.<init>(r11, r3, r13)
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                r0.setOnClickListener(r2)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.Button r0 = r0.btnRaiseMyBid
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$6 r2 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$6
                r2.<init>(r11, r3, r13)
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                r0.setOnClickListener(r2)
                java.lang.Integer r0 = r30.getSalvageID()
                if (r0 == 0) goto L_0x040f
                int r14 = r0.intValue()
                goto L_0x0410
            L_0x040f:
                r14 = 0
            L_0x0410:
                java.util.ArrayList r0 = r11.getBidHistoryData(r14)
                int r2 = r0.size()
                r4 = 8
                java.lang.String r5 = "binding.llBidHistory"
                if (r2 <= 0) goto L_0x0444
                com.iaai.android.databinding.ItemManageOfferListBinding r2 = r11.binding
                android.widget.LinearLayout r2 = r2.llBidHistory
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
                r6 = 0
                r2.setVisibility(r6)
                com.iaai.android.databinding.ItemManageOfferListBinding r2 = r11.binding
                android.widget.LinearLayout r2 = r2.llBidHistory
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
                r5 = 1
                r2.setClickable(r5)
                com.iaai.android.databinding.ItemManageOfferListBinding r2 = r11.binding
                android.widget.LinearLayout r2 = r2.llBidHistory
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$7 r5 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain$ViewHolderItem$bindInfo$7
                r5.<init>(r11, r3, r13)
                android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
                r2.setOnClickListener(r5)
                r5 = 0
                goto L_0x0459
            L_0x0444:
                com.iaai.android.databinding.ItemManageOfferListBinding r2 = r11.binding
                android.widget.LinearLayout r2 = r2.llBidHistory
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
                r2.setVisibility(r4)
                com.iaai.android.databinding.ItemManageOfferListBinding r2 = r11.binding
                android.widget.LinearLayout r2 = r2.llBidHistory
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
                r5 = 0
                r2.setClickable(r5)
            L_0x0459:
                java.lang.Boolean r2 = r30.isBidHistoryVisible()
                r6 = 1
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
                if (r2 == 0) goto L_0x049d
                com.iaai.android.databinding.ItemManageOfferListBinding r2 = r11.binding
                android.widget.TextView r2 = r2.tvBidHistory
                java.lang.String r4 = "binding.tvBidHistory"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
                r2.setVisibility(r5)
                java.lang.Integer r2 = r30.getSalvageID()
                if (r2 == 0) goto L_0x047f
                int r14 = r2.intValue()
                goto L_0x0480
            L_0x047f:
                r14 = 0
            L_0x0480:
                r11.createBidHistoryLayout(r14, r0)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llBidHistoryDetails
                java.lang.String r2 = "binding.llBidHistoryDetails"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r5)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.ivArrowDown
                java.lang.String r2 = "binding.ivArrowDown"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r2 = 1
                r0.setSelected(r2)
                goto L_0x04c2
            L_0x049d:
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvBidHistory
                java.lang.String r2 = "binding.tvBidHistory"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r4)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.LinearLayout r0 = r0.llBidHistoryDetails
                java.lang.String r2 = "binding.llBidHistoryDetails"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r0.setVisibility(r4)
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.ImageView r0 = r0.ivArrowDown
                java.lang.String r2 = "binding.ivArrowDown"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
                r2 = 0
                r0.setSelected(r2)
            L_0x04c2:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x04fa
                java.lang.String r2 = "Accept"
                boolean r0 = r0.equals(r2)
                r2 = 1
                if (r0 != r2) goto L_0x04fa
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                r4 = 2131821760(0x7f1104c0, float:1.9276272E38)
                java.lang.Object[] r5 = new java.lang.Object[r2]
                java.lang.String r2 = r30.getFormattedNegotiationAmount()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                r6 = 0
                r5[r6] = r2
                java.lang.String r1 = r1.getString(r4, r5)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
            L_0x04f7:
                r6 = 0
                goto L_0x0648
            L_0x04fa:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x0530
                java.lang.String r2 = "Reject"
                boolean r0 = r0.equals(r2)
                r2 = 1
                if (r0 != r2) goto L_0x0530
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                r4 = 2131821901(0x7f11054d, float:1.9276558E38)
                java.lang.Object[] r5 = new java.lang.Object[r2]
                java.lang.String r2 = r30.getFormattedCurrentBidAmount()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                r6 = 0
                r5[r6] = r2
                java.lang.String r1 = r1.getString(r4, r5)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                goto L_0x04f7
            L_0x0530:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x0540
                java.lang.String r2 = "IBidFast"
                boolean r0 = r0.equals(r2)
                r2 = 1
                if (r0 == r2) goto L_0x055d
                goto L_0x0541
            L_0x0540:
                r2 = 1
            L_0x0541:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x054f
                java.lang.String r4 = "BuyNow"
                boolean r0 = r0.equals(r4)
                if (r0 == r2) goto L_0x055d
            L_0x054f:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x057c
                java.lang.String r4 = "Rerun"
                boolean r0 = r0.equals(r4)
                if (r0 != r2) goto L_0x057c
            L_0x055d:
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                r2 = 2131821591(0x7f110417, float:1.927593E38)
                java.lang.String r1 = r1.getString(r2)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                goto L_0x04f7
            L_0x057c:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x05aa
                java.lang.String r2 = "Expire"
                boolean r0 = r0.equals(r2)
                r2 = 1
                if (r0 != r2) goto L_0x05aa
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                r2 = 2131821599(0x7f11041f, float:1.9275946E38)
                java.lang.String r1 = r1.getString(r2)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                goto L_0x04f7
            L_0x05aa:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x05d8
                java.lang.String r2 = "OverrideAccept"
                boolean r0 = r0.equals(r2)
                r2 = 1
                if (r0 != r2) goto L_0x05d8
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                r2 = 2131821608(0x7f110428, float:1.9275964E38)
                java.lang.String r1 = r1.getString(r2)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                goto L_0x04f7
            L_0x05d8:
                java.lang.String r0 = r30.getEventtype()
                if (r0 == 0) goto L_0x0621
                java.lang.String r2 = "CounterOffer"
                boolean r0 = r0.equals(r2)
                r2 = 1
                if (r0 != r2) goto L_0x0621
                java.lang.String r0 = r30.getStatus()
                if (r0 == 0) goto L_0x0621
                java.lang.String r4 = "PendingSeller"
                boolean r0 = r0.equals(r4)
                if (r0 != r2) goto L_0x0621
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                android.content.res.Resources r1 = r1.getResources()
                r4 = 2131821902(0x7f11054e, float:1.927656E38)
                java.lang.Object[] r5 = new java.lang.Object[r2]
                java.lang.String r2 = r30.getFormattedNegotiationAmount()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                r6 = 0
                r5[r6] = r2
                java.lang.String r1 = r1.getString(r4, r5)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                goto L_0x04f7
            L_0x0621:
                com.iaai.android.databinding.ItemManageOfferListBinding r0 = r11.binding
                android.widget.TextView r0 = r0.tvSellerCounterOffer
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                r2 = 2131821740(0x7f1104ac, float:1.9276232E38)
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]
                java.lang.String r4 = r30.getFormattedSellerOfferAmount()
                java.lang.String r4 = java.lang.String.valueOf(r4)
                r6 = 0
                r5[r6] = r4
                java.lang.String r1 = r1.getString(r2, r5)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
            L_0x0648:
                java.lang.String r0 = r30.getStatus()
                if (r0 == 0) goto L_0x0662
                java.lang.String r1 = "PendingSeller"
                boolean r0 = r0.equals(r1)
                r1 = 1
                if (r0 != r1) goto L_0x0662
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r0 = r11.this$0
                int r0 = r0.getACTION_BUTTON_DISABLE_ALL()
                r11.updateActionButtonVisibility(r0)
                goto L_0x06d8
            L_0x0662:
                java.lang.String r0 = r30.getStatus()
                if (r0 == 0) goto L_0x0689
                java.lang.String r1 = "PendingBidder"
                boolean r0 = r0.equals(r1)
                r1 = 1
                if (r0 != r1) goto L_0x0689
                java.lang.Integer r0 = r30.getRemainingBidderCounters()
                if (r0 == 0) goto L_0x067c
                int r14 = r0.intValue()
                goto L_0x067d
            L_0x067c:
                r14 = 0
            L_0x067d:
                if (r14 <= 0) goto L_0x0689
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r0 = r11.this$0
                int r0 = r0.getACTION_BUTTON_ENABLE_ALL()
                r11.updateActionButtonVisibility(r0)
                goto L_0x06d8
            L_0x0689:
                java.lang.String r0 = r30.getStatus()
                if (r0 == 0) goto L_0x06b0
                java.lang.String r1 = "PendingBidder"
                boolean r0 = r0.equals(r1)
                r1 = 1
                if (r0 != r1) goto L_0x06b0
                java.lang.Integer r0 = r30.getRemainingBidderCounters()
                if (r0 == 0) goto L_0x06a3
                int r14 = r0.intValue()
                goto L_0x06a4
            L_0x06a3:
                r14 = 0
            L_0x06a4:
                if (r14 != 0) goto L_0x06b0
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r0 = r11.this$0
                int r0 = r0.getACTION_BUTTON_DISABLE_RAISE()
                r11.updateActionButtonVisibility(r0)
                goto L_0x06d8
            L_0x06b0:
                java.lang.String r0 = r30.getStatus()
                if (r0 == 0) goto L_0x06c0
                java.lang.String r1 = "Closed"
                boolean r0 = r0.equals(r1)
                r1 = 1
                if (r0 == r1) goto L_0x06cf
                goto L_0x06c1
            L_0x06c0:
                r1 = 1
            L_0x06c1:
                java.lang.String r0 = r30.getStatus()
                if (r0 == 0) goto L_0x06d8
                java.lang.String r2 = "Expired"
                boolean r0 = r0.equals(r2)
                if (r0 != r1) goto L_0x06d8
            L_0x06cf:
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r0 = r11.this$0
                int r0 = r0.getACTION_BUTTON_DISABLE_ALL()
                r11.updateActionButtonVisibility(r0)
            L_0x06d8:
                com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
                r0.<init>()
                com.bumptech.glide.request.RequestOptions r0 = r0.centerCrop()
                r1 = 2131231231(0x7f0801ff, float:1.8078537E38)
                com.bumptech.glide.request.RequestOptions r0 = r0.error((int) r1)
                com.bumptech.glide.load.engine.DiskCacheStrategy r1 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
                com.bumptech.glide.request.RequestOptions r0 = r0.diskCacheStrategy(r1)
                com.bumptech.glide.Priority r1 = com.bumptech.glide.Priority.HIGH
                com.bumptech.glide.request.RequestOptions r0 = r0.priority(r1)
                r1 = 2131231567(0x7f08034f, float:1.8079219E38)
                com.bumptech.glide.request.RequestOptions r0 = r0.placeholder((int) r1)
                com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = r11.this$0
                android.content.Context r1 = r1.getMContext()
                com.bumptech.glide.RequestManager r1 = com.bumptech.glide.Glide.with((android.content.Context) r1)
                java.lang.String r2 = r30.getThumbnailImage()
                com.bumptech.glide.RequestBuilder r1 = r1.load((java.lang.String) r2)
                com.bumptech.glide.RequestBuilder r0 = r1.apply(r0)
                com.iaai.android.databinding.ItemManageOfferListBinding r1 = r11.binding
                android.widget.ImageView r1 = r1.ivVehicleThumbnail
                r0.into((android.widget.ImageView) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain.ViewHolderItem.bindInfo(com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList, int):void");
        }

        private final void updateActionButtonVisibility(int i) {
            if (i == this.this$0.getACTION_BUTTON_ENABLE_ALL()) {
                ConstraintLayout constraintLayout = this.binding.clActionAreaLayout;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.clActionAreaLayout");
                constraintLayout.setVisibility(0);
                Button button = this.binding.btnRaiseMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button, "binding.btnRaiseMyBid");
                button.setClickable(true);
                Button button2 = this.binding.btnKeepMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button2, "binding.btnKeepMyBid");
                button2.setClickable(true);
                Button button3 = this.binding.btnBuyIt;
                Intrinsics.checkExpressionValueIsNotNull(button3, "binding.btnBuyIt");
                button3.setClickable(true);
                Button button4 = this.binding.btnRaiseMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button4, "binding.btnRaiseMyBid");
                button4.setAlpha(1.0f);
                Button button5 = this.binding.btnKeepMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button5, "binding.btnKeepMyBid");
                button5.setAlpha(1.0f);
                Button button6 = this.binding.btnBuyIt;
                Intrinsics.checkExpressionValueIsNotNull(button6, "binding.btnBuyIt");
                button6.setAlpha(1.0f);
                TextView textView = this.binding.tvWhyThisIs;
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvWhyThisIs");
                textView.setVisibility(8);
            } else if (i == this.this$0.getACTION_BUTTON_DISABLE_ALL()) {
                ConstraintLayout constraintLayout2 = this.binding.clActionAreaLayout;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.clActionAreaLayout");
                constraintLayout2.setVisibility(0);
                Button button7 = this.binding.btnRaiseMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button7, "binding.btnRaiseMyBid");
                button7.setClickable(false);
                Button button8 = this.binding.btnKeepMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button8, "binding.btnKeepMyBid");
                button8.setClickable(false);
                Button button9 = this.binding.btnBuyIt;
                Intrinsics.checkExpressionValueIsNotNull(button9, "binding.btnBuyIt");
                button9.setClickable(false);
                Button button10 = this.binding.btnRaiseMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button10, "binding.btnRaiseMyBid");
                button10.setAlpha(0.5f);
                Button button11 = this.binding.btnKeepMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button11, "binding.btnKeepMyBid");
                button11.setAlpha(0.5f);
                Button button12 = this.binding.btnBuyIt;
                Intrinsics.checkExpressionValueIsNotNull(button12, "binding.btnBuyIt");
                button12.setAlpha(0.5f);
                TextView textView2 = this.binding.tvWhyThisIs;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvWhyThisIs");
                textView2.setVisibility(8);
            } else if (i == this.this$0.getACTION_BUTTON_DISABLE_RAISE()) {
                ConstraintLayout constraintLayout3 = this.binding.clActionAreaLayout;
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.clActionAreaLayout");
                constraintLayout3.setVisibility(0);
                Button button13 = this.binding.btnRaiseMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button13, "binding.btnRaiseMyBid");
                button13.setClickable(false);
                Button button14 = this.binding.btnRaiseMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button14, "binding.btnRaiseMyBid");
                button14.setAlpha(0.5f);
                TextView textView3 = this.binding.tvWhyThisIs;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvWhyThisIs");
                textView3.setVisibility(0);
                Button button15 = this.binding.btnKeepMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button15, "binding.btnKeepMyBid");
                button15.setClickable(true);
                Button button16 = this.binding.btnBuyIt;
                Intrinsics.checkExpressionValueIsNotNull(button16, "binding.btnBuyIt");
                button16.setClickable(true);
                Button button17 = this.binding.btnKeepMyBid;
                Intrinsics.checkExpressionValueIsNotNull(button17, "binding.btnKeepMyBid");
                button17.setAlpha(1.0f);
                Button button18 = this.binding.btnBuyIt;
                Intrinsics.checkExpressionValueIsNotNull(button18, "binding.btnBuyIt");
                button18.setAlpha(1.0f);
            }
        }

        private final void createBidHistoryLayout(int i, ArrayList<NegotiationsBidHistory> arrayList) {
            this.binding.llBidHistoryDetails.removeAllViews();
            int i2 = 0;
            for (Object next : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                NegotiationsBidHistory negotiationsBidHistory = (NegotiationsBidHistory) next;
                View inflate = LayoutInflater.from(this.this$0.getMContext()).inflate(C2723R.C2728layout.item_row_bid_history, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(C2723R.C2726id.tvBidTime);
                TextView textView2 = (TextView) inflate.findViewById(C2723R.C2726id.tvBidDescription);
                TextView textView3 = (TextView) inflate.findViewById(C2723R.C2726id.tvBidValue);
                View findViewById = inflate.findViewById(C2723R.C2726id.viewSeparator);
                ImageView imageView = (ImageView) inflate.findViewById(C2723R.C2726id.ivBidIndicator);
                if (i2 == 0) {
                    imageView.setImageDrawable(this.this$0.getMContext().getResources().getDrawable(C2723R.C2725drawable.ic_green_circle_outline));
                } else {
                    imageView.setImageDrawable(this.this$0.getMContext().getResources().getDrawable(C2723R.C2725drawable.ic_green_circle));
                }
                if (i2 == arrayList.size() - 1) {
                    Intrinsics.checkExpressionValueIsNotNull(findViewById, "viewSeparator");
                    findViewById.setVisibility(8);
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(findViewById, "viewSeparator");
                    findViewById.setVisibility(0);
                }
                String replace$default = StringsKt.replace$default(StringsKt.replace$default(NewDateHelper.INSTANCE.getBidHistoryDate(negotiationsBidHistory.getEventDatetime()), "AM", "am", false, 4, (Object) null), "PM", "pm", false, 4, (Object) null);
                String formattedAmount = negotiationsBidHistory.getFormattedAmount();
                if (formattedAmount != null) {
                    if (formattedAmount.length() > 0) {
                        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBidDescription");
                        textView2.setText(negotiationsBidHistory.getDescription() + ": ");
                        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvBidValue");
                        textView3.setText(negotiationsBidHistory.getFormattedAmount());
                        Intrinsics.checkExpressionValueIsNotNull(textView, "tvBidTime");
                        textView.setText(replace$default);
                        this.binding.llBidHistoryDetails.addView(inflate);
                        i2 = i3;
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBidDescription");
                textView2.setText(String.valueOf(negotiationsBidHistory.getDescription()));
                Intrinsics.checkExpressionValueIsNotNull(textView3, "tvBidValue");
                textView3.setText(negotiationsBidHistory.getFormattedAmount());
                Intrinsics.checkExpressionValueIsNotNull(textView, "tvBidTime");
                textView.setText(replace$default);
                this.binding.llBidHistoryDetails.addView(inflate);
                i2 = i3;
            }
        }

        private final ArrayList<NegotiationsBidHistory> getBidHistoryData(int i) {
            ArrayList<NegotiationsBidHistory> arrayList = new ArrayList<>();
            List<NegotiationsBidHistory> access$getNegotiationsBidHistory$p = this.this$0.negotiationsBidHistory;
            if (access$getNegotiationsBidHistory$p != null) {
                for (NegotiationsBidHistory negotiationsBidHistory : access$getNegotiationsBidHistory$p) {
                    if (negotiationsBidHistory.getSalvageID() == i && negotiationsBidHistory.getDescription() != null) {
                        if (negotiationsBidHistory.getDescription().length() > 0) {
                            arrayList.add(negotiationsBidHistory);
                        }
                    }
                }
            }
            return arrayList;
        }
    }
}
