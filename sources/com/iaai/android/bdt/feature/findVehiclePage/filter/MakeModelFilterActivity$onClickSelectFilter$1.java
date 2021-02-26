package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelFilterActivity.kt */
final class MakeModelFilterActivity$onClickSelectFilter$1 implements View.OnClickListener {
    final /* synthetic */ MakeModelFilterActivity this$0;

    MakeModelFilterActivity$onClickSelectFilter$1(MakeModelFilterActivity makeModelFilterActivity) {
        this.this$0 = makeModelFilterActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, this.this$0.selectedFilterList);
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_LAST_SELECTED_MAKE_MODEL, this.this$0.getLastSelectedModel());
        this.this$0.setResult(102, intent);
        this.this$0.finish();
    }
}
