package harmony.java.awt.geom;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.NoSuchElementException;
import org.apache.harmony.awt.internal.nls.Messages;

public class FlatteningPathIterator implements PathIterator {
    private static final int BUFFER_CAPACITY = 16;
    private static final int BUFFER_LIMIT = 16;
    private static final int BUFFER_SIZE = 16;
    double[] buf;
    boolean bufEmpty;
    int bufIndex;
    int bufLimit;
    int bufSize;
    int bufSubdiv;
    int bufType;
    double[] coords;
    double flatness;
    double flatness2;

    /* renamed from: p */
    PathIterator f4939p;

    /* renamed from: px */
    double f4940px;

    /* renamed from: py */
    double f4941py;

    public FlatteningPathIterator(PathIterator pathIterator, double d) {
        this(pathIterator, d, 16);
    }

    public FlatteningPathIterator(PathIterator pathIterator, double d, int i) {
        this.bufEmpty = true;
        this.coords = new double[6];
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException(Messages.getString("awt.206"));
        } else if (i < 0) {
            throw new IllegalArgumentException(Messages.getString("awt.207"));
        } else if (pathIterator != null) {
            this.f4939p = pathIterator;
            this.flatness = d;
            this.flatness2 = d * d;
            this.bufLimit = i;
            this.bufSize = Math.min(this.bufLimit, 16);
            int i2 = this.bufSize;
            this.buf = new double[i2];
            this.bufIndex = i2;
        } else {
            throw new NullPointerException(Messages.getString("awt.208"));
        }
    }

    public double getFlatness() {
        return this.flatness;
    }

    public int getRecursionLimit() {
        return this.bufLimit;
    }

    public int getWindingRule() {
        return this.f4939p.getWindingRule();
    }

    public boolean isDone() {
        return this.bufEmpty && this.f4939p.isDone();
    }

    /* access modifiers changed from: package-private */
    public void evaluate() {
        if (this.bufEmpty) {
            this.bufType = this.f4939p.currentSegment(this.coords);
        }
        int i = this.bufType;
        boolean z = false;
        if (i == 0 || i == 1) {
            double[] dArr = this.coords;
            this.f4940px = dArr[0];
            this.f4941py = dArr[1];
        } else if (i == 2) {
            if (this.bufEmpty) {
                this.bufIndex -= 6;
                double[] dArr2 = this.buf;
                int i2 = this.bufIndex;
                dArr2[i2 + 0] = this.f4940px;
                dArr2[i2 + 1] = this.f4941py;
                System.arraycopy(this.coords, 0, dArr2, i2 + 2, 4);
                this.bufSubdiv = 0;
            }
            while (this.bufSubdiv < this.bufLimit && QuadCurve2D.getFlatnessSq(this.buf, this.bufIndex) >= this.flatness2) {
                int i3 = this.bufIndex;
                if (i3 <= 4) {
                    int i4 = this.bufSize;
                    double[] dArr3 = new double[(i4 + 16)];
                    System.arraycopy(this.buf, i3, dArr3, i3 + 16, i4 - i3);
                    this.buf = dArr3;
                    this.bufSize += 16;
                    this.bufIndex += 16;
                }
                double[] dArr4 = this.buf;
                int i5 = this.bufIndex;
                QuadCurve2D.subdivide(dArr4, i5, dArr4, i5 - 4, dArr4, i5);
                this.bufIndex -= 4;
                this.bufSubdiv++;
            }
            this.bufIndex += 4;
            double[] dArr5 = this.buf;
            int i6 = this.bufIndex;
            this.f4940px = dArr5[i6];
            this.f4941py = dArr5[i6 + 1];
            if (i6 == this.bufSize - 2) {
                z = true;
            }
            this.bufEmpty = z;
            if (this.bufEmpty) {
                this.bufIndex = this.bufSize;
                this.bufType = 1;
            }
        } else if (i == 3) {
            if (this.bufEmpty) {
                this.bufIndex -= 8;
                double[] dArr6 = this.buf;
                int i7 = this.bufIndex;
                dArr6[i7 + 0] = this.f4940px;
                dArr6[i7 + 1] = this.f4941py;
                System.arraycopy(this.coords, 0, dArr6, i7 + 2, 6);
                this.bufSubdiv = 0;
            }
            while (this.bufSubdiv < this.bufLimit && CubicCurve2D.getFlatnessSq(this.buf, this.bufIndex) >= this.flatness2) {
                int i8 = this.bufIndex;
                if (i8 <= 6) {
                    int i9 = this.bufSize;
                    double[] dArr7 = new double[(i9 + 16)];
                    System.arraycopy(this.buf, i8, dArr7, i8 + 16, i9 - i8);
                    this.buf = dArr7;
                    this.bufSize += 16;
                    this.bufIndex += 16;
                }
                double[] dArr8 = this.buf;
                int i10 = this.bufIndex;
                CubicCurve2D.subdivide(dArr8, i10, dArr8, i10 - 6, dArr8, i10);
                this.bufIndex -= 6;
                this.bufSubdiv++;
            }
            this.bufIndex += 6;
            double[] dArr9 = this.buf;
            int i11 = this.bufIndex;
            this.f4940px = dArr9[i11];
            this.f4941py = dArr9[i11 + 1];
            if (i11 == this.bufSize - 2) {
                z = true;
            }
            this.bufEmpty = z;
            if (this.bufEmpty) {
                this.bufIndex = this.bufSize;
                this.bufType = 1;
            }
        }
    }

    public void next() {
        if (this.bufEmpty) {
            this.f4939p.next();
        }
    }

    public int currentSegment(float[] fArr) {
        if (!isDone()) {
            evaluate();
            int i = this.bufType;
            if (i == 4) {
                return i;
            }
            fArr[0] = (float) this.f4940px;
            fArr[1] = (float) this.f4941py;
            if (i != 0) {
                return 1;
            }
            return i;
        }
        throw new NoSuchElementException(Messages.getString("awt.4Bx"));
    }

    public int currentSegment(double[] dArr) {
        if (!isDone()) {
            evaluate();
            int i = this.bufType;
            if (i == 4) {
                return i;
            }
            dArr[0] = this.f4940px;
            dArr[1] = this.f4941py;
            if (i != 0) {
                return 1;
            }
            return i;
        }
        throw new NoSuchElementException(Messages.getString("awt.4B"));
    }
}
