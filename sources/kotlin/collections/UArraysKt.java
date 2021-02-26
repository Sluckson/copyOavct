package kotlin.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0004ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0006\u001a\u00020\fH\u0004ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001e\u0010&\u001a\u00020+*\u00020\t2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001e\u0010&\u001a\u00020.*\u00020\f2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001e\u0010&\u001a\u000201*\u00020\u000f2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020'05*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020+05*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020.05*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020105*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, mo66933d2 = {"Lkotlin/collections/UArraysKt;", "", "()V", "contentEquals", "", "Lkotlin/UByteArray;", "other", "contentEquals-kdPth3s", "([B[B)Z", "Lkotlin/UIntArray;", "contentEquals-ctEhBpI", "([I[I)Z", "Lkotlin/ULongArray;", "contentEquals-us8wMrg", "([J[J)Z", "Lkotlin/UShortArray;", "contentEquals-mazbYpA", "([S[S)Z", "contentHashCode", "", "contentHashCode-GBYM_sE", "([B)I", "contentHashCode--ajY-9A", "([I)I", "contentHashCode-QwZRm1k", "([J)I", "contentHashCode-rL5Bavg", "([S)I", "contentToString", "", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "random", "Lkotlin/UByte;", "Lkotlin/random/Random;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "Lkotlin/UInt;", "random-2D5oskM", "([ILkotlin/random/Random;)I", "Lkotlin/ULong;", "random-JzugnMA", "([JLkotlin/random/Random;)J", "Lkotlin/UShort;", "random-s5X_as8", "([SLkotlin/random/Random;)S", "toTypedArray", "", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "kotlin-stdlib"}, mo66934k = 1, mo66935mv = {1, 1, 16})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
/* compiled from: UArraysKt.kt */
public final class UArraysKt {
    public static final UArraysKt INSTANCE = new UArraysKt();

    private UArraysKt() {
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: random-2D5oskM  reason: not valid java name */
    public static final int m5196random2D5oskM(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$random");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!UIntArray.m4992isEmptyimpl(iArr)) {
            return UIntArray.m4989getimpl(iArr, random.nextInt(UIntArray.m4990getSizeimpl(iArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: random-JzugnMA  reason: not valid java name */
    public static final long m5197randomJzugnMA(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$random");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!ULongArray.m5061isEmptyimpl(jArr)) {
            return ULongArray.m5058getimpl(jArr, random.nextInt(ULongArray.m5059getSizeimpl(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: random-oSF2wD8  reason: not valid java name */
    public static final byte m5198randomoSF2wD8(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$random");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!UByteArray.m4923isEmptyimpl(bArr)) {
            return UByteArray.m4920getimpl(bArr, random.nextInt(UByteArray.m4921getSizeimpl(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: random-s5X_as8  reason: not valid java name */
    public static final short m5199randoms5X_as8(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$random");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!UShortArray.m5156isEmptyimpl(sArr)) {
            return UShortArray.m5153getimpl(sArr, random.nextInt(UShortArray.m5154getSizeimpl(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentEquals-ctEhBpI  reason: not valid java name */
    public static final boolean m5184contentEqualsctEhBpI(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(iArr2, "other");
        return Arrays.equals(iArr, iArr2);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentEquals-us8wMrg  reason: not valid java name */
    public static final boolean m5187contentEqualsus8wMrg(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(jArr2, "other");
        return Arrays.equals(jArr, jArr2);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentEquals-kdPth3s  reason: not valid java name */
    public static final boolean m5185contentEqualskdPth3s(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(bArr2, "other");
        return Arrays.equals(bArr, bArr2);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentEquals-mazbYpA  reason: not valid java name */
    public static final boolean m5186contentEqualsmazbYpA(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(sArr2, "other");
        return Arrays.equals(sArr, sArr2);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentHashCode--ajY-9A  reason: not valid java name */
    public static final int m5188contentHashCodeajY9A(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$contentHashCode");
        return Arrays.hashCode(iArr);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentHashCode-QwZRm1k  reason: not valid java name */
    public static final int m5190contentHashCodeQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$contentHashCode");
        return Arrays.hashCode(jArr);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentHashCode-GBYM_sE  reason: not valid java name */
    public static final int m5189contentHashCodeGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$contentHashCode");
        return Arrays.hashCode(bArr);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    /* renamed from: contentHashCode-rL5Bavg  reason: not valid java name */
    public static final int m5191contentHashCoderL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$contentHashCode");
        return Arrays.hashCode(sArr);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: contentToString--ajY-9A  reason: not valid java name */
    public static final String m5192contentToStringajY9A(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$contentToString");
        return CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(iArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: contentToString-QwZRm1k  reason: not valid java name */
    public static final String m5194contentToStringQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$contentToString");
        return CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(jArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: contentToString-GBYM_sE  reason: not valid java name */
    public static final String m5193contentToStringGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$contentToString");
        return CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(bArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: contentToString-rL5Bavg  reason: not valid java name */
    public static final String m5195contentToStringrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$contentToString");
        return CollectionsKt.joinToString$default(Intrinsics.checkParameterIsNotNull(sArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: toTypedArray--ajY-9A  reason: not valid java name */
    public static final UInt[] m5200toTypedArrayajY9A(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$toTypedArray");
        int r0 = UIntArray.m4990getSizeimpl(iArr);
        UInt[] uIntArr = new UInt[r0];
        for (int i = 0; i < r0; i++) {
            uIntArr[i] = UInt.m4932boximpl(UIntArray.m4989getimpl(iArr, i));
        }
        return uIntArr;
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: toTypedArray-QwZRm1k  reason: not valid java name */
    public static final ULong[] m5202toTypedArrayQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$toTypedArray");
        int r0 = ULongArray.m5059getSizeimpl(jArr);
        ULong[] uLongArr = new ULong[r0];
        for (int i = 0; i < r0; i++) {
            uLongArr[i] = ULong.m5001boximpl(ULongArray.m5058getimpl(jArr, i));
        }
        return uLongArr;
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: toTypedArray-GBYM_sE  reason: not valid java name */
    public static final UByte[] m5201toTypedArrayGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$toTypedArray");
        int r0 = UByteArray.m4921getSizeimpl(bArr);
        UByte[] uByteArr = new UByte[r0];
        for (int i = 0; i < r0; i++) {
            uByteArr[i] = UByte.m4865boximpl(UByteArray.m4920getimpl(bArr, i));
        }
        return uByteArr;
    }

    @ExperimentalUnsignedTypes
    @JvmStatic
    @NotNull
    /* renamed from: toTypedArray-rL5Bavg  reason: not valid java name */
    public static final UShort[] m5203toTypedArrayrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$toTypedArray");
        int r0 = UShortArray.m5154getSizeimpl(sArr);
        UShort[] uShortArr = new UShort[r0];
        for (int i = 0; i < r0; i++) {
            uShortArr[i] = UShort.m5098boximpl(UShortArray.m5153getimpl(sArr, i));
        }
        return uShortArr;
    }
}
