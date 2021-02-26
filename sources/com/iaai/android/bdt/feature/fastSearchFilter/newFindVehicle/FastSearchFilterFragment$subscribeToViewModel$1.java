package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
final class FastSearchFilterFragment$subscribeToViewModel$1<T> implements Observer<FastSearchResponse2> {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$subscribeToViewModel$1(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public final void onChanged(FastSearchResponse2 fastSearchResponse2) {
        Context context;
        Boolean isFirstLaunchForFastSearch = IAASharedPreference.getIsFirstLaunchForFastSearch(this.this$0.getContext());
        Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchForFastSearch, "isFirstLaunch");
        if (isFirstLaunchForFastSearch.booleanValue() && (context = this.this$0.getContext()) != null) {
            Context_ExtensionKt.launchOnBoardingScreen(context, OnBoardingEnum.FAST_SEARCH);
        }
        this.this$0.showLoadingIndicator(false);
        if (!StringsKt.isBlank(this.this$0.scanValue)) {
            this.this$0.scanValue = "";
            this.this$0.navigateToProductDetailPage(fastSearchResponse2.getSearch().getFormattedResults().get(0));
        } else if (this.this$0.isSavedSearchPressed) {
            this.this$0.isSavedSearchPressed = false;
            FastSearchFilterFragment fastSearchFilterFragment = this.this$0;
            fastSearchFilterFragment.insertSaveSearch(fastSearchFilterFragment.saveText, fastSearchResponse2.getSearch().getResult().getURI());
        } else {
            FastSearchFilterFragment fastSearchFilterFragment2 = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(fastSearchResponse2, "it");
            fastSearchFilterFragment2.updateFacetUIBasedOnResponse(fastSearchResponse2);
            BDTUtils.INSTANCE.updateFacetJson(FastSearchFilterFragment.access$getFastSearchFilterActivity$p(this.this$0), fastSearchResponse2);
        }
    }
}
