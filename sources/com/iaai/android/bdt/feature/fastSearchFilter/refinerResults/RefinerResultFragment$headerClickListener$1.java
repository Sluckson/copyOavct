package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.RefinerHeaderAdapter;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment$headerClickListener$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$OnRefinerHeaderItemClickListener;", "onItemClick", "", "indices", "Lkotlin/Triple;", "", "facetXX", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "position", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
public final class RefinerResultFragment$headerClickListener$1 implements RefinerHeaderAdapter.OnRefinerHeaderItemClickListener {
    final /* synthetic */ RefinerResultFragment this$0;

    RefinerResultFragment$headerClickListener$1(RefinerResultFragment refinerResultFragment) {
        this.this$0 = refinerResultFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.iaai.android.bdt.model.fastSearchFilter2.FacetXX} */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        if (r0 != 4) goto L_0x00be;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(@org.jetbrains.annotations.NotNull kotlin.Triple<java.lang.Integer, java.lang.Integer, java.lang.Integer> r9, @org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r10, int r11) {
        /*
            r8 = this;
            java.lang.String r0 = "indices"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.Object r0 = r9.getFirst()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r1 = 0
            r2 = 1
            r3 = 2
            r4 = 0
            if (r0 == 0) goto L_0x0057
            if (r0 == r2) goto L_0x0057
            if (r0 == r3) goto L_0x001e
            r5 = 4
            if (r0 == r5) goto L_0x0057
            goto L_0x00be
        L_0x001e:
            com.iaai.android.bdt.utils.BDTUtils r10 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            com.iaai.android.bdt.utils.BDTUtils r0 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.LinkedHashMap r0 = r0.getExpandableListDetailPC()
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r5 = r5.getSearchMappingArray()
            java.lang.Object r3 = r5.get(r3)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r3 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray) r3
            java.util.ArrayList r3 = r3.getGroups()
            java.lang.Object r3 = r3.get(r4)
            java.lang.Object r0 = r0.get(r3)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0053
            java.lang.Object r9 = r9.getThird()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r9 = r0.get(r9)
            r1 = r9
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r1 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r1
        L_0x0053:
            r10.updateGlobalPopularCategoryMapping(r1)
            goto L_0x00be
        L_0x0057:
            if (r10 == 0) goto L_0x00a8
            java.lang.String r0 = r10.getRefinerValue()
            if (r0 == 0) goto L_0x00a8
            java.lang.String r5 = "keyword"
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r5, r4, r3, r1)
            if (r0 != 0) goto L_0x00a8
            com.iaai.android.bdt.utils.BDTUtils r0 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.lang.Object r5 = r9.getFirst()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.Object r6 = r9.getSecond()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            java.lang.Object r7 = r9.getThird()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r0.updateGlobalFilterMapping(r5, r6, r7, r10)
            java.lang.String r0 = r10.getRefinerValue()
            java.lang.String r5 = "AuctionType"
            boolean r0 = kotlin.text.StringsKt.equals$default(r0, r5, r4, r3, r1)
            if (r0 == 0) goto L_0x00be
            java.lang.String r10 = r10.getValue()
            java.lang.String r0 = "Buy Now"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)
            if (r10 == 0) goto L_0x00be
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r10 = r8.this$0
            r10.updateBuyNowPrice(r9)
            goto L_0x00be
        L_0x00a8:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            int r10 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r9 = r9._$_findCachedViewById(r10)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r10 = "ed_search_result"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
            java.lang.String r10 = ""
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
        L_0x00be:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            java.util.ArrayList r9 = r9.selectedFacets
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x00d1
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r9 = 0
            goto L_0x00d2
        L_0x00d1:
            r9 = 1
        L_0x00d2:
            if (r9 != 0) goto L_0x00e6
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            java.util.ArrayList r9 = r9.selectedFacets
            r9.remove(r11)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r9 = com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment.access$getRefinerResultListAdapter$p(r9)
            r9.notifyDataSetChanged()
        L_0x00e6:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            java.util.ArrayList r9 = r9.selectedIndices
            java.util.Collection r9 = (java.util.Collection) r9
            if (r9 == 0) goto L_0x00f8
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            if (r2 != 0) goto L_0x010c
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            java.util.ArrayList r9 = r9.selectedIndices
            r9.remove(r11)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r9 = com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment.access$getRefinerResultListAdapter$p(r9)
            r9.notifyDataSetChanged()
        L_0x010c:
            com.iaai.android.IaaiApplication.isSavedSearch = r4
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            r9.updateGlobalArrayForSelectedFacet()
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment r9 = r8.this$0
            r9.loadRefinerResult()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment$headerClickListener$1.onItemClick(kotlin.Triple, com.iaai.android.bdt.model.fastSearchFilter2.FacetXX, int):void");
    }
}
