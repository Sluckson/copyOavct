package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0004\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\n\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\r\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0004\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\r\u001a\u001f\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u0018\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u0018\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u001b\u001a\u001f\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u001d\u001a\u001f\u0010\"\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u001f\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b&\u0010!\u001a\u0017\u0010'\u001a\u00020\u0002*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010'\u001a\u00020\u0005*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0007\u001a\u0017\u0010'\u001a\u00020\b*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u0010'\u001a\u00020\u000b*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0017\u0010/\u001a\u00020\u0002*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b0\u0010)\u001a\u0017\u0010/\u001a\u00020\u0005*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0007\u001a\u0017\u0010/\u001a\u00020\b*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b2\u0010,\u001a\u0017\u0010/\u001a\u00020\u000b*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b3\u0010.\u0002\u0004\n\u0002\b\u0019¨\u00064"}, mo66933d2 = {"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, mo66934k = 2, mo66935mv = {1, 1, 16})
@JvmName(name = "UNumbersKt")
/* compiled from: UNumbers.kt */
public final class UNumbersKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m5075countOneBitsWZ4Q5Ns(int i) {
        return Integer.bitCount(i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m5071countLeadingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m5079countTrailingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-WZ4Q5Ns  reason: not valid java name */
    private static final int m5091takeHighestOneBitWZ4Q5Ns(int i) {
        return UInt.m4938constructorimpl(Integer.highestOneBit(i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-WZ4Q5Ns  reason: not valid java name */
    private static final int m5095takeLowestOneBitWZ4Q5Ns(int i) {
        return UInt.m4938constructorimpl(Integer.lowestOneBit(i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-V7xB4Y4  reason: not valid java name */
    private static final int m5083rotateLeftV7xB4Y4(int i, int i2) {
        return UInt.m4938constructorimpl(Integer.rotateLeft(i, i2));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-V7xB4Y4  reason: not valid java name */
    private static final int m5087rotateRightV7xB4Y4(int i, int i2) {
        return UInt.m4938constructorimpl(Integer.rotateRight(i, i2));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-VKZWuLQ  reason: not valid java name */
    private static final int m5074countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-VKZWuLQ  reason: not valid java name */
    private static final int m5070countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-VKZWuLQ  reason: not valid java name */
    private static final int m5078countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-VKZWuLQ  reason: not valid java name */
    private static final long m5090takeHighestOneBitVKZWuLQ(long j) {
        return ULong.m5007constructorimpl(Long.highestOneBit(j));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-VKZWuLQ  reason: not valid java name */
    private static final long m5094takeLowestOneBitVKZWuLQ(long j) {
        return ULong.m5007constructorimpl(Long.lowestOneBit(j));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-JSWoG40  reason: not valid java name */
    private static final long m5081rotateLeftJSWoG40(long j, int i) {
        return ULong.m5007constructorimpl(Long.rotateLeft(j, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-JSWoG40  reason: not valid java name */
    private static final long m5085rotateRightJSWoG40(long j, int i) {
        return ULong.m5007constructorimpl(Long.rotateRight(j, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-7apg3OU  reason: not valid java name */
    private static final int m5073countOneBits7apg3OU(byte b) {
        return Integer.bitCount(UInt.m4938constructorimpl(b & 255));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-7apg3OU  reason: not valid java name */
    private static final int m5069countLeadingZeroBits7apg3OU(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-7apg3OU  reason: not valid java name */
    private static final int m5077countTrailingZeroBits7apg3OU(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-7apg3OU  reason: not valid java name */
    private static final byte m5089takeHighestOneBit7apg3OU(byte b) {
        return UByte.m4871constructorimpl((byte) Integer.highestOneBit(b & 255));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-7apg3OU  reason: not valid java name */
    private static final byte m5093takeLowestOneBit7apg3OU(byte b) {
        return UByte.m4871constructorimpl((byte) Integer.lowestOneBit(b & 255));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-LxnNnR4  reason: not valid java name */
    private static final byte m5082rotateLeftLxnNnR4(byte b, int i) {
        return UByte.m4871constructorimpl(NumbersKt.rotateLeft(b, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-LxnNnR4  reason: not valid java name */
    private static final byte m5086rotateRightLxnNnR4(byte b, int i) {
        return UByte.m4871constructorimpl(NumbersKt.rotateRight(b, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-xj2QHRw  reason: not valid java name */
    private static final int m5076countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m4938constructorimpl(s & UShort.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-xj2QHRw  reason: not valid java name */
    private static final int m5072countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-xj2QHRw  reason: not valid java name */
    private static final int m5080countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-xj2QHRw  reason: not valid java name */
    private static final short m5092takeHighestOneBitxj2QHRw(short s) {
        return UShort.m5104constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-xj2QHRw  reason: not valid java name */
    private static final short m5096takeLowestOneBitxj2QHRw(short s) {
        return UShort.m5104constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-olVBNx4  reason: not valid java name */
    private static final short m5084rotateLeftolVBNx4(short s, int i) {
        return UShort.m5104constructorimpl(NumbersKt.rotateLeft(s, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-olVBNx4  reason: not valid java name */
    private static final short m5088rotateRightolVBNx4(short s, int i) {
        return UShort.m5104constructorimpl(NumbersKt.rotateRight(s, i));
    }
}
