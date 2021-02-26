package com.iaai.android.bdt.model.toBePaid.paymentDueList;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b0\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 Î\u00012\u00020\u0001:\u0002Î\u0001B\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010+\u001a\u00020\u0007\u0012\u0006\u0010,\u001a\u00020\u0007\u0012\u0006\u0010-\u001a\u00020\u0007\u0012\u0006\u0010.\u001a\u00020\u0007\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00100\u001a\u00020\u0005\u0012\u0006\u00101\u001a\u00020\u0005\u0012\b\u00102\u001a\u0004\u0018\u00010\u0007\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00105\u001a\u00020\u0005\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00108\u001a\u00020\u0007\u0012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:\u0012\u0006\u0010<\u001a\u00020\t\u0012\u0006\u0010=\u001a\u00020\t\u0012\u0006\u0010>\u001a\u00020\t\u0012\u0006\u0010?\u001a\u00020\u0005\u0012\u0006\u0010@\u001a\u00020\u0005\u0012\u0006\u0010A\u001a\u00020\u0005¢\u0006\u0002\u0010BJ\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010HJ\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010HJ\n\u0010\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010HJ\n\u0010 \u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010KJ\n\u0010©\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010HJ\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0007HÆ\u0003J\u0012\u0010¶\u0001\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:HÆ\u0003J\n\u0010·\u0001\u001a\u00020\tHÆ\u0003J\n\u0010¸\u0001\u001a\u00020\tHÆ\u0003J\n\u0010¹\u0001\u001a\u00020\tHÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010½\u0001\u001a\u00020\tHÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010À\u0001\u001a\u00020\tHÆ\u0003J\u0005\u0010Á\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010#\u001a\u00020\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010+\u001a\u00020\u00072\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00105\u001a\u00020\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00108\u001a\u00020\u00072\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:2\b\b\u0002\u0010<\u001a\u00020\t2\b\b\u0002\u0010=\u001a\u00020\t2\b\b\u0002\u0010>\u001a\u00020\t2\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00052\b\b\u0002\u0010A\u001a\u00020\u0005HÆ\u0001¢\u0006\u0003\u0010Â\u0001J\n\u0010Ã\u0001\u001a\u00020\u0007HÖ\u0001J\u0016\u0010Ä\u0001\u001a\u00020\u00052\n\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001HÖ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010È\u0001\u001a\u00020\u0003HÖ\u0001J\u001e\u0010É\u0001\u001a\u00030Ê\u00012\b\u0010Ë\u0001\u001a\u00030Ì\u00012\u0007\u0010Í\u0001\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010L\u001a\u0004\bJ\u0010KR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010FR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010DR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bS\u0010OR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010DR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010DR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010DR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bW\u0010QR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bX\u0010QR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bY\u0010QR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010FR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010FR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010DR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010DR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u0010FR\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010FR\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b`\u0010FR\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\ba\u0010QR\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bb\u0010QR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010DR\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bd\u0010FR\u0015\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010I\u001a\u0004\be\u0010HR\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010DR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010DR\u0011\u0010#\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bh\u0010QR\u0015\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010I\u001a\u0004\bi\u0010HR\u0011\u0010%\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bj\u0010FR\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010FR\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010DR\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010DR\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010DR\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bo\u0010DR\u0011\u0010+\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bp\u0010QR\u0011\u0010,\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bq\u0010QR\u0011\u0010-\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\br\u0010QR\u0011\u0010.\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bs\u0010QR\u0013\u0010/\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bt\u0010DR\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bu\u0010FR\u0011\u00101\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bv\u0010FR\u0015\u00102\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010I\u001a\u0004\bw\u0010HR\u0013\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010DR\u0013\u00104\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010DR\u0011\u00105\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bz\u0010FR\u0013\u00107\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010DR\u0011\u0010=\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b|\u0010OR\u0011\u0010>\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b}\u0010OR\u0011\u0010<\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b~\u0010OR\u0013\u00106\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010DR\u001b\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0012\u00108\u001a\u00020\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010QR\u001c\u0010@\u001a\u00020\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b@\u0010F\"\u0006\b\u0001\u0010\u0001R\u001c\u0010A\u001a\u00020\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\bA\u0010F\"\u0006\b\u0001\u0010\u0001R\u001c\u0010?\u001a\u00020\u0005X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b?\u0010F\"\u0006\b\u0001\u0010\u0001¨\u0006Ï\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "Landroid/os/Parcelable;", "AFCDealerPhone", "", "AFCEligibileOnSoldDateInd", "", "AFCResponseErrorType", "", "AdjustedTotal", "", "Adjusted_Buyer_Charge_Tax_Ind", "Adjusted_Tax", "AuctionItemNumber", "AuctionLane", "BidAmount", "BidWonMethod", "BidderName", "BranchPhoneNumber", "BuyerChargeId", "Buyer_Employee_ID", "Buyer_ID", "CATInd", "ClearTitle", "DateWon", "Description", "DisclosureRequired", "EnableRow", "FinancedItem", "FreeLateDays", "FreeStorageDays", "IAABranchName", "IsVehicleEligibleForShipping", "Location", "Make", "Model", "OAAuctionId", "OAAuctionItemId", "Offsite_Sale_Ind", "Partial_Payment_Ind", "PaymentDueDate", "PaymentType", "PickUpDueDate", "Reference", "RowNumber", "SalvageBuyerChargeId", "SalvageId", "SalvageSaleId", "SalvageType", "ShowAsterisk", "ShowStockNoUrl", "StockNo", "StockNumber", "StorageLocationName", "TexasDealer", "VIN", "ThumbnailImageUrl", "Year", "VehicleFees", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/VehicleFees;", "TotalDue", "TotalAmount", "TotalAmountWithOutTaxAdjustment", "isSelected", "isFeeVisible", "isPaymentSuccess", "(Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Double;ZDILjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZLjava/lang/String;Ljava/lang/String;ZZZIILjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;ZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/util/List;DDDZZZ)V", "getAFCDealerPhone", "()Ljava/lang/String;", "getAFCEligibileOnSoldDateInd", "()Z", "getAFCResponseErrorType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdjustedTotal", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAdjusted_Buyer_Charge_Tax_Ind", "getAdjusted_Tax", "()D", "getAuctionItemNumber", "()I", "getAuctionLane", "getBidAmount", "getBidWonMethod", "getBidderName", "getBranchPhoneNumber", "getBuyerChargeId", "getBuyer_Employee_ID", "getBuyer_ID", "getCATInd", "getClearTitle", "getDateWon", "getDescription", "getDisclosureRequired", "getEnableRow", "getFinancedItem", "getFreeLateDays", "getFreeStorageDays", "getIAABranchName", "getIsVehicleEligibleForShipping", "getLocation", "getMake", "getModel", "getOAAuctionId", "getOAAuctionItemId", "getOffsite_Sale_Ind", "getPartial_Payment_Ind", "getPaymentDueDate", "getPaymentType", "getPickUpDueDate", "getReference", "getRowNumber", "getSalvageBuyerChargeId", "getSalvageId", "getSalvageSaleId", "getSalvageType", "getShowAsterisk", "getShowStockNoUrl", "getStockNo", "getStockNumber", "getStorageLocationName", "getTexasDealer", "getThumbnailImageUrl", "getTotalAmount", "getTotalAmountWithOutTaxAdjustment", "getTotalDue", "getVIN", "getVehicleFees", "()Ljava/util/List;", "getYear", "setFeeVisible", "(Z)V", "setPaymentSuccess", "setSelected", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Double;ZDILjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZLjava/lang/String;Ljava/lang/String;ZZZIILjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;ZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/util/List;DDDZZZ)Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: PaymentDue.kt */
public final class PaymentDue implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<PaymentDue> DIFF_CALLBACK = new PaymentDue$Companion$DIFF_CALLBACK$1();
    @Nullable
    private final String AFCDealerPhone;
    private final boolean AFCEligibileOnSoldDateInd;
    @Nullable
    private final Integer AFCResponseErrorType;
    @Nullable
    private final Double AdjustedTotal;
    private final boolean Adjusted_Buyer_Charge_Tax_Ind;
    private final double Adjusted_Tax;
    private final int AuctionItemNumber;
    @Nullable
    private final String AuctionLane;
    private final double BidAmount;
    @Nullable
    private final String BidWonMethod;
    @Nullable
    private final String BidderName;
    @Nullable
    private final String BranchPhoneNumber;
    private final int BuyerChargeId;
    private final int Buyer_Employee_ID;
    private final int Buyer_ID;
    private final boolean CATInd;
    private final boolean ClearTitle;
    @Nullable
    private final String DateWon;
    @Nullable
    private final String Description;
    private final boolean DisclosureRequired;
    private final boolean EnableRow;
    private final boolean FinancedItem;
    private final int FreeLateDays;
    private final int FreeStorageDays;
    @Nullable
    private final String IAABranchName;
    private final boolean IsVehicleEligibleForShipping;
    @Nullable
    private final Integer Location;
    @Nullable
    private final String Make;
    @Nullable
    private final String Model;
    private final int OAAuctionId;
    @Nullable
    private final Integer OAAuctionItemId;
    private final boolean Offsite_Sale_Ind;
    private final boolean Partial_Payment_Ind;
    @Nullable
    private final String PaymentDueDate;
    @Nullable
    private final String PaymentType;
    @Nullable
    private final String PickUpDueDate;
    @Nullable
    private final String Reference;
    private final int RowNumber;
    private final int SalvageBuyerChargeId;
    private final int SalvageId;
    private final int SalvageSaleId;
    @Nullable
    private final String SalvageType;
    private final boolean ShowAsterisk;
    private final boolean ShowStockNoUrl;
    @Nullable
    private final Integer StockNo;
    @Nullable
    private final String StockNumber;
    @Nullable
    private final String StorageLocationName;
    private final boolean TexasDealer;
    @Nullable
    private final String ThumbnailImageUrl;
    private final double TotalAmount;
    private final double TotalAmountWithOutTaxAdjustment;
    private final double TotalDue;
    @Nullable
    private final String VIN;
    @Nullable
    private final List<VehicleFees> VehicleFees;
    private final int Year;
    private boolean isFeeVisible;
    private boolean isPaymentSuccess;
    private boolean isSelected;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkParameterIsNotNull(parcel2, "in");
            String readString = parcel.readString();
            boolean z = parcel.readInt() != 0;
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Double valueOf2 = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
            boolean z2 = parcel.readInt() != 0;
            double readDouble = parcel.readDouble();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            double readDouble2 = parcel.readDouble();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            boolean z5 = parcel.readInt() != 0;
            boolean z6 = parcel.readInt() != 0;
            boolean z7 = parcel.readInt() != 0;
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            String readString8 = parcel.readString();
            boolean z8 = parcel.readInt() != 0;
            Integer valueOf3 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            int readInt7 = parcel.readInt();
            Integer valueOf4 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            boolean z9 = parcel.readInt() != 0;
            boolean z10 = parcel.readInt() != 0;
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            int readInt8 = parcel.readInt();
            int readInt9 = parcel.readInt();
            int readInt10 = parcel.readInt();
            int readInt11 = parcel.readInt();
            String readString15 = parcel.readString();
            boolean z11 = parcel.readInt() != 0;
            boolean z12 = parcel.readInt() != 0;
            Integer valueOf5 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString16 = parcel.readString();
            String readString17 = parcel.readString();
            boolean z13 = parcel.readInt() != 0;
            String readString18 = parcel.readString();
            String readString19 = parcel.readString();
            int readInt12 = parcel.readInt();
            if (parcel.readInt() != 0) {
                int readInt13 = parcel.readInt();
                arrayList = new ArrayList(readInt13);
                while (readInt13 != 0) {
                    arrayList.add((VehicleFees) VehicleFees.CREATOR.createFromParcel(parcel2));
                    readInt13--;
                }
            }
            return new PaymentDue(readString, z, valueOf, valueOf2, z2, readDouble, readInt, readString2, readDouble2, readString3, readString4, readString5, readInt2, readInt3, readInt4, z3, z4, readString6, readString7, z5, z6, z7, readInt5, readInt6, readString8, z8, valueOf3, readString9, readString10, readInt7, valueOf4, z9, z10, readString11, readString12, readString13, readString14, readInt8, readInt9, readInt10, readInt11, readString15, z11, z12, valueOf5, readString16, readString17, z13, readString18, readString19, readInt12, arrayList, parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PaymentDue[i];
        }
    }

    @NotNull
    public static /* synthetic */ PaymentDue copy$default(PaymentDue paymentDue, String str, boolean z, Integer num, Double d, boolean z2, double d2, int i, String str2, double d3, String str3, String str4, String str5, int i2, int i3, int i4, boolean z3, boolean z4, String str6, String str7, boolean z5, boolean z6, boolean z7, int i5, int i6, String str8, boolean z8, Integer num2, String str9, String str10, int i7, Integer num3, boolean z9, boolean z10, String str11, String str12, String str13, String str14, int i8, int i9, int i10, int i11, String str15, boolean z11, boolean z12, Integer num4, String str16, String str17, boolean z13, String str18, String str19, int i12, List list, double d4, double d5, double d6, boolean z14, boolean z15, boolean z16, int i13, int i14, Object obj) {
        int i15;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        String str20;
        String str21;
        String str22;
        String str23;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        int i16;
        int i17;
        int i18;
        int i19;
        String str24;
        String str25;
        boolean z27;
        boolean z28;
        Integer num5;
        Integer num6;
        String str26;
        String str27;
        String str28;
        String str29;
        int i20;
        int i21;
        Integer num7;
        boolean z29;
        boolean z30;
        boolean z31;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        int i22;
        int i23;
        int i24;
        String str38;
        boolean z32;
        boolean z33;
        String str39;
        String str40;
        String str41;
        String str42;
        int i25;
        int i26;
        List list2;
        Integer num8;
        String str43;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        boolean z34;
        PaymentDue paymentDue2 = paymentDue;
        int i27 = i13;
        int i28 = i14;
        String str44 = (i27 & 1) != 0 ? paymentDue2.AFCDealerPhone : str;
        boolean z35 = (i27 & 2) != 0 ? paymentDue2.AFCEligibileOnSoldDateInd : z;
        Integer num9 = (i27 & 4) != 0 ? paymentDue2.AFCResponseErrorType : num;
        Double d13 = (i27 & 8) != 0 ? paymentDue2.AdjustedTotal : d;
        boolean z36 = (i27 & 16) != 0 ? paymentDue2.Adjusted_Buyer_Charge_Tax_Ind : z2;
        double d14 = (i27 & 32) != 0 ? paymentDue2.Adjusted_Tax : d2;
        int i29 = (i27 & 64) != 0 ? paymentDue2.AuctionItemNumber : i;
        String str45 = (i27 & 128) != 0 ? paymentDue2.AuctionLane : str2;
        double d15 = (i27 & 256) != 0 ? paymentDue2.BidAmount : d3;
        String str46 = (i27 & 512) != 0 ? paymentDue2.BidWonMethod : str3;
        String str47 = (i27 & 1024) != 0 ? paymentDue2.BidderName : str4;
        String str48 = (i27 & 2048) != 0 ? paymentDue2.BranchPhoneNumber : str5;
        int i30 = (i27 & 4096) != 0 ? paymentDue2.BuyerChargeId : i2;
        int i31 = (i27 & 8192) != 0 ? paymentDue2.Buyer_Employee_ID : i3;
        int i32 = (i27 & 16384) != 0 ? paymentDue2.Buyer_ID : i4;
        if ((i27 & 32768) != 0) {
            i15 = i32;
            z17 = paymentDue2.CATInd;
        } else {
            i15 = i32;
            z17 = z3;
        }
        if ((i27 & 65536) != 0) {
            z18 = z17;
            z19 = paymentDue2.ClearTitle;
        } else {
            z18 = z17;
            z19 = z4;
        }
        if ((i27 & 131072) != 0) {
            z20 = z19;
            str20 = paymentDue2.DateWon;
        } else {
            z20 = z19;
            str20 = str6;
        }
        if ((i27 & 262144) != 0) {
            str21 = str20;
            str22 = paymentDue2.Description;
        } else {
            str21 = str20;
            str22 = str7;
        }
        if ((i27 & 524288) != 0) {
            str23 = str22;
            z21 = paymentDue2.DisclosureRequired;
        } else {
            str23 = str22;
            z21 = z5;
        }
        if ((i27 & 1048576) != 0) {
            z22 = z21;
            z23 = paymentDue2.EnableRow;
        } else {
            z22 = z21;
            z23 = z6;
        }
        if ((i27 & 2097152) != 0) {
            z24 = z23;
            z25 = paymentDue2.FinancedItem;
        } else {
            z24 = z23;
            z25 = z7;
        }
        if ((i27 & 4194304) != 0) {
            z26 = z25;
            i16 = paymentDue2.FreeLateDays;
        } else {
            z26 = z25;
            i16 = i5;
        }
        if ((i27 & 8388608) != 0) {
            i17 = i16;
            i18 = paymentDue2.FreeStorageDays;
        } else {
            i17 = i16;
            i18 = i6;
        }
        if ((i27 & 16777216) != 0) {
            i19 = i18;
            str24 = paymentDue2.IAABranchName;
        } else {
            i19 = i18;
            str24 = str8;
        }
        if ((i27 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str25 = str24;
            z27 = paymentDue2.IsVehicleEligibleForShipping;
        } else {
            str25 = str24;
            z27 = z8;
        }
        if ((i27 & 67108864) != 0) {
            z28 = z27;
            num5 = paymentDue2.Location;
        } else {
            z28 = z27;
            num5 = num2;
        }
        if ((i27 & 134217728) != 0) {
            num6 = num5;
            str26 = paymentDue2.Make;
        } else {
            num6 = num5;
            str26 = str9;
        }
        if ((i27 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str27 = str26;
            str28 = paymentDue2.Model;
        } else {
            str27 = str26;
            str28 = str10;
        }
        if ((i27 & 536870912) != 0) {
            str29 = str28;
            i20 = paymentDue2.OAAuctionId;
        } else {
            str29 = str28;
            i20 = i7;
        }
        if ((i27 & 1073741824) != 0) {
            i21 = i20;
            num7 = paymentDue2.OAAuctionItemId;
        } else {
            i21 = i20;
            num7 = num3;
        }
        boolean z37 = (i27 & Integer.MIN_VALUE) != 0 ? paymentDue2.Offsite_Sale_Ind : z9;
        if ((i28 & 1) != 0) {
            z29 = z37;
            z30 = paymentDue2.Partial_Payment_Ind;
        } else {
            z29 = z37;
            z30 = z10;
        }
        if ((i28 & 2) != 0) {
            z31 = z30;
            str30 = paymentDue2.PaymentDueDate;
        } else {
            z31 = z30;
            str30 = str11;
        }
        if ((i28 & 4) != 0) {
            str31 = str30;
            str32 = paymentDue2.PaymentType;
        } else {
            str31 = str30;
            str32 = str12;
        }
        if ((i28 & 8) != 0) {
            str33 = str32;
            str34 = paymentDue2.PickUpDueDate;
        } else {
            str33 = str32;
            str34 = str13;
        }
        if ((i28 & 16) != 0) {
            str35 = str34;
            str36 = paymentDue2.Reference;
        } else {
            str35 = str34;
            str36 = str14;
        }
        if ((i28 & 32) != 0) {
            str37 = str36;
            i22 = paymentDue2.RowNumber;
        } else {
            str37 = str36;
            i22 = i8;
        }
        if ((i28 & 64) != 0) {
            i23 = i22;
            i24 = paymentDue2.SalvageBuyerChargeId;
        } else {
            i23 = i22;
            i24 = i9;
        }
        int i33 = i24;
        int i34 = (i28 & 128) != 0 ? paymentDue2.SalvageId : i10;
        int i35 = (i28 & 256) != 0 ? paymentDue2.SalvageSaleId : i11;
        String str49 = (i28 & 512) != 0 ? paymentDue2.SalvageType : str15;
        boolean z38 = (i28 & 1024) != 0 ? paymentDue2.ShowAsterisk : z11;
        boolean z39 = (i28 & 2048) != 0 ? paymentDue2.ShowStockNoUrl : z12;
        Integer num10 = (i28 & 4096) != 0 ? paymentDue2.StockNo : num4;
        String str50 = (i28 & 8192) != 0 ? paymentDue2.StockNumber : str16;
        String str51 = (i28 & 16384) != 0 ? paymentDue2.StorageLocationName : str17;
        if ((i28 & 32768) != 0) {
            str38 = str51;
            z32 = paymentDue2.TexasDealer;
        } else {
            str38 = str51;
            z32 = z13;
        }
        if ((i28 & 65536) != 0) {
            z33 = z32;
            str39 = paymentDue2.VIN;
        } else {
            z33 = z32;
            str39 = str18;
        }
        if ((i28 & 131072) != 0) {
            str40 = str39;
            str41 = paymentDue2.ThumbnailImageUrl;
        } else {
            str40 = str39;
            str41 = str19;
        }
        if ((i28 & 262144) != 0) {
            str42 = str41;
            i25 = paymentDue2.Year;
        } else {
            str42 = str41;
            i25 = i12;
        }
        if ((i28 & 524288) != 0) {
            i26 = i25;
            list2 = paymentDue2.VehicleFees;
        } else {
            i26 = i25;
            list2 = list;
        }
        if ((i28 & 1048576) != 0) {
            str43 = str46;
            num8 = num7;
            d7 = paymentDue2.TotalDue;
        } else {
            str43 = str46;
            num8 = num7;
            d7 = d4;
        }
        if ((i28 & 2097152) != 0) {
            d8 = d7;
            d9 = paymentDue2.TotalAmount;
        } else {
            d8 = d7;
            d9 = d5;
        }
        if ((i28 & 4194304) != 0) {
            d10 = d9;
            d11 = paymentDue2.TotalAmountWithOutTaxAdjustment;
        } else {
            d10 = d9;
            d11 = d6;
        }
        if ((i28 & 8388608) != 0) {
            d12 = d11;
            z34 = paymentDue2.isSelected;
        } else {
            d12 = d11;
            z34 = z14;
        }
        return paymentDue.copy(str44, z35, num9, d13, z36, d14, i29, str45, d15, str43, str47, str48, i30, i31, i15, z18, z20, str21, str23, z22, z24, z26, i17, i19, str25, z28, num6, str27, str29, i21, num8, z29, z31, str31, str33, str35, str37, i23, i33, i34, i35, str49, z38, z39, num10, str50, str38, z33, str40, str42, i26, list2, d8, d10, d12, z34, (16777216 & i28) != 0 ? paymentDue2.isFeeVisible : z15, (i28 & PdfFormField.FF_RADIOSINUNISON) != 0 ? paymentDue2.isPaymentSuccess : z16);
    }

    @Nullable
    public final String component1() {
        return this.AFCDealerPhone;
    }

    @Nullable
    public final String component10() {
        return this.BidWonMethod;
    }

    @Nullable
    public final String component11() {
        return this.BidderName;
    }

    @Nullable
    public final String component12() {
        return this.BranchPhoneNumber;
    }

    public final int component13() {
        return this.BuyerChargeId;
    }

    public final int component14() {
        return this.Buyer_Employee_ID;
    }

    public final int component15() {
        return this.Buyer_ID;
    }

    public final boolean component16() {
        return this.CATInd;
    }

    public final boolean component17() {
        return this.ClearTitle;
    }

    @Nullable
    public final String component18() {
        return this.DateWon;
    }

    @Nullable
    public final String component19() {
        return this.Description;
    }

    public final boolean component2() {
        return this.AFCEligibileOnSoldDateInd;
    }

    public final boolean component20() {
        return this.DisclosureRequired;
    }

    public final boolean component21() {
        return this.EnableRow;
    }

    public final boolean component22() {
        return this.FinancedItem;
    }

    public final int component23() {
        return this.FreeLateDays;
    }

    public final int component24() {
        return this.FreeStorageDays;
    }

    @Nullable
    public final String component25() {
        return this.IAABranchName;
    }

    public final boolean component26() {
        return this.IsVehicleEligibleForShipping;
    }

    @Nullable
    public final Integer component27() {
        return this.Location;
    }

    @Nullable
    public final String component28() {
        return this.Make;
    }

    @Nullable
    public final String component29() {
        return this.Model;
    }

    @Nullable
    public final Integer component3() {
        return this.AFCResponseErrorType;
    }

    public final int component30() {
        return this.OAAuctionId;
    }

    @Nullable
    public final Integer component31() {
        return this.OAAuctionItemId;
    }

    public final boolean component32() {
        return this.Offsite_Sale_Ind;
    }

    public final boolean component33() {
        return this.Partial_Payment_Ind;
    }

    @Nullable
    public final String component34() {
        return this.PaymentDueDate;
    }

    @Nullable
    public final String component35() {
        return this.PaymentType;
    }

    @Nullable
    public final String component36() {
        return this.PickUpDueDate;
    }

    @Nullable
    public final String component37() {
        return this.Reference;
    }

    public final int component38() {
        return this.RowNumber;
    }

    public final int component39() {
        return this.SalvageBuyerChargeId;
    }

    @Nullable
    public final Double component4() {
        return this.AdjustedTotal;
    }

    public final int component40() {
        return this.SalvageId;
    }

    public final int component41() {
        return this.SalvageSaleId;
    }

    @Nullable
    public final String component42() {
        return this.SalvageType;
    }

    public final boolean component43() {
        return this.ShowAsterisk;
    }

    public final boolean component44() {
        return this.ShowStockNoUrl;
    }

    @Nullable
    public final Integer component45() {
        return this.StockNo;
    }

    @Nullable
    public final String component46() {
        return this.StockNumber;
    }

    @Nullable
    public final String component47() {
        return this.StorageLocationName;
    }

    public final boolean component48() {
        return this.TexasDealer;
    }

    @Nullable
    public final String component49() {
        return this.VIN;
    }

    public final boolean component5() {
        return this.Adjusted_Buyer_Charge_Tax_Ind;
    }

    @Nullable
    public final String component50() {
        return this.ThumbnailImageUrl;
    }

    public final int component51() {
        return this.Year;
    }

    @Nullable
    public final List<VehicleFees> component52() {
        return this.VehicleFees;
    }

    public final double component53() {
        return this.TotalDue;
    }

    public final double component54() {
        return this.TotalAmount;
    }

    public final double component55() {
        return this.TotalAmountWithOutTaxAdjustment;
    }

    public final boolean component56() {
        return this.isSelected;
    }

    public final boolean component57() {
        return this.isFeeVisible;
    }

    public final boolean component58() {
        return this.isPaymentSuccess;
    }

    public final double component6() {
        return this.Adjusted_Tax;
    }

    public final int component7() {
        return this.AuctionItemNumber;
    }

    @Nullable
    public final String component8() {
        return this.AuctionLane;
    }

    public final double component9() {
        return this.BidAmount;
    }

    @NotNull
    public final PaymentDue copy(@Nullable String str, boolean z, @Nullable Integer num, @Nullable Double d, boolean z2, double d2, int i, @Nullable String str2, double d3, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i2, int i3, int i4, boolean z3, boolean z4, @Nullable String str6, @Nullable String str7, boolean z5, boolean z6, boolean z7, int i5, int i6, @Nullable String str8, boolean z8, @Nullable Integer num2, @Nullable String str9, @Nullable String str10, int i7, @Nullable Integer num3, boolean z9, boolean z10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, int i8, int i9, int i10, int i11, @Nullable String str15, boolean z11, boolean z12, @Nullable Integer num4, @Nullable String str16, @Nullable String str17, boolean z13, @Nullable String str18, @Nullable String str19, int i12, @Nullable List<VehicleFees> list, double d4, double d5, double d6, boolean z14, boolean z15, boolean z16) {
        return new PaymentDue(str, z, num, d, z2, d2, i, str2, d3, str3, str4, str5, i2, i3, i4, z3, z4, str6, str7, z5, z6, z7, i5, i6, str8, z8, num2, str9, str10, i7, num3, z9, z10, str11, str12, str13, str14, i8, i9, i10, i11, str15, z11, z12, num4, str16, str17, z13, str18, str19, i12, list, d4, d5, d6, z14, z15, z16);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PaymentDue) {
                PaymentDue paymentDue = (PaymentDue) obj;
                if (Intrinsics.areEqual((Object) this.AFCDealerPhone, (Object) paymentDue.AFCDealerPhone)) {
                    if ((this.AFCEligibileOnSoldDateInd == paymentDue.AFCEligibileOnSoldDateInd) && Intrinsics.areEqual((Object) this.AFCResponseErrorType, (Object) paymentDue.AFCResponseErrorType) && Intrinsics.areEqual((Object) this.AdjustedTotal, (Object) paymentDue.AdjustedTotal)) {
                        if ((this.Adjusted_Buyer_Charge_Tax_Ind == paymentDue.Adjusted_Buyer_Charge_Tax_Ind) && Double.compare(this.Adjusted_Tax, paymentDue.Adjusted_Tax) == 0) {
                            if ((this.AuctionItemNumber == paymentDue.AuctionItemNumber) && Intrinsics.areEqual((Object) this.AuctionLane, (Object) paymentDue.AuctionLane) && Double.compare(this.BidAmount, paymentDue.BidAmount) == 0 && Intrinsics.areEqual((Object) this.BidWonMethod, (Object) paymentDue.BidWonMethod) && Intrinsics.areEqual((Object) this.BidderName, (Object) paymentDue.BidderName) && Intrinsics.areEqual((Object) this.BranchPhoneNumber, (Object) paymentDue.BranchPhoneNumber)) {
                                if (this.BuyerChargeId == paymentDue.BuyerChargeId) {
                                    if (this.Buyer_Employee_ID == paymentDue.Buyer_Employee_ID) {
                                        if (this.Buyer_ID == paymentDue.Buyer_ID) {
                                            if (this.CATInd == paymentDue.CATInd) {
                                                if ((this.ClearTitle == paymentDue.ClearTitle) && Intrinsics.areEqual((Object) this.DateWon, (Object) paymentDue.DateWon) && Intrinsics.areEqual((Object) this.Description, (Object) paymentDue.Description)) {
                                                    if (this.DisclosureRequired == paymentDue.DisclosureRequired) {
                                                        if (this.EnableRow == paymentDue.EnableRow) {
                                                            if (this.FinancedItem == paymentDue.FinancedItem) {
                                                                if (this.FreeLateDays == paymentDue.FreeLateDays) {
                                                                    if ((this.FreeStorageDays == paymentDue.FreeStorageDays) && Intrinsics.areEqual((Object) this.IAABranchName, (Object) paymentDue.IAABranchName)) {
                                                                        if ((this.IsVehicleEligibleForShipping == paymentDue.IsVehicleEligibleForShipping) && Intrinsics.areEqual((Object) this.Location, (Object) paymentDue.Location) && Intrinsics.areEqual((Object) this.Make, (Object) paymentDue.Make) && Intrinsics.areEqual((Object) this.Model, (Object) paymentDue.Model)) {
                                                                            if ((this.OAAuctionId == paymentDue.OAAuctionId) && Intrinsics.areEqual((Object) this.OAAuctionItemId, (Object) paymentDue.OAAuctionItemId)) {
                                                                                if (this.Offsite_Sale_Ind == paymentDue.Offsite_Sale_Ind) {
                                                                                    if ((this.Partial_Payment_Ind == paymentDue.Partial_Payment_Ind) && Intrinsics.areEqual((Object) this.PaymentDueDate, (Object) paymentDue.PaymentDueDate) && Intrinsics.areEqual((Object) this.PaymentType, (Object) paymentDue.PaymentType) && Intrinsics.areEqual((Object) this.PickUpDueDate, (Object) paymentDue.PickUpDueDate) && Intrinsics.areEqual((Object) this.Reference, (Object) paymentDue.Reference)) {
                                                                                        if (this.RowNumber == paymentDue.RowNumber) {
                                                                                            if (this.SalvageBuyerChargeId == paymentDue.SalvageBuyerChargeId) {
                                                                                                if (this.SalvageId == paymentDue.SalvageId) {
                                                                                                    if ((this.SalvageSaleId == paymentDue.SalvageSaleId) && Intrinsics.areEqual((Object) this.SalvageType, (Object) paymentDue.SalvageType)) {
                                                                                                        if (this.ShowAsterisk == paymentDue.ShowAsterisk) {
                                                                                                            if ((this.ShowStockNoUrl == paymentDue.ShowStockNoUrl) && Intrinsics.areEqual((Object) this.StockNo, (Object) paymentDue.StockNo) && Intrinsics.areEqual((Object) this.StockNumber, (Object) paymentDue.StockNumber) && Intrinsics.areEqual((Object) this.StorageLocationName, (Object) paymentDue.StorageLocationName)) {
                                                                                                                if ((this.TexasDealer == paymentDue.TexasDealer) && Intrinsics.areEqual((Object) this.VIN, (Object) paymentDue.VIN) && Intrinsics.areEqual((Object) this.ThumbnailImageUrl, (Object) paymentDue.ThumbnailImageUrl)) {
                                                                                                                    if ((this.Year == paymentDue.Year) && Intrinsics.areEqual((Object) this.VehicleFees, (Object) paymentDue.VehicleFees) && Double.compare(this.TotalDue, paymentDue.TotalDue) == 0 && Double.compare(this.TotalAmount, paymentDue.TotalAmount) == 0 && Double.compare(this.TotalAmountWithOutTaxAdjustment, paymentDue.TotalAmountWithOutTaxAdjustment) == 0) {
                                                                                                                        if (this.isSelected == paymentDue.isSelected) {
                                                                                                                            if (this.isFeeVisible == paymentDue.isFeeVisible) {
                                                                                                                                if (this.isPaymentSuccess == paymentDue.isPaymentSuccess) {
                                                                                                                                    return true;
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
        String str = this.AFCDealerPhone;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.AFCEligibileOnSoldDateInd;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        Integer num = this.AFCResponseErrorType;
        int hashCode2 = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        Double d = this.AdjustedTotal;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 31;
        boolean z2 = this.Adjusted_Buyer_Charge_Tax_Ind;
        if (z2) {
            z2 = true;
        }
        int hashCode4 = (((((hashCode3 + (z2 ? 1 : 0)) * 31) + Double.valueOf(this.Adjusted_Tax).hashCode()) * 31) + Integer.valueOf(this.AuctionItemNumber).hashCode()) * 31;
        String str2 = this.AuctionLane;
        int hashCode5 = (((hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + Double.valueOf(this.BidAmount).hashCode()) * 31;
        String str3 = this.BidWonMethod;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.BidderName;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.BranchPhoneNumber;
        int hashCode8 = (((((((hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.valueOf(this.BuyerChargeId).hashCode()) * 31) + Integer.valueOf(this.Buyer_Employee_ID).hashCode()) * 31) + Integer.valueOf(this.Buyer_ID).hashCode()) * 31;
        boolean z3 = this.CATInd;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode8 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.ClearTitle;
        if (z4) {
            z4 = true;
        }
        int i4 = (i3 + (z4 ? 1 : 0)) * 31;
        String str6 = this.DateWon;
        int hashCode9 = (i4 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.Description;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z5 = this.DisclosureRequired;
        if (z5) {
            z5 = true;
        }
        int i5 = (hashCode10 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.EnableRow;
        if (z6) {
            z6 = true;
        }
        int i6 = (i5 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.FinancedItem;
        if (z7) {
            z7 = true;
        }
        int hashCode11 = (((((i6 + (z7 ? 1 : 0)) * 31) + Integer.valueOf(this.FreeLateDays).hashCode()) * 31) + Integer.valueOf(this.FreeStorageDays).hashCode()) * 31;
        String str8 = this.IAABranchName;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z8 = this.IsVehicleEligibleForShipping;
        if (z8) {
            z8 = true;
        }
        int i7 = (hashCode12 + (z8 ? 1 : 0)) * 31;
        Integer num2 = this.Location;
        int hashCode13 = (i7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str9 = this.Make;
        int hashCode14 = (hashCode13 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.Model;
        int hashCode15 = (((hashCode14 + (str10 != null ? str10.hashCode() : 0)) * 31) + Integer.valueOf(this.OAAuctionId).hashCode()) * 31;
        Integer num3 = this.OAAuctionItemId;
        int hashCode16 = (hashCode15 + (num3 != null ? num3.hashCode() : 0)) * 31;
        boolean z9 = this.Offsite_Sale_Ind;
        if (z9) {
            z9 = true;
        }
        int i8 = (hashCode16 + (z9 ? 1 : 0)) * 31;
        boolean z10 = this.Partial_Payment_Ind;
        if (z10) {
            z10 = true;
        }
        int i9 = (i8 + (z10 ? 1 : 0)) * 31;
        String str11 = this.PaymentDueDate;
        int hashCode17 = (i9 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.PaymentType;
        int hashCode18 = (hashCode17 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.PickUpDueDate;
        int hashCode19 = (hashCode18 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.Reference;
        int hashCode20 = (((((((((hashCode19 + (str14 != null ? str14.hashCode() : 0)) * 31) + Integer.valueOf(this.RowNumber).hashCode()) * 31) + Integer.valueOf(this.SalvageBuyerChargeId).hashCode()) * 31) + Integer.valueOf(this.SalvageId).hashCode()) * 31) + Integer.valueOf(this.SalvageSaleId).hashCode()) * 31;
        String str15 = this.SalvageType;
        int hashCode21 = (hashCode20 + (str15 != null ? str15.hashCode() : 0)) * 31;
        boolean z11 = this.ShowAsterisk;
        if (z11) {
            z11 = true;
        }
        int i10 = (hashCode21 + (z11 ? 1 : 0)) * 31;
        boolean z12 = this.ShowStockNoUrl;
        if (z12) {
            z12 = true;
        }
        int i11 = (i10 + (z12 ? 1 : 0)) * 31;
        Integer num4 = this.StockNo;
        int hashCode22 = (i11 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str16 = this.StockNumber;
        int hashCode23 = (hashCode22 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.StorageLocationName;
        int hashCode24 = (hashCode23 + (str17 != null ? str17.hashCode() : 0)) * 31;
        boolean z13 = this.TexasDealer;
        if (z13) {
            z13 = true;
        }
        int i12 = (hashCode24 + (z13 ? 1 : 0)) * 31;
        String str18 = this.VIN;
        int hashCode25 = (i12 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.ThumbnailImageUrl;
        int hashCode26 = (((hashCode25 + (str19 != null ? str19.hashCode() : 0)) * 31) + Integer.valueOf(this.Year).hashCode()) * 31;
        List<VehicleFees> list = this.VehicleFees;
        if (list != null) {
            i = list.hashCode();
        }
        int hashCode27 = (((((((hashCode26 + i) * 31) + Double.valueOf(this.TotalDue).hashCode()) * 31) + Double.valueOf(this.TotalAmount).hashCode()) * 31) + Double.valueOf(this.TotalAmountWithOutTaxAdjustment).hashCode()) * 31;
        boolean z14 = this.isSelected;
        if (z14) {
            z14 = true;
        }
        int i13 = (hashCode27 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.isFeeVisible;
        if (z15) {
            z15 = true;
        }
        int i14 = (i13 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.isPaymentSuccess;
        if (z16) {
            z16 = true;
        }
        return i14 + (z16 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "PaymentDue(AFCDealerPhone=" + this.AFCDealerPhone + ", AFCEligibileOnSoldDateInd=" + this.AFCEligibileOnSoldDateInd + ", AFCResponseErrorType=" + this.AFCResponseErrorType + ", AdjustedTotal=" + this.AdjustedTotal + ", Adjusted_Buyer_Charge_Tax_Ind=" + this.Adjusted_Buyer_Charge_Tax_Ind + ", Adjusted_Tax=" + this.Adjusted_Tax + ", AuctionItemNumber=" + this.AuctionItemNumber + ", AuctionLane=" + this.AuctionLane + ", BidAmount=" + this.BidAmount + ", BidWonMethod=" + this.BidWonMethod + ", BidderName=" + this.BidderName + ", BranchPhoneNumber=" + this.BranchPhoneNumber + ", BuyerChargeId=" + this.BuyerChargeId + ", Buyer_Employee_ID=" + this.Buyer_Employee_ID + ", Buyer_ID=" + this.Buyer_ID + ", CATInd=" + this.CATInd + ", ClearTitle=" + this.ClearTitle + ", DateWon=" + this.DateWon + ", Description=" + this.Description + ", DisclosureRequired=" + this.DisclosureRequired + ", EnableRow=" + this.EnableRow + ", FinancedItem=" + this.FinancedItem + ", FreeLateDays=" + this.FreeLateDays + ", FreeStorageDays=" + this.FreeStorageDays + ", IAABranchName=" + this.IAABranchName + ", IsVehicleEligibleForShipping=" + this.IsVehicleEligibleForShipping + ", Location=" + this.Location + ", Make=" + this.Make + ", Model=" + this.Model + ", OAAuctionId=" + this.OAAuctionId + ", OAAuctionItemId=" + this.OAAuctionItemId + ", Offsite_Sale_Ind=" + this.Offsite_Sale_Ind + ", Partial_Payment_Ind=" + this.Partial_Payment_Ind + ", PaymentDueDate=" + this.PaymentDueDate + ", PaymentType=" + this.PaymentType + ", PickUpDueDate=" + this.PickUpDueDate + ", Reference=" + this.Reference + ", RowNumber=" + this.RowNumber + ", SalvageBuyerChargeId=" + this.SalvageBuyerChargeId + ", SalvageId=" + this.SalvageId + ", SalvageSaleId=" + this.SalvageSaleId + ", SalvageType=" + this.SalvageType + ", ShowAsterisk=" + this.ShowAsterisk + ", ShowStockNoUrl=" + this.ShowStockNoUrl + ", StockNo=" + this.StockNo + ", StockNumber=" + this.StockNumber + ", StorageLocationName=" + this.StorageLocationName + ", TexasDealer=" + this.TexasDealer + ", VIN=" + this.VIN + ", ThumbnailImageUrl=" + this.ThumbnailImageUrl + ", Year=" + this.Year + ", VehicleFees=" + this.VehicleFees + ", TotalDue=" + this.TotalDue + ", TotalAmount=" + this.TotalAmount + ", TotalAmountWithOutTaxAdjustment=" + this.TotalAmountWithOutTaxAdjustment + ", isSelected=" + this.isSelected + ", isFeeVisible=" + this.isFeeVisible + ", isPaymentSuccess=" + this.isPaymentSuccess + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.AFCDealerPhone);
        parcel.writeInt(this.AFCEligibileOnSoldDateInd ? 1 : 0);
        Integer num = this.AFCResponseErrorType;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Double d = this.AdjustedTotal;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.Adjusted_Buyer_Charge_Tax_Ind ? 1 : 0);
        parcel.writeDouble(this.Adjusted_Tax);
        parcel.writeInt(this.AuctionItemNumber);
        parcel.writeString(this.AuctionLane);
        parcel.writeDouble(this.BidAmount);
        parcel.writeString(this.BidWonMethod);
        parcel.writeString(this.BidderName);
        parcel.writeString(this.BranchPhoneNumber);
        parcel.writeInt(this.BuyerChargeId);
        parcel.writeInt(this.Buyer_Employee_ID);
        parcel.writeInt(this.Buyer_ID);
        parcel.writeInt(this.CATInd ? 1 : 0);
        parcel.writeInt(this.ClearTitle ? 1 : 0);
        parcel.writeString(this.DateWon);
        parcel.writeString(this.Description);
        parcel.writeInt(this.DisclosureRequired ? 1 : 0);
        parcel.writeInt(this.EnableRow ? 1 : 0);
        parcel.writeInt(this.FinancedItem ? 1 : 0);
        parcel.writeInt(this.FreeLateDays);
        parcel.writeInt(this.FreeStorageDays);
        parcel.writeString(this.IAABranchName);
        parcel.writeInt(this.IsVehicleEligibleForShipping ? 1 : 0);
        Integer num2 = this.Location;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.Make);
        parcel.writeString(this.Model);
        parcel.writeInt(this.OAAuctionId);
        Integer num3 = this.OAAuctionItemId;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.Offsite_Sale_Ind ? 1 : 0);
        parcel.writeInt(this.Partial_Payment_Ind ? 1 : 0);
        parcel.writeString(this.PaymentDueDate);
        parcel.writeString(this.PaymentType);
        parcel.writeString(this.PickUpDueDate);
        parcel.writeString(this.Reference);
        parcel.writeInt(this.RowNumber);
        parcel.writeInt(this.SalvageBuyerChargeId);
        parcel.writeInt(this.SalvageId);
        parcel.writeInt(this.SalvageSaleId);
        parcel.writeString(this.SalvageType);
        parcel.writeInt(this.ShowAsterisk ? 1 : 0);
        parcel.writeInt(this.ShowStockNoUrl ? 1 : 0);
        Integer num4 = this.StockNo;
        if (num4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.StockNumber);
        parcel.writeString(this.StorageLocationName);
        parcel.writeInt(this.TexasDealer ? 1 : 0);
        parcel.writeString(this.VIN);
        parcel.writeString(this.ThumbnailImageUrl);
        parcel.writeInt(this.Year);
        List<VehicleFees> list = this.VehicleFees;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (VehicleFees writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeDouble(this.TotalDue);
        parcel.writeDouble(this.TotalAmount);
        parcel.writeDouble(this.TotalAmountWithOutTaxAdjustment);
        parcel.writeInt(this.isSelected ? 1 : 0);
        parcel.writeInt(this.isFeeVisible ? 1 : 0);
        parcel.writeInt(this.isPaymentSuccess ? 1 : 0);
    }

    public PaymentDue(@Nullable String str, boolean z, @Nullable Integer num, @Nullable Double d, boolean z2, double d2, int i, @Nullable String str2, double d3, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i2, int i3, int i4, boolean z3, boolean z4, @Nullable String str6, @Nullable String str7, boolean z5, boolean z6, boolean z7, int i5, int i6, @Nullable String str8, boolean z8, @Nullable Integer num2, @Nullable String str9, @Nullable String str10, int i7, @Nullable Integer num3, boolean z9, boolean z10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, int i8, int i9, int i10, int i11, @Nullable String str15, boolean z11, boolean z12, @Nullable Integer num4, @Nullable String str16, @Nullable String str17, boolean z13, @Nullable String str18, @Nullable String str19, int i12, @Nullable List<VehicleFees> list, double d4, double d5, double d6, boolean z14, boolean z15, boolean z16) {
        this.AFCDealerPhone = str;
        this.AFCEligibileOnSoldDateInd = z;
        this.AFCResponseErrorType = num;
        this.AdjustedTotal = d;
        this.Adjusted_Buyer_Charge_Tax_Ind = z2;
        this.Adjusted_Tax = d2;
        this.AuctionItemNumber = i;
        this.AuctionLane = str2;
        this.BidAmount = d3;
        this.BidWonMethod = str3;
        this.BidderName = str4;
        this.BranchPhoneNumber = str5;
        this.BuyerChargeId = i2;
        this.Buyer_Employee_ID = i3;
        this.Buyer_ID = i4;
        this.CATInd = z3;
        this.ClearTitle = z4;
        this.DateWon = str6;
        this.Description = str7;
        this.DisclosureRequired = z5;
        this.EnableRow = z6;
        this.FinancedItem = z7;
        this.FreeLateDays = i5;
        this.FreeStorageDays = i6;
        this.IAABranchName = str8;
        this.IsVehicleEligibleForShipping = z8;
        this.Location = num2;
        this.Make = str9;
        this.Model = str10;
        this.OAAuctionId = i7;
        this.OAAuctionItemId = num3;
        this.Offsite_Sale_Ind = z9;
        this.Partial_Payment_Ind = z10;
        this.PaymentDueDate = str11;
        this.PaymentType = str12;
        this.PickUpDueDate = str13;
        this.Reference = str14;
        this.RowNumber = i8;
        this.SalvageBuyerChargeId = i9;
        this.SalvageId = i10;
        this.SalvageSaleId = i11;
        this.SalvageType = str15;
        this.ShowAsterisk = z11;
        this.ShowStockNoUrl = z12;
        this.StockNo = num4;
        this.StockNumber = str16;
        this.StorageLocationName = str17;
        this.TexasDealer = z13;
        this.VIN = str18;
        this.ThumbnailImageUrl = str19;
        this.Year = i12;
        this.VehicleFees = list;
        this.TotalDue = d4;
        this.TotalAmount = d5;
        this.TotalAmountWithOutTaxAdjustment = d6;
        this.isSelected = z14;
        this.isFeeVisible = z15;
        this.isPaymentSuccess = z16;
    }

    @Nullable
    public final String getAFCDealerPhone() {
        return this.AFCDealerPhone;
    }

    public final boolean getAFCEligibileOnSoldDateInd() {
        return this.AFCEligibileOnSoldDateInd;
    }

    @Nullable
    public final Integer getAFCResponseErrorType() {
        return this.AFCResponseErrorType;
    }

    @Nullable
    public final Double getAdjustedTotal() {
        return this.AdjustedTotal;
    }

    public final boolean getAdjusted_Buyer_Charge_Tax_Ind() {
        return this.Adjusted_Buyer_Charge_Tax_Ind;
    }

    public final double getAdjusted_Tax() {
        return this.Adjusted_Tax;
    }

    public final int getAuctionItemNumber() {
        return this.AuctionItemNumber;
    }

    @Nullable
    public final String getAuctionLane() {
        return this.AuctionLane;
    }

    public final double getBidAmount() {
        return this.BidAmount;
    }

    @Nullable
    public final String getBidWonMethod() {
        return this.BidWonMethod;
    }

    @Nullable
    public final String getBidderName() {
        return this.BidderName;
    }

    @Nullable
    public final String getBranchPhoneNumber() {
        return this.BranchPhoneNumber;
    }

    public final int getBuyerChargeId() {
        return this.BuyerChargeId;
    }

    public final int getBuyer_Employee_ID() {
        return this.Buyer_Employee_ID;
    }

    public final int getBuyer_ID() {
        return this.Buyer_ID;
    }

    public final boolean getCATInd() {
        return this.CATInd;
    }

    public final boolean getClearTitle() {
        return this.ClearTitle;
    }

    @Nullable
    public final String getDateWon() {
        return this.DateWon;
    }

    @Nullable
    public final String getDescription() {
        return this.Description;
    }

    public final boolean getDisclosureRequired() {
        return this.DisclosureRequired;
    }

    public final boolean getEnableRow() {
        return this.EnableRow;
    }

    public final boolean getFinancedItem() {
        return this.FinancedItem;
    }

    public final int getFreeLateDays() {
        return this.FreeLateDays;
    }

    public final int getFreeStorageDays() {
        return this.FreeStorageDays;
    }

    @Nullable
    public final String getIAABranchName() {
        return this.IAABranchName;
    }

    public final boolean getIsVehicleEligibleForShipping() {
        return this.IsVehicleEligibleForShipping;
    }

    @Nullable
    public final Integer getLocation() {
        return this.Location;
    }

    @Nullable
    public final String getMake() {
        return this.Make;
    }

    @Nullable
    public final String getModel() {
        return this.Model;
    }

    public final int getOAAuctionId() {
        return this.OAAuctionId;
    }

    @Nullable
    public final Integer getOAAuctionItemId() {
        return this.OAAuctionItemId;
    }

    public final boolean getOffsite_Sale_Ind() {
        return this.Offsite_Sale_Ind;
    }

    public final boolean getPartial_Payment_Ind() {
        return this.Partial_Payment_Ind;
    }

    @Nullable
    public final String getPaymentDueDate() {
        return this.PaymentDueDate;
    }

    @Nullable
    public final String getPaymentType() {
        return this.PaymentType;
    }

    @Nullable
    public final String getPickUpDueDate() {
        return this.PickUpDueDate;
    }

    @Nullable
    public final String getReference() {
        return this.Reference;
    }

    public final int getRowNumber() {
        return this.RowNumber;
    }

    public final int getSalvageBuyerChargeId() {
        return this.SalvageBuyerChargeId;
    }

    public final int getSalvageId() {
        return this.SalvageId;
    }

    public final int getSalvageSaleId() {
        return this.SalvageSaleId;
    }

    @Nullable
    public final String getSalvageType() {
        return this.SalvageType;
    }

    public final boolean getShowAsterisk() {
        return this.ShowAsterisk;
    }

    public final boolean getShowStockNoUrl() {
        return this.ShowStockNoUrl;
    }

    @Nullable
    public final Integer getStockNo() {
        return this.StockNo;
    }

    @Nullable
    public final String getStockNumber() {
        return this.StockNumber;
    }

    @Nullable
    public final String getStorageLocationName() {
        return this.StorageLocationName;
    }

    public final boolean getTexasDealer() {
        return this.TexasDealer;
    }

    @Nullable
    public final String getVIN() {
        return this.VIN;
    }

    @Nullable
    public final String getThumbnailImageUrl() {
        return this.ThumbnailImageUrl;
    }

    public final int getYear() {
        return this.Year;
    }

    @Nullable
    public final List<VehicleFees> getVehicleFees() {
        return this.VehicleFees;
    }

    public final double getTotalDue() {
        return this.TotalDue;
    }

    public final double getTotalAmount() {
        return this.TotalAmount;
    }

    public final double getTotalAmountWithOutTaxAdjustment() {
        return this.TotalAmountWithOutTaxAdjustment;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean isFeeVisible() {
        return this.isFeeVisible;
    }

    public final void setFeeVisible(boolean z) {
        this.isFeeVisible = z;
    }

    public final boolean isPaymentSuccess() {
        return this.isPaymentSuccess;
    }

    public final void setPaymentSuccess(boolean z) {
        this.isPaymentSuccess = z;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDIFF_CALLBACK", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PaymentDue.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<PaymentDue> getDIFF_CALLBACK() {
            return PaymentDue.DIFF_CALLBACK;
        }

        public final void setDIFF_CALLBACK(@NotNull DiffUtil.ItemCallback<PaymentDue> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            PaymentDue.DIFF_CALLBACK = itemCallback;
        }
    }
}
