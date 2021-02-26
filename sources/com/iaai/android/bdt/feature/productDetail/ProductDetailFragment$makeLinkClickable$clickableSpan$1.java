package com.iaai.android.bdt.feature.productDetail;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.activities.ContactUsActivity;
import com.iaai.android.old.activities.SSORegistrationActivity;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/ProductDetailFragment$makeLinkClickable$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
public final class ProductDetailFragment$makeLinkClickable$clickableSpan$1 extends ClickableSpan {
    final /* synthetic */ URLSpan $span;
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$makeLinkClickable$clickableSpan$1(ProductDetailFragment productDetailFragment, URLSpan uRLSpan) {
        this.this$0 = productDetailFragment;
        this.$span = uRLSpan;
    }

    public void onClick(@Nullable View view) {
        String url = this.$span.getURL();
        Intrinsics.checkExpressionValueIsNotNull(url, "span.url");
        PackageManager packageManager = null;
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "Registration/UpgradeToBid", false, 2, (Object) null)) {
            Intent intent = new Intent(this.this$0.getContext(), SSORegistrationActivity.class);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(Constants.EXTRA_SSO_URL, this.$span.getURL());
            this.this$0.startActivity(intent);
            return;
        }
        String url2 = this.$span.getURL();
        Intrinsics.checkExpressionValueIsNotNull(url2, "span.url");
        if (StringsKt.contains$default((CharSequence) url2, (CharSequence) "Login/LoginPage", false, 2, (Object) null)) {
            this.this$0.getSessionManager().promptForLoginIfNeededTabletBDT(this.this$0.getActivity(), this.this$0.baseFragment, 20);
            return;
        }
        String url3 = this.$span.getURL();
        Intrinsics.checkExpressionValueIsNotNull(url3, "span.url");
        if (StringsKt.contains$default((CharSequence) url3, (CharSequence) "Registration/Free", false, 2, (Object) null)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://www.iaai.com/Registration/Free"));
            intent2.setPackage("com.android.chrome");
            try {
                this.this$0.startActivity(intent2);
            } catch (ActivityNotFoundException unused) {
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.setData(Uri.parse("https://www.iaai.com/Registration/Free"));
                this.this$0.startActivity(intent3);
            }
        } else {
            String url4 = this.$span.getURL();
            Intrinsics.checkExpressionValueIsNotNull(url4, "span.url");
            if (StringsKt.contains$default((CharSequence) url4, (CharSequence) "/Support/CustomerServiceView.aspx", false, 2, (Object) null)) {
                IaaiApplication instance = IaaiApplication.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
                if (instance.getIAARemoteConfig().getBorkerCommunityFlag()) {
                    String string = this.this$0.getString(C2723R.string.url_broker_community_buyer_Service, Constants_MVVM.EXTRA_ENGLISH_CODE);
                    Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.url_b…_MVVM.EXTRA_ENGLISH_CODE)");
                    if (Intrinsics.areEqual((Object) Utils.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                        string = this.this$0.getString(C2723R.string.url_broker_community_buyer_Service, Constants_MVVM.EXTRA_SPANISH_CODE);
                        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.url_b…_MVVM.EXTRA_SPANISH_CODE)");
                    }
                    String str = this.this$0.getString(C2723R.string.base_broker_community_url) + string;
                    Intent intent4 = new Intent(this.this$0.getContext(), WebViewActivity.class);
                    intent4.putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, str);
                    intent4.putExtra(Constants_MVVM.EXTRA_BROKER_TITLE, "Buyer Services");
                    this.this$0.startActivity(intent4);
                    return;
                }
                this.this$0.startActivity(new Intent(this.this$0.getContext(), ContactUsActivity.class));
                return;
            }
            String url5 = this.$span.getURL();
            Intrinsics.checkExpressionValueIsNotNull(url5, "span.url");
            if (StringsKt.contains((CharSequence) url5, (CharSequence) "Services/BrokerSearch", true)) {
                ProductDetailFragment productDetailFragment = this.this$0;
                String url6 = this.$span.getURL();
                Intrinsics.checkExpressionValueIsNotNull(url6, "span.url");
                productDetailFragment.navigateToLicencedBorkerPage(url6);
                return;
            }
            String url7 = this.$span.getURL();
            Intrinsics.checkExpressionValueIsNotNull(url7, "span.url");
            if (StringsKt.contains((CharSequence) url7, (CharSequence) "/Broker/BrokerSearch", true)) {
                ProductDetailFragment productDetailFragment2 = this.this$0;
                String url8 = this.$span.getURL();
                Intrinsics.checkExpressionValueIsNotNull(url8, "span.url");
                productDetailFragment2.navigateToLicencedBorkerPage(url8);
                return;
            }
            String url9 = this.$span.getURL();
            Intrinsics.checkExpressionValueIsNotNull(url9, "span.url");
            if (StringsKt.contains((CharSequence) url9, (CharSequence) "broker-search", true)) {
                ProductDetailFragment productDetailFragment3 = this.this$0;
                String url10 = this.$span.getURL();
                Intrinsics.checkExpressionValueIsNotNull(url10, "span.url");
                productDetailFragment3.navigateToLicencedBorkerPage(url10);
                return;
            }
            Uri parse = Uri.parse(this.$span.getURL());
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(span.url)");
            Intent intent5 = new Intent("android.intent.action.VIEW", parse);
            BaseActivity access$getBaseActivity$p = this.this$0.baseActivity;
            if (access$getBaseActivity$p != null) {
                packageManager = access$getBaseActivity$p.getPackageManager();
            }
            if (packageManager == null) {
                Intrinsics.throwNpe();
            }
            if (intent5.resolveActivity(packageManager) != null) {
                this.this$0.startActivity(intent5);
                return;
            }
            Context context = this.this$0.getContext();
            if (context != null) {
                Context_ExtensionKt.showToast(context, "No activity found to handle this action");
            }
        }
    }
}
