package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure = new Measure();
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public enum MeasureType {
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer2.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.mChildren.get(i);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer2.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer2) {
        int size = constraintWidgetContainer2.mChildren.size();
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.mChildren.get(i);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                boolean z = true;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    z = false;
                }
                if (!z) {
                    measure(measurer, constraintWidget, false);
                    if (constraintWidgetContainer2.mMetrics != null) {
                        constraintWidgetContainer2.mMetrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, String str, int i, int i2) {
        int minWidth = constraintWidgetContainer2.getMinWidth();
        int minHeight = constraintWidgetContainer2.getMinHeight();
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.setWidth(i);
        constraintWidgetContainer2.setHeight(i2);
        constraintWidgetContainer2.setMinWidth(minWidth);
        constraintWidgetContainer2.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        boolean z;
        boolean z2;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z3;
        int i15;
        int i16;
        int i17;
        ConstraintWidgetContainer constraintWidgetContainer3 = constraintWidgetContainer2;
        int i18 = i;
        int i19 = i4;
        int i20 = i6;
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        int size = constraintWidgetContainer3.mChildren.size();
        int width = constraintWidgetContainer2.getWidth();
        int height = constraintWidgetContainer2.getHeight();
        boolean enabled = Optimizer.enabled(i18, 128);
        boolean z4 = enabled || Optimizer.enabled(i18, 64);
        if (z4) {
            int i21 = 0;
            while (true) {
                if (i21 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer3.mChildren.get(i21);
                boolean z5 = (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((!constraintWidget.isInHorizontalChain() || !z5) && ((!constraintWidget.isInVerticalChain() || !z5) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInHorizontalChain() && !constraintWidget.isInVerticalChain())) {
                    i21++;
                }
            }
            z4 = false;
        }
        if (z4 && LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.measures++;
        }
        if (z4 && ((i19 == 1073741824 && i20 == 1073741824) || enabled)) {
            int min = Math.min(constraintWidgetContainer2.getMaxWidth(), i5);
            int min2 = Math.min(constraintWidgetContainer2.getMaxHeight(), i7);
            if (i19 == 1073741824 && constraintWidgetContainer2.getWidth() != min) {
                constraintWidgetContainer3.setWidth(min);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i20 == 1073741824 && constraintWidgetContainer2.getHeight() != min2) {
                constraintWidgetContainer3.setHeight(min2);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i19 == 1073741824 && i20 == 1073741824) {
                z = constraintWidgetContainer3.directMeasure(enabled);
                i10 = 2;
            } else {
                z = constraintWidgetContainer3.directMeasureSetup(enabled);
                if (i19 == 1073741824) {
                    z &= constraintWidgetContainer3.directMeasureWithOrientation(enabled, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i20 == 1073741824) {
                    z &= constraintWidgetContainer3.directMeasureWithOrientation(enabled, 1);
                    i10++;
                }
            }
            if (z) {
                constraintWidgetContainer3.updateFromRuns(i19 == 1073741824, i20 == 1073741824);
            }
        } else {
            z = false;
            i10 = 0;
        }
        if (z && i10 == 2) {
            return 0;
        }
        if (size > 0) {
            measureChildren(constraintWidgetContainer2);
        }
        int optimizationLevel = constraintWidgetContainer2.getOptimizationLevel();
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer3, "First pass", width, height);
        }
        if (size2 > 0) {
            boolean z6 = constraintWidgetContainer2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z7 = constraintWidgetContainer2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(constraintWidgetContainer2.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer2.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i22 = 0;
            boolean z8 = false;
            while (i22 < size2) {
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i22);
                if (!(constraintWidget2 instanceof VirtualLayout)) {
                    i15 = optimizationLevel;
                    i17 = width;
                    i16 = height;
                } else {
                    int width2 = constraintWidget2.getWidth();
                    int height2 = constraintWidget2.getHeight();
                    i15 = optimizationLevel;
                    boolean measure = z8 | measure(measurer, constraintWidget2, true);
                    if (constraintWidgetContainer3.mMetrics != null) {
                        i17 = width;
                        i16 = height;
                        constraintWidgetContainer3.mMetrics.measuredMatchWidgets++;
                    } else {
                        i17 = width;
                        i16 = height;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z6 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        measure = true;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z7 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        measure = true;
                    }
                    z8 = ((VirtualLayout) constraintWidget2).needSolverPass() | measure;
                }
                i22++;
                optimizationLevel = i15;
                width = i17;
                height = i16;
            }
            int i23 = optimizationLevel;
            int i24 = width;
            int i25 = height;
            int i26 = 0;
            int i27 = 2;
            while (i26 < i27) {
                boolean z9 = z8;
                int i28 = 0;
                while (i28 < size2) {
                    ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i28);
                    if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!constraintWidget3.horizontalRun.dimension.resolved || !constraintWidget3.verticalRun.dimension.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        boolean measure2 = z9 | measure(measurer, constraintWidget3, true);
                        if (constraintWidgetContainer3.mMetrics != null) {
                            i14 = i26;
                            i13 = size2;
                            constraintWidgetContainer3.mMetrics.measuredMatchWidgets++;
                        } else {
                            i14 = i26;
                            i13 = size2;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z6 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            z3 = true;
                        } else {
                            z3 = measure2;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z7 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            z3 = true;
                        }
                        z9 = (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) ? z3 : true;
                    } else {
                        i14 = i26;
                        i13 = size2;
                    }
                    i28++;
                    size2 = i13;
                    i26 = i14;
                }
                int i29 = i26;
                int i30 = size2;
                if (z9) {
                    i12 = i24;
                    i11 = i25;
                    solveLinearSystem(constraintWidgetContainer3, "intermediate pass", i12, i11);
                    z8 = false;
                } else {
                    i12 = i24;
                    i11 = i25;
                    z8 = z9;
                }
                i26 = i29 + 1;
                i24 = i12;
                i25 = i11;
                i27 = 2;
                size2 = i30;
            }
            int i31 = i24;
            int i32 = i25;
            if (z8) {
                solveLinearSystem(constraintWidgetContainer3, "2nd pass", i31, i32);
                if (constraintWidgetContainer2.getWidth() < max) {
                    constraintWidgetContainer3.setWidth(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (constraintWidgetContainer2.getHeight() < max2) {
                    constraintWidgetContainer3.setHeight(max2);
                    z2 = true;
                }
                if (z2) {
                    solveLinearSystem(constraintWidgetContainer3, "3rd pass", i31, i32);
                }
            }
            optimizationLevel = i23;
        }
        constraintWidgetContainer3.setOptimizationLevel(optimizationLevel);
        return 0;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z;
        boolean z2 = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.useCurrentDimensions = false;
        return measure2.measuredNeedsSolverPass;
    }
}
