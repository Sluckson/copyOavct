package com.iaai.android.bdt.utils;

import android.content.Context;
import android.database.Cursor;
import com.iaai.android.old.providers.IaaContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/ContentResolverUtil;", "", "()V", "getFCMRegistrationId", "", "context", "Landroid/content/Context;", "code", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ContentResolverUtil.kt */
public final class ContentResolverUtil {
    public static final ContentResolverUtil INSTANCE = new ContentResolverUtil();

    private ContentResolverUtil() {
    }

    @Nullable
    public final String getFCMRegistrationId(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return getFCMRegistrationId(context, -1);
    }

    private final String getFCMRegistrationId(Context context, int i) {
        String str;
        Cursor cursor = null;
        if (i == -1) {
            str = null;
        } else {
            try {
                str = "isSync = " + i;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        Cursor query = context.getContentResolver().query(IaaContent.C2dmRegistration.CONTENT_URI, (String[]) null, str, (String[]) null, (String) null);
        if (query == null) {
            Intrinsics.throwNpe();
        }
        if (query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex(IaaContent.C2dmRegistration.REGISTRATION_ID));
            query.close();
            return string;
        }
        query.close();
        return null;
    }
}
