package com.iaai.android.bdt.feature.auctionMainPage;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo66933d2 = {"com/iaai/android/bdt/feature/auctionMainPage/AuctionMainListFragment$initializeRecycler$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListFragment.kt */
public final class AuctionMainListFragment$initializeRecycler$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ AuctionMainListFragment this$0;

    AuctionMainListFragment$initializeRecycler$2(AuctionMainListFragment auctionMainListFragment) {
        this.this$0 = auctionMainListFragment;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (i2 < 0) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) this.this$0._$_findCachedViewById(C2723R.C2726id.faAuctionMainUpScroll);
            Intrinsics.checkExpressionValueIsNotNull(floatingActionButton, "faAuctionMainUpScroll");
            if (floatingActionButton.getVisibility() == 0) {
                ((FloatingActionButton) this.this$0._$_findCachedViewById(C2723R.C2726id.faAuctionMainUpScroll)).hide();
                return;
            }
        }
        if (i2 > 0) {
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) this.this$0._$_findCachedViewById(C2723R.C2726id.faAuctionMainUpScroll);
            Intrinsics.checkExpressionValueIsNotNull(floatingActionButton2, "faAuctionMainUpScroll");
            if (floatingActionButton2.getVisibility() != 0) {
                ((FloatingActionButton) this.this$0._$_findCachedViewById(C2723R.C2726id.faAuctionMainUpScroll)).show();
            }
        }
    }
}
