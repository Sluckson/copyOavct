package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.model.fastSearchFilter2.Search;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultActivity.kt */
final class RefinerResultActivity$subscribeToViewModel$1<T> implements Observer<FastSearchResponse2> {
    final /* synthetic */ RefinerResultActivity this$0;

    RefinerResultActivity$subscribeToViewModel$1(RefinerResultActivity refinerResultActivity) {
        this.this$0 = refinerResultActivity;
    }

    public final void onChanged(FastSearchResponse2 fastSearchResponse2) {
        Search search;
        List<FormattedResult> formattedResults;
        Log.e("Error", "subscribeToViewModel");
        ArrayList arrayList = new ArrayList();
        if (!(fastSearchResponse2 == null || (search = fastSearchResponse2.getSearch()) == null || (formattedResults = search.getFormattedResults()) == null)) {
            for (FormattedResult itemId : formattedResults) {
                arrayList.add(String.valueOf(itemId.getItemId()));
            }
        }
        RefinerResultActivity.access$getOnNextPageLoad$p(this.this$0).OnNextSlotOfItemID(arrayList);
    }
}
