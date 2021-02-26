package com.iaai.android.bdt.feature.findVehiclePage;

import android.content.Intent;
import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchPanelFindVehicleActivity.kt */
final class SearchPanelFindVehicleActivity$init$7 implements View.OnClickListener {
    final /* synthetic */ SearchPanelFindVehicleActivity this$0;

    SearchPanelFindVehicleActivity$init$7(SearchPanelFindVehicleActivity searchPanelFindVehicleActivity) {
        this.this$0 = searchPanelFindVehicleActivity;
    }

    public final void onClick(View view) {
        this.this$0.hideSoftKeyboard();
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, this.this$0.searchKeyword);
        this.this$0.setResult(104, intent);
        this.this$0.finish();
        this.this$0.overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
    }
}
