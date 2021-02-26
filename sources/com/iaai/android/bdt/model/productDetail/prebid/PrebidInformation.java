package com.iaai.android.bdt.model.productDetail.prebid;

import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0003\bæ\u0001\b\b\u0018\u00002\u00020\u0001B÷\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010'\u001a\u00020\u0001\u0012\u0006\u0010(\u001a\u00020\u0001\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0001\u0012\u0006\u0010+\u001a\u00020\u000e\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00102\u001a\u00020\u000e\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u00105\u001a\u00020\u000e\u0012\u0006\u00106\u001a\u00020\u000e\u0012\u0006\u00107\u001a\u00020\u000e\u0012\u0006\u00108\u001a\u00020\u0005\u0012\u0006\u00109\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u00020\u0001\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010=\u001a\u00020\u0003\u0012\u0006\u0010>\u001a\u00020\u0001\u0012\u0006\u0010?\u001a\u00020\u0001\u0012\u0006\u0010@\u001a\u00020\u0003\u0012\u0006\u0010A\u001a\u00020\u000e\u0012\u0006\u0010B\u001a\u00020\u0001\u0012\u0006\u0010C\u001a\u00020\u0001\u0012\u0006\u0010D\u001a\u00020\u000e\u0012\u0006\u0010E\u001a\u00020\u0003\u0012\u0006\u0010F\u001a\u00020\u0003\u0012\u0006\u0010G\u001a\u00020\u000e\u0012\u0006\u0010H\u001a\u00020\u0001\u0012\u0006\u0010I\u001a\u00020\u0003\u0012\u0006\u0010J\u001a\u00020\u0003\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010O\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010PJ\n\u0010£\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010©\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010«\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010­\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010UJ\n\u0010¯\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010´\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010·\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010À\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010Ý\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010Þ\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010á\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010â\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010ã\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ä\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010å\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010æ\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ë\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010nJ\n\u0010ì\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010í\u0001\u001a\u00020\u0003HÆ\u0003J\u0006\u0010î\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010'\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00012\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020\u000e2\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\u00012\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00032\b\b\u0002\u0010=\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00012\b\b\u0002\u0010?\u001a\u00020\u00012\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u000e2\b\b\u0002\u0010B\u001a\u00020\u00012\b\b\u0002\u0010C\u001a\u00020\u00012\b\b\u0002\u0010D\u001a\u00020\u000e2\b\b\u0002\u0010E\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u000e2\b\b\u0002\u0010H\u001a\u00020\u00012\b\b\u0002\u0010I\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00032\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0003\u0010ï\u0001J\u0015\u0010ð\u0001\u001a\u00020\u000e2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010ò\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010ó\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010I\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010RR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010V\u001a\u0004\bT\u0010UR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010RR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010RR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010RR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010RR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0011\u0010J\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010RR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\\R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010RR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010RR\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010aR\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010aR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bg\u0010aR\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bh\u0010aR\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bi\u0010aR\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010aR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010RR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010RR\u0015\u0010O\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010o\u001a\u0004\bm\u0010nR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010RR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010RR\u0013\u0010N\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\br\u0010RR\u0013\u0010M\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bs\u0010RR\u0013\u0010L\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bt\u0010RR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bu\u0010RR\u0011\u0010\u001c\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bv\u0010aR\u0011\u0010\u001d\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bw\u0010aR\u0011\u0010\u001e\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bx\u0010aR\u0011\u0010\u001f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\by\u0010aR\u0011\u0010 \u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bz\u0010aR\u0011\u0010!\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b{\u0010aR\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b|\u0010RR\u0013\u0010K\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010RR\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b~\u0010RR\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010RR\u0012\u0010%\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0014\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010'\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010(\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010)\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010*\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010+\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u0010,\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010-\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u0010/\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u00100\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0014\u00101\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u00102\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u00103\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u00104\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u00105\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u00106\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u00107\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u00108\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\\R\u0012\u00109\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010:\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010;\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\\R\u0012\u0010<\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010=\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010>\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010?\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010@\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010A\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u0010B\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010C\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010dR\u0012\u0010D\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010aR\u0012\u0010E\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0012\u0010F\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010RR\u0012\u0010G\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b¡\u0001\u0010aR\u0012\u0010H\u001a\u00020\u0001¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010dR\u0011\u0010.\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010a¨\u0006ô\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/prebid/PrebidInformation;", "", "AdjustedCloseDate", "", "AuctionStatus", "", "AuctionStatusDescription", "BidCountText", "BidText", "BiddingErrorMessage", "BranchCode", "BuyNowOfferAmount", "BuyNowPrice", "BuyNowSold", "", "DecimalHighBidAmount", "DecimalOutBidAmount", "DisplayDeletedBidMsg", "DisplayHighPrebid", "DisplayPremiumReport", "DisplaySalesTaxWarning", "DisplaySalesTaxWarningLinks", "DisplayTaxLink", "ErrorMessage", "FormattedMyMax", "HighBidAmount", "HighBidder", "IBFSoldMessage", "IbuyFastAllowed", "IsGuest", "IsHighPrebidder", "IsPreBidVisible", "IsPrebiddingDone", "IsPublic", "LiveDate", "LosingBidStatus", "ModifiedDate", "MyCurrent", "MyMax", "MyStock", "OutBidAmount", "OutBidAmountNeededText", "PreBidHistory", "PrebidAllowed", "PrebidAwardMesssage", "PrebidClosed", "isTransportationQuotesAvailable", "PrebidPayDate", "PrebidPickUpDate", "PrebidPopupErrorMessage", "ReserveMet", "SalesTaxWarningMessage", "ShowCurrentBid", "ShowIBidLiveIcon", "ShowOutbidMessage", "ShowPrebidHistory", "StartBid", "StartingBidAmountNeededText", "StringOutBidAmount", "TimedAuctionBuyNowOfferstatus", "TimedAuctionCloseTimeCST", "TimedAuctionClosingStatus", "TimedAuctionDate", "TimedAuctionDateString", "TimedAuctionDay", "TimedAuctionInd", "TimedAuctionMonth", "TimedAuctionSoldTime", "UserLoginStatus", "UserTimezoneAbb", "VehicleStatus", "VisibleBuyerFeeLink", "WhoCanBid", "AuctionID", "BuyNowCloseDate", "LiveDateinUserTimeZone", "IBFPickUpDate", "IBFPayDate", "IBFAwardMesssage", "HidePreBidOnUpstreamBuyNow", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/Object;ZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZILjava/lang/String;Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/Object;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAdjustedCloseDate", "()Ljava/lang/String;", "getAuctionID", "getAuctionStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAuctionStatusDescription", "getBidCountText", "getBidText", "getBiddingErrorMessage", "getBranchCode", "()I", "getBuyNowCloseDate", "getBuyNowOfferAmount", "getBuyNowPrice", "getBuyNowSold", "()Z", "getDecimalHighBidAmount", "getDecimalOutBidAmount", "()Ljava/lang/Object;", "getDisplayDeletedBidMsg", "getDisplayHighPrebid", "getDisplayPremiumReport", "getDisplaySalesTaxWarning", "getDisplaySalesTaxWarningLinks", "getDisplayTaxLink", "getErrorMessage", "getFormattedMyMax", "getHidePreBidOnUpstreamBuyNow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHighBidAmount", "getHighBidder", "getIBFAwardMesssage", "getIBFPayDate", "getIBFPickUpDate", "getIBFSoldMessage", "getIbuyFastAllowed", "getIsGuest", "getIsHighPrebidder", "getIsPreBidVisible", "getIsPrebiddingDone", "getIsPublic", "getLiveDate", "getLiveDateinUserTimeZone", "getLosingBidStatus", "getModifiedDate", "getMyCurrent", "getMyMax", "getMyStock", "getOutBidAmount", "getOutBidAmountNeededText", "getPreBidHistory", "getPrebidAllowed", "getPrebidAwardMesssage", "getPrebidClosed", "getPrebidPayDate", "getPrebidPickUpDate", "getPrebidPopupErrorMessage", "getReserveMet", "getSalesTaxWarningMessage", "getShowCurrentBid", "getShowIBidLiveIcon", "getShowOutbidMessage", "getShowPrebidHistory", "getStartBid", "getStartingBidAmountNeededText", "getStringOutBidAmount", "getTimedAuctionBuyNowOfferstatus", "getTimedAuctionCloseTimeCST", "getTimedAuctionClosingStatus", "getTimedAuctionDate", "getTimedAuctionDateString", "getTimedAuctionDay", "getTimedAuctionInd", "getTimedAuctionMonth", "getTimedAuctionSoldTime", "getUserLoginStatus", "getUserTimezoneAbb", "getVehicleStatus", "getVisibleBuyerFeeLink", "getWhoCanBid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/Object;ZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZILjava/lang/String;Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/Object;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/iaai/android/bdt/model/productDetail/prebid/PrebidInformation;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PrebidInformation.kt */
public final class PrebidInformation {
    @NotNull
    private final String AdjustedCloseDate;
    @NotNull
    private final String AuctionID;
    @Nullable
    private final Integer AuctionStatus;
    @Nullable
    private final String AuctionStatusDescription;
    @NotNull
    private final String BidCountText;
    @NotNull
    private final String BidText;
    @NotNull
    private final String BiddingErrorMessage;
    private final int BranchCode;
    @NotNull
    private final String BuyNowCloseDate;
    private final int BuyNowOfferAmount;
    @NotNull
    private final String BuyNowPrice;
    private final boolean BuyNowSold;
    @NotNull
    private final String DecimalHighBidAmount;
    @NotNull
    private final Object DecimalOutBidAmount;
    private final boolean DisplayDeletedBidMsg;
    private final boolean DisplayHighPrebid;
    private final boolean DisplayPremiumReport;
    private final boolean DisplaySalesTaxWarning;
    private final boolean DisplaySalesTaxWarningLinks;
    private final boolean DisplayTaxLink;
    @NotNull
    private final String ErrorMessage;
    @NotNull
    private final String FormattedMyMax;
    @Nullable
    private final Boolean HidePreBidOnUpstreamBuyNow;
    @Nullable
    private final String HighBidAmount;
    @Nullable
    private final String HighBidder;
    @Nullable
    private final String IBFAwardMesssage;
    @Nullable
    private final String IBFPayDate;
    @Nullable
    private final String IBFPickUpDate;
    @Nullable
    private final String IBFSoldMessage;
    private final boolean IbuyFastAllowed;
    private final boolean IsGuest;
    private final boolean IsHighPrebidder;
    private final boolean IsPreBidVisible;
    private final boolean IsPrebiddingDone;
    private final boolean IsPublic;
    @NotNull
    private final String LiveDate;
    @Nullable
    private final String LiveDateinUserTimeZone;
    @Nullable
    private final String LosingBidStatus;
    @NotNull
    private final String ModifiedDate;
    @NotNull
    private final String MyCurrent;
    @Nullable
    private final String MyMax;
    @NotNull
    private final Object MyStock;
    @NotNull
    private final Object OutBidAmount;
    @NotNull
    private final String OutBidAmountNeededText;
    @NotNull
    private final Object PreBidHistory;
    private final boolean PrebidAllowed;
    @NotNull
    private final String PrebidAwardMesssage;
    private final boolean PrebidClosed;
    @NotNull
    private final String PrebidPayDate;
    @NotNull
    private final String PrebidPickUpDate;
    @Nullable
    private final String PrebidPopupErrorMessage;
    private final boolean ReserveMet;
    @NotNull
    private final String SalesTaxWarningMessage;
    private final boolean ShowCurrentBid;
    private final boolean ShowIBidLiveIcon;
    private final boolean ShowOutbidMessage;
    private final boolean ShowPrebidHistory;
    private final int StartBid;
    @NotNull
    private final String StartingBidAmountNeededText;
    @NotNull
    private final Object StringOutBidAmount;
    private final int TimedAuctionBuyNowOfferstatus;
    @NotNull
    private final String TimedAuctionCloseTimeCST;
    @NotNull
    private final String TimedAuctionClosingStatus;
    @NotNull
    private final Object TimedAuctionDate;
    @NotNull
    private final Object TimedAuctionDateString;
    @NotNull
    private final String TimedAuctionDay;
    private final boolean TimedAuctionInd;
    @NotNull
    private final Object TimedAuctionMonth;
    @NotNull
    private final Object TimedAuctionSoldTime;
    private final boolean UserLoginStatus;
    @NotNull
    private final String UserTimezoneAbb;
    @NotNull
    private final String VehicleStatus;
    private final boolean VisibleBuyerFeeLink;
    @NotNull
    private final Object WhoCanBid;
    private final boolean isTransportationQuotesAvailable;

    @NotNull
    public static /* synthetic */ PrebidInformation copy$default(PrebidInformation prebidInformation, String str, Integer num, String str2, String str3, String str4, String str5, int i, int i2, String str6, boolean z, String str7, Object obj, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str8, String str9, String str10, String str11, String str12, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, String str13, String str14, String str15, String str16, String str17, Object obj2, Object obj3, String str18, Object obj4, boolean z14, String str19, boolean z15, boolean z16, String str20, String str21, String str22, boolean z17, String str23, boolean z18, boolean z19, boolean z20, boolean z21, int i3, String str24, Object obj5, int i4, String str25, String str26, Object obj6, Object obj7, String str27, boolean z22, Object obj8, Object obj9, boolean z23, String str28, String str29, boolean z24, Object obj10, String str30, String str31, String str32, String str33, String str34, String str35, Boolean bool, int i5, int i6, int i7, Object obj11) {
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        boolean z32;
        boolean z33;
        boolean z34;
        boolean z35;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z40;
        boolean z41;
        boolean z42;
        boolean z43;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        String str54;
        String str55;
        Object obj16;
        Object obj17;
        boolean z44;
        String str56;
        boolean z45;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z50;
        boolean z51;
        boolean z52;
        int i8;
        int i9;
        String str57;
        String str58;
        Object obj18;
        Object obj19;
        int i10;
        int i11;
        String str59;
        String str60;
        String str61;
        String str62;
        Object obj20;
        Object obj21;
        Object obj22;
        Object obj23;
        String str63;
        String str64;
        boolean z53;
        boolean z54;
        Object obj24;
        Object obj25;
        Object obj26;
        boolean z55;
        String str65;
        String str66;
        String str67;
        String str68;
        boolean z56;
        boolean z57;
        Object obj27;
        Object obj28;
        String str69;
        String str70;
        String str71;
        String str72;
        String str73;
        PrebidInformation prebidInformation2 = prebidInformation;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        String str74 = (i12 & 1) != 0 ? prebidInformation2.AdjustedCloseDate : str;
        Integer num2 = (i12 & 2) != 0 ? prebidInformation2.AuctionStatus : num;
        String str75 = (i12 & 4) != 0 ? prebidInformation2.AuctionStatusDescription : str2;
        String str76 = (i12 & 8) != 0 ? prebidInformation2.BidCountText : str3;
        String str77 = (i12 & 16) != 0 ? prebidInformation2.BidText : str4;
        String str78 = (i12 & 32) != 0 ? prebidInformation2.BiddingErrorMessage : str5;
        int i15 = (i12 & 64) != 0 ? prebidInformation2.BranchCode : i;
        int i16 = (i12 & 128) != 0 ? prebidInformation2.BuyNowOfferAmount : i2;
        String str79 = (i12 & 256) != 0 ? prebidInformation2.BuyNowPrice : str6;
        boolean z58 = (i12 & 512) != 0 ? prebidInformation2.BuyNowSold : z;
        String str80 = (i12 & 1024) != 0 ? prebidInformation2.DecimalHighBidAmount : str7;
        Object obj29 = (i12 & 2048) != 0 ? prebidInformation2.DecimalOutBidAmount : obj;
        boolean z59 = (i12 & 4096) != 0 ? prebidInformation2.DisplayDeletedBidMsg : z2;
        boolean z60 = (i12 & 8192) != 0 ? prebidInformation2.DisplayHighPrebid : z3;
        boolean z61 = (i12 & 16384) != 0 ? prebidInformation2.DisplayPremiumReport : z4;
        if ((i12 & 32768) != 0) {
            z25 = z61;
            z26 = prebidInformation2.DisplaySalesTaxWarning;
        } else {
            z25 = z61;
            z26 = z5;
        }
        if ((i12 & 65536) != 0) {
            z27 = z26;
            z28 = prebidInformation2.DisplaySalesTaxWarningLinks;
        } else {
            z27 = z26;
            z28 = z6;
        }
        if ((i12 & 131072) != 0) {
            z29 = z28;
            z30 = prebidInformation2.DisplayTaxLink;
        } else {
            z29 = z28;
            z30 = z7;
        }
        if ((i12 & 262144) != 0) {
            z31 = z30;
            str36 = prebidInformation2.ErrorMessage;
        } else {
            z31 = z30;
            str36 = str8;
        }
        if ((i12 & 524288) != 0) {
            str37 = str36;
            str38 = prebidInformation2.FormattedMyMax;
        } else {
            str37 = str36;
            str38 = str9;
        }
        if ((i12 & 1048576) != 0) {
            str39 = str38;
            str40 = prebidInformation2.HighBidAmount;
        } else {
            str39 = str38;
            str40 = str10;
        }
        if ((i12 & 2097152) != 0) {
            str41 = str40;
            str42 = prebidInformation2.HighBidder;
        } else {
            str41 = str40;
            str42 = str11;
        }
        if ((i12 & 4194304) != 0) {
            str43 = str42;
            str44 = prebidInformation2.IBFSoldMessage;
        } else {
            str43 = str42;
            str44 = str12;
        }
        if ((i12 & 8388608) != 0) {
            str45 = str44;
            z32 = prebidInformation2.IbuyFastAllowed;
        } else {
            str45 = str44;
            z32 = z8;
        }
        if ((i12 & 16777216) != 0) {
            z33 = z32;
            z34 = prebidInformation2.IsGuest;
        } else {
            z33 = z32;
            z34 = z9;
        }
        if ((i12 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            z35 = z34;
            z36 = prebidInformation2.IsHighPrebidder;
        } else {
            z35 = z34;
            z36 = z10;
        }
        if ((i12 & 67108864) != 0) {
            z37 = z36;
            z38 = prebidInformation2.IsPreBidVisible;
        } else {
            z37 = z36;
            z38 = z11;
        }
        if ((i12 & 134217728) != 0) {
            z39 = z38;
            z40 = prebidInformation2.IsPrebiddingDone;
        } else {
            z39 = z38;
            z40 = z12;
        }
        if ((i12 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            z41 = z40;
            z42 = prebidInformation2.IsPublic;
        } else {
            z41 = z40;
            z42 = z13;
        }
        if ((i12 & 536870912) != 0) {
            z43 = z42;
            str46 = prebidInformation2.LiveDate;
        } else {
            z43 = z42;
            str46 = str13;
        }
        if ((i12 & 1073741824) != 0) {
            str47 = str46;
            str48 = prebidInformation2.LosingBidStatus;
        } else {
            str47 = str46;
            str48 = str14;
        }
        String str81 = (i12 & Integer.MIN_VALUE) != 0 ? prebidInformation2.ModifiedDate : str15;
        if ((i13 & 1) != 0) {
            str49 = str81;
            str50 = prebidInformation2.MyCurrent;
        } else {
            str49 = str81;
            str50 = str16;
        }
        if ((i13 & 2) != 0) {
            str51 = str50;
            str52 = prebidInformation2.MyMax;
        } else {
            str51 = str50;
            str52 = str17;
        }
        if ((i13 & 4) != 0) {
            str53 = str52;
            obj12 = prebidInformation2.MyStock;
        } else {
            str53 = str52;
            obj12 = obj2;
        }
        if ((i13 & 8) != 0) {
            obj13 = obj12;
            obj14 = prebidInformation2.OutBidAmount;
        } else {
            obj13 = obj12;
            obj14 = obj3;
        }
        if ((i13 & 16) != 0) {
            obj15 = obj14;
            str54 = prebidInformation2.OutBidAmountNeededText;
        } else {
            obj15 = obj14;
            str54 = str18;
        }
        if ((i13 & 32) != 0) {
            str55 = str54;
            obj16 = prebidInformation2.PreBidHistory;
        } else {
            str55 = str54;
            obj16 = obj4;
        }
        if ((i13 & 64) != 0) {
            obj17 = obj16;
            z44 = prebidInformation2.PrebidAllowed;
        } else {
            obj17 = obj16;
            z44 = z14;
        }
        boolean z62 = z44;
        String str82 = (i13 & 128) != 0 ? prebidInformation2.PrebidAwardMesssage : str19;
        boolean z63 = (i13 & 256) != 0 ? prebidInformation2.PrebidClosed : z15;
        boolean z64 = (i13 & 512) != 0 ? prebidInformation2.isTransportationQuotesAvailable : z16;
        String str83 = (i13 & 1024) != 0 ? prebidInformation2.PrebidPayDate : str20;
        String str84 = (i13 & 2048) != 0 ? prebidInformation2.PrebidPickUpDate : str21;
        String str85 = (i13 & 4096) != 0 ? prebidInformation2.PrebidPopupErrorMessage : str22;
        boolean z65 = (i13 & 8192) != 0 ? prebidInformation2.ReserveMet : z17;
        String str86 = (i13 & 16384) != 0 ? prebidInformation2.SalesTaxWarningMessage : str23;
        if ((i13 & 32768) != 0) {
            str56 = str86;
            z45 = prebidInformation2.ShowCurrentBid;
        } else {
            str56 = str86;
            z45 = z18;
        }
        if ((i13 & 65536) != 0) {
            z46 = z45;
            z47 = prebidInformation2.ShowIBidLiveIcon;
        } else {
            z46 = z45;
            z47 = z19;
        }
        if ((i13 & 131072) != 0) {
            z48 = z47;
            z49 = prebidInformation2.ShowOutbidMessage;
        } else {
            z48 = z47;
            z49 = z20;
        }
        if ((i13 & 262144) != 0) {
            z50 = z49;
            z51 = prebidInformation2.ShowPrebidHistory;
        } else {
            z50 = z49;
            z51 = z21;
        }
        if ((i13 & 524288) != 0) {
            z52 = z51;
            i8 = prebidInformation2.StartBid;
        } else {
            z52 = z51;
            i8 = i3;
        }
        if ((i13 & 1048576) != 0) {
            i9 = i8;
            str57 = prebidInformation2.StartingBidAmountNeededText;
        } else {
            i9 = i8;
            str57 = str24;
        }
        if ((i13 & 2097152) != 0) {
            str58 = str57;
            obj18 = prebidInformation2.StringOutBidAmount;
        } else {
            str58 = str57;
            obj18 = obj5;
        }
        if ((i13 & 4194304) != 0) {
            obj19 = obj18;
            i10 = prebidInformation2.TimedAuctionBuyNowOfferstatus;
        } else {
            obj19 = obj18;
            i10 = i4;
        }
        if ((i13 & 8388608) != 0) {
            i11 = i10;
            str59 = prebidInformation2.TimedAuctionCloseTimeCST;
        } else {
            i11 = i10;
            str59 = str25;
        }
        if ((i13 & 16777216) != 0) {
            str60 = str59;
            str61 = prebidInformation2.TimedAuctionClosingStatus;
        } else {
            str60 = str59;
            str61 = str26;
        }
        if ((i13 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str62 = str61;
            obj20 = prebidInformation2.TimedAuctionDate;
        } else {
            str62 = str61;
            obj20 = obj6;
        }
        if ((i13 & 67108864) != 0) {
            obj21 = obj20;
            obj22 = prebidInformation2.TimedAuctionDateString;
        } else {
            obj21 = obj20;
            obj22 = obj7;
        }
        if ((i13 & 134217728) != 0) {
            obj23 = obj22;
            str63 = prebidInformation2.TimedAuctionDay;
        } else {
            obj23 = obj22;
            str63 = str27;
        }
        if ((i13 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str64 = str63;
            z53 = prebidInformation2.TimedAuctionInd;
        } else {
            str64 = str63;
            z53 = z22;
        }
        if ((i13 & 536870912) != 0) {
            z54 = z53;
            obj24 = prebidInformation2.TimedAuctionMonth;
        } else {
            z54 = z53;
            obj24 = obj8;
        }
        if ((i13 & 1073741824) != 0) {
            obj25 = obj24;
            obj26 = prebidInformation2.TimedAuctionSoldTime;
        } else {
            obj25 = obj24;
            obj26 = obj9;
        }
        boolean z66 = (i13 & Integer.MIN_VALUE) != 0 ? prebidInformation2.UserLoginStatus : z23;
        if ((i14 & 1) != 0) {
            z55 = z66;
            str65 = prebidInformation2.UserTimezoneAbb;
        } else {
            z55 = z66;
            str65 = str28;
        }
        if ((i14 & 2) != 0) {
            str66 = str65;
            str67 = prebidInformation2.VehicleStatus;
        } else {
            str66 = str65;
            str67 = str29;
        }
        if ((i14 & 4) != 0) {
            str68 = str67;
            z56 = prebidInformation2.VisibleBuyerFeeLink;
        } else {
            str68 = str67;
            z56 = z24;
        }
        if ((i14 & 8) != 0) {
            z57 = z56;
            obj27 = prebidInformation2.WhoCanBid;
        } else {
            z57 = z56;
            obj27 = obj10;
        }
        if ((i14 & 16) != 0) {
            obj28 = obj27;
            str69 = prebidInformation2.AuctionID;
        } else {
            obj28 = obj27;
            str69 = str30;
        }
        if ((i14 & 32) != 0) {
            str70 = str69;
            str71 = prebidInformation2.BuyNowCloseDate;
        } else {
            str70 = str69;
            str71 = str31;
        }
        if ((i14 & 64) != 0) {
            str72 = str71;
            str73 = prebidInformation2.LiveDateinUserTimeZone;
        } else {
            str72 = str71;
            str73 = str32;
        }
        return prebidInformation.copy(str74, num2, str75, str76, str77, str78, i15, i16, str79, z58, str80, obj29, z59, z60, z25, z27, z29, z31, str37, str39, str41, str43, str45, z33, z35, z37, z39, z41, z43, str47, str48, str49, str51, str53, obj13, obj15, str55, obj17, z62, str82, z63, z64, str83, str84, str85, z65, str56, z46, z48, z50, z52, i9, str58, obj19, i11, str60, str62, obj21, obj23, str64, z54, obj25, obj26, z55, str66, str68, z57, obj28, str70, str72, str73, (i14 & 128) != 0 ? prebidInformation2.IBFPickUpDate : str33, (i14 & 256) != 0 ? prebidInformation2.IBFPayDate : str34, (i14 & 512) != 0 ? prebidInformation2.IBFAwardMesssage : str35, (i14 & 1024) != 0 ? prebidInformation2.HidePreBidOnUpstreamBuyNow : bool);
    }

    @NotNull
    public final String component1() {
        return this.AdjustedCloseDate;
    }

    public final boolean component10() {
        return this.BuyNowSold;
    }

    @NotNull
    public final String component11() {
        return this.DecimalHighBidAmount;
    }

    @NotNull
    public final Object component12() {
        return this.DecimalOutBidAmount;
    }

    public final boolean component13() {
        return this.DisplayDeletedBidMsg;
    }

    public final boolean component14() {
        return this.DisplayHighPrebid;
    }

    public final boolean component15() {
        return this.DisplayPremiumReport;
    }

    public final boolean component16() {
        return this.DisplaySalesTaxWarning;
    }

    public final boolean component17() {
        return this.DisplaySalesTaxWarningLinks;
    }

    public final boolean component18() {
        return this.DisplayTaxLink;
    }

    @NotNull
    public final String component19() {
        return this.ErrorMessage;
    }

    @Nullable
    public final Integer component2() {
        return this.AuctionStatus;
    }

    @NotNull
    public final String component20() {
        return this.FormattedMyMax;
    }

    @Nullable
    public final String component21() {
        return this.HighBidAmount;
    }

    @Nullable
    public final String component22() {
        return this.HighBidder;
    }

    @Nullable
    public final String component23() {
        return this.IBFSoldMessage;
    }

    public final boolean component24() {
        return this.IbuyFastAllowed;
    }

    public final boolean component25() {
        return this.IsGuest;
    }

    public final boolean component26() {
        return this.IsHighPrebidder;
    }

    public final boolean component27() {
        return this.IsPreBidVisible;
    }

    public final boolean component28() {
        return this.IsPrebiddingDone;
    }

    public final boolean component29() {
        return this.IsPublic;
    }

    @Nullable
    public final String component3() {
        return this.AuctionStatusDescription;
    }

    @NotNull
    public final String component30() {
        return this.LiveDate;
    }

    @Nullable
    public final String component31() {
        return this.LosingBidStatus;
    }

    @NotNull
    public final String component32() {
        return this.ModifiedDate;
    }

    @NotNull
    public final String component33() {
        return this.MyCurrent;
    }

    @Nullable
    public final String component34() {
        return this.MyMax;
    }

    @NotNull
    public final Object component35() {
        return this.MyStock;
    }

    @NotNull
    public final Object component36() {
        return this.OutBidAmount;
    }

    @NotNull
    public final String component37() {
        return this.OutBidAmountNeededText;
    }

    @NotNull
    public final Object component38() {
        return this.PreBidHistory;
    }

    public final boolean component39() {
        return this.PrebidAllowed;
    }

    @NotNull
    public final String component4() {
        return this.BidCountText;
    }

    @NotNull
    public final String component40() {
        return this.PrebidAwardMesssage;
    }

    public final boolean component41() {
        return this.PrebidClosed;
    }

    public final boolean component42() {
        return this.isTransportationQuotesAvailable;
    }

    @NotNull
    public final String component43() {
        return this.PrebidPayDate;
    }

    @NotNull
    public final String component44() {
        return this.PrebidPickUpDate;
    }

    @Nullable
    public final String component45() {
        return this.PrebidPopupErrorMessage;
    }

    public final boolean component46() {
        return this.ReserveMet;
    }

    @NotNull
    public final String component47() {
        return this.SalesTaxWarningMessage;
    }

    public final boolean component48() {
        return this.ShowCurrentBid;
    }

    public final boolean component49() {
        return this.ShowIBidLiveIcon;
    }

    @NotNull
    public final String component5() {
        return this.BidText;
    }

    public final boolean component50() {
        return this.ShowOutbidMessage;
    }

    public final boolean component51() {
        return this.ShowPrebidHistory;
    }

    public final int component52() {
        return this.StartBid;
    }

    @NotNull
    public final String component53() {
        return this.StartingBidAmountNeededText;
    }

    @NotNull
    public final Object component54() {
        return this.StringOutBidAmount;
    }

    public final int component55() {
        return this.TimedAuctionBuyNowOfferstatus;
    }

    @NotNull
    public final String component56() {
        return this.TimedAuctionCloseTimeCST;
    }

    @NotNull
    public final String component57() {
        return this.TimedAuctionClosingStatus;
    }

    @NotNull
    public final Object component58() {
        return this.TimedAuctionDate;
    }

    @NotNull
    public final Object component59() {
        return this.TimedAuctionDateString;
    }

    @NotNull
    public final String component6() {
        return this.BiddingErrorMessage;
    }

    @NotNull
    public final String component60() {
        return this.TimedAuctionDay;
    }

    public final boolean component61() {
        return this.TimedAuctionInd;
    }

    @NotNull
    public final Object component62() {
        return this.TimedAuctionMonth;
    }

    @NotNull
    public final Object component63() {
        return this.TimedAuctionSoldTime;
    }

    public final boolean component64() {
        return this.UserLoginStatus;
    }

    @NotNull
    public final String component65() {
        return this.UserTimezoneAbb;
    }

    @NotNull
    public final String component66() {
        return this.VehicleStatus;
    }

    public final boolean component67() {
        return this.VisibleBuyerFeeLink;
    }

    @NotNull
    public final Object component68() {
        return this.WhoCanBid;
    }

    @NotNull
    public final String component69() {
        return this.AuctionID;
    }

    public final int component7() {
        return this.BranchCode;
    }

    @NotNull
    public final String component70() {
        return this.BuyNowCloseDate;
    }

    @Nullable
    public final String component71() {
        return this.LiveDateinUserTimeZone;
    }

    @Nullable
    public final String component72() {
        return this.IBFPickUpDate;
    }

    @Nullable
    public final String component73() {
        return this.IBFPayDate;
    }

    @Nullable
    public final String component74() {
        return this.IBFAwardMesssage;
    }

    @Nullable
    public final Boolean component75() {
        return this.HidePreBidOnUpstreamBuyNow;
    }

    public final int component8() {
        return this.BuyNowOfferAmount;
    }

    @NotNull
    public final String component9() {
        return this.BuyNowPrice;
    }

    @NotNull
    public final PrebidInformation copy(@NotNull String str, @Nullable Integer num, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, int i2, @NotNull String str6, boolean z, @NotNull String str7, @NotNull Object obj, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull String str8, @NotNull String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, @NotNull String str13, @Nullable String str14, @NotNull String str15, @NotNull String str16, @Nullable String str17, @NotNull Object obj2, @NotNull Object obj3, @NotNull String str18, @NotNull Object obj4, boolean z14, @NotNull String str19, boolean z15, boolean z16, @NotNull String str20, @NotNull String str21, @Nullable String str22, boolean z17, @NotNull String str23, boolean z18, boolean z19, boolean z20, boolean z21, int i3, @NotNull String str24, @NotNull Object obj5, int i4, @NotNull String str25, @NotNull String str26, @NotNull Object obj6, @NotNull Object obj7, @NotNull String str27, boolean z22, @NotNull Object obj8, @NotNull Object obj9, boolean z23, @NotNull String str28, @NotNull String str29, boolean z24, @NotNull Object obj10, @NotNull String str30, @NotNull String str31, @Nullable String str32, @Nullable String str33, @Nullable String str34, @Nullable String str35, @Nullable Boolean bool) {
        String str36 = str;
        Intrinsics.checkParameterIsNotNull(str36, "AdjustedCloseDate");
        Intrinsics.checkParameterIsNotNull(str3, "BidCountText");
        Intrinsics.checkParameterIsNotNull(str4, "BidText");
        Intrinsics.checkParameterIsNotNull(str5, "BiddingErrorMessage");
        Intrinsics.checkParameterIsNotNull(str6, "BuyNowPrice");
        Intrinsics.checkParameterIsNotNull(str7, "DecimalHighBidAmount");
        Intrinsics.checkParameterIsNotNull(obj, "DecimalOutBidAmount");
        Intrinsics.checkParameterIsNotNull(str8, "ErrorMessage");
        Intrinsics.checkParameterIsNotNull(str9, "FormattedMyMax");
        Intrinsics.checkParameterIsNotNull(str13, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str15, "ModifiedDate");
        Intrinsics.checkParameterIsNotNull(str16, "MyCurrent");
        Intrinsics.checkParameterIsNotNull(obj2, "MyStock");
        Intrinsics.checkParameterIsNotNull(obj3, "OutBidAmount");
        Intrinsics.checkParameterIsNotNull(str18, "OutBidAmountNeededText");
        Intrinsics.checkParameterIsNotNull(obj4, "PreBidHistory");
        Intrinsics.checkParameterIsNotNull(str19, "PrebidAwardMesssage");
        Intrinsics.checkParameterIsNotNull(str20, "PrebidPayDate");
        Intrinsics.checkParameterIsNotNull(str21, "PrebidPickUpDate");
        Intrinsics.checkParameterIsNotNull(str23, "SalesTaxWarningMessage");
        Intrinsics.checkParameterIsNotNull(str24, "StartingBidAmountNeededText");
        Intrinsics.checkParameterIsNotNull(obj5, "StringOutBidAmount");
        Intrinsics.checkParameterIsNotNull(str25, "TimedAuctionCloseTimeCST");
        Intrinsics.checkParameterIsNotNull(str26, "TimedAuctionClosingStatus");
        Intrinsics.checkParameterIsNotNull(obj6, "TimedAuctionDate");
        Intrinsics.checkParameterIsNotNull(obj7, "TimedAuctionDateString");
        Intrinsics.checkParameterIsNotNull(str27, "TimedAuctionDay");
        Intrinsics.checkParameterIsNotNull(obj8, "TimedAuctionMonth");
        Intrinsics.checkParameterIsNotNull(obj9, "TimedAuctionSoldTime");
        Intrinsics.checkParameterIsNotNull(str28, "UserTimezoneAbb");
        Intrinsics.checkParameterIsNotNull(str29, "VehicleStatus");
        Intrinsics.checkParameterIsNotNull(obj10, "WhoCanBid");
        Intrinsics.checkParameterIsNotNull(str30, "AuctionID");
        Intrinsics.checkParameterIsNotNull(str31, "BuyNowCloseDate");
        return new PrebidInformation(str36, num, str2, str3, str4, str5, i, i2, str6, z, str7, obj, z2, z3, z4, z5, z6, z7, str8, str9, str10, str11, str12, z8, z9, z10, z11, z12, z13, str13, str14, str15, str16, str17, obj2, obj3, str18, obj4, z14, str19, z15, z16, str20, str21, str22, z17, str23, z18, z19, z20, z21, i3, str24, obj5, i4, str25, str26, obj6, obj7, str27, z22, obj8, obj9, z23, str28, str29, z24, obj10, str30, str31, str32, str33, str34, str35, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PrebidInformation) {
                PrebidInformation prebidInformation = (PrebidInformation) obj;
                if (Intrinsics.areEqual((Object) this.AdjustedCloseDate, (Object) prebidInformation.AdjustedCloseDate) && Intrinsics.areEqual((Object) this.AuctionStatus, (Object) prebidInformation.AuctionStatus) && Intrinsics.areEqual((Object) this.AuctionStatusDescription, (Object) prebidInformation.AuctionStatusDescription) && Intrinsics.areEqual((Object) this.BidCountText, (Object) prebidInformation.BidCountText) && Intrinsics.areEqual((Object) this.BidText, (Object) prebidInformation.BidText) && Intrinsics.areEqual((Object) this.BiddingErrorMessage, (Object) prebidInformation.BiddingErrorMessage)) {
                    if (this.BranchCode == prebidInformation.BranchCode) {
                        if ((this.BuyNowOfferAmount == prebidInformation.BuyNowOfferAmount) && Intrinsics.areEqual((Object) this.BuyNowPrice, (Object) prebidInformation.BuyNowPrice)) {
                            if ((this.BuyNowSold == prebidInformation.BuyNowSold) && Intrinsics.areEqual((Object) this.DecimalHighBidAmount, (Object) prebidInformation.DecimalHighBidAmount) && Intrinsics.areEqual(this.DecimalOutBidAmount, prebidInformation.DecimalOutBidAmount)) {
                                if (this.DisplayDeletedBidMsg == prebidInformation.DisplayDeletedBidMsg) {
                                    if (this.DisplayHighPrebid == prebidInformation.DisplayHighPrebid) {
                                        if (this.DisplayPremiumReport == prebidInformation.DisplayPremiumReport) {
                                            if (this.DisplaySalesTaxWarning == prebidInformation.DisplaySalesTaxWarning) {
                                                if (this.DisplaySalesTaxWarningLinks == prebidInformation.DisplaySalesTaxWarningLinks) {
                                                    if ((this.DisplayTaxLink == prebidInformation.DisplayTaxLink) && Intrinsics.areEqual((Object) this.ErrorMessage, (Object) prebidInformation.ErrorMessage) && Intrinsics.areEqual((Object) this.FormattedMyMax, (Object) prebidInformation.FormattedMyMax) && Intrinsics.areEqual((Object) this.HighBidAmount, (Object) prebidInformation.HighBidAmount) && Intrinsics.areEqual((Object) this.HighBidder, (Object) prebidInformation.HighBidder) && Intrinsics.areEqual((Object) this.IBFSoldMessage, (Object) prebidInformation.IBFSoldMessage)) {
                                                        if (this.IbuyFastAllowed == prebidInformation.IbuyFastAllowed) {
                                                            if (this.IsGuest == prebidInformation.IsGuest) {
                                                                if (this.IsHighPrebidder == prebidInformation.IsHighPrebidder) {
                                                                    if (this.IsPreBidVisible == prebidInformation.IsPreBidVisible) {
                                                                        if (this.IsPrebiddingDone == prebidInformation.IsPrebiddingDone) {
                                                                            if ((this.IsPublic == prebidInformation.IsPublic) && Intrinsics.areEqual((Object) this.LiveDate, (Object) prebidInformation.LiveDate) && Intrinsics.areEqual((Object) this.LosingBidStatus, (Object) prebidInformation.LosingBidStatus) && Intrinsics.areEqual((Object) this.ModifiedDate, (Object) prebidInformation.ModifiedDate) && Intrinsics.areEqual((Object) this.MyCurrent, (Object) prebidInformation.MyCurrent) && Intrinsics.areEqual((Object) this.MyMax, (Object) prebidInformation.MyMax) && Intrinsics.areEqual(this.MyStock, prebidInformation.MyStock) && Intrinsics.areEqual(this.OutBidAmount, prebidInformation.OutBidAmount) && Intrinsics.areEqual((Object) this.OutBidAmountNeededText, (Object) prebidInformation.OutBidAmountNeededText) && Intrinsics.areEqual(this.PreBidHistory, prebidInformation.PreBidHistory)) {
                                                                                if ((this.PrebidAllowed == prebidInformation.PrebidAllowed) && Intrinsics.areEqual((Object) this.PrebidAwardMesssage, (Object) prebidInformation.PrebidAwardMesssage)) {
                                                                                    if (this.PrebidClosed == prebidInformation.PrebidClosed) {
                                                                                        if ((this.isTransportationQuotesAvailable == prebidInformation.isTransportationQuotesAvailable) && Intrinsics.areEqual((Object) this.PrebidPayDate, (Object) prebidInformation.PrebidPayDate) && Intrinsics.areEqual((Object) this.PrebidPickUpDate, (Object) prebidInformation.PrebidPickUpDate) && Intrinsics.areEqual((Object) this.PrebidPopupErrorMessage, (Object) prebidInformation.PrebidPopupErrorMessage)) {
                                                                                            if ((this.ReserveMet == prebidInformation.ReserveMet) && Intrinsics.areEqual((Object) this.SalesTaxWarningMessage, (Object) prebidInformation.SalesTaxWarningMessage)) {
                                                                                                if (this.ShowCurrentBid == prebidInformation.ShowCurrentBid) {
                                                                                                    if (this.ShowIBidLiveIcon == prebidInformation.ShowIBidLiveIcon) {
                                                                                                        if (this.ShowOutbidMessage == prebidInformation.ShowOutbidMessage) {
                                                                                                            if (this.ShowPrebidHistory == prebidInformation.ShowPrebidHistory) {
                                                                                                                if ((this.StartBid == prebidInformation.StartBid) && Intrinsics.areEqual((Object) this.StartingBidAmountNeededText, (Object) prebidInformation.StartingBidAmountNeededText) && Intrinsics.areEqual(this.StringOutBidAmount, prebidInformation.StringOutBidAmount)) {
                                                                                                                    if ((this.TimedAuctionBuyNowOfferstatus == prebidInformation.TimedAuctionBuyNowOfferstatus) && Intrinsics.areEqual((Object) this.TimedAuctionCloseTimeCST, (Object) prebidInformation.TimedAuctionCloseTimeCST) && Intrinsics.areEqual((Object) this.TimedAuctionClosingStatus, (Object) prebidInformation.TimedAuctionClosingStatus) && Intrinsics.areEqual(this.TimedAuctionDate, prebidInformation.TimedAuctionDate) && Intrinsics.areEqual(this.TimedAuctionDateString, prebidInformation.TimedAuctionDateString) && Intrinsics.areEqual((Object) this.TimedAuctionDay, (Object) prebidInformation.TimedAuctionDay)) {
                                                                                                                        if ((this.TimedAuctionInd == prebidInformation.TimedAuctionInd) && Intrinsics.areEqual(this.TimedAuctionMonth, prebidInformation.TimedAuctionMonth) && Intrinsics.areEqual(this.TimedAuctionSoldTime, prebidInformation.TimedAuctionSoldTime)) {
                                                                                                                            if ((this.UserLoginStatus == prebidInformation.UserLoginStatus) && Intrinsics.areEqual((Object) this.UserTimezoneAbb, (Object) prebidInformation.UserTimezoneAbb) && Intrinsics.areEqual((Object) this.VehicleStatus, (Object) prebidInformation.VehicleStatus)) {
                                                                                                                                if (!(this.VisibleBuyerFeeLink == prebidInformation.VisibleBuyerFeeLink) || !Intrinsics.areEqual(this.WhoCanBid, prebidInformation.WhoCanBid) || !Intrinsics.areEqual((Object) this.AuctionID, (Object) prebidInformation.AuctionID) || !Intrinsics.areEqual((Object) this.BuyNowCloseDate, (Object) prebidInformation.BuyNowCloseDate) || !Intrinsics.areEqual((Object) this.LiveDateinUserTimeZone, (Object) prebidInformation.LiveDateinUserTimeZone) || !Intrinsics.areEqual((Object) this.IBFPickUpDate, (Object) prebidInformation.IBFPickUpDate) || !Intrinsics.areEqual((Object) this.IBFPayDate, (Object) prebidInformation.IBFPayDate) || !Intrinsics.areEqual((Object) this.IBFAwardMesssage, (Object) prebidInformation.IBFAwardMesssage) || !Intrinsics.areEqual((Object) this.HidePreBidOnUpstreamBuyNow, (Object) prebidInformation.HidePreBidOnUpstreamBuyNow)) {
                                                                                                                                    return false;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
        String str = this.AdjustedCloseDate;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.AuctionStatus;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.AuctionStatusDescription;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.BidCountText;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.BidText;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.BiddingErrorMessage;
        int hashCode6 = (((((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.valueOf(this.BranchCode).hashCode()) * 31) + Integer.valueOf(this.BuyNowOfferAmount).hashCode()) * 31;
        String str6 = this.BuyNowPrice;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.BuyNowSold;
        if (z) {
            z = true;
        }
        int i2 = (hashCode7 + (z ? 1 : 0)) * 31;
        String str7 = this.DecimalHighBidAmount;
        int hashCode8 = (i2 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Object obj = this.DecimalOutBidAmount;
        int hashCode9 = (hashCode8 + (obj != null ? obj.hashCode() : 0)) * 31;
        boolean z2 = this.DisplayDeletedBidMsg;
        if (z2) {
            z2 = true;
        }
        int i3 = (hashCode9 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.DisplayHighPrebid;
        if (z3) {
            z3 = true;
        }
        int i4 = (i3 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.DisplayPremiumReport;
        if (z4) {
            z4 = true;
        }
        int i5 = (i4 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.DisplaySalesTaxWarning;
        if (z5) {
            z5 = true;
        }
        int i6 = (i5 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.DisplaySalesTaxWarningLinks;
        if (z6) {
            z6 = true;
        }
        int i7 = (i6 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.DisplayTaxLink;
        if (z7) {
            z7 = true;
        }
        int i8 = (i7 + (z7 ? 1 : 0)) * 31;
        String str8 = this.ErrorMessage;
        int hashCode10 = (i8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.FormattedMyMax;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.HighBidAmount;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.HighBidder;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.IBFSoldMessage;
        int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 31;
        boolean z8 = this.IbuyFastAllowed;
        if (z8) {
            z8 = true;
        }
        int i9 = (hashCode14 + (z8 ? 1 : 0)) * 31;
        boolean z9 = this.IsGuest;
        if (z9) {
            z9 = true;
        }
        int i10 = (i9 + (z9 ? 1 : 0)) * 31;
        boolean z10 = this.IsHighPrebidder;
        if (z10) {
            z10 = true;
        }
        int i11 = (i10 + (z10 ? 1 : 0)) * 31;
        boolean z11 = this.IsPreBidVisible;
        if (z11) {
            z11 = true;
        }
        int i12 = (i11 + (z11 ? 1 : 0)) * 31;
        boolean z12 = this.IsPrebiddingDone;
        if (z12) {
            z12 = true;
        }
        int i13 = (i12 + (z12 ? 1 : 0)) * 31;
        boolean z13 = this.IsPublic;
        if (z13) {
            z13 = true;
        }
        int i14 = (i13 + (z13 ? 1 : 0)) * 31;
        String str13 = this.LiveDate;
        int hashCode15 = (i14 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.LosingBidStatus;
        int hashCode16 = (hashCode15 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.ModifiedDate;
        int hashCode17 = (hashCode16 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.MyCurrent;
        int hashCode18 = (hashCode17 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.MyMax;
        int hashCode19 = (hashCode18 + (str17 != null ? str17.hashCode() : 0)) * 31;
        Object obj2 = this.MyStock;
        int hashCode20 = (hashCode19 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.OutBidAmount;
        int hashCode21 = (hashCode20 + (obj3 != null ? obj3.hashCode() : 0)) * 31;
        String str18 = this.OutBidAmountNeededText;
        int hashCode22 = (hashCode21 + (str18 != null ? str18.hashCode() : 0)) * 31;
        Object obj4 = this.PreBidHistory;
        int hashCode23 = (hashCode22 + (obj4 != null ? obj4.hashCode() : 0)) * 31;
        boolean z14 = this.PrebidAllowed;
        if (z14) {
            z14 = true;
        }
        int i15 = (hashCode23 + (z14 ? 1 : 0)) * 31;
        String str19 = this.PrebidAwardMesssage;
        int hashCode24 = (i15 + (str19 != null ? str19.hashCode() : 0)) * 31;
        boolean z15 = this.PrebidClosed;
        if (z15) {
            z15 = true;
        }
        int i16 = (hashCode24 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.isTransportationQuotesAvailable;
        if (z16) {
            z16 = true;
        }
        int i17 = (i16 + (z16 ? 1 : 0)) * 31;
        String str20 = this.PrebidPayDate;
        int hashCode25 = (i17 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.PrebidPickUpDate;
        int hashCode26 = (hashCode25 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.PrebidPopupErrorMessage;
        int hashCode27 = (hashCode26 + (str22 != null ? str22.hashCode() : 0)) * 31;
        boolean z17 = this.ReserveMet;
        if (z17) {
            z17 = true;
        }
        int i18 = (hashCode27 + (z17 ? 1 : 0)) * 31;
        String str23 = this.SalesTaxWarningMessage;
        int hashCode28 = (i18 + (str23 != null ? str23.hashCode() : 0)) * 31;
        boolean z18 = this.ShowCurrentBid;
        if (z18) {
            z18 = true;
        }
        int i19 = (hashCode28 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.ShowIBidLiveIcon;
        if (z19) {
            z19 = true;
        }
        int i20 = (i19 + (z19 ? 1 : 0)) * 31;
        boolean z20 = this.ShowOutbidMessage;
        if (z20) {
            z20 = true;
        }
        int i21 = (i20 + (z20 ? 1 : 0)) * 31;
        boolean z21 = this.ShowPrebidHistory;
        if (z21) {
            z21 = true;
        }
        int hashCode29 = (((i21 + (z21 ? 1 : 0)) * 31) + Integer.valueOf(this.StartBid).hashCode()) * 31;
        String str24 = this.StartingBidAmountNeededText;
        int hashCode30 = (hashCode29 + (str24 != null ? str24.hashCode() : 0)) * 31;
        Object obj5 = this.StringOutBidAmount;
        int hashCode31 = (((hashCode30 + (obj5 != null ? obj5.hashCode() : 0)) * 31) + Integer.valueOf(this.TimedAuctionBuyNowOfferstatus).hashCode()) * 31;
        String str25 = this.TimedAuctionCloseTimeCST;
        int hashCode32 = (hashCode31 + (str25 != null ? str25.hashCode() : 0)) * 31;
        String str26 = this.TimedAuctionClosingStatus;
        int hashCode33 = (hashCode32 + (str26 != null ? str26.hashCode() : 0)) * 31;
        Object obj6 = this.TimedAuctionDate;
        int hashCode34 = (hashCode33 + (obj6 != null ? obj6.hashCode() : 0)) * 31;
        Object obj7 = this.TimedAuctionDateString;
        int hashCode35 = (hashCode34 + (obj7 != null ? obj7.hashCode() : 0)) * 31;
        String str27 = this.TimedAuctionDay;
        int hashCode36 = (hashCode35 + (str27 != null ? str27.hashCode() : 0)) * 31;
        boolean z22 = this.TimedAuctionInd;
        if (z22) {
            z22 = true;
        }
        int i22 = (hashCode36 + (z22 ? 1 : 0)) * 31;
        Object obj8 = this.TimedAuctionMonth;
        int hashCode37 = (i22 + (obj8 != null ? obj8.hashCode() : 0)) * 31;
        Object obj9 = this.TimedAuctionSoldTime;
        int hashCode38 = (hashCode37 + (obj9 != null ? obj9.hashCode() : 0)) * 31;
        boolean z23 = this.UserLoginStatus;
        if (z23) {
            z23 = true;
        }
        int i23 = (hashCode38 + (z23 ? 1 : 0)) * 31;
        String str28 = this.UserTimezoneAbb;
        int hashCode39 = (i23 + (str28 != null ? str28.hashCode() : 0)) * 31;
        String str29 = this.VehicleStatus;
        int hashCode40 = (hashCode39 + (str29 != null ? str29.hashCode() : 0)) * 31;
        boolean z24 = this.VisibleBuyerFeeLink;
        if (z24) {
            z24 = true;
        }
        int i24 = (hashCode40 + (z24 ? 1 : 0)) * 31;
        Object obj10 = this.WhoCanBid;
        int hashCode41 = (i24 + (obj10 != null ? obj10.hashCode() : 0)) * 31;
        String str30 = this.AuctionID;
        int hashCode42 = (hashCode41 + (str30 != null ? str30.hashCode() : 0)) * 31;
        String str31 = this.BuyNowCloseDate;
        int hashCode43 = (hashCode42 + (str31 != null ? str31.hashCode() : 0)) * 31;
        String str32 = this.LiveDateinUserTimeZone;
        int hashCode44 = (hashCode43 + (str32 != null ? str32.hashCode() : 0)) * 31;
        String str33 = this.IBFPickUpDate;
        int hashCode45 = (hashCode44 + (str33 != null ? str33.hashCode() : 0)) * 31;
        String str34 = this.IBFPayDate;
        int hashCode46 = (hashCode45 + (str34 != null ? str34.hashCode() : 0)) * 31;
        String str35 = this.IBFAwardMesssage;
        int hashCode47 = (hashCode46 + (str35 != null ? str35.hashCode() : 0)) * 31;
        Boolean bool = this.HidePreBidOnUpstreamBuyNow;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode47 + i;
    }

    @NotNull
    public String toString() {
        return "PrebidInformation(AdjustedCloseDate=" + this.AdjustedCloseDate + ", AuctionStatus=" + this.AuctionStatus + ", AuctionStatusDescription=" + this.AuctionStatusDescription + ", BidCountText=" + this.BidCountText + ", BidText=" + this.BidText + ", BiddingErrorMessage=" + this.BiddingErrorMessage + ", BranchCode=" + this.BranchCode + ", BuyNowOfferAmount=" + this.BuyNowOfferAmount + ", BuyNowPrice=" + this.BuyNowPrice + ", BuyNowSold=" + this.BuyNowSold + ", DecimalHighBidAmount=" + this.DecimalHighBidAmount + ", DecimalOutBidAmount=" + this.DecimalOutBidAmount + ", DisplayDeletedBidMsg=" + this.DisplayDeletedBidMsg + ", DisplayHighPrebid=" + this.DisplayHighPrebid + ", DisplayPremiumReport=" + this.DisplayPremiumReport + ", DisplaySalesTaxWarning=" + this.DisplaySalesTaxWarning + ", DisplaySalesTaxWarningLinks=" + this.DisplaySalesTaxWarningLinks + ", DisplayTaxLink=" + this.DisplayTaxLink + ", ErrorMessage=" + this.ErrorMessage + ", FormattedMyMax=" + this.FormattedMyMax + ", HighBidAmount=" + this.HighBidAmount + ", HighBidder=" + this.HighBidder + ", IBFSoldMessage=" + this.IBFSoldMessage + ", IbuyFastAllowed=" + this.IbuyFastAllowed + ", IsGuest=" + this.IsGuest + ", IsHighPrebidder=" + this.IsHighPrebidder + ", IsPreBidVisible=" + this.IsPreBidVisible + ", IsPrebiddingDone=" + this.IsPrebiddingDone + ", IsPublic=" + this.IsPublic + ", LiveDate=" + this.LiveDate + ", LosingBidStatus=" + this.LosingBidStatus + ", ModifiedDate=" + this.ModifiedDate + ", MyCurrent=" + this.MyCurrent + ", MyMax=" + this.MyMax + ", MyStock=" + this.MyStock + ", OutBidAmount=" + this.OutBidAmount + ", OutBidAmountNeededText=" + this.OutBidAmountNeededText + ", PreBidHistory=" + this.PreBidHistory + ", PrebidAllowed=" + this.PrebidAllowed + ", PrebidAwardMesssage=" + this.PrebidAwardMesssage + ", PrebidClosed=" + this.PrebidClosed + ", isTransportationQuotesAvailable=" + this.isTransportationQuotesAvailable + ", PrebidPayDate=" + this.PrebidPayDate + ", PrebidPickUpDate=" + this.PrebidPickUpDate + ", PrebidPopupErrorMessage=" + this.PrebidPopupErrorMessage + ", ReserveMet=" + this.ReserveMet + ", SalesTaxWarningMessage=" + this.SalesTaxWarningMessage + ", ShowCurrentBid=" + this.ShowCurrentBid + ", ShowIBidLiveIcon=" + this.ShowIBidLiveIcon + ", ShowOutbidMessage=" + this.ShowOutbidMessage + ", ShowPrebidHistory=" + this.ShowPrebidHistory + ", StartBid=" + this.StartBid + ", StartingBidAmountNeededText=" + this.StartingBidAmountNeededText + ", StringOutBidAmount=" + this.StringOutBidAmount + ", TimedAuctionBuyNowOfferstatus=" + this.TimedAuctionBuyNowOfferstatus + ", TimedAuctionCloseTimeCST=" + this.TimedAuctionCloseTimeCST + ", TimedAuctionClosingStatus=" + this.TimedAuctionClosingStatus + ", TimedAuctionDate=" + this.TimedAuctionDate + ", TimedAuctionDateString=" + this.TimedAuctionDateString + ", TimedAuctionDay=" + this.TimedAuctionDay + ", TimedAuctionInd=" + this.TimedAuctionInd + ", TimedAuctionMonth=" + this.TimedAuctionMonth + ", TimedAuctionSoldTime=" + this.TimedAuctionSoldTime + ", UserLoginStatus=" + this.UserLoginStatus + ", UserTimezoneAbb=" + this.UserTimezoneAbb + ", VehicleStatus=" + this.VehicleStatus + ", VisibleBuyerFeeLink=" + this.VisibleBuyerFeeLink + ", WhoCanBid=" + this.WhoCanBid + ", AuctionID=" + this.AuctionID + ", BuyNowCloseDate=" + this.BuyNowCloseDate + ", LiveDateinUserTimeZone=" + this.LiveDateinUserTimeZone + ", IBFPickUpDate=" + this.IBFPickUpDate + ", IBFPayDate=" + this.IBFPayDate + ", IBFAwardMesssage=" + this.IBFAwardMesssage + ", HidePreBidOnUpstreamBuyNow=" + this.HidePreBidOnUpstreamBuyNow + ")";
    }

    public PrebidInformation(@NotNull String str, @Nullable Integer num, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, int i2, @NotNull String str6, boolean z, @NotNull String str7, @NotNull Object obj, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull String str8, @NotNull String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, @NotNull String str13, @Nullable String str14, @NotNull String str15, @NotNull String str16, @Nullable String str17, @NotNull Object obj2, @NotNull Object obj3, @NotNull String str18, @NotNull Object obj4, boolean z14, @NotNull String str19, boolean z15, boolean z16, @NotNull String str20, @NotNull String str21, @Nullable String str22, boolean z17, @NotNull String str23, boolean z18, boolean z19, boolean z20, boolean z21, int i3, @NotNull String str24, @NotNull Object obj5, int i4, @NotNull String str25, @NotNull String str26, @NotNull Object obj6, @NotNull Object obj7, @NotNull String str27, boolean z22, @NotNull Object obj8, @NotNull Object obj9, boolean z23, @NotNull String str28, @NotNull String str29, boolean z24, @NotNull Object obj10, @NotNull String str30, @NotNull String str31, @Nullable String str32, @Nullable String str33, @Nullable String str34, @Nullable String str35, @Nullable Boolean bool) {
        String str36 = str;
        String str37 = str3;
        String str38 = str4;
        String str39 = str5;
        String str40 = str6;
        String str41 = str7;
        Object obj11 = obj;
        String str42 = str8;
        String str43 = str9;
        String str44 = str13;
        String str45 = str15;
        String str46 = str16;
        Object obj12 = obj2;
        Object obj13 = obj3;
        Object obj14 = obj4;
        Intrinsics.checkParameterIsNotNull(str36, "AdjustedCloseDate");
        Intrinsics.checkParameterIsNotNull(str37, "BidCountText");
        Intrinsics.checkParameterIsNotNull(str38, "BidText");
        Intrinsics.checkParameterIsNotNull(str39, "BiddingErrorMessage");
        Intrinsics.checkParameterIsNotNull(str40, "BuyNowPrice");
        Intrinsics.checkParameterIsNotNull(str41, "DecimalHighBidAmount");
        Intrinsics.checkParameterIsNotNull(obj11, "DecimalOutBidAmount");
        Intrinsics.checkParameterIsNotNull(str42, "ErrorMessage");
        Intrinsics.checkParameterIsNotNull(str43, "FormattedMyMax");
        Intrinsics.checkParameterIsNotNull(str44, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str45, "ModifiedDate");
        Intrinsics.checkParameterIsNotNull(str46, "MyCurrent");
        Intrinsics.checkParameterIsNotNull(obj12, "MyStock");
        Intrinsics.checkParameterIsNotNull(obj13, "OutBidAmount");
        Intrinsics.checkParameterIsNotNull(str18, "OutBidAmountNeededText");
        Intrinsics.checkParameterIsNotNull(obj4, "PreBidHistory");
        Intrinsics.checkParameterIsNotNull(str19, "PrebidAwardMesssage");
        Intrinsics.checkParameterIsNotNull(str20, "PrebidPayDate");
        Intrinsics.checkParameterIsNotNull(str21, "PrebidPickUpDate");
        Intrinsics.checkParameterIsNotNull(str23, "SalesTaxWarningMessage");
        Intrinsics.checkParameterIsNotNull(str24, "StartingBidAmountNeededText");
        Intrinsics.checkParameterIsNotNull(obj5, "StringOutBidAmount");
        Intrinsics.checkParameterIsNotNull(str25, "TimedAuctionCloseTimeCST");
        Intrinsics.checkParameterIsNotNull(str26, "TimedAuctionClosingStatus");
        Intrinsics.checkParameterIsNotNull(obj6, "TimedAuctionDate");
        Intrinsics.checkParameterIsNotNull(obj7, "TimedAuctionDateString");
        Intrinsics.checkParameterIsNotNull(str27, "TimedAuctionDay");
        Intrinsics.checkParameterIsNotNull(obj8, "TimedAuctionMonth");
        Intrinsics.checkParameterIsNotNull(obj9, "TimedAuctionSoldTime");
        Intrinsics.checkParameterIsNotNull(str28, "UserTimezoneAbb");
        Intrinsics.checkParameterIsNotNull(str29, "VehicleStatus");
        Intrinsics.checkParameterIsNotNull(obj10, "WhoCanBid");
        Intrinsics.checkParameterIsNotNull(str30, "AuctionID");
        Intrinsics.checkParameterIsNotNull(str31, "BuyNowCloseDate");
        this.AdjustedCloseDate = str36;
        this.AuctionStatus = num;
        this.AuctionStatusDescription = str2;
        this.BidCountText = str37;
        this.BidText = str38;
        this.BiddingErrorMessage = str39;
        this.BranchCode = i;
        this.BuyNowOfferAmount = i2;
        this.BuyNowPrice = str40;
        this.BuyNowSold = z;
        this.DecimalHighBidAmount = str41;
        this.DecimalOutBidAmount = obj11;
        this.DisplayDeletedBidMsg = z2;
        this.DisplayHighPrebid = z3;
        this.DisplayPremiumReport = z4;
        this.DisplaySalesTaxWarning = z5;
        this.DisplaySalesTaxWarningLinks = z6;
        this.DisplayTaxLink = z7;
        this.ErrorMessage = str42;
        this.FormattedMyMax = str43;
        this.HighBidAmount = str10;
        this.HighBidder = str11;
        this.IBFSoldMessage = str12;
        this.IbuyFastAllowed = z8;
        this.IsGuest = z9;
        this.IsHighPrebidder = z10;
        this.IsPreBidVisible = z11;
        this.IsPrebiddingDone = z12;
        this.IsPublic = z13;
        this.LiveDate = str44;
        this.LosingBidStatus = str14;
        this.ModifiedDate = str45;
        this.MyCurrent = str46;
        this.MyMax = str17;
        this.MyStock = obj12;
        this.OutBidAmount = obj13;
        this.OutBidAmountNeededText = str18;
        this.PreBidHistory = obj4;
        this.PrebidAllowed = z14;
        this.PrebidAwardMesssage = str19;
        this.PrebidClosed = z15;
        this.isTransportationQuotesAvailable = z16;
        this.PrebidPayDate = str20;
        this.PrebidPickUpDate = str21;
        this.PrebidPopupErrorMessage = str22;
        this.ReserveMet = z17;
        this.SalesTaxWarningMessage = str23;
        this.ShowCurrentBid = z18;
        this.ShowIBidLiveIcon = z19;
        this.ShowOutbidMessage = z20;
        this.ShowPrebidHistory = z21;
        this.StartBid = i3;
        this.StartingBidAmountNeededText = str24;
        this.StringOutBidAmount = obj5;
        this.TimedAuctionBuyNowOfferstatus = i4;
        this.TimedAuctionCloseTimeCST = str25;
        this.TimedAuctionClosingStatus = str26;
        this.TimedAuctionDate = obj6;
        this.TimedAuctionDateString = obj7;
        this.TimedAuctionDay = str27;
        this.TimedAuctionInd = z22;
        this.TimedAuctionMonth = obj8;
        this.TimedAuctionSoldTime = obj9;
        this.UserLoginStatus = z23;
        this.UserTimezoneAbb = str28;
        this.VehicleStatus = str29;
        this.VisibleBuyerFeeLink = z24;
        this.WhoCanBid = obj10;
        this.AuctionID = str30;
        this.BuyNowCloseDate = str31;
        this.LiveDateinUserTimeZone = str32;
        this.IBFPickUpDate = str33;
        this.IBFPayDate = str34;
        this.IBFAwardMesssage = str35;
        this.HidePreBidOnUpstreamBuyNow = bool;
    }

    @NotNull
    public final String getAdjustedCloseDate() {
        return this.AdjustedCloseDate;
    }

    @Nullable
    public final Integer getAuctionStatus() {
        return this.AuctionStatus;
    }

    @Nullable
    public final String getAuctionStatusDescription() {
        return this.AuctionStatusDescription;
    }

    @NotNull
    public final String getBidCountText() {
        return this.BidCountText;
    }

    @NotNull
    public final String getBidText() {
        return this.BidText;
    }

    @NotNull
    public final String getBiddingErrorMessage() {
        return this.BiddingErrorMessage;
    }

    public final int getBranchCode() {
        return this.BranchCode;
    }

    public final int getBuyNowOfferAmount() {
        return this.BuyNowOfferAmount;
    }

    @NotNull
    public final String getBuyNowPrice() {
        return this.BuyNowPrice;
    }

    public final boolean getBuyNowSold() {
        return this.BuyNowSold;
    }

    @NotNull
    public final String getDecimalHighBidAmount() {
        return this.DecimalHighBidAmount;
    }

    @NotNull
    public final Object getDecimalOutBidAmount() {
        return this.DecimalOutBidAmount;
    }

    public final boolean getDisplayDeletedBidMsg() {
        return this.DisplayDeletedBidMsg;
    }

    public final boolean getDisplayHighPrebid() {
        return this.DisplayHighPrebid;
    }

    public final boolean getDisplayPremiumReport() {
        return this.DisplayPremiumReport;
    }

    public final boolean getDisplaySalesTaxWarning() {
        return this.DisplaySalesTaxWarning;
    }

    public final boolean getDisplaySalesTaxWarningLinks() {
        return this.DisplaySalesTaxWarningLinks;
    }

    public final boolean getDisplayTaxLink() {
        return this.DisplayTaxLink;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.ErrorMessage;
    }

    @NotNull
    public final String getFormattedMyMax() {
        return this.FormattedMyMax;
    }

    @Nullable
    public final String getHighBidAmount() {
        return this.HighBidAmount;
    }

    @Nullable
    public final String getHighBidder() {
        return this.HighBidder;
    }

    @Nullable
    public final String getIBFSoldMessage() {
        return this.IBFSoldMessage;
    }

    public final boolean getIbuyFastAllowed() {
        return this.IbuyFastAllowed;
    }

    public final boolean getIsGuest() {
        return this.IsGuest;
    }

    public final boolean getIsHighPrebidder() {
        return this.IsHighPrebidder;
    }

    public final boolean getIsPreBidVisible() {
        return this.IsPreBidVisible;
    }

    public final boolean getIsPrebiddingDone() {
        return this.IsPrebiddingDone;
    }

    public final boolean getIsPublic() {
        return this.IsPublic;
    }

    @NotNull
    public final String getLiveDate() {
        return this.LiveDate;
    }

    @Nullable
    public final String getLosingBidStatus() {
        return this.LosingBidStatus;
    }

    @NotNull
    public final String getModifiedDate() {
        return this.ModifiedDate;
    }

    @NotNull
    public final String getMyCurrent() {
        return this.MyCurrent;
    }

    @Nullable
    public final String getMyMax() {
        return this.MyMax;
    }

    @NotNull
    public final Object getMyStock() {
        return this.MyStock;
    }

    @NotNull
    public final Object getOutBidAmount() {
        return this.OutBidAmount;
    }

    @NotNull
    public final String getOutBidAmountNeededText() {
        return this.OutBidAmountNeededText;
    }

    @NotNull
    public final Object getPreBidHistory() {
        return this.PreBidHistory;
    }

    public final boolean getPrebidAllowed() {
        return this.PrebidAllowed;
    }

    @NotNull
    public final String getPrebidAwardMesssage() {
        return this.PrebidAwardMesssage;
    }

    public final boolean getPrebidClosed() {
        return this.PrebidClosed;
    }

    public final boolean isTransportationQuotesAvailable() {
        return this.isTransportationQuotesAvailable;
    }

    @NotNull
    public final String getPrebidPayDate() {
        return this.PrebidPayDate;
    }

    @NotNull
    public final String getPrebidPickUpDate() {
        return this.PrebidPickUpDate;
    }

    @Nullable
    public final String getPrebidPopupErrorMessage() {
        return this.PrebidPopupErrorMessage;
    }

    public final boolean getReserveMet() {
        return this.ReserveMet;
    }

    @NotNull
    public final String getSalesTaxWarningMessage() {
        return this.SalesTaxWarningMessage;
    }

    public final boolean getShowCurrentBid() {
        return this.ShowCurrentBid;
    }

    public final boolean getShowIBidLiveIcon() {
        return this.ShowIBidLiveIcon;
    }

    public final boolean getShowOutbidMessage() {
        return this.ShowOutbidMessage;
    }

    public final boolean getShowPrebidHistory() {
        return this.ShowPrebidHistory;
    }

    public final int getStartBid() {
        return this.StartBid;
    }

    @NotNull
    public final String getStartingBidAmountNeededText() {
        return this.StartingBidAmountNeededText;
    }

    @NotNull
    public final Object getStringOutBidAmount() {
        return this.StringOutBidAmount;
    }

    public final int getTimedAuctionBuyNowOfferstatus() {
        return this.TimedAuctionBuyNowOfferstatus;
    }

    @NotNull
    public final String getTimedAuctionCloseTimeCST() {
        return this.TimedAuctionCloseTimeCST;
    }

    @NotNull
    public final String getTimedAuctionClosingStatus() {
        return this.TimedAuctionClosingStatus;
    }

    @NotNull
    public final Object getTimedAuctionDate() {
        return this.TimedAuctionDate;
    }

    @NotNull
    public final Object getTimedAuctionDateString() {
        return this.TimedAuctionDateString;
    }

    @NotNull
    public final String getTimedAuctionDay() {
        return this.TimedAuctionDay;
    }

    public final boolean getTimedAuctionInd() {
        return this.TimedAuctionInd;
    }

    @NotNull
    public final Object getTimedAuctionMonth() {
        return this.TimedAuctionMonth;
    }

    @NotNull
    public final Object getTimedAuctionSoldTime() {
        return this.TimedAuctionSoldTime;
    }

    public final boolean getUserLoginStatus() {
        return this.UserLoginStatus;
    }

    @NotNull
    public final String getUserTimezoneAbb() {
        return this.UserTimezoneAbb;
    }

    @NotNull
    public final String getVehicleStatus() {
        return this.VehicleStatus;
    }

    public final boolean getVisibleBuyerFeeLink() {
        return this.VisibleBuyerFeeLink;
    }

    @NotNull
    public final Object getWhoCanBid() {
        return this.WhoCanBid;
    }

    @NotNull
    public final String getAuctionID() {
        return this.AuctionID;
    }

    @NotNull
    public final String getBuyNowCloseDate() {
        return this.BuyNowCloseDate;
    }

    @Nullable
    public final String getLiveDateinUserTimeZone() {
        return this.LiveDateinUserTimeZone;
    }

    @Nullable
    public final String getIBFPickUpDate() {
        return this.IBFPickUpDate;
    }

    @Nullable
    public final String getIBFPayDate() {
        return this.IBFPayDate;
    }

    @Nullable
    public final String getIBFAwardMesssage() {
        return this.IBFAwardMesssage;
    }

    @Nullable
    public final Boolean getHidePreBidOnUpstreamBuyNow() {
        return this.HidePreBidOnUpstreamBuyNow;
    }
}
