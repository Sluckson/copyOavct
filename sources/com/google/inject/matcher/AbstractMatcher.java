package com.google.inject.matcher;

import java.io.Serializable;

public abstract class AbstractMatcher<T> implements Matcher<T> {
    public Matcher<T> and(Matcher<? super T> matcher) {
        return new AndMatcher(this, matcher);
    }

    /* renamed from: or */
    public Matcher<T> mo36999or(Matcher<? super T> matcher) {
        return new OrMatcher(this, matcher);
    }

    private static class AndMatcher<T> extends AbstractMatcher<T> implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        private final Matcher<? super T> f385a;

        /* renamed from: b */
        private final Matcher<? super T> f386b;

        public AndMatcher(Matcher<? super T> matcher, Matcher<? super T> matcher2) {
            this.f385a = matcher;
            this.f386b = matcher2;
        }

        public boolean matches(T t) {
            return this.f385a.matches(t) && this.f386b.matches(t);
        }

        public boolean equals(Object obj) {
            if (obj instanceof AndMatcher) {
                AndMatcher andMatcher = (AndMatcher) obj;
                return andMatcher.f385a.equals(this.f385a) && andMatcher.f386b.equals(this.f386b);
            }
        }

        public int hashCode() {
            return (this.f385a.hashCode() ^ this.f386b.hashCode()) * 41;
        }

        public String toString() {
            return "and(" + this.f385a + ", " + this.f386b + ")";
        }
    }

    private static class OrMatcher<T> extends AbstractMatcher<T> implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        private final Matcher<? super T> f387a;

        /* renamed from: b */
        private final Matcher<? super T> f388b;

        public OrMatcher(Matcher<? super T> matcher, Matcher<? super T> matcher2) {
            this.f387a = matcher;
            this.f388b = matcher2;
        }

        public boolean matches(T t) {
            return this.f387a.matches(t) || this.f388b.matches(t);
        }

        public boolean equals(Object obj) {
            if (obj instanceof OrMatcher) {
                OrMatcher orMatcher = (OrMatcher) obj;
                return orMatcher.f387a.equals(this.f387a) && orMatcher.f388b.equals(this.f388b);
            }
        }

        public int hashCode() {
            return (this.f387a.hashCode() ^ this.f388b.hashCode()) * 37;
        }

        public String toString() {
            return "or(" + this.f387a + ", " + this.f388b + ")";
        }
    }
}
