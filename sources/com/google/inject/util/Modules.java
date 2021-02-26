package com.google.inject.util;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.PrivateBinder;
import com.google.inject.Scope;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;
import com.google.inject.internal.Sets;
import com.google.inject.spi.DefaultBindingScopingVisitor;
import com.google.inject.spi.DefaultElementVisitor;
import com.google.inject.spi.Element;
import com.google.inject.spi.Elements;
import com.google.inject.spi.PrivateElements;
import com.google.inject.spi.ScopeBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class Modules {
    public static final Module EMPTY_MODULE = new Module() {
        public void configure(Binder binder) {
        }
    };

    public interface OverriddenModuleBuilder {
        Module with(Iterable<? extends Module> iterable);

        Module with(Module... moduleArr);
    }

    private Modules() {
    }

    public static OverriddenModuleBuilder override(Module... moduleArr) {
        return new RealOverriddenModuleBuilder(Arrays.asList(moduleArr));
    }

    public static OverriddenModuleBuilder override(Iterable<? extends Module> iterable) {
        return new RealOverriddenModuleBuilder(iterable);
    }

    public static Module combine(Module... moduleArr) {
        return combine((Iterable<? extends Module>) ImmutableSet.m350of((E[]) moduleArr));
    }

    public static Module combine(Iterable<? extends Module> iterable) {
        final ImmutableSet<E> copyOf = ImmutableSet.copyOf(iterable);
        return new Module() {
            public void configure(Binder binder) {
                Binder skipSources = binder.skipSources(getClass());
                for (Module install : copyOf) {
                    skipSources.install(install);
                }
            }
        };
    }

    private static final class RealOverriddenModuleBuilder implements OverriddenModuleBuilder {
        /* access modifiers changed from: private */
        public final ImmutableSet<Module> baseModules;

        private RealOverriddenModuleBuilder(Iterable<? extends Module> iterable) {
            this.baseModules = ImmutableSet.copyOf(iterable);
        }

        public Module with(Module... moduleArr) {
            return with((Iterable<? extends Module>) Arrays.asList(moduleArr));
        }

        public Module with(final Iterable<? extends Module> iterable) {
            return new AbstractModule() {
                public void configure() {
                    List<Element> elements = Elements.getElements((Iterable<? extends Module>) RealOverriddenModuleBuilder.this.baseModules);
                    List<Element> elements2 = Elements.getElements((Iterable<? extends Module>) iterable);
                    final HashSet newHashSet = Sets.newHashSet();
                    final HashSet newHashSet2 = Sets.newHashSet();
                    new ModuleWriter(binder()) {
                        public <T> Void visit(Binding<T> binding) {
                            newHashSet.add(binding.getKey());
                            return (Void) super.visit(binding);
                        }

                        public Void visit(ScopeBinding scopeBinding) {
                            newHashSet2.add(scopeBinding.getAnnotationType());
                            return (Void) super.visit(scopeBinding);
                        }

                        public Void visit(PrivateElements privateElements) {
                            newHashSet.addAll(privateElements.getExposedKeys());
                            return (Void) super.visit(privateElements);
                        }
                    }.writeAll(elements2);
                    final HashMap newHashMap = Maps.newHashMap();
                    ArrayList newArrayList = Lists.newArrayList();
                    final HashMap hashMap = newHashMap;
                    final ArrayList arrayList = newArrayList;
                    new ModuleWriter(binder()) {
                        public <T> Void visit(Binding<T> binding) {
                            if (newHashSet.remove(binding.getKey())) {
                                return null;
                            }
                            super.visit(binding);
                            Scope access$200 = C25841.this.getScopeInstanceOrNull(binding);
                            if (access$200 == null) {
                                return null;
                            }
                            hashMap.put(access$200, binding.getSource());
                            return null;
                        }

                        public Void visit(PrivateElements privateElements) {
                            PrivateBinder newPrivateBinder = this.binder.withSource(privateElements.getSource()).newPrivateBinder();
                            HashSet newHashSet = Sets.newHashSet();
                            for (Key next : privateElements.getExposedKeys()) {
                                if (newHashSet.remove(next)) {
                                    newHashSet.add(next);
                                } else {
                                    newPrivateBinder.withSource(privateElements.getExposedSource(next)).expose((Key<?>) next);
                                }
                            }
                            for (Element next2 : privateElements.getElements()) {
                                if (!(next2 instanceof Binding) || !newHashSet.contains(((Binding) next2).getKey())) {
                                    next2.applyTo(newPrivateBinder);
                                }
                            }
                            return null;
                        }

                        public Void visit(ScopeBinding scopeBinding) {
                            arrayList.add(scopeBinding);
                            return null;
                        }
                    }.writeAll(elements);
                    new ModuleWriter(binder()) {
                        public Void visit(ScopeBinding scopeBinding) {
                            if (!newHashSet2.remove(scopeBinding.getAnnotationType())) {
                                super.visit(scopeBinding);
                                return null;
                            }
                            Object obj = newHashMap.get(scopeBinding.getScope());
                            if (obj == null) {
                                return null;
                            }
                            C25841.this.binder().withSource(obj).addError("The scope for @%s is bound directly and cannot be overridden.", scopeBinding.getAnnotationType().getSimpleName());
                            return null;
                        }
                    }.writeAll(newArrayList);
                }

                /* access modifiers changed from: private */
                public Scope getScopeInstanceOrNull(Binding<?> binding) {
                    return (Scope) binding.acceptScopingVisitor(new DefaultBindingScopingVisitor<Scope>() {
                        public Scope visitScope(Scope scope) {
                            return scope;
                        }
                    });
                }
            };
        }
    }

    private static class ModuleWriter extends DefaultElementVisitor<Void> {
        protected final Binder binder;

        ModuleWriter(Binder binder2) {
            this.binder = binder2;
        }

        /* access modifiers changed from: protected */
        public Void visitOther(Element element) {
            element.applyTo(this.binder);
            return null;
        }

        /* access modifiers changed from: package-private */
        public void writeAll(Iterable<? extends Element> iterable) {
            for (Element acceptVisitor : iterable) {
                acceptVisitor.acceptVisitor(this);
            }
        }
    }
}
