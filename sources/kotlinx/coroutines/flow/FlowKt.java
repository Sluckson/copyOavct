package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, mo66934k = 4, mo66935mv = {1, 1, 15})
public final class FlowKt {
    @NotNull
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    @FlowPreview
    public static /* synthetic */ void DEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.asFlow(iterable);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterator<? extends T> it) {
        return FlowKt__BuildersKt.asFlow(it);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> asFlow(@NotNull Function0<? extends T> function0) {
        return FlowKt__BuildersKt.asFlow(function0);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> asFlow(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return FlowKt__BuildersKt.asFlow(function1);
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull IntRange intRange) {
        return FlowKt__BuildersKt.asFlow(intRange);
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull LongRange longRange) {
        return FlowKt__BuildersKt.asFlow(longRange);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Sequence<? extends T> sequence) {
        return FlowKt__BuildersKt.asFlow(sequence);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> broadcastChannel) {
        return FlowKt__ChannelsKt.asFlow(broadcastChannel);
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull int[] iArr) {
        return FlowKt__BuildersKt.asFlow(iArr);
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull long[] jArr) {
        return FlowKt__BuildersKt.asFlow(jArr);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull T[] tArr) {
        return FlowKt__BuildersKt.asFlow(tArr);
    }

    @NotNull
    @FlowPreview
    public static final <T> BroadcastChannel<T> broadcastIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        return FlowKt__ChannelsKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> flow, int i) {
        return FlowKt__ContextKt.buffer(flow, i);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> callbackFlow(@NotNull @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.callbackFlow(function2);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    /* renamed from: catch  reason: not valid java name */
    public static final <T> Flow<T> m5872catch(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__ErrorsKt.m5873catch(flow, function3);
    }

    @Nullable
    public static final <T> Object catchImpl(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.catchImpl(flow, flowCollector, continuation);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> channelFlow(@NotNull @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.channelFlow(function2);
    }

    @Nullable
    public static final Object collect(@NotNull Flow<?> flow, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collect(flow, continuation);
    }

    @Nullable
    public static final <T> Object collect(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collect(flow, function2, continuation);
    }

    @Nullable
    private static final Object collect$$forInline(@NotNull Flow flow, @NotNull Function2 function2, @NotNull Continuation continuation) {
        return FlowKt__CollectKt.collect(flow, function2, continuation);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T> Object collectIndexed(@NotNull Flow<? extends T> flow, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collectIndexed(flow, function3, continuation);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    private static final Object collectIndexed$$forInline(@NotNull Flow flow, @NotNull Function3 function3, @NotNull Continuation continuation) {
        return FlowKt__CollectKt.collectIndexed(flow, function3, continuation);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T> Object collectLatest(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.collectLatest(flow, function2, continuation);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.combine(flow, flow2, function3);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull @BuilderInference Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, function4);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, function5);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, flow5, function6);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    public static final <T1, T2, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, function4);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, function5);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, flow5, function6);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull @BuilderInference Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, function4);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull @BuilderInference Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> function5) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, function5);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull @BuilderInference Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> function6) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, function6);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull @BuilderInference Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> function7) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, flow5, function7);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    public static final <T, R> Flow<R> compose(@NotNull Flow<? extends T> flow, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.compose(flow, function1);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> concatMap(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.concatMap(flow, function1);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.concatWith(flow, t);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.concatWith(flow, flow2);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> flow) {
        return FlowKt__ContextKt.conflate(flow);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.consumeAsFlow(receiveChannel);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.count(flow, continuation);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.count(flow, function2, continuation);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, long j) {
        return FlowKt__DelayKt.debounce(flow, j);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayEach(@NotNull Flow<? extends T> flow, long j) {
        return FlowKt__MigrationKt.delayEach(flow, j);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayFlow(@NotNull Flow<? extends T> flow, long j) {
        return FlowKt__MigrationKt.delayFlow(flow, j);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> flow) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super T, Boolean> function2) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow, function2);
    }

    @NotNull
    @FlowPreview
    public static final <T, K> Flow<T> distinctUntilChangedBy(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends K> function1) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(flow, function1);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> drop(@NotNull Flow<? extends T> flow, int i) {
        return FlowKt__LimitKt.drop(flow, i);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> dropWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.dropWhile(flow, function2);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__ChannelsKt.emitAll(flowCollector, receiveChannel, continuation);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.emitAll(flowCollector, flow, continuation);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    private static final Object emitAll$$forInline(@NotNull FlowCollector flowCollector, @NotNull Flow flow, @NotNull Continuation continuation) {
        return FlowKt__CollectKt.emitAll(flowCollector, flow, continuation);
    }

    @NotNull
    public static final <T> Flow<T> emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    @NotNull
    public static final <T> Flow<T> filter(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.filter(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> filterNot(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.filterNot(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> filterNotNull(@NotNull Flow<? extends T> flow) {
        return FlowKt__TransformKt.filterNotNull(flow);
    }

    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.first(flow, continuation);
    }

    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.first(flow, function2, continuation);
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        return FlowKt__DelayKt.fixedPeriodTicker(coroutineScope, j, j2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is named flatMapConcat", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> flatMap(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.flatMap(flow, function2);
    }

    @NotNull
    @FlowPreview
    public static final <T, R> Flow<R> flatMapConcat(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapConcat(flow, function2);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapLatest(flow, function2);
    }

    @NotNull
    @FlowPreview
    public static final <T, R> Flow<R> flatMapMerge(@NotNull Flow<? extends T> flow, int i, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapMerge(flow, i, function2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> flatten(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.flatten(flow);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> flattenConcat(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MergeKt.flattenConcat(flow);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> flow, int i) {
        return FlowKt__MergeKt.flattenMerge(flow, i);
    }

    @NotNull
    public static final <T> Flow<T> flow(@NotNull @BuilderInference Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.flow(function2);
    }

    @NotNull
    @JvmName(name = "flowCombine")
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> flowCombine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.flowCombine(flow, flow2, function3);
    }

    @NotNull
    @JvmName(name = "flowCombineTransform")
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> flowCombineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull @BuilderInference Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.flowCombineTransform(flow, flow2, function4);
    }

    @NotNull
    public static final <T> Flow<T> flowOf(T t) {
        return FlowKt__BuildersKt.flowOf(t);
    }

    @NotNull
    public static final <T> Flow<T> flowOf(@NotNull T... tArr) {
        return FlowKt__BuildersKt.flowOf(tArr);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__ContextKt.flowOn(flow, coroutineContext);
    }

    @FlowPreview
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    public static final <T> Flow<T> flowViaChannel(int i, @NotNull @BuilderInference Function2<? super CoroutineScope, ? super SendChannel<? super T>, Unit> function2) {
        return FlowKt__BuildersKt.flowViaChannel(i, function2);
    }

    @FlowPreview
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    public static final <T, R> Flow<R> flowWith(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, int i, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        return FlowKt__ContextKt.flowWith(flow, coroutineContext, i, function1);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T, R> Object fold(@NotNull Flow<? extends T> flow, R r, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        return FlowKt__ReduceKt.fold(flow, r, function3, continuation);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    private static final Object fold$$forInline(@NotNull Flow flow, Object obj, @NotNull Function3 function3, @NotNull Continuation continuation) {
        return FlowKt__ReduceKt.fold(flow, obj, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    public static final <T> void forEach(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.forEach(flow, function2);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Job launchIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.launchIn(flow, coroutineScope);
    }

    @NotNull
    public static final <T, R> Flow<R> map(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.map(flow, function2);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.mapLatest(flow, function2);
    }

    @NotNull
    public static final <T, R> Flow<R> mapNotNull(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.mapNotNull(flow, function2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> merge(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.merge(flow);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> observeOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.observeOn(flow, coroutineContext);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> onCompletion(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.onCompletion(flow, function3);
    }

    @NotNull
    public static final <T> Flow<T> onEach(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__TransformKt.onEach(flow, function2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> onErrorCollect(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt__ErrorsKt.onErrorCollect(flow, flow2, function1);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResume(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.onErrorResume(flow, flow2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResumeNext(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.onErrorResumeNext(flow, flow2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.onErrorReturn(flow, t);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> flow, T t, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt__MigrationKt.onErrorReturn(flow, t, function1);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> onStart(@NotNull Flow<? extends T> flow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__EmittersKt.onStart(flow, function2);
    }

    @NotNull
    @FlowPreview
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.produceIn(flow, coroutineScope);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> publishOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.publishOn(flow, coroutineContext);
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.reduce(flow, function3, continuation);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> retry(@NotNull Flow<? extends T> flow, long j, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__ErrorsKt.retry(flow, j, function2);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> flow, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return FlowKt__ErrorsKt.retryWhen(flow, function4);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> flow, long j) {
        return FlowKt__DelayKt.sample(flow, j);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> scan(@NotNull Flow<? extends T> flow, R r, @NotNull @BuilderInference Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.scan(flow, r, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> Flow<R> scanFold(@NotNull Flow<? extends T> flow, R r, @NotNull @BuilderInference Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.scanFold(flow, r, function3);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> scanReduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt__TransformKt.scanReduce(flow, function3);
    }

    @Nullable
    public static final <T> Object single(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.single(flow, continuation);
    }

    @Nullable
    public static final <T> Object singleOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.singleOrNull(flow, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    public static final <T> Flow<T> skip(@NotNull Flow<? extends T> flow, int i) {
        return FlowKt__MigrationKt.skip(flow, i);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.startWith(flow, t);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.startWith(flow, flow2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow) {
        FlowKt__MigrationKt.subscribe(flow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.subscribe(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        FlowKt__MigrationKt.subscribe(flow, function2, function22);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use flowOn instead")
    public static final <T> Flow<T> subscribeOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.subscribeOn(flow, coroutineContext);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> Flow<R> switchMap(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.switchMap(flow, function2);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> take(@NotNull Flow<? extends T> flow, int i) {
        return FlowKt__LimitKt.take(flow, i);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.takeWhile(flow, function2);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object toCollection(@NotNull Flow<? extends T> flow, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.toCollection(flow, c, continuation);
    }

    @Nullable
    public static final <T> Object toList(@NotNull Flow<? extends T> flow, @NotNull List<T> list, @NotNull Continuation<? super List<? extends T>> continuation) {
        return FlowKt__CollectionKt.toList(flow, list, continuation);
    }

    @Nullable
    public static final <T> Object toSet(@NotNull Flow<? extends T> flow, @NotNull Set<T> set, @NotNull Continuation<? super Set<? extends T>> continuation) {
        return FlowKt__CollectionKt.toSet(flow, set, continuation);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> transform(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.transform(flow, function3);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.transformLatest(flow, function3);
    }

    @NotNull
    @PublishedApi
    public static final <T, R> Flow<R> unsafeTransform(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.unsafeTransform(flow, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "withContext in flow body is deprecated, use flowOn instead")
    public static final <T, R> void withContext(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        FlowKt__MigrationKt.withContext(flowCollector, coroutineContext, function1);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flow<IndexedValue<T>> withIndex(@NotNull Flow<? extends T> flow) {
        return FlowKt__TransformKt.withIndex(flow);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T1, T2, R> Flow<R> zip(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.zip(flow, flow2, function3);
    }
}
