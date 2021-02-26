package com.iaai.android.bdt.model.fastSearch;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0003\bÞ\u0001\b\b\u0018\u0000 û\u00012\u00020\u0001:\u0002û\u0001Bù\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u0001\u0012\u0006\u0010 \u001a\u00020\u0001\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0001\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u001e\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0001\u0012\u0006\u00101\u001a\u00020\u001e\u0012\u0006\u00102\u001a\u00020\u0001\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u0001\u0012\u0006\u00106\u001a\u00020\u0001\u0012\u0006\u00107\u001a\u00020\u0001\u0012\u0006\u00108\u001a\u00020\u0005\u0012\u0006\u00109\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u001e\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u0001\u0012\u0006\u0010=\u001a\u00020\u0005\u0012\u0006\u0010>\u001a\u00020\u0010\u0012\u0006\u0010?\u001a\u00020\u0005\u0012\u0006\u0010@\u001a\u00020\u0001\u0012\u0006\u0010A\u001a\u00020\u0005\u0012\u0006\u0010B\u001a\u00020\u0005\u0012\u0006\u0010C\u001a\u00020\u0001\u0012\u0006\u0010D\u001a\u00020\u0005\u0012\u0006\u0010E\u001a\u00020\u0001\u0012\u0006\u0010F\u001a\u00020\u0005\u0012\u0006\u0010G\u001a\u00020\u0001\u0012\u0006\u0010H\u001a\u00020\u0005\u0012\u0006\u0010I\u001a\u00020\u0001\u0012\u0006\u0010J\u001a\u00020\u0005\u0012\u0006\u0010K\u001a\u00020\u0001\u0012\u0006\u0010L\u001a\u00020\u0005\u0012\u0006\u0010M\u001a\u00020\u0001\u0012\u0006\u0010N\u001a\u00020\u0001\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010RJ\n\u0010¨\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0010HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010À\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ý\u0001\u001a\u00020\u0010HÆ\u0003J\n\u0010Þ\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010á\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010â\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ã\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ä\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010å\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010æ\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ç\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010è\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010é\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ê\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ë\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ì\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010í\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010î\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ï\u0001\u001a\u00020\u0001HÆ\u0003J\u0012\u0010ð\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010ò\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0003\u0010\u0001J\n\u0010ó\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ô\u0001\u001a\u00020\u0005HÆ\u0003J\u0006\u0010õ\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00012\b\b\u0002\u00101\u001a\u00020\u001e2\b\b\u0002\u00102\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u00020\u00012\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u001e2\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00012\b\b\u0002\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u00020\u00102\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00012\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\u00012\b\b\u0002\u0010D\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020\u00012\b\b\u0002\u0010F\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u00012\b\b\u0002\u0010H\u001a\u00020\u00052\b\b\u0002\u0010I\u001a\u00020\u00012\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020\u00012\b\b\u0002\u0010N\u001a\u00020\u00012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0003\u0010ö\u0001J\u0015\u0010÷\u0001\u001a\u00020\u00102\t\u0010ø\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010ù\u0001\u001a\u00020\u001eHÖ\u0001J\n\u0010ú\u0001\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bU\u0010TR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bX\u0010TR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010WR\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010TR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010WR\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010TR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u0010WR\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b^\u0010TR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010WR\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b`\u0010TR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0011\u0010\u0011\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bc\u0010TR\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bd\u0010TR\u0011\u0010\u0013\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\be\u0010TR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bf\u0010WR\u0011\u0010\u0015\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bg\u0010TR\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bh\u0010TR\u0011\u0010\u0017\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bi\u0010TR\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bj\u0010TR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010WR\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bl\u0010TR\u0011\u0010\u001b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bm\u0010TR\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bn\u0010TR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0011\u0010\u001f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bq\u0010TR\u0011\u0010 \u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\br\u0010TR\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bs\u0010WR\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bt\u0010WR\u0011\u0010#\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bu\u0010WR\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bv\u0010WR\u0011\u0010%\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bw\u0010WR\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bx\u0010WR\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\by\u0010WR\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bz\u0010WR\u0011\u0010)\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b{\u0010TR\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b|\u0010WR\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b}\u0010WR\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b~\u0010WR\u0011\u0010-\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u0010pR\u0012\u0010.\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010/\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u00100\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u00101\u001a\u00020\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010pR\u0012\u00102\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u00103\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u00104\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u00105\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u00106\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u00107\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u00108\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u00109\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010:\u001a\u00020\u001e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010pR\u0012\u0010;\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR#\u0010Q\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0015\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0012\u0010<\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u0010=\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010>\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010bR\u0012\u0010?\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010@\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u0010A\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010B\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010C\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u0010D\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010E\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u0010F\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010G\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u0012\u0010H\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010WR\u0012\u0010I\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010TR\u0012\u0010J\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b¡\u0001\u0010WR\"\u0010O\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0014\n\u0003\u0010\u0001\u001a\u0005\bO\u0010\u0001\"\u0006\b¢\u0001\u0010\u0001R\"\u0010P\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0014\n\u0003\u0010\u0001\u001a\u0005\bP\u0010\u0001\"\u0006\b£\u0001\u0010\u0001R\u0012\u0010K\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010TR\u0012\u0010L\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010WR\u0012\u0010M\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010TR\u0012\u0010N\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b§\u0001\u0010T¨\u0006ü\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "", "ACVRange", "AirBag", "AucLiveDateInUserTimeZone", "", "AuctionId", "AuctionTime", "AuctionTypeId", "BidLive", "BranchInternetLiveAuction", "BranchName", "BranchPublicAuction", "Branchnumber", "BuyerFeeLevel", "CATInd", "", "Closed", "CountryOfOrigin", "Cylinders", "Damage", "ExteriorColor", "FuelType", "IBNClosedatetime", "IBNExpired", "IBNSold", "IBuyFast", "ImageUrl", "InteriorColor", "ItemId", "", "ItemInternetLiveAuction", "Key", "LaneAndItemNumber", "LiveDate", "LossType", "Make", "Model", "Odobrand", "Odometer", "OdometerRange", "OdometerStatus", "OffsiteSaleIndicator", "PrebidType", "PublicVehicle", "RowNumber", "RunAndDrive", "SaleDocument", "SalesListURL", "SalvageId", "SecondaryDamage", "Seller", "Series", "Slot", "SlotOrder", "StartCode", "State", "StockAvailable", "StockNumber", "StorageLocationName", "TimeZone", "TimedAuctionCloseTimeCST", "TimedAuctionInd", "Transmission", "UserTimeZoneAbb", "UserTimeinUserTZ", "VIN", "VehStatus", "VehicleStarts", "VehicleSubType", "VehicleTitle", "VehicleType", "Year", "YearRange", "closedatetime", "itempublicauction", "livedatetime", "timedAuctionDateTime", "vehicleTypeId", "isWatchable", "isWatching", "TBOIndicator", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getACVRange", "()Ljava/lang/Object;", "getAirBag", "getAucLiveDateInUserTimeZone", "()Ljava/lang/String;", "getAuctionId", "getAuctionTime", "getAuctionTypeId", "getBidLive", "getBranchInternetLiveAuction", "getBranchName", "getBranchPublicAuction", "getBranchnumber", "getBuyerFeeLevel", "getCATInd", "()Z", "getClosed", "getCountryOfOrigin", "getCylinders", "getDamage", "getExteriorColor", "getFuelType", "getIBNClosedatetime", "getIBNExpired", "getIBNSold", "getIBuyFast", "getImageUrl", "getInteriorColor", "getItemId", "()I", "getItemInternetLiveAuction", "getKey", "getLaneAndItemNumber", "getLiveDate", "getLossType", "getMake", "getModel", "getOdobrand", "getOdometer", "getOdometerRange", "getOdometerStatus", "getOffsiteSaleIndicator", "getPrebidType", "getPublicVehicle", "getRowNumber", "getRunAndDrive", "getSaleDocument", "getSalesListURL", "getSalvageId", "getSecondaryDamage", "getSeller", "getSeries", "getSlot", "getSlotOrder", "getStartCode", "getState", "getStockAvailable", "getStockNumber", "getStorageLocationName", "getTBOIndicator", "()Ljava/lang/Boolean;", "setTBOIndicator", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTimeZone", "getTimedAuctionCloseTimeCST", "getTimedAuctionInd", "getTransmission", "getUserTimeZoneAbb", "getUserTimeinUserTZ", "getVIN", "getVehStatus", "getVehicleStarts", "getVehicleSubType", "getVehicleTitle", "getVehicleType", "getYear", "getYearRange", "getClosedatetime", "setWatchable", "setWatching", "getItempublicauction", "getLivedatetime", "getTimedAuctionDateTime", "getVehicleTypeId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component8", "component9", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "equals", "other", "hashCode", "toString", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Vehicle.kt */
public final class Vehicle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<Vehicle> DIFF_CALLBACK = new Vehicle$Companion$DIFF_CALLBACK$1();
    @NotNull
    private final Object ACVRange;
    @NotNull
    private final Object AirBag;
    @NotNull
    private final String AucLiveDateInUserTimeZone;
    @NotNull
    private final Object AuctionId;
    @NotNull
    private final String AuctionTime;
    @NotNull
    private final Object AuctionTypeId;
    @NotNull
    private final String BidLive;
    @NotNull
    private final Object BranchInternetLiveAuction;
    @NotNull
    private final String BranchName;
    @NotNull
    private final Object BranchPublicAuction;
    @NotNull
    private final String Branchnumber;
    @NotNull
    private final Object BuyerFeeLevel;
    private final boolean CATInd;
    @NotNull
    private final Object Closed;
    @NotNull
    private final Object CountryOfOrigin;
    @NotNull
    private final Object Cylinders;
    @NotNull
    private final String Damage;
    @NotNull
    private final Object ExteriorColor;
    @NotNull
    private final Object FuelType;
    @NotNull
    private final Object IBNClosedatetime;
    @NotNull
    private final Object IBNExpired;
    @NotNull
    private final String IBNSold;
    @NotNull
    private final Object IBuyFast;
    @NotNull
    private final Object ImageUrl;
    @NotNull
    private final Object InteriorColor;
    private final int ItemId;
    @NotNull
    private final Object ItemInternetLiveAuction;
    @NotNull
    private final Object Key;
    @NotNull
    private final String LaneAndItemNumber;
    @NotNull
    private final String LiveDate;
    @NotNull
    private final String LossType;
    @NotNull
    private final String Make;
    @NotNull
    private final String Model;
    @NotNull
    private final String Odobrand;
    @NotNull
    private final String Odometer;
    @NotNull
    private final String OdometerRange;
    @NotNull
    private final Object OdometerStatus;
    @NotNull
    private final String OffsiteSaleIndicator;
    @NotNull
    private final String PrebidType;
    @NotNull
    private final String PublicVehicle;
    private final int RowNumber;
    @NotNull
    private final String RunAndDrive;
    @NotNull
    private final String SaleDocument;
    @NotNull
    private final Object SalesListURL;
    private final int SalvageId;
    @NotNull
    private final Object SecondaryDamage;
    @NotNull
    private final String Seller;
    @NotNull
    private final String Series;
    @NotNull
    private final Object Slot;
    @NotNull
    private final Object SlotOrder;
    @NotNull
    private final Object StartCode;
    @NotNull
    private final String State;
    @NotNull
    private final String StockAvailable;
    private final int StockNumber;
    @NotNull
    private final String StorageLocationName;
    @Nullable
    private Boolean TBOIndicator;
    @NotNull
    private final Object TimeZone;
    @NotNull
    private final String TimedAuctionCloseTimeCST;
    private final boolean TimedAuctionInd;
    @NotNull
    private final String Transmission;
    @NotNull
    private final Object UserTimeZoneAbb;
    @NotNull
    private final String UserTimeinUserTZ;
    @NotNull
    private final String VIN;
    @NotNull
    private final Object VehStatus;
    @NotNull
    private final String VehicleStarts;
    @NotNull
    private final Object VehicleSubType;
    @NotNull
    private final String VehicleTitle;
    @NotNull
    private final Object VehicleType;
    @NotNull
    private final String Year;
    @NotNull
    private final Object YearRange;
    @NotNull
    private final String closedatetime;
    @Nullable
    private Boolean isWatchable;
    @Nullable
    private Boolean isWatching;
    @NotNull
    private final Object itempublicauction;
    @NotNull
    private final String livedatetime;
    @NotNull
    private final Object timedAuctionDateTime;
    @NotNull
    private final Object vehicleTypeId;

    @NotNull
    public static /* synthetic */ Vehicle copy$default(Vehicle vehicle, Object obj, Object obj2, String str, Object obj3, String str2, Object obj4, String str3, Object obj5, String str4, Object obj6, String str5, Object obj7, boolean z, Object obj8, Object obj9, Object obj10, String str6, Object obj11, Object obj12, Object obj13, Object obj14, String str7, Object obj15, Object obj16, Object obj17, int i, Object obj18, Object obj19, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Object obj20, String str16, String str17, String str18, int i2, String str19, String str20, Object obj21, int i3, Object obj22, String str21, String str22, Object obj23, Object obj24, Object obj25, String str23, String str24, int i4, String str25, Object obj26, String str26, boolean z2, String str27, Object obj27, String str28, String str29, Object obj28, String str30, Object obj29, String str31, Object obj30, String str32, Object obj31, String str33, Object obj32, String str34, Object obj33, Object obj34, Boolean bool, Boolean bool2, Boolean bool3, int i5, int i6, int i7, Object obj35) {
        Object obj36;
        Object obj37;
        Object obj38;
        String str35;
        String str36;
        Object obj39;
        Object obj40;
        Object obj41;
        Object obj42;
        Object obj43;
        Object obj44;
        Object obj45;
        Object obj46;
        String str37;
        String str38;
        Object obj47;
        Object obj48;
        Object obj49;
        Object obj50;
        Object obj51;
        Object obj52;
        int i8;
        int i9;
        Object obj53;
        Object obj54;
        Object obj55;
        Object obj56;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        Object obj57;
        Object obj58;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        String str58;
        Object obj59;
        Object obj60;
        Object obj61;
        Object obj62;
        Object obj63;
        Object obj64;
        String str59;
        String str60;
        String str61;
        String str62;
        int i10;
        int i11;
        String str63;
        String str64;
        Object obj65;
        Object obj66;
        String str65;
        String str66;
        boolean z3;
        boolean z4;
        String str67;
        String str68;
        Object obj67;
        Object obj68;
        String str69;
        String str70;
        String str71;
        String str72;
        Object obj69;
        String str73;
        Object obj70;
        Object obj71;
        String str74;
        String str75;
        Object obj72;
        Object obj73;
        String str76;
        String str77;
        Object obj74;
        Object obj75;
        String str78;
        String str79;
        Object obj76;
        Vehicle vehicle2 = vehicle;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        Object obj77 = (i12 & 1) != 0 ? vehicle2.ACVRange : obj;
        Object obj78 = (i12 & 2) != 0 ? vehicle2.AirBag : obj2;
        String str80 = (i12 & 4) != 0 ? vehicle2.AucLiveDateInUserTimeZone : str;
        Object obj79 = (i12 & 8) != 0 ? vehicle2.AuctionId : obj3;
        String str81 = (i12 & 16) != 0 ? vehicle2.AuctionTime : str2;
        Object obj80 = (i12 & 32) != 0 ? vehicle2.AuctionTypeId : obj4;
        String str82 = (i12 & 64) != 0 ? vehicle2.BidLive : str3;
        Object obj81 = (i12 & 128) != 0 ? vehicle2.BranchInternetLiveAuction : obj5;
        String str83 = (i12 & 256) != 0 ? vehicle2.BranchName : str4;
        Object obj82 = (i12 & 512) != 0 ? vehicle2.BranchPublicAuction : obj6;
        String str84 = (i12 & 1024) != 0 ? vehicle2.Branchnumber : str5;
        Object obj83 = (i12 & 2048) != 0 ? vehicle2.BuyerFeeLevel : obj7;
        boolean z5 = (i12 & 4096) != 0 ? vehicle2.CATInd : z;
        Object obj84 = (i12 & 8192) != 0 ? vehicle2.Closed : obj8;
        Object obj85 = (i12 & 16384) != 0 ? vehicle2.CountryOfOrigin : obj9;
        if ((i12 & 32768) != 0) {
            obj36 = obj85;
            obj37 = vehicle2.Cylinders;
        } else {
            obj36 = obj85;
            obj37 = obj10;
        }
        if ((i12 & 65536) != 0) {
            obj38 = obj37;
            str35 = vehicle2.Damage;
        } else {
            obj38 = obj37;
            str35 = str6;
        }
        if ((i12 & 131072) != 0) {
            str36 = str35;
            obj39 = vehicle2.ExteriorColor;
        } else {
            str36 = str35;
            obj39 = obj11;
        }
        if ((i12 & 262144) != 0) {
            obj40 = obj39;
            obj41 = vehicle2.FuelType;
        } else {
            obj40 = obj39;
            obj41 = obj12;
        }
        if ((i12 & 524288) != 0) {
            obj42 = obj41;
            obj43 = vehicle2.IBNClosedatetime;
        } else {
            obj42 = obj41;
            obj43 = obj13;
        }
        if ((i12 & 1048576) != 0) {
            obj44 = obj43;
            obj45 = vehicle2.IBNExpired;
        } else {
            obj44 = obj43;
            obj45 = obj14;
        }
        if ((i12 & 2097152) != 0) {
            obj46 = obj45;
            str37 = vehicle2.IBNSold;
        } else {
            obj46 = obj45;
            str37 = str7;
        }
        if ((i12 & 4194304) != 0) {
            str38 = str37;
            obj47 = vehicle2.IBuyFast;
        } else {
            str38 = str37;
            obj47 = obj15;
        }
        if ((i12 & 8388608) != 0) {
            obj48 = obj47;
            obj49 = vehicle2.ImageUrl;
        } else {
            obj48 = obj47;
            obj49 = obj16;
        }
        if ((i12 & 16777216) != 0) {
            obj50 = obj49;
            obj51 = vehicle2.InteriorColor;
        } else {
            obj50 = obj49;
            obj51 = obj17;
        }
        if ((i12 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            obj52 = obj51;
            i8 = vehicle2.ItemId;
        } else {
            obj52 = obj51;
            i8 = i;
        }
        if ((i12 & 67108864) != 0) {
            i9 = i8;
            obj53 = vehicle2.ItemInternetLiveAuction;
        } else {
            i9 = i8;
            obj53 = obj18;
        }
        if ((i12 & 134217728) != 0) {
            obj54 = obj53;
            obj55 = vehicle2.Key;
        } else {
            obj54 = obj53;
            obj55 = obj19;
        }
        if ((i12 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            obj56 = obj55;
            str39 = vehicle2.LaneAndItemNumber;
        } else {
            obj56 = obj55;
            str39 = str8;
        }
        if ((i12 & 536870912) != 0) {
            str40 = str39;
            str41 = vehicle2.LiveDate;
        } else {
            str40 = str39;
            str41 = str9;
        }
        if ((i12 & 1073741824) != 0) {
            str42 = str41;
            str43 = vehicle2.LossType;
        } else {
            str42 = str41;
            str43 = str10;
        }
        String str85 = (i12 & Integer.MIN_VALUE) != 0 ? vehicle2.Make : str11;
        if ((i13 & 1) != 0) {
            str44 = str85;
            str45 = vehicle2.Model;
        } else {
            str44 = str85;
            str45 = str12;
        }
        if ((i13 & 2) != 0) {
            str46 = str45;
            str47 = vehicle2.Odobrand;
        } else {
            str46 = str45;
            str47 = str13;
        }
        if ((i13 & 4) != 0) {
            str48 = str47;
            str49 = vehicle2.Odometer;
        } else {
            str48 = str47;
            str49 = str14;
        }
        if ((i13 & 8) != 0) {
            str50 = str49;
            str51 = vehicle2.OdometerRange;
        } else {
            str50 = str49;
            str51 = str15;
        }
        if ((i13 & 16) != 0) {
            str52 = str51;
            obj57 = vehicle2.OdometerStatus;
        } else {
            str52 = str51;
            obj57 = obj20;
        }
        if ((i13 & 32) != 0) {
            obj58 = obj57;
            str53 = vehicle2.OffsiteSaleIndicator;
        } else {
            obj58 = obj57;
            str53 = str16;
        }
        if ((i13 & 64) != 0) {
            str54 = str53;
            str55 = vehicle2.PrebidType;
        } else {
            str54 = str53;
            str55 = str17;
        }
        String str86 = str55;
        String str87 = (i13 & 128) != 0 ? vehicle2.PublicVehicle : str18;
        int i15 = (i13 & 256) != 0 ? vehicle2.RowNumber : i2;
        String str88 = (i13 & 512) != 0 ? vehicle2.RunAndDrive : str19;
        String str89 = (i13 & 1024) != 0 ? vehicle2.SaleDocument : str20;
        Object obj86 = (i13 & 2048) != 0 ? vehicle2.SalesListURL : obj21;
        int i16 = (i13 & 4096) != 0 ? vehicle2.SalvageId : i3;
        Object obj87 = (i13 & 8192) != 0 ? vehicle2.SecondaryDamage : obj22;
        String str90 = (i13 & 16384) != 0 ? vehicle2.Seller : str21;
        if ((i13 & 32768) != 0) {
            str56 = str90;
            str57 = vehicle2.Series;
        } else {
            str56 = str90;
            str57 = str22;
        }
        if ((i13 & 65536) != 0) {
            str58 = str57;
            obj59 = vehicle2.Slot;
        } else {
            str58 = str57;
            obj59 = obj23;
        }
        if ((i13 & 131072) != 0) {
            obj60 = obj59;
            obj61 = vehicle2.SlotOrder;
        } else {
            obj60 = obj59;
            obj61 = obj24;
        }
        if ((i13 & 262144) != 0) {
            obj62 = obj61;
            obj63 = vehicle2.StartCode;
        } else {
            obj62 = obj61;
            obj63 = obj25;
        }
        if ((i13 & 524288) != 0) {
            obj64 = obj63;
            str59 = vehicle2.State;
        } else {
            obj64 = obj63;
            str59 = str23;
        }
        if ((i13 & 1048576) != 0) {
            str60 = str59;
            str61 = vehicle2.StockAvailable;
        } else {
            str60 = str59;
            str61 = str24;
        }
        if ((i13 & 2097152) != 0) {
            str62 = str61;
            i10 = vehicle2.StockNumber;
        } else {
            str62 = str61;
            i10 = i4;
        }
        if ((i13 & 4194304) != 0) {
            i11 = i10;
            str63 = vehicle2.StorageLocationName;
        } else {
            i11 = i10;
            str63 = str25;
        }
        if ((i13 & 8388608) != 0) {
            str64 = str63;
            obj65 = vehicle2.TimeZone;
        } else {
            str64 = str63;
            obj65 = obj26;
        }
        if ((i13 & 16777216) != 0) {
            obj66 = obj65;
            str65 = vehicle2.TimedAuctionCloseTimeCST;
        } else {
            obj66 = obj65;
            str65 = str26;
        }
        if ((i13 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str66 = str65;
            z3 = vehicle2.TimedAuctionInd;
        } else {
            str66 = str65;
            z3 = z2;
        }
        if ((i13 & 67108864) != 0) {
            z4 = z3;
            str67 = vehicle2.Transmission;
        } else {
            z4 = z3;
            str67 = str27;
        }
        if ((i13 & 134217728) != 0) {
            str68 = str67;
            obj67 = vehicle2.UserTimeZoneAbb;
        } else {
            str68 = str67;
            obj67 = obj27;
        }
        if ((i13 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            obj68 = obj67;
            str69 = vehicle2.UserTimeinUserTZ;
        } else {
            obj68 = obj67;
            str69 = str28;
        }
        if ((i13 & 536870912) != 0) {
            str70 = str69;
            str71 = vehicle2.VIN;
        } else {
            str70 = str69;
            str71 = str29;
        }
        if ((i13 & 1073741824) != 0) {
            str72 = str71;
            obj69 = vehicle2.VehStatus;
        } else {
            str72 = str71;
            obj69 = obj28;
        }
        String str91 = (i13 & Integer.MIN_VALUE) != 0 ? vehicle2.VehicleStarts : str30;
        if ((i14 & 1) != 0) {
            str73 = str91;
            obj70 = vehicle2.VehicleSubType;
        } else {
            str73 = str91;
            obj70 = obj29;
        }
        if ((i14 & 2) != 0) {
            obj71 = obj70;
            str74 = vehicle2.VehicleTitle;
        } else {
            obj71 = obj70;
            str74 = str31;
        }
        if ((i14 & 4) != 0) {
            str75 = str74;
            obj72 = vehicle2.VehicleType;
        } else {
            str75 = str74;
            obj72 = obj30;
        }
        if ((i14 & 8) != 0) {
            obj73 = obj72;
            str76 = vehicle2.Year;
        } else {
            obj73 = obj72;
            str76 = str32;
        }
        if ((i14 & 16) != 0) {
            str77 = str76;
            obj74 = vehicle2.YearRange;
        } else {
            str77 = str76;
            obj74 = obj31;
        }
        if ((i14 & 32) != 0) {
            obj75 = obj74;
            str78 = vehicle2.closedatetime;
        } else {
            obj75 = obj74;
            str78 = str33;
        }
        if ((i14 & 64) != 0) {
            str79 = str78;
            obj76 = vehicle2.itempublicauction;
        } else {
            str79 = str78;
            obj76 = obj32;
        }
        return vehicle.copy(obj77, obj78, str80, obj79, str81, obj80, str82, obj81, str83, obj82, str84, obj83, z5, obj84, obj36, obj38, str36, obj40, obj42, obj44, obj46, str38, obj48, obj50, obj52, i9, obj54, obj56, str40, str42, str43, str44, str46, str48, str50, str52, obj58, str54, str86, str87, i15, str88, str89, obj86, i16, obj87, str56, str58, obj60, obj62, obj64, str60, str62, i11, str64, obj66, str66, z4, str68, obj68, str70, str72, obj69, str73, obj71, str75, obj73, str77, obj75, str79, obj76, (i14 & 128) != 0 ? vehicle2.livedatetime : str34, (i14 & 256) != 0 ? vehicle2.timedAuctionDateTime : obj33, (i14 & 512) != 0 ? vehicle2.vehicleTypeId : obj34, (i14 & 1024) != 0 ? vehicle2.isWatchable : bool, (i14 & 2048) != 0 ? vehicle2.isWatching : bool2, (i14 & 4096) != 0 ? vehicle2.TBOIndicator : bool3);
    }

    @NotNull
    public final Object component1() {
        return this.ACVRange;
    }

    @NotNull
    public final Object component10() {
        return this.BranchPublicAuction;
    }

    @NotNull
    public final String component11() {
        return this.Branchnumber;
    }

    @NotNull
    public final Object component12() {
        return this.BuyerFeeLevel;
    }

    public final boolean component13() {
        return this.CATInd;
    }

    @NotNull
    public final Object component14() {
        return this.Closed;
    }

    @NotNull
    public final Object component15() {
        return this.CountryOfOrigin;
    }

    @NotNull
    public final Object component16() {
        return this.Cylinders;
    }

    @NotNull
    public final String component17() {
        return this.Damage;
    }

    @NotNull
    public final Object component18() {
        return this.ExteriorColor;
    }

    @NotNull
    public final Object component19() {
        return this.FuelType;
    }

    @NotNull
    public final Object component2() {
        return this.AirBag;
    }

    @NotNull
    public final Object component20() {
        return this.IBNClosedatetime;
    }

    @NotNull
    public final Object component21() {
        return this.IBNExpired;
    }

    @NotNull
    public final String component22() {
        return this.IBNSold;
    }

    @NotNull
    public final Object component23() {
        return this.IBuyFast;
    }

    @NotNull
    public final Object component24() {
        return this.ImageUrl;
    }

    @NotNull
    public final Object component25() {
        return this.InteriorColor;
    }

    public final int component26() {
        return this.ItemId;
    }

    @NotNull
    public final Object component27() {
        return this.ItemInternetLiveAuction;
    }

    @NotNull
    public final Object component28() {
        return this.Key;
    }

    @NotNull
    public final String component29() {
        return this.LaneAndItemNumber;
    }

    @NotNull
    public final String component3() {
        return this.AucLiveDateInUserTimeZone;
    }

    @NotNull
    public final String component30() {
        return this.LiveDate;
    }

    @NotNull
    public final String component31() {
        return this.LossType;
    }

    @NotNull
    public final String component32() {
        return this.Make;
    }

    @NotNull
    public final String component33() {
        return this.Model;
    }

    @NotNull
    public final String component34() {
        return this.Odobrand;
    }

    @NotNull
    public final String component35() {
        return this.Odometer;
    }

    @NotNull
    public final String component36() {
        return this.OdometerRange;
    }

    @NotNull
    public final Object component37() {
        return this.OdometerStatus;
    }

    @NotNull
    public final String component38() {
        return this.OffsiteSaleIndicator;
    }

    @NotNull
    public final String component39() {
        return this.PrebidType;
    }

    @NotNull
    public final Object component4() {
        return this.AuctionId;
    }

    @NotNull
    public final String component40() {
        return this.PublicVehicle;
    }

    public final int component41() {
        return this.RowNumber;
    }

    @NotNull
    public final String component42() {
        return this.RunAndDrive;
    }

    @NotNull
    public final String component43() {
        return this.SaleDocument;
    }

    @NotNull
    public final Object component44() {
        return this.SalesListURL;
    }

    public final int component45() {
        return this.SalvageId;
    }

    @NotNull
    public final Object component46() {
        return this.SecondaryDamage;
    }

    @NotNull
    public final String component47() {
        return this.Seller;
    }

    @NotNull
    public final String component48() {
        return this.Series;
    }

    @NotNull
    public final Object component49() {
        return this.Slot;
    }

    @NotNull
    public final String component5() {
        return this.AuctionTime;
    }

    @NotNull
    public final Object component50() {
        return this.SlotOrder;
    }

    @NotNull
    public final Object component51() {
        return this.StartCode;
    }

    @NotNull
    public final String component52() {
        return this.State;
    }

    @NotNull
    public final String component53() {
        return this.StockAvailable;
    }

    public final int component54() {
        return this.StockNumber;
    }

    @NotNull
    public final String component55() {
        return this.StorageLocationName;
    }

    @NotNull
    public final Object component56() {
        return this.TimeZone;
    }

    @NotNull
    public final String component57() {
        return this.TimedAuctionCloseTimeCST;
    }

    public final boolean component58() {
        return this.TimedAuctionInd;
    }

    @NotNull
    public final String component59() {
        return this.Transmission;
    }

    @NotNull
    public final Object component6() {
        return this.AuctionTypeId;
    }

    @NotNull
    public final Object component60() {
        return this.UserTimeZoneAbb;
    }

    @NotNull
    public final String component61() {
        return this.UserTimeinUserTZ;
    }

    @NotNull
    public final String component62() {
        return this.VIN;
    }

    @NotNull
    public final Object component63() {
        return this.VehStatus;
    }

    @NotNull
    public final String component64() {
        return this.VehicleStarts;
    }

    @NotNull
    public final Object component65() {
        return this.VehicleSubType;
    }

    @NotNull
    public final String component66() {
        return this.VehicleTitle;
    }

    @NotNull
    public final Object component67() {
        return this.VehicleType;
    }

    @NotNull
    public final String component68() {
        return this.Year;
    }

    @NotNull
    public final Object component69() {
        return this.YearRange;
    }

    @NotNull
    public final String component7() {
        return this.BidLive;
    }

    @NotNull
    public final String component70() {
        return this.closedatetime;
    }

    @NotNull
    public final Object component71() {
        return this.itempublicauction;
    }

    @NotNull
    public final String component72() {
        return this.livedatetime;
    }

    @NotNull
    public final Object component73() {
        return this.timedAuctionDateTime;
    }

    @NotNull
    public final Object component74() {
        return this.vehicleTypeId;
    }

    @Nullable
    public final Boolean component75() {
        return this.isWatchable;
    }

    @Nullable
    public final Boolean component76() {
        return this.isWatching;
    }

    @Nullable
    public final Boolean component77() {
        return this.TBOIndicator;
    }

    @NotNull
    public final Object component8() {
        return this.BranchInternetLiveAuction;
    }

    @NotNull
    public final String component9() {
        return this.BranchName;
    }

    @NotNull
    public final Vehicle copy(@NotNull Object obj, @NotNull Object obj2, @NotNull String str, @NotNull Object obj3, @NotNull String str2, @NotNull Object obj4, @NotNull String str3, @NotNull Object obj5, @NotNull String str4, @NotNull Object obj6, @NotNull String str5, @NotNull Object obj7, boolean z, @NotNull Object obj8, @NotNull Object obj9, @NotNull Object obj10, @NotNull String str6, @NotNull Object obj11, @NotNull Object obj12, @NotNull Object obj13, @NotNull Object obj14, @NotNull String str7, @NotNull Object obj15, @NotNull Object obj16, @NotNull Object obj17, int i, @NotNull Object obj18, @NotNull Object obj19, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull Object obj20, @NotNull String str16, @NotNull String str17, @NotNull String str18, int i2, @NotNull String str19, @NotNull String str20, @NotNull Object obj21, int i3, @NotNull Object obj22, @NotNull String str21, @NotNull String str22, @NotNull Object obj23, @NotNull Object obj24, @NotNull Object obj25, @NotNull String str23, @NotNull String str24, int i4, @NotNull String str25, @NotNull Object obj26, @NotNull String str26, boolean z2, @NotNull String str27, @NotNull Object obj27, @NotNull String str28, @NotNull String str29, @NotNull Object obj28, @NotNull String str30, @NotNull Object obj29, @NotNull String str31, @NotNull Object obj30, @NotNull String str32, @NotNull Object obj31, @NotNull String str33, @NotNull Object obj32, @NotNull String str34, @NotNull Object obj33, @NotNull Object obj34, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        Object obj35 = obj;
        Intrinsics.checkParameterIsNotNull(obj35, "ACVRange");
        Intrinsics.checkParameterIsNotNull(obj2, "AirBag");
        Intrinsics.checkParameterIsNotNull(str, "AucLiveDateInUserTimeZone");
        Intrinsics.checkParameterIsNotNull(obj3, "AuctionId");
        Intrinsics.checkParameterIsNotNull(str2, "AuctionTime");
        Intrinsics.checkParameterIsNotNull(obj4, "AuctionTypeId");
        Intrinsics.checkParameterIsNotNull(str3, "BidLive");
        Intrinsics.checkParameterIsNotNull(obj5, "BranchInternetLiveAuction");
        Intrinsics.checkParameterIsNotNull(str4, "BranchName");
        Intrinsics.checkParameterIsNotNull(obj6, "BranchPublicAuction");
        Intrinsics.checkParameterIsNotNull(str5, "Branchnumber");
        Intrinsics.checkParameterIsNotNull(obj7, "BuyerFeeLevel");
        Intrinsics.checkParameterIsNotNull(obj8, "Closed");
        Intrinsics.checkParameterIsNotNull(obj9, "CountryOfOrigin");
        Intrinsics.checkParameterIsNotNull(obj10, "Cylinders");
        Intrinsics.checkParameterIsNotNull(str6, "Damage");
        Intrinsics.checkParameterIsNotNull(obj11, "ExteriorColor");
        Intrinsics.checkParameterIsNotNull(obj12, "FuelType");
        Intrinsics.checkParameterIsNotNull(obj13, "IBNClosedatetime");
        Intrinsics.checkParameterIsNotNull(obj14, "IBNExpired");
        Intrinsics.checkParameterIsNotNull(str7, "IBNSold");
        Intrinsics.checkParameterIsNotNull(obj15, "IBuyFast");
        Intrinsics.checkParameterIsNotNull(obj16, "ImageUrl");
        Intrinsics.checkParameterIsNotNull(obj17, "InteriorColor");
        Intrinsics.checkParameterIsNotNull(obj18, "ItemInternetLiveAuction");
        Intrinsics.checkParameterIsNotNull(obj19, "Key");
        Intrinsics.checkParameterIsNotNull(str8, "LaneAndItemNumber");
        Intrinsics.checkParameterIsNotNull(str9, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str10, "LossType");
        Intrinsics.checkParameterIsNotNull(str11, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str12, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str13, "Odobrand");
        Intrinsics.checkParameterIsNotNull(str14, "Odometer");
        Intrinsics.checkParameterIsNotNull(str15, "OdometerRange");
        Intrinsics.checkParameterIsNotNull(obj20, "OdometerStatus");
        Intrinsics.checkParameterIsNotNull(str16, "OffsiteSaleIndicator");
        Intrinsics.checkParameterIsNotNull(str17, "PrebidType");
        Intrinsics.checkParameterIsNotNull(str18, "PublicVehicle");
        Intrinsics.checkParameterIsNotNull(str19, "RunAndDrive");
        Intrinsics.checkParameterIsNotNull(str20, "SaleDocument");
        Intrinsics.checkParameterIsNotNull(obj21, "SalesListURL");
        Intrinsics.checkParameterIsNotNull(obj22, "SecondaryDamage");
        Intrinsics.checkParameterIsNotNull(str21, "Seller");
        Intrinsics.checkParameterIsNotNull(str22, "Series");
        Intrinsics.checkParameterIsNotNull(obj23, "Slot");
        Intrinsics.checkParameterIsNotNull(obj24, "SlotOrder");
        Intrinsics.checkParameterIsNotNull(obj25, "StartCode");
        Intrinsics.checkParameterIsNotNull(str23, "State");
        Intrinsics.checkParameterIsNotNull(str24, "StockAvailable");
        Intrinsics.checkParameterIsNotNull(str25, "StorageLocationName");
        Intrinsics.checkParameterIsNotNull(obj26, "TimeZone");
        Intrinsics.checkParameterIsNotNull(str26, "TimedAuctionCloseTimeCST");
        Intrinsics.checkParameterIsNotNull(str27, "Transmission");
        Intrinsics.checkParameterIsNotNull(obj27, "UserTimeZoneAbb");
        Intrinsics.checkParameterIsNotNull(str28, "UserTimeinUserTZ");
        Intrinsics.checkParameterIsNotNull(str29, "VIN");
        Intrinsics.checkParameterIsNotNull(obj28, "VehStatus");
        Intrinsics.checkParameterIsNotNull(str30, "VehicleStarts");
        Intrinsics.checkParameterIsNotNull(obj29, "VehicleSubType");
        Intrinsics.checkParameterIsNotNull(str31, "VehicleTitle");
        Intrinsics.checkParameterIsNotNull(obj30, "VehicleType");
        Intrinsics.checkParameterIsNotNull(str32, "Year");
        Intrinsics.checkParameterIsNotNull(obj31, "YearRange");
        Intrinsics.checkParameterIsNotNull(str33, "closedatetime");
        Intrinsics.checkParameterIsNotNull(obj32, "itempublicauction");
        Intrinsics.checkParameterIsNotNull(str34, "livedatetime");
        Intrinsics.checkParameterIsNotNull(obj33, "timedAuctionDateTime");
        Intrinsics.checkParameterIsNotNull(obj34, "vehicleTypeId");
        return new Vehicle(obj35, obj2, str, obj3, str2, obj4, str3, obj5, str4, obj6, str5, obj7, z, obj8, obj9, obj10, str6, obj11, obj12, obj13, obj14, str7, obj15, obj16, obj17, i, obj18, obj19, str8, str9, str10, str11, str12, str13, str14, str15, obj20, str16, str17, str18, i2, str19, str20, obj21, i3, obj22, str21, str22, obj23, obj24, obj25, str23, str24, i4, str25, obj26, str26, z2, str27, obj27, str28, str29, obj28, str30, obj29, str31, obj30, str32, obj31, str33, obj32, str34, obj33, obj34, bool, bool2, bool3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) obj;
                if (Intrinsics.areEqual(this.ACVRange, vehicle.ACVRange) && Intrinsics.areEqual(this.AirBag, vehicle.AirBag) && Intrinsics.areEqual((Object) this.AucLiveDateInUserTimeZone, (Object) vehicle.AucLiveDateInUserTimeZone) && Intrinsics.areEqual(this.AuctionId, vehicle.AuctionId) && Intrinsics.areEqual((Object) this.AuctionTime, (Object) vehicle.AuctionTime) && Intrinsics.areEqual(this.AuctionTypeId, vehicle.AuctionTypeId) && Intrinsics.areEqual((Object) this.BidLive, (Object) vehicle.BidLive) && Intrinsics.areEqual(this.BranchInternetLiveAuction, vehicle.BranchInternetLiveAuction) && Intrinsics.areEqual((Object) this.BranchName, (Object) vehicle.BranchName) && Intrinsics.areEqual(this.BranchPublicAuction, vehicle.BranchPublicAuction) && Intrinsics.areEqual((Object) this.Branchnumber, (Object) vehicle.Branchnumber) && Intrinsics.areEqual(this.BuyerFeeLevel, vehicle.BuyerFeeLevel)) {
                    if ((this.CATInd == vehicle.CATInd) && Intrinsics.areEqual(this.Closed, vehicle.Closed) && Intrinsics.areEqual(this.CountryOfOrigin, vehicle.CountryOfOrigin) && Intrinsics.areEqual(this.Cylinders, vehicle.Cylinders) && Intrinsics.areEqual((Object) this.Damage, (Object) vehicle.Damage) && Intrinsics.areEqual(this.ExteriorColor, vehicle.ExteriorColor) && Intrinsics.areEqual(this.FuelType, vehicle.FuelType) && Intrinsics.areEqual(this.IBNClosedatetime, vehicle.IBNClosedatetime) && Intrinsics.areEqual(this.IBNExpired, vehicle.IBNExpired) && Intrinsics.areEqual((Object) this.IBNSold, (Object) vehicle.IBNSold) && Intrinsics.areEqual(this.IBuyFast, vehicle.IBuyFast) && Intrinsics.areEqual(this.ImageUrl, vehicle.ImageUrl) && Intrinsics.areEqual(this.InteriorColor, vehicle.InteriorColor)) {
                        if ((this.ItemId == vehicle.ItemId) && Intrinsics.areEqual(this.ItemInternetLiveAuction, vehicle.ItemInternetLiveAuction) && Intrinsics.areEqual(this.Key, vehicle.Key) && Intrinsics.areEqual((Object) this.LaneAndItemNumber, (Object) vehicle.LaneAndItemNumber) && Intrinsics.areEqual((Object) this.LiveDate, (Object) vehicle.LiveDate) && Intrinsics.areEqual((Object) this.LossType, (Object) vehicle.LossType) && Intrinsics.areEqual((Object) this.Make, (Object) vehicle.Make) && Intrinsics.areEqual((Object) this.Model, (Object) vehicle.Model) && Intrinsics.areEqual((Object) this.Odobrand, (Object) vehicle.Odobrand) && Intrinsics.areEqual((Object) this.Odometer, (Object) vehicle.Odometer) && Intrinsics.areEqual((Object) this.OdometerRange, (Object) vehicle.OdometerRange) && Intrinsics.areEqual(this.OdometerStatus, vehicle.OdometerStatus) && Intrinsics.areEqual((Object) this.OffsiteSaleIndicator, (Object) vehicle.OffsiteSaleIndicator) && Intrinsics.areEqual((Object) this.PrebidType, (Object) vehicle.PrebidType) && Intrinsics.areEqual((Object) this.PublicVehicle, (Object) vehicle.PublicVehicle)) {
                            if ((this.RowNumber == vehicle.RowNumber) && Intrinsics.areEqual((Object) this.RunAndDrive, (Object) vehicle.RunAndDrive) && Intrinsics.areEqual((Object) this.SaleDocument, (Object) vehicle.SaleDocument) && Intrinsics.areEqual(this.SalesListURL, vehicle.SalesListURL)) {
                                if ((this.SalvageId == vehicle.SalvageId) && Intrinsics.areEqual(this.SecondaryDamage, vehicle.SecondaryDamage) && Intrinsics.areEqual((Object) this.Seller, (Object) vehicle.Seller) && Intrinsics.areEqual((Object) this.Series, (Object) vehicle.Series) && Intrinsics.areEqual(this.Slot, vehicle.Slot) && Intrinsics.areEqual(this.SlotOrder, vehicle.SlotOrder) && Intrinsics.areEqual(this.StartCode, vehicle.StartCode) && Intrinsics.areEqual((Object) this.State, (Object) vehicle.State) && Intrinsics.areEqual((Object) this.StockAvailable, (Object) vehicle.StockAvailable)) {
                                    if ((this.StockNumber == vehicle.StockNumber) && Intrinsics.areEqual((Object) this.StorageLocationName, (Object) vehicle.StorageLocationName) && Intrinsics.areEqual(this.TimeZone, vehicle.TimeZone) && Intrinsics.areEqual((Object) this.TimedAuctionCloseTimeCST, (Object) vehicle.TimedAuctionCloseTimeCST)) {
                                        if (!(this.TimedAuctionInd == vehicle.TimedAuctionInd) || !Intrinsics.areEqual((Object) this.Transmission, (Object) vehicle.Transmission) || !Intrinsics.areEqual(this.UserTimeZoneAbb, vehicle.UserTimeZoneAbb) || !Intrinsics.areEqual((Object) this.UserTimeinUserTZ, (Object) vehicle.UserTimeinUserTZ) || !Intrinsics.areEqual((Object) this.VIN, (Object) vehicle.VIN) || !Intrinsics.areEqual(this.VehStatus, vehicle.VehStatus) || !Intrinsics.areEqual((Object) this.VehicleStarts, (Object) vehicle.VehicleStarts) || !Intrinsics.areEqual(this.VehicleSubType, vehicle.VehicleSubType) || !Intrinsics.areEqual((Object) this.VehicleTitle, (Object) vehicle.VehicleTitle) || !Intrinsics.areEqual(this.VehicleType, vehicle.VehicleType) || !Intrinsics.areEqual((Object) this.Year, (Object) vehicle.Year) || !Intrinsics.areEqual(this.YearRange, vehicle.YearRange) || !Intrinsics.areEqual((Object) this.closedatetime, (Object) vehicle.closedatetime) || !Intrinsics.areEqual(this.itempublicauction, vehicle.itempublicauction) || !Intrinsics.areEqual((Object) this.livedatetime, (Object) vehicle.livedatetime) || !Intrinsics.areEqual(this.timedAuctionDateTime, vehicle.timedAuctionDateTime) || !Intrinsics.areEqual(this.vehicleTypeId, vehicle.vehicleTypeId) || !Intrinsics.areEqual((Object) this.isWatchable, (Object) vehicle.isWatchable) || !Intrinsics.areEqual((Object) this.isWatching, (Object) vehicle.isWatching) || !Intrinsics.areEqual((Object) this.TBOIndicator, (Object) vehicle.TBOIndicator)) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.ACVRange;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.AirBag;
        int hashCode2 = (hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        String str = this.AucLiveDateInUserTimeZone;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Object obj3 = this.AuctionId;
        int hashCode4 = (hashCode3 + (obj3 != null ? obj3.hashCode() : 0)) * 31;
        String str2 = this.AuctionTime;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj4 = this.AuctionTypeId;
        int hashCode6 = (hashCode5 + (obj4 != null ? obj4.hashCode() : 0)) * 31;
        String str3 = this.BidLive;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Object obj5 = this.BranchInternetLiveAuction;
        int hashCode8 = (hashCode7 + (obj5 != null ? obj5.hashCode() : 0)) * 31;
        String str4 = this.BranchName;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Object obj6 = this.BranchPublicAuction;
        int hashCode10 = (hashCode9 + (obj6 != null ? obj6.hashCode() : 0)) * 31;
        String str5 = this.Branchnumber;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Object obj7 = this.BuyerFeeLevel;
        int hashCode12 = (hashCode11 + (obj7 != null ? obj7.hashCode() : 0)) * 31;
        boolean z = this.CATInd;
        if (z) {
            z = true;
        }
        int i2 = (hashCode12 + (z ? 1 : 0)) * 31;
        Object obj8 = this.Closed;
        int hashCode13 = (i2 + (obj8 != null ? obj8.hashCode() : 0)) * 31;
        Object obj9 = this.CountryOfOrigin;
        int hashCode14 = (hashCode13 + (obj9 != null ? obj9.hashCode() : 0)) * 31;
        Object obj10 = this.Cylinders;
        int hashCode15 = (hashCode14 + (obj10 != null ? obj10.hashCode() : 0)) * 31;
        String str6 = this.Damage;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Object obj11 = this.ExteriorColor;
        int hashCode17 = (hashCode16 + (obj11 != null ? obj11.hashCode() : 0)) * 31;
        Object obj12 = this.FuelType;
        int hashCode18 = (hashCode17 + (obj12 != null ? obj12.hashCode() : 0)) * 31;
        Object obj13 = this.IBNClosedatetime;
        int hashCode19 = (hashCode18 + (obj13 != null ? obj13.hashCode() : 0)) * 31;
        Object obj14 = this.IBNExpired;
        int hashCode20 = (hashCode19 + (obj14 != null ? obj14.hashCode() : 0)) * 31;
        String str7 = this.IBNSold;
        int hashCode21 = (hashCode20 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Object obj15 = this.IBuyFast;
        int hashCode22 = (hashCode21 + (obj15 != null ? obj15.hashCode() : 0)) * 31;
        Object obj16 = this.ImageUrl;
        int hashCode23 = (hashCode22 + (obj16 != null ? obj16.hashCode() : 0)) * 31;
        Object obj17 = this.InteriorColor;
        int hashCode24 = (((hashCode23 + (obj17 != null ? obj17.hashCode() : 0)) * 31) + Integer.valueOf(this.ItemId).hashCode()) * 31;
        Object obj18 = this.ItemInternetLiveAuction;
        int hashCode25 = (hashCode24 + (obj18 != null ? obj18.hashCode() : 0)) * 31;
        Object obj19 = this.Key;
        int hashCode26 = (hashCode25 + (obj19 != null ? obj19.hashCode() : 0)) * 31;
        String str8 = this.LaneAndItemNumber;
        int hashCode27 = (hashCode26 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.LiveDate;
        int hashCode28 = (hashCode27 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.LossType;
        int hashCode29 = (hashCode28 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.Make;
        int hashCode30 = (hashCode29 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.Model;
        int hashCode31 = (hashCode30 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.Odobrand;
        int hashCode32 = (hashCode31 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.Odometer;
        int hashCode33 = (hashCode32 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.OdometerRange;
        int hashCode34 = (hashCode33 + (str15 != null ? str15.hashCode() : 0)) * 31;
        Object obj20 = this.OdometerStatus;
        int hashCode35 = (hashCode34 + (obj20 != null ? obj20.hashCode() : 0)) * 31;
        String str16 = this.OffsiteSaleIndicator;
        int hashCode36 = (hashCode35 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.PrebidType;
        int hashCode37 = (hashCode36 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.PublicVehicle;
        int hashCode38 = (((hashCode37 + (str18 != null ? str18.hashCode() : 0)) * 31) + Integer.valueOf(this.RowNumber).hashCode()) * 31;
        String str19 = this.RunAndDrive;
        int hashCode39 = (hashCode38 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.SaleDocument;
        int hashCode40 = (hashCode39 + (str20 != null ? str20.hashCode() : 0)) * 31;
        Object obj21 = this.SalesListURL;
        int hashCode41 = (((hashCode40 + (obj21 != null ? obj21.hashCode() : 0)) * 31) + Integer.valueOf(this.SalvageId).hashCode()) * 31;
        Object obj22 = this.SecondaryDamage;
        int hashCode42 = (hashCode41 + (obj22 != null ? obj22.hashCode() : 0)) * 31;
        String str21 = this.Seller;
        int hashCode43 = (hashCode42 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.Series;
        int hashCode44 = (hashCode43 + (str22 != null ? str22.hashCode() : 0)) * 31;
        Object obj23 = this.Slot;
        int hashCode45 = (hashCode44 + (obj23 != null ? obj23.hashCode() : 0)) * 31;
        Object obj24 = this.SlotOrder;
        int hashCode46 = (hashCode45 + (obj24 != null ? obj24.hashCode() : 0)) * 31;
        Object obj25 = this.StartCode;
        int hashCode47 = (hashCode46 + (obj25 != null ? obj25.hashCode() : 0)) * 31;
        String str23 = this.State;
        int hashCode48 = (hashCode47 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.StockAvailable;
        int hashCode49 = (((hashCode48 + (str24 != null ? str24.hashCode() : 0)) * 31) + Integer.valueOf(this.StockNumber).hashCode()) * 31;
        String str25 = this.StorageLocationName;
        int hashCode50 = (hashCode49 + (str25 != null ? str25.hashCode() : 0)) * 31;
        Object obj26 = this.TimeZone;
        int hashCode51 = (hashCode50 + (obj26 != null ? obj26.hashCode() : 0)) * 31;
        String str26 = this.TimedAuctionCloseTimeCST;
        int hashCode52 = (hashCode51 + (str26 != null ? str26.hashCode() : 0)) * 31;
        boolean z2 = this.TimedAuctionInd;
        if (z2) {
            z2 = true;
        }
        int i3 = (hashCode52 + (z2 ? 1 : 0)) * 31;
        String str27 = this.Transmission;
        int hashCode53 = (i3 + (str27 != null ? str27.hashCode() : 0)) * 31;
        Object obj27 = this.UserTimeZoneAbb;
        int hashCode54 = (hashCode53 + (obj27 != null ? obj27.hashCode() : 0)) * 31;
        String str28 = this.UserTimeinUserTZ;
        int hashCode55 = (hashCode54 + (str28 != null ? str28.hashCode() : 0)) * 31;
        String str29 = this.VIN;
        int hashCode56 = (hashCode55 + (str29 != null ? str29.hashCode() : 0)) * 31;
        Object obj28 = this.VehStatus;
        int hashCode57 = (hashCode56 + (obj28 != null ? obj28.hashCode() : 0)) * 31;
        String str30 = this.VehicleStarts;
        int hashCode58 = (hashCode57 + (str30 != null ? str30.hashCode() : 0)) * 31;
        Object obj29 = this.VehicleSubType;
        int hashCode59 = (hashCode58 + (obj29 != null ? obj29.hashCode() : 0)) * 31;
        String str31 = this.VehicleTitle;
        int hashCode60 = (hashCode59 + (str31 != null ? str31.hashCode() : 0)) * 31;
        Object obj30 = this.VehicleType;
        int hashCode61 = (hashCode60 + (obj30 != null ? obj30.hashCode() : 0)) * 31;
        String str32 = this.Year;
        int hashCode62 = (hashCode61 + (str32 != null ? str32.hashCode() : 0)) * 31;
        Object obj31 = this.YearRange;
        int hashCode63 = (hashCode62 + (obj31 != null ? obj31.hashCode() : 0)) * 31;
        String str33 = this.closedatetime;
        int hashCode64 = (hashCode63 + (str33 != null ? str33.hashCode() : 0)) * 31;
        Object obj32 = this.itempublicauction;
        int hashCode65 = (hashCode64 + (obj32 != null ? obj32.hashCode() : 0)) * 31;
        String str34 = this.livedatetime;
        int hashCode66 = (hashCode65 + (str34 != null ? str34.hashCode() : 0)) * 31;
        Object obj33 = this.timedAuctionDateTime;
        int hashCode67 = (hashCode66 + (obj33 != null ? obj33.hashCode() : 0)) * 31;
        Object obj34 = this.vehicleTypeId;
        int hashCode68 = (hashCode67 + (obj34 != null ? obj34.hashCode() : 0)) * 31;
        Boolean bool = this.isWatchable;
        int hashCode69 = (hashCode68 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isWatching;
        int hashCode70 = (hashCode69 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.TBOIndicator;
        if (bool3 != null) {
            i = bool3.hashCode();
        }
        return hashCode70 + i;
    }

    @NotNull
    public String toString() {
        return "Vehicle(ACVRange=" + this.ACVRange + ", AirBag=" + this.AirBag + ", AucLiveDateInUserTimeZone=" + this.AucLiveDateInUserTimeZone + ", AuctionId=" + this.AuctionId + ", AuctionTime=" + this.AuctionTime + ", AuctionTypeId=" + this.AuctionTypeId + ", BidLive=" + this.BidLive + ", BranchInternetLiveAuction=" + this.BranchInternetLiveAuction + ", BranchName=" + this.BranchName + ", BranchPublicAuction=" + this.BranchPublicAuction + ", Branchnumber=" + this.Branchnumber + ", BuyerFeeLevel=" + this.BuyerFeeLevel + ", CATInd=" + this.CATInd + ", Closed=" + this.Closed + ", CountryOfOrigin=" + this.CountryOfOrigin + ", Cylinders=" + this.Cylinders + ", Damage=" + this.Damage + ", ExteriorColor=" + this.ExteriorColor + ", FuelType=" + this.FuelType + ", IBNClosedatetime=" + this.IBNClosedatetime + ", IBNExpired=" + this.IBNExpired + ", IBNSold=" + this.IBNSold + ", IBuyFast=" + this.IBuyFast + ", ImageUrl=" + this.ImageUrl + ", InteriorColor=" + this.InteriorColor + ", ItemId=" + this.ItemId + ", ItemInternetLiveAuction=" + this.ItemInternetLiveAuction + ", Key=" + this.Key + ", LaneAndItemNumber=" + this.LaneAndItemNumber + ", LiveDate=" + this.LiveDate + ", LossType=" + this.LossType + ", Make=" + this.Make + ", Model=" + this.Model + ", Odobrand=" + this.Odobrand + ", Odometer=" + this.Odometer + ", OdometerRange=" + this.OdometerRange + ", OdometerStatus=" + this.OdometerStatus + ", OffsiteSaleIndicator=" + this.OffsiteSaleIndicator + ", PrebidType=" + this.PrebidType + ", PublicVehicle=" + this.PublicVehicle + ", RowNumber=" + this.RowNumber + ", RunAndDrive=" + this.RunAndDrive + ", SaleDocument=" + this.SaleDocument + ", SalesListURL=" + this.SalesListURL + ", SalvageId=" + this.SalvageId + ", SecondaryDamage=" + this.SecondaryDamage + ", Seller=" + this.Seller + ", Series=" + this.Series + ", Slot=" + this.Slot + ", SlotOrder=" + this.SlotOrder + ", StartCode=" + this.StartCode + ", State=" + this.State + ", StockAvailable=" + this.StockAvailable + ", StockNumber=" + this.StockNumber + ", StorageLocationName=" + this.StorageLocationName + ", TimeZone=" + this.TimeZone + ", TimedAuctionCloseTimeCST=" + this.TimedAuctionCloseTimeCST + ", TimedAuctionInd=" + this.TimedAuctionInd + ", Transmission=" + this.Transmission + ", UserTimeZoneAbb=" + this.UserTimeZoneAbb + ", UserTimeinUserTZ=" + this.UserTimeinUserTZ + ", VIN=" + this.VIN + ", VehStatus=" + this.VehStatus + ", VehicleStarts=" + this.VehicleStarts + ", VehicleSubType=" + this.VehicleSubType + ", VehicleTitle=" + this.VehicleTitle + ", VehicleType=" + this.VehicleType + ", Year=" + this.Year + ", YearRange=" + this.YearRange + ", closedatetime=" + this.closedatetime + ", itempublicauction=" + this.itempublicauction + ", livedatetime=" + this.livedatetime + ", timedAuctionDateTime=" + this.timedAuctionDateTime + ", vehicleTypeId=" + this.vehicleTypeId + ", isWatchable=" + this.isWatchable + ", isWatching=" + this.isWatching + ", TBOIndicator=" + this.TBOIndicator + ")";
    }

    public Vehicle(@NotNull Object obj, @NotNull Object obj2, @NotNull String str, @NotNull Object obj3, @NotNull String str2, @NotNull Object obj4, @NotNull String str3, @NotNull Object obj5, @NotNull String str4, @NotNull Object obj6, @NotNull String str5, @NotNull Object obj7, boolean z, @NotNull Object obj8, @NotNull Object obj9, @NotNull Object obj10, @NotNull String str6, @NotNull Object obj11, @NotNull Object obj12, @NotNull Object obj13, @NotNull Object obj14, @NotNull String str7, @NotNull Object obj15, @NotNull Object obj16, @NotNull Object obj17, int i, @NotNull Object obj18, @NotNull Object obj19, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull Object obj20, @NotNull String str16, @NotNull String str17, @NotNull String str18, int i2, @NotNull String str19, @NotNull String str20, @NotNull Object obj21, int i3, @NotNull Object obj22, @NotNull String str21, @NotNull String str22, @NotNull Object obj23, @NotNull Object obj24, @NotNull Object obj25, @NotNull String str23, @NotNull String str24, int i4, @NotNull String str25, @NotNull Object obj26, @NotNull String str26, boolean z2, @NotNull String str27, @NotNull Object obj27, @NotNull String str28, @NotNull String str29, @NotNull Object obj28, @NotNull String str30, @NotNull Object obj29, @NotNull String str31, @NotNull Object obj30, @NotNull String str32, @NotNull Object obj31, @NotNull String str33, @NotNull Object obj32, @NotNull String str34, @NotNull Object obj33, @NotNull Object obj34, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        Object obj35 = obj;
        Object obj36 = obj2;
        String str35 = str;
        Object obj37 = obj3;
        String str36 = str2;
        Object obj38 = obj4;
        String str37 = str3;
        Object obj39 = obj5;
        String str38 = str4;
        Object obj40 = obj6;
        String str39 = str5;
        Object obj41 = obj7;
        Object obj42 = obj8;
        Object obj43 = obj9;
        String str40 = str6;
        Intrinsics.checkParameterIsNotNull(obj35, "ACVRange");
        Intrinsics.checkParameterIsNotNull(obj36, "AirBag");
        Intrinsics.checkParameterIsNotNull(str35, "AucLiveDateInUserTimeZone");
        Intrinsics.checkParameterIsNotNull(obj37, "AuctionId");
        Intrinsics.checkParameterIsNotNull(str36, "AuctionTime");
        Intrinsics.checkParameterIsNotNull(obj38, "AuctionTypeId");
        Intrinsics.checkParameterIsNotNull(str37, "BidLive");
        Intrinsics.checkParameterIsNotNull(obj39, "BranchInternetLiveAuction");
        Intrinsics.checkParameterIsNotNull(str38, "BranchName");
        Intrinsics.checkParameterIsNotNull(obj40, "BranchPublicAuction");
        Intrinsics.checkParameterIsNotNull(str39, "Branchnumber");
        Intrinsics.checkParameterIsNotNull(obj41, "BuyerFeeLevel");
        Intrinsics.checkParameterIsNotNull(obj42, "Closed");
        Intrinsics.checkParameterIsNotNull(obj43, "CountryOfOrigin");
        Intrinsics.checkParameterIsNotNull(obj10, "Cylinders");
        Intrinsics.checkParameterIsNotNull(str6, "Damage");
        Intrinsics.checkParameterIsNotNull(obj11, "ExteriorColor");
        Intrinsics.checkParameterIsNotNull(obj12, "FuelType");
        Intrinsics.checkParameterIsNotNull(obj13, "IBNClosedatetime");
        Intrinsics.checkParameterIsNotNull(obj14, "IBNExpired");
        Intrinsics.checkParameterIsNotNull(str7, "IBNSold");
        Intrinsics.checkParameterIsNotNull(obj15, "IBuyFast");
        Intrinsics.checkParameterIsNotNull(obj16, "ImageUrl");
        Intrinsics.checkParameterIsNotNull(obj17, "InteriorColor");
        Intrinsics.checkParameterIsNotNull(obj18, "ItemInternetLiveAuction");
        Intrinsics.checkParameterIsNotNull(obj19, "Key");
        Intrinsics.checkParameterIsNotNull(str8, "LaneAndItemNumber");
        Intrinsics.checkParameterIsNotNull(str9, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str10, "LossType");
        Intrinsics.checkParameterIsNotNull(str11, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str12, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str13, "Odobrand");
        Intrinsics.checkParameterIsNotNull(str14, "Odometer");
        Intrinsics.checkParameterIsNotNull(str15, "OdometerRange");
        Intrinsics.checkParameterIsNotNull(obj20, "OdometerStatus");
        Intrinsics.checkParameterIsNotNull(str16, "OffsiteSaleIndicator");
        Intrinsics.checkParameterIsNotNull(str17, "PrebidType");
        Intrinsics.checkParameterIsNotNull(str18, "PublicVehicle");
        Intrinsics.checkParameterIsNotNull(str19, "RunAndDrive");
        Intrinsics.checkParameterIsNotNull(str20, "SaleDocument");
        Intrinsics.checkParameterIsNotNull(obj21, "SalesListURL");
        Intrinsics.checkParameterIsNotNull(obj22, "SecondaryDamage");
        Intrinsics.checkParameterIsNotNull(str21, "Seller");
        Intrinsics.checkParameterIsNotNull(str22, "Series");
        Intrinsics.checkParameterIsNotNull(obj23, "Slot");
        Intrinsics.checkParameterIsNotNull(obj24, "SlotOrder");
        Intrinsics.checkParameterIsNotNull(obj25, "StartCode");
        Intrinsics.checkParameterIsNotNull(str23, "State");
        Intrinsics.checkParameterIsNotNull(str24, "StockAvailable");
        Intrinsics.checkParameterIsNotNull(str25, "StorageLocationName");
        Intrinsics.checkParameterIsNotNull(obj26, "TimeZone");
        Intrinsics.checkParameterIsNotNull(str26, "TimedAuctionCloseTimeCST");
        Intrinsics.checkParameterIsNotNull(str27, "Transmission");
        Intrinsics.checkParameterIsNotNull(obj27, "UserTimeZoneAbb");
        Intrinsics.checkParameterIsNotNull(str28, "UserTimeinUserTZ");
        Intrinsics.checkParameterIsNotNull(str29, "VIN");
        Intrinsics.checkParameterIsNotNull(obj28, "VehStatus");
        Intrinsics.checkParameterIsNotNull(str30, "VehicleStarts");
        Intrinsics.checkParameterIsNotNull(obj29, "VehicleSubType");
        Intrinsics.checkParameterIsNotNull(str31, "VehicleTitle");
        Intrinsics.checkParameterIsNotNull(obj30, "VehicleType");
        Intrinsics.checkParameterIsNotNull(str32, "Year");
        Intrinsics.checkParameterIsNotNull(obj31, "YearRange");
        Intrinsics.checkParameterIsNotNull(str33, "closedatetime");
        Intrinsics.checkParameterIsNotNull(obj32, "itempublicauction");
        Intrinsics.checkParameterIsNotNull(str34, "livedatetime");
        Intrinsics.checkParameterIsNotNull(obj33, "timedAuctionDateTime");
        Intrinsics.checkParameterIsNotNull(obj34, "vehicleTypeId");
        this.ACVRange = obj35;
        this.AirBag = obj36;
        this.AucLiveDateInUserTimeZone = str35;
        this.AuctionId = obj37;
        this.AuctionTime = str36;
        this.AuctionTypeId = obj38;
        this.BidLive = str37;
        this.BranchInternetLiveAuction = obj39;
        this.BranchName = str38;
        this.BranchPublicAuction = obj40;
        this.Branchnumber = str39;
        this.BuyerFeeLevel = obj41;
        this.CATInd = z;
        this.Closed = obj42;
        this.CountryOfOrigin = obj43;
        this.Cylinders = obj10;
        this.Damage = str6;
        this.ExteriorColor = obj11;
        this.FuelType = obj12;
        this.IBNClosedatetime = obj13;
        this.IBNExpired = obj14;
        this.IBNSold = str7;
        this.IBuyFast = obj15;
        this.ImageUrl = obj16;
        this.InteriorColor = obj17;
        this.ItemId = i;
        this.ItemInternetLiveAuction = obj18;
        this.Key = obj19;
        this.LaneAndItemNumber = str8;
        this.LiveDate = str9;
        this.LossType = str10;
        this.Make = str11;
        this.Model = str12;
        this.Odobrand = str13;
        this.Odometer = str14;
        this.OdometerRange = str15;
        this.OdometerStatus = obj20;
        this.OffsiteSaleIndicator = str16;
        this.PrebidType = str17;
        this.PublicVehicle = str18;
        this.RowNumber = i2;
        this.RunAndDrive = str19;
        this.SaleDocument = str20;
        this.SalesListURL = obj21;
        this.SalvageId = i3;
        this.SecondaryDamage = obj22;
        this.Seller = str21;
        this.Series = str22;
        this.Slot = obj23;
        this.SlotOrder = obj24;
        this.StartCode = obj25;
        this.State = str23;
        this.StockAvailable = str24;
        this.StockNumber = i4;
        this.StorageLocationName = str25;
        this.TimeZone = obj26;
        this.TimedAuctionCloseTimeCST = str26;
        this.TimedAuctionInd = z2;
        this.Transmission = str27;
        this.UserTimeZoneAbb = obj27;
        this.UserTimeinUserTZ = str28;
        this.VIN = str29;
        this.VehStatus = obj28;
        this.VehicleStarts = str30;
        this.VehicleSubType = obj29;
        this.VehicleTitle = str31;
        this.VehicleType = obj30;
        this.Year = str32;
        this.YearRange = obj31;
        this.closedatetime = str33;
        this.itempublicauction = obj32;
        this.livedatetime = str34;
        this.timedAuctionDateTime = obj33;
        this.vehicleTypeId = obj34;
        this.isWatchable = bool;
        this.isWatching = bool2;
        this.TBOIndicator = bool3;
    }

    @NotNull
    public final Object getACVRange() {
        return this.ACVRange;
    }

    @NotNull
    public final Object getAirBag() {
        return this.AirBag;
    }

    @NotNull
    public final String getAucLiveDateInUserTimeZone() {
        return this.AucLiveDateInUserTimeZone;
    }

    @NotNull
    public final Object getAuctionId() {
        return this.AuctionId;
    }

    @NotNull
    public final String getAuctionTime() {
        return this.AuctionTime;
    }

    @NotNull
    public final Object getAuctionTypeId() {
        return this.AuctionTypeId;
    }

    @NotNull
    public final String getBidLive() {
        return this.BidLive;
    }

    @NotNull
    public final Object getBranchInternetLiveAuction() {
        return this.BranchInternetLiveAuction;
    }

    @NotNull
    public final String getBranchName() {
        return this.BranchName;
    }

    @NotNull
    public final Object getBranchPublicAuction() {
        return this.BranchPublicAuction;
    }

    @NotNull
    public final String getBranchnumber() {
        return this.Branchnumber;
    }

    @NotNull
    public final Object getBuyerFeeLevel() {
        return this.BuyerFeeLevel;
    }

    public final boolean getCATInd() {
        return this.CATInd;
    }

    @NotNull
    public final Object getClosed() {
        return this.Closed;
    }

    @NotNull
    public final Object getCountryOfOrigin() {
        return this.CountryOfOrigin;
    }

    @NotNull
    public final Object getCylinders() {
        return this.Cylinders;
    }

    @NotNull
    public final String getDamage() {
        return this.Damage;
    }

    @NotNull
    public final Object getExteriorColor() {
        return this.ExteriorColor;
    }

    @NotNull
    public final Object getFuelType() {
        return this.FuelType;
    }

    @NotNull
    public final Object getIBNClosedatetime() {
        return this.IBNClosedatetime;
    }

    @NotNull
    public final Object getIBNExpired() {
        return this.IBNExpired;
    }

    @NotNull
    public final String getIBNSold() {
        return this.IBNSold;
    }

    @NotNull
    public final Object getIBuyFast() {
        return this.IBuyFast;
    }

    @NotNull
    public final Object getImageUrl() {
        return this.ImageUrl;
    }

    @NotNull
    public final Object getInteriorColor() {
        return this.InteriorColor;
    }

    public final int getItemId() {
        return this.ItemId;
    }

    @NotNull
    public final Object getItemInternetLiveAuction() {
        return this.ItemInternetLiveAuction;
    }

    @NotNull
    public final Object getKey() {
        return this.Key;
    }

    @NotNull
    public final String getLaneAndItemNumber() {
        return this.LaneAndItemNumber;
    }

    @NotNull
    public final String getLiveDate() {
        return this.LiveDate;
    }

    @NotNull
    public final String getLossType() {
        return this.LossType;
    }

    @NotNull
    public final String getMake() {
        return this.Make;
    }

    @NotNull
    public final String getModel() {
        return this.Model;
    }

    @NotNull
    public final String getOdobrand() {
        return this.Odobrand;
    }

    @NotNull
    public final String getOdometer() {
        return this.Odometer;
    }

    @NotNull
    public final String getOdometerRange() {
        return this.OdometerRange;
    }

    @NotNull
    public final Object getOdometerStatus() {
        return this.OdometerStatus;
    }

    @NotNull
    public final String getOffsiteSaleIndicator() {
        return this.OffsiteSaleIndicator;
    }

    @NotNull
    public final String getPrebidType() {
        return this.PrebidType;
    }

    @NotNull
    public final String getPublicVehicle() {
        return this.PublicVehicle;
    }

    public final int getRowNumber() {
        return this.RowNumber;
    }

    @NotNull
    public final String getRunAndDrive() {
        return this.RunAndDrive;
    }

    @NotNull
    public final String getSaleDocument() {
        return this.SaleDocument;
    }

    @NotNull
    public final Object getSalesListURL() {
        return this.SalesListURL;
    }

    public final int getSalvageId() {
        return this.SalvageId;
    }

    @NotNull
    public final Object getSecondaryDamage() {
        return this.SecondaryDamage;
    }

    @NotNull
    public final String getSeller() {
        return this.Seller;
    }

    @NotNull
    public final String getSeries() {
        return this.Series;
    }

    @NotNull
    public final Object getSlot() {
        return this.Slot;
    }

    @NotNull
    public final Object getSlotOrder() {
        return this.SlotOrder;
    }

    @NotNull
    public final Object getStartCode() {
        return this.StartCode;
    }

    @NotNull
    public final String getState() {
        return this.State;
    }

    @NotNull
    public final String getStockAvailable() {
        return this.StockAvailable;
    }

    public final int getStockNumber() {
        return this.StockNumber;
    }

    @NotNull
    public final String getStorageLocationName() {
        return this.StorageLocationName;
    }

    @NotNull
    public final Object getTimeZone() {
        return this.TimeZone;
    }

    @NotNull
    public final String getTimedAuctionCloseTimeCST() {
        return this.TimedAuctionCloseTimeCST;
    }

    public final boolean getTimedAuctionInd() {
        return this.TimedAuctionInd;
    }

    @NotNull
    public final String getTransmission() {
        return this.Transmission;
    }

    @NotNull
    public final Object getUserTimeZoneAbb() {
        return this.UserTimeZoneAbb;
    }

    @NotNull
    public final String getUserTimeinUserTZ() {
        return this.UserTimeinUserTZ;
    }

    @NotNull
    public final String getVIN() {
        return this.VIN;
    }

    @NotNull
    public final Object getVehStatus() {
        return this.VehStatus;
    }

    @NotNull
    public final String getVehicleStarts() {
        return this.VehicleStarts;
    }

    @NotNull
    public final Object getVehicleSubType() {
        return this.VehicleSubType;
    }

    @NotNull
    public final String getVehicleTitle() {
        return this.VehicleTitle;
    }

    @NotNull
    public final Object getVehicleType() {
        return this.VehicleType;
    }

    @NotNull
    public final String getYear() {
        return this.Year;
    }

    @NotNull
    public final Object getYearRange() {
        return this.YearRange;
    }

    @NotNull
    public final String getClosedatetime() {
        return this.closedatetime;
    }

    @NotNull
    public final Object getItempublicauction() {
        return this.itempublicauction;
    }

    @NotNull
    public final String getLivedatetime() {
        return this.livedatetime;
    }

    @NotNull
    public final Object getTimedAuctionDateTime() {
        return this.timedAuctionDateTime;
    }

    @NotNull
    public final Object getVehicleTypeId() {
        return this.vehicleTypeId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Vehicle(java.lang.Object r82, java.lang.Object r83, java.lang.String r84, java.lang.Object r85, java.lang.String r86, java.lang.Object r87, java.lang.String r88, java.lang.Object r89, java.lang.String r90, java.lang.Object r91, java.lang.String r92, java.lang.Object r93, boolean r94, java.lang.Object r95, java.lang.Object r96, java.lang.Object r97, java.lang.String r98, java.lang.Object r99, java.lang.Object r100, java.lang.Object r101, java.lang.Object r102, java.lang.String r103, java.lang.Object r104, java.lang.Object r105, java.lang.Object r106, int r107, java.lang.Object r108, java.lang.Object r109, java.lang.String r110, java.lang.String r111, java.lang.String r112, java.lang.String r113, java.lang.String r114, java.lang.String r115, java.lang.String r116, java.lang.String r117, java.lang.Object r118, java.lang.String r119, java.lang.String r120, java.lang.String r121, int r122, java.lang.String r123, java.lang.String r124, java.lang.Object r125, int r126, java.lang.Object r127, java.lang.String r128, java.lang.String r129, java.lang.Object r130, java.lang.Object r131, java.lang.Object r132, java.lang.String r133, java.lang.String r134, int r135, java.lang.String r136, java.lang.Object r137, java.lang.String r138, boolean r139, java.lang.String r140, java.lang.Object r141, java.lang.String r142, java.lang.String r143, java.lang.Object r144, java.lang.String r145, java.lang.Object r146, java.lang.String r147, java.lang.Object r148, java.lang.String r149, java.lang.Object r150, java.lang.String r151, java.lang.Object r152, java.lang.String r153, java.lang.Object r154, java.lang.Object r155, java.lang.Boolean r156, java.lang.Boolean r157, java.lang.Boolean r158, int r159, int r160, int r161, kotlin.jvm.internal.DefaultConstructorMarker r162) {
        /*
            r81 = this;
            r0 = r161
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r78 = r1
            goto L_0x000f
        L_0x000d:
            r78 = r156
        L_0x000f:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0019
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r79 = r1
            goto L_0x001b
        L_0x0019:
            r79 = r157
        L_0x001b:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0025
            r0 = r2
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r80 = r0
            goto L_0x0027
        L_0x0025:
            r80 = r158
        L_0x0027:
            r3 = r81
            r4 = r82
            r5 = r83
            r6 = r84
            r7 = r85
            r8 = r86
            r9 = r87
            r10 = r88
            r11 = r89
            r12 = r90
            r13 = r91
            r14 = r92
            r15 = r93
            r16 = r94
            r17 = r95
            r18 = r96
            r19 = r97
            r20 = r98
            r21 = r99
            r22 = r100
            r23 = r101
            r24 = r102
            r25 = r103
            r26 = r104
            r27 = r105
            r28 = r106
            r29 = r107
            r30 = r108
            r31 = r109
            r32 = r110
            r33 = r111
            r34 = r112
            r35 = r113
            r36 = r114
            r37 = r115
            r38 = r116
            r39 = r117
            r40 = r118
            r41 = r119
            r42 = r120
            r43 = r121
            r44 = r122
            r45 = r123
            r46 = r124
            r47 = r125
            r48 = r126
            r49 = r127
            r50 = r128
            r51 = r129
            r52 = r130
            r53 = r131
            r54 = r132
            r55 = r133
            r56 = r134
            r57 = r135
            r58 = r136
            r59 = r137
            r60 = r138
            r61 = r139
            r62 = r140
            r63 = r141
            r64 = r142
            r65 = r143
            r66 = r144
            r67 = r145
            r68 = r146
            r69 = r147
            r70 = r148
            r71 = r149
            r72 = r150
            r73 = r151
            r74 = r152
            r75 = r153
            r76 = r154
            r77 = r155
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.model.fastSearch.Vehicle.<init>(java.lang.Object, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, boolean, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, int, java.lang.Object, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.Object, int, java.lang.Object, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.String, java.lang.String, int, java.lang.String, java.lang.Object, java.lang.String, boolean, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Nullable
    public final Boolean isWatchable() {
        return this.isWatchable;
    }

    public final void setWatchable(@Nullable Boolean bool) {
        this.isWatchable = bool;
    }

    @Nullable
    public final Boolean isWatching() {
        return this.isWatching;
    }

    public final void setWatching(@Nullable Boolean bool) {
        this.isWatching = bool;
    }

    @Nullable
    public final Boolean getTBOIndicator() {
        return this.TBOIndicator;
    }

    public final void setTBOIndicator(@Nullable Boolean bool) {
        this.TBOIndicator = bool;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/Vehicle$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDIFF_CALLBACK", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: Vehicle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<Vehicle> getDIFF_CALLBACK() {
            return Vehicle.DIFF_CALLBACK;
        }

        public final void setDIFF_CALLBACK(@NotNull DiffUtil.ItemCallback<Vehicle> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            Vehicle.DIFF_CALLBACK = itemCallback;
        }
    }
}
