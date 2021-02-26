package com.iaai.android.bdt.model.fastSearchFilter2;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C1119C;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0003\bä\u0001\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÝ\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010=\u001a\u00020\u0003\u0012\u0006\u0010>\u001a\u00020\u0003\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\u0006\u0010@\u001a\u00020\u0003\u0012\u0006\u0010A\u001a\u00020\u0003\u0012\u0006\u0010B\u001a\u00020\u0003\u0012\u0006\u0010C\u001a\u00020\u0003\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\u0003\u0012\u0006\u0010F\u001a\u00020\u0003\u0012\u0006\u0010G\u001a\u00020\u0003\u0012\u0006\u0010H\u001a\u00020\u0003\u0012\u0006\u0010I\u001a\u00020\u0003\u0012\u0006\u0010J\u001a\u00020\u0003\u0012\u0006\u0010K\u001a\u00020\u0003\u0012\u0006\u0010L\u001a\u00020\u0003\u0012\u0006\u0010M\u001a\u00020\u0003¢\u0006\u0002\u0010NJ\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010À\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ý\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Þ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010á\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010â\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ã\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ä\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010å\u0001\u001a\u00020\u0003HÆ\u0003Jø\u0005\u0010æ\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\u00032\b\b\u0002\u0010=\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00032\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u00032\b\b\u0002\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00032\b\b\u0002\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020\u00032\b\b\u0002\u0010M\u001a\u00020\u0003HÆ\u0001J\u0016\u0010ç\u0001\u001a\u00030è\u00012\t\u0010é\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010ê\u0001\u001a\u00030ë\u0001HÖ\u0001J\n\u0010ì\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010PR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010PR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010PR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010PR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010PR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010PR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010PR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010PR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010PR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010PR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010PR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010PR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010PR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010PR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010PR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010PR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010PR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010PR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010PR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bd\u0010PR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u0010PR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010PR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010PR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bh\u0010PR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bi\u0010PR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010PR\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010PR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010PR\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010PR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010PR\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bo\u0010PR\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010PR\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010PR\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\br\u0010PR\u0011\u0010&\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bs\u0010PR\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bt\u0010PR\u0011\u0010(\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bu\u0010PR\u0011\u0010)\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bv\u0010PR\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bw\u0010PR\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010PR\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010PR\u0011\u0010-\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bz\u0010PR\u0011\u0010.\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010PR\u0011\u0010/\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b|\u0010PR\u0011\u00100\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010PR\u0011\u00101\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b~\u0010PR\u0011\u00102\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010PR\u0012\u00103\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00104\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00105\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00106\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00107\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00108\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u00109\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010:\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010;\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010<\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010=\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010>\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010?\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010@\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010A\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010B\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010C\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010D\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010E\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010F\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010G\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010H\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010I\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010J\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010K\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010L\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010PR\u0012\u0010M\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010P¨\u0006í\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/Data;", "", "ACV", "", "AdminBranch", "Airbag", "AuctionLane", "Availability", "BodyStyleName", "BranchName", "BranchNumber", "BranchPublicAuction", "BuyNowCloseDatetime", "BuyNowIndicator", "CatIndicator", "CheckDigit", "CloseDateTime", "CountryOfOrigin", "Cylinders", "DisplaySeller", "DriveLineType", "DriveLineTypeDesc", "Engine", "EngineSize", "ExteriorColor", "ExternalVehicleId", "FuelType", "InteriorColor", "InventoryID", "ItemId", "ItemImageId", "ItemNumber", "ItemPublicAuction", "Key", "LatValue", "Latitude", "LiveDate", "LiveDateTime", "LongValue", "Longitude", "LossType", "Make", "Model", "OdoBrand", "Odometer", "OffSiteSaleIndicator", "PrimaryDamage", "Promotions", "PublicVehicle", "RestraintSystem", "RunAndDrive", "SaleDocument", "SaleDocumentBrand", "SecondaryDamage", "SellerName", "SellerType", "Series", "StartDesc", "Stockno", "StorageLocation", "StorageLocationId", "StorageLocationName", "TBOIndicator", "TZAdjust", "Tenant", "TimeZone", "TimedAuctionCloseDateTime", "TimedAuctionIndicator", "Title", "TitleState", "Transmission", "VIN", "VehicleClass", "VehicleState", "VehicleSubtype", "VehicleType", "VehicleTypeId", "Year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getACV", "()Ljava/lang/String;", "getAdminBranch", "getAirbag", "getAuctionLane", "getAvailability", "getBodyStyleName", "getBranchName", "getBranchNumber", "getBranchPublicAuction", "getBuyNowCloseDatetime", "getBuyNowIndicator", "getCatIndicator", "getCheckDigit", "getCloseDateTime", "getCountryOfOrigin", "getCylinders", "getDisplaySeller", "getDriveLineType", "getDriveLineTypeDesc", "getEngine", "getEngineSize", "getExteriorColor", "getExternalVehicleId", "getFuelType", "getInteriorColor", "getInventoryID", "getItemId", "getItemImageId", "getItemNumber", "getItemPublicAuction", "getKey", "getLatValue", "getLatitude", "getLiveDate", "getLiveDateTime", "getLongValue", "getLongitude", "getLossType", "getMake", "getModel", "getOdoBrand", "getOdometer", "getOffSiteSaleIndicator", "getPrimaryDamage", "getPromotions", "getPublicVehicle", "getRestraintSystem", "getRunAndDrive", "getSaleDocument", "getSaleDocumentBrand", "getSecondaryDamage", "getSellerName", "getSellerType", "getSeries", "getStartDesc", "getStockno", "getStorageLocation", "getStorageLocationId", "getStorageLocationName", "getTBOIndicator", "getTZAdjust", "getTenant", "getTimeZone", "getTimedAuctionCloseDateTime", "getTimedAuctionIndicator", "getTitle", "getTitleState", "getTransmission", "getVIN", "getVehicleClass", "getVehicleState", "getVehicleSubtype", "getVehicleType", "getVehicleTypeId", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Data.kt */
public final class Data {
    @NotNull
    private final String ACV;
    @NotNull
    private final String AdminBranch;
    @NotNull
    private final String Airbag;
    @NotNull
    private final String AuctionLane;
    @NotNull
    private final String Availability;
    @NotNull
    private final String BodyStyleName;
    @NotNull
    private final String BranchName;
    @NotNull
    private final String BranchNumber;
    @NotNull
    private final String BranchPublicAuction;
    @NotNull
    private final String BuyNowCloseDatetime;
    @NotNull
    private final String BuyNowIndicator;
    @NotNull
    private final String CatIndicator;
    @NotNull
    private final String CheckDigit;
    @NotNull
    private final String CloseDateTime;
    @NotNull
    private final String CountryOfOrigin;
    @NotNull
    private final String Cylinders;
    @NotNull
    private final String DisplaySeller;
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
    private final String ExternalVehicleId;
    @NotNull
    private final String FuelType;
    @NotNull
    private final String InteriorColor;
    @NotNull
    private final String InventoryID;
    @NotNull
    private final String ItemId;
    @NotNull
    private final String ItemImageId;
    @NotNull
    private final String ItemNumber;
    @NotNull
    private final String ItemPublicAuction;
    @NotNull
    private final String Key;
    @NotNull
    private final String LatValue;
    @NotNull
    private final String Latitude;
    @NotNull
    private final String LiveDate;
    @NotNull
    private final String LiveDateTime;
    @NotNull
    private final String LongValue;
    @NotNull
    private final String Longitude;
    @NotNull
    private final String LossType;
    @NotNull
    private final String Make;
    @NotNull
    private final String Model;
    @NotNull
    private final String OdoBrand;
    @NotNull
    private final String Odometer;
    @NotNull
    private final String OffSiteSaleIndicator;
    @NotNull
    private final String PrimaryDamage;
    @NotNull
    private final String Promotions;
    @NotNull
    private final String PublicVehicle;
    @NotNull
    private final String RestraintSystem;
    @NotNull
    private final String RunAndDrive;
    @NotNull
    private final String SaleDocument;
    @NotNull
    private final String SaleDocumentBrand;
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
    private final String Stockno;
    @NotNull
    private final String StorageLocation;
    @NotNull
    private final String StorageLocationId;
    @NotNull
    private final String StorageLocationName;
    @NotNull
    private final String TBOIndicator;
    @NotNull
    private final String TZAdjust;
    @NotNull
    private final String Tenant;
    @NotNull
    private final String TimeZone;
    @NotNull
    private final String TimedAuctionCloseDateTime;
    @NotNull
    private final String TimedAuctionIndicator;
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
    @NotNull
    private final String VehicleTypeId;
    @NotNull
    private final String Year;

    @NotNull
    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, String str59, String str60, String str61, String str62, String str63, String str64, String str65, String str66, String str67, String str68, String str69, String str70, String str71, String str72, String str73, String str74, String str75, int i, int i2, int i3, Object obj) {
        String str76;
        String str77;
        String str78;
        String str79;
        String str80;
        String str81;
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
        String str130;
        String str131;
        String str132;
        String str133;
        String str134;
        String str135;
        String str136;
        String str137;
        String str138;
        String str139;
        String str140;
        String str141;
        String str142;
        String str143;
        String str144;
        String str145;
        String str146;
        String str147;
        String str148;
        String str149;
        String str150;
        String str151;
        String str152;
        String str153;
        String str154;
        String str155;
        String str156;
        String str157;
        String str158;
        String str159;
        String str160;
        String str161;
        String str162;
        String str163;
        String str164;
        String str165;
        String str166;
        String str167;
        Data data2 = data;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        String str168 = (i4 & 1) != 0 ? data2.ACV : str;
        String str169 = (i4 & 2) != 0 ? data2.AdminBranch : str2;
        String str170 = (i4 & 4) != 0 ? data2.Airbag : str3;
        String str171 = (i4 & 8) != 0 ? data2.AuctionLane : str4;
        String str172 = (i4 & 16) != 0 ? data2.Availability : str5;
        String str173 = (i4 & 32) != 0 ? data2.BodyStyleName : str6;
        String str174 = (i4 & 64) != 0 ? data2.BranchName : str7;
        String str175 = (i4 & 128) != 0 ? data2.BranchNumber : str8;
        String str176 = (i4 & 256) != 0 ? data2.BranchPublicAuction : str9;
        String str177 = (i4 & 512) != 0 ? data2.BuyNowCloseDatetime : str10;
        String str178 = (i4 & 1024) != 0 ? data2.BuyNowIndicator : str11;
        String str179 = (i4 & 2048) != 0 ? data2.CatIndicator : str12;
        String str180 = (i4 & 4096) != 0 ? data2.CheckDigit : str13;
        String str181 = (i4 & 8192) != 0 ? data2.CloseDateTime : str14;
        String str182 = (i4 & 16384) != 0 ? data2.CountryOfOrigin : str15;
        if ((i4 & 32768) != 0) {
            str76 = str182;
            str77 = data2.Cylinders;
        } else {
            str76 = str182;
            str77 = str16;
        }
        if ((i4 & 65536) != 0) {
            str78 = str77;
            str79 = data2.DisplaySeller;
        } else {
            str78 = str77;
            str79 = str17;
        }
        if ((i4 & 131072) != 0) {
            str80 = str79;
            str81 = data2.DriveLineType;
        } else {
            str80 = str79;
            str81 = str18;
        }
        if ((i4 & 262144) != 0) {
            str82 = str81;
            str83 = data2.DriveLineTypeDesc;
        } else {
            str82 = str81;
            str83 = str19;
        }
        if ((i4 & 524288) != 0) {
            str84 = str83;
            str85 = data2.Engine;
        } else {
            str84 = str83;
            str85 = str20;
        }
        if ((i4 & 1048576) != 0) {
            str86 = str85;
            str87 = data2.EngineSize;
        } else {
            str86 = str85;
            str87 = str21;
        }
        if ((i4 & 2097152) != 0) {
            str88 = str87;
            str89 = data2.ExteriorColor;
        } else {
            str88 = str87;
            str89 = str22;
        }
        if ((i4 & 4194304) != 0) {
            str90 = str89;
            str91 = data2.ExternalVehicleId;
        } else {
            str90 = str89;
            str91 = str23;
        }
        if ((i4 & 8388608) != 0) {
            str92 = str91;
            str93 = data2.FuelType;
        } else {
            str92 = str91;
            str93 = str24;
        }
        if ((i4 & 16777216) != 0) {
            str94 = str93;
            str95 = data2.InteriorColor;
        } else {
            str94 = str93;
            str95 = str25;
        }
        if ((i4 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str96 = str95;
            str97 = data2.InventoryID;
        } else {
            str96 = str95;
            str97 = str26;
        }
        if ((i4 & 67108864) != 0) {
            str98 = str97;
            str99 = data2.ItemId;
        } else {
            str98 = str97;
            str99 = str27;
        }
        if ((i4 & 134217728) != 0) {
            str100 = str99;
            str101 = data2.ItemImageId;
        } else {
            str100 = str99;
            str101 = str28;
        }
        if ((i4 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str102 = str101;
            str103 = data2.ItemNumber;
        } else {
            str102 = str101;
            str103 = str29;
        }
        if ((i4 & 536870912) != 0) {
            str104 = str103;
            str105 = data2.ItemPublicAuction;
        } else {
            str104 = str103;
            str105 = str30;
        }
        if ((i4 & 1073741824) != 0) {
            str106 = str105;
            str107 = data2.Key;
        } else {
            str106 = str105;
            str107 = str31;
        }
        String str183 = (i4 & Integer.MIN_VALUE) != 0 ? data2.LatValue : str32;
        if ((i5 & 1) != 0) {
            str108 = str183;
            str109 = data2.Latitude;
        } else {
            str108 = str183;
            str109 = str33;
        }
        if ((i5 & 2) != 0) {
            str110 = str109;
            str111 = data2.LiveDate;
        } else {
            str110 = str109;
            str111 = str34;
        }
        if ((i5 & 4) != 0) {
            str112 = str111;
            str113 = data2.LiveDateTime;
        } else {
            str112 = str111;
            str113 = str35;
        }
        if ((i5 & 8) != 0) {
            str114 = str113;
            str115 = data2.LongValue;
        } else {
            str114 = str113;
            str115 = str36;
        }
        if ((i5 & 16) != 0) {
            str116 = str115;
            str117 = data2.Longitude;
        } else {
            str116 = str115;
            str117 = str37;
        }
        if ((i5 & 32) != 0) {
            str118 = str117;
            str119 = data2.LossType;
        } else {
            str118 = str117;
            str119 = str38;
        }
        if ((i5 & 64) != 0) {
            str120 = str119;
            str121 = data2.Make;
        } else {
            str120 = str119;
            str121 = str39;
        }
        String str184 = str121;
        String str185 = (i5 & 128) != 0 ? data2.Model : str40;
        String str186 = (i5 & 256) != 0 ? data2.OdoBrand : str41;
        String str187 = (i5 & 512) != 0 ? data2.Odometer : str42;
        String str188 = (i5 & 1024) != 0 ? data2.OffSiteSaleIndicator : str43;
        String str189 = (i5 & 2048) != 0 ? data2.PrimaryDamage : str44;
        String str190 = (i5 & 4096) != 0 ? data2.Promotions : str45;
        String str191 = (i5 & 8192) != 0 ? data2.PublicVehicle : str46;
        String str192 = (i5 & 16384) != 0 ? data2.RestraintSystem : str47;
        if ((i5 & 32768) != 0) {
            str122 = str192;
            str123 = data2.RunAndDrive;
        } else {
            str122 = str192;
            str123 = str48;
        }
        if ((i5 & 65536) != 0) {
            str124 = str123;
            str125 = data2.SaleDocument;
        } else {
            str124 = str123;
            str125 = str49;
        }
        if ((i5 & 131072) != 0) {
            str126 = str125;
            str127 = data2.SaleDocumentBrand;
        } else {
            str126 = str125;
            str127 = str50;
        }
        if ((i5 & 262144) != 0) {
            str128 = str127;
            str129 = data2.SecondaryDamage;
        } else {
            str128 = str127;
            str129 = str51;
        }
        if ((i5 & 524288) != 0) {
            str130 = str129;
            str131 = data2.SellerName;
        } else {
            str130 = str129;
            str131 = str52;
        }
        if ((i5 & 1048576) != 0) {
            str132 = str131;
            str133 = data2.SellerType;
        } else {
            str132 = str131;
            str133 = str53;
        }
        if ((i5 & 2097152) != 0) {
            str134 = str133;
            str135 = data2.Series;
        } else {
            str134 = str133;
            str135 = str54;
        }
        if ((i5 & 4194304) != 0) {
            str136 = str135;
            str137 = data2.StartDesc;
        } else {
            str136 = str135;
            str137 = str55;
        }
        if ((i5 & 8388608) != 0) {
            str138 = str137;
            str139 = data2.Stockno;
        } else {
            str138 = str137;
            str139 = str56;
        }
        if ((i5 & 16777216) != 0) {
            str140 = str139;
            str141 = data2.StorageLocation;
        } else {
            str140 = str139;
            str141 = str57;
        }
        if ((i5 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str142 = str141;
            str143 = data2.StorageLocationId;
        } else {
            str142 = str141;
            str143 = str58;
        }
        if ((i5 & 67108864) != 0) {
            str144 = str143;
            str145 = data2.StorageLocationName;
        } else {
            str144 = str143;
            str145 = str59;
        }
        if ((i5 & 134217728) != 0) {
            str146 = str145;
            str147 = data2.TBOIndicator;
        } else {
            str146 = str145;
            str147 = str60;
        }
        if ((i5 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str148 = str147;
            str149 = data2.TZAdjust;
        } else {
            str148 = str147;
            str149 = str61;
        }
        if ((i5 & 536870912) != 0) {
            str150 = str149;
            str151 = data2.Tenant;
        } else {
            str150 = str149;
            str151 = str62;
        }
        if ((i5 & 1073741824) != 0) {
            str152 = str151;
            str153 = data2.TimeZone;
        } else {
            str152 = str151;
            str153 = str63;
        }
        String str193 = (i5 & Integer.MIN_VALUE) != 0 ? data2.TimedAuctionCloseDateTime : str64;
        if ((i6 & 1) != 0) {
            str154 = str193;
            str155 = data2.TimedAuctionIndicator;
        } else {
            str154 = str193;
            str155 = str65;
        }
        if ((i6 & 2) != 0) {
            str156 = str155;
            str157 = data2.Title;
        } else {
            str156 = str155;
            str157 = str66;
        }
        if ((i6 & 4) != 0) {
            str158 = str157;
            str159 = data2.TitleState;
        } else {
            str158 = str157;
            str159 = str67;
        }
        if ((i6 & 8) != 0) {
            str160 = str159;
            str161 = data2.Transmission;
        } else {
            str160 = str159;
            str161 = str68;
        }
        if ((i6 & 16) != 0) {
            str162 = str161;
            str163 = data2.VIN;
        } else {
            str162 = str161;
            str163 = str69;
        }
        if ((i6 & 32) != 0) {
            str164 = str163;
            str165 = data2.VehicleClass;
        } else {
            str164 = str163;
            str165 = str70;
        }
        if ((i6 & 64) != 0) {
            str166 = str165;
            str167 = data2.VehicleState;
        } else {
            str166 = str165;
            str167 = str71;
        }
        return data.copy(str168, str169, str170, str171, str172, str173, str174, str175, str176, str177, str178, str179, str180, str181, str76, str78, str80, str82, str84, str86, str88, str90, str92, str94, str96, str98, str100, str102, str104, str106, str107, str108, str110, str112, str114, str116, str118, str120, str184, str185, str186, str187, str188, str189, str190, str191, str122, str124, str126, str128, str130, str132, str134, str136, str138, str140, str142, str144, str146, str148, str150, str152, str153, str154, str156, str158, str160, str162, str164, str166, str167, (i6 & 128) != 0 ? data2.VehicleSubtype : str72, (i6 & 256) != 0 ? data2.VehicleType : str73, (i6 & 512) != 0 ? data2.VehicleTypeId : str74, (i6 & 1024) != 0 ? data2.Year : str75);
    }

    @NotNull
    public final String component1() {
        return this.ACV;
    }

    @NotNull
    public final String component10() {
        return this.BuyNowCloseDatetime;
    }

    @NotNull
    public final String component11() {
        return this.BuyNowIndicator;
    }

    @NotNull
    public final String component12() {
        return this.CatIndicator;
    }

    @NotNull
    public final String component13() {
        return this.CheckDigit;
    }

    @NotNull
    public final String component14() {
        return this.CloseDateTime;
    }

    @NotNull
    public final String component15() {
        return this.CountryOfOrigin;
    }

    @NotNull
    public final String component16() {
        return this.Cylinders;
    }

    @NotNull
    public final String component17() {
        return this.DisplaySeller;
    }

    @NotNull
    public final String component18() {
        return this.DriveLineType;
    }

    @NotNull
    public final String component19() {
        return this.DriveLineTypeDesc;
    }

    @NotNull
    public final String component2() {
        return this.AdminBranch;
    }

    @NotNull
    public final String component20() {
        return this.Engine;
    }

    @NotNull
    public final String component21() {
        return this.EngineSize;
    }

    @NotNull
    public final String component22() {
        return this.ExteriorColor;
    }

    @NotNull
    public final String component23() {
        return this.ExternalVehicleId;
    }

    @NotNull
    public final String component24() {
        return this.FuelType;
    }

    @NotNull
    public final String component25() {
        return this.InteriorColor;
    }

    @NotNull
    public final String component26() {
        return this.InventoryID;
    }

    @NotNull
    public final String component27() {
        return this.ItemId;
    }

    @NotNull
    public final String component28() {
        return this.ItemImageId;
    }

    @NotNull
    public final String component29() {
        return this.ItemNumber;
    }

    @NotNull
    public final String component3() {
        return this.Airbag;
    }

    @NotNull
    public final String component30() {
        return this.ItemPublicAuction;
    }

    @NotNull
    public final String component31() {
        return this.Key;
    }

    @NotNull
    public final String component32() {
        return this.LatValue;
    }

    @NotNull
    public final String component33() {
        return this.Latitude;
    }

    @NotNull
    public final String component34() {
        return this.LiveDate;
    }

    @NotNull
    public final String component35() {
        return this.LiveDateTime;
    }

    @NotNull
    public final String component36() {
        return this.LongValue;
    }

    @NotNull
    public final String component37() {
        return this.Longitude;
    }

    @NotNull
    public final String component38() {
        return this.LossType;
    }

    @NotNull
    public final String component39() {
        return this.Make;
    }

    @NotNull
    public final String component4() {
        return this.AuctionLane;
    }

    @NotNull
    public final String component40() {
        return this.Model;
    }

    @NotNull
    public final String component41() {
        return this.OdoBrand;
    }

    @NotNull
    public final String component42() {
        return this.Odometer;
    }

    @NotNull
    public final String component43() {
        return this.OffSiteSaleIndicator;
    }

    @NotNull
    public final String component44() {
        return this.PrimaryDamage;
    }

    @NotNull
    public final String component45() {
        return this.Promotions;
    }

    @NotNull
    public final String component46() {
        return this.PublicVehicle;
    }

    @NotNull
    public final String component47() {
        return this.RestraintSystem;
    }

    @NotNull
    public final String component48() {
        return this.RunAndDrive;
    }

    @NotNull
    public final String component49() {
        return this.SaleDocument;
    }

    @NotNull
    public final String component5() {
        return this.Availability;
    }

    @NotNull
    public final String component50() {
        return this.SaleDocumentBrand;
    }

    @NotNull
    public final String component51() {
        return this.SecondaryDamage;
    }

    @NotNull
    public final String component52() {
        return this.SellerName;
    }

    @NotNull
    public final String component53() {
        return this.SellerType;
    }

    @NotNull
    public final String component54() {
        return this.Series;
    }

    @NotNull
    public final String component55() {
        return this.StartDesc;
    }

    @NotNull
    public final String component56() {
        return this.Stockno;
    }

    @NotNull
    public final String component57() {
        return this.StorageLocation;
    }

    @NotNull
    public final String component58() {
        return this.StorageLocationId;
    }

    @NotNull
    public final String component59() {
        return this.StorageLocationName;
    }

    @NotNull
    public final String component6() {
        return this.BodyStyleName;
    }

    @NotNull
    public final String component60() {
        return this.TBOIndicator;
    }

    @NotNull
    public final String component61() {
        return this.TZAdjust;
    }

    @NotNull
    public final String component62() {
        return this.Tenant;
    }

    @NotNull
    public final String component63() {
        return this.TimeZone;
    }

    @NotNull
    public final String component64() {
        return this.TimedAuctionCloseDateTime;
    }

    @NotNull
    public final String component65() {
        return this.TimedAuctionIndicator;
    }

    @NotNull
    public final String component66() {
        return this.Title;
    }

    @NotNull
    public final String component67() {
        return this.TitleState;
    }

    @NotNull
    public final String component68() {
        return this.Transmission;
    }

    @NotNull
    public final String component69() {
        return this.VIN;
    }

    @NotNull
    public final String component7() {
        return this.BranchName;
    }

    @NotNull
    public final String component70() {
        return this.VehicleClass;
    }

    @NotNull
    public final String component71() {
        return this.VehicleState;
    }

    @NotNull
    public final String component72() {
        return this.VehicleSubtype;
    }

    @NotNull
    public final String component73() {
        return this.VehicleType;
    }

    @NotNull
    public final String component74() {
        return this.VehicleTypeId;
    }

    @NotNull
    public final String component75() {
        return this.Year;
    }

    @NotNull
    public final String component8() {
        return this.BranchNumber;
    }

    @NotNull
    public final String component9() {
        return this.BranchPublicAuction;
    }

    @NotNull
    public final Data copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, @NotNull String str23, @NotNull String str24, @NotNull String str25, @NotNull String str26, @NotNull String str27, @NotNull String str28, @NotNull String str29, @NotNull String str30, @NotNull String str31, @NotNull String str32, @NotNull String str33, @NotNull String str34, @NotNull String str35, @NotNull String str36, @NotNull String str37, @NotNull String str38, @NotNull String str39, @NotNull String str40, @NotNull String str41, @NotNull String str42, @NotNull String str43, @NotNull String str44, @NotNull String str45, @NotNull String str46, @NotNull String str47, @NotNull String str48, @NotNull String str49, @NotNull String str50, @NotNull String str51, @NotNull String str52, @NotNull String str53, @NotNull String str54, @NotNull String str55, @NotNull String str56, @NotNull String str57, @NotNull String str58, @NotNull String str59, @NotNull String str60, @NotNull String str61, @NotNull String str62, @NotNull String str63, @NotNull String str64, @NotNull String str65, @NotNull String str66, @NotNull String str67, @NotNull String str68, @NotNull String str69, @NotNull String str70, @NotNull String str71, @NotNull String str72, @NotNull String str73, @NotNull String str74, @NotNull String str75) {
        String str76 = str;
        Intrinsics.checkParameterIsNotNull(str76, "ACV");
        Intrinsics.checkParameterIsNotNull(str2, "AdminBranch");
        Intrinsics.checkParameterIsNotNull(str3, "Airbag");
        Intrinsics.checkParameterIsNotNull(str4, "AuctionLane");
        Intrinsics.checkParameterIsNotNull(str5, "Availability");
        Intrinsics.checkParameterIsNotNull(str6, "BodyStyleName");
        Intrinsics.checkParameterIsNotNull(str7, "BranchName");
        Intrinsics.checkParameterIsNotNull(str8, AnalyticsContract.Analytics.COLUMN_NAME_BRANCH_NO);
        Intrinsics.checkParameterIsNotNull(str9, "BranchPublicAuction");
        Intrinsics.checkParameterIsNotNull(str10, "BuyNowCloseDatetime");
        Intrinsics.checkParameterIsNotNull(str11, "BuyNowIndicator");
        Intrinsics.checkParameterIsNotNull(str12, "CatIndicator");
        Intrinsics.checkParameterIsNotNull(str13, "CheckDigit");
        Intrinsics.checkParameterIsNotNull(str14, "CloseDateTime");
        Intrinsics.checkParameterIsNotNull(str15, "CountryOfOrigin");
        Intrinsics.checkParameterIsNotNull(str16, "Cylinders");
        Intrinsics.checkParameterIsNotNull(str17, "DisplaySeller");
        Intrinsics.checkParameterIsNotNull(str18, "DriveLineType");
        Intrinsics.checkParameterIsNotNull(str19, "DriveLineTypeDesc");
        Intrinsics.checkParameterIsNotNull(str20, "Engine");
        Intrinsics.checkParameterIsNotNull(str21, "EngineSize");
        Intrinsics.checkParameterIsNotNull(str22, "ExteriorColor");
        Intrinsics.checkParameterIsNotNull(str23, "ExternalVehicleId");
        Intrinsics.checkParameterIsNotNull(str24, "FuelType");
        Intrinsics.checkParameterIsNotNull(str25, "InteriorColor");
        Intrinsics.checkParameterIsNotNull(str26, "InventoryID");
        Intrinsics.checkParameterIsNotNull(str27, "ItemId");
        Intrinsics.checkParameterIsNotNull(str28, "ItemImageId");
        Intrinsics.checkParameterIsNotNull(str29, "ItemNumber");
        Intrinsics.checkParameterIsNotNull(str30, "ItemPublicAuction");
        Intrinsics.checkParameterIsNotNull(str31, "Key");
        Intrinsics.checkParameterIsNotNull(str32, "LatValue");
        Intrinsics.checkParameterIsNotNull(str33, "Latitude");
        Intrinsics.checkParameterIsNotNull(str34, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str35, "LiveDateTime");
        Intrinsics.checkParameterIsNotNull(str36, "LongValue");
        Intrinsics.checkParameterIsNotNull(str37, "Longitude");
        Intrinsics.checkParameterIsNotNull(str38, "LossType");
        Intrinsics.checkParameterIsNotNull(str39, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str40, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str41, "OdoBrand");
        Intrinsics.checkParameterIsNotNull(str42, "Odometer");
        Intrinsics.checkParameterIsNotNull(str43, "OffSiteSaleIndicator");
        Intrinsics.checkParameterIsNotNull(str44, "PrimaryDamage");
        Intrinsics.checkParameterIsNotNull(str45, "Promotions");
        Intrinsics.checkParameterIsNotNull(str46, "PublicVehicle");
        Intrinsics.checkParameterIsNotNull(str47, "RestraintSystem");
        Intrinsics.checkParameterIsNotNull(str48, "RunAndDrive");
        Intrinsics.checkParameterIsNotNull(str49, "SaleDocument");
        Intrinsics.checkParameterIsNotNull(str50, "SaleDocumentBrand");
        Intrinsics.checkParameterIsNotNull(str51, "SecondaryDamage");
        Intrinsics.checkParameterIsNotNull(str52, "SellerName");
        Intrinsics.checkParameterIsNotNull(str53, "SellerType");
        Intrinsics.checkParameterIsNotNull(str54, "Series");
        Intrinsics.checkParameterIsNotNull(str55, "StartDesc");
        Intrinsics.checkParameterIsNotNull(str56, "Stockno");
        Intrinsics.checkParameterIsNotNull(str57, "StorageLocation");
        Intrinsics.checkParameterIsNotNull(str58, "StorageLocationId");
        Intrinsics.checkParameterIsNotNull(str59, "StorageLocationName");
        Intrinsics.checkParameterIsNotNull(str60, "TBOIndicator");
        Intrinsics.checkParameterIsNotNull(str61, "TZAdjust");
        Intrinsics.checkParameterIsNotNull(str62, "Tenant");
        Intrinsics.checkParameterIsNotNull(str63, "TimeZone");
        Intrinsics.checkParameterIsNotNull(str64, "TimedAuctionCloseDateTime");
        Intrinsics.checkParameterIsNotNull(str65, "TimedAuctionIndicator");
        Intrinsics.checkParameterIsNotNull(str66, "Title");
        Intrinsics.checkParameterIsNotNull(str67, "TitleState");
        Intrinsics.checkParameterIsNotNull(str68, "Transmission");
        Intrinsics.checkParameterIsNotNull(str69, "VIN");
        Intrinsics.checkParameterIsNotNull(str70, "VehicleClass");
        Intrinsics.checkParameterIsNotNull(str71, "VehicleState");
        Intrinsics.checkParameterIsNotNull(str72, "VehicleSubtype");
        Intrinsics.checkParameterIsNotNull(str73, "VehicleType");
        Intrinsics.checkParameterIsNotNull(str74, "VehicleTypeId");
        Intrinsics.checkParameterIsNotNull(str75, "Year");
        return new Data(str76, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, str51, str52, str53, str54, str55, str56, str57, str58, str59, str60, str61, str62, str63, str64, str65, str66, str67, str68, str69, str70, str71, str72, str73, str74, str75);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return Intrinsics.areEqual((Object) this.ACV, (Object) data.ACV) && Intrinsics.areEqual((Object) this.AdminBranch, (Object) data.AdminBranch) && Intrinsics.areEqual((Object) this.Airbag, (Object) data.Airbag) && Intrinsics.areEqual((Object) this.AuctionLane, (Object) data.AuctionLane) && Intrinsics.areEqual((Object) this.Availability, (Object) data.Availability) && Intrinsics.areEqual((Object) this.BodyStyleName, (Object) data.BodyStyleName) && Intrinsics.areEqual((Object) this.BranchName, (Object) data.BranchName) && Intrinsics.areEqual((Object) this.BranchNumber, (Object) data.BranchNumber) && Intrinsics.areEqual((Object) this.BranchPublicAuction, (Object) data.BranchPublicAuction) && Intrinsics.areEqual((Object) this.BuyNowCloseDatetime, (Object) data.BuyNowCloseDatetime) && Intrinsics.areEqual((Object) this.BuyNowIndicator, (Object) data.BuyNowIndicator) && Intrinsics.areEqual((Object) this.CatIndicator, (Object) data.CatIndicator) && Intrinsics.areEqual((Object) this.CheckDigit, (Object) data.CheckDigit) && Intrinsics.areEqual((Object) this.CloseDateTime, (Object) data.CloseDateTime) && Intrinsics.areEqual((Object) this.CountryOfOrigin, (Object) data.CountryOfOrigin) && Intrinsics.areEqual((Object) this.Cylinders, (Object) data.Cylinders) && Intrinsics.areEqual((Object) this.DisplaySeller, (Object) data.DisplaySeller) && Intrinsics.areEqual((Object) this.DriveLineType, (Object) data.DriveLineType) && Intrinsics.areEqual((Object) this.DriveLineTypeDesc, (Object) data.DriveLineTypeDesc) && Intrinsics.areEqual((Object) this.Engine, (Object) data.Engine) && Intrinsics.areEqual((Object) this.EngineSize, (Object) data.EngineSize) && Intrinsics.areEqual((Object) this.ExteriorColor, (Object) data.ExteriorColor) && Intrinsics.areEqual((Object) this.ExternalVehicleId, (Object) data.ExternalVehicleId) && Intrinsics.areEqual((Object) this.FuelType, (Object) data.FuelType) && Intrinsics.areEqual((Object) this.InteriorColor, (Object) data.InteriorColor) && Intrinsics.areEqual((Object) this.InventoryID, (Object) data.InventoryID) && Intrinsics.areEqual((Object) this.ItemId, (Object) data.ItemId) && Intrinsics.areEqual((Object) this.ItemImageId, (Object) data.ItemImageId) && Intrinsics.areEqual((Object) this.ItemNumber, (Object) data.ItemNumber) && Intrinsics.areEqual((Object) this.ItemPublicAuction, (Object) data.ItemPublicAuction) && Intrinsics.areEqual((Object) this.Key, (Object) data.Key) && Intrinsics.areEqual((Object) this.LatValue, (Object) data.LatValue) && Intrinsics.areEqual((Object) this.Latitude, (Object) data.Latitude) && Intrinsics.areEqual((Object) this.LiveDate, (Object) data.LiveDate) && Intrinsics.areEqual((Object) this.LiveDateTime, (Object) data.LiveDateTime) && Intrinsics.areEqual((Object) this.LongValue, (Object) data.LongValue) && Intrinsics.areEqual((Object) this.Longitude, (Object) data.Longitude) && Intrinsics.areEqual((Object) this.LossType, (Object) data.LossType) && Intrinsics.areEqual((Object) this.Make, (Object) data.Make) && Intrinsics.areEqual((Object) this.Model, (Object) data.Model) && Intrinsics.areEqual((Object) this.OdoBrand, (Object) data.OdoBrand) && Intrinsics.areEqual((Object) this.Odometer, (Object) data.Odometer) && Intrinsics.areEqual((Object) this.OffSiteSaleIndicator, (Object) data.OffSiteSaleIndicator) && Intrinsics.areEqual((Object) this.PrimaryDamage, (Object) data.PrimaryDamage) && Intrinsics.areEqual((Object) this.Promotions, (Object) data.Promotions) && Intrinsics.areEqual((Object) this.PublicVehicle, (Object) data.PublicVehicle) && Intrinsics.areEqual((Object) this.RestraintSystem, (Object) data.RestraintSystem) && Intrinsics.areEqual((Object) this.RunAndDrive, (Object) data.RunAndDrive) && Intrinsics.areEqual((Object) this.SaleDocument, (Object) data.SaleDocument) && Intrinsics.areEqual((Object) this.SaleDocumentBrand, (Object) data.SaleDocumentBrand) && Intrinsics.areEqual((Object) this.SecondaryDamage, (Object) data.SecondaryDamage) && Intrinsics.areEqual((Object) this.SellerName, (Object) data.SellerName) && Intrinsics.areEqual((Object) this.SellerType, (Object) data.SellerType) && Intrinsics.areEqual((Object) this.Series, (Object) data.Series) && Intrinsics.areEqual((Object) this.StartDesc, (Object) data.StartDesc) && Intrinsics.areEqual((Object) this.Stockno, (Object) data.Stockno) && Intrinsics.areEqual((Object) this.StorageLocation, (Object) data.StorageLocation) && Intrinsics.areEqual((Object) this.StorageLocationId, (Object) data.StorageLocationId) && Intrinsics.areEqual((Object) this.StorageLocationName, (Object) data.StorageLocationName) && Intrinsics.areEqual((Object) this.TBOIndicator, (Object) data.TBOIndicator) && Intrinsics.areEqual((Object) this.TZAdjust, (Object) data.TZAdjust) && Intrinsics.areEqual((Object) this.Tenant, (Object) data.Tenant) && Intrinsics.areEqual((Object) this.TimeZone, (Object) data.TimeZone) && Intrinsics.areEqual((Object) this.TimedAuctionCloseDateTime, (Object) data.TimedAuctionCloseDateTime) && Intrinsics.areEqual((Object) this.TimedAuctionIndicator, (Object) data.TimedAuctionIndicator) && Intrinsics.areEqual((Object) this.Title, (Object) data.Title) && Intrinsics.areEqual((Object) this.TitleState, (Object) data.TitleState) && Intrinsics.areEqual((Object) this.Transmission, (Object) data.Transmission) && Intrinsics.areEqual((Object) this.VIN, (Object) data.VIN) && Intrinsics.areEqual((Object) this.VehicleClass, (Object) data.VehicleClass) && Intrinsics.areEqual((Object) this.VehicleState, (Object) data.VehicleState) && Intrinsics.areEqual((Object) this.VehicleSubtype, (Object) data.VehicleSubtype) && Intrinsics.areEqual((Object) this.VehicleType, (Object) data.VehicleType) && Intrinsics.areEqual((Object) this.VehicleTypeId, (Object) data.VehicleTypeId) && Intrinsics.areEqual((Object) this.Year, (Object) data.Year);
    }

    public int hashCode() {
        String str = this.ACV;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.AdminBranch;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Airbag;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.AuctionLane;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.Availability;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.BodyStyleName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.BranchName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.BranchNumber;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.BranchPublicAuction;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.BuyNowCloseDatetime;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.BuyNowIndicator;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.CatIndicator;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.CheckDigit;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.CloseDateTime;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.CountryOfOrigin;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.Cylinders;
        int hashCode16 = (hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.DisplaySeller;
        int hashCode17 = (hashCode16 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.DriveLineType;
        int hashCode18 = (hashCode17 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.DriveLineTypeDesc;
        int hashCode19 = (hashCode18 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.Engine;
        int hashCode20 = (hashCode19 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.EngineSize;
        int hashCode21 = (hashCode20 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.ExteriorColor;
        int hashCode22 = (hashCode21 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.ExternalVehicleId;
        int hashCode23 = (hashCode22 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.FuelType;
        int hashCode24 = (hashCode23 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.InteriorColor;
        int hashCode25 = (hashCode24 + (str25 != null ? str25.hashCode() : 0)) * 31;
        String str26 = this.InventoryID;
        int hashCode26 = (hashCode25 + (str26 != null ? str26.hashCode() : 0)) * 31;
        String str27 = this.ItemId;
        int hashCode27 = (hashCode26 + (str27 != null ? str27.hashCode() : 0)) * 31;
        String str28 = this.ItemImageId;
        int hashCode28 = (hashCode27 + (str28 != null ? str28.hashCode() : 0)) * 31;
        String str29 = this.ItemNumber;
        int hashCode29 = (hashCode28 + (str29 != null ? str29.hashCode() : 0)) * 31;
        String str30 = this.ItemPublicAuction;
        int hashCode30 = (hashCode29 + (str30 != null ? str30.hashCode() : 0)) * 31;
        String str31 = this.Key;
        int hashCode31 = (hashCode30 + (str31 != null ? str31.hashCode() : 0)) * 31;
        String str32 = this.LatValue;
        int hashCode32 = (hashCode31 + (str32 != null ? str32.hashCode() : 0)) * 31;
        String str33 = this.Latitude;
        int hashCode33 = (hashCode32 + (str33 != null ? str33.hashCode() : 0)) * 31;
        String str34 = this.LiveDate;
        int hashCode34 = (hashCode33 + (str34 != null ? str34.hashCode() : 0)) * 31;
        String str35 = this.LiveDateTime;
        int hashCode35 = (hashCode34 + (str35 != null ? str35.hashCode() : 0)) * 31;
        String str36 = this.LongValue;
        int hashCode36 = (hashCode35 + (str36 != null ? str36.hashCode() : 0)) * 31;
        String str37 = this.Longitude;
        int hashCode37 = (hashCode36 + (str37 != null ? str37.hashCode() : 0)) * 31;
        String str38 = this.LossType;
        int hashCode38 = (hashCode37 + (str38 != null ? str38.hashCode() : 0)) * 31;
        String str39 = this.Make;
        int hashCode39 = (hashCode38 + (str39 != null ? str39.hashCode() : 0)) * 31;
        String str40 = this.Model;
        int hashCode40 = (hashCode39 + (str40 != null ? str40.hashCode() : 0)) * 31;
        String str41 = this.OdoBrand;
        int hashCode41 = (hashCode40 + (str41 != null ? str41.hashCode() : 0)) * 31;
        String str42 = this.Odometer;
        int hashCode42 = (hashCode41 + (str42 != null ? str42.hashCode() : 0)) * 31;
        String str43 = this.OffSiteSaleIndicator;
        int hashCode43 = (hashCode42 + (str43 != null ? str43.hashCode() : 0)) * 31;
        String str44 = this.PrimaryDamage;
        int hashCode44 = (hashCode43 + (str44 != null ? str44.hashCode() : 0)) * 31;
        String str45 = this.Promotions;
        int hashCode45 = (hashCode44 + (str45 != null ? str45.hashCode() : 0)) * 31;
        String str46 = this.PublicVehicle;
        int hashCode46 = (hashCode45 + (str46 != null ? str46.hashCode() : 0)) * 31;
        String str47 = this.RestraintSystem;
        int hashCode47 = (hashCode46 + (str47 != null ? str47.hashCode() : 0)) * 31;
        String str48 = this.RunAndDrive;
        int hashCode48 = (hashCode47 + (str48 != null ? str48.hashCode() : 0)) * 31;
        String str49 = this.SaleDocument;
        int hashCode49 = (hashCode48 + (str49 != null ? str49.hashCode() : 0)) * 31;
        String str50 = this.SaleDocumentBrand;
        int hashCode50 = (hashCode49 + (str50 != null ? str50.hashCode() : 0)) * 31;
        String str51 = this.SecondaryDamage;
        int hashCode51 = (hashCode50 + (str51 != null ? str51.hashCode() : 0)) * 31;
        String str52 = this.SellerName;
        int hashCode52 = (hashCode51 + (str52 != null ? str52.hashCode() : 0)) * 31;
        String str53 = this.SellerType;
        int hashCode53 = (hashCode52 + (str53 != null ? str53.hashCode() : 0)) * 31;
        String str54 = this.Series;
        int hashCode54 = (hashCode53 + (str54 != null ? str54.hashCode() : 0)) * 31;
        String str55 = this.StartDesc;
        int hashCode55 = (hashCode54 + (str55 != null ? str55.hashCode() : 0)) * 31;
        String str56 = this.Stockno;
        int hashCode56 = (hashCode55 + (str56 != null ? str56.hashCode() : 0)) * 31;
        String str57 = this.StorageLocation;
        int hashCode57 = (hashCode56 + (str57 != null ? str57.hashCode() : 0)) * 31;
        String str58 = this.StorageLocationId;
        int hashCode58 = (hashCode57 + (str58 != null ? str58.hashCode() : 0)) * 31;
        String str59 = this.StorageLocationName;
        int hashCode59 = (hashCode58 + (str59 != null ? str59.hashCode() : 0)) * 31;
        String str60 = this.TBOIndicator;
        int hashCode60 = (hashCode59 + (str60 != null ? str60.hashCode() : 0)) * 31;
        String str61 = this.TZAdjust;
        int hashCode61 = (hashCode60 + (str61 != null ? str61.hashCode() : 0)) * 31;
        String str62 = this.Tenant;
        int hashCode62 = (hashCode61 + (str62 != null ? str62.hashCode() : 0)) * 31;
        String str63 = this.TimeZone;
        int hashCode63 = (hashCode62 + (str63 != null ? str63.hashCode() : 0)) * 31;
        String str64 = this.TimedAuctionCloseDateTime;
        int hashCode64 = (hashCode63 + (str64 != null ? str64.hashCode() : 0)) * 31;
        String str65 = this.TimedAuctionIndicator;
        int hashCode65 = (hashCode64 + (str65 != null ? str65.hashCode() : 0)) * 31;
        String str66 = this.Title;
        int hashCode66 = (hashCode65 + (str66 != null ? str66.hashCode() : 0)) * 31;
        String str67 = this.TitleState;
        int hashCode67 = (hashCode66 + (str67 != null ? str67.hashCode() : 0)) * 31;
        String str68 = this.Transmission;
        int hashCode68 = (hashCode67 + (str68 != null ? str68.hashCode() : 0)) * 31;
        String str69 = this.VIN;
        int hashCode69 = (hashCode68 + (str69 != null ? str69.hashCode() : 0)) * 31;
        String str70 = this.VehicleClass;
        int hashCode70 = (hashCode69 + (str70 != null ? str70.hashCode() : 0)) * 31;
        String str71 = this.VehicleState;
        int hashCode71 = (hashCode70 + (str71 != null ? str71.hashCode() : 0)) * 31;
        String str72 = this.VehicleSubtype;
        int hashCode72 = (hashCode71 + (str72 != null ? str72.hashCode() : 0)) * 31;
        String str73 = this.VehicleType;
        int hashCode73 = (hashCode72 + (str73 != null ? str73.hashCode() : 0)) * 31;
        String str74 = this.VehicleTypeId;
        int hashCode74 = (hashCode73 + (str74 != null ? str74.hashCode() : 0)) * 31;
        String str75 = this.Year;
        if (str75 != null) {
            i = str75.hashCode();
        }
        return hashCode74 + i;
    }

    @NotNull
    public String toString() {
        return "Data(ACV=" + this.ACV + ", AdminBranch=" + this.AdminBranch + ", Airbag=" + this.Airbag + ", AuctionLane=" + this.AuctionLane + ", Availability=" + this.Availability + ", BodyStyleName=" + this.BodyStyleName + ", BranchName=" + this.BranchName + ", BranchNumber=" + this.BranchNumber + ", BranchPublicAuction=" + this.BranchPublicAuction + ", BuyNowCloseDatetime=" + this.BuyNowCloseDatetime + ", BuyNowIndicator=" + this.BuyNowIndicator + ", CatIndicator=" + this.CatIndicator + ", CheckDigit=" + this.CheckDigit + ", CloseDateTime=" + this.CloseDateTime + ", CountryOfOrigin=" + this.CountryOfOrigin + ", Cylinders=" + this.Cylinders + ", DisplaySeller=" + this.DisplaySeller + ", DriveLineType=" + this.DriveLineType + ", DriveLineTypeDesc=" + this.DriveLineTypeDesc + ", Engine=" + this.Engine + ", EngineSize=" + this.EngineSize + ", ExteriorColor=" + this.ExteriorColor + ", ExternalVehicleId=" + this.ExternalVehicleId + ", FuelType=" + this.FuelType + ", InteriorColor=" + this.InteriorColor + ", InventoryID=" + this.InventoryID + ", ItemId=" + this.ItemId + ", ItemImageId=" + this.ItemImageId + ", ItemNumber=" + this.ItemNumber + ", ItemPublicAuction=" + this.ItemPublicAuction + ", Key=" + this.Key + ", LatValue=" + this.LatValue + ", Latitude=" + this.Latitude + ", LiveDate=" + this.LiveDate + ", LiveDateTime=" + this.LiveDateTime + ", LongValue=" + this.LongValue + ", Longitude=" + this.Longitude + ", LossType=" + this.LossType + ", Make=" + this.Make + ", Model=" + this.Model + ", OdoBrand=" + this.OdoBrand + ", Odometer=" + this.Odometer + ", OffSiteSaleIndicator=" + this.OffSiteSaleIndicator + ", PrimaryDamage=" + this.PrimaryDamage + ", Promotions=" + this.Promotions + ", PublicVehicle=" + this.PublicVehicle + ", RestraintSystem=" + this.RestraintSystem + ", RunAndDrive=" + this.RunAndDrive + ", SaleDocument=" + this.SaleDocument + ", SaleDocumentBrand=" + this.SaleDocumentBrand + ", SecondaryDamage=" + this.SecondaryDamage + ", SellerName=" + this.SellerName + ", SellerType=" + this.SellerType + ", Series=" + this.Series + ", StartDesc=" + this.StartDesc + ", Stockno=" + this.Stockno + ", StorageLocation=" + this.StorageLocation + ", StorageLocationId=" + this.StorageLocationId + ", StorageLocationName=" + this.StorageLocationName + ", TBOIndicator=" + this.TBOIndicator + ", TZAdjust=" + this.TZAdjust + ", Tenant=" + this.Tenant + ", TimeZone=" + this.TimeZone + ", TimedAuctionCloseDateTime=" + this.TimedAuctionCloseDateTime + ", TimedAuctionIndicator=" + this.TimedAuctionIndicator + ", Title=" + this.Title + ", TitleState=" + this.TitleState + ", Transmission=" + this.Transmission + ", VIN=" + this.VIN + ", VehicleClass=" + this.VehicleClass + ", VehicleState=" + this.VehicleState + ", VehicleSubtype=" + this.VehicleSubtype + ", VehicleType=" + this.VehicleType + ", VehicleTypeId=" + this.VehicleTypeId + ", Year=" + this.Year + ")";
    }

    public Data(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, @NotNull String str23, @NotNull String str24, @NotNull String str25, @NotNull String str26, @NotNull String str27, @NotNull String str28, @NotNull String str29, @NotNull String str30, @NotNull String str31, @NotNull String str32, @NotNull String str33, @NotNull String str34, @NotNull String str35, @NotNull String str36, @NotNull String str37, @NotNull String str38, @NotNull String str39, @NotNull String str40, @NotNull String str41, @NotNull String str42, @NotNull String str43, @NotNull String str44, @NotNull String str45, @NotNull String str46, @NotNull String str47, @NotNull String str48, @NotNull String str49, @NotNull String str50, @NotNull String str51, @NotNull String str52, @NotNull String str53, @NotNull String str54, @NotNull String str55, @NotNull String str56, @NotNull String str57, @NotNull String str58, @NotNull String str59, @NotNull String str60, @NotNull String str61, @NotNull String str62, @NotNull String str63, @NotNull String str64, @NotNull String str65, @NotNull String str66, @NotNull String str67, @NotNull String str68, @NotNull String str69, @NotNull String str70, @NotNull String str71, @NotNull String str72, @NotNull String str73, @NotNull String str74, @NotNull String str75) {
        String str76 = str;
        String str77 = str2;
        String str78 = str3;
        String str79 = str4;
        String str80 = str5;
        String str81 = str6;
        String str82 = str7;
        String str83 = str8;
        String str84 = str9;
        String str85 = str10;
        String str86 = str11;
        String str87 = str12;
        String str88 = str13;
        String str89 = str14;
        String str90 = str16;
        Intrinsics.checkParameterIsNotNull(str76, "ACV");
        Intrinsics.checkParameterIsNotNull(str77, "AdminBranch");
        Intrinsics.checkParameterIsNotNull(str78, "Airbag");
        Intrinsics.checkParameterIsNotNull(str79, "AuctionLane");
        Intrinsics.checkParameterIsNotNull(str80, "Availability");
        Intrinsics.checkParameterIsNotNull(str81, "BodyStyleName");
        Intrinsics.checkParameterIsNotNull(str82, "BranchName");
        Intrinsics.checkParameterIsNotNull(str83, AnalyticsContract.Analytics.COLUMN_NAME_BRANCH_NO);
        Intrinsics.checkParameterIsNotNull(str84, "BranchPublicAuction");
        Intrinsics.checkParameterIsNotNull(str85, "BuyNowCloseDatetime");
        Intrinsics.checkParameterIsNotNull(str86, "BuyNowIndicator");
        Intrinsics.checkParameterIsNotNull(str87, "CatIndicator");
        Intrinsics.checkParameterIsNotNull(str88, "CheckDigit");
        Intrinsics.checkParameterIsNotNull(str89, "CloseDateTime");
        Intrinsics.checkParameterIsNotNull(str15, "CountryOfOrigin");
        Intrinsics.checkParameterIsNotNull(str16, "Cylinders");
        Intrinsics.checkParameterIsNotNull(str17, "DisplaySeller");
        Intrinsics.checkParameterIsNotNull(str18, "DriveLineType");
        Intrinsics.checkParameterIsNotNull(str19, "DriveLineTypeDesc");
        Intrinsics.checkParameterIsNotNull(str20, "Engine");
        Intrinsics.checkParameterIsNotNull(str21, "EngineSize");
        Intrinsics.checkParameterIsNotNull(str22, "ExteriorColor");
        Intrinsics.checkParameterIsNotNull(str23, "ExternalVehicleId");
        Intrinsics.checkParameterIsNotNull(str24, "FuelType");
        Intrinsics.checkParameterIsNotNull(str25, "InteriorColor");
        Intrinsics.checkParameterIsNotNull(str26, "InventoryID");
        Intrinsics.checkParameterIsNotNull(str27, "ItemId");
        Intrinsics.checkParameterIsNotNull(str28, "ItemImageId");
        Intrinsics.checkParameterIsNotNull(str29, "ItemNumber");
        Intrinsics.checkParameterIsNotNull(str30, "ItemPublicAuction");
        Intrinsics.checkParameterIsNotNull(str31, "Key");
        Intrinsics.checkParameterIsNotNull(str32, "LatValue");
        Intrinsics.checkParameterIsNotNull(str33, "Latitude");
        Intrinsics.checkParameterIsNotNull(str34, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str35, "LiveDateTime");
        Intrinsics.checkParameterIsNotNull(str36, "LongValue");
        Intrinsics.checkParameterIsNotNull(str37, "Longitude");
        Intrinsics.checkParameterIsNotNull(str38, "LossType");
        Intrinsics.checkParameterIsNotNull(str39, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str40, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str41, "OdoBrand");
        Intrinsics.checkParameterIsNotNull(str42, "Odometer");
        Intrinsics.checkParameterIsNotNull(str43, "OffSiteSaleIndicator");
        Intrinsics.checkParameterIsNotNull(str44, "PrimaryDamage");
        Intrinsics.checkParameterIsNotNull(str45, "Promotions");
        Intrinsics.checkParameterIsNotNull(str46, "PublicVehicle");
        Intrinsics.checkParameterIsNotNull(str47, "RestraintSystem");
        Intrinsics.checkParameterIsNotNull(str48, "RunAndDrive");
        Intrinsics.checkParameterIsNotNull(str49, "SaleDocument");
        Intrinsics.checkParameterIsNotNull(str50, "SaleDocumentBrand");
        Intrinsics.checkParameterIsNotNull(str51, "SecondaryDamage");
        Intrinsics.checkParameterIsNotNull(str52, "SellerName");
        Intrinsics.checkParameterIsNotNull(str53, "SellerType");
        Intrinsics.checkParameterIsNotNull(str54, "Series");
        Intrinsics.checkParameterIsNotNull(str55, "StartDesc");
        Intrinsics.checkParameterIsNotNull(str56, "Stockno");
        Intrinsics.checkParameterIsNotNull(str57, "StorageLocation");
        Intrinsics.checkParameterIsNotNull(str58, "StorageLocationId");
        Intrinsics.checkParameterIsNotNull(str59, "StorageLocationName");
        Intrinsics.checkParameterIsNotNull(str60, "TBOIndicator");
        Intrinsics.checkParameterIsNotNull(str61, "TZAdjust");
        Intrinsics.checkParameterIsNotNull(str62, "Tenant");
        Intrinsics.checkParameterIsNotNull(str63, "TimeZone");
        Intrinsics.checkParameterIsNotNull(str64, "TimedAuctionCloseDateTime");
        Intrinsics.checkParameterIsNotNull(str65, "TimedAuctionIndicator");
        Intrinsics.checkParameterIsNotNull(str66, "Title");
        Intrinsics.checkParameterIsNotNull(str67, "TitleState");
        Intrinsics.checkParameterIsNotNull(str68, "Transmission");
        Intrinsics.checkParameterIsNotNull(str69, "VIN");
        Intrinsics.checkParameterIsNotNull(str70, "VehicleClass");
        Intrinsics.checkParameterIsNotNull(str71, "VehicleState");
        Intrinsics.checkParameterIsNotNull(str72, "VehicleSubtype");
        Intrinsics.checkParameterIsNotNull(str73, "VehicleType");
        Intrinsics.checkParameterIsNotNull(str74, "VehicleTypeId");
        Intrinsics.checkParameterIsNotNull(str75, "Year");
        this.ACV = str76;
        this.AdminBranch = str77;
        this.Airbag = str78;
        this.AuctionLane = str79;
        this.Availability = str80;
        this.BodyStyleName = str81;
        this.BranchName = str82;
        this.BranchNumber = str83;
        this.BranchPublicAuction = str84;
        this.BuyNowCloseDatetime = str85;
        this.BuyNowIndicator = str86;
        this.CatIndicator = str87;
        this.CheckDigit = str88;
        this.CloseDateTime = str89;
        this.CountryOfOrigin = str15;
        this.Cylinders = str16;
        this.DisplaySeller = str17;
        this.DriveLineType = str18;
        this.DriveLineTypeDesc = str19;
        this.Engine = str20;
        this.EngineSize = str21;
        this.ExteriorColor = str22;
        this.ExternalVehicleId = str23;
        this.FuelType = str24;
        this.InteriorColor = str25;
        this.InventoryID = str26;
        this.ItemId = str27;
        this.ItemImageId = str28;
        this.ItemNumber = str29;
        this.ItemPublicAuction = str30;
        this.Key = str31;
        this.LatValue = str32;
        this.Latitude = str33;
        this.LiveDate = str34;
        this.LiveDateTime = str35;
        this.LongValue = str36;
        this.Longitude = str37;
        this.LossType = str38;
        this.Make = str39;
        this.Model = str40;
        this.OdoBrand = str41;
        this.Odometer = str42;
        this.OffSiteSaleIndicator = str43;
        this.PrimaryDamage = str44;
        this.Promotions = str45;
        this.PublicVehicle = str46;
        this.RestraintSystem = str47;
        this.RunAndDrive = str48;
        this.SaleDocument = str49;
        this.SaleDocumentBrand = str50;
        this.SecondaryDamage = str51;
        this.SellerName = str52;
        this.SellerType = str53;
        this.Series = str54;
        this.StartDesc = str55;
        this.Stockno = str56;
        this.StorageLocation = str57;
        this.StorageLocationId = str58;
        this.StorageLocationName = str59;
        this.TBOIndicator = str60;
        this.TZAdjust = str61;
        this.Tenant = str62;
        this.TimeZone = str63;
        this.TimedAuctionCloseDateTime = str64;
        this.TimedAuctionIndicator = str65;
        this.Title = str66;
        this.TitleState = str67;
        this.Transmission = str68;
        this.VIN = str69;
        this.VehicleClass = str70;
        this.VehicleState = str71;
        this.VehicleSubtype = str72;
        this.VehicleType = str73;
        this.VehicleTypeId = str74;
        this.Year = str75;
    }

    @NotNull
    public final String getACV() {
        return this.ACV;
    }

    @NotNull
    public final String getAdminBranch() {
        return this.AdminBranch;
    }

    @NotNull
    public final String getAirbag() {
        return this.Airbag;
    }

    @NotNull
    public final String getAuctionLane() {
        return this.AuctionLane;
    }

    @NotNull
    public final String getAvailability() {
        return this.Availability;
    }

    @NotNull
    public final String getBodyStyleName() {
        return this.BodyStyleName;
    }

    @NotNull
    public final String getBranchName() {
        return this.BranchName;
    }

    @NotNull
    public final String getBranchNumber() {
        return this.BranchNumber;
    }

    @NotNull
    public final String getBranchPublicAuction() {
        return this.BranchPublicAuction;
    }

    @NotNull
    public final String getBuyNowCloseDatetime() {
        return this.BuyNowCloseDatetime;
    }

    @NotNull
    public final String getBuyNowIndicator() {
        return this.BuyNowIndicator;
    }

    @NotNull
    public final String getCatIndicator() {
        return this.CatIndicator;
    }

    @NotNull
    public final String getCheckDigit() {
        return this.CheckDigit;
    }

    @NotNull
    public final String getCloseDateTime() {
        return this.CloseDateTime;
    }

    @NotNull
    public final String getCountryOfOrigin() {
        return this.CountryOfOrigin;
    }

    @NotNull
    public final String getCylinders() {
        return this.Cylinders;
    }

    @NotNull
    public final String getDisplaySeller() {
        return this.DisplaySeller;
    }

    @NotNull
    public final String getDriveLineType() {
        return this.DriveLineType;
    }

    @NotNull
    public final String getDriveLineTypeDesc() {
        return this.DriveLineTypeDesc;
    }

    @NotNull
    public final String getEngine() {
        return this.Engine;
    }

    @NotNull
    public final String getEngineSize() {
        return this.EngineSize;
    }

    @NotNull
    public final String getExteriorColor() {
        return this.ExteriorColor;
    }

    @NotNull
    public final String getExternalVehicleId() {
        return this.ExternalVehicleId;
    }

    @NotNull
    public final String getFuelType() {
        return this.FuelType;
    }

    @NotNull
    public final String getInteriorColor() {
        return this.InteriorColor;
    }

    @NotNull
    public final String getInventoryID() {
        return this.InventoryID;
    }

    @NotNull
    public final String getItemId() {
        return this.ItemId;
    }

    @NotNull
    public final String getItemImageId() {
        return this.ItemImageId;
    }

    @NotNull
    public final String getItemNumber() {
        return this.ItemNumber;
    }

    @NotNull
    public final String getItemPublicAuction() {
        return this.ItemPublicAuction;
    }

    @NotNull
    public final String getKey() {
        return this.Key;
    }

    @NotNull
    public final String getLatValue() {
        return this.LatValue;
    }

    @NotNull
    public final String getLatitude() {
        return this.Latitude;
    }

    @NotNull
    public final String getLiveDate() {
        return this.LiveDate;
    }

    @NotNull
    public final String getLiveDateTime() {
        return this.LiveDateTime;
    }

    @NotNull
    public final String getLongValue() {
        return this.LongValue;
    }

    @NotNull
    public final String getLongitude() {
        return this.Longitude;
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
    public final String getOdoBrand() {
        return this.OdoBrand;
    }

    @NotNull
    public final String getOdometer() {
        return this.Odometer;
    }

    @NotNull
    public final String getOffSiteSaleIndicator() {
        return this.OffSiteSaleIndicator;
    }

    @NotNull
    public final String getPrimaryDamage() {
        return this.PrimaryDamage;
    }

    @NotNull
    public final String getPromotions() {
        return this.Promotions;
    }

    @NotNull
    public final String getPublicVehicle() {
        return this.PublicVehicle;
    }

    @NotNull
    public final String getRestraintSystem() {
        return this.RestraintSystem;
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
    public final String getSaleDocumentBrand() {
        return this.SaleDocumentBrand;
    }

    @NotNull
    public final String getSecondaryDamage() {
        return this.SecondaryDamage;
    }

    @NotNull
    public final String getSellerName() {
        return this.SellerName;
    }

    @NotNull
    public final String getSellerType() {
        return this.SellerType;
    }

    @NotNull
    public final String getSeries() {
        return this.Series;
    }

    @NotNull
    public final String getStartDesc() {
        return this.StartDesc;
    }

    @NotNull
    public final String getStockno() {
        return this.Stockno;
    }

    @NotNull
    public final String getStorageLocation() {
        return this.StorageLocation;
    }

    @NotNull
    public final String getStorageLocationId() {
        return this.StorageLocationId;
    }

    @NotNull
    public final String getStorageLocationName() {
        return this.StorageLocationName;
    }

    @NotNull
    public final String getTBOIndicator() {
        return this.TBOIndicator;
    }

    @NotNull
    public final String getTZAdjust() {
        return this.TZAdjust;
    }

    @NotNull
    public final String getTenant() {
        return this.Tenant;
    }

    @NotNull
    public final String getTimeZone() {
        return this.TimeZone;
    }

    @NotNull
    public final String getTimedAuctionCloseDateTime() {
        return this.TimedAuctionCloseDateTime;
    }

    @NotNull
    public final String getTimedAuctionIndicator() {
        return this.TimedAuctionIndicator;
    }

    @NotNull
    public final String getTitle() {
        return this.Title;
    }

    @NotNull
    public final String getTitleState() {
        return this.TitleState;
    }

    @NotNull
    public final String getTransmission() {
        return this.Transmission;
    }

    @NotNull
    public final String getVIN() {
        return this.VIN;
    }

    @NotNull
    public final String getVehicleClass() {
        return this.VehicleClass;
    }

    @NotNull
    public final String getVehicleState() {
        return this.VehicleState;
    }

    @NotNull
    public final String getVehicleSubtype() {
        return this.VehicleSubtype;
    }

    @NotNull
    public final String getVehicleType() {
        return this.VehicleType;
    }

    @NotNull
    public final String getVehicleTypeId() {
        return this.VehicleTypeId;
    }

    @NotNull
    public final String getYear() {
        return this.Year;
    }
}
