package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, mo66933d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "sortArray-GBYM_sE", "([B)V", "sortArray--ajY-9A", "([I)V", "sortArray-QwZRm1k", "([J)V", "sortArray-rL5Bavg", "([S)V", "kotlin-stdlib"}, mo66934k = 2, mo66935mv = {1, 1, 16})
/* compiled from: UArraySorting.kt */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m5173partition4UcCI2c(byte[] bArr, int i, int i2) {
        byte b;
        byte b2 = UByteArray.m4920getimpl(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                b = b2 & 255;
                if (Intrinsics.compare((int) UByteArray.m4920getimpl(bArr, i) & 255, (int) b) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare((int) UByteArray.m4920getimpl(bArr, i2) & 255, (int) b) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte b3 = UByteArray.m4920getimpl(bArr, i);
                UByteArray.m4925setVurrAj0(bArr, i, UByteArray.m4920getimpl(bArr, i2));
                UByteArray.m4925setVurrAj0(bArr, i2, b3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m5177quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int r0 = m5173partition4UcCI2c(bArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m5177quickSort4UcCI2c(bArr, i, i3);
        }
        if (r0 < i2) {
            m5177quickSort4UcCI2c(bArr, r0, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m5174partitionAa5vz7o(short[] sArr, int i, int i2) {
        short s;
        short s2 = UShortArray.m5153getimpl(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                short s3 = UShortArray.m5153getimpl(sArr, i) & UShort.MAX_VALUE;
                s = s2 & UShort.MAX_VALUE;
                if (Intrinsics.compare((int) s3, (int) s) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare((int) UShortArray.m5153getimpl(sArr, i2) & UShort.MAX_VALUE, (int) s) > 0) {
                i2--;
            }
            if (i <= i2) {
                short s4 = UShortArray.m5153getimpl(sArr, i);
                UShortArray.m5158set01HTLdE(sArr, i, UShortArray.m5153getimpl(sArr, i2));
                UShortArray.m5158set01HTLdE(sArr, i2, s4);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m5178quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int r0 = m5174partitionAa5vz7o(sArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m5178quickSortAa5vz7o(sArr, i, i3);
        }
        if (r0 < i2) {
            m5178quickSortAa5vz7o(sArr, r0, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m5175partitionoBK06Vg(int[] iArr, int i, int i2) {
        int i3 = UIntArray.m4989getimpl(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m4989getimpl(iArr, i), i3) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m4989getimpl(iArr, i2), i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                int i4 = UIntArray.m4989getimpl(iArr, i);
                UIntArray.m4994setVXSXFK8(iArr, i, UIntArray.m4989getimpl(iArr, i2));
                UIntArray.m4994setVXSXFK8(iArr, i2, i4);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m5179quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int r0 = m5175partitionoBK06Vg(iArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m5179quickSortoBK06Vg(iArr, i, i3);
        }
        if (r0 < i2) {
            m5179quickSortoBK06Vg(iArr, r0, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m5172partitionnroSd4(long[] jArr, int i, int i2) {
        long j = ULongArray.m5058getimpl(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m5058getimpl(jArr, i), j) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m5058getimpl(jArr, i2), j) > 0) {
                i2--;
            }
            if (i <= i2) {
                long j2 = ULongArray.m5058getimpl(jArr, i);
                ULongArray.m5063setk8EXiF4(jArr, i, ULongArray.m5058getimpl(jArr, i2));
                ULongArray.m5063setk8EXiF4(jArr, i2, j2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m5176quickSortnroSd4(long[] jArr, int i, int i2) {
        int r0 = m5172partitionnroSd4(jArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m5176quickSortnroSd4(jArr, i, i3);
        }
        if (r0 < i2) {
            m5176quickSortnroSd4(jArr, r0, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-GBYM_sE  reason: not valid java name */
    public static final void m5181sortArrayGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        m5177quickSort4UcCI2c(bArr, 0, UByteArray.m4921getSizeimpl(bArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-rL5Bavg  reason: not valid java name */
    public static final void m5183sortArrayrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "array");
        m5178quickSortAa5vz7o(sArr, 0, UShortArray.m5154getSizeimpl(sArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--ajY-9A  reason: not valid java name */
    public static final void m5180sortArrayajY9A(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "array");
        m5179quickSortoBK06Vg(iArr, 0, UIntArray.m4990getSizeimpl(iArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-QwZRm1k  reason: not valid java name */
    public static final void m5182sortArrayQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "array");
        m5176quickSortnroSd4(jArr, 0, ULongArray.m5059getSizeimpl(jArr) - 1);
    }
}
