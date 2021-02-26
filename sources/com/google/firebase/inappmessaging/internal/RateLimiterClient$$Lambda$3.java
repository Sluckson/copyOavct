package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;
import p011io.reactivex.functions.Predicate;

/* compiled from: RateLimiterClient */
final /* synthetic */ class RateLimiterClient$$Lambda$3 implements Predicate {
    private final RateLimiterClient arg$1;
    private final RateLimit arg$2;

    private RateLimiterClient$$Lambda$3(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        this.arg$1 = rateLimiterClient;
        this.arg$2 = rateLimit;
    }

    public static Predicate lambdaFactory$(RateLimiterClient rateLimiterClient, RateLimit rateLimit) {
        return new RateLimiterClient$$Lambda$3(rateLimiterClient, rateLimit);
    }

    public boolean test(Object obj) {
        return RateLimiterClient.lambda$isRateLimited$6(this.arg$1, this.arg$2, (RateLimitProto.Counter) obj);
    }
}