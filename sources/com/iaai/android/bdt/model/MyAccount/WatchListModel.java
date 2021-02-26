package com.iaai.android.bdt.model.MyAccount;

import androidx.recyclerview.widget.DiffUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b;\n\u0002\u0010\u000b\n\u0003\b¯\u0001\u0018\u0000 ú\u00012\u00020\u0001:\u0002ú\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R \u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0005\"\u0004\b \u0010\u0007R \u0010!\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0005\"\u0004\b#\u0010\u0007R \u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\"\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\rR \u0010*\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0005\"\u0004\b,\u0010\u0007R \u0010-\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\"\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\rR \u00103\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R \u00106\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R \u00109\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0005\"\u0004\b;\u0010\u0007R \u0010<\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0005\"\u0004\b>\u0010\u0007R \u0010?\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R \u0010B\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R \u0010E\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R \u0010H\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0005\"\u0004\bJ\u0010\u0007R\"\u0010K\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR \u0010U\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0012\"\u0004\bW\u0010\u0014R \u0010X\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0012\"\u0004\bZ\u0010\u0014R\"\u0010[\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\b\\\u0010N\"\u0004\b]\u0010PR \u0010^\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0005\"\u0004\b`\u0010\u0007R \u0010a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0012\"\u0004\bc\u0010\u0014R \u0010d\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0005\"\u0004\bf\u0010\u0007R\"\u0010g\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bh\u0010N\"\u0004\bi\u0010PR\"\u0010j\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bk\u0010N\"\u0004\bl\u0010PR \u0010m\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0012\"\u0004\bo\u0010\u0014R \u0010p\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0012\"\u0004\br\u0010\u0014R \u0010s\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0005\"\u0004\bu\u0010\u0007R \u0010v\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0012\"\u0004\bx\u0010\u0014R\"\u0010y\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bz\u0010N\"\u0004\b{\u0010PR\"\u0010|\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\b}\u0010N\"\u0004\b~\u0010PR$\u0010\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\b\u0001\u0010N\"\u0005\b\u0001\u0010PR%\u0010\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\b\u0001\u0010N\"\u0005\b\u0001\u0010PR#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010\u0014R#\u0010 \u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010\u0005\"\u0005\b¢\u0001\u0010\u0007R#\u0010£\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\u0012\"\u0005\b¥\u0001\u0010\u0014R#\u0010¦\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010\u0005\"\u0005\b¨\u0001\u0010\u0007R#\u0010©\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010\u0012\"\u0005\b«\u0001\u0010\u0014R#\u0010¬\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b­\u0001\u0010\u0005\"\u0005\b®\u0001\u0010\u0007R#\u0010¯\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010\u0005\"\u0005\b±\u0001\u0010\u0007R#\u0010²\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010\u0012\"\u0005\b´\u0001\u0010\u0014R%\u0010µ\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\b¶\u0001\u0010N\"\u0005\b·\u0001\u0010PR%\u0010¸\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010\u000e\u001a\u0005\b¹\u0001\u0010\u000b\"\u0005\bº\u0001\u0010\rR%\u0010»\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\b¼\u0001\u0010N\"\u0005\b½\u0001\u0010PR#\u0010¾\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010\u0005\"\u0005\bÀ\u0001\u0010\u0007R%\u0010Á\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\bÂ\u0001\u0010N\"\u0005\bÃ\u0001\u0010PR#\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010\u0012\"\u0005\bÆ\u0001\u0010\u0014R#\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÈ\u0001\u0010\u0012\"\u0005\bÉ\u0001\u0010\u0014R%\u0010Ê\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010\u000e\u001a\u0005\bË\u0001\u0010\u000b\"\u0005\bÌ\u0001\u0010\rR#\u0010Í\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010\u0012\"\u0005\bÏ\u0001\u0010\u0014R#\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010\u0012\"\u0005\bÒ\u0001\u0010\u0014R%\u0010Ó\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\bÔ\u0001\u0010N\"\u0005\bÕ\u0001\u0010PR#\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010\u0005\"\u0005\bØ\u0001\u0010\u0007R#\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\u0005\"\u0005\bÛ\u0001\u0010\u0007R#\u0010Ü\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0001\u0010\u0005\"\u0005\bÞ\u0001\u0010\u0007R#\u0010ß\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010\u0005\"\u0005\bá\u0001\u0010\u0007R#\u0010â\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010\u0005\"\u0005\bä\u0001\u0010\u0007R%\u0010å\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\bæ\u0001\u0010N\"\u0005\bç\u0001\u0010PR#\u0010è\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0001\u0010\u0005\"\u0005\bê\u0001\u0010\u0007R#\u0010ë\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0001\u0010\u0005\"\u0005\bí\u0001\u0010\u0007R#\u0010î\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bï\u0001\u0010\u0005\"\u0005\bð\u0001\u0010\u0007R%\u0010ñ\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\bò\u0001\u0010N\"\u0005\bó\u0001\u0010PR%\u0010ô\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010Q\u001a\u0005\bõ\u0001\u0010N\"\u0005\bö\u0001\u0010PR#\u0010÷\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bø\u0001\u0010\u0012\"\u0005\bù\u0001\u0010\u0014¨\u0006û\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "", "()V", "aBidWonMethod", "getABidWonMethod", "()Ljava/lang/Object;", "setABidWonMethod", "(Ljava/lang/Object;)V", "aBidamount", "", "getABidamount", "()Ljava/lang/Integer;", "setABidamount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "adjClosedate", "", "getAdjClosedate", "()Ljava/lang/String;", "setAdjClosedate", "(Ljava/lang/String;)V", "adjLiveDate", "getAdjLiveDate", "setAdjLiveDate", "auctionDate", "getAuctionDate", "setAuctionDate", "auctionId", "getAuctionId", "setAuctionId", "auctionLane", "getAuctionLane", "setAuctionLane", "auctionStartsAt", "getAuctionStartsAt", "setAuctionStartsAt", "bidStatus", "getBidStatus", "setBidStatus", "bidamount", "getBidamount", "setBidamount", "bidderName", "getBidderName", "setBidderName", "branchname", "getBranchname", "setBranchname", "code", "getCode", "setCode", "currentHigh", "getCurrentHigh", "setCurrentHigh", "damage", "getDamage", "setDamage", "datepaidstring", "getDatepaidstring", "setDatepaidstring", "feesAndTax", "getFeesAndTax", "setFeesAndTax", "floatingFifthElement", "getFloatingFifthElement", "setFloatingFifthElement", "formattedAdjCloseDate", "getFormattedAdjCloseDate", "setFormattedAdjCloseDate", "formattedAdjLiveDate", "getFormattedAdjLiveDate", "setFormattedAdjLiveDate", "fourthElementHistory", "getFourthElementHistory", "setFourthElementHistory", "iBNACQualified", "", "getIBNACQualified", "()Ljava/lang/Boolean;", "setIBNACQualified", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "iBNSold", "getIBNSold", "setIBNSold", "imageURL", "getImageURL", "setImageURL", "itemid", "getItemid", "setItemid", "itempublicauction", "getItempublicauction", "setItempublicauction", "liveDatePreSale", "getLiveDatePreSale", "setLiveDatePreSale", "lossType", "getLossType", "setLossType", "losstype", "getLosstype", "setLosstype", "lost", "getLost", "setLost", "lostPrebid", "getLostPrebid", "setLostPrebid", "make", "getMake", "setMake", "model", "getModel", "setModel", "odobrand", "getOdobrand", "setOdobrand", "odometer", "getOdometer", "setOdometer", "offsiteSaleIndicator", "getOffsiteSaleIndicator", "setOffsiteSaleIndicator", "onlyWatchList", "getOnlyWatchList", "setOnlyWatchList", "outbid", "getOutbid", "setOutbid", "own", "getOwn", "setOwn", "paPaymentDueDate", "getPaPaymentDueDate", "setPaPaymentDueDate", "paPickUpDueDate", "getPaPickUpDueDate", "setPaPickUpDueDate", "paymentduedate", "getPaymentduedate", "setPaymentduedate", "pickduedate", "getPickduedate", "setPickduedate", "pickedupDate", "getPickedupDate", "setPickedupDate", "pickedupdatestring", "getPickedupdatestring", "setPickedupdatestring", "prebidClosesAt", "getPrebidClosesAt", "setPrebidClosesAt", "prebidStatus", "getPrebidStatus", "setPrebidStatus", "prebidStatusColor", "getPrebidStatusColor", "setPrebidStatusColor", "predictedTimeOnBlock", "getPredictedTimeOnBlock", "setPredictedTimeOnBlock", "providerName", "getProviderName", "setProviderName", "puDatePaid", "getPuDatePaid", "setPuDatePaid", "puPickUpDueDate", "getPuPickUpDueDate", "setPuPickUpDueDate", "receiptDescription", "getReceiptDescription", "setReceiptDescription", "receiptNo", "getReceiptNo", "setReceiptNo", "rowOwner", "getRowOwner", "setRowOwner", "runAndDrive", "getRunAndDrive", "setRunAndDrive", "salvageId", "getSalvageId", "setSalvageId", "sealedIndicator", "getSealedIndicator", "setSealedIndicator", "series", "getSeries", "setSeries", "shrinkwrap", "getShrinkwrap", "setShrinkwrap", "slot", "getSlot", "setSlot", "state", "getState", "setState", "status", "getStatus", "setStatus", "stockNumber", "getStockNumber", "setStockNumber", "stockstatus", "getStockstatus", "setStockstatus", "tBOInd", "getTBOInd", "setTBOInd", "timedAuctionCloseTimeCST", "getTimedAuctionCloseTimeCST", "setTimedAuctionCloseTimeCST", "timedAuctionIndicator", "getTimedAuctionIndicator", "setTimedAuctionIndicator", "title", "getTitle", "setTitle", "totalPaid", "getTotalPaid", "setTotalPaid", "transmissionTypeDescription", "getTransmissionTypeDescription", "setTransmissionTypeDescription", "vehicleStarts", "getVehicleStarts", "setVehicleStarts", "vin", "getVin", "setVin", "winAmount", "getWinAmount", "setWinAmount", "winDifference", "getWinDifference", "setWinDifference", "winning", "getWinning", "setWinning", "wonPrebid", "getWonPrebid", "setWonPrebid", "year", "getYear", "setYear", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: WatchListModel.kt */
public final class WatchListModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<WatchListModel> diffCallback = new WatchListModel$Companion$diffCallback$1();
    @SerializedName("a_bidWonMethod")
    @Nullable
    @Expose
    private Object aBidWonMethod;
    @SerializedName("a_bidamount")
    @Nullable
    @Expose
    private Integer aBidamount;
    @SerializedName("adjClosedate")
    @Nullable
    @Expose
    private String adjClosedate;
    @SerializedName("AdjLiveDate")
    @Nullable
    @Expose
    private String adjLiveDate;
    @SerializedName("AuctionDate")
    @Nullable
    @Expose
    private String auctionDate;
    @SerializedName("AuctionId")
    @Nullable
    @Expose
    private String auctionId;
    @SerializedName("AuctionLane")
    @Nullable
    @Expose
    private Object auctionLane;
    @SerializedName("AuctionStartsAt")
    @Nullable
    @Expose
    private Object auctionStartsAt;
    @SerializedName("BidStatus")
    @Nullable
    @Expose
    private String bidStatus;
    @SerializedName("bidamount")
    @Nullable
    @Expose
    private Integer bidamount;
    @SerializedName("BidderName")
    @Nullable
    @Expose
    private Object bidderName;
    @SerializedName("Branchname")
    @Nullable
    @Expose
    private String branchname;
    @SerializedName("Code")
    @Nullable
    @Expose
    private Integer code;
    @SerializedName("CurrentHigh")
    @Nullable
    @Expose
    private String currentHigh;
    @SerializedName("Damage")
    @Nullable
    @Expose
    private String damage;
    @SerializedName("datepaidstring")
    @Nullable
    @Expose
    private Object datepaidstring;
    @SerializedName("feesAndTax")
    @Nullable
    @Expose
    private Object feesAndTax;
    @SerializedName("FloatingFifthElement")
    @Nullable
    @Expose
    private String floatingFifthElement;
    @SerializedName("FormattedAdjCloseDate")
    @Nullable
    @Expose
    private String formattedAdjCloseDate;
    @SerializedName("FormattedAdjLiveDate")
    @Nullable
    @Expose
    private String formattedAdjLiveDate;
    @SerializedName("fourthElementHistory")
    @Nullable
    @Expose
    private Object fourthElementHistory;
    @SerializedName("IBN_AC_Qualified")
    @Nullable
    @Expose
    private Boolean iBNACQualified;
    @SerializedName("IBN_Sold")
    @Nullable
    @Expose
    private Boolean iBNSold;
    @SerializedName("ImageURL")
    @Nullable
    @Expose
    private String imageURL;
    @SerializedName("Itemid")
    @Nullable
    @Expose
    private String itemid;
    @SerializedName("itempublicauction")
    @Nullable
    @Expose
    private Boolean itempublicauction;
    @SerializedName("liveDatePreSale")
    @Nullable
    @Expose
    private Object liveDatePreSale;
    @SerializedName("LossType")
    @Nullable
    @Expose
    private String lossType;
    @SerializedName("losstype")
    @Nullable
    @Expose
    private Object losstype;
    @SerializedName("lost")
    @Nullable
    @Expose
    private Boolean lost;
    @SerializedName("lost_prebid")
    @Nullable
    @Expose
    private Boolean lostPrebid;
    @SerializedName("Make")
    @Nullable
    @Expose
    private String make;
    @SerializedName("Model")
    @Nullable
    @Expose
    private String model;
    @SerializedName("Odobrand")
    @Nullable
    @Expose
    private Object odobrand;
    @SerializedName("Odometer")
    @Nullable
    @Expose
    private String odometer;
    @SerializedName("Offsite_Sale_Indicator")
    @Nullable
    @Expose
    private Boolean offsiteSaleIndicator;
    @SerializedName("only_WatchList")
    @Nullable
    @Expose
    private Boolean onlyWatchList;
    @SerializedName("Outbid")
    @Nullable
    @Expose
    private Boolean outbid;
    @SerializedName("Own")
    @Nullable
    @Expose
    private Boolean own;
    @SerializedName("pa_paymentDueDate")
    @Nullable
    @Expose
    private String paPaymentDueDate;
    @SerializedName("pa_pickUpDueDate")
    @Nullable
    @Expose
    private String paPickUpDueDate;
    @SerializedName("Paymentduedate")
    @Nullable
    @Expose
    private String paymentduedate;
    @SerializedName("Pickduedate")
    @Nullable
    @Expose
    private String pickduedate;
    @SerializedName("pickedupDate")
    @Nullable
    @Expose
    private String pickedupDate;
    @SerializedName("pickedupdatestring")
    @Nullable
    @Expose
    private String pickedupdatestring;
    @SerializedName("PrebidClosesAt")
    @Nullable
    @Expose
    private String prebidClosesAt;
    @SerializedName("prebidStatus")
    @Nullable
    @Expose
    private String prebidStatus;
    @SerializedName("prebidStatusColor")
    @Nullable
    @Expose
    private String prebidStatusColor;
    @SerializedName("PredictedTimeOnBlock")
    @Nullable
    @Expose
    private Object predictedTimeOnBlock;
    @SerializedName("ProviderName")
    @Nullable
    @Expose
    private String providerName;
    @SerializedName("pu_datePaid")
    @Nullable
    @Expose
    private Object puDatePaid;
    @SerializedName("pu_pickUpDueDate")
    @Nullable
    @Expose
    private String puPickUpDueDate;
    @SerializedName("ReceiptDescription")
    @Nullable
    @Expose
    private Object receiptDescription;
    @SerializedName("ReceiptNo")
    @Nullable
    @Expose
    private Object receiptNo;
    @SerializedName("RowOwner")
    @Nullable
    @Expose
    private String rowOwner;
    @SerializedName("RunAndDrive")
    @Nullable
    @Expose
    private Boolean runAndDrive;
    @SerializedName("Salvage_Id")
    @Nullable
    @Expose
    private Integer salvageId;
    @SerializedName("sealed_indicator")
    @Nullable
    @Expose
    private Boolean sealedIndicator;
    @SerializedName("Series")
    @Nullable
    @Expose
    private Object series;
    @SerializedName("shrinkwrap")
    @Nullable
    @Expose
    private Boolean shrinkwrap;
    @SerializedName("Slot")
    @Nullable
    @Expose
    private String slot;
    @SerializedName("state")
    @Nullable
    @Expose
    private String state;
    @SerializedName("status")
    @Nullable
    @Expose
    private Integer status;
    @SerializedName("StockNumber")
    @Nullable
    @Expose
    private String stockNumber;
    @SerializedName("Stockstatus")
    @Nullable
    @Expose
    private String stockstatus;
    @SerializedName("TBOInd")
    @Nullable
    @Expose
    private Boolean tBOInd;
    @SerializedName("TimedAuctionCloseTimeCST")
    @Nullable
    @Expose
    private Object timedAuctionCloseTimeCST;
    @SerializedName("TimedAuctionIndicator")
    @Nullable
    @Expose
    private Object timedAuctionIndicator;
    @SerializedName("Title")
    @Nullable
    @Expose
    private Object title;
    @SerializedName("totalPaid")
    @Nullable
    @Expose
    private Object totalPaid;
    @SerializedName("Transmission_Type_Description")
    @Nullable
    @Expose
    private Object transmissionTypeDescription;
    @SerializedName("Vehicle_starts")
    @Nullable
    @Expose
    private Boolean vehicleStarts;
    @SerializedName("vin")
    @Nullable
    @Expose
    private Object vin;
    @SerializedName("win_amount")
    @Nullable
    @Expose
    private Object winAmount;
    @SerializedName("win_difference")
    @Nullable
    @Expose
    private Object winDifference;
    @SerializedName("winning")
    @Nullable
    @Expose
    private Boolean winning;
    @SerializedName("won_prebid")
    @Nullable
    @Expose
    private Boolean wonPrebid;
    @SerializedName("Year")
    @Nullable
    @Expose
    private String year;

    @Nullable
    public final String getAdjLiveDate() {
        return this.adjLiveDate;
    }

    public final void setAdjLiveDate(@Nullable String str) {
        this.adjLiveDate = str;
    }

    @Nullable
    public final String getAuctionDate() {
        return this.auctionDate;
    }

    public final void setAuctionDate(@Nullable String str) {
        this.auctionDate = str;
    }

    @Nullable
    public final String getAuctionId() {
        return this.auctionId;
    }

    public final void setAuctionId(@Nullable String str) {
        this.auctionId = str;
    }

    @Nullable
    public final Object getAuctionLane() {
        return this.auctionLane;
    }

    public final void setAuctionLane(@Nullable Object obj) {
        this.auctionLane = obj;
    }

    @Nullable
    public final Object getAuctionStartsAt() {
        return this.auctionStartsAt;
    }

    public final void setAuctionStartsAt(@Nullable Object obj) {
        this.auctionStartsAt = obj;
    }

    @Nullable
    public final String getBidStatus() {
        return this.bidStatus;
    }

    public final void setBidStatus(@Nullable String str) {
        this.bidStatus = str;
    }

    @Nullable
    public final Object getBidderName() {
        return this.bidderName;
    }

    public final void setBidderName(@Nullable Object obj) {
        this.bidderName = obj;
    }

    @Nullable
    public final String getBranchname() {
        return this.branchname;
    }

    public final void setBranchname(@Nullable String str) {
        this.branchname = str;
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(@Nullable Integer num) {
        this.code = num;
    }

    @Nullable
    public final String getCurrentHigh() {
        return this.currentHigh;
    }

    public final void setCurrentHigh(@Nullable String str) {
        this.currentHigh = str;
    }

    @Nullable
    public final String getDamage() {
        return this.damage;
    }

    public final void setDamage(@Nullable String str) {
        this.damage = str;
    }

    @Nullable
    public final String getFloatingFifthElement() {
        return this.floatingFifthElement;
    }

    public final void setFloatingFifthElement(@Nullable String str) {
        this.floatingFifthElement = str;
    }

    @Nullable
    public final Boolean getIBNACQualified() {
        return this.iBNACQualified;
    }

    public final void setIBNACQualified(@Nullable Boolean bool) {
        this.iBNACQualified = bool;
    }

    @Nullable
    public final Boolean getIBNSold() {
        return this.iBNSold;
    }

    public final void setIBNSold(@Nullable Boolean bool) {
        this.iBNSold = bool;
    }

    @Nullable
    public final String getImageURL() {
        return this.imageURL;
    }

    public final void setImageURL(@Nullable String str) {
        this.imageURL = str;
    }

    @Nullable
    public final String getItemid() {
        return this.itemid;
    }

    public final void setItemid(@Nullable String str) {
        this.itemid = str;
    }

    @Nullable
    public final String getLossType() {
        return this.lossType;
    }

    public final void setLossType(@Nullable String str) {
        this.lossType = str;
    }

    @Nullable
    public final String getMake() {
        return this.make;
    }

    public final void setMake(@Nullable String str) {
        this.make = str;
    }

    @Nullable
    public final String getModel() {
        return this.model;
    }

    public final void setModel(@Nullable String str) {
        this.model = str;
    }

    @Nullable
    public final Object getOdobrand() {
        return this.odobrand;
    }

    public final void setOdobrand(@Nullable Object obj) {
        this.odobrand = obj;
    }

    @Nullable
    public final String getOdometer() {
        return this.odometer;
    }

    public final void setOdometer(@Nullable String str) {
        this.odometer = str;
    }

    @Nullable
    public final Boolean getOffsiteSaleIndicator() {
        return this.offsiteSaleIndicator;
    }

    public final void setOffsiteSaleIndicator(@Nullable Boolean bool) {
        this.offsiteSaleIndicator = bool;
    }

    @Nullable
    public final Boolean getOutbid() {
        return this.outbid;
    }

    public final void setOutbid(@Nullable Boolean bool) {
        this.outbid = bool;
    }

    @Nullable
    public final Boolean getOwn() {
        return this.own;
    }

    public final void setOwn(@Nullable Boolean bool) {
        this.own = bool;
    }

    @Nullable
    public final String getPaymentduedate() {
        return this.paymentduedate;
    }

    public final void setPaymentduedate(@Nullable String str) {
        this.paymentduedate = str;
    }

    @Nullable
    public final String getPickduedate() {
        return this.pickduedate;
    }

    public final void setPickduedate(@Nullable String str) {
        this.pickduedate = str;
    }

    @Nullable
    public final String getPrebidClosesAt() {
        return this.prebidClosesAt;
    }

    public final void setPrebidClosesAt(@Nullable String str) {
        this.prebidClosesAt = str;
    }

    @Nullable
    public final Object getPredictedTimeOnBlock() {
        return this.predictedTimeOnBlock;
    }

    public final void setPredictedTimeOnBlock(@Nullable Object obj) {
        this.predictedTimeOnBlock = obj;
    }

    @Nullable
    public final String getProviderName() {
        return this.providerName;
    }

    public final void setProviderName(@Nullable String str) {
        this.providerName = str;
    }

    @Nullable
    public final Object getReceiptDescription() {
        return this.receiptDescription;
    }

    public final void setReceiptDescription(@Nullable Object obj) {
        this.receiptDescription = obj;
    }

    @Nullable
    public final Object getReceiptNo() {
        return this.receiptNo;
    }

    public final void setReceiptNo(@Nullable Object obj) {
        this.receiptNo = obj;
    }

    @Nullable
    public final String getRowOwner() {
        return this.rowOwner;
    }

    public final void setRowOwner(@Nullable String str) {
        this.rowOwner = str;
    }

    @Nullable
    public final Boolean getRunAndDrive() {
        return this.runAndDrive;
    }

    public final void setRunAndDrive(@Nullable Boolean bool) {
        this.runAndDrive = bool;
    }

    @Nullable
    public final Integer getSalvageId() {
        return this.salvageId;
    }

    public final void setSalvageId(@Nullable Integer num) {
        this.salvageId = num;
    }

    @Nullable
    public final Object getSeries() {
        return this.series;
    }

    public final void setSeries(@Nullable Object obj) {
        this.series = obj;
    }

    @Nullable
    public final String getSlot() {
        return this.slot;
    }

    public final void setSlot(@Nullable String str) {
        this.slot = str;
    }

    @Nullable
    public final String getStockNumber() {
        return this.stockNumber;
    }

    public final void setStockNumber(@Nullable String str) {
        this.stockNumber = str;
    }

    @Nullable
    public final String getStockstatus() {
        return this.stockstatus;
    }

    public final void setStockstatus(@Nullable String str) {
        this.stockstatus = str;
    }

    @Nullable
    public final Boolean getTBOInd() {
        return this.tBOInd;
    }

    public final void setTBOInd(@Nullable Boolean bool) {
        this.tBOInd = bool;
    }

    @Nullable
    public final Object getTimedAuctionCloseTimeCST() {
        return this.timedAuctionCloseTimeCST;
    }

    public final void setTimedAuctionCloseTimeCST(@Nullable Object obj) {
        this.timedAuctionCloseTimeCST = obj;
    }

    @Nullable
    public final Object getTimedAuctionIndicator() {
        return this.timedAuctionIndicator;
    }

    public final void setTimedAuctionIndicator(@Nullable Object obj) {
        this.timedAuctionIndicator = obj;
    }

    @Nullable
    public final Object getTitle() {
        return this.title;
    }

    public final void setTitle(@Nullable Object obj) {
        this.title = obj;
    }

    @Nullable
    public final Object getTransmissionTypeDescription() {
        return this.transmissionTypeDescription;
    }

    public final void setTransmissionTypeDescription(@Nullable Object obj) {
        this.transmissionTypeDescription = obj;
    }

    @Nullable
    public final Boolean getVehicleStarts() {
        return this.vehicleStarts;
    }

    public final void setVehicleStarts(@Nullable Boolean bool) {
        this.vehicleStarts = bool;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    public final void setYear(@Nullable String str) {
        this.year = str;
    }

    @Nullable
    public final Object getABidWonMethod() {
        return this.aBidWonMethod;
    }

    public final void setABidWonMethod(@Nullable Object obj) {
        this.aBidWonMethod = obj;
    }

    @Nullable
    public final Integer getABidamount() {
        return this.aBidamount;
    }

    public final void setABidamount(@Nullable Integer num) {
        this.aBidamount = num;
    }

    @Nullable
    public final String getAdjClosedate() {
        return this.adjClosedate;
    }

    public final void setAdjClosedate(@Nullable String str) {
        this.adjClosedate = str;
    }

    @Nullable
    public final Integer getBidamount() {
        return this.bidamount;
    }

    public final void setBidamount(@Nullable Integer num) {
        this.bidamount = num;
    }

    @Nullable
    public final Object getDatepaidstring() {
        return this.datepaidstring;
    }

    public final void setDatepaidstring(@Nullable Object obj) {
        this.datepaidstring = obj;
    }

    @Nullable
    public final Object getFeesAndTax() {
        return this.feesAndTax;
    }

    public final void setFeesAndTax(@Nullable Object obj) {
        this.feesAndTax = obj;
    }

    @Nullable
    public final Object getFourthElementHistory() {
        return this.fourthElementHistory;
    }

    public final void setFourthElementHistory(@Nullable Object obj) {
        this.fourthElementHistory = obj;
    }

    @Nullable
    public final Boolean getItempublicauction() {
        return this.itempublicauction;
    }

    public final void setItempublicauction(@Nullable Boolean bool) {
        this.itempublicauction = bool;
    }

    @Nullable
    public final Object getLiveDatePreSale() {
        return this.liveDatePreSale;
    }

    public final void setLiveDatePreSale(@Nullable Object obj) {
        this.liveDatePreSale = obj;
    }

    @Nullable
    public final Object getLosstype() {
        return this.losstype;
    }

    public final void setLosstype(@Nullable Object obj) {
        this.losstype = obj;
    }

    @Nullable
    public final Boolean getLost() {
        return this.lost;
    }

    public final void setLost(@Nullable Boolean bool) {
        this.lost = bool;
    }

    @Nullable
    public final Boolean getLostPrebid() {
        return this.lostPrebid;
    }

    public final void setLostPrebid(@Nullable Boolean bool) {
        this.lostPrebid = bool;
    }

    @Nullable
    public final Boolean getOnlyWatchList() {
        return this.onlyWatchList;
    }

    public final void setOnlyWatchList(@Nullable Boolean bool) {
        this.onlyWatchList = bool;
    }

    @Nullable
    public final String getPaPaymentDueDate() {
        return this.paPaymentDueDate;
    }

    public final void setPaPaymentDueDate(@Nullable String str) {
        this.paPaymentDueDate = str;
    }

    @Nullable
    public final String getPaPickUpDueDate() {
        return this.paPickUpDueDate;
    }

    public final void setPaPickUpDueDate(@Nullable String str) {
        this.paPickUpDueDate = str;
    }

    @Nullable
    public final String getPickedupDate() {
        return this.pickedupDate;
    }

    public final void setPickedupDate(@Nullable String str) {
        this.pickedupDate = str;
    }

    @Nullable
    public final String getPickedupdatestring() {
        return this.pickedupdatestring;
    }

    public final void setPickedupdatestring(@Nullable String str) {
        this.pickedupdatestring = str;
    }

    @Nullable
    public final String getPrebidStatus() {
        return this.prebidStatus;
    }

    public final void setPrebidStatus(@Nullable String str) {
        this.prebidStatus = str;
    }

    @Nullable
    public final String getPrebidStatusColor() {
        return this.prebidStatusColor;
    }

    public final void setPrebidStatusColor(@Nullable String str) {
        this.prebidStatusColor = str;
    }

    @Nullable
    public final Object getPuDatePaid() {
        return this.puDatePaid;
    }

    public final void setPuDatePaid(@Nullable Object obj) {
        this.puDatePaid = obj;
    }

    @Nullable
    public final String getPuPickUpDueDate() {
        return this.puPickUpDueDate;
    }

    public final void setPuPickUpDueDate(@Nullable String str) {
        this.puPickUpDueDate = str;
    }

    @Nullable
    public final Boolean getSealedIndicator() {
        return this.sealedIndicator;
    }

    public final void setSealedIndicator(@Nullable Boolean bool) {
        this.sealedIndicator = bool;
    }

    @Nullable
    public final Boolean getShrinkwrap() {
        return this.shrinkwrap;
    }

    public final void setShrinkwrap(@Nullable Boolean bool) {
        this.shrinkwrap = bool;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    public final void setState(@Nullable String str) {
        this.state = str;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    @Nullable
    public final Object getTotalPaid() {
        return this.totalPaid;
    }

    public final void setTotalPaid(@Nullable Object obj) {
        this.totalPaid = obj;
    }

    @Nullable
    public final Object getVin() {
        return this.vin;
    }

    public final void setVin(@Nullable Object obj) {
        this.vin = obj;
    }

    @Nullable
    public final Object getWinAmount() {
        return this.winAmount;
    }

    public final void setWinAmount(@Nullable Object obj) {
        this.winAmount = obj;
    }

    @Nullable
    public final Object getWinDifference() {
        return this.winDifference;
    }

    public final void setWinDifference(@Nullable Object obj) {
        this.winDifference = obj;
    }

    @Nullable
    public final Boolean getWinning() {
        return this.winning;
    }

    public final void setWinning(@Nullable Boolean bool) {
        this.winning = bool;
    }

    @Nullable
    public final Boolean getWonPrebid() {
        return this.wonPrebid;
    }

    public final void setWonPrebid(@Nullable Boolean bool) {
        this.wonPrebid = bool;
    }

    @Nullable
    public final String getFormattedAdjCloseDate() {
        return this.formattedAdjCloseDate;
    }

    public final void setFormattedAdjCloseDate(@Nullable String str) {
        this.formattedAdjCloseDate = str;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/WatchListModel$Companion;", "", "()V", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDiffCallback", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: WatchListModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<WatchListModel> getDiffCallback() {
            return WatchListModel.diffCallback;
        }

        public final void setDiffCallback(@NotNull DiffUtil.ItemCallback<WatchListModel> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            WatchListModel.diffCallback = itemCallback;
        }
    }

    @Nullable
    public final String getFormattedAdjLiveDate() {
        return this.formattedAdjLiveDate;
    }

    public final void setFormattedAdjLiveDate(@Nullable String str) {
        this.formattedAdjLiveDate = str;
    }
}
