package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;

    /* renamed from: mX */
    protected int f35mX;

    /* renamed from: mY */
    protected int f36mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtuaLayout = z;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f35mX = 0;
        this.f36mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f35mX = 0;
        this.f36mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f35mX = 0;
        this.f36mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.f35mX = i;
        this.f36mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f35mX);
        sb.append(", ");
        sb.append(this.f36mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f35mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.f35mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f36mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.f36mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else {
            i = this.mMatchConstraintMinWidth;
            if (i > 0) {
                this.mWidth = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else {
            i = this.mMatchConstraintMinHeight;
            if (i > 0) {
                this.mHeight = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.f35mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.f36mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = 0;
        if (constraintAnchor != null) {
            i = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getVerticalMargin() {
        int i = 0;
        if (this.mLeft != null) {
            i = 0 + this.mTop.mMargin;
        }
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.f35mX = i;
    }

    public void setY(int i) {
        this.f36mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.f35mX = i;
        this.f36mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = C02041.f37x4c44d048[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
        } else if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        }
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mWidth;
        int i3 = this.mMinWidth;
        if (i2 < i3) {
            this.mWidth = i3;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mHeight;
        int i3 = this.mMinHeight;
        if (i2 < i3) {
            this.mHeight = i3;
        }
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f > 0.0f && f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f > 0.0f && f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = 0
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.mDimensionRatio = r9
            r8.mDimensionRatioSide = r1
        L_0x008d:
            return
        L_0x008e:
            r8.mDimensionRatio = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mWidth;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
        this.mHeight = i2;
        int i5 = this.mHeight;
        int i6 = this.mMinHeight;
        if (i5 < i6) {
            this.mHeight = i6;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.f35mX = i;
        this.f36mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED || i7 >= (i5 = this.mWidth)) {
            i5 = i7;
        }
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED || i8 >= (i6 = this.mHeight)) {
            i6 = i8;
        }
        this.mWidth = i5;
        this.mHeight = i6;
        int i9 = this.mHeight;
        int i10 = this.mMinHeight;
        if (i9 < i10) {
            this.mHeight = i10;
        }
        int i11 = this.mWidth;
        int i12 = this.mMinWidth;
        if (i11 < i12) {
            this.mWidth = i12;
        }
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public void setHorizontalDimension(int i, int i2) {
        this.f35mX = i;
        this.mWidth = i2 - i;
        int i3 = this.mWidth;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.f36mY = i;
        this.mHeight = i2 - i;
        int i3 = this.mHeight;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        boolean z;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                } else if (z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                }
            } else if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                    i = 0;
                } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                    if (anchor13 != null) {
                        anchor13.reset();
                    }
                    ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor14.getTarget() != anchor10) {
                        anchor14.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    if (anchor15.isConnected()) {
                        opposite.reset();
                        anchor15.reset();
                    }
                } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor16.getTarget() != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                anchor9.connect(anchor10, i);
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != (constraintAnchor2 = this.mLeft)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (i == 1 && this.mTop.mTarget != null && this.mTop.mTarget.mTarget == (constraintAnchor = this.mTop)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != (constraintAnchor2 = this.mRight)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (i == 1 && this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == (constraintAnchor = this.mBottom)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            if (constraintAnchor != constraintAnchorArr[i2]) {
                int i3 = i2 + 1;
                return constraintAnchorArr[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3];
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x027e, code lost:
        if (r2 == -1) goto L_0x0282;
     */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0503  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r44) {
        /*
            r43 = this;
            r13 = r43
            r9 = r44
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mLeft
            androidx.constraintlayout.solver.SolverVariable r7 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mRight
            androidx.constraintlayout.solver.SolverVariable r6 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mTop
            androidx.constraintlayout.solver.SolverVariable r4 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mBottom
            androidx.constraintlayout.solver.SolverVariable r3 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mBaseline
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            r10 = 1
            if (r0 == 0) goto L_0x002f
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r14 = r0.widgets
            long r14 = r14 + r10
            r0.widgets = r14
        L_0x002f:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            boolean r0 = r0.resolved
            r12 = 0
            if (r0 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x00e1
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r0 == 0) goto L_0x005b
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r14 = r0.graphSolved
            long r14 = r14 + r10
            r0.graphSolved = r14
        L_0x005b:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            int r0 = r0.value
            r9.addEquality(r7, r0)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r9.addEquality(r6, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            int r0 = r0.value
            r9.addEquality(r4, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r9.addEquality(r3, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r9.addEquality(r1, r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x00e0
            if (r0 == 0) goto L_0x0098
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x0098
            r0 = 1
            goto L_0x0099
        L_0x0098:
            r0 = 0
        L_0x0099:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r13.mParent
            if (r1 == 0) goto L_0x00a8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.mListDimensionBehaviors
            r2 = 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x00a8
            r1 = 1
            goto L_0x00a9
        L_0x00a8:
            r1 = 0
        L_0x00a9:
            if (r0 == 0) goto L_0x00c4
            boolean[] r0 = r13.isTerminalWidget
            boolean r0 = r0[r12]
            if (r0 == 0) goto L_0x00c4
            boolean r0 = r43.isInHorizontalChain()
            if (r0 != 0) goto L_0x00c4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r2 = 8
            r9.addGreaterThan(r0, r6, r12, r2)
        L_0x00c4:
            if (r1 == 0) goto L_0x00e0
            boolean[] r0 = r13.isTerminalWidget
            r1 = 1
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x00e0
            boolean r0 = r43.isInVerticalChain()
            if (r0 != 0) goto L_0x00e0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r1 = 8
            r9.addGreaterThan(r0, r3, r12, r1)
        L_0x00e0:
            return
        L_0x00e1:
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r0 == 0) goto L_0x00ec
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r14 = r0.linearSolved
            long r14 = r14 + r10
            r0.linearSolved = r14
        L_0x00ec:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0183
            if (r0 == 0) goto L_0x00fc
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r2) goto L_0x00fc
            r0 = 1
            goto L_0x00fd
        L_0x00fc:
            r0 = 0
        L_0x00fd:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r13.mParent
            if (r2 == 0) goto L_0x010c
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r5 = 1
            r2 = r2[r5]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r5) goto L_0x010c
            r2 = 1
            goto L_0x010d
        L_0x010c:
            r2 = 0
        L_0x010d:
            boolean r5 = r13.isChainHead(r12)
            if (r5 == 0) goto L_0x011d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r5 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r5
            r5.addChain(r13, r12)
            r5 = 1
            r14 = 1
            goto L_0x0122
        L_0x011d:
            boolean r14 = r43.isInHorizontalChain()
            r5 = 1
        L_0x0122:
            boolean r8 = r13.isChainHead(r5)
            if (r8 == 0) goto L_0x0131
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r8
            r8.addChain(r13, r5)
            r5 = 1
            goto L_0x0135
        L_0x0131:
            boolean r5 = r43.isInVerticalChain()
        L_0x0135:
            if (r14 != 0) goto L_0x0157
            if (r0 == 0) goto L_0x0157
            int r8 = r13.mVisibility
            r10 = 8
            if (r8 == r10) goto L_0x0157
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0157
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0157
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mRight
            androidx.constraintlayout.solver.SolverVariable r8 = r9.createObjectVariable(r8)
            r10 = 1
            r9.addGreaterThan(r8, r6, r12, r10)
        L_0x0157:
            if (r5 != 0) goto L_0x017d
            if (r2 == 0) goto L_0x017d
            int r8 = r13.mVisibility
            r10 = 8
            if (r8 == r10) goto L_0x017d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x017d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x017d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mBaseline
            if (r8 != 0) goto L_0x017d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mBottom
            androidx.constraintlayout.solver.SolverVariable r8 = r9.createObjectVariable(r8)
            r10 = 1
            r9.addGreaterThan(r8, r3, r12, r10)
        L_0x017d:
            r15 = r2
            r28 = r5
            r27 = r14
            goto L_0x0189
        L_0x0183:
            r0 = 0
            r15 = 0
            r27 = 0
            r28 = 0
        L_0x0189:
            int r2 = r13.mWidth
            int r5 = r13.mMinWidth
            if (r2 >= r5) goto L_0x0190
            r2 = r5
        L_0x0190:
            int r5 = r13.mHeight
            int r8 = r13.mMinHeight
            if (r5 >= r8) goto L_0x0197
            r5 = r8
        L_0x0197:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r13.mListDimensionBehaviors
            r8 = r8[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 == r10) goto L_0x01a1
            r8 = 1
            goto L_0x01a2
        L_0x01a1:
            r8 = 0
        L_0x01a2:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r13.mListDimensionBehaviors
            r11 = 1
            r10 = r10[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 == r11) goto L_0x01ad
            r10 = 1
            goto L_0x01ae
        L_0x01ad:
            r10 = 0
        L_0x01ae:
            int r11 = r13.mDimensionRatioSide
            r13.mResolvedDimensionRatioSide = r11
            float r11 = r13.mDimensionRatio
            r13.mResolvedDimensionRatio = r11
            int r14 = r13.mMatchConstraintDefaultWidth
            int r12 = r13.mMatchConstraintDefaultHeight
            r19 = 0
            r20 = 4
            r21 = r2
            int r11 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r11 <= 0) goto L_0x0264
            int r11 = r13.mVisibility
            r2 = 8
            if (r11 == r2) goto L_0x0264
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 0
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r22 = r1
            r1 = 3
            if (r2 != r11) goto L_0x01d9
            if (r14 != 0) goto L_0x01d9
            r14 = 3
        L_0x01d9:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 1
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x01e5
            if (r12 != 0) goto L_0x01e5
            r12 = 3
        L_0x01e5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 0
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x01ff
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 1
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x01ff
            if (r14 != r1) goto L_0x01ff
            if (r12 != r1) goto L_0x01ff
            r13.setupDimensionRatio(r0, r15, r8, r10)
            goto L_0x025c
        L_0x01ff:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r8 = 0
            r2 = r2[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r10) goto L_0x022a
            if (r14 != r1) goto L_0x022a
            r13.mResolvedDimensionRatioSide = r8
            float r1 = r13.mResolvedDimensionRatio
            int r2 = r13.mHeight
            float r2 = (float) r2
            float r1 = r1 * r2
            int r2 = (int) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r8 = 1
            r1 = r1[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r10) goto L_0x0227
            r21 = r2
            r31 = r5
            r30 = r12
            r1 = 0
            r29 = 4
            goto L_0x026d
        L_0x0227:
            r21 = r2
            goto L_0x025c
        L_0x022a:
            r8 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r2 = r2[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r10) goto L_0x025c
            if (r12 != r1) goto L_0x025c
            r13.mResolvedDimensionRatioSide = r8
            int r1 = r13.mDimensionRatioSide
            r2 = -1
            if (r1 != r2) goto L_0x0243
            r1 = 1065353216(0x3f800000, float:1.0)
            float r2 = r13.mResolvedDimensionRatio
            float r1 = r1 / r2
            r13.mResolvedDimensionRatio = r1
        L_0x0243:
            float r1 = r13.mResolvedDimensionRatio
            int r2 = r13.mWidth
            float r2 = (float) r2
            float r1 = r1 * r2
            int r5 = (int) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r2 = 0
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r2) goto L_0x025c
            r31 = r5
            r29 = r14
            r1 = 0
            r30 = 4
            goto L_0x026d
        L_0x025c:
            r31 = r5
            r30 = r12
            r29 = r14
            r1 = 1
            goto L_0x026d
        L_0x0264:
            r22 = r1
            r31 = r5
            r30 = r12
            r29 = r14
            r1 = 0
        L_0x026d:
            int[] r2 = r13.mResolvedMatchConstraintDefault
            r5 = 0
            r2[r5] = r29
            r5 = 1
            r2[r5] = r30
            r13.mResolvedHasRatio = r1
            if (r1 == 0) goto L_0x0285
            int r2 = r13.mResolvedDimensionRatioSide
            if (r2 == 0) goto L_0x0281
            r5 = -1
            if (r2 != r5) goto L_0x0286
            goto L_0x0282
        L_0x0281:
            r5 = -1
        L_0x0282:
            r19 = 1
            goto L_0x0288
        L_0x0285:
            r5 = -1
        L_0x0286:
            r19 = 0
        L_0x0288:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r8 = 0
            r2 = r2[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r8) goto L_0x0298
            boolean r2 = r13 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r2 == 0) goto L_0x0298
            r20 = 1
            goto L_0x029a
        L_0x0298:
            r20 = 0
        L_0x029a:
            if (r20 == 0) goto L_0x029e
            r21 = 0
        L_0x029e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r13.mCenter
            boolean r2 = r2.isConnected()
            r14 = 1
            r32 = r2 ^ 1
            boolean[] r2 = r13.mIsInBarrier
            r8 = 0
            boolean r26 = r2[r8]
            boolean r33 = r2[r14]
            int r2 = r13.mHorizontalResolution
            r12 = 2
            r34 = 0
            if (r2 == r12) goto L_0x0389
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x030a
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            boolean r2 = r2.resolved
            if (r2 != 0) goto L_0x02c6
            goto L_0x030a
        L_0x02c6:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            int r2 = r2.value
            r9.addEquality(r7, r2)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r9.addEquality(r6, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r13.mParent
            if (r2 == 0) goto L_0x02f8
            if (r0 == 0) goto L_0x02f8
            boolean[] r2 = r13.isTerminalWidget
            r8 = 0
            boolean r2 = r2[r8]
            if (r2 == 0) goto L_0x02f8
            boolean r2 = r43.isInHorizontalChain()
            if (r2 != 0) goto L_0x02f8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mRight
            androidx.constraintlayout.solver.SolverVariable r2 = r9.createObjectVariable(r2)
            r11 = 8
            r9.addGreaterThan(r2, r6, r8, r11)
        L_0x02f8:
            r36 = r0
            r39 = r1
            r40 = r3
            r41 = r4
            r42 = r6
            r35 = r7
            r37 = r15
            r38 = r22
            goto L_0x039b
        L_0x030a:
            r11 = 8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r13.mParent
            if (r2 == 0) goto L_0x0319
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mRight
            androidx.constraintlayout.solver.SolverVariable r2 = r9.createObjectVariable(r2)
            r17 = r2
            goto L_0x031b
        L_0x0319:
            r17 = r34
        L_0x031b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r13.mParent
            if (r2 == 0) goto L_0x0328
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mLeft
            androidx.constraintlayout.solver.SolverVariable r2 = r9.createObjectVariable(r2)
            r35 = r2
            goto L_0x032a
        L_0x0328:
            r35 = r34
        L_0x032a:
            r2 = 1
            r10 = -1
            boolean[] r5 = r13.isTerminalWidget
            r16 = 0
            boolean r5 = r5[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r13.mListDimensionBehaviors
            r8 = r8[r16]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r13.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mRight
            r18 = 8
            int r12 = r13.f35mX
            r2 = 0
            int r14 = r13.mMinWidth
            r36 = r0
            int[] r0 = r13.mMaxDimension
            r0 = r0[r2]
            r37 = r15
            r15 = r0
            float r0 = r13.mHorizontalBiasPercent
            r16 = r0
            int r0 = r13.mMatchConstraintMinWidth
            r23 = r0
            int r0 = r13.mMatchConstraintMaxWidth
            r24 = r0
            float r0 = r13.mMatchConstraintPercentWidth
            r25 = r0
            r0 = r43
            r39 = r1
            r38 = r22
            r1 = r44
            r40 = r3
            r3 = r36
            r41 = r4
            r4 = r37
            r42 = r6
            r6 = r35
            r35 = r7
            r7 = r17
            r9 = r20
            r13 = r21
            r17 = r19
            r18 = r27
            r19 = r28
            r20 = r26
            r21 = r29
            r22 = r30
            r26 = r32
            r2 = 1
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0399
        L_0x0389:
            r36 = r0
            r39 = r1
            r40 = r3
            r41 = r4
            r42 = r6
            r35 = r7
            r37 = r15
            r38 = r22
        L_0x0399:
            r13 = r43
        L_0x039b:
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x03f4
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x03f4
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            int r0 = r0.value
            r9 = r44
            r7 = r41
            r9.addEquality(r7, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r6 = r40
            r9.addEquality(r6, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r1 = r38
            r9.addEquality(r1, r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x03ee
            if (r28 != 0) goto L_0x03ee
            if (r37 == 0) goto L_0x03ee
            boolean[] r2 = r13.isTerminalWidget
            r4 = 1
            boolean r2 = r2[r4]
            if (r2 == 0) goto L_0x03ea
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r2 = 8
            r3 = 0
            r9.addGreaterThan(r0, r6, r3, r2)
            goto L_0x03f2
        L_0x03ea:
            r2 = 8
            r3 = 0
            goto L_0x03f2
        L_0x03ee:
            r2 = 8
            r3 = 0
            r4 = 1
        L_0x03f2:
            r12 = 0
            goto L_0x0401
        L_0x03f4:
            r9 = r44
            r1 = r38
            r6 = r40
            r7 = r41
            r2 = 8
            r3 = 0
            r4 = 1
            r12 = 1
        L_0x0401:
            int r0 = r13.mVerticalResolution
            r5 = 2
            if (r0 != r5) goto L_0x0407
            r12 = 0
        L_0x0407:
            if (r12 == 0) goto L_0x04c8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r5) goto L_0x0418
            boolean r0 = r13 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0418
            r17 = 1
            goto L_0x041a
        L_0x0418:
            r17 = 0
        L_0x041a:
            if (r17 == 0) goto L_0x041e
            r31 = 0
        L_0x041e:
            if (r39 == 0) goto L_0x042a
            int r0 = r13.mResolvedDimensionRatioSide
            if (r0 == r4) goto L_0x0427
            r5 = -1
            if (r0 != r5) goto L_0x042a
        L_0x0427:
            r18 = 1
            goto L_0x042c
        L_0x042a:
            r18 = 0
        L_0x042c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0437
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            goto L_0x0439
        L_0x0437:
            r0 = r34
        L_0x0439:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r13.mParent
            if (r5 == 0) goto L_0x0445
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTop
            androidx.constraintlayout.solver.SolverVariable r5 = r9.createObjectVariable(r5)
            r34 = r5
        L_0x0445:
            int r5 = r13.mBaselineDistance
            if (r5 > 0) goto L_0x044d
            int r5 = r13.mVisibility
            if (r5 != r2) goto L_0x047b
        L_0x044d:
            int r5 = r43.getBaselineDistance()
            r9.addEquality(r1, r7, r5, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r13.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0474
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r13.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r5 = r9.createObjectVariable(r5)
            r9.addEquality(r1, r5, r3, r2)
            if (r37 == 0) goto L_0x0471
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r13.mBottom
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r1)
            r2 = 5
            r9.addGreaterThan(r0, r1, r3, r2)
        L_0x0471:
            r26 = 0
            goto L_0x047d
        L_0x0474:
            int r5 = r13.mVisibility
            if (r5 != r2) goto L_0x047b
            r9.addEquality(r1, r7, r3, r2)
        L_0x047b:
            r26 = r32
        L_0x047d:
            r2 = 0
            boolean[] r1 = r13.isTerminalWidget
            boolean r5 = r1[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r8 = r1[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r13.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mBottom
            int r12 = r13.f36mY
            int r14 = r13.mMinHeight
            int[] r1 = r13.mMaxDimension
            r15 = r1[r4]
            float r1 = r13.mVerticalBiasPercent
            r16 = r1
            int r1 = r13.mMatchConstraintMinHeight
            r23 = r1
            int r1 = r13.mMatchConstraintMaxHeight
            r24 = r1
            float r1 = r13.mMatchConstraintPercentHeight
            r25 = r1
            r19 = r0
            r0 = r43
            r1 = r44
            r3 = r37
            r4 = r36
            r32 = r6
            r6 = r34
            r34 = r7
            r7 = r19
            r9 = r17
            r13 = r31
            r17 = r18
            r18 = r28
            r19 = r27
            r20 = r33
            r21 = r30
            r22 = r29
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x04cc
        L_0x04c8:
            r32 = r6
            r34 = r7
        L_0x04cc:
            if (r39 == 0) goto L_0x04f9
            r6 = 8
            r7 = r43
            int r0 = r7.mResolvedDimensionRatioSide
            r1 = 1
            if (r0 != r1) goto L_0x04e7
            float r5 = r7.mResolvedDimensionRatio
            r0 = r44
            r1 = r32
            r2 = r34
            r3 = r42
            r4 = r35
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x04fb
        L_0x04e7:
            float r5 = r7.mResolvedDimensionRatio
            r6 = 8
            r0 = r44
            r1 = r42
            r2 = r35
            r3 = r32
            r4 = r34
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x04fb
        L_0x04f9:
            r7 = r43
        L_0x04fb:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0523
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r3 = r44
            r3.addCenterPoint(r7, r0, r1, r2)
        L_0x0523:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide != -1) {
            return;
        }
        if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
            this.mResolvedDimensionRatioSide = 0;
        } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0361, code lost:
        if ((r3 instanceof androidx.constraintlayout.solver.widgets.Barrier) != false) goto L_0x0366;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x034c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0443 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:300:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem r34, boolean r35, boolean r36, boolean r37, boolean r38, androidx.constraintlayout.solver.SolverVariable r39, androidx.constraintlayout.solver.SolverVariable r40, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r41, boolean r42, androidx.constraintlayout.solver.widgets.ConstraintAnchor r43, androidx.constraintlayout.solver.widgets.ConstraintAnchor r44, int r45, int r46, int r47, int r48, float r49, boolean r50, boolean r51, boolean r52, boolean r53, int r54, int r55, int r56, int r57, float r58, boolean r59) {
        /*
            r33 = this;
            r0 = r33
            r10 = r34
            r11 = r39
            r12 = r40
            r13 = r43
            r14 = r44
            r15 = r47
            r1 = r48
            r2 = r55
            r3 = r56
            r4 = r57
            androidx.constraintlayout.solver.SolverVariable r9 = r10.createObjectVariable(r13)
            androidx.constraintlayout.solver.SolverVariable r8 = r10.createObjectVariable(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r43.getTarget()
            androidx.constraintlayout.solver.SolverVariable r7 = r10.createObjectVariable(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r44.getTarget()
            androidx.constraintlayout.solver.SolverVariable r6 = r10.createObjectVariable(r5)
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r5 == 0) goto L_0x0040
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r12 = r5.nonresolvedWidgets
            r16 = 1
            long r12 = r12 + r16
            r5.nonresolvedWidgets = r12
        L_0x0040:
            boolean r12 = r43.isConnected()
            boolean r13 = r44.isConnected()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r0.mCenter
            boolean r16 = r5.isConnected()
            if (r12 == 0) goto L_0x0053
            r18 = 1
            goto L_0x0055
        L_0x0053:
            r18 = 0
        L_0x0055:
            if (r13 == 0) goto L_0x0059
            int r18 = r18 + 1
        L_0x0059:
            if (r16 == 0) goto L_0x005d
            int r18 = r18 + 1
        L_0x005d:
            r19 = r18
            if (r50 == 0) goto L_0x0064
            r20 = 3
            goto L_0x0066
        L_0x0064:
            r20 = r54
        L_0x0066:
            int[] r21 = androidx.constraintlayout.solver.widgets.ConstraintWidget.C02041.f38xdde91696
            int r22 = r41.ordinal()
            r5 = r21[r22]
            r2 = 2
            r14 = 1
            if (r5 == r14) goto L_0x007a
            if (r5 == r2) goto L_0x007a
            r14 = 3
            if (r5 == r14) goto L_0x007a
            r14 = 4
            if (r5 == r14) goto L_0x007f
        L_0x007a:
            r5 = r20
        L_0x007c:
            r20 = 0
            goto L_0x0086
        L_0x007f:
            r5 = r20
            if (r5 != r14) goto L_0x0084
            goto L_0x007c
        L_0x0084:
            r20 = 1
        L_0x0086:
            int r14 = r0.mVisibility
            r2 = 8
            if (r14 != r2) goto L_0x0090
            r14 = 0
            r20 = 0
            goto L_0x0092
        L_0x0090:
            r14 = r46
        L_0x0092:
            if (r59 == 0) goto L_0x00b0
            if (r12 != 0) goto L_0x00a0
            if (r13 != 0) goto L_0x00a0
            if (r16 != 0) goto L_0x00a0
            r2 = r45
            r10.addEquality(r9, r2)
            goto L_0x00b0
        L_0x00a0:
            if (r12 == 0) goto L_0x00b0
            if (r13 != 0) goto L_0x00b0
            int r2 = r43.getMargin()
            r22 = r6
            r6 = 8
            r10.addEquality(r9, r7, r2, r6)
            goto L_0x00b4
        L_0x00b0:
            r22 = r6
            r6 = 8
        L_0x00b4:
            if (r20 != 0) goto L_0x00e3
            if (r42 == 0) goto L_0x00d0
            r2 = 3
            r6 = 0
            r10.addEquality(r8, r9, r6, r2)
            if (r15 <= 0) goto L_0x00c5
            r14 = 8
            r10.addGreaterThan(r8, r9, r15, r14)
            goto L_0x00c7
        L_0x00c5:
            r14 = 8
        L_0x00c7:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r2) goto L_0x00d6
            r10.addLowerThan(r8, r9, r1, r14)
            goto L_0x00d6
        L_0x00d0:
            r1 = 8
            r6 = 0
            r10.addEquality(r8, r9, r14, r1)
        L_0x00d6:
            r15 = r5
            r1 = r7
            r14 = r8
            r18 = r19
            r2 = r22
            r19 = r38
        L_0x00df:
            r22 = r3
            goto L_0x01e3
        L_0x00e3:
            r1 = r19
            r2 = 2
            r6 = 0
            if (r1 == r2) goto L_0x010b
            if (r50 != 0) goto L_0x010b
            r2 = 1
            if (r5 == r2) goto L_0x00f0
            if (r5 != 0) goto L_0x010b
        L_0x00f0:
            int r2 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00fa
            int r2 = java.lang.Math.min(r4, r2)
        L_0x00fa:
            r14 = 8
            r10.addEquality(r8, r9, r2, r14)
            r19 = r38
            r18 = r1
            r15 = r5
            r1 = r7
            r14 = r8
            r2 = r22
            r20 = 0
            goto L_0x00df
        L_0x010b:
            r2 = -2
            if (r3 != r2) goto L_0x010f
            r3 = r14
        L_0x010f:
            if (r4 != r2) goto L_0x0113
            r2 = r14
            goto L_0x0114
        L_0x0113:
            r2 = r4
        L_0x0114:
            if (r14 <= 0) goto L_0x011a
            r4 = 1
            if (r5 == r4) goto L_0x011a
            r14 = 0
        L_0x011a:
            if (r3 <= 0) goto L_0x0125
            r4 = 8
            r10.addGreaterThan(r8, r9, r3, r4)
            int r14 = java.lang.Math.max(r14, r3)
        L_0x0125:
            if (r2 <= 0) goto L_0x013e
            if (r36 == 0) goto L_0x012e
            r4 = 1
            if (r5 != r4) goto L_0x012e
            r4 = 0
            goto L_0x012f
        L_0x012e:
            r4 = 1
        L_0x012f:
            if (r4 == 0) goto L_0x0137
            r4 = 8
            r10.addLowerThan(r8, r9, r2, r4)
            goto L_0x0139
        L_0x0137:
            r4 = 8
        L_0x0139:
            int r14 = java.lang.Math.min(r14, r2)
            goto L_0x0140
        L_0x013e:
            r4 = 8
        L_0x0140:
            r6 = 1
            if (r5 != r6) goto L_0x0166
            if (r36 == 0) goto L_0x0149
            r10.addEquality(r8, r9, r14, r4)
            goto L_0x015a
        L_0x0149:
            if (r51 == 0) goto L_0x0153
            r6 = 5
            r10.addEquality(r8, r9, r14, r6)
            r10.addLowerThan(r8, r9, r14, r4)
            goto L_0x015a
        L_0x0153:
            r6 = 5
            r10.addEquality(r8, r9, r14, r6)
            r10.addLowerThan(r8, r9, r14, r4)
        L_0x015a:
            r19 = r38
            r18 = r1
            r4 = r2
            r15 = r5
            r1 = r7
            r14 = r8
            r2 = r22
            goto L_0x00df
        L_0x0166:
            r14 = 2
            if (r5 != r14) goto L_0x01d2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = r43.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r4 == r6) goto L_0x0193
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = r43.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r4 != r6) goto L_0x017a
            goto L_0x0193
        L_0x017a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.getAnchor(r6)
            androidx.constraintlayout.solver.SolverVariable r4 = r10.createObjectVariable(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.getAnchor(r14)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.createObjectVariable(r6)
            goto L_0x01ab
        L_0x0193:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.getAnchor(r6)
            androidx.constraintlayout.solver.SolverVariable r4 = r10.createObjectVariable(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.getAnchor(r14)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.createObjectVariable(r6)
        L_0x01ab:
            r14 = r4
            androidx.constraintlayout.solver.ArrayRow r4 = r34.createRow()
            r19 = r3
            r3 = r4
            r4 = r8
            r42 = r2
            r15 = r5
            r2 = 0
            r5 = r9
            r2 = r22
            r18 = r1
            r1 = r7
            r7 = r14
            r14 = r8
            r8 = r58
            androidx.constraintlayout.solver.ArrayRow r3 = r3.createRowDimensionRatio(r4, r5, r6, r7, r8)
            r10.addConstraint(r3)
            r4 = r42
            r22 = r19
            r20 = 0
            r19 = r38
            goto L_0x01e3
        L_0x01d2:
            r18 = r1
            r42 = r2
            r19 = r3
            r15 = r5
            r1 = r7
            r14 = r8
            r2 = r22
            r4 = r42
            r22 = r19
            r19 = 1
        L_0x01e3:
            if (r59 == 0) goto L_0x0436
            if (r51 == 0) goto L_0x01f4
            r3 = r40
            r6 = r9
            r2 = r18
            r1 = 0
            r5 = 2
            r12 = 8
            r29 = 1
            goto L_0x0441
        L_0x01f4:
            if (r12 != 0) goto L_0x01fc
            if (r13 != 0) goto L_0x01fc
            if (r16 != 0) goto L_0x01fc
            goto L_0x041a
        L_0x01fc:
            if (r12 == 0) goto L_0x0202
            if (r13 != 0) goto L_0x0202
            goto L_0x041a
        L_0x0202:
            if (r12 != 0) goto L_0x0219
            if (r13 == 0) goto L_0x0219
            int r1 = r44.getMargin()
            int r1 = -r1
            r3 = 8
            r10.addEquality(r14, r2, r1, r3)
            if (r36 == 0) goto L_0x041a
            r3 = 5
            r5 = 0
            r10.addGreaterThan(r9, r11, r5, r3)
            goto L_0x041a
        L_0x0219:
            r3 = 5
            r5 = 0
            if (r12 == 0) goto L_0x041a
            if (r13 == 0) goto L_0x041a
            r12 = r43
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r12.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r6.mOwner
            r8 = r44
            r16 = 4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r8.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r33.getParent()
            r17 = 6
            if (r20 == 0) goto L_0x02ed
            if (r15 != 0) goto L_0x0266
            if (r4 != 0) goto L_0x0243
            if (r22 != 0) goto L_0x0243
            r4 = 0
            r18 = 1
            r24 = 8
            r25 = 8
            goto L_0x024a
        L_0x0243:
            r4 = 1
            r18 = 0
            r24 = 5
            r25 = 5
        L_0x024a:
            boolean r3 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 != 0) goto L_0x025a
            boolean r3 = r7 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 == 0) goto L_0x0253
            goto L_0x025a
        L_0x0253:
            r26 = r24
            r3 = 6
            r5 = 1
            r23 = 0
            goto L_0x0262
        L_0x025a:
            r26 = r24
            r3 = 6
            r5 = 1
            r23 = 0
            r25 = 4
        L_0x0262:
            r24 = r18
            goto L_0x02f8
        L_0x0266:
            r3 = 1
            if (r15 != r3) goto L_0x0276
            r3 = 6
            r4 = 1
            r5 = 1
            r23 = 1
            r24 = 0
            r25 = 4
        L_0x0272:
            r26 = 8
            goto L_0x02f8
        L_0x0276:
            r5 = 3
            if (r15 != r5) goto L_0x02e7
            int r5 = r0.mResolvedDimensionRatioSide
            r3 = -1
            if (r5 != r3) goto L_0x0291
            if (r52 == 0) goto L_0x0286
            if (r36 == 0) goto L_0x0284
            r3 = 5
            goto L_0x0288
        L_0x0284:
            r3 = 4
            goto L_0x0288
        L_0x0286:
            r3 = 8
        L_0x0288:
            r4 = 1
            r5 = 1
            r23 = 1
            r24 = 1
            r25 = 5
            goto L_0x0272
        L_0x0291:
            if (r50 == 0) goto L_0x02b3
            r3 = r55
            r5 = 2
            if (r3 == r5) goto L_0x029e
            r5 = 1
            if (r3 != r5) goto L_0x029c
            goto L_0x029f
        L_0x029c:
            r3 = 0
            goto L_0x02a0
        L_0x029e:
            r5 = 1
        L_0x029f:
            r3 = 1
        L_0x02a0:
            if (r3 != 0) goto L_0x02a6
            r3 = 8
            r4 = 5
            goto L_0x02a8
        L_0x02a6:
            r3 = 5
            r4 = 4
        L_0x02a8:
            r26 = r3
            r25 = r4
            r3 = 6
            r4 = 1
            r23 = 1
            r24 = 1
            goto L_0x02f8
        L_0x02b3:
            r5 = 1
            if (r4 <= 0) goto L_0x02bf
            r3 = 6
            r4 = 1
            r23 = 1
            r24 = 1
            r25 = 5
            goto L_0x02f6
        L_0x02bf:
            if (r4 != 0) goto L_0x02e0
            if (r22 != 0) goto L_0x02e0
            if (r52 != 0) goto L_0x02ce
            r3 = 6
            r4 = 1
            r23 = 1
            r24 = 1
            r25 = 8
            goto L_0x02f6
        L_0x02ce:
            if (r13 == r6) goto L_0x02d4
            if (r7 == r6) goto L_0x02d4
            r3 = 4
            goto L_0x02d5
        L_0x02d4:
            r3 = 5
        L_0x02d5:
            r26 = r3
            r3 = 6
            r4 = 1
            r23 = 1
            r24 = 1
            r25 = 4
            goto L_0x02f8
        L_0x02e0:
            r3 = 6
            r4 = 1
            r23 = 1
            r24 = 1
            goto L_0x02f4
        L_0x02e7:
            r5 = 1
            r3 = 6
            r4 = 0
            r23 = 0
            goto L_0x02f2
        L_0x02ed:
            r5 = 1
            r3 = 6
            r4 = 1
            r23 = 1
        L_0x02f2:
            r24 = 0
        L_0x02f4:
            r25 = 4
        L_0x02f6:
            r26 = 5
        L_0x02f8:
            if (r23 == 0) goto L_0x0303
            if (r1 != r2) goto L_0x0303
            if (r13 == r6) goto L_0x0303
            r23 = 0
            r27 = 0
            goto L_0x0305
        L_0x0303:
            r27 = 1
        L_0x0305:
            if (r4 == 0) goto L_0x033a
            int r4 = r0.mVisibility
            r5 = 8
            if (r4 != r5) goto L_0x0310
            r21 = 4
            goto L_0x0312
        L_0x0310:
            r21 = r3
        L_0x0312:
            int r4 = r43.getMargin()
            int r28 = r44.getMargin()
            r3 = r1
            r1 = r34
            r5 = r2
            r12 = 8
            r2 = r9
            r38 = r3
            r29 = 1
            r35 = r5
            r5 = r49
            r30 = r6
            r6 = r35
            r31 = r7
            r7 = r14
            r8 = r28
            r32 = r9
            r9 = r21
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0348
        L_0x033a:
            r38 = r1
            r35 = r2
            r30 = r6
            r31 = r7
            r32 = r9
            r12 = 8
            r29 = 1
        L_0x0348:
            int r1 = r0.mVisibility
            if (r1 != r12) goto L_0x034d
            return
        L_0x034d:
            if (r23 == 0) goto L_0x0384
            if (r36 == 0) goto L_0x0368
            r2 = r35
            r1 = r38
            if (r1 == r2) goto L_0x036c
            if (r20 != 0) goto L_0x036c
            boolean r3 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 != 0) goto L_0x0364
            r3 = r31
            boolean r4 = r3 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 == 0) goto L_0x036e
            goto L_0x0366
        L_0x0364:
            r3 = r31
        L_0x0366:
            r4 = 6
            goto L_0x0370
        L_0x0368:
            r2 = r35
            r1 = r38
        L_0x036c:
            r3 = r31
        L_0x036e:
            r4 = r26
        L_0x0370:
            int r5 = r43.getMargin()
            r6 = r32
            r10.addGreaterThan(r6, r1, r5, r4)
            int r5 = r44.getMargin()
            int r5 = -r5
            r10.addLowerThan(r14, r2, r5, r4)
            r26 = r4
            goto L_0x038c
        L_0x0384:
            r2 = r35
            r1 = r38
            r3 = r31
            r6 = r32
        L_0x038c:
            if (r36 == 0) goto L_0x039d
            if (r53 == 0) goto L_0x039d
            boolean r4 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 != 0) goto L_0x039d
            boolean r4 = r3 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r4 != 0) goto L_0x039d
            r4 = 6
            r5 = 6
            r27 = 1
            goto L_0x03a1
        L_0x039d:
            r4 = r25
            r5 = r26
        L_0x03a1:
            if (r27 == 0) goto L_0x03f1
            if (r24 == 0) goto L_0x03d1
            if (r52 == 0) goto L_0x03a9
            if (r37 == 0) goto L_0x03d1
        L_0x03a9:
            r7 = r30
            if (r13 == r7) goto L_0x03b2
            if (r3 != r7) goto L_0x03b0
            goto L_0x03b2
        L_0x03b0:
            r17 = r4
        L_0x03b2:
            boolean r8 = r13 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r8 != 0) goto L_0x03ba
            boolean r8 = r3 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r8 == 0) goto L_0x03bc
        L_0x03ba:
            r17 = 5
        L_0x03bc:
            boolean r8 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r8 != 0) goto L_0x03c4
            boolean r8 = r3 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r8 == 0) goto L_0x03c6
        L_0x03c4:
            r17 = 5
        L_0x03c6:
            if (r52 == 0) goto L_0x03ca
            r8 = 5
            goto L_0x03cc
        L_0x03ca:
            r8 = r17
        L_0x03cc:
            int r4 = java.lang.Math.max(r8, r4)
            goto L_0x03d3
        L_0x03d1:
            r7 = r30
        L_0x03d3:
            if (r36 == 0) goto L_0x03e2
            int r4 = java.lang.Math.min(r5, r4)
            if (r50 == 0) goto L_0x03e2
            if (r52 != 0) goto L_0x03e2
            if (r13 == r7) goto L_0x03e1
            if (r3 != r7) goto L_0x03e2
        L_0x03e1:
            r4 = 4
        L_0x03e2:
            int r3 = r43.getMargin()
            r10.addEquality(r6, r1, r3, r4)
            int r3 = r44.getMargin()
            int r3 = -r3
            r10.addEquality(r14, r2, r3, r4)
        L_0x03f1:
            if (r36 == 0) goto L_0x0401
            if (r11 != r1) goto L_0x03fa
            int r5 = r43.getMargin()
            goto L_0x03fb
        L_0x03fa:
            r5 = 0
        L_0x03fb:
            if (r1 == r11) goto L_0x0401
            r1 = 5
            r10.addGreaterThan(r6, r11, r5, r1)
        L_0x0401:
            if (r36 == 0) goto L_0x041a
            if (r20 == 0) goto L_0x041a
            r5 = r15
            if (r47 != 0) goto L_0x041a
            if (r22 != 0) goto L_0x041a
            if (r20 == 0) goto L_0x0414
            r1 = 3
            if (r5 != r1) goto L_0x0414
            r1 = 0
            r10.addGreaterThan(r14, r6, r1, r12)
            goto L_0x041b
        L_0x0414:
            r1 = 0
            r3 = 5
            r10.addGreaterThan(r14, r6, r1, r3)
            goto L_0x041b
        L_0x041a:
            r1 = 0
        L_0x041b:
            if (r36 == 0) goto L_0x0435
            if (r19 == 0) goto L_0x0435
            r3 = r44
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            if (r4 == 0) goto L_0x042c
            int r5 = r44.getMargin()
            r3 = r40
            goto L_0x042f
        L_0x042c:
            r3 = r40
            r5 = 0
        L_0x042f:
            if (r2 == r3) goto L_0x0435
            r1 = 5
            r10.addGreaterThan(r3, r14, r5, r1)
        L_0x0435:
            return
        L_0x0436:
            r3 = r40
            r6 = r9
            r1 = 0
            r5 = 2
            r12 = 8
            r29 = 1
            r2 = r18
        L_0x0441:
            if (r2 >= r5) goto L_0x0483
            if (r36 == 0) goto L_0x0483
            if (r19 == 0) goto L_0x0483
            r10.addGreaterThan(r6, r11, r1, r12)
            if (r35 != 0) goto L_0x0455
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 != 0) goto L_0x0453
            goto L_0x0455
        L_0x0453:
            r5 = 0
            goto L_0x0456
        L_0x0455:
            r5 = 1
        L_0x0456:
            if (r35 != 0) goto L_0x047e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x047e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            float r4 = r2.mDimensionRatio
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x047d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r2.mListDimensionBehaviors
            r4 = r4[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x047d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r29]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r4) goto L_0x047d
            r5 = 1
            goto L_0x047e
        L_0x047d:
            r5 = 0
        L_0x047e:
            if (r5 == 0) goto L_0x0483
            r10.addGreaterThan(r3, r14, r1, r12)
        L_0x0483:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1 */
    static /* synthetic */ class C02041 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour */
        static final /* synthetic */ int[] f38xdde91696 = new int[DimensionBehaviour.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f38xdde91696 = r0
                r0 = 1
                int[] r1 = f38xdde91696     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f38xdde91696     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f38xdde91696     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f38xdde91696     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f37x4c44d048 = r4
                int[] r4 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x0048 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x0052 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x005c }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x0066 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x0071 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x007c }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x0087 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x0093 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f37x4c44d048     // Catch:{ NoSuchFieldError -> 0x009f }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.C02041.<clinit>():void");
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (this.horizontalRun.start.resolved && this.horizontalRun.end.resolved) {
            objectVariableValue = this.horizontalRun.start.value;
            objectVariableValue3 = this.horizontalRun.end.value;
        }
        if (this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
            objectVariableValue2 = this.verticalRun.start.value;
            objectVariableValue4 = this.verticalRun.end.value;
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget2 = null;
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.f35mX = constraintWidget.f35mX;
        this.f36mY = constraintWidget.f36mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mOptimizerMeasurable = constraintWidget.mOptimizerMeasurable;
        this.mGroupsToSolver = constraintWidget.mGroupsToSolver;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.mVerticalNextWidget = constraintWidget2;
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.horizontalRun.isResolved();
        boolean isResolved2 = z2 & this.verticalRun.isResolved();
        int i3 = this.horizontalRun.start.value;
        int i4 = this.verticalRun.start.value;
        int i5 = this.horizontalRun.end.value;
        int i6 = this.verticalRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.f35mX = i3;
        }
        if (isResolved2) {
            this.f36mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED || i8 >= (i2 = this.mWidth)) {
                i2 = i8;
            }
            this.mWidth = i2;
            int i10 = this.mWidth;
            int i11 = this.mMinWidth;
            if (i10 < i11) {
                this.mWidth = i11;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED || i9 >= (i = this.mHeight)) {
                i = i9;
            }
            this.mHeight = i;
            int i12 = this.mHeight;
            int i13 = this.mMinHeight;
            if (i12 < i13) {
                this.mHeight = i13;
            }
        }
    }
}
