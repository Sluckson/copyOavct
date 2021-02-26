package com.iaai.android.bdt.feature.digitalNegotiation;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.ToolTipActvityStatus;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0006\u0010\u001a\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/DNToolTipActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "toolTipStatus", "", "getToolTipStatus", "()I", "setToolTipStatus", "(I)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbarTilte", "", "getToolbarTilte", "()Ljava/lang/String;", "setToolbarTilte", "(Ljava/lang/String;)V", "handleAwardPendingUI", "", "handleBuyNowUI", "handleDNtoolTipUI", "handleManageBranchToolTip", "handlePurchaseHistoryToolTip", "handleToBePickedUpUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DNToolTipActivity.kt */
public final class DNToolTipActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private int toolTipStatus;
    @NotNull
    public Toolbar toolbar;
    @NotNull
    private String toolbarTilte = "";

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final Toolbar getToolbar() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar2;
    }

    public final void setToolbar(@NotNull Toolbar toolbar2) {
        Intrinsics.checkParameterIsNotNull(toolbar2, "<set-?>");
        this.toolbar = toolbar2;
    }

    @NotNull
    public final String getToolbarTilte() {
        return this.toolbarTilte;
    }

    public final void setToolbarTilte(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.toolbarTilte = str;
    }

    public final int getToolTipStatus() {
        return this.toolTipStatus;
    }

    public final void setToolTipStatus(int i) {
        this.toolTipStatus = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_tool_tip_layout);
        if (getIntent().hasExtra(Constants_MVVM.EXTRA_TOOLBAR_TITLE)) {
            String stringExtra = getIntent().getStringExtra(Constants_MVVM.EXTRA_TOOLBAR_TITLE);
            Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Co…MVVM.EXTRA_TOOLBAR_TITLE)");
            this.toolbarTilte = stringExtra;
        }
        if (getIntent().hasExtra(Constants_MVVM.EXTRA_TOOLTIP_STATUS)) {
            this.toolTipStatus = getIntent().getIntExtra(Constants_MVVM.EXTRA_TOOLTIP_STATUS, 0);
        }
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.toolbar_header);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbar_header");
        textView.setText(this.toolbarTilte);
        int i = this.toolTipStatus;
        if (i == ToolTipActvityStatus.DN_ToolTip.getValue()) {
            handleDNtoolTipUI();
        } else if (i == ToolTipActvityStatus.Awawrd_Pending.getValue()) {
            handleAwardPendingUI();
        } else if (i == ToolTipActvityStatus.Purchase_History.getValue()) {
            handlePurchaseHistoryToolTip();
        } else if (i == ToolTipActvityStatus.BuyNow_ToolTip.getValue()) {
            handleBuyNowUI();
        } else if (i == ToolTipActvityStatus.ToBePickedUP_ToolTip.getValue()) {
            handleToBePickedUpUI();
        } else if (i == ToolTipActvityStatus.MangeBranchPRefToolTip.getValue()) {
            handleManageBranchToolTip();
        }
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_back_tooltip)).setOnClickListener(new DNToolTipActivity$onCreate$1(this));
    }

    private final void handleManageBranchToolTip() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_manage_offer);
        Intrinsics.checkExpressionValueIsNotNull(textView, "txt_manage_offer");
        textView.setText(getString(C2723R.string.lbl_header_manage_branch));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_award_title1);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "txt_award_title1");
        textView2.setVisibility(8);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value1);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "txt_offer_value1");
        textView3.setVisibility(8);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title2);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "txt_offer_title2");
        textView4.setVisibility(8);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value2);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "txt_offer_value2");
        textView5.setVisibility(8);
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title3);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "txt_offer_title3");
        textView6.setVisibility(8);
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value3);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "txt_offer_value3");
        textView7.setVisibility(8);
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title4);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "txt_offer_title4");
        textView8.setVisibility(8);
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value4);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "txt_offer_value4");
        textView9.setVisibility(8);
        TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title5);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "txt_offer_title5");
        textView10.setVisibility(8);
        TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value5);
        Intrinsics.checkExpressionValueIsNotNull(textView11, "txt_offer_value5");
        textView11.setVisibility(8);
        TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title6);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "txt_offer_title6");
        textView12.setVisibility(8);
        TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value6);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "txt_offer_value6");
        textView13.setVisibility(8);
    }

    private final void handleToBePickedUpUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_manage_offer);
        Intrinsics.checkExpressionValueIsNotNull(textView, "txt_manage_offer");
        textView.setText(getString(C2723R.string.lbl_header_to_be_pickedup));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_award_title1);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "txt_award_title1");
        textView2.setVisibility(8);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value1);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "txt_offer_value1");
        textView3.setVisibility(8);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title2);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "txt_offer_title2");
        textView4.setVisibility(8);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value2);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "txt_offer_value2");
        textView5.setVisibility(8);
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title3);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "txt_offer_title3");
        textView6.setVisibility(8);
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value3);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "txt_offer_value3");
        textView7.setVisibility(8);
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title4);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "txt_offer_title4");
        textView8.setVisibility(8);
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value4);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "txt_offer_value4");
        textView9.setVisibility(8);
        TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title5);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "txt_offer_title5");
        textView10.setVisibility(8);
        TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value5);
        Intrinsics.checkExpressionValueIsNotNull(textView11, "txt_offer_value5");
        textView11.setVisibility(8);
        TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title6);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "txt_offer_title6");
        textView12.setVisibility(8);
        TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value6);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "txt_offer_value6");
        textView13.setVisibility(8);
    }

    private final void handleBuyNowUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_manage_offer);
        Intrinsics.checkExpressionValueIsNotNull(textView, "txt_manage_offer");
        textView.setText(getString(C2723R.string.lbl_header_buy_now));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_award_title1);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "txt_award_title1");
        textView2.setVisibility(8);
        ((TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value1)).setTypeface((Typeface) null, 1);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value1);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "txt_offer_value1");
        textView3.setText(getString(C2723R.string.buy_now_title));
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title2);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "txt_offer_title2");
        textView4.setVisibility(8);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value2);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "txt_offer_value2");
        textView5.setVisibility(8);
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title3);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "txt_offer_title3");
        textView6.setVisibility(8);
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value3);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "txt_offer_value3");
        textView7.setVisibility(8);
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title4);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "txt_offer_title4");
        textView8.setVisibility(8);
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value4);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "txt_offer_value4");
        textView9.setVisibility(8);
        TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title5);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "txt_offer_title5");
        textView10.setVisibility(8);
        TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value5);
        Intrinsics.checkExpressionValueIsNotNull(textView11, "txt_offer_value5");
        textView11.setVisibility(8);
        TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title6);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "txt_offer_title6");
        textView12.setVisibility(8);
        TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value6);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "txt_offer_value6");
        textView13.setVisibility(8);
    }

    public final void handleDNtoolTipUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_manage_offer);
        Intrinsics.checkExpressionValueIsNotNull(textView, "txt_manage_offer");
        textView.setText(getString(C2723R.string.lbl_header_managing_offers));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_award_title1);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "txt_award_title1");
        textView2.setText(getString(C2723R.string.txt_offer_title1));
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value1);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "txt_offer_value1");
        textView3.setText(getString(C2723R.string.txt_offer_value1));
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title2);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "txt_offer_title2");
        textView4.setText(getString(C2723R.string.txt_offer_title2));
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value2);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "txt_offer_value2");
        textView5.setText(getString(C2723R.string.txt_offer_value2));
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title3);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "txt_offer_title3");
        textView6.setText(getString(C2723R.string.txt_offer_title3));
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value3);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "txt_offer_value3");
        textView7.setText(getString(C2723R.string.txt_offer_value3));
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title4);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "txt_offer_title4");
        textView8.setText(getString(C2723R.string.txt_offer_title4));
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value4);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "txt_offer_value4");
        textView9.setText(getString(C2723R.string.txt_offer_value4));
        TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title5);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "txt_offer_title5");
        textView10.setText(getString(C2723R.string.txt_offer_title5));
        TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value5);
        Intrinsics.checkExpressionValueIsNotNull(textView11, "txt_offer_value5");
        textView11.setText(getString(C2723R.string.txt_offer_value5));
        TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title6);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "txt_offer_title6");
        textView12.setText(getString(C2723R.string.txt_offer_title6));
        TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value6);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "txt_offer_value6");
        textView13.setText(getString(C2723R.string.txt_offer_value6));
    }

    public final void handleAwardPendingUI() {
        CharSequence charSequence;
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_manage_offer);
        Intrinsics.checkExpressionValueIsNotNull(textView, "txt_manage_offer");
        textView.setText(getString(C2723R.string.lbl_header_award_pending));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_award_title1);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "txt_award_title1");
        textView2.setText(getString(C2723R.string.txt_award_pending_title1));
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value1);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "txt_offer_value1");
        textView3.setText(getString(C2723R.string.txt_award_pending_value1));
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title2);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "txt_offer_title2");
        textView4.setText(getString(C2723R.string.txt_award_pending_title2));
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(getString(C2723R.string.txt_award_pending_value2), 0);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml, "Html.fromHtml(getString(…ml.FROM_HTML_MODE_LEGACY)");
            charSequence = fromHtml;
        } else {
            Spanned fromHtml2 = Html.fromHtml(getString(C2723R.string.txt_award_pending_value2));
            Intrinsics.checkExpressionValueIsNotNull(fromHtml2, "Html.fromHtml(getString(…xt_award_pending_value2))");
            charSequence = fromHtml2;
        }
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value2);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "txt_offer_value2");
        textView5.setText(charSequence);
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title3);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "txt_offer_title3");
        textView6.setVisibility(8);
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value3);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "txt_offer_value3");
        textView7.setVisibility(8);
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title4);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "txt_offer_title4");
        textView8.setVisibility(8);
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value4);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "txt_offer_value4");
        textView9.setVisibility(8);
        TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title5);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "txt_offer_title5");
        textView10.setVisibility(8);
        TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value5);
        Intrinsics.checkExpressionValueIsNotNull(textView11, "txt_offer_value5");
        textView11.setVisibility(8);
        TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title6);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "txt_offer_title6");
        textView12.setVisibility(8);
        TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value6);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "txt_offer_value6");
        textView13.setVisibility(8);
    }

    public final void handlePurchaseHistoryToolTip() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_manage_offer);
        Intrinsics.checkExpressionValueIsNotNull(textView, "txt_manage_offer");
        textView.setText(getString(C2723R.string.lbl_header_purchase_history));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_award_title1);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "txt_award_title1");
        textView2.setText(getString(C2723R.string.txt_purchase_title1));
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value1);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "txt_offer_value1");
        textView3.setText(getString(C2723R.string.txt_purchase_value1));
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title2);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "txt_offer_title2");
        textView4.setText(getString(C2723R.string.txt_purchase_title2));
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value2);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "txt_offer_value2");
        textView5.setText(getString(C2723R.string.txt_purchase_value2));
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title3);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "txt_offer_title3");
        textView6.setText(getString(C2723R.string.txt_purchase_title3));
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value3);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "txt_offer_value3");
        textView7.setText(getString(C2723R.string.txt_purchase_value3));
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title4);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "txt_offer_title4");
        textView8.setVisibility(8);
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value4);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "txt_offer_value4");
        textView9.setVisibility(8);
        TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title5);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "txt_offer_title5");
        textView10.setVisibility(8);
        TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value5);
        Intrinsics.checkExpressionValueIsNotNull(textView11, "txt_offer_value5");
        textView11.setVisibility(8);
        TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_title6);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "txt_offer_title6");
        textView12.setVisibility(8);
        TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_offer_value6);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "txt_offer_value6");
        textView13.setVisibility(8);
    }
}
