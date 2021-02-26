package com.iaai.android.bdt.model.fastSearchFilter2;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b<\n\u0002\u0010\u0006\n\u0003\bÙ\u0001\b\b\u0018\u0000 ¢\u00022\u00020\u0001:\u0002¢\u0002B\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010/\u001a\u0004\u0018\u00010\r\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\r\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010=\u001a\u00020\u0003\u0012\u0006\u0010>\u001a\u00020\u0003\u0012\b\u0010?\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010@\u001a\u00020\u0003\u0012\u0006\u0010A\u001a\u00020\u0003\u0012\u0006\u0010B\u001a\u00020\u0003\u0012\b\u0010C\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\r\u0012\b\u0010F\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010G\u001a\u00020\u0003\u0012\u0006\u0010H\u001a\u00020\u0003\u0012\b\u0010I\u001a\u0004\u0018\u00010J\u0012\u0006\u0010K\u001a\u00020\u0003\u0012\u0006\u0010L\u001a\u00020\u0003\u0012\u0006\u0010M\u001a\u00020\u0003\u0012\b\u0010N\u001a\u0004\u0018\u00010\r\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010P\u001a\u00020\u0005\u0012\b\u0010Q\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\b\u0010S\u001a\u0004\u0018\u00010J\u0012\u0006\u0010T\u001a\u00020\u0003\u0012\u0006\u0010U\u001a\u00020\u0003\u0012\b\u0010V\u001a\u0004\u0018\u00010\r\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010X\u001a\u00020\u0003\u0012\u0006\u0010Y\u001a\u00020\u0003\u0012\b\u0010Z\u001a\u0004\u0018\u00010\r\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010]\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010^\u001a\u00020\u0005\u0012\b\u0010_\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010`J\n\u0010Â\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010Ä\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\n\u0010Ó\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ý\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Þ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010á\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010â\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010ã\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\n\u0010ä\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010å\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010æ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\u0011\u0010ç\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010è\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010é\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ê\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ë\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010í\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010î\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ï\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ð\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ñ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ò\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ó\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ô\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010õ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ö\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010÷\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010ø\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010ù\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ú\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010û\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ü\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010ý\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010þ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ÿ\u0001\u001a\u00020\rHÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0002\u001a\u0004\u0018\u00010JHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\n\u0010\u0002\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0002\u001a\u0004\u0018\u00010JHÆ\u0003¢\u0006\u0003\u0010\u0001J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0002\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010nJ\n\u0010\u0002\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÂ\u0007\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\r2\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\r2\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\u00032\b\b\u0002\u0010=\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00032\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020\r2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010G\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00032\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020\u00032\b\b\u0002\u0010M\u001a\u00020\u00032\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010R\u001a\u00020\u00032\n\b\u0002\u0010S\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010T\u001a\u00020\u00032\b\b\u0002\u0010U\u001a\u00020\u00032\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010X\u001a\u00020\u00032\b\b\u0002\u0010Y\u001a\u00020\u00032\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010^\u001a\u00020\u00052\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0002J\u0015\u0010\u0002\u001a\u00020\u00052\t\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010 \u0002\u001a\u00020\rHÖ\u0001J\n\u0010¡\u0002\u001a\u00020\u0003HÖ\u0001R\u0015\u0010/\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010c\u001a\u0004\ba\u0010bR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010eR\u0011\u0010@\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010eR\u0011\u00105\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bh\u0010eR\u0011\u00101\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bi\u0010eR\u0011\u0010U\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010eR\u0011\u0010<\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010eR\u0015\u00104\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010c\u001a\u0004\bl\u0010bR\u0015\u0010\\\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010o\u001a\u0004\bm\u0010nR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010eR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010eR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010o\u001a\u0004\br\u0010nR\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bs\u0010eR\u0013\u0010W\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bt\u0010eR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bu\u0010eR\u0011\u0010G\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bv\u0010eR\u0015\u0010]\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010o\u001a\u0004\bw\u0010nR\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010eR\u0011\u0010R\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bz\u0010eR\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010eR\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b|\u0010eR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010eR\u0011\u00102\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b~\u0010eR\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010eR\u0013\u0010E\u001a\u00020\r¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0012\u0010\u0002\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010\u0012\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010D\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0016\u0010C\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u0016\u0010V\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u0012\u0010>\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0016\u0010[\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010o\u001a\u0005\b\u0001\u0010nR\u0012\u0010\u0017\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010\"\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u0018\u0010I\u001a\u0004\u0018\u00010J¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0012\u0010Y\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010X\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0016\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u0018\u0010S\u001a\u0004\u0018\u00010J¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0012\u00106\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010=\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010$\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010#\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010;\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u00108\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u00109\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0016\u0010O\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010o\u001a\u0005\b\u0001\u0010nR\u0012\u0010\u001e\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010\u001b\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0012\u0010\b\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0013\u0010^\u001a\u00020\u0005¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0012\u0010)\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010eR\u0013\u0010P\u001a\u00020\u0005¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010\u0001R\u0012\u00103\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010eR\u0012\u0010(\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b£\u0001\u0010eR\u0012\u0010!\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010eR\u0016\u0010Q\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b¥\u0001\u0010bR\u0012\u0010\u0019\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010eR\u0012\u0010T\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b§\u0001\u0010eR\u0012\u0010\u001d\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¨\u0001\u0010eR\u0012\u0010\t\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010eR\u0012\u0010\u0016\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010eR\u0012\u0010\u001f\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b«\u0001\u0010eR\u0012\u0010A\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010eR\u0012\u0010'\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b­\u0001\u0010eR\u0016\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b®\u0001\u0010bR\u0012\u0010&\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¯\u0001\u0010eR\u0016\u0010.\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010o\u001a\u0005\b°\u0001\u0010nR\u0016\u0010Z\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b±\u0001\u0010bR\u0012\u0010B\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010eR\u0012\u0010H\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b³\u0001\u0010eR\u0012\u0010\u0010\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b´\u0001\u0010eR\u0014\u0010_\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\bµ\u0001\u0010eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010o\u001a\u0005\b¶\u0001\u0010nR\u0012\u0010:\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b·\u0001\u0010eR\u0012\u0010-\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¸\u0001\u0010eR\u0012\u0010K\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010eR\u0012\u00107\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\bº\u0001\u0010eR\u0012\u00100\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b»\u0001\u0010eR\u0012\u0010\u0015\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¼\u0001\u0010eR\u0012\u0010L\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b½\u0001\u0010eR\u0012\u0010M\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b¾\u0001\u0010eR\u0016\u0010F\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b¿\u0001\u0010bR\u0016\u0010?\u001a\u0004\u0018\u00010\r¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\bÀ\u0001\u0010bR\u0012\u0010\u0004\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0004\u0010\u0001R\u0012\u0010\u0006\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0006\u0010\u0001R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010o\u001a\u0005\bÁ\u0001\u0010n¨\u0006£\u0002"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "", "ImageUrl", "", "isWatchable", "", "isWatching", "TimedAuctionIndicator", "Promotions", "Series", "valVehicle", "DriveLineTypeDesc", "LongValue", "", "LatValue", "BuyNowCloseDatetime", "TimedAuctionCloseDateTime", "BuyNowIndicator", "InteriorColor", "ExteriorColor", "AdminBranch", "VehicleState", "StartDesc", "Key", "Airbag", "SecondaryDamage", "CountryOfOrigin", "PrimaryDamage", "CatIndicator", "SellerType", "PrebidType", "StockAvailable", "IBNSold", "SalesListURL", "LaneAndItemNumber", "MaskedVIN", "MaskedSeller", "Distance", "StorageLocationName", "StorageLocation", "SaleDocumentBrand", "RestraintSystem", "EngineSize", "Engine", "CheckDigit", "TitleState", "TBOIndicator", "ACV", "VehicleClass", "BidLive", "FuelType", "SaleDocument", "BranchNumber", "Availability", "LossType", "VIN", "OdoBrand", "Odometer", "Title", "Model", "BranchName", "Make", "ItemNumber", "Year", "AuctionLane", "Stockno", "Tenant", "ItemId", "InventoryID", "Id", "VehicleTypeId", "Cylinders", "TimeZone", "Latitude", "", "Transmission", "VehicleSubtype", "VehicleType", "StorageLocationId", "OffSiteSaleIndicator", "RunAndDrive", "SalvageId", "DriveLineType", "Longitude", "SellerName", "BodyStyleName", "ItemImageId", "CloseDateTime", "LiveDateTime", "LiveDate", "TZAdjust", "ItemvalAuction", "BranchvalAuction", "DisplaySeller", "PublicVehicle", "TimedAuctionCloseTimeCST", "(Ljava/lang/String;ZZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/String;)V", "getACV", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdminBranch", "()Ljava/lang/String;", "getAirbag", "getAuctionLane", "getAvailability", "getBidLive", "getBodyStyleName", "getBranchName", "getBranchNumber", "getBranchvalAuction", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBuyNowCloseDatetime", "getBuyNowIndicator", "getCatIndicator", "getCheckDigit", "getCloseDateTime", "getCountryOfOrigin", "getCylinders", "getDisplaySeller", "getDistance", "getDriveLineType", "getDriveLineTypeDesc", "getEngine", "getEngineSize", "getExteriorColor", "getFuelType", "getIBNSold", "getId", "()I", "getImageUrl", "getInteriorColor", "getInventoryID", "getItemId", "getItemImageId", "getItemNumber", "getItemvalAuction", "getKey", "getLaneAndItemNumber", "getLatValue", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLiveDate", "getLiveDateTime", "getLongValue", "getLongitude", "getLossType", "getMake", "getMaskedSeller", "getMaskedVIN", "getModel", "getOdoBrand", "getOdometer", "getOffSiteSaleIndicator", "getPrebidType", "getPrimaryDamage", "getPromotions", "getPublicVehicle", "()Z", "getRestraintSystem", "getRunAndDrive", "getSaleDocument", "getSaleDocumentBrand", "getSalesListURL", "getSalvageId", "getSecondaryDamage", "getSellerName", "getSellerType", "getSeries", "getStartDesc", "getStockAvailable", "getStockno", "getStorageLocation", "getStorageLocationId", "getStorageLocationName", "getTBOIndicator", "getTZAdjust", "getTenant", "getTimeZone", "getTimedAuctionCloseDateTime", "getTimedAuctionCloseTimeCST", "getTimedAuctionIndicator", "getTitle", "getTitleState", "getTransmission", "getVIN", "getVehicleClass", "getVehicleState", "getVehicleSubtype", "getVehicleType", "getVehicleTypeId", "getYear", "getValVehicle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component8", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component9", "component90", "copy", "(Ljava/lang/String;ZZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/String;)Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "equals", "other", "hashCode", "toString", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FormattedResult.kt */
public final class FormattedResult {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<FormattedResult> DIFF_CALLBACK = new FormattedResult$Companion$DIFF_CALLBACK$1();
    @Nullable
    private final Integer ACV;
    @NotNull
    private final String AdminBranch;
    @NotNull
    private final String Airbag;
    @NotNull
    private final String AuctionLane;
    @NotNull
    private final String Availability;
    @NotNull
    private final String BidLive;
    @NotNull
    private final String BodyStyleName;
    @NotNull
    private final String BranchName;
    @Nullable
    private final Integer BranchNumber;
    @Nullable
    private final Boolean BranchvalAuction;
    @NotNull
    private final String BuyNowCloseDatetime;
    @NotNull
    private final String BuyNowIndicator;
    @Nullable
    private final Boolean CatIndicator;
    @NotNull
    private final String CheckDigit;
    @Nullable
    private final String CloseDateTime;
    @NotNull
    private final String CountryOfOrigin;
    @NotNull
    private final String Cylinders;
    @Nullable
    private final Boolean DisplaySeller;
    @NotNull
    private final String Distance;
    @NotNull
    private final String DriveLineType;
    @NotNull
    private final String DriveLineTypeDesc;
    @NotNull
    private final String Engine;
    @NotNull
    private final String EngineSize;
    @NotNull
    private final String ExteriorColor;
    @NotNull
    private final String FuelType;
    @NotNull
    private final String IBNSold;

    /* renamed from: Id */
    private final int f504Id;
    @NotNull
    private final String ImageUrl;
    @NotNull
    private final String InteriorColor;
    @NotNull
    private final String InventoryID;
    @Nullable
    private final Integer ItemId;
    @Nullable
    private final Integer ItemImageId;
    @NotNull
    private final String ItemNumber;
    @Nullable
    private final Boolean ItemvalAuction;
    @NotNull
    private final String Key;
    @NotNull
    private final String LaneAndItemNumber;
    @Nullable
    private final Integer LatValue;
    @Nullable
    private final Double Latitude;
    @NotNull
    private final String LiveDate;
    @NotNull
    private final String LiveDateTime;
    @Nullable
    private final Integer LongValue;
    @Nullable
    private final Double Longitude;
    @NotNull
    private final String LossType;
    @NotNull
    private final String Make;
    @NotNull
    private final String MaskedSeller;
    @NotNull
    private final String MaskedVIN;
    @NotNull
    private final String Model;
    @NotNull
    private final String OdoBrand;
    @NotNull
    private final String Odometer;
    @Nullable
    private final Boolean OffSiteSaleIndicator;
    @NotNull
    private final String PrebidType;
    @NotNull
    private final String PrimaryDamage;
    @NotNull
    private final String Promotions;
    private final boolean PublicVehicle;
    @NotNull
    private final String RestraintSystem;
    private final boolean RunAndDrive;
    @NotNull
    private final String SaleDocument;
    @NotNull
    private final String SaleDocumentBrand;
    @NotNull
    private final String SalesListURL;
    @Nullable
    private final Integer SalvageId;
    @NotNull
    private final String SecondaryDamage;
    @NotNull
    private final String SellerName;
    @NotNull
    private final String SellerType;
    @NotNull
    private final String Series;
    @NotNull
    private final String StartDesc;
    @NotNull
    private final String StockAvailable;
    @NotNull
    private final String Stockno;
    @NotNull
    private final String StorageLocation;
    @Nullable
    private final Integer StorageLocationId;
    @NotNull
    private final String StorageLocationName;
    @Nullable
    private final Boolean TBOIndicator;
    @Nullable
    private final Integer TZAdjust;
    @NotNull
    private final String Tenant;
    @NotNull
    private final String TimeZone;
    @NotNull
    private final String TimedAuctionCloseDateTime;
    @Nullable
    private final String TimedAuctionCloseTimeCST;
    @Nullable
    private final Boolean TimedAuctionIndicator;
    @NotNull
    private final String Title;
    @NotNull
    private final String TitleState;
    @NotNull
    private final String Transmission;
    @NotNull
    private final String VIN;
    @NotNull
    private final String VehicleClass;
    @NotNull
    private final String VehicleState;
    @NotNull
    private final String VehicleSubtype;
    @NotNull
    private final String VehicleType;
    @Nullable
    private final Integer VehicleTypeId;
    @Nullable
    private final Integer Year;
    private final boolean isWatchable;
    private final boolean isWatching;
    @Nullable
    private final Boolean valVehicle;

    @NotNull
    public static /* synthetic */ FormattedResult copy$default(FormattedResult formattedResult, String str, boolean z, boolean z2, Boolean bool, String str2, String str3, Boolean bool2, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool3, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, Boolean bool4, Integer num3, String str35, String str36, String str37, String str38, Integer num4, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, Integer num5, String str49, String str50, String str51, Integer num6, String str52, int i, Integer num7, String str53, String str54, Double d, String str55, String str56, String str57, Integer num8, Boolean bool5, boolean z3, Integer num9, String str58, Double d2, String str59, String str60, Integer num10, String str61, String str62, String str63, Integer num11, Boolean bool6, Boolean bool7, Boolean bool8, boolean z4, String str64, int i2, int i3, int i4, Object obj) {
        String str65;
        String str66;
        String str67;
        String str68;
        String str69;
        String str70;
        String str71;
        String str72;
        String str73;
        String str74;
        String str75;
        String str76;
        String str77;
        String str78;
        String str79;
        String str80;
        String str81;
        Boolean bool9;
        Boolean bool10;
        String str82;
        String str83;
        String str84;
        String str85;
        String str86;
        String str87;
        String str88;
        String str89;
        String str90;
        String str91;
        String str92;
        String str93;
        String str94;
        String str95;
        String str96;
        String str97;
        String str98;
        String str99;
        String str100;
        String str101;
        String str102;
        String str103;
        String str104;
        String str105;
        String str106;
        String str107;
        String str108;
        String str109;
        Integer num12;
        Integer num13;
        String str110;
        String str111;
        String str112;
        String str113;
        String str114;
        String str115;
        String str116;
        String str117;
        String str118;
        String str119;
        String str120;
        String str121;
        String str122;
        String str123;
        String str124;
        String str125;
        String str126;
        String str127;
        String str128;
        String str129;
        Integer num14;
        Integer num15;
        String str130;
        String str131;
        String str132;
        String str133;
        String str134;
        String str135;
        Integer num16;
        String str136;
        int i5;
        int i6;
        Integer num17;
        Integer num18;
        String str137;
        String str138;
        String str139;
        String str140;
        Double d3;
        Double d4;
        String str141;
        String str142;
        String str143;
        String str144;
        String str145;
        String str146;
        Integer num19;
        Integer num20;
        String str147;
        String str148;
        String str149;
        String str150;
        String str151;
        String str152;
        Integer num21;
        Integer num22;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        Boolean bool14;
        Boolean bool15;
        Boolean bool16;
        boolean z5;
        FormattedResult formattedResult2 = formattedResult;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        String str153 = (i7 & 1) != 0 ? formattedResult2.ImageUrl : str;
        boolean z6 = (i7 & 2) != 0 ? formattedResult2.isWatchable : z;
        boolean z7 = (i7 & 4) != 0 ? formattedResult2.isWatching : z2;
        Boolean bool17 = (i7 & 8) != 0 ? formattedResult2.TimedAuctionIndicator : bool;
        String str154 = (i7 & 16) != 0 ? formattedResult2.Promotions : str2;
        String str155 = (i7 & 32) != 0 ? formattedResult2.Series : str3;
        Boolean bool18 = (i7 & 64) != 0 ? formattedResult2.valVehicle : bool2;
        String str156 = (i7 & 128) != 0 ? formattedResult2.DriveLineTypeDesc : str4;
        Integer num23 = (i7 & 256) != 0 ? formattedResult2.LongValue : num;
        Integer num24 = (i7 & 512) != 0 ? formattedResult2.LatValue : num2;
        String str157 = (i7 & 1024) != 0 ? formattedResult2.BuyNowCloseDatetime : str5;
        String str158 = (i7 & 2048) != 0 ? formattedResult2.TimedAuctionCloseDateTime : str6;
        String str159 = (i7 & 4096) != 0 ? formattedResult2.BuyNowIndicator : str7;
        String str160 = (i7 & 8192) != 0 ? formattedResult2.InteriorColor : str8;
        String str161 = (i7 & 16384) != 0 ? formattedResult2.ExteriorColor : str9;
        if ((i7 & 32768) != 0) {
            str65 = str161;
            str66 = formattedResult2.AdminBranch;
        } else {
            str65 = str161;
            str66 = str10;
        }
        if ((i7 & 65536) != 0) {
            str67 = str66;
            str68 = formattedResult2.VehicleState;
        } else {
            str67 = str66;
            str68 = str11;
        }
        if ((i7 & 131072) != 0) {
            str69 = str68;
            str70 = formattedResult2.StartDesc;
        } else {
            str69 = str68;
            str70 = str12;
        }
        if ((i7 & 262144) != 0) {
            str71 = str70;
            str72 = formattedResult2.Key;
        } else {
            str71 = str70;
            str72 = str13;
        }
        if ((i7 & 524288) != 0) {
            str73 = str72;
            str74 = formattedResult2.Airbag;
        } else {
            str73 = str72;
            str74 = str14;
        }
        if ((i7 & 1048576) != 0) {
            str75 = str74;
            str76 = formattedResult2.SecondaryDamage;
        } else {
            str75 = str74;
            str76 = str15;
        }
        if ((i7 & 2097152) != 0) {
            str77 = str76;
            str78 = formattedResult2.CountryOfOrigin;
        } else {
            str77 = str76;
            str78 = str16;
        }
        if ((i7 & 4194304) != 0) {
            str79 = str78;
            str80 = formattedResult2.PrimaryDamage;
        } else {
            str79 = str78;
            str80 = str17;
        }
        if ((i7 & 8388608) != 0) {
            str81 = str80;
            bool9 = formattedResult2.CatIndicator;
        } else {
            str81 = str80;
            bool9 = bool3;
        }
        if ((i7 & 16777216) != 0) {
            bool10 = bool9;
            str82 = formattedResult2.SellerType;
        } else {
            bool10 = bool9;
            str82 = str18;
        }
        if ((i7 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str83 = str82;
            str84 = formattedResult2.PrebidType;
        } else {
            str83 = str82;
            str84 = str19;
        }
        if ((i7 & 67108864) != 0) {
            str85 = str84;
            str86 = formattedResult2.StockAvailable;
        } else {
            str85 = str84;
            str86 = str20;
        }
        if ((i7 & 134217728) != 0) {
            str87 = str86;
            str88 = formattedResult2.IBNSold;
        } else {
            str87 = str86;
            str88 = str21;
        }
        if ((i7 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str89 = str88;
            str90 = formattedResult2.SalesListURL;
        } else {
            str89 = str88;
            str90 = str22;
        }
        if ((i7 & 536870912) != 0) {
            str91 = str90;
            str92 = formattedResult2.LaneAndItemNumber;
        } else {
            str91 = str90;
            str92 = str23;
        }
        if ((i7 & 1073741824) != 0) {
            str93 = str92;
            str94 = formattedResult2.MaskedVIN;
        } else {
            str93 = str92;
            str94 = str24;
        }
        String str162 = (i7 & Integer.MIN_VALUE) != 0 ? formattedResult2.MaskedSeller : str25;
        if ((i8 & 1) != 0) {
            str95 = str162;
            str96 = formattedResult2.Distance;
        } else {
            str95 = str162;
            str96 = str26;
        }
        if ((i8 & 2) != 0) {
            str97 = str96;
            str98 = formattedResult2.StorageLocationName;
        } else {
            str97 = str96;
            str98 = str27;
        }
        if ((i8 & 4) != 0) {
            str99 = str98;
            str100 = formattedResult2.StorageLocation;
        } else {
            str99 = str98;
            str100 = str28;
        }
        if ((i8 & 8) != 0) {
            str101 = str100;
            str102 = formattedResult2.SaleDocumentBrand;
        } else {
            str101 = str100;
            str102 = str29;
        }
        if ((i8 & 16) != 0) {
            str103 = str102;
            str104 = formattedResult2.RestraintSystem;
        } else {
            str103 = str102;
            str104 = str30;
        }
        if ((i8 & 32) != 0) {
            str105 = str104;
            str106 = formattedResult2.EngineSize;
        } else {
            str105 = str104;
            str106 = str31;
        }
        if ((i8 & 64) != 0) {
            str107 = str106;
            str108 = formattedResult2.Engine;
        } else {
            str107 = str106;
            str108 = str32;
        }
        String str163 = str108;
        String str164 = (i8 & 128) != 0 ? formattedResult2.CheckDigit : str33;
        String str165 = (i8 & 256) != 0 ? formattedResult2.TitleState : str34;
        Boolean bool19 = (i8 & 512) != 0 ? formattedResult2.TBOIndicator : bool4;
        Integer num25 = (i8 & 1024) != 0 ? formattedResult2.ACV : num3;
        String str166 = (i8 & 2048) != 0 ? formattedResult2.VehicleClass : str35;
        String str167 = (i8 & 4096) != 0 ? formattedResult2.BidLive : str36;
        String str168 = (i8 & 8192) != 0 ? formattedResult2.FuelType : str37;
        String str169 = (i8 & 16384) != 0 ? formattedResult2.SaleDocument : str38;
        if ((i8 & 32768) != 0) {
            str109 = str169;
            num12 = formattedResult2.BranchNumber;
        } else {
            str109 = str169;
            num12 = num4;
        }
        if ((i8 & 65536) != 0) {
            num13 = num12;
            str110 = formattedResult2.Availability;
        } else {
            num13 = num12;
            str110 = str39;
        }
        if ((i8 & 131072) != 0) {
            str111 = str110;
            str112 = formattedResult2.LossType;
        } else {
            str111 = str110;
            str112 = str40;
        }
        if ((i8 & 262144) != 0) {
            str113 = str112;
            str114 = formattedResult2.VIN;
        } else {
            str113 = str112;
            str114 = str41;
        }
        if ((i8 & 524288) != 0) {
            str115 = str114;
            str116 = formattedResult2.OdoBrand;
        } else {
            str115 = str114;
            str116 = str42;
        }
        if ((i8 & 1048576) != 0) {
            str117 = str116;
            str118 = formattedResult2.Odometer;
        } else {
            str117 = str116;
            str118 = str43;
        }
        if ((i8 & 2097152) != 0) {
            str119 = str118;
            str120 = formattedResult2.Title;
        } else {
            str119 = str118;
            str120 = str44;
        }
        if ((i8 & 4194304) != 0) {
            str121 = str120;
            str122 = formattedResult2.Model;
        } else {
            str121 = str120;
            str122 = str45;
        }
        if ((i8 & 8388608) != 0) {
            str123 = str122;
            str124 = formattedResult2.BranchName;
        } else {
            str123 = str122;
            str124 = str46;
        }
        if ((i8 & 16777216) != 0) {
            str125 = str124;
            str126 = formattedResult2.Make;
        } else {
            str125 = str124;
            str126 = str47;
        }
        if ((i8 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str127 = str126;
            str128 = formattedResult2.ItemNumber;
        } else {
            str127 = str126;
            str128 = str48;
        }
        if ((i8 & 67108864) != 0) {
            str129 = str128;
            num14 = formattedResult2.Year;
        } else {
            str129 = str128;
            num14 = num5;
        }
        if ((i8 & 134217728) != 0) {
            num15 = num14;
            str130 = formattedResult2.AuctionLane;
        } else {
            num15 = num14;
            str130 = str49;
        }
        if ((i8 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str131 = str130;
            str132 = formattedResult2.Stockno;
        } else {
            str131 = str130;
            str132 = str50;
        }
        if ((i8 & 536870912) != 0) {
            str133 = str132;
            str134 = formattedResult2.Tenant;
        } else {
            str133 = str132;
            str134 = str51;
        }
        if ((i8 & 1073741824) != 0) {
            str135 = str134;
            num16 = formattedResult2.ItemId;
        } else {
            str135 = str134;
            num16 = num6;
        }
        String str170 = (i8 & Integer.MIN_VALUE) != 0 ? formattedResult2.InventoryID : str52;
        if ((i9 & 1) != 0) {
            str136 = str170;
            i5 = formattedResult2.f504Id;
        } else {
            str136 = str170;
            i5 = i;
        }
        if ((i9 & 2) != 0) {
            i6 = i5;
            num17 = formattedResult2.VehicleTypeId;
        } else {
            i6 = i5;
            num17 = num7;
        }
        if ((i9 & 4) != 0) {
            num18 = num17;
            str137 = formattedResult2.Cylinders;
        } else {
            num18 = num17;
            str137 = str53;
        }
        if ((i9 & 8) != 0) {
            str138 = str137;
            str139 = formattedResult2.TimeZone;
        } else {
            str138 = str137;
            str139 = str54;
        }
        if ((i9 & 16) != 0) {
            str140 = str139;
            d3 = formattedResult2.Latitude;
        } else {
            str140 = str139;
            d3 = d;
        }
        if ((i9 & 32) != 0) {
            d4 = d3;
            str141 = formattedResult2.Transmission;
        } else {
            d4 = d3;
            str141 = str55;
        }
        if ((i9 & 64) != 0) {
            str142 = str141;
            str143 = formattedResult2.VehicleSubtype;
        } else {
            str142 = str141;
            str143 = str56;
        }
        String str171 = str143;
        String str172 = (i9 & 128) != 0 ? formattedResult2.VehicleType : str57;
        Integer num26 = (i9 & 256) != 0 ? formattedResult2.StorageLocationId : num8;
        Boolean bool20 = (i9 & 512) != 0 ? formattedResult2.OffSiteSaleIndicator : bool5;
        boolean z8 = (i9 & 1024) != 0 ? formattedResult2.RunAndDrive : z3;
        Integer num27 = (i9 & 2048) != 0 ? formattedResult2.SalvageId : num9;
        String str173 = (i9 & 4096) != 0 ? formattedResult2.DriveLineType : str58;
        Double d5 = (i9 & 8192) != 0 ? formattedResult2.Longitude : d2;
        String str174 = (i9 & 16384) != 0 ? formattedResult2.SellerName : str59;
        if ((i9 & 32768) != 0) {
            str144 = str174;
            str145 = formattedResult2.BodyStyleName;
        } else {
            str144 = str174;
            str145 = str60;
        }
        if ((i9 & 65536) != 0) {
            str146 = str145;
            num19 = formattedResult2.ItemImageId;
        } else {
            str146 = str145;
            num19 = num10;
        }
        if ((i9 & 131072) != 0) {
            num20 = num19;
            str147 = formattedResult2.CloseDateTime;
        } else {
            num20 = num19;
            str147 = str61;
        }
        if ((i9 & 262144) != 0) {
            str148 = str147;
            str149 = formattedResult2.LiveDateTime;
        } else {
            str148 = str147;
            str149 = str62;
        }
        if ((i9 & 524288) != 0) {
            str150 = str149;
            str151 = formattedResult2.LiveDate;
        } else {
            str150 = str149;
            str151 = str63;
        }
        if ((i9 & 1048576) != 0) {
            str152 = str151;
            num21 = formattedResult2.TZAdjust;
        } else {
            str152 = str151;
            num21 = num11;
        }
        if ((i9 & 2097152) != 0) {
            num22 = num21;
            bool11 = formattedResult2.ItemvalAuction;
        } else {
            num22 = num21;
            bool11 = bool6;
        }
        if ((i9 & 4194304) != 0) {
            bool12 = bool11;
            bool13 = formattedResult2.BranchvalAuction;
        } else {
            bool12 = bool11;
            bool13 = bool7;
        }
        if ((i9 & 8388608) != 0) {
            bool14 = bool13;
            bool15 = formattedResult2.DisplaySeller;
        } else {
            bool14 = bool13;
            bool15 = bool8;
        }
        if ((i9 & 16777216) != 0) {
            bool16 = bool15;
            z5 = formattedResult2.PublicVehicle;
        } else {
            bool16 = bool15;
            z5 = z4;
        }
        return formattedResult.copy(str153, z6, z7, bool17, str154, str155, bool18, str156, num23, num24, str157, str158, str159, str160, str65, str67, str69, str71, str73, str75, str77, str79, str81, bool10, str83, str85, str87, str89, str91, str93, str94, str95, str97, str99, str101, str103, str105, str107, str163, str164, str165, bool19, num25, str166, str167, str168, str109, num13, str111, str113, str115, str117, str119, str121, str123, str125, str127, str129, num15, str131, str133, str135, num16, str136, i6, num18, str138, str140, d4, str142, str171, str172, num26, bool20, z8, num27, str173, d5, str144, str146, num20, str148, str150, str152, num22, bool12, bool14, bool16, z5, (i9 & PdfFormField.FF_RADIOSINUNISON) != 0 ? formattedResult2.TimedAuctionCloseTimeCST : str64);
    }

    @NotNull
    public final String component1() {
        return this.ImageUrl;
    }

    @Nullable
    public final Integer component10() {
        return this.LatValue;
    }

    @NotNull
    public final String component11() {
        return this.BuyNowCloseDatetime;
    }

    @NotNull
    public final String component12() {
        return this.TimedAuctionCloseDateTime;
    }

    @NotNull
    public final String component13() {
        return this.BuyNowIndicator;
    }

    @NotNull
    public final String component14() {
        return this.InteriorColor;
    }

    @NotNull
    public final String component15() {
        return this.ExteriorColor;
    }

    @NotNull
    public final String component16() {
        return this.AdminBranch;
    }

    @NotNull
    public final String component17() {
        return this.VehicleState;
    }

    @NotNull
    public final String component18() {
        return this.StartDesc;
    }

    @NotNull
    public final String component19() {
        return this.Key;
    }

    public final boolean component2() {
        return this.isWatchable;
    }

    @NotNull
    public final String component20() {
        return this.Airbag;
    }

    @NotNull
    public final String component21() {
        return this.SecondaryDamage;
    }

    @NotNull
    public final String component22() {
        return this.CountryOfOrigin;
    }

    @NotNull
    public final String component23() {
        return this.PrimaryDamage;
    }

    @Nullable
    public final Boolean component24() {
        return this.CatIndicator;
    }

    @NotNull
    public final String component25() {
        return this.SellerType;
    }

    @NotNull
    public final String component26() {
        return this.PrebidType;
    }

    @NotNull
    public final String component27() {
        return this.StockAvailable;
    }

    @NotNull
    public final String component28() {
        return this.IBNSold;
    }

    @NotNull
    public final String component29() {
        return this.SalesListURL;
    }

    public final boolean component3() {
        return this.isWatching;
    }

    @NotNull
    public final String component30() {
        return this.LaneAndItemNumber;
    }

    @NotNull
    public final String component31() {
        return this.MaskedVIN;
    }

    @NotNull
    public final String component32() {
        return this.MaskedSeller;
    }

    @NotNull
    public final String component33() {
        return this.Distance;
    }

    @NotNull
    public final String component34() {
        return this.StorageLocationName;
    }

    @NotNull
    public final String component35() {
        return this.StorageLocation;
    }

    @NotNull
    public final String component36() {
        return this.SaleDocumentBrand;
    }

    @NotNull
    public final String component37() {
        return this.RestraintSystem;
    }

    @NotNull
    public final String component38() {
        return this.EngineSize;
    }

    @NotNull
    public final String component39() {
        return this.Engine;
    }

    @Nullable
    public final Boolean component4() {
        return this.TimedAuctionIndicator;
    }

    @NotNull
    public final String component40() {
        return this.CheckDigit;
    }

    @NotNull
    public final String component41() {
        return this.TitleState;
    }

    @Nullable
    public final Boolean component42() {
        return this.TBOIndicator;
    }

    @Nullable
    public final Integer component43() {
        return this.ACV;
    }

    @NotNull
    public final String component44() {
        return this.VehicleClass;
    }

    @NotNull
    public final String component45() {
        return this.BidLive;
    }

    @NotNull
    public final String component46() {
        return this.FuelType;
    }

    @NotNull
    public final String component47() {
        return this.SaleDocument;
    }

    @Nullable
    public final Integer component48() {
        return this.BranchNumber;
    }

    @NotNull
    public final String component49() {
        return this.Availability;
    }

    @NotNull
    public final String component5() {
        return this.Promotions;
    }

    @NotNull
    public final String component50() {
        return this.LossType;
    }

    @NotNull
    public final String component51() {
        return this.VIN;
    }

    @NotNull
    public final String component52() {
        return this.OdoBrand;
    }

    @NotNull
    public final String component53() {
        return this.Odometer;
    }

    @NotNull
    public final String component54() {
        return this.Title;
    }

    @NotNull
    public final String component55() {
        return this.Model;
    }

    @NotNull
    public final String component56() {
        return this.BranchName;
    }

    @NotNull
    public final String component57() {
        return this.Make;
    }

    @NotNull
    public final String component58() {
        return this.ItemNumber;
    }

    @Nullable
    public final Integer component59() {
        return this.Year;
    }

    @NotNull
    public final String component6() {
        return this.Series;
    }

    @NotNull
    public final String component60() {
        return this.AuctionLane;
    }

    @NotNull
    public final String component61() {
        return this.Stockno;
    }

    @NotNull
    public final String component62() {
        return this.Tenant;
    }

    @Nullable
    public final Integer component63() {
        return this.ItemId;
    }

    @NotNull
    public final String component64() {
        return this.InventoryID;
    }

    public final int component65() {
        return this.f504Id;
    }

    @Nullable
    public final Integer component66() {
        return this.VehicleTypeId;
    }

    @NotNull
    public final String component67() {
        return this.Cylinders;
    }

    @NotNull
    public final String component68() {
        return this.TimeZone;
    }

    @Nullable
    public final Double component69() {
        return this.Latitude;
    }

    @Nullable
    public final Boolean component7() {
        return this.valVehicle;
    }

    @NotNull
    public final String component70() {
        return this.Transmission;
    }

    @NotNull
    public final String component71() {
        return this.VehicleSubtype;
    }

    @NotNull
    public final String component72() {
        return this.VehicleType;
    }

    @Nullable
    public final Integer component73() {
        return this.StorageLocationId;
    }

    @Nullable
    public final Boolean component74() {
        return this.OffSiteSaleIndicator;
    }

    public final boolean component75() {
        return this.RunAndDrive;
    }

    @Nullable
    public final Integer component76() {
        return this.SalvageId;
    }

    @NotNull
    public final String component77() {
        return this.DriveLineType;
    }

    @Nullable
    public final Double component78() {
        return this.Longitude;
    }

    @NotNull
    public final String component79() {
        return this.SellerName;
    }

    @NotNull
    public final String component8() {
        return this.DriveLineTypeDesc;
    }

    @NotNull
    public final String component80() {
        return this.BodyStyleName;
    }

    @Nullable
    public final Integer component81() {
        return this.ItemImageId;
    }

    @Nullable
    public final String component82() {
        return this.CloseDateTime;
    }

    @NotNull
    public final String component83() {
        return this.LiveDateTime;
    }

    @NotNull
    public final String component84() {
        return this.LiveDate;
    }

    @Nullable
    public final Integer component85() {
        return this.TZAdjust;
    }

    @Nullable
    public final Boolean component86() {
        return this.ItemvalAuction;
    }

    @Nullable
    public final Boolean component87() {
        return this.BranchvalAuction;
    }

    @Nullable
    public final Boolean component88() {
        return this.DisplaySeller;
    }

    public final boolean component89() {
        return this.PublicVehicle;
    }

    @Nullable
    public final Integer component9() {
        return this.LongValue;
    }

    @Nullable
    public final String component90() {
        return this.TimedAuctionCloseTimeCST;
    }

    @NotNull
    public final FormattedResult copy(@NotNull String str, boolean z, boolean z2, @Nullable Boolean bool, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool2, @NotNull String str4, @Nullable Integer num, @Nullable Integer num2, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @Nullable Boolean bool3, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, @NotNull String str23, @NotNull String str24, @NotNull String str25, @NotNull String str26, @NotNull String str27, @NotNull String str28, @NotNull String str29, @NotNull String str30, @NotNull String str31, @NotNull String str32, @NotNull String str33, @NotNull String str34, @Nullable Boolean bool4, @Nullable Integer num3, @NotNull String str35, @NotNull String str36, @NotNull String str37, @NotNull String str38, @Nullable Integer num4, @NotNull String str39, @NotNull String str40, @NotNull String str41, @NotNull String str42, @NotNull String str43, @NotNull String str44, @NotNull String str45, @NotNull String str46, @NotNull String str47, @NotNull String str48, @Nullable Integer num5, @NotNull String str49, @NotNull String str50, @NotNull String str51, @Nullable Integer num6, @NotNull String str52, int i, @Nullable Integer num7, @NotNull String str53, @NotNull String str54, @Nullable Double d, @NotNull String str55, @NotNull String str56, @NotNull String str57, @Nullable Integer num8, @Nullable Boolean bool5, boolean z3, @Nullable Integer num9, @NotNull String str58, @Nullable Double d2, @NotNull String str59, @NotNull String str60, @Nullable Integer num10, @Nullable String str61, @NotNull String str62, @NotNull String str63, @Nullable Integer num11, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable Boolean bool8, boolean z4, @Nullable String str64) {
        String str65 = str;
        Intrinsics.checkParameterIsNotNull(str65, "ImageUrl");
        Intrinsics.checkParameterIsNotNull(str2, "Promotions");
        Intrinsics.checkParameterIsNotNull(str3, "Series");
        Intrinsics.checkParameterIsNotNull(str4, "DriveLineTypeDesc");
        Intrinsics.checkParameterIsNotNull(str5, "BuyNowCloseDatetime");
        Intrinsics.checkParameterIsNotNull(str6, "TimedAuctionCloseDateTime");
        Intrinsics.checkParameterIsNotNull(str7, "BuyNowIndicator");
        Intrinsics.checkParameterIsNotNull(str8, "InteriorColor");
        Intrinsics.checkParameterIsNotNull(str9, "ExteriorColor");
        Intrinsics.checkParameterIsNotNull(str10, "AdminBranch");
        Intrinsics.checkParameterIsNotNull(str11, "VehicleState");
        Intrinsics.checkParameterIsNotNull(str12, "StartDesc");
        Intrinsics.checkParameterIsNotNull(str13, "Key");
        Intrinsics.checkParameterIsNotNull(str14, "Airbag");
        Intrinsics.checkParameterIsNotNull(str15, "SecondaryDamage");
        Intrinsics.checkParameterIsNotNull(str16, "CountryOfOrigin");
        Intrinsics.checkParameterIsNotNull(str17, "PrimaryDamage");
        Intrinsics.checkParameterIsNotNull(str18, "SellerType");
        Intrinsics.checkParameterIsNotNull(str19, "PrebidType");
        Intrinsics.checkParameterIsNotNull(str20, "StockAvailable");
        Intrinsics.checkParameterIsNotNull(str21, "IBNSold");
        Intrinsics.checkParameterIsNotNull(str22, "SalesListURL");
        Intrinsics.checkParameterIsNotNull(str23, "LaneAndItemNumber");
        Intrinsics.checkParameterIsNotNull(str24, "MaskedVIN");
        Intrinsics.checkParameterIsNotNull(str25, "MaskedSeller");
        Intrinsics.checkParameterIsNotNull(str26, "Distance");
        Intrinsics.checkParameterIsNotNull(str27, "StorageLocationName");
        Intrinsics.checkParameterIsNotNull(str28, "StorageLocation");
        Intrinsics.checkParameterIsNotNull(str29, "SaleDocumentBrand");
        Intrinsics.checkParameterIsNotNull(str30, "RestraintSystem");
        Intrinsics.checkParameterIsNotNull(str31, "EngineSize");
        Intrinsics.checkParameterIsNotNull(str32, "Engine");
        Intrinsics.checkParameterIsNotNull(str33, "CheckDigit");
        Intrinsics.checkParameterIsNotNull(str34, "TitleState");
        Intrinsics.checkParameterIsNotNull(str35, "VehicleClass");
        Intrinsics.checkParameterIsNotNull(str36, "BidLive");
        Intrinsics.checkParameterIsNotNull(str37, "FuelType");
        Intrinsics.checkParameterIsNotNull(str38, "SaleDocument");
        Intrinsics.checkParameterIsNotNull(str39, "Availability");
        Intrinsics.checkParameterIsNotNull(str40, "LossType");
        Intrinsics.checkParameterIsNotNull(str41, "VIN");
        Intrinsics.checkParameterIsNotNull(str42, "OdoBrand");
        Intrinsics.checkParameterIsNotNull(str43, "Odometer");
        Intrinsics.checkParameterIsNotNull(str44, "Title");
        Intrinsics.checkParameterIsNotNull(str45, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str46, "BranchName");
        Intrinsics.checkParameterIsNotNull(str47, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str48, "ItemNumber");
        Intrinsics.checkParameterIsNotNull(str49, "AuctionLane");
        Intrinsics.checkParameterIsNotNull(str50, "Stockno");
        Intrinsics.checkParameterIsNotNull(str51, "Tenant");
        Intrinsics.checkParameterIsNotNull(str52, "InventoryID");
        Intrinsics.checkParameterIsNotNull(str53, "Cylinders");
        Intrinsics.checkParameterIsNotNull(str54, "TimeZone");
        Intrinsics.checkParameterIsNotNull(str55, "Transmission");
        Intrinsics.checkParameterIsNotNull(str56, "VehicleSubtype");
        Intrinsics.checkParameterIsNotNull(str57, "VehicleType");
        Intrinsics.checkParameterIsNotNull(str58, "DriveLineType");
        Intrinsics.checkParameterIsNotNull(str59, "SellerName");
        Intrinsics.checkParameterIsNotNull(str60, "BodyStyleName");
        Intrinsics.checkParameterIsNotNull(str62, "LiveDateTime");
        Intrinsics.checkParameterIsNotNull(str63, "LiveDate");
        return new FormattedResult(str65, z, z2, bool, str2, str3, bool2, str4, num, num2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, bool3, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, bool4, num3, str35, str36, str37, str38, num4, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, num5, str49, str50, str51, num6, str52, i, num7, str53, str54, d, str55, str56, str57, num8, bool5, z3, num9, str58, d2, str59, str60, num10, str61, str62, str63, num11, bool6, bool7, bool8, z4, str64);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FormattedResult) {
                FormattedResult formattedResult = (FormattedResult) obj;
                if (Intrinsics.areEqual((Object) this.ImageUrl, (Object) formattedResult.ImageUrl)) {
                    if (this.isWatchable == formattedResult.isWatchable) {
                        if ((this.isWatching == formattedResult.isWatching) && Intrinsics.areEqual((Object) this.TimedAuctionIndicator, (Object) formattedResult.TimedAuctionIndicator) && Intrinsics.areEqual((Object) this.Promotions, (Object) formattedResult.Promotions) && Intrinsics.areEqual((Object) this.Series, (Object) formattedResult.Series) && Intrinsics.areEqual((Object) this.valVehicle, (Object) formattedResult.valVehicle) && Intrinsics.areEqual((Object) this.DriveLineTypeDesc, (Object) formattedResult.DriveLineTypeDesc) && Intrinsics.areEqual((Object) this.LongValue, (Object) formattedResult.LongValue) && Intrinsics.areEqual((Object) this.LatValue, (Object) formattedResult.LatValue) && Intrinsics.areEqual((Object) this.BuyNowCloseDatetime, (Object) formattedResult.BuyNowCloseDatetime) && Intrinsics.areEqual((Object) this.TimedAuctionCloseDateTime, (Object) formattedResult.TimedAuctionCloseDateTime) && Intrinsics.areEqual((Object) this.BuyNowIndicator, (Object) formattedResult.BuyNowIndicator) && Intrinsics.areEqual((Object) this.InteriorColor, (Object) formattedResult.InteriorColor) && Intrinsics.areEqual((Object) this.ExteriorColor, (Object) formattedResult.ExteriorColor) && Intrinsics.areEqual((Object) this.AdminBranch, (Object) formattedResult.AdminBranch) && Intrinsics.areEqual((Object) this.VehicleState, (Object) formattedResult.VehicleState) && Intrinsics.areEqual((Object) this.StartDesc, (Object) formattedResult.StartDesc) && Intrinsics.areEqual((Object) this.Key, (Object) formattedResult.Key) && Intrinsics.areEqual((Object) this.Airbag, (Object) formattedResult.Airbag) && Intrinsics.areEqual((Object) this.SecondaryDamage, (Object) formattedResult.SecondaryDamage) && Intrinsics.areEqual((Object) this.CountryOfOrigin, (Object) formattedResult.CountryOfOrigin) && Intrinsics.areEqual((Object) this.PrimaryDamage, (Object) formattedResult.PrimaryDamage) && Intrinsics.areEqual((Object) this.CatIndicator, (Object) formattedResult.CatIndicator) && Intrinsics.areEqual((Object) this.SellerType, (Object) formattedResult.SellerType) && Intrinsics.areEqual((Object) this.PrebidType, (Object) formattedResult.PrebidType) && Intrinsics.areEqual((Object) this.StockAvailable, (Object) formattedResult.StockAvailable) && Intrinsics.areEqual((Object) this.IBNSold, (Object) formattedResult.IBNSold) && Intrinsics.areEqual((Object) this.SalesListURL, (Object) formattedResult.SalesListURL) && Intrinsics.areEqual((Object) this.LaneAndItemNumber, (Object) formattedResult.LaneAndItemNumber) && Intrinsics.areEqual((Object) this.MaskedVIN, (Object) formattedResult.MaskedVIN) && Intrinsics.areEqual((Object) this.MaskedSeller, (Object) formattedResult.MaskedSeller) && Intrinsics.areEqual((Object) this.Distance, (Object) formattedResult.Distance) && Intrinsics.areEqual((Object) this.StorageLocationName, (Object) formattedResult.StorageLocationName) && Intrinsics.areEqual((Object) this.StorageLocation, (Object) formattedResult.StorageLocation) && Intrinsics.areEqual((Object) this.SaleDocumentBrand, (Object) formattedResult.SaleDocumentBrand) && Intrinsics.areEqual((Object) this.RestraintSystem, (Object) formattedResult.RestraintSystem) && Intrinsics.areEqual((Object) this.EngineSize, (Object) formattedResult.EngineSize) && Intrinsics.areEqual((Object) this.Engine, (Object) formattedResult.Engine) && Intrinsics.areEqual((Object) this.CheckDigit, (Object) formattedResult.CheckDigit) && Intrinsics.areEqual((Object) this.TitleState, (Object) formattedResult.TitleState) && Intrinsics.areEqual((Object) this.TBOIndicator, (Object) formattedResult.TBOIndicator) && Intrinsics.areEqual((Object) this.ACV, (Object) formattedResult.ACV) && Intrinsics.areEqual((Object) this.VehicleClass, (Object) formattedResult.VehicleClass) && Intrinsics.areEqual((Object) this.BidLive, (Object) formattedResult.BidLive) && Intrinsics.areEqual((Object) this.FuelType, (Object) formattedResult.FuelType) && Intrinsics.areEqual((Object) this.SaleDocument, (Object) formattedResult.SaleDocument) && Intrinsics.areEqual((Object) this.BranchNumber, (Object) formattedResult.BranchNumber) && Intrinsics.areEqual((Object) this.Availability, (Object) formattedResult.Availability) && Intrinsics.areEqual((Object) this.LossType, (Object) formattedResult.LossType) && Intrinsics.areEqual((Object) this.VIN, (Object) formattedResult.VIN) && Intrinsics.areEqual((Object) this.OdoBrand, (Object) formattedResult.OdoBrand) && Intrinsics.areEqual((Object) this.Odometer, (Object) formattedResult.Odometer) && Intrinsics.areEqual((Object) this.Title, (Object) formattedResult.Title) && Intrinsics.areEqual((Object) this.Model, (Object) formattedResult.Model) && Intrinsics.areEqual((Object) this.BranchName, (Object) formattedResult.BranchName) && Intrinsics.areEqual((Object) this.Make, (Object) formattedResult.Make) && Intrinsics.areEqual((Object) this.ItemNumber, (Object) formattedResult.ItemNumber) && Intrinsics.areEqual((Object) this.Year, (Object) formattedResult.Year) && Intrinsics.areEqual((Object) this.AuctionLane, (Object) formattedResult.AuctionLane) && Intrinsics.areEqual((Object) this.Stockno, (Object) formattedResult.Stockno) && Intrinsics.areEqual((Object) this.Tenant, (Object) formattedResult.Tenant) && Intrinsics.areEqual((Object) this.ItemId, (Object) formattedResult.ItemId) && Intrinsics.areEqual((Object) this.InventoryID, (Object) formattedResult.InventoryID)) {
                            if ((this.f504Id == formattedResult.f504Id) && Intrinsics.areEqual((Object) this.VehicleTypeId, (Object) formattedResult.VehicleTypeId) && Intrinsics.areEqual((Object) this.Cylinders, (Object) formattedResult.Cylinders) && Intrinsics.areEqual((Object) this.TimeZone, (Object) formattedResult.TimeZone) && Intrinsics.areEqual((Object) this.Latitude, (Object) formattedResult.Latitude) && Intrinsics.areEqual((Object) this.Transmission, (Object) formattedResult.Transmission) && Intrinsics.areEqual((Object) this.VehicleSubtype, (Object) formattedResult.VehicleSubtype) && Intrinsics.areEqual((Object) this.VehicleType, (Object) formattedResult.VehicleType) && Intrinsics.areEqual((Object) this.StorageLocationId, (Object) formattedResult.StorageLocationId) && Intrinsics.areEqual((Object) this.OffSiteSaleIndicator, (Object) formattedResult.OffSiteSaleIndicator)) {
                                if ((this.RunAndDrive == formattedResult.RunAndDrive) && Intrinsics.areEqual((Object) this.SalvageId, (Object) formattedResult.SalvageId) && Intrinsics.areEqual((Object) this.DriveLineType, (Object) formattedResult.DriveLineType) && Intrinsics.areEqual((Object) this.Longitude, (Object) formattedResult.Longitude) && Intrinsics.areEqual((Object) this.SellerName, (Object) formattedResult.SellerName) && Intrinsics.areEqual((Object) this.BodyStyleName, (Object) formattedResult.BodyStyleName) && Intrinsics.areEqual((Object) this.ItemImageId, (Object) formattedResult.ItemImageId) && Intrinsics.areEqual((Object) this.CloseDateTime, (Object) formattedResult.CloseDateTime) && Intrinsics.areEqual((Object) this.LiveDateTime, (Object) formattedResult.LiveDateTime) && Intrinsics.areEqual((Object) this.LiveDate, (Object) formattedResult.LiveDate) && Intrinsics.areEqual((Object) this.TZAdjust, (Object) formattedResult.TZAdjust) && Intrinsics.areEqual((Object) this.ItemvalAuction, (Object) formattedResult.ItemvalAuction) && Intrinsics.areEqual((Object) this.BranchvalAuction, (Object) formattedResult.BranchvalAuction) && Intrinsics.areEqual((Object) this.DisplaySeller, (Object) formattedResult.DisplaySeller)) {
                                    if (!(this.PublicVehicle == formattedResult.PublicVehicle) || !Intrinsics.areEqual((Object) this.TimedAuctionCloseTimeCST, (Object) formattedResult.TimedAuctionCloseTimeCST)) {
                                        return false;
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
        String str = this.ImageUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.isWatchable;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z2 = this.isWatching;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        Boolean bool = this.TimedAuctionIndicator;
        int hashCode2 = (i3 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.Promotions;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Series;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool2 = this.valVehicle;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str4 = this.DriveLineTypeDesc;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.LongValue;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.LatValue;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str5 = this.BuyNowCloseDatetime;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.TimedAuctionCloseDateTime;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.BuyNowIndicator;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.InteriorColor;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ExteriorColor;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.AdminBranch;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.VehicleState;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.StartDesc;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.Key;
        int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.Airbag;
        int hashCode18 = (hashCode17 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.SecondaryDamage;
        int hashCode19 = (hashCode18 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.CountryOfOrigin;
        int hashCode20 = (hashCode19 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.PrimaryDamage;
        int hashCode21 = (hashCode20 + (str17 != null ? str17.hashCode() : 0)) * 31;
        Boolean bool3 = this.CatIndicator;
        int hashCode22 = (hashCode21 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str18 = this.SellerType;
        int hashCode23 = (hashCode22 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.PrebidType;
        int hashCode24 = (hashCode23 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.StockAvailable;
        int hashCode25 = (hashCode24 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.IBNSold;
        int hashCode26 = (hashCode25 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.SalesListURL;
        int hashCode27 = (hashCode26 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.LaneAndItemNumber;
        int hashCode28 = (hashCode27 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.MaskedVIN;
        int hashCode29 = (hashCode28 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.MaskedSeller;
        int hashCode30 = (hashCode29 + (str25 != null ? str25.hashCode() : 0)) * 31;
        String str26 = this.Distance;
        int hashCode31 = (hashCode30 + (str26 != null ? str26.hashCode() : 0)) * 31;
        String str27 = this.StorageLocationName;
        int hashCode32 = (hashCode31 + (str27 != null ? str27.hashCode() : 0)) * 31;
        String str28 = this.StorageLocation;
        int hashCode33 = (hashCode32 + (str28 != null ? str28.hashCode() : 0)) * 31;
        String str29 = this.SaleDocumentBrand;
        int hashCode34 = (hashCode33 + (str29 != null ? str29.hashCode() : 0)) * 31;
        String str30 = this.RestraintSystem;
        int hashCode35 = (hashCode34 + (str30 != null ? str30.hashCode() : 0)) * 31;
        String str31 = this.EngineSize;
        int hashCode36 = (hashCode35 + (str31 != null ? str31.hashCode() : 0)) * 31;
        String str32 = this.Engine;
        int hashCode37 = (hashCode36 + (str32 != null ? str32.hashCode() : 0)) * 31;
        String str33 = this.CheckDigit;
        int hashCode38 = (hashCode37 + (str33 != null ? str33.hashCode() : 0)) * 31;
        String str34 = this.TitleState;
        int hashCode39 = (hashCode38 + (str34 != null ? str34.hashCode() : 0)) * 31;
        Boolean bool4 = this.TBOIndicator;
        int hashCode40 = (hashCode39 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Integer num3 = this.ACV;
        int hashCode41 = (hashCode40 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str35 = this.VehicleClass;
        int hashCode42 = (hashCode41 + (str35 != null ? str35.hashCode() : 0)) * 31;
        String str36 = this.BidLive;
        int hashCode43 = (hashCode42 + (str36 != null ? str36.hashCode() : 0)) * 31;
        String str37 = this.FuelType;
        int hashCode44 = (hashCode43 + (str37 != null ? str37.hashCode() : 0)) * 31;
        String str38 = this.SaleDocument;
        int hashCode45 = (hashCode44 + (str38 != null ? str38.hashCode() : 0)) * 31;
        Integer num4 = this.BranchNumber;
        int hashCode46 = (hashCode45 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str39 = this.Availability;
        int hashCode47 = (hashCode46 + (str39 != null ? str39.hashCode() : 0)) * 31;
        String str40 = this.LossType;
        int hashCode48 = (hashCode47 + (str40 != null ? str40.hashCode() : 0)) * 31;
        String str41 = this.VIN;
        int hashCode49 = (hashCode48 + (str41 != null ? str41.hashCode() : 0)) * 31;
        String str42 = this.OdoBrand;
        int hashCode50 = (hashCode49 + (str42 != null ? str42.hashCode() : 0)) * 31;
        String str43 = this.Odometer;
        int hashCode51 = (hashCode50 + (str43 != null ? str43.hashCode() : 0)) * 31;
        String str44 = this.Title;
        int hashCode52 = (hashCode51 + (str44 != null ? str44.hashCode() : 0)) * 31;
        String str45 = this.Model;
        int hashCode53 = (hashCode52 + (str45 != null ? str45.hashCode() : 0)) * 31;
        String str46 = this.BranchName;
        int hashCode54 = (hashCode53 + (str46 != null ? str46.hashCode() : 0)) * 31;
        String str47 = this.Make;
        int hashCode55 = (hashCode54 + (str47 != null ? str47.hashCode() : 0)) * 31;
        String str48 = this.ItemNumber;
        int hashCode56 = (hashCode55 + (str48 != null ? str48.hashCode() : 0)) * 31;
        Integer num5 = this.Year;
        int hashCode57 = (hashCode56 + (num5 != null ? num5.hashCode() : 0)) * 31;
        String str49 = this.AuctionLane;
        int hashCode58 = (hashCode57 + (str49 != null ? str49.hashCode() : 0)) * 31;
        String str50 = this.Stockno;
        int hashCode59 = (hashCode58 + (str50 != null ? str50.hashCode() : 0)) * 31;
        String str51 = this.Tenant;
        int hashCode60 = (hashCode59 + (str51 != null ? str51.hashCode() : 0)) * 31;
        Integer num6 = this.ItemId;
        int hashCode61 = (hashCode60 + (num6 != null ? num6.hashCode() : 0)) * 31;
        String str52 = this.InventoryID;
        int hashCode62 = (((hashCode61 + (str52 != null ? str52.hashCode() : 0)) * 31) + Integer.valueOf(this.f504Id).hashCode()) * 31;
        Integer num7 = this.VehicleTypeId;
        int hashCode63 = (hashCode62 + (num7 != null ? num7.hashCode() : 0)) * 31;
        String str53 = this.Cylinders;
        int hashCode64 = (hashCode63 + (str53 != null ? str53.hashCode() : 0)) * 31;
        String str54 = this.TimeZone;
        int hashCode65 = (hashCode64 + (str54 != null ? str54.hashCode() : 0)) * 31;
        Double d = this.Latitude;
        int hashCode66 = (hashCode65 + (d != null ? d.hashCode() : 0)) * 31;
        String str55 = this.Transmission;
        int hashCode67 = (hashCode66 + (str55 != null ? str55.hashCode() : 0)) * 31;
        String str56 = this.VehicleSubtype;
        int hashCode68 = (hashCode67 + (str56 != null ? str56.hashCode() : 0)) * 31;
        String str57 = this.VehicleType;
        int hashCode69 = (hashCode68 + (str57 != null ? str57.hashCode() : 0)) * 31;
        Integer num8 = this.StorageLocationId;
        int hashCode70 = (hashCode69 + (num8 != null ? num8.hashCode() : 0)) * 31;
        Boolean bool5 = this.OffSiteSaleIndicator;
        int hashCode71 = (hashCode70 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        boolean z3 = this.RunAndDrive;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode71 + (z3 ? 1 : 0)) * 31;
        Integer num9 = this.SalvageId;
        int hashCode72 = (i4 + (num9 != null ? num9.hashCode() : 0)) * 31;
        String str58 = this.DriveLineType;
        int hashCode73 = (hashCode72 + (str58 != null ? str58.hashCode() : 0)) * 31;
        Double d2 = this.Longitude;
        int hashCode74 = (hashCode73 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str59 = this.SellerName;
        int hashCode75 = (hashCode74 + (str59 != null ? str59.hashCode() : 0)) * 31;
        String str60 = this.BodyStyleName;
        int hashCode76 = (hashCode75 + (str60 != null ? str60.hashCode() : 0)) * 31;
        Integer num10 = this.ItemImageId;
        int hashCode77 = (hashCode76 + (num10 != null ? num10.hashCode() : 0)) * 31;
        String str61 = this.CloseDateTime;
        int hashCode78 = (hashCode77 + (str61 != null ? str61.hashCode() : 0)) * 31;
        String str62 = this.LiveDateTime;
        int hashCode79 = (hashCode78 + (str62 != null ? str62.hashCode() : 0)) * 31;
        String str63 = this.LiveDate;
        int hashCode80 = (hashCode79 + (str63 != null ? str63.hashCode() : 0)) * 31;
        Integer num11 = this.TZAdjust;
        int hashCode81 = (hashCode80 + (num11 != null ? num11.hashCode() : 0)) * 31;
        Boolean bool6 = this.ItemvalAuction;
        int hashCode82 = (hashCode81 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.BranchvalAuction;
        int hashCode83 = (hashCode82 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.DisplaySeller;
        int hashCode84 = (hashCode83 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        boolean z4 = this.PublicVehicle;
        if (z4) {
            z4 = true;
        }
        int i5 = (hashCode84 + (z4 ? 1 : 0)) * 31;
        String str64 = this.TimedAuctionCloseTimeCST;
        if (str64 != null) {
            i = str64.hashCode();
        }
        return i5 + i;
    }

    @NotNull
    public String toString() {
        return "FormattedResult(ImageUrl=" + this.ImageUrl + ", isWatchable=" + this.isWatchable + ", isWatching=" + this.isWatching + ", TimedAuctionIndicator=" + this.TimedAuctionIndicator + ", Promotions=" + this.Promotions + ", Series=" + this.Series + ", valVehicle=" + this.valVehicle + ", DriveLineTypeDesc=" + this.DriveLineTypeDesc + ", LongValue=" + this.LongValue + ", LatValue=" + this.LatValue + ", BuyNowCloseDatetime=" + this.BuyNowCloseDatetime + ", TimedAuctionCloseDateTime=" + this.TimedAuctionCloseDateTime + ", BuyNowIndicator=" + this.BuyNowIndicator + ", InteriorColor=" + this.InteriorColor + ", ExteriorColor=" + this.ExteriorColor + ", AdminBranch=" + this.AdminBranch + ", VehicleState=" + this.VehicleState + ", StartDesc=" + this.StartDesc + ", Key=" + this.Key + ", Airbag=" + this.Airbag + ", SecondaryDamage=" + this.SecondaryDamage + ", CountryOfOrigin=" + this.CountryOfOrigin + ", PrimaryDamage=" + this.PrimaryDamage + ", CatIndicator=" + this.CatIndicator + ", SellerType=" + this.SellerType + ", PrebidType=" + this.PrebidType + ", StockAvailable=" + this.StockAvailable + ", IBNSold=" + this.IBNSold + ", SalesListURL=" + this.SalesListURL + ", LaneAndItemNumber=" + this.LaneAndItemNumber + ", MaskedVIN=" + this.MaskedVIN + ", MaskedSeller=" + this.MaskedSeller + ", Distance=" + this.Distance + ", StorageLocationName=" + this.StorageLocationName + ", StorageLocation=" + this.StorageLocation + ", SaleDocumentBrand=" + this.SaleDocumentBrand + ", RestraintSystem=" + this.RestraintSystem + ", EngineSize=" + this.EngineSize + ", Engine=" + this.Engine + ", CheckDigit=" + this.CheckDigit + ", TitleState=" + this.TitleState + ", TBOIndicator=" + this.TBOIndicator + ", ACV=" + this.ACV + ", VehicleClass=" + this.VehicleClass + ", BidLive=" + this.BidLive + ", FuelType=" + this.FuelType + ", SaleDocument=" + this.SaleDocument + ", BranchNumber=" + this.BranchNumber + ", Availability=" + this.Availability + ", LossType=" + this.LossType + ", VIN=" + this.VIN + ", OdoBrand=" + this.OdoBrand + ", Odometer=" + this.Odometer + ", Title=" + this.Title + ", Model=" + this.Model + ", BranchName=" + this.BranchName + ", Make=" + this.Make + ", ItemNumber=" + this.ItemNumber + ", Year=" + this.Year + ", AuctionLane=" + this.AuctionLane + ", Stockno=" + this.Stockno + ", Tenant=" + this.Tenant + ", ItemId=" + this.ItemId + ", InventoryID=" + this.InventoryID + ", Id=" + this.f504Id + ", VehicleTypeId=" + this.VehicleTypeId + ", Cylinders=" + this.Cylinders + ", TimeZone=" + this.TimeZone + ", Latitude=" + this.Latitude + ", Transmission=" + this.Transmission + ", VehicleSubtype=" + this.VehicleSubtype + ", VehicleType=" + this.VehicleType + ", StorageLocationId=" + this.StorageLocationId + ", OffSiteSaleIndicator=" + this.OffSiteSaleIndicator + ", RunAndDrive=" + this.RunAndDrive + ", SalvageId=" + this.SalvageId + ", DriveLineType=" + this.DriveLineType + ", Longitude=" + this.Longitude + ", SellerName=" + this.SellerName + ", BodyStyleName=" + this.BodyStyleName + ", ItemImageId=" + this.ItemImageId + ", CloseDateTime=" + this.CloseDateTime + ", LiveDateTime=" + this.LiveDateTime + ", LiveDate=" + this.LiveDate + ", TZAdjust=" + this.TZAdjust + ", ItemvalAuction=" + this.ItemvalAuction + ", BranchvalAuction=" + this.BranchvalAuction + ", DisplaySeller=" + this.DisplaySeller + ", PublicVehicle=" + this.PublicVehicle + ", TimedAuctionCloseTimeCST=" + this.TimedAuctionCloseTimeCST + ")";
    }

    public FormattedResult(@NotNull String str, boolean z, boolean z2, @Nullable Boolean bool, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool2, @NotNull String str4, @Nullable Integer num, @Nullable Integer num2, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @Nullable Boolean bool3, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, @NotNull String str23, @NotNull String str24, @NotNull String str25, @NotNull String str26, @NotNull String str27, @NotNull String str28, @NotNull String str29, @NotNull String str30, @NotNull String str31, @NotNull String str32, @NotNull String str33, @NotNull String str34, @Nullable Boolean bool4, @Nullable Integer num3, @NotNull String str35, @NotNull String str36, @NotNull String str37, @NotNull String str38, @Nullable Integer num4, @NotNull String str39, @NotNull String str40, @NotNull String str41, @NotNull String str42, @NotNull String str43, @NotNull String str44, @NotNull String str45, @NotNull String str46, @NotNull String str47, @NotNull String str48, @Nullable Integer num5, @NotNull String str49, @NotNull String str50, @NotNull String str51, @Nullable Integer num6, @NotNull String str52, int i, @Nullable Integer num7, @NotNull String str53, @NotNull String str54, @Nullable Double d, @NotNull String str55, @NotNull String str56, @NotNull String str57, @Nullable Integer num8, @Nullable Boolean bool5, boolean z3, @Nullable Integer num9, @NotNull String str58, @Nullable Double d2, @NotNull String str59, @NotNull String str60, @Nullable Integer num10, @Nullable String str61, @NotNull String str62, @NotNull String str63, @Nullable Integer num11, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable Boolean bool8, boolean z4, @Nullable String str64) {
        String str65 = str;
        String str66 = str2;
        String str67 = str3;
        String str68 = str4;
        String str69 = str5;
        String str70 = str6;
        String str71 = str7;
        String str72 = str8;
        String str73 = str9;
        String str74 = str10;
        String str75 = str11;
        String str76 = str12;
        String str77 = str13;
        String str78 = str14;
        String str79 = str16;
        Intrinsics.checkParameterIsNotNull(str65, "ImageUrl");
        Intrinsics.checkParameterIsNotNull(str66, "Promotions");
        Intrinsics.checkParameterIsNotNull(str67, "Series");
        Intrinsics.checkParameterIsNotNull(str68, "DriveLineTypeDesc");
        Intrinsics.checkParameterIsNotNull(str69, "BuyNowCloseDatetime");
        Intrinsics.checkParameterIsNotNull(str70, "TimedAuctionCloseDateTime");
        Intrinsics.checkParameterIsNotNull(str71, "BuyNowIndicator");
        Intrinsics.checkParameterIsNotNull(str72, "InteriorColor");
        Intrinsics.checkParameterIsNotNull(str73, "ExteriorColor");
        Intrinsics.checkParameterIsNotNull(str74, "AdminBranch");
        Intrinsics.checkParameterIsNotNull(str75, "VehicleState");
        Intrinsics.checkParameterIsNotNull(str76, "StartDesc");
        Intrinsics.checkParameterIsNotNull(str77, "Key");
        Intrinsics.checkParameterIsNotNull(str78, "Airbag");
        Intrinsics.checkParameterIsNotNull(str15, "SecondaryDamage");
        Intrinsics.checkParameterIsNotNull(str16, "CountryOfOrigin");
        Intrinsics.checkParameterIsNotNull(str17, "PrimaryDamage");
        Intrinsics.checkParameterIsNotNull(str18, "SellerType");
        Intrinsics.checkParameterIsNotNull(str19, "PrebidType");
        Intrinsics.checkParameterIsNotNull(str20, "StockAvailable");
        Intrinsics.checkParameterIsNotNull(str21, "IBNSold");
        Intrinsics.checkParameterIsNotNull(str22, "SalesListURL");
        Intrinsics.checkParameterIsNotNull(str23, "LaneAndItemNumber");
        Intrinsics.checkParameterIsNotNull(str24, "MaskedVIN");
        Intrinsics.checkParameterIsNotNull(str25, "MaskedSeller");
        Intrinsics.checkParameterIsNotNull(str26, "Distance");
        Intrinsics.checkParameterIsNotNull(str27, "StorageLocationName");
        Intrinsics.checkParameterIsNotNull(str28, "StorageLocation");
        Intrinsics.checkParameterIsNotNull(str29, "SaleDocumentBrand");
        Intrinsics.checkParameterIsNotNull(str30, "RestraintSystem");
        Intrinsics.checkParameterIsNotNull(str31, "EngineSize");
        Intrinsics.checkParameterIsNotNull(str32, "Engine");
        Intrinsics.checkParameterIsNotNull(str33, "CheckDigit");
        Intrinsics.checkParameterIsNotNull(str34, "TitleState");
        Intrinsics.checkParameterIsNotNull(str35, "VehicleClass");
        Intrinsics.checkParameterIsNotNull(str36, "BidLive");
        Intrinsics.checkParameterIsNotNull(str37, "FuelType");
        Intrinsics.checkParameterIsNotNull(str38, "SaleDocument");
        Intrinsics.checkParameterIsNotNull(str39, "Availability");
        Intrinsics.checkParameterIsNotNull(str40, "LossType");
        Intrinsics.checkParameterIsNotNull(str41, "VIN");
        Intrinsics.checkParameterIsNotNull(str42, "OdoBrand");
        Intrinsics.checkParameterIsNotNull(str43, "Odometer");
        Intrinsics.checkParameterIsNotNull(str44, "Title");
        Intrinsics.checkParameterIsNotNull(str45, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str46, "BranchName");
        Intrinsics.checkParameterIsNotNull(str47, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str48, "ItemNumber");
        Intrinsics.checkParameterIsNotNull(str49, "AuctionLane");
        Intrinsics.checkParameterIsNotNull(str50, "Stockno");
        Intrinsics.checkParameterIsNotNull(str51, "Tenant");
        Intrinsics.checkParameterIsNotNull(str52, "InventoryID");
        Intrinsics.checkParameterIsNotNull(str53, "Cylinders");
        Intrinsics.checkParameterIsNotNull(str54, "TimeZone");
        Intrinsics.checkParameterIsNotNull(str55, "Transmission");
        Intrinsics.checkParameterIsNotNull(str56, "VehicleSubtype");
        Intrinsics.checkParameterIsNotNull(str57, "VehicleType");
        Intrinsics.checkParameterIsNotNull(str58, "DriveLineType");
        Intrinsics.checkParameterIsNotNull(str59, "SellerName");
        Intrinsics.checkParameterIsNotNull(str60, "BodyStyleName");
        Intrinsics.checkParameterIsNotNull(str62, "LiveDateTime");
        Intrinsics.checkParameterIsNotNull(str63, "LiveDate");
        this.ImageUrl = str65;
        this.isWatchable = z;
        this.isWatching = z2;
        this.TimedAuctionIndicator = bool;
        this.Promotions = str66;
        this.Series = str67;
        this.valVehicle = bool2;
        this.DriveLineTypeDesc = str68;
        this.LongValue = num;
        this.LatValue = num2;
        this.BuyNowCloseDatetime = str69;
        this.TimedAuctionCloseDateTime = str70;
        this.BuyNowIndicator = str71;
        this.InteriorColor = str72;
        this.ExteriorColor = str73;
        this.AdminBranch = str74;
        this.VehicleState = str75;
        this.StartDesc = str76;
        this.Key = str77;
        this.Airbag = str78;
        this.SecondaryDamage = str15;
        this.CountryOfOrigin = str16;
        this.PrimaryDamage = str17;
        this.CatIndicator = bool3;
        this.SellerType = str18;
        this.PrebidType = str19;
        this.StockAvailable = str20;
        this.IBNSold = str21;
        this.SalesListURL = str22;
        this.LaneAndItemNumber = str23;
        this.MaskedVIN = str24;
        this.MaskedSeller = str25;
        this.Distance = str26;
        this.StorageLocationName = str27;
        this.StorageLocation = str28;
        this.SaleDocumentBrand = str29;
        this.RestraintSystem = str30;
        this.EngineSize = str31;
        this.Engine = str32;
        this.CheckDigit = str33;
        this.TitleState = str34;
        this.TBOIndicator = bool4;
        this.ACV = num3;
        this.VehicleClass = str35;
        this.BidLive = str36;
        this.FuelType = str37;
        this.SaleDocument = str38;
        this.BranchNumber = num4;
        this.Availability = str39;
        this.LossType = str40;
        this.VIN = str41;
        this.OdoBrand = str42;
        this.Odometer = str43;
        this.Title = str44;
        this.Model = str45;
        this.BranchName = str46;
        this.Make = str47;
        this.ItemNumber = str48;
        this.Year = num5;
        this.AuctionLane = str49;
        this.Stockno = str50;
        this.Tenant = str51;
        this.ItemId = num6;
        this.InventoryID = str52;
        this.f504Id = i;
        this.VehicleTypeId = num7;
        this.Cylinders = str53;
        this.TimeZone = str54;
        this.Latitude = d;
        this.Transmission = str55;
        this.VehicleSubtype = str56;
        this.VehicleType = str57;
        this.StorageLocationId = num8;
        this.OffSiteSaleIndicator = bool5;
        this.RunAndDrive = z3;
        this.SalvageId = num9;
        this.DriveLineType = str58;
        this.Longitude = d2;
        this.SellerName = str59;
        this.BodyStyleName = str60;
        this.ItemImageId = num10;
        this.CloseDateTime = str61;
        this.LiveDateTime = str62;
        this.LiveDate = str63;
        this.TZAdjust = num11;
        this.ItemvalAuction = bool6;
        this.BranchvalAuction = bool7;
        this.DisplaySeller = bool8;
        this.PublicVehicle = z4;
        this.TimedAuctionCloseTimeCST = str64;
    }

    @NotNull
    public final String getImageUrl() {
        return this.ImageUrl;
    }

    public final boolean isWatchable() {
        return this.isWatchable;
    }

    public final boolean isWatching() {
        return this.isWatching;
    }

    @Nullable
    public final Boolean getTimedAuctionIndicator() {
        return this.TimedAuctionIndicator;
    }

    @NotNull
    public final String getPromotions() {
        return this.Promotions;
    }

    @NotNull
    public final String getSeries() {
        return this.Series;
    }

    @Nullable
    public final Boolean getValVehicle() {
        return this.valVehicle;
    }

    @NotNull
    public final String getDriveLineTypeDesc() {
        return this.DriveLineTypeDesc;
    }

    @Nullable
    public final Integer getLongValue() {
        return this.LongValue;
    }

    @Nullable
    public final Integer getLatValue() {
        return this.LatValue;
    }

    @NotNull
    public final String getBuyNowCloseDatetime() {
        return this.BuyNowCloseDatetime;
    }

    @NotNull
    public final String getTimedAuctionCloseDateTime() {
        return this.TimedAuctionCloseDateTime;
    }

    @NotNull
    public final String getBuyNowIndicator() {
        return this.BuyNowIndicator;
    }

    @NotNull
    public final String getInteriorColor() {
        return this.InteriorColor;
    }

    @NotNull
    public final String getExteriorColor() {
        return this.ExteriorColor;
    }

    @NotNull
    public final String getAdminBranch() {
        return this.AdminBranch;
    }

    @NotNull
    public final String getVehicleState() {
        return this.VehicleState;
    }

    @NotNull
    public final String getStartDesc() {
        return this.StartDesc;
    }

    @NotNull
    public final String getKey() {
        return this.Key;
    }

    @NotNull
    public final String getAirbag() {
        return this.Airbag;
    }

    @NotNull
    public final String getSecondaryDamage() {
        return this.SecondaryDamage;
    }

    @NotNull
    public final String getCountryOfOrigin() {
        return this.CountryOfOrigin;
    }

    @NotNull
    public final String getPrimaryDamage() {
        return this.PrimaryDamage;
    }

    @Nullable
    public final Boolean getCatIndicator() {
        return this.CatIndicator;
    }

    @NotNull
    public final String getSellerType() {
        return this.SellerType;
    }

    @NotNull
    public final String getPrebidType() {
        return this.PrebidType;
    }

    @NotNull
    public final String getStockAvailable() {
        return this.StockAvailable;
    }

    @NotNull
    public final String getIBNSold() {
        return this.IBNSold;
    }

    @NotNull
    public final String getSalesListURL() {
        return this.SalesListURL;
    }

    @NotNull
    public final String getLaneAndItemNumber() {
        return this.LaneAndItemNumber;
    }

    @NotNull
    public final String getMaskedVIN() {
        return this.MaskedVIN;
    }

    @NotNull
    public final String getMaskedSeller() {
        return this.MaskedSeller;
    }

    @NotNull
    public final String getDistance() {
        return this.Distance;
    }

    @NotNull
    public final String getStorageLocationName() {
        return this.StorageLocationName;
    }

    @NotNull
    public final String getStorageLocation() {
        return this.StorageLocation;
    }

    @NotNull
    public final String getSaleDocumentBrand() {
        return this.SaleDocumentBrand;
    }

    @NotNull
    public final String getRestraintSystem() {
        return this.RestraintSystem;
    }

    @NotNull
    public final String getEngineSize() {
        return this.EngineSize;
    }

    @NotNull
    public final String getEngine() {
        return this.Engine;
    }

    @NotNull
    public final String getCheckDigit() {
        return this.CheckDigit;
    }

    @NotNull
    public final String getTitleState() {
        return this.TitleState;
    }

    @Nullable
    public final Boolean getTBOIndicator() {
        return this.TBOIndicator;
    }

    @Nullable
    public final Integer getACV() {
        return this.ACV;
    }

    @NotNull
    public final String getVehicleClass() {
        return this.VehicleClass;
    }

    @NotNull
    public final String getBidLive() {
        return this.BidLive;
    }

    @NotNull
    public final String getFuelType() {
        return this.FuelType;
    }

    @NotNull
    public final String getSaleDocument() {
        return this.SaleDocument;
    }

    @Nullable
    public final Integer getBranchNumber() {
        return this.BranchNumber;
    }

    @NotNull
    public final String getAvailability() {
        return this.Availability;
    }

    @NotNull
    public final String getLossType() {
        return this.LossType;
    }

    @NotNull
    public final String getVIN() {
        return this.VIN;
    }

    @NotNull
    public final String getOdoBrand() {
        return this.OdoBrand;
    }

    @NotNull
    public final String getOdometer() {
        return this.Odometer;
    }

    @NotNull
    public final String getTitle() {
        return this.Title;
    }

    @NotNull
    public final String getModel() {
        return this.Model;
    }

    @NotNull
    public final String getBranchName() {
        return this.BranchName;
    }

    @NotNull
    public final String getMake() {
        return this.Make;
    }

    @NotNull
    public final String getItemNumber() {
        return this.ItemNumber;
    }

    @Nullable
    public final Integer getYear() {
        return this.Year;
    }

    @NotNull
    public final String getAuctionLane() {
        return this.AuctionLane;
    }

    @NotNull
    public final String getStockno() {
        return this.Stockno;
    }

    @NotNull
    public final String getTenant() {
        return this.Tenant;
    }

    @Nullable
    public final Integer getItemId() {
        return this.ItemId;
    }

    @NotNull
    public final String getInventoryID() {
        return this.InventoryID;
    }

    public final int getId() {
        return this.f504Id;
    }

    @Nullable
    public final Integer getVehicleTypeId() {
        return this.VehicleTypeId;
    }

    @NotNull
    public final String getCylinders() {
        return this.Cylinders;
    }

    @NotNull
    public final String getTimeZone() {
        return this.TimeZone;
    }

    @Nullable
    public final Double getLatitude() {
        return this.Latitude;
    }

    @NotNull
    public final String getTransmission() {
        return this.Transmission;
    }

    @NotNull
    public final String getVehicleSubtype() {
        return this.VehicleSubtype;
    }

    @NotNull
    public final String getVehicleType() {
        return this.VehicleType;
    }

    @Nullable
    public final Integer getStorageLocationId() {
        return this.StorageLocationId;
    }

    @Nullable
    public final Boolean getOffSiteSaleIndicator() {
        return this.OffSiteSaleIndicator;
    }

    public final boolean getRunAndDrive() {
        return this.RunAndDrive;
    }

    @Nullable
    public final Integer getSalvageId() {
        return this.SalvageId;
    }

    @NotNull
    public final String getDriveLineType() {
        return this.DriveLineType;
    }

    @Nullable
    public final Double getLongitude() {
        return this.Longitude;
    }

    @NotNull
    public final String getSellerName() {
        return this.SellerName;
    }

    @NotNull
    public final String getBodyStyleName() {
        return this.BodyStyleName;
    }

    @Nullable
    public final Integer getItemImageId() {
        return this.ItemImageId;
    }

    @Nullable
    public final String getCloseDateTime() {
        return this.CloseDateTime;
    }

    @NotNull
    public final String getLiveDateTime() {
        return this.LiveDateTime;
    }

    @NotNull
    public final String getLiveDate() {
        return this.LiveDate;
    }

    @Nullable
    public final Integer getTZAdjust() {
        return this.TZAdjust;
    }

    @Nullable
    public final Boolean getItemvalAuction() {
        return this.ItemvalAuction;
    }

    @Nullable
    public final Boolean getBranchvalAuction() {
        return this.BranchvalAuction;
    }

    @Nullable
    public final Boolean getDisplaySeller() {
        return this.DisplaySeller;
    }

    public final boolean getPublicVehicle() {
        return this.PublicVehicle;
    }

    @Nullable
    public final String getTimedAuctionCloseTimeCST() {
        return this.TimedAuctionCloseTimeCST;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDIFF_CALLBACK", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FormattedResult.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<FormattedResult> getDIFF_CALLBACK() {
            return FormattedResult.DIFF_CALLBACK;
        }

        public final void setDIFF_CALLBACK(@NotNull DiffUtil.ItemCallback<FormattedResult> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            FormattedResult.DIFF_CALLBACK = itemCallback;
        }
    }
}
