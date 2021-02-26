package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
final class RefinerResultFragment$initializeRecycler$4 implements View.OnClickListener {
    final /* synthetic */ RefinerResultFragment this$0;

    RefinerResultFragment$initializeRecycler$4(RefinerResultFragment refinerResultFragment) {
        this.this$0 = refinerResultFragment;
    }

    public final void onClick(View view) {
        if (this.this$0.getSessionManager().isLoggedIn()) {
            this.this$0.startActivityForResult(new Intent(this.this$0.getActivity(), SavedSearchActivity.class), 106);
            return;
        }
        this.this$0.getSessionManager().promptForLoginIfNeededTabletBDT(this.this$0.getActivity(), this.this$0, 44);
    }
}
