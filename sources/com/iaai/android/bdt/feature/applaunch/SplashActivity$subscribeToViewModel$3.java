package com.iaai.android.bdt.feature.applaunch;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "it", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SplashActivity.kt */
final class SplashActivity$subscribeToViewModel$3<T> implements Observer<List<? extends SearchMappingArray>> {
    final /* synthetic */ SplashActivity this$0;

    SplashActivity$subscribeToViewModel$3(SplashActivity splashActivity) {
        this.this$0 = splashActivity;
    }

    public final void onChanged(List<SearchMappingArray> list) {
        try {
            Gson gson = new Gson();
            if (list != null) {
                ArrayList<SearchMappingArray> arrayList = (ArrayList) list;
                for (SearchMappingArray searchMappingArray : arrayList) {
                    List sortedWith = CollectionsKt.sortedWith(searchMappingArray.getGroups(), new C2736xed666277());
                    searchMappingArray.getGroups().clear();
                    searchMappingArray.getGroups().addAll(sortedWith);
                }
                String json = gson.toJson((Object) arrayList);
                Log.d("Search Mapping Data", json);
                IAASharedPreference.setSearchMappingData(this.this$0.getApplicationContext(), json);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray> */");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
