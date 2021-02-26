package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "request", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
final class RefinerResultFragment$subscribeToViewModel$4<T> implements Observer<FastSearchRequestBody> {
    final /* synthetic */ RefinerResultFragment this$0;

    RefinerResultFragment$subscribeToViewModel$4(RefinerResultFragment refinerResultFragment) {
        this.this$0 = refinerResultFragment;
    }

    public final void onChanged(FastSearchRequestBody fastSearchRequestBody) {
        if (this.this$0.isFromSavedSearchList) {
            this.this$0.isFromSavedSearchList = false;
            RefinerResultFragment refinerResultFragment = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(fastSearchRequestBody, "request");
            refinerResultFragment.addSelectedFacetForSavedSearch(fastSearchRequestBody);
        }
    }
}
