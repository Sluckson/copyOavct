package com.google.inject.internal;

import com.lowagie.text.html.Markup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;

public class StackTraceElements {
    public static Object forMember(Member member) {
        if (member == null) {
            return SourceProvider.UNKNOWN_SOURCE;
        }
        return new StackTraceElement(member.getDeclaringClass().getName(), MoreTypes.memberType(member) == Constructor.class ? "<init>" : member.getName(), (String) null, -1);
    }

    public static Object forType(Class<?> cls) {
        return new StackTraceElement(cls.getName(), Markup.HTML_ATTR_CSS_CLASS, (String) null, -1);
    }
}
