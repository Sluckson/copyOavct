package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 2}, mo66932d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo66933d2 = {"create", "T", "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "retrofit"}, mo66934k = 2, mo66935mv = {1, 1, 11})
@JvmName(name = "-KotlinExtensions")
/* renamed from: retrofit2.-KotlinExtensions  reason: invalid class name */
/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions {
    private static final <T> T create(@NotNull Retrofit retrofit) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return retrofit.create(Object.class);
    }
}
