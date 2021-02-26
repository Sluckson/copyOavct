package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r¸\u0006\u0000"}, mo66933d2 = {"com/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddFragment$updateStateSpinner$1$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddFragment.kt */
public final class InsertRepOrAddFragment$updateStateSpinner$$inlined$with$lambda$1 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ Ref.ObjectRef $aa$inlined;
    final /* synthetic */ InsertRepOrAddFragment this$0;

    public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
    }

    InsertRepOrAddFragment$updateStateSpinner$$inlined$with$lambda$1(InsertRepOrAddFragment insertRepOrAddFragment, Ref.ObjectRef objectRef) {
        this.this$0 = insertRepOrAddFragment;
        this.$aa$inlined = objectRef;
    }

    public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        this.this$0.stateIndex = i;
        this.this$0.updateValidationFlag(6, true);
    }
}
