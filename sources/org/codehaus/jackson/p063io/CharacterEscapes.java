package org.codehaus.jackson.p063io;

import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.util.CharTypes;

/* renamed from: org.codehaus.jackson.io.CharacterEscapes */
public abstract class CharacterEscapes {
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;

    public abstract int[] getEscapeCodesForAscii();

    public abstract SerializableString getEscapeSequence(int i);

    public static int[] standardAsciiEscapesForJSON() {
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }
}
