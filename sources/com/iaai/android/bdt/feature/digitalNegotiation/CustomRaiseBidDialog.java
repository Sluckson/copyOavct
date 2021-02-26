package com.iaai.android.bdt.feature.digitalNegotiation;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.EditText;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/CustomRaiseBidDialog;", "Landroid/app/Dialog;", "sellerOfferAmount", "", "buyAmount", "activity", "Landroid/app/Activity;", "listener", "Lcom/iaai/android/bdt/feature/digitalNegotiation/RaiseBidCallback;", "(JJLandroid/app/Activity;Lcom/iaai/android/bdt/feature/digitalNegotiation/RaiseBidCallback;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getBuyAmount", "()J", "setBuyAmount", "(J)V", "getListener", "()Lcom/iaai/android/bdt/feature/digitalNegotiation/RaiseBidCallback;", "setListener", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/RaiseBidCallback;)V", "getSellerOfferAmount", "setSellerOfferAmount", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CustomRaiseBidDialog.kt */
public final class CustomRaiseBidDialog extends Dialog {
    @NotNull
    private Activity activity;
    private long buyAmount;
    @NotNull
    private RaiseBidCallback listener;
    private long sellerOfferAmount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomRaiseBidDialog(long j, long j2, @NotNull Activity activity2, @NotNull RaiseBidCallback raiseBidCallback) {
        super(activity2);
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(raiseBidCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.sellerOfferAmount = j;
        this.buyAmount = j2;
        this.activity = activity2;
        this.listener = raiseBidCallback;
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    public final long getBuyAmount() {
        return this.buyAmount;
    }

    @NotNull
    public final RaiseBidCallback getListener() {
        return this.listener;
    }

    public final long getSellerOfferAmount() {
        return this.sellerOfferAmount;
    }

    public final void setActivity(@NotNull Activity activity2) {
        Intrinsics.checkParameterIsNotNull(activity2, "<set-?>");
        this.activity = activity2;
    }

    public final void setBuyAmount(long j) {
        this.buyAmount = j;
    }

    public final void setListener(@NotNull RaiseBidCallback raiseBidCallback) {
        Intrinsics.checkParameterIsNotNull(raiseBidCallback, "<set-?>");
        this.listener = raiseBidCallback;
    }

    public final void setSellerOfferAmount(long j) {
        this.sellerOfferAmount = j;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C2723R.C2728layout.custom_raise_bid_layout);
        ((EditText) findViewById(C2723R.C2726id.etRaiseBid)).setOnEditorActionListener(new CustomRaiseBidDialog$onCreate$1(this));
    }
}
