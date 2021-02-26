package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.Reader;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.p063io.IOContext;

public abstract class ReaderBasedNumericParser extends ReaderBasedParserBase {
    public ReaderBasedNumericParser(IOContext iOContext, int i, Reader reader) {
        super(iOContext, i, reader);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r13v0 ?, r13v2 ?, r13v23 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    protected final org.codehaus.jackson.JsonToken parseNumberText(
/*
Method generation error in method: org.codehaus.jackson.impl.ReaderBasedNumericParser.parseNumberText(int):org.codehaus.jackson.JsonToken, dex: classes4.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r13v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/

    private final JsonToken parseNumberText2(boolean z) throws IOException, JsonParseException {
        int i;
        char c;
        boolean z2;
        boolean z3;
        int i2;
        char c2;
        char nextChar;
        int i3;
        boolean z4 = z;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i4 = 0;
        if (z4) {
            emptyAndGetCurrentSegment[0] = '-';
            i = 1;
        } else {
            i = 0;
        }
        if (this._inputPtr < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            int i5 = this._inputPtr;
            this._inputPtr = i5 + 1;
            c = cArr[i5];
        } else {
            c = getNextChar("No digit following minus sign");
        }
        if (c == '0') {
            c = _verifyNoLeadingZeroes();
        }
        char[] cArr2 = emptyAndGetCurrentSegment;
        int i6 = 0;
        while (true) {
            if (c >= '0' && c <= '9') {
                i6++;
                if (i >= cArr2.length) {
                    cArr2 = this._textBuffer.finishCurrentSegment();
                    i = 0;
                }
                int i7 = i + 1;
                cArr2[i] = c;
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    i = i7;
                    c = 0;
                    z2 = true;
                    break;
                }
                char[] cArr3 = this._inputBuffer;
                int i8 = this._inputPtr;
                this._inputPtr = i8 + 1;
                c = cArr3[i8];
                i = i7;
            } else {
                z2 = false;
            }
        }
        z2 = false;
        if (i6 == 0) {
            reportInvalidNumber("Missing integer part (next char " + _getCharDesc(c) + ")");
        }
        if (c == '.') {
            int i9 = i + 1;
            cArr2[i] = c;
            int i10 = 0;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    z2 = true;
                    break;
                }
                char[] cArr4 = this._inputBuffer;
                int i11 = this._inputPtr;
                this._inputPtr = i11 + 1;
                c = cArr4[i11];
                if (c < '0' || c > '9') {
                    break;
                }
                i10++;
                if (i9 >= cArr2.length) {
                    cArr2 = this._textBuffer.finishCurrentSegment();
                    i9 = 0;
                }
                cArr2[i9] = c;
                i9++;
            }
            if (i10 == 0) {
                reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
            }
            boolean z5 = z2;
            i2 = i10;
            i = i9;
            z3 = z5;
        } else {
            z3 = z2;
            i2 = 0;
        }
        if (c == 'e' || c == 'E') {
            if (i >= cArr2.length) {
                cArr2 = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int i12 = i + 1;
            cArr2[i] = c;
            if (this._inputPtr < this._inputEnd) {
                char[] cArr5 = this._inputBuffer;
                int i13 = this._inputPtr;
                this._inputPtr = i13 + 1;
                c2 = cArr5[i13];
            } else {
                c2 = getNextChar("expected a digit for number exponent");
            }
            if (c2 == '-' || c2 == '+') {
                if (i12 >= cArr2.length) {
                    cArr2 = this._textBuffer.finishCurrentSegment();
                    i12 = 0;
                }
                int i14 = i12 + 1;
                cArr2[i12] = c2;
                if (this._inputPtr < this._inputEnd) {
                    char[] cArr6 = this._inputBuffer;
                    int i15 = this._inputPtr;
                    this._inputPtr = i15 + 1;
                    nextChar = cArr6[i15];
                } else {
                    nextChar = getNextChar("expected a digit for number exponent");
                }
                i12 = i14;
            }
            int i16 = 0;
            while (true) {
                if (c2 <= '9' && c2 >= '0') {
                    i16++;
                    if (i12 >= cArr2.length) {
                        cArr2 = this._textBuffer.finishCurrentSegment();
                        i12 = 0;
                    }
                    i3 = i12 + 1;
                    cArr2[i12] = c2;
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        i4 = i16;
                        z3 = true;
                        break;
                    }
                    char[] cArr7 = this._inputBuffer;
                    int i17 = this._inputPtr;
                    this._inputPtr = i17 + 1;
                    c2 = cArr7[i17];
                    i12 = i3;
                } else {
                    i4 = i16;
                    i3 = i12;
                }
            }
            i4 = i16;
            i3 = i12;
            if (i4 == 0) {
                reportUnexpectedNumberChar(c2, "Exponent indicator not followed by a digit");
            }
            i = i3;
        }
        if (!z3) {
            this._inputPtr--;
        }
        this._textBuffer.setCurrentLength(i);
        return reset(z4, i6, i2, i4);
    }

    private final char _verifyNoLeadingZeroes() throws IOException, JsonParseException {
        char c;
        if ((this._inputPtr >= this._inputEnd && !loadMore()) || (c = this._inputBuffer[this._inputPtr]) < '0' || c > '9') {
            return '0';
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (c == '0') {
            do {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    break;
                }
                c = this._inputBuffer[this._inputPtr];
                if (c < '0' || c > '9') {
                    return '0';
                }
                this._inputPtr++;
            } while (c == '0');
        }
        return c;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ?, r9v1 ?, r9v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    protected org.codehaus.jackson.JsonToken _handleInvalidNumberStart(
/*
Method generation error in method: org.codehaus.jackson.impl.ReaderBasedNumericParser._handleInvalidNumberStart(int, boolean):org.codehaus.jackson.JsonToken, dex: classes4.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/
}
