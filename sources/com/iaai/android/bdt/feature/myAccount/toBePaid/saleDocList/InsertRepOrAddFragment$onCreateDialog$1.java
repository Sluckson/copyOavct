package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddFragment.kt */
final class InsertRepOrAddFragment$onCreateDialog$1 implements DialogInterface.OnShowListener {
    final /* synthetic */ BottomSheetDialog $bottomSheetDialog;

    InsertRepOrAddFragment$onCreateDialog$1(BottomSheetDialog bottomSheetDialog) {
        this.$bottomSheetDialog = bottomSheetDialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) this.$bottomSheetDialog.findViewById(C2723R.C2726id.design_bottom_sheet);
        if (frameLayout == null) {
            Intrinsics.throwNpe();
        }
        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
        Intrinsics.checkExpressionValueIsNotNull(from, "BottomSheetBehavior.from(bottomSheet!!)");
        from.setSkipCollapsed(true);
        from.setState(3);
    }
}
