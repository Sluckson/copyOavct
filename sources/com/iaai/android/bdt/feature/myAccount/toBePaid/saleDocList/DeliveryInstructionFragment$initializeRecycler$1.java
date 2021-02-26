package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionAdapter;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0016¨\u0006\u000b"}, mo66933d2 = {"com/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter$OnClickListener;", "onSelectAllClicked", "", "isSelected", "", "onSingleStockClicked", "itemsList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "Lkotlin/collections/ArrayList;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionFragment.kt */
public final class DeliveryInstructionFragment$initializeRecycler$1 implements DeliveryInstructionAdapter.OnClickListener {
    final /* synthetic */ DeliveryInstructionFragment this$0;

    DeliveryInstructionFragment$initializeRecycler$1(DeliveryInstructionFragment deliveryInstructionFragment) {
        this.this$0 = deliveryInstructionFragment;
    }

    public void onSingleStockClicked(@NotNull ArrayList<TitleInstructionItem> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "itemsList");
        Collection collection = arrayList;
        if (!collection.isEmpty()) {
            this.this$0.stockList = arrayList;
            int size = collection.size();
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).isSelected()) {
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (z) {
                DeliveryInstructionFragment.access$getDeliveryInstructionAdapter$p(this.this$0).setAllSelected(false);
                DeliveryInstructionFragment.access$getDeliveryInstructionAdapter$p(this.this$0).notifyItemChanged(0);
            }
            if (z2) {
                Button button = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
                Intrinsics.checkExpressionValueIsNotNull(button, "btnSetDelivery");
                button.setClickable(true);
                ((Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery)).setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray_darkest));
                Button button2 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
                Intrinsics.checkExpressionValueIsNotNull(button2, "btnSetDelivery");
                button2.setBackground(this.this$0.getResources().getDrawable(C2723R.C2725drawable.rectangle_red_border));
                if (!z) {
                    DeliveryInstructionFragment.access$getDeliveryInstructionAdapter$p(this.this$0).setAllSelected(true);
                    DeliveryInstructionFragment.access$getDeliveryInstructionAdapter$p(this.this$0).notifyItemChanged(0);
                    return;
                }
                return;
            }
            Button button3 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnSetDelivery");
            button3.setClickable(false);
            ((Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery)).setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray));
            Button button4 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnSetDelivery");
            button4.setBackground(this.this$0.getResources().getDrawable(C2723R.C2725drawable.rectangle_red_border_disabled));
        }
    }

    public void onSelectAllClicked(boolean z) {
        for (TitleInstructionItem selected : this.this$0.stockList) {
            selected.setSelected(z);
        }
        if (z) {
            Button button = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnSetDelivery");
            button.setClickable(true);
            ((Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery)).setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray_darkest));
            Button button2 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnSetDelivery");
            button2.setBackground(this.this$0.getResources().getDrawable(C2723R.C2725drawable.rectangle_red_border));
        } else {
            Button button3 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnSetDelivery");
            button3.setClickable(false);
            ((Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery)).setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray));
            Button button4 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnSetDelivery");
            button4.setBackground(this.this$0.getResources().getDrawable(C2723R.C2725drawable.rectangle_red_border_disabled));
        }
        DeliveryInstructionFragment.access$getDeliveryInstructionAdapter$p(this.this$0).setDataList(this.this$0.stockList);
        DeliveryInstructionFragment.access$getDeliveryInstructionAdapter$p(this.this$0).notifyDataSetChanged();
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C2723R.C2726id.rvStockList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvStockList");
        recyclerView.setAdapter(DeliveryInstructionFragment.access$getDeliveryInstructionAdapter$p(this.this$0));
    }
}
