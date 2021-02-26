package com.iaai.android.bdt.feature.landing.quickFilter;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByVehicleFragment.kt */
final class SearchByVehicleFragment$init$2 implements View.OnClickListener {
    final /* synthetic */ SearchByVehicleFragment this$0;

    SearchByVehicleFragment$init$2(SearchByVehicleFragment searchByVehicleFragment) {
        this.this$0 = searchByVehicleFragment;
    }

    public final void onClick(View view) {
        this.this$0.startActivityForResult(new Intent(this.this$0.getActivity(), SavedSearchActivity.class), 106);
    }
}
