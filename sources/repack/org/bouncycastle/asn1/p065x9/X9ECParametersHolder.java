package repack.org.bouncycastle.asn1.p065x9;

/* renamed from: repack.org.bouncycastle.asn1.x9.X9ECParametersHolder */
public abstract class X9ECParametersHolder {
    private X9ECParameters params;

    /* access modifiers changed from: protected */
    public abstract X9ECParameters createParameters();

    public X9ECParameters getParameters() {
        if (this.params == null) {
            this.params = createParameters();
        }
        return this.params;
    }
}
