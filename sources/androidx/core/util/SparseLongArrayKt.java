package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, mo66933d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: SparseLongArray.kt */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final int getSize(@NotNull SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$size");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean contains(@NotNull SparseLongArray sparseLongArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$contains");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final void set(@NotNull SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$set");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull SparseLongArray sparseLongArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$containsKey");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull SparseLongArray sparseLongArray, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$containsValue");
        return sparseLongArray.indexOfValue(j) != -1;
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$getOrDefault");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull SparseLongArray sparseLongArray, int i, @NotNull Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        return indexOfKey != -1 ? sparseLongArray.valueAt(indexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$isEmpty");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$isNotEmpty");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$remove");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey == -1 || j != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull SparseLongArray sparseLongArray, @NotNull Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseLongArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
        }
    }

    @RequiresApi(18)
    @NotNull
    public static final IntIterator keyIterator(@NotNull SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$keyIterator");
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    @RequiresApi(18)
    @NotNull
    public static final LongIterator valueIterator(@NotNull SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$valueIterator");
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        for (int i = 0; i < size; i++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
        }
    }
}
