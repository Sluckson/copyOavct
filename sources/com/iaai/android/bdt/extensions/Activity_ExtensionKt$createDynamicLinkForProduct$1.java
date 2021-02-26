package com.iaai.android.bdt.extensions;

import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.iaai.android.bdt.base.DynamicLinkCallback;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "result", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink;", "kotlin.jvm.PlatformType", "onSuccess"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: Activity+Extension.kt */
final class Activity_ExtensionKt$createDynamicLinkForProduct$1<TResult> implements OnSuccessListener<ShortDynamicLink> {
    final /* synthetic */ DynamicLinkCallback $callback;
    final /* synthetic */ String $verbiage;

    Activity_ExtensionKt$createDynamicLinkForProduct$1(String str, DynamicLinkCallback dynamicLinkCallback) {
        this.$verbiage = str;
        this.$callback = dynamicLinkCallback;
    }

    public final void onSuccess(ShortDynamicLink shortDynamicLink) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.$verbiage);
        sb.append(" \n ");
        Intrinsics.checkExpressionValueIsNotNull(shortDynamicLink, Constants.EXTRA_RESULT);
        sb.append(shortDynamicLink.getShortLink());
        String sb2 = sb.toString();
        this.$callback.postShortLinkURL(sb2);
        Log.e("createDynamicLink:", "Short link: " + sb2);
        shortDynamicLink.getPreviewLink();
    }
}
