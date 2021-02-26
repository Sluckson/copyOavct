package com.iaai.android.bdt.feature.landing.recommendedVehicles;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/CustomPopUpDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "badgesAdapter", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/BadgesAdapter;", "initializeRecycler", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CustomPopUpDialog.kt */
public final class CustomPopUpDialog extends Dialog {
    @NotNull
    private Activity activity;
    private BadgesAdapter badgesAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomPopUpDialog(@NotNull Activity activity2) {
        super(activity2);
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        this.activity = activity2;
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(@NotNull Activity activity2) {
        Intrinsics.checkParameterIsNotNull(activity2, "<set-?>");
        this.activity = activity2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C2723R.C2728layout.custom_badge_pop_up);
        initializeRecycler();
        ((TextView) findViewById(C2723R.C2726id.btnClose)).setOnClickListener(new CustomPopUpDialog$onCreate$1(this));
    }

    private final void initializeRecycler() {
        this.badgesAdapter = new BadgesAdapter(this.activity, CollectionsKt.arrayListOf(Integer.valueOf(C2723R.string.lbl_bdt_badge_make_model), Integer.valueOf(C2723R.string.lbl_bdt_badge_foreign_domestic), Integer.valueOf(C2723R.string.lbl_bdt_badge_sale_doc_type), Integer.valueOf(C2723R.string.lbl_bdt_badge_acv), Integer.valueOf(C2723R.string.lbl_bdt_badge_age)), CollectionsKt.arrayListOf(Integer.valueOf(C2723R.C2725drawable.ic_bre_badge_make_model), Integer.valueOf(C2723R.C2725drawable.ic_bre_badge_foreign), Integer.valueOf(C2723R.C2725drawable.ic_bre_badge), Integer.valueOf(C2723R.C2725drawable.ic_bre_badge_acv), Integer.valueOf(C2723R.C2725drawable.ic_bre_badge_age)));
        RecyclerView recyclerView = (RecyclerView) findViewById(C2723R.C2726id.rvBadges);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvBadges");
        BadgesAdapter badgesAdapter2 = this.badgesAdapter;
        if (badgesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badgesAdapter");
        }
        recyclerView.setAdapter(badgesAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(C2723R.C2726id.rvBadges);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvBadges");
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
    }
}
