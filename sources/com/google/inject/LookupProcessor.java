package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.spi.MembersInjectorLookup;
import com.google.inject.spi.ProviderLookup;

class LookupProcessor extends AbstractProcessor {
    LookupProcessor(Errors errors) {
        super(errors);
    }

    public <T> Boolean visit(MembersInjectorLookup<T> membersInjectorLookup) {
        try {
            membersInjectorLookup.initializeDelegate(this.injector.membersInjectorStore.get(membersInjectorLookup.getType(), this.errors));
        } catch (ErrorsException e) {
            this.errors.merge(e.getErrors());
        }
        return true;
    }

    public <T> Boolean visit(ProviderLookup<T> providerLookup) {
        try {
            providerLookup.initializeDelegate(this.injector.getProviderOrThrow(providerLookup.getKey(), this.errors));
        } catch (ErrorsException e) {
            this.errors.merge(e.getErrors());
        }
        return true;
    }
}
