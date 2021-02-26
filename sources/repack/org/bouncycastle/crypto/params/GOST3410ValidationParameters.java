package repack.org.bouncycastle.crypto.params;

public class GOST3410ValidationParameters {

    /* renamed from: c */
    private int f6200c;

    /* renamed from: cL */
    private long f6201cL;

    /* renamed from: x0 */
    private int f6202x0;
    private long x0L;

    public GOST3410ValidationParameters(int i, int i2) {
        this.f6202x0 = i;
        this.f6200c = i2;
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.x0L = j;
        this.f6201cL = j2;
    }

    public int getC() {
        return this.f6200c;
    }

    public int getX0() {
        return this.f6202x0;
    }

    public long getCL() {
        return this.f6201cL;
    }

    public long getX0L() {
        return this.x0L;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        if (gOST3410ValidationParameters.f6200c == this.f6200c && gOST3410ValidationParameters.f6202x0 == this.f6202x0 && gOST3410ValidationParameters.f6201cL == this.f6201cL && gOST3410ValidationParameters.x0L == this.x0L) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f6202x0 ^ this.f6200c;
        long j = this.x0L;
        long j2 = this.f6201cL;
        return (((i ^ ((int) j)) ^ ((int) (j >> 32))) ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }
}
