package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.utils.BDTUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\r"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$clickListener$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchExpandableAdapter$OnFilterItemClickListener;", "onGroupClearClick", "", "parentPos", "", "onMultiSelectItemClick", "parentPosition", "childPosition", "isSelected", "", "onRadioItemClick", "onSliderItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
public final class FastSearchFilterFragment$clickListener$1 implements FastSearchExpandableAdapter.OnFilterItemClickListener {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$clickListener$1(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public void onMultiSelectItemClick(int i, int i2, boolean z) {
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…s].groups[parentPosition]");
        SearchMappingGroup searchMappingGroup2 = searchMappingGroup;
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i));
        String str = null;
        FacetXX facetXX = list != null ? (FacetXX) list.get(i2) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("MULTI CLICK: ");
        sb.append(searchMappingGroup2.getDisplayname());
        sb.append(' ');
        if (facetXX != null) {
            str = facetXX.getValue();
        }
        sb.append(str);
        sb.append(' ');
        sb.append(z);
        Log.e("TEST", sb.toString());
        this.this$0.updateHeader(i, i2, HeaderUpdate.MULTI_SELECT, z);
    }

    public void onRadioItemClick(int i, int i2) {
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…s].groups[parentPosition]");
        SearchMappingGroup searchMappingGroup2 = searchMappingGroup;
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i));
        String str = null;
        FacetXX facetXX = list != null ? (FacetXX) list.get(i2) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("RADIO CLICK: ");
        sb.append(searchMappingGroup2.getDisplayname());
        sb.append(' ');
        if (facetXX != null) {
            str = facetXX.getValue();
        }
        sb.append(str);
        Log.e("TEST", sb.toString());
        this.this$0.updateHeader(i, i2, HeaderUpdate.SINGLE_SELECT, false);
    }

    public void onSliderItemClick(int i) {
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…s].groups[parentPosition]");
        SearchMappingGroup searchMappingGroup2 = searchMappingGroup;
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i));
        String str = null;
        FacetXX facetXX = list != null ? (FacetXX) list.get(0) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("SLIDER CLICK: ");
        sb.append(searchMappingGroup2.getDisplayname());
        sb.append(' ');
        if (facetXX != null) {
            str = facetXX.getValue();
        }
        sb.append(str);
        Log.e("TEST", sb.toString());
        this.this$0.updateHeader(i, 0, HeaderUpdate.SLIDER, false);
    }

    public void onGroupClearClick(int i) {
        Log.e("TEST", "GROUP CLEAR CLICK: " + i);
        List<FacetXX> list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i));
        if (list != null) {
            for (FacetXX selected : list) {
                selected.setSelected(false);
            }
        }
        this.this$0.updateHeader(i, 0, HeaderUpdate.CLEAR_GROUP_VIEW, false);
        if (Intrinsics.areEqual((Object) BDTUtils.INSTANCE.getSearchMappingArray().get(this.this$0.tabPos).getGroups().get(i).getGroup(), (Object) ExifInterface.TAG_MAKE)) {
            this.this$0.lastSelectedMakeModel.clear();
            this.this$0.resetUIForSeriesAndMakeModel();
        }
        this.this$0.parentPosition = -1;
        this.this$0.getFilterValueBasedSelectedRefiner(true);
    }
}
