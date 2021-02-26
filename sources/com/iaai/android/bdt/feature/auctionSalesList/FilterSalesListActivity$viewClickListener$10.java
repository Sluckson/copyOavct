package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterSalesListActivity.kt */
final class FilterSalesListActivity$viewClickListener$10 implements View.OnClickListener {
    final /* synthetic */ FilterSalesListActivity this$0;

    FilterSalesListActivity$viewClickListener$10(FilterSalesListActivity filterSalesListActivity) {
        this.this$0 = filterSalesListActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01a5, code lost:
        if ((com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity.access$getLossType$p(r7.this$0).length() > 0) != false) goto L_0x017e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r0 = r7.this$0
            android.content.Context r0 = r0.getApplicationContext()
            com.iaai.android.old.utils.AppUtils.hideSoftkeyBoard(r0, r8)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            int r0 = com.iaai.android.C2723R.C2726id.et_start_year
            android.view.View r8 = r8._$_findCachedViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r0 = "et_start_year"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r0)
            java.lang.CharSequence r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            r1 = 0
            r2 = 1
            if (r8 != 0) goto L_0x002c
            r8 = 1
            goto L_0x002d
        L_0x002c:
            r8 = 0
        L_0x002d:
            java.lang.String r3 = ""
            if (r8 == 0) goto L_0x0033
            r8 = r3
            goto L_0x0048
        L_0x0033:
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            int r4 = com.iaai.android.C2723R.C2726id.et_start_year
            android.view.View r8 = r8._$_findCachedViewById(r4)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r0)
            java.lang.CharSequence r8 = r8.getText()
            java.lang.String r8 = r8.toString()
        L_0x0048:
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r0 = r7.this$0
            int r4 = com.iaai.android.C2723R.C2726id.et_end_year
            android.view.View r0 = r0._$_findCachedViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "et_end_year"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0069
            r0 = 1
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            if (r0 == 0) goto L_0x006e
            r0 = r3
            goto L_0x0083
        L_0x006e:
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r0 = r7.this$0
            int r5 = com.iaai.android.C2723R.C2726id.et_end_year
            android.view.View r0 = r0._$_findCachedViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
        L_0x0083:
            r4 = r8
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x008e
            r5 = 1
            goto L_0x008f
        L_0x008e:
            r5 = 0
        L_0x008f:
            java.lang.String r6 = "tv_year_error"
            if (r5 == 0) goto L_0x00c7
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x009e
            r5 = 1
            goto L_0x009f
        L_0x009e:
            r5 = 0
        L_0x009f:
            if (r5 == 0) goto L_0x00c7
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            int r0 = com.iaai.android.C2723R.C2726id.tv_year_error
            android.view.View r8 = r8._$_findCachedViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r6)
            r8.setVisibility(r1)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            int r0 = com.iaai.android.C2723R.C2726id.tv_year_error
            android.view.View r8 = r8._$_findCachedViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r6)
            java.lang.String r0 = "Please enter max year"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            goto L_0x01dc
        L_0x00c7:
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x00d2
            r5 = 1
            goto L_0x00d3
        L_0x00d2:
            r5 = 0
        L_0x00d3:
            if (r5 == 0) goto L_0x0106
            int r5 = r4.length()
            if (r5 != 0) goto L_0x00dd
            r5 = 1
            goto L_0x00de
        L_0x00dd:
            r5 = 0
        L_0x00de:
            if (r5 == 0) goto L_0x0106
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            int r0 = com.iaai.android.C2723R.C2726id.tv_year_error
            android.view.View r8 = r8._$_findCachedViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r6)
            r8.setVisibility(r1)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            int r0 = com.iaai.android.C2723R.C2726id.tv_year_error
            android.view.View r8 = r8._$_findCachedViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r6)
            java.lang.String r0 = "Please enter min year"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            goto L_0x01dc
        L_0x0106:
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r5 = r7.this$0
            android.content.Context r5 = r5.getApplicationContext()
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r6 = r7.this$0
            int r6 = r6.lossTypeItemPosition
            com.iaai.android.old.utils.IAASharedPreference.setLossTypeItemPosPreferencesMVVM(r5, r6)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r5 = r7.this$0
            android.content.Context r5 = r5.getApplicationContext()
            com.iaai.android.old.utils.IAASharedPreference.setStartYearFilterPreferencesMVVM(r5, r8)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r5 = r7.this$0
            android.content.Context r5 = r5.getApplicationContext()
            com.iaai.android.old.utils.IAASharedPreference.setEndYearFilterPreferencesMVVM(r5, r0)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r5 = r7.this$0
            android.content.Context r5 = r5.getApplicationContext()
            int r6 = r4.length()
            if (r6 != 0) goto L_0x0135
            r6 = 1
            goto L_0x0136
        L_0x0135:
            r6 = 0
        L_0x0136:
            if (r6 == 0) goto L_0x0139
            goto L_0x0152
        L_0x0139:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Year: "
            r3.append(r6)
            r3.append(r8)
            java.lang.String r6 = " - "
            r3.append(r6)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
        L_0x0152:
            com.iaai.android.old.utils.IAASharedPreference.setYearFilterPreferencesMVVM(r5, r3)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r3 = r7.this$0
            android.content.Context r3 = r3.getApplicationContext()
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r5 = r7.this$0
            java.lang.String r5 = r5.getLane()
            com.iaai.android.old.utils.IAASharedPreference.setLaneFilterPreferencesMVVM(r3, r5)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r3 = r7.this$0
            android.content.Context r3 = r3.getApplicationContext()
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r5 = r7.this$0
            java.lang.String r5 = r5.lossType
            com.iaai.android.old.utils.IAASharedPreference.setLossTypeFilterPreferencesMVVM(r3, r5)
            int r3 = r4.length()
            if (r3 <= 0) goto L_0x017b
            r3 = 1
            goto L_0x017c
        L_0x017b:
            r3 = 0
        L_0x017c:
            if (r3 == 0) goto L_0x0180
        L_0x017e:
            r1 = 1
            goto L_0x01a8
        L_0x0180:
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r3 = r7.this$0
            java.lang.String r3 = r3.getLane()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0190
            r3 = 1
            goto L_0x0191
        L_0x0190:
            r3 = 0
        L_0x0191:
            if (r3 == 0) goto L_0x0194
            goto L_0x017e
        L_0x0194:
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r3 = r7.this$0
            java.lang.String r3 = r3.lossType
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x01a4
            r3 = 1
            goto L_0x01a5
        L_0x01a4:
            r3 = 0
        L_0x01a5:
            if (r3 == 0) goto L_0x01a8
            goto L_0x017e
        L_0x01a8:
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            java.lang.String r4 = "startYear"
            r3.putExtra(r4, r8)
            java.lang.String r8 = "startEnd"
            r3.putExtra(r8, r0)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            java.lang.String r8 = r8.getLane()
            java.lang.String r0 = "lane"
            r3.putExtra(r0, r8)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            java.lang.String r8 = r8.lossType
            java.lang.String r0 = "lossType"
            r3.putExtra(r0, r8)
            java.lang.String r8 = "isFilterApplied"
            r3.putExtra(r8, r1)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            r8.setResult(r2, r3)
            com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity r8 = r7.this$0
            r8.finish()
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionSalesList.FilterSalesListActivity$viewClickListener$10.onClick(android.view.View):void");
    }
}
