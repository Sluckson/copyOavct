package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final String ALIGN_BOTTOM_LEFT = "{\\an1}";
    private static final String ALIGN_BOTTOM_MID = "{\\an2}";
    private static final String ALIGN_BOTTOM_RIGHT = "{\\an3}";
    private static final String ALIGN_MID_LEFT = "{\\an4}";
    private static final String ALIGN_MID_MID = "{\\an5}";
    private static final String ALIGN_MID_RIGHT = "{\\an6}";
    private static final String ALIGN_TOP_LEFT = "{\\an7}";
    private static final String ALIGN_TOP_MID = "{\\an8}";
    private static final String ALIGN_TOP_RIGHT = "{\\an9}";
    static final float END_FRACTION = 0.92f;
    static final float MID_FRACTION = 0.5f;
    static final float START_FRACTION = 0.08f;
    private static final String SUBRIP_ALIGNMENT_TAG = "\\{\\\\an[1-9]\\}";
    private static final Pattern SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+),(\\d+)";
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private static final String TAG = "SubripDecoder";
    private final ArrayList<String> tags = new ArrayList<>();
    private final StringBuilder textBuilder = new StringBuilder();

    public SubripDecoder() {
        super(TAG);
    }

    /* access modifiers changed from: protected */
    public SubripSubtitle decode(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    String readLine2 = parsableByteArray.readLine();
                    if (readLine2 == null) {
                        Log.m54w(TAG, "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(readLine2);
                    if (matcher.matches()) {
                        boolean z2 = true;
                        longArray.add(parseTimecode(matcher, 1));
                        int i2 = 0;
                        if (!TextUtils.isEmpty(matcher.group(6))) {
                            longArray.add(parseTimecode(matcher, 6));
                        } else {
                            z2 = false;
                        }
                        this.textBuilder.setLength(0);
                        this.tags.clear();
                        for (String readLine3 = parsableByteArray.readLine(); !TextUtils.isEmpty(readLine3); readLine3 = parsableByteArray.readLine()) {
                            if (this.textBuilder.length() > 0) {
                                this.textBuilder.append("<br>");
                            }
                            this.textBuilder.append(processLine(readLine3, this.tags));
                        }
                        Spanned fromHtml = Html.fromHtml(this.textBuilder.toString());
                        String str = null;
                        while (true) {
                            if (i2 >= this.tags.size()) {
                                break;
                            }
                            String str2 = this.tags.get(i2);
                            if (str2.matches(SUBRIP_ALIGNMENT_TAG)) {
                                str = str2;
                                break;
                            }
                            i2++;
                        }
                        arrayList.add(buildCue(fromHtml, str));
                        if (z2) {
                            arrayList.add(Cue.EMPTY);
                        }
                    } else {
                        Log.m54w(TAG, "Skipping invalid timing: " + readLine2);
                    }
                } catch (NumberFormatException unused) {
                    Log.m54w(TAG, "Skipping invalid index: " + readLine);
                }
            }
        }
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SubripSubtitle(cueArr, longArray.toArray());
    }

    private String processLine(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = SUBRIP_TAG_PATTERN.matcher(trim);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i;
            int length = group.length();
            sb.replace(start, start + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.text.Cue buildCue(android.text.Spanned r18, @androidx.annotation.Nullable java.lang.String r19) {
        /*
            r17 = this;
            r0 = r19
            if (r0 != 0) goto L_0x000c
            com.google.android.exoplayer2.text.Cue r0 = new com.google.android.exoplayer2.text.Cue
            r2 = r18
            r0.<init>(r2)
            return r0
        L_0x000c:
            r2 = r18
            int r1 = r19.hashCode()
            java.lang.String r3 = "{\\an8}"
            java.lang.String r4 = "{\\an7}"
            java.lang.String r5 = "{\\an6}"
            java.lang.String r6 = "{\\an5}"
            java.lang.String r7 = "{\\an4}"
            java.lang.String r8 = "{\\an3}"
            java.lang.String r9 = "{\\an2}"
            java.lang.String r10 = "{\\an1}"
            r13 = 5
            r14 = 4
            r15 = 3
            r11 = 2
            r12 = 1
            switch(r1) {
                case -685620710: goto L_0x0077;
                case -685620679: goto L_0x006f;
                case -685620648: goto L_0x0067;
                case -685620617: goto L_0x005f;
                case -685620586: goto L_0x0057;
                case -685620555: goto L_0x004f;
                case -685620524: goto L_0x0047;
                case -685620493: goto L_0x003e;
                case -685620462: goto L_0x0033;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x007f
        L_0x0033:
            java.lang.String r1 = "{\\an9}"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x007f
            r1 = 5
            goto L_0x0080
        L_0x003e:
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L_0x007f
            r1 = 8
            goto L_0x0080
        L_0x0047:
            boolean r1 = r0.equals(r4)
            if (r1 == 0) goto L_0x007f
            r1 = 2
            goto L_0x0080
        L_0x004f:
            boolean r1 = r0.equals(r5)
            if (r1 == 0) goto L_0x007f
            r1 = 4
            goto L_0x0080
        L_0x0057:
            boolean r1 = r0.equals(r6)
            if (r1 == 0) goto L_0x007f
            r1 = 7
            goto L_0x0080
        L_0x005f:
            boolean r1 = r0.equals(r7)
            if (r1 == 0) goto L_0x007f
            r1 = 1
            goto L_0x0080
        L_0x0067:
            boolean r1 = r0.equals(r8)
            if (r1 == 0) goto L_0x007f
            r1 = 3
            goto L_0x0080
        L_0x006f:
            boolean r1 = r0.equals(r9)
            if (r1 == 0) goto L_0x007f
            r1 = 6
            goto L_0x0080
        L_0x0077:
            boolean r1 = r0.equals(r10)
            if (r1 == 0) goto L_0x007f
            r1 = 0
            goto L_0x0080
        L_0x007f:
            r1 = -1
        L_0x0080:
            if (r1 == 0) goto L_0x0092
            if (r1 == r12) goto L_0x0092
            if (r1 == r11) goto L_0x0092
            if (r1 == r15) goto L_0x008f
            if (r1 == r14) goto L_0x008f
            if (r1 == r13) goto L_0x008f
            r16 = 1
            goto L_0x0094
        L_0x008f:
            r16 = 2
            goto L_0x0094
        L_0x0092:
            r16 = 0
        L_0x0094:
            int r1 = r19.hashCode()
            switch(r1) {
                case -685620710: goto L_0x00e0;
                case -685620679: goto L_0x00d8;
                case -685620648: goto L_0x00d0;
                case -685620617: goto L_0x00c8;
                case -685620586: goto L_0x00c0;
                case -685620555: goto L_0x00b7;
                case -685620524: goto L_0x00af;
                case -685620493: goto L_0x00a7;
                case -685620462: goto L_0x009c;
                default: goto L_0x009b;
            }
        L_0x009b:
            goto L_0x00e8
        L_0x009c:
            java.lang.String r1 = "{\\an9}"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00e8
            r0 = 5
            goto L_0x00e9
        L_0x00a7:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00e8
            r0 = 4
            goto L_0x00e9
        L_0x00af:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00e8
            r0 = 3
            goto L_0x00e9
        L_0x00b7:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x00e8
            r0 = 8
            goto L_0x00e9
        L_0x00c0:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00e8
            r0 = 7
            goto L_0x00e9
        L_0x00c8:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00e8
            r0 = 6
            goto L_0x00e9
        L_0x00d0:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00e8
            r0 = 2
            goto L_0x00e9
        L_0x00d8:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00e8
            r0 = 1
            goto L_0x00e9
        L_0x00e0:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00e8
            r0 = 0
            goto L_0x00e9
        L_0x00e8:
            r0 = -1
        L_0x00e9:
            if (r0 == 0) goto L_0x00f9
            if (r0 == r12) goto L_0x00f9
            if (r0 == r11) goto L_0x00f9
            if (r0 == r15) goto L_0x00f7
            if (r0 == r14) goto L_0x00f7
            if (r0 == r13) goto L_0x00f7
            r6 = 1
            goto L_0x00fa
        L_0x00f7:
            r6 = 0
            goto L_0x00fa
        L_0x00f9:
            r6 = 2
        L_0x00fa:
            com.google.android.exoplayer2.text.Cue r0 = new com.google.android.exoplayer2.text.Cue
            r3 = 0
            float r4 = getFractionalPositionForAnchorType(r6)
            r5 = 0
            float r7 = getFractionalPositionForAnchorType(r16)
            r9 = 1
            r1 = r0
            r2 = r18
            r8 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.subrip.SubripDecoder.buildCue(android.text.Spanned, java.lang.String):com.google.android.exoplayer2.text.Cue");
    }

    private static long parseTimecode(Matcher matcher, int i) {
        return ((Long.parseLong(matcher.group(i + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i + 3)) * 1000) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }

    static float getFractionalPositionForAnchorType(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return END_FRACTION;
        }
        throw new IllegalArgumentException();
    }
}
