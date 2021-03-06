package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {
    public static final String ANONYMOUS_REGION_ID = "";
    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final String ATTR_TTS_EXTENT = "extent";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_ORIGIN = "origin";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DATA = "data";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_IMAGE = "image";
    public static final String TAG_INFORMATION = "information";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final String UNDERLINE = "underline";
    private List<TtmlNode> children;
    public final long endTimeUs;
    @Nullable
    public final String imageId;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final String regionId;
    public final long startTimeUs;
    @Nullable
    public final TtmlStyle style;
    @Nullable
    private final String[] styleIds;
    @Nullable
    public final String tag;
    @Nullable
    public final String text;

    public static TtmlNode buildTextNode(String str) {
        return new TtmlNode((String) null, TtmlRenderUtil.applyTextElementSpacePolicy(str), C1119C.TIME_UNSET, C1119C.TIME_UNSET, (TtmlStyle) null, (String[]) null, "", (String) null);
    }

    public static TtmlNode buildNode(@Nullable String str, long j, long j2, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str2, @Nullable String str3) {
        return new TtmlNode(str, (String) null, j, j2, ttmlStyle, strArr, str2, str3);
    }

    private TtmlNode(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str3, @Nullable String str4) {
        this.tag = str;
        this.text = str2;
        this.imageId = str4;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        this.isTextNode = str2 != null;
        this.startTimeUs = j;
        this.endTimeUs = j2;
        this.regionId = (String) Assertions.checkNotNull(str3);
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    public boolean isActive(long j) {
        return (this.startTimeUs == C1119C.TIME_UNSET && this.endTimeUs == C1119C.TIME_UNSET) || (this.startTimeUs <= j && this.endTimeUs == C1119C.TIME_UNSET) || ((this.startTimeUs == C1119C.TIME_UNSET && j < this.endTimeUs) || (this.startTimeUs <= j && j < this.endTimeUs));
    }

    public void addChild(TtmlNode ttmlNode) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public TtmlNode getChild(int i) {
        List<TtmlNode> list = this.children;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getChildCount() {
        List<TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long[] getEventTimesUs() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    private void getEventTimes(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.tag);
        boolean equals2 = "div".equals(this.tag);
        if (z || equals || (equals2 && this.imageId != null)) {
            long j = this.startTimeUs;
            if (j != C1119C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.endTimeUs;
            if (j2 != C1119C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.children != null) {
            for (int i = 0; i < this.children.size(); i++) {
                this.children.get(i).getEventTimes(treeSet, z || equals);
            }
        }
    }

    public String[] getStyleIds() {
        return this.styleIds;
    }

    public List<Cue> getCues(long j, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        long j2 = j;
        Map<String, TtmlRegion> map4 = map2;
        ArrayList<Pair> arrayList = new ArrayList<>();
        traverseForImage(j2, this.regionId, arrayList);
        TreeMap treeMap = new TreeMap();
        traverseForText(j, false, this.regionId, treeMap);
        traverseForStyle(j2, map, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                TtmlRegion ttmlRegion = map4.get(pair.first);
                arrayList2.add(new Cue(decodeByteArray, ttmlRegion.position, 0, ttmlRegion.line, ttmlRegion.lineAnchor, ttmlRegion.width, ttmlRegion.height));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = map4.get(entry.getKey());
            arrayList2.add(new Cue((CharSequence) cleanUpText((SpannableStringBuilder) entry.getValue()), (Layout.Alignment) null, ttmlRegion2.line, ttmlRegion2.lineType, ttmlRegion2.lineAnchor, ttmlRegion2.position, Integer.MIN_VALUE, ttmlRegion2.width, ttmlRegion2.textSizeType, ttmlRegion2.textSize));
        }
        return arrayList2;
    }

    private void traverseForImage(long j, String str, List<Pair<String, String>> list) {
        String str2;
        if (!"".equals(this.regionId)) {
            str = this.regionId;
        }
        if (!isActive(j) || !"div".equals(this.tag) || (str2 = this.imageId) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                getChild(i).traverseForImage(j, str, list);
            }
            return;
        }
        list.add(new Pair(str, str2));
    }

    private void traverseForText(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if (!TAG_METADATA.equals(this.tag)) {
            if (!"".equals(this.regionId)) {
                str = this.regionId;
            }
            if (this.isTextNode && z) {
                getRegionOutput(str, map).append(this.text);
            } else if ("br".equals(this.tag) && z) {
                getRegionOutput(str, map).append(10);
            } else if (isActive(j)) {
                for (Map.Entry next : map.entrySet()) {
                    this.nodeStartsByRegion.put(next.getKey(), Integer.valueOf(((SpannableStringBuilder) next.getValue()).length()));
                }
                boolean equals = "p".equals(this.tag);
                for (int i = 0; i < getChildCount(); i++) {
                    getChild(i).traverseForText(j, z || equals, str, map);
                }
                if (equals) {
                    TtmlRenderUtil.endParagraph(getRegionOutput(str, map));
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.nodeEndsByRegion.put(next2.getKey(), Integer.valueOf(((SpannableStringBuilder) next2.getValue()).length()));
                }
            }
        }
    }

    private static SpannableStringBuilder getRegionOutput(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void traverseForStyle(long j, Map<String, TtmlStyle> map, Map<String, SpannableStringBuilder> map2) {
        int i;
        if (isActive(j)) {
            Iterator<Map.Entry<String, Integer>> it = this.nodeEndsByRegion.entrySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                if (this.nodeStartsByRegion.containsKey(str)) {
                    i = this.nodeStartsByRegion.get(str).intValue();
                }
                int intValue = ((Integer) next.getValue()).intValue();
                if (i != intValue) {
                    applyStyleToOutput(map, map2.get(str), i, intValue);
                }
            }
            while (i < getChildCount()) {
                getChild(i).traverseForStyle(j, map, map2);
                i++;
            }
        }
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        TtmlStyle resolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map);
        if (resolveStyle != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, i, i2, resolveStyle);
        }
    }

    private SpannableStringBuilder cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int i3 = 0;
        int length = spannableStringBuilder.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (spannableStringBuilder.charAt(i4) == ' ') {
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i6) == ' ') {
                    i6++;
                }
                int i7 = i6 - i5;
                if (i7 > 0) {
                    spannableStringBuilder.delete(i4, i4 + i7);
                    length -= i7;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i8 = 0;
        while (true) {
            i = length - 1;
            if (i8 >= i) {
                break;
            }
            if (spannableStringBuilder.charAt(i8) == 10) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i9) == ' ') {
                    spannableStringBuilder.delete(i9, i8 + 2);
                    length--;
                }
            }
            i8++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i) == ' ') {
            spannableStringBuilder.delete(i, length);
            length--;
        }
        while (true) {
            i2 = length - 1;
            if (i3 >= i2) {
                break;
            }
            if (spannableStringBuilder.charAt(i3) == ' ') {
                int i10 = i3 + 1;
                if (spannableStringBuilder.charAt(i10) == 10) {
                    spannableStringBuilder.delete(i3, i10);
                    length--;
                }
            }
            i3++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == 10) {
            spannableStringBuilder.delete(i2, length);
        }
        return spannableStringBuilder;
    }
}
