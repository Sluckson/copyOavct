package com.github.anastr.speedviewlib;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.github.anastr.speedviewlib.components.Section;
import com.github.anastr.speedviewlib.components.Style;
import com.github.anastr.speedviewlib.util.UtilsKt;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.lowagie.text.ElementTags;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010Á\u0001\u001a\u00020C2\u0013\u0010W\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020#0Â\u0001\"\u00020#¢\u0006\u0003\u0010Ã\u0001J\u0016\u0010Á\u0001\u001a\u00020C2\r\u0010W\u001a\t\u0012\u0004\u0012\u00020#0Ä\u0001J\t\u0010Å\u0001\u001a\u00020CH\u0004J\t\u0010Æ\u0001\u001a\u00020CH\u0002J\t\u0010Ç\u0001\u001a\u00020CH\u0002J\t\u0010È\u0001\u001a\u00020CH\u0002J\t\u0010É\u0001\u001a\u00020CH\u0002J\u0018\u0010Ê\u0001\u001a\u00020C2\u0007\u0010Ë\u0001\u001a\u00020#H\u0000¢\u0006\u0003\bÌ\u0001J\t\u0010Í\u0001\u001a\u00020CH\u0002J\u0007\u0010Î\u0001\u001a\u00020CJ\n\u0010Ï\u0001\u001a\u00030\u0001H\u0014J\t\u0010Ð\u0001\u001a\u00020CH$J\u0010\u0010Ñ\u0001\u001a\u00020\u000b2\u0007\u0010Ò\u0001\u001a\u00020\u000bJ\u0013\u0010Ó\u0001\u001a\u00020C2\b\u0010Ô\u0001\u001a\u00030\u0001H\u0004J\u000b\u0010Õ\u0001\u001a\u0004\u0018\u00010#H\u0002J\u0007\u0010Ö\u0001\u001a\u00020\u000bJ\u0007\u0010×\u0001\u001a\u00020\u000bJ\t\u0010Ø\u0001\u001a\u00020eH\u0004J\n\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0004J\t\u0010Û\u0001\u001a\u00020\u000bH\u0002J\t\u0010Ü\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010Ý\u0001\u001a\u00020\u000b2\u0007\u0010Þ\u0001\u001a\u00020\u000bH\u0002J\t\u0010ß\u0001\u001a\u00020CH\u0002J\u001b\u0010à\u0001\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0007\u0010á\u0001\u001a\u00020CJ\t\u0010â\u0001\u001a\u00020\u0015H\u0016J#\u0010ã\u0001\u001a\u00020C2\u0007\u0010ä\u0001\u001a\u00020\b2\u0007\u0010å\u0001\u001a\u00020\b2\b\u0010æ\u0001\u001a\u00030ç\u0001J\t\u0010è\u0001\u001a\u00020CH\u0014J\t\u0010é\u0001\u001a\u00020CH\u0014J\u0013\u0010ê\u0001\u001a\u00020C2\b\u0010Ô\u0001\u001a\u00030\u0001H\u0014J\u001d\u0010ë\u0001\u001a\u00020C2\b\u0010A\u001a\u0004\u0018\u00010#2\b\u0010B\u001a\u0004\u0018\u00010#H\u0004J-\u0010ì\u0001\u001a\u00020C2\u0007\u0010í\u0001\u001a\u00020\b2\u0007\u0010î\u0001\u001a\u00020\b2\u0007\u0010ï\u0001\u001a\u00020\b2\u0007\u0010ð\u0001\u001a\u00020\bH\u0014J\u0010\u0010ñ\u0001\u001a\u00020\u000b2\u0007\u0010ò\u0001\u001a\u00020\u000bJ\u0010\u0010ó\u0001\u001a\u00020C2\u0007\u0010ô\u0001\u001a\u00020\u000bJ\u000f\u0010õ\u0001\u001a\u00020C2\u0006\u0010\\\u001a\u00020\u000bJ\u0012\u0010ö\u0001\u001a\u00020C2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010#J\u0017\u0010÷\u0001\u001a\u00020C2\u0006\u0010:\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bJ-\u0010ø\u0001\u001a\u00020C2\u0007\u0010ù\u0001\u001a\u00020\b2\u0007\u0010ú\u0001\u001a\u00020\b2\u0007\u0010û\u0001\u001a\u00020\b2\u0007\u0010ü\u0001\u001a\u00020\bH\u0016J-\u0010ý\u0001\u001a\u00020C2\u0007\u0010þ\u0001\u001a\u00020\b2\u0007\u0010ú\u0001\u001a\u00020\b2\u0007\u0010ÿ\u0001\u001a\u00020\b2\u0007\u0010ü\u0001\u001a\u00020\bH\u0016J\u000f\u0010\u0002\u001a\u00020C2\u0006\u0010\\\u001a\u00020\u000bJ\u0019\u0010\u0002\u001a\u00020C2\u0007\u0010 \u0001\u001a\u00020\u000b2\u0007\u0010£\u0001\u001a\u00020\bJ\u0007\u0010\u0002\u001a\u00020CJ\u001e\u0010\u0002\u001a\u00020C2\u0007\u0010ô\u0001\u001a\u00020\b2\n\b\u0002\u0010\u0002\u001a\u00030\u0002H\u0007J\u001d\u0010\u0002\u001a\u00020C2\u0006\u0010\\\u001a\u00020\u000b2\n\b\u0002\u0010\u0002\u001a\u00030\u0002H\u0007J\u0007\u0010\u0002\u001a\u00020CJ\u0007\u0010\u0002\u001a\u00020CJ\t\u0010\u0002\u001a\u00020CH\u0004J!\u0010\u0002\u001a\u00020C2\n\u0010Ë\u0001\u001a\u0005\u0018\u00010\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0016J\t\u0010\u0002\u001a\u00020CH$J-\u0010\u0002\u001a\u00020C2\u0007\u0010ù\u0001\u001a\u00020\b2\u0007\u0010ú\u0001\u001a\u00020\b2\u0007\u0010û\u0001\u001a\u00020\b2\u0007\u0010ü\u0001\u001a\u00020\bH\u0002J\u0013\u0010\u0002\u001a\u00020C2\b\u0010\u0002\u001a\u00030§\u0001H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\"\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u001f\u001a\u0004\u0018\u00010#@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR$\u0010)\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R\u001e\u0010,\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u001e\u0010.\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R$\u00100\u001a\u0002012\u0006\u00100\u001a\u000201@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011R$\u0010:\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011RV\u0010=\u001a>\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020C\u0018\u00010>j\u0004\u0018\u0001`DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HRg\u0010I\u001aO\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020C\u0018\u00010Jj\u0004\u0018\u0001`NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\"R\u000e\u0010U\u001a\u00020VX.¢\u0006\u0002\n\u0000R!\u0010W\u001a\u0012\u0012\u0004\u0012\u00020#0Xj\b\u0012\u0004\u0012\u00020#`Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u000fR\u000e\u0010^\u001a\u00020VX.¢\u0006\u0002\n\u0000R$\u0010_\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b`\u0010\"\"\u0004\ba\u0010bRb\u0010g\u001a!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020e0dj\u0002`f2%\u0010c\u001a!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020e0dj\u0002`f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001e\u0010l\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\"\u0004\bm\u0010\u0011R\u000e\u0010n\u001a\u00020oX\u0004¢\u0006\u0002\n\u0000R$\u0010p\u001a\u00020q2\u0006\u0010p\u001a\u00020q@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010v\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\bw\u0010\u000f\"\u0004\bx\u0010\u0011R(\u0010{\u001a\u0004\u0018\u00010z2\b\u0010y\u001a\u0004\u0018\u00010z8F@FX\u000e¢\u0006\f\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R\u000f\u0010\u0001\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u0015@FX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0001\u0010/\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b@VX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000f\"\u0005\b\u0001\u0010\u0011R(\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\b8F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010\"\"\u0005\b\u0001\u0010bR\u001f\u0010\u0001\u001a\u00020oX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010\u000f\"\u0005\b\u0001\u0010\u0011R+\u0010\u0001\u001a\u0004\u0018\u00010z2\b\u0010y\u001a\u0004\u0018\u00010z8F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010}\"\u0005\b\u0001\u0010R\u001d\u0010\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000f\"\u0005\b\u0001\u0010\u0011R\u001d\u0010\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000f\"\u0005\b\u0001\u0010\u0011R\u000f\u0010\u0001\u001a\u00020VX.¢\u0006\u0002\n\u0000R(\u0010 \u0001\u001a\u00020\u000b2\u0007\u0010 \u0001\u001a\u00020\u000b@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010\u000f\"\u0005\b¢\u0001\u0010\u0011R(\u0010£\u0001\u001a\u00020\b2\u0007\u0010£\u0001\u001a\u00020\b@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\"\"\u0005\b¥\u0001\u0010bR,\u0010¦\u0001\u001a\u00030§\u00012\b\u0010¦\u0001\u001a\u00030§\u0001@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R!\u0010¬\u0001\u001a\u00020\u000b2\u0007\u0010¬\u0001\u001a\u00020\u000b@BX\u000e¢\u0006\t\n\u0000\"\u0005\b­\u0001\u0010\u0011R(\u0010®\u0001\u001a\u00020\b2\u0007\u0010®\u0001\u001a\u00020\b8F@FX\u000e¢\u0006\u000e\u001a\u0005\b¯\u0001\u0010\"\"\u0005\b°\u0001\u0010bR\u000f\u0010±\u0001\u001a\u00020oX\u0004¢\u0006\u0002\n\u0000R(\u0010²\u0001\u001a\u00020\u000b2\u0007\u0010²\u0001\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\u001a\u0005\b³\u0001\u0010\u000f\"\u0005\b´\u0001\u0010\u0011R)\u0010µ\u0001\u001a\u00020\u00152\u0007\u0010µ\u0001\u001a\u00020\u0015@FX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¶\u0001\u0010/\"\u0006\b·\u0001\u0010\u0001R\u0013\u0010¸\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010\"R\u0013\u0010º\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010\"R \u0010¼\u0001\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\b½\u0001\u0010\"R)\u0010¾\u0001\u001a\u00020\u00152\u0007\u0010¾\u0001\u001a\u00020\u0015@FX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¿\u0001\u0010/\"\u0006\bÀ\u0001\u0010\u0001¨\u0006\u0002"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/Gauge;", "Landroid/view/View;", "Ljava/util/Observer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_maxSpeed", "", "_minSpeed", "accelerate", "getAccelerate", "()F", "setAccelerate", "(F)V", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "attachedToWindow", "", "backgroundBitmap", "Landroid/graphics/Bitmap;", "getBackgroundBitmap", "()Landroid/graphics/Bitmap;", "setBackgroundBitmap", "(Landroid/graphics/Bitmap;)V", "backgroundBitmapPaint", "Landroid/graphics/Paint;", "canceled", "<set-?>", "currentIntSpeed", "getCurrentIntSpeed", "()I", "Lcom/github/anastr/speedviewlib/components/Section;", "currentSection", "getCurrentSection", "()Lcom/github/anastr/speedviewlib/components/Section;", "currentSpeed", "getCurrentSpeed", "decelerate", "getDecelerate", "setDecelerate", "heightPa", "getHeightPa", "isSpeedIncrease", "()Z", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "value", "maxSpeed", "getMaxSpeed", "setMaxSpeed", "minSpeed", "getMinSpeed", "setMinSpeed", "onSectionChangeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "previousSection", "newSection", "", "Lcom/github/anastr/speedviewlib/util/OnSectionChangeListener;", "getOnSectionChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnSectionChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "onSpeedChangeListener", "Lkotlin/Function3;", "gauge", "isSpeedUp", "isByTremble", "Lcom/github/anastr/speedviewlib/util/OnSpeedChangeListener;", "getOnSpeedChangeListener", "()Lkotlin/jvm/functions/Function3;", "setOnSpeedChangeListener", "(Lkotlin/jvm/functions/Function3;)V", "padding", "getPadding", "realSpeedAnimator", "Landroid/animation/ValueAnimator;", "sections", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSections", "()Ljava/util/ArrayList;", "speed", "getSpeed", "speedAnimator", "speedTextColor", "getSpeedTextColor", "setSpeedTextColor", "(I)V", "speedTextFormat", "Lkotlin/Function1;", "", "Lcom/github/anastr/speedviewlib/SpeedTextListener;", "speedTextListener", "getSpeedTextListener", "()Lkotlin/jvm/functions/Function1;", "setSpeedTextListener", "(Lkotlin/jvm/functions/Function1;)V", "speedTextPadding", "setSpeedTextPadding", "speedTextPaint", "Landroid/text/TextPaint;", "speedTextPosition", "Lcom/github/anastr/speedviewlib/Gauge$Position;", "getSpeedTextPosition", "()Lcom/github/anastr/speedviewlib/Gauge$Position;", "setSpeedTextPosition", "(Lcom/github/anastr/speedviewlib/Gauge$Position;)V", "speedTextSize", "getSpeedTextSize", "setSpeedTextSize", "typeface", "Landroid/graphics/Typeface;", "speedTextTypeface", "getSpeedTextTypeface", "()Landroid/graphics/Typeface;", "setSpeedTextTypeface", "(Landroid/graphics/Typeface;)V", "speedUnitTextBitmap", "speedUnitTextBitmapPaint", "speedUnitTextCanvas", "Landroid/graphics/Canvas;", "speedometerTextRightToLeft", "getSpeedometerTextRightToLeft", "setSpeedometerTextRightToLeft", "(Z)V", "speedometerWidth", "getSpeedometerWidth", "setSpeedometerWidth", "textColor", "getTextColor", "setTextColor", "textPaint", "getTextPaint", "()Landroid/text/TextPaint;", "setTextPaint", "(Landroid/text/TextPaint;)V", "textSize", "getTextSize", "setTextSize", "textTypeface", "getTextTypeface", "setTextTypeface", "translatedDx", "getTranslatedDx", "setTranslatedDx", "translatedDy", "getTranslatedDy", "setTranslatedDy", "trembleAnimator", "trembleDegree", "getTrembleDegree", "setTrembleDegree", "trembleDuration", "getTrembleDuration", "setTrembleDuration", "unit", "", "getUnit", "()Ljava/lang/String;", "setUnit", "(Ljava/lang/String;)V", "unitSpeedInterval", "setUnitSpeedInterval", "unitTextColor", "getUnitTextColor", "setUnitTextColor", "unitTextPaint", "unitTextSize", "getUnitTextSize", "setUnitTextSize", "unitUnderSpeedText", "getUnitUnderSpeedText", "setUnitUnderSpeedText", "viewSize", "getViewSize", "viewSizePa", "getViewSizePa", "widthPa", "getWidthPa", "withTremble", "getWithTremble", "setWithTremble", "addSections", "", "([Lcom/github/anastr/speedviewlib/components/Section;)V", "", "cancelSpeedAnimator", "cancelSpeedMove", "cancelTremble", "checkAccelerate", "checkDecelerate", "checkSection", "section", "checkSection$speedviewlib_release", "checkTrembleData", "clearSections", "createBackgroundBitmapCanvas", "defaultGaugeValues", "dpTOpx", "dp", "drawSpeedUnitText", "canvas", "findSection", "getOffsetSpeed", "getPercentSpeed", "getSpeedText", "getSpeedUnitTextBounds", "Landroid/graphics/RectF;", "getSpeedUnitTextHeight", "getSpeedUnitTextWidth", "getSpeedValue", "percentSpeed", "init", "initAttributeSet", "invalidateGauge", "isAttachedToWindow", "makeSections", "numberOfSections", "color", "style", "Lcom/github/anastr/speedviewlib/components/Style;", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onSectionChangeEvent", "onSizeChanged", "w", "h", "oldW", "oldH", "pxTOdp", "px", "realSpeedPercentTo", "percent", "realSpeedTo", "removeSection", "setMinMaxSpeed", "setPadding", "left", "top", "right", "bottom", "setPaddingRelative", "start", "end", "setSpeedAt", "setTrembleData", "slowDown", "speedPercentTo", "moveDuration", "", "speedTo", "speedUp", "stop", "tremble", "update", "Ljava/util/Observable;", "isPercentChanged", "", "updateBackgroundBitmap", "updatePadding", "updateSpeedUnitTextBitmap", "speedText", "Position", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: Gauge.kt */
public abstract class Gauge extends View implements Observer {
    private float _maxSpeed;
    private float _minSpeed;
    private float accelerate;
    private Animator.AnimatorListener animatorListener;
    private boolean attachedToWindow;
    @NotNull
    private Bitmap backgroundBitmap;
    private final Paint backgroundBitmapPaint;
    /* access modifiers changed from: private */
    public boolean canceled;
    private int currentIntSpeed;
    @Nullable
    private Section currentSection;
    /* access modifiers changed from: private */
    public float currentSpeed;
    private float decelerate;
    private int heightPa;
    /* access modifiers changed from: private */
    public boolean isSpeedIncrease;
    @NotNull
    private Locale locale;
    @Nullable
    private Function2<? super Section, ? super Section, Unit> onSectionChangeListener;
    @Nullable
    private Function3<? super Gauge, ? super Boolean, ? super Boolean, Unit> onSpeedChangeListener;
    private int padding;
    private ValueAnimator realSpeedAnimator;
    @NotNull
    private final ArrayList<Section> sections;
    private float speed;
    /* access modifiers changed from: private */
    public ValueAnimator speedAnimator;
    @NotNull
    private Function1<? super Float, ? extends CharSequence> speedTextListener;
    private float speedTextPadding;
    private final TextPaint speedTextPaint;
    @NotNull
    private Position speedTextPosition;
    private Bitmap speedUnitTextBitmap;
    private final Paint speedUnitTextBitmapPaint;
    private Canvas speedUnitTextCanvas;
    private boolean speedometerTextRightToLeft;
    private float speedometerWidth;
    @NotNull
    private TextPaint textPaint;
    private float translatedDx;
    private float translatedDy;
    /* access modifiers changed from: private */
    public ValueAnimator trembleAnimator;
    private float trembleDegree;
    private int trembleDuration;
    @NotNull
    private String unit;
    private float unitSpeedInterval;
    private final TextPaint unitTextPaint;
    private boolean unitUnderSpeedText;
    private int widthPa;
    private boolean withTremble;

    /* access modifiers changed from: protected */
    public abstract void defaultGaugeValues();

    @JvmOverloads
    public final void speedPercentTo(int i) {
        speedPercentTo$default(this, i, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final void speedTo(float f) {
        speedTo$default(this, f, 0, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract void updateBackgroundBitmap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Gauge(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.speedUnitTextBitmapPaint = new Paint(1);
        this.textPaint = new TextPaint(1);
        this.speedTextPaint = new TextPaint(1);
        this.unitTextPaint = new TextPaint(1);
        this.unit = "Km/h";
        this.withTremble = true;
        this._maxSpeed = 100.0f;
        this.speed = getMinSpeed();
        this.currentSpeed = getMinSpeed();
        this.trembleDegree = 4.0f;
        this.trembleDuration = 1000;
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.backgroundBitmap = createBitmap;
        this.backgroundBitmapPaint = new Paint(1);
        this.sections = new ArrayList<>();
        this.speedometerWidth = dpTOpx(30.0f);
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.getDefault()");
        this.locale = locale2;
        this.accelerate = 0.1f;
        this.decelerate = 0.1f;
        this.speedTextPosition = Position.BOTTOM_CENTER;
        this.unitSpeedInterval = dpTOpx(1.0f);
        this.speedTextPadding = dpTOpx(20.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap2, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.speedUnitTextBitmap = createBitmap2;
        this.speedTextListener = new Gauge$speedTextListener$1(this);
        init();
        initAttributeSet(context, attributeSet);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Gauge(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ ValueAnimator access$getSpeedAnimator$p(Gauge gauge) {
        ValueAnimator valueAnimator = gauge.speedAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
        }
        return valueAnimator;
    }

    public static final /* synthetic */ ValueAnimator access$getTrembleAnimator$p(Gauge gauge) {
        ValueAnimator valueAnimator = gauge.trembleAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trembleAnimator");
        }
        return valueAnimator;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    /* access modifiers changed from: protected */
    public final void setTextPaint(@NotNull TextPaint textPaint2) {
        Intrinsics.checkParameterIsNotNull(textPaint2, "<set-?>");
        this.textPaint = textPaint2;
    }

    @NotNull
    public final String getUnit() {
        return this.unit;
    }

    public final void setUnit(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "unit");
        this.unit = str;
        if (this.attachedToWindow) {
            invalidate();
        }
    }

    public final boolean getWithTremble() {
        return this.withTremble;
    }

    public final void setWithTremble(boolean z) {
        this.withTremble = z;
        tremble();
    }

    public final float getMinSpeed() {
        return this._minSpeed;
    }

    public final void setMinSpeed(float f) {
        setMinMaxSpeed(f, getMaxSpeed());
    }

    public final float getMaxSpeed() {
        return this._maxSpeed;
    }

    public final void setMaxSpeed(float f) {
        setMinMaxSpeed(getMinSpeed(), f);
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final int getCurrentIntSpeed() {
        return this.currentIntSpeed;
    }

    public final float getCurrentSpeed() {
        return this.currentSpeed;
    }

    public final boolean isSpeedIncrease() {
        return this.isSpeedIncrease;
    }

    public final float getTrembleDegree() {
        return this.trembleDegree;
    }

    public final void setTrembleDegree(float f) {
        this.trembleDegree = f;
        checkTrembleData();
    }

    public final int getTrembleDuration() {
        return this.trembleDuration;
    }

    public final void setTrembleDuration(int i) {
        this.trembleDuration = i;
        checkTrembleData();
    }

    @Nullable
    public final Function3<Gauge, Boolean, Boolean, Unit> getOnSpeedChangeListener() {
        return this.onSpeedChangeListener;
    }

    public final void setOnSpeedChangeListener(@Nullable Function3<? super Gauge, ? super Boolean, ? super Boolean, Unit> function3) {
        this.onSpeedChangeListener = function3;
    }

    @Nullable
    public final Function2<Section, Section, Unit> getOnSectionChangeListener() {
        return this.onSectionChangeListener;
    }

    public final void setOnSectionChangeListener(@Nullable Function2<? super Section, ? super Section, Unit> function2) {
        this.onSectionChangeListener = function2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Bitmap getBackgroundBitmap() {
        return this.backgroundBitmap;
    }

    /* access modifiers changed from: protected */
    public final void setBackgroundBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "<set-?>");
        this.backgroundBitmap = bitmap;
    }

    public final int getPadding() {
        return this.padding;
    }

    public final int getWidthPa() {
        return this.widthPa;
    }

    public final int getHeightPa() {
        return this.heightPa;
    }

    @NotNull
    public final ArrayList<Section> getSections() {
        return this.sections;
    }

    @Nullable
    public final Section getCurrentSection() {
        return this.currentSection;
    }

    public float getSpeedometerWidth() {
        return this.speedometerWidth;
    }

    public void setSpeedometerWidth(float f) {
        this.speedometerWidth = f;
        UtilsKt.doOnSections(this, new Gauge$speedometerWidth$1(f));
        if (isAttachedToWindow()) {
            invalidateGauge();
        }
    }

    public final boolean getSpeedometerTextRightToLeft() {
        return this.speedometerTextRightToLeft;
    }

    public final void setSpeedometerTextRightToLeft(boolean z) {
        this.speedometerTextRightToLeft = z;
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    public final float getTranslatedDx() {
        return this.translatedDx;
    }

    /* access modifiers changed from: protected */
    public final void setTranslatedDx(float f) {
        this.translatedDx = f;
    }

    /* access modifiers changed from: protected */
    public final float getTranslatedDy() {
        return this.translatedDy;
    }

    /* access modifiers changed from: protected */
    public final void setTranslatedDy(float f) {
        this.translatedDy = f;
    }

    @NotNull
    public final Locale getLocale() {
        return this.locale;
    }

    public final void setLocale(@NotNull Locale locale2) {
        Intrinsics.checkParameterIsNotNull(locale2, "locale");
        this.locale = locale2;
        if (this.attachedToWindow) {
            invalidate();
        }
    }

    public final float getAccelerate() {
        return this.accelerate;
    }

    public final void setAccelerate(float f) {
        this.accelerate = f;
        checkAccelerate();
    }

    public final float getDecelerate() {
        return this.decelerate;
    }

    public final void setDecelerate(float f) {
        this.decelerate = f;
        checkDecelerate();
    }

    @NotNull
    public final Position getSpeedTextPosition() {
        return this.speedTextPosition;
    }

    public final void setSpeedTextPosition(@NotNull Position position) {
        Intrinsics.checkParameterIsNotNull(position, "speedTextPosition");
        this.speedTextPosition = position;
        invalidateGauge();
    }

    private final void setUnitSpeedInterval(float f) {
        this.unitSpeedInterval = f;
        invalidateGauge();
    }

    private final void setSpeedTextPadding(float f) {
        this.speedTextPadding = f;
        if (this.attachedToWindow) {
            invalidate();
        }
    }

    public final boolean getUnitUnderSpeedText() {
        return this.unitUnderSpeedText;
    }

    public final void setUnitUnderSpeedText(boolean z) {
        this.unitUnderSpeedText = z;
        if (z) {
            this.speedTextPaint.setTextAlign(Paint.Align.CENTER);
            this.unitTextPaint.setTextAlign(Paint.Align.CENTER);
        } else {
            this.speedTextPaint.setTextAlign(Paint.Align.LEFT);
            this.unitTextPaint.setTextAlign(Paint.Align.LEFT);
        }
        invalidateGauge();
    }

    @NotNull
    public final Function1<Float, CharSequence> getSpeedTextListener() {
        return this.speedTextListener;
    }

    public final void setSpeedTextListener(@NotNull Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "speedTextFormat");
        this.speedTextListener = function1;
        invalidateGauge();
    }

    private final void init() {
        int i = (int) 4278190080L;
        this.textPaint.setColor(i);
        this.textPaint.setTextSize(dpTOpx(10.0f));
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.speedTextPaint.setColor(i);
        this.speedTextPaint.setTextSize(dpTOpx(18.0f));
        this.unitTextPaint.setColor(i);
        this.unitTextPaint.setTextSize(dpTOpx(15.0f));
        this.sections.add(new Section(0.0f, 0.6f, (int) 4278255360L, getSpeedometerWidth(), (Style) null, 16, (DefaultConstructorMarker) null).inGauge$speedviewlib_release(this));
        this.sections.add(new Section(0.6f, 0.87f, (int) 4294967040L, getSpeedometerWidth(), (Style) null, 16, (DefaultConstructorMarker) null).inGauge$speedviewlib_release(this));
        this.sections.add(new Section(0.87f, 1.0f, (int) 4294901760L, getSpeedometerWidth(), (Style) null, 16, (DefaultConstructorMarker) null).inGauge$speedviewlib_release(this));
        if (Build.VERSION.SDK_INT >= 11) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ValueAnimator.ofFloat(0f, 1f)");
            this.speedAnimator = ofFloat;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            Intrinsics.checkExpressionValueIsNotNull(ofFloat2, "ValueAnimator.ofFloat(0f, 1f)");
            this.trembleAnimator = ofFloat2;
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            Intrinsics.checkExpressionValueIsNotNull(ofFloat3, "ValueAnimator.ofFloat(0f, 1f)");
            this.realSpeedAnimator = ofFloat3;
            this.animatorListener = new Gauge$init$1(this);
        }
        defaultGaugeValues();
    }

    private final void initAttributeSet(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1083R.styleable.Gauge, 0, 0);
            setMaxSpeed(obtainStyledAttributes.getFloat(C1083R.styleable.Gauge_sv_maxSpeed, getMaxSpeed()));
            setMinSpeed(obtainStyledAttributes.getFloat(C1083R.styleable.Gauge_sv_minSpeed, getMinSpeed()));
            this.speed = getMinSpeed();
            this.currentSpeed = getMinSpeed();
            setSpeedometerWidth(obtainStyledAttributes.getDimension(C1083R.styleable.Gauge_sv_speedometerWidth, getSpeedometerWidth()));
            for (Section width : this.sections) {
                width.setWidth(getSpeedometerWidth());
            }
            setWithTremble(obtainStyledAttributes.getBoolean(C1083R.styleable.Gauge_sv_withTremble, this.withTremble));
            this.textPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.Gauge_sv_textColor, this.textPaint.getColor()));
            this.textPaint.setTextSize(obtainStyledAttributes.getDimension(C1083R.styleable.Gauge_sv_textSize, this.textPaint.getTextSize()));
            this.speedTextPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.Gauge_sv_speedTextColor, this.speedTextPaint.getColor()));
            this.speedTextPaint.setTextSize(obtainStyledAttributes.getDimension(C1083R.styleable.Gauge_sv_speedTextSize, this.speedTextPaint.getTextSize()));
            this.unitTextPaint.setColor(obtainStyledAttributes.getColor(C1083R.styleable.Gauge_sv_unitTextColor, this.unitTextPaint.getColor()));
            this.unitTextPaint.setTextSize(obtainStyledAttributes.getDimension(C1083R.styleable.Gauge_sv_unitTextSize, this.unitTextPaint.getTextSize()));
            String string = obtainStyledAttributes.getString(C1083R.styleable.Gauge_sv_unit);
            if (string == null) {
                string = this.unit;
            }
            setUnit(string);
            setTrembleDegree(obtainStyledAttributes.getFloat(C1083R.styleable.Gauge_sv_trembleDegree, this.trembleDegree));
            setTrembleDuration(obtainStyledAttributes.getInt(C1083R.styleable.Gauge_sv_trembleDuration, this.trembleDuration));
            setSpeedometerTextRightToLeft(obtainStyledAttributes.getBoolean(C1083R.styleable.Gauge_sv_textRightToLeft, this.speedometerTextRightToLeft));
            setAccelerate(obtainStyledAttributes.getFloat(C1083R.styleable.Gauge_sv_accelerate, this.accelerate));
            setDecelerate(obtainStyledAttributes.getFloat(C1083R.styleable.Gauge_sv_decelerate, this.decelerate));
            setUnitUnderSpeedText(obtainStyledAttributes.getBoolean(C1083R.styleable.Gauge_sv_unitUnderSpeedText, this.unitUnderSpeedText));
            setUnitSpeedInterval(obtainStyledAttributes.getDimension(C1083R.styleable.Gauge_sv_unitSpeedInterval, this.unitSpeedInterval));
            setSpeedTextPadding(obtainStyledAttributes.getDimension(C1083R.styleable.Gauge_sv_speedTextPadding, this.speedTextPadding));
            String string2 = obtainStyledAttributes.getString(C1083R.styleable.Gauge_sv_speedTextTypeface);
            if (string2 != null && !isInEditMode()) {
                setSpeedTextTypeface(Typeface.createFromAsset(context.getAssets(), string2));
            }
            String string3 = obtainStyledAttributes.getString(C1083R.styleable.Gauge_sv_textTypeface);
            if (string3 != null && !isInEditMode()) {
                setTextTypeface(Typeface.createFromAsset(context.getAssets(), string3));
            }
            int i = obtainStyledAttributes.getInt(C1083R.styleable.Gauge_sv_speedTextPosition, -1);
            if (i != -1) {
                setSpeedTextPosition(Position.values()[i]);
            }
            int i2 = obtainStyledAttributes.getInt(C1083R.styleable.Gauge_sv_speedTextFormat, -1);
            if (i2 == 0) {
                setSpeedTextListener(new Gauge$initAttributeSet$2(this));
            } else if (i2 == 1) {
                setSpeedTextListener(new Gauge$initAttributeSet$3(this));
            }
            obtainStyledAttributes.recycle();
            checkAccelerate();
            checkDecelerate();
            checkTrembleData();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        int i6 = this.widthPa;
        if (i6 > 0 && (i5 = this.heightPa) > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i6, i5, Bitmap.Config.ARGB_8888);
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
            this.speedUnitTextBitmap = createBitmap;
        }
        this.speedUnitTextCanvas = new Canvas(this.speedUnitTextBitmap);
    }

    private final void checkAccelerate() {
        float f = this.accelerate;
        boolean z = false;
        if (f <= 1.0f && f > ((float) 0)) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("accelerate must be between (0, 1]".toString());
        }
    }

    private final void checkDecelerate() {
        float f = this.decelerate;
        boolean z = false;
        if (f <= 1.0f && f > ((float) 0)) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("decelerate must be between (0, 1]".toString());
        }
    }

    private final void checkTrembleData() {
        boolean z = false;
        if (this.trembleDegree >= ((float) 0)) {
            if (this.trembleDuration >= 0) {
                z = true;
            }
            if (!z) {
                throw new IllegalArgumentException("trembleDuration  can't be Negative".toString());
            }
            return;
        }
        throw new IllegalArgumentException("trembleDegree  can't be Negative".toString());
    }

    public final void checkSection$speedviewlib_release(@NotNull Section section) {
        Intrinsics.checkParameterIsNotNull(section, ElementTags.SECTION);
        int indexOf = this.sections.indexOf(section);
        boolean z = false;
        if (section.getStartOffset() < section.getEndOffset()) {
            Section section2 = (Section) CollectionsKt.getOrNull(this.sections, indexOf - 1);
            if (section2 != null) {
                if (!(section2.getEndOffset() <= section.getStartOffset() && section2.getEndOffset() < section.getEndOffset())) {
                    throw new IllegalArgumentException(("Section at index (" + indexOf + ") is conflicted with previous section").toString());
                }
            }
            Section section3 = (Section) CollectionsKt.getOrNull(this.sections, indexOf + 1);
            if (section3 != null) {
                if (section3.getStartOffset() >= section.getEndOffset() && section3.getStartOffset() > section.getStartOffset()) {
                    z = true;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Section at index (" + indexOf + ") is conflicted with next section").toString());
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("endOffset must be bigger than startOffset".toString());
    }

    public final float dpTOpx(float f) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return f * resources.getDisplayMetrics().density;
    }

    public final float pxTOdp(float f) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return f / resources.getDisplayMetrics().density;
    }

    private final void updatePadding(int i, int i2, int i3, int i4) {
        this.padding = Math.max(Math.max(i, i3), Math.max(i2, i4));
        this.widthPa = getWidth() - (this.padding * 2);
        this.heightPa = getHeight() - (this.padding * 2);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final RectF getSpeedUnitTextBounds() {
        float x$speedviewlib_release = ((((((float) this.widthPa) * this.speedTextPosition.getX$speedviewlib_release()) - this.translatedDx) + ((float) this.padding)) - (getSpeedUnitTextWidth() * this.speedTextPosition.getWidth$speedviewlib_release())) + (this.speedTextPadding * ((float) this.speedTextPosition.getPaddingH$speedviewlib_release()));
        float y$speedviewlib_release = ((((((float) this.heightPa) * this.speedTextPosition.getY$speedviewlib_release()) - this.translatedDy) + ((float) this.padding)) - (getSpeedUnitTextHeight() * this.speedTextPosition.getHeight$speedviewlib_release())) + (this.speedTextPadding * ((float) this.speedTextPosition.getPaddingV$speedviewlib_release()));
        return new RectF(x$speedviewlib_release, y$speedviewlib_release, getSpeedUnitTextWidth() + x$speedviewlib_release, getSpeedUnitTextHeight() + y$speedviewlib_release);
    }

    private final float getSpeedUnitTextWidth() {
        if (this.unitUnderSpeedText) {
            return Math.max(this.speedTextPaint.measureText(getSpeedText().toString()), this.unitTextPaint.measureText(this.unit));
        }
        return this.speedTextPaint.measureText(getSpeedText().toString()) + this.unitTextPaint.measureText(this.unit) + this.unitSpeedInterval;
    }

    private final float getSpeedUnitTextHeight() {
        if (this.unitUnderSpeedText) {
            return this.speedTextPaint.getTextSize() + this.unitTextPaint.getTextSize() + this.unitSpeedInterval;
        }
        return Math.max(this.speedTextPaint.getTextSize(), this.unitTextPaint.getTextSize());
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final CharSequence getSpeedText() {
        return (CharSequence) this.speedTextListener.invoke(Float.valueOf(this.currentSpeed));
    }

    public final float getPercentSpeed() {
        return ((this.currentSpeed - getMinSpeed()) * 100.0f) / (getMaxSpeed() - getMinSpeed());
    }

    public final float getOffsetSpeed() {
        return (this.currentSpeed - getMinSpeed()) / (getMaxSpeed() - getMinSpeed());
    }

    public final int getTextColor() {
        return this.textPaint.getColor();
    }

    public final void setTextColor(int i) {
        this.textPaint.setColor(i);
        invalidateGauge();
    }

    public final int getSpeedTextColor() {
        return this.speedTextPaint.getColor();
    }

    public final void setSpeedTextColor(int i) {
        this.speedTextPaint.setColor(i);
        if (this.attachedToWindow) {
            invalidate();
        }
    }

    public final int getUnitTextColor() {
        return this.unitTextPaint.getColor();
    }

    public final void setUnitTextColor(int i) {
        this.unitTextPaint.setColor(i);
        if (this.attachedToWindow) {
            invalidate();
        }
    }

    public final float getTextSize() {
        return this.textPaint.getTextSize();
    }

    public final void setTextSize(float f) {
        this.textPaint.setTextSize(f);
        if (this.attachedToWindow) {
            invalidate();
        }
    }

    public final float getSpeedTextSize() {
        return this.speedTextPaint.getTextSize();
    }

    public final void setSpeedTextSize(float f) {
        this.speedTextPaint.setTextSize(f);
        if (this.attachedToWindow) {
            invalidate();
        }
    }

    public final float getUnitTextSize() {
        return this.unitTextPaint.getTextSize();
    }

    public final void setUnitTextSize(float f) {
        this.unitTextPaint.setTextSize(f);
        invalidateGauge();
    }

    public final int getViewSize() {
        return Math.max(getWidth(), getHeight());
    }

    public final int getViewSizePa() {
        return Math.max(this.widthPa, this.heightPa);
    }

    @Nullable
    public final Typeface getSpeedTextTypeface() {
        return this.speedTextPaint.getTypeface();
    }

    public final void setSpeedTextTypeface(@Nullable Typeface typeface) {
        this.speedTextPaint.setTypeface(typeface);
        this.unitTextPaint.setTypeface(typeface);
        invalidateGauge();
    }

    @Nullable
    public final Typeface getTextTypeface() {
        return this.textPaint.getTypeface();
    }

    public final void setTextTypeface(@Nullable Typeface typeface) {
        this.textPaint.setTypeface(typeface);
        invalidateGauge();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[EDGE_INSN: B:28:0x005d->B:25:0x005d ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(@org.jetbrains.annotations.NotNull android.graphics.Canvas r8) {
        /*
            r7 = this;
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            float r0 = r7.translatedDx
            float r1 = r7.translatedDy
            r8.translate(r0, r1)
            android.graphics.Bitmap r0 = r7.backgroundBitmap
            android.graphics.Paint r1 = r7.backgroundBitmapPaint
            r2 = 0
            r8.drawBitmap(r0, r2, r2, r1)
            float r8 = r7.currentSpeed
            int r8 = (int) r8
            int r0 = r7.currentIntSpeed
            r1 = 1
            if (r8 == r0) goto L_0x005d
            kotlin.jvm.functions.Function3<? super com.github.anastr.speedviewlib.Gauge, ? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> r0 = r7.onSpeedChangeListener
            if (r0 == 0) goto L_0x005d
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            r3 = 0
            if (r0 < r2) goto L_0x0038
            android.animation.ValueAnimator r0 = r7.trembleAnimator
            if (r0 != 0) goto L_0x0030
            java.lang.String r2 = "trembleAnimator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0030:
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            int r2 = r7.currentIntSpeed
            if (r8 <= r2) goto L_0x003e
            r3 = 1
        L_0x003e:
            if (r3 == 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = -1
        L_0x0043:
            int r4 = r7.currentIntSpeed
            if (r4 == r8) goto L_0x005d
            int r4 = r4 + r2
            r7.currentIntSpeed = r4
            kotlin.jvm.functions.Function3<? super com.github.anastr.speedviewlib.Gauge, ? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> r4 = r7.onSpeedChangeListener
            if (r4 != 0) goto L_0x0051
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0051:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r4.invoke(r7, r5, r6)
            goto L_0x0043
        L_0x005d:
            r7.currentIntSpeed = r8
            com.github.anastr.speedviewlib.components.Section r8 = r7.findSection()
            com.github.anastr.speedviewlib.components.Section r0 = r7.currentSection
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0073
            com.github.anastr.speedviewlib.components.Section r0 = r7.currentSection
            r7.onSectionChangeEvent(r0, r8)
            r7.currentSection = r8
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.anastr.speedviewlib.Gauge.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public final void drawSpeedUnitText(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        RectF speedUnitTextBounds = getSpeedUnitTextBounds();
        updateSpeedUnitTextBitmap(getSpeedText().toString());
        canvas.drawBitmap(this.speedUnitTextBitmap, (speedUnitTextBounds.left - (((float) this.speedUnitTextBitmap.getWidth()) * 0.5f)) + (speedUnitTextBounds.width() * 0.5f), (speedUnitTextBounds.top - (((float) this.speedUnitTextBitmap.getHeight()) * 0.5f)) + (speedUnitTextBounds.height() * 0.5f), this.speedUnitTextBitmapPaint);
    }

    private final void updateSpeedUnitTextBitmap(String str) {
        float f;
        float f2;
        this.speedUnitTextBitmap.eraseColor(0);
        if (this.unitUnderSpeedText) {
            Canvas canvas = this.speedUnitTextCanvas;
            if (canvas != null) {
                canvas.drawText(str, ((float) this.speedUnitTextBitmap.getWidth()) * 0.5f, (((float) this.speedUnitTextBitmap.getHeight()) * 0.5f) - (this.unitSpeedInterval * 0.5f), this.speedTextPaint);
            }
            Canvas canvas2 = this.speedUnitTextCanvas;
            if (canvas2 != null) {
                canvas2.drawText(this.unit, ((float) this.speedUnitTextBitmap.getWidth()) * 0.5f, (((float) this.speedUnitTextBitmap.getHeight()) * 0.5f) + this.unitTextPaint.getTextSize() + (this.unitSpeedInterval * 0.5f), this.unitTextPaint);
                return;
            }
            return;
        }
        if (this.speedometerTextRightToLeft) {
            f2 = (((float) this.speedUnitTextBitmap.getWidth()) * 0.5f) - (getSpeedUnitTextWidth() * 0.5f);
            f = this.unitTextPaint.measureText(this.unit) + f2 + this.unitSpeedInterval;
        } else {
            f = (((float) this.speedUnitTextBitmap.getWidth()) * 0.5f) - (getSpeedUnitTextWidth() * 0.5f);
            f2 = this.speedTextPaint.measureText(str) + f + this.unitSpeedInterval;
        }
        float height = (((float) this.speedUnitTextBitmap.getHeight()) * 0.5f) + (getSpeedUnitTextHeight() * 0.5f);
        Canvas canvas3 = this.speedUnitTextCanvas;
        if (canvas3 != null) {
            canvas3.drawText(str, f, height, this.speedTextPaint);
        }
        Canvas canvas4 = this.speedUnitTextCanvas;
        if (canvas4 != null) {
            canvas4.drawText(this.unit, f2, height, this.unitTextPaint);
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Canvas createBackgroundBitmapCanvas() {
        if (getWidth() == 0 || getHeight() == 0) {
            return new Canvas();
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.backgroundBitmap = createBitmap;
        return new Canvas(this.backgroundBitmap);
    }

    /* access modifiers changed from: protected */
    public final void onSectionChangeEvent(@Nullable Section section, @Nullable Section section2) {
        Function2<? super Section, ? super Section, Unit> function2 = this.onSectionChangeListener;
        if (function2 != null) {
            Unit invoke = function2.invoke(section, section2);
        }
    }

    public final void stop() {
        ValueAnimator valueAnimator = this.speedAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
        }
        if (!valueAnimator.isRunning()) {
            ValueAnimator valueAnimator2 = this.realSpeedAnimator;
            if (valueAnimator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
            }
            if (!valueAnimator2.isRunning()) {
                return;
            }
        }
        this.speed = this.currentSpeed;
        cancelSpeedAnimator();
        tremble();
    }

    /* access modifiers changed from: protected */
    public final void cancelSpeedAnimator() {
        cancelSpeedMove();
        cancelTremble();
    }

    private final void cancelTremble() {
        this.canceled = true;
        ValueAnimator valueAnimator = this.trembleAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trembleAnimator");
        }
        valueAnimator.cancel();
        this.canceled = false;
    }

    private final void cancelSpeedMove() {
        this.canceled = true;
        ValueAnimator valueAnimator = this.speedAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
        }
        valueAnimator.cancel();
        ValueAnimator valueAnimator2 = this.realSpeedAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
        }
        valueAnimator2.cancel();
        this.canceled = false;
    }

    public final void setSpeedAt(float f) {
        if (f > getMaxSpeed()) {
            f = getMaxSpeed();
        } else if (f < getMinSpeed()) {
            f = getMinSpeed();
        }
        this.isSpeedIncrease = f > this.currentSpeed;
        this.speed = f;
        this.currentSpeed = f;
        cancelSpeedAnimator();
        invalidate();
        tremble();
    }

    public static /* synthetic */ void speedPercentTo$default(Gauge gauge, int i, long j, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
            }
            gauge.speedPercentTo(i, j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: speedPercentTo");
    }

    @JvmOverloads
    public final void speedPercentTo(int i, long j) {
        speedTo(getSpeedValue((float) i), j);
    }

    public static /* synthetic */ void speedTo$default(Gauge gauge, float f, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                j = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
            }
            gauge.speedTo(f, j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: speedTo");
    }

    @JvmOverloads
    public final void speedTo(float f, long j) {
        if (f > getMaxSpeed()) {
            f = getMaxSpeed();
        } else if (f < getMinSpeed()) {
            f = getMinSpeed();
        }
        if (f != this.speed) {
            this.speed = f;
            this.isSpeedIncrease = f > this.currentSpeed;
            cancelSpeedAnimator();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.currentSpeed, f});
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ValueAnimator.ofFloat(currentSpeed, newSpeed)");
            this.speedAnimator = ofFloat;
            ValueAnimator valueAnimator = this.speedAnimator;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
            }
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            ValueAnimator valueAnimator2 = this.speedAnimator;
            if (valueAnimator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
            }
            valueAnimator2.setDuration(j);
            ValueAnimator valueAnimator3 = this.speedAnimator;
            if (valueAnimator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
            }
            valueAnimator3.addUpdateListener(new Gauge$speedTo$1(this));
            ValueAnimator valueAnimator4 = this.speedAnimator;
            if (valueAnimator4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
            }
            Animator.AnimatorListener animatorListener2 = this.animatorListener;
            if (animatorListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorListener");
            }
            valueAnimator4.addListener(animatorListener2);
            ValueAnimator valueAnimator5 = this.speedAnimator;
            if (valueAnimator5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speedAnimator");
            }
            valueAnimator5.start();
        }
    }

    public final void speedUp() {
        realSpeedTo(getMaxSpeed());
    }

    public final void slowDown() {
        realSpeedTo(0.0f);
    }

    public final void realSpeedPercentTo(float f) {
        realSpeedTo(getSpeedValue(f));
    }

    public final void realSpeedTo(float f) {
        boolean z = this.speed > this.currentSpeed;
        if (f > getMaxSpeed()) {
            f = getMaxSpeed();
        } else if (f < getMinSpeed()) {
            f = getMinSpeed();
        }
        if (f != this.speed) {
            this.speed = f;
            this.isSpeedIncrease = f > this.currentSpeed;
            ValueAnimator valueAnimator = this.realSpeedAnimator;
            if (valueAnimator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
            }
            if (!valueAnimator.isRunning() || z != this.isSpeedIncrease) {
                cancelSpeedAnimator();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{(int) this.currentSpeed, (int) f});
                Intrinsics.checkExpressionValueIsNotNull(ofInt, "ValueAnimator.ofInt(curr…oInt(), newSpeed.toInt())");
                this.realSpeedAnimator = ofInt;
                ValueAnimator valueAnimator2 = this.realSpeedAnimator;
                if (valueAnimator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
                }
                valueAnimator2.setRepeatCount(-1);
                ValueAnimator valueAnimator3 = this.realSpeedAnimator;
                if (valueAnimator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
                }
                valueAnimator3.setInterpolator(new LinearInterpolator());
                ValueAnimator valueAnimator4 = this.realSpeedAnimator;
                if (valueAnimator4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
                }
                valueAnimator4.setDuration(Math.abs((long) ((f - this.currentSpeed) * ((float) 10))));
                ValueAnimator valueAnimator5 = this.realSpeedAnimator;
                if (valueAnimator5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
                }
                valueAnimator5.addUpdateListener(new Gauge$realSpeedTo$1(this, f));
                ValueAnimator valueAnimator6 = this.realSpeedAnimator;
                if (valueAnimator6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
                }
                Animator.AnimatorListener animatorListener2 = this.animatorListener;
                if (animatorListener2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animatorListener");
                }
                valueAnimator6.addListener(animatorListener2);
                ValueAnimator valueAnimator7 = this.realSpeedAnimator;
                if (valueAnimator7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("realSpeedAnimator");
                }
                valueAnimator7.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tremble() {
        /*
            r5 = this;
            r5.cancelTremble()
            boolean r0 = r5.withTremble
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            float r1 = r5.trembleDegree
            float r2 = r0.nextFloat()
            float r1 = r1 * r2
            boolean r0 = r0.nextBoolean()
            r2 = 1
            if (r0 == 0) goto L_0x001e
            r0 = -1
            goto L_0x001f
        L_0x001e:
            r0 = 1
        L_0x001f:
            float r0 = (float) r0
            float r1 = r1 * r0
            float r0 = r5.speed
            float r0 = r0 + r1
            float r3 = r5.getMaxSpeed()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0036
            float r0 = r5.getMaxSpeed()
            float r1 = r5.speed
        L_0x0033:
            float r1 = r0 - r1
            goto L_0x0048
        L_0x0036:
            float r0 = r5.speed
            float r0 = r0 + r1
            float r3 = r5.getMinSpeed()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0048
            float r0 = r5.getMinSpeed()
            float r1 = r5.speed
            goto L_0x0033
        L_0x0048:
            r0 = 2
            float[] r0 = new float[r0]
            r3 = 0
            float r4 = r5.currentSpeed
            r0[r3] = r4
            float r3 = r5.speed
            float r3 = r3 + r1
            r0[r2] = r3
            android.animation.ValueAnimator r0 = android.animation.ValueAnimator.ofFloat(r0)
            java.lang.String r1 = "ValueAnimator.ofFloat(currentSpeed, speed + mad)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r5.trembleAnimator = r0
            android.animation.ValueAnimator r0 = r5.trembleAnimator
            java.lang.String r1 = "trembleAnimator"
            if (r0 != 0) goto L_0x0069
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0069:
            android.view.animation.DecelerateInterpolator r2 = new android.view.animation.DecelerateInterpolator
            r2.<init>()
            android.animation.TimeInterpolator r2 = (android.animation.TimeInterpolator) r2
            r0.setInterpolator(r2)
            android.animation.ValueAnimator r0 = r5.trembleAnimator
            if (r0 != 0) goto L_0x007a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x007a:
            int r2 = r5.trembleDuration
            long r2 = (long) r2
            r0.setDuration(r2)
            android.animation.ValueAnimator r0 = r5.trembleAnimator
            if (r0 != 0) goto L_0x0087
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0087:
            com.github.anastr.speedviewlib.Gauge$tremble$1 r2 = new com.github.anastr.speedviewlib.Gauge$tremble$1
            r2.<init>(r5)
            android.animation.ValueAnimator$AnimatorUpdateListener r2 = (android.animation.ValueAnimator.AnimatorUpdateListener) r2
            r0.addUpdateListener(r2)
            android.animation.ValueAnimator r0 = r5.trembleAnimator
            if (r0 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0098:
            android.animation.Animator$AnimatorListener r2 = r5.animatorListener
            if (r2 != 0) goto L_0x00a1
            java.lang.String r3 = "animatorListener"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x00a1:
            r0.addListener(r2)
            android.animation.ValueAnimator r0 = r5.trembleAnimator
            if (r0 != 0) goto L_0x00ab
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00ab:
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.anastr.speedviewlib.Gauge.tremble():void");
    }

    private final float getSpeedValue(float f) {
        if (f > ((float) 100)) {
            f = 100.0f;
        } else if (f < ((float) 0)) {
            f = 0.0f;
        }
        return (f * (getMaxSpeed() - getMinSpeed()) * 0.01f) + getMinSpeed();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        if (!isInEditMode()) {
            updateBackgroundBitmap();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelSpeedAnimator();
        this.attachedToWindow = false;
    }

    public final void setTrembleData(float f, int i) {
        setTrembleDegree(f);
        setTrembleDuration(i);
    }

    public final void setMinMaxSpeed(float f, float f2) {
        if (f < f2) {
            cancelSpeedAnimator();
            this._minSpeed = f;
            this._maxSpeed = f2;
            invalidateGauge();
            if (this.attachedToWindow) {
                setSpeedAt(this.speed);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("minSpeed must be smaller than maxSpeed !!".toString());
    }

    public final void addSections(@NotNull Section... sectionArr) {
        Intrinsics.checkParameterIsNotNull(sectionArr, "sections");
        addSections((List<Section>) ArraysKt.asList((T[]) sectionArr));
    }

    public final void addSections(@NotNull List<Section> list) {
        Intrinsics.checkParameterIsNotNull(list, "sections");
        for (Section section : list) {
            this.sections.add(section.inGauge$speedviewlib_release(this));
            checkSection$speedviewlib_release(section);
        }
        invalidateGauge();
    }

    public final void makeSections(int i, int i2, @NotNull Style style) {
        Intrinsics.checkParameterIsNotNull(style, "style");
        for (Section clearGauge$speedviewlib_release : this.sections) {
            clearGauge$speedviewlib_release.clearGauge$speedviewlib_release();
        }
        this.sections.clear();
        float f = 1.0f / ((float) i);
        int i3 = 0;
        float f2 = f;
        float f3 = 0.0f;
        while (i3 < i) {
            this.sections.add(new Section(f3, f2, i2, getSpeedometerWidth(), style).inGauge$speedviewlib_release(this));
            i3++;
            f3 = f2;
            f2 += f;
        }
        invalidateGauge();
    }

    public final void removeSection(@Nullable Section section) {
        if (section != null) {
            section.clearGauge$speedviewlib_release();
        }
        Collection collection = this.sections;
        if (collection != null) {
            TypeIntrinsics.asMutableCollection(collection).remove(section);
            invalidateGauge();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public final void clearSections() {
        for (Section clearGauge$speedviewlib_release : this.sections) {
            clearGauge$speedviewlib_release.clearGauge$speedviewlib_release();
        }
        this.sections.clear();
        invalidateGauge();
    }

    public void update(@Nullable Observable observable, @Nullable Object obj) {
        invalidateGauge();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        updatePadding(i, i2, i3, i4);
        int i5 = this.padding;
        super.setPadding(i5, i5, i5, i5);
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        updatePadding(i, i2, i3, i4);
        int i5 = this.padding;
        super.setPaddingRelative(i5, i5, i5, i5);
    }

    private final Section findSection() {
        for (Section section : this.sections) {
            if (((getMaxSpeed() - getMinSpeed()) * section.getStartOffset()) + getMinSpeed() <= this.currentSpeed && ((getMaxSpeed() - getMinSpeed()) * section.getEndOffset()) + getMinSpeed() >= this.currentSpeed) {
                return section;
            }
        }
        return null;
    }

    public boolean isAttachedToWindow() {
        return this.attachedToWindow;
    }

    public final void invalidateGauge() {
        if (this.attachedToWindow) {
            updateBackgroundBitmap();
            invalidate();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/Gauge$Position;", "", "x", "", "y", "width", "height", "paddingH", "", "paddingV", "(Ljava/lang/String;IFFFFII)V", "getHeight$speedviewlib_release", "()F", "getPaddingH$speedviewlib_release", "()I", "getPaddingV$speedviewlib_release", "getWidth$speedviewlib_release", "getX$speedviewlib_release", "getY$speedviewlib_release", "TOP_LEFT", "TOP_CENTER", "TOP_RIGHT", "LEFT", "CENTER", "RIGHT", "BOTTOM_LEFT", "BOTTOM_CENTER", "BOTTOM_RIGHT", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Gauge.kt */
    public enum Position {
        TOP_LEFT(0.0f, 0.0f, 0.0f, 0.0f, 1, 1),
        TOP_CENTER(0.5f, 0.0f, 0.5f, 0.0f, 0, 1),
        TOP_RIGHT(1.0f, 0.0f, 1.0f, 0.0f, -1, 1),
        LEFT(0.0f, 0.5f, 0.0f, 0.5f, 1, 0),
        CENTER(0.5f, 0.5f, 0.5f, 0.5f, 0, 0),
        RIGHT(1.0f, 0.5f, 1.0f, 0.5f, -1, 0),
        BOTTOM_LEFT(0.0f, 1.0f, 0.0f, 1.0f, 1, -1),
        BOTTOM_CENTER(0.5f, 1.0f, 0.5f, 1.0f, 0, -1),
        BOTTOM_RIGHT(1.0f, 1.0f, 1.0f, 1.0f, -1, -1);
        
        private final float height;
        private final int paddingH;
        private final int paddingV;
        private final float width;

        /* renamed from: x */
        private final float f116x;

        /* renamed from: y */
        private final float f117y;

        private Position(float f, float f2, float f3, float f4, int i, int i2) {
            this.f116x = f;
            this.f117y = f2;
            this.width = f3;
            this.height = f4;
            this.paddingH = i;
            this.paddingV = i2;
        }

        public final float getX$speedviewlib_release() {
            return this.f116x;
        }

        public final float getY$speedviewlib_release() {
            return this.f117y;
        }

        public final float getHeight$speedviewlib_release() {
            return this.height;
        }

        public final float getWidth$speedviewlib_release() {
            return this.width;
        }

        public final int getPaddingH$speedviewlib_release() {
            return this.paddingH;
        }

        public final int getPaddingV$speedviewlib_release() {
            return this.paddingV;
        }
    }
}
