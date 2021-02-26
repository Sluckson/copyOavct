package com.paypal.android.sdk.onetouch.core.sdk;

import android.content.Intent;
import android.net.Uri;
import com.paypal.android.sdk.onetouch.core.Request;
import com.paypal.android.sdk.onetouch.core.Result;
import com.paypal.android.sdk.onetouch.core.base.ContextInspector;
import com.paypal.android.sdk.onetouch.core.config.ConfigManager;
import com.paypal.android.sdk.onetouch.core.config.OtcConfiguration;
import com.paypal.android.sdk.onetouch.core.config.Recipe;
import com.paypal.android.sdk.onetouch.core.enums.Protocol;
import com.paypal.android.sdk.onetouch.core.enums.ResultType;
import com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint;

public class BrowserSwitchHelper {
    public static Intent getBrowserSwitchIntent(ContextInspector contextInspector, ConfigManager configManager, Request request) {
        OtcConfiguration config = configManager.getConfig();
        String browserSwitchUrl = request.getBrowserSwitchUrl();
        Recipe browserSwitchRecipe = request.getBrowserSwitchRecipe(config);
        for (String next : browserSwitchRecipe.getTargetPackagesInReversePriorityOrder()) {
            if (Recipe.isValidBrowserTarget(contextInspector.getContext(), browserSwitchUrl, next)) {
                request.trackFpti(contextInspector.getContext(), TrackingPoint.SwitchToBrowser, browserSwitchRecipe.getProtocol());
                return Recipe.getBrowserIntent(contextInspector.getContext(), browserSwitchUrl, next);
            }
        }
        return null;
    }

    /* renamed from: com.paypal.android.sdk.onetouch.core.sdk.BrowserSwitchHelper$1 */
    static /* synthetic */ class C38311 {
        static final /* synthetic */ int[] $SwitchMap$com$paypal$android$sdk$onetouch$core$enums$ResultType = new int[ResultType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.paypal.android.sdk.onetouch.core.enums.ResultType[] r0 = com.paypal.android.sdk.onetouch.core.enums.ResultType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$paypal$android$sdk$onetouch$core$enums$ResultType = r0
                int[] r0 = $SwitchMap$com$paypal$android$sdk$onetouch$core$enums$ResultType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.paypal.android.sdk.onetouch.core.enums.ResultType r1 = com.paypal.android.sdk.onetouch.core.enums.ResultType.Error     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$paypal$android$sdk$onetouch$core$enums$ResultType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.paypal.android.sdk.onetouch.core.enums.ResultType r1 = com.paypal.android.sdk.onetouch.core.enums.ResultType.Cancel     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$paypal$android$sdk$onetouch$core$enums$ResultType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.paypal.android.sdk.onetouch.core.enums.ResultType r1 = com.paypal.android.sdk.onetouch.core.enums.ResultType.Success     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.onetouch.core.sdk.BrowserSwitchHelper.C38311.<clinit>():void");
        }
    }

    public static Result parseBrowserSwitchResponse(ContextInspector contextInspector, Request request, Uri uri) {
        Result parseBrowserResponse = request.parseBrowserResponse(uri);
        int i = C38311.$SwitchMap$com$paypal$android$sdk$onetouch$core$enums$ResultType[parseBrowserResponse.getResultType().ordinal()];
        if (i == 1) {
            request.trackFpti(contextInspector.getContext(), TrackingPoint.Error, (Protocol) null);
        } else if (i == 2) {
            request.trackFpti(contextInspector.getContext(), TrackingPoint.Cancel, (Protocol) null);
        } else if (i == 3) {
            request.trackFpti(contextInspector.getContext(), TrackingPoint.Return, (Protocol) null);
        }
        return parseBrowserResponse;
    }
}
