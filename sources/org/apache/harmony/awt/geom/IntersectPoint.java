package org.apache.harmony.awt.geom;

public class IntersectPoint {
    private int begIndex1;
    private int begIndex2;
    private int endIndex1;
    private int endIndex2;
    private double param1;
    private double param2;
    private int rule1;
    private int rule2;
    private int ruleIndex1;
    private int ruleIndex2;

    /* renamed from: x */
    private final double f5803x;

    /* renamed from: y */
    private final double f5804y;

    public IntersectPoint(int i, int i2, int i3, int i4, double d, double d2) {
        this.begIndex1 = i;
        this.endIndex1 = i2;
        this.begIndex2 = i3;
        this.endIndex2 = i4;
        this.f5803x = d;
        this.f5804y = d2;
    }

    public IntersectPoint(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, double d, double d2, double d3, double d4) {
        this.begIndex1 = i;
        this.endIndex1 = i2;
        this.rule1 = i3;
        this.ruleIndex1 = i4;
        this.param1 = d3;
        this.begIndex2 = i5;
        this.endIndex2 = i6;
        this.rule2 = i7;
        this.ruleIndex2 = i8;
        this.param2 = d4;
        this.f5803x = d;
        this.f5804y = d2;
    }

    public int getBegIndex(boolean z) {
        return z ? this.begIndex1 : this.begIndex2;
    }

    public int getEndIndex(boolean z) {
        return z ? this.endIndex1 : this.endIndex2;
    }

    public int getRuleIndex(boolean z) {
        return z ? this.ruleIndex1 : this.ruleIndex2;
    }

    public double getParam(boolean z) {
        return z ? this.param1 : this.param2;
    }

    public int getRule(boolean z) {
        return z ? this.rule1 : this.rule2;
    }

    public double getX() {
        return this.f5803x;
    }

    public double getY() {
        return this.f5804y;
    }

    public void setBegIndex1(int i) {
        this.begIndex1 = i;
    }

    public void setEndIndex1(int i) {
        this.endIndex1 = i;
    }

    public void setBegIndex2(int i) {
        this.begIndex2 = i;
    }

    public void setEndIndex2(int i) {
        this.endIndex2 = i;
    }
}
