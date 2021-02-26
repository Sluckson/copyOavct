package com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.databinding.ItemCreditCardDetailsBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u001c\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u001c\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u001e\u0010 \u001a\u00020\u00192\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0012R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CreditCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CreditCardAdapter$ViewHolder;", "context", "Landroid/content/Context;", "cardSelectedListener", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CardSelectedListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CardSelectedListener;)V", "cardList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/DummyCard;", "Lkotlin/collections/ArrayList;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "setSelectedIndex", "selectedIndex", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CreditCardAdapter.kt */
public final class CreditCardAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<DummyCard> cardList;
    /* access modifiers changed from: private */
    public final CardSelectedListener cardSelectedListener;
    @NotNull
    private Context mContext;
    private int selectedPosition = -1;

    public CreditCardAdapter(@NotNull Context context, @NotNull CardSelectedListener cardSelectedListener2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(cardSelectedListener2, "cardSelectedListener");
        this.cardSelectedListener = cardSelectedListener2;
        this.mContext = context;
    }

    public static final /* synthetic */ ArrayList access$getCardList$p(CreditCardAdapter creditCardAdapter) {
        ArrayList<DummyCard> arrayList = creditCardAdapter.cardList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardList");
        }
        return arrayList;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        ArrayList<DummyCard> arrayList = this.cardList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardList");
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        DummyCard dummyCard = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(dummyCard, "cardList!![position]");
        viewHolder.bindVehicle(dummyCard);
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C2723R.C2726id.llContainer);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "holder.itemView.llContainer");
        linearLayout.setSelected(this.selectedPosition == i);
        viewHolder.itemView.setOnClickListener(new CreditCardAdapter$onBindViewHolder$1(this, viewHolder));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.item_credit_card_details, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (ItemCreditCardDetailsBinding) inflate);
    }

    public int getItemCount() {
        ArrayList<DummyCard> arrayList = this.cardList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardList");
        }
        return arrayList.size();
    }

    public final void setData(@NotNull ArrayList<DummyCard> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "cardList");
        this.cardList = arrayList;
    }

    public final void setSelectedIndex(int i) {
        this.selectedPosition = i;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CreditCardAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemCreditCardDetailsBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CreditCardAdapter;Lcom/iaai/android/databinding/ItemCreditCardDetailsBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemCreditCardDetailsBinding;", "setBinding", "(Lcom/iaai/android/databinding/ItemCreditCardDetailsBinding;)V", "bindVehicle", "", "card", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/DummyCard;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: CreditCardAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private ItemCreditCardDetailsBinding binding;
        final /* synthetic */ CreditCardAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull CreditCardAdapter creditCardAdapter, ItemCreditCardDetailsBinding itemCreditCardDetailsBinding) {
            super(itemCreditCardDetailsBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemCreditCardDetailsBinding, "binding");
            this.this$0 = creditCardAdapter;
            this.binding = itemCreditCardDetailsBinding;
        }

        @NotNull
        public final ItemCreditCardDetailsBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull ItemCreditCardDetailsBinding itemCreditCardDetailsBinding) {
            Intrinsics.checkParameterIsNotNull(itemCreditCardDetailsBinding, "<set-?>");
            this.binding = itemCreditCardDetailsBinding;
        }

        public final void bindVehicle(@NotNull DummyCard dummyCard) {
            Intrinsics.checkParameterIsNotNull(dummyCard, "card");
            TextView textView = this.binding.tvCardNumber;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvCardNumber");
            textView.setText(dummyCard.getNumber());
            TextView textView2 = this.binding.tvExpiryValue;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvExpiryValue");
            textView2.setText(dummyCard.getExp());
        }
    }
}
