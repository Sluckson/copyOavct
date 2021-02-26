package harmony.java.awt;

import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.io.Serializable;
import org.apache.harmony.awt.internal.nls.Messages;

public class Color implements Serializable {
    public static final Color BLACK = black;
    public static final Color BLUE = blue;
    public static final Color CYAN = cyan;
    public static final Color DARK_GRAY = darkGray;
    public static final Color GRAY = gray;
    public static final Color GREEN = green;
    public static final Color LIGHT_GRAY = lightGray;
    public static final Color MAGENTA = magenta;
    private static final int MIN_SCALABLE = 3;
    public static final Color ORANGE = orange;
    public static final Color PINK = pink;
    public static final Color RED = red;
    private static final double SCALE_FACTOR = 0.7d;
    public static final Color WHITE = white;
    public static final Color YELLOW = yellow;
    public static final Color black = new Color(0, 0, 0);
    public static final Color blue = new Color(0, 0, 255);
    public static final Color cyan = new Color(0, 255, 255);
    public static final Color darkGray = new Color(64, 64, 64);
    public static final Color gray = new Color(128, 128, 128);
    public static final Color green = new Color(0, 255, 0);
    public static final Color lightGray = new Color((int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM, (int) PsExtractor.AUDIO_STREAM);
    public static final Color magenta = new Color(255, 0, 255);
    public static final Color orange = new Color(255, 200, 0);
    public static final Color pink = new Color(255, 175, 175);
    public static final Color red = new Color(255, 0, 0);
    private static final long serialVersionUID = 118526816881161077L;
    public static final Color white = new Color(255, 255, 255);
    public static final Color yellow = new Color(255, 255, 0);
    private float falpha;
    private float[] frgbvalue;
    private float[] fvalue;
    int value;

    public Color(int i, boolean z) {
        if (!z) {
            this.value = i | ViewCompat.MEASURED_STATE_MASK;
        } else {
            this.value = i;
        }
    }

    public Color(int i, int i2, int i3, int i4) {
        if ((i & 255) == i && (i2 & 255) == i2 && (i3 & 255) == i3 && (i4 & 255) == i4) {
            this.value = (i << 16) | (i2 << 8) | i3 | (i4 << 24);
            return;
        }
        throw new IllegalArgumentException(Messages.getString("awt.109"));
    }

    public Color(int i, int i2, int i3) {
        if ((i & 255) == i && (i2 & 255) == i2 && (i3 & 255) == i3) {
            this.value = (i << 16) | (i2 << 8) | i3 | ViewCompat.MEASURED_STATE_MASK;
            return;
        }
        throw new IllegalArgumentException(Messages.getString("awt.109"));
    }

    public Color(int i) {
        this.value = i | ViewCompat.MEASURED_STATE_MASK;
    }

    public Color(float f, float f2, float f3, float f4) {
        this((int) (((double) (f * 255.0f)) + 0.5d), (int) (((double) (f2 * 255.0f)) + 0.5d), (int) (((double) (f3 * 255.0f)) + 0.5d), (int) (((double) (255.0f * f4)) + 0.5d));
        this.falpha = f4;
        this.fvalue = new float[3];
        float[] fArr = this.fvalue;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        this.frgbvalue = fArr;
    }

    public Color(float f, float f2, float f3) {
        this(f, f2, f3, 1.0f);
    }

    public String toString() {
        return String.valueOf(getClass().getName()) + "[r=" + getRed() + ",g=" + getGreen() + ",b=" + getBlue() + "]";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Color) || ((Color) obj).value != this.value) {
            return false;
        }
        return true;
    }

    public Color darker() {
        return new Color((int) (((double) getRed()) * SCALE_FACTOR), (int) (((double) getGreen()) * SCALE_FACTOR), (int) (((double) getBlue()) * SCALE_FACTOR));
    }

    public Color brighter() {
        int i;
        int i2;
        int red2 = getRed();
        int blue2 = getBlue();
        int green2 = getGreen();
        int i3 = 3;
        if (red2 == 0 && blue2 == 0 && green2 == 0) {
            return new Color(3, 3, 3);
        }
        if (red2 >= 3 || red2 == 0) {
            i = (int) (((double) red2) / SCALE_FACTOR);
            if (i > 255) {
                i = 255;
            }
        } else {
            i = 3;
        }
        if (blue2 >= 3 || blue2 == 0) {
            i2 = (int) (((double) blue2) / SCALE_FACTOR);
            if (i2 > 255) {
                i2 = 255;
            }
        } else {
            i2 = 3;
        }
        if (green2 >= 3 || green2 == 0) {
            int i4 = (int) (((double) green2) / SCALE_FACTOR);
            i3 = i4 > 255 ? 255 : i4;
        }
        return new Color(i, i3, i2);
    }

    public float[] getRGBComponents(float[] fArr) {
        if (fArr == null) {
            fArr = new float[4];
        }
        if (this.frgbvalue != null) {
            fArr[3] = this.falpha;
        } else {
            fArr[3] = ((float) getAlpha()) / 255.0f;
        }
        getRGBColorComponents(fArr);
        return fArr;
    }

    public float[] getRGBColorComponents(float[] fArr) {
        if (fArr == null) {
            fArr = new float[3];
        }
        float[] fArr2 = this.frgbvalue;
        if (fArr2 != null) {
            fArr[2] = fArr2[2];
            fArr[1] = fArr2[1];
            fArr[0] = fArr2[0];
        } else {
            fArr[2] = ((float) getBlue()) / 255.0f;
            fArr[1] = ((float) getGreen()) / 255.0f;
            fArr[0] = ((float) getRed()) / 255.0f;
        }
        return fArr;
    }

    public float[] getComponents(float[] fArr) {
        float[] fArr2 = this.fvalue;
        if (fArr2 == null) {
            return getRGBComponents(fArr);
        }
        int length = fArr2.length;
        if (fArr == null) {
            fArr = new float[(length + 1)];
        }
        getColorComponents(fArr);
        fArr[length] = this.falpha;
        return fArr;
    }

    public float[] getColorComponents(float[] fArr) {
        float[] fArr2 = this.fvalue;
        if (fArr2 == null) {
            return getRGBColorComponents(fArr);
        }
        if (fArr == null) {
            fArr = new float[fArr2.length];
        }
        int i = 0;
        while (true) {
            float[] fArr3 = this.fvalue;
            if (i >= fArr3.length) {
                return fArr;
            }
            fArr[i] = fArr3[i];
            i++;
        }
    }

    public int hashCode() {
        return this.value;
    }

    public int getTransparency() {
        int alpha = getAlpha();
        if (alpha != 0) {
            return alpha != 255 ? 3 : 1;
        }
        return 2;
    }

    public int getRed() {
        return (this.value >> 16) & 255;
    }

    public int getRGB() {
        return this.value;
    }

    public int getGreen() {
        return (this.value >> 8) & 255;
    }

    public int getBlue() {
        return this.value & 255;
    }

    public int getAlpha() {
        return (this.value >> 24) & 255;
    }

    public static Color getColor(String str, Color color) {
        Integer integer = Integer.getInteger(str);
        if (integer == null) {
            return color;
        }
        return new Color(integer.intValue());
    }

    public static Color getColor(String str, int i) {
        Integer integer = Integer.getInteger(str);
        if (integer == null) {
            return new Color(i);
        }
        return new Color(integer.intValue());
    }

    public static Color getColor(String str) {
        Integer integer = Integer.getInteger(str);
        if (integer == null) {
            return null;
        }
        return new Color(integer.intValue());
    }

    public static Color decode(String str) throws NumberFormatException {
        return new Color(Integer.decode(str).intValue());
    }

    public static Color getHSBColor(float f, float f2, float f3) {
        return new Color(HSBtoRGB(f, f2, f3));
    }

    public static float[] RGBtoHSB(int i, int i2, int i3, float[] fArr) {
        float f;
        if (fArr == null) {
            fArr = new float[3];
        }
        int max = Math.max(i3, Math.max(i, i2));
        int min = Math.min(i3, Math.min(i, i2));
        float f2 = (float) max;
        float f3 = f2 / 255.0f;
        float f4 = 0.0f;
        if (max == min) {
            f = 0.0f;
        } else {
            float f5 = (float) (max - min);
            f = f5 / f2;
            float f6 = ((float) (max - i)) / f5;
            float f7 = ((float) (max - i2)) / f5;
            float f8 = ((float) (max - i3)) / f5;
            float f9 = (i == max ? f8 - f7 : i2 == max ? (f6 + 2.0f) - f8 : (f7 + 4.0f) - f6) / 6.0f;
            f4 = f9 < 0.0f ? f9 + 1.0f : f9;
        }
        fArr[0] = f4;
        fArr[1] = f;
        fArr[2] = f3;
        return fArr;
    }

    public static int HSBtoRGB(float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        if (f2 == 0.0f) {
            f4 = f3;
            f5 = f4;
        } else {
            float floor = (f - ((float) Math.floor((double) f))) * 6.0f;
            int floor2 = (int) Math.floor((double) floor);
            float f7 = floor - ((float) floor2);
            f5 = (1.0f - f2) * f3;
            float f8 = (1.0f - (f2 * f7)) * f3;
            f4 = f3 * (1.0f - (f2 * (1.0f - f7)));
            if (floor2 == 0) {
                f6 = f5;
                f5 = f4;
            } else if (floor2 == 1) {
                f4 = f5;
                f5 = f3;
                f3 = f8;
            } else if (floor2 == 2) {
                float f9 = f5;
                f5 = f3;
                f3 = f9;
            } else if (floor2 == 3) {
                f4 = f3;
                f3 = f5;
                f5 = f8;
            } else if (floor2 == 4) {
                f6 = f3;
                f3 = f4;
            } else if (floor2 != 5) {
                f4 = 0.0f;
                f3 = 0.0f;
                f5 = 0.0f;
            } else {
                f4 = f8;
            }
            f4 = f6;
        }
        return ((int) ((((double) f4) * 255.0d) + 0.5d)) | (((int) ((((double) f3) * 255.0d) + 0.5d)) << 16) | (((int) ((((double) f5) * 255.0d) + 0.5d)) << 8) | ViewCompat.MEASURED_STATE_MASK;
    }
}
